package com.coinbase.wallet.featureflags.apis;

import com.coinbase.wallet.consumer.views.ConsumerAuthenticateWebViewClient;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.featureflags.dtos.GetFeatureFlagsResultDto;
import com.coinbase.wallet.featureflags.models.FeatureFlag;
import com.coinbase.wallet.http.CallEnqueueSingle;
import com.coinbase.wallet.http.HTTP;
import com.coinbase.wallet.http.models.HTTPService;
import h.c.b0;
import h.c.m0.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.u;

/* compiled from: FeatureFlagsApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/featureflags/apis/FeatureFlagsApi;", "", "Lh/c/b0;", "", "Lcom/coinbase/wallet/featureflags/models/FeatureFlag;", "", "getFeatureFlags", "()Lh/c/b0;", "Lcom/coinbase/wallet/http/models/HTTPService;", "walletApiHttpService", "Lcom/coinbase/wallet/http/models/HTTPService;", "Lcom/coinbase/wallet/featureflags/apis/RPC;", "RPC", "Lcom/coinbase/wallet/featureflags/apis/RPC;", "<init>", "(Lcom/coinbase/wallet/http/models/HTTPService;Lcom/coinbase/wallet/featureflags/apis/RPC;)V", "featureflags_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class FeatureFlagsApi {
    private final RPC RPC;
    private final HTTPService walletApiHttpService;

    public FeatureFlagsApi(HTTPService walletApiHttpService, RPC RPC) {
        m.g(walletApiHttpService, "walletApiHttpService");
        m.g(RPC, "RPC");
        this.walletApiHttpService = walletApiHttpService;
        this.RPC = RPC;
    }

    public static /* synthetic */ Map a(GetFeatureFlagsResultDto getFeatureFlagsResultDto) {
        return m1200getFeatureFlags$lambda2(getFeatureFlagsResultDto);
    }

    /* renamed from: getFeatureFlags$lambda-2 */
    public static final Map m1200getFeatureFlags$lambda2(GetFeatureFlagsResultDto response) {
        Map r;
        FeatureFlag featureFlag;
        m.g(response, "response");
        Set<Map.Entry<String, Boolean>> entrySet = response.getResult().getAndroid().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
            FeatureFlag[] values = FeatureFlag.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    featureFlag = null;
                    break;
                }
                featureFlag = values[i2];
                if (m.c(featureFlag.getValue(), str)) {
                    break;
                }
                i2++;
            }
            o a = featureFlag != null ? u.a(featureFlag, Boolean.valueOf(booleanValue)) : null;
            if (a != null) {
                arrayList.add(a);
            }
        }
        r = m0.r(arrayList);
        return r;
    }

    public final b0<Map<FeatureFlag, Boolean>> getFeatureFlags() {
        Map<String, String> e2;
        HTTPService hTTPService = this.walletApiHttpService;
        e2 = l0.e(u.a("Authorization", m.o(ConsumerAuthenticateWebViewClient.BEARER, this.RPC.getToken())));
        HTTP http = HTTP.INSTANCE;
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(hTTPService, "/rpc/v2/getFeatureFlags", null, e2)).map(new n() { // from class: com.coinbase.wallet.featureflags.apis.FeatureFlagsApi$getFeatureFlags$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.featureflags.dtos.GetFeatureFlagsResultDto.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.featureflags.dtos.GetFeatureFlagsResultDto> r0 = com.coinbase.wallet.featureflags.dtos.GetFeatureFlagsResultDto.class
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
                    com.coinbase.wallet.featureflags.dtos.GetFeatureFlagsResultDto r4 = (com.coinbase.wallet.featureflags.dtos.GetFeatureFlagsResultDto) r4
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
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.featureflags.apis.FeatureFlagsApi$getFeatureFlags$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0 map = subscribeOn.map(RPC$getProtected$1.INSTANCE);
        m.f(map, "HTTP.get<T>(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers?.plus(authHeader) ?: authHeader\n        ).map { response ->\n            response.body\n        }");
        b0<Map<FeatureFlag, Boolean>> map2 = Single_CoreKt.retryIfNeeded(map, 3, RPC$getProtected$2.INSTANCE).map(new n() { // from class: com.coinbase.wallet.featureflags.apis.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return FeatureFlagsApi.a((GetFeatureFlagsResultDto) obj);
            }
        });
        m.f(map2, "RPC\n        .get<GetFeatureFlagsResultDto> (\n            service = walletApiHttpService, isAuthRequired = true,\n            path = \"/rpc/v2/getFeatureFlags\"\n        )\n        .map { response ->\n            val flags = response\n            flags.result.android.entries\n                .mapNotNull { (key, value) ->\n                    val feature = FeatureFlag.values().firstOrNull { it.value == key }\n                        ?: return@mapNotNull null\n\n                    feature to value\n                }\n                .toMap()\n        }");
        return map2;
    }
}