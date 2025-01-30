package com.coinbase.wallet.qr.parsers;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.qr.exceptions.QrException;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import com.coinbase.wallet.stellar.extensions.Blockchain_StellarKt;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import h.c.b0;
import h.c.h0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.l0.y;
import org.spongycastle.i18n.TextBundle;

/* compiled from: StellarQrCodeParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/StellarQrCodeParser;", "Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "", "address", "", "queryMap", "Lh/c/b0;", "parseAddress", "(Ljava/lang/String;Ljava/util/Map;)Lh/c/b0;", TextBundle.TEXT_ENTRY, "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "parse", "(Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "txRepository", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "<init>", "(Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;)V", "Companion", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StellarQrCodeParser implements QRCodeIntentParser {
    private static final String AMOUNT = "amount";
    public static final Companion Companion = new Companion(null);
    private static final String DESTINATION = "destination";
    private static final String MEMO = "memo";
    private static final String MEMO_HASH = "MEMO_HASH";
    private static final String MEMO_ID = "MEMO_ID";
    private static final String MEMO_RETURN = "MEMO_RETURN";
    private static final String MEMO_TEXT = "MEMO_TEXT";
    private static final String MEMO_TYPE = "memo_type";
    private static final String STELLAR_ALT_PREFIX = "stellar";
    private static final String STELLAR_PREFIX = "web+stellar";
    private static final List<String> supportedSchemes;
    private final ITxRepository txRepository;
    private final IWalletRepository walletRepository;

    /* compiled from: StellarQrCodeParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u001e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/StellarQrCodeParser$Companion;", "", "", "AMOUNT", "Ljava/lang/String;", "DESTINATION", "MEMO", StellarQrCodeParser.MEMO_HASH, StellarQrCodeParser.MEMO_ID, StellarQrCodeParser.MEMO_RETURN, StellarQrCodeParser.MEMO_TEXT, "MEMO_TYPE", "STELLAR_ALT_PREFIX", "STELLAR_PREFIX", "", "supportedSchemes", "Ljava/util/List;", "<init>", "()V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
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
        j2 = kotlin.a0.r.j("web+stellar", "stellar", null);
        supportedSchemes = j2;
    }

    public StellarQrCodeParser(ITxRepository txRepository, IWalletRepository walletRepository) {
        kotlin.jvm.internal.m.g(txRepository, "txRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        this.txRepository = txRepository;
        this.walletRepository = walletRepository;
    }

    public static /* synthetic */ h0 a(String str, Map map, StellarQrCodeParser stellarQrCodeParser, Network network, Boolean bool) {
        return m1638parseAddress$lambda8$lambda7(str, map, stellarQrCodeParser, network, bool);
    }

    public static /* synthetic */ QRCodeScanResult b(Map map, String str) {
        return m1636parse$lambda5(map, str);
    }

    public static /* synthetic */ h0 c(StellarQrCodeParser stellarQrCodeParser, String str, Map map, Network network) {
        return m1637parseAddress$lambda8(stellarQrCodeParser, str, map, network);
    }

    public static /* synthetic */ String d(String str, Boolean bool) {
        return m1639parseAddress$lambda8$lambda7$lambda6(str, bool);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0017, code lost:
        r0 = kotlin.l0.v.j(r0);
     */
    /* renamed from: parse$lambda-5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.coinbase.wallet.qr.models.QRCodeScanResult m1636parse$lambda5(java.util.Map r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "$queryMap"
            kotlin.jvm.internal.m.g(r9, r0)
            java.lang.String r0 = "parsedAddress"
            kotlin.jvm.internal.m.g(r10, r0)
            java.lang.String r0 = "amount"
            java.lang.Object r0 = r9.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            if (r0 != 0) goto L17
        L15:
            r0 = r1
            goto L28
        L17:
            java.math.BigDecimal r0 = kotlin.l0.o.j(r0)
            if (r0 != 0) goto L1e
            goto L15
        L1e:
            com.coinbase.wallet.blockchains.models.CurrencyDecimal r2 = com.coinbase.wallet.blockchains.models.CurrencyDecimal.INSTANCE
            int r2 = com.coinbase.wallet.stellar.extensions.CurrencyDecimal_StellarKt.getXLM(r2)
            java.math.BigInteger r0 = com.coinbase.wallet.common.extensions.BigDecimal_CommonKt.asBigInteger(r0, r2)
        L28:
            java.lang.String r2 = "memo"
            java.lang.Object r2 = r9.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L34
            goto L95
        L34:
            java.lang.String r3 = "memo_type"
            java.lang.Object r9 = r9.get(r3)
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L40
            goto L93
        L40:
            int r3 = r9.hashCode()
            switch(r3) {
                case 229742835: goto L76;
                case 230104338: goto L68;
                case 1667276352: goto L56;
                case 2029562837: goto L48;
                default: goto L47;
            }
        L47:
            goto L84
        L48:
            java.lang.String r3 = "MEMO_RETURN"
            boolean r9 = r9.equals(r3)
            if (r9 != 0) goto L51
            goto L84
        L51:
            r5 = r1
            r6 = r5
            r7 = r6
            r8 = r2
            goto L88
        L56:
            java.lang.String r3 = "MEMO_ID"
            boolean r9 = r9.equals(r3)
            if (r9 != 0) goto L5f
            goto L84
        L5f:
            java.math.BigInteger r9 = new java.math.BigInteger
            r9.<init>(r2)
            r6 = r9
            r5 = r1
            r7 = r5
            goto L87
        L68:
            java.lang.String r3 = "MEMO_TEXT"
            boolean r9 = r9.equals(r3)
            if (r9 != 0) goto L71
            goto L84
        L71:
            r6 = r1
            r7 = r6
            r8 = r7
            r5 = r2
            goto L88
        L76:
            java.lang.String r3 = "MEMO_HASH"
            boolean r9 = r9.equals(r3)
            if (r9 != 0) goto L7f
            goto L84
        L7f:
            r5 = r1
            r6 = r5
            r8 = r6
            r7 = r2
            goto L88
        L84:
            r5 = r1
            r6 = r5
            r7 = r6
        L87:
            r8 = r7
        L88:
            kotlin.x r9 = kotlin.x.a
            com.coinbase.wallet.qr.models.QRCodeScanResult$Stellar r9 = new com.coinbase.wallet.qr.models.QRCodeScanResult$Stellar
            r2 = r9
            r3 = r10
            r4 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r1 = r9
        L93:
            if (r1 == 0) goto La4
        L95:
            if (r1 != 0) goto La3
            com.coinbase.wallet.qr.models.QRCodeScanResult$Stellar r1 = new com.coinbase.wallet.qr.models.QRCodeScanResult$Stellar
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r2 = r1
            r3 = r10
            r4 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
        La3:
            return r1
        La4:
            com.coinbase.wallet.qr.exceptions.QrException$InvalidQrCode r9 = new com.coinbase.wallet.qr.exceptions.QrException$InvalidQrCode
            java.lang.String r10 = "Unable to parse scanned text"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.qr.parsers.StellarQrCodeParser.m1636parse$lambda5(java.util.Map, java.lang.String):com.coinbase.wallet.qr.models.QRCodeScanResult");
    }

    private final b0<String> parseAddress(final String str, final Map<String, String> map) {
        b0<String> flatMap = Observable_CoreKt.takeSingle(this.walletRepository.observeNetwork(Blockchain_StellarKt.getSTELLAR(Blockchain.Companion))).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.o
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarQrCodeParser.c(StellarQrCodeParser.this, str, map, (Network) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "walletRepository.observeNetwork(Blockchain.STELLAR)\n            .takeSingle()\n            .flatMap { network ->\n                txRepository.isValidAddress(Blockchain.STELLAR, network, address)\n                    .onErrorReturnItem(false)\n                    .flatMap { isValid ->\n                        if (isValid) {\n                            Single.just(address)\n                        } else {\n                            val dAddress = queryMap[DESTINATION] ?: throw InvalidQrCode(\"Unable to parse scanned text\")\n                            txRepository.isValidAddress(Blockchain.STELLAR, network, dAddress)\n                                .map { valid ->\n                                    if (valid) dAddress else throw InvalidQrCode(\"Unable to parse scanned text\")\n                                }\n                        }\n                    }\n            }");
        return flatMap;
    }

    /* renamed from: parseAddress$lambda-8 */
    public static final h0 m1637parseAddress$lambda8(final StellarQrCodeParser this$0, final String address, final Map queryMap, final Network network) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(queryMap, "$queryMap");
        kotlin.jvm.internal.m.g(network, "network");
        return this$0.txRepository.isValidAddress(Blockchain_StellarKt.getSTELLAR(Blockchain.Companion), network, address).onErrorReturnItem(Boolean.FALSE).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarQrCodeParser.a(address, queryMap, this$0, network, (Boolean) obj);
            }
        });
    }

    /* renamed from: parseAddress$lambda-8$lambda-7 */
    public static final h0 m1638parseAddress$lambda8$lambda7(String address, Map queryMap, StellarQrCodeParser this$0, Network network, Boolean isValid) {
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(queryMap, "$queryMap");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(isValid, "isValid");
        if (isValid.booleanValue()) {
            return b0.just(address);
        }
        final String str = (String) queryMap.get(DESTINATION);
        if (str != null) {
            return this$0.txRepository.isValidAddress(Blockchain_StellarKt.getSTELLAR(Blockchain.Companion), network, str).map(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.p
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return StellarQrCodeParser.d(str, (Boolean) obj);
                }
            });
        }
        throw new QrException.InvalidQrCode("Unable to parse scanned text");
    }

    /* renamed from: parseAddress$lambda-8$lambda-7$lambda-6 */
    public static final String m1639parseAddress$lambda8$lambda7$lambda6(String dAddress, Boolean valid) {
        kotlin.jvm.internal.m.g(dAddress, "$dAddress");
        kotlin.jvm.internal.m.g(valid, "valid");
        if (valid.booleanValue()) {
            return dAddress;
        }
        throw new QrException.InvalidQrCode("Unable to parse scanned text");
    }

    @Override // com.coinbase.wallet.qr.parsers.QRCodeIntentParser
    public b0<QRCodeScanResult> parse(String text) {
        int i0;
        int r;
        final Map<String, String> r2;
        int i02;
        kotlin.jvm.internal.m.g(text, "text");
        Uri parse = Uri.parse(text);
        String address = parse.getSchemeSpecificPart();
        kotlin.jvm.internal.m.f(address, "it");
        i0 = y.i0(address, "?", 0, false, 6, null);
        if (i0 > 0) {
            i02 = y.i0(address, "?", 0, false, 6, null);
            address = address.substring(0, i02);
            kotlin.jvm.internal.m.f(address, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        List<UrlQuerySanitizer.ParameterValuePair> parameterList = new UrlQuerySanitizer(text).getParameterList();
        kotlin.jvm.internal.m.f(parameterList, "UrlQuerySanitizer(text)\n                .parameterList");
        r = kotlin.a0.s.r(parameterList, 10);
        ArrayList arrayList = new ArrayList(r);
        for (UrlQuerySanitizer.ParameterValuePair parameterValuePair : parameterList) {
            arrayList.add(kotlin.u.a(parameterValuePair.mParameter, parameterValuePair.mValue));
        }
        r2 = m0.r(arrayList);
        if (!supportedSchemes.contains(parse.getScheme())) {
            b0<QRCodeScanResult> error = b0.error(new QrException.InvalidQrCode("Unable to parse scanned text"));
            kotlin.jvm.internal.m.f(error, "{\n            Single.error(InvalidQrCode(\"Unable to parse scanned text\"))\n        }");
            return error;
        }
        kotlin.jvm.internal.m.f(address, "address");
        b0 map = parseAddress(address, r2).map(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarQrCodeParser.b(r2, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "{\n            parseAddress(address, queryMap)\n                    .map { parsedAddress ->\n                        var memoHash: String? = null\n                        var memoId: BigInteger? = null\n                        var memoReturn: String? = null\n                        var memoText: String? = null\n\n                        val amount = queryMap[AMOUNT]\n                            ?.toBigDecimalOrNull()\n                            ?.asBigInteger(CurrencyDecimal.XLM)\n\n                        queryMap[MEMO]?.let { memo ->\n                            queryMap[MEMO_TYPE]?.let { memoTypeString ->\n                                when (memoTypeString) {\n                                    MEMO_HASH -> memoHash = memo\n                                    MEMO_TEXT -> memoText = memo\n                                    MEMO_RETURN -> memoReturn = memo\n                                    MEMO_ID -> memoId = memo.toBigInteger()\n                                }\n                            }?.let {\n                                QRCodeScanResult.Stellar(\n                                        address = parsedAddress,\n                                        amount = amount,\n                                        memoHash = memoHash,\n                                        memoId = memoId,\n                                        memoReturn = memoReturn,\n                                        memoText = memoText\n                                )\n                            } ?: throw InvalidQrCode(\"Unable to parse scanned text\")\n                        } ?: QRCodeScanResult.Stellar(\n                                address = parsedAddress,\n                                amount = amount,\n                                memoHash = null,\n                                memoId = null,\n                                memoReturn = null,\n                                memoText = null\n                        )\n                    }\n        }");
        return map;
    }
}