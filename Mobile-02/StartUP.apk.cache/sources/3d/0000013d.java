package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* compiled from: AppCompatSeekBar.java */
/* loaded from: classes.dex */
public class q extends SeekBar {
    private final r a;

    public q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.J);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.a.i();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.g(canvas);
    }

    public q(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        n0.a(this, getContext());
        r rVar = new r(this);
        this.a = rVar;
        rVar.c(attributeSet, i2);
    }
}