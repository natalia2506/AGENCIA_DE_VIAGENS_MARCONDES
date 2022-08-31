package crud;

import java.util.Scanner;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteCrud {
	public static void main(String[] args) {

	
	ClienteDAO clientesDAO = new ClienteDAO();
	
	Scanner input = new Scanner(System.in);
	
	int opcao = 0;
	int posicao = 0;
	
	int id = 0;
	String nome = "";
	String nomesocial = "";
	int idade = 0;
	String identidade = "";
	String cpf = "";
	String endereco = "";
	String telefone = "";
	String email = "";
		

	do {
		System.out.println("\n\t--- CRUD CLIENTE ---");
		System.out.println("\n\t1 - Cadastro de Cliente");
		System.out.println("\t2 - Consulta de Clientes");
		System.out.println("\t3 - Delete de Cliente");
		System.out.println("\t4 - Atualizar Cliente");
		System.out.println("\t0 - Sair");
		
		opcao = input.nextInt();
		
		switch (opcao) { 
		case 1: 
			//CREATE
			System.out.println("\n**Cadastrar Cliente**");
			System.out.println("\nDigite o nome do cliente: ");
			nome = input.nextLine();
			nome = input.nextLine();
			System.out.println("Digite o nome social do cliente: ");
			nomesocial = input.nextLine();
			System.out.println("Digite a idade do cliente: ");
			idade = input.nextInt();
			input.nextLine();
			System.out.println("Digite identidade do cliente: ");
			identidade = input.nextLine();
			System.out.println("Digite o CPF do cliente: ");
			cpf = input.nextLine();
			System.out.println("Digite endereço do cliente: ");
			endereco = input.nextLine();
			System.out.println("Digite o telefone do cliente: ");
			telefone = input.nextLine();
			System.out.println("Digite o e-mail do cliente: ");
			email = input.nextLine();
			
			
			Cliente clientes = new Cliente();
			
			clientes.setNome_cliente(nome);
			clientes.setNomesocial_cliente(nomesocial);
			clientes.setIdade_cliente(idade);
			clientes.setIdentidade_cliente(identidade);
			clientes.setCpf_cliente(cpf);
			clientes.setEndereco_cliente(endereco);
			clientes.setTelefone_cliente(telefone);
			clientes.setEmail_cliente(email);
			
			clientesDAO.save(clientes);
			
			System.out.println("\n*** Cliente cadastrado com sucesso**\n");
			break;
		case 2:
			//READ
			for (Cliente a : clientesDAO.getCliente()) { 
				System.out.println("\n\tId do cliente: " + a.getId_cliente() + "\n\tNome do cliente: " 
			+ a.getNome_cliente() + "\n\tNome social do cliente:  " + a.getNomesocial_cliente() + "\n\tIdade do cliente:  " + a.getIdade_cliente() + "\n\tIdentidade do cliente:  " + a.getIdentidade_cliente() + "\n\tCPF do cliente:  " + a.getCpf_cliente() + "\n\tEndereço do cliente:  " + a.getEndereco_cliente() + "\n\tTelefone do cliente:  " + a.getTelefone_cliente() + "\n\tEmail do cliente:  " + a.getEmail_cliente());
			}
			
			System.out.println("\n\n**********************************************************Consulta Finalizada*******************************************************************");
			break;
		case 3:
			//DELETE
			System.out.println("\nPasse o ID  do  cliente para exclusão: ");
			posicao = input.nextInt();
			clientesDAO.deleteById(posicao);
			System.out.println("\n*Cliente excluído com sucesso*");
			break;
		case 4: 
			//UPDATE
			System.out.println("Digite o id do cliente: ");
			id = input.nextInt();
			input.nextLine();
			System.out.println("Digite o novo nome do Cliente: ");
			nome = input.nextLine();
			System.out.println("Digite o novo nome social do Cliente: ");
			nomesocial = input.nextLine();
			System.out.println("Digite a nova idade do Cliente: ");
			idade = input.nextInt();
			input.nextLine();
			System.out.println("Digite a nova identidade do Cliente: ");
			identidade = input.nextLine();
			System.out.println("Digite o novo  CPF do Cliente: ");
			cpf = input.nextLine();
			System.out.println("Digite o novo  endereço do Cliente: ");
			endereco = input.nextLine();
			System.out.println("Digite o novo  telefone do Cliente: ");
			telefone = input.nextLine();
			System.out.println("Digite o novo email do Cliente: ");
			email = input.nextLine();
			input.nextLine();
			
			Cliente cliente1 = new Cliente(id, nome, nomesocial, idade, identidade, cpf, endereco, telefone, email);
			
			clientesDAO.update(cliente1);
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

