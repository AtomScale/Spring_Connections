package MongoDB_Objects.Oggetti;

import java.util.ArrayList;

public class Modello {
    private Integer id_modello;
    private String nome_modello;
    private ArrayList<String> attributi;

    public Modello(Integer id_modello, String nome_modello, ArrayList attributi) {
        this.id_modello = id_modello;
        this.nome_modello = nome_modello;
        this.attributi = attributi;
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

    public String getNome_modello() {
        return nome_modello;
    }
    public void setNome_modello(String nome) {
        this.nome_modello = nome;
    }
 
}
