package com.svalero.deliveryapp.task;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.maps.model.Marker;
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
import java.util.concurrent.TimeUnit;

// TODO Mejorar el diseño estilo MVP
public class RouteTask extends AsyncTask<Void, Void, DirectionsResult> {

    private boolean error = false;
    private ProgressBar progressBar;
    private DirectionsApiRequest request;
    private Context context;
    private Marker initialMarker, finalMarker;

    public RouteTask(Context context, Marker initialMarker, Marker finalMarker) {
        this.context = context;
        this.initialMarker = initialMarker;
        this.finalMarker = finalMarker;
    }

    private GeoApiContext getGeoContext() {
        GeoApiContext geoApiContext = new GeoApiContext();
        return geoApiContext.setQueryRateLimit(3)
                .setApiKey(context.getString(R.string.google_maps_key))
                .setConnectTimeout(1, TimeUnit.SECONDS)
                .setReadTimeout(1, TimeUnit.SECONDS)
                .setWriteTimeout(1, TimeUnit.SECONDS);
    }

    @Override
    protected DirectionsResult doInBackground(Void... input) {
        try {
            return request.await();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } catch (ApiException apie) {
            error = true;
            apie.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressBar = ((Activity) context).findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setIndeterminate(true);

        request = DirectionsApi.newRequest(getGeoContext())
                .mode(TravelMode.DRIVING)
                .origin(DirectionUtils.fromMapsToDirectionsApi(initialMarker.getPosition()))
                .destination(DirectionUtils.fromMapsToDirectionsApi(finalMarker.getPosition()))
                .departureTime(DateTime.now())
                .alternatives(true);
    }

    @Override
    protected void onPostExecute(DirectionsResult directionsResult) {
        super.onPostExecute(directionsResult);

        progressBar.setVisibility(View.GONE);

        if (error) {
            Toast.makeText(context,
                    "Se ha producido un error al conectar con la API", Toast.LENGTH_SHORT).show();
        }

        if (directionsResult.routes.length == 0) {
            Toast.makeText(context, "No hay rutas entre los 2 puntos", Toast.LENGTH_SHORT).show();
        }
    }
}
