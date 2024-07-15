package views;

import DAO.AdministradorDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginVIEW extends JFrame {

    public LoginVIEW() {
        setTitle("Login Usuário");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        // Estrutura
        JLabel labelUsuario = new JLabel("Usuário:");  // Label
        JLabel labelSenha = new JLabel("Senha:"); // Label
        JTextField textUsuario = new JTextField();
        JPasswordField textSenha = new JPasswordField();
        JButton buttonLogin = new JButton("Login");  // Botão
        JButton buttonCadastro = new JButton("Cadastro");

        // Definindo posições e tamanhos dos componentes
        labelUsuario.setBounds(50, 50, 100, 25);
        labelSenha.setBounds(50, 100, 100, 25);
        textUsuario.setBounds(150, 50, 200, 25);
        textSenha.setBounds(150, 100, 200, 25);
        buttonLogin.setBounds(150, 150, 100, 25);
        buttonCadastro.setBounds(150, 200, 100, 25);

        // Adicionando os componentes ao JFrame
        add(labelUsuario);
        add(labelSenha);
        add(textUsuario);
        add(textSenha);
        add(buttonLogin);
        add(buttonCadastro);

        // Adicionando ação ao botão de login
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String user = textUsuario.getText();
                    String senha = new String(textSenha.getPassword());

                    // Verificação de campos
                    if (user.isEmpty() || senha.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                        return;
                    }

                    // Instânciando obj
                    AdministradorDAO adminDao = new AdministradorDAO();
                    boolean autenticado = adminDao.autenticarUsuario(user, senha);
                    if (autenticado) {
                        // Chamo outra tela
                        JOptionPane.showMessageDialog(null, "Acesso permitido");
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário ou senha inválido.");
                    }

                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "LoginVIEW: " + erro.getMessage());
                }

            } // Fim código
        });

        setVisible(true);
    }
}
