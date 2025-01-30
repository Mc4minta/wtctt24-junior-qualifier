package g.a.a;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.f;
import com.google.protobuf.h;
import com.google.protobuf.j;
import com.google.protobuf.k;
import com.google.protobuf.o;
import com.google.protobuf.q;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-abt@@19.0.0 */
/* loaded from: classes2.dex */
public final class c extends j<c, a> implements o {

    /* renamed from: d  reason: collision with root package name */
    private static final c f14019d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile q<c> f14020e;

    /* renamed from: f  reason: collision with root package name */
    private int f14021f;

    /* renamed from: j  reason: collision with root package name */
    private long f14024j;

    /* renamed from: l  reason: collision with root package name */
    private long f14026l;
    private long m;
    private int v;

    /* renamed from: g  reason: collision with root package name */
    private String f14022g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f14023h = "";

    /* renamed from: k  reason: collision with root package name */
    private String f14025k = "";
    private String n = "";
    private String p = "";
    private String q = "";
    private String t = "";
    private String u = "";
    private k.a<b> w = j.f();

    /* compiled from: com.google.firebase:firebase-abt@@19.0.0 */
    /* loaded from: classes2.dex */
    public static final class a extends j.b<c, a> implements o {
        /* synthetic */ a(g.a.a.a aVar) {
            this();
        }

        private a() {
            super(c.f14019d);
        }
    }

    static {
        c cVar = new c();
        f14019d = cVar;
        cVar.l();
    }

    private c() {
    }

    public static c C(byte[] bArr) throws InvalidProtocolBufferException {
        return (c) j.p(f14019d, bArr);
    }

    public long A() {
        return this.f14026l;
    }

    public String B() {
        return this.f14023h;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.protobuf.j
    protected final Object e(j.i iVar, Object obj, Object obj2) {
        switch (g.a.a.a.a[iVar.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return f14019d;
            case 3:
                this.w.v();
                return null;
            case 4:
                return new a(null);
            case 5:
                j.InterfaceC0203j interfaceC0203j = (j.InterfaceC0203j) obj;
                c cVar = (c) obj2;
                this.f14022g = interfaceC0203j.e(!this.f14022g.isEmpty(), this.f14022g, !cVar.f14022g.isEmpty(), cVar.f14022g);
                this.f14023h = interfaceC0203j.e(!this.f14023h.isEmpty(), this.f14023h, !cVar.f14023h.isEmpty(), cVar.f14023h);
                long j2 = this.f14024j;
                boolean z = j2 != 0;
                long j3 = cVar.f14024j;
                this.f14024j = interfaceC0203j.i(z, j2, j3 != 0, j3);
                this.f14025k = interfaceC0203j.e(!this.f14025k.isEmpty(), this.f14025k, !cVar.f14025k.isEmpty(), cVar.f14025k);
                long j4 = this.f14026l;
                boolean z2 = j4 != 0;
                long j5 = cVar.f14026l;
                this.f14026l = interfaceC0203j.i(z2, j4, j5 != 0, j5);
                long j6 = this.m;
                boolean z3 = j6 != 0;
                long j7 = cVar.m;
                this.m = interfaceC0203j.i(z3, j6, j7 != 0, j7);
                this.n = interfaceC0203j.e(!this.n.isEmpty(), this.n, !cVar.n.isEmpty(), cVar.n);
                this.p = interfaceC0203j.e(!this.p.isEmpty(), this.p, !cVar.p.isEmpty(), cVar.p);
                this.q = interfaceC0203j.e(!this.q.isEmpty(), this.q, !cVar.q.isEmpty(), cVar.q);
                this.t = interfaceC0203j.e(!this.t.isEmpty(), this.t, !cVar.t.isEmpty(), cVar.t);
                this.u = interfaceC0203j.e(!this.u.isEmpty(), this.u, !cVar.u.isEmpty(), cVar.u);
                int i2 = this.v;
                boolean z4 = i2 != 0;
                int i3 = cVar.v;
                this.v = interfaceC0203j.c(z4, i2, i3 != 0, i3);
                this.w = interfaceC0203j.f(this.w, cVar.w);
                if (interfaceC0203j == j.h.a) {
                    this.f14021f |= cVar.f14021f;
                }
                return this;
            case 6:
                f fVar = (f) obj;
                h hVar = (h) obj2;
                while (!r1) {
                    try {
                        int z5 = fVar.z();
                        switch (z5) {
                            case 0:
                                break;
                            case 10:
                                this.f14022g = fVar.y();
                                continue;
                            case 18:
                                this.f14023h = fVar.y();
                                continue;
                            case 24:
                                this.f14024j = fVar.o();
                                continue;
                            case 34:
                                this.f14025k = fVar.y();
                                continue;
                            case 40:
                                this.f14026l = fVar.o();
                                continue;
                            case 48:
                                this.m = fVar.o();
                                continue;
                            case 58:
                                this.n = fVar.y();
                                continue;
                            case 66:
                                this.p = fVar.y();
                                continue;
                            case 74:
                                this.q = fVar.y();
                                continue;
                            case 82:
                                this.t = fVar.y();
                                continue;
                            case 90:
                                this.u = fVar.y();
                                continue;
                            case 96:
                                this.v = fVar.k();
                                continue;
                            case 106:
                                if (!this.w.d1()) {
                                    this.w = j.m(this.w);
                                }
                                this.w.add((b) fVar.p(b.w(), hVar));
                                continue;
                            default:
                                if (!fVar.C(z5)) {
                                    break;
                                } else {
                                    continue;
                                }
                        }
                        r1 = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw new RuntimeException(e2.h(this));
                    } catch (IOException e3) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).h(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f14020e == null) {
                    synchronized (c.class) {
                        if (f14020e == null) {
                            f14020e = new j.c(f14019d);
                        }
                    }
                }
                return f14020e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14019d;
    }

    public String w() {
        return this.f14022g;
    }

    public long x() {
        return this.f14024j;
    }

    public long y() {
        return this.m;
    }

    public String z() {
        return this.f14025k;
    }
}