package co.wa2do_app.wa2do.application;

import android.app.Application;
import co.wa2do_app.wa2do.modules.ActivityModule;
import co.wa2do_app.wa2do.modules.UtilModule;
import dagger.ObjectGraph;

import java.util.Arrays;
import java.util.List;

public class Wa2DoApplication extends Application {

    private static ObjectGraph mObjectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        mObjectGraph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules() {
        return Arrays.asList(new UtilModule(this),
                             new ActivityModule());
    }

    public static void inject(Object object) {
        mObjectGraph.inject(object);
    }

}
