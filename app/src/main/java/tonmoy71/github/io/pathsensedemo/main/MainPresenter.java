package tonmoy71.github.io.pathsensedemo.main;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.pathsense.android.sdk.location.PathsenseLocationProviderApi;
import java.util.ArrayList;
import java.util.List;
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

  private static final int LOCATION_UPDATE_INTERVAL_SECONDS = 60;
  private LocationObservable mObservable = LocationObservable.getInstance();
  private MainView mView;
  private PathsenseLocationProviderApi mLocationApi;
  private GoogleMapWrapper mMapWrapper = new GoogleMapImpl();  // TODO: 07-Apr-17 Inject dependency
  private List<LatLng> mPointList = new ArrayList<>();

  public MainPresenter(MainView mView) {
    this.mView = mView;
  }

  public void startLocationUpdate() {
    mObservable.addObserver(this);
    mLocationApi = PathsenseLocationProviderApi.getInstance(mView.getContext());
    PathsenseLocationProviderApi api = mLocationApi;
    api.requestInVehicleLocationUpdates(LOCATION_UPDATE_INTERVAL_SECONDS,
        LocationUpdateReceiver.class);
  }

  public void stopLocationUpdate() {
    mLocationApi.removeInVehicleLocationUpdates();
  }

  @Override public void update(Observable observable, Object data) {
    mView.onLocationUpdate(mObservable.getLocation());
  }

  public void initializeMap(GoogleMap googleMap) {
    mMapWrapper.initialize(googleMap);
  }

  public void showCurrentPosition(double latitude, double longitude) {
    mMapWrapper.showCurrentLocationMarker(new LatLng(latitude, longitude));
  }

  public void showPath(double lat, double lng) {
    mPointList.add(new LatLng(lat, lng));
    mMapWrapper.drawPolyline(mPointList);
  }
}
