package com.facebook.react.uimanager.events;

import android.util.SparseArray;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

/* loaded from: classes2.dex */
public class ReactEventEmitter implements RCTEventEmitter {
    private static final String TAG = "ReactEventEmitter";
    private final SparseArray<RCTEventEmitter> mEventEmitters = new SparseArray<>();
    private final ReactApplicationContext mReactContext;

    public ReactEventEmitter(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
    }

    private RCTEventEmitter getEventEmitter(int i2) {
        int a = com.facebook.react.uimanager.d1.a.a(i2);
        RCTEventEmitter rCTEventEmitter = this.mEventEmitters.get(a);
        if (rCTEventEmitter == null) {
            e.f.d.d.a.k(TAG, "Unable to find event emitter for reactTag: %d - uiManagerType: %d", Integer.valueOf(i2), Integer.valueOf(a));
            if (this.mReactContext.hasActiveCatalystInstance()) {
                return (RCTEventEmitter) this.mReactContext.getJSModule(RCTEventEmitter.class);
            }
            ReactSoftException.logSoftException(TAG, new ReactNoCrashSoftException("Cannot get RCTEventEmitter from Context for reactTag: " + i2 + " - uiManagerType: " + a + " - No active Catalyst instance!"));
            return rCTEventEmitter;
        }
        return rCTEventEmitter;
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveEvent(int i2, String str, WritableMap writableMap) {
        RCTEventEmitter eventEmitter = getEventEmitter(i2);
        if (eventEmitter != null) {
            eventEmitter.receiveEvent(i2, str, writableMap);
        }
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        e.f.k.a.a.a(writableArray.size() > 0);
        RCTEventEmitter eventEmitter = getEventEmitter(writableArray.getMap(0).getInt("target"));
        if (eventEmitter != null) {
            eventEmitter.receiveTouches(str, writableArray, writableArray2);
        }
    }

    public void register(int i2, RCTEventEmitter rCTEventEmitter) {
        this.mEventEmitters.put(i2, rCTEventEmitter);
    }

    public void unregister(int i2) {
        this.mEventEmitters.remove(i2);
    }
}