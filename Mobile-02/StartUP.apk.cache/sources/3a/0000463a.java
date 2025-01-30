package e.f.j.e;

import android.content.Context;
import com.facebook.common.memory.PooledByteBuffer;
import e.f.d.h.b;
import e.f.j.d.p;
import e.f.j.e.i;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: ImagePipelineExperiments.java */
/* loaded from: classes2.dex */
public class j {
    private final boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final b.a f12502b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f12503c;

    /* renamed from: d  reason: collision with root package name */
    private final e.f.d.h.b f12504d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f12505e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f12506f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12507g;

    /* renamed from: h  reason: collision with root package name */
    private final int f12508h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12509i;

    /* renamed from: j  reason: collision with root package name */
    private final int f12510j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f12511k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f12512l;
    private final d m;
    private final e.f.d.c.l<Boolean> n;
    private final boolean o;
    private final boolean p;

    /* compiled from: ImagePipelineExperiments.java */
    /* loaded from: classes2.dex */
    public static class b {
        private final i.b a;

        /* renamed from: c  reason: collision with root package name */
        private b.a f12514c;

        /* renamed from: e  reason: collision with root package name */
        private e.f.d.h.b f12516e;
        private d n;
        public e.f.d.c.l<Boolean> o;
        public boolean p;
        public boolean q;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12513b = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f12515d = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f12517f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f12518g = false;

        /* renamed from: h  reason: collision with root package name */
        private int f12519h = 0;

        /* renamed from: i  reason: collision with root package name */
        private int f12520i = 0;

        /* renamed from: j  reason: collision with root package name */
        public boolean f12521j = false;

        /* renamed from: k  reason: collision with root package name */
        private int f12522k = PKIFailureInfo.wrongIntegrity;

        /* renamed from: l  reason: collision with root package name */
        private boolean f12523l = false;
        private boolean m = false;

        public b(i.b bVar) {
            this.a = bVar;
        }

        public j m() {
            return new j(this);
        }
    }

    /* compiled from: ImagePipelineExperiments.java */
    /* loaded from: classes2.dex */
    public static class c implements d {
        @Override // e.f.j.e.j.d
        public m a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, f fVar, com.facebook.common.memory.g gVar, p<e.f.b.a.d, e.f.j.i.b> pVar, p<e.f.b.a.d, PooledByteBuffer> pVar2, e.f.j.d.e eVar, e.f.j.d.e eVar2, e.f.j.d.f fVar2, e.f.j.c.f fVar3, int i2, int i3, boolean z4, int i4, e.f.j.e.a aVar2) {
            return new m(context, aVar, bVar, dVar, z, z2, z3, fVar, gVar, pVar, pVar2, eVar, eVar2, fVar2, fVar3, i2, i3, z4, i4, aVar2);
        }
    }

    /* compiled from: ImagePipelineExperiments.java */
    /* loaded from: classes2.dex */
    public interface d {
        m a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, f fVar, com.facebook.common.memory.g gVar, p<e.f.b.a.d, e.f.j.i.b> pVar, p<e.f.b.a.d, PooledByteBuffer> pVar2, e.f.j.d.e eVar, e.f.j.d.e eVar2, e.f.j.d.f fVar2, e.f.j.c.f fVar3, int i2, int i3, boolean z4, int i4, e.f.j.e.a aVar2);
    }

    public boolean a() {
        return this.f12509i;
    }

    public int b() {
        return this.f12508h;
    }

    public int c() {
        return this.f12507g;
    }

    public int d() {
        return this.f12510j;
    }

    public d e() {
        return this.m;
    }

    public boolean f() {
        return this.f12506f;
    }

    public boolean g() {
        return this.f12505e;
    }

    public e.f.d.h.b h() {
        return this.f12504d;
    }

    public b.a i() {
        return this.f12502b;
    }

    public boolean j() {
        return this.f12503c;
    }

    public boolean k() {
        return this.o;
    }

    public e.f.d.c.l<Boolean> l() {
        return this.n;
    }

    public boolean m() {
        return this.f12511k;
    }

    public boolean n() {
        return this.f12512l;
    }

    public boolean o() {
        return this.a;
    }

    public boolean p() {
        return this.p;
    }

    private j(b bVar) {
        this.a = bVar.f12513b;
        this.f12502b = bVar.f12514c;
        this.f12503c = bVar.f12515d;
        this.f12504d = bVar.f12516e;
        this.f12505e = bVar.f12517f;
        this.f12506f = bVar.f12518g;
        this.f12507g = bVar.f12519h;
        this.f12508h = bVar.f12520i;
        this.f12509i = bVar.f12521j;
        this.f12510j = bVar.f12522k;
        this.f12511k = bVar.f12523l;
        this.f12512l = bVar.m;
        if (bVar.n != null) {
            this.m = bVar.n;
        } else {
            this.m = new c();
        }
        this.n = bVar.o;
        this.o = bVar.p;
        this.p = bVar.q;
    }
}