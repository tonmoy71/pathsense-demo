package tonmoy71.github.io.pathsensedemo.map;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.List;
import tonmoy71.github.io.pathsensedemo.R;

/**
 * Created by Fahim on 07-Apr-17.
 */

public class GoogleMapImpl implements GoogleMapWrapper {

  private static final float ZOOM_LEVEL_STREET = 15.0f;
  private GoogleMap mMap;
  private Marker mCurrentLocationMarker;
  private Polyline mPath;
  private boolean mNeedCameraMovement = true;

  @Override public void initialize(GoogleMap googleMap) {
    this.mMap = googleMap;
  }

  @Override public void showMarker(LatLng position) {
    mMap.addMarker(new MarkerOptions().position(position));
  }

  @Override public void showCurrentLocationMarker(LatLng position) {
    removeCurrentMarker();
    mCurrentLocationMarker = mMap.addMarker(new MarkerOptions().position(position)
        .title("Me!")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_person_pin_teal_500_24dp)));
    if (mNeedCameraMovement) {
      animateCamera(position);
    }
    mNeedCameraMovement = false;
  }

  private void removeCurrentMarker() {
    if (mCurrentLocationMarker != null) {
      mCurrentLocationMarker.remove();
    }
  }

  @Override public void drawPolyline(List<LatLng> locationList) {
    removePolyline();
    mPath = mMap.addPolyline(new PolylineOptions().addAll(locationList));
  }

  @Override public void animateCamera(LatLng position) {
    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(position, ZOOM_LEVEL_STREET));
  }

  private void removePolyline() {
    if (mPath != null) {
      mPath.remove();
    }
  }
}
