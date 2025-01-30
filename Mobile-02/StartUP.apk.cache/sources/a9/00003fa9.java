package com.swmansion.gesturehandler.react;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.o;

/* loaded from: classes2.dex */
public class RNGestureHandlerButtonViewManager extends ViewGroupManager<a> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends ViewGroup {
        static TypedValue a = new TypedValue();

        /* renamed from: b  reason: collision with root package name */
        static a f10895b;

        /* renamed from: c  reason: collision with root package name */
        int f10896c;

        /* renamed from: d  reason: collision with root package name */
        Integer f10897d;

        /* renamed from: e  reason: collision with root package name */
        Integer f10898e;

        /* renamed from: f  reason: collision with root package name */
        boolean f10899f;

        /* renamed from: g  reason: collision with root package name */
        boolean f10900g;

        /* renamed from: h  reason: collision with root package name */
        float f10901h;

        /* renamed from: j  reason: collision with root package name */
        boolean f10902j;

        public a(Context context) {
            super(context);
            this.f10896c = 0;
            this.f10899f = false;
            this.f10900g = false;
            this.f10901h = 0.0f;
            this.f10902j = false;
            setClickable(true);
            setFocusable(true);
            this.f10902j = true;
        }

        private Drawable b(Drawable drawable) {
            Integer num;
            Integer num2 = this.f10897d;
            if (num2 != null && Build.VERSION.SDK_INT >= 21 && (drawable instanceof RippleDrawable)) {
                ((RippleDrawable) drawable).setColor(new ColorStateList(new int[][]{new int[]{16842910}}, new int[]{num2.intValue()}));
            }
            if (Build.VERSION.SDK_INT >= 23 && (num = this.f10898e) != null && (drawable instanceof RippleDrawable)) {
                ((RippleDrawable) drawable).setRadius((int) o.c(num.intValue()));
            }
            return drawable;
        }

        private Drawable c() {
            int i2 = Build.VERSION.SDK_INT;
            getContext().getTheme().resolveAttribute(d(getContext(), (!this.f10900g || i2 < 21) ? "selectableItemBackground" : "selectableItemBackgroundBorderless"), a, true);
            if (i2 >= 21) {
                return getResources().getDrawable(a.resourceId, getContext().getTheme());
            }
            return getResources().getDrawable(a.resourceId);
        }

        @TargetApi(21)
        private static int d(Context context, String str) {
            SoftAssertions.assertNotNull(str);
            if ("selectableItemBackground".equals(str)) {
                return 16843534;
            }
            if ("selectableItemBackgroundBorderless".equals(str)) {
                return 16843868;
            }
            return context.getResources().getIdentifier(str, "attr", "android");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j() {
            if (this.f10902j) {
                this.f10902j = false;
                if (this.f10896c == 0) {
                    setBackground(null);
                }
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 23) {
                    setForeground(null);
                }
                if (this.f10899f && i2 >= 23) {
                    setForeground(b(c()));
                    int i3 = this.f10896c;
                    if (i3 != 0) {
                        setBackgroundColor(i3);
                    }
                } else if (this.f10896c == 0 && this.f10897d == null) {
                    setBackground(c());
                } else {
                    PaintDrawable paintDrawable = new PaintDrawable(this.f10896c);
                    Drawable c2 = c();
                    float f2 = this.f10901h;
                    if (f2 != 0.0f) {
                        paintDrawable.setCornerRadius(f2);
                        if (i2 >= 21 && (c2 instanceof RippleDrawable)) {
                            PaintDrawable paintDrawable2 = new PaintDrawable(-1);
                            paintDrawable2.setCornerRadius(this.f10901h);
                            ((RippleDrawable) c2).setDrawableByLayerId(16908334, paintDrawable2);
                        }
                    }
                    b(c2);
                    setBackground(new LayerDrawable(new Drawable[]{paintDrawable, c2}));
                }
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDrawableHotspotChanged(float f2, float f3) {
        }

        @Override // android.view.View
        public void drawableHotspotChanged(float f2, float f3) {
            a aVar = f10895b;
            if (aVar == null || aVar == this) {
                super.drawableHotspotChanged(f2, f3);
            }
        }

        public void e(float f2) {
            this.f10901h = f2 * getResources().getDisplayMetrics().density;
            this.f10902j = true;
        }

        public void f(Integer num) {
            this.f10897d = num;
            this.f10902j = true;
        }

        public void g(Integer num) {
            this.f10898e = num;
            this.f10902j = true;
        }

        public void h(boolean z) {
            this.f10900g = z;
        }

        public void i(boolean z) {
            this.f10899f = z;
            this.f10902j = true;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                return true;
            }
            onTouchEvent(motionEvent);
            return isPressed();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        @Override // android.view.View
        public void setBackgroundColor(int i2) {
            this.f10896c = i2;
            this.f10902j = true;
        }

        @Override // android.view.View
        public void setPressed(boolean z) {
            if (z && f10895b == null) {
                f10895b = this;
            }
            if (!z || f10895b == this) {
                super.setPressed(z);
            }
            if (z || f10895b != this) {
                return;
            }
            f10895b = null;
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNGestureHandlerButton";
    }

    @com.facebook.react.uimanager.c1.a(name = "borderless")
    public void setBorderless(a aVar, boolean z) {
        aVar.h(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "enabled")
    public void setEnabled(a aVar, boolean z) {
        aVar.setEnabled(z);
    }

    @TargetApi(23)
    @com.facebook.react.uimanager.c1.a(name = "foreground")
    public void setForeground(a aVar, boolean z) {
        aVar.i(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "rippleColor")
    public void setRippleColor(a aVar, Integer num) {
        aVar.f(num);
    }

    @com.facebook.react.uimanager.c1.a(name = "rippleRadius")
    public void setRippleRadius(a aVar, Integer num) {
        aVar.g(num);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public a createViewInstance(i0 i0Var) {
        return new a(i0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(a aVar) {
        aVar.j();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(name = "borderRadius")
    public void setBorderRadius(a aVar, float f2) {
        aVar.e(f2);
    }
}