package tonmoy71.github.io.pathsensedemo.map;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/**
 * Created by Fahim on 07-Apr-17.
 */

public interface GoogleMapWrapper {

  void initialize(GoogleMap googleMap);

  void showMarker(LatLng position);

  void drawPolyline(List<LatLng> locationList);

  void animateCamera(LatLng position);

  void showCurrentLocationMarker(LatLng position);

}
