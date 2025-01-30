package e.a.a.y;

import e.a.a.w.b;
import e.a.a.y.k0.c;
import java.io.IOException;

/* compiled from: DocumentDataParser.java */
/* loaded from: classes.dex */
public class h implements j0<e.a.a.w.b> {
    public static final h a = new h();

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f11921b = c.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private h() {
    }

    @Override // e.a.a.y.j0
    /* renamed from: b */
    public e.a.a.w.b a(e.a.a.y.k0.c cVar, float f2) throws IOException {
        b.a aVar = b.a.CENTER;
        cVar.c();
        b.a aVar2 = aVar;
        String str = null;
        String str2 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        boolean z = true;
        while (cVar.f()) {
            switch (cVar.K(f11921b)) {
                case 0:
                    str = cVar.v();
                    break;
                case 1:
                    str2 = cVar.v();
                    break;
                case 2:
                    f3 = (float) cVar.j();
                    break;
                case 3:
                    int m = cVar.m();
                    aVar2 = b.a.CENTER;
                    if (m <= aVar2.ordinal() && m >= 0) {
                        aVar2 = b.a.values()[m];
                        break;
                    }
                    break;
                case 4:
                    i2 = cVar.m();
                    break;
                case 5:
                    f4 = (float) cVar.j();
                    break;
                case 6:
                    f5 = (float) cVar.j();
                    break;
                case 7:
                    i3 = p.d(cVar);
                    break;
                case 8:
                    i4 = p.d(cVar);
                    break;
                case 9:
                    f6 = (float) cVar.j();
                    break;
                case 10:
                    z = cVar.g();
                    break;
                default:
                    cVar.N();
                    cVar.O();
                    break;
            }
        }
        cVar.e();
        return new e.a.a.w.b(str, str2, f3, aVar2, i2, f4, f5, i3, i4, f6, z);
    }
}