package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class EventNode extends m implements RCTEventEmitter {
    private final List<a> mMapping;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f10965b;

        public a(ReadableArray readableArray) {
            int size = readableArray.size() - 1;
            this.f10965b = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.f10965b[i2] = readableArray.getString(i2);
            }
            this.a = readableArray.getInt(size);
        }

        public Double b(ReadableMap readableMap) {
            int i2 = 0;
            while (readableMap != null) {
                String[] strArr = this.f10965b;
                if (i2 >= strArr.length - 1) {
                    break;
                }
                String str = strArr[i2];
                readableMap = readableMap.hasKey(str) ? readableMap.getMap(str) : null;
                i2++;
            }
            if (readableMap != null) {
                String[] strArr2 = this.f10965b;
                String str2 = strArr2[strArr2.length - 1];
                if (readableMap.hasKey(str2)) {
                    return Double.valueOf(readableMap.getDouble(str2));
                }
                return null;
            }
            return null;
        }
    }

    public EventNode(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        this.mMapping = processMapping(readableMap.getArray("argMapping"));
    }

    private static List<a> processMapping(ReadableArray readableArray) {
        int size = readableArray.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new a(readableArray.getArray(i2)));
        }
        return arrayList;
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveEvent(int i2, String str, WritableMap writableMap) {
        if (writableMap != null) {
            for (int i3 = 0; i3 < this.mMapping.size(); i3++) {
                a aVar = this.mMapping.get(i3);
                Double b2 = aVar.b(writableMap);
                if (b2 != null) {
                    ((u) this.mNodesManager.o(aVar.a, u.class)).c(b2);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Animated events must have event data.");
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        throw new RuntimeException("receiveTouches is not support by animated events");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.reanimated.nodes.m
    public Double evaluate() {
        return m.ZERO;
    }
}