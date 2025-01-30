package com.facebook.react.animated;

import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.util.List;

/* loaded from: classes2.dex */
class EventAnimationDriver implements RCTEventEmitter {
    private List<String> mEventPath;
    s mValueNode;

    public EventAnimationDriver(List<String> list, s sVar) {
        this.mEventPath = list;
        this.mValueNode = sVar;
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveEvent(int i2, String str, WritableMap writableMap) {
        if (writableMap != null) {
            int i3 = 0;
            WritableMap writableMap2 = writableMap;
            while (i3 < this.mEventPath.size() - 1) {
                i3++;
                writableMap2 = writableMap2.getMap(this.mEventPath.get(i3));
            }
            s sVar = this.mValueNode;
            List<String> list = this.mEventPath;
            sVar.f4779f = writableMap2.getDouble(list.get(list.size() - 1));
            return;
        }
        throw new IllegalArgumentException("Native animated events must have event data.");
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        throw new RuntimeException("receiveTouches is not support by native animated events");
    }
}