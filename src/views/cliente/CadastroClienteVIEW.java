package views.cliente;

import DAO.ClienteDAO;
import entities.ClienteDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroClienteVIEW extends JFrame {

    public CadastroClienteVIEW() {
        setTitle("Cadastro de Cliente");
        setSize(400, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        // Estrutura
        JLabel lblTopo = new JLabel("Cadastro de Cliente", SwingConstants.CENTER);
        lblTopo.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel lblNome = new JLabel("Nome:");
        JLabel lblSobrenome = new JLabel("Sobrenome:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblSenha = new JLabel("Senha:");
        JTextField txtNome = new JTextField();
        JTextField txtSobrenome = new JTextField();
        JTextField txtEmail = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JButton btnCadastro = new JButton("Cadastro");
        JButton btnVoltar = new JButton("Voltar");

        // Posição e tamanho dos componentes
        lblTopo.setBounds(100, 0, 180, 25);
        lblNome.setBounds(50, 50, 100, 25);
        lblSobrenome.setBounds(50, 100, 100, 25);
        lblEmail.setBounds(50, 150, 100, 25);
        lblSenha.setBounds(50, 200, 100, 25);
        txtNome.setBounds(150, 50, 200, 25);
        txtSobrenome.setBounds(150, 100, 200, 25);
        txtEmail.setBounds(150, 150, 200, 25);
        txtSenha.setBounds(150, 200, 200, 25);
        btnCadastro.setBounds(140, 250, 100, 25);
        btnVoltar.setBounds(140, 300, 100, 25);

        // Adicionando na tela
        add(lblTopo);
        add(lblNome);
        add(lblSobrenome);
        add(lblEmail);
        add(lblSenha);
        add(txtNome);
        add(txtSobrenome);
        add(txtEmail);
        add(txtSenha);
        add(btnCadastro);
        add(btnVoltar);

        // Action botão de cadastro
        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    // Obtendo os campos
                    String nome = txtNome.getText();
                    String sobrenome = txtSobrenome.getText();
                    String email = txtEmail.getText();
                    String senha = new String(txtSenha.getPassword());

                    // Verificação de campos vazios
                    if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                        return;
                    }

                    // Verificação de senha (apenas int)
                    int senhaInt;
                    try {
                        senhaInt = Integer.parseInt(senha);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "A senha deve conter apenas números.");
                        txtSenha.setText("");
                        return;
                    }

                    // Registrando cliente
                    ClienteDAO clienteDao = new ClienteDAO();
                    ClienteDTO cliente = new ClienteDTO(nome, sobrenome, email, senhaInt);
                    clienteDao.cadastrarCliente(cliente);

                    // Limpando campo após o cadastro
                    txtNome.setText("");
                    txtSobrenome.setText("");
                    txtEmail.setText("");
                    txtSenha.setText("");

                    // Voltando para a tela de login
                    new LoginClienteVIEW();
                    dispose();

                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "CadastroClienteVIEW: " + erro.getMessage());
                }

            }
        });

        // Action botão voltar
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginClienteVIEW();
                dispose();
            }
        });

        setVisible(true);  // Mostrando o JFrame
    }

}
