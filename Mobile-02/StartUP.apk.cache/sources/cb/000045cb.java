package e.f.h.e;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;

/* compiled from: RoundedNinePatchDrawable.java */
/* loaded from: classes2.dex */
public class o extends n {
    public o(NinePatchDrawable ninePatchDrawable) {
        super(ninePatchDrawable);
    }

    @Override // e.f.h.e.n, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("RoundedNinePatchDrawable#draw");
        }
        if (!g()) {
            super.draw(canvas);
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
                return;
            }
            return;
        }
        k();
        j();
        canvas.clipPath(this.f12299e);
        super.draw(canvas);
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
    }
}