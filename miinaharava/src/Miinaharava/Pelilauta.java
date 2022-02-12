package Miinaharava;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Pelilauta {
	Object[][] pelilauta;
	
	public Pelilauta() {
		this.pelilauta = luoPelilauta();
	}
	
	public Object[][] getPelilauta() {
		return this.pelilauta;
	}
	
	public void printtajotain() {
		System.out.println("Osaispa javaa.");
	}
	
	public Object[][] luoPelilauta() {
		Object[][] pelilauta = {{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0},
								{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0},
								{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0},
								{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0},
								{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0},
								{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0},
								{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0},
								{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0},
								{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0},
								{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0},
								{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0},
								{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0},
								{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0},
								{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0},
								{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0},
								{(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0,(int) 0}};
		
		ArrayList<Tuple> miinakoord = new ArrayList<>();
		
		while (miinakoord.size()<41) {
			Tuple miina = luoRandomKoord(); 
			if (!onListassa(miinakoord,miina)) {
				miinakoord.add(miina);
			}	
		}


		//miinat laudalle
		ArrayList<Tuple> vierus = new ArrayList<>();
		for (Tuple pari : miinakoord) {
			int rivi = pari.getRivi();
			int solu = pari.getSolu();
			pelilauta[rivi][solu] = "Q";
			
			Tuple yv = new Tuple(rivi-1, solu-1);
			Tuple yk = new Tuple(rivi-1, solu);
			Tuple yo = new Tuple(rivi-1, solu+1);
			Tuple vv = new Tuple(rivi, solu-1);
			Tuple vo = new Tuple(rivi, solu+1);
			Tuple av = new Tuple(rivi+1, solu-1);
			Tuple ak = new Tuple(rivi+1, solu);
			Tuple ao = new Tuple(rivi+1, solu+1);
			
			vierus.add(yv);
			vierus.add(yk);
			vierus.add(yo);
			vierus.add(vv);
			vierus.add(vo);
			vierus.add(av);
			vierus.add(ak);
			vierus.add(ao);
			
		}
				
		for (Tuple k : vierus) {
			if (!(k.getRivi()<0) && k.getRivi()<16) {
				if (!(k.getSolu()<0) && k.getSolu()<16) {
					if (pelilauta[k.getRivi()][k.getSolu()] instanceof Integer) {
						pelilauta[k.getRivi()][k.getSolu()] = (int) pelilauta[k.getRivi()][k.getSolu()] + 1;
					}
				}
			}
		}
		
		return pelilauta;
	}

	
	public void tulostaLauta() {
		System.out.println("    1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16");
		String kerros = "ABCDEFGHIJKLMNOP";
		int kirjain = 0;
		for (Object[] rivi : this.pelilauta) {
			System.out.print(kerros.substring(kirjain, kirjain+1) + " ");
			kirjain++;
			System.out.print("| ");
			for (Object solu : rivi) {
				System.out.print(solu);
				System.out.print(" | ");
			}
			System.out.println();
		}
	}
	
	
	
	public boolean onListassa(ArrayList<Tuple> lista, Tuple koordinaatit) {
		if (lista.contains(koordinaatit)) {
			return true;
		}else {
			return false;
		}
	}
	
	public Tuple luoRandomKoord() {
		int randomRivi = ThreadLocalRandom.current().nextInt(0, 16); 
		int randomSolu = ThreadLocalRandom.current().nextInt(0, 16);
		Tuple koordinaatit = new Tuple(randomRivi,randomSolu);
		return koordinaatit;
	}

}
