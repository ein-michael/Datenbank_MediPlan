package hsnr.clemens.datenbank_grundlage;

import android.util.Log;
import java.util.Date;
import android.content.ContentValues;

import android.database.sqlite.SQLiteOpenHelper;

import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.content.Context;

import android.widget.Toast;

public class DB_Tools extends SQLiteOpenHelper {

    public Context context;

    // region Namensdefinitionen
    private static final String DATENBANK_NAME = "Medikationsplan.db";
    private static final int DATENBANK_VERSION = 1;

    // region MedBib
    private static final String MDB_TABLE_NAME = "MedBib";

    private static final String MDB_COLUMN_MEDID = "MedID";
    private static final String MDB_COLUMN_PZN = "PZN";
    private static final String MDB_COLUMN_ZULETZTBEARB = "zuletztBearb";
    private static final String MDB_COLUMN_HANDELSNAME = "Handelsname";
    private static final String MDB_COLUMN_STAERKEDOSIS = "Staerk_Dosis";
    private static final String MDB_COLUMN_EINHEIT = "Einheit";
    private static final String MDB_COLUMN_DARREICHNUNGSFORM = "DarreichungsForm";
    private static final String MDB_COLUMN_NEBENWIRKUNG = "Nebenwirkung";
    private static final String MDB_COLUMN_EINNHINWEIS = "EinnHinweis";
    private static final String MDB_COLUMN_PACKGROESSE = "PackGroesse";
    private static final String MDB_COLUMN_EINNEINHEIT = "EinnEinheit";
    private static final String MDB_COLUMN_ISVALID = "isValid";
    // endregion MedBib

    // region enthaelt
    private static final String ENT_TABLE_NAME = "enthaelt";

    private static final String ENT_COLUMN_MEDID = "MedID";
    private static final String ENT_COLUMN_WIRKSTOFFID = "WirkstoffID";
    // endregion enthaelt

    // region Einheit
    private static final String EIH_TABLE_NAME = "Einheit";

    private static final String EIH_COLUMN_EINID = "EinID";
    private static final String EIH_COLUMN_EINHEIT = "Einheit";
    private static final String EIH_COLUMN_ISVALID = "isValid";
    // endregion Einheit

    // region EinnEinheit
    private static final String EIN_TABLE_NAME = "EinnEinheit";

    private static final String EIN_COLUMN_EINNEINHEITID = "EinnEinheitID";
    private static final String EIN_COLUMN_EINHEIT = "Einheit";
    private static final String EIN_COLUMN_ISVALID = "isValid";
    // endregion EinnEinheit

    // region Wirkstoff
    private static final String WIS_TABLE_NAME = "Wirkstoff";

    private static final String WIS_COLUMN_WIRKSTOFFID = "WirkstoffID";
    private static final String WIS_COLUMN_BEZEICHNUNG = "Bezeichnung";
    private static final String WIS_COLUMN_ISVALID = "isValid";
    // endregion Wirkstoff

    // region wirktFuer
    private static final String WIF_TABLE_NAME = "wirktFuer";

    private static final String WIF_COLUMN_MEDID = "MedID";
    private static final String WIF_COLUMN_WIRKBERID = "WirkBerID";
    // endregion wirktFuer

    // region Wirkbereich
    private static final String WIB_TABLE_NAME = "Wirkbereich";

    private static final String WIB_COLUMN_WIRKBERID = "WirkBerID";
    private static final String WIB_COLUMN_BEZEICHNUNG = "Bezeichnung";
    private static final String WIB_COLUMN_ISVALID = "isValid";
    // endregion Wirkbereich

    // region Darreichungsform
    private static final String DAF_TABLE_NAME = "Darreichungsform";

    private static final String DAF_COLUMN_DARRID = "DarrID";
    private static final String DAF_COLUMN_BEZEICHNUNG = "Bezeichnung";
    private static final String DAF_COLUMN_ISVALID = "isValid";
    // endregion Darreichungsform

    // region Anordnung
    private static final String ANO_TABLE_NAME = "Anordnung";

    private static final String ANO_COLUMN_ANORDNUNGSID = "AnordnungID";
    private static final String ANO_COLUMN_TYP = "Typ";
    private static final String ANO_COLUMN_NICHTEXAKT = "NichtExakt";
    private static final String ANO_COLUMN_MORVOR = "MorVor";
    private static final String ANO_COLUMN_MORZUR = "MorZur";
    private static final String ANO_COLUMN_MORNACH = "MorNach";
    private static final String ANO_COLUMN_MITVOR = "MitVor";
    private static final String ANO_COLUMN_MITZUR = "MitZur";
    private static final String ANO_COLUMN_MITNACH = "MitNach";
    private static final String ANO_COLUMN_ABVOR = "AbVor";
    private static final String ANO_COLUMN_ABZUR = "AbZur";
    private static final String ANO_COLUMN_ABNACH = "AbNach";
    private static final String ANO_COLUMN_NACHT = "Nacht";
    private static final String ANO_COLUMN_STARTZEITP = "Startzeitp";
    private static final String ANO_COLUMN_ENDZEITP = "Endzeitp";
    private static final String ANO_COLUMN_USER = "User";
    private static final String ANO_COLUMN_MEDIKAMENT = "Medikament";
    private static final String ANO_COLUMN_ARZT = "Arzt";
    private static final String ANO_COLUMN_EINNMAX = "EinMax";
    private static final String ANO_COLUMN_ISVALID = "isValid";
    // endregion Anordung

    // region Arzt
    private static final String ARZ_TABLE_NAME = "Arzt";

    private static final String ARZ_COLUMN_ARZTID = "ArztID";
    private static final String ARZ_COLUMN_FACHRICHTUNG = "Fachrichtung";
    private static final String ARZ_COLUMN_NAME = "Name";
    private static final String ARZ_COLUMN_ISVALID = "isValid";

    //endregion Arzt

    // region Fachrichtung
    private static final String FAC_TABLE_NAME = "Fachrichtung";

    private static final String FAC_COLUMN_FACHRICHTUNGID = "FachrichtungID";
    private static final String FAC_COLUMN_BEZEICHNUNG = "Bezeichnung";
    private static final String FAC_COLUMN_ISVALID = "isValid";
    // endregion Fachrichtung

    // region Rhythmus
    private static final String RHY_TABLE_NAME = "Rhythmus";

    private static final String RHY_COLUMN_RHYTHMID ="RhythmID";
    private static final String RHY_COLUMN_ALLXTAGE = "AlleXTage";
    private static final String RHY_COLUMN_WOCHENTAGE = "Wochentage";
    private static final String RHY_COLUMN_SCHEMAAKTIV = "SchemaAktiv";
    private static final String RHY_COLUMN_SCHEMAINAKTIV = "SchemaInaktiv";
    private static final String RHY_COLUMN_ISVALID = "isValid";
    // endregion Rhythmus

    // region hatRhythmus
    private static final String HRH_TABLE_NAME = "hatRhythmus";

    private static final String HRH_COLUMN_ANORDNUNGID = "AnordungID";
    private static final String HRH_COLUMN_RHYTHMID = "RhythmID";
    //endregion hatRhytmus

    // region User
    private static final String USR_TABLE_NAME = "User";

    private static final String USR_COLUMN_USERID = "UserID";
    private static final String USR_COLUMN_NUTZERNAME = "NutzerName";
    private static final String USR_COLUMN_NUTZERVORNAME = "NutzerVorname";
    private static final String USR_COLUMN_GEBURTSTAG = "Geburtstag";
    private static final String USR_COLUMN_ANLEGEDAT = "AnlegeDat";
    private static final String USR_COLUMN_ARZT = "Arzt";
    private static final String USR_COLUMN_ISVALID = "isValid";

    //endregion User

    // region EinnahmeDoku
    private static final String EDO_TABLE_NAME = "EinnahmeDoku";
    private static final String EDO_COLUMN_DOKUID = "DokuID";
    private static final String EDO_COLUMN_ZEITPEINNSOLL = "ZeitpEinnSoll";
    private static final String EDO_COLUMN_ZEITEINNIST = "ZeitpEinnIst";
    private static final String EDO_COLUMN_ZEITEINTRAG = "ZeitpEintrag";
    private static final String EDO_COLUMN_MENGE = "Menge";
    private static final String EDO_COLUMN_EINHEIT = "Einheit";
    private static final String EDO_COLUMN_ANORDNUNG = "Anordnung";
    private static final String EDO_COLUMN_GENOMMEN = "Genommen";
    private static final String EDO_COLUMN_BEMERKUNG = "Bemerkung";
    private static final String EDO_COLUMN_KOMMENTAR = "Kommentar";
    private static final String EDO_COLUMN_ISVALID = "isValid";
    //endregion EinnahmeDoku

    // region Tagebucheintrag
    private static final String TAG_TABLE_NAME = "Tagebucheintrag";
    private static final String TAG_COLUMN_EINTRAGID = "EintragID";
    private static final String TAG_COLUMN_EINTRAGTAG = "EintragTag";
    private static final String TAG_COLUMN_ANLAGEDAT = "AnlageDat";
    private static final String TAG_COLUMN_USER = "User";
    private static final String TAG_COLUMN_EINTRAG = "Eintrag";
    private static final String TAG_COLUMN_ISVALID = "isValid";
    //endregion Tagebucheintrag

    // endregion Namensdefinitionen


    public DB_Tools(@Nullable Context context){
        super(context, DATENBANK_NAME,null,DATENBANK_VERSION);
        this.context = context;
    }

    //OnCreate erstellt Datenbank wenn es noch keine gibt
    //Das Prinzip dahinter ist wir erstellen immer eine Abfrage mit dem Namen query_[Tabellenabkürzung], in den wir den SQL-CREATE-TABLE-Befehl erstellen. Der wird dann ausgeführt und die nächste query erstellt.
    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        String query_MDB =
                "CREATE TABLE " + MDB_TABLE_NAME +
                        " (" + MDB_COLUMN_MEDID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        MDB_COLUMN_PZN + " INTEGER, " +
                        MDB_COLUMN_ZULETZTBEARB + " LONG NOT NULL, " +
                        MDB_COLUMN_HANDELSNAME + " TEXT NOT NULL, " +
                        MDB_COLUMN_STAERKEDOSIS + " FLOAT, " +
                        MDB_COLUMN_EINHEIT + " INTEGER, " +
                        MDB_COLUMN_DARREICHNUNGSFORM + " INTEGER NOT NULL, " +
                        MDB_COLUMN_NEBENWIRKUNG + " TEXT, " +
                        MDB_COLUMN_EINNHINWEIS + " TEXT, " +
                        MDB_COLUMN_PACKGROESSE + " FLOAT, " +
                        MDB_COLUMN_EINNEINHEIT + " INTEGER NOT NULL,"+
                        MDB_COLUMN_ISVALID + " BOOLEAN); ";
        db.execSQL(query_MDB);

        String query_WIS =
                "CREATE TABLE " + WIS_TABLE_NAME +
                        " (" + WIS_COLUMN_WIRKSTOFFID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        WIS_COLUMN_BEZEICHNUNG + " TEXT NOT NULL,"+
                        WIS_COLUMN_ISVALID + " BOOLEAN); ";
        db.execSQL(query_WIS);

        String query_ENT =
                "CREATE TABLE " + ENT_TABLE_NAME +
                        " (" + ENT_COLUMN_MEDID + " INTEGER  NOT NULL, " +
                        ENT_COLUMN_WIRKSTOFFID + " INTEGER NOT NULL,"+
                        "FOREIGN KEY ("+ENT_COLUMN_MEDID+") REFERENCES "+MDB_TABLE_NAME+"("+MDB_COLUMN_MEDID+")," +
                        "FOREIGN KEY ("+ENT_COLUMN_WIRKSTOFFID+") REFERENCES "+WIS_TABLE_NAME+"("+WIS_COLUMN_WIRKSTOFFID+")); ";
        db.execSQL(query_ENT);

        String query_EIH =
                "CREATE TABLE " + EIH_TABLE_NAME +
                        " (" + EIH_COLUMN_EINID + " INTEGER  PRIMARY KEY AUTOINCREMENT, " +
                        EIH_COLUMN_EINHEIT + " TEXT NOT NULL,"+
                        EIH_COLUMN_ISVALID + " BOOLEAN); ";
        db.execSQL(query_EIH);

        String query_WIB =
                "CREATE TABLE " + WIB_TABLE_NAME +
                        " (" + WIB_COLUMN_WIRKBERID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        WIB_COLUMN_BEZEICHNUNG + " TEXT NOT NULL,"+
                        WIB_COLUMN_ISVALID + " BOOLEAN); ";
        db.execSQL(query_WIB);

        String query_WIF =
                "CREATE TABLE " + WIF_TABLE_NAME +
                        " (" + WIF_COLUMN_MEDID + " INTEGER  NOT NULL, " +
                        WIF_COLUMN_WIRKBERID + " INTEGER NOT NULL,"+
                        "FOREIGN KEY ("+WIF_COLUMN_MEDID+") REFERENCES "+MDB_TABLE_NAME+"("+MDB_COLUMN_MEDID+")," +
                        "FOREIGN KEY ("+WIF_COLUMN_WIRKBERID+") REFERENCES "+WIS_TABLE_NAME+"("+WIS_COLUMN_WIRKSTOFFID+")); ";
        db.execSQL(query_WIF);

        String query_DAF =
                "CREATE TABLE " + DAF_TABLE_NAME +
                        " (" + DAF_COLUMN_DARRID + " INTEGER  PRIMARY KEY AUTOINCREMENT, " +
                        DAF_COLUMN_BEZEICHNUNG + " TEXT NOT NULL,"+
                        DAF_COLUMN_ISVALID + " BOOLEAN); ";
        db.execSQL(query_DAF);

        String query_EIN =
                "CREATE TABLE " + EIN_TABLE_NAME +
                        " (" + EIN_COLUMN_EINNEINHEITID + " INTEGER  PRIMARY KEY AUTOINCREMENT, " +
                        EIN_COLUMN_EINHEIT + " TEXT NOT NULL,"+
                        EIN_COLUMN_ISVALID + " BOOLEAN); ";
        db.execSQL(query_EIN);

        String query_ANO =
                "CREATE TABLE " + ANO_TABLE_NAME +
                        "(" + ANO_COLUMN_ANORDNUNGSID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        ANO_COLUMN_TYP + " INTEGER NOT NULL," +
                        ANO_COLUMN_STARTZEITP + " LONG," +
                        ANO_COLUMN_ENDZEITP + " LONG," +
                        ANO_COLUMN_USER + " INTEGER NOT NULL," +
                        ANO_COLUMN_MEDIKAMENT + " INTEGER NOT NULL," +
                        ANO_COLUMN_MORVOR + " FLOAT," +
                        ANO_COLUMN_MORZUR + " FLOAT," +
                        ANO_COLUMN_MORNACH + " FLOAT," +
                        ANO_COLUMN_MITVOR + " FLOAT," +
                        ANO_COLUMN_MITZUR + " FLOAT," +
                        ANO_COLUMN_MITNACH + " FLOAT," +
                        ANO_COLUMN_ABVOR + " FLOAT," +
                        ANO_COLUMN_ABZUR + " FLOAT," +
                        ANO_COLUMN_ABNACH + " FLOAT," +
                        ANO_COLUMN_NACHT + " FLOAT," +
                        ANO_COLUMN_NICHTEXAKT + " BOOLEAN," +
                        ANO_COLUMN_EINNMAX + " FLOAT,"+
                        ANO_COLUMN_ISVALID + " BOOLEAN); ";
        db.execSQL(query_ANO);

        String query_RYH =
                "CREATE TABLE " + RHY_TABLE_NAME +
                        "("+ RHY_COLUMN_RHYTHMID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        RHY_COLUMN_ALLXTAGE + " INTEGER," +
                        RHY_COLUMN_WOCHENTAGE + " INTEGER," +
                        RHY_COLUMN_SCHEMAAKTIV + " INTEGER," +
                        RHY_COLUMN_SCHEMAINAKTIV + " INTEGER,"+
                        RHY_COLUMN_ISVALID + " BOOLEAN); ";
        db.execSQL(query_RYH);

        String query_HRH =
                "CREATE TABLE " + HRH_TABLE_NAME +
                        "("+ HRH_COLUMN_ANORDNUNGID + " INTEGER,"+
                        HRH_COLUMN_RHYTHMID + " INTEGER NOT NULL,"+
                        "FOREIGN KEY ("+HRH_COLUMN_ANORDNUNGID+") REFERENCES " + ANO_TABLE_NAME +" ("+ANO_COLUMN_ANORDNUNGSID +")," +
                        "FOREIGN KEY ("+HRH_COLUMN_RHYTHMID+") REFERENCES " + RHY_TABLE_NAME + " (" + RHY_COLUMN_RHYTHMID + "));";
        db.execSQL(query_HRH);

        String query_ARZ =
                "CREATE TABLE " + ARZ_TABLE_NAME +
                        "("+ ARZ_COLUMN_ARZTID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        ARZ_COLUMN_FACHRICHTUNG + " INTEGER," +
                        ARZ_COLUMN_NAME + " TEXT,"+
                        ARZ_COLUMN_ISVALID + " BOOLEAN); ";
        db.execSQL(query_ARZ);

        String query_FAC =
                "CREATE TABLE " + FAC_TABLE_NAME +
                        "("+ FAC_COLUMN_FACHRICHTUNGID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                        FAC_COLUMN_BEZEICHNUNG + " TEXT NOT NULL,"+
                        FAC_COLUMN_ISVALID + " BOOLEAN); ";
        db.execSQL(query_FAC);

        String query_USR =
                "CREATE TABLE " + USR_TABLE_NAME +
                        "("+ USR_COLUMN_USERID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        USR_COLUMN_NUTZERNAME + " TEXT NOT NULL," +
                        USR_COLUMN_NUTZERVORNAME + " TEXT NOT NULL," +
                        USR_COLUMN_GEBURTSTAG + " LONG," +
                        USR_COLUMN_ANLEGEDAT + " LONG NOT NULL," +
                        USR_COLUMN_ARZT + " INTEGER,"+
                        USR_COLUMN_ISVALID + " BOOLEAN); ";
        db.execSQL(query_USR);

        String query_EDO =
                "CREATE TABLE " + EDO_TABLE_NAME +
                        "("+ EDO_COLUMN_DOKUID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        EDO_COLUMN_ZEITPEINNSOLL + " LONG," +
                        EDO_COLUMN_ZEITEINNIST + " LONG," +
                        EDO_COLUMN_ZEITEINTRAG + " LONG," +
                        EDO_COLUMN_MENGE + " FLOAT," +
                        EDO_COLUMN_EINHEIT + " INTEGER," +
                        EDO_COLUMN_ANORDNUNG + " INTEGER," +
                        EDO_COLUMN_GENOMMEN + " BOOLEAN," +
                        EDO_COLUMN_BEMERKUNG + " TEXT," +
                        EDO_COLUMN_KOMMENTAR + " TEXT,"+
                        EDO_COLUMN_ISVALID + " BOOLEAN); ";
        db.execSQL(query_EDO);

        String query_TAG =
                "CREATE TABLE " + TAG_TABLE_NAME +
                        "("+ TAG_COLUMN_EINTRAGID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        TAG_COLUMN_EINTRAGTAG + " LONG NOT NULL," +
                        TAG_COLUMN_ANLAGEDAT + " LONG NOT NULL," +
                        TAG_COLUMN_USER + " INTEGER NOT NULL," +
                        TAG_COLUMN_EINTRAG + " TEXT NOT NULL,"+
                        TAG_COLUMN_ISVALID + " BOOLEAN); ";
        db.execSQL(query_TAG);
    }

    //Wird abgerufen wenn eine bestehende Datenbank upgegraded werden soll
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //gibt Meldung wenn Datenbank geupgraded werden soll, sollte eigentlich nie sein
        Toast.makeText(context, "Das hier sollte nie passieren...",Toast.LENGTH_LONG).show();
    }

    //Die Methode macht nix außer ein Datenbankobjekt zu initialisieren, legt damit eine Datenbank an, wenn keine da ist.
    //Die onCrate-Methode wird in dem Moment aufgerufen, wo ein SQLiteDatabase-Object erstellt wird und es die entsprechenden Tabellen noch nicht gibt.
    //Die Methode unten macht also nur das, sie erstellt die Tabellen in der Datenbank, wenn es sie noch nocht gibt.
    void ErstelleWennNichtDa() {
        SQLiteDatabase db = this.getReadableDatabase();
    }

    // region Test/Debug

    //gerade nix hier...

    // endregion Test/Debug

    // region UI-Hilfe

    //gibt ein Array an Spinneritems einer bestimmten Tabelle zurück. Nützlich für drop-down-menüs
    public SpinnerItem[] gibSpinnerItems(int tabelle){
        String Zieltabelle;

        //Zuordnung der Zieltabelle zum übergebenen Parameter
        switch (tabelle){
            case 0: Zieltabelle = WIS_TABLE_NAME;
                break;
            case 1: Zieltabelle = EIH_TABLE_NAME;
                break;
            case 2: Zieltabelle = DAF_TABLE_NAME;
                break;
            case 3: Zieltabelle = WIB_TABLE_NAME;
                break;
            case 4: Zieltabelle = EIN_TABLE_NAME;
                break;
            default: return null;
        }

        //Abfrage generieren und durchführen. Noch nicht sicher gegen SQL-Injection
        String abfrage = "SELECT * FROM "+Zieltabelle+";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor erg = db.rawQuery(abfrage,null);

        //Wenn es kein Ergebnis gibt geht null zurück
        if(erg.getCount()<1) return null;

        //return-Array anlegen, durch den Cursor durchiterieren und schrittweise das Array füllen
        SpinnerItem[] rtn = new SpinnerItem[erg.getCount()];
        if(erg.moveToFirst()){
            do{
                rtn[erg.getPosition()] = new SpinnerItem(erg.getInt(0),erg.getString(1));
            } while (erg.moveToNext());
        }
        erg.close();
        return rtn;
    }

    // endregion UI-Hilfe

    // region Objekt zu ID

    public Medikament MedikamentZuID(int id){
        //SQL Lite Abfrage
        String abfrage = "SELECT * FROM " + MDB_TABLE_NAME + " WHERE "+ MDB_COLUMN_MEDID + " = " + id+" AND "+MDB_COLUMN_ISVALID+" = 1;";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor abf = db.rawQuery(abfrage,null);

        if (abf.moveToFirst()) {

            Medikament md = new Medikament();

            md.MedID = abf.getInt(0);
            md.PZN = abf.getInt(1);
            md.ZuletztBearb = abf.getLong(2);
            md.Handelsname = abf.getString(3);
            md.Staerke_Dosis = abf.getFloat(4);
            md.Einheit = EinheitZuID(abf.getInt(5));
            md.Darreichungsform = DarreichungsformZuID(abf.getInt(6));
            md.Nebenwirkung = abf.getString(7);
            md.EinnHinweis = abf.getString(8);
            md.PackGroesse = abf.getFloat(9);
            md.EinnEinheit = EinnEinheitZuID(abf.getInt(10));
            md.isValid = abf.getInt(11)==1; //kleiner Trick, booleans werden in SQLite als int gespeichert, 1=true

            md.Wirkstoffe = WirkstoffeZuMedID(abf.getInt(0));
            md.Wirkbereiche = WirkbereicheZuMedID(abf.getInt(0));
            abf.close();

            return md;
        }
        else {
            // Kein Treffer gefunden
            return null;
        }
    }
    public Einheit EinheitZuID(int id) {
        //SQL Lite Abfrage
        String abfrage = "SELECT * FROM " + EIH_TABLE_NAME + " WHERE " + EIH_COLUMN_EINID + " = " + id + " AND " + EIH_COLUMN_ISVALID + " = 1;";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor Einheit_abf = db.rawQuery(abfrage, null);

        if (Einheit_abf.moveToFirst()) {
            Einheit einh = new Einheit();
            einh.EinID = Einheit_abf.getInt(0);
            einh.Einheit = Einheit_abf.getString(1);
            einh.isValid = Einheit_abf.getInt(2)==1;
            Einheit_abf.close();
            return einh;
        }
        else return null;
    }
    public EinnEinheit EinnEinheitZuID(int id) {
        //SQL Lite Abfrage
        String abfrage = "SELECT * FROM " + EIN_TABLE_NAME + " WHERE " + EIN_COLUMN_EINNEINHEITID + " = " + id + " AND " + EIN_COLUMN_ISVALID + " = 1;";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor EinnEinheit_abf = db.rawQuery(abfrage, null);

        if (EinnEinheit_abf.moveToFirst()) {
            EinnEinheit einnEinh = new EinnEinheit();
            einnEinh.EinnEinheitID = EinnEinheit_abf.getInt(0);
            einnEinh.Einheit = EinnEinheit_abf.getString(1);
            einnEinh.isValid = EinnEinheit_abf.getInt(2)==1;
            EinnEinheit_abf.close();
            return einnEinh;
        }
        else return null;
    }
    public DarreichungsForm DarreichungsformZuID(int id) {
        //SQL Lite Abfrage
        String abfrage = "SELECT * FROM " + DAF_TABLE_NAME + " WHERE " + DAF_COLUMN_DARRID + " = " + id + " AND " + DAF_COLUMN_ISVALID + " = 1;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor Darreichungsform_abf = db.rawQuery(abfrage, null);

        if (Darreichungsform_abf.moveToFirst()) {
            DarreichungsForm darreich = new DarreichungsForm();
            darreich.DarrID = Darreichungsform_abf.getInt(0);
            darreich.Bezeichnung = Darreichungsform_abf.getString(1);
            darreich.isValid = Darreichungsform_abf.getInt(2)==1;
            Darreichungsform_abf.close();
            return darreich;
        }
        else return null;
    }
    public Wirkstoff WirkstoffZuID(int id){
        //SQL Lite Abfrage
        String abfrage = "SELECT * FROM " + WIS_TABLE_NAME + " WHERE " + WIS_COLUMN_WIRKSTOFFID + " = " + id + " AND " + WIS_COLUMN_ISVALID + " = 1;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor Wirkstoff_abf = db.rawQuery(abfrage, null);

        if (Wirkstoff_abf.moveToFirst()) {
            Wirkstoff wirkstoff = new Wirkstoff();
            wirkstoff.WirkstoffID = Wirkstoff_abf.getInt(0);
            wirkstoff.Bezeichnung = Wirkstoff_abf.getString(1);
            wirkstoff.isValid = Wirkstoff_abf.getInt(2)==1;
            Wirkstoff_abf.close();
            return wirkstoff;
        }
        else return null;
    }
    public Wirkbereich WirkbereicZuID(int id){
        //SQL Lite Abfrage
        String abfrage = "SELECT * FROM " + WIB_TABLE_NAME + " WHERE " + WIB_COLUMN_WIRKBERID + " = " + id + " AND " + WIB_COLUMN_ISVALID + " = 1;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor Wirkbereich_abf = db.rawQuery(abfrage, null);

        if (Wirkbereich_abf.moveToFirst()) {
            Wirkbereich wirkbereich = new Wirkbereich();
            wirkbereich.WirkBerID = Wirkbereich_abf.getInt(0);
            wirkbereich.Bezeichnung = Wirkbereich_abf.getString(1);
            wirkbereich.isValid = Wirkbereich_abf.getInt(2)==1;
            Wirkbereich_abf.close();
            return wirkbereich;
        }
        else return null;
    }

    // endregion Objekt zu ID

    // region Verbindungstabellen auslesen

    public Wirkstoff[] WirkstoffeZuMedID(int id){
        //SQL Lite Abfrage
        String abfrage = "SELECT * FROM " + ENT_TABLE_NAME + " WHERE " + ENT_COLUMN_MEDID + " =  + id;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor enthaelt_abf = db.rawQuery(abfrage, null);
        if (enthaelt_abf.moveToFirst()) {
            Wirkstoff[] wirkstoffe = new Wirkstoff[enthaelt_abf.getCount()];
            do{
                wirkstoffe[enthaelt_abf.getPosition()] = WirkstoffZuID(enthaelt_abf.getInt(1));
            } while (enthaelt_abf.moveToNext());
            return wirkstoffe;
        }
        else return null;
    }
    public Wirkbereich[] WirkbereicheZuMedID(int id){
        //SQL Lite Abfrage
        String abfrage = "SELECT * FROM " + WIF_TABLE_NAME + " WHERE " + WIF_COLUMN_MEDID + " =  + id;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor wirkfuer_abf = db.rawQuery(abfrage, null);
        if (wirkfuer_abf.moveToFirst()) {
            Wirkbereich[] wirkbereiche = new Wirkbereich[wirkfuer_abf.getCount()];
            do{
                wirkbereiche[wirkfuer_abf.getPosition()] = WirkbereicZuID(wirkfuer_abf.getInt(1));
            } while (wirkfuer_abf.moveToNext());
            return wirkbereiche;
        }
        else return null;
    }

    // endregion Verbindungstabellen auslesen

    // region Medikamente_Methoden

    //Gibt das zu der eingegebenen PZN passende Medikament zurück
    public Medikament MedikamentZuPzn(int pzn){
        //SQL Lite Abfrage
        String PZNabfrage = "SELECT * FROM " + MDB_TABLE_NAME + " WHERE "+ MDB_COLUMN_PZN + " = " + pzn+" AND "+MDB_COLUMN_ISVALID+" = 1;";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor abf = db.rawQuery(PZNabfrage,null);

        if (abf.moveToFirst()) {

            Medikament md = MedikamentZuID(abf.getInt(0));
            abf.close();
            return md;
        }
        else {
            // Kein Treffer gefunden
            return null;
        }
    }

   /* public boolean medikamentAnlegen(Medikament medikament){
        // Stellt Verbindung mit Datenbank her
        SQLiteDatabase db = this.getWritableDatabase();

        // Erstellt ein neues ContentValues-Objekt mit den Informationen des Medikaments
        ContentValues values = new ContentValues();
        values.put(MDB_COLUMN_PZN,medikament.PZN);
        values.put(MDB_COLUMN_ZULETZTBEARB,medikament.ZuletztBearb);
        values.put(MDB_COLUMN_HANDELSNAME,medikament.Handelsname);
        values.put(MDB_COLUMN_STAERKEDOSIS,medikament.Staerke_Dosis);
        values.put(MDB_COLUMN_EINHEIT,medikament.Einheit);
        values.put(MDB_COLUMN_DARREICHNUNGSFORM,medikament.Darreichungsform);
        values.put(MDB_COLUMN_NEBENWIRKUNG,medikament.Nebenwirkung);
        values.put(MDB_COLUMN_EINNHINWEIS,medikament.EinnHinweis);
        values.put(MDB_COLUMN_PACKGROESSE,medikament.PackGroesse);
        values.put(MDB_COLUMN_EINNEINHEIT,medikament.EinnEinheit);

        // Fügt den neuen Datensatz zur Datenbank hinzu und gibt das Ergebnis zurück
        long result = db.insert(MDB_TABLE_NAME, null, values);
        return result != -1;
    } */


    // endregion Medikamente-Methoden

    // region User-Methoden

    //gibt zurück ob ein User existiert
    public boolean existiertUser(){
        //SQL-Abfrage zum ausführen
        String abfrage = "SELECT * FROM " + USR_TABLE_NAME+";";
        //Auf die Datenbank zugreifen
        SQLiteDatabase db = this.getReadableDatabase();
        //Cursor erstellen
        Cursor cursor = db.rawQuery(abfrage,null);

        //Anzahl der Datensätze im Cursor ermitteln
        int count = cursor.getCount();
        cursor.close();
        //Wenn es Datensätze gibt, wird der boolean auf true gesetzt
        boolean datensätzeExistieren = count > 0;

        //If-Abfrage, um abzufragen, ob es Datensätze gibt. Wenn ja --> True, wenn nicht --> False
        if (datensätzeExistieren) {
            return true;
        }
        else{
            return false;
        }
    }

    //Legt den übergebenen User in die Datenbank
    // Gibt true zurück wenn erfolgreich, sonst false
    /*public boolean userAnlegen(User user){

        // Stellt Verbindung mit Datenbank her
        SQLiteDatabase db = this.getWritableDatabase();

        // Erstellt ein neues ContentValues-Objekt mit den Informationen des Users
        ContentValues values = new ContentValues();
        values.put(USR_COLUMN_NUTZERNAME, user.NutzerName);
        values.put(USR_COLUMN_NUTZERVORNAME, user.NutzerVorname);
        values.put(USR_COLUMN_GEBURTSTAG, user.Geburtstag);
        values.put(USR_COLUMN_ANLEGEDAT, user.AnlageDat);
        values.put(USR_COLUMN_ARZT, user.Arzt);

        // Fügt den neuen Datensatz zur Datenbank hinzu und gibt das Ergebnis zurück
        long result = db.insert(USR_TABLE_NAME, null, values);
        return result != -1;
    }

    //Gibt den User aus der Tabelle als ein User-Objekt zurück
    //Gibt null zurück falls es keinen user gibt */
   /* public User userAbfragen(){

        //Abfrage erstellen
        String abfrage = "SELECT * FROM "+USR_TABLE_NAME+";";

        // Stellt Verbindung mit Datenbank her
        SQLiteDatabase db = this.getReadableDatabase();

        //Cursor mit Abfrage belegen
        Cursor cursor = db.rawQuery(abfrage,null);

        // Prüft, ob die Abfrage ein Ergebnis zurückgibt und gibt den User als Objekt zurück
        if (cursor.moveToFirst()) {
            User user = new User();
            user.UserID=cursor.getInt(0);
            user.NutzerName=cursor.getString(1);
            user.NutzerVorname=cursor.getString(2);
            user.Geburtstag=cursor.getLong(3);
            user.AnlageDat=cursor.getLong(4);
            user.Arzt=cursor.getInt(5);
            cursor.close();
            return user;
        } else {
            cursor.close();
            return null;
        }
    } */

    // endregion User-Methoden

}