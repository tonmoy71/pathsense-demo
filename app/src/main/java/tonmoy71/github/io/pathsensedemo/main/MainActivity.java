package tonmoy71.github.io.pathsensedemo.main;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import tonmoy71.github.io.pathsensedemo.R;

public class MainActivity extends AppCompatActivity implements MainView, OnMapReadyCallback {

  private static final String TAG = MainActivity.class.getSimpleName();
  private MainPresenter mPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_map);

    // TODO: 07-Apr-17 Inject dependency
    mPresenter = new MainPresenter(this);
    mPresenter.startLocationUpdate();

    SupportMapFragment mapFragment =
        (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
  }

  @Override public void onLocationUpdate(Location location) {
    double latitude = location.getLatitude();
    double longitude = location.getLongitude();
    Log.d(TAG, "onLocationUpdate() called with: location = [" + location + "]");

    mPresenter.showCurrentPosition(latitude, longitude);
    mPresenter.showPath(latitude, longitude);
  }

  @Override public Context getContext() {
    return getApplicationContext();
  }

  @Override protected void onPause() {
    super.onPause();
    mPresenter.stopLocationUpdate();
  }

  @Override public void onMapReady(GoogleMap googleMap) {
    mPresenter.initializeMap(googleMap);
  }
}
