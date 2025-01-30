package com.google.firebase.remoteconfig.m;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.h;
import com.google.protobuf.j;
import com.google.protobuf.o;
import com.google.protobuf.q;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public final class d extends j<d, a> implements o {

    /* renamed from: d  reason: collision with root package name */
    private static final d f9490d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile q<d> f9491e;

    /* renamed from: f  reason: collision with root package name */
    private int f9492f;

    /* renamed from: g  reason: collision with root package name */
    private int f9493g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9494h;

    /* renamed from: j  reason: collision with root package name */
    private long f9495j;

    /* compiled from: com.google.firebase:firebase-config@@19.0.4 */
    /* loaded from: classes2.dex */
    public static final class a extends j.b<d, a> implements o {
        /* synthetic */ a(com.google.firebase.remoteconfig.m.a aVar) {
            this();
        }

        private a() {
            super(d.f9490d);
        }
    }

    static {
        d dVar = new d();
        f9490d = dVar;
        dVar.l();
    }

    private d() {
    }

    public static q<d> z() {
        return f9490d.getParserForType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.protobuf.j
    protected final Object e(j.i iVar, Object obj, Object obj2) {
        switch (com.google.firebase.remoteconfig.m.a.a[iVar.ordinal()]) {
            case 1:
                return new d();
            case 2:
                return f9490d;
            case 3:
                return null;
            case 4:
                return new a(null);
            case 5:
                j.InterfaceC0203j interfaceC0203j = (j.InterfaceC0203j) obj;
                d dVar = (d) obj2;
                this.f9493g = interfaceC0203j.c(x(), this.f9493g, dVar.x(), dVar.f9493g);
                this.f9494h = interfaceC0203j.g(w(), this.f9494h, dVar.w(), dVar.f9494h);
                this.f9495j = interfaceC0203j.i(y(), this.f9495j, dVar.y(), dVar.f9495j);
                if (interfaceC0203j == j.h.a) {
                    this.f9492f |= dVar.f9492f;
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
                                this.f9492f |= 1;
                                this.f9493g = fVar.n();
                            } else if (z2 == 16) {
                                this.f9492f |= 2;
                                this.f9494h = fVar.i();
                            } else if (z2 != 25) {
                                if (!s(z2, fVar)) {
                                }
                            } else {
                                this.f9492f |= 4;
                                this.f9495j = fVar.m();
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
                if (f9491e == null) {
                    synchronized (d.class) {
                        if (f9491e == null) {
                            f9491e = new j.c(f9490d);
                        }
                    }
                }
                return f9491e;
            default:
                throw new UnsupportedOperationException();
        }
        return f9490d;
    }

    public boolean w() {
        return (this.f9492f & 2) == 2;
    }

    public boolean x() {
        return (this.f9492f & 1) == 1;
    }

    public boolean y() {
        return (this.f9492f & 4) == 4;
    }
}