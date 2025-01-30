package e.j.f;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.biometric.BiometricPrompt;
import org.toshi.R;

/* compiled from: ContextExtensions.kt */
/* loaded from: classes2.dex */
public final class h {
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.biometric.BiometricPrompt.e a(android.content.Context r1, java.lang.CharSequence r2, java.lang.CharSequence r3, java.lang.CharSequence r4, java.lang.CharSequence r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.m.g(r1, r0)
            java.lang.String r1 = "title"
            kotlin.jvm.internal.m.g(r2, r1)
            java.lang.String r1 = "negativeButtonText"
            kotlin.jvm.internal.m.g(r3, r1)
            androidx.biometric.BiometricPrompt$e$a r1 = new androidx.biometric.BiometricPrompt$e$a
            r1.<init>()
            androidx.biometric.BiometricPrompt$e$a r1 = r1.e(r2)
            androidx.biometric.BiometricPrompt$e$a r1 = r1.c(r3)
            java.lang.String r2 = "Builder()\n        .setTitle(title)\n        .setNegativeButtonText(negativeButtonText)"
            kotlin.jvm.internal.m.f(r1, r2)
            r2 = 0
            r3 = 1
            if (r4 != 0) goto L27
        L25:
            r0 = r2
            goto L2f
        L27:
            boolean r0 = kotlin.l0.o.D(r4)
            r0 = r0 ^ r3
            if (r0 != r3) goto L25
            r0 = r3
        L2f:
            if (r0 == 0) goto L34
            r1.d(r4)
        L34:
            if (r5 != 0) goto L37
            goto L3f
        L37:
            boolean r4 = kotlin.l0.o.D(r5)
            r4 = r4 ^ r3
            if (r4 != r3) goto L3f
            r2 = r3
        L3f:
            if (r2 == 0) goto L44
            r1.b(r5)
        L44:
            androidx.biometric.BiometricPrompt$e r1 = r1.a()
            java.lang.String r2 = "builder.build()"
            kotlin.jvm.internal.m.f(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.f.h.a(android.content.Context, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence):androidx.biometric.BiometricPrompt$e");
    }

    public static /* synthetic */ BiometricPrompt.e b(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = context.getString(R.string.please_authenticate);
            kotlin.jvm.internal.m.f(charSequence, "fun Context.buildBiometricPromptInfo(\n    title: CharSequence = getString(R.string.please_authenticate),\n    negativeButtonText: CharSequence = getString(R.string.cancel),\n    subtitle: CharSequence? = null,\n    description: CharSequence? = null\n): BiometricPrompt.PromptInfo {\n    val builder = BiometricPrompt.PromptInfo.Builder()\n        .setTitle(title)\n        .setNegativeButtonText(negativeButtonText)\n\n    if (subtitle?.isNotBlank() == true) {\n        builder.setSubtitle(subtitle)\n    }\n\n    if (description?.isNotBlank() == true) {\n        builder.setDescription(description)\n    }\n\n    return builder.build()\n}");
        }
        if ((i2 & 2) != 0) {
            charSequence2 = context.getString(R.string.cancel);
            kotlin.jvm.internal.m.f(charSequence2, "fun Context.buildBiometricPromptInfo(\n    title: CharSequence = getString(R.string.please_authenticate),\n    negativeButtonText: CharSequence = getString(R.string.cancel),\n    subtitle: CharSequence? = null,\n    description: CharSequence? = null\n): BiometricPrompt.PromptInfo {\n    val builder = BiometricPrompt.PromptInfo.Builder()\n        .setTitle(title)\n        .setNegativeButtonText(negativeButtonText)\n\n    if (subtitle?.isNotBlank() == true) {\n        builder.setSubtitle(subtitle)\n    }\n\n    if (description?.isNotBlank() == true) {\n        builder.setDescription(description)\n    }\n\n    return builder.build()\n}");
        }
        if ((i2 & 4) != 0) {
            charSequence3 = null;
        }
        if ((i2 & 8) != 0) {
            charSequence4 = null;
        }
        return a(context, charSequence, charSequence2, charSequence3, charSequence4);
    }

    public static final int c(Context context) {
        kotlin.jvm.internal.m.g(context, "<this>");
        return e(context, R.attr.actionBarSize);
    }

    public static final Activity d(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            do {
                context = ((ContextWrapper) context).getBaseContext();
                if (context instanceof Activity) {
                    return (Activity) context;
                }
            } while (context instanceof ContextWrapper);
            return null;
        }
        return null;
    }

    public static final int e(Context context, int i2) throws Resources.NotFoundException {
        kotlin.jvm.internal.m.g(context, "<this>");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i2});
        kotlin.jvm.internal.m.f(obtainStyledAttributes, "obtainStyledAttributes(attrs)");
        if (obtainStyledAttributes.hasValue(0)) {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
            return dimensionPixelSize;
        }
        obtainStyledAttributes.recycle();
        throw new Resources.NotFoundException("unable to find resId (" + i2 + "): " + ((Object) context.getResources().getResourceEntryName(i2)));
    }

    public static final int f(Context context, int i2) {
        kotlin.jvm.internal.m.g(context, "<this>");
        return androidx.core.content.a.d(context, i2);
    }

    public static final int g(Context context, int i2, int i3, int i4) {
        kotlin.jvm.internal.m.g(context, "<this>");
        return context.getResources().getDimensionPixelSize(i2) + context.getResources().getDimensionPixelSize(i3) + context.getResources().getDimensionPixelSize(i4);
    }

    public static final boolean h(Context context, String permission) {
        kotlin.jvm.internal.m.g(context, "<this>");
        kotlin.jvm.internal.m.g(permission, "permission");
        return androidx.core.content.a.a(context, permission) == 0;
    }

    public static final boolean i(Context context) {
        kotlin.jvm.internal.m.g(context, "<this>");
        Object systemService = context.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        if (keyguardManager == null) {
            return false;
        }
        return keyguardManager.isKeyguardSecure();
    }

    public static final androidx.appcompat.app.c j(Context context, kotlin.e0.c.l<? super c.a, kotlin.x> callback) {
        kotlin.jvm.internal.m.g(context, "<this>");
        kotlin.jvm.internal.m.g(callback, "callback");
        Activity d2 = d(context);
        if (d2 != null && !d2.isFinishing() && !d2.isDestroyed()) {
            c.a aVar = new c.a(context, R.style.SignOutDialog);
            callback.invoke(aVar);
            return aVar.q();
        }
        l.a.a.i("Attempted to show a dialog, but Context " + context + " has no Activity", new Object[0]);
        return null;
    }

    public static final void k(Context context, int i2, int i3) {
        kotlin.jvm.internal.m.g(context, "<this>");
        Toast.makeText(context, i2, i3).show();
    }

    public static /* synthetic */ void l(Context context, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        k(context, i2, i3);
    }
}