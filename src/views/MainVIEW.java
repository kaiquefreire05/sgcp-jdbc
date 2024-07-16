package views;

import views.admin.LoginAdminVIEW;
import views.cliente.LoginClienteVIEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainVIEW extends JFrame {

    public MainVIEW () {
        setTitle("Sistema de Gerenciamento");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Estrutura
        JLabel lblEscolha = new JLabel("Escolha a sua opção:", SwingConstants.CENTER);
        lblEscolha.setFont(new Font("Arial", Font.BOLD, 16));
        JButton btnCliente = new JButton("Cliente");
        JButton btnAdmin = new JButton("Administrador");

        // Posição e localização
        lblEscolha.setBounds(90, 10, 200, 25);
        btnCliente.setBounds(130, 75, 125, 25);
        btnAdmin.setBounds(130, 125, 125, 25);

        // Adicionando no JFrame
        add(lblEscolha);
        add(btnCliente);
        add(btnAdmin);

        // Redirecionamento de telas
        btnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginClienteVIEW();
                dispose();
            }
        });

        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginAdminVIEW();
                dispose();
            }
        });

        setVisible(true);  // Mostrando View
    }

}
