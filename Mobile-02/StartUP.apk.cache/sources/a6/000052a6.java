package kotlin.l0;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversionsJVM.kt */
/* loaded from: classes3.dex */
public class v extends u {
    public static BigDecimal j(String toBigDecimalOrNull) {
        kotlin.jvm.internal.m.g(toBigDecimalOrNull, "$this$toBigDecimalOrNull");
        try {
            if (n.a.d(toBigDecimalOrNull)) {
                return new BigDecimal(toBigDecimalOrNull);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static BigInteger k(String toBigIntegerOrNull) {
        kotlin.jvm.internal.m.g(toBigIntegerOrNull, "$this$toBigIntegerOrNull");
        return l(toBigIntegerOrNull, 10);
    }

    public static final BigInteger l(String toBigIntegerOrNull, int i2) {
        int a;
        kotlin.jvm.internal.m.g(toBigIntegerOrNull, "$this$toBigIntegerOrNull");
        b.a(i2);
        int length = toBigIntegerOrNull.length();
        if (length != 0) {
            if (length != 1) {
                for (int i3 = toBigIntegerOrNull.charAt(0) == '-' ? 1 : 0; i3 < length; i3++) {
                    if (b.b(toBigIntegerOrNull.charAt(i3), i2) < 0) {
                        return null;
                    }
                }
            } else if (b.b(toBigIntegerOrNull.charAt(0), i2) < 0) {
                return null;
            }
            a = b.a(i2);
            return new BigInteger(toBigIntegerOrNull, a);
        }
        return null;
    }

    public static Double m(String toDoubleOrNull) {
        kotlin.jvm.internal.m.g(toDoubleOrNull, "$this$toDoubleOrNull");
        try {
            if (n.a.d(toDoubleOrNull)) {
                return Double.valueOf(Double.parseDouble(toDoubleOrNull));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Float n(String toFloatOrNull) {
        kotlin.jvm.internal.m.g(toFloatOrNull, "$this$toFloatOrNull");
        try {
            if (n.a.d(toFloatOrNull)) {
                return Float.valueOf(Float.parseFloat(toFloatOrNull));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}