package tonmoy71.github.io.pathsensedemo.location;

import android.content.Context;
import com.pathsense.android.sdk.location.PathsenseInVehicleLocation;
import com.pathsense.android.sdk.location.PathsenseInVehicleLocationUpdateReceiver;

/**
 * Created by Fahim on 05-Apr-17.
 */

public class LocationUpdateReceiver extends PathsenseInVehicleLocationUpdateReceiver {
  private static final String TAG = LocationUpdateReceiver.class.getSimpleName();

  @Override
  protected void onInVehicleLocationUpdate(Context context, PathsenseInVehicleLocation location) {
    if (location != null) {
      LocationObservable observable = LocationObservable.getInstance();
      observable.updateLocation(location);
    }
  }
}
