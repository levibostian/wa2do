package co.wa2do_app.wa2do.modules;

import co.wa2do_app.wa2do.activity.MainActivity;
import dagger.Module;

@Module(injects = {MainActivity.class}, complete = false)
public class ActivityModule {

    public ActivityModule() {
    }

}
