package controlador;

public class Emprestimo {

	public Cliente cliente;
	public Publicacao publicacao;

	public String Professor = "Professor: ";
	public String Aluno = "Aluno: ";
	public String Servidor = "Servidor: ";

	public Emprestimo(Cliente cliente, Publicacao publicacao) {
		this.cliente = cliente;
		this.publicacao = publicacao;
		this.publicacao.matriculaReservada = this.cliente.matricula;
		if (cliente.id == 1)//registrar no emprestimo que tipo o cliente eh
			Aluno += "" + cliente.nome + " ";

		if (cliente.id == 2)
			Professor += "" + cliente.nome + " ";

		if (cliente.id == 3)
			Servidor += "" + cliente.nome + " ";
	}

}
