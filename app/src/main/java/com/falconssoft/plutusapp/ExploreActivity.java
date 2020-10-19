package com.falconssoft.plutusapp;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.falconssoft.plutusapp.models.AccountInfoModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class ExploreActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    MapView mapView;
    TextView text1,text2,text3;
    private CategoryAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore_activity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        text1=findViewById(R.id.tex1);
        text2=findViewById(R.id.tex2);
        text3=findViewById(R.id.tex3);

        mapView=findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ExploreActivity.this,WithdrawPage.class);

                intent.putExtra("Explore","Explore");

                startActivity(intent);

            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ExploreActivity.this,WithdrawPage.class);

                intent.putExtra("Explore","Explore");

                startActivity(intent);

            }
        });
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ExploreActivity.this,WithdrawPage.class);

                intent.putExtra("Explore","Explore");

                startActivity(intent);

            }
        });

        List<AccountInfoModel> list = new ArrayList<>();
        list.add(new AccountInfoModel("Bakery", ""));
        list.add(new AccountInfoModel("Gas Station", ""));
        list.add(new AccountInfoModel("Restaurant", ""));
        list.add(new AccountInfoModel("Hair Salon", ""));
        list.add(new AccountInfoModel("Car Exhibition", ""));

        recyclerView = findViewById(R.id.withdraw_categories);
        adapter = new CategoryAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true));
        recyclerView.setAdapter(adapter);

//        mapView=findViewById(R.id.mapView);
//        mapView.onCreate(savedInstanceState);
//        mapView.getMapAsync(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(31.9695148,35.9140312);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("FalconS Soft"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        LatLng latLng = new LatLng(31.9695148,35.9140312);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
//        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.bakery));

        mMap.addMarker(markerOptions);
//        mMap.setMaxZoomPreference(200);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        float zoomLevel = 16.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));
    }
}
