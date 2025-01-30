package e.f.h.f;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import e.f.h.e.g;
import e.f.h.e.t;
import e.f.h.e.u;

/* compiled from: RootDrawable.java */
/* loaded from: classes2.dex */
public class c extends g implements t {

    /* renamed from: e  reason: collision with root package name */
    Drawable f12346e;

    /* renamed from: f  reason: collision with root package name */
    private u f12347f;

    public c(Drawable drawable) {
        super(drawable);
        this.f12346e = null;
    }

    @Override // e.f.h.e.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            u uVar = this.f12347f;
            if (uVar != null) {
                uVar.a();
            }
            super.draw(canvas);
            Drawable drawable = this.f12346e;
            if (drawable != null) {
                drawable.setBounds(getBounds());
                this.f12346e.draw(canvas);
            }
        }
    }

    @Override // e.f.h.e.g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // e.f.h.e.g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    @Override // e.f.h.e.t
    public void j(u uVar) {
        this.f12347f = uVar;
    }

    public void p(Drawable drawable) {
        this.f12346e = drawable;
        invalidateSelf();
    }

    @Override // e.f.h.e.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        u uVar = this.f12347f;
        if (uVar != null) {
            uVar.b(z);
        }
        return super.setVisible(z, z2);
    }
}