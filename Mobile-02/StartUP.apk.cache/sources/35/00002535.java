package com.coinbase.wallet.qr.parsers;

import android.net.UrlQuerySanitizer;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.qr.exceptions.QrException;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import h.c.b0;
import h.c.h0;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.l0.x;
import kotlin.l0.y;
import org.spongycastle.i18n.TextBundle;

/* compiled from: HdWalletQrCodeParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \"2\u00020\u0001:\u0001\"B?\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001b¨\u0006#"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/HdWalletQrCodeParser;", "Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "", "address", "scheme", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lh/c/b0;", "parseAddress", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", TextBundle.TEXT_ENTRY, "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "parse", "(Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "", "decimals", "I", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "txRepository", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "mainnetScheme", "Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "testnetScheme", "<init>", "(ILcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class HdWalletQrCodeParser implements QRCodeIntentParser {
    private static final String AMOUNT = "amount";
    public static final Companion Companion = new Companion(null);
    private static final String LABEL = "label";
    private static final String MESSAGE = "message";
    private final Blockchain blockchain;
    private final CurrencyCode currencyCode;
    private final int decimals;
    private final String mainnetScheme;
    private final String testnetScheme;
    private final ITxRepository txRepository;
    private final IWalletRepository walletRepository;

    /* compiled from: HdWalletQrCodeParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/HdWalletQrCodeParser$Companion;", "", "", "AMOUNT", "Ljava/lang/String;", "LABEL", "MESSAGE", "<init>", "()V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HdWalletQrCodeParser(int i2, CurrencyCode currencyCode, Blockchain blockchain, ITxRepository txRepository, IWalletRepository walletRepository, String mainnetScheme, String testnetScheme) {
        kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        kotlin.jvm.internal.m.g(txRepository, "txRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(mainnetScheme, "mainnetScheme");
        kotlin.jvm.internal.m.g(testnetScheme, "testnetScheme");
        this.decimals = i2;
        this.currencyCode = currencyCode;
        this.blockchain = blockchain;
        this.txRepository = txRepository;
        this.walletRepository = walletRepository;
        this.mainnetScheme = mainnetScheme;
        this.testnetScheme = testnetScheme;
    }

    public static /* synthetic */ h0 a(String str, HdWalletQrCodeParser hdWalletQrCodeParser, Network network, String str2, Boolean bool) {
        return m1634parseAddress$lambda4(str, hdWalletQrCodeParser, network, str2, bool);
    }

    public static /* synthetic */ QRCodeScanResult.HDWallet b(Map map, HdWalletQrCodeParser hdWalletQrCodeParser, String str) {
        return m1633parse$lambda2$lambda1(map, hdWalletQrCodeParser, str);
    }

    public static /* synthetic */ h0 c(HdWalletQrCodeParser hdWalletQrCodeParser, String str, Network network) {
        return m1632parse$lambda2(hdWalletQrCodeParser, str, network);
    }

    public static /* synthetic */ h0 d(String str, Boolean bool) {
        return m1635parseAddress$lambda4$lambda3(str, bool);
    }

    /* renamed from: parse$lambda-2 */
    public static final h0 m1632parse$lambda2(final HdWalletQrCodeParser this$0, String text, Network network) {
        int r;
        final Map r2;
        List K0;
        boolean D;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(text, "$text");
        kotlin.jvm.internal.m.g(network, "network");
        String str = network.isTestnet() ? this$0.testnetScheme : this$0.mainnetScheme;
        URI uri = new URI(text);
        List<UrlQuerySanitizer.ParameterValuePair> parameterList = new UrlQuerySanitizer(text).getParameterList();
        kotlin.jvm.internal.m.f(parameterList, "UrlQuerySanitizer(text)\n                .parameterList");
        r = kotlin.a0.s.r(parameterList, 10);
        ArrayList arrayList = new ArrayList(r);
        for (UrlQuerySanitizer.ParameterValuePair parameterValuePair : parameterList) {
            arrayList.add(kotlin.u.a(parameterValuePair.mParameter, parameterValuePair.mValue));
        }
        r2 = m0.r(arrayList);
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        kotlin.jvm.internal.m.f(schemeSpecificPart, "urlComponents.schemeSpecificPart");
        K0 = y.K0(schemeSpecificPart, new String[]{"?"}, false, 0, 6, null);
        String str2 = (String) kotlin.a0.p.Y(K0);
        if (uri.getScheme() == null || kotlin.jvm.internal.m.c(uri.getScheme(), str)) {
            D = x.D(str2);
            if (!D) {
                return this$0.parseAddress(str2, str, network).map(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.j
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return HdWalletQrCodeParser.b(r2, this$0, (String) obj);
                    }
                });
            }
        }
        return b0.error(new QrException.InvalidQrCode("Unable to parse scanned text"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001c, code lost:
        r0 = kotlin.l0.v.j(r0);
     */
    /* renamed from: parse$lambda-2$lambda-1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.coinbase.wallet.qr.models.QRCodeScanResult.HDWallet m1633parse$lambda2$lambda1(java.util.Map r9, com.coinbase.wallet.qr.parsers.HdWalletQrCodeParser r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "$queryMap"
            kotlin.jvm.internal.m.g(r9, r0)
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.m.g(r10, r0)
            java.lang.String r0 = "parsedAddress"
            kotlin.jvm.internal.m.g(r11, r0)
            java.lang.String r0 = "amount"
            java.lang.Object r0 = r9.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            if (r0 != 0) goto L1c
        L1a:
            r6 = r1
            goto L2a
        L1c:
            java.math.BigDecimal r0 = kotlin.l0.o.j(r0)
            if (r0 != 0) goto L23
            goto L1a
        L23:
            int r1 = r10.decimals
            java.math.BigInteger r1 = com.coinbase.wallet.common.extensions.BigDecimal_CommonKt.asBigInteger(r0, r1)
            goto L1a
        L2a:
            java.lang.String r0 = "label"
            java.lang.Object r0 = r9.get(r0)
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r0 = "message"
            java.lang.Object r9 = r9.get(r0)
            r8 = r9
            java.lang.String r8 = (java.lang.String) r8
            com.coinbase.wallet.qr.models.QRCodeScanResult$HDWallet r9 = new com.coinbase.wallet.qr.models.QRCodeScanResult$HDWallet
            com.coinbase.wallet.blockchains.models.CurrencyCode r4 = r10.currencyCode
            com.coinbase.wallet.blockchains.models.Blockchain r5 = r10.blockchain
            r2 = r9
            r3 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.qr.parsers.HdWalletQrCodeParser.m1633parse$lambda2$lambda1(java.util.Map, com.coinbase.wallet.qr.parsers.HdWalletQrCodeParser, java.lang.String):com.coinbase.wallet.qr.models.QRCodeScanResult$HDWallet");
    }

    private final b0<String> parseAddress(final String str, String str2, final Network network) {
        final String str3 = str2 + ':' + str;
        b0 flatMap = this.txRepository.isValidAddress(this.blockchain, network, str3).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return HdWalletQrCodeParser.a(str3, this, network, str, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "txRepository.isValidAddress(blockchain, network, addressWithScheme)\n            .flatMap { isValid ->\n                if (isValid) {\n                    Single.just(addressWithScheme)\n                } else {\n                    txRepository.isValidAddress(blockchain, network, address)\n                        .onErrorReturnItem(false)\n                        .flatMap { valid ->\n                            if (valid) {\n                                Single.just(address)\n                            } else {\n                                Single.error<String>(InvalidQrCode(\"Unable to parse scanned text\"))\n                            }\n                        }\n                }\n            }");
        return flatMap;
    }

    /* renamed from: parseAddress$lambda-4 */
    public static final h0 m1634parseAddress$lambda4(String addressWithScheme, HdWalletQrCodeParser this$0, Network network, final String address, Boolean isValid) {
        kotlin.jvm.internal.m.g(addressWithScheme, "$addressWithScheme");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(isValid, "isValid");
        if (isValid.booleanValue()) {
            return b0.just(addressWithScheme);
        }
        return this$0.txRepository.isValidAddress(this$0.blockchain, network, address).onErrorReturnItem(Boolean.FALSE).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return HdWalletQrCodeParser.d(address, (Boolean) obj);
            }
        });
    }

    /* renamed from: parseAddress$lambda-4$lambda-3 */
    public static final h0 m1635parseAddress$lambda4$lambda3(String address, Boolean valid) {
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(valid, "valid");
        if (valid.booleanValue()) {
            return b0.just(address);
        }
        return b0.error(new QrException.InvalidQrCode("Unable to parse scanned text"));
    }

    @Override // com.coinbase.wallet.qr.parsers.QRCodeIntentParser
    public b0<QRCodeScanResult> parse(final String text) {
        kotlin.jvm.internal.m.g(text, "text");
        b0<QRCodeScanResult> flatMap = Observable_CoreKt.takeSingle(this.walletRepository.observeNetwork(this.blockchain)).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return HdWalletQrCodeParser.c(HdWalletQrCodeParser.this, text, (Network) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "walletRepository.observeNetwork(blockchain)\n        .takeSingle()\n        .flatMap { network ->\n            val scheme = if (network.isTestnet) testnetScheme else mainnetScheme\n            val urlComponents = URI(text)\n            val queryMap = UrlQuerySanitizer(text)\n                .parameterList\n                .map { it.mParameter to it.mValue }\n                .toMap()\n\n            // URI::schemeSpecificPart returns the query params and we just want the part before the first query param\n            val address = urlComponents.schemeSpecificPart.split(\"?\").first()\n\n            if ((urlComponents.scheme != null && urlComponents.scheme != scheme) || address.isBlank()) {\n                return@flatMap Single.error<QRCodeScanResult>(InvalidQrCode(\"Unable to parse scanned text\"))\n            }\n\n            parseAddress(address, scheme, network)\n                .map { parsedAddress ->\n                    val amount = queryMap[AMOUNT]\n                        ?.toBigDecimalOrNull()\n                        ?.asBigInteger(decimals)\n\n                    val label = queryMap[LABEL]\n                    val message = queryMap[MESSAGE]\n\n                    QRCodeScanResult.HDWallet(\n                        address = parsedAddress,\n                        currencyCode = currencyCode,\n                        blockchain = blockchain,\n                        amount = amount,\n                        label = label,\n                        message = message\n                    )\n                }\n        }");
        return flatMap;
    }
}