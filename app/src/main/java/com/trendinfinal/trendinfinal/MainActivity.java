package com.trendinfinal.trendinfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener ,OnClickListener {

    SliderLayout sliderLayout;
    HashMap<String,String> Hash_file_maps ;
    Button begin1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        begin1 = (Button) findViewById(R.id.begin);
        begin1.setOnClickListener(this);





        Hash_file_maps = new HashMap<String, String>();

        sliderLayout = (SliderLayout)findViewById(R.id.slider);
        Hash_file_maps.put("CLOUD STORAGE", "https://www.virtru.com/wp-content/uploads/2015/10/Encrypted-Cloud-Storage-6-Ways-Your-Files-are-Vulnerable-to-Hacking-600x600.jpg");
        Hash_file_maps.put("BUZZFEED ", "https://whats-trending.today/assets/img/logo.png");
        Hash_file_maps.put("HANGOUT RECOMMENDATIONS","https://img.informer.com/articles_uploads/3/3563/GoogleMaps.png" );
         Hash_file_maps.put("CAMPUS TRENDS", "http://fi.ge.pgstatic.net/colleges/gallery/processed/1434094592.2e6f223d39cb43d1a7e23ee2b8ea3be3.jpg");




        for(String name : Hash_file_maps.keySet()){

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(this);
    }
    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.begin:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;

            default:
                break;
        }

    }
}