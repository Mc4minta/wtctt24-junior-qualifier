package com.coinbase.wallet.qr.parsers;

import com.coinbase.wallet.qr.models.QRCodeScanResult;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Metadata;

/* compiled from: EthereumClassicQrCodeParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006JG\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/EthereumClassicQrCodeParser;", "Lcom/coinbase/wallet/qr/parsers/EthereumBasedQrCodeParser;", "", "uChainId", "", "isValid", "(I)Z", "", "address", "Ljava/math/BigInteger;", "amount", "", "data", "Ljava/math/BigDecimal;", "gasLimit", "gasPrice", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lcom/coinbase/wallet/qr/models/QRCodeScanResult$EthereumClassic;", "asEthereumResult", "(Ljava/lang/String;Ljava/math/BigInteger;[BLjava/math/BigDecimal;Ljava/math/BigDecimal;I)Lcom/coinbase/wallet/qr/models/QRCodeScanResult$EthereumClassic;", "I", "getChainId", "()I", "decimals", "getDecimals", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "<init>", "(Lcom/coinbase/ciphercore/CipherCoreInterface;)V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class EthereumClassicQrCodeParser extends EthereumBasedQrCodeParser {
    private final int chainId;
    private final int decimals;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public EthereumClassicQrCodeParser(com.coinbase.ciphercore.CipherCoreInterface r5) {
        /*
            r4 = this;
            java.lang.String r0 = "cipherCore"
            kotlin.jvm.internal.m.g(r5, r0)
            java.lang.String r0 = "ethereum"
            java.lang.String r1 = "ethereum_classic"
            java.lang.String r2 = "ethereum-classic"
            java.lang.String r3 = "ethereumclassic"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1, r2, r3}
            java.util.List r0 = kotlin.a0.p.j(r0)
            r4.<init>(r5, r0)
            com.coinbase.ciphercore.ethereum.EthereumChain r5 = com.coinbase.ciphercore.ethereum.EthereumChain.ETHEREUM_CLASSIC_MAINNET
            int r5 = r5.getChainId()
            r4.chainId = r5
            com.coinbase.wallet.blockchains.models.CurrencyDecimal r5 = com.coinbase.wallet.blockchains.models.CurrencyDecimal.INSTANCE
            int r5 = com.coinbase.wallet.ethereum.extensions.CurrencyDecimal_EthereumKt.getETC(r5)
            r4.decimals = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.qr.parsers.EthereumClassicQrCodeParser.<init>(com.coinbase.ciphercore.CipherCoreInterface):void");
    }

    @Override // com.coinbase.wallet.qr.parsers.EthereumBasedQrCodeParser
    public int getChainId() {
        return this.chainId;
    }

    @Override // com.coinbase.wallet.qr.parsers.EthereumBasedQrCodeParser
    public int getDecimals() {
        return this.decimals;
    }

    @Override // com.coinbase.wallet.qr.parsers.EthereumBasedQrCodeParser
    public boolean isValid(int i2) {
        return i2 == getChainId();
    }

    @Override // com.coinbase.wallet.qr.parsers.EthereumBasedQrCodeParser
    public QRCodeScanResult.EthereumClassic asEthereumResult(String address, BigInteger bigInteger, byte[] bArr, BigDecimal bigDecimal, BigDecimal bigDecimal2, int i2) {
        kotlin.jvm.internal.m.g(address, "address");
        return new QRCodeScanResult.EthereumClassic(address, bigInteger, bArr, bigDecimal, bigDecimal2);
    }
}