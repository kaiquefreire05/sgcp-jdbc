package views.cliente;

import DAO.ClienteDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerfilClienteVIEW extends JFrame {
    public PerfilClienteVIEW () {
        setTitle("Visualizar Perfil");
        setSize(400, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Estrutura
        JLabel lblTopo = new JLabel("Informações de Perfil");
        lblTopo.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel lblEntrada = new JLabel("Digite seu email:");
        JTextField txtEmail = new JTextField();
        JButton btnCarregarPerfil = new JButton("Carregar");
        JButton btnVoltar = new JButton("Voltar");

        String[] columns = {"Nome", "Sobrenome", "Email", "Senha"};
        DefaultTableModel modelTabela = new DefaultTableModel(columns, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tblInfo = new JTable(modelTabela);
        JScrollPane scroll = new JScrollPane(tblInfo);

        // Ajustando tamanho das colunas
        TableColumnModel columnModel = tblInfo.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(50);

        // Localização e tamanho dos componentes
        lblTopo.setBounds(110, 0, 200, 25);
        lblEntrada.setBounds(50, 50, 100, 25);
        txtEmail.setBounds(160, 50, 200, 25);
        btnCarregarPerfil.setBounds(140, 90, 100, 25);
        btnVoltar.setBounds(140, 250, 100, 25);
        scroll.setBounds(20, 120, 350, 120);

        // Adicionando na interface
        add(lblTopo);
        add(lblEntrada);
        add(txtEmail);
        add(btnCarregarPerfil);
        add(scroll);
        add(btnVoltar);

        //ActionListener

        btnCarregarPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelTabela.setRowCount(0);  // Excluindo linhas da tabela
                String email = txtEmail.getText();
                ClienteDAO clienteDao = new ClienteDAO();
                if (email.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Preencha os campos.");
                    return;
                }
                Object[] perfil = clienteDao.visualizarPerfil(email);
                if (perfil != null)
                    modelTabela.addRow(perfil);
                else
                    txtEmail.setText("");
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OpcoesClienteVIEW();
                dispose();
            }
        });

        setVisible(true);
    }
}
