package c.a.l.a;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import c.a.l.a.b;

/* compiled from: StateListDrawable.java */
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
class d extends b {
    private a n;
    private boolean p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StateListDrawable.java */
    /* loaded from: classes.dex */
    public static class a extends b.c {
        int[][] J;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(a aVar, d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[f()];
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int A(int[] iArr) {
            int[][] iArr2 = this.J;
            int h2 = h();
            for (int i2 = 0; i2 < h2; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new d(this, null);
        }

        @Override // c.a.l.a.b.c
        public void o(int i2, int i3) {
            super.o(i2, i3);
            int[][] iArr = new int[i3];
            System.arraycopy(this.J, 0, iArr, 0, i2);
            this.J = iArr;
        }

        @Override // c.a.l.a.b.c
        void r() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int z(int[] iArr, Drawable drawable) {
            int a = a(drawable);
            this.J[a] = iArr;
            return a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    d(a aVar, Resources resources) {
        h(new a(aVar, this, resources));
        onStateChange(getState());
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.a.l.a.b
    public void h(b.c cVar) {
        super.h(cVar);
        if (cVar instanceof a) {
            this.n = (a) cVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.a.l.a.b
    /* renamed from: j */
    public a b() {
        return new a(this.n, this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] k(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i2 = 0;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i3);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i4 = i2 + 1;
                if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i2] = attributeNameResource;
                i2 = i4;
            }
        }
        return StateSet.trimStateSet(iArr, i2);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.p && super.mutate() == this) {
            this.n.r();
            this.p = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int A = this.n.A(iArr);
        if (A < 0) {
            A = this.n.A(StateSet.WILD_CARD);
        }
        return g(A) || onStateChange;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        if (aVar != null) {
            h(aVar);
        }
    }
}