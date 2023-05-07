package controlador;

public class Professor extends Cliente {

	
	public Professor(int matricula, String nome) {
		super(matricula, nome);
		this.tipo="Professor";
		super.quantidadeEmprestimo = 10;
		super.id =2;
	}

	public int verificarDias() {
		return 20;
	}

	public int quantidadeDeTP() {
		return 25;
	}
}
