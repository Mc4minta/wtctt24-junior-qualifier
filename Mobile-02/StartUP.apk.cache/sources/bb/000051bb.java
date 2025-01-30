package kotlin.c0.i.a;

import java.lang.reflect.Field;
import kotlin.jvm.internal.m;

/* compiled from: DebugMetadata.kt */
/* loaded from: classes3.dex */
public final class f {
    private static final void a(int i2, int i3) {
        if (i3 <= i2) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i2 + ", got " + i3 + ". Please update the Kotlin standard library.").toString());
    }

    private static final e b(a aVar) {
        return (e) aVar.getClass().getAnnotation(e.class);
    }

    private static final int c(a aVar) {
        try {
            Field field = aVar.getClass().getDeclaredField("label");
            m.f(field, "field");
            field.setAccessible(true);
            Object obj = field.get(aVar);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(a getStackTraceElementImpl) {
        String str;
        m.g(getStackTraceElementImpl, "$this$getStackTraceElementImpl");
        e b2 = b(getStackTraceElementImpl);
        if (b2 != null) {
            a(1, b2.v());
            int c2 = c(getStackTraceElementImpl);
            int i2 = c2 < 0 ? -1 : b2.l()[c2];
            String b3 = h.f17267c.b(getStackTraceElementImpl);
            if (b3 == null) {
                str = b2.c();
            } else {
                str = b3 + '/' + b2.c();
            }
            return new StackTraceElement(str, b2.m(), b2.f(), i2);
        }
        return null;
    }
}