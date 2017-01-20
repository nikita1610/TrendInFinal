package com.trendinfinal.trendinfinal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback  {


    private GoogleMap mMap;
    private static final LatLng DOMINOS = new LatLng(28.6281,77.3755);
    private static final LatLng PIZZA = new LatLng(28.612897,77.362628);
    private static final LatLng WINDSOR = new LatLng(28.637047,77.366217);
    private static final LatLng SHIPRA_MALL = new LatLng(28.6339,77.3693);
    private static final LatLng SANDWEDGES = new LatLng(28.6382,77.3689);
    private static final LatLng BAKES_CAKES = new LatLng(28.635845,77.366949);
    private static final LatLng ROLLS_KING = new LatLng(28.618466,77.370394);
    private static final LatLng ADITYA_MALL = new LatLng(28.6692,77.370394);
    private static final LatLng JAIPURIA_MALL = new LatLng(28.6322,77.4538);


    private Marker MDOMINOS;
    private Marker MPIZZA_HUT;
    private Marker MWINDSOR;
    private Marker MSHIPRA_MALL;
    private Marker MSANDWEDGES;
    private Marker MBAKES_CAKES;
    private Marker MROLLS_KING;
    private  Marker MADITYA_MALL;
    private Marker MJAIPURIA_MALL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng jiit = new LatLng(28.6305, 77.3721);
        mMap.addMarker(new MarkerOptions().position(jiit).title("Marker at Jiit"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jiit));
        mMap.addMarker(new MarkerOptions().position(jiit)).setVisible(true);

        // Move the camera instantly to location with a zoom of 15.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jiit, 15));

        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);
        MDOMINOS = mMap.addMarker(new MarkerOptions()
                .position(DOMINOS)
                .title("DOMINOS").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        MDOMINOS.setTag(0);

        MPIZZA_HUT = mMap.addMarker(new MarkerOptions()
                .position(PIZZA)
                .title("PIZZA_HUT").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)) );
        MPIZZA_HUT.setTag(0);

        MBAKES_CAKES = mMap.addMarker(new MarkerOptions()
                .position(BAKES_CAKES)
                .title("BAKES & CAKES").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        MBAKES_CAKES.setTag(0);

        MWINDSOR= mMap.addMarker(new MarkerOptions()
                .position(WINDSOR)
                .title("WINDSOR_STREET").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        MWINDSOR.setTag(0);

        MSANDWEDGES = mMap.addMarker(new MarkerOptions()
                .position(SANDWEDGES)
                .title("SANDWEDGES").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        MSANDWEDGES.setTag(0);

        MSHIPRA_MALL = mMap.addMarker(new MarkerOptions()
                .position(SHIPRA_MALL)
                .title("SHIPRA MALL").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        MSHIPRA_MALL.setTag(0);

        MROLLS_KING = mMap.addMarker(new MarkerOptions()
                .position(ROLLS_KING)
                .title("ROLLS KING").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        MROLLS_KING.setTag(0);

        MADITYA_MALL = mMap.addMarker(new MarkerOptions()
                .position(ADITYA_MALL)
                .title("ADITYA MALL").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        MADITYA_MALL.setTag(0);

        MJAIPURIA_MALL = mMap.addMarker(new MarkerOptions()
                .position(JAIPURIA_MALL)
                .title("JAIPURIA MALL").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        MJAIPURIA_MALL.setTag(0);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTitle().equals("DOMINOS")) {
                    Intent intent =new Intent(MapsActivity2.this,dominos.class);
                    startActivity(intent);

                    Toast.makeText(MapsActivity2.this,"DOMINOS",Toast.LENGTH_SHORT).show();

                    return true;
                }
                if(marker.getTitle().equals("SANDWEDGES")) {

                    Intent intent =new Intent(MapsActivity2.this,sandwedges.class);
                    startActivity(intent);

                    Toast.makeText(MapsActivity2.this,"SANDWEDGES",Toast.LENGTH_SHORT).show();

                    return true;

                }
                if(marker.getTitle().equals("PIZZA_HUT")) {

                    Intent intent =new Intent(MapsActivity2.this,pizza_hut.class);
                    startActivity(intent);

                    Toast.makeText(MapsActivity2.this,"PIZZA HUT",Toast.LENGTH_SHORT).show();

                    return true;

                }
                if(marker.getTitle().equals("BAKES & CAKES")) {

                    Intent intent =new Intent(MapsActivity2.this,bakes_cakes.class);
                    startActivity(intent);

                    Toast.makeText(MapsActivity2.this,"BAKES AND CAKES",Toast.LENGTH_SHORT).show();

                    return true;

                }

                if(marker.getTitle().equals("ROLLS KING")) {

                    Intent intent =new Intent(MapsActivity2.this,rolls_king.class);
                    startActivity(intent);

                    Toast.makeText(MapsActivity2.this,"ROLLS KING",Toast.LENGTH_SHORT).show();

                    return true;

                }
                if(marker.getTitle().equals("SHIPRA MALL")) {

                    Intent intent =new Intent(MapsActivity2.this,shipra_mall.class);
                    startActivity(intent);

                    Toast.makeText(MapsActivity2.this,"SHIPRA MALL",Toast.LENGTH_SHORT).show();

                    return true;

                }
                if(marker.getTitle().equals("WINDSOR_STREET")) {

                    Intent intent =new Intent(MapsActivity2.this,windsor_street.class);
                    startActivity(intent);

                    Toast.makeText(MapsActivity2.this,"WINDSOR STREET",Toast.LENGTH_SHORT).show();

                    return true;

                }
                if(marker.getTitle().equals("JAIPURIA MALL")) {

                    Intent intent =new Intent(MapsActivity2.this,jaipuria_mall.class);
                    startActivity(intent);

                    Toast.makeText(MapsActivity2.this,"JAIPURIA MALL",Toast.LENGTH_SHORT).show();
                    return true;

                }
                if(marker.getTitle().equals("ADITYA MALL")) {

                    Intent intent =new Intent(MapsActivity2.this,aditya_mall.class);
                    startActivity(intent);

                    Toast.makeText(MapsActivity2.this,"ADITYA MALL",Toast.LENGTH_SHORT).show();
                    return true;

                }
                return false;
            }
        });








    }
}
