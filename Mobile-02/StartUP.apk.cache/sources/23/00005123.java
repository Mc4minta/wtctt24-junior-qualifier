package j;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ByteString.kt */
/* loaded from: classes3.dex */
public class i implements Serializable, Comparable<i> {

    /* renamed from: c  reason: collision with root package name */
    private transient int f17152c;

    /* renamed from: d  reason: collision with root package name */
    private transient String f17153d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f17154e;

    /* renamed from: b  reason: collision with root package name */
    public static final a f17151b = new a(null);
    public static final i a = new i(new byte[0]);

    /* compiled from: ByteString.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ i g(a aVar, byte[] bArr, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = bArr.length;
            }
            return aVar.f(bArr, i2, i3);
        }

        public final i a(String decodeBase64) {
            kotlin.jvm.internal.m.g(decodeBase64, "$this$decodeBase64");
            byte[] a = j.a.a(decodeBase64);
            if (a != null) {
                return new i(a);
            }
            return null;
        }

        public final i b(String decodeHex) {
            kotlin.jvm.internal.m.g(decodeHex, "$this$decodeHex");
            if (decodeHex.length() % 2 == 0) {
                int length = decodeHex.length() / 2;
                byte[] bArr = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i2 * 2;
                    bArr[i2] = (byte) ((j.h0.b.b(decodeHex.charAt(i3)) << 4) + j.h0.b.b(decodeHex.charAt(i3 + 1)));
                }
                return new i(bArr);
            }
            throw new IllegalArgumentException(("Unexpected hex string: " + decodeHex).toString());
        }

        public final i c(String encode, Charset charset) {
            kotlin.jvm.internal.m.g(encode, "$this$encode");
            kotlin.jvm.internal.m.g(charset, "charset");
            byte[] bytes = encode.getBytes(charset);
            kotlin.jvm.internal.m.f(bytes, "(this as java.lang.String).getBytes(charset)");
            return new i(bytes);
        }

        public final i d(String encodeUtf8) {
            kotlin.jvm.internal.m.g(encodeUtf8, "$this$encodeUtf8");
            i iVar = new i(b.a(encodeUtf8));
            iVar.N(encodeUtf8);
            return iVar;
        }

        public final i e(byte... data) {
            kotlin.jvm.internal.m.g(data, "data");
            byte[] copyOf = Arrays.copyOf(data, data.length);
            kotlin.jvm.internal.m.f(copyOf, "java.util.Arrays.copyOf(this, size)");
            return new i(copyOf);
        }

        public final i f(byte[] toByteString, int i2, int i3) {
            kotlin.jvm.internal.m.g(toByteString, "$this$toByteString");
            c.b(toByteString.length, i2, i3);
            return new i(kotlin.a0.j.h(toByteString, i2, i3 + i2));
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public i(byte[] data) {
        kotlin.jvm.internal.m.g(data, "data");
        this.f17154e = data;
    }

    public static final i J(byte... bArr) {
        return f17151b.e(bArr);
    }

    public static final i q(String str) {
        return f17151b.a(str);
    }

    public static final i s(String str) {
        return f17151b.b(str);
    }

    public static final i z(String str) {
        return f17151b.d(str);
    }

    public final byte A(int i2) {
        return H(i2);
    }

    public final byte[] B() {
        return this.f17154e;
    }

    public final int C() {
        return this.f17152c;
    }

    public int D() {
        return B().length;
    }

    public final String E() {
        return this.f17153d;
    }

    public String F() {
        byte[] B;
        char[] cArr = new char[B().length * 2];
        int i2 = 0;
        for (byte b2 : B()) {
            int i3 = i2 + 1;
            cArr[i2] = j.h0.b.f()[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = j.h0.b.f()[b2 & 15];
        }
        return new String(cArr);
    }

    public byte[] G() {
        return B();
    }

    public byte H(int i2) {
        return B()[i2];
    }

    public final i I() {
        return y("MD5");
    }

    public boolean K(int i2, i other, int i3, int i4) {
        kotlin.jvm.internal.m.g(other, "other");
        return other.L(i3, B(), i2, i4);
    }

    public boolean L(int i2, byte[] other, int i3, int i4) {
        kotlin.jvm.internal.m.g(other, "other");
        return i2 >= 0 && i2 <= B().length - i4 && i3 >= 0 && i3 <= other.length - i4 && c.a(B(), i2, other, i3, i4);
    }

    public final void M(int i2) {
        this.f17152c = i2;
    }

    public final void N(String str) {
        this.f17153d = str;
    }

    public final i O() {
        return y("SHA-1");
    }

    public final i P() {
        return y("SHA-256");
    }

    public final int Q() {
        return D();
    }

    public final boolean R(i prefix) {
        kotlin.jvm.internal.m.g(prefix, "prefix");
        return K(0, prefix, 0, prefix.Q());
    }

    public i S() {
        byte b2;
        for (int i2 = 0; i2 < B().length; i2++) {
            byte b3 = B()[i2];
            byte b4 = (byte) 65;
            if (b3 >= b4 && b3 <= (b2 = (byte) 90)) {
                byte[] B = B();
                byte[] copyOf = Arrays.copyOf(B, B.length);
                kotlin.jvm.internal.m.f(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b3 + 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b5 = copyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        copyOf[i3] = (byte) (b5 + 32);
                    }
                }
                return new i(copyOf);
            }
        }
        return this;
    }

    public byte[] T() {
        byte[] B = B();
        byte[] copyOf = Arrays.copyOf(B, B.length);
        kotlin.jvm.internal.m.f(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    public String U() {
        String E = E();
        if (E == null) {
            String b2 = b.b(G());
            N(b2);
            return b2;
        }
        return E;
    }

    public void V(f buffer, int i2, int i3) {
        kotlin.jvm.internal.m.g(buffer, "buffer");
        j.h0.b.d(this, buffer, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (iVar.Q() == B().length && iVar.L(0, B(), 0, B().length)) {
                return true;
            }
        }
        return false;
    }

    public String h() {
        return j.a.c(B(), null, 1, null);
    }

    public int hashCode() {
        int C = C();
        if (C != 0) {
            return C;
        }
        int hashCode = Arrays.hashCode(B());
        M(hashCode);
        return hashCode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r0 < r1) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
        if (r7 < r8) goto L12;
     */
    @Override // java.lang.Comparable
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(j.i r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.m.g(r10, r0)
            int r0 = r9.Q()
            int r1 = r10.Q()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.A(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.A(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L32
            goto L30
        L2b:
            if (r0 != r1) goto L2e
            goto L33
        L2e:
            if (r0 >= r1) goto L32
        L30:
            r3 = r5
            goto L33
        L32:
            r3 = r6
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j.i.compareTo(j.i):int");
    }

    public String toString() {
        String K;
        String K2;
        String K3;
        if (B().length == 0) {
            return "[size=0]";
        }
        int a2 = j.h0.b.a(B(), 64);
        if (a2 == -1) {
            if (B().length <= 64) {
                return "[hex=" + F() + ']';
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(B().length);
            sb.append(" hex=");
            if (64 <= B().length) {
                sb.append((64 == B().length ? this : new i(kotlin.a0.j.h(B(), 0, 64))).F());
                sb.append("…]");
                return sb.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + B().length + ')').toString());
        }
        String U = U();
        Objects.requireNonNull(U, "null cannot be cast to non-null type java.lang.String");
        String substring = U.substring(0, a2);
        kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        K = kotlin.l0.x.K(substring, "\\", "\\\\", false, 4, null);
        K2 = kotlin.l0.x.K(K, "\n", "\\n", false, 4, null);
        K3 = kotlin.l0.x.K(K2, "\r", "\\r", false, 4, null);
        if (a2 < U.length()) {
            return "[size=" + B().length + " text=" + K3 + "…]";
        }
        return "[text=" + K3 + ']';
    }

    public i y(String algorithm) {
        kotlin.jvm.internal.m.g(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.f17154e, 0, Q());
        byte[] digestBytes = messageDigest.digest();
        kotlin.jvm.internal.m.f(digestBytes, "digestBytes");
        return new i(digestBytes);
    }
}