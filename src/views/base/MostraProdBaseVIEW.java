package views.base;

import DAO.ClienteDAO;
import entities.ProdutoDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class MostraProdBaseVIEW extends JFrame {

    public MostraProdBaseVIEW() {
        setTitle("Produtos Disponíveis");
        setSize(600, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // Estrutura
        JButton btnMostrar = new JButton("Mostrar Produtos");
        btnMostrar.setBounds(210, 20, 150, 25);
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(210, 320, 150, 25);

        // Tabela para exibir todos os produtos retornados
        String[] columns = {"ID", "Nome", "Descrição", "Preço", "Estoque"};
        // Modelo de tabela
        DefaultTableModel modeloTabela = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // Desabilita a edição de todas as células
            }
        };
        // Criando tabela de produtos e passando modelo
        JTable tabelaProdutos = new JTable(modeloTabela);
        // Inserindo o scroll na tabela
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);
        scrollPane.setBounds(30, 70, 540, 240);  // Mudando tamanho

        // Ajustando a largura das colunas
        TableColumnModel columnModel = tabelaProdutos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);  // ID
        columnModel.getColumn(1).setPreferredWidth(150); // Nome
        columnModel.getColumn(2).setPreferredWidth(250); // Descrição
        columnModel.getColumn(3).setPreferredWidth(50);  // Preço
        columnModel.getColumn(4).setPreferredWidth(50);  // Estoque

        // Mostrando objetos
        add(btnMostrar);
        add(scrollPane);
        add(btnVoltar);

        // Ações dos botões
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                modeloTabela.setRowCount(0);
                ClienteDAO clienteDao = new ClienteDAO();
                ArrayList<ProdutoDTO> produtos = clienteDao.visualizarTodosProdutos();  // Obtendo produtos da tabela
                // Verificação para a lista
                if (produtos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum produto disponível.");
                    return;
                }

                // Percorrendo toda a lista
                for (ProdutoDTO prod : produtos){
                    // Obtendo os dados para serem inseridos
                    Object[] dados = {
                            prod.getIdProduto(),
                            prod.getNomeProduto(),
                            prod.getDescProduto(),
                            prod.getPrecoProduto(),
                            prod.getEstoqueProduto()
                    };
                    modeloTabela.addRow(dados);  // Adicionando na tabela
                }
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        setVisible(true);
    }

    protected abstract void voltar();
}
