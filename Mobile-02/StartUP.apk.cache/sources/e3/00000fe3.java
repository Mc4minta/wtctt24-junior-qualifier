package com.coinbase.ciphercore;

import java.security.SecureRandom;
import kotlin.Metadata;

/* compiled from: Util.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "size", "", "getRandomBytes", "(I)[B", "cipher-core_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UtilKt {
    public static final byte[] getRandomBytes(int i2) {
        byte[] bArr = new byte[i2];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}