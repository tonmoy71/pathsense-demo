package tonmoy71.github.io.pathsensedemo.map;

import android.location.Location;
import com.google.android.gms.maps.GoogleMap;
import java.util.List;

/**
 * Created by Fahim on 07-Apr-17.
 */

public interface GoogleMapWrapper {

  void initialize(GoogleMap googleMap);

  void showMarker(double latitude, double longitude);

  void drawPolyline(List<Location> locationList);

  void removePolyline();
}
