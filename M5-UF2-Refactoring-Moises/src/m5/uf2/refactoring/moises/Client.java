package m5.uf2.refactoring.moises;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Client {
    private static final double EUROS_PER_UNITAT_DE_COST = 30;
    private String nif;
    private String nom;
    private String telefon;
    private List<Lloguer> lloguers;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new ArrayList<Lloguer>();
    }

    public List<Lloguer> getLloguers() {
        return lloguers;
    }
    
    public String getNif()     { return nif;     }
    public String getNom()     { return nom;     }
    public String getTelefon() { return telefon; }

    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void afegeix(Lloguer lloguer) {
        if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }

    public String informe() {
        return composaCapsalera() + composaDetall() + composaPeu();
    }

    public int importTotal() {
        int total = 0;
        for (Lloguer lloguer: lloguers) {
            total += lloguer.quantitat() * EUROS_PER_UNITAT_DE_COST;
        }
        return total;
    }

    private int bonificacionsTotals() {
        int total = 0;
        for (Lloguer lloguer: lloguers) {
            total += lloguer.bonificacions();
        }
        return total;
    }

    private String composaCapsalera() {
        return "Informe de lloguers del client " + getNom() + " (" + getNif() + ")\n";
    }

    private String composaDetall() {
        String resultat="";
        for (Lloguer lloguer: lloguers) {
        // composa els resultats d'aquest lloguer
        resultat +=  "\t" + lloguer.getVehicle().getMarca() + " " + lloguer.getVehicle().getModel() + ": " +
            (lloguer.quantitat() * EUROS_PER_UNITAT_DE_COST) + "€" + "\n";
        }
        return resultat;
    }

    private String composaPeu() {
    // afegeix informació final
        return "Import a pagar: " + importTotal() + "€\n" +
            "Punts guanyats: " + bonificacionsTotals() + "\n";
    }
}