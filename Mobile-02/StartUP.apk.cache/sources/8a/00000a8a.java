package com.coinbase;

/* loaded from: classes.dex */
public interface ApiConstants {
    public static final String ABOVE = "above";
    public static final String ACCESS_TOKEN = "oauth/token";
    public static final String ACCOUNTS = "accounts";
    public static final String ADDRESSES = "addresses";
    public static final String AMOUNT = "amount";
    public static final String AUTHORIZATION_CODE = "authorization_code";
    public static final String AUTHORIZE = "authorize";
    public static final String AUTH_CODE = "oauth/authorize/with-credentials";
    public static final String BASE_URL_PRODUCTION = "https://api.coinbase.com";
    public static final String BUY = "buy";
    public static final String BUYS = "buys";
    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_PLATFORM = "mobile";
    public static final String CLIENT_SECRET = "client_secret";
    public static final String COMMIT = "commit";
    public static final String COMPLETE = "complete";
    public static final String COMPLETED = "completed";
    public static final String CURRENCIES = "currencies";
    public static final String CURRENCY = "currency";
    public static final String CURRENCY_CODE = "currency_code";
    public static final String DEPOSITS = "deposits";
    public static final String DESCRIPTION = "description";
    public static final String EXCHANGE_RATES = "exchange-rates";
    public static final String FEE = "fee";
    public static final String FROM = "from";
    public static final String GRANT_TYPE = "grant_type";
    public static final String IDEM = "idem";
    public static final String INSTANT_EXCHANGE_QUOTE = "instant_exchange_quote";
    public static final String LOCALE = "locale";
    public static final String MESSAGE = "message";
    public static final String NAME = "name";
    public static final String NATIVE_CURRENCY = "native_currency";
    public static final String PATH_SEPARATOR = "/";
    public static final String PAYMENT_METHOD = "payment_method";
    public static final String PAYMENT_METHODS = "payment-methods";
    public static final String PENDING = "pending";
    public static final String PRICE = "price";
    public static final String PRICES = "prices";
    public static final String PRIMARY = "primary";
    public static final String QUOTE = "quote";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String REQUEST = "request";
    public static final String RESEND = "resend";
    public static final String SELL = "sell";
    public static final String SELLS = "sells";
    public static final String SEND = "send";
    public static final String SERVER_VERSION = "v2";
    public static final String SPOT = "spot";
    public static final String STARTING_AFTER = "starting_after";
    public static final String STATE = "state";
    public static final String TIME = "time";
    public static final String TIME_ZONE = "time_zone";
    public static final String TO = "to";
    public static final String TOKEN = "token";
    public static final String TOTAL = "total";
    public static final String TRANSACTIONS = "transactions";
    public static final String TRANSFER = "transfer";
    public static final String TWO_LEGGED = "2_legged";
    public static final String TYPE = "type";
    public static final String TZ_OFFSET = "tz_offset";
    public static final String USER = "user";
    public static final String USERS = "users";
    public static final String USER_AUTH_INFO = "user/auth";
    public static final String VERSION = "2020-08-27";
    public static final String WITHDRAWALS = "withdrawals";

    /* loaded from: classes.dex */
    public interface Headers {
        public static final String ACCEPT_LANGUAGE = "Accept-Language";
        public static final String APP_BUILD_NUMBER = "X-App-Build-Number";
        public static final String APP_VERSION = "X-App-Version";
        public static final String AUTHORIZATION = "Authorization";
        public static final String CB_2_FA_TOKEN = "CB-2FA-Token";
        public static final String CB_CLIENT = "CB-CLIENT";
        public static final String CB_VERSION = "CB-VERSION";
    }

    /* loaded from: classes.dex */
    public interface OAuth {
        public static final String OAUTH = "oauth";
        public static final String REVOKE = "/oauth/revoke";
        public static final String ROOT = "/oauth/";
        public static final String TOKEN = "/oauth/token";
    }
}