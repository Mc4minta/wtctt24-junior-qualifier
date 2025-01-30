package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import org.spongycastle.i18n.MessageBundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.java */
/* loaded from: classes.dex */
public class m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        c f2 = c.f();
        return f2 != null && f2.h();
    }

    private static boolean b(Context context, String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i2)) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return false;
            case 6:
            default:
                return true;
        }
    }

    private static boolean d(Context context, String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i2)) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(String str, androidx.fragment.app.d dVar, Bundle bundle, Runnable runnable) {
        KeyguardManager keyguardManager;
        CharSequence charSequence;
        if (!(dVar instanceof DeviceCredentialHandlerActivity)) {
            Log.e(str, "Failed to check device credential. Parent handler not found.");
            return;
        }
        DeviceCredentialHandlerActivity deviceCredentialHandlerActivity = (DeviceCredentialHandlerActivity) dVar;
        if (Build.VERSION.SDK_INT >= 23) {
            keyguardManager = (KeyguardManager) deviceCredentialHandlerActivity.getSystemService(KeyguardManager.class);
        } else {
            Object systemService = deviceCredentialHandlerActivity.getSystemService("keyguard");
            if (!(systemService instanceof KeyguardManager)) {
                Log.e(str, "Failed to check device credential. KeyguardManager not found.");
                deviceCredentialHandlerActivity.a(0);
                return;
            }
            keyguardManager = (KeyguardManager) systemService;
        }
        if (keyguardManager == null) {
            Log.e(str, "Failed to check device credential. KeyguardManager was null.");
            deviceCredentialHandlerActivity.a(0);
            return;
        }
        CharSequence charSequence2 = null;
        if (bundle != null) {
            charSequence2 = bundle.getCharSequence(MessageBundle.TITLE_ENTRY);
            charSequence = bundle.getCharSequence("subtitle");
        } else {
            charSequence = null;
        }
        Intent createConfirmDeviceCredentialIntent = keyguardManager.createConfirmDeviceCredentialIntent(charSequence2, charSequence);
        if (createConfirmDeviceCredentialIntent == null) {
            Log.e(str, "Failed to check device credential. Got null intent from Keyguard.");
            deviceCredentialHandlerActivity.a(0);
            return;
        }
        c e2 = c.e();
        e2.m(true);
        e2.p();
        if (runnable != null) {
            runnable.run();
        }
        createConfirmDeviceCredentialIntent.setFlags(134742016);
        deviceCredentialHandlerActivity.startActivityForResult(createConfirmDeviceCredentialIntent, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(androidx.fragment.app.d dVar) {
        if (!(dVar instanceof DeviceCredentialHandlerActivity) || dVar.isFinishing()) {
            return;
        }
        dVar.finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(Context context, String str) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        return b(context, str, f.hide_fingerprint_instantly_prefixes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        return d(context, str, f.crypto_fingerprint_fallback_vendors) || b(context, str2, f.crypto_fingerprint_fallback_prefixes);
    }
}