package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.ciphercore.ByteArray_CipherCoreKt;
import com.coinbase.wallet.crypto.extensions.String_CryptoKt;
import com.coinbase.wallet.ethereum.interfaces.ETHABIEncoding;
import com.coinbase.wallet.ethereum.models.ETHABIEncodedUInt256;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.a0.n;
import kotlin.a0.p;
import kotlin.i0.f;
import kotlin.jvm.internal.m;
import kotlin.l0.i;
import kotlin.l0.k;
import kotlin.l0.y;

/* compiled from: String+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u001a%\u0010\u0004\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"\u0019\u0010\b\u001a\u0004\u0018\u00010\u0000*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"", "", "Lcom/coinbase/wallet/ethereum/interfaces/ETHABIEncoding;", "parameters", "asETHCallRequestData", "(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;", "getAsETHABIEncodedMethod", "(Ljava/lang/String;)Ljava/lang/String;", "asETHABIEncodedMethod", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class String_EthereumKt {
    public static final String asETHCallRequestData(String str, List<? extends ETHABIEncoding> list) {
        List<String> b2;
        List K0;
        m.g(str, "<this>");
        i b3 = k.b(new k(".*\\((.*)\\)"), str, 0, 2, null);
        String asETHABIEncodedMethod = getAsETHABIEncodedMethod(str);
        if (asETHABIEncodedMethod == null) {
            return null;
        }
        String str2 = (b3 == null || (b2 = b3.b()) == null) ? null : (String) p.b0(b2, 1);
        if (str2 == null) {
            Locale US = Locale.US;
            m.f(US, "US");
            String lowerCase = asETHABIEncodedMethod.toLowerCase(US);
            m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        } else if (list == null) {
            Locale US2 = Locale.US;
            m.f(US2, "US");
            String lowerCase2 = asETHABIEncodedMethod.toLowerCase(US2);
            m.f(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase2;
        } else {
            K0 = y.K0(str2, new String[]{","}, false, 0, 6, null);
            int size = K0.size();
            StringBuilder sb = new StringBuilder();
            int i2 = size * 32;
            StringBuilder sb2 = new StringBuilder(asETHABIEncodedMethod);
            for (ETHABIEncoding eTHABIEncoding : list) {
                String encode = eTHABIEncoding.encode();
                if (encode == null) {
                    return null;
                }
                if (eTHABIEncoding.isDynamicLength()) {
                    String encode2 = new ETHABIEncodedUInt256(i2).encode();
                    if (encode2 == null) {
                        return null;
                    }
                    sb2.append(encode2);
                    i2 += encode.length();
                    sb.append(encode);
                } else {
                    sb2.append(encode);
                }
            }
            sb2.append((CharSequence) sb);
            String sb3 = sb2.toString();
            m.f(sb3, "dataBuilder.toString()");
            Locale US3 = Locale.US;
            m.f(US3, "US");
            String lowerCase3 = sb3.toLowerCase(US3);
            m.f(lowerCase3, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase3;
        }
    }

    public static /* synthetic */ String asETHCallRequestData$default(String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = null;
        }
        return asETHCallRequestData(str, list);
    }

    public static final String getAsETHABIEncodedMethod(String str) {
        kotlin.i0.c j2;
        byte[] T;
        m.g(str, "<this>");
        byte[] keccak256 = String_CryptoKt.keccak256(str);
        j2 = f.j(0, 4);
        T = n.T(keccak256, j2);
        return ByteArray_CipherCoreKt.toHexEncodedString(T, true);
    }
}