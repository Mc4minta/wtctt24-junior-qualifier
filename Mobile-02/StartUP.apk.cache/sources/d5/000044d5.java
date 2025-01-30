package e.a.a.w.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import e.a.a.w.k.n;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeLayer.java */
/* loaded from: classes.dex */
public class f extends a {
    private final e.a.a.u.b.d x;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e.a.a.g gVar, d dVar) {
        super(gVar, dVar);
        e.a.a.u.b.d dVar2 = new e.a.a.u.b.d(gVar, this, new n("__container", dVar.l(), false));
        this.x = dVar2;
        dVar2.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // e.a.a.w.l.a
    protected void D(e.a.a.w.e eVar, int i2, List<e.a.a.w.e> list, e.a.a.w.e eVar2) {
        this.x.c(eVar, i2, list, eVar2);
    }

    @Override // e.a.a.w.l.a, e.a.a.u.b.e
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        this.x.d(rectF, this.m, z);
    }

    @Override // e.a.a.w.l.a
    void t(Canvas canvas, Matrix matrix, int i2) {
        this.x.f(canvas, matrix, i2);
    }
}