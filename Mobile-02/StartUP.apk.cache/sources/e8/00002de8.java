package com.facebook.react.devsupport;

import android.view.View;
import com.facebook.fbreact.specs.NativeJSDevSupportSpec;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.JSCHeapCapture;
import java.util.HashMap;
import java.util.Map;

@e.f.m.x.a.a(name = JSDevSupport.MODULE_NAME)
/* loaded from: classes2.dex */
public class JSDevSupport extends NativeJSDevSupportSpec {
    public static final int ERROR_CODE_EXCEPTION = 0;
    public static final int ERROR_CODE_VIEW_NOT_FOUND = 1;
    public static final String MODULE_NAME = "JSDevSupport";
    private volatile a mCurrentCallback;

    /* loaded from: classes2.dex */
    public interface JSDevSupportModule extends JavaScriptModule {
        void getJSHierarchy(int i2);
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i2, Exception exc);

        void b(String str);
    }

    public JSDevSupport(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mCurrentCallback = null;
    }

    public synchronized void computeDeepestJSHierarchy(View view, a aVar) {
        getJSHierarchy(Integer.valueOf(((View) f.a(view).first).getId()).intValue(), aVar);
    }

    public synchronized void getJSHierarchy(int i2, a aVar) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        JSDevSupportModule jSDevSupportModule = reactApplicationContextIfActiveOrWarn != null ? (JSDevSupportModule) reactApplicationContextIfActiveOrWarn.getJSModule(JSDevSupportModule.class) : null;
        if (jSDevSupportModule == null) {
            aVar.a(0, new JSCHeapCapture.CaptureException("JSDevSupport module not registered."));
            return;
        }
        this.mCurrentCallback = aVar;
        jSDevSupportModule.getJSHierarchy(i2);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return MODULE_NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeJSDevSupportSpec
    public Map<String, Object> getTypedExportedConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("ERROR_CODE_EXCEPTION", 0);
        hashMap.put("ERROR_CODE_VIEW_NOT_FOUND", 1);
        return hashMap;
    }

    @Override // com.facebook.fbreact.specs.NativeJSDevSupportSpec
    public synchronized void onFailure(double d2, String str) {
        int i2 = (int) d2;
        if (this.mCurrentCallback != null) {
            this.mCurrentCallback.a(i2, new RuntimeException(str));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeJSDevSupportSpec
    public synchronized void onSuccess(String str) {
        if (this.mCurrentCallback != null) {
            this.mCurrentCallback.b(str);
        }
    }
}