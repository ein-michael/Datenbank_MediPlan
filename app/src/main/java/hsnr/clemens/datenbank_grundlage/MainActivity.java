package hsnr.clemens.datenbank_grundlage;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    DB_Tools toolsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolsi = new DB_Tools(MainActivity.this);
        toolsi.ErstelleWennNichtDa();
        //TestMethodeUser();
        //TestNachPzn(12345);

    }

  /*  public void TestMethodeUser(){
        Log.e("Debugger","Der Test beginnt ab jetzt");
        boolean existiertUser = toolsi.existiertUser();
        Log.e("Debugger","Gibt es einen User: "+existiertUser);
        if(!existiertUser){
            User daNewUser = new User("Horstsohn","Horst",61,84,69);
            if(toolsi.userAnlegen(daNewUser)) Log.e("Debugger","Neuer User angelegt");
            else Log.e("Debugger","Fehler beim Anlegen des neuen Users");

        }
        else{
            User daExUser = toolsi.userAbfragen();
            Log.e("Debugger","Es folgen die Stats zum User");
            Log.e("Debugger","UserID: "+daExUser.UserID);
            Log.e("Debugger","NutzeName: "+daExUser.NutzerName);
            Log.e("Debugger","NutzerVorname: "+daExUser.NutzerVorname);
            Log.e("Debugger","Geburtsdatum: "+daExUser.Geburtstag);
            Log.e("Debugger","AnlegeDat: "+daExUser.AnlageDat);
            Log.e("Debugger","Arzt: "+daExUser.Arzt);
        }
    } */

    /*public void TestAddMedi(int testPzn){
        Medikament insertMedi = new Medikament(testPzn,13,"Irkosonat",3,5,1,"aua","mit Wasser",7,5);
        if(toolsi.medikamentAnlegen(insertMedi)) Log.e("Debugger","Neues Medikament angelegt");
        else Log.e("Debugger","Fehler beim Anlegen des neuen Medikaments");
    } */
    /*public void TestNachPzn(int testPzn){
        Medikament datMedi = toolsi.MedikamentZuPzn(testPzn);
        if(datMedi == null) {
            Log.e("Debugger","Es existiert kein Medikament mit der PZN");
            TestAddMedi(testPzn);
        }
        else{
            Log.e("Debugger","Es folgen die Stats zum medikament mit PZN "+testPzn);
            Log.e("Debugger","MedID: "+datMedi.MedID);
            Log.e("Debugger","PZN: "+datMedi.PZN);
            Log.e("Debugger","zuletztBearbeit: "+datMedi.ZuletztBearb);
            Log.e("Debugger","Handelsname: "+datMedi.Handelsname);
            Log.e("Debugger","Staerke_dosis: "+datMedi.Staerke_Dosis);
            Log.e("Debugger","Einheit: "+datMedi.Einheit);
            Log.e("Debugger","Darreichungsform: "+datMedi.Darreichungsform);
            Log.e("Debugger","Nebenwirkung: "+datMedi.Nebenwirkung);
            Log.e("Debugger","EinnHinweis: "+datMedi.EinnHinweis);
            Log.e("Debugger","PackGroesse: "+datMedi.PackGroesse);
            Log.e("Debugger","EinnEinheit: "+datMedi.EinnEinheit);
        }
    } */
}