package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private int A;
    private CharSequence B;
    private CharSequence C;
    private ColorStateList D;
    private ColorStateList E;
    private boolean F;
    private boolean G;
    private final ArrayList<View> H;
    private final ArrayList<View> I;
    private final int[] J;
    f K;
    private final ActionMenuView.e L;
    private t0 M;
    private androidx.appcompat.widget.c N;
    private d O;
    private m.a P;
    private g.a Q;
    private boolean R;
    private final Runnable S;
    private ActionMenuView a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f719b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f720c;

    /* renamed from: d  reason: collision with root package name */
    private ImageButton f721d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f722e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f723f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f724g;

    /* renamed from: h  reason: collision with root package name */
    ImageButton f725h;

    /* renamed from: j  reason: collision with root package name */
    View f726j;

    /* renamed from: k  reason: collision with root package name */
    private Context f727k;

    /* renamed from: l  reason: collision with root package name */
    private int f728l;
    private int m;
    private int n;
    int p;
    private int q;
    private int t;
    private int u;
    private int v;
    private int w;
    private k0 x;
    private int y;
    private int z;

    /* loaded from: classes.dex */
    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            f fVar = Toolbar.this.K;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements androidx.appcompat.view.menu.m {
        androidx.appcompat.view.menu.g a;

        /* renamed from: b  reason: collision with root package name */
        androidx.appcompat.view.menu.i f729b;

        d() {
        }

        @Override // androidx.appcompat.view.menu.m
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.m
        public void c(boolean z) {
            if (this.f729b != null) {
                androidx.appcompat.view.menu.g gVar = this.a;
                boolean z2 = false;
                if (gVar != null) {
                    int size = gVar.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (this.a.getItem(i2) == this.f729b) {
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                if (z2) {
                    return;
                }
                e(this.a, this.f729b);
            }
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean d() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean e(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
            View view = Toolbar.this.f726j;
            if (view instanceof c.a.o.c) {
                ((c.a.o.c) view).e();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f726j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f725h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f726j = null;
            toolbar3.a();
            this.f729b = null;
            Toolbar.this.requestLayout();
            iVar.r(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean f(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f725h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f725h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f725h);
            }
            Toolbar.this.f726j = iVar.getActionView();
            this.f729b = iVar;
            ViewParent parent2 = Toolbar.this.f726j.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f726j);
                }
                e generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.a = 8388611 | (toolbar4.p & 112);
                generateDefaultLayoutParams.f731b = 2;
                toolbar4.f726j.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f726j);
            }
            Toolbar.this.G();
            Toolbar.this.requestLayout();
            iVar.r(true);
            View view = Toolbar.this.f726j;
            if (view instanceof c.a.o.c) {
                ((c.a.o.c) view).c();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.m
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.m
        public void i(Context context, androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.i iVar;
            androidx.appcompat.view.menu.g gVar2 = this.a;
            if (gVar2 != null && (iVar = this.f729b) != null) {
                gVar2.f(iVar);
            }
            this.a = gVar;
        }

        @Override // androidx.appcompat.view.menu.m
        public void j(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean l(androidx.appcompat.view.menu.r rVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public Parcelable m() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    private int B(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int max = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int q = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, q, max + measuredWidth, view.getMeasuredHeight() + q);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
    }

    private int C(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int max = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int q = q(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, q, max, view.getMeasuredHeight() + q);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    private int D(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + max + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void E(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void F() {
        removeCallbacks(this.S);
        post(this.S);
    }

    private boolean M() {
        if (this.R) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (N(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean N(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i2) {
        boolean z = c.h.k.v.y(this) == 1;
        int childCount = getChildCount();
        int b2 = c.h.k.d.b(i2, c.h.k.v.y(this));
        list.clear();
        if (!z) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f731b == 0 && N(childAt) && p(eVar.a) == b2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f731b == 0 && N(childAt2) && p(eVar2.a) == b2) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z) {
        e eVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            eVar = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            eVar = generateLayoutParams(layoutParams);
        } else {
            eVar = (e) layoutParams;
        }
        eVar.f731b = 1;
        if (z && this.f726j != null) {
            view.setLayoutParams(eVar);
            this.I.add(view);
            return;
        }
        addView(view, eVar);
    }

    private MenuInflater getMenuInflater() {
        return new c.a.o.g(getContext());
    }

    private void h() {
        if (this.x == null) {
            this.x = new k0();
        }
    }

    private void i() {
        if (this.f722e == null) {
            this.f722e = new AppCompatImageView(getContext());
        }
    }

    private void j() {
        k();
        if (this.a.N() == null) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) this.a.getMenu();
            if (this.O == null) {
                this.O = new d();
            }
            this.a.setExpandedActionViewsExclusive(true);
            gVar.c(this.O, this.f727k);
        }
    }

    private void k() {
        if (this.a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.a = actionMenuView;
            actionMenuView.setPopupTheme(this.f728l);
            this.a.setOnMenuItemClickListener(this.L);
            this.a.O(this.P, this.Q);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = 8388613 | (this.p & 112);
            this.a.setLayoutParams(generateDefaultLayoutParams);
            c(this.a, false);
        }
    }

    private void l() {
        if (this.f721d == null) {
            this.f721d = new j(getContext(), null, c.a.a.N);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = 8388611 | (this.p & 112);
            this.f721d.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private int p(int i2) {
        int y = c.h.k.v.y(this);
        int b2 = c.h.k.d.b(i2, y) & 7;
        return (b2 == 1 || b2 == 3 || b2 == 5) ? b2 : y == 1 ? 5 : 3;
    }

    private int q(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int r = r(eVar.a);
        if (r != 48) {
            if (r != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i5 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                if (i4 < i5) {
                    i4 = i5;
                } else {
                    int i6 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
                    int i7 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                    if (i6 < i7) {
                        i4 = Math.max(0, i4 - (i7 - i6));
                    }
                }
                return paddingTop + i4;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i3;
        }
        return getPaddingTop() - i3;
    }

    private int r(int i2) {
        int i3 = i2 & 112;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.A & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return c.h.k.g.b(marginLayoutParams) + c.h.k.g.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            View view = list.get(i4);
            e eVar = (e) view.getLayoutParams();
            int i6 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - i2;
            int i7 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - i3;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i7);
            int max3 = Math.max(0, -i6);
            int max4 = Math.max(0, -i7);
            i5 += max + view.getMeasuredWidth() + max2;
            i4++;
            i3 = max4;
            i2 = max3;
        }
        return i5;
    }

    private boolean y(View view) {
        return view.getParent() == this || this.I.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.J();
    }

    void G() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((e) childAt.getLayoutParams()).f731b != 2 && childAt != this.a) {
                removeViewAt(childCount);
                this.I.add(childAt);
            }
        }
    }

    public void H(int i2, int i3) {
        h();
        this.x.g(i2, i3);
    }

    public void I(androidx.appcompat.view.menu.g gVar, androidx.appcompat.widget.c cVar) {
        if (gVar == null && this.a == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.g N = this.a.N();
        if (N == gVar) {
            return;
        }
        if (N != null) {
            N.Q(this.N);
            N.Q(this.O);
        }
        if (this.O == null) {
            this.O = new d();
        }
        cVar.I(true);
        if (gVar != null) {
            gVar.c(cVar, this.f727k);
            gVar.c(this.O, this.f727k);
        } else {
            cVar.i(this.f727k, null);
            this.O.i(this.f727k, null);
            cVar.c(true);
            this.O.c(true);
        }
        this.a.setPopupTheme(this.f728l);
        this.a.setPresenter(cVar);
        this.N = cVar;
    }

    public void J(m.a aVar, g.a aVar2) {
        this.P = aVar;
        this.Q = aVar2;
        ActionMenuView actionMenuView = this.a;
        if (actionMenuView != null) {
            actionMenuView.O(aVar, aVar2);
        }
    }

    public void K(Context context, int i2) {
        this.n = i2;
        TextView textView = this.f720c;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void L(Context context, int i2) {
        this.m = i2;
        TextView textView = this.f719b;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public boolean O() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.P();
    }

    void a() {
        for (int size = this.I.size() - 1; size >= 0; size--) {
            addView(this.I.get(size));
        }
        this.I.clear();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.a) != null && actionMenuView.K();
    }

    public void e() {
        d dVar = this.O;
        androidx.appcompat.view.menu.i iVar = dVar == null ? null : dVar.f729b;
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.a;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    void g() {
        if (this.f725h == null) {
            j jVar = new j(getContext(), null, c.a.a.N);
            this.f725h = jVar;
            jVar.setImageDrawable(this.f723f);
            this.f725h.setContentDescription(this.f724g);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = 8388611 | (this.p & 112);
            generateDefaultLayoutParams.f731b = 2;
            this.f725h.setLayoutParams(generateDefaultLayoutParams);
            this.f725h.setOnClickListener(new c());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f725h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f725h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        k0 k0Var = this.x;
        if (k0Var != null) {
            return k0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.z;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        k0 k0Var = this.x;
        if (k0Var != null) {
            return k0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        k0 k0Var = this.x;
        if (k0Var != null) {
            return k0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        k0 k0Var = this.x;
        if (k0Var != null) {
            return k0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.y;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.g N;
        ActionMenuView actionMenuView = this.a;
        if ((actionMenuView == null || (N = actionMenuView.N()) == null || !N.hasVisibleItems()) ? false : true) {
            return Math.max(getContentInsetEnd(), Math.max(this.z, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (c.h.k.v.y(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (c.h.k.v.y(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.y, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f722e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f722e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.a.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f721d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f721d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    androidx.appcompat.widget.c getOuterActionMenuPresenter() {
        return this.N;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f727k;
    }

    public int getPopupTheme() {
        return this.f728l;
    }

    public CharSequence getSubtitle() {
        return this.C;
    }

    final TextView getSubtitleTextView() {
        return this.f720c;
    }

    public CharSequence getTitle() {
        return this.B;
    }

    public int getTitleMarginBottom() {
        return this.w;
    }

    public int getTitleMarginEnd() {
        return this.u;
    }

    public int getTitleMarginStart() {
        return this.t;
    }

    public int getTitleMarginTop() {
        return this.v;
    }

    final TextView getTitleTextView() {
        return this.f719b;
    }

    public y getWrapper() {
        if (this.M == null) {
            this.M = new t0(this, true);
        }
        return this.M;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: n */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: o */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        if (layoutParams instanceof a.C0005a) {
            return new e((a.C0005a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new e(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.S);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.G = false;
        }
        if (!this.G) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.G = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.G = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:105:0x029f A[LOOP:0: B:104:0x029d->B:105:0x029f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c1 A[LOOP:1: B:107:0x02bf->B:108:0x02c1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02fa A[LOOP:2: B:116:0x02f8->B:117:0x02fa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0227  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 783
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        char c2;
        char c3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr = this.J;
        if (y0.b(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c2 = 1;
            c3 = 0;
        }
        if (N(this.f721d)) {
            E(this.f721d, i2, 0, i3, 0, this.q);
            i4 = this.f721d.getMeasuredWidth() + s(this.f721d);
            i5 = Math.max(0, this.f721d.getMeasuredHeight() + t(this.f721d));
            i6 = View.combineMeasuredStates(0, this.f721d.getMeasuredState());
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (N(this.f725h)) {
            E(this.f725h, i2, 0, i3, 0, this.q);
            i4 = this.f725h.getMeasuredWidth() + s(this.f725h);
            i5 = Math.max(i5, this.f725h.getMeasuredHeight() + t(this.f725h));
            i6 = View.combineMeasuredStates(i6, this.f725h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i4);
        iArr[c3] = Math.max(0, currentContentInsetStart - i4);
        if (N(this.a)) {
            E(this.a, i2, max, i3, 0, this.q);
            i7 = this.a.getMeasuredWidth() + s(this.a);
            i5 = Math.max(i5, this.a.getMeasuredHeight() + t(this.a));
            i6 = View.combineMeasuredStates(i6, this.a.getMeasuredState());
        } else {
            i7 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i7);
        iArr[c2] = Math.max(0, currentContentInsetEnd - i7);
        if (N(this.f726j)) {
            max2 += D(this.f726j, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.f726j.getMeasuredHeight() + t(this.f726j));
            i6 = View.combineMeasuredStates(i6, this.f726j.getMeasuredState());
        }
        if (N(this.f722e)) {
            max2 += D(this.f722e, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.f722e.getMeasuredHeight() + t(this.f722e));
            i6 = View.combineMeasuredStates(i6, this.f722e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (((e) childAt.getLayoutParams()).f731b == 0 && N(childAt)) {
                max2 += D(childAt, i2, max2, i3, 0, iArr);
                i5 = Math.max(i5, childAt.getMeasuredHeight() + t(childAt));
                i6 = View.combineMeasuredStates(i6, childAt.getMeasuredState());
            }
        }
        int i12 = this.v + this.w;
        int i13 = this.t + this.u;
        if (N(this.f719b)) {
            D(this.f719b, i2, max2 + i13, i3, i12, iArr);
            int measuredWidth = this.f719b.getMeasuredWidth() + s(this.f719b);
            i8 = this.f719b.getMeasuredHeight() + t(this.f719b);
            i9 = View.combineMeasuredStates(i6, this.f719b.getMeasuredState());
            i10 = measuredWidth;
        } else {
            i8 = 0;
            i9 = i6;
            i10 = 0;
        }
        if (N(this.f720c)) {
            i10 = Math.max(i10, D(this.f720c, i2, max2 + i13, i3, i8 + i12, iArr));
            i8 += this.f720c.getMeasuredHeight() + t(this.f720c);
            i9 = View.combineMeasuredStates(i9, this.f720c.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max2 + i10 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, (-16777216) & i9), M() ? 0 : View.resolveSizeAndState(Math.max(Math.max(i5, i8) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, i9 << 16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.a());
        ActionMenuView actionMenuView = this.a;
        androidx.appcompat.view.menu.g N = actionMenuView != null ? actionMenuView.N() : null;
        int i2 = gVar.f732c;
        if (i2 != 0 && this.O != null && N != null && (findItem = N.findItem(i2)) != null) {
            findItem.expandActionView();
        }
        if (gVar.f733d) {
            F();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i2);
        }
        h();
        this.x.f(i2 == 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.i iVar;
        g gVar = new g(super.onSaveInstanceState());
        d dVar = this.O;
        if (dVar != null && (iVar = dVar.f729b) != null) {
            gVar.f732c = iVar.getItemId();
        }
        gVar.f733d = A();
        return gVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.F = false;
        }
        if (!this.F) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.F = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.F = false;
        }
        return true;
    }

    public void setCollapseContentDescription(int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseIcon(int i2) {
        setCollapseIcon(c.a.k.a.a.d(getContext(), i2));
    }

    public void setCollapsible(boolean z) {
        this.R = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.z) {
            this.z = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.y) {
            this.y = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(c.a.k.a.a.d(getContext(), i2));
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(c.a.k.a.a.d(getContext(), i2));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f721d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.K = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.f728l != i2) {
            this.f728l = i2;
            if (i2 == 0) {
                this.f727k = getContext();
            } else {
                this.f727k = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextColor(int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMarginBottom(int i2) {
        this.w = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.u = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.t = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.v = i2;
        requestLayout();
    }

    public void setTitleTextColor(int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    public boolean v() {
        d dVar = this.O;
        return (dVar == null || dVar.f729b == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.H();
    }

    public void x(int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    public boolean z() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.I();
    }

    /* loaded from: classes.dex */
    public static class e extends a.C0005a {

        /* renamed from: b  reason: collision with root package name */
        int f731b;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f731b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(int i2, int i3) {
            super(i2, i3);
            this.f731b = 0;
            this.a = 8388627;
        }

        public e(e eVar) {
            super((a.C0005a) eVar);
            this.f731b = 0;
            this.f731b = eVar.f731b;
        }

        public e(a.C0005a c0005a) {
            super(c0005a);
            this.f731b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f731b = 0;
            a(marginLayoutParams);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f731b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.O);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f725h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f725h.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.f725h;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.f723f);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!y(this.f722e)) {
                c(this.f722e, true);
            }
        } else {
            ImageView imageView = this.f722e;
            if (imageView != null && y(imageView)) {
                removeView(this.f722e);
                this.I.remove(this.f722e);
            }
        }
        ImageView imageView2 = this.f722e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f722e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f721d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!y(this.f721d)) {
                c(this.f721d, true);
            }
        } else {
            ImageButton imageButton = this.f721d;
            if (imageButton != null && y(imageButton)) {
                removeView(this.f721d);
                this.I.remove(this.f721d);
            }
        }
        ImageButton imageButton2 = this.f721d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f720c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f720c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f720c.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.n;
                if (i2 != 0) {
                    this.f720c.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.E;
                if (colorStateList != null) {
                    this.f720c.setTextColor(colorStateList);
                }
            }
            if (!y(this.f720c)) {
                c(this.f720c, true);
            }
        } else {
            TextView textView = this.f720c;
            if (textView != null && y(textView)) {
                removeView(this.f720c);
                this.I.remove(this.f720c);
            }
        }
        TextView textView2 = this.f720c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.C = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.E = colorStateList;
        TextView textView = this.f720c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f719b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f719b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f719b.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.m;
                if (i2 != 0) {
                    this.f719b.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.D;
                if (colorStateList != null) {
                    this.f719b.setTextColor(colorStateList);
                }
            }
            if (!y(this.f719b)) {
                c(this.f719b, true);
            }
        } else {
            TextView textView = this.f719b;
            if (textView != null && y(textView)) {
                removeView(this.f719b);
                this.I.remove(this.f719b);
            }
        }
        TextView textView2 = this.f719b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.B = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.D = colorStateList;
        TextView textView = this.f719b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* loaded from: classes.dex */
    public static class g extends c.j.a.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f732c;

        /* renamed from: d  reason: collision with root package name */
        boolean f733d;

        /* loaded from: classes.dex */
        class a implements Parcelable.ClassLoaderCreator<g> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public g[] newArray(int i2) {
                return new g[i2];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f732c = parcel.readInt();
            this.f733d = parcel.readInt() != 0;
        }

        @Override // c.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f732c);
            parcel.writeInt(this.f733d ? 1 : 0);
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.A = 8388627;
        this.H = new ArrayList<>();
        this.I = new ArrayList<>();
        this.J = new int[2];
        this.L = new a();
        this.S = new b();
        Context context2 = getContext();
        int[] iArr = c.a.j.o3;
        s0 v = s0.v(context2, attributeSet, iArr, i2, 0);
        c.h.k.v.i0(this, context, iArr, attributeSet, v.r(), i2, 0);
        this.m = v.n(c.a.j.Q3, 0);
        this.n = v.n(c.a.j.H3, 0);
        this.A = v.l(c.a.j.p3, this.A);
        this.p = v.l(c.a.j.q3, 48);
        int e2 = v.e(c.a.j.K3, 0);
        int i3 = c.a.j.P3;
        e2 = v.s(i3) ? v.e(i3, e2) : e2;
        this.w = e2;
        this.v = e2;
        this.u = e2;
        this.t = e2;
        int e3 = v.e(c.a.j.N3, -1);
        if (e3 >= 0) {
            this.t = e3;
        }
        int e4 = v.e(c.a.j.M3, -1);
        if (e4 >= 0) {
            this.u = e4;
        }
        int e5 = v.e(c.a.j.O3, -1);
        if (e5 >= 0) {
            this.v = e5;
        }
        int e6 = v.e(c.a.j.L3, -1);
        if (e6 >= 0) {
            this.w = e6;
        }
        this.q = v.f(c.a.j.B3, -1);
        int e7 = v.e(c.a.j.x3, Integer.MIN_VALUE);
        int e8 = v.e(c.a.j.t3, Integer.MIN_VALUE);
        int f2 = v.f(c.a.j.v3, 0);
        int f3 = v.f(c.a.j.w3, 0);
        h();
        this.x.e(f2, f3);
        if (e7 != Integer.MIN_VALUE || e8 != Integer.MIN_VALUE) {
            this.x.g(e7, e8);
        }
        this.y = v.e(c.a.j.y3, Integer.MIN_VALUE);
        this.z = v.e(c.a.j.u3, Integer.MIN_VALUE);
        this.f723f = v.g(c.a.j.s3);
        this.f724g = v.p(c.a.j.r3);
        CharSequence p = v.p(c.a.j.J3);
        if (!TextUtils.isEmpty(p)) {
            setTitle(p);
        }
        CharSequence p2 = v.p(c.a.j.G3);
        if (!TextUtils.isEmpty(p2)) {
            setSubtitle(p2);
        }
        this.f727k = getContext();
        setPopupTheme(v.n(c.a.j.F3, 0));
        Drawable g2 = v.g(c.a.j.E3);
        if (g2 != null) {
            setNavigationIcon(g2);
        }
        CharSequence p3 = v.p(c.a.j.D3);
        if (!TextUtils.isEmpty(p3)) {
            setNavigationContentDescription(p3);
        }
        Drawable g3 = v.g(c.a.j.z3);
        if (g3 != null) {
            setLogo(g3);
        }
        CharSequence p4 = v.p(c.a.j.A3);
        if (!TextUtils.isEmpty(p4)) {
            setLogoDescription(p4);
        }
        int i4 = c.a.j.R3;
        if (v.s(i4)) {
            setTitleTextColor(v.c(i4));
        }
        int i5 = c.a.j.I3;
        if (v.s(i5)) {
            setSubtitleTextColor(v.c(i5));
        }
        int i6 = c.a.j.C3;
        if (v.s(i6)) {
            x(v.n(i6, 0));
        }
        v.w();
    }
}