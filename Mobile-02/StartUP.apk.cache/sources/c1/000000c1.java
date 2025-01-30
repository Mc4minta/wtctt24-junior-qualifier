package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.d0;

/* loaded from: classes.dex */
public class ActionMenuView extends d0 implements g.b, androidx.appcompat.view.menu.n {
    private boolean A;
    private int B;
    private int C;
    private int D;
    e E;
    private androidx.appcompat.view.menu.g t;
    private Context u;
    private int v;
    private boolean w;
    private androidx.appcompat.widget.c x;
    private m.a y;
    g.a z;

    /* loaded from: classes.dex */
    public interface a {
        boolean a();

        boolean b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements m.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d0.a {
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public boolean f674c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public int f675d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public int f676e;
        @ViewDebug.ExportedProperty

        /* renamed from: f  reason: collision with root package name */
        public boolean f677f;
        @ViewDebug.ExportedProperty

        /* renamed from: g  reason: collision with root package name */
        public boolean f678g;

        /* renamed from: h  reason: collision with root package name */
        boolean f679h;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f674c = cVar.f674c;
        }

        public c(int i2, int i3) {
            super(i2, i3);
            this.f674c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.E;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            g.a aVar = ActionMenuView.this.z;
            if (aVar != null) {
                aVar.b(gVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int L(View view, int i2, int i3, int i4, int i5) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4) - i5, View.MeasureSpec.getMode(i4));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.h();
        int i6 = 2;
        if (i3 <= 0 || (z2 && i3 < 2)) {
            i6 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i7 = measuredWidth / i2;
            if (measuredWidth % i2 != 0) {
                i7++;
            }
            if (!z2 || i7 >= 2) {
                i6 = i7;
            }
        }
        if (cVar.f674c || !z2) {
            z = false;
        }
        cVar.f677f = z;
        cVar.f675d = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i6, 1073741824), makeMeasureSpec);
        return i6;
    }

    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r14v14 */
    private void M(int i2, int i3) {
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        boolean z2;
        boolean z3;
        int i8;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
        int i9 = size - paddingLeft;
        int i10 = this.C;
        int i11 = i9 / i10;
        int i12 = i9 % i10;
        if (i11 == 0) {
            setMeasuredDimension(i9, 0);
            return;
        }
        int i13 = i10 + (i12 / i11);
        int childCount = getChildCount();
        int i14 = 0;
        int i15 = 0;
        boolean z4 = false;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        long j2 = 0;
        while (i15 < childCount) {
            View childAt = getChildAt(i15);
            int i19 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z5 = childAt instanceof ActionMenuItemView;
                int i20 = i16 + 1;
                if (z5) {
                    int i21 = this.D;
                    i8 = i20;
                    r14 = 0;
                    childAt.setPadding(i21, 0, i21, 0);
                } else {
                    i8 = i20;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f679h = r14;
                cVar.f676e = r14;
                cVar.f675d = r14;
                cVar.f677f = r14;
                ((ViewGroup.MarginLayoutParams) cVar).leftMargin = r14;
                ((ViewGroup.MarginLayoutParams) cVar).rightMargin = r14;
                cVar.f678g = z5 && ((ActionMenuItemView) childAt).h();
                int L = L(childAt, i13, cVar.f674c ? 1 : i11, childMeasureSpec, paddingTop);
                i17 = Math.max(i17, L);
                if (cVar.f677f) {
                    i18++;
                }
                if (cVar.f674c) {
                    z4 = true;
                }
                i11 -= L;
                i14 = Math.max(i14, childAt.getMeasuredHeight());
                if (L == 1) {
                    j2 |= 1 << i15;
                    i14 = i14;
                }
                i16 = i8;
            }
            i15++;
            size2 = i19;
        }
        int i22 = size2;
        boolean z6 = z4 && i16 == 2;
        boolean z7 = false;
        while (i18 > 0 && i11 > 0) {
            int i23 = Integer.MAX_VALUE;
            int i24 = 0;
            int i25 = 0;
            long j3 = 0;
            while (i25 < childCount) {
                boolean z8 = z7;
                c cVar2 = (c) getChildAt(i25).getLayoutParams();
                int i26 = i14;
                if (cVar2.f677f) {
                    int i27 = cVar2.f675d;
                    if (i27 < i23) {
                        j3 = 1 << i25;
                        i23 = i27;
                        i24 = 1;
                    } else if (i27 == i23) {
                        i24++;
                        j3 |= 1 << i25;
                    }
                }
                i25++;
                i14 = i26;
                z7 = z8;
            }
            z = z7;
            i6 = i14;
            j2 |= j3;
            if (i24 > i11) {
                i4 = mode;
                i5 = i9;
                break;
            }
            int i28 = i23 + 1;
            int i29 = 0;
            while (i29 < childCount) {
                View childAt2 = getChildAt(i29);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i30 = i9;
                int i31 = mode;
                long j4 = 1 << i29;
                if ((j3 & j4) == 0) {
                    if (cVar3.f675d == i28) {
                        j2 |= j4;
                    }
                    z3 = z6;
                } else {
                    if (z6 && cVar3.f678g && i11 == 1) {
                        int i32 = this.D;
                        z3 = z6;
                        childAt2.setPadding(i32 + i13, 0, i32, 0);
                    } else {
                        z3 = z6;
                    }
                    cVar3.f675d++;
                    cVar3.f679h = true;
                    i11--;
                }
                i29++;
                mode = i31;
                i9 = i30;
                z6 = z3;
            }
            i14 = i6;
            z7 = true;
        }
        i4 = mode;
        i5 = i9;
        z = z7;
        i6 = i14;
        boolean z9 = !z4 && i16 == 1;
        if (i11 <= 0 || j2 == 0 || (i11 >= i16 - 1 && !z9 && i17 <= 1)) {
            i7 = 0;
            z2 = z;
        } else {
            float bitCount = Long.bitCount(j2);
            if (z9) {
                i7 = 0;
            } else {
                i7 = 0;
                if ((j2 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f678g) {
                    bitCount -= 0.5f;
                }
                int i33 = childCount - 1;
                if ((j2 & (1 << i33)) != 0 && !((c) getChildAt(i33).getLayoutParams()).f678g) {
                    bitCount -= 0.5f;
                }
            }
            int i34 = bitCount > 0.0f ? (int) ((i11 * i13) / bitCount) : i7;
            z2 = z;
            for (int i35 = i7; i35 < childCount; i35++) {
                if ((j2 & (1 << i35)) != 0) {
                    View childAt3 = getChildAt(i35);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f676e = i34;
                        cVar4.f679h = true;
                        if (i35 == 0 && !cVar4.f678g) {
                            ((ViewGroup.MarginLayoutParams) cVar4).leftMargin = (-i34) / 2;
                        }
                        z2 = true;
                    } else if (cVar4.f674c) {
                        cVar4.f676e = i34;
                        cVar4.f679h = true;
                        ((ViewGroup.MarginLayoutParams) cVar4).rightMargin = (-i34) / 2;
                        z2 = true;
                    } else {
                        if (i35 != 0) {
                            ((ViewGroup.MarginLayoutParams) cVar4).leftMargin = i34 / 2;
                        }
                        if (i35 != childCount - 1) {
                            ((ViewGroup.MarginLayoutParams) cVar4).rightMargin = i34 / 2;
                        }
                    }
                }
            }
        }
        if (z2) {
            for (int i36 = i7; i36 < childCount; i36++) {
                View childAt4 = getChildAt(i36);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f679h) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f675d * i13) + cVar5.f676e, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i5, i4 != 1073741824 ? i6 : i22);
    }

    public void B() {
        androidx.appcompat.widget.c cVar = this.x;
        if (cVar != null) {
            cVar.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.d0
    /* renamed from: C */
    public c m() {
        c cVar = new c(-2, -2);
        cVar.f782b = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.d0
    /* renamed from: D */
    public c n(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.d0
    /* renamed from: E */
    public c o(ViewGroup.LayoutParams layoutParams) {
        c cVar;
        if (layoutParams != null) {
            if (layoutParams instanceof c) {
                cVar = new c((c) layoutParams);
            } else {
                cVar = new c(layoutParams);
            }
            if (cVar.f782b <= 0) {
                cVar.f782b = 16;
            }
            return cVar;
        }
        return m();
    }

    public c F() {
        c m = m();
        m.f674c = true;
        return m;
    }

    protected boolean G(int i2) {
        boolean z = false;
        if (i2 == 0) {
            return false;
        }
        View childAt = getChildAt(i2 - 1);
        View childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof a)) {
            z = false | ((a) childAt).a();
        }
        return (i2 <= 0 || !(childAt2 instanceof a)) ? z : z | ((a) childAt2).b();
    }

    public boolean H() {
        androidx.appcompat.widget.c cVar = this.x;
        return cVar != null && cVar.D();
    }

    public boolean I() {
        androidx.appcompat.widget.c cVar = this.x;
        return cVar != null && cVar.F();
    }

    public boolean J() {
        androidx.appcompat.widget.c cVar = this.x;
        return cVar != null && cVar.G();
    }

    public boolean K() {
        return this.w;
    }

    public androidx.appcompat.view.menu.g N() {
        return this.t;
    }

    public void O(m.a aVar, g.a aVar2) {
        this.y = aVar;
        this.z = aVar2;
    }

    public boolean P() {
        androidx.appcompat.widget.c cVar = this.x;
        return cVar != null && cVar.M();
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean a(androidx.appcompat.view.menu.i iVar) {
        return this.t.N(iVar, 0);
    }

    @Override // androidx.appcompat.view.menu.n
    public void b(androidx.appcompat.view.menu.g gVar) {
        this.t = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.d0, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.t == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
            this.t = gVar;
            gVar.V(new d());
            androidx.appcompat.widget.c cVar = new androidx.appcompat.widget.c(context);
            this.x = cVar;
            cVar.L(true);
            androidx.appcompat.widget.c cVar2 = this.x;
            m.a aVar = this.y;
            if (aVar == null) {
                aVar = new b();
            }
            cVar2.g(aVar);
            this.t.c(this.x, this.u);
            this.x.J(this);
        }
        return this.t;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.x.C();
    }

    public int getPopupTheme() {
        return this.v;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.widget.c cVar = this.x;
        if (cVar != null) {
            cVar.c(false);
            if (this.x.G()) {
                this.x.D();
                this.x.M();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.d0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int width;
        int i6;
        if (!this.A) {
            super.onLayout(z, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i4 - i2;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean b2 = y0.b(this);
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f674c) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (G(i11)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b2) {
                        i6 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
                        width = i6 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                        i6 = width - measuredWidth;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(i6, i12, width, measuredHeight + i12);
                    paddingRight -= measuredWidth;
                    i9 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin) + ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                    G(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth2 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        int max = Math.max(0, i15 > 0 ? paddingRight / i15 : 0);
        if (b2) {
            int width2 = getWidth() - getPaddingRight();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt3 = getChildAt(i16);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f674c) {
                    int i17 = width2 - ((ViewGroup.MarginLayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i18 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i17 - measuredWidth3, i18, i17, measuredHeight3 + i18);
                    width2 = i17 - ((measuredWidth3 + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt4 = getChildAt(i19);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f674c) {
                int i20 = paddingLeft + ((ViewGroup.MarginLayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft = i20 + measuredWidth4 + ((ViewGroup.MarginLayoutParams) cVar3).rightMargin + max;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.d0, android.view.View
    public void onMeasure(int i2, int i3) {
        androidx.appcompat.view.menu.g gVar;
        boolean z = this.A;
        boolean z2 = View.MeasureSpec.getMode(i2) == 1073741824;
        this.A = z2;
        if (z != z2) {
            this.B = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (this.A && (gVar = this.t) != null && size != this.B) {
            this.B = size;
            gVar.M(true);
        }
        int childCount = getChildCount();
        if (this.A && childCount > 0) {
            M(i2, i3);
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            c cVar = (c) getChildAt(i4).getLayoutParams();
            ((ViewGroup.MarginLayoutParams) cVar).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i2, i3);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.x.I(z);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.E = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.x.K(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.w = z;
    }

    public void setPopupTheme(int i2) {
        if (this.v != i2) {
            this.v = i2;
            if (i2 == 0) {
                this.u = getContext();
            } else {
                this.u = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setPresenter(androidx.appcompat.widget.c cVar) {
        this.x = cVar;
        cVar.J(this);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.C = (int) (56.0f * f2);
        this.D = (int) (f2 * 4.0f);
        this.u = context;
        this.v = 0;
    }
}