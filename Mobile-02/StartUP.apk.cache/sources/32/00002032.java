package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.bitcoin.extensions.Blockchain_BitcoinKt;
import com.coinbase.wallet.bitcoincash.extensions.Blockchain_BitcoinCashKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.dogecoin.extensions.Blockchain_DogecoinKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.litecoin.extensions.Blockchain_LitecoinKt;
import com.coinbase.wallet.ripple.exceptions.XrpException;
import com.coinbase.wallet.ripple.extensions.Blockchain_RippleKt;
import com.coinbase.wallet.stellar.extensions.Blockchain_StellarKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;

/* compiled from: SendDestinationPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\"\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003\"\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "Lcom/coinbase/wallet/ripple/exceptions/XrpException;", "throwableXRPErrors", "Ljava/util/List;", "", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "", "blockchainMinAddressLength", "Ljava/util/Map;", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationPickerViewModelKt {
    private static final Map<Blockchain, Integer> blockchainMinAddressLength;
    private static final List<XrpException> throwableXRPErrors;

    static {
        List<XrpException> j2;
        Map<Blockchain, Integer> l2;
        j2 = kotlin.a0.r.j(XrpException.RecipientDisallowsIncomingXrp.INSTANCE, XrpException.MissingDestinationTag.INSTANCE, XrpException.RequiresBaseReserve.INSTANCE);
        throwableXRPErrors = j2;
        Blockchain.Companion companion = Blockchain.Companion;
        l2 = m0.l(kotlin.u.a(Blockchain_StellarKt.getSTELLAR(companion), 55), kotlin.u.a(Blockchain_RippleKt.getXRP(companion), 25), kotlin.u.a(Blockchain_BitcoinCashKt.getBITCOIN_CASH(companion), 25), kotlin.u.a(Blockchain_EthereumKt.getETHEREUM_CLASSIC(companion), 40), kotlin.u.a(Blockchain_EthereumKt.getETHEREUM(companion), 40), kotlin.u.a(Blockchain_LitecoinKt.getLITECOIN(companion), 25), kotlin.u.a(Blockchain_BitcoinKt.getBITCOIN(companion), 25), kotlin.u.a(Blockchain_DogecoinKt.getDOGECOIN(companion), 25));
        blockchainMinAddressLength = l2;
    }
}