package controlador;

public abstract class Cliente implements ValidacaoEmprestimo{

	protected  int matricula;
	protected String nome;
	protected int tps;
	protected String tipo;
	public int quantidadeEmprestimo;
	public int id;
	public boolean cadastado;
	
	public Cliente(int matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.tps=0;
		this.cadastado = false;
	}
	
	
}
