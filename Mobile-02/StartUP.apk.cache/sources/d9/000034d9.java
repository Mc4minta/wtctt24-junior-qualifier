package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class i1 implements n1 {
    private static final Map<Uri, i1> a = new c.e.a();

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f7174b = {"key", "value"};

    /* renamed from: c  reason: collision with root package name */
    private final ContentResolver f7175c;

    /* renamed from: d  reason: collision with root package name */
    private final Uri f7176d;

    /* renamed from: e  reason: collision with root package name */
    private final ContentObserver f7177e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f7178f;

    /* renamed from: g  reason: collision with root package name */
    private volatile Map<String, String> f7179g;

    /* renamed from: h  reason: collision with root package name */
    private final List<k1> f7180h;

    private i1(ContentResolver contentResolver, Uri uri) {
        l1 l1Var = new l1(this, null);
        this.f7177e = l1Var;
        this.f7178f = new Object();
        this.f7180h = new ArrayList();
        this.f7175c = contentResolver;
        this.f7176d = uri;
        contentResolver.registerContentObserver(uri, false, l1Var);
    }

    public static i1 a(ContentResolver contentResolver, Uri uri) {
        i1 i1Var;
        synchronized (i1.class) {
            Map<Uri, i1> map = a;
            i1Var = map.get(uri);
            if (i1Var == null) {
                try {
                    i1 i1Var2 = new i1(contentResolver, uri);
                    try {
                        map.put(uri, i1Var2);
                    } catch (SecurityException unused) {
                    }
                    i1Var = i1Var2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return i1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void d() {
        synchronized (i1.class) {
            for (i1 i1Var : a.values()) {
                i1Var.f7175c.unregisterContentObserver(i1Var.f7177e);
            }
            a.clear();
        }
    }

    private final Map<String, String> g() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) m1.a(new p1(this) { // from class: com.google.android.gms.internal.measurement.h1
                    private final i1 a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.a = this;
                    }

                    @Override // com.google.android.gms.internal.measurement.p1
                    public final Object a() {
                        return this.a.e();
                    }
                });
            } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return null;
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public final Map<String, String> b() {
        Map<String, String> map = this.f7179g;
        if (map == null) {
            synchronized (this.f7178f) {
                map = this.f7179g;
                if (map == null) {
                    map = g();
                    this.f7179g = map;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    public final void c() {
        synchronized (this.f7178f) {
            this.f7179g = null;
            x1.g();
        }
        synchronized (this) {
            for (k1 k1Var : this.f7180h) {
                k1Var.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Map e() {
        Map hashMap;
        Cursor query = this.f7175c.query(this.f7176d, f7174b, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                hashMap = new c.e.a(count);
            } else {
                hashMap = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                hashMap.put(query.getString(0), query.getString(1));
            }
            return hashMap;
        } finally {
            query.close();
        }
    }

    @Override // com.google.android.gms.internal.measurement.n1
    public final /* synthetic */ Object f(String str) {
        return b().get(str);
    }
}