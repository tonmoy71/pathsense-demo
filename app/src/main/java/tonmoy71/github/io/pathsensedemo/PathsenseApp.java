package tonmoy71.github.io.pathsensedemo;

import android.app.Application;
import tonmoy71.github.io.pathsensedemo.map.MapModule;

/**
 * Created by Fahim on 10-Apr-17.
 */

public class PathsenseApp extends Application {

  private AppComponent mComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    mComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .mapModule(new MapModule())
        .build();

  }

  public AppComponent getComponent() {
    return mComponent;
  }
}
