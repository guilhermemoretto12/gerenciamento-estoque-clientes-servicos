package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
  private static Connection con;
  
  private Conexao() {
    try {
      String conexao = "org.firebirdsql.jdbc.FBDriver";
      String path = System.getProperty("user.dir").replace("\\", "/");
      String url = "jdbc:firebirdsql://localhost/" + path + "/MUNDIAL.FDB";
      String usuario = "SYSDBA";
      String senha = "masterkey";
      Class.forName(conexao);
      con = DriverManager.getConnection(url, usuario, senha);
      con.setAutoCommit(true);
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "Nfoi possconectar com o banco de dados: " + e);
    } catch (ClassNotFoundException e) {
      JOptionPane.showMessageDialog(null, "Nfoi possencontrar o drive de acesso ao banco de dados: " + e);
    } 
  }
  
  public static Connection getConexao() {
    if (con == null)
      new Conexao(); 
    return con;
  }
  
  public static void main(String[] args) {
    try {
      System.out.println(getConexao());
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
  }
  
  public static int getGenerator(String nomeGenerator) {
    try {
      String sql = "SELECT GEN_ID(" + nomeGenerator + ", 1) FROM RDB$DATABASE";
      PreparedStatement ps = getConexao().prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      if (rs.next())
        return rs.getInt(1); 
      return -1;
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Houve um problema ao tentar obter o generator " + nomeGenerator);
      return -1;
    } 
  }
}
