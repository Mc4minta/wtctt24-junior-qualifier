package com.facebook.react.modules.blob;

import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactContext;
import com.facebook.soloader.SoLoader;

/* loaded from: classes2.dex */
class BlobCollector {

    /* loaded from: classes2.dex */
    static class a implements Runnable {
        final /* synthetic */ ReactContext a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BlobModule f4851b;

        a(ReactContext reactContext, BlobModule blobModule) {
            this.a = reactContext;
            this.f4851b = blobModule;
        }

        @Override // java.lang.Runnable
        public void run() {
            JavaScriptContextHolder javaScriptContextHolder = this.a.getJavaScriptContextHolder();
            if (javaScriptContextHolder.get() != 0) {
                BlobCollector.nativeInstall(this.f4851b, javaScriptContextHolder.get());
            }
        }
    }

    static {
        SoLoader.j("reactnativeblob");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(ReactContext reactContext, BlobModule blobModule) {
        reactContext.runOnJSQueueThread(new a(reactContext, blobModule));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeInstall(Object obj, long j2);
}