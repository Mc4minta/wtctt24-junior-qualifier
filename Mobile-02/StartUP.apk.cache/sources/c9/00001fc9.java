package com.coinbase.wallet.features.send.models;

import com.coinbase.wallet.txhistory.models.RecipientType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;

/* compiled from: SendDestinationViewInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AddressSearchResult;", "Lcom/coinbase/wallet/features/send/models/SendDestinationViewInfo;", "toSendDestination", "(Lcom/coinbase/wallet/features/send/models/AddressSearchResult;)Lcom/coinbase/wallet/features/send/models/SendDestinationViewInfo;", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationViewInfoKt {

    /* compiled from: SendDestinationViewInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecipientType.values().length];
            iArr[RecipientType.Coinbase.ordinal()] = 1;
            iArr[RecipientType.User.ordinal()] = 2;
            iArr[RecipientType.ENS.ordinal()] = 3;
            iArr[RecipientType.Address.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final SendDestinationViewInfo toSendDestination(AddressSearchResult addressSearchResult) {
        m.g(addressSearchResult, "<this>");
        int i2 = WhenMappings.$EnumSwitchMapping$0[addressSearchResult.getRecipientType().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        return SendDestinationViewInfo.Companion.fromAddress(addressSearchResult.getDestination(), addressSearchResult.getMetadataKey(), addressSearchResult.getMetadata());
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return SendDestinationViewInfo.Companion.fromENS(addressSearchResult.getDestination());
            }
            return SendDestinationViewInfo.Companion.fromUsername(addressSearchResult.getDestination());
        }
        return SendDestinationViewInfo.Companion.fromCoinbaseEmail(addressSearchResult.getDestination(), addressSearchResult.getMetadataKey(), addressSearchResult.getMetadata());
    }
}