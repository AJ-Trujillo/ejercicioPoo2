package com.unu.poo2.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.poo2.beans.Editorial;

public class EditorialModeler extends Conexion {

	CallableStatement cs;
	ResultSet rs;
	
	
	public List<Editorial> listarEditorial()  {
		try {
			List<Editorial> lista = new ArrayList<>();
			String sql = "CALL sp_listarEditorial()";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Editorial editorial = new Editorial();
				editorial.setIdeditorial(rs.getInt("ideditorial"));
				editorial.setNombre(rs.getString("nombre"));
				editorial.setContacto(rs.getString("contacto"));
				editorial.setTelefono(rs.getString("telefono"));
				lista.add(editorial);
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
	
	public int insertarEditorial(Editorial editorial)throws SQLException{
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_insertarEditorial(?,?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setString(1, editorial.getNombre());
			cs.setString(2, editorial.getContacto());
			cs.setString(3, editorial.getTelefono());
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
	
	public Editorial obtenerEditorial(int ideditorial) throws SQLException {
		Editorial editorial = new Editorial();
		try {
			String sql= "CALL sp_obtenerEditorial(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, ideditorial);
			rs = cs.executeQuery();
			if(rs.next()) {
				
				editorial.setIdeditorial(rs.getInt("ideditorial"));
				editorial.setNombre(rs.getString("nombre"));
				editorial.setContacto(rs.getString("contacto"));
				editorial.setTelefono(rs.getString("telefono"));
				this.cerrarConexion();
			}
		} catch (Exception e) {
			// TODO: handle exception
			
			this.cerrarConexion();
			return null;
		}
		return editorial;
		
	}
	
	public int modificarEditorial(Editorial editorial)throws SQLException{
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_modificarEditorial(?,?,?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, editorial.getIdeditorial());
			cs.setString(2, editorial.getNombre());
			cs.setString(3, editorial.getContacto());
			cs.setString(4, editorial.getTelefono());
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
	
	public int eliminarEditorial (int ideditorial)throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_eliminarEditorial(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, ideditorial);
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