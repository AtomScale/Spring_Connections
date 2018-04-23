package MongoDB_Objects.Dao;

import MongoDB_Objects.Oggetti.Modello;

import java.util.HashMap;

public interface Modello_Dao {
    boolean inserisciModello(Modello modello);

    boolean eliminaModello(Integer id_modello);

    boolean setModello(Modello modello);

    Modello getModello(Integer id_modello);

    HashMap<Integer,Modello> modelliCollection();
}
