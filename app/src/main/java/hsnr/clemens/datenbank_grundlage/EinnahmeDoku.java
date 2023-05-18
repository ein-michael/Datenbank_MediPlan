package hsnr.clemens.datenbank_grundlage;

public class EinnahmeDoku extends DatabaseObject {

    public int DokuID;
    public long ZeitpEinnSoll;
    public long ZeitpEinnIst;
    public long ZeitpEintrag;
    public float Menge;
    public Einheit Einheit;
    public Anordnung Anordnung;
    public boolean Genommen;
    public String Bemerkung;
    public String Kommentar;
    public boolean isValid;
}