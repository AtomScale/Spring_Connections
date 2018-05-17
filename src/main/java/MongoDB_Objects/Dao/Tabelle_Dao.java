package MongoDB_Objects.Dao;

import MongoDB_Objects.Oggetti.Tabella;

import java.util.ArrayList;
import java.util.HashMap;

public interface Tabelle_Dao {
    boolean inserisciTabella(Tabella tabella);

    boolean eliminaTabella(Integer id_tabella);

    boolean setTabella(Tabella tabella);

    Tabella getTabella(Integer id_tabella);

    HashMap<Integer,Tabella> tabelleCollection();

    //public ArrayList<String> id_tabelle_utenteSpecifico(String username);
}
