package tonmoy71.github.io.pathsensedemo;

import dagger.Component;
import javax.inject.Singleton;
import tonmoy71.github.io.pathsensedemo.main.MainActivity;
import tonmoy71.github.io.pathsensedemo.main.MainModule;
import tonmoy71.github.io.pathsensedemo.map.MapModule;

/**
 * Created by Fahim on 10-Apr-17.
 */

@Singleton @Component(modules = { AppModule.class, MapModule.class, MainModule.class })
public interface AppComponent {
  void inject(MainActivity target);
  void inject(PathsenseApp target);
}