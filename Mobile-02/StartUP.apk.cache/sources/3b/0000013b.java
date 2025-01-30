package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* compiled from: AppCompatRatingBar.java */
/* loaded from: classes.dex */
public class p extends RatingBar {
    private final n a;

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.H);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Bitmap b2 = this.a.b();
        if (b2 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b2.getWidth() * getNumStars(), i2, 0), getMeasuredHeight());
        }
    }

    public p(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        n0.a(this, getContext());
        n nVar = new n(this);
        this.a = nVar;
        nVar.c(attributeSet, i2);
    }
}