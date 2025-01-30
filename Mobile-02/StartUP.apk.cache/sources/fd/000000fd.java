package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import c.h.k.b;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActionMenuPresenter.java */
/* loaded from: classes.dex */
public class c extends androidx.appcompat.view.menu.b implements b.a {
    private int A;
    private final SparseBooleanArray B;
    e C;
    a D;
    RunnableC0009c E;
    private b F;
    final f G;
    int H;

    /* renamed from: l  reason: collision with root package name */
    d f758l;
    private Drawable m;
    private boolean n;
    private boolean p;
    private boolean q;
    private int t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.view.menu.l {
        public a(Context context, androidx.appcompat.view.menu.r rVar, View view) {
            super(context, rVar, view, false, c.a.a.f2430l);
            if (!((androidx.appcompat.view.menu.i) rVar.getItem()).l()) {
                View view2 = c.this.f758l;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.b) c.this).f561j : view2);
            }
            j(c.this.G);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.appcompat.view.menu.l
        public void e() {
            c cVar = c.this;
            cVar.D = null;
            cVar.H = 0;
            super.e();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.p a() {
            a aVar = c.this.D;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: androidx.appcompat.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0009c implements Runnable {
        private e a;

        public RunnableC0009c(e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.b) c.this).f555c != null) {
                ((androidx.appcompat.view.menu.b) c.this).f555c.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.b) c.this).f561j;
            if (view != null && view.getWindowToken() != null && this.a.m()) {
                c.this.C = this.a;
            }
            c.this.E = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public class d extends AppCompatImageView implements ActionMenuView.a {

        /* compiled from: ActionMenuPresenter.java */
        /* loaded from: classes.dex */
        class a extends c0 {

            /* renamed from: k  reason: collision with root package name */
            final /* synthetic */ c f760k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, c cVar) {
                super(view);
                this.f760k = cVar;
            }

            @Override // androidx.appcompat.widget.c0
            public androidx.appcompat.view.menu.p b() {
                e eVar = c.this.C;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.c0
            public boolean c() {
                c.this.M();
                return true;
            }

            @Override // androidx.appcompat.widget.c0
            public boolean d() {
                c cVar = c.this;
                if (cVar.E != null) {
                    return false;
                }
                cVar.D();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, c.a.a.f2429k);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            u0.a(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.M();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public class e extends androidx.appcompat.view.menu.l {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z) {
            super(context, gVar, view, z, c.a.a.f2430l);
            h(8388613);
            j(c.this.G);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.appcompat.view.menu.l
        public void e() {
            if (((androidx.appcompat.view.menu.b) c.this).f555c != null) {
                ((androidx.appcompat.view.menu.b) c.this).f555c.close();
            }
            c.this.C = null;
            super.e();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    private class f implements m.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (gVar instanceof androidx.appcompat.view.menu.r) {
                gVar.F().e(false);
            }
            m.a o = c.this.o();
            if (o != null) {
                o.b(gVar, z);
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            if (gVar == ((androidx.appcompat.view.menu.b) c.this).f555c) {
                return false;
            }
            c.this.H = ((androidx.appcompat.view.menu.r) gVar).getItem().getItemId();
            m.a o = c.this.o();
            if (o != null) {
                return o.c(gVar);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter.java */
    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new a();
        public int a;

        /* compiled from: ActionMenuPresenter.java */
        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<g> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public g[] newArray(int i2) {
                return new g[i2];
            }
        }

        g() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
        }

        g(Parcel parcel) {
            this.a = parcel.readInt();
        }
    }

    public c(Context context) {
        super(context, c.a.g.f2472c, c.a.g.f2471b);
        this.B = new SparseBooleanArray();
        this.G = new f();
    }

    private View B(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f561j;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean A() {
        return D() | E();
    }

    public Drawable C() {
        d dVar = this.f758l;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.n) {
            return this.m;
        }
        return null;
    }

    public boolean D() {
        androidx.appcompat.view.menu.n nVar;
        RunnableC0009c runnableC0009c = this.E;
        if (runnableC0009c != null && (nVar = this.f561j) != null) {
            ((View) nVar).removeCallbacks(runnableC0009c);
            this.E = null;
            return true;
        }
        e eVar = this.C;
        if (eVar != null) {
            eVar.b();
            return true;
        }
        return false;
    }

    public boolean E() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.b();
            return true;
        }
        return false;
    }

    public boolean F() {
        return this.E != null || G();
    }

    public boolean G() {
        e eVar = this.C;
        return eVar != null && eVar.d();
    }

    public void H(Configuration configuration) {
        if (!this.w) {
            this.v = c.a.o.a.b(this.f554b).d();
        }
        androidx.appcompat.view.menu.g gVar = this.f555c;
        if (gVar != null) {
            gVar.M(true);
        }
    }

    public void I(boolean z) {
        this.z = z;
    }

    public void J(ActionMenuView actionMenuView) {
        this.f561j = actionMenuView;
        actionMenuView.b(this.f555c);
    }

    public void K(Drawable drawable) {
        d dVar = this.f758l;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.n = true;
        this.m = drawable;
    }

    public void L(boolean z) {
        this.p = z;
        this.q = true;
    }

    public boolean M() {
        androidx.appcompat.view.menu.g gVar;
        if (!this.p || G() || (gVar = this.f555c) == null || this.f561j == null || this.E != null || gVar.B().isEmpty()) {
            return false;
        }
        RunnableC0009c runnableC0009c = new RunnableC0009c(new e(this.f554b, this.f555c, this.f758l, true));
        this.E = runnableC0009c;
        ((View) this.f561j).post(runnableC0009c);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
        A();
        super.b(gVar, z);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void c(boolean z) {
        super.c(z);
        ((View) this.f561j).requestLayout();
        androidx.appcompat.view.menu.g gVar = this.f555c;
        boolean z2 = false;
        if (gVar != null) {
            ArrayList<androidx.appcompat.view.menu.i> u = gVar.u();
            int size = u.size();
            for (int i2 = 0; i2 < size; i2++) {
                c.h.k.b b2 = u.get(i2).b();
                if (b2 != null) {
                    b2.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.g gVar2 = this.f555c;
        ArrayList<androidx.appcompat.view.menu.i> B = gVar2 != null ? gVar2.B() : null;
        if (this.p && B != null) {
            int size2 = B.size();
            if (size2 == 1) {
                z2 = !B.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f758l == null) {
                this.f758l = new d(this.a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f758l.getParent();
            if (viewGroup != this.f561j) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f758l);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f561j;
                actionMenuView.addView(this.f758l, actionMenuView.F());
            }
        } else {
            d dVar = this.f758l;
            if (dVar != null) {
                ViewParent parent = dVar.getParent();
                androidx.appcompat.view.menu.n nVar = this.f561j;
                if (parent == nVar) {
                    ((ViewGroup) nVar).removeView(this.f758l);
                }
            }
        }
        ((ActionMenuView) this.f561j).setOverflowReserved(this.p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        ArrayList<androidx.appcompat.view.menu.i> arrayList;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        c cVar = this;
        androidx.appcompat.view.menu.g gVar = cVar.f555c;
        View view = null;
        ?? r3 = 0;
        if (gVar != null) {
            arrayList = gVar.G();
            i2 = arrayList.size();
        } else {
            arrayList = null;
            i2 = 0;
        }
        int i6 = cVar.v;
        int i7 = cVar.u;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f561j;
        boolean z2 = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i2; i10++) {
            androidx.appcompat.view.menu.i iVar = arrayList.get(i10);
            if (iVar.o()) {
                i8++;
            } else if (iVar.n()) {
                i9++;
            } else {
                z2 = true;
            }
            if (cVar.z && iVar.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (cVar.p && (z2 || i9 + i8 > i6)) {
            i6--;
        }
        int i11 = i6 - i8;
        SparseBooleanArray sparseBooleanArray = cVar.B;
        sparseBooleanArray.clear();
        if (cVar.x) {
            int i12 = cVar.A;
            i4 = i7 / i12;
            i3 = i12 + ((i7 % i12) / i4);
        } else {
            i3 = 0;
            i4 = 0;
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < i2) {
            androidx.appcompat.view.menu.i iVar2 = arrayList.get(i13);
            if (iVar2.o()) {
                View p = cVar.p(iVar2, view, viewGroup);
                if (cVar.x) {
                    i4 -= ActionMenuView.L(p, i3, i4, makeMeasureSpec, r3);
                } else {
                    p.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = p.getMeasuredWidth();
                i7 -= measuredWidth;
                if (i14 == 0) {
                    i14 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.u(true);
                z = r3;
                i5 = i2;
            } else if (iVar2.n()) {
                int groupId2 = iVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i11 > 0 || z3) && i7 > 0 && (!cVar.x || i4 > 0);
                boolean z5 = z4;
                i5 = i2;
                if (z4) {
                    View p2 = cVar.p(iVar2, null, viewGroup);
                    if (cVar.x) {
                        int L = ActionMenuView.L(p2, i3, i4, makeMeasureSpec, 0);
                        i4 -= L;
                        if (L == 0) {
                            z5 = false;
                        }
                    } else {
                        p2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z6 = z5;
                    int measuredWidth2 = p2.getMeasuredWidth();
                    i7 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z4 = z6 & (!cVar.x ? i7 + i14 <= 0 : i7 < 0);
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i15 = 0; i15 < i13; i15++) {
                        androidx.appcompat.view.menu.i iVar3 = arrayList.get(i15);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.l()) {
                                i11++;
                            }
                            iVar3.u(false);
                        }
                    }
                }
                if (z4) {
                    i11--;
                }
                iVar2.u(z4);
                z = false;
            } else {
                z = r3;
                i5 = i2;
                iVar2.u(z);
            }
            i13++;
            r3 = z;
            i2 = i5;
            view = null;
            cVar = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b
    public void h(androidx.appcompat.view.menu.i iVar, n.a aVar) {
        aVar.f(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f561j);
        if (this.F == null) {
            this.F = new b();
        }
        actionMenuItemView.setPopupCallback(this.F);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void i(Context context, androidx.appcompat.view.menu.g gVar) {
        super.i(context, gVar);
        Resources resources = context.getResources();
        c.a.o.a b2 = c.a.o.a.b(context);
        if (!this.q) {
            this.p = b2.h();
        }
        if (!this.y) {
            this.t = b2.c();
        }
        if (!this.w) {
            this.v = b2.d();
        }
        int i2 = this.t;
        if (this.p) {
            if (this.f758l == null) {
                d dVar = new d(this.a);
                this.f758l = dVar;
                if (this.n) {
                    dVar.setImageDrawable(this.m);
                    this.m = null;
                    this.n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f758l.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i2 -= this.f758l.getMeasuredWidth();
        } else {
            this.f758l = null;
        }
        this.u = i2;
        this.A = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.m
    public void j(Parcelable parcelable) {
        int i2;
        MenuItem findItem;
        if ((parcelable instanceof g) && (i2 = ((g) parcelable).a) > 0 && (findItem = this.f555c.findItem(i2)) != null) {
            l((androidx.appcompat.view.menu.r) findItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean l(androidx.appcompat.view.menu.r rVar) {
        boolean z = false;
        if (rVar.hasVisibleItems()) {
            androidx.appcompat.view.menu.r rVar2 = rVar;
            while (rVar2.i0() != this.f555c) {
                rVar2 = (androidx.appcompat.view.menu.r) rVar2.i0();
            }
            View B = B(rVar2.getItem());
            if (B == null) {
                return false;
            }
            this.H = rVar.getItem().getItemId();
            int size = rVar.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MenuItem item = rVar.getItem(i2);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i2++;
            }
            a aVar = new a(this.f554b, rVar, B);
            this.D = aVar;
            aVar.g(z);
            this.D.k();
            super.l(rVar);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable m() {
        g gVar = new g();
        gVar.a = this.H;
        return gVar;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean n(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.f758l) {
            return false;
        }
        return super.n(viewGroup, i2);
    }

    @Override // androidx.appcompat.view.menu.b
    public View p(androidx.appcompat.view.menu.i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.j()) {
            actionView = super.p(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.o(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.n q(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.n nVar = this.f561j;
        androidx.appcompat.view.menu.n q = super.q(viewGroup);
        if (nVar != q) {
            ((ActionMenuView) q).setPresenter(this);
        }
        return q;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean s(int i2, androidx.appcompat.view.menu.i iVar) {
        return iVar.l();
    }
}