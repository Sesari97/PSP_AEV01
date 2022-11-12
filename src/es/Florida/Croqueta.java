package es.Florida;

public class Croqueta {
	
private int unidades, tiempoFabricacion, totalCroquetas;
private String tipo;

	/**
	 * Constructor para crear objetos Croqueta que contienen el tipo de croqueta, las unidades y el tiempo de fabricacion
	 * @param unidades
	 * @param tipo
	 * @param tiempoFabricacion
	 * @param totalCroquetas
	 */
	Croqueta(int unidades, String tipo, int tiempoFabricacion, int totalCroquetas){
		this.unidades = unidades;
		this.tipo = tipo;
		this.tiempoFabricacion = tiempoFabricacion;
		this.totalCroquetas = totalCroquetas;
	}
	
	public int getUnidades() {
		return unidades;
	}
	
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getTiempoFabricacion() {
		return tiempoFabricacion;
	}
	
	public void setTiempoFabricacion(int tiempoFabricacion) {
		this.tiempoFabricacion = tiempoFabricacion;
	}
	
	public int getTotalCroquetas() {
		return totalCroquetas;
	}
	
	public void setTotalCroquetas(int totalCroquetas) {
		this.totalCroquetas = totalCroquetas;
	}
}
