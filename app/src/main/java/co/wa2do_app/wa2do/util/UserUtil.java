package co.wa2do_app.wa2do.util;

import android.content.Context;
import android.content.SharedPreferences;

public class UserUtil {

    private static final String SHARED_PREFS_NAME = "userUtilSharedPrefs";
    private static final String USER_BROWSED_TOPICS = "userBrowsedTopics";

    private Context mContext;

    public UserUtil(Context context) {
        mContext = context;
    }

    public boolean isUserBrowsedTopics() {
        SharedPreferences preferences = mContext.getSharedPreferences(SHARED_PREFS_NAME, 0);

        return preferences.getBoolean(USER_BROWSED_TOPICS, false);
    }

    public void updateUserBrowsedTopics(boolean isUserBrowsedTopics) {
        SharedPreferences.Editor prefsEditor = mContext.getSharedPreferences(SHARED_PREFS_NAME, 0).edit();
        prefsEditor.putBoolean(USER_BROWSED_TOPICS, isUserBrowsedTopics);

        prefsEditor.commit();
    }

}
