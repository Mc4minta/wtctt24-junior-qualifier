package e.j.f;

import android.util.Base64;

/* compiled from: ByteArrayExtensions.kt */
/* loaded from: classes2.dex */
public final class f {
    public static final String a(byte[] bArr) {
        kotlin.jvm.internal.m.g(bArr, "<this>");
        String encodeToString = Base64.encodeToString(bArr, 2);
        kotlin.jvm.internal.m.f(encodeToString, "encodeToString(this, Base64.NO_WRAP)");
        return encodeToString;
    }
}