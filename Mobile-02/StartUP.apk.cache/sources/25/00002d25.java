package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TransformAnimatedNode.java */
/* loaded from: classes2.dex */
public class r extends com.facebook.react.animated.b {

    /* renamed from: e  reason: collision with root package name */
    private final l f4771e;

    /* renamed from: f  reason: collision with root package name */
    private final List<d> f4772f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransformAnimatedNode.java */
    /* loaded from: classes2.dex */
    public class b extends d {

        /* renamed from: c  reason: collision with root package name */
        public int f4773c;

        private b() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransformAnimatedNode.java */
    /* loaded from: classes2.dex */
    public class c extends d {

        /* renamed from: c  reason: collision with root package name */
        public double f4775c;

        private c() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransformAnimatedNode.java */
    /* loaded from: classes2.dex */
    public class d {
        public String a;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ReadableMap readableMap, l lVar) {
        ReadableArray array = readableMap.getArray("transforms");
        this.f4772f = new ArrayList(array.size());
        for (int i2 = 0; i2 < array.size(); i2++) {
            ReadableMap map = array.getMap(i2);
            String string = map.getString("property");
            if (map.getString("type").equals("animated")) {
                b bVar = new b();
                bVar.a = string;
                bVar.f4773c = map.getInt("nodeTag");
                this.f4772f.add(bVar);
            } else {
                c cVar = new c();
                cVar.a = string;
                cVar.f4775c = map.getDouble("value");
                this.f4772f.add(cVar);
            }
        }
        this.f4771e = lVar;
    }

    public void f(JavaOnlyMap javaOnlyMap) {
        double d2;
        ArrayList arrayList = new ArrayList(this.f4772f.size());
        for (d dVar : this.f4772f) {
            if (dVar instanceof b) {
                com.facebook.react.animated.b l2 = this.f4771e.l(((b) dVar).f4773c);
                if (l2 != null) {
                    if (l2 instanceof s) {
                        d2 = ((s) l2).i();
                    } else {
                        throw new IllegalArgumentException("Unsupported type of node used as a transform child node " + l2.getClass());
                    }
                } else {
                    throw new IllegalArgumentException("Mapped style node does not exists");
                }
            } else {
                d2 = ((c) dVar).f4775c;
            }
            arrayList.add(JavaOnlyMap.of(dVar.a, Double.valueOf(d2)));
        }
        javaOnlyMap.putArray("transform", JavaOnlyArray.from(arrayList));
    }
}