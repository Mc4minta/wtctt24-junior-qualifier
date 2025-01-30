package com.facebook.react.views.text.frescosupport;

import android.content.Context;
import android.net.Uri;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.views.text.o;
import com.facebook.react.views.text.z;
import java.util.Locale;

/* compiled from: FrescoBasedReactTextInlineImageShadowNode.java */
/* loaded from: classes2.dex */
public class a extends o {
    private Uri E;
    private ReadableMap F;
    private final e.f.h.c.b G;
    private final Object H;
    private String J;
    private float I = Float.NaN;
    private float K = Float.NaN;
    private int L = 0;

    public a(e.f.h.c.b bVar, Object obj) {
        this.G = bVar;
        this.H = obj;
    }

    private static Uri s1(Context context, String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return new Uri.Builder().scheme("res").path(String.valueOf(context.getResources().getIdentifier(str.toLowerCase(Locale.getDefault()).replace("-", "_"), "drawable", context.getPackageName()))).build();
    }

    @Override // com.facebook.react.views.text.o
    public z o1() {
        return new b(F().getResources(), (int) Math.ceil(this.K), (int) Math.ceil(this.I), this.L, t1(), r1(), q1(), p1(), this.J);
    }

    public Object p1() {
        return this.H;
    }

    public e.f.h.c.b q1() {
        return this.G;
    }

    public ReadableMap r1() {
        return this.F;
    }

    @com.facebook.react.uimanager.c1.a(name = "headers")
    public void setHeaders(ReadableMap readableMap) {
        this.F = readableMap;
    }

    @Override // com.facebook.react.uimanager.h
    public void setHeight(Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Number) {
            this.K = (float) dynamic.asDouble();
            return;
        }
        throw new JSApplicationIllegalArgumentException("Inline images must not have percentage based height");
    }

    @com.facebook.react.uimanager.c1.a(name = "resizeMode")
    public void setResizeMode(String str) {
        this.J = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (r1.getScheme() == null) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    @com.facebook.react.uimanager.c1.a(name = "src")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setSource(com.facebook.react.bridge.ReadableArray r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L16
            int r1 = r4.size()
            if (r1 != 0) goto La
            goto L16
        La:
            r1 = 0
            com.facebook.react.bridge.ReadableMap r4 = r4.getMap(r1)
            java.lang.String r1 = "uri"
            java.lang.String r4 = r4.getString(r1)
            goto L17
        L16:
            r4 = r0
        L17:
            if (r4 == 0) goto L2f
            android.net.Uri r1 = android.net.Uri.parse(r4)     // Catch: java.lang.Exception -> L25
            java.lang.String r2 = r1.getScheme()     // Catch: java.lang.Exception -> L24
            if (r2 != 0) goto L24
            goto L25
        L24:
            r0 = r1
        L25:
            if (r0 != 0) goto L2f
            com.facebook.react.uimanager.i0 r0 = r3.F()
            android.net.Uri r0 = s1(r0, r4)
        L2f:
            android.net.Uri r4 = r3.E
            if (r0 == r4) goto L36
            r3.w0()
        L36:
            r3.E = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.frescosupport.a.setSource(com.facebook.react.bridge.ReadableArray):void");
    }

    @com.facebook.react.uimanager.c1.a(name = "tintColor")
    public void setTintColor(int i2) {
        this.L = i2;
    }

    @Override // com.facebook.react.uimanager.h
    public void setWidth(Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Number) {
            this.I = (float) dynamic.asDouble();
            return;
        }
        throw new JSApplicationIllegalArgumentException("Inline images must not have percentage based width");
    }

    @Override // com.facebook.react.uimanager.z, com.facebook.react.uimanager.y
    public boolean t() {
        return true;
    }

    public Uri t1() {
        return this.E;
    }
}