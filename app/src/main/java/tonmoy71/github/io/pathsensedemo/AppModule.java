package tonmoy71.github.io.pathsensedemo;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Fahim on 10-Apr-17.
 */

@Module public class AppModule {

  private Application mApplication;

  public AppModule(Application application) {
    this.mApplication = application;
  }

  @Provides @Singleton public Context providesContext() {
    return mApplication;
  }
}