package com.coinbase.wallet.routing.models;

import android.net.Uri;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.qr.parsers.QRCodeIntentParser;
import com.coinbase.wallet.routing.models.PaymentRouting;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import h.c.b0;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.o;

/* compiled from: EthereumPaymentRouteAction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\b\u0012\u0006\u0012\u0002\b\u00030$0\"\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010 \u001a\u00020\f¢\u0006\u0004\b)\u0010*R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u00020\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u00020\u001b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010R,\u0010%\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\b\u0012\u0006\u0012\u0002\b\u00030$0\"8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/coinbase/wallet/routing/models/EthereumPaymentRouteAction;", "Lcom/coinbase/wallet/routing/models/PaymentRouting;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "qrCodeParser", "Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "getQrCodeParser", "()Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "", "sendDestinationId", "I", "getSendDestinationId", "()I", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "getWalletRepository", "()Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Landroid/net/Uri;", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "sendAmountId", "getSendAmountId", "Lkotlin/o;", "", "Ljava/lang/Class;", "viewModelKey", "Lkotlin/o;", "getViewModelKey", "()Lkotlin/o;", "<init>", "(Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;Landroid/net/Uri;Lkotlin/o;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;II)V", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class EthereumPaymentRouteAction implements PaymentRouting {
    private final Blockchain blockchain;
    private final CurrencyCode currencyCode;
    private final QRCodeIntentParser qrCodeParser;
    private final int sendAmountId;
    private final int sendDestinationId;
    private final Uri uri;
    private final o<String, Class<?>> viewModelKey;
    private final IWalletRepository walletRepository;

    /* JADX WARN: Multi-variable type inference failed */
    public EthereumPaymentRouteAction(QRCodeIntentParser qrCodeParser, Uri uri, o<String, ? extends Class<?>> viewModelKey, IWalletRepository walletRepository, int i2, int i3) {
        m.g(qrCodeParser, "qrCodeParser");
        m.g(uri, "uri");
        m.g(viewModelKey, "viewModelKey");
        m.g(walletRepository, "walletRepository");
        this.qrCodeParser = qrCodeParser;
        this.uri = uri;
        this.viewModelKey = viewModelKey;
        this.walletRepository = walletRepository;
        this.sendDestinationId = i2;
        this.sendAmountId = i3;
        this.blockchain = Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion);
        this.currencyCode = CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion);
    }

    @Override // com.coinbase.wallet.routing.models.PaymentRouting, com.coinbase.wallet.routing.models.RouteAction
    public b0<DeeplinkDestination> execute() {
        return PaymentRouting.DefaultImpls.execute(this);
    }

    @Override // com.coinbase.wallet.routing.models.PaymentRouting
    public Blockchain getBlockchain() {
        return this.blockchain;
    }

    @Override // com.coinbase.wallet.routing.models.PaymentRouting
    public CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    @Override // com.coinbase.wallet.routing.models.PaymentRouting
    public QRCodeIntentParser getQrCodeParser() {
        return this.qrCodeParser;
    }

    @Override // com.coinbase.wallet.routing.models.PaymentRouting
    public int getSendAmountId() {
        return this.sendAmountId;
    }

    @Override // com.coinbase.wallet.routing.models.PaymentRouting
    public int getSendDestinationId() {
        return this.sendDestinationId;
    }

    @Override // com.coinbase.wallet.routing.models.RouteAction
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.coinbase.wallet.routing.models.PaymentRouting
    public o<String, Class<?>> getViewModelKey() {
        return this.viewModelKey;
    }

    @Override // com.coinbase.wallet.routing.models.PaymentRouting
    public IWalletRepository getWalletRepository() {
        return this.walletRepository;
    }
}