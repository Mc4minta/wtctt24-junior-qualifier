package com.facebook.react.views.slider;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import c.h.k.e0.d;
import c.h.k.v;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.h;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.w0;
import com.facebook.yoga.m;
import com.facebook.yoga.n;
import com.facebook.yoga.o;
import com.facebook.yoga.p;
import e.f.m.a0.q;
import e.f.m.a0.r;
import java.util.Map;

/* loaded from: classes2.dex */
public class ReactSliderManager extends SimpleViewManager<com.facebook.react.views.slider.a> implements r<com.facebook.react.views.slider.a> {
    public static final String REACT_CLASS = "RCTSlider";
    private static final int STYLE = 16842875;
    private final w0<com.facebook.react.views.slider.a> mDelegate = new q(this);
    private static final SeekBar.OnSeekBarChangeListener ON_CHANGE_LISTENER = new a();
    protected static b sAccessibilityDelegate = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            ((UIManagerModule) ((ReactContext) seekBar.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().v(new com.facebook.react.views.slider.b(seekBar.getId(), ((com.facebook.react.views.slider.a) seekBar).b(i2), z));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            ((UIManagerModule) ((ReactContext) seekBar.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().v(new com.facebook.react.views.slider.c(seekBar.getId(), ((com.facebook.react.views.slider.a) seekBar).b(seekBar.getProgress())));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class b extends c.h.k.a {
        protected b() {
        }

        private static boolean n(int i2) {
            return i2 == d.a.m.b() || i2 == d.a.n.b() || i2 == d.a.H.b();
        }

        @Override // c.h.k.a
        public boolean j(View view, int i2, Bundle bundle) {
            if (n(i2)) {
                ReactSliderManager.ON_CHANGE_LISTENER.onStartTrackingTouch((SeekBar) view);
            }
            boolean j2 = super.j(view, i2, bundle);
            if (n(i2)) {
                ReactSliderManager.ON_CHANGE_LISTENER.onStopTrackingTouch((SeekBar) view);
            }
            return j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c extends h implements m {
        private int E;
        private int F;
        private boolean G;

        /* synthetic */ c(a aVar) {
            this();
        }

        private void o1() {
            R0(this);
        }

        @Override // com.facebook.yoga.m
        public long T(p pVar, float f2, n nVar, float f3, n nVar2) {
            if (!this.G) {
                com.facebook.react.views.slider.a aVar = new com.facebook.react.views.slider.a(F(), null, ReactSliderManager.STYLE);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
                aVar.measure(makeMeasureSpec, makeMeasureSpec);
                this.E = aVar.getMeasuredWidth();
                this.F = aVar.getMeasuredHeight();
                this.G = true;
            }
            return o.b(this.E, this.F);
        }

        private c() {
            o1();
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected w0<com.facebook.react.views.slider.a> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return com.facebook.react.common.c.d("topSlidingComplete", com.facebook.react.common.c.d("registrationName", "onSlidingComplete"));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.SimpleViewManager, com.facebook.react.uimanager.ViewManager
    public Class getShadowNodeClass() {
        return c.class;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, n nVar, float f3, n nVar2, int[] iArr) {
        com.facebook.react.views.slider.a aVar = new com.facebook.react.views.slider.a(context, null, STYLE);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
        aVar.measure(makeMeasureSpec, makeMeasureSpec);
        return o.a(com.facebook.react.uimanager.o.a(aVar.getMeasuredWidth()), com.facebook.react.uimanager.o.a(aVar.getMeasuredHeight()));
    }

    @Override // e.f.m.a0.r
    public void setDisabled(com.facebook.react.views.slider.a aVar, boolean z) {
    }

    @Override // e.f.m.a0.r
    public void setMaximumTrackImage(com.facebook.react.views.slider.a aVar, ReadableMap readableMap) {
    }

    @Override // e.f.m.a0.r
    public void setMinimumTrackImage(com.facebook.react.views.slider.a aVar, ReadableMap readableMap) {
    }

    @Override // e.f.m.a0.r
    public void setThumbImage(com.facebook.react.views.slider.a aVar, ReadableMap readableMap) {
    }

    @Override // e.f.m.a0.r
    public void setTrackImage(com.facebook.react.views.slider.a aVar, ReadableMap readableMap) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(i0 i0Var, com.facebook.react.views.slider.a aVar) {
        aVar.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
    }

    @Override // com.facebook.react.uimanager.SimpleViewManager, com.facebook.react.uimanager.ViewManager
    public h createShadowNodeInstance() {
        return new c(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public com.facebook.react.views.slider.a createViewInstance(i0 i0Var) {
        com.facebook.react.views.slider.a aVar = new com.facebook.react.views.slider.a(i0Var, null, STYLE);
        v.k0(aVar, sAccessibilityDelegate);
        return aVar;
    }

    @Override // e.f.m.a0.r
    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "enabled")
    public void setEnabled(com.facebook.react.views.slider.a aVar, boolean z) {
        aVar.setEnabled(z);
    }

    @Override // e.f.m.a0.r
    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "maximumTrackTintColor")
    public void setMaximumTrackTintColor(com.facebook.react.views.slider.a aVar, Integer num) {
        Drawable findDrawableByLayerId = ((LayerDrawable) aVar.getProgressDrawable().getCurrent()).findDrawableByLayerId(16908288);
        if (num == null) {
            findDrawableByLayerId.clearColorFilter();
        } else {
            findDrawableByLayerId.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @Override // e.f.m.a0.r
    @com.facebook.react.uimanager.c1.a(defaultDouble = 1.0d, name = "maximumValue")
    public void setMaximumValue(com.facebook.react.views.slider.a aVar, double d2) {
        aVar.setMaxValue(d2);
    }

    @Override // e.f.m.a0.r
    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "minimumTrackTintColor")
    public void setMinimumTrackTintColor(com.facebook.react.views.slider.a aVar, Integer num) {
        Drawable findDrawableByLayerId = ((LayerDrawable) aVar.getProgressDrawable().getCurrent()).findDrawableByLayerId(16908301);
        if (num == null) {
            findDrawableByLayerId.clearColorFilter();
        } else {
            findDrawableByLayerId.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @Override // e.f.m.a0.r
    @com.facebook.react.uimanager.c1.a(defaultDouble = 0.0d, name = "minimumValue")
    public void setMinimumValue(com.facebook.react.views.slider.a aVar, double d2) {
        aVar.setMinValue(d2);
    }

    @Override // e.f.m.a0.r
    @com.facebook.react.uimanager.c1.a(defaultDouble = 0.0d, name = "step")
    public void setStep(com.facebook.react.views.slider.a aVar, double d2) {
        aVar.setStep(d2);
    }

    @Override // e.f.m.a0.r
    public void setTestID(com.facebook.react.views.slider.a aVar, String str) {
        super.setTestId(aVar, str);
    }

    @Override // e.f.m.a0.r
    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(com.facebook.react.views.slider.a aVar, Integer num) {
        if (num == null) {
            aVar.getThumb().clearColorFilter();
        } else {
            aVar.getThumb().setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @Override // e.f.m.a0.r
    @com.facebook.react.uimanager.c1.a(defaultDouble = 0.0d, name = "value")
    public void setValue(com.facebook.react.views.slider.a aVar, double d2) {
        aVar.setOnSeekBarChangeListener(null);
        aVar.setValue(d2);
        aVar.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
    }
}