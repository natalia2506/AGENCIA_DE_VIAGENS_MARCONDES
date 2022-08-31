package crud;

import java.util.Scanner;


import dao.OrigemDAO;
import dao.ViagemDAO;
import dao.DestinoDAO;
import model.Origem;
import model.Destino;
import model.Viagem;

public class ViagemCrud {


	public static void main(String[] args) {
		
			ViagemDAO viagensDAO = new ViagemDAO();
			OrigemDAO origensDAO = new OrigemDAO();
			DestinoDAO destinosDAO = new DestinoDAO();
			
			Scanner input = new Scanner(System.in);
			
			int opcao = 0;
			int posicao = 0;
			
			int id = 0;
			String data_ida = "";
			String data_volta = "";
			String data_ida1 = "";
			String data_volta1 = "";
			
			double preco = 0;
			int id_origem = 0;
			int id_destino = 0;
			
		do {
			System.out.println("\n\t--- CRUD VIAGEM ---");
			System.out.println("\n\t1 - Cadastro de viagem");
			System.out.println("\t2 - Consulta de viagens");
			System.out.println("\t3 - Atualizar viagem");
			System.out.println("\t4 - Delete de viagem");
			System.out.println("0 - Sair");
			opcao = input.nextInt();
			input.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("\n*CADASTRAR VIAGEM*");
				System.out.println("\nDigite a data de ida: ");
				input.nextLine();
				data_ida = input.nextLine();
				System.out.println("Digite a data de volta: ");
				data_volta = input.nextLine();
				System.out.println("Digite o preço: ");
				preco = input.nextDouble();
				System.out.println("Digite o id da origem: ");
				id_origem = input.nextInt();
				input.nextLine();
				System.out.println("Digite o id do destino: ");
				id_destino = input.nextInt();
				input.nextLine();
				
			
				Origem origens = origensDAO.getOrigemById(id_origem);
				Destino destinos = destinosDAO.getDestinoById(id_destino);

				Viagem viagens1 = new Viagem(id, data_ida, data_volta, preco, origens, destinos);
				
				viagensDAO.save(viagens1);
				
				System.out.println("\n*Cadastrado*");
				break;	
			case 2:
				// READ
				for (Viagem l : viagensDAO.getViagem()) { 
					System.out.println("\n\tId: " + l.getId_viagem() + "\n\tData de ida: " + l.getData_ida() + "\n\tData de volta: " + l.getData_volta() + 
							"\n\tPreço: " + l.getPreco() + "\n\tOrigem: " + l.getOrigem().getNome_origem() + "\n\tDestino: " + l.getDestino().getNome_destino());
				}
				
				System.out.println("\n\n**********************************************************Consulta Finalizada*******************************************************************");
				break;				
			case 3:
				// UPDATE
				System.out.println("Digite o id da viagem: ");
				id = input.nextInt();
				input.nextLine();
				System.out.println("Digite a data de ida: ");
				data_ida = input.nextLine();
				System.out.println("Digite a data de volta: ");
				data_volta = input.nextLine();
				System.out.println("Digite o preço: ");
				preco = input.nextDouble();
				System.out.println("Digite o id da origem: ");
				id_origem = input.nextInt();
				input.nextLine();
				System.out.println("Digite o id do destino: ");
				id_destino = input.nextInt();
				input.nextLine();
				
				Origem origens1 = origensDAO.getOrigemById(id_origem);
				Destino destinos1 = destinosDAO.getDestinoById(id_destino);
				
				
				Viagem viagens2 = new Viagem(posicao, data_ida1, data_volta1, preco, origens1, destinos1);
				
				viagensDAO.update(viagens2);
				break;
				
			case 4:
				// DELETE
				System.out.println("Digite o id: ");
				posicao = input.nextInt();
				viagensDAO.deleteById(posicao);
				System.out.println("viagem excluído \n");
				break;	
			
			default:
				System.out.println(opcao != 0 ? "Opcao invalida, digite novamente" : "");
				break;
			}

		} while (opcao != 0);

		System.out.println("Sistema finalizado");
		input.close();
	}
}
