package es.Florida;

public class HiloCroqueta implements Runnable {
	
	private Croqueta croqueta;
	private String tipo;
	private int tiempoFabricacion, unidades, totalCroquetas;
	
	
	/**
	 * Constructor para crear objetos HiloCroqueta que contienen un objeto Croqueta
	 * @param croqueta
	 */
	HiloCroqueta(Croqueta croqueta){
		this.croqueta = croqueta;
	}
	
	/**
	 * Metodo para crear hilos que gestionan la fabricacion de croquetas
	 * Muestra por consola los hitos de fabricacion
	 */
	void fabricarCroqueta() {
		boolean hayTrabajo = true;
		while (hayTrabajo) {
			synchronized (croqueta) {
				if(croqueta.getUnidades() > 0) {
					System.out.println("Croqueta " + croqueta.getTipo() + " empezada (quedan " + croqueta.getUnidades() + " croquetas)");
					try {
						Thread.sleep(croqueta.getTiempoFabricacion());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					croqueta.setUnidades(croqueta.getUnidades() -1);
					croqueta.setTotalCroquetas(croqueta.getTotalCroquetas() - 1);
					System.out.println("Croqueta " + croqueta.getTipo() + " finalizada (quedan " + croqueta.getUnidades() + " croquetas)");
				}else {
					System.out.println("Ya no quedan croquetas de  " + croqueta.getTipo() + " por fabricar.");
					hayTrabajo = false;
				}
				System.out.println("Ya no quedan croquetas de  " + croqueta.getTipo() + " por fabricar.");
			}
		}
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	/**
	 * Lanza los hilos de fabricacion de croquetas
	 */
	@Override
	public void run() {
		fabricarCroqueta();
	}

}
