package com.google.firebase.remoteconfig.m;

import com.google.firebase.remoteconfig.m.b;
import com.google.firebase.remoteconfig.m.d;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.h;
import com.google.protobuf.j;
import com.google.protobuf.k;
import com.google.protobuf.o;
import com.google.protobuf.q;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public final class f extends j<f, a> implements o {

    /* renamed from: d  reason: collision with root package name */
    private static final f f9501d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile q<f> f9502e;

    /* renamed from: f  reason: collision with root package name */
    private int f9503f;

    /* renamed from: g  reason: collision with root package name */
    private b f9504g;

    /* renamed from: h  reason: collision with root package name */
    private b f9505h;

    /* renamed from: j  reason: collision with root package name */
    private b f9506j;

    /* renamed from: k  reason: collision with root package name */
    private d f9507k;

    /* renamed from: l  reason: collision with root package name */
    private k.a<g> f9508l = j.f();

    /* compiled from: com.google.firebase:firebase-config@@19.0.4 */
    /* loaded from: classes2.dex */
    public static final class a extends j.b<f, a> implements o {
        /* synthetic */ a(com.google.firebase.remoteconfig.m.a aVar) {
            this();
        }

        private a() {
            super(f.f9501d);
        }
    }

    static {
        f fVar = new f();
        f9501d = fVar;
        fVar.l();
    }

    private f() {
    }

    public static f z(InputStream inputStream) throws IOException {
        return (f) j.o(f9501d, inputStream);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.protobuf.j
    protected final Object e(j.i iVar, Object obj, Object obj2) {
        switch (com.google.firebase.remoteconfig.m.a.a[iVar.ordinal()]) {
            case 1:
                return new f();
            case 2:
                return f9501d;
            case 3:
                this.f9508l.v();
                return null;
            case 4:
                return new a(null);
            case 5:
                j.InterfaceC0203j interfaceC0203j = (j.InterfaceC0203j) obj;
                f fVar = (f) obj2;
                this.f9504g = (b) interfaceC0203j.a(this.f9504g, fVar.f9504g);
                this.f9505h = (b) interfaceC0203j.a(this.f9505h, fVar.f9505h);
                this.f9506j = (b) interfaceC0203j.a(this.f9506j, fVar.f9506j);
                this.f9507k = (d) interfaceC0203j.a(this.f9507k, fVar.f9507k);
                this.f9508l = interfaceC0203j.f(this.f9508l, fVar.f9508l);
                if (interfaceC0203j == j.h.a) {
                    this.f9503f |= fVar.f9503f;
                }
                return this;
            case 6:
                com.google.protobuf.f fVar2 = (com.google.protobuf.f) obj;
                h hVar = (h) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int z2 = fVar2.z();
                        if (z2 != 0) {
                            if (z2 == 10) {
                                b.a builder = (this.f9503f & 1) == 1 ? this.f9504g.toBuilder() : null;
                                b bVar = (b) fVar2.p(b.B(), hVar);
                                this.f9504g = bVar;
                                if (builder != null) {
                                    builder.n(bVar);
                                    this.f9504g = builder.f();
                                }
                                this.f9503f |= 1;
                            } else if (z2 == 18) {
                                b.a builder2 = (this.f9503f & 2) == 2 ? this.f9505h.toBuilder() : null;
                                b bVar2 = (b) fVar2.p(b.B(), hVar);
                                this.f9505h = bVar2;
                                if (builder2 != null) {
                                    builder2.n(bVar2);
                                    this.f9505h = builder2.f();
                                }
                                this.f9503f |= 2;
                            } else if (z2 == 26) {
                                b.a builder3 = (this.f9503f & 4) == 4 ? this.f9506j.toBuilder() : null;
                                b bVar3 = (b) fVar2.p(b.B(), hVar);
                                this.f9506j = bVar3;
                                if (builder3 != null) {
                                    builder3.n(bVar3);
                                    this.f9506j = builder3.f();
                                }
                                this.f9503f |= 4;
                            } else if (z2 == 34) {
                                d.a builder4 = (this.f9503f & 8) == 8 ? this.f9507k.toBuilder() : null;
                                d dVar = (d) fVar2.p(d.z(), hVar);
                                this.f9507k = dVar;
                                if (builder4 != null) {
                                    builder4.n(dVar);
                                    this.f9507k = builder4.f();
                                }
                                this.f9503f |= 8;
                            } else if (z2 != 42) {
                                if (!s(z2, fVar2)) {
                                }
                            } else {
                                if (!this.f9508l.d1()) {
                                    this.f9508l = j.m(this.f9508l);
                                }
                                this.f9508l.add((g) fVar2.p(g.z(), hVar));
                            }
                        }
                        z = true;
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
                if (f9502e == null) {
                    synchronized (f.class) {
                        if (f9502e == null) {
                            f9502e = new j.c(f9501d);
                        }
                    }
                }
                return f9502e;
            default:
                throw new UnsupportedOperationException();
        }
        return f9501d;
    }

    public b w() {
        b bVar = this.f9505h;
        return bVar == null ? b.w() : bVar;
    }

    public b x() {
        b bVar = this.f9506j;
        return bVar == null ? b.w() : bVar;
    }

    public b y() {
        b bVar = this.f9504g;
        return bVar == null ? b.w() : bVar;
    }
}