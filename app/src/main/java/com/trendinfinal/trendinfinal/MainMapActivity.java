package com.trendinfinal.trendinfinal;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class MainMapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("HANGOUTS");
        Thread thread=new Thread()
        {
            LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
            boolean enabled = service
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);
            public void run()
            {
                try{

                    if (!enabled) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                        finish();
                        sleep(2000);
                            Intent intent1 = new Intent(MainMapActivity.this, MapsActivity2.class);
                            startActivity(intent1);



                    }

                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    if(enabled) {
                        Intent intent = new Intent(MainMapActivity.this, MapsActivity2.class);
                        startActivity(intent);
                    }
                }
            }
        };
        thread.start();


    }


}