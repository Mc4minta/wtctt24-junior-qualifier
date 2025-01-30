package com.facebook.react.views.progressbar;

import android.content.Context;
import android.widget.ProgressBar;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.w0;
import e.f.m.a0.g;
import e.f.m.a0.h;

@e.f.m.x.a.a(name = ReactProgressBarViewManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ReactProgressBarViewManager extends BaseViewManager<a, b> implements h<a> {
    static final String DEFAULT_STYLE = "Normal";
    static final String PROP_ANIMATING = "animating";
    static final String PROP_INDETERMINATE = "indeterminate";
    static final String PROP_PROGRESS = "progress";
    static final String PROP_STYLE = "styleAttr";
    public static final String REACT_CLASS = "AndroidProgressBar";
    private static Object sProgressBarCtorLock = new Object();
    private final w0<a> mDelegate = new g(this);

    public static ProgressBar createProgressBar(Context context, int i2) {
        ProgressBar progressBar;
        synchronized (sProgressBarCtorLock) {
            progressBar = new ProgressBar(context, null, i2);
        }
        return progressBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getStyleFromString(String str) {
        if (str != null) {
            if (str.equals("Horizontal")) {
                return 16842872;
            }
            if (str.equals("Small")) {
                return 16842873;
            }
            if (str.equals("Large")) {
                return 16842874;
            }
            if (str.equals("Inverse")) {
                return 16843399;
            }
            if (str.equals("SmallInverse")) {
                return 16843400;
            }
            if (str.equals("LargeInverse")) {
                return 16843401;
            }
            if (str.equals(DEFAULT_STYLE)) {
                return 16842871;
            }
            throw new JSApplicationIllegalArgumentException("Unknown ProgressBar style: " + str);
        }
        throw new JSApplicationIllegalArgumentException("ProgressBar needs to have a style, null received");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected w0<a> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<b> getShadowNodeClass() {
        return b.class;
    }

    @Override // e.f.m.a0.h
    public void setTypeAttr(a aVar, String str) {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(a aVar, Object obj) {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public b createShadowNodeInstance() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public a createViewInstance(i0 i0Var) {
        return new a(i0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(a aVar) {
        aVar.a();
    }

    @Override // e.f.m.a0.h
    @com.facebook.react.uimanager.c1.a(name = PROP_ANIMATING)
    public void setAnimating(a aVar, boolean z) {
        aVar.b(z);
    }

    @Override // e.f.m.a0.h
    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "color")
    public void setColor(a aVar, Integer num) {
        aVar.d(num);
    }

    @Override // e.f.m.a0.h
    @com.facebook.react.uimanager.c1.a(name = PROP_INDETERMINATE)
    public void setIndeterminate(a aVar, boolean z) {
        aVar.e(z);
    }

    @Override // e.f.m.a0.h
    @com.facebook.react.uimanager.c1.a(name = PROP_PROGRESS)
    public void setProgress(a aVar, double d2) {
        aVar.f(d2);
    }

    @Override // e.f.m.a0.h
    @com.facebook.react.uimanager.c1.a(name = PROP_STYLE)
    public void setStyleAttr(a aVar, String str) {
        aVar.g(str);
    }

    @Override // e.f.m.a0.h
    public void setTestID(a aVar, String str) {
        super.setTestId(aVar, str);
    }
}