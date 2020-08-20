
package dao;

import bd.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pojo.Cliente;
import pojo.Servico;

public class ServicoDAO {
    
    public void inserir(Servico s) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        
        try {
            //PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INSERIR);
            ps = con.prepareStatement("INSERT INTO SERVICO VALUES (?, ?, ?, ?, ?, 1, ?)");
            ps.setInt(1, s.getIdServico());
            ps.setString(2, s.getDataServico());
            ps.setString(3, s.getDescricao());
            ps.setInt(4, s.getIdCliente().getIdCliente());
            ps.setInt(5, s.getIdMedico().getIdMedico());
            ps.setInt(6, s.getRefServico());
 
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!"); 
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar serviço: " + e.getMessage());  
        } finally {
            ps.close();
        }
    }
    
    public List<Servico> consultar(Integer codigo) throws Exception{
      List<Servico> servicos = new ArrayList<>();

        try {
            Connection con = Conexao.getConexao();
            ResultSet rs;

            PreparedStatement ps = con.prepareStatement("SELECT SERVICO.refservico, SERVICO.dataservico, SERVICO.descricao, "
                    + "MEDICO.nomemedico FROM SERVICO, MEDICO WHERE SERVICO.idmedico = MEDICO.idmedico "
                    + "AND SERVICO.statusservico = 1 AND SERVICO.idcliente = ? ORDER BY SERVICO.dataservico");

            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                Servico s = new Servico();
                
                s.setRefServico(rs.getInt("REFSERVICO"));
                s.setDataServico(rs.getString("DATASERVICO"));
                s.setDescricao(rs.getString("DESCRICAO"));
                s.setNomeMedico(rs.getString("NOMEMEDICO"));

                servicos.add(s);
            }
            rs.close();
            return servicos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void alterar(Servico s) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        
        try {
            //PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INSERIR);
            ps = con.prepareStatement("UPDATE SERVICO SET DATASERVICO = ?, DESCRICAO = ? WHERE IDSERVICO = ?");
            ps.setString(1, s.getDataServico());
            ps.setString(2, s.getDescricao());
            ps.setInt(3, s.getIdServico());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Serviço alterado com sucesso!"); 
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar serviço: " + e.getMessage());  
        } finally {
            ps.close();
        }
    }
    
    public Servico preencher(Servico s) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        ResultSet rs = null; 
        
        try {
            ps = con.prepareStatement("SELECT SERVICO.idservico, SERVICO.dataservico, SERVICO.descricao, "
                    + "MEDICO.nomemedico, Cliente.nomecliente, SERVICO.idcliente FROM SERVICO, MEDICO, CLIENTE "
                    + "WHERE SERVICO.idmedico = MEDICO.idmedico AND SERVICO.idcliente = CLIENTE.idcliente "
                    + "AND SERVICO.idservico = ?");
            
            ps.setInt(1, s.getIdServico());
            
            rs = ps.executeQuery();
            while (rs.next()) {
                s.setIdServico(rs.getInt("IDSERVICO"));     
                        
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("IDCLIENTE"));
                s.setIdCliente(c);
                
                s.setNomeCliente(rs.getString("NOMECLIENTE"));
                s.setNomeMedico(rs.getString("NOMEMEDICO"));
                s.setDataServico(rs.getString("DATASERVICO"));
                s.setDescricao(rs.getString("DESCRICAO"));   
            }
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());  
        } finally {
            ps.close();
        }
        return s;
    }      
    
    public void excluir(Servico s) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        
        try {
            ps = con.prepareStatement("UPDATE SERVICO SET STATUSSERVICO = 0 WHERE IDSERVICO = ?");
            
            ps.setInt(1, s.getIdServico());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Serviço excluído com sucesso!"); 
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir serviço: " + e.getMessage());  
        } finally {
            ps.close();
        }
    }
}
