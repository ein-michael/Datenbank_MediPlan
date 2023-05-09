package hsnr.clemens.datenbank_grundlage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB_Tools toolsi = new DB_Tools(MainActivity.this);
        toolsi.ErstelleWennNichtDa();

        //Erstelle neues Objekt newUser
        User newUser = new User(1, "herbert69", "Herbert", 1577855592, 1683605592, 1);
        //Überprüfe, ob newUser bereits existiert
        boolean existiert = toolsi.existiertUser(newUser);
        Log.d("LogIt", "Existiert newUser wirklich?: " + existiert);

        //Wenn newUser nicht funktioniert, lege neuen User an und melde die Methode userAnlegen als erfolgreich
        if(toolsi.existiertUser(newUser) == false) {
            boolean success = toolsi.userAnlegen(newUser);
            Log.d("LogIt", "Methode userAnlegen erfolgreich?: " + success);
        }
        //Gebe die Daten von herbert69 wieder, wenn User bekannt
        toolsi.userAbfrage("herbert69");

//Medikamententest

        //Füge mit der Methode stammMediNeu neues Medikament in die Datenbank
        toolsi.stammMediNeu(0, 12345,"Ibuprofen", 400, 1, 1,"Keine", "Keine", 50, 1);
        //Lege neues Objekt ibu an
        Medikament ibu = new Medikament(0, 12345, 1683614287, "Ibuprofen", 400, 1, 1,"Keine", "Keine", 50, 1);
        //Prüfe, ob Medikament mit PZN in Datenbank vorhanden ist
        //Wenn vorhanden, gebe Daten des Medikaments wieder;
        toolsi.MedikamentZuPzn(12345);
        toolsi.MedikamentZuPzn(1);


    }
}