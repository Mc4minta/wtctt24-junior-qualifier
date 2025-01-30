package io.branch.referral;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import io.branch.referral.g0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceInfo.java */
/* loaded from: classes2.dex */
public class o {
    private static o a;

    /* renamed from: b  reason: collision with root package name */
    private final g0 f17093b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final Context f17094c;

    /* compiled from: DeviceInfo.java */
    /* loaded from: classes2.dex */
    private class a extends g0 {
        public a() {
        }
    }

    private o(Context context) {
        this.f17094c = context;
    }

    private String b(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                return WebSettings.getDefaultUserAgent(context);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o e() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o i(Context context) {
        if (a == null) {
            a = new o(context);
        }
        return a;
    }

    public static boolean j() {
        return b.l0() || i.d();
    }

    public static boolean k(String str) {
        return TextUtils.isEmpty(str) || str.equals("bnc_no_value");
    }

    public String a() {
        return g0.c(this.f17094c);
    }

    public long c() {
        return g0.d(this.f17094c);
    }

    public g0.c d() {
        h();
        return g0.q(this.f17094c, j());
    }

    public long f() {
        return g0.i(this.f17094c);
    }

    public String g() {
        return g0.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g0 h() {
        return this.f17093b;
    }

    public boolean l() {
        return g0.s(this.f17094c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(JSONObject jSONObject) {
        try {
            g0.c d2 = d();
            if (!k(d2.a())) {
                jSONObject.put(l.HardwareID.h(), d2.a());
                jSONObject.put(l.IsHardwareIDReal.h(), d2.b());
            }
            String m = g0.m();
            if (!k(m)) {
                jSONObject.put(l.Brand.h(), m);
            }
            String n = g0.n();
            if (!k(n)) {
                jSONObject.put(l.Model.h(), n);
            }
            DisplayMetrics o = g0.o(this.f17094c);
            jSONObject.put(l.ScreenDpi.h(), o.densityDpi);
            jSONObject.put(l.ScreenHeight.h(), o.heightPixels);
            jSONObject.put(l.ScreenWidth.h(), o.widthPixels);
            jSONObject.put(l.WiFi.h(), g0.r(this.f17094c));
            jSONObject.put(l.UIMode.h(), g0.p(this.f17094c));
            String k2 = g0.k();
            if (!k(k2)) {
                jSONObject.put(l.OS.h(), k2);
            }
            jSONObject.put(l.OSVersion.h(), g0.l());
            String f2 = g0.f();
            if (!TextUtils.isEmpty(f2)) {
                jSONObject.put(l.Country.h(), f2);
            }
            String g2 = g0.g();
            if (!TextUtils.isEmpty(g2)) {
                jSONObject.put(l.Language.h(), g2);
            }
            String j2 = g0.j();
            if (TextUtils.isEmpty(j2)) {
                return;
            }
            jSONObject.put(l.LocalIP.h(), j2);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Context context, q qVar, JSONObject jSONObject) {
        try {
            g0.c d2 = d();
            if (!k(d2.a()) && d2.b()) {
                jSONObject.put(l.AndroidID.h(), d2.a());
            } else {
                jSONObject.put(l.UnidentifiedDevice.h(), true);
            }
            String m = g0.m();
            if (!k(m)) {
                jSONObject.put(l.Brand.h(), m);
            }
            String n = g0.n();
            if (!k(n)) {
                jSONObject.put(l.Model.h(), n);
            }
            DisplayMetrics o = g0.o(this.f17094c);
            jSONObject.put(l.ScreenDpi.h(), o.densityDpi);
            jSONObject.put(l.ScreenHeight.h(), o.heightPixels);
            jSONObject.put(l.ScreenWidth.h(), o.widthPixels);
            String k2 = g0.k();
            if (!k(k2)) {
                jSONObject.put(l.OS.h(), k2);
            }
            jSONObject.put(l.OSVersion.h(), g0.l());
            String f2 = g0.f();
            if (!TextUtils.isEmpty(f2)) {
                jSONObject.put(l.Country.h(), f2);
            }
            String g2 = g0.g();
            if (!TextUtils.isEmpty(g2)) {
                jSONObject.put(l.Language.h(), g2);
            }
            String j2 = g0.j();
            if (!TextUtils.isEmpty(j2)) {
                jSONObject.put(l.LocalIP.h(), j2);
            }
            if (qVar != null) {
                if (!k(qVar.s())) {
                    jSONObject.put(l.DeviceFingerprintID.h(), qVar.s());
                }
                String x = qVar.x();
                if (!k(x)) {
                    jSONObject.put(l.DeveloperIdentity.h(), x);
                }
            }
            jSONObject.put(l.AppVersion.h(), a());
            jSONObject.put(l.SDK.h(), "android");
            jSONObject.put(l.SdkVersion.h(), "3.2.0");
            jSONObject.put(l.UserAgent.h(), b(context));
        } catch (JSONException unused) {
        }
    }
}