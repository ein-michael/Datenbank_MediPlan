package hsnr.clemens.datenbank_grundlage;

public class Arzt extends DatabaseObject {

    public int ArztID;
    public Fachrichtung Fachrichtung;
    public String Name;
    public  boolean isValid;

    public Arzt(){}

    public Arzt(
            Fachrichtung Fachrichtung,
            String Name
    ){
        this.Fachrichtung = Fachrichtung;
        this.Name = Name;
    }
}

