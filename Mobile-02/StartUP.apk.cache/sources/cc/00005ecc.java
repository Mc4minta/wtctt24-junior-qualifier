package org.reactnative.camera.f;

import android.util.Base64;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.util.Formatter;
import org.reactnative.camera.CameraViewManager;

/* compiled from: BarCodeReadEvent.java */
/* loaded from: classes3.dex */
public class a extends com.facebook.react.uimanager.events.c<a> {

    /* renamed from: f  reason: collision with root package name */
    private static final androidx.core.util.g<a> f17665f = new androidx.core.util.g<>(3);

    /* renamed from: g  reason: collision with root package name */
    private com.google.zxing.k f17666g;

    /* renamed from: h  reason: collision with root package name */
    private int f17667h;

    /* renamed from: i  reason: collision with root package name */
    private int f17668i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f17669j;

    private a() {
    }

    private void m(int i2, com.google.zxing.k kVar, int i3, int i4, byte[] bArr) {
        super.j(i2);
        this.f17666g = kVar;
        this.f17667h = i3;
        this.f17668i = i4;
        this.f17669j = bArr;
    }

    public static a n(int i2, com.google.zxing.k kVar, int i3, int i4, byte[] bArr) {
        a acquire = f17665f.acquire();
        if (acquire == null) {
            acquire = new a();
        }
        acquire.m(i2, kVar, i3, i4, bArr);
        return acquire;
    }

    private WritableMap o() {
        com.google.zxing.m[] e2;
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap.putInt("target", i());
        createMap.putString("data", this.f17666g.f());
        byte[] c2 = this.f17666g.c();
        if (c2 != null && c2.length > 0) {
            Formatter formatter = new Formatter();
            int length = c2.length;
            for (int i2 = 0; i2 < length; i2++) {
                formatter.format("%02x", Byte.valueOf(c2[i2]));
            }
            createMap.putString("rawData", formatter.toString());
            formatter.close();
        }
        createMap.putString("type", this.f17666g.b().toString());
        WritableArray createArray = Arguments.createArray();
        for (com.google.zxing.m mVar : this.f17666g.e()) {
            if (mVar != null) {
                WritableMap createMap3 = Arguments.createMap();
                createMap3.putString("x", String.valueOf(mVar.c()));
                createMap3.putString("y", String.valueOf(mVar.d()));
                createArray.pushMap(createMap3);
            }
        }
        createMap2.putArray("origin", createArray);
        createMap2.putInt("height", this.f17668i);
        createMap2.putInt("width", this.f17667h);
        createMap.putMap("bounds", createMap2);
        byte[] bArr = this.f17669j;
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
        return (short) (this.f17666g.f().hashCode() % 32767);
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return CameraViewManager.a.EVENT_ON_BAR_CODE_READ.toString();
    }
}