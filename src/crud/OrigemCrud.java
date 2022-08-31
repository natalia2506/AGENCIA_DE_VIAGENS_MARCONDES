package crud;

import java.util.Scanner;

import dao.OrigemDAO;
import model.Origem;


public class OrigemCrud {
	
	public static void main(String[] args) { 
	
	OrigemDAO origensDAO = new OrigemDAO();
	
	Scanner input = new Scanner(System.in);
	
	int opcao = 0;
	int posicao = 0;
	
	int id = 0;
	String nome = "";
	String pais = "";
	

	do {
		System.out.println("\n\t--- CRUD ORIGEM---");
		System.out.println("\n\t1 - Cadastro de origem");
		System.out.println("\t2 - Consulta de origens");
		System.out.println("\t3 - Delete de origem");
		System.out.println("\t4 - Atualizar origem");
		System.out.println("\t0 - Sair");
		
		opcao = input.nextInt();
		
		switch (opcao) { 
		case 1: 
			//CREATE
			System.out.println("\n**Cadastrar Origem**");
			System.out.println("\nDigite o nome da cidade de origem: ");
			nome = input.nextLine();
			System.out.println("Digite o país de origem: ");
			pais = input.nextLine();
			
			Origem origens = new Origem();
			
			origens.setNome_origem(nome);
			origens.setPais_origem(pais);
			
			origensDAO.save(origens);
			
			System.out.println("\n*** Origem Cadastrada**\n");
			break;
		case 2:
			//READ
			for (Origem a : origensDAO.getOrigem()) { 
				System.out.println("\n\tId: " + a.getId_origem() + "\n\tNome origem: " 
			+ a.getNome_origem() + ";\n\tPaís de origem: " + a.getPais_origem());
			}
			
			System.out.println("\n\n**********************************************************Consulta Finalizada*******************************************************************");
			break;
		case 3:
			//DELETE
			System.out.println("Passe o ID para exclusão: ");
			posicao = input.nextInt();
			origensDAO.deleteById(posicao);
			System.out.println("*\nOrigem excluída*");
			break;
		case 4: 
			//UPDATE
			System.out.println("Digite o id de Origem: ");
			id = input.nextInt();
			System.out.println("Digite o novo nome da origem: ");
			nome = input.nextLine();
			nome = input.nextLine();
			System.out.println("Digite o novo País de origem: ");
			pais = input.nextLine();
			
			
			Origem origem1 = new Origem(id, nome, pais);
			origensDAO.update(origem1);
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


