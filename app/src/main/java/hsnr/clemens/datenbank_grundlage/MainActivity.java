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

        User newUser = new User(1, "herbert69", "Herbert", 1577855592, 1683605592, 1);

        boolean success = toolsi.userAnlegen(newUser);
        Log.d("LogIt", "Methode userAnlegen erfolgreich?: " + success);

        boolean existiert = toolsi.existiertUser(newUser);
        Log.d("LogIt", "Existiert newUser wirklich?: " + existiert);
        toolsi.userAbfrage("herbert69");
        toolsi.userAbfrage("jeron666");


    }
}