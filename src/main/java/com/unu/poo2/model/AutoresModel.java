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
	
	/*public int insertarAutor(Autor autor)throws SQLException{
		try {
			int filasAfectadas = 0;
			String sqlString = "CALL sp_insertarAutor(?,?,?)";
			this.abrirConexion();
			cs = c
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}*/

}
