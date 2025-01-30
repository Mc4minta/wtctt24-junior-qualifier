package c.s;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* compiled from: ViewGroupOverlayApi18.java */
/* loaded from: classes.dex */
class i0 implements j0 {
    private final ViewGroupOverlay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(ViewGroup viewGroup) {
        this.a = viewGroup.getOverlay();
    }

    @Override // c.s.o0
    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // c.s.o0
    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }

    @Override // c.s.j0
    public void c(View view) {
        this.a.add(view);
    }

    @Override // c.s.j0
    public void d(View view) {
        this.a.remove(view);
    }
}