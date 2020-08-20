
package dao;

import bd.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pojo.Produto;

public class ProdutoDAO {
    
    public void inserir(Produto p) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        
        try {
            //PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INSERIR);
            ps = con.prepareStatement("INSERT INTO PRODUTO VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, p.getIdProduto());
            ps.setString(2, p.getCodProduto());
            ps.setString(3, p.getNomeProduto());
            ps.setDouble(4, p.getPrecoCusto());
            ps.setDouble(5, p.getPrecoVenda());
            ps.setInt(6, p.getQtdEstoque());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!"); 
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());  
        } finally {
            ps.close();
        }
    }
    
    public void entrada(Produto p) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        
        try {
            //PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_ENTRADA);
            ps = con.prepareStatement("UPDATE PRODUTO SET QTDESTOQUE = QTDESTOQUE + ? WHERE CODPRODUTO = ?");
            
            ps.setInt(1, p.getQtdEstoque());
            ps.setString(2, p.getCodProduto());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto adicionado ao estoque!"); 
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao dar entrada no estoque: " + e.getMessage());  
        } finally {
            ps.close();
        }
    }
    
    public Produto preencher(Produto p) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        ResultSet rs = null; 
        
        try {
            ps = con.prepareStatement("SELECT CODPRODUTO, NOMEPRODUTO, PRECOCUSTO, PRECOVENDA, QTDESTOQUE FROM PRODUTO WHERE CODPRODUTO = ?");
            
            ps.setString(1, p.getCodProduto());
            
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setCodProduto(rs.getString("CODPRODUTO"));
                p.setNomeProduto(rs.getString("NOMEPRODUTO"));
                p.setPrecoCusto(rs.getDouble("PRECOCUSTO"));
                p.setPrecoVenda(rs.getDouble("PRECOVENDA"));
                p.setQtdEstoque(rs.getInt("QTDESTOQUE"));
            }
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());  
        } finally {
            ps.close();
        }
        return p;
    }
    
    public void saida(Produto p) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        
        try {
            //PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_SAIDA);
            ps = con.prepareStatement("UPDATE PRODUTO SET QTDESTOQUE = QTDESTOQUE - 1 WHERE CODPRODUTO = ?");
           
            ps.setString(1, p.getCodProduto());
            
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());  
        } finally {
            ps.close();
        }
    }
    
    public List<Produto> consultar(String nome) throws Exception{
      List<Produto> produtos = new ArrayList<>();

        try {
            Connection con = Conexao.getConexao();
            ResultSet rs;

            PreparedStatement ps = con.prepareStatement("SELECT * FROM PRODUTO WHERE NOMEPRODUTO LIKE ? ORDER BY NOMEPRODUTO");

            ps.setString(1, nome + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setCodProduto(rs.getString("CODPRODUTO"));
                p.setNomeProduto(rs.getString("NOMEPRODUTO"));
                p.setPrecoCusto(rs.getDouble("PRECOCUSTO"));
                p.setPrecoVenda(rs.getDouble("PRECOVENDA"));
                p.setQtdEstoque(rs.getInt("QTDESTOQUE"));

                produtos.add(p);
            }
            rs.close();
            return produtos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void alterar(Produto p) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        
        try {
            ps = con.prepareStatement("UPDATE PRODUTO SET NOMEPRODUTO = ?, PRECOCUSTO = ?, PRECOVENDA = ?, QTDESTOQUE = ? WHERE CODPRODUTO = ?");
            ps.setString(1, p.getNomeProduto());
            ps.setDouble(2, p.getPrecoCusto());
            ps.setDouble(3, p.getPrecoVenda());
            ps.setInt(4, p.getQtdEstoque());
            ps.setString(5, p.getCodProduto());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!"); 
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar produto: " + e.getMessage());  
        } finally {
            ps.close();
        }
    }
    
    public void excluir(Produto p) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        
        try {
            //PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INSERIR);
            ps = con.prepareStatement("DELETE FROM PRODUTO WHERE CODPRODUTO = ?");
            
            ps.setString(1, p.getCodProduto());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!"); 
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto: " + e.getMessage());  
        } finally {
            ps.close();
        }
    }
 
}