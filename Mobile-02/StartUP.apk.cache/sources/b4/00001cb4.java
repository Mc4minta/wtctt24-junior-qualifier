package com.coinbase.wallet.ethereum.models;

import com.coinbase.ciphercore.ByteArray_CipherCoreKt;
import com.coinbase.wallet.core.extensions.Chars;
import com.coinbase.wallet.core.extensions.Chars_CoreKt;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.ethereum.interfaces.ETHABIEncoding;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.l0.a0;
import kotlin.l0.y;

/* compiled from: ETHABIEncodedBytes.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/ETHABIEncodedBytes;", "Lcom/coinbase/wallet/ethereum/interfaces/ETHABIEncoding;", "", "encode", "()Ljava/lang/String;", "", "isDynamicLength", "Z", "()Z", "", "data", "[B", "hex", "<init>", "(Ljava/lang/String;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ETHABIEncodedBytes implements ETHABIEncoding {
    private final byte[] data;
    private final boolean isDynamicLength;

    public ETHABIEncodedBytes(String hex) {
        m.g(hex, "hex");
        this.data = String_CoreKt.asHexEncodedData(hex);
        this.isDynamicLength = true;
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.ETHABIEncoding
    public String encode() {
        String encode;
        List<String> i1;
        List K0;
        int i2;
        String s0;
        if (this.data == null || (encode = new ETHABIEncodedUInt256(this.data.length).encode()) == null) {
            return null;
        }
        i1 = a0.i1(ByteArray_CipherCoreKt.toHexEncodedString$default(this.data, false, 1, null), 64);
        K0 = z.K0(i1);
        String str = (String) p.j0(K0);
        if (64 - str.length() > 0) {
            i2 = r.i(K0);
            s0 = y.s0(str, 64, Chars_CoreKt.getZero(Chars.INSTANCE));
            K0.set(i2, s0);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(encode);
        z.f0(K0, sb, Strings_CoreKt.getEmpty(Strings.INSTANCE), null, null, 0, null, null, 124, null);
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.ETHABIEncoding
    public boolean isDynamicLength() {
        return this.isDynamicLength;
    }
}