package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.o;

/* compiled from: TouchesHelper.java */
/* loaded from: classes2.dex */
public class j {
    private static WritableArray a(int i2, g gVar) {
        WritableArray createArray = Arguments.createArray();
        MotionEvent m = gVar.m();
        float x = m.getX() - gVar.n();
        float y = m.getY() - gVar.o();
        for (int i3 = 0; i3 < m.getPointerCount(); i3++) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("pageX", o.a(m.getX(i3)));
            createMap.putDouble("pageY", o.a(m.getY(i3)));
            createMap.putDouble("locationX", o.a(m.getX(i3) - x));
            createMap.putDouble("locationY", o.a(m.getY(i3) - y));
            createMap.putInt("target", i2);
            createMap.putDouble("timestamp", gVar.g());
            createMap.putDouble("identifier", m.getPointerId(i3));
            createArray.pushMap(createMap);
        }
        return createArray;
    }

    public static void b(RCTEventEmitter rCTEventEmitter, i iVar, int i2, g gVar) {
        WritableArray a = a(i2, gVar);
        MotionEvent m = gVar.m();
        WritableArray createArray = Arguments.createArray();
        if (iVar != i.MOVE && iVar != i.CANCEL) {
            if (iVar != i.START && iVar != i.END) {
                throw new RuntimeException("Unknown touch type: " + iVar);
            }
            createArray.pushInt(m.getActionIndex());
        } else {
            for (int i3 = 0; i3 < m.getPointerCount(); i3++) {
                createArray.pushInt(i3);
            }
        }
        rCTEventEmitter.receiveTouches(i.h(iVar), a, createArray);
    }
}