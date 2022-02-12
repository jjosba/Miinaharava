package Miinaharava;

import java.util.ArrayList;
import java.util.Scanner;

public class Peli {

	public static void main(String[] args) {
		Pelilauta lauta = new Pelilauta();
		ArrayList<Tuple> siirrot = new ArrayList<>();
		Scanner lukija = new Scanner(System.in);
		
		System.out.println("Heippa! Tervetuloa pelaamaan Miinaharavaa! :)\n");
		
		System.out.print("Haluatko lukea peliohjeet? (k = kyll� / e = ei) ");
		String ohjeistus = lukija.nextLine();
		tulostaOhjeet(ohjeistus);
		
		lauta.tulostaLauta();
		
		boolean pelataan = true;
		
		while (pelataan) {
			Tuple siirto = pelaajanSiirto();
			pelataan = onMiina(siirto, lauta);
		}
		

	}
	
	public static Tuple pelaajanSiirto() {
		Scanner lukija = new Scanner(System.in);
		
		System.out.print("Siirto: ");
		
		String siirto = lukija.nextLine();
		
		int sarake = Integer.valueOf(siirto.substring(1)) - 1;
		String rivit = "ABCDEFGHIJKLMNOP";
		int rivi = rivit.indexOf(siirto.substring(0,1));
		Tuple koord = new Tuple(rivi,sarake);
		return koord;
	}
	
	public static boolean onMiina(Tuple koordinaatit, Pelilauta lauta) {
		Object[][] pelilauta = lauta.getPelilauta();
		if (pelilauta[koordinaatit.getRivi()][koordinaatit.getSolu()].equals("Q")) {
			System.out.println("Osuit miinaan. Peli loppui.");
			return false;
		}else {
			return true;
		}
	}
	
	public static void tulostaOhjeet(String ohjeistus) {
		if (ohjeistus.equals("k")) {
			System.out.println("\n"
					+ "Miinaharavassa on tavoitteena paljastaa pelilaudalta kaikki miinattomat ruudut.\n"
					+ "Laudan koko on 16 x 16 ja laudalta l�ytyy 40 miinaa.\n"
					+ "Miinattomissa ruuduissa n�kyy numero, joka kertoo, montako miinaa sen naapuriruuduista l�ytyy.\n"
					+ "Numeroita apuna k�ytt�en pelaaja voi p��tell�, miss� ruuduissa miinat sijaitsevat.\n"
					+ "Ruutuja valitsemalla pelaaja paljastaa uusia ruutuja pelilaudalta.\n"
					+ "Ruudun valinta tapahtuu sy�tt�m�ll� koordinaatit muodossa: rivi, sarake.\n"
					+ "Jos pelaaja valitsee ruudun, jossa on miina, peli p��ttyy.\n"
					+ "Muuten laudalta paljastuu uusia ruutuja.\n"
					+ "Pelaaja voi my�s liputtaa ('P') ruutuja, joita h�n pit�� varmasti miinattomina.\n"
					+ "Kun kaikki miinattomat ruudut on paljastettu tai liputettu, peli p��ttyy voittoon.\n");
		}else {
			System.out.println("\nOhjeita ei tulostettu.\n");
		}System.out.println("Aloitetaan peli!\n");
	}
}
