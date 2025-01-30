package com.coinbase.wallet.common.utilities;

import android.annotation.SuppressLint;
import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Contexts.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/common/utilities/Contexts;", "", "Landroid/app/Application;", "app", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "setApp", "(Landroid/app/Application;)V", "<init>", "()V", "common_productionRelease"}, k = 1, mv = {1, 5, 1})
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes.dex */
public final class Contexts {
    public static final Contexts INSTANCE = new Contexts();
    public static Application app;

    private Contexts() {
    }

    public final Application getApp() {
        Application application = app;
        if (application != null) {
            return application;
        }
        m.w("app");
        throw null;
    }

    public final void setApp(Application application) {
        m.g(application, "<set-?>");
        app = application;
    }
}