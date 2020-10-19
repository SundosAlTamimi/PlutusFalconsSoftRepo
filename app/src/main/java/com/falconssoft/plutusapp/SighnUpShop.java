package com.falconssoft.plutusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
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
import com.google.android.gms.maps.model.PolylineOptions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SighnUpShop extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sighn_up_shop);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        mMapView.getMap().setOnMapClickListener(new GoogleMap.OnMapClickListener()
//        {
//            @Override
//            public void onMapClick(LatLng arg0)
//            {
//                android.util.Log.i("onMapClick", "Horray!");
//            }
//        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
//        googleMap.addMarker(new MarkerOptions()
//                .position(new LatLng(0, 0))
//                .title("Marker"));

        mMap = googleMap;

        mMap = googleMap;
//        PolylineOptions polylineOptions = new PolylineOptions();
        LatLng latLng = new LatLng(31.9695148,35.9140312);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
//        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.bakery));

        mMap.addMarker(markerOptions);
//        mMap.setMaxZoomPreference(200);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        float zoomLevel = 16.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));
//        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//                                          @Override
//                                          public boolean onMarkerClick(Marker m) {
//                                              Log.e("Marker",""+m.getTitle());
//                                              Toast.makeText(SighnUpShop.this, ""+m.getTitle(), Toast.LENGTH_SHORT).show();
//                                              return true;
//
//
//                                          }
//                                      });
//        polylineOptions.add(latLng)
//                            .color(Color.RED)
//                            .width(2);
//                    mMap.addPolyline(polylineOptions);
//        today = convertToEnglish(today);

//        List<SalesmanStations> stations = new DatabaseHandler(SalesmanMap.this).getAllSalesmanSatation(Login.salesMan, today);

//        Log.e("size " , "" + stations.size());

//        for (int i = 0; i < stations.size(); i++) {
//            for (int j = 0; j < stations.size(); j++) {
//                if (stations.get(j).getSerial() == i + 1) {
//                    LatLng latLng = new LatLng(Double.parseDouble(stations.get(j).getLatitude()), Double.parseDouble(stations.get(j).getLongitude()));
//                    MarkerOptions markerOptions = new MarkerOptions();
//                    markerOptions.position(latLng);
//                    markerOptions.title("(" + stations.get(j).getSerial() + ") " + stations.get(j).getCustName());
//
//
//                    if (stations.get(j).getSerial() == 1)
//                        mMap.addMarker(markerOptions).showInfoWindow();
//                    else
//                        mMap.addMarker(markerOptions);
//
//                    mMap.setMaxZoomPreference(20);
//                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));
//
//                    polylineOptions.add(latLng)
//                            .color(Color.RED)
//                            .width(2);
//                    mMap.addPolyline(polylineOptions);
//                    break;
//                }
//            }
//        }

    }
}
