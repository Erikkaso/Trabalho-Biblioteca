package controlador;

public abstract class Publicacao {

	protected String titulo;
	protected int ano;
	protected String autor;
	protected int quantidadeDisponivel;
	protected String tipo;
	protected int matriculaReservada;//serve pra salvar a matricula de quem reservou a publicacao
	
	public Publicacao(String titulo, int ano, String autor, int quantidadeDisponivel) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.autor = autor;
		this.quantidadeDisponivel = quantidadeDisponivel;
	}
	
	
}
