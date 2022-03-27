package com.example.geolvide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Tile;

public class MapaActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker markerPrueba;

    double Latitud_number;
    double Longitud_number;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
                mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
        Bundle extras= getIntent().getExtras();
        if(extras !=null){
            String value = extras.getString("Lati");
            Latitud_number=Double.valueOf(value);
            String value2= extras.getString("Longi");
            Longitud_number=Double.valueOf(value2);
        }

        LatLng ubicacion=new LatLng(Latitud_number, Longitud_number);
        mMap.addMarker(new MarkerOptions().position(ubicacion).title("Ubicación seleccionada"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));

        LatLng prueba= new LatLng(Latitud_number, -Longitud_number);
        markerPrueba= googleMap.addMarker(new MarkerOptions()
                .position(prueba)
                .title("prueba")
        );

        googleMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) this);

    }
}