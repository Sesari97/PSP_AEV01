package es.Florida;

import java.util.ArrayList;

public class Procesadora {

	public static void main(String[] args) {
		int jamon = Integer.parseInt(args[0]);
		int pollo = Integer.parseInt(args[1]);
		int bacalao = Integer.parseInt(args[2]);
		int queso = Integer.parseInt(args[3]);
		
		int prioridadJamon = Integer.parseInt(args[4]);
		int prioridadPollo = Integer.parseInt(args[5]);
		int prioridadBacalao = Integer.parseInt(args[6]);
		int prioridadQueso = Integer.parseInt(args[7]);
		
		int totalCroquetas = jamon + pollo + bacalao + queso;

		ArrayList<Croqueta> croquetas = new ArrayList<>();
		Croqueta croquetaJamon = new Croqueta(jamon, "Jamon", 5000, totalCroquetas);
		Croqueta croquetaPollo = new Croqueta(pollo, "Pollo", 6000, totalCroquetas);
		Croqueta croquetaBacalao = new Croqueta(bacalao, "Bacalao", 7000, totalCroquetas);
		Croqueta croquetaQueso = new Croqueta(queso, "Queso", 8000, totalCroquetas);
		croquetas.add(croquetaJamon);
		croquetas.add(croquetaPollo);
		croquetas.add(croquetaBacalao);
		croquetas.add(croquetaQueso);
				
		Thread t = null;
		for(int i = 0; i < croquetas.size(); i++) {	
			HiloCroqueta hiloCroqueta = new HiloCroqueta(croquetas.get(i));
			t = new Thread(hiloCroqueta);
			if (croquetas.get(i).getTipo() == "Jamon") {
				t.setPriority(prioridadJamon);
			} else if (croquetas.get(i).getTipo() == "Pollo") {
				t.setPriority(prioridadPollo);
			} else if (croquetas.get(i).getTipo() == "Bacalao") {
				t.setPriority(prioridadBacalao);
			} else if (croquetas.get(i).getTipo() == "Queso") {
				t.setPriority(prioridadQueso);
			}
			t.start();
		}
		
		while (totalCroquetas > 0) {
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
