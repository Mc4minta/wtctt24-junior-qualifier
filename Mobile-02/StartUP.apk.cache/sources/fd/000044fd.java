package e.a.a.y;

import java.io.IOException;

/* compiled from: IntegerParser.java */
/* loaded from: classes.dex */
public class o implements j0<Integer> {
    public static final o a = new o();

    private o() {
    }

    @Override // e.a.a.y.j0
    /* renamed from: b */
    public Integer a(e.a.a.y.k0.c cVar, float f2) throws IOException {
        return Integer.valueOf(Math.round(p.g(cVar) * f2));
    }
}