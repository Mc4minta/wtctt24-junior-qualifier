package com.coinbase.walletengine.services.xrp;

import android.util.Base64;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.qr.models.WalletConstants;
import com.coinbase.walletengine.Optional;
import com.coinbase.walletengine.WalletEngine;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import h.c.b0;
import h.c.m0.n;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.u;
import kotlin.x;

/* compiled from: XRPService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 K2\u00020\u0001:\u0001KB\u000f\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bI\u0010JJ3\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00062\u0006\u0010\u0017\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001aJ+\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001f\u0010 J;\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001d0\u00062\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b%\u0010\u001aJy\u00102\u001a\b\u0012\u0004\u0012\u00020/0\u00062\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u001b2\b\u0010+\u001a\u0004\u0018\u00010\u001b2\b\u0010,\u001a\u0004\u0018\u00010\u001b2\b\u0010-\u001a\u0004\u0018\u00010\u00022\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J%\u00105\u001a\b\u0012\u0004\u0012\u0002040\u00062\u0006\u00103\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b5\u00106J=\u0010<\u001a\b\u0012\u0004\u0012\u0002090\u00062\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010;J+\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0=0\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b?\u0010 R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR$\u0010E\u001a\n D*\u0004\u0018\u00010C0C8\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\bE\u0010F\u0012\u0004\bG\u0010H\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"Lcom/coinbase/walletengine/services/xrp/XRPService;", "", "", "method", "", "params", "Lh/c/b0;", "call", "(Ljava/lang/String;Ljava/util/Map;)Lh/c/b0;", "T", "Ljava/lang/reflect/Type;", "type", "json", "decodeJson", "(Ljava/lang/reflect/Type;Ljava/lang/String;)Ljava/lang/Object;", "", "publicKey", "deriveAddressFromPublicKey", "([B)Lh/c/b0;", "address", "", "isAddressValid", "(Ljava/lang/String;)Lh/c/b0;", "testnet", "Ljava/math/BigInteger;", "getReserveBase", "(Z)Lh/c/b0;", "Lkotlin/UInt;", "getLedgerVersion", "Lcom/coinbase/walletengine/Optional;", "Lcom/coinbase/walletengine/services/xrp/AccountInfo;", "getAccountInfo", "(Ljava/lang/String;Z)Lh/c/b0;", "atLedgerVersion", "getBalance-SLwFa_Y", "(Ljava/lang/String;Lkotlin/UInt;Z)Lh/c/b0;", "getBalance", "estimateFee", "fromAddress", "toAddress", "amount", ApiConstants.FEE, "maxLedgerVersionOffset", "sourceTag", "destinationTag", "invoiceId", "privateKey", "Lcom/coinbase/walletengine/services/xrp/SignedTransaction;", "signTransaction-gXGYdlU", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;ILkotlin/UInt;Lkotlin/UInt;Ljava/lang/String;[B[BZ)Lh/c/b0;", "signTransaction", "signedTxData", "Lkotlin/x;", "submitSignedTransaction", "([BZ)Lh/c/b0;", "txHash", "maxLedgerVersion", "Lcom/coinbase/walletengine/services/xrp/TransactionResult;", "getTransactionResult-JaBXUxU", "(Ljava/lang/String;ILkotlin/UInt;Z)Lh/c/b0;", "getTransactionResult", "", "Lcom/coinbase/walletengine/services/xrp/Transaction;", "getTransactions", "Lcom/coinbase/walletengine/WalletEngine;", "walletEngine", "Lcom/coinbase/walletengine/WalletEngine;", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi$annotations", "()V", "<init>", "(Lcom/coinbase/walletengine/WalletEngine;)V", "Companion", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class XRPService {
    public static final Companion Companion = new Companion(null);
    private final Moshi moshi;
    private final WalletEngine walletEngine;

    /* compiled from: XRPService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletengine/services/xrp/XRPService$Companion;", "", "<init>", "()V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public XRPService(WalletEngine walletEngine) {
        m.g(walletEngine, "walletEngine");
        this.walletEngine = walletEngine;
        this.moshi = new Moshi.Builder().add(new BigIntegerJsonAdapter()).add(new ByteArrayJsonAdapter()).add(UInt.class, new UIntJsonAdapter()).build();
    }

    public static /* synthetic */ SignedTransaction a(XRPService xRPService, String str) {
        return m2119signTransaction_gXGYdlU$lambda7(xRPService, str);
    }

    public static /* synthetic */ Optional b(XRPService xRPService, String str) {
        return m2113getBalance_SLwFa_Y$lambda5(xRPService, str);
    }

    public static /* synthetic */ String c(XRPService xRPService, String str) {
        return m2110deriveAddressFromPublicKey$lambda0(xRPService, str);
    }

    private final b0<String> call(String str, Map<String, ? extends Object> map) {
        String encodedParams = this.moshi.adapter((Type) Map.class).serializeNulls().toJson(map);
        WalletEngine walletEngine = this.walletEngine;
        m.f(encodedParams, "encodedParams");
        return walletEngine.call(WalletConstants.URIPrefixes.XRP_ALT, str, encodedParams);
    }

    public static /* synthetic */ Boolean d(XRPService xRPService, String str) {
        return m2118isAddressValid$lambda1(xRPService, str);
    }

    private final <T> T decodeJson(Type type, String str) {
        return this.moshi.adapter(type).serializeNulls().fromJson(str);
    }

    /* renamed from: deriveAddressFromPublicKey$lambda-0 */
    public static final String m2110deriveAddressFromPublicKey$lambda0(XRPService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return (String) this$0.decodeJson(String.class, it);
    }

    public static /* synthetic */ x e(String str) {
        return m2120submitSignedTransaction$lambda8(str);
    }

    /* renamed from: estimateFee$lambda-6 */
    public static final BigInteger m2111estimateFee$lambda6(XRPService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return (BigInteger) this$0.decodeJson(BigInteger.class, it);
    }

    public static /* synthetic */ BigInteger f(XRPService xRPService, String str) {
        return m2115getReserveBase$lambda2(xRPService, str);
    }

    public static /* synthetic */ List g(XRPService xRPService, String str) {
        return m2117getTransactions$lambda10(xRPService, str);
    }

    /* renamed from: getAccountInfo$lambda-4 */
    public static final Optional m2112getAccountInfo$lambda4(XRPService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return m.c(it, "null") ? new Optional(null) : new Optional(this$0.decodeJson(AccountInfo.class, it));
    }

    /* renamed from: getBalance_SLwFa_Y$lambda-5 */
    public static final Optional m2113getBalance_SLwFa_Y$lambda5(XRPService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return m.c(it, "null") ? new Optional(null) : new Optional(this$0.decodeJson(BigInteger.class, it));
    }

    /* renamed from: getLedgerVersion$lambda-3 */
    public static final UInt m2114getLedgerVersion$lambda3(XRPService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return (UInt) this$0.decodeJson(UInt.class, it);
    }

    private static /* synthetic */ void getMoshi$annotations() {
    }

    /* renamed from: getReserveBase$lambda-2 */
    public static final BigInteger m2115getReserveBase$lambda2(XRPService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return (BigInteger) this$0.decodeJson(BigInteger.class, it);
    }

    /* renamed from: getTransactionResult_JaBXUxU$lambda-9 */
    public static final TransactionResult m2116getTransactionResult_JaBXUxU$lambda9(XRPService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return (TransactionResult) this$0.decodeJson(TransactionResult.class, it);
    }

    /* renamed from: getTransactions$lambda-10 */
    public static final List m2117getTransactions$lambda10(XRPService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, Transaction.class);
        m.f(newParameterizedType, "newParameterizedType(List::class.java, Transaction::class.java)");
        return (List) this$0.decodeJson(newParameterizedType, it);
    }

    public static /* synthetic */ BigInteger h(XRPService xRPService, String str) {
        return m2111estimateFee$lambda6(xRPService, str);
    }

    public static /* synthetic */ UInt i(XRPService xRPService, String str) {
        return m2114getLedgerVersion$lambda3(xRPService, str);
    }

    /* renamed from: isAddressValid$lambda-1 */
    public static final Boolean m2118isAddressValid$lambda1(XRPService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return (Boolean) this$0.decodeJson(Boolean.class, it);
    }

    public static /* synthetic */ TransactionResult j(XRPService xRPService, String str) {
        return m2116getTransactionResult_JaBXUxU$lambda9(xRPService, str);
    }

    public static /* synthetic */ Optional k(XRPService xRPService, String str) {
        return m2112getAccountInfo$lambda4(xRPService, str);
    }

    /* renamed from: signTransaction_gXGYdlU$lambda-7 */
    public static final SignedTransaction m2119signTransaction_gXGYdlU$lambda7(XRPService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return (SignedTransaction) this$0.decodeJson(SignedTransaction.class, it);
    }

    /* renamed from: submitSignedTransaction$lambda-8 */
    public static final x m2120submitSignedTransaction$lambda8(String it) {
        m.g(it, "it");
        return x.a;
    }

    public b0<String> deriveAddressFromPublicKey(byte[] publicKey) {
        Map<String, ? extends Object> e2;
        m.g(publicKey, "publicKey");
        e2 = l0.e(u.a("publicKey", Base64.encodeToString(publicKey, 2)));
        b0 map = call("deriveAddressFromPublicKey", e2).map(new n() { // from class: com.coinbase.walletengine.services.xrp.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPService.c(XRPService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"deriveAddressFromPublicKey\",\n                mapOf(\n                        \"publicKey\" to Base64.encodeToString(publicKey, Base64.NO_WRAP)\n                )\n        )\n                .map { decodeJson<String>(String::class.java, it) }");
        return map;
    }

    public b0<BigInteger> estimateFee(boolean z) {
        Map<String, ? extends Object> e2;
        e2 = l0.e(u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("estimateFee", e2).map(new n() { // from class: com.coinbase.walletengine.services.xrp.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPService.h(XRPService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"estimateFee\",\n                mapOf(\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<BigInteger>(BigInteger::class.java, it) }");
        return map;
    }

    public b0<Optional<AccountInfo>> getAccountInfo(String address, boolean z) {
        Map<String, ? extends Object> l2;
        m.g(address, "address");
        l2 = m0.l(u.a("address", address), u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("getAccountInfo", l2).map(new n() { // from class: com.coinbase.walletengine.services.xrp.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPService.k(XRPService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"getAccountInfo\",\n                mapOf(\n                        \"address\" to address,\n                        \"testnet\" to testnet\n                )\n        )\n                .map { if (it == \"null\") { Optional<AccountInfo>(null) } else { Optional<AccountInfo>(decodeJson<AccountInfo?>(AccountInfo::class.java, it)) } }");
        return map;
    }

    /* renamed from: getBalance-SLwFa_Y */
    public b0<Optional<BigInteger>> m2121getBalanceSLwFa_Y(String address, UInt uInt, boolean z) {
        Map<String, ? extends Object> l2;
        m.g(address, "address");
        l2 = m0.l(u.a("address", address), u.a("atLedgerVersion", uInt), u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("getBalance", l2).map(new n() { // from class: com.coinbase.walletengine.services.xrp.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPService.b(XRPService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"getBalance\",\n                mapOf(\n                        \"address\" to address,\n                        \"atLedgerVersion\" to atLedgerVersion,\n                        \"testnet\" to testnet\n                )\n        )\n                .map { if (it == \"null\") { Optional<BigInteger>(null) } else { Optional<BigInteger>(decodeJson<BigInteger?>(BigInteger::class.java, it)) } }");
        return map;
    }

    public b0<UInt> getLedgerVersion(boolean z) {
        Map<String, ? extends Object> e2;
        e2 = l0.e(u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("getLedgerVersion", e2).map(new n() { // from class: com.coinbase.walletengine.services.xrp.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPService.i(XRPService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"getLedgerVersion\",\n                mapOf(\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<UInt>(UInt::class.javaObjectType, it) }");
        return map;
    }

    public b0<BigInteger> getReserveBase(boolean z) {
        Map<String, ? extends Object> e2;
        e2 = l0.e(u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("getReserveBase", e2).map(new n() { // from class: com.coinbase.walletengine.services.xrp.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPService.f(XRPService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"getReserveBase\",\n                mapOf(\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<BigInteger>(BigInteger::class.java, it) }");
        return map;
    }

    /* renamed from: getTransactionResult-JaBXUxU */
    public b0<TransactionResult> m2122getTransactionResultJaBXUxU(String txHash, int i2, UInt uInt, boolean z) {
        Map<String, ? extends Object> l2;
        m.g(txHash, "txHash");
        l2 = m0.l(u.a("txHash", txHash), u.a("maxLedgerVersion", UInt.h(i2)), u.a("atLedgerVersion", uInt), u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("getTransactionResult", l2).map(new n() { // from class: com.coinbase.walletengine.services.xrp.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPService.j(XRPService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"getTransactionResult\",\n                mapOf(\n                        \"txHash\" to txHash,\n                        \"maxLedgerVersion\" to maxLedgerVersion,\n                        \"atLedgerVersion\" to atLedgerVersion,\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<TransactionResult>(TransactionResult::class.java, it) }");
        return map;
    }

    public b0<List<Transaction>> getTransactions(String address, boolean z) {
        Map<String, ? extends Object> l2;
        m.g(address, "address");
        l2 = m0.l(u.a("address", address), u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("getTransactions", l2).map(new n() { // from class: com.coinbase.walletengine.services.xrp.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPService.g(XRPService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"getTransactions\",\n                mapOf(\n                        \"address\" to address,\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<List<Transaction>>(Types.newParameterizedType(List::class.java, Transaction::class.java), it) }");
        return map;
    }

    public b0<Boolean> isAddressValid(String address) {
        Map<String, ? extends Object> e2;
        m.g(address, "address");
        e2 = l0.e(u.a("address", address));
        b0 map = call("isAddressValid", e2).map(new n() { // from class: com.coinbase.walletengine.services.xrp.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPService.d(XRPService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"isAddressValid\",\n                mapOf(\n                        \"address\" to address\n                )\n        )\n                .map { decodeJson<Boolean>(Boolean::class.javaObjectType, it) }");
        return map;
    }

    /* renamed from: signTransaction-gXGYdlU */
    public b0<SignedTransaction> m2123signTransactiongXGYdlU(String fromAddress, String toAddress, BigInteger amount, BigInteger fee, int i2, UInt uInt, UInt uInt2, String str, byte[] privateKey, byte[] publicKey, boolean z) {
        Map<String, ? extends Object> l2;
        m.g(fromAddress, "fromAddress");
        m.g(toAddress, "toAddress");
        m.g(amount, "amount");
        m.g(fee, "fee");
        m.g(privateKey, "privateKey");
        m.g(publicKey, "publicKey");
        l2 = m0.l(u.a("fromAddress", fromAddress), u.a("toAddress", toAddress), u.a("amount", amount.toString()), u.a(ApiConstants.FEE, fee.toString()), u.a("maxLedgerVersionOffset", UInt.h(i2)), u.a("sourceTag", uInt), u.a("destinationTag", uInt2), u.a("invoiceId", str), u.a("privateKey", Base64.encodeToString(privateKey, 2)), u.a("publicKey", Base64.encodeToString(publicKey, 2)), u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("signTransaction", l2).map(new n() { // from class: com.coinbase.walletengine.services.xrp.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPService.a(XRPService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"signTransaction\",\n                mapOf(\n                        \"fromAddress\" to fromAddress,\n                        \"toAddress\" to toAddress,\n                        \"amount\" to amount.toString(),\n                        \"fee\" to fee.toString(),\n                        \"maxLedgerVersionOffset\" to maxLedgerVersionOffset,\n                        \"sourceTag\" to sourceTag,\n                        \"destinationTag\" to destinationTag,\n                        \"invoiceId\" to invoiceId,\n                        \"privateKey\" to Base64.encodeToString(privateKey, Base64.NO_WRAP),\n                        \"publicKey\" to Base64.encodeToString(publicKey, Base64.NO_WRAP),\n                        \"testnet\" to testnet\n                )\n        )\n                .map { decodeJson<SignedTransaction>(SignedTransaction::class.java, it) }");
        return map;
    }

    public b0<x> submitSignedTransaction(byte[] signedTxData, boolean z) {
        Map<String, ? extends Object> l2;
        m.g(signedTxData, "signedTxData");
        l2 = m0.l(u.a("signedTxData", Base64.encodeToString(signedTxData, 2)), u.a("testnet", Boolean.valueOf(z)));
        b0 map = call("submitSignedTransaction", l2).map(new n() { // from class: com.coinbase.walletengine.services.xrp.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPService.e((String) obj);
            }
        });
        m.f(map, "call(\n                \"submitSignedTransaction\",\n                mapOf(\n                        \"signedTxData\" to Base64.encodeToString(signedTxData, Base64.NO_WRAP),\n                        \"testnet\" to testnet\n                )\n        )\n                .map { Unit }");
        return map;
    }
}