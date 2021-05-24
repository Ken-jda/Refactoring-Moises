package m5.uf2.refactoring.moises;

public class Vehicle {

    final static String BASIC="Basic";
    final static String GENERAL="General";
    final static String LUXE="Luxe";

    private String model;
    private String marca;
    private String categoria;

    public Vehicle(String model, String marca, String categoria) {
        this.model = model;
        this.marca = marca;
        this.categoria = categoria;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
