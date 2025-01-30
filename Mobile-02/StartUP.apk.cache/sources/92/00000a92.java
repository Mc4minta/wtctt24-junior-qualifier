package com.coinbase;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.coinbase.ApiConstants;
import com.coinbase.errors.CoinbaseErrorResponse;
import com.coinbase.errors.CoinbaseException;
import com.coinbase.errors.CoinbaseOAuthException;
import com.coinbase.errors.OAuthError;
import com.coinbase.network.ApiCall;
import com.coinbase.network.ApiCallAdapterFactory;
import com.coinbase.resources.accounts.AccountResource;
import com.coinbase.resources.accounts.AccountsApi;
import com.coinbase.resources.accounts.AccountsApiRx;
import com.coinbase.resources.accounts.Currency;
import com.coinbase.resources.addresses.AddressResource;
import com.coinbase.resources.addresses.AddressesApi;
import com.coinbase.resources.addresses.AddressesApiRx;
import com.coinbase.resources.auth.AccessToken;
import com.coinbase.resources.auth.AuthApi;
import com.coinbase.resources.auth.AuthApiRx;
import com.coinbase.resources.auth.AuthResource;
import com.coinbase.resources.base.DynamicResource;
import com.coinbase.resources.base.DynamicResourceDeserializer;
import com.coinbase.resources.buys.BuysResource;
import com.coinbase.resources.currencies.CurrenciesApi;
import com.coinbase.resources.currencies.CurrenciesApiRx;
import com.coinbase.resources.currencies.CurrenciesResource;
import com.coinbase.resources.deposits.DepositsResource;
import com.coinbase.resources.paymentmethods.PaymentMethodResource;
import com.coinbase.resources.paymentmethods.PaymentMethodsApi;
import com.coinbase.resources.paymentmethods.PaymentMethodsApiRx;
import com.coinbase.resources.prices.PricesApi;
import com.coinbase.resources.prices.PricesApiRx;
import com.coinbase.resources.prices.PricesResource;
import com.coinbase.resources.rates.ExchangeRatesApi;
import com.coinbase.resources.rates.ExchangeRatesApiRx;
import com.coinbase.resources.rates.ExchangeRatesResource;
import com.coinbase.resources.sells.SellsResource;
import com.coinbase.resources.time.TimeApi;
import com.coinbase.resources.time.TimeApiRx;
import com.coinbase.resources.time.TimeResource;
import com.coinbase.resources.trades.PlaceTradeOrderBody;
import com.coinbase.resources.trades.PlaceTradeOrderBodySerializer;
import com.coinbase.resources.trades.Trade;
import com.coinbase.resources.trades.TradesApi;
import com.coinbase.resources.trades.TradesApiRx;
import com.coinbase.resources.trades.TradesDeserializer;
import com.coinbase.resources.transactions.TransactionsApi;
import com.coinbase.resources.transactions.TransactionsApiRx;
import com.coinbase.resources.transactions.TransactionsResource;
import com.coinbase.resources.transactions.entities.CryptoAddress;
import com.coinbase.resources.transactions.entities.CryptoNetwork;
import com.coinbase.resources.users.UserResource;
import com.coinbase.resources.users.UsersApi;
import com.coinbase.resources.users.UsersApiRx;
import com.coinbase.resources.withdrawals.WithdrawalsResource;
import com.coinbase.wallet.consumer.views.ConsumerAuthenticateWebViewClient;
import h.c.a0;
import h.c.b0;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import okhttp3.Cache;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.t;

/* loaded from: classes.dex */
public class Coinbase {
    private static final String BASE_API_URL = "https://api.coinbase.com/v2/";
    private static final int CONNECTION_TIMEOUT = 30;
    private static final String KEY_LOGIN_CSRF_TOKEN = "com.coinbase.android.sdk.login_csrf_token";
    private static final String LOG_TAG = "Coinbase";
    private static final String OAUTH_URL = "https://www.coinbase.com/oauth/";
    private static final int PERSISTENT_CACHE_SIZE = 5242880;
    private static final String PREFS_NAME = "com.coinbase.android.sdk";
    private static final int READ_TIMEOUT = 30;
    protected volatile String accessToken;
    private AccountResource accountResource;
    private List<Interceptor> additionalInterceptors;
    private AddressResource addressResource;
    private String apiVersionCode;
    private AuthResource authResource;
    private boolean autorefresh;
    private a0 backgroundScheduler;
    private URL baseApiUrl;
    private URL baseOAuthUrl;
    private BuysResource buysResource;
    protected String clientId;
    protected String clientName;
    protected String clientSecret;
    protected String clientVersion;
    protected Context context;
    private Set<String> cryptoAddressNames;
    private Set<String> cryptoNetworkNames;
    private CurrenciesResource currenciesResource;
    private DepositsResource depositsResource;
    private final Cache diskCache;
    private ExchangeRatesResource exchangeRatesResource;
    protected com.google.gson.f gson;
    private ExecutorService httpExecutorService;
    private HttpLoggingInterceptor.Level loggingLevel;
    private OkHttpClient okHttpClient;
    private PaymentMethodResource paymentMethodResource;
    private PricesResource pricesResource;
    protected volatile String refreshToken;
    private retrofit2.t retrofit;
    private SellsResource sellsResource;
    private boolean skipCertPinning;
    private SSLContext sslContext;
    private TimeResource timeResource;
    private volatile TokenListener tokenListener;
    private TransactionsResource transactionsResource;
    private X509TrustManager trustManager;
    private final Handler uiHandler;
    private UserResource userResource;
    private WithdrawalsResource withdrawalResource;

    /* loaded from: classes.dex */
    public interface TokenListener {
        void onNewTokensAvailable(AccessToken accessToken);

        void onRefreshFailed(CoinbaseOAuthException coinbaseOAuthException);

        void onTokenRevoked();
    }

    protected Coinbase(Context context) {
        this.cryptoAddressNames = new HashSet();
        this.cryptoNetworkNames = new HashSet();
        this.loggingLevel = HttpLoggingInterceptor.Level.NONE;
        this.additionalInterceptors = Collections.emptyList();
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.apiVersionCode = null;
        this.context = context;
        try {
            this.baseApiUrl = new URL(BASE_API_URL);
            this.baseOAuthUrl = new URL(OAUTH_URL);
            this.sslContext = CoinbaseSSL.getSSLContext();
            this.trustManager = CoinbaseSSL.getTrustManager();
            this.backgroundScheduler = h.c.u0.a.c();
            this.diskCache = new Cache(context.getCacheDir(), 5242880L);
            this.gson = createGson();
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void checkClientIdAndSecret() {
        if (TextUtils.isEmpty(this.clientId) || TextUtils.isEmpty(this.clientSecret)) {
            throw new IllegalStateException("Client id and client secret should be provided before authorization starts");
        }
    }

    private void clearAuthInfo() {
        this.accessToken = null;
        this.refreshToken = null;
    }

    private com.google.gson.f createGson() {
        return createGsonBuilder().c(DynamicResource.class, initDynamicResourceDeserializer()).b();
    }

    public static com.google.gson.g createGsonBuilder() {
        return new com.google.gson.g().d(new Currency.CurrencyDeserializationFactory()).c(Trade.class, new TradesDeserializer()).c(PlaceTradeOrderBody.class, new PlaceTradeOrderBodySerializer()).f(com.google.gson.d.f9518d).e("yyyy-MM-dd'T'HH:mm:ssZ");
    }

    private synchronized void doRefreshToken(String str) throws IOException {
        if (str.equals(this.refreshToken)) {
            try {
                getAuthResource().refreshTokens(this.clientId, this.clientSecret, this.refreshToken).execute();
            } catch (CoinbaseOAuthException e2) {
                Log.w(LOG_TAG, "Could not refresh token", e2);
            }
        }
    }

    private OkHttpClient.Builder generateClientBuilder(SSLContext sSLContext, X509TrustManager x509TrustManager, boolean z) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (sSLContext != null && x509TrustManager != null && !z) {
            builder.sslSocketFactory(sSLContext.getSocketFactory(), x509TrustManager);
        }
        ExecutorService executorService = this.httpExecutorService;
        if (executorService != null) {
            builder.dispatcher(new Dispatcher(executorService));
        }
        builder.protocols(Collections.singletonList(Protocol.HTTP_1_1));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.readTimeout(30L, timeUnit).connectTimeout(30L, timeUnit);
        builder.addInterceptor(tokenRefreshInterceptor()).addInterceptor(errorHandlingInterceptor()).addInterceptor(saveAuthTokensInterceptor()).addInterceptor(authHeaderInterceptor()).addInterceptor(clientInfoInterceptor());
        for (Interceptor interceptor : this.additionalInterceptors) {
            builder.addInterceptor(interceptor);
        }
        builder.addInterceptor(loggingInterceptor());
        builder.addNetworkInterceptor(networkSniffingInterceptor());
        return builder;
    }

    private String getAuthCode(Intent intent) {
        return getAuthCodeFromUri(getIntentUri(intent));
    }

    private Uri getIntentUri(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            return data;
        }
        throw new IllegalArgumentException("No redirect URI in intent!");
    }

    private String getRedirectUrl(Intent intent) {
        return getRedirectUrlFromUri(getIntentUri(intent));
    }

    private DynamicResourceDeserializer initDynamicResourceDeserializer() {
        DynamicResourceDeserializer dynamicResourceDeserializer = new DynamicResourceDeserializer();
        dynamicResourceDeserializer.addTypeMapping("bitcoin_address", CryptoAddress.class);
        dynamicResourceDeserializer.addTypeMapping("bitcoin_cash_address", CryptoAddress.class);
        dynamicResourceDeserializer.addTypeMapping("litecoin_address", CryptoAddress.class);
        dynamicResourceDeserializer.addTypeMapping("ethereum_address", CryptoAddress.class);
        dynamicResourceDeserializer.addTypeMapping("ethereum_classic_address", CryptoAddress.class);
        dynamicResourceDeserializer.addTypeMapping("ripple_address", CryptoAddress.class);
        dynamicResourceDeserializer.addTypeMapping("stellar_address", CryptoAddress.class);
        for (String str : this.cryptoAddressNames) {
            dynamicResourceDeserializer.addTypeMapping(str, CryptoAddress.class);
        }
        dynamicResourceDeserializer.addTypeMapping("bitcoin_network", CryptoNetwork.class);
        dynamicResourceDeserializer.addTypeMapping("bitcoin_cash_network", CryptoNetwork.class);
        dynamicResourceDeserializer.addTypeMapping("litecoin_network", CryptoNetwork.class);
        dynamicResourceDeserializer.addTypeMapping("ethereum_network", CryptoNetwork.class);
        for (String str2 : this.cryptoNetworkNames) {
            dynamicResourceDeserializer.addTypeMapping(str2, CryptoNetwork.class);
        }
        return dynamicResourceDeserializer;
    }

    private Request.Builder insertAccessToken(Request.Builder builder) {
        if (this.accessToken != null) {
            builder.header("Authorization", ConsumerAuthenticateWebViewClient.BEARER + this.accessToken);
        }
        return builder;
    }

    /* renamed from: lambda$authHeaderInterceptor$1 */
    public /* synthetic */ Response a(Interceptor.Chain chain) throws IOException {
        return chain.proceed(insertAccessToken(chain.request().newBuilder()).build());
    }

    /* renamed from: lambda$clientInfoInterceptor$0 */
    public /* synthetic */ Response b(Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().addHeader(ApiConstants.Headers.CB_VERSION, ApiConstants.VERSION).addHeader(ApiConstants.Headers.CB_CLIENT, getPackageVersionName()).addHeader(ApiConstants.Headers.APP_VERSION, getVersionName()).addHeader(ApiConstants.Headers.APP_BUILD_NUMBER, getVersionCode()).addHeader("Accept-Language", Locale.getDefault().getLanguage()).build());
    }

    /* renamed from: lambda$errorHandlingInterceptor$4 */
    public /* synthetic */ Response c(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        if (proceed.isSuccessful() || shouldDoAutoRefresh(request, proceed)) {
            return proceed;
        }
        if (request.url().pathSegments().contains(ApiConstants.OAuth.OAUTH)) {
            throw new CoinbaseOAuthException((OAuthError) this.gson.j(proceed.body().string(), OAuthError.class));
        }
        throw new CoinbaseException(((CoinbaseErrorResponse) this.gson.j(proceed.body().string(), CoinbaseErrorResponse.class)).getErrors());
    }

    public static /* synthetic */ Response lambda$networkSniffingInterceptor$8(Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request());
    }

    /* renamed from: lambda$onTokenRevoked$7 */
    public /* synthetic */ void d() {
        this.tokenListener.onTokenRevoked();
    }

    /* renamed from: lambda$onTokensFail$6 */
    public /* synthetic */ void e(OAuthError oAuthError) {
        this.tokenListener.onRefreshFailed(new CoinbaseOAuthException(oAuthError));
    }

    /* renamed from: lambda$onTokensReceived$5 */
    public /* synthetic */ void f(AccessToken accessToken) {
        this.tokenListener.onNewTokensAvailable(accessToken);
    }

    /* renamed from: lambda$saveAuthTokensInterceptor$2 */
    public /* synthetic */ Response g(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        String encodedPath = request.url().encodedPath();
        if (encodedPath.startsWith(ApiConstants.OAuth.TOKEN)) {
            j.h source = proceed.body().source();
            source.request(Long.MAX_VALUE);
            String G0 = source.i().clone().G0();
            if (proceed.isSuccessful()) {
                onTokensReceived(G0);
            } else {
                onTokensFail(G0);
            }
        }
        if (encodedPath.startsWith(ApiConstants.OAuth.REVOKE) && proceed.isSuccessful()) {
            onTokenRevoked();
        }
        return proceed;
    }

    /* renamed from: lambda$tokenRefreshInterceptor$3 */
    public /* synthetic */ Response h(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        Response proceed = chain.proceed(request);
        if (shouldDoAutoRefresh(request, proceed)) {
            String str = this.refreshToken;
            doRefreshToken(str);
            if (!TextUtils.isEmpty(this.refreshToken) && !this.refreshToken.equals(str)) {
                insertAccessToken(newBuilder);
                proceed.close();
                return chain.proceed(newBuilder.build());
            }
        }
        return proceed;
    }

    private void onTokenRevoked() {
        if (this.tokenListener != null) {
            this.uiHandler.post(new Runnable() { // from class: com.coinbase.f
                @Override // java.lang.Runnable
                public final void run() {
                    Coinbase.this.d();
                }
            });
        }
        clearAuthInfo();
    }

    private void onTokensFail(String str) {
        if (this.tokenListener != null) {
            final OAuthError oAuthError = (OAuthError) this.gson.j(str, OAuthError.class);
            this.uiHandler.post(new Runnable() { // from class: com.coinbase.g
                @Override // java.lang.Runnable
                public final void run() {
                    Coinbase.this.e(oAuthError);
                }
            });
        }
        clearAuthInfo();
    }

    private void onTokensReceived(String str) {
        final AccessToken accessToken = (AccessToken) this.gson.j(str, AccessToken.class);
        this.accessToken = accessToken.getAccessToken();
        if (this.autorefresh) {
            this.refreshToken = accessToken.getRefreshToken();
            if (this.tokenListener != null) {
                this.uiHandler.post(new Runnable() { // from class: com.coinbase.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        Coinbase.this.f(accessToken);
                    }
                });
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    private void setCsrfToken(String str) {
        this.context.getSharedPreferences(PREFS_NAME, 0).edit().putString(KEY_LOGIN_CSRF_TOKEN, str).commit();
    }

    private boolean shouldDoAutoRefresh(Request request, Response response) {
        return this.autorefresh && response.code() == 401 && !request.url().pathSegments().contains(ApiConstants.OAuth.OAUTH) && !TextUtils.isEmpty(this.refreshToken);
    }

    protected Interceptor authHeaderInterceptor() {
        return new Interceptor() { // from class: com.coinbase.e
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return Coinbase.this.a(chain);
            }
        };
    }

    public void beginAuthorization(Context context, Uri uri, String... strArr) {
        beginAuthorization(context, new AuthorizationRequest(uri, strArr));
    }

    public Uri buildAuthorizationUri(AuthorizationRequest authorizationRequest) {
        checkClientIdAndSecret();
        setCsrfToken(null);
        return authorizationRequest.getAuthorizationUri(this.baseOAuthUrl, this.clientId).buildUpon().appendQueryParameter(ApiConstants.STATE, getCsrfToken()).build();
    }

    protected Interceptor clientInfoInterceptor() {
        return new Interceptor() { // from class: com.coinbase.k
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return Coinbase.this.b(chain);
            }
        };
    }

    public ApiCall<AccessToken> completeAuthorization(Intent intent) {
        return getAuthResource().getTokens(this.clientId, this.clientSecret, getAuthCode(intent), getRedirectUrl(intent));
    }

    public b0<AccessToken> completeAuthorizationRx(Intent intent) {
        return getAuthResource().getTokensRx(this.clientId, this.clientSecret, getAuthCode(intent), getRedirectUrl(intent));
    }

    public ApiCall<AccessToken> completeAuthorizationWithRedirectAndCode(String str, String str2) {
        return getAuthResource().getTokens(this.clientId, this.clientSecret, str2, str);
    }

    public b0<AccessToken> completeAuthorizationWithRedirectAndCodeRx(String str, String str2) {
        return getAuthResource().getTokensRx(this.clientId, this.clientSecret, str2, str);
    }

    protected Interceptor errorHandlingInterceptor() {
        return new Interceptor() { // from class: com.coinbase.d
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return Coinbase.this.c(chain);
            }
        };
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public AccountResource getAccountResource() {
        if (this.accountResource == null) {
            this.accountResource = (AccountResource) initResource(new h.c.m0.c() { // from class: com.coinbase.b
                @Override // h.c.m0.c
                public final Object apply(Object obj, Object obj2) {
                    return new AccountResource((AccountsApi) obj, (AccountsApiRx) obj2);
                }
            }, AccountsApi.class, AccountsApiRx.class);
        }
        return this.accountResource;
    }

    public AddressResource getAddressResource() {
        if (this.addressResource == null) {
            this.addressResource = (AddressResource) initResource(new h.c.m0.c() { // from class: com.coinbase.m
                @Override // h.c.m0.c
                public final Object apply(Object obj, Object obj2) {
                    return new AddressResource((AddressesApi) obj, (AddressesApiRx) obj2);
                }
            }, AddressesApi.class, AddressesApiRx.class);
        }
        return this.addressResource;
    }

    protected String getApiVersionCode() {
        String str = this.apiVersionCode;
        return str == null ? ApiConstants.VERSION : str;
    }

    public String getAuthCodeFromUri(Uri uri) {
        String queryParameter = uri.getQueryParameter("code");
        if (queryParameter == null) {
            String queryParameter2 = uri.getQueryParameter("error_description");
            if (queryParameter2 == null) {
                queryParameter2 = "Invalid auth code!";
            }
            throw new IllegalArgumentException(queryParameter2);
        }
        return queryParameter;
    }

    public AuthResource getAuthResource() {
        if (this.authResource == null) {
            this.authResource = (AuthResource) initResource(new h.c.m0.c() { // from class: com.coinbase.t
                @Override // h.c.m0.c
                public final Object apply(Object obj, Object obj2) {
                    return new AuthResource((AuthApi) obj, (AuthApiRx) obj2);
                }
            }, AuthApi.class, AuthApiRx.class);
        }
        return this.authResource;
    }

    public BuysResource getBuysResource() {
        if (this.buysResource == null) {
            this.buysResource = (BuysResource) initResource(new h.c.m0.c() { // from class: com.coinbase.w
                @Override // h.c.m0.c
                public final Object apply(Object obj, Object obj2) {
                    return new BuysResource((TradesApi) obj, (TradesApiRx) obj2);
                }
            }, TradesApi.class, TradesApiRx.class);
        }
        return this.buysResource;
    }

    synchronized String getCsrfToken() {
        String string;
        string = this.context.getSharedPreferences(PREFS_NAME, 0).getString(KEY_LOGIN_CSRF_TOKEN, null);
        if (string == null) {
            string = Integer.toHexString(new SecureRandom().nextInt());
            setCsrfToken(string);
        }
        return string;
    }

    public CurrenciesResource getCurrenciesResource() {
        if (this.currenciesResource == null) {
            this.currenciesResource = (CurrenciesResource) initResource(new h.c.m0.c() { // from class: com.coinbase.o
                @Override // h.c.m0.c
                public final Object apply(Object obj, Object obj2) {
                    return new CurrenciesResource((CurrenciesApi) obj, (CurrenciesApiRx) obj2);
                }
            }, CurrenciesApi.class, CurrenciesApiRx.class);
        }
        return this.currenciesResource;
    }

    public DepositsResource getDepositsResource() {
        if (this.depositsResource == null) {
            this.depositsResource = (DepositsResource) initResource(new h.c.m0.c() { // from class: com.coinbase.u
                @Override // h.c.m0.c
                public final Object apply(Object obj, Object obj2) {
                    return new DepositsResource((TradesApi) obj, (TradesApiRx) obj2);
                }
            }, TradesApi.class, TradesApiRx.class);
        }
        return this.depositsResource;
    }

    public ExchangeRatesResource getExchangeRatesResource() {
        if (this.exchangeRatesResource == null) {
            this.exchangeRatesResource = (ExchangeRatesResource) initResource(new h.c.m0.c() { // from class: com.coinbase.n
                @Override // h.c.m0.c
                public final Object apply(Object obj, Object obj2) {
                    return new ExchangeRatesResource((ExchangeRatesApi) obj, (ExchangeRatesApiRx) obj2);
                }
            }, ExchangeRatesApi.class, ExchangeRatesApiRx.class);
        }
        return this.exchangeRatesResource;
    }

    public URL getOauthUrl() {
        return this.baseOAuthUrl;
    }

    public OkHttpClient getOkHttpClient() {
        OkHttpClient okHttpClient = this.okHttpClient;
        if (okHttpClient != null) {
            return okHttpClient;
        }
        OkHttpClient build = generateClientBuilder(this.sslContext, this.trustManager, this.skipCertPinning).cache(this.diskCache).build();
        this.okHttpClient = build;
        return build;
    }

    public String getPackageVersionName() {
        return this.context.getPackageName() + "/" + (getVersionName() + "/" + getVersionCode());
    }

    public PaymentMethodResource getPaymentMethodResource() {
        if (this.paymentMethodResource == null) {
            this.paymentMethodResource = (PaymentMethodResource) initResource(new h.c.m0.c() { // from class: com.coinbase.a
                @Override // h.c.m0.c
                public final Object apply(Object obj, Object obj2) {
                    return new PaymentMethodResource((PaymentMethodsApi) obj, (PaymentMethodsApiRx) obj2);
                }
            }, PaymentMethodsApi.class, PaymentMethodsApiRx.class);
        }
        return this.paymentMethodResource;
    }

    public PricesResource getPricesResource() {
        if (this.pricesResource == null) {
            this.pricesResource = (PricesResource) initResource(new h.c.m0.c() { // from class: com.coinbase.s
                @Override // h.c.m0.c
                public final Object apply(Object obj, Object obj2) {
                    return new PricesResource((PricesApi) obj, (PricesApiRx) obj2);
                }
            }, PricesApi.class, PricesApiRx.class);
        }
        return this.pricesResource;
    }

    public String getRedirectUrlFromUri(Uri uri) {
        String queryParameter = uri.getQueryParameter(ApiConstants.STATE);
        if (queryParameter != null && queryParameter.equals(getCsrfToken())) {
            return uri.buildUpon().clearQuery().build().toString();
        }
        throw new IllegalArgumentException("CSRF Detected!");
    }

    public retrofit2.t getRetrofit() {
        retrofit2.adapter.rxjava2.g b2;
        retrofit2.t tVar = this.retrofit;
        if (tVar != null) {
            return tVar;
        }
        t.b a = new t.b().c(this.baseApiUrl.toString()).g(getOkHttpClient()).a(ApiCallAdapterFactory.create());
        a0 a0Var = this.backgroundScheduler;
        if (a0Var == null) {
            b2 = retrofit2.adapter.rxjava2.g.a();
        } else {
            b2 = retrofit2.adapter.rxjava2.g.b(a0Var);
        }
        retrofit2.t e2 = a.a(b2).b(retrofit2.y.a.a.a(this.gson)).e();
        this.retrofit = e2;
        return e2;
    }

    public SellsResource getSellsResource() {
        if (this.sellsResource == null) {
            this.sellsResource = (SellsResource) initResource(new h.c.m0.c() { // from class: com.coinbase.c
                @Override // h.c.m0.c
                public final Object apply(Object obj, Object obj2) {
                    return new SellsResource((TradesApi) obj, (TradesApiRx) obj2);
                }
            }, TradesApi.class, TradesApiRx.class);
        }
        return this.sellsResource;
    }

    public TimeResource getTimeResource() {
        if (this.timeResource == null) {
            this.timeResource = (TimeResource) initResource(new h.c.m0.c() { // from class: com.coinbase.q
                @Override // h.c.m0.c
                public final Object apply(Object obj, Object obj2) {
                    return new TimeResource((TimeApi) obj, (TimeApiRx) obj2);
                }
            }, TimeApi.class, TimeApiRx.class);
        }
        return this.timeResource;
    }

    public TransactionsResource getTransactionsResource() {
        if (this.transactionsResource == null) {
            this.transactionsResource = (TransactionsResource) initResource(new h.c.m0.c() { // from class: com.coinbase.v
                @Override // h.c.m0.c
                public final Object apply(Object obj, Object obj2) {
                    return new TransactionsResource((TransactionsApi) obj, (TransactionsApiRx) obj2);
                }
            }, TransactionsApi.class, TransactionsApiRx.class);
        }
        return this.transactionsResource;
    }

    public UserResource getUserResource() {
        if (this.userResource == null) {
            this.userResource = (UserResource) initResource(new h.c.m0.c() { // from class: com.coinbase.r
                @Override // h.c.m0.c
                public final Object apply(Object obj, Object obj2) {
                    return new UserResource((UsersApi) obj, (UsersApiRx) obj2);
                }
            }, UsersApi.class, UsersApiRx.class);
        }
        return this.userResource;
    }

    protected String getVersionCode() {
        return this.clientVersion;
    }

    protected String getVersionName() {
        return this.clientName;
    }

    public WithdrawalsResource getWithdrawalsResource() {
        if (this.withdrawalResource == null) {
            this.withdrawalResource = (WithdrawalsResource) initResource(new h.c.m0.c() { // from class: com.coinbase.p
                @Override // h.c.m0.c
                public final Object apply(Object obj, Object obj2) {
                    return new WithdrawalsResource((TradesApi) obj, (TradesApiRx) obj2);
                }
            }, TradesApi.class, TradesApiRx.class);
        }
        return this.withdrawalResource;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <R, T, Trx> R initResource(h.c.m0.c<T, Trx, R> cVar, Class<T> cls, Class<Trx> cls2) {
        try {
            retrofit2.t retrofit = getRetrofit();
            return (R) cVar.apply(retrofit.c(cls), retrofit.c(cls2));
        } catch (Exception e2) {
            Log.e(getClass().getSimpleName(), "Could not instantiate resource", e2);
            throw new IllegalArgumentException(e2);
        }
    }

    public boolean isAuthorized() {
        return (this.accessToken == null && this.refreshToken == null) ? false : true;
    }

    protected Interceptor loggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(this.loggingLevel);
    }

    public void logout() {
        clearAuthInfo();
    }

    protected Interceptor networkSniffingInterceptor() {
        return new Interceptor() { // from class: com.coinbase.h
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return Coinbase.lambda$networkSniffingInterceptor$8(chain);
            }
        };
    }

    protected Interceptor saveAuthTokensInterceptor() {
        return new Interceptor() { // from class: com.coinbase.l
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return Coinbase.this.g(chain);
            }
        };
    }

    public void setAccessToken(String str) {
        if (this.autorefresh && TextUtils.isEmpty(this.refreshToken)) {
            throw new IllegalStateException("Providing access token without refresh token with auto-refresh enabled might cause auto-refresh fails. Please disable auto-refreshor provide auto-refresh token first.");
        }
        this.accessToken = str;
    }

    public void setAutorefrashedEnabled(boolean z) {
        this.autorefresh = z;
    }

    public void setClientIdAndSecret(String str, String str2) {
        if (!str.equals(this.clientId)) {
            clearAuthInfo();
        }
        this.clientId = str;
        this.clientSecret = str2;
    }

    public void setNetworkingExecutor(ExecutorService executorService) {
        this.httpExecutorService = executorService;
        this.backgroundScheduler = h.c.u0.a.b(executorService);
    }

    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    public void setRefreshTokenListener(TokenListener tokenListener) {
        this.tokenListener = tokenListener;
    }

    protected Interceptor tokenRefreshInterceptor() {
        return new Interceptor() { // from class: com.coinbase.i
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return Coinbase.this.h(chain);
            }
        };
    }

    public void beginAuthorization(Context context, AuthorizationRequest authorizationRequest) {
        context.startActivity(new Intent("android.intent.action.VIEW").setData(buildAuthorizationUri(authorizationRequest)));
    }

    public Coinbase(CoinbaseBuilder coinbaseBuilder) {
        this.cryptoAddressNames = new HashSet();
        this.cryptoNetworkNames = new HashSet();
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.NONE;
        this.loggingLevel = level;
        this.additionalInterceptors = Collections.emptyList();
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.apiVersionCode = null;
        this.context = coinbaseBuilder.context;
        this.baseOAuthUrl = coinbaseBuilder.baseOauthUrl;
        this.clientId = coinbaseBuilder.clientId;
        this.clientSecret = coinbaseBuilder.clientSecret;
        String str = coinbaseBuilder.clientVersion;
        if (str != null) {
            this.clientVersion = str;
            String str2 = coinbaseBuilder.clientName;
            if (str2 != null) {
                this.clientName = str2;
                this.accessToken = coinbaseBuilder.accessToken;
                this.refreshToken = coinbaseBuilder.refreshToken;
                this.clientSecret = coinbaseBuilder.clientSecret;
                this.clientId = coinbaseBuilder.clientId;
                this.tokenListener = coinbaseBuilder.tokenListener;
                this.autorefresh = coinbaseBuilder.autorefresh;
                this.apiVersionCode = coinbaseBuilder.apiVersionCode;
                this.sslContext = coinbaseBuilder.sslContext;
                this.trustManager = coinbaseBuilder.trustManager;
                this.skipCertPinning = coinbaseBuilder.skipCertPinning;
                this.baseApiUrl = coinbaseBuilder.baseApiUrl;
                this.cryptoAddressNames.addAll(coinbaseBuilder.cryptoAddressNames);
                this.cryptoNetworkNames.addAll(coinbaseBuilder.cryptoNetworkNames);
                int i2 = coinbaseBuilder.cacheSize;
                this.diskCache = new Cache(this.context.getCacheDir(), i2 > 0 ? i2 : 5242880L);
                ExecutorService executorService = coinbaseBuilder.httpExecutorService;
                this.httpExecutorService = executorService;
                this.backgroundScheduler = executorService == null ? h.c.u0.a.c() : h.c.u0.a.b(executorService);
                HttpLoggingInterceptor.Level level2 = coinbaseBuilder.loggingLevel;
                this.loggingLevel = level2 != null ? level2 : level;
                this.additionalInterceptors = coinbaseBuilder.additionalInterceptors;
                try {
                    if (this.baseOAuthUrl == null) {
                        this.baseOAuthUrl = new URL(OAUTH_URL);
                    }
                    if (this.baseApiUrl == null) {
                        this.baseApiUrl = new URL(BASE_API_URL);
                    }
                    if (this.sslContext == null) {
                        this.sslContext = CoinbaseSSL.getSSLContext();
                    }
                    if (this.trustManager == null) {
                        this.trustManager = CoinbaseSSL.getTrustManager();
                    }
                    this.gson = createGson();
                    return;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            throw new IllegalArgumentException("clientName must not be null");
        }
        throw new IllegalArgumentException("clientVersion must not be null");
    }
}