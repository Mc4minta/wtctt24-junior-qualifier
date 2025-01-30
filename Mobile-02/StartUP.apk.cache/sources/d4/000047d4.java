package e.g.a.e.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.util.h;
import com.google.android.gms.internal.clearcut.i5;
import com.google.android.gms.internal.clearcut.l5;
import com.google.android.gms.internal.clearcut.r5;
import com.google.android.gms.internal.clearcut.t2;
import com.google.android.gms.internal.clearcut.t5;
import com.google.android.gms.internal.clearcut.y4;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.ArrayList;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public final class a {
    private static final a.g<l5> a;

    /* renamed from: b  reason: collision with root package name */
    private static final a.AbstractC0138a<l5, ?> f13096b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<?> f13097c;

    /* renamed from: d  reason: collision with root package name */
    private static final e.g.a.e.e.a[] f13098d;

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f13099e;

    /* renamed from: f  reason: collision with root package name */
    private static final byte[][] f13100f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f13101g;

    /* renamed from: h  reason: collision with root package name */
    private final String f13102h;

    /* renamed from: i  reason: collision with root package name */
    private final int f13103i;

    /* renamed from: j  reason: collision with root package name */
    private String f13104j;

    /* renamed from: k  reason: collision with root package name */
    private int f13105k;

    /* renamed from: l  reason: collision with root package name */
    private String f13106l;
    private String m;
    private final boolean n;
    private y4 o;
    private final e.g.a.e.c.c p;
    private final com.google.android.gms.common.util.e q;
    private d r;
    private final b s;

    /* renamed from: e.g.a.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0300a {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private String f13107b;

        /* renamed from: c  reason: collision with root package name */
        private String f13108c;

        /* renamed from: d  reason: collision with root package name */
        private String f13109d;

        /* renamed from: e  reason: collision with root package name */
        private y4 f13110e;

        /* renamed from: f  reason: collision with root package name */
        private final c f13111f;

        /* renamed from: g  reason: collision with root package name */
        private ArrayList<Integer> f13112g;

        /* renamed from: h  reason: collision with root package name */
        private ArrayList<String> f13113h;

        /* renamed from: i  reason: collision with root package name */
        private ArrayList<Integer> f13114i;

        /* renamed from: j  reason: collision with root package name */
        private ArrayList<e.g.a.e.e.a> f13115j;

        /* renamed from: k  reason: collision with root package name */
        private ArrayList<byte[]> f13116k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f13117l;
        private final i5 m;
        private boolean n;

        private C0300a(a aVar, byte[] bArr) {
            this(bArr, (c) null);
        }

        private C0300a(byte[] bArr, c cVar) {
            this.a = a.this.f13105k;
            this.f13107b = a.this.f13104j;
            this.f13108c = a.this.f13106l;
            this.f13109d = null;
            this.f13110e = a.this.o;
            this.f13112g = null;
            this.f13113h = null;
            this.f13114i = null;
            this.f13115j = null;
            this.f13116k = null;
            this.f13117l = true;
            i5 i5Var = new i5();
            this.m = i5Var;
            this.n = false;
            this.f13108c = a.this.f13106l;
            this.f13109d = null;
            i5Var.E = com.google.android.gms.internal.clearcut.b.a(a.this.f13101g);
            i5Var.f6459c = a.this.q.a();
            i5Var.f6460d = a.this.q.b();
            d unused = a.this.r;
            i5Var.w = TimeZone.getDefault().getOffset(i5Var.f6459c) / RNCWebViewManager.COMMAND_CLEAR_FORM_DATA;
            if (bArr != null) {
                i5Var.p = bArr;
            }
            this.f13111f = null;
        }

        /* synthetic */ C0300a(a aVar, byte[] bArr, e.g.a.e.c.b bVar) {
            this(aVar, bArr);
        }

        public void a() {
            if (this.n) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.n = true;
            f fVar = new f(new t5(a.this.f13102h, a.this.f13103i, this.a, this.f13107b, this.f13108c, this.f13109d, a.this.n, this.f13110e), this.m, null, null, a.g(null), null, a.g(null), null, null, this.f13117l);
            if (a.this.s.a(fVar)) {
                a.this.p.a(fVar);
            } else {
                com.google.android.gms.common.api.f.b(Status.a, null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        boolean a(f fVar);
    }

    /* loaded from: classes2.dex */
    public interface c {
        byte[] a();
    }

    /* loaded from: classes2.dex */
    public static class d {
    }

    static {
        a.g<l5> gVar = new a.g<>();
        a = gVar;
        e.g.a.e.c.b bVar = new e.g.a.e.c.b();
        f13096b = bVar;
        f13097c = new com.google.android.gms.common.api.a<>("ClearcutLogger.API", bVar, gVar);
        f13098d = new e.g.a.e.e.a[0];
        f13099e = new String[0];
        f13100f = new byte[0];
    }

    private a(Context context, int i2, String str, String str2, String str3, boolean z, e.g.a.e.c.c cVar, com.google.android.gms.common.util.e eVar, d dVar, b bVar) {
        this.f13105k = -1;
        y4 y4Var = y4.DEFAULT;
        this.o = y4Var;
        this.f13101g = context;
        this.f13102h = context.getPackageName();
        this.f13103i = c(context);
        this.f13105k = -1;
        this.f13104j = str;
        this.f13106l = str2;
        this.m = null;
        this.n = z;
        this.p = cVar;
        this.q = eVar;
        this.r = new d();
        this.o = y4Var;
        this.s = bVar;
        if (z) {
            t.b(str2 == null, "can't be anonymous with an upload account");
        }
    }

    public static a a(Context context, String str) {
        return new a(context, -1, str, null, null, true, t2.o(context), h.c(), null, new r5(context));
    }

    private static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.wtf("ClearcutLogger", "This can't happen.", e2);
            return 0;
        }
    }

    private static int[] e(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            Integer num = arrayList.get(i2);
            i2++;
            iArr[i3] = num.intValue();
            i3++;
        }
        return iArr;
    }

    static /* synthetic */ int[] g(ArrayList arrayList) {
        return e(null);
    }

    public final C0300a b(byte[] bArr) {
        return new C0300a(this, bArr, (e.g.a.e.c.b) null);
    }
}