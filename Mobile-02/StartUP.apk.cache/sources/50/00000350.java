package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.i;
import androidx.lifecycle.z;
import androidx.savedstate.SavedStateRegistry;
import java.util.UUID;

/* compiled from: NavBackStackEntry.java */
/* loaded from: classes.dex */
public final class e implements androidx.lifecycle.o, g0, androidx.lifecycle.h, androidx.savedstate.b {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final k f1851b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f1852c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.lifecycle.p f1853d;

    /* renamed from: e  reason: collision with root package name */
    private final androidx.savedstate.a f1854e;

    /* renamed from: f  reason: collision with root package name */
    final UUID f1855f;

    /* renamed from: g  reason: collision with root package name */
    private i.b f1856g;

    /* renamed from: h  reason: collision with root package name */
    private i.b f1857h;

    /* renamed from: j  reason: collision with root package name */
    private g f1858j;

    /* renamed from: k  reason: collision with root package name */
    private d0.b f1859k;

    /* renamed from: l  reason: collision with root package name */
    private z f1860l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NavBackStackEntry.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.a.values().length];
            a = iArr;
            try {
                iArr[i.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i.a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[i.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[i.a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[i.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[i.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavBackStackEntry.java */
    /* loaded from: classes.dex */
    public static class b extends androidx.lifecycle.a {
        b(androidx.savedstate.b bVar, Bundle bundle) {
            super(bVar, bundle);
        }

        @Override // androidx.lifecycle.a
        protected <T extends b0> T create(String str, Class<T> cls, z zVar) {
            return new c(zVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavBackStackEntry.java */
    /* loaded from: classes.dex */
    public static class c extends b0 {
        private z a;

        c(z zVar) {
            this.a = zVar;
        }

        public z a() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, k kVar, Bundle bundle, androidx.lifecycle.o oVar, g gVar) {
        this(context, kVar, bundle, oVar, gVar, UUID.randomUUID(), null);
    }

    private static i.b e(i.a aVar) {
        switch (a.a[aVar.ordinal()]) {
            case 1:
            case 2:
                return i.b.CREATED;
            case 3:
            case 4:
                return i.b.STARTED;
            case 5:
                return i.b.RESUMED;
            case 6:
                return i.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    public Bundle a() {
        return this.f1852c;
    }

    public k b() {
        return this.f1851b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i.b c() {
        return this.f1857h;
    }

    public z d() {
        if (this.f1860l == null) {
            this.f1860l = ((c) new d0(this, new b(this, null)).a(c.class)).a();
        }
        return this.f1860l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(i.a aVar) {
        this.f1856g = e(aVar);
        j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Bundle bundle) {
        this.f1852c = bundle;
    }

    @Override // androidx.lifecycle.h
    public d0.b getDefaultViewModelProviderFactory() {
        if (this.f1859k == null) {
            this.f1859k = new a0((Application) this.a.getApplicationContext(), this, this.f1852c);
        }
        return this.f1859k;
    }

    @Override // androidx.lifecycle.o
    public androidx.lifecycle.i getLifecycle() {
        return this.f1853d;
    }

    @Override // androidx.savedstate.b
    public SavedStateRegistry getSavedStateRegistry() {
        return this.f1854e.b();
    }

    @Override // androidx.lifecycle.g0
    public f0 getViewModelStore() {
        g gVar = this.f1858j;
        if (gVar != null) {
            return gVar.c(this.f1855f);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Bundle bundle) {
        this.f1854e.d(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(i.b bVar) {
        this.f1857h = bVar;
        j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        if (this.f1856g.ordinal() < this.f1857h.ordinal()) {
            this.f1853d.p(this.f1856g);
        } else {
            this.f1853d.p(this.f1857h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, k kVar, Bundle bundle, androidx.lifecycle.o oVar, g gVar, UUID uuid, Bundle bundle2) {
        this.f1853d = new androidx.lifecycle.p(this);
        androidx.savedstate.a a2 = androidx.savedstate.a.a(this);
        this.f1854e = a2;
        this.f1856g = i.b.CREATED;
        this.f1857h = i.b.RESUMED;
        this.a = context;
        this.f1855f = uuid;
        this.f1851b = kVar;
        this.f1852c = bundle;
        this.f1858j = gVar;
        a2.c(bundle2);
        if (oVar != null) {
            this.f1856g = oVar.getLifecycle().b();
        }
    }
}