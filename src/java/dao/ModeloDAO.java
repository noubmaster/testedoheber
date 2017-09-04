package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Marca;
import modelo.Modelo;
import util.Conexao;

public class ModeloDAO {

    public static void inserir(Modelo modelo) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql
                = "insert into modelo (descricao, categoria, combustivel, transmissao, motor, tracao,idMarca) values (?,?,?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, modelo.getDescricao());
        stmt.setString(2, modelo.getCategoria());
        stmt.setString(3, modelo.getCombustivel());
        stmt.setString(4, modelo.getTransmissao());
        stmt.setString(5, modelo.getMotor());
        stmt.setString(6, modelo.getTracao());
        stmt.setInt(7, modelo.getMarca().getIdMarca());
        
        stmt.execute();
        stmt.close();
        con.close();
    }

    public static void alterar(Modelo modelo) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql
                = "update modelo set descricao=?, categoria=?, combustivel=?, transmissao=?, motor=?, tracao=?,idMarca=? where idModelo = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, modelo.getDescricao());
        stmt.setString(2, modelo.getCategoria());
        stmt.setString(3, modelo.getCombustivel());
        stmt.setString(4, modelo.getTransmissao());
        stmt.setString(5, modelo.getMotor());
        stmt.setString(6, modelo.getTracao());
        stmt.setInt(7, modelo.getMarca().getIdMarca());
        stmt.setInt(8, modelo.getIdModelo());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public static void excluir(Modelo modelo) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql
                = "DELETE FROM modelo WHERE  idModelo = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, modelo.getIdModelo());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public static List<Modelo> getLista() throws SQLException {
        List<Modelo> lista = new ArrayList<Modelo>();
        Connection con = Conexao.getConnection();
        String sql = "SELECT * FROM modelo mo ,marca ma where mo.idMarca = ma.idMarca";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            
            Marca marca = new Marca();
            marca.setIdMarca(rs.getInt("idMarca"));
            marca.setNome(rs.getString("nome"));
            marca.setPaisOrigem(rs.getString("paisOrigem"));

            Modelo modelo = new Modelo();
            modelo.setIdModelo(rs.getInt("idModelo"));
            modelo.setDescricao(rs.getString("descricao"));
            modelo.setCategoria(rs.getString("categoria"));
            modelo.setCombustivel(rs.getString("combustivel"));
            modelo.setTransmissao(rs.getString("transmissao"));
            modelo.setMotor(rs.getString("motor"));
            modelo.setTracao(rs.getString("tracao"));
            
            modelo.setMarca(marca);
            lista.add(modelo);
        }
        stmt.close();
        rs.close();
        con.close();

        return lista;
    }

}
