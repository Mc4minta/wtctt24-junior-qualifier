package e.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: LottieCompositionFactory.java */
/* loaded from: classes.dex */
public class f {
    private static final Map<String, n<e.a.a.e>> a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class a implements i<e.a.a.e> {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // e.a.a.i
        /* renamed from: b */
        public void a(e.a.a.e eVar) {
            f.a.remove(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class b implements i<Throwable> {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // e.a.a.i
        /* renamed from: b */
        public void a(Throwable th) {
            f.a.remove(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class c implements Callable<m<e.a.a.e>> {
        final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f11527b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f11528c;

        c(Context context, String str, String str2) {
            this.a = context;
            this.f11527b = str;
            this.f11528c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public m<e.a.a.e> call() {
            return e.a.a.x.c.e(this.a, this.f11527b, this.f11528c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class d implements Callable<m<e.a.a.e>> {
        final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f11529b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f11530c;

        d(Context context, String str, String str2) {
            this.a = context;
            this.f11529b = str;
            this.f11530c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public m<e.a.a.e> call() {
            return f.g(this.a, this.f11529b, this.f11530c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class e implements Callable<m<e.a.a.e>> {
        final /* synthetic */ WeakReference a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f11531b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f11532c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f11533d;

        e(WeakReference weakReference, Context context, int i2, String str) {
            this.a = weakReference;
            this.f11531b = context;
            this.f11532c = i2;
            this.f11533d = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public m<e.a.a.e> call() {
            Context context = (Context) this.a.get();
            if (context == null) {
                context = this.f11531b;
            }
            return f.p(context, this.f11532c, this.f11533d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: e.a.a.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0253f implements Callable<m<e.a.a.e>> {
        final /* synthetic */ InputStream a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f11534b;

        CallableC0253f(InputStream inputStream, String str) {
            this.a = inputStream;
            this.f11534b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public m<e.a.a.e> call() {
            return f.i(this.a, this.f11534b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class g implements Callable<m<e.a.a.e>> {
        final /* synthetic */ e.a.a.e a;

        g(e.a.a.e eVar) {
            this.a = eVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public m<e.a.a.e> call() {
            return new m<>(this.a);
        }
    }

    private static n<e.a.a.e> b(String str, Callable<m<e.a.a.e>> callable) {
        e.a.a.e a2 = str == null ? null : e.a.a.w.g.b().a(str);
        if (a2 != null) {
            return new n<>(new g(a2));
        }
        if (str != null) {
            Map<String, n<e.a.a.e>> map = a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        n<e.a.a.e> nVar = new n<>(callable);
        if (str != null) {
            nVar.f(new a(str));
            nVar.e(new b(str));
            a.put(str, nVar);
        }
        return nVar;
    }

    private static h c(e.a.a.e eVar, String str) {
        for (h hVar : eVar.i().values()) {
            if (hVar.b().equals(str)) {
                return hVar;
            }
        }
        return null;
    }

    public static n<e.a.a.e> d(Context context, String str) {
        return e(context, str, "asset_" + str);
    }

    public static n<e.a.a.e> e(Context context, String str, String str2) {
        return b(str2, new d(context.getApplicationContext(), str, str2));
    }

    public static m<e.a.a.e> f(Context context, String str) {
        return g(context, str, "asset_" + str);
    }

    public static m<e.a.a.e> g(Context context, String str, String str2) {
        try {
            if (str.endsWith(".zip")) {
                return s(new ZipInputStream(context.getAssets().open(str)), str2);
            }
            return i(context.getAssets().open(str), str2);
        } catch (IOException e2) {
            return new m<>(e2);
        }
    }

    public static n<e.a.a.e> h(InputStream inputStream, String str) {
        return b(str, new CallableC0253f(inputStream, str));
    }

    public static m<e.a.a.e> i(InputStream inputStream, String str) {
        return j(inputStream, str, true);
    }

    private static m<e.a.a.e> j(InputStream inputStream, String str, boolean z) {
        try {
            return k(e.a.a.y.k0.c.z(j.q.d(j.q.k(inputStream))), str);
        } finally {
            if (z) {
                e.a.a.z.h.c(inputStream);
            }
        }
    }

    public static m<e.a.a.e> k(e.a.a.y.k0.c cVar, String str) {
        return l(cVar, str, true);
    }

    private static m<e.a.a.e> l(e.a.a.y.k0.c cVar, String str, boolean z) {
        try {
            try {
                e.a.a.e a2 = e.a.a.y.t.a(cVar);
                if (str != null) {
                    e.a.a.w.g.b().c(str, a2);
                }
                m<e.a.a.e> mVar = new m<>(a2);
                if (z) {
                    e.a.a.z.h.c(cVar);
                }
                return mVar;
            } catch (Exception e2) {
                m<e.a.a.e> mVar2 = new m<>(e2);
                if (z) {
                    e.a.a.z.h.c(cVar);
                }
                return mVar2;
            }
        } catch (Throwable th) {
            if (z) {
                e.a.a.z.h.c(cVar);
            }
            throw th;
        }
    }

    public static n<e.a.a.e> m(Context context, int i2) {
        return n(context, i2, v(context, i2));
    }

    public static n<e.a.a.e> n(Context context, int i2, String str) {
        return b(str, new e(new WeakReference(context), context.getApplicationContext(), i2, str));
    }

    public static m<e.a.a.e> o(Context context, int i2) {
        return p(context, i2, v(context, i2));
    }

    public static m<e.a.a.e> p(Context context, int i2, String str) {
        try {
            return i(context.getResources().openRawResource(i2), str);
        } catch (Resources.NotFoundException e2) {
            return new m<>(e2);
        }
    }

    public static n<e.a.a.e> q(Context context, String str) {
        return r(context, str, "url_" + str);
    }

    public static n<e.a.a.e> r(Context context, String str, String str2) {
        return b(str2, new c(context, str, str2));
    }

    public static m<e.a.a.e> s(ZipInputStream zipInputStream, String str) {
        try {
            return t(zipInputStream, str);
        } finally {
            e.a.a.z.h.c(zipInputStream);
        }
    }

    private static m<e.a.a.e> t(ZipInputStream zipInputStream, String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            e.a.a.e eVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    eVar = l(e.a.a.y.k0.c.z(j.q.d(j.q.k(zipInputStream))), null, false).b();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp")) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split("/")[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (eVar == null) {
                return new m<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                h c2 = c(eVar, (String) entry.getKey());
                if (c2 != null) {
                    c2.f(e.a.a.z.h.l((Bitmap) entry.getValue(), c2.e(), c2.c()));
                }
            }
            for (Map.Entry<String, h> entry2 : eVar.i().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new m<>(new IllegalStateException("There is no image for " + entry2.getValue().b()));
                }
            }
            if (str != null) {
                e.a.a.w.g.b().c(str, eVar);
            }
            return new m<>(eVar);
        } catch (IOException e2) {
            return new m<>(e2);
        }
    }

    private static boolean u(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static String v(Context context, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(u(context) ? "_night_" : "_day_");
        sb.append(i2);
        return sb.toString();
    }
}