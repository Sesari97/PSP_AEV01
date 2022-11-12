package es.Florida;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Lanzadera {

	private JFrame frame;
	private JTextField numeroJamon;
	private JTextField numeroPollo;
	private JTextField numeroBacalao;
	private JTextField numeroQueso;
	private JTextField prioridadQuesoInput;
	private JTextField prioridadJamonInput;
	private JTextField prioridadPolloInput;
	private JTextField prioridadBacalaoInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lanzadera window = new Lanzadera();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lanzadera() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Croquetas de Jamón");
		lblNewLabel.setBounds(10, 39, 162, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCroquetasDePollo = new JLabel("Croquetas de Pollo");
		lblCroquetasDePollo.setBounds(10, 74, 162, 14);
		frame.getContentPane().add(lblCroquetasDePollo);
		
		JLabel lblCroquetasDeBacalao = new JLabel("Croquetas de Bacalao");
		lblCroquetasDeBacalao.setBounds(10, 110, 162, 14);
		frame.getContentPane().add(lblCroquetasDeBacalao);
		
		JLabel lblCroquetasDeQueso = new JLabel("Croquetas de Queso");
		lblCroquetasDeQueso.setBounds(10, 146, 162, 14);
		frame.getContentPane().add(lblCroquetasDeQueso);
		
		numeroJamon = new JTextField();
		numeroJamon.setBounds(182, 36, 100, 20);
		frame.getContentPane().add(numeroJamon);
		numeroJamon.setColumns(10);
		
		numeroPollo = new JTextField();
		numeroPollo.setColumns(10);
		numeroPollo.setBounds(182, 68, 100, 20);
		frame.getContentPane().add(numeroPollo);
		
		numeroBacalao = new JTextField();
		numeroBacalao.setColumns(10);
		numeroBacalao.setBounds(182, 107, 100, 20);
		frame.getContentPane().add(numeroBacalao);
		
		numeroQueso = new JTextField();
		numeroQueso.setColumns(10);
		numeroQueso.setBounds(182, 143, 100, 20);
		frame.getContentPane().add(numeroQueso);
		
		JButton btnPedido = new JButton("Hacer pedido");
		btnPedido.setBounds(149, 227, 132, 23);
		frame.getContentPane().add(btnPedido);
		
		JLabel labelPrioridad = new JLabel("Prioridad");
		labelPrioridad.setBounds(338, 11, 86, 14);
		frame.getContentPane().add(labelPrioridad);
		
		prioridadQuesoInput = new JTextField();
		prioridadQuesoInput.setBounds(324, 143, 86, 20);
		frame.getContentPane().add(prioridadQuesoInput);
		prioridadQuesoInput.setColumns(10);
		
		prioridadJamonInput = new JTextField();
		prioridadJamonInput.setColumns(10);
		prioridadJamonInput.setBounds(324, 36, 86, 20);
		frame.getContentPane().add(prioridadJamonInput);
		
		prioridadPolloInput = new JTextField();
		prioridadPolloInput.setColumns(10);
		prioridadPolloInput.setBounds(324, 71, 86, 20);
		frame.getContentPane().add(prioridadPolloInput);
		
		prioridadBacalaoInput = new JTextField();
		prioridadBacalaoInput.setColumns(10);
		prioridadBacalaoInput.setBounds(324, 107, 86, 20);
		frame.getContentPane().add(prioridadBacalaoInput);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(205, 11, 79, 14);
		frame.getContentPane().add(lblCantidad);
		
		// Boton Hacer Pedido
		btnPedido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String jamon = numeroJamon.getText();
				String pollo = numeroPollo.getText();
				String bacalao = numeroBacalao.getText();
				String queso = numeroQueso.getText();
				String prioridadJamon = prioridadJamonInput.getText();
				String prioridadPollo = prioridadPolloInput.getText();
				String prioridadBacalao = prioridadBacalaoInput.getText();
				String prioridadQueso = prioridadQuesoInput.getText();

				crearPedido(frame, jamon, pollo, bacalao, queso, prioridadJamon, prioridadPollo, prioridadBacalao, prioridadQueso);					
			}
		});
	}
	
	
	/**
	 * Metodo para crear pedido utilizando la comunicacion entre procesos.
	 * Apunta a la clase Procesadora utilizando un objeto ProcessBuilder.
	 * @param panel
	 * @param jamon
	 * @param pollo
	 * @param bacalao
	 * @param queso
	 * @param prioridadJamon
	 * @param prioridadPollo
	 * @param prioridadBacalao
	 * @param prioridadQueso
	 */
	private void crearPedido(JFrame panel, String jamon, String pollo, String bacalao, String queso, 
			String prioridadJamon, String prioridadPollo, String prioridadBacalao, String prioridadQueso) {
		
		if(comprobarPedido(jamon, pollo, bacalao, queso)) {			
			String clase = "es.Florida.Procesadora";
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;
			ArrayList<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(jamon);
			command.add(pollo);
			command.add(bacalao);
			command.add(queso);
			command.add(prioridadJamon);
			command.add(prioridadPollo);
			command.add(prioridadBacalao);
			command.add(prioridadQueso);
			ProcessBuilder builder = new ProcessBuilder(command);
			try {
				builder.inheritIO().start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(panel, "Las croquetas se deben pedir de 6 en 6");
		}
	}
	
	/**
	 * Metodo para asegurarse de que las unidades en los pedidos de cada tipo de croqueta son multiplos de 6
	 * Se evita que existan cajas de croquetas con espacios vacios
	 * @param jamon
	 * @param pollo
	 * @param bacalao
	 * @param queso
	 * @return true si las unidades son multiplos de 6
	 */
	private boolean comprobarPedido(String jamon, String pollo, String bacalao, String queso) {
		
		if (Integer.valueOf(jamon)%6 != 0 || Integer.valueOf(pollo)%6 != 0 || Integer.valueOf(bacalao)%6 != 0 
				|| Integer.valueOf(queso)%6 != 0) {
			return false;
		} else {
			return true;
		}
	}
}
