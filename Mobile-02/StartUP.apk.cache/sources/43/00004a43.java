package e.j.l.p;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: CryptoUtil.kt */
/* loaded from: classes2.dex */
public final class d {
    public static final a a = new a(null);

    /* compiled from: CryptoUtil.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final byte[] a(byte[] bytes) {
            byte[] h2;
            m.g(bytes, "bytes");
            h2 = kotlin.a0.m.h(bytes, 12, bytes.length);
            return h2;
        }

        public final byte[] b(byte[] bytes) {
            byte[] h2;
            m.g(bytes, "bytes");
            h2 = kotlin.a0.m.h(bytes, 0, 12);
            return h2;
        }

        public final byte[] c(byte[] encryptedBytes, byte[] iv) {
            m.g(encryptedBytes, "encryptedBytes");
            m.g(iv, "iv");
            byte[] bArr = new byte[iv.length + encryptedBytes.length];
            System.arraycopy(iv, 0, bArr, 0, iv.length);
            System.arraycopy(encryptedBytes, 0, bArr, iv.length, encryptedBytes.length);
            return bArr;
        }

        public final byte[] d(byte[] encryptedBytes, byte[] iv) {
            m.g(encryptedBytes, "encryptedBytes");
            m.g(iv, "iv");
            int length = encryptedBytes.length - iv.length;
            byte[] bArr = new byte[length];
            System.arraycopy(encryptedBytes, iv.length, bArr, 0, length);
            return bArr;
        }
    }
}