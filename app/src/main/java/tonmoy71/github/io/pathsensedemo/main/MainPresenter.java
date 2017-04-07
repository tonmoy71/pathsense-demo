package tonmoy71.github.io.pathsensedemo.main;

import com.google.android.gms.maps.GoogleMap;
import com.pathsense.android.sdk.location.PathsenseLocationProviderApi;
import java.util.Observable;
import java.util.Observer;
import tonmoy71.github.io.pathsensedemo.location.LocationObservable;
import tonmoy71.github.io.pathsensedemo.location.LocationUpdateReceiver;
import tonmoy71.github.io.pathsensedemo.map.GoogleMapImpl;
import tonmoy71.github.io.pathsensedemo.map.GoogleMapWrapper;

/**
 * Created by Fahim on 05-Apr-17.
 */

public class MainPresenter implements Observer {

  private LocationObservable mObservable = LocationObservable.getInstance();
  private MainView mView;
  private PathsenseLocationProviderApi mLocationApi;
  private GoogleMapWrapper mapWrapper = new GoogleMapImpl();  // TODO: 07-Apr-17 Inject dependency

  public MainPresenter(MainView mView) {
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

  public void initializeMap(GoogleMap googleMap) {
    mapWrapper.initialize(googleMap);
  }

  public void showMarker(double latitude, double longitude) {
    mapWrapper.showMarker(latitude, longitude);
  }
}
