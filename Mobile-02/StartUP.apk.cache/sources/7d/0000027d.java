package androidx.core.os;

import android.os.Build;

/* compiled from: BuildCompat.java */
/* loaded from: classes.dex */
public class a {
    @Deprecated
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 30;
    }
}