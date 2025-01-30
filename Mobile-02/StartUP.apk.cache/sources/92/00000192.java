package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.widget.g;

/* compiled from: CardViewApi17Impl.java */
/* loaded from: classes.dex */
class a extends c {

    /* compiled from: CardViewApi17Impl.java */
    /* renamed from: androidx.cardview.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0017a implements g.a {
        C0017a() {
        }

        @Override // androidx.cardview.widget.g.a
        public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
            canvas.drawRoundRect(rectF, f2, f2, paint);
        }
    }

    @Override // androidx.cardview.widget.c, androidx.cardview.widget.e
    public void j() {
        g.f1027b = new C0017a();
    }
}