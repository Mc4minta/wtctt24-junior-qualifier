package com.coinbase.wallet.qr.parsers;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.String_CipherCoreKt;
import com.coinbase.wallet.common.extensions.String_CommonKt;
import com.coinbase.wallet.qr.exceptions.QrException;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import com.coinbase.wallet.qr.models.WalletConstants;
import com.coinbase.wallet.routing.models.RouteActionKey;
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
import kotlin.l0.v;
import kotlin.l0.x;
import kotlin.l0.y;
import org.apache.http.cookie.ClientCookie;
import org.spongycastle.i18n.TextBundle;

/* compiled from: EthereumBasedQrCodeParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 )2\u00020\u0001:\u0001)B\u001f\u0012\u0006\u0010%\u001a\u00020$\u0012\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001f¢\u0006\u0004\b'\u0010(J%\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\u000fJG\u0010\u0019\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0005H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\t2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u000bR\u0016\u0010\u0017\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/EthereumBasedQrCodeParser;", "Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "", ClientCookie.PATH_ATTR, "Lkotlin/o;", "", "parseAddressAndChainId", "(Ljava/lang/String;)Lkotlin/o;", "address", "Lh/c/b0;", "parseAddress", "(Ljava/lang/String;)Lh/c/b0;", "uChainId", "", "isValid", "(I)Z", "Ljava/math/BigInteger;", "amount", "", EthereumBasedQrCodeParser.DATA, "Ljava/math/BigDecimal;", EthereumBasedQrCodeParser.GAS_LIMIT, EthereumBasedQrCodeParser.GAS_PRICE, RouteActionKey.RouteActionKeys.CHAIN_ID, "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "asEthereumResult", "(Ljava/lang/String;Ljava/math/BigInteger;[BLjava/math/BigDecimal;Ljava/math/BigDecimal;I)Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", TextBundle.TEXT_ENTRY, "parse", "getChainId", "()I", "", "supportedSchemes", "Ljava/util/List;", "getDecimals", "decimals", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "<init>", "(Lcom/coinbase/ciphercore/CipherCoreInterface;Ljava/util/List;)V", "Companion", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class EthereumBasedQrCodeParser implements QRCodeIntentParser {
    private static final String AMOUNT = "amount";
    public static final Companion Companion = new Companion(null);
    private static final String DATA = "data";
    private static final String GAS_LIMIT = "gasLimit";
    private static final String GAS_PRICE = "gasPrice";
    private static final String VALUE = "value";
    private final CipherCoreInterface cipherCore;
    private final List<String> supportedSchemes;

    /* compiled from: EthereumBasedQrCodeParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/EthereumBasedQrCodeParser$Companion;", "", "", "AMOUNT", "Ljava/lang/String;", "DATA", "GAS_LIMIT", "GAS_PRICE", "VALUE", "<init>", "()V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public EthereumBasedQrCodeParser(CipherCoreInterface cipherCore, List<String> supportedSchemes) {
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        kotlin.jvm.internal.m.g(supportedSchemes, "supportedSchemes");
        this.cipherCore = cipherCore;
        this.supportedSchemes = supportedSchemes;
    }

    public static /* synthetic */ String a(kotlin.o oVar) {
        return m1630parseAddress$lambda4(oVar);
    }

    public static /* synthetic */ QRCodeScanResult b(BigInteger bigInteger, BigInteger bigInteger2, BigDecimal bigDecimal, BigDecimal bigDecimal2, EthereumBasedQrCodeParser ethereumBasedQrCodeParser, byte[] bArr, int i2, String str) {
        return m1629parse$lambda3(bigInteger, bigInteger2, bigDecimal, bigDecimal2, ethereumBasedQrCodeParser, bArr, i2, str);
    }

    public static /* synthetic */ h0 c(Throwable th) {
        return m1631parseAddress$lambda5(th);
    }

    /* renamed from: parse$lambda-3 */
    public static final QRCodeScanResult m1629parse$lambda3(BigInteger bigInteger, BigInteger bigInteger2, BigDecimal bigDecimal, BigDecimal bigDecimal2, EthereumBasedQrCodeParser this$0, byte[] bArr, int i2, String checksummedAddress) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(checksummedAddress, "checksummedAddress");
        BigDecimal bigDecimal3 = new BigDecimal(-1);
        return this$0.asEthereumResult(checksummedAddress, bigInteger == null ? bigInteger2 : bigInteger, bArr, (bigDecimal == null || bigDecimal.compareTo(bigDecimal3) <= 0) ? null : bigDecimal, (bigDecimal2 == null || bigDecimal2.compareTo(bigDecimal3) <= 0) ? null : bigDecimal2, i2);
    }

    private final b0<String> parseAddress(String str) {
        String e2 = new kotlin.l0.k("^pay-").e(str, "");
        b0<String> onErrorResumeNext = h.c.t0.f.a(this.cipherCore.checksumEthereumAddress(e2), this.cipherCore.isValidEthereumAddress(e2)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedQrCodeParser.a((kotlin.o) obj);
            }
        }).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return EthereumBasedQrCodeParser.c((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext, "cipherCore.checksumEthereumAddress(ethereumAddress)\n            .zipWith(cipherCore.isValidEthereumAddress(ethereumAddress))\n            .map { (checksummedEthereumAddress, isValidEthereumAddress) ->\n                if (!isValidEthereumAddress) {\n                    throw InvalidQrCode(\"Unable to parse scanned text\")\n                }\n\n                checksummedEthereumAddress\n            }\n            .onErrorResumeNext { Single.error(InvalidQrCode(\"Unable to parse address\")) }");
        return onErrorResumeNext;
    }

    /* renamed from: parseAddress$lambda-4 */
    public static final String m1630parseAddress$lambda4(kotlin.o dstr$checksummedEthereumAddress$isValidEthereumAddress) {
        kotlin.jvm.internal.m.g(dstr$checksummedEthereumAddress$isValidEthereumAddress, "$dstr$checksummedEthereumAddress$isValidEthereumAddress");
        String str = (String) dstr$checksummedEthereumAddress$isValidEthereumAddress.a();
        if (((Boolean) dstr$checksummedEthereumAddress$isValidEthereumAddress.b()).booleanValue()) {
            return str;
        }
        throw new QrException.InvalidQrCode("Unable to parse scanned text");
    }

    /* renamed from: parseAddress$lambda-5 */
    public static final h0 m1631parseAddress$lambda5(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return b0.error(new QrException.InvalidQrCode("Unable to parse address"));
    }

    private final kotlin.o<String, Integer> parseAddressAndChainId(String str) {
        List K0;
        K0 = y.K0(str, new String[]{"@"}, false, 0, 6, null);
        if (K0.size() == 2 && isValid(Integer.parseInt((String) K0.get(1)))) {
            return new kotlin.o<>(K0.get(0), Integer.valueOf(Integer.parseInt((String) K0.get(1))));
        }
        if (K0.size() == 1) {
            return new kotlin.o<>(K0.get(0), Integer.valueOf(getChainId()));
        }
        return null;
    }

    public abstract QRCodeScanResult asEthereumResult(String str, BigInteger bigInteger, byte[] bArr, BigDecimal bigDecimal, BigDecimal bigDecimal2, int i2);

    public abstract int getChainId();

    public abstract int getDecimals();

    public abstract boolean isValid(int i2);

    @Override // com.coinbase.wallet.qr.parsers.QRCodeIntentParser
    public b0<QRCodeScanResult> parse(String text) {
        String K;
        int r;
        Map r2;
        int i0;
        BigDecimal j2;
        final BigDecimal bigDecimal;
        BigDecimal j3;
        final BigDecimal bigDecimal2;
        String str;
        BigDecimal j4;
        BigDecimal movePointRight;
        BigInteger bigInteger;
        int i02;
        kotlin.jvm.internal.m.g(text, "text");
        K = x.K(text, WalletConstants.URIPrefixes.ETC, WalletConstants.URIPrefixes.ETC_ALT, false, 4, null);
        Uri parse = Uri.parse(K);
        List<UrlQuerySanitizer.ParameterValuePair> parameterList = new UrlQuerySanitizer(K).getParameterList();
        kotlin.jvm.internal.m.f(parameterList, "UrlQuerySanitizer(sanitizedText)\n            .parameterList");
        r = kotlin.a0.s.r(parameterList, 10);
        ArrayList arrayList = new ArrayList(r);
        for (UrlQuerySanitizer.ParameterValuePair parameterValuePair : parameterList) {
            arrayList.add(kotlin.u.a(parameterValuePair.mParameter, parameterValuePair.mValue));
        }
        r2 = m0.r(arrayList);
        String path = parse.getSchemeSpecificPart();
        kotlin.jvm.internal.m.f(path, "it");
        i0 = y.i0(path, "?", 0, false, 6, null);
        if (i0 > 0) {
            i02 = y.i0(path, "?", 0, false, 6, null);
            path = path.substring(0, i02);
            kotlin.jvm.internal.m.f(path, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        kotlin.jvm.internal.m.f(path, "path");
        kotlin.o<String, Integer> parseAddressAndChainId = parseAddressAndChainId(path);
        BigInteger bigInteger2 = null;
        if (parseAddressAndChainId == null) {
            parseAddressAndChainId = new kotlin.o<>(null, Integer.valueOf(getChainId()));
        }
        String a = parseAddressAndChainId.a();
        final int intValue = parseAddressAndChainId.b().intValue();
        if (this.supportedSchemes.contains(parse.getScheme()) && a != null) {
            String str2 = (String) r2.get(GAS_LIMIT);
            if (str2 == null) {
                bigDecimal = null;
            } else {
                j2 = v.j(str2);
                bigDecimal = j2;
            }
            String str3 = (String) r2.get(GAS_PRICE);
            if (str3 == null) {
                bigDecimal2 = null;
            } else {
                j3 = v.j(str3);
                bigDecimal2 = j3;
            }
            String str4 = (String) r2.get(DATA);
            final byte[] byteArrayUsingHexEncoding = str4 == null ? null : String_CipherCoreKt.toByteArrayUsingHexEncoding(str4);
            String str5 = (String) r2.get(VALUE);
            final BigInteger bigInteger3 = str5 == null ? null : new BigInteger(str5);
            if (bigInteger3 == null && (str = (String) r2.get("amount")) != null) {
                if (String_CommonKt.isScientificNotation(str)) {
                    bigInteger = new BigDecimal(str).toBigInteger();
                } else {
                    j4 = v.j(str);
                    if (j4 != null && (movePointRight = j4.movePointRight(getDecimals())) != null) {
                        bigInteger = movePointRight.toBigInteger();
                    }
                }
                bigInteger2 = bigInteger;
            }
            final BigInteger bigInteger4 = bigInteger2;
            b0 map = parseAddress(a).map(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.g
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumBasedQrCodeParser.b(bigInteger3, bigInteger4, bigDecimal, bigDecimal2, this, byteArrayUsingHexEncoding, intValue, (String) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "parseAddress(address)\n            .map { checksummedAddress ->\n                val negativeOne = BigDecimal(-1)\n                var gasLimitBigDecimal: BigDecimal? = null\n                var gasPriceBigDecimal: BigDecimal? = null\n                val amountBigInteger: BigInteger? = value ?: amount\n\n                if (gasLimit != null && gasLimit > negativeOne) gasLimitBigDecimal = gasLimit\n                if (gasPrice != null && gasPrice > negativeOne) gasPriceBigDecimal = gasPrice\n\n                asEthereumResult(\n                    address = checksummedAddress,\n                    amount = amountBigInteger,\n                    data = data,\n                    gasLimit = gasLimitBigDecimal,\n                    gasPrice = gasPriceBigDecimal,\n                    chainId = parsedChainId\n                )\n            }");
            return map;
        }
        b0<QRCodeScanResult> error = b0.error(new QrException.InvalidQrCode("Invalid QR Code"));
        kotlin.jvm.internal.m.f(error, "error<QRCodeScanResult>(InvalidQrCode(\"Invalid QR Code\"))");
        return error;
    }
}