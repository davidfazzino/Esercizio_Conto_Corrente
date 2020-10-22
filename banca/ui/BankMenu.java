package banca.ui;
import java.util.Scanner;

import banca.domain.Banca;
//import banca.domain.Cliente;
import banca.domain.exception.SaldoInsufficenteException;

public class BankMenu {
	private Banca b = Banca.getInstance();
	private boolean flag = true;
	private Scanner input= new Scanner(System.in);
	
	public void stampaMenu() throws SaldoInsufficenteException {
		
		do {
			System.out.println("Inserisci il tuo idCliente: ");
			int idCliente=input.nextInt();
			if (b.getClientById(idCliente)!=null) {
				System.out.println("Benvenuto in banca Java. Scegli l'operazione da fare:");
				StringBuilder sb = new StringBuilder();
				sb.append("1 - Bonifico ").append(System.lineSeparator())
				 .append("2 - Prelievo ").append(System.lineSeparator())
				 .append("3 - Versamento ").append(System.lineSeparator())
				 .append("4 - Saldo ").append(System.lineSeparator())
				 .append("5 - Lista utenti").append(System.lineSeparator())
				 .append("6 - Termina il programma").append(System.lineSeparator());
				
				System.out.println(sb);
				scelta(input.nextInt(), idCliente);
			}
			
		}while (flag);

	}
	
	public void scelta ( int scelta, int idCliente ) throws SaldoInsufficenteException {
		switch (scelta) {
			case 1: {
				StringBuilder sb=new StringBuilder("Scegli  il conto dal quale effettuare il bonifico \n")
					.append(b.getClientById(idCliente)).append(System.lineSeparator());
				System.out.println(sb);
				int idConto=input.nextInt();
				while (b.getClientById(idCliente).getContoById(idConto)==null) {
					System.out.println(sb);
					idConto=input.nextInt();
				}
				System.out.println("Inserisci l'id del destinatario , l'id del suo conto e l'importo");
				int idDestinatario=input.nextInt();
				int idContoDestinatario=input.nextInt();
				double amount=input.nextDouble();
				if(b.getClientById(idDestinatario).getContoById(idContoDestinatario)!= null) {
					//b.Bonifica(amount, idConto, idCliente, idContoDestinatario, idDestinatario);
					b.Bonifica(amount, idConto, idCliente, idContoDestinatario, idDestinatario);
					
					//System.out.println("Il saldo del destinatario � di : " + b.getClientById(idDestinatario).getContoById(idContoDestinatario).getSaldo());
					System.out.println("Il tuo saldo attuale �: " + b.getClientById(idCliente).getContoById(idConto).getSaldo()); 
				}else {
					System.out.println("dati errati. Ciao");
				}
				
				
				
			} break;
			
			case 2:{
				StringBuilder sb=new StringBuilder("Scegli il conto dal quale prelevare \n")
						.append(b.getClientById(idCliente)).append(System.lineSeparator());
				System.out.println(sb);
				int idConto=input.nextInt();
				System.out.println("Quanto vuoi prelevare?");
				b.preleva(input.nextDouble(), idCliente, idConto);
				System.out.println("Il tuo saldo attuale �: "+ b.getClientById(idCliente).getContoById(idConto).getSaldo());
			} break;
			
			case 3:{
				StringBuilder sb=new StringBuilder("Scegli il conto in cui versare \n")
						.append(b.getClientById(idCliente)).append(System.lineSeparator());
				System.out.println(sb);
				int idConto=input.nextInt();
				System.out.println("Quanto vuoi versare?");
				b.Deposita(input.nextDouble(), idConto, idCliente);
				System.out.println("Il tuo saldo attuale �: "+ b.getClientById(idCliente).getContoById(idConto).getSaldo());
			} break;
			
			case 4:{
				
			} break;
			
			case 5:{
				
			} break;
			
			case 6:{
				System.out.println("Termine programma \nA presto!");
				flag=false;
			} break;
			
			default: System.out.println("Numero non valido!");
		}
		
	}
}
