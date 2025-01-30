package g.a.a;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.f;
import com.google.protobuf.h;
import com.google.protobuf.j;
import com.google.protobuf.o;
import com.google.protobuf.q;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-abt@@19.0.0 */
/* loaded from: classes2.dex */
public final class b extends j<b, a> implements o {

    /* renamed from: d  reason: collision with root package name */
    private static final b f14016d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile q<b> f14017e;

    /* renamed from: f  reason: collision with root package name */
    private String f14018f = "";

    /* compiled from: com.google.firebase:firebase-abt@@19.0.0 */
    /* loaded from: classes2.dex */
    public static final class a extends j.b<b, a> implements o {
        /* synthetic */ a(g.a.a.a aVar) {
            this();
        }

        private a() {
            super(b.f14016d);
        }
    }

    static {
        b bVar = new b();
        f14016d = bVar;
        bVar.l();
    }

    private b() {
    }

    public static q<b> w() {
        return f14016d.getParserForType();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.protobuf.j
    protected final Object e(j.i iVar, Object obj, Object obj2) {
        switch (g.a.a.a.a[iVar.ordinal()]) {
            case 1:
                return new b();
            case 2:
                return f14016d;
            case 3:
                return null;
            case 4:
                return new a(null);
            case 5:
                b bVar = (b) obj2;
                this.f14018f = ((j.InterfaceC0203j) obj).e(!this.f14018f.isEmpty(), this.f14018f, true ^ bVar.f14018f.isEmpty(), bVar.f14018f);
                j.h hVar = j.h.a;
                return this;
            case 6:
                f fVar = (f) obj;
                h hVar2 = (h) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int z2 = fVar.z();
                        if (z2 != 0) {
                            if (z2 != 10) {
                                if (!fVar.C(z2)) {
                                }
                            } else {
                                this.f14018f = fVar.y();
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
                if (f14017e == null) {
                    synchronized (b.class) {
                        if (f14017e == null) {
                            f14017e = new j.c(f14016d);
                        }
                    }
                }
                return f14017e;
            default:
                throw new UnsupportedOperationException();
        }
        return f14016d;
    }
}