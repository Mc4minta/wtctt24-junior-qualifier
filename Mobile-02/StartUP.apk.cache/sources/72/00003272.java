package com.google.android.gms.internal.clearcut;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class c {
    private static final ConcurrentHashMap<Uri, c> a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f6378b = {"key", "value"};

    /* renamed from: c  reason: collision with root package name */
    private final ContentResolver f6379c;

    /* renamed from: d  reason: collision with root package name */
    private final Uri f6380d;

    /* renamed from: g  reason: collision with root package name */
    private volatile Map<String, String> f6383g;

    /* renamed from: f  reason: collision with root package name */
    private final Object f6382f = new Object();

    /* renamed from: h  reason: collision with root package name */
    private final Object f6384h = new Object();

    /* renamed from: i  reason: collision with root package name */
    private final List<e> f6385i = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final ContentObserver f6381e = new d(this, null);

    private c(ContentResolver contentResolver, Uri uri) {
        this.f6379c = contentResolver;
        this.f6380d = uri;
    }

    public static c a(ContentResolver contentResolver, Uri uri) {
        ConcurrentHashMap<Uri, c> concurrentHashMap = a;
        c cVar = concurrentHashMap.get(uri);
        if (cVar == null) {
            c cVar2 = new c(contentResolver, uri);
            c putIfAbsent = concurrentHashMap.putIfAbsent(uri, cVar2);
            if (putIfAbsent == null) {
                cVar2.f6379c.registerContentObserver(cVar2.f6380d, false, cVar2.f6381e);
                return cVar2;
            }
            return putIfAbsent;
        }
        return cVar;
    }

    private final Map<String, String> e() {
        try {
            HashMap hashMap = new HashMap();
            Cursor query = this.f6379c.query(this.f6380d, f6378b, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    hashMap.put(query.getString(0), query.getString(1));
                }
                query.close();
            }
            return hashMap;
        } catch (SQLiteException | SecurityException unused) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        synchronized (this.f6384h) {
            for (e eVar : this.f6385i) {
                eVar.o();
            }
        }
    }

    public final Map<String, String> c() {
        Map<String, String> e2 = f.h("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? e() : this.f6383g;
        if (e2 == null) {
            synchronized (this.f6382f) {
                e2 = this.f6383g;
                if (e2 == null) {
                    e2 = e();
                    this.f6383g = e2;
                }
            }
        }
        return e2 != null ? e2 : Collections.emptyMap();
    }

    public final void d() {
        synchronized (this.f6382f) {
            this.f6383g = null;
        }
    }
}