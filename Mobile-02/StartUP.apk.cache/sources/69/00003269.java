package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
abstract class a4 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i2 = 0;
        while (i2 < length) {
            try {
                char charAt = charSequence.charAt(i2);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i2, (byte) charAt);
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                char charAt2 = charSequence.charAt(i2);
                StringBuilder sb = new StringBuilder(37);
                sb.append("Failed writing ");
                sb.append(charAt2);
                sb.append(" at index ");
                sb.append(byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1));
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
        }
        if (i2 == length) {
            byteBuffer.position(position + i2);
            return;
        }
        position += i2;
        while (i2 < length) {
            char charAt3 = charSequence.charAt(i2);
            if (charAt3 < 128) {
                byteBuffer.put(position, (byte) charAt3);
            } else if (charAt3 < 2048) {
                int i3 = position + 1;
                try {
                    byteBuffer.put(position, (byte) ((charAt3 >>> 6) | 192));
                    byteBuffer.put(i3, (byte) ((charAt3 & '?') | 128));
                    position = i3;
                } catch (IndexOutOfBoundsException unused2) {
                    position = i3;
                    char charAt22 = charSequence.charAt(i2);
                    StringBuilder sb2 = new StringBuilder(37);
                    sb2.append("Failed writing ");
                    sb2.append(charAt22);
                    sb2.append(" at index ");
                    sb2.append(byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1));
                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                }
            } else if (charAt3 >= 55296 && 57343 >= charAt3) {
                int i4 = i2 + 1;
                if (i4 != length) {
                    try {
                        char charAt4 = charSequence.charAt(i4);
                        if (Character.isSurrogatePair(charAt3, charAt4)) {
                            int codePoint = Character.toCodePoint(charAt3, charAt4);
                            int i5 = position + 1;
                            try {
                                byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                int i6 = i5 + 1;
                                byteBuffer.put(i5, (byte) (((codePoint >>> 12) & 63) | 128));
                                int i7 = i6 + 1;
                                byteBuffer.put(i6, (byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put(i7, (byte) ((codePoint & 63) | 128));
                                position = i7;
                                i2 = i4;
                            } catch (IndexOutOfBoundsException unused3) {
                                position = i5;
                                i2 = i4;
                                char charAt222 = charSequence.charAt(i2);
                                StringBuilder sb22 = new StringBuilder(37);
                                sb22.append("Failed writing ");
                                sb22.append(charAt222);
                                sb22.append(" at index ");
                                sb22.append(byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1));
                                throw new ArrayIndexOutOfBoundsException(sb22.toString());
                            }
                        } else {
                            i2 = i4;
                        }
                    } catch (IndexOutOfBoundsException unused4) {
                    }
                }
                throw new c4(i2, length);
            } else {
                int i8 = position + 1;
                byteBuffer.put(position, (byte) ((charAt3 >>> '\f') | 224));
                position = i8 + 1;
                byteBuffer.put(i8, (byte) (((charAt3 >>> 6) & 63) | 128));
                byteBuffer.put(position, (byte) ((charAt3 & '?') | 128));
            }
            i2++;
            position++;
        }
        byteBuffer.position(position);
    }

    abstract int a(int i2, byte[] bArr, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int b(CharSequence charSequence, byte[] bArr, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(CharSequence charSequence, ByteBuffer byteBuffer);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e(byte[] bArr, int i2, int i3) {
        return a(0, bArr, i2, i3) == 0;
    }
}