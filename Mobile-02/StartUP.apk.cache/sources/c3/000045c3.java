package e.f.h.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: OrientedDrawable.java */
/* loaded from: classes2.dex */
public class i extends g {

    /* renamed from: e  reason: collision with root package name */
    final Matrix f12272e;

    /* renamed from: f  reason: collision with root package name */
    private int f12273f;

    /* renamed from: g  reason: collision with root package name */
    private int f12274g;

    /* renamed from: h  reason: collision with root package name */
    private final Matrix f12275h;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f12276j;

    public i(Drawable drawable, int i2, int i3) {
        super(drawable);
        this.f12275h = new Matrix();
        this.f12276j = new RectF();
        this.f12272e = new Matrix();
        this.f12273f = i2 - (i2 % 90);
        this.f12274g = (i3 < 0 || i3 > 8) ? 0 : 0;
    }

    @Override // e.f.h.e.g, e.f.h.e.s
    public void d(Matrix matrix) {
        m(matrix);
        if (this.f12272e.isIdentity()) {
            return;
        }
        matrix.preConcat(this.f12272e);
    }

    @Override // e.f.h.e.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i2;
        if (this.f12273f <= 0 && ((i2 = this.f12274g) == 0 || i2 == 1)) {
            super.draw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.concat(this.f12272e);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // e.f.h.e.g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i2 = this.f12274g;
        if (i2 != 5 && i2 != 7 && this.f12273f % CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 == 0) {
            return super.getIntrinsicHeight();
        }
        return super.getIntrinsicWidth();
    }

    @Override // e.f.h.e.g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i2 = this.f12274g;
        if (i2 != 5 && i2 != 7 && this.f12273f % CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 == 0) {
            return super.getIntrinsicWidth();
        }
        return super.getIntrinsicHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.h.e.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int i2;
        Drawable current = getCurrent();
        int i3 = this.f12273f;
        if (i3 <= 0 && ((i2 = this.f12274g) == 0 || i2 == 1)) {
            current.setBounds(rect);
            return;
        }
        int i4 = this.f12274g;
        if (i4 == 2) {
            this.f12272e.setScale(-1.0f, 1.0f);
        } else if (i4 == 7) {
            this.f12272e.setRotate(270.0f, rect.centerX(), rect.centerY());
            this.f12272e.postScale(-1.0f, 1.0f);
        } else if (i4 == 4) {
            this.f12272e.setScale(1.0f, -1.0f);
        } else if (i4 != 5) {
            this.f12272e.setRotate(i3, rect.centerX(), rect.centerY());
        } else {
            this.f12272e.setRotate(270.0f, rect.centerX(), rect.centerY());
            this.f12272e.postScale(1.0f, -1.0f);
        }
        this.f12275h.reset();
        this.f12272e.invert(this.f12275h);
        this.f12276j.set(rect);
        this.f12275h.mapRect(this.f12276j);
        RectF rectF = this.f12276j;
        current.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }
}