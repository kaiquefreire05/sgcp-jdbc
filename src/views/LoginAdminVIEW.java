package views;

import DAO.AdministradorDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAdminVIEW extends JFrame {

    public LoginAdminVIEW() {
        setTitle("Login Administrador");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        // Estrutura
        JLabel labelTopo = new JLabel("Login de Administrador", SwingConstants.CENTER);
        labelTopo.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel labelUsuario = new JLabel("Usuário:");
        JLabel labelSenha = new JLabel("Senha:");
        JTextField textUsuario = new JTextField();
        JPasswordField textSenha = new JPasswordField();
        JButton buttonLogin = new JButton("Login");

        // Definindo posições e tamanhos dos componentes
        labelTopo.setBounds(100, 0, 180, 25);
        labelUsuario.setBounds(50, 50, 100, 25);
        labelSenha.setBounds(50, 100, 100, 25);
        textUsuario.setBounds(150, 50, 200, 25);
        textSenha.setBounds(150, 100, 200, 25);
        buttonLogin.setBounds(150, 150, 100, 25);

        // Adicionando os componentes ao JFrame
        add(labelTopo);
        add(labelUsuario);
        add(labelSenha);
        add(textUsuario);
        add(textSenha);
        add(buttonLogin);

        // Adicionando ação ao botão de login
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String user = textUsuario.getText();
                    String senha = new String(textSenha.getPassword());

                    // Verificação de campos vazios
                    if (user.isEmpty() || senha.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                        return;
                    }

                    // Fazendo a verificação da senha (aceita somente números)
                    int senhaInt;
                    try {
                        senhaInt = Integer.parseInt(senha);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "A senha deve conter apenas números.");
                        textSenha.setText("");  // Limpando o campo de senha
                        return;
                    }

                    // Tentando autenticar
                    AdministradorDAO adminDao = new AdministradorDAO();
                    boolean autenticado = adminDao.autenticarUsuario(user, senhaInt);
                    if (autenticado) {

                        // Chamo outra tela
                        JOptionPane.showMessageDialog(null, "Acesso permitido");

                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário ou senha inválido.");
                        textUsuario.setText("");
                        textSenha.setText("");
                    }

                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "LoginAdminVIEW: " + erro.getMessage());
                }

            } // Fim código
        });

        setVisible(true);
    }
}
