package org.reactnative.facedetector;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class FaceDetectorModule extends ReactContextBaseJavaModule {
    private static final String TAG = "RNFaceDetector";
    private static ReactApplicationContext mScopedContext;

    /* loaded from: classes3.dex */
    class a extends HashMap<String, Object> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: org.reactnative.facedetector.FaceDetectorModule$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0430a extends HashMap<String, Object> {
            C0430a() {
                put("fast", Integer.valueOf(org.reactnative.facedetector.b.f17749f));
                put("accurate", Integer.valueOf(org.reactnative.facedetector.b.f17748e));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class b extends HashMap<String, Object> {
            b() {
                put("all", Integer.valueOf(org.reactnative.facedetector.b.a));
                put("none", Integer.valueOf(org.reactnative.facedetector.b.f17745b));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class c extends HashMap<String, Object> {
            c() {
                put("all", Integer.valueOf(org.reactnative.facedetector.b.f17746c));
                put("none", Integer.valueOf(org.reactnative.facedetector.b.f17747d));
            }
        }

        a() {
            put("Mode", d());
            put("Landmarks", c());
            put("Classifications", b());
        }

        private Map<String, Object> b() {
            return Collections.unmodifiableMap(new b());
        }

        private Map<String, Object> c() {
            return Collections.unmodifiableMap(new c());
        }

        private Map<String, Object> d() {
            return Collections.unmodifiableMap(new C0430a());
        }
    }

    public FaceDetectorModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        mScopedContext = reactApplicationContext;
    }

    @ReactMethod
    public void detectFaces(ReadableMap readableMap, Promise promise) {
        new org.reactnative.facedetector.c.a(mScopedContext, readableMap, promise).execute(new Void[0]);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(new a());
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }
}