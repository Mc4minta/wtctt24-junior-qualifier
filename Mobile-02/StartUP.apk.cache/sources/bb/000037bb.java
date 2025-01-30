package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.u0;
import androidx.core.util.Pools$SimplePool;
import androidx.viewpager.widget.ViewPager;
import c.h.k.t;
import c.h.k.v;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import com.reactnativecommunity.webview.RNCWebViewManager;
import e.g.a.f.j;
import e.g.a.f.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpStatus;

@ViewPager.e
/* loaded from: classes2.dex */
public class TabLayout extends HorizontalScrollView {
    private static final androidx.core.util.f<f> a = new androidx.core.util.g(16);
    private int A;
    int B;
    int C;
    int D;
    int E;
    boolean F;
    boolean G;
    boolean H;
    private c I;
    private final ArrayList<c> J;
    private c K;
    private ValueAnimator L;
    ViewPager M;
    private androidx.viewpager.widget.a N;
    private DataSetObserver O;
    private g P;
    private b Q;
    private boolean R;
    private final androidx.core.util.f<h> S;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<f> f8210b;

    /* renamed from: c  reason: collision with root package name */
    private f f8211c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f8212d;

    /* renamed from: e  reason: collision with root package name */
    private final e f8213e;

    /* renamed from: f  reason: collision with root package name */
    int f8214f;

    /* renamed from: g  reason: collision with root package name */
    int f8215g;

    /* renamed from: h  reason: collision with root package name */
    int f8216h;

    /* renamed from: j  reason: collision with root package name */
    int f8217j;

    /* renamed from: k  reason: collision with root package name */
    int f8218k;

    /* renamed from: l  reason: collision with root package name */
    ColorStateList f8219l;
    ColorStateList m;
    ColorStateList n;
    Drawable p;
    PorterDuff.Mode q;
    float t;
    float u;
    final int v;
    int w;
    private final int x;
    private final int y;
    private final int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements ViewPager.i {
        private boolean a;

        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.M == viewPager) {
                tabLayout.E(aVar2, this.a);
            }
        }

        void b(boolean z) {
            this.a = z;
        }
    }

    /* loaded from: classes2.dex */
    public interface c<T extends f> {
        void onTabReselected(T t);

        void onTabSelected(T t);

        void onTabUnselected(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d extends DataSetObserver {
        d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.x();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e extends LinearLayout {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private final Paint f8221b;

        /* renamed from: c  reason: collision with root package name */
        private final GradientDrawable f8222c;

        /* renamed from: d  reason: collision with root package name */
        int f8223d;

        /* renamed from: e  reason: collision with root package name */
        float f8224e;

        /* renamed from: f  reason: collision with root package name */
        private int f8225f;

        /* renamed from: g  reason: collision with root package name */
        private int f8226g;

        /* renamed from: h  reason: collision with root package name */
        private int f8227h;

        /* renamed from: j  reason: collision with root package name */
        private ValueAnimator f8228j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f8230b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f8231c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f8232d;

            a(int i2, int i3, int i4, int i5) {
                this.a = i2;
                this.f8230b = i3;
                this.f8231c = i4;
                this.f8232d = i5;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                e.this.d(e.g.a.f.l.a.b(this.a, this.f8230b, animatedFraction), e.g.a.f.l.a.b(this.f8231c, this.f8232d, animatedFraction));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class b extends AnimatorListenerAdapter {
            final /* synthetic */ int a;

            b(int i2) {
                this.a = i2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e eVar = e.this;
                eVar.f8223d = this.a;
                eVar.f8224e = 0.0f;
            }
        }

        e(Context context) {
            super(context);
            this.f8223d = -1;
            this.f8225f = -1;
            this.f8226g = -1;
            this.f8227h = -1;
            setWillNotDraw(false);
            this.f8221b = new Paint();
            this.f8222c = new GradientDrawable();
        }

        private void b(h hVar, RectF rectF) {
            int f2 = hVar.f();
            if (f2 < TabLayout.this.t(24)) {
                f2 = TabLayout.this.t(24);
            }
            int left = (hVar.getLeft() + hVar.getRight()) / 2;
            int i2 = f2 / 2;
            rectF.set(left - i2, 0.0f, left + i2, 0.0f);
        }

        private void h() {
            int i2;
            int i3;
            View childAt = getChildAt(this.f8223d);
            if (childAt == null || childAt.getWidth() <= 0) {
                i2 = -1;
                i3 = -1;
            } else {
                i2 = childAt.getLeft();
                i3 = childAt.getRight();
                TabLayout tabLayout = TabLayout.this;
                if (!tabLayout.G && (childAt instanceof h)) {
                    b((h) childAt, tabLayout.f8212d);
                    i2 = (int) TabLayout.this.f8212d.left;
                    i3 = (int) TabLayout.this.f8212d.right;
                }
                if (this.f8224e > 0.0f && this.f8223d < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f8223d + 1);
                    int left = childAt2.getLeft();
                    int right = childAt2.getRight();
                    TabLayout tabLayout2 = TabLayout.this;
                    if (!tabLayout2.G && (childAt2 instanceof h)) {
                        b((h) childAt2, tabLayout2.f8212d);
                        left = (int) TabLayout.this.f8212d.left;
                        right = (int) TabLayout.this.f8212d.right;
                    }
                    float f2 = this.f8224e;
                    i2 = (int) ((left * f2) + ((1.0f - f2) * i2));
                    i3 = (int) ((right * f2) + ((1.0f - f2) * i3));
                }
            }
            d(i2, i3);
        }

        void a(int i2, int i3) {
            ValueAnimator valueAnimator = this.f8228j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f8228j.cancel();
            }
            View childAt = getChildAt(i2);
            if (childAt == null) {
                h();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            TabLayout tabLayout = TabLayout.this;
            if (!tabLayout.G && (childAt instanceof h)) {
                b((h) childAt, tabLayout.f8212d);
                left = (int) TabLayout.this.f8212d.left;
                right = (int) TabLayout.this.f8212d.right;
            }
            int i4 = left;
            int i5 = right;
            int i6 = this.f8226g;
            int i7 = this.f8227h;
            if (i6 == i4 && i7 == i5) {
                return;
            }
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f8228j = valueAnimator2;
            valueAnimator2.setInterpolator(e.g.a.f.l.a.f13292b);
            valueAnimator2.setDuration(i3);
            valueAnimator2.setFloatValues(0.0f, 1.0f);
            valueAnimator2.addUpdateListener(new a(i6, i4, i7, i5));
            valueAnimator2.addListener(new b(i2));
            valueAnimator2.start();
        }

        boolean c() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        void d(int i2, int i3) {
            if (i2 == this.f8226g && i3 == this.f8227h) {
                return;
            }
            this.f8226g = i2;
            this.f8227h = i3;
            v.b0(this);
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            Drawable drawable = TabLayout.this.p;
            int i2 = 0;
            int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
            int i3 = this.a;
            if (i3 >= 0) {
                intrinsicHeight = i3;
            }
            int i4 = TabLayout.this.D;
            if (i4 == 0) {
                i2 = getHeight() - intrinsicHeight;
                intrinsicHeight = getHeight();
            } else if (i4 == 1) {
                i2 = (getHeight() - intrinsicHeight) / 2;
                intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
            } else if (i4 != 2) {
                intrinsicHeight = i4 != 3 ? 0 : getHeight();
            }
            int i5 = this.f8226g;
            if (i5 >= 0 && this.f8227h > i5) {
                Drawable drawable2 = TabLayout.this.p;
                if (drawable2 == null) {
                    drawable2 = this.f8222c;
                }
                Drawable r = androidx.core.graphics.drawable.a.r(drawable2);
                r.setBounds(this.f8226g, i2, this.f8227h, intrinsicHeight);
                Paint paint = this.f8221b;
                if (paint != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        r.setColorFilter(paint.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        androidx.core.graphics.drawable.a.n(r, paint.getColor());
                    }
                }
                r.draw(canvas);
            }
            super.draw(canvas);
        }

        void e(int i2, float f2) {
            ValueAnimator valueAnimator = this.f8228j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f8228j.cancel();
            }
            this.f8223d = i2;
            this.f8224e = f2;
            h();
        }

        void f(int i2) {
            if (this.f8221b.getColor() != i2) {
                this.f8221b.setColor(i2);
                v.b0(this);
            }
        }

        void g(int i2) {
            if (this.a != i2) {
                this.a = i2;
                v.b0(this);
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.f8228j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f8228j.cancel();
                a(this.f8223d, Math.round((1.0f - this.f8228j.getAnimatedFraction()) * ((float) this.f8228j.getDuration())));
                return;
            }
            h();
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.E == 1 && tabLayout.B == 1) {
                int childCount = getChildCount();
                int i4 = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    if (childAt.getVisibility() == 0) {
                        i4 = Math.max(i4, childAt.getMeasuredWidth());
                    }
                }
                if (i4 <= 0) {
                    return;
                }
                if (i4 * childCount <= getMeasuredWidth() - (TabLayout.this.t(16) * 2)) {
                    boolean z2 = false;
                    for (int i6 = 0; i6 < childCount; i6++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                        if (layoutParams.width != i4 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i4;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.B = 0;
                    tabLayout2.L(false);
                }
                if (z) {
                    super.onMeasure(i2, i3);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT >= 23 || this.f8225f == i2) {
                return;
            }
            requestLayout();
            this.f8225f = i2;
        }
    }

    /* loaded from: classes2.dex */
    public static class f {
        private Object a;

        /* renamed from: b  reason: collision with root package name */
        private Drawable f8235b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f8236c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f8237d;

        /* renamed from: e  reason: collision with root package name */
        private int f8238e = -1;

        /* renamed from: f  reason: collision with root package name */
        private View f8239f;

        /* renamed from: g  reason: collision with root package name */
        public TabLayout f8240g;

        /* renamed from: h  reason: collision with root package name */
        public h f8241h;

        public View c() {
            return this.f8239f;
        }

        public Drawable d() {
            return this.f8235b;
        }

        public int e() {
            return this.f8238e;
        }

        public CharSequence f() {
            return this.f8236c;
        }

        public boolean g() {
            TabLayout tabLayout = this.f8240g;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.f8238e;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void h() {
            this.f8240g = null;
            this.f8241h = null;
            this.a = null;
            this.f8235b = null;
            this.f8236c = null;
            this.f8237d = null;
            this.f8238e = -1;
            this.f8239f = null;
        }

        public void i() {
            TabLayout tabLayout = this.f8240g;
            if (tabLayout != null) {
                tabLayout.C(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public f j(CharSequence charSequence) {
            this.f8237d = charSequence;
            p();
            return this;
        }

        public f k(int i2) {
            return l(LayoutInflater.from(this.f8241h.getContext()).inflate(i2, (ViewGroup) this.f8241h, false));
        }

        public f l(View view) {
            this.f8239f = view;
            p();
            return this;
        }

        public f m(Drawable drawable) {
            this.f8235b = drawable;
            p();
            return this;
        }

        void n(int i2) {
            this.f8238e = i2;
        }

        public f o(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f8237d) && !TextUtils.isEmpty(charSequence)) {
                this.f8241h.setContentDescription(charSequence);
            }
            this.f8236c = charSequence;
            p();
            return this;
        }

        void p() {
            h hVar = this.f8241h;
            if (hVar != null) {
                hVar.i();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class g implements ViewPager.j {
        private final WeakReference<TabLayout> a;

        /* renamed from: b  reason: collision with root package name */
        private int f8242b;

        /* renamed from: c  reason: collision with root package name */
        private int f8243c;

        public g(TabLayout tabLayout) {
            this.a = new WeakReference<>(tabLayout);
        }

        void a() {
            this.f8243c = 0;
            this.f8242b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i2) {
            this.f8242b = this.f8243c;
            this.f8243c = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null) {
                int i4 = this.f8243c;
                boolean z = false;
                boolean z2 = i4 != 2 || this.f8242b == 1;
                if (i4 != 2 || this.f8242b != 0) {
                    z = true;
                }
                tabLayout.G(i2, f2, z2, z);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i2) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i2 || i2 >= tabLayout.getTabCount()) {
                return;
            }
            int i3 = this.f8243c;
            tabLayout.D(tabLayout.v(i2), i3 == 0 || (i3 == 2 && this.f8242b == 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h extends LinearLayout {
        private f a;

        /* renamed from: b  reason: collision with root package name */
        private TextView f8244b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f8245c;

        /* renamed from: d  reason: collision with root package name */
        private View f8246d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f8247e;

        /* renamed from: f  reason: collision with root package name */
        private ImageView f8248f;

        /* renamed from: g  reason: collision with root package name */
        private Drawable f8249g;

        /* renamed from: h  reason: collision with root package name */
        private int f8250h;

        public h(Context context) {
            super(context);
            this.f8250h = 2;
            j(context);
            v.x0(this, TabLayout.this.f8214f, TabLayout.this.f8215g, TabLayout.this.f8216h, TabLayout.this.f8217j);
            setGravity(17);
            setOrientation(!TabLayout.this.F ? 1 : 0);
            setClickable(true);
            v.y0(this, t.b(getContext(), RNCWebViewManager.COMMAND_CLEAR_HISTORY));
        }

        private float d(Layout layout, int i2, float f2) {
            return layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(Canvas canvas) {
            Drawable drawable = this.f8249g;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f8249g.draw(canvas);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int f() {
            View[] viewArr = {this.f8244b, this.f8245c, this.f8246d};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getLeft()) : view.getLeft();
                    i2 = z ? Math.max(i2, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i2 - i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARN: Type inference failed for: r2v3, types: [android.graphics.drawable.LayerDrawable] */
        public void j(Context context) {
            int i2 = TabLayout.this.v;
            if (i2 != 0) {
                Drawable d2 = c.a.k.a.a.d(context, i2);
                this.f8249g = d2;
                if (d2 != null && d2.isStateful()) {
                    this.f8249g.setState(getDrawableState());
                }
            } else {
                this.f8249g = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (TabLayout.this.n != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList a = e.g.a.f.r.a.a(TabLayout.this.n);
                if (Build.VERSION.SDK_INT >= 21) {
                    boolean z = TabLayout.this.H;
                    if (z) {
                        gradientDrawable = null;
                    }
                    gradientDrawable = new RippleDrawable(a, gradientDrawable, z ? null : gradientDrawable2);
                } else {
                    Drawable r = androidx.core.graphics.drawable.a.r(gradientDrawable2);
                    androidx.core.graphics.drawable.a.o(r, a);
                    gradientDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, r});
                }
            }
            v.m0(this, gradientDrawable);
            TabLayout.this.invalidate();
        }

        private void l(TextView textView, ImageView imageView) {
            f fVar = this.a;
            Drawable mutate = (fVar == null || fVar.d() == null) ? null : androidx.core.graphics.drawable.a.r(this.a.d()).mutate();
            f fVar2 = this.a;
            CharSequence f2 = fVar2 != null ? fVar2.f() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(f2);
            if (textView != null) {
                if (z) {
                    textView.setText(f2);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int t = (z && imageView.getVisibility() == 0) ? TabLayout.this.t(8) : 0;
                if (TabLayout.this.F) {
                    if (t != c.h.k.g.a(marginLayoutParams)) {
                        c.h.k.g.c(marginLayoutParams, t);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (t != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = t;
                    c.h.k.g.c(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            f fVar3 = this.a;
            u0.a(this, z ? null : fVar3 != null ? fVar3.f8237d : null);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f8249g;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.f8249g.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        void g() {
            h(null);
            setSelected(false);
        }

        void h(f fVar) {
            if (fVar != this.a) {
                this.a = fVar;
                i();
            }
        }

        final void i() {
            f fVar = this.a;
            Drawable drawable = null;
            View c2 = fVar != null ? fVar.c() : null;
            if (c2 != null) {
                ViewParent parent = c2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(c2);
                    }
                    addView(c2);
                }
                this.f8246d = c2;
                TextView textView = this.f8244b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f8245c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f8245c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) c2.findViewById(16908308);
                this.f8247e = textView2;
                if (textView2 != null) {
                    this.f8250h = androidx.core.widget.i.d(textView2);
                }
                this.f8248f = (ImageView) c2.findViewById(16908294);
            } else {
                View view = this.f8246d;
                if (view != null) {
                    removeView(view);
                    this.f8246d = null;
                }
                this.f8247e = null;
                this.f8248f = null;
            }
            boolean z = false;
            if (this.f8246d == null) {
                if (this.f8245c == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(e.g.a.f.h.f13266c, (ViewGroup) this, false);
                    addView(imageView2, 0);
                    this.f8245c = imageView2;
                }
                if (fVar != null && fVar.d() != null) {
                    drawable = androidx.core.graphics.drawable.a.r(fVar.d()).mutate();
                }
                if (drawable != null) {
                    androidx.core.graphics.drawable.a.o(drawable, TabLayout.this.m);
                    PorterDuff.Mode mode = TabLayout.this.q;
                    if (mode != null) {
                        androidx.core.graphics.drawable.a.p(drawable, mode);
                    }
                }
                if (this.f8244b == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(e.g.a.f.h.f13267d, (ViewGroup) this, false);
                    addView(textView3);
                    this.f8244b = textView3;
                    this.f8250h = androidx.core.widget.i.d(textView3);
                }
                androidx.core.widget.i.q(this.f8244b, TabLayout.this.f8218k);
                ColorStateList colorStateList = TabLayout.this.f8219l;
                if (colorStateList != null) {
                    this.f8244b.setTextColor(colorStateList);
                }
                l(this.f8244b, this.f8245c);
            } else {
                TextView textView4 = this.f8247e;
                if (textView4 != null || this.f8248f != null) {
                    l(textView4, this.f8248f);
                }
            }
            if (fVar != null && !TextUtils.isEmpty(fVar.f8237d)) {
                setContentDescription(fVar.f8237d);
            }
            if (fVar != null && fVar.g()) {
                z = true;
            }
            setSelected(z);
        }

        final void k() {
            setOrientation(!TabLayout.this.F ? 1 : 0);
            TextView textView = this.f8247e;
            if (textView == null && this.f8248f == null) {
                l(this.f8244b, this.f8245c);
            } else {
                l(textView, this.f8248f);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(a.c.class.getName());
        }

        @Override // android.view.View
        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(a.c.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.w, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.f8244b != null) {
                float f2 = TabLayout.this.t;
                int i4 = this.f8250h;
                ImageView imageView = this.f8245c;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f8244b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.u;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.f8244b.getTextSize();
                int lineCount = this.f8244b.getLineCount();
                int d2 = androidx.core.widget.i.d(this.f8244b);
                int i5 = (f2 > textSize ? 1 : (f2 == textSize ? 0 : -1));
                if (i5 != 0 || (d2 >= 0 && i4 != d2)) {
                    if (TabLayout.this.E == 1 && i5 > 0 && lineCount == 1 && ((layout = this.f8244b.getLayout()) == null || d(layout, 0, f2) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.f8244b.setTextSize(0, f2);
                        this.f8244b.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.a != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.a.i();
                return true;
            }
            return performClick;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f8244b;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f8245c;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f8246d;
            if (view != null) {
                view.setSelected(z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class i implements c {
        private final ViewPager a;

        public i(ViewPager viewPager) {
            this.a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(f fVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(f fVar) {
            this.a.setCurrentItem(fVar.e());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(f fVar) {
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.g.a.f.b.f13237l);
    }

    private void B(int i2) {
        h hVar = (h) this.f8213e.getChildAt(i2);
        this.f8213e.removeViewAt(i2);
        if (hVar != null) {
            hVar.g();
            this.S.release(hVar);
        }
        requestLayout();
    }

    private void I(ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.M;
        if (viewPager2 != null) {
            g gVar = this.P;
            if (gVar != null) {
                viewPager2.removeOnPageChangeListener(gVar);
            }
            b bVar = this.Q;
            if (bVar != null) {
                this.M.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.K;
        if (cVar != null) {
            A(cVar);
            this.K = null;
        }
        if (viewPager != null) {
            this.M = viewPager;
            if (this.P == null) {
                this.P = new g(this);
            }
            this.P.a();
            viewPager.addOnPageChangeListener(this.P);
            i iVar = new i(viewPager);
            this.K = iVar;
            b(iVar);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                E(adapter, z);
            }
            if (this.Q == null) {
                this.Q = new b();
            }
            this.Q.b(z);
            viewPager.addOnAdapterChangeListener(this.Q);
            F(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.M = null;
            E(null, false);
        }
        this.R = z2;
    }

    private void J() {
        int size = this.f8210b.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f8210b.get(i2).p();
        }
    }

    private void K(LinearLayout.LayoutParams layoutParams) {
        if (this.E == 1 && this.B == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private void f(com.google.android.material.tabs.a aVar) {
        f w = w();
        CharSequence charSequence = aVar.a;
        if (charSequence != null) {
            w.o(charSequence);
        }
        Drawable drawable = aVar.f8252b;
        if (drawable != null) {
            w.m(drawable);
        }
        int i2 = aVar.f8253c;
        if (i2 != 0) {
            w.k(i2);
        }
        if (!TextUtils.isEmpty(aVar.getContentDescription())) {
            w.j(aVar.getContentDescription());
        }
        c(w);
    }

    private void g(f fVar) {
        this.f8213e.addView(fVar.f8241h, fVar.e(), n());
    }

    private int getDefaultHeight() {
        int size = this.f8210b.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                f fVar = this.f8210b.get(i2);
                if (fVar != null && fVar.d() != null && !TextUtils.isEmpty(fVar.f())) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z || this.F) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.x;
        if (i2 != -1) {
            return i2;
        }
        if (this.E == 0) {
            return this.z;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f8213e.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void h(View view) {
        if (view instanceof com.google.android.material.tabs.a) {
            f((com.google.android.material.tabs.a) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void i(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() != null && v.S(this) && !this.f8213e.c()) {
            int scrollX = getScrollX();
            int k2 = k(i2, 0.0f);
            if (scrollX != k2) {
                u();
                this.L.setIntValues(scrollX, k2);
                this.L.start();
            }
            this.f8213e.a(i2, this.C);
            return;
        }
        F(i2, 0.0f, true);
    }

    private void j() {
        v.x0(this.f8213e, this.E == 0 ? Math.max(0, this.A - this.f8214f) : 0, 0, 0, 0);
        int i2 = this.E;
        if (i2 == 0) {
            this.f8213e.setGravity(8388611);
        } else if (i2 == 1) {
            this.f8213e.setGravity(1);
        }
        L(true);
    }

    private int k(int i2, float f2) {
        if (this.E == 0) {
            View childAt = this.f8213e.getChildAt(i2);
            int i3 = i2 + 1;
            View childAt2 = i3 < this.f8213e.getChildCount() ? this.f8213e.getChildAt(i3) : null;
            int width = childAt != null ? childAt.getWidth() : 0;
            int width2 = childAt2 != null ? childAt2.getWidth() : 0;
            int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
            int i4 = (int) ((width + width2) * 0.5f * f2);
            return v.y(this) == 0 ? left + i4 : left - i4;
        }
        return 0;
    }

    private void l(f fVar, int i2) {
        fVar.n(i2);
        this.f8210b.add(i2, fVar);
        int size = this.f8210b.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            }
            this.f8210b.get(i2).n(i2);
        }
    }

    private static ColorStateList m(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private LinearLayout.LayoutParams n() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        K(layoutParams);
        return layoutParams;
    }

    private h p(f fVar) {
        androidx.core.util.f<h> fVar2 = this.S;
        h acquire = fVar2 != null ? fVar2.acquire() : null;
        if (acquire == null) {
            acquire = new h(getContext());
        }
        acquire.h(fVar);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(fVar.f8237d)) {
            acquire.setContentDescription(fVar.f8236c);
        } else {
            acquire.setContentDescription(fVar.f8237d);
        }
        return acquire;
    }

    private void q(f fVar) {
        for (int size = this.J.size() - 1; size >= 0; size--) {
            this.J.get(size).onTabReselected(fVar);
        }
    }

    private void r(f fVar) {
        for (int size = this.J.size() - 1; size >= 0; size--) {
            this.J.get(size).onTabSelected(fVar);
        }
    }

    private void s(f fVar) {
        for (int size = this.J.size() - 1; size >= 0; size--) {
            this.J.get(size).onTabUnselected(fVar);
        }
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.f8213e.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f8213e.getChildAt(i3);
                boolean z = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z = false;
                }
                childAt.setActivated(z);
                i3++;
            }
        }
    }

    private void u() {
        if (this.L == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.L = valueAnimator;
            valueAnimator.setInterpolator(e.g.a.f.l.a.f13292b);
            this.L.setDuration(this.C);
            this.L.addUpdateListener(new a());
        }
    }

    public void A(c cVar) {
        this.J.remove(cVar);
    }

    void C(f fVar) {
        D(fVar, true);
    }

    void D(f fVar, boolean z) {
        f fVar2 = this.f8211c;
        if (fVar2 == fVar) {
            if (fVar2 != null) {
                q(fVar);
                i(fVar.e());
                return;
            }
            return;
        }
        int e2 = fVar != null ? fVar.e() : -1;
        if (z) {
            if ((fVar2 == null || fVar2.e() == -1) && e2 != -1) {
                F(e2, 0.0f, true);
            } else {
                i(e2);
            }
            if (e2 != -1) {
                setSelectedTabView(e2);
            }
        }
        this.f8211c = fVar;
        if (fVar2 != null) {
            s(fVar2);
        }
        if (fVar != null) {
            r(fVar);
        }
    }

    void E(androidx.viewpager.widget.a aVar, boolean z) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.N;
        if (aVar2 != null && (dataSetObserver = this.O) != null) {
            aVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.N = aVar;
        if (z && aVar != null) {
            if (this.O == null) {
                this.O = new d();
            }
            aVar.registerDataSetObserver(this.O);
        }
        x();
    }

    public void F(int i2, float f2, boolean z) {
        G(i2, f2, z, true);
    }

    void G(int i2, float f2, boolean z, boolean z2) {
        int round = Math.round(i2 + f2);
        if (round < 0 || round >= this.f8213e.getChildCount()) {
            return;
        }
        if (z2) {
            this.f8213e.e(i2, f2);
        }
        ValueAnimator valueAnimator = this.L;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.L.cancel();
        }
        scrollTo(k(i2, f2), 0);
        if (z) {
            setSelectedTabView(round);
        }
    }

    public void H(ViewPager viewPager, boolean z) {
        I(viewPager, z, false);
    }

    void L(boolean z) {
        for (int i2 = 0; i2 < this.f8213e.getChildCount(); i2++) {
            View childAt = this.f8213e.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            K((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        h(view);
    }

    public void b(c cVar) {
        if (this.J.contains(cVar)) {
            return;
        }
        this.J.add(cVar);
    }

    public void c(f fVar) {
        e(fVar, this.f8210b.isEmpty());
    }

    public void d(f fVar, int i2, boolean z) {
        if (fVar.f8240g == this) {
            l(fVar, i2);
            g(fVar);
            if (z) {
                fVar.i();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void e(f fVar, boolean z) {
        d(fVar, this.f8210b.size(), z);
    }

    public int getSelectedTabPosition() {
        f fVar = this.f8211c;
        if (fVar != null) {
            return fVar.e();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f8210b.size();
    }

    public int getTabGravity() {
        return this.B;
    }

    public ColorStateList getTabIconTint() {
        return this.m;
    }

    public int getTabIndicatorGravity() {
        return this.D;
    }

    int getTabMaxWidth() {
        return this.w;
    }

    public int getTabMode() {
        return this.E;
    }

    public ColorStateList getTabRippleColor() {
        return this.n;
    }

    public Drawable getTabSelectedIndicator() {
        return this.p;
    }

    public ColorStateList getTabTextColors() {
        return this.f8219l;
    }

    protected f o() {
        f acquire = a.acquire();
        return acquire == null ? new f() : acquire;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.M == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                I((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.R) {
            setupWithViewPager(null);
            this.R = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.f8213e.getChildCount(); i2++) {
            View childAt = this.f8213e.getChildAt(i2);
            if (childAt instanceof h) {
                ((h) childAt).e(canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
        if (r1.getMeasuredWidth() != getMeasuredWidth()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
        if (r1.getMeasuredWidth() < getMeasuredWidth()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
        r6 = r0;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.getDefaultHeight()
            int r0 = r5.t(r0)
            int r1 = r5.getPaddingTop()
            int r0 = r0 + r1
            int r1 = r5.getPaddingBottom()
            int r0 = r0 + r1
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r1 == r2) goto L24
            if (r1 == 0) goto L1f
            goto L30
        L1f:
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L30
        L24:
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            int r7 = java.lang.Math.min(r0, r7)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3)
        L30:
            int r0 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r6)
            if (r1 == 0) goto L49
            int r1 = r5.y
            if (r1 <= 0) goto L3f
            goto L47
        L3f:
            r1 = 56
            int r1 = r5.t(r1)
            int r1 = r0 - r1
        L47:
            r5.w = r1
        L49:
            super.onMeasure(r6, r7)
            int r6 = r5.getChildCount()
            r0 = 1
            if (r6 != r0) goto L97
            r6 = 0
            android.view.View r1 = r5.getChildAt(r6)
            int r2 = r5.E
            if (r2 == 0) goto L6a
            if (r2 == r0) goto L5f
            goto L77
        L5f:
            int r2 = r1.getMeasuredWidth()
            int r4 = r5.getMeasuredWidth()
            if (r2 == r4) goto L75
            goto L76
        L6a:
            int r2 = r1.getMeasuredWidth()
            int r4 = r5.getMeasuredWidth()
            if (r2 >= r4) goto L75
            goto L76
        L75:
            r0 = r6
        L76:
            r6 = r0
        L77:
            if (r6 == 0) goto L97
            int r6 = r5.getPaddingTop()
            int r0 = r5.getPaddingBottom()
            int r6 = r6 + r0
            android.view.ViewGroup$LayoutParams r0 = r1.getLayoutParams()
            int r0 = r0.height
            int r6 = android.widget.HorizontalScrollView.getChildMeasureSpec(r7, r6, r0)
            int r7 = r5.getMeasuredWidth()
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3)
            r1.measure(r7, r6)
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    public void setInlineLabel(boolean z) {
        if (this.F != z) {
            this.F = z;
            for (int i2 = 0; i2 < this.f8213e.getChildCount(); i2++) {
                View childAt = this.f8213e.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).k();
                }
            }
            j();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.I;
        if (cVar2 != null) {
            A(cVar2);
        }
        this.I = cVar;
        if (cVar != null) {
            b(cVar);
        }
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        u();
        this.L.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.p != drawable) {
            this.p = drawable;
            v.b0(this.f8213e);
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.f8213e.f(i2);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.D != i2) {
            this.D = i2;
            v.b0(this.f8213e);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.f8213e.g(i2);
    }

    public void setTabGravity(int i2) {
        if (this.B != i2) {
            this.B = i2;
            j();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            J();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(c.a.k.a.a.c(getContext(), i2));
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.G = z;
        v.b0(this.f8213e);
    }

    public void setTabMode(int i2) {
        if (i2 != this.E) {
            this.E = i2;
            j();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            for (int i2 = 0; i2 < this.f8213e.getChildCount(); i2++) {
                View childAt = this.f8213e.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).j(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(c.a.k.a.a.c(getContext(), i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f8219l != colorStateList) {
            this.f8219l = colorStateList;
            J();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        E(aVar, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.H != z) {
            this.H = z;
            for (int i2 = 0; i2 < this.f8213e.getChildCount(); i2++) {
                View childAt = this.f8213e.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).j(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        H(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    int t(int i2) {
        return Math.round(getResources().getDisplayMetrics().density * i2);
    }

    public f v(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.f8210b.get(i2);
    }

    public f w() {
        f o = o();
        o.f8240g = this;
        o.f8241h = p(o);
        return o;
    }

    void x() {
        int currentItem;
        z();
        androidx.viewpager.widget.a aVar = this.N;
        if (aVar != null) {
            int count = aVar.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                e(w().o(this.N.getPageTitle(i2)), false);
            }
            ViewPager viewPager = this.M;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            C(v(currentItem));
        }
    }

    protected boolean y(f fVar) {
        return a.release(fVar);
    }

    public void z() {
        for (int childCount = this.f8213e.getChildCount() - 1; childCount >= 0; childCount--) {
            B(childCount);
        }
        Iterator<f> it = this.f8210b.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.h();
            y(next);
        }
        this.f8211c = null;
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8210b = new ArrayList<>();
        this.f8212d = new RectF();
        this.w = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.J = new ArrayList<>();
        this.S = new Pools$SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        e eVar = new e(context);
        this.f8213e = eVar;
        super.addView(eVar, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = k.t1;
        int i3 = j.f13277h;
        int i4 = k.Q1;
        TypedArray h2 = com.google.android.material.internal.h.h(context, attributeSet, iArr, i2, i3, i4);
        eVar.g(h2.getDimensionPixelSize(k.E1, -1));
        eVar.f(h2.getColor(k.B1, 0));
        setSelectedTabIndicator(e.g.a.f.q.a.b(context, h2, k.z1));
        setSelectedTabIndicatorGravity(h2.getInt(k.D1, 0));
        setTabIndicatorFullWidth(h2.getBoolean(k.C1, true));
        int dimensionPixelSize = h2.getDimensionPixelSize(k.J1, 0);
        this.f8217j = dimensionPixelSize;
        this.f8216h = dimensionPixelSize;
        this.f8215g = dimensionPixelSize;
        this.f8214f = dimensionPixelSize;
        this.f8214f = h2.getDimensionPixelSize(k.M1, dimensionPixelSize);
        this.f8215g = h2.getDimensionPixelSize(k.N1, this.f8215g);
        this.f8216h = h2.getDimensionPixelSize(k.L1, this.f8216h);
        this.f8217j = h2.getDimensionPixelSize(k.K1, this.f8217j);
        int resourceId = h2.getResourceId(i4, j.f13272c);
        this.f8218k = resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId, c.a.j.X2);
        try {
            this.t = obtainStyledAttributes.getDimensionPixelSize(c.a.j.Y2, 0);
            this.f8219l = e.g.a.f.q.a.a(context, obtainStyledAttributes, c.a.j.b3);
            obtainStyledAttributes.recycle();
            int i5 = k.R1;
            if (h2.hasValue(i5)) {
                this.f8219l = e.g.a.f.q.a.a(context, h2, i5);
            }
            int i6 = k.P1;
            if (h2.hasValue(i6)) {
                this.f8219l = m(this.f8219l.getDefaultColor(), h2.getColor(i6, 0));
            }
            this.m = e.g.a.f.q.a.a(context, h2, k.x1);
            this.q = com.google.android.material.internal.i.b(h2.getInt(k.y1, -1), null);
            this.n = e.g.a.f.q.a.a(context, h2, k.O1);
            this.C = h2.getInt(k.A1, HttpStatus.SC_MULTIPLE_CHOICES);
            this.x = h2.getDimensionPixelSize(k.H1, -1);
            this.y = h2.getDimensionPixelSize(k.G1, -1);
            this.v = h2.getResourceId(k.u1, 0);
            this.A = h2.getDimensionPixelSize(k.v1, 0);
            this.E = h2.getInt(k.I1, 1);
            this.B = h2.getInt(k.w1, 0);
            this.F = h2.getBoolean(k.F1, false);
            this.H = h2.getBoolean(k.S1, false);
            h2.recycle();
            Resources resources = getResources();
            this.u = resources.getDimensionPixelSize(e.g.a.f.d.p);
            this.z = resources.getDimensionPixelSize(e.g.a.f.d.o);
            j();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        h(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        h(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        h(view);
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(c.a.k.a.a.d(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}