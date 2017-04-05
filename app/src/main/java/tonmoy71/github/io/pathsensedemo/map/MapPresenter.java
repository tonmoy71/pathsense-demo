package tonmoy71.github.io.pathsensedemo.map;

import com.pathsense.android.sdk.location.PathsenseLocationProviderApi;
import java.util.Observable;
import java.util.Observer;
import tonmoy71.github.io.pathsensedemo.location.LocationObservable;
import tonmoy71.github.io.pathsensedemo.location.LocationUpdateReceiver;

/**
 * Created by Fahim on 05-Apr-17.
 */

public class MapPresenter implements Observer {

  private LocationObservable mObservable = LocationObservable.getInstance();
  private MapView mView;
  private PathsenseLocationProviderApi mLocationApi;

  public MapPresenter(MapView mView) {
    this.mView = mView;
  }

  public void startLocationUpdate() {
    mObservable.addObserver(this);
    mLocationApi = PathsenseLocationProviderApi.getInstance(mView.getContext());
    PathsenseLocationProviderApi api = mLocationApi;
    api.requestInVehicleLocationUpdates(LocationUpdateReceiver.class);
  }

  public void stopLocationUpdate() {
    mLocationApi.removeInVehicleLocationUpdates();
  }

  @Override public void update(Observable observable, Object data) {
    mView.onLocationUpdate(mObservable.getLocation());
  }
}
