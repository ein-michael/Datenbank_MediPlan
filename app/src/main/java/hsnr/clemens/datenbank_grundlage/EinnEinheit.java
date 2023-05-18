package hsnr.clemens.datenbank_grundlage;

public class EinnEinheit extends DatabaseObject {

    public int EinnEinheitID;
    public String Einheit;
    public boolean isValid;

    public EinnEinheit(){}

    public EinnEinheit(
            String Einheit
    ){
        this.Einheit = Einheit;
    }
}