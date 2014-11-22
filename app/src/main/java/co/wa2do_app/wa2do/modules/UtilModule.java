package co.wa2do_app.wa2do.modules;

import android.content.Context;
import co.wa2do_app.wa2do.util.UserUtil;
import dagger.Module;
import dagger.Provides;

@Module(library = true)
public class UtilModule {

    private Context mContext;

    public UtilModule(Context context) {
        mContext = context;
    }

    @Provides
    UserUtil provideUserUtil() {
        return new UserUtil(mContext);
    }
}
