package views.admin;

import views.MainVIEW;
import views.cliente.OpcoesClienteVIEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpcoesAdminVIEW extends JFrame {
    public OpcoesAdminVIEW () {
        setTitle("Opções de Administrador");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        // Estrutura da JFrame
        JLabel lblTopo = new JLabel("Opções de Administrador", SwingConstants.CENTER);
        lblTopo.setFont(new Font("Arial", Font.BOLD, 16));
        JButton btnAdicionarProduto = new JButton("Adicionar Produto");

        JButton btnInicio = new JButton("Voltar");

        // Localização e tamanho dos componentes
        lblTopo.setBounds(90, 10, 200, 25);
        btnAdicionarProduto.setBounds(122, 50, 140, 25);
        btnInicio.setBounds(122, 200, 140, 25);

        // Adicionando ao JFrame
        add(lblTopo);
        add(btnAdicionarProduto);
        add(btnInicio);

        // Action Listener
        btnAdicionarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdicionarProdutoVIEW();
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


        setVisible(true);
    }

    public static void main(String[] args) {
        new OpcoesAdminVIEW();
    }

}
