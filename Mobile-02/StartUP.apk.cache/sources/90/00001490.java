package com.coinbase.wallet.commonui.extensions;

import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import com.coinbase.wallet.commonui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Context+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0006\u0010\u0007\"\u0017\u0010\u000b\u001a\u00020\b*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0019\u0010\u000f\u001a\u0004\u0018\u00010\f*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroid/content/Context;", "", "enabled", "Ljava/lang/Class;", "clazz", "Lkotlin/x;", "setComponentEnabledSetting", "(Landroid/content/Context;ZLjava/lang/Class;)V", "", "getStatusBarHeight", "(Landroid/content/Context;)I", "statusBarHeight", "Landroid/content/ClipboardManager;", "getClipboardManager", "(Landroid/content/Context;)Landroid/content/ClipboardManager;", "clipboardManager", "commonui_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Context_CommonKt {
    public static final ClipboardManager getClipboardManager(Context context) {
        m.g(context, "<this>");
        Object systemService = context.getSystemService("clipboard");
        if (systemService instanceof ClipboardManager) {
            return (ClipboardManager) systemService;
        }
        return null;
    }

    public static final int getStatusBarHeight(Context context) {
        m.g(context, "<this>");
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier == 0) {
            identifier = R.dimen.fallback_status_bar_height;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static final void setComponentEnabledSetting(Context context, boolean z, Class<?> clazz) {
        m.g(context, "<this>");
        m.g(clazz, "clazz");
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, clazz), z ? 1 : 2, 1);
    }
}