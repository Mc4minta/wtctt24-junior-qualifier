package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;

/* loaded from: classes.dex */
public class Barrier extends b {

    /* renamed from: j  reason: collision with root package name */
    private int f1230j;

    /* renamed from: k  reason: collision with root package name */
    private int f1231k;

    /* renamed from: l  reason: collision with root package name */
    private c.f.b.k.a f1232l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void s(c.f.b.k.e eVar, int i2, boolean z) {
        this.f1231k = i2;
        if (Build.VERSION.SDK_INT < 17) {
            int i3 = this.f1230j;
            if (i3 == 5) {
                this.f1231k = 0;
            } else if (i3 == 6) {
                this.f1231k = 1;
            }
        } else if (z) {
            int i4 = this.f1230j;
            if (i4 == 5) {
                this.f1231k = 1;
            } else if (i4 == 6) {
                this.f1231k = 0;
            }
        } else {
            int i5 = this.f1230j;
            if (i5 == 5) {
                this.f1231k = 0;
            } else if (i5 == 6) {
                this.f1231k = 1;
            }
        }
        if (eVar instanceof c.f.b.k.a) {
            ((c.f.b.k.a) eVar).Q0(this.f1231k);
        }
    }

    public int getMargin() {
        return this.f1232l.N0();
    }

    public int getType() {
        return this.f1230j;
    }

    @Override // androidx.constraintlayout.widget.b
    protected void i(AttributeSet attributeSet) {
        super.i(attributeSet);
        this.f1232l = new c.f.b.k.a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.a1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.q1) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == i.p1) {
                    this.f1232l.P0(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == i.r1) {
                    this.f1232l.R0(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
        }
        this.f1266d = this.f1232l;
        q();
    }

    @Override // androidx.constraintlayout.widget.b
    public void j(d.a aVar, c.f.b.k.j jVar, ConstraintLayout.b bVar, SparseArray<c.f.b.k.e> sparseArray) {
        super.j(aVar, jVar, bVar, sparseArray);
        if (jVar instanceof c.f.b.k.a) {
            c.f.b.k.a aVar2 = (c.f.b.k.a) jVar;
            s(aVar2, aVar.f1292d.c0, ((c.f.b.k.f) jVar.H()).d1());
            aVar2.P0(aVar.f1292d.k0);
            aVar2.R0(aVar.f1292d.d0);
        }
    }

    @Override // androidx.constraintlayout.widget.b
    public void k(c.f.b.k.e eVar, boolean z) {
        s(eVar, this.f1230j, z);
    }

    public boolean r() {
        return this.f1232l.L0();
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f1232l.P0(z);
    }

    public void setDpMargin(int i2) {
        c.f.b.k.a aVar = this.f1232l;
        aVar.R0((int) ((i2 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i2) {
        this.f1232l.R0(i2);
    }

    public void setType(int i2) {
        this.f1230j = i2;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}