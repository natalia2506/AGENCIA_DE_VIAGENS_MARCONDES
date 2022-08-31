package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;


import model.Viagem;
import model.Origem;
import model.Destino;




public class ViagemDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	// METODO POST
	public void save(Viagem viagens) {
		
		String sql = "INSERT INTO viagem " + "(data_ida, data_volta, preco, id_origem, id_destino)"
				+ " values (?, ?, ?, ?, ?);";


		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			
			pstm.setString(1, viagens.getData_ida());
			pstm.setString(2, viagens.getData_volta());
			pstm.setDouble(3, viagens.getPreco());
			
			pstm.setInt(4, viagens.getOrigem().getId_origem());
			pstm.setInt(5, viagens.getDestino().getId_destino());
			
			pstm.execute();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
    //GET
	public List<Viagem> getViagem() { 
		String sql =  "SELECT *\n"
				+ "FROM viagem AS l\n"
				+ "JOIN origem AS e ON l.id_origem = e.id_origem\n"
				+ "JOIN destino AS a ON l.id_destino = a.id_destino";
		
		List<Viagem> viagem = new ArrayList<Viagem>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try { 
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) { 
				
				Viagem viagens = new Viagem();
				Origem origens = new Origem();
				Destino destinos = new Destino();
				
				
				viagens.setId_viagem(rset.getInt("id_viagem"));
				viagens.setData_ida(rset.getString("data_ida"));
				viagens.setData_volta(rset.getString("data_volta"));
				viagens.setPreco(rset.getDouble("preco"));
				
				origens.setNome_origem(rset.getString("nome_origem"));
				destinos.setNome_destino(rset.getString("nome_destino"));
				
				viagens.setOrigem(origens);
				viagens.setDestino(destinos);
				
				viagem.add(viagens);
				
	
			}
		} catch (Exception e) { 
			e.printStackTrace();
		} finally { 
			try { 
				if (pstm != null) { 
					pstm.close();
				}
				if (conn != null) { 
					conn.close();
				}
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}
		
		return viagem;
	}
	

	// METODO UPDATE
	public void update(Viagem viagens1) {
		String sql = "UPDATE viagem SET data_ida = ?, data_volta = ?, preco = ?, id_origem = ? , id_destino = ? WHERE id_viagem = ?;";
		
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1,viagens1.getId_viagem());
			pstm.setString(2, viagens1.getData_ida());
			pstm.setString(3, viagens1.getData_volta());
			pstm.setDouble(4, viagens1.getPreco());
			
			pstm.setInt(5, viagens1.getOrigem().getId_origem());
			pstm.setInt(6, viagens1.getDestino().getId_destino());
			
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	//DELETE
	public void deleteById(int id) {
		String sql = "DELETE FROM viagem WHERE id_viagem = ?";
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
