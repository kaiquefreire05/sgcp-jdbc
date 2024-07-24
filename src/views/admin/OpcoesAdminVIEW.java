package views.admin;

import views.MainVIEW;

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
        JButton btnMostrarProds = new JButton("Mostrar produtos");
        JButton btnAtualizaProd = new JButton("Atualizar produto");
        JButton btnExcluiProd = new JButton("Excluir produto");

        JButton btnInicio = new JButton("Voltar");

        // Localização e tamanho dos componentes
        lblTopo.setBounds(90, 10, 200, 25);
        btnAdicionarProduto.setBounds(122, 50, 140, 25);
        btnMostrarProds.setBounds(122, 90, 140, 25);
        btnAtualizaProd.setBounds(122, 130, 140, 25);
        btnExcluiProd.setBounds(122, 170, 140, 25);

        btnInicio.setBounds(122, 200, 140, 25);

        // Adicionando ao JFrame
        add(lblTopo);
        add(btnAdicionarProduto);
        add(btnMostrarProds);
        add(btnAtualizaProd);
        add(btnExcluiProd);

        add(btnInicio);

        // Action Listener
        btnAdicionarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdicionarProdutoVIEW();
                dispose();
            }
        });

        btnMostrarProds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MostraProdAdminVIEW();
                dispose();
            }
        });

        btnAtualizaProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AtualizarProdutoVIEW();
                dispose();
            }
        });

        btnExcluiProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExcluirProdutoVIEW();
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
}
