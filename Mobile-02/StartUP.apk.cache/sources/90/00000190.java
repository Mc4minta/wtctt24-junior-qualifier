package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {16842801};
    private static final e IMPL;
    private final d mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    /* loaded from: classes.dex */
    class a implements d {
        private Drawable a;

        a() {
        }

        @Override // androidx.cardview.widget.d
        public void a(int i2, int i3, int i4, int i5) {
            CardView.this.mShadowBounds.set(i2, i3, i4, i5);
            CardView cardView = CardView.this;
            Rect rect = cardView.mContentPadding;
            CardView.super.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
        }

        @Override // androidx.cardview.widget.d
        public void b(int i2, int i3) {
            CardView cardView = CardView.this;
            if (i2 > cardView.mUserSetMinWidth) {
                CardView.super.setMinimumWidth(i2);
            }
            CardView cardView2 = CardView.this;
            if (i3 > cardView2.mUserSetMinHeight) {
                CardView.super.setMinimumHeight(i3);
            }
        }

        @Override // androidx.cardview.widget.d
        public void c(Drawable drawable) {
            this.a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.d
        public boolean d() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // androidx.cardview.widget.d
        public boolean e() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.d
        public Drawable f() {
            return this.a;
        }

        @Override // androidx.cardview.widget.d
        public View g() {
            return CardView.this;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            IMPL = new b();
        } else if (i2 >= 17) {
            IMPL = new androidx.cardview.widget.a();
        } else {
            IMPL = new c();
        }
        IMPL.j();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.h(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.c(this.mCardViewDelegate);
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.g(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return IMPL.d(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        e eVar = IMPL;
        if (!(eVar instanceof b)) {
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(eVar.l(this.mCardViewDelegate)), View.MeasureSpec.getSize(i2)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(eVar.k(this.mCardViewDelegate)), View.MeasureSpec.getSize(i3)), mode2);
            }
            super.onMeasure(i2, i3);
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        IMPL.n(this.mCardViewDelegate, ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f2) {
        IMPL.f(this.mCardViewDelegate, f2);
    }

    public void setContentPadding(int i2, int i3, int i4, int i5) {
        this.mContentPadding.set(i2, i3, i4, i5);
        IMPL.i(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f2) {
        IMPL.o(this.mCardViewDelegate, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        this.mUserSetMinHeight = i2;
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        this.mUserSetMinWidth = i2;
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            IMPL.m(this.mCardViewDelegate);
        }
    }

    public void setRadius(float f2) {
        IMPL.b(this.mCardViewDelegate, f2);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            IMPL.e(this.mCardViewDelegate);
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.d.a.a);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        IMPL.n(this.mCardViewDelegate, colorStateList);
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int color;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.mContentPadding = rect;
        this.mShadowBounds = new Rect();
        a aVar = new a();
        this.mCardViewDelegate = aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.d.e.a, i2, c.d.d.a);
        int i3 = c.d.e.f2616d;
        if (obtainStyledAttributes.hasValue(i3)) {
            valueOf = obtainStyledAttributes.getColorStateList(i3);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(c.d.b.f2611b);
            } else {
                color = getResources().getColor(c.d.b.a);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(c.d.e.f2617e, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(c.d.e.f2618f, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(c.d.e.f2619g, 0.0f);
        this.mCompatPadding = obtainStyledAttributes.getBoolean(c.d.e.f2621i, false);
        this.mPreventCornerOverlap = obtainStyledAttributes.getBoolean(c.d.e.f2620h, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(c.d.e.f2622j, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(c.d.e.f2624l, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(c.d.e.n, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(c.d.e.m, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(c.d.e.f2623k, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = obtainStyledAttributes.getDimensionPixelSize(c.d.e.f2614b, 0);
        this.mUserSetMinHeight = obtainStyledAttributes.getDimensionPixelSize(c.d.e.f2615c, 0);
        obtainStyledAttributes.recycle();
        IMPL.a(aVar, context, colorStateList, dimension, dimension2, f2);
    }
}