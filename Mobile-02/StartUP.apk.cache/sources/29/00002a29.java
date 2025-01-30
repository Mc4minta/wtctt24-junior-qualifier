package com.coinbase.walletengine.services.bitcoin;

import android.util.Base64;
import com.coinbase.ApiConstants;
import com.coinbase.walletengine.WalletEngine;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import h.c.b0;
import h.c.m0.n;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.o;
import kotlin.u;
import kotlin.x;

/* compiled from: BitcoinService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 J2\u00020\u0001:\u0001JB\u000f\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bH\u0010IJ3\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ;\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010\u0014\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00062\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001f\u0010\u001aJ#\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0 0\u00062\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b!\u0010\u001dJ1\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0 0\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020 2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b$\u0010%JK\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020#0 2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b,\u0010-J;\u0010.\u001a\b\u0012\u0004\u0012\u00020+0\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020#0 2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b.\u0010/J9\u00104\u001a\b\u0012\u0004\u0012\u0002030\u00062\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002000\u00042\u0006\u00102\u001a\u00020+2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b4\u00105J%\u00108\u001a\b\u0012\u0004\u0012\u0002070\u00062\u0006\u00106\u001a\u0002002\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b8\u00109J%\u0010<\u001a\b\u0012\u0004\u0012\u00020;0\u00062\u0006\u0010:\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b<\u0010\u001aJ;\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u0010\u0016R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR$\u0010D\u001a\n C*\u0004\u0018\u00010B0B8\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\bD\u0010E\u0012\u0004\bF\u0010G\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006K"}, d2 = {"Lcom/coinbase/walletengine/services/bitcoin/BitcoinService;", "", "", "method", "", "params", "Lh/c/b0;", "call", "(Ljava/lang/String;Ljava/util/Map;)Lh/c/b0;", "T", "Ljava/lang/reflect/Type;", "type", "json", "decodeJson", "(Ljava/lang/reflect/Type;Ljava/lang/String;)Ljava/lang/Object;", "xpubKey", "Lkotlin/UInt;", "index", "", "change", "testnet", "deriveLegacyAddressFromXpubKey-Yuhug_o", "(Ljava/lang/String;IZZ)Lh/c/b0;", "deriveLegacyAddressFromXpubKey", "address", "isAddressValid", "(Ljava/lang/String;Z)Lh/c/b0;", "isAddressUsed", "getBlockHeight", "(Z)Lh/c/b0;", "Ljava/math/BigInteger;", "getBalance", "", "estimateFee", ApiConstants.ADDRESSES, "Lcom/coinbase/walletengine/services/bitcoin/UTXO;", "getUTXOs", "(Ljava/util/List;Z)Lh/c/b0;", "utxos", "toAddress", "changeAddress", "amount", "feeRate", "Lcom/coinbase/walletengine/services/bitcoin/CoinSelection;", "selectCoins", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Z)Lh/c/b0;", "sweepCoins", "(Ljava/util/List;Ljava/lang/String;Ljava/math/BigInteger;Z)Lh/c/b0;", "", "privateKeys", "coinSelection", "Lcom/coinbase/walletengine/services/bitcoin/SignedTransaction;", "signTransaction", "(Ljava/util/Map;Lcom/coinbase/walletengine/services/bitcoin/CoinSelection;Z)Lh/c/b0;", "signedTxData", "Lkotlin/x;", "submitSignedTransaction", "([BZ)Lh/c/b0;", "txHash", "Lcom/coinbase/walletengine/services/bitcoin/TransactionResult;", "getTransactionResult", "deriveSegwitAddressFromXpubKey-Yuhug_o", "deriveSegwitAddressFromXpubKey", "Lcom/coinbase/walletengine/WalletEngine;", "walletEngine", "Lcom/coinbase/walletengine/WalletEngine;", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi$annotations", "()V", "<init>", "(Lcom/coinbase/walletengine/WalletEngine;)V", "Companion", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class BitcoinService {
    public static final Companion Companion = new Companion(null);
    private final Moshi moshi;
    private final WalletEngine walletEngine;

    /* compiled from: BitcoinService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletengine/services/bitcoin/BitcoinService$Companion;", "", "<init>", "()V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BitcoinService(WalletEngine walletEngine) {
        kotlin.jvm.internal.m.g(walletEngine, "walletEngine");
        this.walletEngine = walletEngine;
        this.moshi = new Moshi.Builder().add(new BigIntegerJsonAdapter()).add(new ByteArrayJsonAdapter()).add(UInt.class, new UIntJsonAdapter()).build();
    }

    public static /* synthetic */ UInt a(BitcoinService bitcoinService, String str) {
        return m1927getBlockHeight$lambda3(bitcoinService, str);
    }

    public static /* synthetic */ BigInteger b(BitcoinService bitcoinService, String str) {
        return m1926getBalance$lambda4(bitcoinService, str);
    }

    public static /* synthetic */ TransactionResult c(BitcoinService bitcoinService, String str) {
        return m1928getTransactionResult$lambda15(bitcoinService, str);
    }

    private final b0<String> call(String str, Map<String, ? extends Object> map) {
        String encodedParams = this.moshi.adapter((Type) Map.class).serializeNulls().toJson(map);
        WalletEngine walletEngine = this.walletEngine;
        kotlin.jvm.internal.m.f(encodedParams, "encodedParams");
        return walletEngine.call("bitcoin", str, encodedParams);
    }

    public static /* synthetic */ String d(BitcoinService bitcoinService, String str) {
        return m1924deriveSegwitAddressFromXpubKey_Yuhug_o$lambda16(bitcoinService, str);
    }

    private final <T> T decodeJson(Type type, String str) {
        return this.moshi.adapter(type).serializeNulls().fromJson(str);
    }

    /* renamed from: deriveLegacyAddressFromXpubKey_Yuhug_o$lambda-0 */
    public static final String m1923deriveLegacyAddressFromXpubKey_Yuhug_o$lambda0(BitcoinService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (String) this$0.decodeJson(String.class, it);
    }

    /* renamed from: deriveSegwitAddressFromXpubKey_Yuhug_o$lambda-16 */
    public static final String m1924deriveSegwitAddressFromXpubKey_Yuhug_o$lambda16(BitcoinService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (String) this$0.decodeJson(String.class, it);
    }

    public static /* synthetic */ List e(BitcoinService bitcoinService, String str) {
        return m1925estimateFee$lambda5(bitcoinService, str);
    }

    /* renamed from: estimateFee$lambda-5 */
    public static final List m1925estimateFee$lambda5(BitcoinService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, BigInteger.class);
        kotlin.jvm.internal.m.f(newParameterizedType, "newParameterizedType(List::class.java, BigInteger::class.java)");
        return (List) this$0.decodeJson(newParameterizedType, it);
    }

    public static /* synthetic */ List f(BitcoinService bitcoinService, String str) {
        return m1929getUTXOs$lambda7(bitcoinService, str);
    }

    public static /* synthetic */ CoinSelection g(BitcoinService bitcoinService, String str) {
        return m1935sweepCoins$lambda11(bitcoinService, str);
    }

    /* renamed from: getBalance$lambda-4 */
    public static final BigInteger m1926getBalance$lambda4(BitcoinService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (BigInteger) this$0.decodeJson(BigInteger.class, it);
    }

    /* renamed from: getBlockHeight$lambda-3 */
    public static final UInt m1927getBlockHeight$lambda3(BitcoinService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (UInt) this$0.decodeJson(UInt.class, it);
    }

    private static /* synthetic */ void getMoshi$annotations() {
    }

    /* renamed from: getTransactionResult$lambda-15 */
    public static final TransactionResult m1928getTransactionResult$lambda15(BitcoinService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (TransactionResult) this$0.decodeJson(TransactionResult.class, it);
    }

    /* renamed from: getUTXOs$lambda-7 */
    public static final List m1929getUTXOs$lambda7(BitcoinService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, UTXO.class);
        kotlin.jvm.internal.m.f(newParameterizedType, "newParameterizedType(List::class.java, UTXO::class.java)");
        return (List) this$0.decodeJson(newParameterizedType, it);
    }

    public static /* synthetic */ Boolean h(BitcoinService bitcoinService, String str) {
        return m1931isAddressValid$lambda1(bitcoinService, str);
    }

    public static /* synthetic */ String i(BitcoinService bitcoinService, String str) {
        return m1923deriveLegacyAddressFromXpubKey_Yuhug_o$lambda0(bitcoinService, str);
    }

    /* renamed from: isAddressUsed$lambda-2 */
    public static final Boolean m1930isAddressUsed$lambda2(BitcoinService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (Boolean) this$0.decodeJson(Boolean.class, it);
    }

    /* renamed from: isAddressValid$lambda-1 */
    public static final Boolean m1931isAddressValid$lambda1(BitcoinService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (Boolean) this$0.decodeJson(Boolean.class, it);
    }

    public static /* synthetic */ CoinSelection j(BitcoinService bitcoinService, String str) {
        return m1932selectCoins$lambda9(bitcoinService, str);
    }

    public static /* synthetic */ x k(String str) {
        return m1934submitSignedTransaction$lambda14(str);
    }

    public static /* synthetic */ Boolean l(BitcoinService bitcoinService, String str) {
        return m1930isAddressUsed$lambda2(bitcoinService, str);
    }

    public static /* synthetic */ SignedTransaction m(BitcoinService bitcoinService, String str) {
        return m1933signTransaction$lambda13(bitcoinService, str);
    }

    /* renamed from: selectCoins$lambda-9 */
    public static final CoinSelection m1932selectCoins$lambda9(BitcoinService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (CoinSelection) this$0.decodeJson(CoinSelection.class, it);
    }

    /* renamed from: signTransaction$lambda-13 */
    public static final SignedTransaction m1933signTransaction$lambda13(BitcoinService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (SignedTransaction) this$0.decodeJson(SignedTransaction.class, it);
    }

    /* renamed from: submitSignedTransaction$lambda-14 */
    public static final x m1934submitSignedTransaction$lambda14(String it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    /* renamed from: sweepCoins$lambda-11 */
    public static final CoinSelection m1935sweepCoins$lambda11(BitcoinService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (CoinSelection) this$0.decodeJson(CoinSelection.class, it);
    }

    /* renamed from: deriveLegacyAddressFromXpubKey-Yuhug_o */
    public b0<String> m1936deriveLegacyAddressFromXpubKeyYuhug_o(String xpubKey, int i2, boolean z, boolean z2) {
        Map<String, ? extends Object> l2;
        kotlin.jvm.internal.m.g(xpubKey, "xpubKey");
        l2 = m0.l(u.a("xpubKey", xpubKey), u.a("index", UInt.h(i2)), u.a("change", Boolean.valueOf(z)), u.a("testnet", Boolean.valueOf(z2)));
        b0 map = call("deriveLegacyAddressFromXpubKey", l2).map(new n() { // from class: com.coinbase.walletengine.services.bitcoin.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BitcoinService.i(BitcoinService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"deriveLegacyAddressFromXpubKey\",\n                mapOf(\n                        \"xpubKey\" to xpubKey,\n                        \"index\" to index,\n                        \"change\" to change,\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<String>(String::class.java, it) }");
        return map;
    }

    /* renamed from: deriveSegwitAddressFromXpubKey-Yuhug_o */
    public b0<String> m1937deriveSegwitAddressFromXpubKeyYuhug_o(String xpubKey, int i2, boolean z, boolean z2) {
        Map<String, ? extends Object> l2;
        kotlin.jvm.internal.m.g(xpubKey, "xpubKey");
        l2 = m0.l(u.a("xpubKey", xpubKey), u.a("index", UInt.h(i2)), u.a("change", Boolean.valueOf(z)), u.a("testnet", Boolean.valueOf(z2)));
        b0 map = call("deriveSegwitAddressFromXpubKey", l2).map(new n() { // from class: com.coinbase.walletengine.services.bitcoin.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BitcoinService.d(BitcoinService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"deriveSegwitAddressFromXpubKey\",\n                mapOf(\n                        \"xpubKey\" to xpubKey,\n                        \"index\" to index,\n                        \"change\" to change,\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<String>(String::class.java, it) }");
        return map;
    }

    public b0<List<BigInteger>> estimateFee(boolean z) {
        Map<String, ? extends Object> e2;
        e2 = l0.e(u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("estimateFee", e2).map(new n() { // from class: com.coinbase.walletengine.services.bitcoin.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BitcoinService.e(BitcoinService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"estimateFee\",\n                mapOf(\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<List<BigInteger>>(Types.newParameterizedType(List::class.java, BigInteger::class.java), it) }");
        return map;
    }

    public b0<BigInteger> getBalance(String address, boolean z) {
        Map<String, ? extends Object> l2;
        kotlin.jvm.internal.m.g(address, "address");
        l2 = m0.l(u.a("address", address), u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("getBalance", l2).map(new n() { // from class: com.coinbase.walletengine.services.bitcoin.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BitcoinService.b(BitcoinService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"getBalance\",\n                mapOf(\n                        \"address\" to address,\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<BigInteger>(BigInteger::class.java, it) }");
        return map;
    }

    public b0<UInt> getBlockHeight(boolean z) {
        Map<String, ? extends Object> e2;
        e2 = l0.e(u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("getBlockHeight", e2).map(new n() { // from class: com.coinbase.walletengine.services.bitcoin.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BitcoinService.a(BitcoinService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"getBlockHeight\",\n                mapOf(\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<UInt>(UInt::class.javaObjectType, it) }");
        return map;
    }

    public b0<TransactionResult> getTransactionResult(String txHash, boolean z) {
        Map<String, ? extends Object> l2;
        kotlin.jvm.internal.m.g(txHash, "txHash");
        l2 = m0.l(u.a("txHash", txHash), u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("getTransactionResult", l2).map(new n() { // from class: com.coinbase.walletengine.services.bitcoin.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BitcoinService.c(BitcoinService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"getTransactionResult\",\n                mapOf(\n                        \"txHash\" to txHash,\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<TransactionResult>(TransactionResult::class.java, it) }");
        return map;
    }

    public b0<List<UTXO>> getUTXOs(List<String> addresses, boolean z) {
        Map<String, ? extends Object> l2;
        kotlin.jvm.internal.m.g(addresses, "addresses");
        o[] oVarArr = new o[2];
        ArrayList arrayList = new ArrayList();
        for (String str : addresses) {
            if (str != null) {
                arrayList.add(str);
            }
        }
        oVarArr[0] = u.a(ApiConstants.ADDRESSES, arrayList);
        oVarArr[1] = u.a("testnet", Boolean.valueOf(z));
        l2 = m0.l(oVarArr);
        b0 map = call("getUTXOs", l2).map(new n() { // from class: com.coinbase.walletengine.services.bitcoin.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BitcoinService.f(BitcoinService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"getUTXOs\",\n                mapOf(\n                        \"addresses\" to addresses.mapNotNull { it },\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<List<UTXO>>(Types.newParameterizedType(List::class.java, UTXO::class.java), it) }");
        return map;
    }

    public b0<Boolean> isAddressUsed(String address, boolean z) {
        Map<String, ? extends Object> l2;
        kotlin.jvm.internal.m.g(address, "address");
        l2 = m0.l(u.a("address", address), u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("isAddressUsed", l2).map(new n() { // from class: com.coinbase.walletengine.services.bitcoin.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BitcoinService.l(BitcoinService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"isAddressUsed\",\n                mapOf(\n                        \"address\" to address,\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<Boolean>(Boolean::class.javaObjectType, it) }");
        return map;
    }

    public b0<Boolean> isAddressValid(String address, boolean z) {
        Map<String, ? extends Object> l2;
        kotlin.jvm.internal.m.g(address, "address");
        l2 = m0.l(u.a("address", address), u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("isAddressValid", l2).map(new n() { // from class: com.coinbase.walletengine.services.bitcoin.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BitcoinService.h(BitcoinService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"isAddressValid\",\n                mapOf(\n                        \"address\" to address,\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<Boolean>(Boolean::class.javaObjectType, it) }");
        return map;
    }

    public b0<CoinSelection> selectCoins(List<UTXO> utxos, String toAddress, String changeAddress, BigInteger amount, BigInteger feeRate, boolean z) {
        Map<String, ? extends Object> l2;
        Map asJSONMap;
        kotlin.jvm.internal.m.g(utxos, "utxos");
        kotlin.jvm.internal.m.g(toAddress, "toAddress");
        kotlin.jvm.internal.m.g(changeAddress, "changeAddress");
        kotlin.jvm.internal.m.g(amount, "amount");
        kotlin.jvm.internal.m.g(feeRate, "feeRate");
        o[] oVarArr = new o[6];
        ArrayList arrayList = new ArrayList();
        for (UTXO utxo : utxos) {
            asJSONMap = BitcoinServiceKt.asJSONMap(utxo);
            if (asJSONMap != null) {
                arrayList.add(asJSONMap);
            }
        }
        oVarArr[0] = u.a("utxos", arrayList);
        oVarArr[1] = u.a("toAddress", toAddress);
        oVarArr[2] = u.a("changeAddress", changeAddress);
        oVarArr[3] = u.a("amount", amount.toString());
        oVarArr[4] = u.a("feeRate", feeRate.toString());
        oVarArr[5] = u.a("testnet", Boolean.valueOf(z));
        l2 = m0.l(oVarArr);
        b0 map = call("selectCoins", l2).map(new n() { // from class: com.coinbase.walletengine.services.bitcoin.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BitcoinService.j(BitcoinService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"selectCoins\",\n                mapOf(\n                        \"utxos\" to utxos.mapNotNull { it.asJSONMap() },\n                        \"toAddress\" to toAddress,\n                        \"changeAddress\" to changeAddress,\n                        \"amount\" to amount.toString(),\n                        \"feeRate\" to feeRate.toString(),\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<CoinSelection>(CoinSelection::class.java, it) }");
        return map;
    }

    public b0<SignedTransaction> signTransaction(Map<String, byte[]> privateKeys, CoinSelection coinSelection, boolean z) {
        int d2;
        Map asJSONMap;
        Map<String, ? extends Object> l2;
        kotlin.jvm.internal.m.g(privateKeys, "privateKeys");
        kotlin.jvm.internal.m.g(coinSelection, "coinSelection");
        o[] oVarArr = new o[3];
        d2 = l0.d(privateKeys.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(d2);
        Iterator<T> it = privateKeys.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), Base64.encodeToString((byte[]) entry.getValue(), 2));
        }
        oVarArr[0] = u.a("privateKeys", linkedHashMap);
        asJSONMap = BitcoinServiceKt.asJSONMap(coinSelection);
        oVarArr[1] = u.a("coinSelection", asJSONMap);
        oVarArr[2] = u.a("testnet", Boolean.valueOf(z));
        l2 = m0.l(oVarArr);
        b0 map = call("signTransaction", l2).map(new n() { // from class: com.coinbase.walletengine.services.bitcoin.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BitcoinService.m(BitcoinService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"signTransaction\",\n                mapOf(\n                        \"privateKeys\" to privateKeys.mapValues { Base64.encodeToString(it.value, Base64.NO_WRAP) },\n                        \"coinSelection\" to coinSelection.asJSONMap(),\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<SignedTransaction>(SignedTransaction::class.java, it) }");
        return map;
    }

    public b0<x> submitSignedTransaction(byte[] signedTxData, boolean z) {
        Map<String, ? extends Object> l2;
        kotlin.jvm.internal.m.g(signedTxData, "signedTxData");
        l2 = m0.l(u.a("signedTxData", Base64.encodeToString(signedTxData, 2)), u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("submitSignedTransaction", l2).map(new n() { // from class: com.coinbase.walletengine.services.bitcoin.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BitcoinService.k((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"submitSignedTransaction\",\n                mapOf(\n                        \"signedTxData\" to Base64.encodeToString(signedTxData, Base64.NO_WRAP),\n                        \"testnet\" to testnet\n                )\n        )\n                .map { Unit }");
        return map;
    }

    public b0<CoinSelection> sweepCoins(List<UTXO> utxos, String toAddress, BigInteger feeRate, boolean z) {
        Map<String, ? extends Object> l2;
        Map asJSONMap;
        kotlin.jvm.internal.m.g(utxos, "utxos");
        kotlin.jvm.internal.m.g(toAddress, "toAddress");
        kotlin.jvm.internal.m.g(feeRate, "feeRate");
        o[] oVarArr = new o[4];
        ArrayList arrayList = new ArrayList();
        for (UTXO utxo : utxos) {
            asJSONMap = BitcoinServiceKt.asJSONMap(utxo);
            if (asJSONMap != null) {
                arrayList.add(asJSONMap);
            }
        }
        oVarArr[0] = u.a("utxos", arrayList);
        oVarArr[1] = u.a("toAddress", toAddress);
        oVarArr[2] = u.a("feeRate", feeRate.toString());
        oVarArr[3] = u.a("testnet", Boolean.valueOf(z));
        l2 = m0.l(oVarArr);
        b0 map = call("sweepCoins", l2).map(new n() { // from class: com.coinbase.walletengine.services.bitcoin.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BitcoinService.g(BitcoinService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"sweepCoins\",\n                mapOf(\n                        \"utxos\" to utxos.mapNotNull { it.asJSONMap() },\n                        \"toAddress\" to toAddress,\n                        \"feeRate\" to feeRate.toString(),\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<CoinSelection>(CoinSelection::class.java, it) }");
        return map;
    }
}