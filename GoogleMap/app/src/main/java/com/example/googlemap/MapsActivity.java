package com.example.googlemap;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ImageButton ubica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());

        if (status == ConnectionResult.SUCCESS) {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        } else {
            Toast.makeText(getApplicationContext(), "No es posible iniciar mapa ", Toast.LENGTH_LONG).show();
            finish();
        }

//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }
//
//        mMap.setMyLocationEnabled(true);
//        mMap.getUiSettings().setMyLocationButtonEnabled(true);
//
//        UiSettings uiSettings = mMap.getUiSettings();
//        uiSettings.setZoomControlsEnabled(true);
//
//        //CODIGO AL HACER ONCLICK AL BOTON PARA ACEPTAR LA UBICACION Y OBTENER COORDENADAS
//        ubica = (ImageButton)findViewById(R.id.);
//        ubica.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
//                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);
//                Location myLocation = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
//                double longitude = myLocation.getLongitude();
//                double latitude = myLocation.getLatitude();
//
//                private final LocationListener locationListener = new LocationListener() {
//                    public void onLocationChanged(Location location) {
//                        longitude = location.getLongitude();
//                        latitude = location.getLatitude();
//                    }
//                }
//
//            }
//        });

        // Add a marker in Sydney and move the camera

        double lat = Double.parseDouble(getIntent().getStringExtra("latitud"));
        double lon = Double.parseDouble(getIntent().getStringExtra("longitud"));
        LatLng latlon = new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(latlon).title("Bienvenido a Venezuela"));

        CameraPosition camPos = new CameraPosition.Builder()
                .target(latlon)   //Centramos el mapa en Madrid
                .zoom(19)         //Establecemos el zoom en 19
                .bearing(45)      //Establecemos la orientación con el noreste arriba
                .tilt(60)         //Bajamos el punto de vista de la cámara 70 grados
                .build();

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latlon));

        //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlon,18),5000,null);

        CameraUpdate camUpd3 = CameraUpdateFactory.newCameraPosition(camPos);

        mMap.animateCamera(camUpd3,5000,null);
    }
}
