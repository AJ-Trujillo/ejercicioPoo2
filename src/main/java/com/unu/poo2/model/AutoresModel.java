package com.unu.poo2.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.poo2.beans.Autor;

import java.util.List;

import com.unu.poo2.beans.Autor;

public class AutoresModel extends Conexion {
	CallableStatement cs;
	ResultSet rs;

	

	public List<Autor> listarAutores()  {
		try {
			List<Autor> lista = new ArrayList<>();
			String sql = "CALL sp_listarAutor()";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Autor autor = new Autor();
				autor.setIdAutor(rs.getInt("idautor"));
				autor.setNombreAutor(rs.getString("nombre"));
				autor.setNacionalidad(rs.getString("nacionalidad"));
				lista.add(autor);
			}
			this.cerrarConexion();
			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			this.cerrarConexion();
			;
			return null;
		}
	}
	
	public int insertarAutor(Autor autor)throws SQLException{
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_insertarAutor(?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setString(1, autor.getNombreAutor());
			cs.setString(2, autor.getNacionalidad());
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
			
		} catch (SQLException e) {
			// TODO: handle exception
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, e);
			this.cerrarConexion();
			return 0;

		}
	}
	
	public Autor obtenerAutor(int idautor) throws SQLException {
			Autor autor = new Autor();
		try {
			String sql= "CALL sp_obtenerAutor(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idautor);
			rs = cs.executeQuery();
			if(rs.next()) {
				
				autor.setIdAutor(rs.getInt("idautor"));
				autor.setNombreAutor(rs.getString("nombre"));
				autor.setNacionalidad(rs.getString("nacionalidad"));
				this.cerrarConexion();
			}
		} catch (Exception e) {
			// TODO: handle exception
			
			this.cerrarConexion();
			return null;
		}
		return autor;
		
	}
	
	public int modificarAutor(Autor autor)throws SQLException{
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_modificarAutor(?,?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, autor.getIdAutor());
			cs.setString(2, autor.getNombreAutor());
			cs.setString(3, autor.getNacionalidad());
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			this.cerrarConexion();
			return 0;

		}
	}
	public int eliminarAutor (int idAutor)throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_eliminarAutor(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idAutor);
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
		} catch (Exception e) {
			e.printStackTrace();
			this.cerrarConexion();
			return 0;
		}
	}

}
