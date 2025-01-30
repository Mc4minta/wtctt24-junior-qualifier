package com.facebook.react.views.text;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ReactFontManager.java */
/* loaded from: classes2.dex */
public class i {
    private static final String[] a = {"", "_bold", "_italic", "_bold_italic"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f5431b = {".ttf", ".otf"};

    /* renamed from: c  reason: collision with root package name */
    private static i f5432c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, b> f5433d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Typeface> f5434e = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReactFontManager.java */
    /* loaded from: classes2.dex */
    public static class b {
        private SparseArray<Typeface> a;

        public Typeface a(int i2) {
            return this.a.get(i2);
        }

        public void b(int i2, Typeface typeface) {
            this.a.put(i2, typeface);
        }

        private b() {
            this.a = new SparseArray<>(4);
        }
    }

    private i() {
    }

    private static Typeface b(String str, int i2, AssetManager assetManager) {
        String[] strArr;
        String str2 = a[i2];
        for (String str3 : f5431b) {
            try {
                return Typeface.createFromAsset(assetManager, "fonts/" + str + str2 + str3);
            } catch (RuntimeException unused) {
            }
        }
        return Typeface.create(str, i2);
    }

    public static i c() {
        if (f5432c == null) {
            f5432c = new i();
        }
        return f5432c;
    }

    public void a(Context context, String str, int i2) {
        Typeface c2 = androidx.core.content.d.f.c(context, i2);
        if (c2 != null) {
            this.f5434e.put(str, c2);
        }
    }

    public Typeface d(String str, int i2, int i3, AssetManager assetManager) {
        if (this.f5434e.containsKey(str)) {
            Typeface typeface = this.f5434e.get(str);
            if (Build.VERSION.SDK_INT >= 28 && i3 >= 100 && i3 <= 1000) {
                return Typeface.create(typeface, i3, (i2 & 2) != 0);
            }
            return Typeface.create(typeface, i2);
        }
        b bVar = this.f5433d.get(str);
        if (bVar == null) {
            bVar = new b();
            this.f5433d.put(str, bVar);
        }
        Typeface a2 = bVar.a(i2);
        if (a2 == null && (a2 = b(str, i2, assetManager)) != null) {
            bVar.b(i2, a2);
        }
        return a2;
    }

    public Typeface e(String str, int i2, AssetManager assetManager) {
        return d(str, i2, 0, assetManager);
    }
}