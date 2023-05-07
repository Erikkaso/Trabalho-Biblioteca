package controlador;

public class Servidor extends Cliente {

	
	public Servidor(int matricula, String nome) {
		super(matricula, nome);
		this.tipo="Servidor";
		super.quantidadeEmprestimo = 7;
		super.id =3;
		
	}

	public int verificarDias() {
		return 15;
	}

	public int quantidadeDeTP() {
		return 15;
	}
}
