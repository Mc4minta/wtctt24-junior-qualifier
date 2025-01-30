package androidx.appcompat.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.d0;

/* compiled from: ScrollingTabContainerView.java */
/* loaded from: classes.dex */
public class l0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final Interpolator a = new DecelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    Runnable f838b;

    /* renamed from: c  reason: collision with root package name */
    private c f839c;

    /* renamed from: d  reason: collision with root package name */
    d0 f840d;

    /* renamed from: e  reason: collision with root package name */
    private Spinner f841e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f842f;

    /* renamed from: g  reason: collision with root package name */
    int f843g;

    /* renamed from: h  reason: collision with root package name */
    int f844h;

    /* renamed from: j  reason: collision with root package name */
    private int f845j;

    /* renamed from: k  reason: collision with root package name */
    private int f846k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            l0.this.smoothScrollTo(this.a.getLeft() - ((l0.this.getWidth() - this.a.getWidth()) / 2), 0);
            l0.this.f838b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return l0.this.f840d.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return ((d) l0.this.f840d.getChildAt(i2)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                return l0.this.c((a.c) getItem(i2), true);
            }
            ((d) view).a((a.c) getItem(i2));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = l0.this.f840d.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = l0.this.f840d.getChildAt(i2);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class d extends LinearLayout {
        private final int[] a;

        /* renamed from: b  reason: collision with root package name */
        private a.c f848b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f849c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f850d;

        /* renamed from: e  reason: collision with root package name */
        private View f851e;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public d(android.content.Context r6, androidx.appcompat.app.a.c r7, boolean r8) {
            /*
                r4 = this;
                androidx.appcompat.widget.l0.this = r5
                int r5 = c.a.a.f2422d
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 16842964(0x10100d4, float:2.3694152E-38)
                r3 = 0
                r1[r3] = r2
                r4.a = r1
                r4.f848b = r7
                androidx.appcompat.widget.s0 r5 = androidx.appcompat.widget.s0.v(r6, r0, r1, r5, r3)
                boolean r6 = r5.s(r3)
                if (r6 == 0) goto L26
                android.graphics.drawable.Drawable r6 = r5.g(r3)
                r4.setBackgroundDrawable(r6)
            L26:
                r5.w()
                if (r8 == 0) goto L31
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
            L31:
                r4.c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.l0.d.<init>(androidx.appcompat.widget.l0, android.content.Context, androidx.appcompat.app.a$c, boolean):void");
        }

        public void a(a.c cVar) {
            this.f848b = cVar;
            c();
        }

        public a.c b() {
            return this.f848b;
        }

        public void c() {
            a.c cVar = this.f848b;
            View b2 = cVar.b();
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.f851e = b2;
                TextView textView = this.f849c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f850d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f850d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f851e;
            if (view != null) {
                removeView(view);
                this.f851e = null;
            }
            Drawable c2 = cVar.c();
            CharSequence d2 = cVar.d();
            if (c2 != null) {
                if (this.f850d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f850d = appCompatImageView;
                }
                this.f850d.setImageDrawable(c2);
                this.f850d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f850d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f850d.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(d2);
            if (z) {
                if (this.f849c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, c.a.a.f2423e);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f849c = appCompatTextView;
                }
                this.f849c.setText(d2);
                this.f849c.setVisibility(0);
            } else {
                TextView textView2 = this.f849c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f849c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f850d;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            u0.a(this, z ? null : cVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (l0.this.f843g > 0) {
                int measuredWidth = getMeasuredWidth();
                int i4 = l0.this.f843g;
                if (measuredWidth > i4) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    private Spinner b() {
        s sVar = new s(getContext(), null, c.a.a.f2426h);
        sVar.setLayoutParams(new d0.a(-2, -1));
        sVar.setOnItemSelectedListener(this);
        return sVar;
    }

    private boolean d() {
        Spinner spinner = this.f841e;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (d()) {
            return;
        }
        if (this.f841e == null) {
            this.f841e = b();
        }
        removeView(this.f840d);
        addView(this.f841e, new ViewGroup.LayoutParams(-2, -1));
        if (this.f841e.getAdapter() == null) {
            this.f841e.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f838b;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f838b = null;
        }
        this.f841e.setSelection(this.f846k);
    }

    private boolean f() {
        if (d()) {
            removeView(this.f841e);
            addView(this.f840d, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f841e.getSelectedItemPosition());
            return false;
        }
        return false;
    }

    public void a(int i2) {
        View childAt = this.f840d.getChildAt(i2);
        Runnable runnable = this.f838b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f838b = aVar;
        post(aVar);
    }

    d c(a.c cVar, boolean z) {
        d dVar = new d(getContext(), cVar, z);
        if (z) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f845j));
        } else {
            dVar.setFocusable(true);
            if (this.f839c == null) {
                this.f839c = new c();
            }
            dVar.setOnClickListener(this.f839c);
        }
        return dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f838b;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c.a.o.a b2 = c.a.o.a.b(getContext());
        setContentHeight(b2.f());
        this.f844h = b2.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f838b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((d) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f840d.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f843g = (int) (View.MeasureSpec.getSize(i2) * 0.4f);
            } else {
                this.f843g = View.MeasureSpec.getSize(i2) / 2;
            }
            this.f843g = Math.min(this.f843g, this.f844h);
        } else {
            this.f843g = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f845j, 1073741824);
        if (z2 || !this.f842f) {
            z = false;
        }
        if (z) {
            this.f840d.measure(0, makeMeasureSpec);
            if (this.f840d.getMeasuredWidth() > View.MeasureSpec.getSize(i2)) {
                e();
            } else {
                f();
            }
        } else {
            f();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z2 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f846k);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f842f = z;
    }

    public void setContentHeight(int i2) {
        this.f845j = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.f846k = i2;
        int childCount = this.f840d.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.f840d.getChildAt(i3);
            boolean z = i3 == i2;
            childAt.setSelected(z);
            if (z) {
                a(i2);
            }
            i3++;
        }
        Spinner spinner = this.f841e;
        if (spinner == null || i2 < 0) {
            return;
        }
        spinner.setSelection(i2);
    }
}