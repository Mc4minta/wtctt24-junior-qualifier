package androidx.biometric;

import android.content.Context;
import android.hardware.biometrics.BiometricManager;
import android.os.Build;

/* compiled from: BiometricManager.java */
/* loaded from: classes.dex */
public class b {
    private final c.h.f.a.a a;

    /* renamed from: b  reason: collision with root package name */
    private final BiometricManager f979b;

    /* compiled from: BiometricManager.java */
    /* loaded from: classes.dex */
    private static class a {
        static int a(BiometricManager biometricManager) {
            return biometricManager.canAuthenticate();
        }

        static BiometricManager b(Context context) {
            return (BiometricManager) context.getSystemService(BiometricManager.class);
        }
    }

    private b(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f979b = a.b(context);
            this.a = null;
            return;
        }
        this.f979b = null;
        this.a = c.h.f.a.a.b(context);
    }

    public static b b(Context context) {
        return new b(context);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 29) {
            return a.a(this.f979b);
        }
        if (this.a.e()) {
            return !this.a.d() ? 11 : 0;
        }
        return 12;
    }
}