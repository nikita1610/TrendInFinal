package com.trendinfinal.trendinfinal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class dominos extends AppCompatActivity {
    LinearLayout linear1,linear2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dominos);
        linear1=(LinearLayout)findViewById(R.id.linear2);
        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                 Intent callIntent1 = new Intent(Intent.ACTION_DIAL);
                    callIntent1.setData(Uri.parse("tel:01206888688"));
                    startActivity(callIntent1);
            }
        });
        linear2=(LinearLayout)findViewById(R.id.linear4);
        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.dominos.co.in");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }
}
