package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Cliente;

public class ClienteDAO {

	//CREATE
		public void save(Cliente clientes) { 

			String sql = "INSERT INTO cliente (nome_cliente, nomesocial_cliente, idade_cliente, identidade_cliente, cpf_cliente, endereco_cliente, telefone_cliente, email_cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try { 
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, clientes.getNome_cliente());
				pstm.setString(2, clientes.getNomesocial_cliente());
				pstm.setInt(3, clientes.getIdade_cliente());
				pstm.setString(4, clientes.getIdentidade_cliente());
				pstm.setString(5, clientes.getCpf_cliente());
				pstm.setString(6, clientes.getEndereco_cliente());
				pstm.setString(7, clientes.getTelefone_cliente());
				pstm.setString(8, clientes.getEmail_cliente());
				
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
		public List<Cliente> getCliente() { 
			
			String sql = "SELECT * FROM Cliente";
			
			List<Cliente> cliente = new ArrayList<Cliente>();
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) { 
					Cliente clientes = new Cliente();
					
						
					clientes.setId_cliente(rset.getInt("id_cliente"));
					clientes.setNome_cliente(rset.getString("nome_cliente"));
					clientes.setNomesocial_cliente(rset.getString("nomesocial_cliente"));
					clientes.setIdade_cliente(rset.getInt("idade_cliente"));
					clientes.setIdentidade_cliente(rset.getString("identidade_cliente"));
					clientes.setCpf_cliente(rset.getString("cpf_cliente"));
					clientes.setEndereco_cliente(rset.getString("endereco_cliente"));
					clientes.setTelefone_cliente(rset.getString("telefone_cliente"));
					clientes.setEmail_cliente(rset.getString("email_cliente"));
					
					
					cliente.add(clientes);
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
			
			return cliente;
		}

		//UPDATE
		public void update(Cliente clientes) { 
			
			String sql = "UPDATE Cliente SET nome_cliente = ?, nomesocial_cliente = ?, idade_cliente = ?, identidade_cliente = ?, cpf_cliente = ?, endereco_cliente = ?, telefone_cliente = ?, email_cliente = ? WHERE id_cliente = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try { 
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
		
				
				pstm.setString(1, clientes.getNome_cliente());
				pstm.setString(2, clientes.getNomesocial_cliente());
				pstm.setInt(3, clientes.getIdade_cliente());
				pstm.setString(4, clientes.getIdentidade_cliente());
				pstm.setString(5, clientes.getCpf_cliente());
				pstm.setString(6, clientes.getEndereco_cliente());
				pstm.setString(7, clientes.getTelefone_cliente());
				pstm.setString(8, clientes.getEmail_cliente());
				pstm.setInt(9, clientes.getId_cliente());
				
				
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
			
			String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
			
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
		



