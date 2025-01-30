package com.coinbase.wallet.qr.parsers;

import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.CurrencyDecimal;
import com.coinbase.wallet.dogecoin.extensions.Blockchain_DogecoinKt;
import com.coinbase.wallet.dogecoin.extensions.CurrencyCode_DogecoinKt;
import com.coinbase.wallet.dogecoin.extensions.CurrencyDecimal_DogecoinKt;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import kotlin.Metadata;

/* compiled from: DogecoinQrCodeParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/DogecoinQrCodeParser;", "Lcom/coinbase/wallet/qr/parsers/HdWalletQrCodeParser;", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "txRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;)V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DogecoinQrCodeParser extends HdWalletQrCodeParser {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DogecoinQrCodeParser(ITxRepository txRepository, IWalletRepository walletRepository) {
        super(CurrencyDecimal_DogecoinKt.getDOGE(CurrencyDecimal.INSTANCE), CurrencyCode_DogecoinKt.getDOGE(CurrencyCode.Companion), Blockchain_DogecoinKt.getDOGECOIN(Blockchain.Companion), txRepository, walletRepository, "dogecoin", "dogecoin");
        kotlin.jvm.internal.m.g(txRepository, "txRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
    }
}