package com.coinbase.wallet.routing.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import com.coinbase.wallet.qr.parsers.QRCodeIntentParser;
import com.coinbase.wallet.routing.models.PaymentRouting;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import h.c.b0;
import h.c.m0.n;
import h.c.m0.p;
import h.c.s;
import h.c.t0.f;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.o;

/* compiled from: PaymentRouting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR&\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u00020\u001e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/routing/models/PaymentRouting;", "Lcom/coinbase/wallet/routing/models/RouteAction;", "Lh/c/b0;", "Lcom/coinbase/wallet/routing/models/DeeplinkDestination;", "execute", "()Lh/c/b0;", "Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "getQrCodeParser", "()Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "qrCodeParser", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lkotlin/o;", "", "Ljava/lang/Class;", "getViewModelKey", "()Lkotlin/o;", "viewModelKey", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "getWalletRepository", "()Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "", "getSendDestinationId", "()I", "sendDestinationId", "getSendAmountId", "sendAmountId", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface PaymentRouting extends RouteAction {

    /* compiled from: PaymentRouting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ DeeplinkDestination a(PaymentRouting paymentRouting, o oVar) {
            return m1684execute$lambda0(paymentRouting, oVar);
        }

        public static b0<DeeplinkDestination> execute(final PaymentRouting paymentRouting) {
            m.g(paymentRouting, "this");
            s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(paymentRouting.getWalletRepository(), paymentRouting.getBlockchain(), paymentRouting.getCurrencyCode());
            m.f(observeWallet, "walletRepository.observeWallet(blockchain, currencyCode)");
            s<R> map = observeWallet.filter(new p() { // from class: com.coinbase.wallet.routing.models.PaymentRouting$DefaultImpls$execute$$inlined$unwrap$1
                public final boolean test(Optional<? extends T> it) {
                    m.g(it, "it");
                    return it.toNullable() != null;
                }

                @Override // h.c.m0.p
                public /* bridge */ /* synthetic */ boolean test(Object obj) {
                    return test((Optional) ((Optional) obj));
                }
            }).map(new n() { // from class: com.coinbase.wallet.routing.models.PaymentRouting$DefaultImpls$execute$$inlined$unwrap$2
                public final T apply(Optional<? extends T> it) {
                    m.g(it, "it");
                    return it.toNullable();
                }

                @Override // h.c.m0.n
                public /* bridge */ /* synthetic */ Object apply(Object obj) {
                    return apply((Optional) ((Optional) obj));
                }
            });
            m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
            b0 takeSingle = Observable_CoreKt.takeSingle(map);
            QRCodeIntentParser qrCodeParser = paymentRouting.getQrCodeParser();
            String uri = paymentRouting.getUri().toString();
            m.f(uri, "uri.toString()");
            b0<DeeplinkDestination> map2 = f.a(qrCodeParser.parse(uri), takeSingle).map(new n() { // from class: com.coinbase.wallet.routing.models.a
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return PaymentRouting.DefaultImpls.a(PaymentRouting.this, (o) obj);
                }
            });
            m.f(map2, "qrCodeParserSingle.zipWith(walletSingle)\n            .map { (result, wallet) ->\n                val amount = result.amount\n                if (amount != null) {\n                    val args = SendDestinationPickerArgs.createArguments(\n                        transferValue = TransferValue.Amount(amount),\n                        wallet = wallet,\n                        address = result.address,\n                        metadataValue = result.walletAccountId,\n                        stellarMemoType = result.memoType\n                    )\n\n                    NavDeepLinkDestination(\n                        destinationResId = sendDestinationId,\n                        args = args\n                    )\n                } else {\n                    val args = SendArgs.createArguments(\n                        wallet = wallet,\n                        recipient = result.address,\n                        metadataValue = result.walletAccountId,\n                        stellarMemoType = result.memoType,\n                        viewModelKey = viewModelKey\n                    )\n\n                    NavDeepLinkDestination(\n                        destinationResId = sendAmountId,\n                        args = args\n                    )\n                }\n            }");
            return map2;
        }

        /* renamed from: execute$lambda-0 */
        public static DeeplinkDestination m1684execute$lambda0(PaymentRouting this$0, o dstr$result$wallet) {
            m.g(this$0, "this$0");
            m.g(dstr$result$wallet, "$dstr$result$wallet");
            QRCodeScanResult qRCodeScanResult = (QRCodeScanResult) dstr$result$wallet.a();
            Wallet wallet = (Wallet) dstr$result$wallet.b();
            BigInteger amount = qRCodeScanResult.getAmount();
            if (amount != null) {
                SendDestinationPickerArgs sendDestinationPickerArgs = SendDestinationPickerArgs.INSTANCE;
                TransferValue.Amount amount2 = new TransferValue.Amount(amount);
                m.f(wallet, "wallet");
                return new NavDeepLinkDestination(this$0.getSendDestinationId(), sendDestinationPickerArgs.createArguments(amount2, wallet, qRCodeScanResult.getAddress(), qRCodeScanResult.getWalletAccountId(), qRCodeScanResult.getMemoType()));
            }
            SendArgs sendArgs = SendArgs.INSTANCE;
            m.f(wallet, "wallet");
            return new NavDeepLinkDestination(this$0.getSendAmountId(), sendArgs.createArguments(wallet, qRCodeScanResult.getAddress(), qRCodeScanResult.getWalletAccountId(), qRCodeScanResult.getMemoType(), this$0.getViewModelKey()));
        }
    }

    @Override // com.coinbase.wallet.routing.models.RouteAction
    b0<DeeplinkDestination> execute();

    Blockchain getBlockchain();

    CurrencyCode getCurrencyCode();

    QRCodeIntentParser getQrCodeParser();

    int getSendAmountId();

    int getSendDestinationId();

    o<String, Class<?>> getViewModelKey();

    IWalletRepository getWalletRepository();
}