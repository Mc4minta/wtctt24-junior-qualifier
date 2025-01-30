package com.coinbase.wallet.txhistory.apis;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.core.util.JSON;
import com.coinbase.wallet.http.CallEnqueueSingle;
import com.coinbase.wallet.http.HTTP;
import com.coinbase.wallet.http.exceptions.HTTPException;
import com.coinbase.wallet.http.models.HTTPResponse;
import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.wallet.txhistory.dtos.GetHdWalletTxsResponse;
import com.coinbase.wallet.txhistory.exceptions.TxHistoryException;
import com.coinbase.wallet.txhistory.extensions.HTTPService_TxHistoryKt;
import com.squareup.moshi.JsonAdapter;
import h.c.b0;
import h.c.m0.n;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.u;

/* compiled from: TxHistoryApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ9\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ9\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\rJU\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\n\u0012\u0004\u0012\u00020\u00020\u00150\t2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/txhistory/apis/TxHistoryApi;", "", "", "address", "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "chain", "", "page", "perPage", "Lh/c/b0;", "", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "getEthereumTxs", "(Ljava/lang/String;Lcom/coinbase/ciphercore/ethereum/EthereumChain;II)Lh/c/b0;", "getErc20Txs", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, ApiConstants.ADDRESSES, "", "isTestnet", "pagingToken", "Lkotlin/o;", "Lcom/coinbase/wallet/txhistory/dtos/GetHdWalletTxsResponse;", "getHdWalletTxs", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/util/List;ZLjava/lang/String;I)Lh/c/b0;", "<init>", "()V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryApi {
    public static /* synthetic */ o a(HTTPResponse hTTPResponse) {
        return m1740getHdWalletTxs$lambda5(hTTPResponse);
    }

    public static /* synthetic */ List b(EthereumChain ethereumChain, String str, HTTPResponse hTTPResponse) {
        return m1739getEthereumTxs$lambda1(ethereumChain, str, hTTPResponse);
    }

    public static /* synthetic */ List c(EthereumChain ethereumChain, String str, HTTPResponse hTTPResponse) {
        return m1738getErc20Txs$lambda3(ethereumChain, str, hTTPResponse);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x013d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013a  */
    /* renamed from: getErc20Txs$lambda-3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List m1738getErc20Txs$lambda3(com.coinbase.ciphercore.ethereum.EthereumChain r30, java.lang.String r31, com.coinbase.wallet.http.models.HTTPResponse r32) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.apis.TxHistoryApi.m1738getErc20Txs$lambda3(com.coinbase.ciphercore.ethereum.EthereumChain, java.lang.String, com.coinbase.wallet.http.models.HTTPResponse):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0140 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013d  */
    /* renamed from: getEthereumTxs$lambda-1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List m1739getEthereumTxs$lambda1(com.coinbase.ciphercore.ethereum.EthereumChain r30, java.lang.String r31, com.coinbase.wallet.http.models.HTTPResponse r32) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.apis.TxHistoryApi.m1739getEthereumTxs$lambda1(com.coinbase.ciphercore.ethereum.EthereumChain, java.lang.String, com.coinbase.wallet.http.models.HTTPResponse):java.util.List");
    }

    /* renamed from: getHdWalletTxs$lambda-5 */
    public static final o m1740getHdWalletTxs$lambda5(HTTPResponse response) {
        m.g(response, "response");
        String str = response.getHeaders().get("x-paging-token");
        if (str != null) {
            JsonAdapter parameterizedAdapter = JSON.INSTANCE.parameterizedAdapter(List.class, GetHdWalletTxsResponse.class);
            Charset defaultCharset = Charset.defaultCharset();
            m.f(defaultCharset, "defaultCharset()");
            List list = (List) parameterizedAdapter.fromJson(new String((byte[]) response.getBody(), defaultCharset));
            if (list != null) {
                return u.a(list, str);
            }
            throw HTTPException.UnableToDeserialize.INSTANCE;
        }
        throw TxHistoryException.MissingPagingToken.INSTANCE;
    }

    public final b0<List<Transaction>> getErc20Txs(final String address, final EthereumChain chain, int i2, int i3) {
        Map<String, String> l2;
        List g2;
        m.g(address, "address");
        m.g(chain, "chain");
        l2 = m0.l(u.a("module", "account"), u.a("action", "tokentx"), u.a("address", address), u.a("page", String.valueOf(i2)), u.a("offset", String.valueOf(i3)), u.a("sort", "desc"), u.a("apikey", chain.getEtherscanLikeApiKey()));
        HTTP http = HTTP.INSTANCE;
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(HTTPService_TxHistoryKt.etherscan(HTTPService.Companion, chain), "/api", l2, null)).map(new n() { // from class: com.coinbase.wallet.txhistory.apis.TxHistoryApi$getErc20Txs$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(byte[].class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<byte[]> r0 = byte[].class
                    java.lang.String r1 = "it"
                    kotlin.jvm.internal.m.g(r9, r1)
                    com.squareup.moshi.JsonAdapter r1 = com.squareup.moshi.JsonAdapter.this
                    boolean r2 = kotlin.jvm.internal.m.c(r0, r0)
                    r3 = 0
                    r4 = 0
                    if (r2 == 0) goto L22
                    okhttp3.ResponseBody r0 = r9.body()
                    if (r0 != 0) goto L18
                    goto L1c
                L18:
                    byte[] r4 = r0.bytes()
                L1c:
                    if (r4 != 0) goto La8
                    byte[] r4 = new byte[r3]
                    goto La8
                L22:
                    boolean r2 = r9.isSuccessful()
                    if (r2 != 0) goto L39
                    com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed r0 = new com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed
                    okhttp3.ResponseBody r9 = r9.body()
                    if (r9 != 0) goto L31
                    goto L35
                L31:
                    java.lang.String r4 = r9.string()
                L35:
                    r0.<init>(r4)
                    throw r0
                L39:
                    okhttp3.ResponseBody r2 = r9.body()
                    if (r2 != 0) goto L40
                    goto L44
                L40:
                    java.lang.String r4 = r2.string()
                L44:
                    if (r4 == 0) goto Lf2
                    com.coinbase.wallet.core.util.JSON r2 = com.coinbase.wallet.core.util.JSON.INSTANCE
                    java.util.concurrent.locks.ReentrantReadWriteLock r5 = r2.getMultiReadSingleWriteLock()
                    java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r5 = r5.readLock()
                    r5.lock()
                    kotlin.j0.d r6 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Led
                    java.util.List r6 = r6.getTypeParameters()     // Catch: java.lang.Throwable -> Led
                    boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> Led
                    r7 = 1
                    r6 = r6 ^ r7
                    if (r6 == 0) goto L67
                    if (r1 == 0) goto L66
                    goto L67
                L66:
                    r7 = r3
                L67:
                    if (r7 != 0) goto L8f
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Led
                    r6.<init>()     // Catch: java.lang.Throwable -> Led
                    java.lang.String r7 = "Since "
                    r6.append(r7)     // Catch: java.lang.Throwable -> Led
                    kotlin.j0.d r7 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Led
                    java.lang.String r7 = r7.getSimpleName()     // Catch: java.lang.Throwable -> Led
                    r6.append(r7)     // Catch: java.lang.Throwable -> Led
                    java.lang.String r7 = " is parameterized please pass an adapter to `parameterizedAdapter`"
                    r6.append(r7)     // Catch: java.lang.Throwable -> Led
                    java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Led
                    com.coinbase.wallet.core.util.AssertionException r7 = new com.coinbase.wallet.core.util.AssertionException     // Catch: java.lang.Throwable -> Led
                    r7.<init>(r6)     // Catch: java.lang.Throwable -> Led
                    l.a.a.e(r7)     // Catch: java.lang.Throwable -> Led
                L8f:
                    if (r1 != 0) goto L9e
                    com.squareup.moshi.Moshi r1 = r2.getMoshi()     // Catch: java.lang.Throwable -> Led
                    com.squareup.moshi.JsonAdapter r0 = r1.adapter(r0)     // Catch: java.lang.Throwable -> Led
                    java.lang.Object r0 = r0.fromJson(r4)     // Catch: java.lang.Throwable -> Led
                    goto La2
                L9e:
                    java.lang.Object r0 = r1.fromJson(r4)     // Catch: java.lang.Throwable -> Led
                La2:
                    r4 = r0
                    r5.unlock()
                    if (r4 == 0) goto Lea
                La8:
                    okhttp3.Headers r9 = r9.headers()
                    int r0 = r9.size()
                    kotlin.i0.c r0 = kotlin.i0.d.j(r3, r0)
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r2 = 10
                    int r2 = kotlin.a0.p.r(r0, r2)
                    r1.<init>(r2)
                    java.util.Iterator r0 = r0.iterator()
                Lc3:
                    boolean r2 = r0.hasNext()
                    if (r2 == 0) goto Le0
                    r2 = r0
                    kotlin.a0.h0 r2 = (kotlin.a0.h0) r2
                    int r2 = r2.c()
                    java.lang.String r3 = r9.name(r2)
                    java.lang.String r2 = r9.value(r2)
                    kotlin.o r2 = kotlin.u.a(r3, r2)
                    r1.add(r2)
                    goto Lc3
                Le0:
                    java.util.Map r9 = kotlin.a0.j0.r(r1)
                    com.coinbase.wallet.http.models.HTTPResponse r0 = new com.coinbase.wallet.http.models.HTTPResponse
                    r0.<init>(r4, r9)
                    return r0
                Lea:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                Led:
                    r9 = move-exception
                    r5.unlock()
                    throw r9
                Lf2:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.apis.TxHistoryApi$getErc20Txs$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0 map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.txhistory.apis.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryApi.c(EthereumChain.this, address, (HTTPResponse) obj);
            }
        });
        g2 = r.g();
        b0<List<Transaction>> onErrorReturnItem = map.onErrorReturnItem(g2);
        m.f(onErrorReturnItem, "HTTP\n            .get<ByteArray>(\n                service = HTTPService.etherscan(chain),\n                path = \"/api\",\n                parameters = parameters\n            )\n            .map { data ->\n                val response = EtherscanApiResponseDTO.fromJson<GetERC20TokensResultDTO>(data.body)\n                    ?: throw TxHistoryException.ApiError(\"Unable to deserialize\")\n\n                if (response.status != okStatus) {\n                    val message = response.message\n\n                    if (message == noTxFoundError) {\n                        return@map emptyList<Transaction>()\n                    }\n\n                    throw TxHistoryException.ApiError(response.message)\n                }\n\n                response.result.mapNotNull { txResponse ->\n                    try {\n                        val date = txResponse.timeStamp.toDate()\n                        val amount = txResponse.value.toBigInteger()\n                        val gasUsed = txResponse.gasUsed.toBigInteger()\n                        val gasPrice = txResponse.gasPrice.toBigInteger()\n\n                        Transaction(\n                            id = UUID.randomUUID().toString(),\n                            createdAt = date,\n                            confirmedAt = date,\n                            blockchain = Blockchain.ETHEREUM,\n                            currencyCode = CurrencyCode(txResponse.tokenSymbol),\n                            feeCurrencyCode = EthereumBasedConfiguration.ETH.currencyCodeForNetwork(chain.asNetwork),\n                            toAddress = txResponse.to,\n                            fromAddress = txResponse.from,\n                            amount = amount,\n                            fee = gasUsed * gasPrice,\n                            metadata = TxMetadata(),\n                            state = TxState.CONFIRMED,\n                            network = chain.asNetwork,\n                            txHash = txResponse.hash,\n                            isSent = txResponse.to.toLowerCase() != address.toLowerCase()\n                        )\n                    } catch (e: Exception) {\n                        null\n                    }\n                }\n            }\n            .onErrorReturnItem(emptyList())");
        return onErrorReturnItem;
    }

    public final b0<List<Transaction>> getEthereumTxs(final String address, final EthereumChain chain, int i2, int i3) {
        Map<String, String> l2;
        List g2;
        m.g(address, "address");
        m.g(chain, "chain");
        l2 = m0.l(u.a("module", "account"), u.a("action", "txlist"), u.a("address", address), u.a("page", String.valueOf(i2)), u.a("offset", String.valueOf(i3)), u.a("sort", "desc"), u.a("apikey", chain.getEtherscanLikeApiKey()));
        HTTP http = HTTP.INSTANCE;
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(HTTPService_TxHistoryKt.etherscan(HTTPService.Companion, chain), "/api", l2, null)).map(new n() { // from class: com.coinbase.wallet.txhistory.apis.TxHistoryApi$getEthereumTxs$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(byte[].class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<byte[]> r0 = byte[].class
                    java.lang.String r1 = "it"
                    kotlin.jvm.internal.m.g(r9, r1)
                    com.squareup.moshi.JsonAdapter r1 = com.squareup.moshi.JsonAdapter.this
                    boolean r2 = kotlin.jvm.internal.m.c(r0, r0)
                    r3 = 0
                    r4 = 0
                    if (r2 == 0) goto L22
                    okhttp3.ResponseBody r0 = r9.body()
                    if (r0 != 0) goto L18
                    goto L1c
                L18:
                    byte[] r4 = r0.bytes()
                L1c:
                    if (r4 != 0) goto La8
                    byte[] r4 = new byte[r3]
                    goto La8
                L22:
                    boolean r2 = r9.isSuccessful()
                    if (r2 != 0) goto L39
                    com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed r0 = new com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed
                    okhttp3.ResponseBody r9 = r9.body()
                    if (r9 != 0) goto L31
                    goto L35
                L31:
                    java.lang.String r4 = r9.string()
                L35:
                    r0.<init>(r4)
                    throw r0
                L39:
                    okhttp3.ResponseBody r2 = r9.body()
                    if (r2 != 0) goto L40
                    goto L44
                L40:
                    java.lang.String r4 = r2.string()
                L44:
                    if (r4 == 0) goto Lf2
                    com.coinbase.wallet.core.util.JSON r2 = com.coinbase.wallet.core.util.JSON.INSTANCE
                    java.util.concurrent.locks.ReentrantReadWriteLock r5 = r2.getMultiReadSingleWriteLock()
                    java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r5 = r5.readLock()
                    r5.lock()
                    kotlin.j0.d r6 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Led
                    java.util.List r6 = r6.getTypeParameters()     // Catch: java.lang.Throwable -> Led
                    boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> Led
                    r7 = 1
                    r6 = r6 ^ r7
                    if (r6 == 0) goto L67
                    if (r1 == 0) goto L66
                    goto L67
                L66:
                    r7 = r3
                L67:
                    if (r7 != 0) goto L8f
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Led
                    r6.<init>()     // Catch: java.lang.Throwable -> Led
                    java.lang.String r7 = "Since "
                    r6.append(r7)     // Catch: java.lang.Throwable -> Led
                    kotlin.j0.d r7 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Led
                    java.lang.String r7 = r7.getSimpleName()     // Catch: java.lang.Throwable -> Led
                    r6.append(r7)     // Catch: java.lang.Throwable -> Led
                    java.lang.String r7 = " is parameterized please pass an adapter to `parameterizedAdapter`"
                    r6.append(r7)     // Catch: java.lang.Throwable -> Led
                    java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Led
                    com.coinbase.wallet.core.util.AssertionException r7 = new com.coinbase.wallet.core.util.AssertionException     // Catch: java.lang.Throwable -> Led
                    r7.<init>(r6)     // Catch: java.lang.Throwable -> Led
                    l.a.a.e(r7)     // Catch: java.lang.Throwable -> Led
                L8f:
                    if (r1 != 0) goto L9e
                    com.squareup.moshi.Moshi r1 = r2.getMoshi()     // Catch: java.lang.Throwable -> Led
                    com.squareup.moshi.JsonAdapter r0 = r1.adapter(r0)     // Catch: java.lang.Throwable -> Led
                    java.lang.Object r0 = r0.fromJson(r4)     // Catch: java.lang.Throwable -> Led
                    goto La2
                L9e:
                    java.lang.Object r0 = r1.fromJson(r4)     // Catch: java.lang.Throwable -> Led
                La2:
                    r4 = r0
                    r5.unlock()
                    if (r4 == 0) goto Lea
                La8:
                    okhttp3.Headers r9 = r9.headers()
                    int r0 = r9.size()
                    kotlin.i0.c r0 = kotlin.i0.d.j(r3, r0)
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r2 = 10
                    int r2 = kotlin.a0.p.r(r0, r2)
                    r1.<init>(r2)
                    java.util.Iterator r0 = r0.iterator()
                Lc3:
                    boolean r2 = r0.hasNext()
                    if (r2 == 0) goto Le0
                    r2 = r0
                    kotlin.a0.h0 r2 = (kotlin.a0.h0) r2
                    int r2 = r2.c()
                    java.lang.String r3 = r9.name(r2)
                    java.lang.String r2 = r9.value(r2)
                    kotlin.o r2 = kotlin.u.a(r3, r2)
                    r1.add(r2)
                    goto Lc3
                Le0:
                    java.util.Map r9 = kotlin.a0.j0.r(r1)
                    com.coinbase.wallet.http.models.HTTPResponse r0 = new com.coinbase.wallet.http.models.HTTPResponse
                    r0.<init>(r4, r9)
                    return r0
                Lea:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                Led:
                    r9 = move-exception
                    r5.unlock()
                    throw r9
                Lf2:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.apis.TxHistoryApi$getEthereumTxs$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0 map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.txhistory.apis.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryApi.b(EthereumChain.this, address, (HTTPResponse) obj);
            }
        });
        g2 = r.g();
        b0<List<Transaction>> onErrorReturnItem = map.onErrorReturnItem(g2);
        m.f(onErrorReturnItem, "HTTP\n            .get<ByteArray>(\n                service = HTTPService.etherscan(chain),\n                path = \"/api\",\n                parameters = parameters\n            )\n            .map { data ->\n                val response = EtherscanApiResponseDTO.fromJson<GetEthereumTxsResultDTO>(data.body)\n                    ?: throw TxHistoryException.ApiError(\"Unable to deserialize\")\n\n                if (response.status != okStatus) {\n                    val message = response.message\n\n                    if (message == noTxFoundError) {\n                        return@map emptyList<Transaction>()\n                    }\n\n                    throw TxHistoryException.ApiError(response.message)\n                }\n\n                response.result.mapNotNull { txResponse ->\n                    try {\n                        val date = txResponse.timeStamp.toDate()\n                        val amount = txResponse.value.toBigInteger()\n                        val gasUsed = txResponse.gasUsed.toBigInteger()\n                        val gasPrice = txResponse.gasPrice.toBigInteger()\n\n                        Transaction(\n                            id = UUID.randomUUID().toString(),\n                            createdAt = date,\n                            confirmedAt = date,\n                            blockchain = Blockchain.ETHEREUM,\n                            currencyCode = EthereumBasedConfiguration.ETH.currencyCodeForNetwork(chain.asNetwork),\n                            feeCurrencyCode = EthereumBasedConfiguration.ETH.currencyCodeForNetwork(chain.asNetwork),\n                            toAddress = txResponse.to,\n                            fromAddress = txResponse.from,\n                            amount = amount,\n                            fee = gasUsed * gasPrice,\n                            metadata = TxMetadata(),\n                            state = TxState.CONFIRMED,\n                            network = chain.asNetwork,\n                            txHash = txResponse.hash,\n                            isSent = txResponse.to.toLowerCase() != address.toLowerCase()\n                        )\n                    } catch (e: Exception) {\n                        null\n                    }\n                }\n            }\n            .onErrorReturnItem(emptyList())");
        return onErrorReturnItem;
    }

    public final b0<o<List<GetHdWalletTxsResponse>, String>> getHdWalletTxs(CurrencyCode currencyCode, List<String> addresses, boolean z, String str, int i2) {
        Map<String, ? extends Object> l2;
        m.g(currencyCode, "currencyCode");
        m.g(addresses, "addresses");
        l2 = m0.l(u.a(ApiConstants.ADDRESSES, addresses), u.a("testnet", Boolean.valueOf(z)), u.a("perPage", Integer.valueOf(i2)));
        Map<String, String> e2 = str == null ? null : l0.e(u.a("x-paging-token", str));
        HTTP http = HTTP.INSTANCE;
        HTTPService txHistory = HTTPService_TxHistoryKt.getTxHistory(HTTPService.Companion);
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        String rawValue = currencyCode.getRawValue();
        Objects.requireNonNull(rawValue, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = rawValue.toLowerCase();
        m.f(lowerCase, "(this as java.lang.String).toLowerCase()");
        sb.append(lowerCase);
        sb.append("/v1/getTransactions");
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildPostRequest(txHistory, sb.toString(), l2, e2)).map(new n() { // from class: com.coinbase.wallet.txhistory.apis.TxHistoryApi$getHdWalletTxs$$inlined$post$default$1
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(byte[].class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<byte[]> r0 = byte[].class
                    java.lang.String r1 = "it"
                    kotlin.jvm.internal.m.g(r9, r1)
                    com.squareup.moshi.JsonAdapter r1 = com.squareup.moshi.JsonAdapter.this
                    boolean r2 = kotlin.jvm.internal.m.c(r0, r0)
                    r3 = 0
                    r4 = 0
                    if (r2 == 0) goto L22
                    okhttp3.ResponseBody r0 = r9.body()
                    if (r0 != 0) goto L18
                    goto L1c
                L18:
                    byte[] r4 = r0.bytes()
                L1c:
                    if (r4 != 0) goto La8
                    byte[] r4 = new byte[r3]
                    goto La8
                L22:
                    boolean r2 = r9.isSuccessful()
                    if (r2 != 0) goto L39
                    com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed r0 = new com.coinbase.wallet.http.exceptions.HTTPException$RequestFailed
                    okhttp3.ResponseBody r9 = r9.body()
                    if (r9 != 0) goto L31
                    goto L35
                L31:
                    java.lang.String r4 = r9.string()
                L35:
                    r0.<init>(r4)
                    throw r0
                L39:
                    okhttp3.ResponseBody r2 = r9.body()
                    if (r2 != 0) goto L40
                    goto L44
                L40:
                    java.lang.String r4 = r2.string()
                L44:
                    if (r4 == 0) goto Lf2
                    com.coinbase.wallet.core.util.JSON r2 = com.coinbase.wallet.core.util.JSON.INSTANCE
                    java.util.concurrent.locks.ReentrantReadWriteLock r5 = r2.getMultiReadSingleWriteLock()
                    java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r5 = r5.readLock()
                    r5.lock()
                    kotlin.j0.d r6 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Led
                    java.util.List r6 = r6.getTypeParameters()     // Catch: java.lang.Throwable -> Led
                    boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> Led
                    r7 = 1
                    r6 = r6 ^ r7
                    if (r6 == 0) goto L67
                    if (r1 == 0) goto L66
                    goto L67
                L66:
                    r7 = r3
                L67:
                    if (r7 != 0) goto L8f
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Led
                    r6.<init>()     // Catch: java.lang.Throwable -> Led
                    java.lang.String r7 = "Since "
                    r6.append(r7)     // Catch: java.lang.Throwable -> Led
                    kotlin.j0.d r7 = kotlin.jvm.internal.e0.b(r0)     // Catch: java.lang.Throwable -> Led
                    java.lang.String r7 = r7.getSimpleName()     // Catch: java.lang.Throwable -> Led
                    r6.append(r7)     // Catch: java.lang.Throwable -> Led
                    java.lang.String r7 = " is parameterized please pass an adapter to `parameterizedAdapter`"
                    r6.append(r7)     // Catch: java.lang.Throwable -> Led
                    java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Led
                    com.coinbase.wallet.core.util.AssertionException r7 = new com.coinbase.wallet.core.util.AssertionException     // Catch: java.lang.Throwable -> Led
                    r7.<init>(r6)     // Catch: java.lang.Throwable -> Led
                    l.a.a.e(r7)     // Catch: java.lang.Throwable -> Led
                L8f:
                    if (r1 != 0) goto L9e
                    com.squareup.moshi.Moshi r1 = r2.getMoshi()     // Catch: java.lang.Throwable -> Led
                    com.squareup.moshi.JsonAdapter r0 = r1.adapter(r0)     // Catch: java.lang.Throwable -> Led
                    java.lang.Object r0 = r0.fromJson(r4)     // Catch: java.lang.Throwable -> Led
                    goto La2
                L9e:
                    java.lang.Object r0 = r1.fromJson(r4)     // Catch: java.lang.Throwable -> Led
                La2:
                    r4 = r0
                    r5.unlock()
                    if (r4 == 0) goto Lea
                La8:
                    okhttp3.Headers r9 = r9.headers()
                    int r0 = r9.size()
                    kotlin.i0.c r0 = kotlin.i0.d.j(r3, r0)
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r2 = 10
                    int r2 = kotlin.a0.p.r(r0, r2)
                    r1.<init>(r2)
                    java.util.Iterator r0 = r0.iterator()
                Lc3:
                    boolean r2 = r0.hasNext()
                    if (r2 == 0) goto Le0
                    r2 = r0
                    kotlin.a0.h0 r2 = (kotlin.a0.h0) r2
                    int r2 = r2.c()
                    java.lang.String r3 = r9.name(r2)
                    java.lang.String r2 = r9.value(r2)
                    kotlin.o r2 = kotlin.u.a(r3, r2)
                    r1.add(r2)
                    goto Lc3
                Le0:
                    java.util.Map r9 = kotlin.a0.j0.r(r1)
                    com.coinbase.wallet.http.models.HTTPResponse r0 = new com.coinbase.wallet.http.models.HTTPResponse
                    r0.<init>(r4, r9)
                    return r0
                Lea:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                Led:
                    r9 = move-exception
                    r5.unlock()
                    throw r9
                Lf2:
                    com.coinbase.wallet.http.exceptions.HTTPException$UnableToDeserialize r9 = com.coinbase.wallet.http.exceptions.HTTPException.UnableToDeserialize.INSTANCE
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.apis.TxHistoryApi$getHdWalletTxs$$inlined$post$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildPostRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0<o<List<GetHdWalletTxsResponse>, String>> map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.txhistory.apis.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryApi.a((HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n            .post<ByteArray>(\n                service = HTTPService.txHistory,\n                path = \"/${currencyCode.rawValue.toLowerCase()}/v1/getTransactions\",\n                parameters = parameters,\n                headers = headers\n            )\n            .map { response ->\n                val newPagingToken = response.headers[pagingTokenKey]\n                    ?: throw TxHistoryException.MissingPagingToken\n\n                val adapter = JSON.parameterizedAdapter<List<GetHdWalletTxsResponse>>(\n                    List::class.java,\n                    GetHdWalletTxsResponse::class.java\n                )\n                val responses = adapter.fromJson(response.body.toString(Charset.defaultCharset()))\n                    ?: throw HTTPException.UnableToDeserialize\n\n                responses to newPagingToken\n            }");
        return map;
    }
}