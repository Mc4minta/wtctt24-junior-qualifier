package com.coinbase.wallet.commonui.extensions;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: Activity+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\"(\u0010\f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroid/app/Activity;", "Lkotlin/x;", "enableDarkStatusBarIcons", "(Landroid/app/Activity;)V", "enableLightStatusBarIcons", "enableFullscreenWindow", "", "value", "getHasDarkNavBar", "(Landroid/app/Activity;)Z", "setHasDarkNavBar", "(Landroid/app/Activity;Z)V", "hasDarkNavBar", "commonui_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Activity_CommonKt {
    public static final void enableDarkStatusBarIcons(Activity activity) {
        m.g(activity, "<this>");
        activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() | PKIFailureInfo.certRevoked);
    }

    public static final void enableFullscreenWindow(Activity activity) {
        m.g(activity, "<this>");
        Window window = activity.getWindow();
        m.f(window, "window");
        Window_CommonKt.enableFullscreenWindow(window);
    }

    public static final void enableLightStatusBarIcons(Activity activity) {
        m.g(activity, "<this>");
        activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() & (-8193));
    }

    public static final boolean getHasDarkNavBar(Activity activity) {
        m.g(activity, "<this>");
        return Build.VERSION.SDK_INT >= 29 && (activity.getWindow().getAttributes().flags & 16) != 16;
    }

    public static final void setHasDarkNavBar(Activity activity, boolean z) {
        int systemUiVisibility;
        m.g(activity, "<this>");
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        if (z) {
            systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility() & (-17);
        } else {
            systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility() | 16;
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
    }
}