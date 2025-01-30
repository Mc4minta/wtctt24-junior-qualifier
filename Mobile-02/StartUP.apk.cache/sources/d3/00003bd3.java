package com.google.firebase.remoteconfig.m;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.h;
import com.google.protobuf.j;
import com.google.protobuf.o;
import com.google.protobuf.q;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public final class c extends j<c, a> implements o {

    /* renamed from: d  reason: collision with root package name */
    private static final c f9485d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile q<c> f9486e;

    /* renamed from: f  reason: collision with root package name */
    private int f9487f;

    /* renamed from: g  reason: collision with root package name */
    private String f9488g = "";

    /* renamed from: h  reason: collision with root package name */
    private com.google.protobuf.e f9489h = com.google.protobuf.e.a;

    /* compiled from: com.google.firebase:firebase-config@@19.0.4 */
    /* loaded from: classes2.dex */
    public static final class a extends j.b<c, a> implements o {
        /* synthetic */ a(com.google.firebase.remoteconfig.m.a aVar) {
            this();
        }

        private a() {
            super(c.f9485d);
        }
    }

    static {
        c cVar = new c();
        f9485d = cVar;
        cVar.l();
    }

    private c() {
    }

    public static q<c> A() {
        return f9485d.getParserForType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.protobuf.j
    protected final Object e(j.i iVar, Object obj, Object obj2) {
        switch (com.google.firebase.remoteconfig.m.a.a[iVar.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return f9485d;
            case 3:
                return null;
            case 4:
                return new a(null);
            case 5:
                j.InterfaceC0203j interfaceC0203j = (j.InterfaceC0203j) obj;
                c cVar = (c) obj2;
                this.f9488g = interfaceC0203j.e(y(), this.f9488g, cVar.y(), cVar.f9488g);
                this.f9489h = interfaceC0203j.h(z(), this.f9489h, cVar.z(), cVar.f9489h);
                if (interfaceC0203j == j.h.a) {
                    this.f9487f |= cVar.f9487f;
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
                                String x = fVar.x();
                                this.f9487f = 1 | this.f9487f;
                                this.f9488g = x;
                            } else if (z2 != 18) {
                                if (!s(z2, fVar)) {
                                }
                            } else {
                                this.f9487f |= 2;
                                this.f9489h = fVar.j();
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
                if (f9486e == null) {
                    synchronized (c.class) {
                        if (f9486e == null) {
                            f9486e = new j.c(f9485d);
                        }
                    }
                }
                return f9486e;
            default:
                throw new UnsupportedOperationException();
        }
        return f9485d;
    }

    public String w() {
        return this.f9488g;
    }

    public com.google.protobuf.e x() {
        return this.f9489h;
    }

    public boolean y() {
        return (this.f9487f & 1) == 1;
    }

    public boolean z() {
        return (this.f9487f & 2) == 2;
    }
}