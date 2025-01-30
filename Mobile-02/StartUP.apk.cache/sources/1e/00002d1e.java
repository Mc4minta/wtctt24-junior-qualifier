package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.UIManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PropsAnimatedNode.java */
/* loaded from: classes2.dex */
public class m extends b {

    /* renamed from: e  reason: collision with root package name */
    private int f4748e = -1;

    /* renamed from: f  reason: collision with root package name */
    private final l f4749f;

    /* renamed from: g  reason: collision with root package name */
    private final UIManager f4750g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, Integer> f4751h;

    /* renamed from: i  reason: collision with root package name */
    private final JavaOnlyMap f4752i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ReadableMap readableMap, l lVar, UIManager uIManager) {
        ReadableMap map = readableMap.getMap("props");
        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
        this.f4751h = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            this.f4751h.put(nextKey, Integer.valueOf(map.getInt(nextKey)));
        }
        this.f4752i = new JavaOnlyMap();
        this.f4749f = lVar;
        this.f4750g = uIManager;
    }

    public void f(int i2) {
        if (this.f4748e == -1) {
            this.f4748e = i2;
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node " + this.f4708d + " is already attached to a view");
    }

    public void g(int i2) {
        if (this.f4748e == i2) {
            this.f4748e = -1;
            return;
        }
        throw new JSApplicationIllegalArgumentException("Attempting to disconnect view that has not been connected with the given animated node");
    }

    public void h() {
        ReadableMapKeySetIterator keySetIterator = this.f4752i.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            this.f4752i.putNull(keySetIterator.nextKey());
        }
        this.f4750g.synchronouslyUpdateViewOnUIThread(this.f4748e, this.f4752i);
    }

    public final void i() {
        if (this.f4748e == -1) {
            return;
        }
        for (Map.Entry<String, Integer> entry : this.f4751h.entrySet()) {
            b l2 = this.f4749f.l(entry.getValue().intValue());
            if (l2 != null) {
                if (l2 instanceof o) {
                    ((o) l2).f(this.f4752i);
                } else if (l2 instanceof s) {
                    s sVar = (s) l2;
                    Object h2 = sVar.h();
                    if (h2 instanceof String) {
                        this.f4752i.putString(entry.getKey(), (String) h2);
                    } else {
                        this.f4752i.putDouble(entry.getKey(), sVar.i());
                    }
                } else {
                    throw new IllegalArgumentException("Unsupported type of node used in property node " + l2.getClass());
                }
            } else {
                throw new IllegalArgumentException("Mapped property node does not exists");
            }
        }
        this.f4750g.synchronouslyUpdateViewOnUIThread(this.f4748e, this.f4752i);
    }
}