package com.facebook.react.views.image;

import android.graphics.PorterDuff;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.o;
import java.util.Map;

@e.f.m.x.a.a(name = ReactImageManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ReactImageManager extends SimpleViewManager<g> {
    public static final String REACT_CLASS = "RCTImageView";
    private final Object mCallerContext;
    private final f mCallerContextFactory;
    private e.f.h.c.b mDraweeControllerBuilder;
    private a mGlobalImageLoadListener;

    @Deprecated
    public ReactImageManager(e.f.h.c.b bVar, Object obj) {
        this(bVar, (a) null, obj);
    }

    @Deprecated
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public e.f.h.c.b getDraweeControllerBuilder() {
        if (this.mDraweeControllerBuilder == null) {
            this.mDraweeControllerBuilder = e.f.h.a.a.c.h();
        }
        return this.mDraweeControllerBuilder;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return com.facebook.react.common.c.g(b.m(4), com.facebook.react.common.c.d("registrationName", "onLoadStart"), b.m(2), com.facebook.react.common.c.d("registrationName", "onLoad"), b.m(1), com.facebook.react.common.c.d("registrationName", "onError"), b.m(3), com.facebook.react.common.c.d("registrationName", "onLoadEnd"));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @com.facebook.react.uimanager.c1.a(name = "blurRadius")
    public void setBlurRadius(g gVar, float f2) {
        gVar.setBlurRadius(f2);
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "borderColor")
    public void setBorderColor(g gVar, Integer num) {
        if (num == null) {
            gVar.setBorderColor(0);
        } else {
            gVar.setBorderColor(num.intValue());
        }
    }

    @com.facebook.react.uimanager.c1.b(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(g gVar, int i2, float f2) {
        if (!com.facebook.yoga.g.a(f2)) {
            f2 = o.c(f2);
        }
        if (i2 == 0) {
            gVar.setBorderRadius(f2);
        } else {
            gVar.t(f2, i2 - 1);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "borderWidth")
    public void setBorderWidth(g gVar, float f2) {
        gVar.setBorderWidth(f2);
    }

    @com.facebook.react.uimanager.c1.a(name = "defaultSrc")
    public void setDefaultSource(g gVar, String str) {
        gVar.setDefaultSource(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "fadeDuration")
    public void setFadeDuration(g gVar, int i2) {
        gVar.setFadeDuration(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "headers")
    public void setHeaders(g gVar, ReadableMap readableMap) {
        gVar.setHeaders(readableMap);
    }

    @com.facebook.react.uimanager.c1.a(name = "internal_analyticTag")
    public void setInternal_AnalyticsTag(g gVar, String str) {
        f fVar = this.mCallerContextFactory;
        if (fVar != null) {
            gVar.w(fVar.a((i0) gVar.getContext(), str));
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "shouldNotifyLoadEvents")
    public void setLoadHandlersRegistered(g gVar, boolean z) {
        gVar.setShouldNotifyLoadEvents(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "loadingIndicatorSrc")
    public void setLoadingIndicatorSource(g gVar, String str) {
        gVar.setLoadingIndicatorSource(str);
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "overlayColor")
    public void setOverlayColor(g gVar, Integer num) {
        if (num == null) {
            gVar.setOverlayColor(0);
        } else {
            gVar.setOverlayColor(num.intValue());
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "progressiveRenderingEnabled")
    public void setProgressiveRenderingEnabled(g gVar, boolean z) {
        gVar.setProgressiveRenderingEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "resizeMethod")
    public void setResizeMethod(g gVar, String str) {
        if (str != null && !"auto".equals(str)) {
            if ("resize".equals(str)) {
                gVar.setResizeMethod(c.RESIZE);
                return;
            } else if ("scale".equals(str)) {
                gVar.setResizeMethod(c.SCALE);
                return;
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid resize method: '" + str + "'");
            }
        }
        gVar.setResizeMethod(c.AUTO);
    }

    @com.facebook.react.uimanager.c1.a(name = "resizeMode")
    public void setResizeMode(g gVar, String str) {
        gVar.setScaleType(d.c(str));
        gVar.setTileMode(d.d(str));
    }

    @com.facebook.react.uimanager.c1.a(name = "src")
    public void setSource(g gVar, ReadableArray readableArray) {
        gVar.setSource(readableArray);
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "tintColor")
    public void setTintColor(g gVar, Integer num) {
        if (num == null) {
            gVar.clearColorFilter();
        } else {
            gVar.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @Deprecated
    public ReactImageManager(e.f.h.c.b bVar, a aVar, Object obj) {
        this.mDraweeControllerBuilder = bVar;
        this.mGlobalImageLoadListener = aVar;
        this.mCallerContext = obj;
        this.mCallerContextFactory = null;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public g createViewInstance(i0 i0Var) {
        Object callerContext;
        f fVar = this.mCallerContextFactory;
        if (fVar != null) {
            callerContext = fVar.a(i0Var, null);
        } else {
            callerContext = getCallerContext();
        }
        return new g(i0Var, getDraweeControllerBuilder(), this.mGlobalImageLoadListener, callerContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(g gVar) {
        super.onAfterUpdateTransaction((ReactImageManager) gVar);
        gVar.s();
    }

    public ReactImageManager(e.f.h.c.b bVar, f fVar) {
        this(bVar, (a) null, fVar);
    }

    public ReactImageManager(e.f.h.c.b bVar, a aVar, f fVar) {
        this.mDraweeControllerBuilder = bVar;
        this.mGlobalImageLoadListener = aVar;
        this.mCallerContextFactory = fVar;
        this.mCallerContext = null;
    }

    public ReactImageManager() {
        this.mDraweeControllerBuilder = null;
        this.mCallerContext = null;
        this.mCallerContextFactory = null;
    }
}