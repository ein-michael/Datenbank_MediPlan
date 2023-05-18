package hsnr.clemens.datenbank_grundlage;

public class Wirkstoff extends DatabaseObject {

    public int WirkstoffID;
    public String Bezeichnung;
    public boolean isValid;

    public Wirkstoff(){}

    public Wirkstoff(
            String Bezeichnung
    ){
        this.Bezeichnung = Bezeichnung;
    }
}