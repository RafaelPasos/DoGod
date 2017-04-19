package com.prodevsmx.dogod;

import android.content.Intent;
import android.content.pm.ActivityInfo;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.Manifest;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class SelectDestinationActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    GoogleMap mapGoogleMap;
    GoogleApiClient mapGoogleClient;
    LocationRequest mapLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_destination);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        startMap();
    }

    private void startMap() {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap mGoogleMap) {
        mapGoogleMap = mGoogleMap;
        mapGoogleClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        mapGoogleClient.connect();
    }

    private void goToLocation(double lat, double lng, float zoom) {
        LatLng location = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(location, zoom);
        mapGoogleMap.moveCamera(update);
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mapLocationRequest = LocationRequest.create();
        mapLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mapLocationRequest.setInterval(10000);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //si no tiene permiso
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
                //LocationServices.FusedLocationApi.requestLocationUpdates(mapGoogleClient, mapLocationRequest, this);
                return;
            } else {
                //Si tiene permiso
                LocationServices.FusedLocationApi.requestLocationUpdates(mapGoogleClient, mapLocationRequest, this);
            }
        } else {
            LocationServices.FusedLocationApi.requestLocationUpdates(mapGoogleClient, mapLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(this,"asereje",Toast.LENGTH_SHORT);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(SelectDestinationActivity.this,"asjdnasd",Toast.LENGTH_SHORT);
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location == null){
            Toast.makeText(SelectDestinationActivity.this, "Can't get current location", Toast.LENGTH_SHORT);
        }else{
            goToLocation(location.getLatitude(),location.getLongitude(), 19);
        }
    }
}
