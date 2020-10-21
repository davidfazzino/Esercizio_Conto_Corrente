package banca.domain;

import banca.domain.*;

public class Cliente {
  // Campi del Oggetto
  private String nome; 
  private String cognome; 
  private int eta; 
  private int id; 
  // Quando referenziamo un enumatore dobbiamo utilizzare il nome dell'enumeratore
  private Sesso sesso;   
  // La mappa serve a fare delle associazioni chiave -> valore per ottenere i dati nella mappa tramite una chiave;
  private Map<Integer, ContoCorrente> conti;

  public Cliente ( int id, String nome, String cognome, int eta, Sesso sesso ) {
    this.id = id;
    this.nome = nome; 
    this.cognome = cognome; 
    this.eta = eta;
    this.sesso = sesso; 
    conti = new HashMap<Integer,ContoCorrente>(); 
  }

  public void aggiungiConto ( ContoCorrente c ) {
    c.setCliente(this); // Utilizzando la keyword this sto chiamando l'oggetto su cui sto lavorando in questo momento
    conti.put(c.getId(), c);
  }

  public void rimuoviConto ( int id_conto ) {
    conti.remove(id_conto);
  }




}