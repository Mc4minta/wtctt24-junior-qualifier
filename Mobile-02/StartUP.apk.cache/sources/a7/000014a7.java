package com.coinbase.wallet.commonui.extensions;

import android.os.Build;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Window+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/view/Window;", "Lkotlin/x;", "enableFullscreenWindow", "(Landroid/view/Window;)V", "commonui_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Window_CommonKt {
    public static final void enableFullscreenWindow(Window window) {
        m.g(window, "<this>");
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 256 | 1024 | 512);
        window.setNavigationBarColor(Build.VERSION.SDK_INT >= 29 ? 0 : -16777216);
    }
}