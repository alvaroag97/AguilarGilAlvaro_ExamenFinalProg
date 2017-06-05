package Models;

import java.util.Date;

public class Coche {

	private String Matricula;
	private Date Entrada;
	private Date Salida;
	
	public Coche(String matricula) {
		super();
		setMatricula(matricula);
	}

	public Coche(String matricula, Date entrada) {
		super();
		setMatricula(matricula);
		setEntrada(entrada);
	
	}
	

	public Coche(Date salida) {
		super();
	
		setSalida(salida);
	}

	public String getMatricula() {
		return Matricula;
	}

	public void setMatricula(String matricula) {
		Matricula = matricula;
	}

	public Date getEntrada() {
		return Entrada;
	}

	public void setEntrada(Date entrada) {
		Entrada = entrada;
	}

	public Date getSalida() {
		return Salida;
	}

	public void setSalida(Date salida) {
		Salida = salida;
	}
	
	
	
	
}
