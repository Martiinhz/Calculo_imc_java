package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Clases.Procesos;

public class Ventana extends JFrame implements ActionListener{

	JPanel Panel;
	JLabel titulo,nombre,estatura,peso,resultado;
	JTextField campo1,campo2,campo3;
	JButton boton,boton2;
	
	Procesos MisProcesos;
	public Ventana() {
		MisProcesos = new Procesos();
		setTitle("Calculadora");
		setSize(600,400);
		setLocationRelativeTo(null);
		IniciarComponentes();
	}
	
	public void IniciarComponentes() {
		Panel = new JPanel();
		Panel.setLayout(null);
		Panel.setBackground(Color.pink);
		
		titulo = new JLabel();
		titulo.setText("SISTEMA DE IMC");
		titulo.setBounds(160, 30, 600, 60);
		titulo.setFont(new Font("Robot",Font.BOLD,30));
		
		nombre = new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(260, 20, 50, 200);
		
		campo1 = new JTextField();
		campo1.setBounds(210, 130, 160, 30);
		
		estatura = new JLabel();
		estatura.setText("Estatura:Metros");
		estatura.setBounds(100, 180, 200, 30);
		
		campo2 = new JTextField();
		campo2.setBounds(100, 202, 100, 30);
		
		peso= new JLabel();
		peso.setText("Peso:Kilogramos");
		peso.setBounds(380, 180, 200, 30);
		
		campo3 = new JTextField();
		campo3.setBounds(380, 202, 100, 30);
		
		resultado= new JLabel();
		resultado.setText("Su imc es:");
		resultado.setBounds(30,320 , 600, 30);
		
		boton = new JButton();
		boton.setText("Calcular");
		boton.setBounds(100, 280, 150, 30);
		boton.addActionListener(this);
		
		boton2 = new JButton();
		boton2.setText("Limpiar");
		boton2.setBounds(330, 280, 150, 30);
		boton2.addActionListener(this);
		
		
		add(resultado);
		add(boton2);
		add(boton);
		add(campo3);
		add(peso);
		add(campo2);
		add(estatura);
		add(campo1);
		add(nombre);
		add(titulo);
		add(Panel);
	}
	
	public void calcular() {
		String nombre=campo1.getText();
		double estatura=Double.parseDouble(campo2.getText());
		double peso=Double.parseDouble(campo3.getText());
		
	    double imc = MisProcesos.calcularIMC(estatura, peso);
	    String resultadoIMC = MisProcesos.evaluarIMC(imc);
	    
	    if(imc < 18.5) {
            resultado.setText("Hola "+nombre+ "Su imc es: "+imc+ " Usted esta en bajo peso");
            resultado.setForeground(Color.blue);
        } else if (imc >= 18.5 && imc < 24.9) {
        	resultado.setText("Hola "+nombre+ "Su imc es: "+imc+ " Usted esta en peso saludable");
        	resultado.setForeground(Color.blue);
        } else if (imc >= 25 && imc < 29.9) {
        	resultado.setText("Hola "+nombre+ "Su imc es: "+imc+ " Usted esta en sobre peso");
        	resultado.setForeground(Color.blue);
        } else {
        	resultado.setText("Hola "+nombre+ "Su imc es: "+imc+ " Usted esta obeso");
        	resultado.setForeground(Color.blue);
        }
	    
	    resultado.setBackground(Color.black);
		}
	
	
	
	public void Limpiar() {
		campo1.setText("");
		campo2.setText("");
		campo3.setText("");
		resultado.setText("Su imc es:");
		resultado.setBackground(Color.black);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton) {
			System.out.println("Calculando");
			calcular();
		}else if(e.getSource()==boton2) {
			System.out.println("Limpiar");
			Limpiar();
		}
		
	}
	
	
		
}
