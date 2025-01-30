package com.coinbase.wallet.swap.apis;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.ciphercore.String_CipherCoreKt;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.core.util.AssertionException;
import com.coinbase.wallet.core.util.JSON;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.http.CallEnqueueSingle;
import com.coinbase.wallet.http.HTTP;
import com.coinbase.wallet.http.exceptions.HTTPException;
import com.coinbase.wallet.http.models.HTTPResponse;
import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.swap.dtos.SwapAPIErrorDTO;
import com.coinbase.wallet.swap.dtos.SwapAssetsDTO;
import com.coinbase.wallet.swap.dtos.SwapEstimateGasLimitDTO;
import com.coinbase.wallet.swap.dtos.SwapEstimateMinerFeeDTO;
import com.coinbase.wallet.swap.dtos.SwapQuoteDTO;
import com.coinbase.wallet.swap.dtos.SwapTxDTO;
import com.coinbase.wallet.swap.dtos.SwapTxResultDTO;
import com.coinbase.wallet.swap.models.AmountBase;
import com.coinbase.wallet.swap.models.SwapAsset;
import com.coinbase.wallet.swap.models.SwapAssetInfo;
import com.coinbase.wallet.swap.models.SwapAssetJsonAdapter;
import com.coinbase.wallet.swap.models.SwapMinerFeeException;
import com.coinbase.wallet.swap.models.SwapQuote;
import com.coinbase.wallet.swap.models.SwapQuoteException;
import com.coinbase.wallet.swap.models.SwapTrade;
import h.c.b0;
import h.c.m0.n;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.u;

/* compiled from: SwapAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b#\u0010$JE\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J;\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015JC\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010\u001eR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/coinbase/wallet/swap/apis/SwapAPI;", "", "Lcom/coinbase/wallet/swap/models/SwapAsset;", Payload.SOURCE, "target", "Ljava/math/BigInteger;", "amount", "", "mode", "Lcom/coinbase/wallet/swap/models/AmountBase;", "amountBase", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lh/c/b0;", "Lcom/coinbase/wallet/swap/models/SwapQuote;", "getQuote", "(Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;Ljava/math/BigInteger;Ljava/lang/String;Lcom/coinbase/wallet/swap/models/AmountBase;I)Lh/c/b0;", "Lcom/coinbase/wallet/swap/models/SwapAssetInfo;", "getAssets", "(I)Lh/c/b0;", "getFastQuote", "(Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;Ljava/math/BigInteger;Lcom/coinbase/wallet/swap/models/AmountBase;I)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "address", "Lcom/coinbase/wallet/swap/models/SwapTrade;", "getTrade", "(Lcom/coinbase/wallet/blockchains/models/WalletAddress;Lcom/coinbase/wallet/swap/models/SwapAsset;Lcom/coinbase/wallet/swap/models/SwapAsset;Ljava/math/BigInteger;Lcom/coinbase/wallet/swap/models/AmountBase;I)Lh/c/b0;", "", "signedTxHashes", "getEstimatedMinerFee", "(Ljava/util/List;I)Lh/c/b0;", "estimatedGasConsumed", "Lcom/coinbase/wallet/http/models/HTTPService;", "swapHTTPService", "Lcom/coinbase/wallet/http/models/HTTPService;", "<init>", "(Lcom/coinbase/wallet/http/models/HTTPService;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapAPI {
    private final HTTPService swapHTTPService;

    public SwapAPI(HTTPService swapHTTPService) {
        m.g(swapHTTPService, "swapHTTPService");
        this.swapHTTPService = swapHTTPService;
        JSON.INSTANCE.add(SwapAsset.class, new SwapAssetJsonAdapter());
    }

    public static /* synthetic */ HTTPResponse a(Throwable th) {
        return m1720estimatedGasConsumed$lambda4(th);
    }

    public static /* synthetic */ BigInteger b(HTTPResponse hTTPResponse) {
        return m1721estimatedGasConsumed$lambda5(hTTPResponse);
    }

    public static /* synthetic */ BigInteger c(HTTPResponse hTTPResponse) {
        return m1724getEstimatedMinerFee$lambda3(hTTPResponse);
    }

    public static /* synthetic */ HTTPResponse d(Throwable th) {
        return m1725getQuote$lambda6(th);
    }

    public static /* synthetic */ SwapAssetInfo e(HTTPResponse hTTPResponse) {
        return m1722getAssets$lambda0(hTTPResponse);
    }

    /* renamed from: estimatedGasConsumed$lambda-4 */
    public static final HTTPResponse m1720estimatedGasConsumed$lambda4(Throwable error) {
        m.g(error, "error");
        HTTPException.RequestFailed requestFailed = error instanceof HTTPException.RequestFailed ? (HTTPException.RequestFailed) error : null;
        String body = requestFailed != null ? requestFailed.getBody() : null;
        if (body != null) {
            JSON json = JSON.INSTANCE;
            ReentrantReadWriteLock.ReadLock readLock = json.getMultiReadSingleWriteLock().readLock();
            readLock.lock();
            try {
                if (!(e0.b(SwapAPIErrorDTO.class).getTypeParameters().isEmpty() ^ true ? false : true)) {
                    l.a.a.e(new AssertionException("Since " + ((Object) e0.b(SwapAPIErrorDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
                }
                Object fromJson = json.getMoshi().adapter(SwapAPIErrorDTO.class).fromJson(body);
                readLock.unlock();
                SwapAPIErrorDTO swapAPIErrorDTO = (SwapAPIErrorDTO) fromJson;
                if (swapAPIErrorDTO != null) {
                    if (m.c(swapAPIErrorDTO.getError().getMessage(), "ErrNotEnoughFunds")) {
                        throw SwapMinerFeeException.NotEnoughFunds.INSTANCE;
                    }
                    throw error;
                }
                throw error;
            } catch (Throwable th) {
                readLock.unlock();
                throw th;
            }
        }
        throw error;
    }

    /* renamed from: estimatedGasConsumed$lambda-5 */
    public static final BigInteger m1721estimatedGasConsumed$lambda5(HTTPResponse response) {
        int a;
        m.g(response, "response");
        String strip0x = String_CipherCoreKt.strip0x(((SwapEstimateGasLimitDTO) response.getBody()).getResult().getEstimatedGasLimit());
        a = kotlin.l0.b.a(16);
        return new BigInteger(strip0x, a);
    }

    public static /* synthetic */ HTTPResponse f(Throwable th) {
        return m1723getEstimatedMinerFee$lambda2(th);
    }

    public static /* synthetic */ SwapTrade g(int i2, HTTPResponse hTTPResponse) {
        return m1727getTrade$lambda1(i2, hTTPResponse);
    }

    /* renamed from: getAssets$lambda-0 */
    public static final SwapAssetInfo m1722getAssets$lambda0(HTTPResponse it) {
        m.g(it, "it");
        return ((SwapAssetsDTO) it.getBody()).getResult$swap_release();
    }

    /* renamed from: getEstimatedMinerFee$lambda-2 */
    public static final HTTPResponse m1723getEstimatedMinerFee$lambda2(Throwable error) {
        m.g(error, "error");
        HTTPException.RequestFailed requestFailed = error instanceof HTTPException.RequestFailed ? (HTTPException.RequestFailed) error : null;
        String body = requestFailed != null ? requestFailed.getBody() : null;
        if (body != null) {
            JSON json = JSON.INSTANCE;
            ReentrantReadWriteLock.ReadLock readLock = json.getMultiReadSingleWriteLock().readLock();
            readLock.lock();
            try {
                if (!(e0.b(SwapAPIErrorDTO.class).getTypeParameters().isEmpty() ^ true ? false : true)) {
                    l.a.a.e(new AssertionException("Since " + ((Object) e0.b(SwapAPIErrorDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
                }
                Object fromJson = json.getMoshi().adapter(SwapAPIErrorDTO.class).fromJson(body);
                readLock.unlock();
                SwapAPIErrorDTO swapAPIErrorDTO = (SwapAPIErrorDTO) fromJson;
                if (swapAPIErrorDTO != null) {
                    if (m.c(swapAPIErrorDTO.getError().getMessage(), "ErrNotEnoughFunds")) {
                        throw SwapMinerFeeException.NotEnoughFunds.INSTANCE;
                    }
                    throw error;
                }
                throw error;
            } catch (Throwable th) {
                readLock.unlock();
                throw th;
            }
        }
        throw error;
    }

    /* renamed from: getEstimatedMinerFee$lambda-3 */
    public static final BigInteger m1724getEstimatedMinerFee$lambda3(HTTPResponse response) {
        int a;
        m.g(response, "response");
        String strip0x = String_CipherCoreKt.strip0x(((SwapEstimateMinerFeeDTO) response.getBody()).getResult().getEstimatedMinerFee());
        a = kotlin.l0.b.a(16);
        return new BigInteger(strip0x, a);
    }

    private final b0<SwapQuote> getQuote(SwapAsset swapAsset, SwapAsset swapAsset2, BigInteger bigInteger, String str, AmountBase amountBase, int i2) {
        Map<String, String> l2;
        HTTP http = HTTP.INSTANCE;
        HTTPService hTTPService = this.swapHTTPService;
        o[] oVarArr = new o[6];
        ContractAddress contractAddress = swapAsset.getContractAddress();
        String rawValue = contractAddress == null ? null : contractAddress.getRawValue();
        if (rawValue == null) {
            rawValue = swapAsset.getCurrencyCode().getCode();
        }
        oVarArr[0] = u.a(ApiConstants.FROM, rawValue);
        ContractAddress contractAddress2 = swapAsset2.getContractAddress();
        String rawValue2 = contractAddress2 == null ? null : contractAddress2.getRawValue();
        if (rawValue2 == null) {
            rawValue2 = swapAsset2.getCurrencyCode().getCode();
        }
        oVarArr[1] = u.a(ApiConstants.TO, rawValue2);
        oVarArr[2] = u.a("amount", bigInteger.toString());
        oVarArr[3] = u.a("mode", str);
        oVarArr[4] = u.a("amountReference", amountBase.getDescription());
        oVarArr[5] = u.a(RouteActionKey.RouteActionKeys.CHAIN_ID, String.valueOf(i2));
        l2 = m0.l(oVarArr);
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(hTTPService, "/rpc/v1/swap/quote", l2, null)).map(new n() { // from class: com.coinbase.wallet.swap.apis.SwapAPI$getQuote$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.swap.dtos.SwapQuoteDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.swap.dtos.SwapQuoteDTO> r0 = com.coinbase.wallet.swap.dtos.SwapQuoteDTO.class
                    java.lang.String r1 = "it"
                    kotlin.jvm.internal.m.g(r9, r1)
                    com.squareup.moshi.JsonAdapter r1 = com.squareup.moshi.JsonAdapter.this
                    java.lang.Class<byte[]> r2 = byte[].class
                    boolean r2 = kotlin.jvm.internal.m.c(r0, r2)
                    r3 = 0
                    r4 = 0
                    if (r2 == 0) goto L26
                    okhttp3.ResponseBody r0 = r9.body()
                    if (r0 != 0) goto L1a
                    goto L1e
                L1a:
                    byte[] r4 = r0.bytes()
                L1e:
                    if (r4 != 0) goto L22
                    byte[] r4 = new byte[r3]
                L22:
                    com.coinbase.wallet.swap.dtos.SwapQuoteDTO r4 = (com.coinbase.wallet.swap.dtos.SwapQuoteDTO) r4
                    goto Lac
                L26:
                    boolean r2 = r9.isSuccessful()
                    if (r2 != 0) goto L3d
                    com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed r0 = new com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed
                    okhttp3.ResponseBody r9 = r9.body()
                    if (r9 != 0) goto L35
                    goto L39
                L35:
                    java.lang.String r4 = r9.string()
                L39:
                    r0.<init>(r4)
                    throw r0
                L3d:
                    okhttp3.ResponseBody r2 = r9.body()
                    if (r2 != 0) goto L44
                    goto L48
                L44:
                    java.lang.String r4 = r2.string()
                L48:
                    if (r4 == 0) goto Lf6
                    com.coinbase.wallet.core.util.JSON r2 = com.coinbase.wallet.core.util.JSON.INSTANCE
                    java.util.concurrent.locks.ReentrantReadWriteLock r5 = r2.getMultiReadSingleWriteLock()
                    java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r5 = r5.readLock()
                    r5.lock()
                    kotlin.j0.d r6 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.util.List r6 = r6.getTypeParameters()     // Catch: java.lang.Throwable -> Lf1
                    boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> Lf1
                    r7 = 1
                    r6 = r6 ^ r7
                    if (r6 == 0) goto L6b
                    if (r1 == 0) goto L6a
                    goto L6b
                L6a:
                    r7 = r3
                L6b:
                    if (r7 != 0) goto L93
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf1
                    r6.<init>()     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = "Since "
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    kotlin.j0.d r7 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = r7.getSimpleName()     // Catch: java.lang.Throwable -> Lf1
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = " is parameterized please pass an adapter to `parameterizedAdapter`"
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lf1
                    com.coinbase.wallet.core.util.AssertionException r7 = new com.coinbase.wallet.core.util.AssertionException     // Catch: java.lang.Throwable -> Lf1
                    r7.<init>(r6)     // Catch: java.lang.Throwable -> Lf1
                    l.a.a.e(r7)     // Catch: java.lang.Throwable -> Lf1
                L93:
                    if (r1 != 0) goto La2
                    com.squareup.moshi.Moshi r1 = r2.getMoshi()     // Catch: java.lang.Throwable -> Lf1
                    com.squareup.moshi.JsonAdapter r0 = r1.adapter(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.Object r0 = r0.fromJson(r4)     // Catch: java.lang.Throwable -> Lf1
                    goto La6
                La2:
                    java.lang.Object r0 = r1.fromJson(r4)     // Catch: java.lang.Throwable -> Lf1
                La6:
                    r4 = r0
                    r5.unlock()
                    if (r4 == 0) goto Lee
                Lac:
                    okhttp3.Headers r9 = r9.headers()
                    int r0 = r9.size()
                    kotlin.i0.c r0 = kotlin.i0.d.j(r3, r0)
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r2 = 10
                    int r2 = kotlin.a0.p.r(r0, r2)
                    r1.<init>(r2)
                    java.util.Iterator r0 = r0.iterator()
                Lc7:
                    boolean r2 = r0.hasNext()
                    if (r2 == 0) goto Le4
                    r2 = r0
                    kotlin.a0.h0 r2 = (kotlin.a0.h0) r2
                    int r2 = r2.c()
                    java.lang.String r3 = r9.name(r2)
                    java.lang.String r2 = r9.value(r2)
                    kotlin.o r2 = kotlin.u.a(r3, r2)
                    r1.add(r2)
                    goto Lc7
                Le4:
                    java.util.Map r9 = kotlin.a0.j0.r(r1)
                    com.coinbase.wallet.http.models.HTTPResponse r0 = new com.coinbase.wallet.http.models.HTTPResponse
                    r0.<init>(r4, r9)
                    return r0
                Lee:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                Lf1:
                    r9 = move-exception
                    r5.unlock()
                    throw r9
                Lf6:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.swap.apis.SwapAPI$getQuote$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0<SwapQuote> map = subscribeOn.onErrorReturn(new n() { // from class: com.coinbase.wallet.swap.apis.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAPI.d((Throwable) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.swap.apis.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAPI.h((HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n            .get<SwapQuoteDTO>(\n                service = swapHTTPService,\n                path = \"/rpc/v1/swap/quote\",\n                parameters = mapOf(\n                    \"from\" to (source.contractAddress?.rawValue ?: source.currencyCode.code),\n                    \"to\" to (target.contractAddress?.rawValue ?: target.currencyCode.code),\n                    \"amount\" to amount.toString(),\n                    \"mode\" to mode,\n                    \"amountReference\" to amountBase.description,\n                    \"chainId\" to chainId.toString()\n                )\n            )\n            .onErrorReturn { error ->\n                val swapError = (error as? HTTPException.RequestFailed)?.body ?: throw error\n                val apiException = JSON.fromJsonString<SwapAPIErrorDTO>(swapError) ?: throw error\n                throw if (apiException.error.code == \"errLowLiquidity\") SwapQuoteException.LowLiquidity else error\n            }\n            .map { response -> response.body.result.quote }");
        return map;
    }

    /* renamed from: getQuote$lambda-6 */
    public static final HTTPResponse m1725getQuote$lambda6(Throwable error) {
        m.g(error, "error");
        HTTPException.RequestFailed requestFailed = error instanceof HTTPException.RequestFailed ? (HTTPException.RequestFailed) error : null;
        String body = requestFailed != null ? requestFailed.getBody() : null;
        if (body != null) {
            JSON json = JSON.INSTANCE;
            ReentrantReadWriteLock.ReadLock readLock = json.getMultiReadSingleWriteLock().readLock();
            readLock.lock();
            try {
                if (!(e0.b(SwapAPIErrorDTO.class).getTypeParameters().isEmpty() ^ true ? false : true)) {
                    l.a.a.e(new AssertionException("Since " + ((Object) e0.b(SwapAPIErrorDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
                }
                Object fromJson = json.getMoshi().adapter(SwapAPIErrorDTO.class).fromJson(body);
                readLock.unlock();
                SwapAPIErrorDTO swapAPIErrorDTO = (SwapAPIErrorDTO) fromJson;
                if (swapAPIErrorDTO != null) {
                    if (m.c(swapAPIErrorDTO.getError().getCode(), "errLowLiquidity")) {
                        throw SwapQuoteException.LowLiquidity.INSTANCE;
                    }
                    throw error;
                }
                throw error;
            } catch (Throwable th) {
                readLock.unlock();
                throw th;
            }
        }
        throw error;
    }

    /* renamed from: getQuote$lambda-7 */
    public static final SwapQuote m1726getQuote$lambda7(HTTPResponse response) {
        m.g(response, "response");
        return ((SwapQuoteDTO) response.getBody()).getResult$swap_release().getQuote$swap_release();
    }

    /* renamed from: getTrade$lambda-1 */
    public static final SwapTrade m1727getTrade$lambda1(int i2, HTTPResponse response) {
        m.g(response, "response");
        SwapTxResultDTO result$swap_release = ((SwapTxDTO) response.getBody()).getResult$swap_release();
        return new SwapTrade(result$swap_release.getApproveTx$swap_release(), result$swap_release.getTx$swap_release(), result$swap_release.getQuote$swap_release(), result$swap_release.getFee$swap_release(), i2);
    }

    public static /* synthetic */ SwapQuote h(HTTPResponse hTTPResponse) {
        return m1726getQuote$lambda7(hTTPResponse);
    }

    public final b0<BigInteger> estimatedGasConsumed(List<String> signedTxHashes, int i2) {
        Map<String, ? extends Object> l2;
        m.g(signedTxHashes, "signedTxHashes");
        HTTP http = HTTP.INSTANCE;
        HTTPService hTTPService = this.swapHTTPService;
        l2 = m0.l(u.a("txHashes", signedTxHashes), u.a(RouteActionKey.RouteActionKeys.CHAIN_ID, Integer.valueOf(i2)));
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildPostRequest(hTTPService, "/rpc/v1/swap/estimateGasUsed", l2, null)).map(new n() { // from class: com.coinbase.wallet.swap.apis.SwapAPI$estimatedGasConsumed$$inlined$post$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.swap.dtos.SwapEstimateGasLimitDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.swap.dtos.SwapEstimateGasLimitDTO> r0 = com.coinbase.wallet.swap.dtos.SwapEstimateGasLimitDTO.class
                    java.lang.String r1 = "it"
                    kotlin.jvm.internal.m.g(r9, r1)
                    com.squareup.moshi.JsonAdapter r1 = com.squareup.moshi.JsonAdapter.this
                    java.lang.Class<byte[]> r2 = byte[].class
                    boolean r2 = kotlin.jvm.internal.m.c(r0, r2)
                    r3 = 0
                    r4 = 0
                    if (r2 == 0) goto L26
                    okhttp3.ResponseBody r0 = r9.body()
                    if (r0 != 0) goto L1a
                    goto L1e
                L1a:
                    byte[] r4 = r0.bytes()
                L1e:
                    if (r4 != 0) goto L22
                    byte[] r4 = new byte[r3]
                L22:
                    com.coinbase.wallet.swap.dtos.SwapEstimateGasLimitDTO r4 = (com.coinbase.wallet.swap.dtos.SwapEstimateGasLimitDTO) r4
                    goto Lac
                L26:
                    boolean r2 = r9.isSuccessful()
                    if (r2 != 0) goto L3d
                    com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed r0 = new com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed
                    okhttp3.ResponseBody r9 = r9.body()
                    if (r9 != 0) goto L35
                    goto L39
                L35:
                    java.lang.String r4 = r9.string()
                L39:
                    r0.<init>(r4)
                    throw r0
                L3d:
                    okhttp3.ResponseBody r2 = r9.body()
                    if (r2 != 0) goto L44
                    goto L48
                L44:
                    java.lang.String r4 = r2.string()
                L48:
                    if (r4 == 0) goto Lf6
                    com.coinbase.wallet.core.util.JSON r2 = com.coinbase.wallet.core.util.JSON.INSTANCE
                    java.util.concurrent.locks.ReentrantReadWriteLock r5 = r2.getMultiReadSingleWriteLock()
                    java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r5 = r5.readLock()
                    r5.lock()
                    kotlin.j0.d r6 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.util.List r6 = r6.getTypeParameters()     // Catch: java.lang.Throwable -> Lf1
                    boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> Lf1
                    r7 = 1
                    r6 = r6 ^ r7
                    if (r6 == 0) goto L6b
                    if (r1 == 0) goto L6a
                    goto L6b
                L6a:
                    r7 = r3
                L6b:
                    if (r7 != 0) goto L93
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf1
                    r6.<init>()     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = "Since "
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    kotlin.j0.d r7 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = r7.getSimpleName()     // Catch: java.lang.Throwable -> Lf1
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = " is parameterized please pass an adapter to `parameterizedAdapter`"
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lf1
                    com.coinbase.wallet.core.util.AssertionException r7 = new com.coinbase.wallet.core.util.AssertionException     // Catch: java.lang.Throwable -> Lf1
                    r7.<init>(r6)     // Catch: java.lang.Throwable -> Lf1
                    l.a.a.e(r7)     // Catch: java.lang.Throwable -> Lf1
                L93:
                    if (r1 != 0) goto La2
                    com.squareup.moshi.Moshi r1 = r2.getMoshi()     // Catch: java.lang.Throwable -> Lf1
                    com.squareup.moshi.JsonAdapter r0 = r1.adapter(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.Object r0 = r0.fromJson(r4)     // Catch: java.lang.Throwable -> Lf1
                    goto La6
                La2:
                    java.lang.Object r0 = r1.fromJson(r4)     // Catch: java.lang.Throwable -> Lf1
                La6:
                    r4 = r0
                    r5.unlock()
                    if (r4 == 0) goto Lee
                Lac:
                    okhttp3.Headers r9 = r9.headers()
                    int r0 = r9.size()
                    kotlin.i0.c r0 = kotlin.i0.d.j(r3, r0)
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r2 = 10
                    int r2 = kotlin.a0.p.r(r0, r2)
                    r1.<init>(r2)
                    java.util.Iterator r0 = r0.iterator()
                Lc7:
                    boolean r2 = r0.hasNext()
                    if (r2 == 0) goto Le4
                    r2 = r0
                    kotlin.a0.h0 r2 = (kotlin.a0.h0) r2
                    int r2 = r2.c()
                    java.lang.String r3 = r9.name(r2)
                    java.lang.String r2 = r9.value(r2)
                    kotlin.o r2 = kotlin.u.a(r3, r2)
                    r1.add(r2)
                    goto Lc7
                Le4:
                    java.util.Map r9 = kotlin.a0.j0.r(r1)
                    com.coinbase.wallet.http.models.HTTPResponse r0 = new com.coinbase.wallet.http.models.HTTPResponse
                    r0.<init>(r4, r9)
                    return r0
                Lee:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                Lf1:
                    r9 = move-exception
                    r5.unlock()
                    throw r9
                Lf6:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.swap.apis.SwapAPI$estimatedGasConsumed$$inlined$post$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildPostRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0<BigInteger> map = subscribeOn.onErrorReturn(new n() { // from class: com.coinbase.wallet.swap.apis.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAPI.a((Throwable) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.swap.apis.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAPI.b((HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n            .post<SwapEstimateGasLimitDTO>(\n                service = swapHTTPService,\n                path = \"/rpc/v1/swap/estimateGasUsed\",\n                parameters = mapOf(\n                    \"txHashes\" to signedTxHashes,\n                    \"chainId\" to chainId\n                )\n            )\n            .onErrorReturn { error ->\n                val swapError = (error as? HTTPException.RequestFailed)?.body ?: throw error\n                val apiException = JSON.fromJsonString<SwapAPIErrorDTO>(swapError) ?: throw error\n\n                throw if (apiException.error.message == \"ErrNotEnoughFunds\") {\n                    SwapMinerFeeException.NotEnoughFunds\n                } else {\n                    error\n                }\n            }\n            .map { response ->\n                response.body.result.estimatedGasLimit.strip0x().toBigInteger(16)\n            }");
        return map;
    }

    public final b0<SwapAssetInfo> getAssets(int i2) {
        Map<String, String> e2;
        HTTP http = HTTP.INSTANCE;
        HTTPService hTTPService = this.swapHTTPService;
        e2 = l0.e(u.a(RouteActionKey.RouteActionKeys.CHAIN_ID, String.valueOf(i2)));
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(hTTPService, "/rpc/v1/swap/assets", e2, null)).map(new n() { // from class: com.coinbase.wallet.swap.apis.SwapAPI$getAssets$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.swap.dtos.SwapAssetsDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.swap.dtos.SwapAssetsDTO> r0 = com.coinbase.wallet.swap.dtos.SwapAssetsDTO.class
                    java.lang.String r1 = "it"
                    kotlin.jvm.internal.m.g(r9, r1)
                    com.squareup.moshi.JsonAdapter r1 = com.squareup.moshi.JsonAdapter.this
                    java.lang.Class<byte[]> r2 = byte[].class
                    boolean r2 = kotlin.jvm.internal.m.c(r0, r2)
                    r3 = 0
                    r4 = 0
                    if (r2 == 0) goto L26
                    okhttp3.ResponseBody r0 = r9.body()
                    if (r0 != 0) goto L1a
                    goto L1e
                L1a:
                    byte[] r4 = r0.bytes()
                L1e:
                    if (r4 != 0) goto L22
                    byte[] r4 = new byte[r3]
                L22:
                    com.coinbase.wallet.swap.dtos.SwapAssetsDTO r4 = (com.coinbase.wallet.swap.dtos.SwapAssetsDTO) r4
                    goto Lac
                L26:
                    boolean r2 = r9.isSuccessful()
                    if (r2 != 0) goto L3d
                    com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed r0 = new com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed
                    okhttp3.ResponseBody r9 = r9.body()
                    if (r9 != 0) goto L35
                    goto L39
                L35:
                    java.lang.String r4 = r9.string()
                L39:
                    r0.<init>(r4)
                    throw r0
                L3d:
                    okhttp3.ResponseBody r2 = r9.body()
                    if (r2 != 0) goto L44
                    goto L48
                L44:
                    java.lang.String r4 = r2.string()
                L48:
                    if (r4 == 0) goto Lf6
                    com.coinbase.wallet.core.util.JSON r2 = com.coinbase.wallet.core.util.JSON.INSTANCE
                    java.util.concurrent.locks.ReentrantReadWriteLock r5 = r2.getMultiReadSingleWriteLock()
                    java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r5 = r5.readLock()
                    r5.lock()
                    kotlin.j0.d r6 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.util.List r6 = r6.getTypeParameters()     // Catch: java.lang.Throwable -> Lf1
                    boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> Lf1
                    r7 = 1
                    r6 = r6 ^ r7
                    if (r6 == 0) goto L6b
                    if (r1 == 0) goto L6a
                    goto L6b
                L6a:
                    r7 = r3
                L6b:
                    if (r7 != 0) goto L93
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf1
                    r6.<init>()     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = "Since "
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    kotlin.j0.d r7 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = r7.getSimpleName()     // Catch: java.lang.Throwable -> Lf1
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = " is parameterized please pass an adapter to `parameterizedAdapter`"
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lf1
                    com.coinbase.wallet.core.util.AssertionException r7 = new com.coinbase.wallet.core.util.AssertionException     // Catch: java.lang.Throwable -> Lf1
                    r7.<init>(r6)     // Catch: java.lang.Throwable -> Lf1
                    l.a.a.e(r7)     // Catch: java.lang.Throwable -> Lf1
                L93:
                    if (r1 != 0) goto La2
                    com.squareup.moshi.Moshi r1 = r2.getMoshi()     // Catch: java.lang.Throwable -> Lf1
                    com.squareup.moshi.JsonAdapter r0 = r1.adapter(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.Object r0 = r0.fromJson(r4)     // Catch: java.lang.Throwable -> Lf1
                    goto La6
                La2:
                    java.lang.Object r0 = r1.fromJson(r4)     // Catch: java.lang.Throwable -> Lf1
                La6:
                    r4 = r0
                    r5.unlock()
                    if (r4 == 0) goto Lee
                Lac:
                    okhttp3.Headers r9 = r9.headers()
                    int r0 = r9.size()
                    kotlin.i0.c r0 = kotlin.i0.d.j(r3, r0)
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r2 = 10
                    int r2 = kotlin.a0.p.r(r0, r2)
                    r1.<init>(r2)
                    java.util.Iterator r0 = r0.iterator()
                Lc7:
                    boolean r2 = r0.hasNext()
                    if (r2 == 0) goto Le4
                    r2 = r0
                    kotlin.a0.h0 r2 = (kotlin.a0.h0) r2
                    int r2 = r2.c()
                    java.lang.String r3 = r9.name(r2)
                    java.lang.String r2 = r9.value(r2)
                    kotlin.o r2 = kotlin.u.a(r3, r2)
                    r1.add(r2)
                    goto Lc7
                Le4:
                    java.util.Map r9 = kotlin.a0.j0.r(r1)
                    com.coinbase.wallet.http.models.HTTPResponse r0 = new com.coinbase.wallet.http.models.HTTPResponse
                    r0.<init>(r4, r9)
                    return r0
                Lee:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                Lf1:
                    r9 = move-exception
                    r5.unlock()
                    throw r9
                Lf6:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.swap.apis.SwapAPI$getAssets$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0<SwapAssetInfo> map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.swap.apis.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAPI.e((HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n            .get<SwapAssetsDTO>(\n                service = swapHTTPService,\n                path = \"/rpc/v1/swap/assets\",\n                parameters = mapOf(\n                    \"chainId\" to chainId.toString()\n                )\n            )\n            .map { it.body.result }");
        return map;
    }

    public final b0<BigInteger> getEstimatedMinerFee(List<String> signedTxHashes, int i2) {
        Map<String, ? extends Object> l2;
        m.g(signedTxHashes, "signedTxHashes");
        HTTP http = HTTP.INSTANCE;
        HTTPService hTTPService = this.swapHTTPService;
        l2 = m0.l(u.a("txHashes", signedTxHashes), u.a(RouteActionKey.RouteActionKeys.CHAIN_ID, Integer.valueOf(i2)));
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildPostRequest(hTTPService, "/rpc/v1/swap/estimateMinerFee", l2, null)).map(new n() { // from class: com.coinbase.wallet.swap.apis.SwapAPI$getEstimatedMinerFee$$inlined$post$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.swap.dtos.SwapEstimateMinerFeeDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.swap.dtos.SwapEstimateMinerFeeDTO> r0 = com.coinbase.wallet.swap.dtos.SwapEstimateMinerFeeDTO.class
                    java.lang.String r1 = "it"
                    kotlin.jvm.internal.m.g(r9, r1)
                    com.squareup.moshi.JsonAdapter r1 = com.squareup.moshi.JsonAdapter.this
                    java.lang.Class<byte[]> r2 = byte[].class
                    boolean r2 = kotlin.jvm.internal.m.c(r0, r2)
                    r3 = 0
                    r4 = 0
                    if (r2 == 0) goto L26
                    okhttp3.ResponseBody r0 = r9.body()
                    if (r0 != 0) goto L1a
                    goto L1e
                L1a:
                    byte[] r4 = r0.bytes()
                L1e:
                    if (r4 != 0) goto L22
                    byte[] r4 = new byte[r3]
                L22:
                    com.coinbase.wallet.swap.dtos.SwapEstimateMinerFeeDTO r4 = (com.coinbase.wallet.swap.dtos.SwapEstimateMinerFeeDTO) r4
                    goto Lac
                L26:
                    boolean r2 = r9.isSuccessful()
                    if (r2 != 0) goto L3d
                    com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed r0 = new com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed
                    okhttp3.ResponseBody r9 = r9.body()
                    if (r9 != 0) goto L35
                    goto L39
                L35:
                    java.lang.String r4 = r9.string()
                L39:
                    r0.<init>(r4)
                    throw r0
                L3d:
                    okhttp3.ResponseBody r2 = r9.body()
                    if (r2 != 0) goto L44
                    goto L48
                L44:
                    java.lang.String r4 = r2.string()
                L48:
                    if (r4 == 0) goto Lf6
                    com.coinbase.wallet.core.util.JSON r2 = com.coinbase.wallet.core.util.JSON.INSTANCE
                    java.util.concurrent.locks.ReentrantReadWriteLock r5 = r2.getMultiReadSingleWriteLock()
                    java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r5 = r5.readLock()
                    r5.lock()
                    kotlin.j0.d r6 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.util.List r6 = r6.getTypeParameters()     // Catch: java.lang.Throwable -> Lf1
                    boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> Lf1
                    r7 = 1
                    r6 = r6 ^ r7
                    if (r6 == 0) goto L6b
                    if (r1 == 0) goto L6a
                    goto L6b
                L6a:
                    r7 = r3
                L6b:
                    if (r7 != 0) goto L93
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf1
                    r6.<init>()     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = "Since "
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    kotlin.j0.d r7 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = r7.getSimpleName()     // Catch: java.lang.Throwable -> Lf1
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = " is parameterized please pass an adapter to `parameterizedAdapter`"
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lf1
                    com.coinbase.wallet.core.util.AssertionException r7 = new com.coinbase.wallet.core.util.AssertionException     // Catch: java.lang.Throwable -> Lf1
                    r7.<init>(r6)     // Catch: java.lang.Throwable -> Lf1
                    l.a.a.e(r7)     // Catch: java.lang.Throwable -> Lf1
                L93:
                    if (r1 != 0) goto La2
                    com.squareup.moshi.Moshi r1 = r2.getMoshi()     // Catch: java.lang.Throwable -> Lf1
                    com.squareup.moshi.JsonAdapter r0 = r1.adapter(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.Object r0 = r0.fromJson(r4)     // Catch: java.lang.Throwable -> Lf1
                    goto La6
                La2:
                    java.lang.Object r0 = r1.fromJson(r4)     // Catch: java.lang.Throwable -> Lf1
                La6:
                    r4 = r0
                    r5.unlock()
                    if (r4 == 0) goto Lee
                Lac:
                    okhttp3.Headers r9 = r9.headers()
                    int r0 = r9.size()
                    kotlin.i0.c r0 = kotlin.i0.d.j(r3, r0)
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r2 = 10
                    int r2 = kotlin.a0.p.r(r0, r2)
                    r1.<init>(r2)
                    java.util.Iterator r0 = r0.iterator()
                Lc7:
                    boolean r2 = r0.hasNext()
                    if (r2 == 0) goto Le4
                    r2 = r0
                    kotlin.a0.h0 r2 = (kotlin.a0.h0) r2
                    int r2 = r2.c()
                    java.lang.String r3 = r9.name(r2)
                    java.lang.String r2 = r9.value(r2)
                    kotlin.o r2 = kotlin.u.a(r3, r2)
                    r1.add(r2)
                    goto Lc7
                Le4:
                    java.util.Map r9 = kotlin.a0.j0.r(r1)
                    com.coinbase.wallet.http.models.HTTPResponse r0 = new com.coinbase.wallet.http.models.HTTPResponse
                    r0.<init>(r4, r9)
                    return r0
                Lee:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                Lf1:
                    r9 = move-exception
                    r5.unlock()
                    throw r9
                Lf6:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.swap.apis.SwapAPI$getEstimatedMinerFee$$inlined$post$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildPostRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0<BigInteger> map = subscribeOn.onErrorReturn(new n() { // from class: com.coinbase.wallet.swap.apis.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAPI.f((Throwable) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.swap.apis.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAPI.c((HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n            .post<SwapEstimateMinerFeeDTO>(\n                service = swapHTTPService,\n                path = \"/rpc/v1/swap/estimateMinerFee\",\n                parameters = mapOf(\n                    \"txHashes\" to signedTxHashes,\n                    \"chainId\" to chainId\n                )\n            )\n            .onErrorReturn { error ->\n                val swapError = (error as? HTTPException.RequestFailed)?.body ?: throw error\n                val apiException = JSON.fromJsonString<SwapAPIErrorDTO>(swapError) ?: throw error\n\n                throw if (apiException.error.message == \"ErrNotEnoughFunds\") {\n                    SwapMinerFeeException.NotEnoughFunds\n                } else {\n                    error\n                }\n            }\n            .map { response ->\n                response.body.result.estimatedMinerFee.strip0x().toBigInteger(16)\n            }");
        return map;
    }

    public final b0<SwapQuote> getFastQuote(SwapAsset source, SwapAsset target, BigInteger amount, AmountBase amountBase, int i2) {
        m.g(source, "source");
        m.g(target, "target");
        m.g(amount, "amount");
        m.g(amountBase, "amountBase");
        return getQuote(source, target, amount, "fast", amountBase, i2);
    }

    public final b0<SwapTrade> getTrade(WalletAddress address, SwapAsset source, SwapAsset target, BigInteger amount, AmountBase amountBase, final int i2) {
        Map<String, String> l2;
        m.g(address, "address");
        m.g(source, "source");
        m.g(target, "target");
        m.g(amount, "amount");
        m.g(amountBase, "amountBase");
        HTTP http = HTTP.INSTANCE;
        HTTPService hTTPService = this.swapHTTPService;
        o[] oVarArr = new o[6];
        oVarArr[0] = u.a("fromAddress", address.getAddress());
        ContractAddress contractAddress = source.getContractAddress();
        String rawValue = contractAddress == null ? null : contractAddress.getRawValue();
        if (rawValue == null) {
            rawValue = source.getCurrencyCode().getCode();
        }
        oVarArr[1] = u.a(ApiConstants.FROM, rawValue);
        ContractAddress contractAddress2 = target.getContractAddress();
        String rawValue2 = contractAddress2 == null ? null : contractAddress2.getRawValue();
        if (rawValue2 == null) {
            rawValue2 = target.getCurrencyCode().getCode();
        }
        oVarArr[2] = u.a(ApiConstants.TO, rawValue2);
        oVarArr[3] = u.a("amount", amount.toString());
        oVarArr[4] = u.a("amountReference", amountBase.getDescription());
        oVarArr[5] = u.a(RouteActionKey.RouteActionKeys.CHAIN_ID, String.valueOf(i2));
        l2 = m0.l(oVarArr);
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(hTTPService, "/rpc/v2/swap/trade", l2, null)).map(new n() { // from class: com.coinbase.wallet.swap.apis.SwapAPI$getTrade$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.swap.dtos.SwapTxDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.swap.dtos.SwapTxDTO> r0 = com.coinbase.wallet.swap.dtos.SwapTxDTO.class
                    java.lang.String r1 = "it"
                    kotlin.jvm.internal.m.g(r9, r1)
                    com.squareup.moshi.JsonAdapter r1 = com.squareup.moshi.JsonAdapter.this
                    java.lang.Class<byte[]> r2 = byte[].class
                    boolean r2 = kotlin.jvm.internal.m.c(r0, r2)
                    r3 = 0
                    r4 = 0
                    if (r2 == 0) goto L26
                    okhttp3.ResponseBody r0 = r9.body()
                    if (r0 != 0) goto L1a
                    goto L1e
                L1a:
                    byte[] r4 = r0.bytes()
                L1e:
                    if (r4 != 0) goto L22
                    byte[] r4 = new byte[r3]
                L22:
                    com.coinbase.wallet.swap.dtos.SwapTxDTO r4 = (com.coinbase.wallet.swap.dtos.SwapTxDTO) r4
                    goto Lac
                L26:
                    boolean r2 = r9.isSuccessful()
                    if (r2 != 0) goto L3d
                    com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed r0 = new com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed
                    okhttp3.ResponseBody r9 = r9.body()
                    if (r9 != 0) goto L35
                    goto L39
                L35:
                    java.lang.String r4 = r9.string()
                L39:
                    r0.<init>(r4)
                    throw r0
                L3d:
                    okhttp3.ResponseBody r2 = r9.body()
                    if (r2 != 0) goto L44
                    goto L48
                L44:
                    java.lang.String r4 = r2.string()
                L48:
                    if (r4 == 0) goto Lf6
                    com.coinbase.wallet.core.util.JSON r2 = com.coinbase.wallet.core.util.JSON.INSTANCE
                    java.util.concurrent.locks.ReentrantReadWriteLock r5 = r2.getMultiReadSingleWriteLock()
                    java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r5 = r5.readLock()
                    r5.lock()
                    kotlin.j0.d r6 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.util.List r6 = r6.getTypeParameters()     // Catch: java.lang.Throwable -> Lf1
                    boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> Lf1
                    r7 = 1
                    r6 = r6 ^ r7
                    if (r6 == 0) goto L6b
                    if (r1 == 0) goto L6a
                    goto L6b
                L6a:
                    r7 = r3
                L6b:
                    if (r7 != 0) goto L93
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf1
                    r6.<init>()     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = "Since "
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    kotlin.j0.d r7 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = r7.getSimpleName()     // Catch: java.lang.Throwable -> Lf1
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r7 = " is parameterized please pass an adapter to `parameterizedAdapter`"
                    r6.append(r7)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lf1
                    com.coinbase.wallet.core.util.AssertionException r7 = new com.coinbase.wallet.core.util.AssertionException     // Catch: java.lang.Throwable -> Lf1
                    r7.<init>(r6)     // Catch: java.lang.Throwable -> Lf1
                    l.a.a.e(r7)     // Catch: java.lang.Throwable -> Lf1
                L93:
                    if (r1 != 0) goto La2
                    com.squareup.moshi.Moshi r1 = r2.getMoshi()     // Catch: java.lang.Throwable -> Lf1
                    com.squareup.moshi.JsonAdapter r0 = r1.adapter(r0)     // Catch: java.lang.Throwable -> Lf1
                    java.lang.Object r0 = r0.fromJson(r4)     // Catch: java.lang.Throwable -> Lf1
                    goto La6
                La2:
                    java.lang.Object r0 = r1.fromJson(r4)     // Catch: java.lang.Throwable -> Lf1
                La6:
                    r4 = r0
                    r5.unlock()
                    if (r4 == 0) goto Lee
                Lac:
                    okhttp3.Headers r9 = r9.headers()
                    int r0 = r9.size()
                    kotlin.i0.c r0 = kotlin.i0.d.j(r3, r0)
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r2 = 10
                    int r2 = kotlin.a0.p.r(r0, r2)
                    r1.<init>(r2)
                    java.util.Iterator r0 = r0.iterator()
                Lc7:
                    boolean r2 = r0.hasNext()
                    if (r2 == 0) goto Le4
                    r2 = r0
                    kotlin.a0.h0 r2 = (kotlin.a0.h0) r2
                    int r2 = r2.c()
                    java.lang.String r3 = r9.name(r2)
                    java.lang.String r2 = r9.value(r2)
                    kotlin.o r2 = kotlin.u.a(r3, r2)
                    r1.add(r2)
                    goto Lc7
                Le4:
                    java.util.Map r9 = kotlin.a0.j0.r(r1)
                    com.coinbase.wallet.http.models.HTTPResponse r0 = new com.coinbase.wallet.http.models.HTTPResponse
                    r0.<init>(r4, r9)
                    return r0
                Lee:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                Lf1:
                    r9 = move-exception
                    r5.unlock()
                    throw r9
                Lf6:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.swap.apis.SwapAPI$getTrade$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0<SwapTrade> map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.swap.apis.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SwapAPI.g(i2, (HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n            .get<SwapTxDTO>(\n                service = swapHTTPService,\n                path = \"/rpc/v2/swap/trade\",\n                parameters = mapOf(\n                    \"fromAddress\" to address.address,\n                    \"from\" to (source.contractAddress?.rawValue ?: source.currencyCode.code),\n                    \"to\" to (target.contractAddress?.rawValue ?: target.currencyCode.code),\n                    \"amount\" to amount.toString(),\n                    \"amountReference\" to amountBase.description,\n                    \"chainId\" to chainId.toString()\n                )\n            )\n            .map { response ->\n                val result = response.body.result\n                SwapTrade(approveTx = result.approveTx, tx = result.tx, quote = result.quote, fee = result.fee, chainId)\n            }");
        return map;
    }
}