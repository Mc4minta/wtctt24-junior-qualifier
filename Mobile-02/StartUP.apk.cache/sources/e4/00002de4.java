package com.facebook.react.devsupport;

import com.facebook.fbreact.specs.NativeJSCHeapCaptureSpec;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import java.io.File;

@e.f.m.x.a.a(name = JSCHeapCapture.TAG, needsEagerInit = true)
/* loaded from: classes2.dex */
public class JSCHeapCapture extends NativeJSCHeapCaptureSpec {
    public static final String TAG = "JSCHeapCapture";
    private a mCaptureInProgress;

    /* loaded from: classes2.dex */
    public static class CaptureException extends Exception {
        /* JADX INFO: Access modifiers changed from: package-private */
        public CaptureException(String str) {
            super(str);
        }
    }

    /* loaded from: classes2.dex */
    public interface HeapCapture extends JavaScriptModule {
        void captureHeap(String str);
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a(File file);

        void b(CaptureException captureException);
    }

    public JSCHeapCapture(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mCaptureInProgress = null;
    }

    @Override // com.facebook.fbreact.specs.NativeJSCHeapCaptureSpec
    public synchronized void captureComplete(String str, String str2) {
        a aVar = this.mCaptureInProgress;
        if (aVar != null) {
            if (str2 == null) {
                aVar.a(new File(str));
            } else {
                aVar.b(new CaptureException(str2));
            }
            this.mCaptureInProgress = null;
        }
    }

    public synchronized void captureHeap(String str, a aVar) {
        if (this.mCaptureInProgress != null) {
            aVar.b(new CaptureException("Heap capture already in progress."));
            return;
        }
        File file = new File(str + "/capture.json");
        file.delete();
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            HeapCapture heapCapture = (HeapCapture) reactApplicationContextIfActiveOrWarn.getJSModule(HeapCapture.class);
            if (heapCapture == null) {
                aVar.b(new CaptureException("Heap capture js module not registered."));
            } else {
                this.mCaptureInProgress = aVar;
                heapCapture.captureHeap(file.getPath());
            }
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }
}