package hsnr.clemens.datenbank_grundlage;

public class Wirkbereich extends DatabaseObject {

    public int WirkBerID;
    public String Bezeichnung;
    public boolean isValid;

    public Wirkbereich(){}

    public Wirkbereich(
            String Bezeichnung
    ){
        this.Bezeichnung = Bezeichnung;
    }
}