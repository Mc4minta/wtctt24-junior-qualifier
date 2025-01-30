package j.h0;

import j.f;
import j.i;
import kotlin.jvm.internal.m;

/* compiled from: ByteString.kt */
/* loaded from: classes3.dex */
public final class b {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final /* synthetic */ int a(byte[] bArr, int i2) {
        return c(bArr, i2);
    }

    public static final /* synthetic */ int b(char c2) {
        return e(c2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006b, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int c(byte[] r19, int r20) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j.h0.b.c(byte[], int):int");
    }

    public static final void d(i commonWrite, f buffer, int i2, int i3) {
        m.g(commonWrite, "$this$commonWrite");
        m.g(buffer, "buffer");
        buffer.write(commonWrite.B(), i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        char c3 = 'a';
        if ('a' > c2 || 'f' < c2) {
            c3 = 'A';
            if ('A' > c2 || 'F' < c2) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    public static final char[] f() {
        return a;
    }
}