package e.f.h.f;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import e.f.d.c.i;
import e.f.h.e.q;
import java.util.List;
import org.apache.http.HttpStatus;

/* compiled from: GenericDraweeHierarchyBuilder.java */
/* loaded from: classes2.dex */
public class b {
    public static final q.b a = q.b.f12317f;

    /* renamed from: b  reason: collision with root package name */
    public static final q.b f12335b = q.b.f12318g;

    /* renamed from: c  reason: collision with root package name */
    private Resources f12336c;

    /* renamed from: d  reason: collision with root package name */
    private int f12337d;

    /* renamed from: e  reason: collision with root package name */
    private float f12338e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f12339f;

    /* renamed from: g  reason: collision with root package name */
    private q.b f12340g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f12341h;

    /* renamed from: i  reason: collision with root package name */
    private q.b f12342i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f12343j;

    /* renamed from: k  reason: collision with root package name */
    private q.b f12344k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f12345l;
    private q.b m;
    private q.b n;
    private Matrix o;
    private PointF p;
    private ColorFilter q;
    private Drawable r;
    private List<Drawable> s;
    private Drawable t;
    private d u;

    public b(Resources resources) {
        this.f12336c = resources;
        s();
    }

    private void s() {
        this.f12337d = HttpStatus.SC_MULTIPLE_CHOICES;
        this.f12338e = 0.0f;
        this.f12339f = null;
        q.b bVar = a;
        this.f12340g = bVar;
        this.f12341h = null;
        this.f12342i = bVar;
        this.f12343j = null;
        this.f12344k = bVar;
        this.f12345l = null;
        this.m = bVar;
        this.n = f12335b;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
    }

    public static b t(Resources resources) {
        return new b(resources);
    }

    private void v() {
        List<Drawable> list = this.s;
        if (list != null) {
            for (Drawable drawable : list) {
                i.g(drawable);
            }
        }
    }

    public a a() {
        v();
        return new a(this);
    }

    public ColorFilter b() {
        return this.q;
    }

    public PointF c() {
        return this.p;
    }

    public q.b d() {
        return this.n;
    }

    public Drawable e() {
        return this.r;
    }

    public int f() {
        return this.f12337d;
    }

    public Drawable g() {
        return this.f12343j;
    }

    public q.b h() {
        return this.f12344k;
    }

    public List<Drawable> i() {
        return this.s;
    }

    public Drawable j() {
        return this.f12339f;
    }

    public q.b k() {
        return this.f12340g;
    }

    public Drawable l() {
        return this.t;
    }

    public Drawable m() {
        return this.f12345l;
    }

    public q.b n() {
        return this.m;
    }

    public Resources o() {
        return this.f12336c;
    }

    public Drawable p() {
        return this.f12341h;
    }

    public q.b q() {
        return this.f12342i;
    }

    public d r() {
        return this.u;
    }

    public b u(d dVar) {
        this.u = dVar;
        return this;
    }
}