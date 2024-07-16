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
        JButton btnInicio = new JButton("Início");

        // Localização e tamanho
        txtTopo.setBounds(90, 10, 200, 25);
        btnMostraProd.setBounds(122, 50, 140, 25);
        btnInicio.setBounds(130, 200, 125, 25);

        // Adicionando no JFrame
        add(txtTopo);
        add(btnMostraProd);
        add(btnInicio);

        // Action dos botões
        btnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainVIEW();
                dispose();
            }
        });

        setVisible(true);
    }

}
