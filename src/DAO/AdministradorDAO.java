package DAO;

import database.DB;
import entities.ProdutoDTO;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorDAO {

    public boolean autenticarUsuario(String username, int password) {

        Connection conn = null;

        try {

            conn = DB.getConnection();  // Obtendo conexão com o BD

            // Query para verificar se o usuário e a senha existem
            String sql = "SELECT * FROM administradores WHERE usuario = ? AND senha_usuario = ?";

            // Preparar a consulta
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setInt(2, password);

            // Executar a consulta
            ResultSet rs = pst.executeQuery();

            return rs.next(); // True or False

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "AdministradorDAO: " + e.getMessage());
            return false;

        }

    }

    public boolean inserirProduto(String nomeProd, String descProd, double precoProduto, int estoqueProd) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();
            String query = "INSERT INTO produtos (nome_produto, desc_produto, preco_produto, estoque_produto) VALUES " +
                    "(?, ?, ?, ?)";
            st = conn.prepareStatement(query);
            st.setString(1, nomeProd);
            st.setString(2, descProd);
            st.setDouble(3, precoProduto);
            st.setInt(4, estoqueProd);

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0){
                JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso.");
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "Erro na inserção de produto.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AdministradorDTO: " + e.getMessage());

        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

        return false;
    }

    public void atualizarProduto(int id, String nomeProd, String descProd, BigDecimal precoProd, int estoqueProd) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            // Verificando se o produto existe
            conn = DB.getConnection();

            String verifyQuery = "SELECT 1 FROM produtos WHERE id_produto = ?";
            st = conn.prepareStatement(verifyQuery);
            st.setInt(1, id);
            rs = st.executeQuery();

            // Se foi entrado executar o IF
            if (rs.next()){

                String updateQuery = "UPDATE produtos SET nome_produto = ?, desc_produto = ?, preco_produto = ?" +
                    ", estoque_produto = ? WHERE id_produto = ?";
                st = conn.prepareStatement(updateQuery);
                st.setString(1, nomeProd);
                st.setString(2, descProd);
                st.setBigDecimal(3, precoProd);
                st.setInt(4, estoqueProd);
                st.setInt(5, id);

                // Verificando se o pedido foi atualizado
                int linhasAfetadas = st.executeUpdate();
                if (linhasAfetadas > 0)
                    JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso.");
                else
                    JOptionPane.showMessageDialog(null, "Produto não foi alterado.");


            // Senão o produto não existe
            } else
                JOptionPane.showMessageDialog(null, "Produto não foi encontrado.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AdministradorDAO: " + e.getMessage());

        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    public void excluirProduto(int id) {
        String query = "DELETE FROM produtos WHERE id_produto = ?";
        try (Connection conn = DB.getConnection()){

            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);

            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0)
                JOptionPane.showMessageDialog(null, "Produto foi excluído.");
            else
                JOptionPane.showMessageDialog(null, "Produto não foi excluído.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AdministradorDAO: " + e.getMessage());
        }
    }
}