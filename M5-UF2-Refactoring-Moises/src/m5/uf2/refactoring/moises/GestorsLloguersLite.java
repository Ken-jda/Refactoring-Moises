package m5.uf2.refactoring.moises;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorsLloguersLite {
    public static void main(String[] args) throws ParseException{
        
        Client client = new Client("12345678D", "Ken Miró", "666-666-666");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        
        Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);
        Vehicle vehicleGeneral = new Vehicle("León", "Seat", Vehicle.GENERAL);
        Vehicle vehicleLuxe = new Vehicle("Audi", "GRX", Vehicle.LUXE);
        
        Lloguer lloguerBasic = new Lloguer(dateFormat.parse("2/2/2021"), 1, vehicleBasic);
        Lloguer lloguerGeneral = new Lloguer(dateFormat.parse("3/3/2021"), 3, vehicleGeneral);
        Lloguer lloguerLuxe = new Lloguer(dateFormat.parse("4/4/2012"), 1, vehicleLuxe);
        
        client.afegeix(lloguerBasic);
        client.afegeix(lloguerGeneral);
        client.afegeix(lloguerLuxe);
        
        System.out.println(mostraInformacio(client));
        
        System.out.println(client.informe());

    }
    
    public static String mostraInformacio(Client client){
        String nouString ="";
        nouString += ("Client: " + client.getNom()+"\n\t");
        nouString +=  client.getNif()+"\n\t";
        nouString += client.getTelefon()+"\n";
        
        List<Lloguer> lloguers = new ArrayList<>();
        lloguers = client.getLloguers();
        
        nouString += ("Lloguers: "+ lloguers.size()+"\n");
        
        for (int i=0; i<lloguers.size(); i++){
            nouString+= ((i+1)+". vehicle: "+lloguers.get(i).getVehicle().getMarca()+ " " +lloguers.get(i).getVehicle().getModel()+"\n\t");
            nouString+= ("data d'inici: "+lloguers.get(i).getData()+"\n\t");
            nouString+= ("dies llogats: "+lloguers.get(i).getDies()+"\n\t");
        }
        
        return nouString;
    }
    
    
    
}
