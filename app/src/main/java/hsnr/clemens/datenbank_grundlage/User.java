
package hsnr.clemens.datenbank_grundlage;

public class User extends DatabaseObject {
    public int UserID;
    public String NutzerName;
    public String NutzerVorname;
    public long Geburtstag;
    public long AnlageDat;
    public Arzt Arzt;
    public boolean isValid;

    public User(){
    }

    public User(String NutzerName, String NutzerVorname, long Geburtstag, long AnlageDat, Arzt Arzt){
        this.NutzerName = NutzerName;
        this.NutzerVorname = NutzerVorname;
        this.Geburtstag = Geburtstag;
        this.AnlageDat = AnlageDat;
        this.Arzt = Arzt;
    }
}