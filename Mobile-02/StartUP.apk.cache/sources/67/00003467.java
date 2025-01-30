package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class ad extends bd.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f7031e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f7032f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ Context f7033g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ Bundle f7034h;

    /* renamed from: j  reason: collision with root package name */
    private final /* synthetic */ bd f7035j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(bd bdVar, String str, String str2, Context context, Bundle bundle) {
        super(bdVar);
        this.f7035j = bdVar;
        this.f7031e = str;
        this.f7032f = str2;
        this.f7033g = context;
        this.f7034h = bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0052 A[Catch: Exception -> 0x009e, TryCatch #0 {Exception -> 0x009e, blocks: (B:3:0x0002, B:5:0x0019, B:7:0x002a, B:13:0x003f, B:15:0x0052, B:17:0x005e, B:19:0x006c, B:30:0x0081), top: B:35:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005e A[Catch: Exception -> 0x009e, TryCatch #0 {Exception -> 0x009e, blocks: (B:3:0x0002, B:5:0x0019, B:7:0x002a, B:13:0x003f, B:15:0x0052, B:17:0x005e, B:19:0x006c, B:30:0x0081), top: B:35:0x0002 }] */
    @Override // com.google.android.gms.internal.measurement.bd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            com.google.android.gms.internal.measurement.bd r2 = r14.f7035j     // Catch: java.lang.Exception -> L9e
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Exception -> L9e
            r3.<init>()     // Catch: java.lang.Exception -> L9e
            com.google.android.gms.internal.measurement.bd.e(r2, r3)     // Catch: java.lang.Exception -> L9e
            com.google.android.gms.internal.measurement.bd r2 = r14.f7035j     // Catch: java.lang.Exception -> L9e
            java.lang.String r3 = r14.f7031e     // Catch: java.lang.Exception -> L9e
            java.lang.String r4 = r14.f7032f     // Catch: java.lang.Exception -> L9e
            boolean r2 = com.google.android.gms.internal.measurement.bd.v(r2, r3, r4)     // Catch: java.lang.Exception -> L9e
            r3 = 0
            if (r2 == 0) goto L27
            java.lang.String r3 = r14.f7032f     // Catch: java.lang.Exception -> L9e
            java.lang.String r2 = r14.f7031e     // Catch: java.lang.Exception -> L9e
            com.google.android.gms.internal.measurement.bd r4 = r14.f7035j     // Catch: java.lang.Exception -> L9e
            java.lang.String r4 = com.google.android.gms.internal.measurement.bd.w(r4)     // Catch: java.lang.Exception -> L9e
            r10 = r2
            r11 = r3
            r9 = r4
            goto L2a
        L27:
            r9 = r3
            r10 = r9
            r11 = r10
        L2a:
            android.content.Context r2 = r14.f7033g     // Catch: java.lang.Exception -> L9e
            com.google.android.gms.internal.measurement.bd.E(r2)     // Catch: java.lang.Exception -> L9e
            java.lang.Boolean r2 = com.google.android.gms.internal.measurement.bd.T()     // Catch: java.lang.Exception -> L9e
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Exception -> L9e
            if (r2 != 0) goto L3e
            if (r10 == 0) goto L3c
            goto L3e
        L3c:
            r2 = r0
            goto L3f
        L3e:
            r2 = r1
        L3f:
            com.google.android.gms.internal.measurement.bd r3 = r14.f7035j     // Catch: java.lang.Exception -> L9e
            android.content.Context r4 = r14.f7033g     // Catch: java.lang.Exception -> L9e
            com.google.android.gms.internal.measurement.h9 r4 = r3.a(r4, r2)     // Catch: java.lang.Exception -> L9e
            com.google.android.gms.internal.measurement.bd.b(r3, r4)     // Catch: java.lang.Exception -> L9e
            com.google.android.gms.internal.measurement.bd r3 = r14.f7035j     // Catch: java.lang.Exception -> L9e
            com.google.android.gms.internal.measurement.h9 r3 = com.google.android.gms.internal.measurement.bd.C(r3)     // Catch: java.lang.Exception -> L9e
            if (r3 != 0) goto L5e
            com.google.android.gms.internal.measurement.bd r2 = r14.f7035j     // Catch: java.lang.Exception -> L9e
            java.lang.String r2 = com.google.android.gms.internal.measurement.bd.w(r2)     // Catch: java.lang.Exception -> L9e
            java.lang.String r3 = "Failed to connect to measurement client."
            android.util.Log.w(r2, r3)     // Catch: java.lang.Exception -> L9e
            return
        L5e:
            android.content.Context r3 = r14.f7033g     // Catch: java.lang.Exception -> L9e
            int r3 = com.google.android.gms.internal.measurement.bd.H(r3)     // Catch: java.lang.Exception -> L9e
            android.content.Context r4 = r14.f7033g     // Catch: java.lang.Exception -> L9e
            int r4 = com.google.android.gms.internal.measurement.bd.L(r4)     // Catch: java.lang.Exception -> L9e
            if (r2 == 0) goto L77
            int r2 = java.lang.Math.max(r3, r4)     // Catch: java.lang.Exception -> L9e
            if (r4 >= r3) goto L74
            r3 = r1
            goto L75
        L74:
            r3 = r0
        L75:
            r8 = r3
            goto L81
        L77:
            if (r3 <= 0) goto L7a
            r4 = r3
        L7a:
            if (r3 <= 0) goto L7e
            r2 = r1
            goto L7f
        L7e:
            r2 = r0
        L7f:
            r8 = r2
            r2 = r4
        L81:
            com.google.android.gms.internal.measurement.zc r13 = new com.google.android.gms.internal.measurement.zc     // Catch: java.lang.Exception -> L9e
            r4 = 26001(0x6591, double:1.2846E-319)
            long r6 = (long) r2     // Catch: java.lang.Exception -> L9e
            android.os.Bundle r12 = r14.f7034h     // Catch: java.lang.Exception -> L9e
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L9e
            com.google.android.gms.internal.measurement.bd r2 = r14.f7035j     // Catch: java.lang.Exception -> L9e
            com.google.android.gms.internal.measurement.h9 r2 = com.google.android.gms.internal.measurement.bd.C(r2)     // Catch: java.lang.Exception -> L9e
            android.content.Context r3 = r14.f7033g     // Catch: java.lang.Exception -> L9e
            com.google.android.gms.dynamic.a r3 = com.google.android.gms.dynamic.b.Y0(r3)     // Catch: java.lang.Exception -> L9e
            long r4 = r14.a     // Catch: java.lang.Exception -> L9e
            r2.initialize(r3, r13, r4)     // Catch: java.lang.Exception -> L9e
            return
        L9e:
            r2 = move-exception
            com.google.android.gms.internal.measurement.bd r3 = r14.f7035j
            com.google.android.gms.internal.measurement.bd.l(r3, r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.ad.a():void");
    }
}