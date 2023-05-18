package hsnr.clemens.datenbank_grundlage;

public class Fachrichtung extends DatabaseObject {

    public int FachrichtungID;
    public String Bezeichnung;
    public boolean isValid;


    public Fachrichtung(){}

    public Fachrichtung(
            String Bezeichnung
    ){
        this.Bezeichnung = Bezeichnung;
    }
}