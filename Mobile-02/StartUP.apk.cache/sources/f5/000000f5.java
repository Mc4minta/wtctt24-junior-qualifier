package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbsActionBarView.java */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {
    protected final C0008a a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f738b;

    /* renamed from: c  reason: collision with root package name */
    protected ActionMenuView f739c;

    /* renamed from: d  reason: collision with root package name */
    protected c f740d;

    /* renamed from: e  reason: collision with root package name */
    protected int f741e;

    /* renamed from: f  reason: collision with root package name */
    protected c.h.k.z f742f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f743g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f744h;

    /* compiled from: AbsActionBarView.java */
    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected class C0008a implements c.h.k.a0 {
        private boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        int f745b;

        protected C0008a() {
        }

        @Override // c.h.k.a0
        public void a(View view) {
            this.a = true;
        }

        @Override // c.h.k.a0
        public void b(View view) {
            if (this.a) {
                return;
            }
            a aVar = a.this;
            aVar.f742f = null;
            a.super.setVisibility(this.f745b);
        }

        @Override // c.h.k.a0
        public void c(View view) {
            a.super.setVisibility(0);
            this.a = false;
        }

        public C0008a d(c.h.k.z zVar, int i2) {
            a.this.f742f = zVar;
            this.f745b = i2;
            return this;
        }
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int d(int i2, int i3, boolean z) {
        return z ? i2 - i3 : i2 + i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(View view, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(View view, int i2, int i3, int i4, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 + ((i4 - measuredHeight) / 2);
        if (z) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public c.h.k.z f(int i2, long j2) {
        c.h.k.z zVar = this.f742f;
        if (zVar != null) {
            zVar.b();
        }
        if (i2 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            c.h.k.z a = c.h.k.v.c(this).a(1.0f);
            a.d(j2);
            a.f(this.a.d(a, i2));
            return a;
        }
        c.h.k.z a2 = c.h.k.v.c(this).a(0.0f);
        a2.d(j2);
        a2.f(this.a.d(a2, i2));
        return a2;
    }

    public int getAnimatedVisibility() {
        if (this.f742f != null) {
            return this.a.f745b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f741e;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, c.a.j.a, c.a.a.f2421c, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(c.a.j.f2505j, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.f740d;
        if (cVar != null) {
            cVar.H(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f744h = false;
        }
        if (!this.f744h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f744h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f744h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f743g = false;
        }
        if (!this.f743g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f743g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f743g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i2);

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            c.h.k.z zVar = this.f742f;
            if (zVar != null) {
                zVar.b();
            }
            super.setVisibility(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new C0008a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(c.a.a.a, typedValue, true) && typedValue.resourceId != 0) {
            this.f738b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f738b = context;
        }
    }
}