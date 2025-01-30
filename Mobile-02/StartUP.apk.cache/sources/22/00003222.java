package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.p0;
import com.google.android.gms.common.internal.r0;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public abstract class r extends r0 {
    private int a;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(byte[] bArr) {
        com.google.android.gms.common.internal.t.a(bArr.length == 25);
        this.a = Arrays.hashCode(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] Y0(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.google.android.gms.common.internal.p0
    public final com.google.android.gms.dynamic.a b() {
        return com.google.android.gms.dynamic.b.Y0(q());
    }

    @Override // com.google.android.gms.common.internal.p0
    public final int c() {
        return hashCode();
    }

    public boolean equals(Object obj) {
        com.google.android.gms.dynamic.a b2;
        if (obj != null && (obj instanceof p0)) {
            try {
                p0 p0Var = (p0) obj;
                if (p0Var.c() == hashCode() && (b2 = p0Var.b()) != null) {
                    return Arrays.equals(q(), (byte[]) com.google.android.gms.dynamic.b.q(b2));
                }
                return false;
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            }
        }
        return false;
    }

    public int hashCode() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] q();
}