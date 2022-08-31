package crud;

import java.util.Scanner;

import dao.DestinoDAO;
import model.Destino;

public class DestinoCrud {
	public static void main(String[] args) {
	
	
DestinoDAO destinosDAO = new DestinoDAO();
	
	Scanner input = new Scanner(System.in);
	
	int opcao = 0;
	int posicao = 0;
	
	int id = 0;
	String nome = "";
	String pais = "";
	


	do {
		System.out.println("\n\t--- CRUD DESTINO ---");
		System.out.println("\n\t1 - Cadastro de destino");
		System.out.println("\t2 - Consulta de destinos");
		System.out.println("\t3 - Delete de destino");
		System.out.println("\t4 - Atualizar destino");
		System.out.println("\t0 - Sair");
		
		opcao = input.nextInt();
		
		switch (opcao) { 
		case 1: 
			//CREATE
			System.out.println("\n**Cadastrar Destino**");
			System.out.println("\nDigite o nome do destino: ");
			nome = input.nextLine();
			System.out.println("Digite o nome do país de destino: ");
			pais = input.nextLine();
			
			Destino destinos = new Destino();
			
			destinos.setNome_destino(nome);
			destinos.setPais_destino(pais);
			
			destinosDAO.save(destinos);
			
			System.out.println("\n*** Destino cadastrado**\n");
			break;
		case 2:
			//READ
			for (Destino a : destinosDAO.getDestino()) { 
				System.out.println("\n\tId: " + a.getId_destino() + "\n\tNome destino: " 
			+ a.getNome_destino() + "\n\tPaís de destino: " + a.getPais_destino());
			}
			
			System.out.println("\n\n**********************************************************Consulta Finalizada*******************************************************************");
			break;
		case 3:
			//DELETE
			System.out.println("Passe o ID para exclusão: ");
			posicao = input.nextInt();
			destinosDAO.deleteById(posicao);
			System.out.println("*\ndestino excluído*");
			break;
		case 4: 
			//UPDATE
			System.out.println("Digite o id do destino: ");
			id = input.nextInt();
			System.out.println("Digite o novo nome do destino: ");
			nome = input.nextLine();
			nome = input.nextLine();
			System.out.println("Digite o novo nome do país de destino: ");
			pais = input.nextLine();
			
			Destino destino1 = new Destino(id, nome, pais);
			destinosDAO.update(destino1);
			break;
		default:
			System.out.println(opcao != 0 ? "\n Opção é inválida, " + "tente novamente.\n" : "");
			break;
		}
	} while (opcao != 0);
	input.close();
	 System.out.println("\n************************************************************************Finalizado********************************************************************");
		
   }
}

