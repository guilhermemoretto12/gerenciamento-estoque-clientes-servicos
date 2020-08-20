
package dao;

import bd.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pojo.Medico;

public class MedicoDAO {
    
    public void inserir(Medico m) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        
        try {
            //PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INSERIR);
            ps = con.prepareStatement("INSERT INTO MEDICO VALUES (?, ?, ?)");
            ps.setInt(1, m.getIdMedico());
            ps.setString(2, m.getNomeMedico());
            ps.setInt(3, 1);
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Medico cadastrado com sucesso!"); 
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar médico: " + e.getMessage());  
        } finally {
            ps.close();
        }
    }
    
//    public Medico preencher(Medico p) throws Exception {
//        
//        PreparedStatement ps = null;
//        Connection con = Conexao.getConexao();
//        ResultSet rs = null; 
//        
//        try {
//            //PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_PREENCHER);
//            ps = con.prepareStatement("SELECT CODMEDICO, NOMEMEDICO, PRECOCUSTO, PRECOVENDA, QTDESTOQUE FROM MEDICO WHERE CODMEDICO = ?");
//            
//            ps.setString(1, p.getCodMedico());
//            
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                p.setCodMedico(rs.getString("CODMEDICO"));
//                p.setNomeMedico(rs.getString("NOMEMEDICO"));
//                p.setPrecoCusto(rs.getFloat("PRECOCUSTO"));
//                p.setPrecoVenda(rs.getFloat("PRECOVENDA"));
//                p.setQtdEstoque(rs.getInt("QTDESTOQUE"));
//            }
//            rs.close();
//        } catch (Exception e){
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());  
//        } finally {
//            ps.close();
//        }
//        return p;
//    } 
       
//    public List<Medico> consultar(String nome) throws Exception{
//      List<Medico> medicos = new ArrayList<>();
//
//        try {
//            Connection con = Conexao.getConexao();
//            ResultSet rs;
//
//            PreparedStatement ps = con.prepareStatement("SELECT * FROM MEDICO WHERE NOMEMEDICO LIKE ? ORDER BY NOMEMEDICO");
//
//            ps.setString(1, nome + "%");
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                Medico p = new Medico();
//                p.setCodMedico(rs.getString("CODMEDICO"));
//                p.setNomeMedico(rs.getString("NOMEMEDICO"));
//                p.setPrecoCusto(rs.getFloat("PRECOCUSTO"));
//                p.setPrecoVenda(rs.getFloat("PRECOVENDA"));
//                p.setQtdEstoque(rs.getInt("QTDESTOQUE"));
//
//                médicos.add(p);
//            }
//            rs.close();
//            return médicos;
//        } catch (Exception e) {
//            throw e;
//        }
//    }
    
    public void alterar(Medico m) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        
        try {
            //PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INSERIR);
            ps = con.prepareStatement("UPDATE MEDICO SET NOMEMEDICO = ? WHERE IDMEDICO = ?");
            ps.setString(1, m.getNomeMedico());
            ps.setInt(2, m.getIdMedico());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Medico alterado com sucesso!"); 
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar médico: " + e.getMessage());  
        } finally {
            ps.close();
        }
    }
    
    public void excluir(Medico m) throws Exception {
        
        PreparedStatement ps = null;
        Connection con = Conexao.getConexao();
        
        try {
            //PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INSERIR);
            ps = con.prepareStatement("DELETE FROM MEDICO WHERE CODMEDICO = ?");
            
            ps.setInt(1, m.getIdMedico());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Medico excluído com sucesso!"); 
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir médico: " + e.getMessage());  
        } finally {
            ps.close();
        }
    }
    
    public List<Medico> read() {
        PreparedStatement stmt = null;
        Connection con = Conexao.getConexao();
        ResultSet rs = null;

        List<Medico> medicos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM MEDICO WHERE STATUSMEDICO = 1 ORDER BY NOMEMEDICO");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Medico m = new Medico();
                m.setIdMedico(rs.getInt("IDMEDICO"));
                m.setNomeMedico(rs.getString("NOMEMEDICO"));
                
                medicos.add(m);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
        return medicos;
    }
     public Medico getMedicoNo(String nome) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Medico m = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM medico WHERE nomeMedico like ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();

            if (rs.next()) {
                m = new Medico();
                m.setIdMedico(rs.getInt("idmedico"));
                m.setNomeMedico(rs.getString("nomeMedico"));
            }

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);
        
        }
        return m;
    }

}