package com.facebook.react.modules.core;

import com.facebook.fbreact.specs.NativeHeadlessJsTaskSupportSpec;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;

@e.f.m.x.a.a(name = HeadlessJsTaskSupportModule.NAME)
/* loaded from: classes2.dex */
public class HeadlessJsTaskSupportModule extends NativeHeadlessJsTaskSupportSpec {
    public static final String NAME = "HeadlessJsTaskSupport";

    public HeadlessJsTaskSupportModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeHeadlessJsTaskSupportSpec
    public void notifyTaskFinished(double d2) {
        int i2 = (int) d2;
        e.f.m.w.b e2 = e.f.m.w.b.e(getReactApplicationContext());
        if (e2.g(i2)) {
            e2.d(i2);
        } else {
            e.f.d.d.a.y(HeadlessJsTaskSupportModule.class, "Tried to finish non-active task with id %d. Did it time out?", Integer.valueOf(i2));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeHeadlessJsTaskSupportSpec
    public void notifyTaskRetry(double d2, Promise promise) {
        int i2 = (int) d2;
        e.f.m.w.b e2 = e.f.m.w.b.e(getReactApplicationContext());
        if (e2.g(i2)) {
            promise.resolve(Boolean.valueOf(e2.j(i2)));
            return;
        }
        e.f.d.d.a.y(HeadlessJsTaskSupportModule.class, "Tried to retry non-active task with id %d. Did it time out?", Integer.valueOf(i2));
        promise.resolve(Boolean.FALSE);
    }
}