package hsnr.clemens.datenbank_grundlage;

public class Tagebucheintrag extends DatabaseObject {
    public int EintragID;
    public long EintragTag;
    public long AnlageDat;
    public User User;
    public String Eintrag;
    public boolean isValid;
}