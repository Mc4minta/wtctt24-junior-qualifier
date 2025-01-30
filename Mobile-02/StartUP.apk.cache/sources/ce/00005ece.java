package org.reactnative.camera.f;

import android.util.Base64;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

/* compiled from: BarcodesDetectedEvent.java */
/* loaded from: classes3.dex */
public class c extends com.facebook.react.uimanager.events.c<c> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<c> f17672f = new androidx.core.util.g<>(3);

    /* renamed from: g  reason: collision with root package name */
    private WritableArray f17673g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f17674h;

    private c() {
    }

    private void m(int i2, WritableArray writableArray, byte[] bArr) {
        super.j(i2);
        this.f17673g = writableArray;
        this.f17674h = bArr;
    }

    public static c n(int i2, WritableArray writableArray, byte[] bArr) {
        c acquire = f17672f.acquire();
        if (acquire == null) {
            acquire = new c();
        }
        acquire.m(i2, writableArray, bArr);
        return acquire;
    }

    private WritableMap o() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", "barcode");
        createMap.putArray("barcodes", this.f17673g);
        createMap.putInt("target", i());
        byte[] bArr = this.f17674h;
        if (bArr != null) {
            createMap.putString("image", Base64.encodeToString(bArr, 2));
        }
        return createMap;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), o());
    }

    @Override // com.facebook.react.uimanager.events.c
    public short e() {
        if (this.f17673g.size() > 32767) {
            return Short.MAX_VALUE;
        }
        return (short) this.f17673g.size();
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return CameraViewManager.a.EVENT_ON_BARCODES_DETECTED.toString();
    }
}