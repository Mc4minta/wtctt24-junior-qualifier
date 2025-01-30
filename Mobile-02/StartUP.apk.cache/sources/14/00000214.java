package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import c.f.b.k.l;

/* compiled from: VirtualLayout.java */
/* loaded from: classes.dex */
public abstract class k extends b {

    /* renamed from: j  reason: collision with root package name */
    private boolean f1353j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1354k;

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.b
    public void i(AttributeSet attributeSet) {
        super.i(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.h1) {
                    this.f1353j = true;
                } else if (index == i.o1) {
                    this.f1354k = true;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.b, android.view.View
    public void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.f1353j || this.f1354k) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i2 = 0; i2 < this.f1264b; i2++) {
                View viewById = constraintLayout.getViewById(this.a[i2]);
                if (viewById != null) {
                    if (this.f1353j) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.f1354k && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public void r(l lVar, int i2, int i3) {
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        c();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        c();
    }
}