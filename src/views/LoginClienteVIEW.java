package views;

import DAO.ClienteDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginClienteVIEW extends JFrame {

    public LoginClienteVIEW () {
        setTitle("Login Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        // Estrutura
        JLabel labelTopo = new JLabel("Login de Cliente", SwingConstants.CENTER);
        labelTopo.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel labelEmail = new JLabel("Email:");
        JLabel labelSenha = new JLabel("Senha:");
        JTextField txtEmail = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JButton btnLogin = new JButton("Login");
        JButton btnCadastro = new JButton("Cadastre-se");

        // Definindo posição e tamanho dos componentes
        labelTopo.setBounds(130, 0, 125, 25);
        labelEmail.setBounds(50, 50, 100, 25);
        labelSenha.setBounds(50, 100, 100, 25);
        txtEmail.setBounds(100, 50, 200, 25);
        txtSenha.setBounds(100, 100, 200, 25);
        btnLogin.setBounds(130, 150, 125, 25);
        btnCadastro.setBounds(130, 200, 125, 25);

        // Adicionando no JFrame
        add(labelTopo);
        add(labelEmail);
        add(txtEmail);
        add(labelSenha);
        add(txtSenha);
        add(btnLogin);
        add(btnCadastro);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String email = txtEmail.getText();
                    String senha = new String(txtSenha.getPassword());

                    // Verificação de campos vazios
                    if (email.isEmpty() || senha.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                        return;
                    }

                    // Verificação da senha (aceita somente int)
                    int senhaInt;
                    try {
                        senhaInt = Integer.parseInt(senha);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "A senha deve conter apenas números.");
                        txtSenha.setText(""); // Limpando o campo de senha
                        return;
                    }

                    // Tentando autenticar cliente
                    ClienteDAO clienteDao = new ClienteDAO();
                    boolean autenticado = clienteDao.autenticarCliente(email, senhaInt);
                    if (autenticado) {
                        // Chamo outra tela
                        JOptionPane.showMessageDialog(null, "Acesso permitido.");

                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.");
                        txtEmail.setText("");
                        txtSenha.setText("");

                    }

                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "LoginClienteVIEW: "
                            + erro.getMessage());
                }
            } // Fim código
        });

        setVisible(true);  // Mostrando a tela

    }

}
