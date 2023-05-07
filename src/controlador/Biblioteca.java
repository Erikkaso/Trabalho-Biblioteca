package controlador;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	Scanner input = new Scanner(System.in);
	Scanner inpt = new Scanner(System.in);
	private ArrayList<Emprestimo> listaEmprestimo;
	private ArrayList<Cliente> listaCliente;
	private ArrayList<Publicacao> listaPublicacao;

	public Biblioteca() {
		listaEmprestimo = new ArrayList<Emprestimo>();
		listaCliente = new ArrayList<Cliente>();
		listaPublicacao = new ArrayList<Publicacao>();
	}

	public void addPublicacao(Publicacao p) {// coloca publicaçoes no acervo da biblioteca
		//p.acessivelNoAcervo = true;
		listaPublicacao.add(p);
	}

	public void cadastrarCliente(Cliente c) {// cadastrar clientes no sistema da biblioteca
		//c.cadastado = true;//confirma que ele esta na biblioteca
		listaCliente.add(c);
	}

	
	public void addEmprestimo(Cliente c, Publicacao p) {
		for (int i = 0; i < listaCliente.size(); i++) {
			for(int j=0 ;j<listaPublicacao.size();j++) {
			if(listaCliente.get(i) == c && listaPublicacao.get(j) == p) {
				
				if (listaCliente.get(i).quantidadeEmprestimo == 0 || listaPublicacao.get(j).quantidadeDisponivel == 0)
					System.out.println("Indisponivel no Momento");  
				
				else {
					if(listaCliente.get(i) instanceof Aluno)
						listaCliente.get(i).tps += darDesconto(i, j);
				
					else
					listaCliente.get(i).tps += listaCliente.get(i).quantidadeDeTP();// o cliente começa a receber seu respectivo tp
					//listaEmprestimo.add(e); 
					listaPublicacao.get(j).matriculaReservada = listaCliente.get(i).matricula;
					listaCliente.get(i).quantidadeEmprestimo--;
					listaPublicacao.get(j).quantidadeDisponivel--;
					
					if(listaCliente.get(i).tps%50==0) {
						System.out.println("doe uma publicacao para a biblioteca\n");
						String titulo = input.nextLine();
						int ano = input.nextInt();
						String autor = inpt.nextLine();
						int quantidade = inpt.nextInt();
						Livro doacao = new Livro(titulo,ano,autor,quantidade);
					
						listaPublicacao.add(doacao);
					}
					
					 }
			}
		  }
		}
	}
	
	/*
	 * public void addEmprestimo(Emprestimo e) { 
	 * if (e.cliente.quantidadeEmprestimo
	 * == 0 || e.publicacao.quantidadeDisponivel == 0) 
	 * {
	 * System.out.println("Indisponivel no Momento"); } 
	 * else 
	 * {
	 *  e.cliente.tps =
	 * e.cliente.quantidadeDeTP();// o cliente começa a receber seu respectivo tp
	 * listaEmprestimo.add(e); e.cliente.quantidadeEmprestimo--;
	 * e.publicacao.quantidadeDisponivel--; } 
	 * }
	 * 
	 * public ArrayList<Emprestimo> getListaEmprestimo() { return listaEmprestimo; }
	 * 
	 * public String retornarTodosDadosEmprestimo() {
	 * 
	 * String saida = "";
	 * 
	 * for (int i = 0; i < listaEmprestimo.size(); i++) { Emprestimo aux =
	 * listaEmprestimo.get(i); saida += aux.cliente.tipo + ": " + aux.cliente.nome +
	 * " - " + aux.publicacao.tipo + ": " + aux.publicacao.titulo +
	 * " - Dias de emprestimo:" + aux.cliente.verificarDias() + "\n";
	 * 
	 * } return saida; }
	 */
	public String retornarAcervoDaBiblioteca() {

		String saida = "";
		String livros = "Livros:\n";
		String artigos = "\nArtigos:\n";
		String revistas = "\nRevistas:\n";

		for (int i = 0; i < listaPublicacao.size(); i++) {
			if(listaPublicacao.get(i).tipo == "Livro")
				livros += listaPublicacao.get(i).titulo + "; " + listaPublicacao.get(i).ano + "; " + listaPublicacao.get(i).autor + "; " + listaPublicacao.get(i).quantidadeDisponivel + "\n";
			
			if(listaPublicacao.get(i).tipo == "Artigo")
				artigos += listaPublicacao.get(i).titulo + "; " + listaPublicacao.get(i).ano + "; " + listaPublicacao.get(i).autor + "; " + listaPublicacao.get(i).quantidadeDisponivel + "\n";
			
			if(listaPublicacao.get(i).tipo == "Revista")
				revistas += listaPublicacao.get(i).titulo + "; " + listaPublicacao.get(i).ano + "; " + listaPublicacao.get(i).autor + "; " + listaPublicacao.get(i).quantidadeDisponivel + "\n";
		}
		
		saida += livros + artigos + revistas;
		return saida;
	}

	public String retornarClientesCadastrados() {

		String saida = "\tClientes:\n";
		String alunos = "\nAlunos:\n";
		String professor = "Professores:\n";
		String servidor = "\nServidores:\n";
		
		for (int i = 0; i < listaCliente.size(); i++) {
			if (listaCliente.get(i).id == 1)
				alunos += listaCliente.get(i).matricula + "; " + listaCliente.get(i).nome + "; " + listaCliente.get(i).tps +"\n";

			if (listaCliente.get(i).id == 2)
				professor += listaCliente.get(i).matricula + "; " + listaCliente.get(i).nome + "; " + listaCliente.get(i).tps +"\n";

			if (listaCliente.get(i).id == 3)
				servidor += listaCliente.get(i).matricula + "; " + listaCliente.get(i).nome + "; " + listaCliente.get(i).tps +"\n";
		}
		
		saida += professor + alunos + servidor;
		return saida;
	}

	public String pesquisarCliente(int matricula) {

		String saida = "";

		for (int i = 0; i < listaCliente.size(); i++) {
			Cliente aux = listaCliente.get(i);

			if (aux.matricula == matricula) {
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
			
			if(aux.titulo == nome)
			saida += "Publicacao Existente - Quantidade:" + aux.quantidadeDisponivel;
			
		}
		return saida;
	}

	public int darDesconto(int i, int j) {
		int retorno=0;
		if(listaPublicacao.get(j) instanceof Livro)
			retorno += listaCliente.get(i).quantidadeDeTP() - (listaCliente.get(i).quantidadeDeTP()*0.1) ;
		
		else if(listaPublicacao.get(j) instanceof Artigo)
			retorno += listaCliente.get(i).quantidadeDeTP() - (listaCliente.get(i).quantidadeDeTP()*0.5) ;
		
		else if(listaPublicacao.get(j) instanceof Revista)
			retorno += listaCliente.get(i).quantidadeDeTP() - (listaCliente.get(i).quantidadeDeTP()*0.01) ;
		
		return retorno;
	}
}
