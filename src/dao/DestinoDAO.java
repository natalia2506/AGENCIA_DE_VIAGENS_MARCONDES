package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Destino;



public class DestinoDAO {
	
	//CREATE
	public void save(Destino destinos) { 

		String sql = "INSERT INTO destino (nome_destino, pais_destino) VALUES (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try { 
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destinos.getNome_destino());
			pstm.setString(2, destinos.getPais_destino());
			
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
	
	//READ
	public List<Destino> getDestino() { 
		
		String sql = "SELECT * FROM Destino";
		
		List<Destino> destino = new ArrayList<Destino>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) { 
				Destino destinos = new Destino();
				
				destinos.setId_destino(rset.getInt("id_destino"));
				destinos.setNome_destino(rset.getString("nome_destino"));
				destinos.setPais_destino(rset.getString("pais_destino"));
				
				destino.add(destinos);
			}
		} catch (Exception e) { 
			e.printStackTrace();
		} finally { 
			try { 
				if (rset != null) { 
					rset.close();
				}
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
		
		return destino;
	}

	//UPDATE
	public void update(Destino destinos) { 
		
		String sql = "UPDATE Destino SET nome_destino = ?, pais_destino = ? WHERE id_destino = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try { 
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destinos.getNome_destino());
			pstm.setString(2, destinos.getPais_destino());
			pstm.setInt(3, destinos.getId_destino());
			
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
	
	//read - by id
	
	public Destino getDestinoById(int id_destino) {
		String sql = "SELECT * FROM destino WHERE id_destino = ?";
		
		Destino destinos = new Destino();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		
		
		try { 
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_destino);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			destinos.setId_destino(rset.getInt("id_destino"));
			destinos.setNome_destino(rset.getString("nome_destino"));
			destinos.setPais_destino(rset.getString("pais_destino"));
			
			
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
				if (rset != null) {  
					rset.close();
				}
				
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}
		return destinos;
	}
	
	
	//DELETE
	public void deleteById(int id) { 
		
		String sql = "DELETE FROM destino WHERE id_destino = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
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
	


