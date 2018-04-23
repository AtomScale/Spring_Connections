package MongoDB_Objects.Dao;

import MongoDB_Objects.Oggetti.Utente;

import java.util.HashMap;

public interface Utente_Dao {
    boolean inserisciUtente(Utente utente);

    boolean eliminaUtente(String username);

    boolean setUtente(Utente utente);

    Utente getUtente(String username);

    HashMap<String,Utente> utentiCollection();
}
