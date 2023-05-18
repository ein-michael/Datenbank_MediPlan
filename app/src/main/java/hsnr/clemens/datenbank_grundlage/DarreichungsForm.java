package hsnr.clemens.datenbank_grundlage;

public class DarreichungsForm extends DatabaseObject {

    public int DarrID;
    public String Bezeichnung;
    public boolean isValid;

    public DarreichungsForm(){}

    public DarreichungsForm(
            String Bezeichnung
    ){
        this.Bezeichnung = Bezeichnung;
    }
}