package DAO;

import database.DB;
import entities.ClienteDTO;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    public boolean autenticarCliente(String email, int senha){
        Connection conn = null;

        try {
            conn = DB.getConnection();

            String query = "SELECT * FROM clientes WHERE email_cliente = ? AND senha_cliente = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setInt(2, senha);

            ResultSet rs = ps.executeQuery();
            return rs.next();  // True or False

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ClienteDAO: " + e.getMessage());
            return false;

        }
    }

    public void cadastrarCliente(@NotNull ClienteDTO cliente) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DB.getConnection();

            // Query de inserção
            String query = "INSERT INTO clientes (nome_cliente, sobrenome_cliente, email_cliente, senha_cliente)"
                    + "VALUES (?, ?, ?, ?)";

            ps = conn.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getSobreNome());
            ps.setString(3, cliente.getEmail());
            ps.setInt(4, cliente.getSenha());

            // Verificando se o cliente foi mesmo inserido
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0)
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Nenhum cliente foi adicionado.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ClienteDAO: " + e.getMessage());

        } finally {
            DB.closeStatement(ps);  // Fechando PreparedStatement
            DB.closeConnection();  // Fechando conexão
        }
    }

}
