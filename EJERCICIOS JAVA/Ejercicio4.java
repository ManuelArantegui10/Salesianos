package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase recopila el algoritmo de resoluciÃ³n del ejercicio 1
 * del documento "Ejercicios Ficheros de texto 4".
 * 
 * @author Ã�lvaro Juan Ciriaco
 */
public class Ejercicio4 {
	
	/**
	 * Pre: [nombreFichero] almacena el path+nombre del fichero a analizar. 
	 * 		[pares] contiene las palabras a buscar en dicho fichero.
	 * Post: dado un fichero y una lista de palabras a buscar muestra por pantalla
	 * 		el nÃºmero de ocurrencias de cada una de estas en el fichero.
	 */
	private static void obtenerOcurrencias(String nombreFichero, ArrayList<Par> pares) {
		try {
			/*
			 * Creamos el objeto de clase Scanner para poder leer la informaciÃ³n
			 * del fichero.
			 */
			Scanner f = new Scanner(new File(nombreFichero));
			/*
			 * Como hacemos siempre, recorremos el fichero lÃ­nea por lÃ­nea
			 * para asÃ­ poder analizar todas sus palabras
			 */
			while(f.hasNextLine()) {
				/*
				 * Cada una de estas lÃ­neas la cogemos y lo primero que hacemos es eliminar
				 * todos los signos de puntuaciÃ³n, para tener asÃ­ TODAS LAS PALABRAS 
				 * del fichero separadas por espacios, sin tener "," o ";" que nos molesten.
				 * AdemÃ¡s, transformo todas las palabras a minÃºscula para no tener problemas
				 * a la hora de compararlas.
				 */
				String linea = f.nextLine().replace(",", "").
						replace(";", "").replace("\\.", "").toLowerCase().trim();
				/*
				 * Como tengo todas las palabras de la lÃ­nea separadas por espacios, ahora puedo
				 * crear una tabla donde en cada una de las celdas esten una Ãºnica palabra.
				 */
				String[] lineaSeparada = linea.split(" ");
				/*
				 * Recorro todas las palabras de la lÃ­nea y las comparo con las palabras almacenadas
				 * en la lista de pares. Si la palabra de la lÃ­nea estÃ¡ incluÃ­da dentro de la lista
				 * de pares, entonces aumento en 1 el nÃºmero de ocurrencias.
				 */
				for(String palabra : lineaSeparada) {
					estaEnPares(pares, palabra);
				}
			}
			/*
			 * Muestro por pantalla las palabras que querÃ­amos buscar y su nÃºmero de ocurrencias.
			 */
			for(Par par : pares) {
				par.mostrarPar();
			}
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + nombreFichero + " no puede ser leÃ­do.");
		}
	}
	
	/**
	 * Pre: [pares] contiene las palabras a buscar en dicho fichero
	 * 		[palabra] contiene la palabra que queremos buscar dentro de [pares].
	 * Post: recorre la lista de pares para comprobar si [palabra] se encuentra
	 * 		dentro de las palabras que queremos comprobar su nÃºmero de ocurrencias. 
	 * 		Si [palabra] se encuentra dentro de [pares], aumentamos en 1 su nÃºmero
	 * 		de ocurrencias.
	 */
	private static void estaEnPares(ArrayList<Par> pares, String palabra) {
		for(Par par : pares) {
			/*
			 * Si coincide, entonces aumento en 1 su nÃºmero de ocurrencias.
			 */
			if(par.getPalabra().equals(palabra)) {
				par.setOcurrencias(par.getOcurrencias() + 1);
			}
		}
	}
	
	/**
	 * Pre: ---
	 * Post: solicita al usuario el path+nombre del fichero a analizar, y posteriormente
	 * 		una lista de palabras separadas por ",". Esta lista contiene las palabras a 
	 * 		buscar su ocurrencia dentro del texto.
	 */
	public static void main(String[] args) {
		System.out.print("Dime el path del fichero a examinar: ");
		Scanner entrada = new Scanner(System.in);
		String nombreFichero = entrada.nextLine();
		System.out.print("Dime la lista de palabras a buscar (separadas por ','): ");
		String palabrasLinea = entrada.nextLine();
		System.out.println("-------------------------------------------------------");
		String[] palabrasTabla = palabrasLinea.split(",");
		/*
		 * Lista que va a almacenar las palabras que buscamos y su nÃºmero
		 * de ocurrencias.
		 */
		ArrayList<Par> pares = new ArrayList<Par>();
		for(int i = 0; i < palabrasTabla.length; i++) {
			/*
			 * Paso todas las palabras a minÃºscula para asÃ­ despues no
			 * tener ningun problema.
			 */
			pares.add(new Par(palabrasTabla[i].toLowerCase().trim()));
		}
		obtenerOcurrencias(nombreFichero, pares);
	}

}
