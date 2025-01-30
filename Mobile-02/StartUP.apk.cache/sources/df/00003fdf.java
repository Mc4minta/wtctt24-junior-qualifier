package com.swmansion.reanimated.f;

import android.view.View;
import android.view.ViewGroup;
import c.s.a0;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.l;
import com.facebook.react.uimanager.l0;

/* compiled from: TransitionModule.java */
/* loaded from: classes2.dex */
public class c {
    private final UIManagerModule a;

    /* compiled from: TransitionModule.java */
    /* loaded from: classes2.dex */
    class a implements l0 {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableMap f10963b;

        a(int i2, ReadableMap readableMap) {
            this.a = i2;
            this.f10963b = readableMap;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(l lVar) {
            try {
                View w = lVar.w(this.a);
                if (w instanceof ViewGroup) {
                    ReadableArray array = this.f10963b.getArray("transitions");
                    int size = array.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        a0.b((ViewGroup) w, d.c(array.getMap(i2)));
                    }
                }
            } catch (IllegalViewOperationException unused) {
            }
        }
    }

    public c(UIManagerModule uIManagerModule) {
        this.a = uIManagerModule;
    }

    public void a(int i2, ReadableMap readableMap) {
        this.a.prependUIBlock(new a(i2, readableMap));
    }
}