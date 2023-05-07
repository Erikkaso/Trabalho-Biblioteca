package controlador;

public class Emprestimo {

	public Cliente cliente;
	public Publicacao publicacao;

	public Emprestimo(Cliente cliente, Publicacao publicacao) {
		this.cliente = cliente;
		this.publicacao = publicacao;
		this.publicacao.matriculaReservada = this.cliente.matricula;
	}
		
	
/*
	public String retornarDadosEmprestimo() {

		String saida = "";
		saida = this.cliente.tipo+":" + this.cliente.nome + " - " + publicacao.tipo + ": " + this.publicacao.titulo
				+ " - Dias de emprestimo:" + cliente.verificarDias();
		return saida;
	}*/
	
	
}
