package Controlador;

import java.util.ArrayList;
import java.util.Date;

import Models.Coche;

public class Controlador {

	private static ArrayList<Coche> ListaCoche = new ArrayList<Coche>();
	public static int indice = 0;

	/**
	 * Añadir la matricula y el vehiculo
	 * @param Matricula
	 * @param Inicio
	 */
	public static void AniadirCoche( String Matricula , Date Inicio){
			ListaCoche.add(new Coche(Matricula , Inicio));
}
	
	public static void AniadirFin( Date Fin){
		ListaCoche.add(new Coche(Fin));
}

	/**
	 * Obtienes el coche
	 * @param indice
	 * @return
	 */
	public static Coche ObtenerCoche(int indice){
		if(ListaCoche.isEmpty()) 
		if(indice < 0 || indice >= ListaCoche.size());
		return ListaCoche.get(indice);
	}
	/**
	 * Obtienes la lista
	 * @return
	 */
	public static ArrayList<Coche> ObtenerLista(){
		return ListaCoche;
	}
	
	
	

}
