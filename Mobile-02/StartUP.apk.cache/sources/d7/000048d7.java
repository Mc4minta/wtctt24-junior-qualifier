package e.g.b.a.d.h0;

/* compiled from: UnicodeEscaper.java */
/* loaded from: classes2.dex */
public abstract class e extends b {
    protected static int b(CharSequence charSequence, int i2, int i3) {
        if (i2 < i3) {
            int i4 = i2 + 1;
            char charAt = charSequence.charAt(i2);
            if (charAt < 55296 || charAt > 57343) {
                return charAt;
            }
            if (charAt > 56319) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected low surrogate character '");
                sb.append(charAt);
                sb.append("' with value ");
                sb.append((int) charAt);
                sb.append(" at index ");
                sb.append(i4 - 1);
                throw new IllegalArgumentException(sb.toString());
            } else if (i4 == i3) {
                return -charAt;
            } else {
                char charAt2 = charSequence.charAt(i4);
                if (Character.isLowSurrogate(charAt2)) {
                    return Character.toCodePoint(charAt, charAt2);
                }
                throw new IllegalArgumentException("Expected low surrogate but got char '" + charAt2 + "' with value " + ((int) charAt2) + " at index " + i4);
            }
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    private static char[] e(char[] cArr, int i2, int i3) {
        char[] cArr2 = new char[i3];
        if (i2 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i2);
        }
        return cArr2;
    }

    protected abstract char[] c(int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public final String d(String str, int i2) {
        int length = str.length();
        char[] a = d.a();
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int b2 = b(str, i2, length);
            if (b2 >= 0) {
                char[] c2 = c(b2);
                int i5 = (Character.isSupplementaryCodePoint(b2) ? 2 : 1) + i2;
                if (c2 != null) {
                    int i6 = i2 - i3;
                    int i7 = i4 + i6;
                    int length2 = c2.length + i7;
                    if (a.length < length2) {
                        a = e(a, i4, ((length2 + length) - i2) + 32);
                    }
                    if (i6 > 0) {
                        str.getChars(i3, i2, a, i4);
                        i4 = i7;
                    }
                    if (c2.length > 0) {
                        System.arraycopy(c2, 0, a, i4, c2.length);
                        i4 += c2.length;
                    }
                    i3 = i5;
                }
                i2 = f(str, i5, length);
            } else {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
        }
        int i8 = length - i3;
        if (i8 > 0) {
            int i9 = i8 + i4;
            if (a.length < i9) {
                a = e(a, i4, i9);
            }
            str.getChars(i3, length, a, i4);
            i4 = i9;
        }
        return new String(a, 0, i4);
    }

    protected abstract int f(CharSequence charSequence, int i2, int i3);
}