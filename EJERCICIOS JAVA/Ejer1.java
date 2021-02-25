package EjerciciosFicheros4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejer1 {

	/**
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		ArrayList<String> manu = new ArrayList<String>();
		System.out.print("Dame la ruta del ficher: ");
		String fichero = ent.nextLine();
		System.out.println("Dime las palabras que quieres buscar separandolas con comas.");
		String palabras = ent.nextLine();
		palabras = palabras.toLowerCase();
		String[] palabrasSeparadas = palabras.split(",");
		//for(int i = 0; i < palabrasSeparadas.length; i++) {
			//System.out.println(palabrasSeparadas[i]);
		//}
		ocurrencias(palabrasSeparadas, fichero);
		
	}
	public static void ocurrencias(String[] palabrasSperadas, String fichero) {
		File file1 = new File(fichero);
		try {
			Scanner f1 = new Scanner(file1);
			ArrayList<String> word = new ArrayList<String>();
			while (f1.hasNextLine()){
				String palabra = f1.nextLine();
				String palabra2 = palabra.toLowerCase();
				//palabra2.replaceAll("\\p{Punt}","");
				palabra2.replace(",", " ");
				palabra2.replace(".", " ");
				palabra2.replace("<<", " ");
				palabra2.replace(">>", " ");
				palabra2.replace("´", " ");
				palabra2.trim();
				word.add(palabra2);
				//System.out.print(palabra2);
			}
			//for(int i = 0; i < word.size(); i++) {
				//System.out.println(word.get(i));
			//}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	//public static void raplace()
}
