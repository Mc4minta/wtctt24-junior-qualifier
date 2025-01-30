package com.google.firebase.remoteconfig.m;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.h;
import com.google.protobuf.j;
import com.google.protobuf.k;
import com.google.protobuf.o;
import com.google.protobuf.q;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public final class b extends j<b, a> implements o {

    /* renamed from: d  reason: collision with root package name */
    private static final b f9479d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile q<b> f9480e;

    /* renamed from: f  reason: collision with root package name */
    private int f9481f;

    /* renamed from: h  reason: collision with root package name */
    private long f9483h;

    /* renamed from: g  reason: collision with root package name */
    private k.a<e> f9482g = j.f();

    /* renamed from: j  reason: collision with root package name */
    private k.a<com.google.protobuf.e> f9484j = j.f();

    /* compiled from: com.google.firebase:firebase-config@@19.0.4 */
    /* loaded from: classes2.dex */
    public static final class a extends j.b<b, a> implements o {
        /* synthetic */ a(com.google.firebase.remoteconfig.m.a aVar) {
            this();
        }

        private a() {
            super(b.f9479d);
        }
    }

    static {
        b bVar = new b();
        f9479d = bVar;
        bVar.l();
    }

    private b() {
    }

    public static q<b> B() {
        return f9479d.getParserForType();
    }

    public static b w() {
        return f9479d;
    }

    public boolean A() {
        return (this.f9481f & 1) == 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.protobuf.j
    protected final Object e(j.i iVar, Object obj, Object obj2) {
        switch (com.google.firebase.remoteconfig.m.a.a[iVar.ordinal()]) {
            case 1:
                return new b();
            case 2:
                return f9479d;
            case 3:
                this.f9482g.v();
                this.f9484j.v();
                return null;
            case 4:
                return new a(null);
            case 5:
                j.InterfaceC0203j interfaceC0203j = (j.InterfaceC0203j) obj;
                b bVar = (b) obj2;
                this.f9482g = interfaceC0203j.f(this.f9482g, bVar.f9482g);
                this.f9483h = interfaceC0203j.i(A(), this.f9483h, bVar.A(), bVar.f9483h);
                this.f9484j = interfaceC0203j.f(this.f9484j, bVar.f9484j);
                if (interfaceC0203j == j.h.a) {
                    this.f9481f |= bVar.f9481f;
                }
                return this;
            case 6:
                com.google.protobuf.f fVar = (com.google.protobuf.f) obj;
                h hVar = (h) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int z2 = fVar.z();
                        if (z2 != 0) {
                            if (z2 == 10) {
                                if (!this.f9482g.d1()) {
                                    this.f9482g = j.m(this.f9482g);
                                }
                                this.f9482g.add((e) fVar.p(e.z(), hVar));
                            } else if (z2 == 17) {
                                this.f9481f |= 1;
                                this.f9483h = fVar.m();
                            } else if (z2 != 26) {
                                if (!s(z2, fVar)) {
                                }
                            } else {
                                if (!this.f9484j.d1()) {
                                    this.f9484j = j.m(this.f9484j);
                                }
                                this.f9484j.add(fVar.j());
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
                if (f9480e == null) {
                    synchronized (b.class) {
                        if (f9480e == null) {
                            f9480e = new j.c(f9479d);
                        }
                    }
                }
                return f9480e;
            default:
                throw new UnsupportedOperationException();
        }
        return f9479d;
    }

    public List<com.google.protobuf.e> x() {
        return this.f9484j;
    }

    public List<e> y() {
        return this.f9482g;
    }

    public long z() {
        return this.f9483h;
    }
}