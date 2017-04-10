package tonmoy71.github.io.pathsensedemo.main;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import javax.inject.Inject;
import tonmoy71.github.io.pathsensedemo.PathsenseApp;
import tonmoy71.github.io.pathsensedemo.R;

public class MainActivity extends AppCompatActivity implements MainView, OnMapReadyCallback {

  private static final String TAG = MainActivity.class.getSimpleName();
  @Inject MainPresenter mPresenter;
  @Inject Context mContext;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_map);
    ((PathsenseApp) getApplication()).getComponent().inject(this);
    SupportMapFragment mapFragment =
        (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
    mPresenter.initializeView(this);
    mPresenter.startLocationUpdate();
  }

  @Override public void onLocationUpdate(Location location) {
    double latitude = location.getLatitude();
    double longitude = location.getLongitude();
    Log.d(TAG, "onLocationUpdate() called with: location = [" + location + "]");

    mPresenter.showCurrentPosition(latitude, longitude);
    mPresenter.showPath(latitude, longitude);
  }

  @Override public Context getContext() {
    return mContext;
  }

  @Override protected void onPause() {
    super.onPause();
    mPresenter.stopLocationUpdate();
  }

  @Override public void onMapReady(GoogleMap googleMap) {
    mPresenter.initializeMap(googleMap);
  }
}
