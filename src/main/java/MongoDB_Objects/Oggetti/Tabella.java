package MongoDB_Objects.Oggetti;

import java.util.ArrayList;

public class Tabella {
    private Integer id_tabella;
    private String username_utente;
    private Integer id_modelloTabella;
    private ArrayList<String> tabella;

    public Tabella(Integer id_tabella,String username_utente, Integer id_modelloTabella, ArrayList tabella) {
        this.id_tabella = id_tabella;
        this.username_utente = username_utente;
        this.id_modelloTabella = id_modelloTabella;
        this.tabella = tabella;
    }

    public Tabella() {
    }

    public Integer getId_tabella(){ return this.id_tabella; }
    public void setId_tabella(Integer id_tabella) {
        this.id_tabella = id_tabella;
    }

    public String getUsername_utente() {
        return this.username_utente;
    }
    public void setUsername_utente(String username_utente) {
        this.username_utente = username_utente;
    }

    public Integer getId_modelloTabella(){ return this.id_modelloTabella; }
    public void setId_modelloTabella(Integer id_modelloTabella) {
        this.id_modelloTabella = id_modelloTabella;
    }

    public ArrayList<String> getTabella() {
        return this.tabella;
    }
    public void setTabella(ArrayList<String> tabella) {
        this.tabella = tabella;
    }

    public String toString(){
        return "Id:"+this.getId_tabella()+" user:"+this.getUsername_utente()+" modello:"+this.getId_modelloTabella()+" tabella:"+this.getTabella();
    }
}
