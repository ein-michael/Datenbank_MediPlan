package hsnr.clemens.datenbank_grundlage;

public class User extends DatabaseObject {
    public int UserID;
    public String NutzerName;
    public String NutzerVorname;
    public long Geburtstag;
    public long AnlageDat;
    public int Arzt;

    public User(int UserID, String NutzerName, String NutzerVorname, long Geburtstag, long AnlageDat, int Arzt)
    {
        this.UserID = UserID;
        this.NutzerName = NutzerName;
        this.NutzerVorname = NutzerVorname;
        this.Geburtstag = Geburtstag;
        this.AnlageDat = AnlageDat;
        this.Arzt = Arzt;
    }
}
