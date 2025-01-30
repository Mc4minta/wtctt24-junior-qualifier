package e.g.a.e.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.h;

/* loaded from: classes2.dex */
public final class c {
    private SharedPreferences a;

    public c(Context context) {
        try {
            Context d2 = h.d(context);
            this.a = d2 == null ? null : d2.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", th);
            this.a = null;
        }
    }

    public final boolean a(String str, boolean z) {
        try {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.getBoolean(str, false);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float b(String str, float f2) {
        try {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null) {
                return 0.0f;
            }
            return sharedPreferences.getFloat(str, 0.0f);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c(String str, String str2) {
        try {
            SharedPreferences sharedPreferences = this.a;
            return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return str2;
        }
    }
}