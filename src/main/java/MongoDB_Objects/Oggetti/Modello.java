package MongoDB_Objects.Oggetti;

import java.util.ArrayList;

public class Modello {
    private Integer id_modello;
    private String nome_modello;
    private String username;
    private ArrayList<String> attributi;
    private ArrayList<String> tipiAttributi;

    public Modello(Integer id_modello, String nome_modello, String username, ArrayList attributi, ArrayList tipiAttributi) {
        this.id_modello = id_modello;
        this.nome_modello = nome_modello;
        this.username = username;
        this.attributi = attributi;
        this.tipiAttributi = tipiAttributi;
    }

    public Modello() {
    }

    public Integer getId_modello() {
        return id_modello;
    }
    public void setId_modello(Integer id_modello) {
        this.id_modello = id_modello;
    }

    public ArrayList getAttributi() {
        return attributi;
    }
    public void setAttributi(ArrayList<String> attributi) {
        this.attributi = attributi;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getNome_modello() {
        return nome_modello;
    }
    public void setNome_modello(String nome) {
        this.nome_modello = nome;
    }

    public ArrayList<String> getTipiAttributi() {
        return tipiAttributi;
    }
    public void setTipiAttributi(ArrayList<String> tipiAttributi) {
        this.tipiAttributi = tipiAttributi;
    }
}
