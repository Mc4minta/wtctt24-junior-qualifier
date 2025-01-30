package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: MotionHelper.java */
/* loaded from: classes.dex */
public class o extends androidx.constraintlayout.widget.b implements MotionLayout.i {

    /* renamed from: j  reason: collision with root package name */
    private boolean f1161j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1162k;

    /* renamed from: l  reason: collision with root package name */
    private float f1163l;
    protected View[] m;

    public float getProgress() {
        return this.f1163l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.b
    public void i(AttributeSet attributeSet) {
        super.i(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.i.o6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == androidx.constraintlayout.widget.i.q6) {
                    this.f1161j = obtainStyledAttributes.getBoolean(index, this.f1161j);
                } else if (index == androidx.constraintlayout.widget.i.p6) {
                    this.f1162k = obtainStyledAttributes.getBoolean(index, this.f1162k);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    public void onTransitionChange(MotionLayout motionLayout, int i2, int i3, float f2) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    public void onTransitionCompleted(MotionLayout motionLayout, int i2) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    public void onTransitionStarted(MotionLayout motionLayout, int i2, int i3) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    public void onTransitionTrigger(MotionLayout motionLayout, int i2, boolean z, float f2) {
    }

    public boolean r() {
        return this.f1162k;
    }

    public boolean s() {
        return this.f1161j;
    }

    public void setProgress(float f2) {
        this.f1163l = f2;
        int i2 = 0;
        if (this.f1264b > 0) {
            this.m = h((ConstraintLayout) getParent());
            while (i2 < this.f1264b) {
                t(this.m[i2], f2);
                i2++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i2 < childCount) {
            View childAt = viewGroup.getChildAt(i2);
            if (!(childAt instanceof o)) {
                t(childAt, f2);
            }
            i2++;
        }
    }

    public void t(View view, float f2) {
    }
}