package e.g.b.a.d.h0;

/* compiled from: PercentEscaper.java */
/* loaded from: classes2.dex */
public class c extends e {
    private static final char[] a = {'+'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f13416b = "0123456789ABCDEF".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    private final boolean f13417c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean[] f13418d;

    public c(String str, boolean z) {
        if (!str.matches(".*[0-9A-Za-z].*")) {
            if (z && str.contains(" ")) {
                throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
            }
            if (!str.contains("%")) {
                this.f13417c = z;
                this.f13418d = g(str);
                return;
            }
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        }
        throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
    }

    private static boolean[] g(String str) {
        char[] charArray = str.toCharArray();
        int i2 = 122;
        for (char c2 : charArray) {
            i2 = Math.max((int) c2, i2);
        }
        boolean[] zArr = new boolean[i2 + 1];
        for (int i3 = 48; i3 <= 57; i3++) {
            zArr[i3] = true;
        }
        for (int i4 = 65; i4 <= 90; i4++) {
            zArr[i4] = true;
        }
        for (int i5 = 97; i5 <= 122; i5++) {
            zArr[i5] = true;
        }
        for (char c3 : charArray) {
            zArr[c3] = true;
        }
        return zArr;
    }

    @Override // e.g.b.a.d.h0.b
    public String a(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            boolean[] zArr = this.f13418d;
            if (charAt >= zArr.length || !zArr[charAt]) {
                return d(str, i2);
            }
        }
        return str;
    }

    @Override // e.g.b.a.d.h0.e
    protected char[] c(int i2) {
        boolean[] zArr = this.f13418d;
        if (i2 >= zArr.length || !zArr[i2]) {
            if (i2 == 32 && this.f13417c) {
                return a;
            }
            if (i2 <= 127) {
                char[] cArr = f13416b;
                return new char[]{'%', cArr[i2 >>> 4], cArr[i2 & 15]};
            } else if (i2 <= 2047) {
                char[] cArr2 = f13416b;
                char[] cArr3 = {'%', cArr2[(r14 >>> 4) | 12], cArr2[r14 & 15], '%', cArr2[(r14 & 3) | 8], cArr2[i2 & 15]};
                int i3 = i2 >>> 4;
                int i4 = i3 >>> 2;
                return cArr3;
            } else if (i2 <= 65535) {
                char[] cArr4 = f13416b;
                char[] cArr5 = {'%', 'E', cArr4[r14 >>> 2], '%', cArr4[(r14 & 3) | 8], cArr4[r14 & 15], '%', cArr4[(r14 & 3) | 8], cArr4[i2 & 15]};
                int i5 = i2 >>> 4;
                int i6 = i5 >>> 2;
                int i7 = i6 >>> 4;
                return cArr5;
            } else if (i2 <= 1114111) {
                char[] cArr6 = f13416b;
                char[] cArr7 = {'%', 'F', cArr6[(r14 >>> 2) & 7], '%', cArr6[(r14 & 3) | 8], cArr6[r14 & 15], '%', cArr6[(r14 & 3) | 8], cArr6[r14 & 15], '%', cArr6[(r14 & 3) | 8], cArr6[i2 & 15]};
                int i8 = i2 >>> 4;
                int i9 = i8 >>> 2;
                int i10 = i9 >>> 4;
                int i11 = i10 >>> 2;
                int i12 = i11 >>> 4;
                return cArr7;
            } else {
                throw new IllegalArgumentException("Invalid unicode character value " + i2);
            }
        }
        return null;
    }

    @Override // e.g.b.a.d.h0.e
    protected int f(CharSequence charSequence, int i2, int i3) {
        while (i2 < i3) {
            char charAt = charSequence.charAt(i2);
            boolean[] zArr = this.f13418d;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i2++;
        }
        return i2;
    }
}