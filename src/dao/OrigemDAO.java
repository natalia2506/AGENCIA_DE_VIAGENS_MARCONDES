package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Origem;

public class OrigemDAO {

	//CREATE
		public void save(Origem origens) { 

			String sql = "INSERT INTO origem (nome_origem, pais_origem) VALUES (?, ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try { 
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, origens.getNome_origem());
				pstm.setString(2, origens.getPais_origem());
				
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
		public List<Origem> getOrigem() { 
			
			String sql = "SELECT * FROM Origem";
			
			List<Origem> origem = new ArrayList<Origem>();
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) { 
					Origem origens = new Origem();
					
					origens.setId_origem(rset.getInt("id_origem"));
					origens.setNome_origem(rset.getString("nome_origem"));
					origens.setPais_origem(rset.getString("pais_origem"));
					
					origem.add(origens);
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
			
			return origem;
		}

		//UPDATE
		public void update(Origem origens) { 
			
			String sql = "UPDATE origem SET nome_origem = ?, pais_origem = ? WHERE id_origem = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try { 
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				
				pstm.setString(1, origens.getNome_origem());
				pstm.setString(2, origens.getPais_origem());
				pstm.setInt(3, origens.getId_origem());
				
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
		
		public Origem getOrigemById(int id_origem) {
			String sql = "SELECT *FROM  origem WHERE id_ origem = ?";
			
			Origem origens = new Origem();
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			
			
			try { 
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, id_origem);
				
				rset = pstm.executeQuery();
				
				rset.next();
				
				origens.setId_origem(rset.getInt("id_origem"));
				origens.setNome_origem(rset.getString("nome_origem"));
				origens.setPais_origem(rset.getString("pais_origem"));
				
				
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
			return origens;
		}
		
		
		//DELETE
		public void deleteById(int id) { 
			
			String sql = "DELETE FROM origem WHERE id_origem = ?";
			
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
		


