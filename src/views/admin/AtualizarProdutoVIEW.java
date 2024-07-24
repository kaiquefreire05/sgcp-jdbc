package views.admin;

import DAO.AdministradorDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class AtualizarProdutoVIEW extends JFrame {

    public AtualizarProdutoVIEW () {
        setTitle("Atualizar produto");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Estrutura
        JLabel lblTopo = new JLabel("Atualizar produto", SwingConstants.CENTER);
        lblTopo.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel lblID = new JLabel("ID produto:");
        JLabel lblNome = new JLabel("Nome produto:", SwingConstants.CENTER);
        JLabel lblDesc = new JLabel("Descrição produto:", SwingConstants.CENTER);
        JLabel lblPreco = new JLabel("Preço produto:", SwingConstants.CENTER);
        JLabel lblEstoque = new JLabel("Estoque produto:", SwingConstants.CENTER);
        JTextField txtID = new JTextField();
        JTextField txtNome = new JTextField();
        JTextField txtDesc = new JTextField();
        JTextField txtPreco = new JTextField();
        JTextField txtEstoque = new JTextField();
        JButton btnAtualizar = new JButton("Atualizar Produto");
        JButton btnVoltar = new JButton("Voltar");

        // Localização e tamanho dos componentes
        lblTopo.setBounds(90, 10, 200, 25);
        lblID.setBounds(45, 50, 125, 25);
        lblNome.setBounds(30, 100, 125, 25);
        lblDesc.setBounds(30, 150, 125, 25);
        lblPreco.setBounds(30, 200, 125, 25);
        lblEstoque.setBounds(30, 250, 125, 25);
        txtID.setBounds(150, 50, 200, 25);
        txtNome.setBounds(150, 100, 200, 25);
        txtDesc.setBounds(150, 150, 200, 25);
        txtPreco.setBounds(150, 200, 200, 25);
        txtEstoque.setBounds(150, 250, 200, 25);
        btnAtualizar.setBounds(90, 290, 200, 25);
        btnVoltar.setBounds(90, 330, 200, 25);


        // Adicionando ao JFrame
        add(lblTopo);
        add(lblID);
        add(lblNome);
        add(lblDesc);
        add(lblPreco);
        add(lblEstoque);
        add(txtID);
        add(txtNome);
        add(txtDesc);
        add(txtEstoque);
        add(txtPreco);
        add(btnAtualizar);
        add(btnVoltar);

        // ActionListener
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    // Verificando se os campos estão vazios
                    JTextField[] textFields = {txtID, txtNome, txtDesc, txtPreco, txtEstoque};
                    String[] inputs = new String[textFields.length];
                    for (int i = 0; i < textFields.length; i++) {
                        inputs[i] = textFields[i].getText();
                        if (inputs[i].isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos.");
                            return;
                        }
                    }

                    // Verificação de preço estoque e ID
                    int idCheck;
                    BigDecimal precoProdCheck;
                    int estoqueCheck;

                    try {
                        idCheck = Integer.parseInt(txtID.getText());

                    } catch (NumberFormatException erro) {
                        JOptionPane.showMessageDialog(null, "ID deve ser inteiro.");
                        txtID.setText("");
                        return;
                    }

                    try {
                        precoProdCheck = new BigDecimal(txtPreco.getText());

                    } catch (NumberFormatException erro) {
                        JOptionPane.showMessageDialog(null, "Formato de preço inválido.");
                        txtPreco.setText("");
                        return;
                    }

                    try {
                        estoqueCheck = Integer.parseInt(txtEstoque.getText());

                    } catch (NumberFormatException erro) {
                        JOptionPane.showMessageDialog(null, "Estoque deve ser inteiro.");
                        txtEstoque.setText("");
                        return;
                    }

                    // Atualizando o produto
                    AdministradorDAO adminDao = new AdministradorDAO();
                    adminDao.atualizarProduto(idCheck, inputs[1], inputs[2], precoProdCheck, estoqueCheck);

                    // Limpando todos os campos
                    for (JTextField txtField : textFields) {
                        txtField.setText("");
                    }

                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "AtualizarProdutoVIEW: " + erro.getMessage());
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
