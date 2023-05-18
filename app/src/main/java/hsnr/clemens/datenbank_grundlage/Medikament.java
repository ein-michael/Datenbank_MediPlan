package hsnr.clemens.datenbank_grundlage;

public class Medikament extends DatabaseObject {
    public int MedID;
    public int PZN;
    public long ZuletztBearb;
    public String Handelsname;
    public float Staerke_Dosis;
    public Einheit Einheit;
    public DarreichungsForm Darreichungsform;
    public String Nebenwirkung;
    public String EinnHinweis;
    public float PackGroesse;
    public EinnEinheit EinnEinheit;
    public Wirkstoff[] Wirkstoffe;
    public Wirkbereich[] Wirkbereiche;
    public boolean isValid;

    public Medikament(){
    }

    public Medikament(
            int PZN,
            long ZuletztBearb,
            float Staerke_Dosis,
            Einheit Einheit,
            DarreichungsForm Darreichungsform,
            String Nebenwirkung,
            String EinnHinweis,
            float PackGroese,
            EinnEinheit EinnEinheit,
            Wirkstoff[] Wirkstoffe,
            Wirkbereich[] Wirkbereiche
    ){
        this.PZN = PZN;
        this.ZuletztBearb = ZuletztBearb;
        this.Staerke_Dosis = Staerke_Dosis;
        this.Einheit = Einheit;
        this.Darreichungsform = Darreichungsform;
        this.Nebenwirkung = Nebenwirkung;
        this.EinnHinweis = EinnHinweis;
        this.PackGroesse = PackGroese;
        this.EinnEinheit = EinnEinheit;
        this.Wirkstoffe = Wirkstoffe;
        this.Wirkbereiche = Wirkbereiche;
    }

}