package tonmoy71.github.io.pathsensedemo.map;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import tonmoy71.github.io.pathsensedemo.R;

public class MapActivity extends AppCompatActivity implements MapView {

  private static final String TAG = MapActivity.class.getSimpleName();
  private MapPresenter mPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_map);

    mPresenter = new MapPresenter(this);
    mPresenter.startLocationUpdate();
  }

  @Override public void onLocationUpdate(Location location) {
    String message =
        location.getLatitude() + ", " + location.getLongitude() + ", " + location.getAccuracy();
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  @Override public Context getContext() {
    return getApplicationContext();
  }

  @Override protected void onPause() {
    super.onPause();
    mPresenter.stopLocationUpdate();
  }
}
