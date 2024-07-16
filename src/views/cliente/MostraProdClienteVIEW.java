package views.cliente;

import javax.swing.*;

public class MostraProdClienteVIEW extends JFrame {

    public MostraProdClienteVIEW() {
        setTitle("Produtos disponíveis");
        setSize(400, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // Estrutura
        JButton btnMostrar = new JButton("Mostrar Produtos");

        // Localização e formato
        btnMostrar.setBounds(115, 30, 150, 25);

        // Adicionando ao JFrame
        add(btnMostrar);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MostraProdClienteVIEW();
    }
}
