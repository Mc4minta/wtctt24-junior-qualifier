package com.coinbase.wallet.qr.parsers;

import android.net.UrlQuerySanitizer;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.qr.exceptions.QrException;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import com.coinbase.wallet.ripple.extensions.Blockchain_RippleKt;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import h.c.h0;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.l0.b0;
import kotlin.l0.v;
import kotlin.l0.y;
import org.spongycastle.i18n.TextBundle;

/* compiled from: XRPQrCodeParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/XRPQrCodeParser;", "Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "", "address", "", "queryMap", "Lh/c/b0;", "parseAddress", "(Ljava/lang/String;Ljava/util/Map;)Lh/c/b0;", TextBundle.TEXT_ENTRY, "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "parse", "(Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "txRepository", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;)V", "Companion", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class XRPQrCodeParser implements QRCodeIntentParser {
    private static final String AMOUNT_KEY = "amount";
    public static final Companion Companion = new Companion(null);
    private static final String DT_KEY = "dt";
    private static final String HTTPS_SCHEME = "https";
    private static final String HTTP_SCHEME = "http";
    private static final String RIPPLE_PREFIX = "ripple";
    private static final String TO_KEY = "to";
    private static final String XRP_PREFIX = "xrp";
    private static final List<String> supportedAuthorities;
    private static final List<String> supportedSchemes;
    private final ITxRepository txRepository;
    private final IWalletRepository walletRepository;

    /* compiled from: XRPQrCodeParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u001e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/XRPQrCodeParser$Companion;", "", "", "AMOUNT_KEY", "Ljava/lang/String;", "DT_KEY", "HTTPS_SCHEME", "HTTP_SCHEME", "RIPPLE_PREFIX", "TO_KEY", "XRP_PREFIX", "", "supportedAuthorities", "Ljava/util/List;", "supportedSchemes", "<init>", "()V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        List<String> j2;
        List<String> j3;
        j2 = kotlin.a0.r.j("http", HTTPS_SCHEME, "xrp", "ripple", null);
        supportedSchemes = j2;
        j3 = kotlin.a0.r.j("www.ripple.com", "ripple.com", null);
        supportedAuthorities = j3;
    }

    public XRPQrCodeParser(ITxRepository txRepository, IWalletRepository walletRepository) {
        kotlin.jvm.internal.m.g(txRepository, "txRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        this.txRepository = txRepository;
        this.walletRepository = walletRepository;
    }

    public static /* synthetic */ String a(String str, Boolean bool) {
        return m1644parseAddress$lambda6$lambda5$lambda4$lambda3(str, bool);
    }

    public static /* synthetic */ h0 b(XRPQrCodeParser xRPQrCodeParser, String str, Map map, Network network) {
        return m1642parseAddress$lambda6(xRPQrCodeParser, str, map, network);
    }

    public static /* synthetic */ h0 c(String str, Map map, XRPQrCodeParser xRPQrCodeParser, Network network, Boolean bool) {
        return m1643parseAddress$lambda6$lambda5(str, map, xRPQrCodeParser, network, bool);
    }

    public static /* synthetic */ QRCodeScanResult d(Map map, String str) {
        return m1641parse$lambda2(map, str);
    }

    /* renamed from: parse$lambda-2 */
    public static final QRCodeScanResult m1641parse$lambda2(Map queryMap, String parsedAddress) {
        kotlin.jvm.internal.m.g(queryMap, "$queryMap");
        kotlin.jvm.internal.m.g(parsedAddress, "parsedAddress");
        String str = (String) queryMap.get("amount");
        BigInteger k2 = str == null ? null : v.k(str);
        String str2 = (String) queryMap.get(DT_KEY);
        return new QRCodeScanResult.XRP(parsedAddress, k2, str2 == null ? null : b0.b(str2), null);
    }

    private final h.c.b0<String> parseAddress(final String str, final Map<String, String> map) {
        h.c.b0<String> flatMap = Observable_CoreKt.takeSingle(this.walletRepository.observeNetwork(Blockchain_RippleKt.getXRP(Blockchain.Companion))).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPQrCodeParser.b(XRPQrCodeParser.this, str, map, (Network) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "walletRepository.observeNetwork(Blockchain.XRP)\n            .takeSingle()\n            .flatMap { network ->\n                txRepository.isValidAddress(Blockchain.XRP, network, address)\n                    .onErrorReturnItem(false)\n                    .flatMap { isValid ->\n                        if (isValid) {\n                            Single.just(address)\n                        } else {\n                            queryMap[TO_KEY]?.let { toAddr ->\n                                txRepository.isValidAddress(Blockchain.XRP, network, toAddr)\n                                    .map { toAddr }\n                            } ?: throw InvalidQrCode(\"Unable to parse scanned text\")\n                        }\n                    }\n            }");
        return flatMap;
    }

    /* renamed from: parseAddress$lambda-6 */
    public static final h0 m1642parseAddress$lambda6(final XRPQrCodeParser this$0, final String address, final Map queryMap, final Network network) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(queryMap, "$queryMap");
        kotlin.jvm.internal.m.g(network, "network");
        return this$0.txRepository.isValidAddress(Blockchain_RippleKt.getXRP(Blockchain.Companion), network, address).onErrorReturnItem(Boolean.FALSE).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.t
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPQrCodeParser.c(address, queryMap, this$0, network, (Boolean) obj);
            }
        });
    }

    /* renamed from: parseAddress$lambda-6$lambda-5 */
    public static final h0 m1643parseAddress$lambda6$lambda5(String address, Map queryMap, XRPQrCodeParser this$0, Network network, Boolean isValid) {
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(queryMap, "$queryMap");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(isValid, "isValid");
        if (isValid.booleanValue()) {
            return h.c.b0.just(address);
        }
        final String str = (String) queryMap.get("to");
        h0 map = str == null ? null : this$0.txRepository.isValidAddress(Blockchain_RippleKt.getXRP(Blockchain.Companion), network, str).map(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.r
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPQrCodeParser.a(str, (Boolean) obj);
            }
        });
        if (map != null) {
            return map;
        }
        throw new QrException.InvalidQrCode("Unable to parse scanned text");
    }

    /* renamed from: parseAddress$lambda-6$lambda-5$lambda-4$lambda-3 */
    public static final String m1644parseAddress$lambda6$lambda5$lambda4$lambda3(String toAddr, Boolean it) {
        kotlin.jvm.internal.m.g(toAddr, "$toAddr");
        kotlin.jvm.internal.m.g(it, "it");
        return toAddr;
    }

    @Override // com.coinbase.wallet.qr.parsers.QRCodeIntentParser
    public h.c.b0<QRCodeScanResult> parse(String text) {
        int r;
        final Map<String, String> r2;
        String it;
        int i0;
        int i02;
        kotlin.jvm.internal.m.g(text, "text");
        List<UrlQuerySanitizer.ParameterValuePair> parameterList = new UrlQuerySanitizer(text).getParameterList();
        kotlin.jvm.internal.m.f(parameterList, "UrlQuerySanitizer(text)\n            .parameterList");
        r = kotlin.a0.s.r(parameterList, 10);
        ArrayList arrayList = new ArrayList(r);
        for (UrlQuerySanitizer.ParameterValuePair parameterValuePair : parameterList) {
            arrayList.add(kotlin.u.a(parameterValuePair.mParameter, parameterValuePair.mValue));
        }
        r2 = m0.r(arrayList);
        try {
            URI uri = new URI(text);
            it = uri.getSchemeSpecificPart();
            kotlin.jvm.internal.m.f(it, "it");
            i0 = y.i0(it, "?", 0, false, 6, null);
            if (i0 > 0) {
                i02 = y.i0(it, "?", 0, false, 6, null);
                it = it.substring(0, i02);
                kotlin.jvm.internal.m.f(it, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            kotlin.jvm.internal.m.f(it, "components.schemeSpecificPart\n                .let { if (it.indexOf(\"?\") > 0) it.substring(0, it.indexOf(\"?\")) else it }");
            try {
                if (!supportedSchemes.contains(uri.getScheme()) || !supportedAuthorities.contains(uri.getAuthority())) {
                    h.c.b0<QRCodeScanResult> error = h.c.b0.error(new QrException.InvalidQrCode("Unable to parse scanned text"));
                    kotlin.jvm.internal.m.f(error, "error<QRCodeScanResult>(InvalidQrCode(\"Unable to parse scanned text\"))");
                    return error;
                }
            } catch (URISyntaxException e2) {
                e = e2;
                text = it;
                l.a.a.b(e);
                it = text;
                h.c.b0 map = parseAddress(it, r2).map(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.u
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return XRPQrCodeParser.d(r2, (String) obj);
                    }
                });
                kotlin.jvm.internal.m.f(map, "parseAddress(address, queryMap)\n            .map { parsedAddress ->\n                val amount = queryMap[AMOUNT_KEY]\n                    ?.toBigIntegerOrNull()\n\n                val destinationTag = queryMap[DT_KEY]\n                    ?.toUIntOrNull()\n\n                QRCodeScanResult.XRP(\n                    address = parsedAddress,\n                    amount = amount,\n                    destinationTag = destinationTag\n                )\n            }");
                return map;
            }
        } catch (URISyntaxException e3) {
            e = e3;
        }
        h.c.b0 map2 = parseAddress(it, r2).map(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPQrCodeParser.d(r2, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "parseAddress(address, queryMap)\n            .map { parsedAddress ->\n                val amount = queryMap[AMOUNT_KEY]\n                    ?.toBigIntegerOrNull()\n\n                val destinationTag = queryMap[DT_KEY]\n                    ?.toUIntOrNull()\n\n                QRCodeScanResult.XRP(\n                    address = parsedAddress,\n                    amount = amount,\n                    destinationTag = destinationTag\n                )\n            }");
        return map2;
    }
}