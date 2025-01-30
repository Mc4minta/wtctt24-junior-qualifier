package com.coinbase.wallet.compoundfinance.apis;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.compoundfinance.dtos.CTokenInfoDTO;
import com.coinbase.wallet.compoundfinance.dtos.CompoundExchangeRateResponseDTO;
import com.coinbase.wallet.compoundfinance.dtos.CryptoCurrenciesDTO;
import com.coinbase.wallet.compoundfinance.dtos.CryptoCurrencyDTO;
import com.coinbase.wallet.compoundfinance.dtos.GetCTokenInfoDTO;
import com.coinbase.wallet.compoundfinance.exceptions.CompoundFinanceException;
import com.coinbase.wallet.ethereum.extensions.HTTPService_EthereumKt;
import com.coinbase.wallet.http.CallEnqueueSingle;
import com.coinbase.wallet.http.HTTP;
import com.coinbase.wallet.http.models.HTTPResponse;
import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.wallet.routing.models.RouteActionKey;
import h.c.b0;
import h.c.m0.n;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.l0.x;
import kotlin.u;

/* compiled from: CompoundFinanceAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\b0\u0004¢\u0006\u0004\b\r\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/compoundfinance/apis/CompoundFinanceAPI;", "", "", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "Lh/c/b0;", "Ljava/math/BigInteger;", "getExchangeRate", "(Ljava/lang/String;)Lh/c/b0;", "", "Lcom/coinbase/wallet/compoundfinance/dtos/CTokenInfoDTO;", "getTokens", "()Lh/c/b0;", "Lcom/coinbase/wallet/compoundfinance/dtos/CryptoCurrencyDTO;", "getCryptoCurrencies", "Lcom/coinbase/wallet/http/models/HTTPService;", "walletService", "Lcom/coinbase/wallet/http/models/HTTPService;", "walletApiUrlString", "<init>", "(Ljava/lang/String;)V", "compoundfinance_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CompoundFinanceAPI {
    private final HTTPService walletService;

    public CompoundFinanceAPI(String walletApiUrlString) {
        m.g(walletApiUrlString, "walletApiUrlString");
        this.walletService = new HTTPService(new URL(walletApiUrlString));
    }

    public static /* synthetic */ BigInteger a(HTTPResponse hTTPResponse) {
        return m817getExchangeRate$lambda0(hTTPResponse);
    }

    public static /* synthetic */ List b(HTTPResponse hTTPResponse) {
        return m818getTokens$lambda1(hTTPResponse);
    }

    public static /* synthetic */ List c(HTTPResponse hTTPResponse) {
        return m816getCryptoCurrencies$lambda2(hTTPResponse);
    }

    /* renamed from: getCryptoCurrencies$lambda-2 */
    public static final List m816getCryptoCurrencies$lambda2(HTTPResponse it) {
        m.g(it, "it");
        return ((CryptoCurrenciesDTO) it.getBody()).getResult().getCryptoCurrencies();
    }

    /* renamed from: getExchangeRate$lambda-0 */
    public static final BigInteger m817getExchangeRate$lambda0(HTTPResponse response) {
        boolean Q;
        m.g(response, "response");
        String result = ((CompoundExchangeRateResponseDTO) response.getBody()).getResult();
        Q = x.Q(result, "0x", false, 2, null);
        if (Q) {
            Objects.requireNonNull(result, "null cannot be cast to non-null type java.lang.String");
            result = result.substring(2);
            m.f(result, "(this as java.lang.String).substring(startIndex)");
        }
        return new BigInteger(result, 16);
    }

    /* renamed from: getTokens$lambda-1 */
    public static final List m818getTokens$lambda1(HTTPResponse it) {
        m.g(it, "it");
        return ((GetCTokenInfoDTO) it.getBody()).getTokens();
    }

    public final b0<List<CryptoCurrencyDTO>> getCryptoCurrencies() {
        HTTP http = HTTP.INSTANCE;
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(this.walletService, "/rpc/v2/getCryptoCurrencies", null, null)).map(new n() { // from class: com.coinbase.wallet.compoundfinance.apis.CompoundFinanceAPI$getCryptoCurrencies$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.compoundfinance.dtos.CryptoCurrenciesDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.compoundfinance.dtos.CryptoCurrenciesDTO> r0 = com.coinbase.wallet.compoundfinance.dtos.CryptoCurrenciesDTO.class
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
                    com.coinbase.wallet.compoundfinance.dtos.CryptoCurrenciesDTO r4 = (com.coinbase.wallet.compoundfinance.dtos.CryptoCurrenciesDTO) r4
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
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.compoundfinance.apis.CompoundFinanceAPI$getCryptoCurrencies$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0<List<CryptoCurrencyDTO>> map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.compoundfinance.apis.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CompoundFinanceAPI.c((HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n        .get<CryptoCurrenciesDTO>(\n            walletService,\n            path = \"/rpc/v2/getCryptoCurrencies\"\n        )\n        .map { it.body.result.cryptoCurrencies }");
        return map;
    }

    public final b0<BigInteger> getExchangeRate(String contractAddress) {
        Map l2;
        List j2;
        Map<String, ? extends Object> l3;
        m.g(contractAddress, "contractAddress");
        HTTPService ethereum = HTTPService_EthereumKt.ethereum(HTTPService.Companion, 1);
        if (ethereum == null) {
            b0<BigInteger> error = b0.error(CompoundFinanceException.UnableToFindEthereumRpcUrl.INSTANCE);
            m.f(error, "error(CompoundFinanceException.UnableToFindEthereumRpcUrl)");
            return error;
        }
        l2 = m0.l(u.a(ApiConstants.TO, contractAddress), u.a("data", "0xbd6d894d"));
        j2 = r.j(l2, "latest");
        l3 = m0.l(u.a("jsonrpc", "2.0"), u.a("id", 1), u.a("method", "eth_call"), u.a("params", j2));
        HTTP http = HTTP.INSTANCE;
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildPostRequest(ethereum, "", l3, null)).map(new n() { // from class: com.coinbase.wallet.compoundfinance.apis.CompoundFinanceAPI$getExchangeRate$$inlined$post$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.compoundfinance.dtos.CompoundExchangeRateResponseDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.compoundfinance.dtos.CompoundExchangeRateResponseDTO> r0 = com.coinbase.wallet.compoundfinance.dtos.CompoundExchangeRateResponseDTO.class
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
                    com.coinbase.wallet.compoundfinance.dtos.CompoundExchangeRateResponseDTO r4 = (com.coinbase.wallet.compoundfinance.dtos.CompoundExchangeRateResponseDTO) r4
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
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.compoundfinance.apis.CompoundFinanceAPI$getExchangeRate$$inlined$post$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildPostRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0<BigInteger> map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.compoundfinance.apis.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CompoundFinanceAPI.a((HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n            .post<CompoundExchangeRateResponseDTO>(\n                service = service,\n                path = \"\",\n                parameters = params\n            )\n            .map { response ->\n                val result = response.body.result\n                val hexRate = if (result.startsWith(\"0x\")) result.substring(2) else result\n\n                BigInteger(hexRate, 16)\n            }");
        return map;
    }

    public final b0<List<CTokenInfoDTO>> getTokens() {
        HTTP http = HTTP.INSTANCE;
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(d.a.a.a.a.a.a(HTTPService.Companion), "/api/v2/ctoken", null, null)).map(new n() { // from class: com.coinbase.wallet.compoundfinance.apis.CompoundFinanceAPI$getTokens$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.compoundfinance.dtos.GetCTokenInfoDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.compoundfinance.dtos.GetCTokenInfoDTO> r0 = com.coinbase.wallet.compoundfinance.dtos.GetCTokenInfoDTO.class
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
                    com.coinbase.wallet.compoundfinance.dtos.GetCTokenInfoDTO r4 = (com.coinbase.wallet.compoundfinance.dtos.GetCTokenInfoDTO) r4
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
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.compoundfinance.apis.CompoundFinanceAPI$getTokens$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0<List<CTokenInfoDTO>> map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.compoundfinance.apis.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CompoundFinanceAPI.b((HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n        .get<GetCTokenInfoDTO>(\n            HTTPService.Compound,\n            path = \"/api/v2/ctoken\"\n        )\n        .map { it.body.tokens }");
        return map;
    }
}