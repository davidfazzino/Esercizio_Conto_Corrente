package banca.ui;

//import java.util.Scanner;

//import banca.domain.Banca;
//import banca.domain.Cliente;
import banca.domain.exception.SaldoInsufficenteException;

public class BankInterface {
	
	public static void main(String[] args) {
		BankMenu menu = new BankMenu();
		try {
			menu.stampaMenu();
		} catch (SaldoInsufficenteException e) {
			e.getMessage();
		}
		
	}
	

}
