
package dao;

import bd.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pojo.Cliente;

public class ClienteDAO {
    public void inserir(Cliente c) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        
        try {
            //PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INSERIR);
            ps = con.prepareStatement("INSERT INTO CLIENTE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, c.getIdCliente());
            ps.setString(2, c.getNomeCliente());
            ps.setString(3, c.getCpf());
            ps.setString(4, c.getDataNascimento());
            ps.setString(5, c.getTelefone1());
            ps.setString(6, c.getTelefone2());
            ps.setString(7, c.getEstado());
            ps.setString(8, c.getCidade());
            ps.setString(9, c.getBairro());
            ps.setString(10, c.getLogradouro());
            ps.setString(11, c.getNumero());
            ps.setString(12, c.getPais1());
            ps.setString(13, c.getPais2());
            ps.setInt(14, 1);       
            ps.setString(15, c.getCep());
            ps.setInt(16, c.getCodCliente());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!"); 
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());  
        } finally {
            ps.close();
        }
    }
       
    public Cliente preencher(Cliente c) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        ResultSet rs = null; 
        
        try {
            ps = con.prepareStatement("SELECT * FROM CLIENTE WHERE CODCLIENTE = ?");
            
            ps.setInt(1, c.getIdCliente());
            
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setNomeCliente(rs.getString("NOMECLIENTE"));
                c.setCpf(rs.getString("CPF"));
                c.setDataNascimento(rs.getString("DATANASCIMENTO"));
                c.setTelefone1(rs.getString("TELEFONE1"));
                c.setTelefone2(rs.getString("TELEFONE2"));
                c.setEstado(rs.getString("ESTADO"));
                c.setCidade(rs.getString("CIDADE"));
                c.setBairro(rs.getString("BAIRRO"));
                c.setLogradouro(rs.getString("LOGRADOURO"));
                c.setNumero(rs.getString("NUMERO"));
                c.setPais1(rs.getString("PAIS1"));
                c.setPais2(rs.getString("PAIS2"));
                c.setCep(rs.getString("CEP"));
                c.setCodCliente(rs.getInt("CODCLIENTE"));
            }
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());  
        } finally {
            ps.close();
        }
        return c;
    }      
    
    public List<Cliente> consultar(String nome) throws Exception{
      List<Cliente> clientes = new ArrayList<>();

        try {
            Connection con = Conexao.getConexao();
            ResultSet rs;

            PreparedStatement ps = con.prepareStatement("SELECT CODCLIENTE, NOMECLIENTE, CPF FROM CLIENTE "
                    + "WHERE STATUSCLIENTE = 1 AND NOMECLIENTE LIKE ? ORDER BY NOMECLIENTE");

            ps.setString(1, nome + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCodCliente(rs.getInt("CODCLIENTE"));
                c.setNomeCliente(rs.getString("NOMECLIENTE"));
                c.setCpf(rs.getString("CPF"));
                
                clientes.add(c);
            }
            rs.close();
            return clientes;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void alterar(Cliente c) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        
        try {
            ps = con.prepareStatement("UPDATE CLIENTE SET NOMECLIENTE = ?, CPF = ?, DATANASCIMENTO = ?, TELEFONE1 = ?, "
                    + "TELEFONE2 = ?, ESTADO = ?, CIDADE = ?, BAIRRO = ?, LOGRADOURO = ?, NUMERO = ?, PAIS1 = ?, PAIS2 = ?, "
                    + "CEP = ? WHERE IDCLIENTE = ?");
            ps.setString(1, c.getNomeCliente());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getDataNascimento());
            ps.setString(4, c.getTelefone1());
            ps.setString(5, c.getTelefone2());
            ps.setString(6, c.getEstado());
            ps.setString(7, c.getCidade());
            ps.setString(8, c.getBairro());
            ps.setString(9, c.getLogradouro());
            ps.setString(10, c.getNumero());
            ps.setString(11, c.getPais1());
            ps.setString(12, c.getPais2());      
            ps.setString(13, c.getCep());
            ps.setInt(14, c.getIdCliente());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!"); 
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar cliente: " + e.getMessage());  
        } finally {
            ps.close();
        }
    }
    
    public void excluir(Cliente p) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        
        try {
            ps = con.prepareStatement("UPDATE CLIENTE SET STATUSCLIENTE = 0 WHERE IDCLIENTE = ?");
            
            ps.setInt(1, p.getIdCliente());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!"); 
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente: " + e.getMessage());  
        } finally {
            ps.close();
        }
    }
    
}
