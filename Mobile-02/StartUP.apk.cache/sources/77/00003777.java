package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.core.util.f;
import c.h.k.v;
import c.s.a0;
import c.s.c0;

/* compiled from: BottomNavigationMenuView.java */
/* loaded from: classes2.dex */
public class c extends ViewGroup implements n {
    private static final int[] a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f8105b = {-16842910};
    private int A;
    private int[] B;
    private d C;
    private g D;

    /* renamed from: c  reason: collision with root package name */
    private final c0 f8106c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8107d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8108e;

    /* renamed from: f  reason: collision with root package name */
    private final int f8109f;

    /* renamed from: g  reason: collision with root package name */
    private final int f8110g;

    /* renamed from: h  reason: collision with root package name */
    private final int f8111h;

    /* renamed from: j  reason: collision with root package name */
    private final View.OnClickListener f8112j;

    /* renamed from: k  reason: collision with root package name */
    private final f<com.google.android.material.bottomnavigation.a> f8113k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8114l;
    private int m;
    private com.google.android.material.bottomnavigation.a[] n;
    private int p;
    private int q;
    private ColorStateList t;
    private int u;
    private ColorStateList v;
    private final ColorStateList w;
    private int x;
    private int y;
    private Drawable z;

    /* compiled from: BottomNavigationMenuView.java */
    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i itemData = ((com.google.android.material.bottomnavigation.a) view).getItemData();
            if (c.this.D.O(itemData, c.this.C, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public c(Context context) {
        this(context, null);
    }

    private boolean g(int i2, int i3) {
        if (i2 == -1) {
            if (i3 > 3) {
                return true;
            }
        } else if (i2 == 0) {
            return true;
        }
        return false;
    }

    private com.google.android.material.bottomnavigation.a getNewItem() {
        com.google.android.material.bottomnavigation.a acquire = this.f8113k.acquire();
        return acquire == null ? new com.google.android.material.bottomnavigation.a(getContext()) : acquire;
    }

    @Override // androidx.appcompat.view.menu.n
    public void b(g gVar) {
        this.D = gVar;
    }

    public void d() {
        removeAllViews();
        com.google.android.material.bottomnavigation.a[] aVarArr = this.n;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                if (aVar != null) {
                    this.f8113k.release(aVar);
                }
            }
        }
        if (this.D.size() == 0) {
            this.p = 0;
            this.q = 0;
            this.n = null;
            return;
        }
        this.n = new com.google.android.material.bottomnavigation.a[this.D.size()];
        boolean g2 = g(this.m, this.D.G().size());
        for (int i2 = 0; i2 < this.D.size(); i2++) {
            this.C.k(true);
            this.D.getItem(i2).setCheckable(true);
            this.C.k(false);
            com.google.android.material.bottomnavigation.a newItem = getNewItem();
            this.n[i2] = newItem;
            newItem.setIconTintList(this.t);
            newItem.setIconSize(this.u);
            newItem.setTextColor(this.w);
            newItem.setTextAppearanceInactive(this.x);
            newItem.setTextAppearanceActive(this.y);
            newItem.setTextColor(this.v);
            Drawable drawable = this.z;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.A);
            }
            newItem.setShifting(g2);
            newItem.setLabelVisibilityMode(this.m);
            newItem.f((i) this.D.getItem(i2), 0);
            newItem.setItemPosition(i2);
            newItem.setOnClickListener(this.f8112j);
            addView(newItem);
        }
        int min = Math.min(this.D.size() - 1, this.q);
        this.q = min;
        this.D.getItem(min).setChecked(true);
    }

    public ColorStateList e(int i2) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            ColorStateList c2 = c.a.k.a.a.c(getContext(), typedValue.resourceId);
            if (getContext().getTheme().resolveAttribute(c.a.a.x, typedValue, true)) {
                int i3 = typedValue.data;
                int defaultColor = c2.getDefaultColor();
                int[] iArr = f8105b;
                return new ColorStateList(new int[][]{iArr, a, ViewGroup.EMPTY_STATE_SET}, new int[]{c2.getColorForState(iArr, defaultColor), i3, defaultColor});
            }
            return null;
        }
        return null;
    }

    public boolean f() {
        return this.f8114l;
    }

    public ColorStateList getIconTintList() {
        return this.t;
    }

    public Drawable getItemBackground() {
        com.google.android.material.bottomnavigation.a[] aVarArr = this.n;
        if (aVarArr != null && aVarArr.length > 0) {
            return aVarArr[0].getBackground();
        }
        return this.z;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.A;
    }

    public int getItemIconSize() {
        return this.u;
    }

    public int getItemTextAppearanceActive() {
        return this.y;
    }

    public int getItemTextAppearanceInactive() {
        return this.x;
    }

    public ColorStateList getItemTextColor() {
        return this.v;
    }

    public int getLabelVisibilityMode() {
        return this.m;
    }

    public int getSelectedItemId() {
        return this.p;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i2) {
        int size = this.D.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.D.getItem(i3);
            if (i2 == item.getItemId()) {
                this.p = i2;
                this.q = i3;
                item.setChecked(true);
                return;
            }
        }
    }

    public void i() {
        g gVar = this.D;
        if (gVar == null || this.n == null) {
            return;
        }
        int size = gVar.size();
        if (size != this.n.length) {
            d();
            return;
        }
        int i2 = this.p;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.D.getItem(i3);
            if (item.isChecked()) {
                this.p = item.getItemId();
                this.q = i3;
            }
        }
        if (i2 != this.p) {
            a0.b(this, this.f8106c);
        }
        boolean g2 = g(this.m, this.D.G().size());
        for (int i4 = 0; i4 < size; i4++) {
            this.C.k(true);
            this.n[i4].setLabelVisibilityMode(this.m);
            this.n[i4].setShifting(g2);
            this.n[i4].f((i) this.D.getItem(i4), 0);
            this.C.k(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (v.y(this) == 1) {
                    int i10 = i6 - i8;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.D.G().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f8111h, 1073741824);
        if (g(this.m, size2) && this.f8114l) {
            View childAt = getChildAt(this.q);
            int i4 = this.f8110g;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f8109f, Integer.MIN_VALUE), makeMeasureSpec);
                i4 = Math.max(i4, childAt.getMeasuredWidth());
            }
            int i5 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = Math.min(size - (this.f8108e * i5), Math.min(i4, this.f8109f));
            int i6 = size - min;
            int min2 = Math.min(i6 / (i5 == 0 ? 1 : i5), this.f8107d);
            int i7 = i6 - (i5 * min2);
            int i8 = 0;
            while (i8 < childCount) {
                if (getChildAt(i8).getVisibility() != 8) {
                    int[] iArr = this.B;
                    iArr[i8] = i8 == this.q ? min : min2;
                    if (i7 > 0) {
                        iArr[i8] = iArr[i8] + 1;
                        i7--;
                    }
                } else {
                    this.B[i8] = 0;
                }
                i8++;
            }
        } else {
            int min3 = Math.min(size / (size2 == 0 ? 1 : size2), this.f8109f);
            int i9 = size - (size2 * min3);
            for (int i10 = 0; i10 < childCount; i10++) {
                if (getChildAt(i10).getVisibility() != 8) {
                    int[] iArr2 = this.B;
                    iArr2[i10] = min3;
                    if (i9 > 0) {
                        iArr2[i10] = iArr2[i10] + 1;
                        i9--;
                    }
                } else {
                    this.B[i10] = 0;
                }
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.B[i12], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i11 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i11, View.MeasureSpec.makeMeasureSpec(i11, 1073741824), 0), View.resolveSizeAndState(this.f8111h, makeMeasureSpec, 0));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        com.google.android.material.bottomnavigation.a[] aVarArr = this.n;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                aVar.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.z = drawable;
        com.google.android.material.bottomnavigation.a[] aVarArr = this.n;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                aVar.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.A = i2;
        com.google.android.material.bottomnavigation.a[] aVarArr = this.n;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                aVar.setItemBackground(i2);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.f8114l = z;
    }

    public void setItemIconSize(int i2) {
        this.u = i2;
        com.google.android.material.bottomnavigation.a[] aVarArr = this.n;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                aVar.setIconSize(i2);
            }
        }
    }

    public void setItemTextAppearanceActive(int i2) {
        this.y = i2;
        com.google.android.material.bottomnavigation.a[] aVarArr = this.n;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                aVar.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.v;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.x = i2;
        com.google.android.material.bottomnavigation.a[] aVarArr = this.n;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                aVar.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.v;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.v = colorStateList;
        com.google.android.material.bottomnavigation.a[] aVarArr = this.n;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                aVar.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.m = i2;
    }

    public void setPresenter(d dVar) {
        this.C = dVar;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8113k = new androidx.core.util.g(5);
        this.p = 0;
        this.q = 0;
        Resources resources = getResources();
        this.f8107d = resources.getDimensionPixelSize(e.g.a.f.d.f13245e);
        this.f8108e = resources.getDimensionPixelSize(e.g.a.f.d.f13246f);
        this.f8109f = resources.getDimensionPixelSize(e.g.a.f.d.a);
        this.f8110g = resources.getDimensionPixelSize(e.g.a.f.d.f13242b);
        this.f8111h = resources.getDimensionPixelSize(e.g.a.f.d.f13243c);
        this.w = e(16842808);
        c.s.b bVar = new c.s.b();
        this.f8106c = bVar;
        bVar.u(0);
        bVar.setDuration(115L);
        bVar.setInterpolator(new c.m.a.a.b());
        bVar.h(new com.google.android.material.internal.g());
        this.f8112j = new a();
        this.B = new int[5];
    }
}