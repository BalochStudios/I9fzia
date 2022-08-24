package com.maps.i9fzia;


import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.maps.i9fzia.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    private Double deviceLatitude, deviceLongitude, destinationLatitude, destinationLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
        deviceLatitude = getIntent().getExtras().getDouble(MainActivity.DEVICE_LATITUDE);
        deviceLongitude = getIntent().getExtras().getDouble(MainActivity.DEVICE_LONGITUDE);
        destinationLatitude = getIntent().getExtras().getDouble(MainActivity.DESTINATION_LATITUDE);
        destinationLongitude = getIntent().getExtras().getDouble(MainActivity.DESTINATION_LONGITUDE);
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng userLocation = new LatLng(deviceLatitude, deviceLongitude);
        LatLng destination = new LatLng(destinationLatitude, destinationLongitude);
        mMap.addMarker(new MarkerOptions().position(userLocation).title("User's Location Marker"));
        mMap.addMarker(new MarkerOptions().position(destination).title("Destination Location Marker"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(destination));
    }
}