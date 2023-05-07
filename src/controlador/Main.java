package controlador;

public class Main {

	public static void main(String[] args) {
		
		
		//Clientes da Biblioteca TecProg
		Cliente aluno= new Aluno(30305, "Joao");
		Cliente aluno2= new Aluno(2552, "Marcos");
		
		Cliente professor = new Professor(2525, "Mateus");
		Cliente professor2 = new Professor(565, "jonas");
		
		Cliente servidor = new Servidor(898, "Michelle");
		Cliente servidor2 = new Servidor(982, "Thales");
		
		//Publicacoes da Biblioteca TecProg
		Publicacao livro = new Livro("Java como programa", 2020, "Deitel", 10);
		Publicacao livro2 = new Livro("Python como programa", 2019, "Oliveira", 10);
		
		Publicacao revista = new Revista("INDICO: inclusao digital necessaria para sociedade atual", 2023, "Geovana e Cau�", 8);
		Publicacao revista2 = new Revista("inteligencia artificial aplicada", 2023, "Amora",10);

		Publicacao artigo = new Artigo("Um comparativo de desempenho entre Java e Python", 2021, "Silva", 4);
		Publicacao artigo2 = new Artigo("Um comparativo entre o Eclipse e VsCode", 2023, "Cordeiro", 5);
			
		
		Biblioteca bib= new Biblioteca();
/*		Emprestimo e1= new Emprestimo(aluno, artigo);
		Emprestimo e2= new Emprestimo(aluno, artigo2);
		Emprestimo e3= new Emprestimo(aluno, revista);
		Emprestimo e4= new Emprestimo(aluno, livro);
		Emprestimo e5= new Emprestimo(aluno, livro2);
		Emprestimo e6= new Emprestimo(aluno, revista2);*/
		
		bib.addPublicacao(artigo);
		bib.addPublicacao(artigo2);
		bib.addPublicacao(revista);
		bib.addPublicacao(livro);
		bib.addPublicacao(livro2);
		
		bib.cadastrarCliente(aluno);
		bib.cadastrarCliente(aluno2);
		bib.cadastrarCliente(professor);
		bib.cadastrarCliente(professor2);
		bib.cadastrarCliente(servidor2);
		
		bib.addEmprestimo(aluno, artigo);
	
		
		System.out.println(aluno.tps);
		//System.out.println(bib.pesquisarPublicacao("Java como programa"));
		//System.out.println(bib.retornarTodosDadosEmprestimo());
		
		//System.out.println(bib.retornarClientesCadastrados());
	//	System.out.println(bib.retornarAcervoDaBiblioteca());
		
		System.out.println(bib.pesquisarCliente(2525));
		System.out.println(bib.retornarAcervoDaBiblioteca());
		
/*		Emprestimo e2= new Emprestimo(professor, revista);
		Emprestimo e3= new Emprestimo(servidor, revista2);
		
		bib.addEmprestimo(e1);
		System.out.println(e1.retornarDadosEmprestimo());
		bib.addEmprestimo(e2);
		System.out.println(e2.retornarDadosEmprestimo());
	
		bib.addEmprestimo(e3);
		System.out.println(e3.retornarDadosEmprestimo());
		*/
		
		
	
	}

}
