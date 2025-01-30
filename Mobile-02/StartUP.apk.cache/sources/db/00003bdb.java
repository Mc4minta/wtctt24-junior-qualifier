package com.google.firebase.remoteconfig.m;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.h;
import com.google.protobuf.j;
import com.google.protobuf.o;
import com.google.protobuf.q;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public final class g extends j<g, a> implements o {

    /* renamed from: d  reason: collision with root package name */
    private static final g f9509d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile q<g> f9510e;

    /* renamed from: f  reason: collision with root package name */
    private int f9511f;

    /* renamed from: g  reason: collision with root package name */
    private int f9512g;

    /* renamed from: h  reason: collision with root package name */
    private long f9513h;

    /* renamed from: j  reason: collision with root package name */
    private String f9514j = "";

    /* compiled from: com.google.firebase:firebase-config@@19.0.4 */
    /* loaded from: classes2.dex */
    public static final class a extends j.b<g, a> implements o {
        /* synthetic */ a(com.google.firebase.remoteconfig.m.a aVar) {
            this();
        }

        private a() {
            super(g.f9509d);
        }
    }

    static {
        g gVar = new g();
        f9509d = gVar;
        gVar.l();
    }

    private g() {
    }

    public static q<g> z() {
        return f9509d.getParserForType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.protobuf.j
    protected final Object e(j.i iVar, Object obj, Object obj2) {
        switch (com.google.firebase.remoteconfig.m.a.a[iVar.ordinal()]) {
            case 1:
                return new g();
            case 2:
                return f9509d;
            case 3:
                return null;
            case 4:
                return new a(null);
            case 5:
                j.InterfaceC0203j interfaceC0203j = (j.InterfaceC0203j) obj;
                g gVar = (g) obj2;
                this.f9512g = interfaceC0203j.c(y(), this.f9512g, gVar.y(), gVar.f9512g);
                this.f9513h = interfaceC0203j.i(w(), this.f9513h, gVar.w(), gVar.f9513h);
                this.f9514j = interfaceC0203j.e(x(), this.f9514j, gVar.x(), gVar.f9514j);
                if (interfaceC0203j == j.h.a) {
                    this.f9511f |= gVar.f9511f;
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
                            if (z2 == 8) {
                                this.f9511f |= 1;
                                this.f9512g = fVar.n();
                            } else if (z2 == 17) {
                                this.f9511f |= 2;
                                this.f9513h = fVar.m();
                            } else if (z2 != 26) {
                                if (!s(z2, fVar)) {
                                }
                            } else {
                                String x = fVar.x();
                                this.f9511f |= 4;
                                this.f9514j = x;
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
                if (f9510e == null) {
                    synchronized (g.class) {
                        if (f9510e == null) {
                            f9510e = new j.c(f9509d);
                        }
                    }
                }
                return f9510e;
            default:
                throw new UnsupportedOperationException();
        }
        return f9509d;
    }

    public boolean w() {
        return (this.f9511f & 2) == 2;
    }

    public boolean x() {
        return (this.f9511f & 4) == 4;
    }

    public boolean y() {
        return (this.f9511f & 1) == 1;
    }
}