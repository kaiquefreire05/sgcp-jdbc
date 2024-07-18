package views.cliente;

import DAO.ClienteDAO;
import entities.ClienteDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizarPerfilVIEW extends JFrame {
    private JTextField txtEmail;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtSenha;
    private int clienteId;  // Variável para armazenar o ID do cliente

    public AtualizarPerfilVIEW() {
        setTitle("Atualizar Perfil");
        setSize(400, 350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // Estrutura do frame
        JLabel lblTopo = new JLabel("Atualizar Perfil");
        lblTopo.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        JButton btnCarregar = new JButton("Carregar");

        // Localização e tamanho dos componentes
        lblTopo.setBounds(130, 0, 125, 25);
        lblEmail.setBounds(50, 50, 100, 25);
        txtEmail.setBounds(150, 50, 200, 25);
        btnCarregar.setBounds(130, 90, 125, 25);

        // Adicionando no JFrame
        add(lblTopo);
        add(lblEmail);
        add(txtEmail);
        add(btnCarregar);

        // Action Listener para Carregar
        btnCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ClienteDAO clienteDao = new ClienteDAO();
                    String email = txtEmail.getText();
                    // Verificação de campo vazio
                    if (email.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Insira todos os campos.");
                        return;
                    }

                    Object[] campos = clienteDao.carregarPerfilComID(email);
                    if (campos != null){
                        clienteId = (int) campos[0];
                        remove(btnCarregar);
                        criarCampos(campos);
                        adicionarBtnAtualizar();
                    }

                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "Erro ao carregar perfil: " + erro.getMessage());
                }
            }
        });
        setVisible(true);
    }

    private void criarCampos(Object[] campos) {

         // Estrutura e atribuindo valores
        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField((String) campos[1]);
        JLabel lblSobrenome = new JLabel("Sobrenome:");
        txtSobrenome = new JTextField((String) campos[2]);
        JLabel lblSenha = new JLabel("Senha:");
        txtSenha = new JTextField(String.valueOf(campos[4]));

        // Localização e tamanho
        lblNome.setBounds(50, 100, 100, 25);
        txtNome.setBounds(150, 100, 200, 25);
        lblSobrenome.setBounds(50, 150, 100, 25);
        txtSobrenome.setBounds(150, 150, 200, 25);
        lblSenha.setBounds(50, 200, 100, 25);
        txtSenha.setBounds(150, 200, 200, 25);

        // Adicionando no JFrame
        add(lblNome);
        add(txtNome);
        add(lblSobrenome);
        add(txtSobrenome);
        add(lblSenha);
        add(txtSenha);

        // Atualizando JFrame
        revalidate();
        repaint();

    }

    private void adicionarBtnAtualizar() {
        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(130, 250, 125, 25);
        add(btnAtualizar);

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ClienteDAO clienteDao = new ClienteDAO();
                    // Verificacão de senha
                    int senhaInt;
                    try {
                        senhaInt = Integer.parseInt(txtSenha.getText());
                    } catch (NumberFormatException erro) {
                        JOptionPane.showMessageDialog(null, "Senha deve conter apenas números.");
                        return;
                    }
                    // Criando objeto cliente
                    ClienteDTO cliente = new ClienteDTO(
                            txtNome.getText(),
                            txtSobrenome.getText(),
                            txtEmail.getText(),
                            senhaInt
                    );
                    boolean sucess = clienteDao.atualizarCliente(clienteId, cliente);
                    if (sucess) {
                        JOptionPane.showMessageDialog(null, "Perfil atualizado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao atualizar o perfil.");
                    }

                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "AtualizarPerfilVIEW: " + erro.getMessage());
                }
            }
        });
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new AtualizarPerfilVIEW();
    }
}
