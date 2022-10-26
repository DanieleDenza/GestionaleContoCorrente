import java.util.ArrayList;
import java.util.Scanner;

public class Main {
// nel main vado a richiamare il magazzino e il menu per effettuare un collegamento tra entrambi.
	public static void main(String[] args) {
		
        Menu menu = new Menu();
        
		Magazzino magazzino = new Magazzino();
		
		menu.stampaMenu(magazzino);

	}

}