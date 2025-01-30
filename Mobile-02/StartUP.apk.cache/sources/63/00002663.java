package com.coinbase.wallet.store.extensions;

import android.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.t;

/* compiled from: String+Store.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\u001a'\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0002*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "Lkotlin/t;", "", "parseAES256GMPayload", "(Ljava/lang/String;)Lkotlin/t;", "base64DecodedByteArray", "(Ljava/lang/String;)[B", "store_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class String_StoreKt {
    public static final byte[] base64DecodedByteArray(String str) throws IllegalArgumentException {
        m.g(str, "<this>");
        byte[] decode = Base64.decode(str, 2);
        m.f(decode, "decode(this, Base64.NO_WRAP)");
        return decode;
    }

    public static final t<byte[], byte[], byte[]> parseAES256GMPayload(String str) {
        byte[] h2;
        byte[] h3;
        byte[] h4;
        m.g(str, "<this>");
        byte[] base64DecodedByteArray = base64DecodedByteArray(str);
        h2 = kotlin.a0.m.h(base64DecodedByteArray, 0, 12);
        h3 = kotlin.a0.m.h(base64DecodedByteArray, 12, 28);
        h4 = kotlin.a0.m.h(base64DecodedByteArray, 28, base64DecodedByteArray.length);
        return new t<>(h2, h3, h4);
    }
}