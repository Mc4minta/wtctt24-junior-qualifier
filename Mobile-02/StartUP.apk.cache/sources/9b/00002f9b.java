package com.facebook.react.views.image;

import com.appsflyer.internal.referrer.Payload;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: ImageLoadEvent.java */
/* loaded from: classes2.dex */
public class b extends com.facebook.react.uimanager.events.c<b> {

    /* renamed from: f  reason: collision with root package name */
    private final int f5300f;

    /* renamed from: g  reason: collision with root package name */
    private final String f5301g;

    /* renamed from: h  reason: collision with root package name */
    private final int f5302h;

    /* renamed from: i  reason: collision with root package name */
    private final int f5303i;

    /* renamed from: j  reason: collision with root package name */
    private final String f5304j;

    public b(int i2, int i3) {
        this(i2, i3, null);
    }

    public static String m(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            return "topProgress";
                        }
                        throw new IllegalStateException("Invalid image event: " + Integer.toString(i2));
                    }
                    return "topLoadStart";
                }
                return "topLoadEnd";
            }
            return "topLoad";
        }
        return "topError";
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        WritableMap createMap;
        int i2;
        if (this.f5301g != null || (i2 = this.f5300f) == 2 || i2 == 1) {
            createMap = Arguments.createMap();
            String str = this.f5301g;
            if (str != null) {
                createMap.putString("uri", str);
            }
            int i3 = this.f5300f;
            if (i3 == 2) {
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putDouble("width", this.f5302h);
                createMap2.putDouble("height", this.f5303i);
                String str2 = this.f5301g;
                if (str2 != null) {
                    createMap2.putString("url", str2);
                }
                createMap.putMap(Payload.SOURCE, createMap2);
            } else if (i3 == 1) {
                createMap.putString("error", this.f5304j);
            }
        } else {
            createMap = null;
        }
        rCTEventEmitter.receiveEvent(i(), f(), createMap);
    }

    @Override // com.facebook.react.uimanager.events.c
    public short e() {
        return (short) this.f5300f;
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return m(this.f5300f);
    }

    public b(int i2, int i3, boolean z, String str) {
        this(i2, i3, null, 0, 0, str);
    }

    public b(int i2, int i3, String str) {
        this(i2, i3, str, 0, 0, null);
    }

    public b(int i2, int i3, String str, int i4, int i5) {
        this(i2, i3, str, i4, i5, null);
    }

    public b(int i2, int i3, String str, int i4, int i5, String str2) {
        super(i2);
        this.f5300f = i3;
        this.f5301g = str;
        this.f5302h = i4;
        this.f5303i = i5;
        this.f5304j = str2;
    }
}