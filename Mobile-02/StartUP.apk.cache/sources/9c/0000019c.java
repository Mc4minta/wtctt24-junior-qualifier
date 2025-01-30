package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import androidx.constraintlayout.widget.i;
import androidx.constraintlayout.widget.k;
import c.f.b.k.e;
import c.f.b.k.g;
import c.f.b.k.j;
import c.f.b.k.l;

/* loaded from: classes.dex */
public class Flow extends k {

    /* renamed from: l  reason: collision with root package name */
    private g f1038l;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.k, androidx.constraintlayout.widget.b
    public void i(AttributeSet attributeSet) {
        super.i(attributeSet);
        this.f1038l = new g();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.b1) {
                    this.f1038l.T1(obtainStyledAttributes.getInt(index, 0));
                } else if (index == i.c1) {
                    this.f1038l.Z0(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.m1) {
                    this.f1038l.e1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.n1) {
                    this.f1038l.b1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.d1) {
                    this.f1038l.c1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.e1) {
                    this.f1038l.f1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.f1) {
                    this.f1038l.d1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.g1) {
                    this.f1038l.a1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.L1) {
                    this.f1038l.Y1(obtainStyledAttributes.getInt(index, 0));
                } else if (index == i.B1) {
                    this.f1038l.N1(obtainStyledAttributes.getInt(index, 0));
                } else if (index == i.K1) {
                    this.f1038l.X1(obtainStyledAttributes.getInt(index, 0));
                } else if (index == i.v1) {
                    this.f1038l.H1(obtainStyledAttributes.getInt(index, 0));
                } else if (index == i.D1) {
                    this.f1038l.P1(obtainStyledAttributes.getInt(index, 0));
                } else if (index == i.x1) {
                    this.f1038l.J1(obtainStyledAttributes.getInt(index, 0));
                } else if (index == i.F1) {
                    this.f1038l.R1(obtainStyledAttributes.getInt(index, 0));
                } else if (index == i.z1) {
                    this.f1038l.L1(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == i.u1) {
                    this.f1038l.G1(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == i.C1) {
                    this.f1038l.O1(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == i.w1) {
                    this.f1038l.I1(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == i.E1) {
                    this.f1038l.Q1(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == i.I1) {
                    this.f1038l.V1(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == i.y1) {
                    this.f1038l.K1(obtainStyledAttributes.getInt(index, 2));
                } else if (index == i.H1) {
                    this.f1038l.U1(obtainStyledAttributes.getInt(index, 2));
                } else if (index == i.A1) {
                    this.f1038l.M1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.J1) {
                    this.f1038l.W1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.G1) {
                    this.f1038l.S1(obtainStyledAttributes.getInt(index, -1));
                }
            }
        }
        this.f1266d = this.f1038l;
        q();
    }

    @Override // androidx.constraintlayout.widget.b
    public void j(d.a aVar, j jVar, ConstraintLayout.b bVar, SparseArray<e> sparseArray) {
        super.j(aVar, jVar, bVar, sparseArray);
        if (jVar instanceof g) {
            g gVar = (g) jVar;
            int i2 = bVar.S;
            if (i2 != -1) {
                gVar.T1(i2);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.b
    public void k(e eVar, boolean z) {
        this.f1038l.L0(z);
    }

    @Override // androidx.constraintlayout.widget.b, android.view.View
    @SuppressLint({"WrongCall"})
    protected void onMeasure(int i2, int i3) {
        r(this.f1038l, i2, i3);
    }

    @Override // androidx.constraintlayout.widget.k
    public void r(l lVar, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (lVar != null) {
            lVar.T0(mode, size, mode2, size2);
            setMeasuredDimension(lVar.O0(), lVar.N0());
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public void setFirstHorizontalBias(float f2) {
        this.f1038l.G1(f2);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i2) {
        this.f1038l.H1(i2);
        requestLayout();
    }

    public void setFirstVerticalBias(float f2) {
        this.f1038l.I1(f2);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i2) {
        this.f1038l.J1(i2);
        requestLayout();
    }

    public void setHorizontalAlign(int i2) {
        this.f1038l.K1(i2);
        requestLayout();
    }

    public void setHorizontalBias(float f2) {
        this.f1038l.L1(f2);
        requestLayout();
    }

    public void setHorizontalGap(int i2) {
        this.f1038l.M1(i2);
        requestLayout();
    }

    public void setHorizontalStyle(int i2) {
        this.f1038l.N1(i2);
        requestLayout();
    }

    public void setMaxElementsWrap(int i2) {
        this.f1038l.S1(i2);
        requestLayout();
    }

    public void setOrientation(int i2) {
        this.f1038l.T1(i2);
        requestLayout();
    }

    public void setPadding(int i2) {
        this.f1038l.Z0(i2);
        requestLayout();
    }

    public void setPaddingBottom(int i2) {
        this.f1038l.a1(i2);
        requestLayout();
    }

    public void setPaddingLeft(int i2) {
        this.f1038l.c1(i2);
        requestLayout();
    }

    public void setPaddingRight(int i2) {
        this.f1038l.d1(i2);
        requestLayout();
    }

    public void setPaddingTop(int i2) {
        this.f1038l.f1(i2);
        requestLayout();
    }

    public void setVerticalAlign(int i2) {
        this.f1038l.U1(i2);
        requestLayout();
    }

    public void setVerticalBias(float f2) {
        this.f1038l.V1(f2);
        requestLayout();
    }

    public void setVerticalGap(int i2) {
        this.f1038l.W1(i2);
        requestLayout();
    }

    public void setVerticalStyle(int i2) {
        this.f1038l.X1(i2);
        requestLayout();
    }

    public void setWrapMode(int i2) {
        this.f1038l.Y1(i2);
        requestLayout();
    }
}