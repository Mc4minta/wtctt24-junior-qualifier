package com.horcrux.svg;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;

/* loaded from: classes2.dex */
class SvgViewModule extends ReactContextBaseJavaModule {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableMap f10196b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Callback f10197c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f10198d;

        /* renamed from: com.horcrux.svg.SvgViewModule$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0212a implements Runnable {

            /* renamed from: com.horcrux.svg.SvgViewModule$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            class RunnableC0213a implements Runnable {
                RunnableC0213a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    SvgViewModule.toDataURL(aVar.a, aVar.f10196b, aVar.f10197c, aVar.f10198d + 1);
                }
            }

            RunnableC0212a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f0 svgViewByTag = SvgViewManager.getSvgViewByTag(a.this.a);
                if (svgViewByTag == null) {
                    return;
                }
                svgViewByTag.setToDataUrlTask(new RunnableC0213a());
            }
        }

        /* loaded from: classes2.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                SvgViewModule.toDataURL(aVar.a, aVar.f10196b, aVar.f10197c, aVar.f10198d + 1);
            }
        }

        a(int i2, ReadableMap readableMap, Callback callback, int i3) {
            this.a = i2;
            this.f10196b = readableMap;
            this.f10197c = callback;
            this.f10198d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            f0 svgViewByTag = SvgViewManager.getSvgViewByTag(this.a);
            if (svgViewByTag == null) {
                SvgViewManager.runWhenViewIsAvailable(this.a, new RunnableC0212a());
            } else if (svgViewByTag.O()) {
                svgViewByTag.setToDataUrlTask(new b());
            } else {
                ReadableMap readableMap = this.f10196b;
                if (readableMap != null) {
                    this.f10197c.invoke(svgViewByTag.Q(readableMap.getInt("width"), this.f10196b.getInt("height")));
                } else {
                    this.f10197c.invoke(svgViewByTag.P());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SvgViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void toDataURL(int i2, ReadableMap readableMap, Callback callback, int i3) {
        UiThreadUtil.runOnUiThread(new a(i2, readableMap, callback, i3));
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNSVGSvgViewManager";
    }

    @ReactMethod
    public void toDataURL(int i2, ReadableMap readableMap, Callback callback) {
        toDataURL(i2, readableMap, callback, 0);
    }
}