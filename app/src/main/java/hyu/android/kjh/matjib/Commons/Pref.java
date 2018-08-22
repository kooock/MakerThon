package hyu.android.kjh.matjib.Commons;

import android.content.Context;
import android.content.SharedPreferences;

public class Pref {

    private static SharedPreferences preferences = null;

    private static final String AUTO_LOGIN = "AutoLogin";

    private static final String SHARED_PREF_NAME = "HYU.ANDROID.King";

    public static void init(Context context) {
        preferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }
    public static boolean getAutoLogin() {
        boolean checked = false;
        if (preferences != null)
            checked = preferences.getBoolean(Pref.AUTO_LOGIN, false);
        return checked;
    }
    public static void setAutoLogin(boolean isAuto) {
        if (preferences != null) {
            preferences.edit().putBoolean(AUTO_LOGIN, isAuto).apply();
            Constants.autoLogin = isAuto;
        }
    }
}
