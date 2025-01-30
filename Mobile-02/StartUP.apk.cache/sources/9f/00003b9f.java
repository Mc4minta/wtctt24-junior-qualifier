package com.google.firebase.perf.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.internal.p000firebaseperf.a;
import com.google.android.gms.internal.p000firebaseperf.i;
import com.google.android.gms.internal.p000firebaseperf.i1;
import com.google.android.gms.internal.p000firebaseperf.m0;
import com.google.android.gms.internal.p000firebaseperf.y0;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.metrics.AppStartTrace;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
@Keep
/* loaded from: classes2.dex */
public class FirebasePerfProvider extends ContentProvider {
    private static final y0 zzhb;
    private final Handler mHandler = new a(Looper.getMainLooper());

    static {
        new m0();
        zzhb = new y0();
    }

    public static y0 zzcz() {
        return zzhb;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        t.l(providerInfo, "FirebasePerfProvider ProviderInfo cannot be null.");
        if (!"com.google.firebase.firebaseperfprovider".equals(providerInfo.authority)) {
            super.attachInfo(context, providerInfo);
            i A = i.A();
            A.o(getContext());
            if (A.B()) {
                com.google.firebase.perf.internal.a.j().p(getContext());
                AppStartTrace d2 = AppStartTrace.d();
                d2.f(getContext());
                this.mHandler.post(new AppStartTrace.a(d2));
            }
            SessionManager.zzcm().zzc(i1.FOREGROUND);
            return;
        }
        throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}