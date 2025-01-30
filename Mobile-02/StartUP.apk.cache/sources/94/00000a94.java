package com.coinbase;

import android.content.Context;
import com.coinbase.Coinbase;
import com.coinbase.CoinbaseBuilder;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;

/* loaded from: classes.dex */
public class CoinbaseBuilder<T extends CoinbaseBuilder<T>> {
    String accessToken;
    boolean autorefresh;
    URL baseApiUrl;
    URL baseOauthUrl;
    int cacheSize;
    String clientId;
    String clientName;
    String clientSecret;
    String clientVersion;
    final Context context;
    ExecutorService httpExecutorService;
    HttpLoggingInterceptor.Level loggingLevel;
    String refreshToken;
    boolean skipCertPinning;
    SSLContext sslContext;
    Coinbase.TokenListener tokenListener;
    X509TrustManager trustManager;
    List<Interceptor> additionalInterceptors = Collections.emptyList();
    String apiVersionCode = ApiConstants.VERSION;
    Set<String> cryptoAddressNames = new HashSet();
    Set<String> cryptoNetworkNames = new HashSet();

    protected CoinbaseBuilder(Context context) {
        this.context = context;
    }

    public static CoinbaseBuilder withAccessToken(Context context, String str, String str2, String str3) {
        return withClientIdAndSecret(context, str, str2).accessToken(str3);
    }

    public static CoinbaseBuilder withClientIdAndSecret(Context context, String str, String str2) {
        return new CoinbaseBuilder(context).clientIdAndSecret(str, str2);
    }

    public static CoinbaseBuilder withPublicDataAccess(Context context) {
        return new CoinbaseBuilder(context);
    }

    public static CoinbaseBuilder withTokenAutoRefresh(Context context, String str, String str2) {
        return withTokenAutoRefresh(context, str, str2, null, null, null);
    }

    protected T accessToken(String str) {
        this.accessToken = str;
        return getThis();
    }

    protected T apiVersionCode(String str) {
        this.apiVersionCode = str;
        return getThis();
    }

    public Coinbase build() {
        return new Coinbase(this);
    }

    public T cacheSize(int i2) {
        this.cacheSize = i2;
        return getThis();
    }

    protected T clientIdAndSecret(String str, String str2) {
        this.clientId = str;
        this.clientSecret = str2;
        return getThis();
    }

    protected T getThis() {
        return this;
    }

    protected T refreshToken(String str) {
        this.refreshToken = str;
        return getThis();
    }

    protected T tokenListener(Coinbase.TokenListener tokenListener) {
        this.tokenListener = tokenListener;
        return getThis();
    }

    public CoinbaseBuilder withAdditionalInterceptors(List<Interceptor> list) {
        this.additionalInterceptors = list;
        return getThis();
    }

    public T withBaseApiURL(URL url) {
        this.baseApiUrl = url;
        return getThis();
    }

    public T withBaseOAuthURL(URL url) {
        this.baseOauthUrl = url;
        return getThis();
    }

    public CoinbaseBuilder withClientName(String str) {
        this.clientName = str;
        return getThis();
    }

    public CoinbaseBuilder withClientVersion(String str) {
        this.clientVersion = str;
        return getThis();
    }

    public CoinbaseBuilder withCryptCurrencyAddressNames(String... strArr) {
        this.cryptoAddressNames.addAll(Arrays.asList(strArr));
        return getThis();
    }

    public T withCryptoNetworkNames(String... strArr) {
        this.cryptoNetworkNames.addAll(Arrays.asList(strArr));
        return getThis();
    }

    public T withHttpExecutorService(ExecutorService executorService) {
        this.httpExecutorService = executorService;
        return getThis();
    }

    public CoinbaseBuilder withLoggingLevel(HttpLoggingInterceptor.Level level) {
        this.loggingLevel = level;
        return getThis();
    }

    public T withSSLContext(SSLContext sSLContext) {
        this.sslContext = sSLContext;
        return getThis();
    }

    public T withSkipCertPinning(boolean z) {
        this.skipCertPinning = z;
        return getThis();
    }

    public static CoinbaseBuilder withTokenAutoRefresh(Context context, String str, String str2, String str3, String str4, Coinbase.TokenListener tokenListener) {
        CoinbaseBuilder coinbaseBuilder = withAccessToken(context, str, str2, str3).refreshToken(str4).tokenListener(tokenListener);
        coinbaseBuilder.autorefresh = true;
        return coinbaseBuilder;
    }
}