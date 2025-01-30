package com.coinbase.wallet.core.extensions;

import java.math.BigInteger;
import kotlin.Metadata;

/* compiled from: BigIntegers+Core.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/core/extensions/BigIntegers;", "", "hex", "Ljava/math/BigInteger;", "fromHex", "(Lcom/coinbase/wallet/core/extensions/BigIntegers;Ljava/lang/String;)Ljava/math/BigInteger;", "core_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BigIntegers_CoreKt {
    public static final BigInteger fromHex(BigIntegers bigIntegers, String hex) {
        kotlin.jvm.internal.m.g(bigIntegers, "<this>");
        kotlin.jvm.internal.m.g(hex, "hex");
        try {
            return new BigInteger(String_CoreKt.strip0x(hex), 16);
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}