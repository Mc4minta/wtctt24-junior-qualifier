package com.coinbase.wallet.bip44wallets.apis;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.bip44wallets.dtos.BatchBalanceDTO;
import com.coinbase.wallet.bip44wallets.extensions.HTTPService_BIP44WalletsKt;
import com.coinbase.wallet.http.CallEnqueueSingle;
import com.coinbase.wallet.http.HTTP;
import com.coinbase.wallet.http.models.HTTPResponse;
import com.coinbase.wallet.http.models.HTTPService;
import h.c.b0;
import h.c.m0.n;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: BatchBalanceAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ1\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;", "", "", "code", "", "addressList", "", "isTestnet", "Lh/c/b0;", "Lcom/coinbase/wallet/bip44wallets/dtos/BatchBalanceDTO;", "getBalances", "(Ljava/lang/String;Ljava/util/List;Z)Lh/c/b0;", "<init>", "()V", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BatchBalanceAPI {
    public static /* synthetic */ BatchBalanceDTO a(HTTPResponse hTTPResponse) {
        return m702getBalances$lambda0(hTTPResponse);
    }

    /* renamed from: getBalances$lambda-0 */
    public static final BatchBalanceDTO m702getBalances$lambda0(HTTPResponse it) {
        m.g(it, "it");
        return (BatchBalanceDTO) it.getBody();
    }

    public final b0<BatchBalanceDTO> getBalances(String code, List<String> addressList, boolean z) {
        Map<String, ? extends Object> l2;
        m.g(code, "code");
        m.g(addressList, "addressList");
        HTTP http = HTTP.INSTANCE;
        l2 = m0.l(u.a(ApiConstants.ADDRESSES, addressList), u.a("testnet", Boolean.valueOf(z)));
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildPostRequest(HTTPService_BIP44WalletsKt.getBatchBalance(HTTPService.Companion), '/' + code + "/v1/getBalances", l2, null)).map(new n() { // from class: com.coinbase.wallet.bip44wallets.apis.BatchBalanceAPI$getBalances$$inlined$post$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.bip44wallets.dtos.BatchBalanceDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.bip44wallets.dtos.BatchBalanceDTO> r0 = com.coinbase.wallet.bip44wallets.dtos.BatchBalanceDTO.class
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
                    com.coinbase.wallet.bip44wallets.dtos.BatchBalanceDTO r4 = (com.coinbase.wallet.bip44wallets.dtos.BatchBalanceDTO) r4
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
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.bip44wallets.apis.BatchBalanceAPI$getBalances$$inlined$post$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildPostRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0 map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.bip44wallets.apis.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BatchBalanceAPI.a((HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n            .post<BatchBalanceDTO>(\n                service = HTTPService.batchBalance,\n                path = \"/$code/v1/getBalances\",\n                parameters = mapOf(\n                    \"addresses\" to addressList,\n                    \"testnet\" to isTestnet\n                )\n            )\n            .map { it.body }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }
}