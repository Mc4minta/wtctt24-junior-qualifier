package e.j.f;

import android.app.Activity;
import android.os.Build;
import android.widget.Toast;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import java.util.concurrent.Executor;

/* compiled from: ActivityExtensions.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final void a(Activity this_mainExecutorCompat, Runnable runnable) {
        kotlin.jvm.internal.m.g(this_mainExecutorCompat, "$this_mainExecutorCompat");
        this_mainExecutorCompat.runOnUiThread(runnable);
    }

    public static final void b(androidx.fragment.app.d dVar, BiometricPrompt.b callback, BiometricPrompt.d cryptoObject, BiometricPrompt.e promptInfo) {
        kotlin.jvm.internal.m.g(dVar, "<this>");
        kotlin.jvm.internal.m.g(callback, "callback");
        kotlin.jvm.internal.m.g(cryptoObject, "cryptoObject");
        kotlin.jvm.internal.m.g(promptInfo, "promptInfo");
        Fragment Z = dVar.getSupportFragmentManager().Z("FingerprintDialogFragment");
        Fragment Z2 = dVar.getSupportFragmentManager().Z("FingerprintHelperFragment");
        Fragment Z3 = dVar.getSupportFragmentManager().Z("BiometricFragment");
        androidx.fragment.app.u j2 = dVar.getSupportFragmentManager().j();
        kotlin.jvm.internal.m.f(j2, "supportFragmentManager.beginTransaction()");
        if (Z != null) {
            j2.r(Z);
        }
        if (Z2 != null) {
            j2.r(Z2);
        }
        if (Z3 != null) {
            j2.r(Z3);
        }
        j2.l();
        new BiometricPrompt(dVar, e(dVar), callback).t(promptInfo, cryptoObject);
    }

    public static /* synthetic */ void c(androidx.fragment.app.d dVar, BiometricPrompt.b bVar, BiometricPrompt.d dVar2, BiometricPrompt.e eVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            eVar = h.b(dVar, null, null, null, null, 15, null);
        }
        b(dVar, bVar, dVar2, eVar);
    }

    public static final NavController d(Activity activity, int i2) {
        kotlin.jvm.internal.m.g(activity, "<this>");
        NavController a = androidx.navigation.r.a(activity, i2);
        kotlin.jvm.internal.m.f(a, "findNavController(this, viewId)");
        return a;
    }

    public static final Executor e(final Activity activity) {
        kotlin.jvm.internal.m.g(activity, "<this>");
        if (Build.VERSION.SDK_INT >= 28) {
            Executor mainExecutor = activity.getMainExecutor();
            kotlin.jvm.internal.m.f(mainExecutor, "{\n        mainExecutor\n    }");
            return mainExecutor;
        }
        return new Executor() { // from class: e.j.f.a
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                c.f(activity, runnable);
            }
        };
    }

    public static /* synthetic */ void f(Activity activity, Runnable runnable) {
        a(activity, runnable);
    }

    public static final void g(Activity activity) {
        kotlin.jvm.internal.m.g(activity, "<this>");
        activity.setRequestedOrientation(1);
    }

    public static final void h(Activity activity, int i2, int i3) {
        kotlin.jvm.internal.m.g(activity, "<this>");
        Toast.makeText(activity, i2, i3).show();
    }

    public static final void i(Activity activity) {
        kotlin.jvm.internal.m.g(activity, "<this>");
        activity.setRequestedOrientation(2);
    }
}