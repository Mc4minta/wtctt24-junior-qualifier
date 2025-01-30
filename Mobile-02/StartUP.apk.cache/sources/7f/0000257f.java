package com.coinbase.wallet.ripple.extensions;

import com.coinbase.wallet.blockchains.models.AddressType;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: AddressKind+Ripple.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/AddressType$Companion;", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "XRP$delegate", "Lkotlin/h;", "getXRP", "(Lcom/coinbase/wallet/blockchains/models/AddressType$Companion;)Lcom/coinbase/wallet/blockchains/models/AddressType;", "XRP", "ripple_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AddressKind_RippleKt {
    private static final h XRP$delegate;

    static {
        h b2;
        b2 = k.b(AddressKind_RippleKt$XRP$2.INSTANCE);
        XRP$delegate = b2;
    }

    public static final AddressType getXRP(AddressType.Companion companion) {
        m.g(companion, "<this>");
        return (AddressType) XRP$delegate.getValue();
    }
}