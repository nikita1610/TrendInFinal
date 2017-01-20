package com.trendinfinal.trendinfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivityBuzz extends Activity {
    ListView list;
    String[] web = {
            "JIIT PROGRAMING HUB",
            "JIIT DEVELOPERS GROUP",
            "GDG JIIT NOIDA",
            "RADIANCE HUB",
            "VHACKERS",
            "HACKEREARTH CLUB",
            "JIIT BTECH GROUP",
            "GRAPHICS CLUB"
    } ;
    Integer[] imageId = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainbuzz);

        CustomListBuzz adapter = new
                CustomListBuzz(MainActivityBuzz.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                {
                    switch( position )
                    {
                        case 0:
                            Intent intent=new Intent(MainActivityBuzz.this,jiitknuth.class);
                            startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(MainActivityBuzz.this, jiitdeveloper.class);
                            startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(MainActivityBuzz.this, jiitgdg.class);
                            startActivity(intent);
                            break;
                        case 3:
                            intent = new Intent(MainActivityBuzz.this, jiitradiance.class);
                            startActivity(intent);
                            break;
                        case 4:
                            intent = new Intent(MainActivityBuzz.this, jiitvhacker.class);
                            startActivity(intent);
                            break;
                        case 5:
                            intent = new Intent(MainActivityBuzz.this, jiithackearth.class);
                            startActivity(intent);
                            break;
                        case 6:
                            intent = new Intent(MainActivityBuzz.this, jiitbtech.class);
                            startActivity(intent);
                            break;
                        case 7:
                            intent = new Intent(MainActivityBuzz.this, jiitgraphics.class);
                            startActivity(intent);
                            break;
                    }
                }
            }
        });

    }

}