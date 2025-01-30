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
public final class e extends j<e, a> implements o {

    /* renamed from: d  reason: collision with root package name */
    private static final e f9496d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile q<e> f9497e;

    /* renamed from: f  reason: collision with root package name */
    private int f9498f;

    /* renamed from: g  reason: collision with root package name */
    private String f9499g = "";

    /* renamed from: h  reason: collision with root package name */
    private k.a<c> f9500h = j.f();

    /* compiled from: com.google.firebase:firebase-config@@19.0.4 */
    /* loaded from: classes2.dex */
    public static final class a extends j.b<e, a> implements o {
        /* synthetic */ a(com.google.firebase.remoteconfig.m.a aVar) {
            this();
        }

        private a() {
            super(e.f9496d);
        }
    }

    static {
        e eVar = new e();
        f9496d = eVar;
        eVar.l();
    }

    private e() {
    }

    public static q<e> z() {
        return f9496d.getParserForType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.protobuf.j
    protected final Object e(j.i iVar, Object obj, Object obj2) {
        switch (com.google.firebase.remoteconfig.m.a.a[iVar.ordinal()]) {
            case 1:
                return new e();
            case 2:
                return f9496d;
            case 3:
                this.f9500h.v();
                return null;
            case 4:
                return new a(null);
            case 5:
                j.InterfaceC0203j interfaceC0203j = (j.InterfaceC0203j) obj;
                e eVar = (e) obj2;
                this.f9499g = interfaceC0203j.e(y(), this.f9499g, eVar.y(), eVar.f9499g);
                this.f9500h = interfaceC0203j.f(this.f9500h, eVar.f9500h);
                if (interfaceC0203j == j.h.a) {
                    this.f9498f |= eVar.f9498f;
                }
                return this;
            case 6:
                com.google.protobuf.f fVar = (com.google.protobuf.f) obj;
                h hVar = (h) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int z2 = fVar.z();
                            if (z2 != 0) {
                                if (z2 == 10) {
                                    String x = fVar.x();
                                    this.f9498f = 1 | this.f9498f;
                                    this.f9499g = x;
                                } else if (z2 != 18) {
                                    if (!s(z2, fVar)) {
                                    }
                                } else {
                                    if (!this.f9500h.d1()) {
                                        this.f9500h = j.m(this.f9500h);
                                    }
                                    this.f9500h.add((c) fVar.p(c.A(), hVar));
                                }
                            }
                            z = true;
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).h(this));
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw new RuntimeException(e3.h(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f9497e == null) {
                    synchronized (e.class) {
                        if (f9497e == null) {
                            f9497e = new j.c(f9496d);
                        }
                    }
                }
                return f9497e;
            default:
                throw new UnsupportedOperationException();
        }
        return f9496d;
    }

    public List<c> w() {
        return this.f9500h;
    }

    public String x() {
        return this.f9499g;
    }

    public boolean y() {
        return (this.f9498f & 1) == 1;
    }
}