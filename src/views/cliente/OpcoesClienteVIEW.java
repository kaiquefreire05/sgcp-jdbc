package views.cliente;

import views.MainVIEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpcoesClienteVIEW extends JFrame {
    public OpcoesClienteVIEW (){
        setTitle("Opções de Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        // Estrutura
        JLabel txtTopo = new JLabel("Selecione sua opção", SwingConstants.CENTER);
        txtTopo.setFont(new Font("Arial", Font.BOLD, 16));
        JButton btnMostraProd = new JButton("Mostrar produtos");
        JButton btnPerfil = new JButton("Visualizar perfil");
        JButton btnInicio = new JButton("Início");
        JButton btnAtualizarPerfil = new JButton("Atualizar perfil");

        // Localização e tamanho
        txtTopo.setBounds(90, 10, 200, 25);
        btnMostraProd.setBounds(122, 50, 140, 25);
        btnPerfil.setBounds(122, 90, 140, 25);
        btnAtualizarPerfil.setBounds(122, 130, 140, 25);
        btnInicio.setBounds(122, 200, 140, 25);

        // Adicionando no JFrame
        add(txtTopo);
        add(btnMostraProd);
        add(btnInicio);
        add(btnPerfil);
        add(btnAtualizarPerfil);

        // ActionListener

        btnMostraProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MostraProdClienteVIEW();
                dispose();
            }
        });

        btnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainVIEW();
                dispose();
            }
        });

        btnPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PerfilClienteVIEW();
                dispose();
            }
        });

        btnAtualizarPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AtualizarPerfilVIEW();
                dispose();
            }
        });

        setVisible(true);
    }
}
