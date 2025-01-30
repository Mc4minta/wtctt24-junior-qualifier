package com.facebook.react.modules.core;

import com.facebook.fbreact.specs.NativeTimingSpec;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;

@e.f.m.x.a.a(name = TimingModule.NAME)
/* loaded from: classes2.dex */
public final class TimingModule extends NativeTimingSpec implements LifecycleEventListener, e.f.m.w.c {
    public static final String NAME = "Timing";
    private final d mJavaTimerManager;

    /* loaded from: classes2.dex */
    public class a implements c {
        public a() {
        }

        @Override // com.facebook.react.modules.core.c
        public void callIdleCallbacks(double d2) {
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
            if (reactApplicationContextIfActiveOrWarn != null) {
                ((JSTimers) reactApplicationContextIfActiveOrWarn.getJSModule(JSTimers.class)).callIdleCallbacks(d2);
            }
        }

        @Override // com.facebook.react.modules.core.c
        public void callTimers(WritableArray writableArray) {
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
            if (reactApplicationContextIfActiveOrWarn != null) {
                ((JSTimers) reactApplicationContextIfActiveOrWarn.getJSModule(JSTimers.class)).callTimers(writableArray);
            }
        }

        @Override // com.facebook.react.modules.core.c
        public void emitTimeDriftWarning(String str) {
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
            if (reactApplicationContextIfActiveOrWarn != null) {
                ((JSTimers) reactApplicationContextIfActiveOrWarn.getJSModule(JSTimers.class)).emitTimeDriftWarning(str);
            }
        }
    }

    public TimingModule(ReactApplicationContext reactApplicationContext, com.facebook.react.devsupport.g.c cVar) {
        super(reactApplicationContext);
        this.mJavaTimerManager = new d(reactApplicationContext, new a(), g.i(), cVar);
    }

    @Override // com.facebook.fbreact.specs.NativeTimingSpec
    public void createTimer(double d2, double d3, double d4, boolean z) {
        this.mJavaTimerManager.q((int) d2, (int) d3, d4, z);
    }

    @Override // com.facebook.fbreact.specs.NativeTimingSpec
    public void deleteTimer(double d2) {
        this.mJavaTimerManager.deleteTimer((int) d2);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    public boolean hasActiveTimersInRange(long j2) {
        return this.mJavaTimerManager.r(j2);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
        e.f.m.w.b.e(getReactApplicationContext()).c(this);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        e.f.m.w.b.e(getReactApplicationContext()).h(this);
        this.mJavaTimerManager.A();
    }

    @Override // e.f.m.w.c
    public void onHeadlessJsTaskFinish(int i2) {
        this.mJavaTimerManager.v(i2);
    }

    @Override // e.f.m.w.c
    public void onHeadlessJsTaskStart(int i2) {
        this.mJavaTimerManager.w(i2);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        this.mJavaTimerManager.x();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        this.mJavaTimerManager.y();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        this.mJavaTimerManager.z();
    }

    @Override // com.facebook.fbreact.specs.NativeTimingSpec
    public void setSendIdleEvents(boolean z) {
        this.mJavaTimerManager.setSendIdleEvents(z);
    }
}