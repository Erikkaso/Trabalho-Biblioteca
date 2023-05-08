package controlador;

public abstract class Cliente implements ValidacaoEmprestimo{

	protected  int matricula;
	protected String nome;
	protected int tps;
	protected String tipo;
	protected int quantidadeEmprestimo;
	protected int id;//identificar se é aluno=1 professor=2 ou servidor=3
	
	public Cliente(int matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.tps=0;
	}
	
	
}
