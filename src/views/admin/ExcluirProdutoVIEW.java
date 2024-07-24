package views.admin;

import DAO.AdministradorDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ExcluirProdutoVIEW extends JFrame {
    public ExcluirProdutoVIEW() {
        setTitle("Excluir produto");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Estrutura
        JLabel lblTopo = new JLabel("Excluir produto", SwingConstants.CENTER);
        lblTopo.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel lblId = new JLabel("ID produto:");
        JTextField txtId = new JTextField();
        JButton btnExcluir = new JButton("Excluir Produto");
        JButton btnVoltar = new JButton("Voltar");

        // Localização e tamanho dos componentes
        lblTopo.setBounds(90, 10, 200, 25);
        lblId.setBounds(45, 80, 125, 25);
        txtId.setBounds(150, 80, 200, 25);
        btnExcluir.setBounds(90, 130, 200, 25);
        btnVoltar.setBounds(90, 170, 200, 25);

        // Adicionando ao JFrame
        add(lblTopo);
        add(lblId);
        add(txtId);
        add(btnExcluir);
        add(btnVoltar);

        // ActionListener
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    // Verificando se o campo está vazio
                    if (txtId.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                        return;
                    }

                    // Verificando se o campo é int
                    int idCheck;
                    try {
                        idCheck = Integer.parseInt(txtId.getText());
                    } catch (NumberFormatException erro) {
                        JOptionPane.showMessageDialog(null, "Insira o ID corretamente.");
                        txtId.setText("");
                        return;
                    }

                    AdministradorDAO adminDao = new AdministradorDAO();
                    adminDao.excluirProduto(idCheck);

                    // Limpando text field
                    txtId.setText("");

                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "ExcluirProdutoVIEW: " + erro.getMessage());
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
