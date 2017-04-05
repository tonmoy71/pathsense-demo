package tonmoy71.github.io.pathsensedemo.location;

import android.location.Location;
import java.util.Observable;

/**
 * Created by Fahim on 05-Apr-17.
 */

public class LocationObservable extends Observable {

  private static LocationObservable sInstance;
  private Location mLocation;

  public static LocationObservable getInstance() {
    if (sInstance == null) {
      return sInstance = new LocationObservable();
    }
    return sInstance;
  }

  public void updateLocation(Location location) {
    this.mLocation = location;

    synchronized (this) {
      setChanged();
      notifyObservers();
    }
  }

  public Location getLocation() {
    return mLocation;
  }
}
