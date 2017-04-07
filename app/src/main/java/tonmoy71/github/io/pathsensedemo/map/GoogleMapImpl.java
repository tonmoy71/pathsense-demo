package tonmoy71.github.io.pathsensedemo.map;

import android.location.Location;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.List;
import tonmoy71.github.io.pathsensedemo.R;

/**
 * Created by Fahim on 07-Apr-17.
 */

public class GoogleMapImpl implements GoogleMapWrapper {

  private static final int ZOOM_LEVEL_STREET = 15;

  private GoogleMap mMap;
  private Marker mCurrentLocationMarker;

  @Override public void initialize(GoogleMap googleMap) {
    this.mMap = googleMap;
  }

  @Override public void showMarker(double latitude, double longitude) {
    removeMarker();
    LatLng position = new LatLng(latitude, longitude);
    mCurrentLocationMarker = mMap.addMarker(new MarkerOptions().position(position)
        .title("Me!")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_person_pin_teal_500_24dp)));
    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(position, ZOOM_LEVEL_STREET));
  }

  private void removeMarker() {
    if (mCurrentLocationMarker != null) {
      mCurrentLocationMarker.remove();
    }
  }

  @Override public void drawPolyline(List<Location> locationList) {

  }

  @Override public void removePolyline() {

  }
}
