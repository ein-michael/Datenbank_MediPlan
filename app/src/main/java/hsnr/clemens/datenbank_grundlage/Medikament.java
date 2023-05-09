package hsnr.clemens.datenbank_grundlage;

public class Medikament extends DatabaseObject {
    public int MedID;
    public int PZN;
    public long ZuletztBearb;
    public String Handelsname;
    public float Staerke_Dosis;
    public int Einheit;
    public int Darreichungsform;
    public String Nebenwirkung;
    public String EinnHinweis;
    public float PackGroesse;
    public int EinnEinheit;

    public Medikament(int MedID, int PZN, long ZuletztBearb, String Handelsname, float Starke_Dosis, int Einheit, int Darreichungsform, String Nebenwirkung, String EinnHinweis, float PackGroesse, int EinnEinheit)
    {
        this.MedID = MedID;
        this.PZN = PZN;
        this.ZuletztBearb = ZuletztBearb;
        this.Handelsname = Handelsname;
        this.Staerke_Dosis = Starke_Dosis;
        this.Einheit = Einheit;
        this.Darreichungsform = Darreichungsform;
        this.Nebenwirkung = Nebenwirkung;
        this.EinnHinweis = EinnHinweis;
        this.PackGroesse = PackGroesse;
        this.EinnEinheit = EinnEinheit;
    }
}
