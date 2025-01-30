package okhttp3.logging;

import j.f;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: utf8.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lj/f;", "", "isProbablyUtf8", "(Lj/f;)Z", "okhttp-logging-interceptor"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class Utf8Kt {
    public static final boolean isProbablyUtf8(f isProbablyUtf8) {
        long e2;
        m.h(isProbablyUtf8, "$this$isProbablyUtf8");
        try {
            f fVar = new f();
            e2 = kotlin.i0.f.e(isProbablyUtf8.O0(), 64L);
            isProbablyUtf8.f(fVar, 0L, e2);
            for (int i2 = 0; i2 < 16; i2++) {
                if (fVar.Q()) {
                    return true;
                }
                int L0 = fVar.L0();
                if (Character.isISOControl(L0) && !Character.isWhitespace(L0)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}