package com.coinbase.wallet.qr.parsers;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.common.extensions.List_CommonKt;
import com.coinbase.wallet.common.extensions.String_CommonKt;
import com.coinbase.wallet.qr.exceptions.QrException;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import h.c.b0;
import h.c.h0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.l0.y;
import org.spongycastle.i18n.TextBundle;

/* compiled from: ERC20QRCodeParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/ERC20QRCodeParser;", "Lcom/coinbase/wallet/qr/parsers/EthereumQrCodeParser;", "", ERC20QRCodeParser.ADDRESS_KEY, "Lh/c/b0;", "parseAddress", "(Ljava/lang/String;)Lh/c/b0;", TextBundle.TEXT_ENTRY, "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "parse", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "<init>", "(Lcom/coinbase/ciphercore/CipherCoreInterface;)V", "Companion", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ERC20QRCodeParser extends EthereumQrCodeParser {
    private static final String ADDRESS_KEY = "address";
    private static final String AMOUNT_KEY = "uint256";
    private static final String ETHEREUM_SCHEME = "ethereum";
    private final CipherCoreInterface cipherCore;
    public static final Companion Companion = new Companion(null);
    private static final kotlin.l0.k PATH_PATTERN = new kotlin.l0.k("^(0x[a-zA-Z0-9]+)(/transfer)$");

    /* compiled from: ERC20QRCodeParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/ERC20QRCodeParser$Companion;", "", "", "ADDRESS_KEY", "Ljava/lang/String;", "AMOUNT_KEY", "ETHEREUM_SCHEME", "Lkotlin/l0/k;", "PATH_PATTERN", "Lkotlin/l0/k;", "<init>", "()V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ERC20QRCodeParser(CipherCoreInterface cipherCore) {
        super(cipherCore);
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        this.cipherCore = cipherCore;
    }

    public static /* synthetic */ h0 d(ERC20QRCodeParser eRC20QRCodeParser, String str, Throwable th) {
        return m1627parse$lambda6(eRC20QRCodeParser, str, th);
    }

    public static /* synthetic */ String e(kotlin.o oVar) {
        return m1628parseAddress$lambda7(oVar);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.coinbase.wallet.qr.parsers.ERC20QRCodeParser.parse$lambda-5(com.coinbase.wallet.qr.models.QRCodeScanResult$ERC20):com.coinbase.wallet.qr.models.QRCodeScanResult
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.NullPointerException
        */
    public static /* synthetic */ com.coinbase.wallet.qr.models.QRCodeScanResult f(com.coinbase.wallet.qr.models.QRCodeScanResult.ERC20 r0) {
        /*
            com.coinbase.wallet.qr.models.QRCodeScanResult r0 = m1626parse$lambda5(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.qr.parsers.ERC20QRCodeParser.f(com.coinbase.wallet.qr.models.QRCodeScanResult$ERC20):com.coinbase.wallet.qr.models.QRCodeScanResult");
    }

    public static /* synthetic */ QRCodeScanResult.ERC20 g(String str) {
        return m1625parse$lambda4(str);
    }

    public static /* synthetic */ QRCodeScanResult h(BigInteger bigInteger, kotlin.o oVar) {
        return m1624parse$lambda3(bigInteger, oVar);
    }

    /* renamed from: parse$lambda-3 */
    public static final QRCodeScanResult m1624parse$lambda3(BigInteger bigInteger, kotlin.o dstr$addr$cAddr) {
        kotlin.jvm.internal.m.g(dstr$addr$cAddr, "$dstr$addr$cAddr");
        return new QRCodeScanResult.ERC20((String) dstr$addr$cAddr.a(), bigInteger, (String) dstr$addr$cAddr.b());
    }

    /* renamed from: parse$lambda-4 */
    public static final QRCodeScanResult.ERC20 m1625parse$lambda4(String it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new QRCodeScanResult.ERC20(it, null, null);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* renamed from: parse$lambda-5 */
    private static final com.coinbase.wallet.qr.models.QRCodeScanResult m1626parse$lambda5(com.coinbase.wallet.qr.models.QRCodeScanResult.ERC20 r1) {
        /*
            java.lang.String r0 = "it"
            kotlin.jvm.internal.m.g(r1, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.qr.parsers.ERC20QRCodeParser.m1626parse$lambda5(com.coinbase.wallet.qr.models.QRCodeScanResult$ERC20):com.coinbase.wallet.qr.models.QRCodeScanResult");
    }

    /* renamed from: parse$lambda-6 */
    public static final h0 m1627parse$lambda6(ERC20QRCodeParser this$0, String text, Throwable it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(text, "$text");
        kotlin.jvm.internal.m.g(it, "it");
        return super.parse(text);
    }

    private final b0<String> parseAddress(String str) {
        b0<String> map = h.c.t0.f.a(this.cipherCore.checksumEthereumAddress(str), this.cipherCore.isValidEthereumAddress(str)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ERC20QRCodeParser.e((kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "cipherCore.checksumEthereumAddress(address)\n                .zipWith(cipherCore.isValidEthereumAddress(address))\n                .map { (checksummedAddress, isValid) ->\n                    if (!isValid) throw InvalidQrCode(\"Unable to parse scanned text\")\n                    checksummedAddress\n                }");
        return map;
    }

    /* renamed from: parseAddress$lambda-7 */
    public static final String m1628parseAddress$lambda7(kotlin.o dstr$checksummedAddress$isValid) {
        kotlin.jvm.internal.m.g(dstr$checksummedAddress$isValid, "$dstr$checksummedAddress$isValid");
        String str = (String) dstr$checksummedAddress$isValid.a();
        if (((Boolean) dstr$checksummedAddress$isValid.b()).booleanValue()) {
            return str;
        }
        throw new QrException.InvalidQrCode("Unable to parse scanned text");
    }

    @Override // com.coinbase.wallet.qr.parsers.EthereumBasedQrCodeParser, com.coinbase.wallet.qr.parsers.QRCodeIntentParser
    public b0<QRCodeScanResult> parse(final String text) {
        int r;
        Map r2;
        int i0;
        int i02;
        kotlin.jvm.internal.m.g(text, "text");
        Uri parse = Uri.parse(text);
        List<UrlQuerySanitizer.ParameterValuePair> parameterList = new UrlQuerySanitizer(text).getParameterList();
        kotlin.jvm.internal.m.f(parameterList, "UrlQuerySanitizer(text)\n                .parameterList");
        r = kotlin.a0.s.r(parameterList, 10);
        ArrayList arrayList = new ArrayList(r);
        for (UrlQuerySanitizer.ParameterValuePair parameterValuePair : parameterList) {
            arrayList.add(kotlin.u.a(parameterValuePair.mParameter, parameterValuePair.mValue));
        }
        r2 = m0.r(arrayList);
        String schemeSpecificPart = parse.getSchemeSpecificPart();
        final BigInteger bigInteger = null;
        if (schemeSpecificPart == null) {
            schemeSpecificPart = null;
        } else {
            i0 = y.i0(schemeSpecificPart, "?", 0, false, 6, null);
            if (i0 > 0) {
                i02 = y.i0(schemeSpecificPart, "?", 0, false, 6, null);
                schemeSpecificPart = schemeSpecificPart.substring(0, i02);
                kotlin.jvm.internal.m.f(schemeSpecificPart, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
        }
        if (schemeSpecificPart != null) {
            if ((!kotlin.jvm.internal.m.c(parse.getScheme(), "ethereum") && parse.getScheme() != null) || parse.getSchemeSpecificPart() == null) {
                b0<QRCodeScanResult> error = b0.error(new QrException.InvalidQrCode("Invalid Scheme"));
                kotlin.jvm.internal.m.f(error, "error<QRCodeScanResult>(InvalidQrCode(\"Invalid Scheme\"))");
                return error;
            }
            kotlin.l0.i c2 = PATH_PATTERN.c(schemeSpecificPart);
            List<String> b2 = c2 == null ? null : c2.b();
            if (b2 == null) {
                b2 = kotlin.a0.r.g();
            }
            if (b2.size() == 3) {
                String str = (String) r2.get(ADDRESS_KEY);
                if (str != null) {
                    String str2 = (String) List_CommonKt.require(b2, 1);
                    String str3 = (String) r2.get(AMOUNT_KEY);
                    if (str3 != null) {
                        if (String_CommonKt.isScientificNotation(str3)) {
                            bigInteger = new BigDecimal(str3).toBigInteger();
                        } else {
                            bigInteger = new BigInteger(str3);
                        }
                    }
                    b0<QRCodeScanResult> map = h.c.t0.f.a(parseAddress(str), parseAddress(str2)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.e
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return ERC20QRCodeParser.h(bigInteger, (kotlin.o) obj);
                        }
                    });
                    kotlin.jvm.internal.m.f(map, "{ // 3 because groupValues returns the input as well\n                val address = queryMap[ADDRESS_KEY] ?: throw InvalidQrCode(\"Address can't be null\")\n                val contractAddress = matches.require(1)\n                val amount = queryMap[AMOUNT_KEY]?.let { amount ->\n                    if (amount.isScientificNotation()) {\n                        amount.toBigDecimal()\n                            .toBigInteger()\n                    } else {\n                        amount.toBigInteger()\n                    }\n                }\n\n                parseAddress(address)\n                        .zipWith(parseAddress(contractAddress))\n                        .map { (addr, cAddr) -> QRCodeScanResult.ERC20(addr, amount, cAddr) }\n            }");
                    return map;
                }
                throw new QrException.InvalidQrCode("Address can't be null");
            } else if (!r2.isEmpty()) {
                b0<QRCodeScanResult> error2 = b0.error(new QrException.InvalidQrCode("Invalid parameters"));
                kotlin.jvm.internal.m.f(error2, "error<QRCodeScanResult>(InvalidQrCode(\"Invalid parameters\"))");
                return error2;
            } else {
                b0<QRCodeScanResult> onErrorResumeNext = parseAddress(schemeSpecificPart).map(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.d
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ERC20QRCodeParser.g((String) obj);
                    }
                }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.c
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ERC20QRCodeParser.f((QRCodeScanResult.ERC20) obj);
                    }
                }).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.a
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return ERC20QRCodeParser.d(ERC20QRCodeParser.this, text, (Throwable) obj);
                    }
                });
                kotlin.jvm.internal.m.f(onErrorResumeNext, "parseAddress(path)\n                    .map { QRCodeScanResult.ERC20(it, null, null) }\n                    .map { it as QRCodeScanResult }\n                    .onErrorResumeNext { super.parse(text) }");
                return onErrorResumeNext;
            }
        }
        throw new QrException.InvalidQrCode("Invalid Path");
    }
}