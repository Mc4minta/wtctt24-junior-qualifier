package com.coinbase.walletengine.services.stellar;

import android.util.Base64;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.qr.models.WalletConstants;
import com.coinbase.walletengine.Optional;
import com.coinbase.walletengine.WalletEngine;
import com.squareup.moshi.Moshi;
import h.c.b0;
import h.c.m0.n;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.u;
import kotlin.x;

/* compiled from: StellarService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 A2\u00020\u0001:\u0001AB\u000f\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b?\u0010@J3\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00062\u0006\u0010\u0017\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001aJ+\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001d0\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b \u0010\u001aJ{\u0010.\u001a\b\u0012\u0004\u0012\u00020+0\u00062\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00182\b\u0010(\u001a\u0004\u0018\u00010\u00022\b\u0010)\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J%\u00101\u001a\b\u0012\u0004\u0012\u0002000\u00062\u0006\u0010/\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b1\u00102J+\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u001d0\u00062\u0006\u00103\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b5\u0010\u001fR\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R$\u0010;\u001a\n :*\u0004\u0018\u000109098\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b;\u0010<\u0012\u0004\b=\u0010>\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006B"}, d2 = {"Lcom/coinbase/walletengine/services/stellar/StellarService;", "", "", "method", "", "params", "Lh/c/b0;", "call", "(Ljava/lang/String;Ljava/util/Map;)Lh/c/b0;", "T", "Ljava/lang/reflect/Type;", "type", "json", "decodeJson", "(Ljava/lang/reflect/Type;Ljava/lang/String;)Ljava/lang/Object;", "", "publicKey", "deriveAddressFromPublicKey", "([B)Lh/c/b0;", "address", "", "isAddressValid", "(Ljava/lang/String;)Lh/c/b0;", "testnet", "Ljava/math/BigInteger;", "getMinimumBalance", "(Z)Lh/c/b0;", "Lkotlin/UInt;", "getLedgerSequence", "Lcom/coinbase/walletengine/Optional;", "getBalance", "(Ljava/lang/String;Z)Lh/c/b0;", "estimateFee", "fromAddress", "toAddress", "amount", ApiConstants.FEE, "validBefore", "memoText", "memoId", "memoHash", "memoReturn", "privateKey", "Lcom/coinbase/walletengine/services/stellar/SignedTransaction;", "signTransaction-u2Zo5yI", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;ILjava/lang/String;Ljava/math/BigInteger;Ljava/lang/String;Ljava/lang/String;[BZ)Lh/c/b0;", "signTransaction", "signedTxData", "Lkotlin/x;", "submitSignedTransaction", "([BZ)Lh/c/b0;", "txHash", "Lcom/coinbase/walletengine/services/stellar/TransactionResult;", "getTransactionResult", "Lcom/coinbase/walletengine/WalletEngine;", "walletEngine", "Lcom/coinbase/walletengine/WalletEngine;", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi$annotations", "()V", "<init>", "(Lcom/coinbase/walletengine/WalletEngine;)V", "Companion", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class StellarService {
    public static final Companion Companion = new Companion(null);
    private final Moshi moshi;
    private final WalletEngine walletEngine;

    /* compiled from: StellarService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletengine/services/stellar/StellarService$Companion;", "", "<init>", "()V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StellarService(WalletEngine walletEngine) {
        m.g(walletEngine, "walletEngine");
        this.walletEngine = walletEngine;
        this.moshi = new Moshi.Builder().add(new BigIntegerJsonAdapter()).add(new ByteArrayJsonAdapter()).add(UInt.class, new UIntJsonAdapter()).build();
    }

    public static /* synthetic */ Optional a(StellarService stellarService, String str) {
        return m2079getTransactionResult$lambda8(stellarService, str);
    }

    public static /* synthetic */ String b(StellarService stellarService, String str) {
        return m2074deriveAddressFromPublicKey$lambda0(stellarService, str);
    }

    public static /* synthetic */ Boolean c(StellarService stellarService, String str) {
        return m2080isAddressValid$lambda1(stellarService, str);
    }

    private final b0<String> call(String str, Map<String, ? extends Object> map) {
        String encodedParams = this.moshi.adapter((Type) Map.class).serializeNulls().toJson(map);
        WalletEngine walletEngine = this.walletEngine;
        m.f(encodedParams, "encodedParams");
        return walletEngine.call(WalletConstants.URIPrefixes.XLM_ALT, str, encodedParams);
    }

    public static /* synthetic */ SignedTransaction d(StellarService stellarService, String str) {
        return m2081signTransaction_u2Zo5yI$lambda6(stellarService, str);
    }

    private final <T> T decodeJson(Type type, String str) {
        return this.moshi.adapter(type).serializeNulls().fromJson(str);
    }

    /* renamed from: deriveAddressFromPublicKey$lambda-0 */
    public static final String m2074deriveAddressFromPublicKey$lambda0(StellarService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return (String) this$0.decodeJson(String.class, it);
    }

    public static /* synthetic */ BigInteger e(StellarService stellarService, String str) {
        return m2075estimateFee$lambda5(stellarService, str);
    }

    /* renamed from: estimateFee$lambda-5 */
    public static final BigInteger m2075estimateFee$lambda5(StellarService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return (BigInteger) this$0.decodeJson(BigInteger.class, it);
    }

    public static /* synthetic */ BigInteger f(StellarService stellarService, String str) {
        return m2078getMinimumBalance$lambda2(stellarService, str);
    }

    public static /* synthetic */ UInt g(StellarService stellarService, String str) {
        return m2077getLedgerSequence$lambda3(stellarService, str);
    }

    /* renamed from: getBalance$lambda-4 */
    public static final Optional m2076getBalance$lambda4(StellarService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return m.c(it, "null") ? new Optional(null) : new Optional(this$0.decodeJson(BigInteger.class, it));
    }

    /* renamed from: getLedgerSequence$lambda-3 */
    public static final UInt m2077getLedgerSequence$lambda3(StellarService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return (UInt) this$0.decodeJson(UInt.class, it);
    }

    /* renamed from: getMinimumBalance$lambda-2 */
    public static final BigInteger m2078getMinimumBalance$lambda2(StellarService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return (BigInteger) this$0.decodeJson(BigInteger.class, it);
    }

    private static /* synthetic */ void getMoshi$annotations() {
    }

    /* renamed from: getTransactionResult$lambda-8 */
    public static final Optional m2079getTransactionResult$lambda8(StellarService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return m.c(it, "null") ? new Optional(null) : new Optional(this$0.decodeJson(TransactionResult.class, it));
    }

    public static /* synthetic */ Optional h(StellarService stellarService, String str) {
        return m2076getBalance$lambda4(stellarService, str);
    }

    public static /* synthetic */ x i(String str) {
        return m2082submitSignedTransaction$lambda7(str);
    }

    /* renamed from: isAddressValid$lambda-1 */
    public static final Boolean m2080isAddressValid$lambda1(StellarService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return (Boolean) this$0.decodeJson(Boolean.class, it);
    }

    /* renamed from: signTransaction_u2Zo5yI$lambda-6 */
    public static final SignedTransaction m2081signTransaction_u2Zo5yI$lambda6(StellarService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return (SignedTransaction) this$0.decodeJson(SignedTransaction.class, it);
    }

    /* renamed from: submitSignedTransaction$lambda-7 */
    public static final x m2082submitSignedTransaction$lambda7(String it) {
        m.g(it, "it");
        return x.a;
    }

    public b0<String> deriveAddressFromPublicKey(byte[] publicKey) {
        Map<String, ? extends Object> e2;
        m.g(publicKey, "publicKey");
        e2 = l0.e(u.a("publicKey", Base64.encodeToString(publicKey, 2)));
        b0 map = call("deriveAddressFromPublicKey", e2).map(new n() { // from class: com.coinbase.walletengine.services.stellar.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarService.b(StellarService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"deriveAddressFromPublicKey\",\n                mapOf(\n                        \"publicKey\" to Base64.encodeToString(publicKey, Base64.NO_WRAP)\n                )\n        )\n                .map { decodeJson<String>(String::class.java, it) }");
        return map;
    }

    public b0<BigInteger> estimateFee(boolean z) {
        Map<String, ? extends Object> e2;
        e2 = l0.e(u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("estimateFee", e2).map(new n() { // from class: com.coinbase.walletengine.services.stellar.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarService.e(StellarService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"estimateFee\",\n                mapOf(\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<BigInteger>(BigInteger::class.java, it) }");
        return map;
    }

    public b0<Optional<BigInteger>> getBalance(String address, boolean z) {
        Map<String, ? extends Object> l2;
        m.g(address, "address");
        l2 = m0.l(u.a("address", address), u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("getBalance", l2).map(new n() { // from class: com.coinbase.walletengine.services.stellar.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarService.h(StellarService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"getBalance\",\n                mapOf(\n                        \"address\" to address,\n                        \"testnet\" to testnet\n                )\n        )\n                .map { if (it == \"null\") { Optional<BigInteger>(null) } else { Optional<BigInteger>(decodeJson<BigInteger?>(BigInteger::class.java, it)) } }");
        return map;
    }

    public b0<UInt> getLedgerSequence(boolean z) {
        Map<String, ? extends Object> e2;
        e2 = l0.e(u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("getLedgerSequence", e2).map(new n() { // from class: com.coinbase.walletengine.services.stellar.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarService.g(StellarService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"getLedgerSequence\",\n                mapOf(\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<UInt>(UInt::class.javaObjectType, it) }");
        return map;
    }

    public b0<BigInteger> getMinimumBalance(boolean z) {
        Map<String, ? extends Object> e2;
        e2 = l0.e(u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("getMinimumBalance", e2).map(new n() { // from class: com.coinbase.walletengine.services.stellar.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarService.f(StellarService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"getMinimumBalance\",\n                mapOf(\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<BigInteger>(BigInteger::class.java, it) }");
        return map;
    }

    public b0<Optional<TransactionResult>> getTransactionResult(String txHash, boolean z) {
        Map<String, ? extends Object> l2;
        m.g(txHash, "txHash");
        l2 = m0.l(u.a("txHash", txHash), u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("getTransactionResult", l2).map(new n() { // from class: com.coinbase.walletengine.services.stellar.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarService.a(StellarService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"getTransactionResult\",\n                mapOf(\n                        \"txHash\" to txHash,\n                        \"testnet\" to testnet\n                )\n        )\n                .map { if (it == \"null\") { Optional<TransactionResult>(null) } else { Optional<TransactionResult>(decodeJson<TransactionResult?>(TransactionResult::class.java, it)) } }");
        return map;
    }

    public b0<Boolean> isAddressValid(String address) {
        Map<String, ? extends Object> e2;
        m.g(address, "address");
        e2 = l0.e(u.a("address", address));
        b0 map = call("isAddressValid", e2).map(new n() { // from class: com.coinbase.walletengine.services.stellar.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarService.c(StellarService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"isAddressValid\",\n                mapOf(\n                        \"address\" to address\n                )\n        )\n                .map { decodeJson<Boolean>(Boolean::class.javaObjectType, it) }");
        return map;
    }

    /* renamed from: signTransaction-u2Zo5yI */
    public b0<SignedTransaction> m2083signTransactionu2Zo5yI(String fromAddress, String toAddress, BigInteger amount, BigInteger fee, int i2, String str, BigInteger bigInteger, String str2, String str3, byte[] privateKey, boolean z) {
        Map<String, ? extends Object> l2;
        m.g(fromAddress, "fromAddress");
        m.g(toAddress, "toAddress");
        m.g(amount, "amount");
        m.g(fee, "fee");
        m.g(privateKey, "privateKey");
        o[] oVarArr = new o[11];
        oVarArr[0] = u.a("fromAddress", fromAddress);
        oVarArr[1] = u.a("toAddress", toAddress);
        oVarArr[2] = u.a("amount", amount.toString());
        oVarArr[3] = u.a(ApiConstants.FEE, fee.toString());
        oVarArr[4] = u.a("validBefore", UInt.h(i2));
        oVarArr[5] = u.a("memoText", str);
        oVarArr[6] = u.a("memoId", bigInteger == null ? null : bigInteger.toString());
        oVarArr[7] = u.a("memoHash", str2);
        oVarArr[8] = u.a("memoReturn", str3);
        oVarArr[9] = u.a("privateKey", Base64.encodeToString(privateKey, 2));
        oVarArr[10] = u.a("testnet", Boolean.valueOf(z));
        l2 = m0.l(oVarArr);
        b0 map = call("signTransaction", l2).map(new n() { // from class: com.coinbase.walletengine.services.stellar.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarService.d(StellarService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"signTransaction\",\n                mapOf(\n                        \"fromAddress\" to fromAddress,\n                        \"toAddress\" to toAddress,\n                        \"amount\" to amount.toString(),\n                        \"fee\" to fee.toString(),\n                        \"validBefore\" to validBefore,\n                        \"memoText\" to memoText,\n                        \"memoId\" to memoId?.toString(),\n                        \"memoHash\" to memoHash,\n                        \"memoReturn\" to memoReturn,\n                        \"privateKey\" to Base64.encodeToString(privateKey, Base64.NO_WRAP),\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<SignedTransaction>(SignedTransaction::class.java, it) }");
        return map;
    }

    public b0<x> submitSignedTransaction(byte[] signedTxData, boolean z) {
        Map<String, ? extends Object> l2;
        m.g(signedTxData, "signedTxData");
        l2 = m0.l(u.a("signedTxData", Base64.encodeToString(signedTxData, 2)), u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("submitSignedTransaction", l2).map(new n() { // from class: com.coinbase.walletengine.services.stellar.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarService.i((String) obj);
            }
        });
        m.f(map, "call(\n                \"submitSignedTransaction\",\n                mapOf(\n                        \"signedTxData\" to Base64.encodeToString(signedTxData, Base64.NO_WRAP),\n                        \"testnet\" to testnet\n                )\n        )\n                .map { Unit }");
        return map;
    }
}