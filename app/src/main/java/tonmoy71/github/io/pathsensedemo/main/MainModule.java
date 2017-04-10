package tonmoy71.github.io.pathsensedemo.main;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import tonmoy71.github.io.pathsensedemo.map.GoogleMapWrapper;

/**
 * Created by Fahim on 10-Apr-17.
 */

@Module public class MainModule {

  @Provides @Singleton public MainPresenter providesMainPresenter(GoogleMapWrapper wrapper) {
    return new MainPresenter(wrapper);
  }
}
