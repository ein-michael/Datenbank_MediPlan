package hsnr.clemens.datenbank_grundlage;

public class Anordnung extends DatabaseObject{
    public int AnordnungID;
    public int Typ;
    public long Startzeitp;
    public long Endzeitp;
    public User User;
    public Medikament Medikament;
    public Arzt Arzt;
    public float MorVor,MorZur,MorNach;
    public float MitVor,MitZur,MitNach;
    public float AbVor,AbZur,AbNach;
    public float Nacht;
    public boolean NichtExakt;
    public float EinnMax;
    public Rhythmus[] Rhytmen;
    public boolean isValid;


    public Anordnung(){
    }

    public Anordnung(   int Typ,
                        long Startzeitp,
                        long Endzeitp,
                        User User,
                        Medikament Medikament,
                        Arzt Arzt,
                        float MorVor,
                        float MorZur,
                        float MorNach,
                        float MitVor,
                        float MitZur,
                        float MitNach,
                        float AbVor,
                        float AbZur,
                        float AbNach,
                        float Nacht,
                        boolean NichtExakt,
                        float EinnMax,
                        Rhythmus[] Rhythmen
    ){
        this.Typ = Typ;
        this.Startzeitp = Startzeitp;
        this.Endzeitp = Endzeitp;
        this.User = User;
        this.Medikament = Medikament;
        this.Arzt = Arzt;
        this.MorVor = MorVor;
        this.MorZur = MorZur;
        this.MorNach = MorNach;
        this.MitVor = MitVor;
        this.MitZur = MitZur;
        this.MitNach = MitNach;
        this.AbVor = AbVor;
        this.AbZur = AbZur;
        this.AbNach = AbNach;
        this.Nacht = Nacht;
        this.NichtExakt = NichtExakt;
        this.EinnMax = EinnMax;
        this.Rhytmen = Rhythmen;
    }

}


