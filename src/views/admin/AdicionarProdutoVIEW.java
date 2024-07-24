package views.admin;

import DAO.AdministradorDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarProdutoVIEW extends JFrame {

    public AdicionarProdutoVIEW() {
        setTitle("Adicionar Produto");
        setSize(400, 350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Estrutura do JFrame
        JLabel lblTopo = new JLabel("Cadastro de Produto", SwingConstants.CENTER);
        lblTopo.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel lblNomePro = new JLabel("Nome do Produto:");
        JLabel lblDesc = new JLabel("Descrição Produto:");
        JLabel lblPreco = new JLabel("Preço do Produto:");
        JLabel lblQtdeProd = new JLabel("Quantidade Produto:");
        JTextField txtNomeProd = new JTextField();
        JTextField txtDesc = new JTextField();
        JTextField txtPreco = new JTextField();
        JTextField txtQtde = new JTextField();
        JButton btnCadastrar = new JButton("Cadastrar Produto");
        JButton btnVoltar = new JButton("Voltar");


        // Tamanho e localização do componente
        lblTopo.setBounds(90, 10, 200, 25);
        lblNomePro.setBounds(30, 50, 125, 25);
        lblDesc.setBounds(30, 100, 125, 25);
        lblPreco.setBounds(30, 150, 125, 25);
        lblQtdeProd.setBounds(30, 200, 125, 25);
        txtNomeProd.setBounds(150, 50, 200, 25);
        txtDesc.setBounds(150, 100, 200, 25);
        txtPreco.setBounds(150, 150, 200, 25);
        txtQtde.setBounds(150, 200, 200, 25);
        btnCadastrar.setBounds(90, 240, 200, 25);
        btnVoltar.setBounds(90, 280, 200, 25);

        // Adicionando na JFrame
        add(lblTopo);
        add(lblNomePro);
        add(lblDesc);
        add(lblPreco);
        add(lblQtdeProd);
        add(txtNomeProd);
        add(txtDesc);
        add(txtPreco);
        add(txtQtde);
        add(btnCadastrar);
        add(btnVoltar);

        // Action Listener
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nomeProd = txtNomeProd.getText();
                    String descProd = txtDesc.getText();
                    String precoProd = txtPreco.getText();
                    String estoqueProd = txtQtde.getText();

                    // Verificação de campos vazios
                    if (nomeProd.isEmpty() || descProd.isEmpty() || precoProd.isEmpty() || estoqueProd.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                        return;
                    }

                    // Verificação de preço
                    double precoProdCheck;
                    try {
                        precoProdCheck = Double.parseDouble(precoProd);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Preço deve conter apenas números.");
                        txtPreco.setText("");
                        return;
                    }

                    // Verificação de estoque
                    int estoqueProdutoCheck;
                    try {
                        estoqueProdutoCheck = Integer.parseInt(estoqueProd);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Quantidade de produto deve ser inteiro.");
                        txtQtde.setText("");
                        return;
                    }

                    AdministradorDAO adminDao = new AdministradorDAO();
                    boolean success = adminDao.inserirProduto(nomeProd, descProd, precoProdCheck, estoqueProdutoCheck);
                    if (success){
                        JOptionPane.showMessageDialog(null, "Produto registrado com sucesso.");
                        txtNomeProd.setText("");
                        txtDesc.setText("");
                        txtPreco.setText("");
                        txtQtde.setText("");

                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao registrar produto. Tente novamente.");
                        txtNomeProd.setText("");
                        txtDesc.setText("");
                        txtPreco.setText("");
                        txtQtde.setText("");
                    }

                } catch (Exception erro){
                    JOptionPane.showMessageDialog(null, "AdicionarProdutoVIEW: " + erro.getMessage());
                }
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OpcoesAdminVIEW();
                dispose();
            }
        });

        setVisible(true);
    }

}
