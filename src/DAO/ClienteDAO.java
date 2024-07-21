package DAO;

import database.DB;
import entities.ClienteDTO;
import entities.ProdutoDTO;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends BaseDTO{

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

    public Object[] visualizarPerfil(String email) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Object[] perfil = null;
        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("SELECT * FROM clientes WHERE email_cliente = ?");
            st.setString(1, email);
            rs = st.executeQuery();

            if (rs.next()){
                perfil = new Object[4];
                perfil[0] = rs.getString("nome_cliente");
                perfil[1] = rs.getString("sobrenome_cliente");
                perfil[2] = rs.getString("email_cliente");
                perfil[3] = rs.getInt("senha_cliente");
            } else {
                JOptionPane.showMessageDialog(null, "Perfil não encontrado.");
                return null;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ClienteDAO: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return perfil;
    }

    public Object[] carregarPerfilComID(String email) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Object[] cliente = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("SELECT id_cliente, nome_cliente, sobrenome_cliente, email_cliente" +
                    ", senha_cliente FROM clientes WHERE email_cliente = ?");
            st.setString(1, email);
            rs = st.executeQuery();

            if (rs.next()){
                cliente = new Object[5];
                cliente[0] = rs.getInt("id_cliente");
                cliente[1] = rs.getString("nome_cliente");
                cliente[2] = rs.getString("sobrenome_cliente");
                cliente[3] = rs.getString("email_cliente");
                cliente[4] = rs.getInt("senha_cliente");

            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                return null;
            }

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ClienteDAO: " + e.getMessage());
        }
        return cliente;
    }

    public boolean atualizarCliente(int id, ClienteDTO cliente) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DB.getConnection();
            String query = "UPDATE clientes SET nome_cliente = ?, sobrenome_cliente = ?, email_cliente = ?, senha_cliente" +
                    " = ? WHERE id_cliente = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getSobreNome());
            ps.setString(3, cliente.getEmail());
            ps.setInt(4, cliente.getSenha());
            ps.setInt(5, id);

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ClienteDAO: " + e.getMessage());
            return false;

        } finally {
            DB.closeStatement(ps);
            DB.closeConnection();
        }
    }

}
