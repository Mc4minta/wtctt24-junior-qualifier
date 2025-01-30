package com.google.android.gms.common.l;

import android.util.Log;
import com.google.android.gms.common.internal.j;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class a {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6285b;

    /* renamed from: c  reason: collision with root package name */
    private final j f6286c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6287d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(java.lang.String r7, java.lang.String... r8) {
        /*
            r6 = this;
            int r0 = r8.length
            if (r0 != 0) goto L6
            java.lang.String r8 = ""
            goto L36
        L6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 91
            r0.append(r1)
            int r1 = r8.length
            r2 = 0
        L12:
            if (r2 >= r1) goto L28
            r3 = r8[r2]
            int r4 = r0.length()
            r5 = 1
            if (r4 <= r5) goto L22
            java.lang.String r4 = ","
            r0.append(r4)
        L22:
            r0.append(r3)
            int r2 = r2 + 1
            goto L12
        L28:
            r8 = 93
            r0.append(r8)
            r8 = 32
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L36:
            r6.<init>(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.l.a.<init>(java.lang.String, java.lang.String[]):void");
    }

    public void a(String str, Object... objArr) {
        if (e(3)) {
            Log.d(this.a, c(str, objArr));
        }
    }

    public void b(String str, Object... objArr) {
        Log.e(this.a, c(str, objArr));
    }

    protected String c(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f6285b.concat(str);
    }

    public void d(String str, Object... objArr) {
        Log.i(this.a, c(str, objArr));
    }

    public boolean e(int i2) {
        return this.f6287d <= i2;
    }

    public void f(String str, Object... objArr) {
        Log.w(this.a, c(str, objArr));
    }

    private a(String str, String str2) {
        this.f6285b = str2;
        this.a = str;
        this.f6286c = new j(str);
        int i2 = 2;
        while (7 >= i2 && !Log.isLoggable(this.a, i2)) {
            i2++;
        }
        this.f6287d = i2;
    }
}