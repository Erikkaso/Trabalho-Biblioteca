package controlador;

public abstract class Publicacao {

	protected String titulo;
	protected int ano;
	protected String autor;
	protected int quantidadeDisponivel;
	protected String tipo;
	public int matriculaReservada;
	public boolean acessivelNoAcervo;
	
	public Publicacao(String titulo, int ano, String autor, int quantidadeDisponivel) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.autor = autor;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.acessivelNoAcervo = false;
	}
	
	
}
