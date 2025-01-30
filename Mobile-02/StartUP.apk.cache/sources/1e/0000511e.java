package j;

/* compiled from: Utf8.kt */
/* loaded from: classes3.dex */
public final class g0 {
    public static final long a(String utf8Size, int i2, int i3) {
        int i4;
        kotlin.jvm.internal.m.g(utf8Size, "$this$utf8Size");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i2).toString());
        }
        if (i3 >= i2) {
            if (!(i3 <= utf8Size.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + utf8Size.length()).toString());
            }
            long j2 = 0;
            while (i2 < i3) {
                char charAt = utf8Size.charAt(i2);
                if (charAt < 128) {
                    j2++;
                } else {
                    if (charAt < 2048) {
                        i4 = 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        i4 = 3;
                    } else {
                        int i5 = i2 + 1;
                        char charAt2 = i5 < i3 ? utf8Size.charAt(i5) : (char) 0;
                        if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                            j2++;
                            i2 = i5;
                        } else {
                            j2 += 4;
                            i2 += 2;
                        }
                    }
                    j2 += i4;
                }
                i2++;
            }
            return j2;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
    }

    public static /* synthetic */ long b(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return a(str, i2, i3);
    }
}