package controlador;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Clientes da Biblioteca TecProg
		Cliente aluno = new Aluno(30305, "Joao");
		Cliente aluno2 = new Aluno(2552, "Marcos");

		Cliente professor = new Professor(2525, "Mateus");
		Cliente professor2 = new Professor(565, "jonas");

		Cliente servidor = new Servidor(898, "Michelle");
		Cliente servidor2 = new Servidor(982, "Thales");

		// Publicacoes da Biblioteca TecProg
		Publicacao livro = new Livro("Java como programa", 2020, "Deitel", 10);
		Publicacao livro2 = new Livro("Python como programa", 2019, "Oliveira", 10);

		Publicacao revista = new Revista("INDICO: inclusao digital necessaria para sociedade atual", 2023,
				"Geovana e Cau�", 8);
		Publicacao revista2 = new Revista("inteligencia artificial aplicada", 2023, "Amora", 10);

		Publicacao artigo = new Artigo("Um comparativo de desempenho entre Java e Python", 2021, "Silva", 4);
		Publicacao artigo2 = new Artigo("Um comparativo entre o Eclipse e VsCode", 2023, "Cordeiro", 5);

		Biblioteca bib = new Biblioteca();
		// Salvando publicaçoes na biblioteca
		bib.addPublicacao(artigo);
		bib.addPublicacao(artigo2);
		bib.addPublicacao(revista);
		bib.addPublicacao(revista2);
		bib.addPublicacao(livro);
		bib.addPublicacao(livro2);

		// Cadastrando clientes da biblioteca
		bib.cadastrarCliente(aluno);
		bib.cadastrarCliente(aluno2);
		bib.cadastrarCliente(professor);
		bib.cadastrarCliente(professor2);
		bib.cadastrarCliente(servidor);
		bib.cadastrarCliente(servidor2);

		bib.addEmprestimo(aluno, livro);
		bib.addEmprestimo(professor, livro2);
		bib.addEmprestimo(aluno2, livro);
		bib.addEmprestimo(servidor2, artigo2);
		bib.addEmprestimo(servidor, artigo);

		//sistema de menu
		System.out.println(
				"Bem Vindo, o que deseja?\n1.Mostrar registro de emprestimos\n2.Mostrar acervo da biblioteca\n3.Listar Clientes\n4.Consultar cliente\n5.Consultar publicacao");
		Scanner input = new Scanner(System.in);
		int opcao;
		opcao = input.nextInt();

		switch (opcao) {
		case 1:
			System.out.println(bib.registroDeEmprestimos());
			break;

		case 2:
			System.out.println(bib.retornarAcervoDaBiblioteca());
			break;

		case 3:
			System.out.println(bib.retornarClientesCadastrados());
			break;
		case 4:
			input.nextLine();
			System.out.print("informe a matricula: ");
			int matricula;
			matricula = input.nextInt();
			System.out.println(bib.pesquisarCliente(matricula));
			break;
		case 5:
			input.nextLine();
			System.out.print("informe ao nome da publicacao: ");
			String nome;
			nome = input.nextLine();
			System.out.println(bib.pesquisarPublicacao(nome));
			break;
		default:
			System.out.println("opcao invalida.");
			break;
		}
		input.close();
	}

}
