package controlador;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	Scanner input = new Scanner(System.in);

	private ArrayList<Emprestimo> listaEmprestimo;
	private ArrayList<Cliente> listaCliente;
	private ArrayList<Publicacao> listaPublicacao;

	public Biblioteca() {
		listaEmprestimo = new ArrayList<Emprestimo>();
		listaCliente = new ArrayList<Cliente>();
		listaPublicacao = new ArrayList<Publicacao>();
	}

	public void addPublicacao(Publicacao p) {// coloca publicaçoes no acervo da biblioteca
		listaPublicacao.add(p);
	}

	public void cadastrarCliente(Cliente c) {// cadastrar clientes no sistema da biblioteca
		listaCliente.add(c);
	}

	public void addEmprestimo(Cliente c, Publicacao p) {
		for (int i = 0; i < listaCliente.size(); i++) {
			for (int j = 0; j < listaPublicacao.size(); j++) {
				if (listaCliente.get(i) == c && listaPublicacao.get(j) == p) {

					if (listaCliente.get(i).quantidadeEmprestimo == 0//verifica se o cliente chegou no limite de publicacoes que pode pegar
							|| listaPublicacao.get(j).quantidadeDisponivel == 0)//verifica se ainda tem publicacoes disponiveis
						System.out.println("Indisponivel no Momento");

					else {
						if (listaCliente.get(i) instanceof Aluno)
							listaCliente.get(i).tps += darDesconto(i, j);//caso seja aluno é chamado uma funcao para ver o desconto fornecido

						else
							listaCliente.get(i).tps += listaCliente.get(i).quantidadeDeTP();// o cliente começa a receber seu respectivo tp
																							
						listaPublicacao.get(j).matriculaReservada = listaCliente.get(i).matricula;//registra a matricula do cliente na publicacao q ele deseja
						listaCliente.get(i).quantidadeEmprestimo--;
						listaPublicacao.get(j).quantidadeDisponivel--;

						Emprestimo e = new Emprestimo(c, p);//registro de emprestimo
						listaEmprestimo.add(e);

						if (listaCliente.get(i).tps % 50 == 0) {//sistema pra doar caso os tps sejam divisiveis por 50
							System.out.println("doe uma publicacao para a biblioteca\n");
							String titulo = input.nextLine();
							int ano = input.nextInt();
							input.nextLine();
							String autor = input.nextLine();
							int quantidade = input.nextInt();
							Livro doacao = new Livro(titulo, ano, autor, quantidade);

							listaPublicacao.add(doacao);
						}

					}
				}
			}
		}
	}

	public String retornarAcervoDaBiblioteca() {

		String saida = "";
		String livros = "Livros:\n";
		String artigos = "\nArtigos:\n";
		String revistas = "\nRevistas:\n";

		for (int i = 0; i < listaPublicacao.size(); i++) {
			if (listaPublicacao.get(i).tipo == "Livro")//verifica cada tipo de publicacao segundo o tipo
				livros += listaPublicacao.get(i).titulo + "; " + listaPublicacao.get(i).ano + "; "
						+ listaPublicacao.get(i).autor + "; " + listaPublicacao.get(i).quantidadeDisponivel + "\n";

			if (listaPublicacao.get(i).tipo == "Artigo")
				artigos += listaPublicacao.get(i).titulo + "; " + listaPublicacao.get(i).ano + "; "
						+ listaPublicacao.get(i).autor + "; " + listaPublicacao.get(i).quantidadeDisponivel + "\n";

			if (listaPublicacao.get(i).tipo == "Revista")
				revistas += listaPublicacao.get(i).titulo + "; " + listaPublicacao.get(i).ano + "; "
						+ listaPublicacao.get(i).autor + "; " + listaPublicacao.get(i).quantidadeDisponivel + "\n";
		}

		saida += livros + artigos + revistas;
		return saida;
	}

	public String retornarClientesCadastrados() {

		String saida = "\tClientes:\n";
		String alunos = "\nAlunos:\n";
		String professor = "Professores:\n";
		String servidor = "\nServidores:\n";

		for (int i = 0; i < listaCliente.size(); i++) {//verifica cada tipo de cliente segundo o id
			if (listaCliente.get(i).id == 1)
				alunos += listaCliente.get(i).matricula + "; " + listaCliente.get(i).nome + "; "
						+ listaCliente.get(i).tps + "\n";

			if (listaCliente.get(i).id == 2)
				professor += listaCliente.get(i).matricula + "; " + listaCliente.get(i).nome + "; "
						+ listaCliente.get(i).tps + "\n";

			if (listaCliente.get(i).id == 3)
				servidor += listaCliente.get(i).matricula + "; " + listaCliente.get(i).nome + "; "
						+ listaCliente.get(i).tps + "\n";
		}

		saida += professor + alunos + servidor;
		return saida;
	}

	public String pesquisarCliente(int matricula) {

		String saida = "";

		for (int i = 0; i < listaCliente.size(); i++) {
			Cliente aux = listaCliente.get(i);

			if (aux.matricula == matricula) {//verifica se existe a matricula entre os clientes cadastrados
				String informacaoDasPublicacoes = "";
				for (int j = 0; j < listaPublicacao.size(); j++) {

					if (listaPublicacao.get(j).matriculaReservada == matricula)
						informacaoDasPublicacoes += listaPublicacao.get(j).titulo + "\n";
				}

				saida += aux.tipo + ": " + aux.nome + " - Livros alugados:\n" + informacaoDasPublicacoes + "\n";

			}

		}
		return saida;
	}

	public String pesquisarPublicacao(String nome) {

		String saida = "";

		for (int i = 0; i < listaPublicacao.size(); i++) {
			Publicacao aux = listaPublicacao.get(i);

			if (aux.titulo == nome)//verifica se existe o nome entre as publicacoes
				saida += "Publicacao Existente - Quantidade:" + aux.quantidadeDisponivel;

		}
		return saida;
	}

	public String registroDeEmprestimos() {
		String saida = "\tEmprestimos:\n";
		String livro = "";
		String artigos = "";
		String revistas = "";
		int totalLivros = 0, totalArtigos = 0, totalRevistas = 0;

		for (int i = 0; i < listaEmprestimo.size(); i++) {//sistema q separa os emprestimos em livros artigos e revistas
			if (listaEmprestimo.get(i).publicacao.tipo == "Livro") {
				livro += listaEmprestimo.get(i).cliente.tipo + ": " + listaEmprestimo.get(i).cliente.nome + "; ";
				totalLivros++;
			}

			if (listaEmprestimo.get(i).publicacao.tipo == "Revista") {
				revistas += listaEmprestimo.get(i).cliente.tipo + ": " + listaEmprestimo.get(i).cliente.nome + "; ";
				totalRevistas++;
			}

			if (listaEmprestimo.get(i).publicacao.tipo == "Artigo") {
				artigos += listaEmprestimo.get(i).cliente.tipo + ": " + listaEmprestimo.get(i).cliente.nome + "; ";
				totalArtigos++;
			}

		}
		saida += "Livros: Total " + totalLivros + " " + livro + "\n\nArtigos: Total " + totalArtigos + " " + artigos
				+ "\n\nRevistas: Total " + totalRevistas + " " + revistas;
		return saida;

	}

	public int darDesconto(int i, int j) {//funcao de dar desconto ao aluno mencionado acima
		int retorno = 0;
		if (listaPublicacao.get(j) instanceof Livro)
			retorno += listaCliente.get(i).quantidadeDeTP() - (listaCliente.get(i).quantidadeDeTP() * 0.1);

		else if (listaPublicacao.get(j) instanceof Artigo)
			retorno += listaCliente.get(i).quantidadeDeTP() - (listaCliente.get(i).quantidadeDeTP() * 0.5);

		else if (listaPublicacao.get(j) instanceof Revista)
			retorno += listaCliente.get(i).quantidadeDeTP() - (listaCliente.get(i).quantidadeDeTP() * 0.01);

		return retorno;
	}
}
