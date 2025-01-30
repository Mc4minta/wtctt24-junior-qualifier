package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;
import androidx.constraintlayout.widget.i;
import c.f.b.k.e;

/* loaded from: classes.dex */
public class Layer extends b {
    private float A;
    private float B;
    private boolean C;
    private boolean D;

    /* renamed from: j  reason: collision with root package name */
    private float f1039j;

    /* renamed from: k  reason: collision with root package name */
    private float f1040k;

    /* renamed from: l  reason: collision with root package name */
    private float f1041l;
    ConstraintLayout m;
    private float n;
    private float p;
    protected float q;
    protected float t;
    protected float u;
    protected float v;
    protected float w;
    protected float x;
    boolean y;
    View[] z;

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1039j = Float.NaN;
        this.f1040k = Float.NaN;
        this.f1041l = Float.NaN;
        this.n = 1.0f;
        this.p = 1.0f;
        this.q = Float.NaN;
        this.t = Float.NaN;
        this.u = Float.NaN;
        this.v = Float.NaN;
        this.w = Float.NaN;
        this.x = Float.NaN;
        this.y = true;
        this.z = null;
        this.A = 0.0f;
        this.B = 0.0f;
    }

    private void s() {
        int i2;
        if (this.m == null || (i2 = this.f1264b) == 0) {
            return;
        }
        View[] viewArr = this.z;
        if (viewArr == null || viewArr.length != i2) {
            this.z = new View[i2];
        }
        for (int i3 = 0; i3 < this.f1264b; i3++) {
            this.z[i3] = this.m.getViewById(this.a[i3]);
        }
    }

    private void t() {
        if (this.m == null) {
            return;
        }
        if (this.z == null) {
            s();
        }
        r();
        double radians = Math.toRadians(this.f1041l);
        float sin = (float) Math.sin(radians);
        float cos = (float) Math.cos(radians);
        float f2 = this.n;
        float f3 = f2 * cos;
        float f4 = this.p;
        float f5 = (-f4) * sin;
        float f6 = f2 * sin;
        float f7 = f4 * cos;
        for (int i2 = 0; i2 < this.f1264b; i2++) {
            View view = this.z[i2];
            float left = ((view.getLeft() + view.getRight()) / 2) - this.q;
            float top = ((view.getTop() + view.getBottom()) / 2) - this.t;
            view.setTranslationX((((f3 * left) + (f5 * top)) - left) + this.A);
            view.setTranslationY((((left * f6) + (f7 * top)) - top) + this.B);
            view.setScaleY(this.p);
            view.setScaleX(this.n);
            view.setRotation(this.f1041l);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.b
    public void i(AttributeSet attributeSet) {
        super.i(attributeSet);
        this.f1267e = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.h1) {
                    this.C = true;
                } else if (index == i.o1) {
                    this.D = true;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.b
    public void l(ConstraintLayout constraintLayout) {
        s();
        this.q = Float.NaN;
        this.t = Float.NaN;
        e b2 = ((ConstraintLayout.b) getLayoutParams()).b();
        b2.F0(0);
        b2.i0(0);
        r();
        layout(((int) this.w) - getPaddingLeft(), ((int) this.x) - getPaddingTop(), ((int) this.u) + getPaddingRight(), ((int) this.v) + getPaddingBottom());
        if (Float.isNaN(this.f1041l)) {
            return;
        }
        t();
    }

    @Override // androidx.constraintlayout.widget.b
    public void n(ConstraintLayout constraintLayout) {
        this.m = constraintLayout;
        float rotation = getRotation();
        if (rotation == 0.0f) {
            if (Float.isNaN(this.f1041l)) {
                return;
            }
            this.f1041l = rotation;
            return;
        }
        this.f1041l = rotation;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.b, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = (ConstraintLayout) getParent();
        if (this.C || this.D) {
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i2 = 0; i2 < this.f1264b; i2++) {
                View viewById = this.m.getViewById(this.a[i2]);
                if (viewById != null) {
                    if (this.C) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.D && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    protected void r() {
        if (this.m == null) {
            return;
        }
        if (this.y || Float.isNaN(this.q) || Float.isNaN(this.t)) {
            if (!Float.isNaN(this.f1039j) && !Float.isNaN(this.f1040k)) {
                this.t = this.f1040k;
                this.q = this.f1039j;
                return;
            }
            View[] h2 = h(this.m);
            int left = h2[0].getLeft();
            int top = h2[0].getTop();
            int right = h2[0].getRight();
            int bottom = h2[0].getBottom();
            for (int i2 = 0; i2 < this.f1264b; i2++) {
                View view = h2[i2];
                left = Math.min(left, view.getLeft());
                top = Math.min(top, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.u = right;
            this.v = bottom;
            this.w = left;
            this.x = top;
            if (Float.isNaN(this.f1039j)) {
                this.q = (left + right) / 2;
            } else {
                this.q = this.f1039j;
            }
            if (Float.isNaN(this.f1040k)) {
                this.t = (top + bottom) / 2;
            } else {
                this.t = this.f1040k;
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        c();
    }

    @Override // android.view.View
    public void setPivotX(float f2) {
        this.f1039j = f2;
        t();
    }

    @Override // android.view.View
    public void setPivotY(float f2) {
        this.f1040k = f2;
        t();
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        this.f1041l = f2;
        t();
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        this.n = f2;
        t();
    }

    @Override // android.view.View
    public void setScaleY(float f2) {
        this.p = f2;
        t();
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        this.A = f2;
        t();
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        this.B = f2;
        t();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        c();
    }
}