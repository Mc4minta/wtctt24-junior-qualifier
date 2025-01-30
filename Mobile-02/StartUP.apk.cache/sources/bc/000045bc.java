package e.f.h.e;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

/* compiled from: AutoRotateDrawable.java */
/* loaded from: classes2.dex */
public class b extends g implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    private int f12254e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12255f;

    /* renamed from: g  reason: collision with root package name */
    float f12256g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12257h;

    public b(Drawable drawable, int i2) {
        this(drawable, i2, true);
    }

    private int p() {
        return (int) ((20.0f / this.f12254e) * 360.0f);
    }

    private void q() {
        if (this.f12257h) {
            return;
        }
        this.f12257h = true;
        scheduleSelf(this, SystemClock.uptimeMillis() + 20);
    }

    @Override // e.f.h.e.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i2 = bounds.right;
        int i3 = bounds.left;
        int i4 = i2 - i3;
        int i5 = bounds.bottom;
        int i6 = bounds.top;
        int i7 = i5 - i6;
        float f2 = this.f12256g;
        if (!this.f12255f) {
            f2 = 360.0f - f2;
        }
        canvas.rotate(f2, i3 + (i4 / 2), i6 + (i7 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        q();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f12257h = false;
        this.f12256g += p();
        invalidateSelf();
    }

    public b(Drawable drawable, int i2, boolean z) {
        super((Drawable) e.f.d.c.i.g(drawable));
        this.f12256g = 0.0f;
        this.f12257h = false;
        this.f12254e = i2;
        this.f12255f = z;
    }
}