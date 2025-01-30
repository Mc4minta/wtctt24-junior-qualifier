package com.facebook.react.modules.network;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* compiled from: ProgressiveStringDecoder.java */
/* loaded from: classes2.dex */
public class k {
    private final CharsetDecoder a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f4985b = null;

    public k(Charset charset) {
        this.a = charset.newDecoder();
    }

    public String a(byte[] bArr, int i2) {
        byte[] bArr2 = this.f4985b;
        if (bArr2 != null) {
            byte[] bArr3 = new byte[bArr2.length + i2];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, 0, bArr3, this.f4985b.length, i2);
            i2 += this.f4985b.length;
            bArr = bArr3;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, i2);
        boolean z = true;
        boolean z2 = false;
        int i3 = 0;
        CharBuffer charBuffer = null;
        while (!z2 && i3 < 4) {
            try {
                charBuffer = this.a.decode(wrap);
                z2 = true;
            } catch (CharacterCodingException unused) {
                i3++;
                wrap = ByteBuffer.wrap(bArr, 0, i2 - i3);
            }
        }
        if (!z2 || i3 <= 0) {
            z = false;
        }
        if (z) {
            byte[] bArr4 = new byte[i3];
            this.f4985b = bArr4;
            System.arraycopy(bArr, i2 - i3, bArr4, 0, i3);
        } else {
            this.f4985b = null;
        }
        if (!z2) {
            e.f.d.d.a.A("ReactNative", "failed to decode string from byte array");
            return "";
        }
        return new String(charBuffer.array(), 0, charBuffer.length());
    }
}