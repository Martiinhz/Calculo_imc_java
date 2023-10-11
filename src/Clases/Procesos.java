package Clases;

public class Procesos {

	public double calcularIMC(double estatura, double peso) {
	        
		return peso / (estatura * estatura);
	    }

	public String evaluarIMC(double imc) {
		String resultado = "";
	        if (imc < 18.5) {
	            resultado = "Bajo peso";
	        } else if (imc >= 18.5 && imc < 24.9) {
	            resultado = "Peso saludable";
	        } else if (imc >= 25 && imc < 29.9) {
	            resultado = "Sobrepeso";
	        } else {
	            resultado = "Obeso";
	        }
	        return resultado;
	    }
	}
