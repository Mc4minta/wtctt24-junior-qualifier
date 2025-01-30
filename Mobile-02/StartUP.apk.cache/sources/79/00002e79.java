package com.facebook.react.modules.image;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.SparseArray;
import com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import e.f.j.e.h;

@e.f.m.x.a.a(name = ImageLoaderModule.NAME)
/* loaded from: classes2.dex */
public class ImageLoaderModule extends NativeImageLoaderAndroidSpec implements LifecycleEventListener {
    private static final String ERROR_GET_SIZE_FAILURE = "E_GET_SIZE_FAILURE";
    private static final String ERROR_INVALID_URI = "E_INVALID_URI";
    private static final String ERROR_PREFETCH_FAILURE = "E_PREFETCH_FAILURE";
    public static final String NAME = "ImageLoader";
    private final Object mCallerContext;
    private final Object mEnqueuedRequestMonitor;
    private final SparseArray<e.f.e.c<Void>> mEnqueuedRequests;

    /* loaded from: classes2.dex */
    class a extends e.f.e.b<com.facebook.common.references.a<e.f.j.i.b>> {
        final /* synthetic */ Promise a;

        a(Promise promise) {
            this.a = promise;
        }

        @Override // e.f.e.b
        protected void e(e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> cVar) {
            this.a.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, cVar.c());
        }

        @Override // e.f.e.b
        protected void f(e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> cVar) {
            if (cVar.b()) {
                com.facebook.common.references.a<e.f.j.i.b> f2 = cVar.f();
                try {
                    if (f2 != null) {
                        try {
                            e.f.j.i.b n = f2.n();
                            WritableMap createMap = Arguments.createMap();
                            createMap.putInt("width", n.getWidth());
                            createMap.putInt("height", n.getHeight());
                            this.a.resolve(createMap);
                        } catch (Exception e2) {
                            this.a.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, e2);
                        }
                        return;
                    }
                    this.a.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE);
                } finally {
                    com.facebook.common.references.a.f(f2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends e.f.e.b<com.facebook.common.references.a<e.f.j.i.b>> {
        final /* synthetic */ Promise a;

        b(Promise promise) {
            this.a = promise;
        }

        @Override // e.f.e.b
        protected void e(e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> cVar) {
            this.a.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, cVar.c());
        }

        @Override // e.f.e.b
        protected void f(e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> cVar) {
            if (cVar.b()) {
                com.facebook.common.references.a<e.f.j.i.b> f2 = cVar.f();
                try {
                    if (f2 != null) {
                        try {
                            e.f.j.i.b n = f2.n();
                            WritableMap createMap = Arguments.createMap();
                            createMap.putInt("width", n.getWidth());
                            createMap.putInt("height", n.getHeight());
                            this.a.resolve(createMap);
                        } catch (Exception e2) {
                            this.a.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, e2);
                        }
                        return;
                    }
                    this.a.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE);
                } finally {
                    com.facebook.common.references.a.f(f2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class c extends e.f.e.b<Void> {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Promise f4952b;

        c(int i2, Promise promise) {
            this.a = i2;
            this.f4952b = promise;
        }

        @Override // e.f.e.b
        protected void e(e.f.e.c<Void> cVar) {
            try {
                ImageLoaderModule.this.removeRequest(this.a);
                this.f4952b.reject(ImageLoaderModule.ERROR_PREFETCH_FAILURE, cVar.c());
            } finally {
                cVar.close();
            }
        }

        @Override // e.f.e.b
        protected void f(e.f.e.c<Void> cVar) {
            if (cVar.b()) {
                try {
                    ImageLoaderModule.this.removeRequest(this.a);
                    this.f4952b.resolve(Boolean.TRUE);
                } finally {
                    cVar.close();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class d extends GuardedAsyncTask<Void, Void> {
        final /* synthetic */ ReadableArray a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Promise f4954b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ReactContext reactContext, ReadableArray readableArray, Promise promise) {
            super(reactContext);
            this.a = readableArray;
            this.f4954b = promise;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            WritableMap createMap = Arguments.createMap();
            h a = e.f.h.a.a.c.a();
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                String string = this.a.getString(i2);
                Uri parse = Uri.parse(string);
                if (a.l(parse)) {
                    createMap.putString(string, "memory");
                } else if (a.n(parse)) {
                    createMap.putString(string, "disk");
                }
            }
            this.f4954b.resolve(createMap);
        }
    }

    public ImageLoaderModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mEnqueuedRequestMonitor = new Object();
        this.mEnqueuedRequests = new SparseArray<>();
        this.mCallerContext = this;
    }

    private void registerRequest(int i2, e.f.e.c<Void> cVar) {
        synchronized (this.mEnqueuedRequestMonitor) {
            this.mEnqueuedRequests.put(i2, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e.f.e.c<Void> removeRequest(int i2) {
        e.f.e.c<Void> cVar;
        synchronized (this.mEnqueuedRequestMonitor) {
            cVar = this.mEnqueuedRequests.get(i2);
            this.mEnqueuedRequests.remove(i2);
        }
        return cVar;
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    public void abortRequest(double d2) {
        e.f.e.c<Void> removeRequest = removeRequest((int) d2);
        if (removeRequest != null) {
            removeRequest.close();
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    @ReactMethod
    public void getSize(String str, Promise promise) {
        if (str != null && !str.isEmpty()) {
            e.f.h.a.a.c.a().d(ImageRequestBuilder.r(new e.f.m.b0.b.a(getReactApplicationContext(), str).e()).a(), this.mCallerContext).g(new a(promise), e.f.d.b.a.a());
            return;
        }
        promise.reject(ERROR_INVALID_URI, "Cannot get the size of an image for an empty URI");
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    @ReactMethod
    public void getSizeWithHeaders(String str, ReadableMap readableMap, Promise promise) {
        if (str != null && !str.isEmpty()) {
            e.f.h.a.a.c.a().d(com.facebook.react.modules.fresco.a.w(ImageRequestBuilder.r(new e.f.m.b0.b.a(getReactApplicationContext(), str).e()), readableMap), this.mCallerContext).g(new b(promise), e.f.d.b.a.a());
            return;
        }
        promise.reject(ERROR_INVALID_URI, "Cannot get the size of an image for an empty URI");
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        synchronized (this.mEnqueuedRequestMonitor) {
            int size = this.mEnqueuedRequests.size();
            for (int i2 = 0; i2 < size; i2++) {
                e.f.e.c<Void> valueAt = this.mEnqueuedRequests.valueAt(i2);
                if (valueAt != null) {
                    valueAt.close();
                }
            }
            this.mEnqueuedRequests.clear();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    public void prefetchImage(String str, double d2, Promise promise) {
        int i2 = (int) d2;
        if (str != null && !str.isEmpty()) {
            e.f.e.c<Void> r = e.f.h.a.a.c.a().r(ImageRequestBuilder.r(Uri.parse(str)).a(), this.mCallerContext);
            c cVar = new c(i2, promise);
            registerRequest(i2, r);
            r.g(cVar, e.f.d.b.a.a());
            return;
        }
        promise.reject(ERROR_INVALID_URI, "Cannot prefetch an image for an empty URI");
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    @ReactMethod
    public void queryCache(ReadableArray readableArray, Promise promise) {
        new d(getReactApplicationContext(), readableArray, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public ImageLoaderModule(ReactApplicationContext reactApplicationContext, Object obj) {
        super(reactApplicationContext);
        this.mEnqueuedRequestMonitor = new Object();
        this.mEnqueuedRequests = new SparseArray<>();
        this.mCallerContext = obj;
    }
}