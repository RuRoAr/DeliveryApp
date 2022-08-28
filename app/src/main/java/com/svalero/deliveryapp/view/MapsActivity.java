package com.svalero.deliveryapp.view;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;
import com.svalero.deliveryapp.R;
import com.svalero.deliveryapp.util.DirectionUtils;


import org.joda.time.DateTime;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap map;
    private Marker initialMarker, finalMarker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setOnMapClickListener(this);

    }

    @Override
    public void onMapClick(LatLng position) {
        Marker newMarker = map.addMarker(new MarkerOptions()
                .title("Ubicación del usuario")
                .position(position));

        if (initialMarker == null)
            initialMarker = newMarker;
        else
            finalMarker = newMarker;
    }

    public void showRoute(View view) {
        if ((initialMarker == null) || (finalMarker == null)) {
            Toast.makeText(this, "Debes seleccionar 2 puntos en el mapa", Toast.LENGTH_SHORT).show();
            return;
        }

//        RouteTask routeTask = new RouteTask(this, initialMarker, finalMarker);
//        routeTask.execute();
//        DirectionsResult result = null;
//        try {
//            result = routeTask.get();
//            if (result.routes.length != 0)
//                paintRoute(result, 0);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        CompletableFuture<DirectionsResult> completableFuture = CompletableFuture.supplyAsync(() -> {
            return null;
        }).handle((result, throwable) -> {
            return null;
        });

        try {
            DirectionsResult result = completableFuture.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void paintRoute(DirectionsResult result, int position) {
        List<com.google.maps.model.LatLng> routePath = result.routes[position].overviewPolyline.decodePath();
        map.addPolyline(new PolylineOptions()
                .add(DirectionUtils.fromMapsToDirections(routePath))
                .color(Color.RED));
        Log.d("sanvalero", routePath.toString());
    }

    public void resetMarkers(View view) {
        map.clear();
        initialMarker = null;
        finalMarker = null;
    }
}