package com.coinbase.wallet.lending.apis;

import android.util.Base64;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.TxSource;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.TxMetadataKey_EthereumKt;
import com.coinbase.wallet.ethereum.models.ContractAction;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.http.CallEnqueueSingle;
import com.coinbase.wallet.http.HTTP;
import com.coinbase.wallet.http.models.HTTPResponse;
import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.wallet.lending.dtos.LendInterestDTO;
import com.coinbase.wallet.lending.dtos.LendInterestListDTO;
import com.coinbase.wallet.lending.dtos.LendProviderDTO;
import com.coinbase.wallet.lending.dtos.LendTokenDTO;
import com.coinbase.wallet.lending.dtos.LendTokenListDTO;
import com.coinbase.wallet.lending.dtos.ProviderDTO;
import com.coinbase.wallet.lending.dtos.ProviderIdListDTO;
import com.coinbase.wallet.lending.dtos.TxParamListDTO;
import com.coinbase.wallet.lending.dtos.TxParamsDTO;
import com.coinbase.wallet.lending.exceptions.LendException;
import com.coinbase.wallet.lending.extensions.TxMetadataKey_LendKt;
import com.coinbase.wallet.lending.interfaces.TokenResult;
import com.coinbase.wallet.lending.models.LendInterest;
import com.coinbase.wallet.lending.models.LendProvider;
import com.coinbase.wallet.lending.models.LendProviderID;
import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.lending.models.TxParams;
import com.coinbase.wallet.routing.models.RouteActionKey;
import h.c.b0;
import h.c.m0.n;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: LendAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b+\u0010,J#\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00100\f¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u0016JA\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00170\f2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J1\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00170\f2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010#J+\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b$\u0010%J;\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/coinbase/wallet/lending/apis/LendAPI;", "", "Lcom/coinbase/wallet/lending/models/TxParams;", "Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "fromAddress", "Lcom/coinbase/wallet/ethereum/models/ContractAction;", "action", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "asUnsignedTx", "(Lcom/coinbase/wallet/lending/models/TxParams;Lcom/coinbase/wallet/blockchains/models/WalletAddress;Lcom/coinbase/wallet/ethereum/models/ContractAction;)Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "", "providerID", "Lh/c/b0;", "Lcom/coinbase/wallet/lending/models/LendProvider;", "getProvider", "(Ljava/lang/String;)Lh/c/b0;", "", "getLendProviderIds", "()Lh/c/b0;", "address", "Lcom/coinbase/wallet/lending/interfaces/TokenResult;", "getSupportedTokens", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "", "Lcom/coinbase/wallet/lending/models/LendInterest;", "getLifetimeInterestEarned", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", "supplyERC20", "(Lcom/coinbase/wallet/blockchains/models/WalletAddress;Ljava/lang/String;Lcom/coinbase/wallet/ethereum/models/ContractAddress;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/TransferValue;)Lh/c/b0;", "supplyETH", "(Lcom/coinbase/wallet/blockchains/models/WalletAddress;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/TransferValue;)Lh/c/b0;", "withdrawETH", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/WalletAddress;Lcom/coinbase/wallet/blockchains/models/TransferValue;)Lh/c/b0;", "withdrawERC20", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/WalletAddress;Lcom/coinbase/wallet/ethereum/models/ContractAddress;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/TransferValue;)Lh/c/b0;", "Lcom/coinbase/wallet/http/models/HTTPService;", "walletApiService", "Lcom/coinbase/wallet/http/models/HTTPService;", "<init>", "(Lcom/coinbase/wallet/http/models/HTTPService;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendAPI {
    private final HTTPService walletApiService;

    public LendAPI(HTTPService walletApiService) {
        m.g(walletApiService, "walletApiService");
        this.walletApiService = walletApiService;
    }

    public static /* synthetic */ EthereumUnsigned1559Tx a(LendAPI lendAPI, WalletAddress walletAddress, HTTPResponse hTTPResponse) {
        return m1578withdrawETH$lambda11(lendAPI, walletAddress, hTTPResponse);
    }

    private final EthereumUnsigned1559Tx asUnsignedTx(TxParams txParams, WalletAddress walletAddress, ContractAction contractAction) {
        Map l2;
        String toAddress = txParams.getToAddress();
        if (toAddress != null) {
            CurrencyCode currencyCode = new CurrencyCode(txParams.getCurrencyCode());
            TxMetadataKey.Companion companion = TxMetadataKey.Companion;
            l2 = m0.l(u.a(TxMetadataKey_LendKt.getLendTokenID(companion), txParams.getLendTokenId()), u.a(TxMetadataKey_EthereumKt.getContractAction(companion), contractAction.getRawValue()), u.a(TxMetadataKey_EthereumKt.getTxSource(companion), TxSource.RemoteLend.getValue()));
            String address = walletAddress.getAddress();
            int index = walletAddress.getIndex();
            BigInteger bigInteger = new BigInteger(txParams.getWeiValue());
            BigInteger bigInteger2 = new BigInteger(txParams.getTransferValue());
            byte[] decode = Base64.decode(txParams.getData(), 0);
            BigInteger bigInteger3 = new BigInteger(txParams.getGasPrice());
            BigInteger bigInteger4 = new BigInteger(txParams.getGasBaseFee());
            BigInteger bigInteger5 = new BigInteger(txParams.getGasPriorityFee());
            BigInteger bigInteger6 = new BigInteger(txParams.getGasLimit());
            CurrencyCode eth = CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion);
            Blockchain ethereum = Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion);
            Network asNetwork = EthereumChain_EthereumKt.getAsNetwork(EthereumChain.ETHEREUM_MAINNET);
            m.f(decode, "decode(data, Base64.DEFAULT)");
            return new EthereumUnsigned1559Tx(toAddress, address, index, null, bigInteger, null, decode, bigInteger3, bigInteger4, bigInteger5, bigInteger6, asNetwork, currencyCode, ethereum, bigInteger2, eth, toAddress, l2);
        }
        throw LendException.UnableToGetLendingData.INSTANCE;
    }

    public static /* synthetic */ List b(LendAPI lendAPI, WalletAddress walletAddress, HTTPResponse hTTPResponse) {
        return m1576supplyETH$lambda10(lendAPI, walletAddress, hTTPResponse);
    }

    public static /* synthetic */ Set c(HTTPResponse hTTPResponse) {
        return m1570getLendProviderIds$lambda1(hTTPResponse);
    }

    public static /* synthetic */ TokenResult d(Throwable th) {
        return m1574getSupportedTokens$lambda4(th);
    }

    public static /* synthetic */ List e(HTTPResponse hTTPResponse) {
        return m1571getLifetimeInterestEarned$lambda6(hTTPResponse);
    }

    public static /* synthetic */ List f(LendAPI lendAPI, WalletAddress walletAddress, HTTPResponse hTTPResponse) {
        return m1575supplyERC20$lambda8(lendAPI, walletAddress, hTTPResponse);
    }

    public static /* synthetic */ EthereumUnsigned1559Tx g(LendAPI lendAPI, WalletAddress walletAddress, HTTPResponse hTTPResponse) {
        return m1577withdrawERC20$lambda12(lendAPI, walletAddress, hTTPResponse);
    }

    /* renamed from: getLendProviderIds$lambda-1 */
    public static final Set m1570getLendProviderIds$lambda1(HTTPResponse it) {
        Set M0;
        m.g(it, "it");
        M0 = z.M0(((ProviderIdListDTO) it.getBody()).getResult().getProviderIdList());
        return M0;
    }

    /* renamed from: getLifetimeInterestEarned$lambda-6 */
    public static final List m1571getLifetimeInterestEarned$lambda6(HTTPResponse httpResponse) {
        int r;
        m.g(httpResponse, "httpResponse");
        List<LendInterestDTO> lendInterest = ((LendInterestListDTO) httpResponse.getBody()).getResult().getLendInterest();
        r = s.r(lendInterest, 10);
        ArrayList arrayList = new ArrayList(r);
        for (LendInterestDTO lendInterestDTO : lendInterest) {
            arrayList.add(new LendInterest(new CurrencyCode(lendInterestDTO.getCode()), new ContractAddress(lendInterestDTO.getContractAddress()), lendInterestDTO.getInterestEarned(), lendInterestDTO.getDecimals()));
        }
        return arrayList;
    }

    /* renamed from: getProvider$lambda-0 */
    public static final LendProvider m1572getProvider$lambda0(HTTPResponse httpResponse) {
        m.g(httpResponse, "httpResponse");
        ProviderDTO provider = ((LendProviderDTO) httpResponse.getBody()).getResult().getProvider();
        return new LendProvider(new LendProviderID(provider.getId()), provider.getName(), new URL(provider.getWebsiteURL()), new URL(provider.getImageURL()));
    }

    /* renamed from: getSupportedTokens$lambda-3 */
    public static final TokenResult m1573getSupportedTokens$lambda3(String address, HTTPResponse httpResponse) {
        int r;
        m.g(address, "$address");
        m.g(httpResponse, "httpResponse");
        List<LendTokenDTO> lendTokenList = ((LendTokenListDTO) httpResponse.getBody()).getResult().getLendTokenList();
        r = s.r(lendTokenList, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = lendTokenList.iterator();
        while (it.hasNext()) {
            LendTokenDTO lendTokenDTO = (LendTokenDTO) it.next();
            String id = lendTokenDTO.getId();
            String name = lendTokenDTO.getName();
            String code = lendTokenDTO.getCode();
            int m1585getDecimalspVg5ArA = lendTokenDTO.m1585getDecimalspVg5ArA();
            String imageUrl = lendTokenDTO.getImageUrl();
            URL url = !(imageUrl == null || imageUrl.length() == 0) ? new URL(lendTokenDTO.getImageUrl()) : null;
            String contractAddress = lendTokenDTO.getContractAddress();
            BigInteger bigInteger = new BigInteger(lendTokenDTO.getSupplyBalance());
            Iterator it2 = it;
            BigInteger bigInteger2 = new BigInteger(lendTokenDTO.getSupplyInterestRate());
            ArrayList arrayList2 = arrayList;
            BigInteger bigInteger3 = new BigInteger(lendTokenDTO.getGlobalSuppliedAmount());
            BigInteger bigInteger4 = new BigInteger(lendTokenDTO.getUtilizationRate());
            String collateralRate = lendTokenDTO.getCollateralRate();
            BigInteger bigInteger5 = collateralRate != null ? new BigInteger(collateralRate) : null;
            if (bigInteger5 == null) {
                bigInteger5 = BigInteger.ZERO;
            }
            BigInteger bigInteger6 = bigInteger5;
            m.f(bigInteger6, "it.collateralRate?.toBigInteger() ?: BigInteger.ZERO");
            arrayList2.add(new LendToken(id, address, name, code, m1585getDecimalspVg5ArA, url, contractAddress, bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger6, lendTokenDTO.getCollateralRate() != null, lendTokenDTO.getProviderId(), lendTokenDTO.getProviderName(), new URL(lendTokenDTO.getProviderWebsiteUrl()), new URL(lendTokenDTO.getProviderImageUrl()), lendTokenDTO.m1586getRateDecimalspVg5ArA()));
            arrayList = arrayList2;
            it = it2;
        }
        return new TokenResult(arrayList, true);
    }

    /* renamed from: getSupportedTokens$lambda-4 */
    public static final TokenResult m1574getSupportedTokens$lambda4(Throwable it) {
        List g2;
        m.g(it, "it");
        g2 = r.g();
        return new TokenResult(g2, false);
    }

    public static /* synthetic */ LendProvider h(HTTPResponse hTTPResponse) {
        return m1572getProvider$lambda0(hTTPResponse);
    }

    public static /* synthetic */ TokenResult i(String str, HTTPResponse hTTPResponse) {
        return m1573getSupportedTokens$lambda3(str, hTTPResponse);
    }

    /* renamed from: supplyERC20$lambda-8 */
    public static final List m1575supplyERC20$lambda8(LendAPI this$0, WalletAddress address, HTTPResponse response) {
        int r;
        m.g(this$0, "this$0");
        m.g(address, "$address");
        m.g(response, "response");
        List<TxParams> txParamList = ((TxParamListDTO) response.getBody()).getResult().getTxParamList();
        r = s.r(txParamList, 10);
        ArrayList arrayList = new ArrayList(r);
        for (TxParams txParams : txParamList) {
            arrayList.add(this$0.asUnsignedTx(txParams, address, ContractAction.SUPPLY));
        }
        return arrayList;
    }

    /* renamed from: supplyETH$lambda-10 */
    public static final List m1576supplyETH$lambda10(LendAPI this$0, WalletAddress address, HTTPResponse response) {
        int r;
        m.g(this$0, "this$0");
        m.g(address, "$address");
        m.g(response, "response");
        List<TxParams> txParamList = ((TxParamListDTO) response.getBody()).getResult().getTxParamList();
        r = s.r(txParamList, 10);
        ArrayList arrayList = new ArrayList(r);
        for (TxParams txParams : txParamList) {
            arrayList.add(this$0.asUnsignedTx(txParams, address, ContractAction.SUPPLY));
        }
        return arrayList;
    }

    /* renamed from: withdrawERC20$lambda-12 */
    public static final EthereumUnsigned1559Tx m1577withdrawERC20$lambda12(LendAPI this$0, WalletAddress address, HTTPResponse response) {
        m.g(this$0, "this$0");
        m.g(address, "$address");
        m.g(response, "response");
        return this$0.asUnsignedTx(((TxParamsDTO) response.getBody()).getResult().getTxParams(), address, ContractAction.WITHDRAW);
    }

    /* renamed from: withdrawETH$lambda-11 */
    public static final EthereumUnsigned1559Tx m1578withdrawETH$lambda11(LendAPI this$0, WalletAddress address, HTTPResponse response) {
        m.g(this$0, "this$0");
        m.g(address, "$address");
        m.g(response, "response");
        return this$0.asUnsignedTx(((TxParamsDTO) response.getBody()).getResult().getTxParams(), address, ContractAction.WITHDRAW);
    }

    public final b0<Set<String>> getLendProviderIds() {
        Map<String, String> e2;
        HTTP http = HTTP.INSTANCE;
        HTTPService hTTPService = this.walletApiService;
        e2 = l0.e(u.a("include_old_providers", "true"));
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(hTTPService, "/rpc/v2/lend/getProviderIds", e2, null)).map(new n() { // from class: com.coinbase.wallet.lending.apis.LendAPI$getLendProviderIds$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.lending.dtos.ProviderIdListDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.lending.dtos.ProviderIdListDTO> r0 = com.coinbase.wallet.lending.dtos.ProviderIdListDTO.class
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
                    com.coinbase.wallet.lending.dtos.ProviderIdListDTO r4 = (com.coinbase.wallet.lending.dtos.ProviderIdListDTO) r4
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
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.lending.apis.LendAPI$getLendProviderIds$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0 map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.lending.apis.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendAPI.c((HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n            .get<ProviderIdListDTO>(\n                service = walletApiService,\n                path = \"/rpc/v2/lend/getProviderIds\",\n                parameters = mapOf(\n                    \"include_old_providers\" to \"true\"\n                )\n            )\n            .map { it.body.result.providerIdList.toSet() }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }

    public final b0<List<LendInterest>> getLifetimeInterestEarned(String providerID, String address) {
        Map<String, String> l2;
        m.g(providerID, "providerID");
        m.g(address, "address");
        HTTP http = HTTP.INSTANCE;
        HTTPService hTTPService = this.walletApiService;
        l2 = m0.l(u.a("provider", providerID), u.a("address", address));
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(hTTPService, "/rpc/v2/lend/getLifetimeInterestEarned", l2, null)).map(new n() { // from class: com.coinbase.wallet.lending.apis.LendAPI$getLifetimeInterestEarned$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.lending.dtos.LendInterestListDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.lending.dtos.LendInterestListDTO> r0 = com.coinbase.wallet.lending.dtos.LendInterestListDTO.class
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
                    com.coinbase.wallet.lending.dtos.LendInterestListDTO r4 = (com.coinbase.wallet.lending.dtos.LendInterestListDTO) r4
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
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.lending.apis.LendAPI$getLifetimeInterestEarned$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0 map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.lending.apis.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendAPI.e((HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n            .get<LendInterestListDTO>(\n                service = walletApiService,\n                path = \"/rpc/v2/lend/getLifetimeInterestEarned\",\n                parameters = mapOf(\n                    \"provider\" to providerID,\n                    \"address\" to address\n                )\n            )\n            .map { httpResponse ->\n                httpResponse.body.result.lendInterest.map {\n                    LendInterest(\n                        code = CurrencyCode(it.code),\n                        contractAddress = ContractAddress(it.contractAddress),\n                        interestEarned = it.interestEarned,\n                        decimals = it.decimals\n                    )\n                }\n            }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }

    public final b0<LendProvider> getProvider(String providerID) {
        Map<String, String> e2;
        m.g(providerID, "providerID");
        HTTP http = HTTP.INSTANCE;
        HTTPService hTTPService = this.walletApiService;
        e2 = l0.e(u.a("provider", providerID));
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(hTTPService, "/rpc/v2/lend/getProvider", e2, null)).map(new n() { // from class: com.coinbase.wallet.lending.apis.LendAPI$getProvider$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.lending.dtos.LendProviderDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.lending.dtos.LendProviderDTO> r0 = com.coinbase.wallet.lending.dtos.LendProviderDTO.class
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
                    com.coinbase.wallet.lending.dtos.LendProviderDTO r4 = (com.coinbase.wallet.lending.dtos.LendProviderDTO) r4
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
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.lending.apis.LendAPI$getProvider$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0 map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.lending.apis.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendAPI.h((HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n            .get<LendProviderDTO>(\n                service = walletApiService,\n                path = \"/rpc/v2/lend/getProvider\",\n                parameters = mapOf(\n                    \"provider\" to providerID\n                )\n            )\n            .map { httpResponse ->\n                val dto = httpResponse.body.result.provider\n                LendProvider(LendProviderID(dto.id), dto.name, URL(dto.websiteURL), URL(dto.imageURL))\n            }");
        return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
    }

    public final b0<TokenResult> getSupportedTokens(String providerID, final String address) {
        Map<String, String> l2;
        m.g(providerID, "providerID");
        m.g(address, "address");
        HTTP http = HTTP.INSTANCE;
        HTTPService hTTPService = this.walletApiService;
        l2 = m0.l(u.a("provider", providerID), u.a("address", address), u.a("enable_aave_v2_eth", "true"));
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(hTTPService, "/rpc/v2/lend/getSupportedTokens", l2, null)).map(new n() { // from class: com.coinbase.wallet.lending.apis.LendAPI$getSupportedTokens$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.lending.dtos.LendTokenListDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.lending.dtos.LendTokenListDTO> r0 = com.coinbase.wallet.lending.dtos.LendTokenListDTO.class
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
                    com.coinbase.wallet.lending.dtos.LendTokenListDTO r4 = (com.coinbase.wallet.lending.dtos.LendTokenListDTO) r4
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
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.lending.apis.LendAPI$getSupportedTokens$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0<TokenResult> onErrorReturn = subscribeOn.map(new n() { // from class: com.coinbase.wallet.lending.apis.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendAPI.i(address, (HTTPResponse) obj);
            }
        }).onErrorReturn(new n() { // from class: com.coinbase.wallet.lending.apis.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendAPI.d((Throwable) obj);
            }
        });
        m.f(onErrorReturn, "HTTP\n            .get<LendTokenListDTO>(\n                service = walletApiService,\n                path = \"/rpc/v2/lend/getSupportedTokens\",\n                parameters = mapOf(\n                    \"provider\" to providerID,\n                    \"address\" to address,\n                    \"enable_aave_v2_eth\" to \"true\"\n                )\n            )\n            .map { httpResponse ->\n                val newTokens = httpResponse.body.result.lendTokenList.map {\n                    LendToken(\n                        id = it.id,\n                        walletAddress = address,\n                        name = it.name,\n                        code = it.code,\n                        decimals = it.decimals.toInt(),\n                        imageURL = if (!it.imageUrl.isNullOrEmpty()) URL(it.imageUrl) else null,\n                        contractAddress = it.contractAddress,\n                        supplyBalance = it.supplyBalance.toBigInteger(),\n                        supplyInterestRate = it.supplyInterestRate.toBigInteger(),\n                        globalSuppliedAmount = it.globalSuppliedAmount.toBigInteger(),\n                        utilizationRate = it.utilizationRate.toBigInteger(),\n                        collateralRate = it.collateralRate?.toBigInteger() ?: BigInteger.ZERO,\n                        isCollateralRateApplicable = it.collateralRate != null,\n                        providerID = it.providerId,\n                        providerName = it.providerName,\n                        providerWebsiteURL = URL(it.providerWebsiteUrl),\n                        providerImageURL = URL(it.providerImageUrl),\n                        rateDecimals = it.rateDecimals.toInt()\n                    )\n                }\n\n                TokenResult(newTokens, true)\n            }\n            .onErrorReturn { TokenResult(emptyList(), false) }");
        return onErrorReturn;
    }

    public final b0<List<EthereumUnsigned1559Tx>> supplyERC20(final WalletAddress address, String providerID, ContractAddress contractAddress, CurrencyCode currencyCode, TransferValue amount) {
        Map<String, String> m;
        m.g(address, "address");
        m.g(providerID, "providerID");
        m.g(contractAddress, "contractAddress");
        m.g(currencyCode, "currencyCode");
        m.g(amount, "amount");
        m = m0.m(u.a("provider", providerID), u.a("address", address.getAddress()), u.a(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, contractAddress.getRawValue()), u.a(AppsFlyerProperties.CURRENCY_CODE, currencyCode.getCode()), u.a("isMax", String.valueOf(amount instanceof TransferValue.EntireBalance)));
        if (amount instanceof TransferValue.Amount) {
            String bigInteger = ((TransferValue.Amount) amount).getValue().toString();
            m.f(bigInteger, "amount.value.toString()");
            m.put("amount", bigInteger);
        }
        HTTP http = HTTP.INSTANCE;
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(this.walletApiService, "/rpc/v2/lend/supplyErc20", m, null)).map(new n() { // from class: com.coinbase.wallet.lending.apis.LendAPI$supplyERC20$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.lending.dtos.TxParamListDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.lending.dtos.TxParamListDTO> r0 = com.coinbase.wallet.lending.dtos.TxParamListDTO.class
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
                    com.coinbase.wallet.lending.dtos.TxParamListDTO r4 = (com.coinbase.wallet.lending.dtos.TxParamListDTO) r4
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
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.lending.apis.LendAPI$supplyERC20$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0<List<EthereumUnsigned1559Tx>> map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.lending.apis.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendAPI.f(LendAPI.this, address, (HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n            .get<TxParamListDTO>(\n                service = walletApiService,\n                path = \"/rpc/v2/lend/supplyErc20\",\n                parameters = params\n            )\n            .map { response ->\n                response.body.result.txParamList.map {\n                    it.asUnsignedTx(fromAddress = address, action = ContractAction.SUPPLY)\n                }\n            }");
        return map;
    }

    public final b0<List<EthereumUnsigned1559Tx>> supplyETH(final WalletAddress address, String providerID, TransferValue amount) {
        Map<String, String> m;
        m.g(address, "address");
        m.g(providerID, "providerID");
        m.g(amount, "amount");
        m = m0.m(u.a("provider", providerID), u.a("address", address.getAddress()), u.a("isMax", String.valueOf(amount instanceof TransferValue.EntireBalance)), u.a("list", "true"));
        if (amount instanceof TransferValue.Amount) {
            String bigInteger = ((TransferValue.Amount) amount).getValue().toString();
            m.f(bigInteger, "amount.value.toString()");
            m.put("amount", bigInteger);
        }
        HTTP http = HTTP.INSTANCE;
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(this.walletApiService, "/rpc/v2/lend/supplyEth", m, null)).map(new n() { // from class: com.coinbase.wallet.lending.apis.LendAPI$supplyETH$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.lending.dtos.TxParamListDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.lending.dtos.TxParamListDTO> r0 = com.coinbase.wallet.lending.dtos.TxParamListDTO.class
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
                    com.coinbase.wallet.lending.dtos.TxParamListDTO r4 = (com.coinbase.wallet.lending.dtos.TxParamListDTO) r4
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
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.lending.apis.LendAPI$supplyETH$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0<List<EthereumUnsigned1559Tx>> map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.lending.apis.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendAPI.b(LendAPI.this, address, (HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n            .get<TxParamListDTO>(\n                service = walletApiService,\n                path = \"/rpc/v2/lend/supplyEth\",\n                parameters = params\n            )\n            .map { response ->\n                response.body.result.txParamList.map {\n                    it.asUnsignedTx(fromAddress = address, action = ContractAction.SUPPLY)\n                }\n            }");
        return map;
    }

    public final b0<EthereumUnsigned1559Tx> withdrawERC20(String providerID, final WalletAddress address, ContractAddress contractAddress, CurrencyCode currencyCode, TransferValue amount) {
        Map<String, String> m;
        m.g(providerID, "providerID");
        m.g(address, "address");
        m.g(contractAddress, "contractAddress");
        m.g(currencyCode, "currencyCode");
        m.g(amount, "amount");
        m = m0.m(u.a("provider", providerID), u.a("address", address.getAddress()), u.a(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, contractAddress.getRawValue()), u.a(AppsFlyerProperties.CURRENCY_CODE, currencyCode.getCode()), u.a("isMax", String.valueOf(amount instanceof TransferValue.EntireBalance)));
        if (amount instanceof TransferValue.Amount) {
            String bigInteger = ((TransferValue.Amount) amount).getValue().toString();
            m.f(bigInteger, "amount.value.toString()");
            m.put("amount", bigInteger);
        }
        HTTP http = HTTP.INSTANCE;
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(this.walletApiService, "/rpc/v2/lend/withdrawErc20", m, null)).map(new n() { // from class: com.coinbase.wallet.lending.apis.LendAPI$withdrawERC20$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.lending.dtos.TxParamsDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.lending.dtos.TxParamsDTO> r0 = com.coinbase.wallet.lending.dtos.TxParamsDTO.class
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
                    com.coinbase.wallet.lending.dtos.TxParamsDTO r4 = (com.coinbase.wallet.lending.dtos.TxParamsDTO) r4
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
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.lending.apis.LendAPI$withdrawERC20$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0<EthereumUnsigned1559Tx> map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.lending.apis.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendAPI.g(LendAPI.this, address, (HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n            .get<TxParamsDTO>(\n                service = walletApiService,\n                path = \"/rpc/v2/lend/withdrawErc20\",\n                parameters = params\n            )\n            .map { response ->\n                response.body.result.txParams.asUnsignedTx(fromAddress = address, action = ContractAction.WITHDRAW)\n            }");
        return map;
    }

    public final b0<EthereumUnsigned1559Tx> withdrawETH(String providerID, final WalletAddress address, TransferValue amount) {
        Map<String, String> m;
        m.g(providerID, "providerID");
        m.g(address, "address");
        m.g(amount, "amount");
        m = m0.m(u.a("provider", providerID), u.a("address", address.getAddress()), u.a("isMax", String.valueOf(amount instanceof TransferValue.EntireBalance)));
        if (amount instanceof TransferValue.Amount) {
            String bigInteger = ((TransferValue.Amount) amount).getValue().toString();
            m.f(bigInteger, "amount.value.toString()");
            m.put("amount", bigInteger);
        }
        HTTP http = HTTP.INSTANCE;
        b0 subscribeOn = new CallEnqueueSingle(http.getClient(), http.buildGetRequest(this.walletApiService, "/rpc/v2/lend/withdrawEth", m, null)).map(new n() { // from class: com.coinbase.wallet.lending.apis.LendAPI$withdrawETH$$inlined$get$default$1
            /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
                l.a.a.e(new com.coinbase.wallet.core.util.AssertionException("Since " + ((java.lang.Object) kotlin.jvm.internal.e0.b(com.coinbase.wallet.lending.dtos.TxParamsDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
             */
            @Override // h.c.m0.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.coinbase.wallet.http.models.HTTPResponse<T> apply(okhttp3.Response r9) {
                /*
                    r8 = this;
                    java.lang.Class<com.coinbase.wallet.lending.dtos.TxParamsDTO> r0 = com.coinbase.wallet.lending.dtos.TxParamsDTO.class
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
                    com.coinbase.wallet.lending.dtos.TxParamsDTO r4 = (com.coinbase.wallet.lending.dtos.TxParamsDTO) r4
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
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.lending.apis.LendAPI$withdrawETH$$inlined$get$default$1.apply(okhttp3.Response):com.coinbase.wallet.http.models.HTTPResponse");
            }
        }).subscribeOn(http.getSchedulers());
        m.f(subscribeOn, "parameterizedAdapter: JsonAdapter<T>? = null\n    ): Single<HTTPResponse<T>> {\n        val request = buildGetRequest(\n            service = service,\n            path = path,\n            parameters = parameters,\n            headers = headers\n        )\n\n        return CallEnqueueSingle(client, request)\n            .map { it.asHTTPResponse<T>(parameterizedAdapter) }\n            .subscribeOn(schedulers)");
        b0<EthereumUnsigned1559Tx> map = subscribeOn.map(new n() { // from class: com.coinbase.wallet.lending.apis.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return LendAPI.a(LendAPI.this, address, (HTTPResponse) obj);
            }
        });
        m.f(map, "HTTP\n            .get<TxParamsDTO>(\n                service = walletApiService,\n                path = \"/rpc/v2/lend/withdrawEth\",\n                parameters = params\n            )\n            .map { response ->\n                response.body.result.txParams.asUnsignedTx(\n                    fromAddress = address,\n                    action = ContractAction.WITHDRAW\n                )\n            }");
        return map;
    }
}