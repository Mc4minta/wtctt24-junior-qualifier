package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.h;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.h.k.v;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import e.g.a.f.f;
import e.g.a.f.j;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: BottomSheetDialog.java */
/* loaded from: classes2.dex */
public class a extends h {
    private BottomSheetBehavior<FrameLayout> a;

    /* renamed from: b  reason: collision with root package name */
    boolean f8134b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8135c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8136d;

    /* renamed from: e  reason: collision with root package name */
    private BottomSheetBehavior.c f8137e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BottomSheetDialog.java */
    /* renamed from: com.google.android.material.bottomsheet.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0149a implements View.OnClickListener {
        View$OnClickListenerC0149a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.f8134b && aVar.isShowing() && a.this.a()) {
                a.this.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BottomSheetDialog.java */
    /* loaded from: classes2.dex */
    public class b extends c.h.k.a {
        b() {
        }

        @Override // c.h.k.a
        public void g(View view, c.h.k.e0.d dVar) {
            super.g(view, dVar);
            if (a.this.f8134b) {
                dVar.a(PKIFailureInfo.badCertTemplate);
                dVar.Z(true);
                return;
            }
            dVar.Z(false);
        }

        @Override // c.h.k.a
        public boolean j(View view, int i2, Bundle bundle) {
            if (i2 == 1048576) {
                a aVar = a.this;
                if (aVar.f8134b) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.j(view, i2, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BottomSheetDialog.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: BottomSheetDialog.java */
    /* loaded from: classes2.dex */
    class d extends BottomSheetBehavior.c {
        d() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void onSlide(View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void onStateChanged(View view, int i2) {
            if (i2 == 5) {
                a.this.cancel();
            }
        }
    }

    public a(Context context, int i2) {
        super(context, getThemeResId(context, i2));
        this.f8134b = true;
        this.f8135c = true;
        this.f8137e = new d();
        supportRequestWindowFeature(1);
    }

    private View b(int i2, View view, ViewGroup.LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), e.g.a.f.h.f13265b, null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(f.a);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout2 = (FrameLayout) coordinatorLayout.findViewById(f.f13254b);
        BottomSheetBehavior<FrameLayout> I = BottomSheetBehavior.I(frameLayout2);
        this.a = I;
        I.N(this.f8137e);
        this.a.P(this.f8134b);
        if (layoutParams == null) {
            frameLayout2.addView(view);
        } else {
            frameLayout2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(f.o).setOnClickListener(new View$OnClickListenerC0149a());
        v.k0(frameLayout2, new b());
        frameLayout2.setOnTouchListener(new c());
        return frameLayout;
    }

    private static int getThemeResId(Context context, int i2) {
        if (i2 == 0) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(e.g.a.f.b.f13227b, typedValue, true)) {
                return typedValue.resourceId;
            }
            return j.f13273d;
        }
        return i2;
    }

    boolean a() {
        if (!this.f8136d) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.f8135c = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f8136d = true;
        }
        return this.f8135c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.h, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.a;
        if (bottomSheetBehavior == null || bottomSheetBehavior.K() != 5) {
            return;
        }
        this.a.S(4);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f8134b != z) {
            this.f8134b = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.a;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.P(z);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f8134b) {
            this.f8134b = true;
        }
        this.f8135c = z;
        this.f8136d = true;
    }

    @Override // androidx.appcompat.app.h, android.app.Dialog
    public void setContentView(int i2) {
        super.setContentView(b(i2, null, null));
    }

    @Override // androidx.appcompat.app.h, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(b(0, view, null));
    }

    @Override // androidx.appcompat.app.h, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(b(0, view, layoutParams));
    }
}