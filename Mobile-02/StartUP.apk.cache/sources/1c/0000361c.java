package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.appsflyer.internal.referrer.Payload;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
@TargetApi(14)
/* loaded from: classes2.dex */
public final class c7 implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ i6 a;

    private c7(i6 i6Var) {
        this.a = i6Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d A[Catch: Exception -> 0x01d2, TRY_ENTER, TryCatch #0 {Exception -> 0x01d2, blocks: (B:3:0x000b, B:6:0x0025, B:8:0x0033, B:33:0x009d, B:35:0x00ab, B:37:0x00be, B:40:0x00c6, B:42:0x00cc, B:43:0x00df, B:45:0x00f2, B:47:0x00fb, B:50:0x010b, B:53:0x011b, B:56:0x0123, B:58:0x0129, B:59:0x0134, B:62:0x013b, B:66:0x015c, B:68:0x016f, B:70:0x0186, B:69:0x0177, B:72:0x018d, B:74:0x0193, B:76:0x0199, B:78:0x019f, B:80:0x01a5, B:82:0x01ad, B:86:0x01b8, B:88:0x01c6, B:90:0x01cc, B:12:0x0044, B:15:0x0051, B:17:0x0057, B:19:0x005d, B:21:0x0063, B:23:0x0069, B:24:0x0075, B:26:0x007d, B:28:0x0088, B:30:0x0092, B:27:0x0082), top: B:95:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010b A[Catch: Exception -> 0x01d2, TRY_ENTER, TryCatch #0 {Exception -> 0x01d2, blocks: (B:3:0x000b, B:6:0x0025, B:8:0x0033, B:33:0x009d, B:35:0x00ab, B:37:0x00be, B:40:0x00c6, B:42:0x00cc, B:43:0x00df, B:45:0x00f2, B:47:0x00fb, B:50:0x010b, B:53:0x011b, B:56:0x0123, B:58:0x0129, B:59:0x0134, B:62:0x013b, B:66:0x015c, B:68:0x016f, B:70:0x0186, B:69:0x0177, B:72:0x018d, B:74:0x0193, B:76:0x0199, B:78:0x019f, B:80:0x01a5, B:82:0x01ad, B:86:0x01b8, B:88:0x01c6, B:90:0x01cc, B:12:0x0044, B:15:0x0051, B:17:0x0057, B:19:0x005d, B:21:0x0063, B:23:0x0069, B:24:0x0075, B:26:0x007d, B:28:0x0088, B:30:0x0092, B:27:0x0082), top: B:95:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013b A[Catch: Exception -> 0x01d2, TRY_LEAVE, TryCatch #0 {Exception -> 0x01d2, blocks: (B:3:0x000b, B:6:0x0025, B:8:0x0033, B:33:0x009d, B:35:0x00ab, B:37:0x00be, B:40:0x00c6, B:42:0x00cc, B:43:0x00df, B:45:0x00f2, B:47:0x00fb, B:50:0x010b, B:53:0x011b, B:56:0x0123, B:58:0x0129, B:59:0x0134, B:62:0x013b, B:66:0x015c, B:68:0x016f, B:70:0x0186, B:69:0x0177, B:72:0x018d, B:74:0x0193, B:76:0x0199, B:78:0x019f, B:80:0x01a5, B:82:0x01ad, B:86:0x01b8, B:88:0x01c6, B:90:0x01cc, B:12:0x0044, B:15:0x0051, B:17:0x0057, B:19:0x005d, B:21:0x0063, B:23:0x0069, B:24:0x0075, B:26:0x007d, B:28:0x0088, B:30:0x0092, B:27:0x0082), top: B:95:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.c7.b(boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.a.f().P().a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                return;
            }
            Uri data = intent.getData();
            if (data != null && data.isHierarchical()) {
                this.a.m();
                this.a.l().A(new f7(this, bundle == null, data, v9.Y(intent) ? "gs" : "auto", data.getQueryParameter(Payload.REFERRER)));
            }
        } catch (Exception e2) {
            this.a.f().H().b("Throwable caught in onActivityCreated", e2);
        } finally {
            this.a.t().E(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.a.t().P(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.a.t().N(activity);
        u8 v = this.a.v();
        v.l().A(new w8(v, v.i().b()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        u8 v = this.a.v();
        v.l().A(new x8(v, v.i().b()));
        this.a.t().D(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.a.t().O(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c7(i6 i6Var, j6 j6Var) {
        this(i6Var);
    }
}