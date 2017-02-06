package at.fh.valuvi.resifo.components;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

public class MyLocationListener implements LocationListener {
    @Override
    public void onLocationChanged(Location loc) {
        loc.getLatitude();
        loc.getLongitude();
        String Text = "My current location is: " +
                "Latitud = " + loc.getLatitude() +
                "Longitud = " + loc.getLongitude();
        Toast.makeText(Application.getAppContext(),
                Text,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(Application.getAppContext(),
                "Gps Disabled",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(Application.getAppContext(),
                "Gps Enabled",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}
}