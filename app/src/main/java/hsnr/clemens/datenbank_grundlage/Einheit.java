package hsnr.clemens.datenbank_grundlage;

public class Einheit extends DatabaseObject {

    public int EinID;
    public String Einheit;
    public boolean isValid;

    public Einheit(){}

    public Einheit(
            String Einheit
    ){
        this.Einheit = Einheit;
    }
}