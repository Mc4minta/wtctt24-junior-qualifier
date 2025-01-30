package com.google.android.gms.internal.clearcut;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.UserManager;
import android.util.Log;

/* loaded from: classes2.dex */
public abstract class f<T> {
    private static final Object a = new Object();
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b */
    private static Context f6415b;

    /* renamed from: c */
    private static boolean f6416c;

    /* renamed from: d */
    private static volatile Boolean f6417d;

    /* renamed from: e */
    private static volatile Boolean f6418e;

    /* renamed from: f */
    private final p f6419f;

    /* renamed from: g */
    final String f6420g;

    /* renamed from: h */
    private final String f6421h;

    /* renamed from: i */
    private final T f6422i;

    /* renamed from: j */
    private T f6423j;

    /* renamed from: k */
    private volatile c f6424k;

    /* renamed from: l */
    private volatile SharedPreferences f6425l;

    private f(p pVar, String str, T t) {
        String str2;
        String str3;
        String str4;
        String str5;
        Uri uri;
        Uri uri2;
        this.f6423j = null;
        this.f6424k = null;
        this.f6425l = null;
        str2 = pVar.a;
        if (str2 == null) {
            uri2 = pVar.f6525b;
            if (uri2 == null) {
                throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
            }
        }
        str3 = pVar.a;
        if (str3 != null) {
            uri = pVar.f6525b;
            if (uri != null) {
                throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
            }
        }
        this.f6419f = pVar;
        str4 = pVar.f6526c;
        String valueOf = String.valueOf(str4);
        String valueOf2 = String.valueOf(str);
        this.f6421h = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        str5 = pVar.f6527d;
        String valueOf3 = String.valueOf(str5);
        String valueOf4 = String.valueOf(str);
        this.f6420g = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        this.f6422i = t;
    }

    public /* synthetic */ f(p pVar, String str, Object obj, j jVar) {
        this(pVar, str, obj);
    }

    public static void b(Context context) {
        Context applicationContext;
        if (f6415b == null) {
            synchronized (a) {
                if ((Build.VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) && (applicationContext = context.getApplicationContext()) != null) {
                    context = applicationContext;
                }
                if (f6415b != context) {
                    f6417d = null;
                }
                f6415b = context;
            }
            f6416c = false;
        }
    }

    public static <T> f<T> c(p pVar, String str, T t, o<T> oVar) {
        return new m(pVar, str, t, oVar);
    }

    public static f<String> d(p pVar, String str, String str2) {
        return new l(pVar, str, str2);
    }

    public static f<Boolean> e(p pVar, String str, boolean z) {
        return new k(pVar, str, Boolean.valueOf(z));
    }

    private static <V> V g(n<V> nVar) {
        try {
            return nVar.k();
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return nVar.k();
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public static boolean h(String str, boolean z) {
        if (p()) {
            return ((Boolean) g(new n(str, false) { // from class: com.google.android.gms.internal.clearcut.i
                private final String a;

                /* renamed from: b  reason: collision with root package name */
                private final boolean f6458b = false;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = str;
                }

                @Override // com.google.android.gms.internal.clearcut.n
                public final Object k() {
                    return f.l(this.a, this.f6458b);
                }
            })).booleanValue();
        }
        return false;
    }

    public static final /* synthetic */ Boolean l(String str, boolean z) {
        return Boolean.valueOf(v5.h(f6415b.getContentResolver(), str, z));
    }

    @TargetApi(24)
    private final T n() {
        Uri uri;
        String str;
        boolean z;
        String str2;
        Uri uri2;
        if (h("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            String valueOf = String.valueOf(this.f6420g);
            Log.w("PhenotypeFlag", valueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(valueOf) : new String("Bypass reading Phenotype values for flag: "));
        } else {
            uri = this.f6419f.f6525b;
            if (uri != null) {
                if (this.f6424k == null) {
                    ContentResolver contentResolver = f6415b.getContentResolver();
                    uri2 = this.f6419f.f6525b;
                    this.f6424k = c.a(contentResolver, uri2);
                }
                String str3 = (String) g(new n(this, this.f6424k) { // from class: com.google.android.gms.internal.clearcut.g
                    private final f a;

                    /* renamed from: b  reason: collision with root package name */
                    private final c f6447b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.a = this;
                        this.f6447b = r2;
                    }

                    @Override // com.google.android.gms.internal.clearcut.n
                    public final Object k() {
                        return this.f6447b.c().get(this.a.f6420g);
                    }
                });
                if (str3 != null) {
                    return m(str3);
                }
            } else {
                str = this.f6419f.a;
                if (str != null) {
                    if (Build.VERSION.SDK_INT < 24 || f6415b.isDeviceProtectedStorage()) {
                        z = true;
                    } else {
                        if (f6418e == null || !f6418e.booleanValue()) {
                            f6418e = Boolean.valueOf(((UserManager) f6415b.getSystemService(UserManager.class)).isUserUnlocked());
                        }
                        z = f6418e.booleanValue();
                    }
                    if (!z) {
                        return null;
                    }
                    if (this.f6425l == null) {
                        Context context = f6415b;
                        str2 = this.f6419f.a;
                        this.f6425l = context.getSharedPreferences(str2, 0);
                    }
                    SharedPreferences sharedPreferences = this.f6425l;
                    if (sharedPreferences.contains(this.f6420g)) {
                        return f(sharedPreferences);
                    }
                }
            }
        }
        return null;
    }

    private final T o() {
        boolean z;
        String str;
        z = this.f6419f.f6528e;
        if (z || !p() || (str = (String) g(new n(this) { // from class: com.google.android.gms.internal.clearcut.h
            private final f a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.clearcut.n
            public final Object k() {
                return this.a.q();
            }
        })) == null) {
            return null;
        }
        return m(str);
    }

    private static boolean p() {
        if (f6417d == null) {
            Context context = f6415b;
            if (context == null) {
                return false;
            }
            f6417d = Boolean.valueOf(androidx.core.content.c.a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return f6417d.booleanValue();
    }

    public final T a() {
        boolean z;
        if (f6415b != null) {
            z = this.f6419f.f6529f;
            if (z) {
                T o = o();
                if (o != null) {
                    return o;
                }
                T n = n();
                if (n != null) {
                    return n;
                }
            } else {
                T n2 = n();
                if (n2 != null) {
                    return n2;
                }
                T o2 = o();
                if (o2 != null) {
                    return o2;
                }
            }
            return this.f6422i;
        }
        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
    }

    protected abstract T f(SharedPreferences sharedPreferences);

    public abstract T m(String str);

    public final /* synthetic */ String q() {
        return v5.c(f6415b.getContentResolver(), this.f6421h, null);
    }
}