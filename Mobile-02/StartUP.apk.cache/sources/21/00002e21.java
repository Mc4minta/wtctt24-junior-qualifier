package com.facebook.react.modules.accessibilityinfo;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.facebook.fbreact.specs.NativeAccessibilityInfoSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;

@e.f.m.x.a.a(name = AccessibilityInfoModule.NAME)
/* loaded from: classes2.dex */
public class AccessibilityInfoModule extends NativeAccessibilityInfoSpec implements LifecycleEventListener {
    public static final String NAME = "AccessibilityInfo";
    private static final String REDUCE_MOTION_EVENT_NAME = "reduceMotionDidChange";
    private static final String TOUCH_EXPLORATION_EVENT_NAME = "touchExplorationDidChange";
    private final ContentObserver animationScaleObserver;
    private AccessibilityManager mAccessibilityManager;
    private final ContentResolver mContentResolver;
    private boolean mReduceMotionEnabled;
    private boolean mTouchExplorationEnabled;
    private b mTouchExplorationStateChangeListener;

    /* loaded from: classes2.dex */
    class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            onChange(z, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            if (AccessibilityInfoModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                AccessibilityInfoModule.this.updateAndSendReduceMotionChangeEvent();
            }
        }
    }

    @TargetApi(19)
    /* loaded from: classes2.dex */
    private class b implements AccessibilityManager.TouchExplorationStateChangeListener {
        private b() {
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            AccessibilityInfoModule.this.updateAndSendTouchExplorationChangeEvent(z);
        }

        /* synthetic */ b(AccessibilityInfoModule accessibilityInfoModule, a aVar) {
            this();
        }
    }

    public AccessibilityInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.animationScaleObserver = new a(new Handler(Looper.getMainLooper()));
        this.mReduceMotionEnabled = false;
        this.mTouchExplorationEnabled = false;
        this.mAccessibilityManager = (AccessibilityManager) reactApplicationContext.getApplicationContext().getSystemService("accessibility");
        this.mContentResolver = getReactApplicationContext().getContentResolver();
        this.mTouchExplorationEnabled = this.mAccessibilityManager.isTouchExplorationEnabled();
        this.mReduceMotionEnabled = getIsReduceMotionEnabledValue();
        if (Build.VERSION.SDK_INT >= 19) {
            this.mTouchExplorationStateChangeListener = new b(this, null);
        }
    }

    private boolean getIsReduceMotionEnabledValue() {
        String string = Build.VERSION.SDK_INT < 17 ? null : Settings.Global.getString(this.mContentResolver, "transition_animation_scale");
        return string != null && string.equals("0.0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAndSendReduceMotionChangeEvent() {
        boolean isReduceMotionEnabledValue = getIsReduceMotionEnabledValue();
        if (this.mReduceMotionEnabled != isReduceMotionEnabledValue) {
            this.mReduceMotionEnabled = isReduceMotionEnabledValue;
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
            if (reactApplicationContextIfActiveOrWarn != null) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContextIfActiveOrWarn.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(REDUCE_MOTION_EVENT_NAME, Boolean.valueOf(this.mReduceMotionEnabled));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAndSendTouchExplorationChangeEvent(boolean z) {
        if (this.mTouchExplorationEnabled != z) {
            this.mTouchExplorationEnabled = z;
            if (getReactApplicationContextIfActiveOrWarn() != null) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(TOUCH_EXPLORATION_EVENT_NAME, Boolean.valueOf(this.mTouchExplorationEnabled));
            }
        }
    }

    @Override // com.facebook.fbreact.specs.NativeAccessibilityInfoSpec
    public void announceForAccessibility(String str) {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
        obtain.getText().add(str);
        obtain.setClassName(AccessibilityInfoModule.class.getName());
        obtain.setPackageName(getReactApplicationContext().getPackageName());
        this.mAccessibilityManager.sendAccessibilityEvent(obtain);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
        updateAndSendTouchExplorationChangeEvent(this.mAccessibilityManager.isTouchExplorationEnabled());
        updateAndSendReduceMotionChangeEvent();
    }

    @Override // com.facebook.fbreact.specs.NativeAccessibilityInfoSpec
    public void isReduceMotionEnabled(Callback callback) {
        callback.invoke(Boolean.valueOf(this.mReduceMotionEnabled));
    }

    @Override // com.facebook.fbreact.specs.NativeAccessibilityInfoSpec
    public void isTouchExplorationEnabled(Callback callback) {
        callback.invoke(Boolean.valueOf(this.mTouchExplorationEnabled));
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        getReactApplicationContext().removeLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            this.mAccessibilityManager.removeTouchExplorationStateChangeListener(this.mTouchExplorationStateChangeListener);
        }
        if (i2 >= 17) {
            this.mContentResolver.unregisterContentObserver(this.animationScaleObserver);
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            this.mAccessibilityManager.addTouchExplorationStateChangeListener(this.mTouchExplorationStateChangeListener);
        }
        if (i2 >= 17) {
            this.mContentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, this.animationScaleObserver);
        }
        updateAndSendTouchExplorationChangeEvent(this.mAccessibilityManager.isTouchExplorationEnabled());
        updateAndSendReduceMotionChangeEvent();
    }

    @Override // com.facebook.fbreact.specs.NativeAccessibilityInfoSpec
    public void setAccessibilityFocus(double d2) {
    }
}