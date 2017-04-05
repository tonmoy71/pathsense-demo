package tonmoy71.github.io.pathsensedemo.map;

import android.content.Context;
import android.location.Location;

/**
 * Created by Fahim on 05-Apr-17.
 */

public interface MapView {
  void onLocationUpdate(Location location);
  Context getContext();
}
