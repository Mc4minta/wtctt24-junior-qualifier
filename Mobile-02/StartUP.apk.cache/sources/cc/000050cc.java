package io.branch.referral;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BranchUtil.java */
/* loaded from: classes2.dex */
public class i {
    private static boolean a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f16980b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f16981c;

    static JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(Payload.SOURCE, "android");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Context context) {
        if (!f16980b && f16981c == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null && bundle.containsKey("io.branch.sdk.TestMode")) {
                    f16980b = applicationInfo.metaData.getBoolean("io.branch.sdk.TestMode", false);
                } else {
                    Resources resources = context.getResources();
                    f16980b = Boolean.parseBoolean(resources.getString(resources.getIdentifier("io.branch.sdk.TestMode", "string", context.getPackageName())));
                }
            } catch (Exception unused) {
            }
            f16981c = Boolean.valueOf(f16980b);
        }
        return f16980b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject c(JSONObject jSONObject) {
        return a(jSONObject);
    }

    public static boolean d() {
        return a || e();
    }

    public static boolean e() {
        return f16980b;
    }

    public static String f(Context context) {
        String str = e() ? "io.branch.sdk.BranchKey.test" : "io.branch.sdk.BranchKey";
        String str2 = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null && (str2 = bundle.getString(str)) == null && e()) {
                str2 = applicationInfo.metaData.getString("io.branch.sdk.BranchKey");
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            try {
                Resources resources = context.getResources();
                return resources.getString(resources.getIdentifier(str, "string", context.getPackageName()));
            } catch (Exception unused2) {
                return str2;
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(boolean z) {
        f16980b = z;
    }
}