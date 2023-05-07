package controlador;

public class Aluno extends Cliente {
	
	
	
	public Aluno(int matricula, String nome) {
		super(matricula, nome);
		this.tipo="Aluno";
		super.quantidadeEmprestimo = 5;
		super.id = 1;
	}

	public int verificarDias() {
		return 10;
	}
	
	public int quantidadeDeTP() {
		return 10;
	}

}
