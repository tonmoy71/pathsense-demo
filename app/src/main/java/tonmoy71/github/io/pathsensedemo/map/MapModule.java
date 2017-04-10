package tonmoy71.github.io.pathsensedemo.map;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Fahim on 10-Apr-17.
 */
@Module public class MapModule {

  @Provides @Singleton public GoogleMapWrapper providesGoogleMap() {
    return new GoogleMapImpl();
  }
}
