package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import c.f.b.k.e;

/* compiled from: Placeholder.java */
/* loaded from: classes.dex */
public class g extends View {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private View f1328b;

    /* renamed from: c  reason: collision with root package name */
    private int f1329c;

    public void a(ConstraintLayout constraintLayout) {
        if (this.f1328b == null) {
            return;
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.f1328b.getLayoutParams();
        bVar2.n0.E0(0);
        e.b z = bVar.n0.z();
        e.b bVar3 = e.b.FIXED;
        if (z != bVar3) {
            bVar.n0.F0(bVar2.n0.Q());
        }
        if (bVar.n0.N() != bVar3) {
            bVar.n0.i0(bVar2.n0.w());
        }
        bVar2.n0.E0(8);
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.a == -1 && !isInEditMode()) {
            setVisibility(this.f1329c);
        }
        View findViewById = constraintLayout.findViewById(this.a);
        this.f1328b = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.b) findViewById.getLayoutParams()).b0 = true;
            this.f1328b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f1328b;
    }

    public int getEmptyVisibility() {
        return this.f1329c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i2) {
        View findViewById;
        if (this.a == i2) {
            return;
        }
        View view = this.f1328b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.b) this.f1328b.getLayoutParams()).b0 = false;
            this.f1328b = null;
        }
        this.a = i2;
        if (i2 == -1 || (findViewById = ((View) getParent()).findViewById(i2)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i2) {
        this.f1329c = i2;
    }
}