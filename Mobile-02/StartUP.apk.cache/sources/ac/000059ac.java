package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.m;
import kotlin.l0.x;

/* compiled from: numbers.kt */
/* loaded from: classes3.dex */
public final class NumbersKt {
    public static final NumberWithRadix extractRadix(String value) {
        boolean Q;
        boolean Q2;
        boolean Q3;
        boolean Q4;
        m.g(value, "value");
        Q = x.Q(value, "0x", false, 2, null);
        if (!Q) {
            Q2 = x.Q(value, "0X", false, 2, null);
            if (!Q2) {
                Q3 = x.Q(value, "0b", false, 2, null);
                if (!Q3) {
                    Q4 = x.Q(value, "0B", false, 2, null);
                    if (!Q4) {
                        return new NumberWithRadix(value, 10);
                    }
                }
                String substring = value.substring(2);
                m.f(substring, "(this as java.lang.String).substring(startIndex)");
                return new NumberWithRadix(substring, 2);
            }
        }
        String substring2 = value.substring(2);
        m.f(substring2, "(this as java.lang.String).substring(startIndex)");
        return new NumberWithRadix(substring2, 16);
    }
}