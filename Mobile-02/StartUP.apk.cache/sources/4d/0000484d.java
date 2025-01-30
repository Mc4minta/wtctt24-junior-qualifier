package e.g.a.e.g;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.f;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.util.g;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class a {
    private static final f a = f.f();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f13190b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static Method f13191c = null;

    public static void a(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        t.l(context, "Context must not be null");
        a.k(context, 11925000);
        Context b2 = b(context);
        if (b2 == null) {
            b2 = c(context);
        }
        if (b2 != null) {
            synchronized (f13190b) {
                try {
                    try {
                        if (f13191c == null) {
                            f13191c = b2.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", Context.class);
                        }
                        f13191c.invoke(null, b2);
                    } catch (Exception e2) {
                        Throwable cause = e2.getCause();
                        if (Log.isLoggable("ProviderInstaller", 6)) {
                            String valueOf = String.valueOf(cause == null ? e2.getMessage() : cause.getMessage());
                            Log.e("ProviderInstaller", valueOf.length() != 0 ? "Failed to install provider: ".concat(valueOf) : new String("Failed to install provider: "));
                        }
                        throw new GooglePlayServicesNotAvailableException(8);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        Log.e("ProviderInstaller", "Failed to get remote context");
        throw new GooglePlayServicesNotAvailableException(8);
    }

    private static Context b(Context context) {
        try {
            return DynamiteModule.e(context, DynamiteModule.f6358k, "providerinstaller").b();
        } catch (DynamiteModule.LoadingException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("ProviderInstaller", valueOf.length() != 0 ? "Failed to load providerinstaller module: ".concat(valueOf) : new String("Failed to load providerinstaller module: "));
            return null;
        }
    }

    private static Context c(Context context) {
        try {
            return h.d(context);
        } catch (Resources.NotFoundException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("ProviderInstaller", valueOf.length() != 0 ? "Failed to load GMS Core context for providerinstaller: ".concat(valueOf) : new String("Failed to load GMS Core context for providerinstaller: "));
            g.a(context, e2);
            return null;
        }
    }
}