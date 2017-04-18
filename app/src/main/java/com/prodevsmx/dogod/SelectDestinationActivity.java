package com.prodevsmx.dogod;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class SelectDestinationActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mapGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_destination);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        startMap();
    }

    private void startMap(){
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap mGoogleMap) {
        mapGoogleMap = mGoogleMap;
        goToLocation(25.1941287,55.2736491,16);
    }

    private void goToLocation(double lat, double lng, float zoom) {
        LatLng location = new LatLng(lat,lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(location,zoom);
        mapGoogleMap.moveCamera(update);
    }


}
