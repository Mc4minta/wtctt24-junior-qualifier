package com.facebook.react.views.switchview;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
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
import e.f.m.a0.k;
import e.f.m.a0.l;

/* loaded from: classes2.dex */
public class ReactSwitchManager extends SimpleViewManager<com.facebook.react.views.switchview.a> implements l<com.facebook.react.views.switchview.a> {
    private static final CompoundButton.OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER = new a();
    public static final String REACT_CLASS = "AndroidSwitch";
    private final w0<com.facebook.react.views.switchview.a> mDelegate = new k(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ((UIManagerModule) ((ReactContext) compoundButton.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().v(new com.facebook.react.views.switchview.b(compoundButton.getId(), z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b extends h implements m {
        private int E;
        private int F;
        private boolean G;

        /* synthetic */ b(a aVar) {
            this();
        }

        private void o1() {
            R0(this);
        }

        @Override // com.facebook.yoga.m
        public long T(p pVar, float f2, n nVar, float f3, n nVar2) {
            if (!this.G) {
                com.facebook.react.views.switchview.a aVar = new com.facebook.react.views.switchview.a(F());
                aVar.setShowText(false);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                aVar.measure(makeMeasureSpec, makeMeasureSpec);
                this.E = aVar.getMeasuredWidth();
                this.F = aVar.getMeasuredHeight();
                this.G = true;
            }
            return o.b(this.E, this.F);
        }

        private b() {
            o1();
        }
    }

    private static void setValueInternal(com.facebook.react.views.switchview.a aVar, boolean z) {
        aVar.setOnCheckedChangeListener(null);
        aVar.n(z);
        aVar.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected w0<com.facebook.react.views.switchview.a> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.SimpleViewManager, com.facebook.react.uimanager.ViewManager
    public Class getShadowNodeClass() {
        return b.class;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, n nVar, float f3, n nVar2, int[] iArr) {
        com.facebook.react.views.switchview.a aVar = new com.facebook.react.views.switchview.a(context);
        aVar.setShowText(false);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        aVar.measure(makeMeasureSpec, makeMeasureSpec);
        return o.a(com.facebook.react.uimanager.o.a(aVar.getMeasuredWidth()), com.facebook.react.uimanager.o.a(aVar.getMeasuredHeight()));
    }

    public void setNativeValue(com.facebook.react.views.switchview.a aVar, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(i0 i0Var, com.facebook.react.views.switchview.a aVar) {
        aVar.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    @Override // com.facebook.react.uimanager.SimpleViewManager, com.facebook.react.uimanager.ViewManager
    public h createShadowNodeInstance() {
        return new b(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public com.facebook.react.views.switchview.a createViewInstance(i0 i0Var) {
        com.facebook.react.views.switchview.a aVar = new com.facebook.react.views.switchview.a(i0Var);
        aVar.setShowText(false);
        return aVar;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(com.facebook.react.views.switchview.a aVar, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativeValue")) {
            boolean z = false;
            if (readableArray != null && readableArray.getBoolean(0)) {
                z = true;
            }
            setValueInternal(aVar, z);
        }
    }

    @Override // e.f.m.a0.l
    @com.facebook.react.uimanager.c1.a(defaultBoolean = false, name = "disabled")
    public void setDisabled(com.facebook.react.views.switchview.a aVar, boolean z) {
        aVar.setEnabled(!z);
    }

    @Override // e.f.m.a0.l
    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "enabled")
    public void setEnabled(com.facebook.react.views.switchview.a aVar, boolean z) {
        aVar.setEnabled(z);
    }

    @Override // e.f.m.a0.l
    @com.facebook.react.uimanager.c1.a(name = "on")
    public void setOn(com.facebook.react.views.switchview.a aVar, boolean z) {
        setValueInternal(aVar, z);
    }

    @Override // e.f.m.a0.l
    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "thumbColor")
    public void setThumbColor(com.facebook.react.views.switchview.a aVar, Integer num) {
        aVar.o(num);
    }

    @Override // e.f.m.a0.l
    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(com.facebook.react.views.switchview.a aVar, Integer num) {
        setThumbColor(aVar, num);
    }

    @Override // e.f.m.a0.l
    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "trackColorForFalse")
    public void setTrackColorForFalse(com.facebook.react.views.switchview.a aVar, Integer num) {
        aVar.r(num);
    }

    @Override // e.f.m.a0.l
    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "trackColorForTrue")
    public void setTrackColorForTrue(com.facebook.react.views.switchview.a aVar, Integer num) {
        aVar.s(num);
    }

    @Override // e.f.m.a0.l
    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "trackTintColor")
    public void setTrackTintColor(com.facebook.react.views.switchview.a aVar, Integer num) {
        aVar.p(num);
    }

    @Override // e.f.m.a0.l
    @com.facebook.react.uimanager.c1.a(name = "value")
    public void setValue(com.facebook.react.views.switchview.a aVar, boolean z) {
        setValueInternal(aVar, z);
    }
}