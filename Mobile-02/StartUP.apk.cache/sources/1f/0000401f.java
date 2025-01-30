package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TransformNode.java */
/* loaded from: classes2.dex */
public class t extends m {
    private List<d> a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransformNode.java */
    /* loaded from: classes2.dex */
    public static class b extends d {

        /* renamed from: b  reason: collision with root package name */
        public int f10996b;

        private b() {
            super();
        }

        @Override // com.swmansion.reanimated.nodes.t.d
        public Object a(com.swmansion.reanimated.b bVar) {
            return bVar.p(this.f10996b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransformNode.java */
    /* loaded from: classes2.dex */
    public static class c extends d {

        /* renamed from: b  reason: collision with root package name */
        public Object f10997b;

        private c() {
            super();
        }

        @Override // com.swmansion.reanimated.nodes.t.d
        public Object a(com.swmansion.reanimated.b bVar) {
            return this.f10997b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransformNode.java */
    /* loaded from: classes2.dex */
    public static abstract class d {
        public String a;

        private d() {
        }

        public abstract Object a(com.swmansion.reanimated.b bVar);
    }

    public t(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        this.a = d(readableMap.getArray("transform"));
    }

    private static List<d> d(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            ReadableMap map = readableArray.getMap(i2);
            String string = map.getString("property");
            if (map.hasKey("nodeID")) {
                b bVar = new b();
                bVar.a = string;
                bVar.f10996b = map.getInt("nodeID");
                arrayList.add(bVar);
            } else {
                c cVar = new c();
                cVar.a = string;
                ReadableType type = map.getType("value");
                if (type == ReadableType.String) {
                    cVar.f10997b = map.getString("value");
                } else if (type == ReadableType.Array) {
                    cVar.f10997b = map.getArray("value");
                } else {
                    cVar.f10997b = Double.valueOf(map.getDouble("value"));
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.reanimated.nodes.m
    /* renamed from: c */
    public WritableArray evaluate() {
        ArrayList arrayList = new ArrayList(this.a.size());
        for (d dVar : this.a) {
            arrayList.add(JavaOnlyMap.of(dVar.a, dVar.a(this.mNodesManager)));
        }
        return JavaOnlyArray.from(arrayList);
    }
}