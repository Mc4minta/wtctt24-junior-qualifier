package c.s;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* compiled from: ViewOverlayApi18.java */
/* loaded from: classes.dex */
class n0 implements o0 {
    private final ViewOverlay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n0(View view) {
        this.a = view.getOverlay();
    }

    @Override // c.s.o0
    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // c.s.o0
    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }
}