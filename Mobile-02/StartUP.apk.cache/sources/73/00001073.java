package com.coinbase.cipherwebview.util;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.l0.x;

/* compiled from: String+CipherWebView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0003\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "prepend0x", "(Ljava/lang/String;)Ljava/lang/String;", "strip0x", "", "toByteArrayUsingHexEncoding", "(Ljava/lang/String;)[B", "hexadecimalCharacters", "Ljava/lang/String;", "cipher-webview_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class String_CipherWebViewKt {
    private static final String hexadecimalCharacters = "0123456789abcdef";

    public static final String prepend0x(String str) {
        boolean Q;
        m.g(str, "<this>");
        Q = x.Q(str, "0x", false, 2, null);
        return Q ? str : m.o("0x", str);
    }

    public static final String strip0x(String str) {
        boolean Q;
        m.g(str, "<this>");
        Q = x.Q(str, "0x", false, 2, null);
        if (Q) {
            String substring = str.substring(2);
            m.f(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
        r4 = kotlin.l0.y.h0(com.coinbase.cipherwebview.util.String_CipherWebViewKt.hexadecimalCharacters, r14.charAt(r4 + 1), 0, false, 6, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final byte[] toByteArrayUsingHexEncoding(java.lang.String r14) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.m.g(r14, r0)
            java.lang.String r14 = strip0x(r14)
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            java.util.Objects.requireNonNull(r14, r0)
            java.lang.String r14 = r14.toLowerCase()
            java.lang.String r0 = "(this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.m.f(r14, r0)
            int r0 = r14.length()
            int r0 = r0 % 2
            if (r0 != 0) goto L20
            goto L26
        L20:
            java.lang.String r0 = "0"
            java.lang.String r14 = kotlin.jvm.internal.m.o(r0, r14)
        L26:
            int r0 = r14.length()
            int r0 = r0 / 2
            byte[] r1 = new byte[r0]
            r2 = 0
            if (r0 <= 0) goto L66
        L31:
            int r3 = r2 + 1
            int r4 = r2 * 2
            char r6 = r14.charAt(r4)
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            java.lang.String r5 = "0123456789abcdef"
            int r5 = kotlin.l0.o.h0(r5, r6, r7, r8, r9, r10)
            r6 = 0
            r7 = -1
            if (r5 != r7) goto L48
            return r6
        L48:
            int r4 = r4 + 1
            char r9 = r14.charAt(r4)
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            java.lang.String r8 = "0123456789abcdef"
            int r4 = kotlin.l0.o.h0(r8, r9, r10, r11, r12, r13)
            if (r4 != r7) goto L5b
            return r6
        L5b:
            int r5 = r5 * 16
            int r5 = r5 + r4
            byte r4 = (byte) r5
            r1[r2] = r4
            if (r3 < r0) goto L64
            goto L66
        L64:
            r2 = r3
            goto L31
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.cipherwebview.util.String_CipherWebViewKt.toByteArrayUsingHexEncoding(java.lang.String):byte[]");
    }
}