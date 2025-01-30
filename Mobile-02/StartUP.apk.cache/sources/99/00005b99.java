package okhttp3.logging;

import com.coinbase.ApiConstants;
import j.f;
import j.h;
import j.n;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.a0.s0;
import kotlin.a0.w;
import kotlin.io.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.h0;
import kotlin.jvm.internal.m;
import kotlin.l0.x;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import org.apache.http.message.TokenParser;
import org.apache.http.protocol.HTTP;

/* compiled from: HttpLoggingInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002'(B\u0013\b\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b%\u0010&J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R*\u0010\u0011\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00108\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010#\u001a\u0004\b\u0016\u0010\u0015\"\u0004\b\u0011\u0010$¨\u0006)"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Headers;", "headers", "", "i", "Lkotlin/x;", "logHeader", "(Lokhttp3/Headers;I)V", "", "bodyHasUnknownEncoding", "(Lokhttp3/Headers;)Z", "", ApiConstants.NAME, "redactHeader", "(Ljava/lang/String;)V", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", "setLevel", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)Lokhttp3/logging/HttpLoggingInterceptor;", "-deprecated_level", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "getLevel", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "headersToRedact", "Ljava/util/Set;", "<set-?>", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "Level", "Logger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    /* compiled from: HttpLoggingInterceptor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* compiled from: HttpLoggingInterceptor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "", ApiConstants.MESSAGE, "Lkotlin/x;", "log", "(Ljava/lang/String;)V", "Companion", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public interface Logger {
        public static final Companion Companion = new Companion(null);
        public static final Logger DEFAULT = new Logger() { // from class: okhttp3.logging.HttpLoggingInterceptor$Logger$Companion$DEFAULT$1
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public void log(String message) {
                m.h(message, "message");
                Platform.log$default(Platform.Companion.get(), message, 0, null, 6, null);
            }
        };

        /* compiled from: HttpLoggingInterceptor.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001\u0082\u0002\u0007\n\u0005\b\u0091F0\u0001¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion;", "", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "DEFAULT", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "<init>", "()V", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes3.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(null, 1, null);
    }

    public HttpLoggingInterceptor(Logger logger) {
        Set<String> b2;
        m.h(logger, "logger");
        this.logger = logger;
        b2 = s0.b();
        this.headersToRedact = b2;
        this.level = Level.NONE;
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        boolean A;
        boolean A2;
        String str = headers.get("Content-Encoding");
        if (str != null) {
            A = x.A(str, HTTP.IDENTITY_CODING, true);
            if (A) {
                return false;
            }
            A2 = x.A(str, "gzip", true);
            return !A2;
        }
        return false;
    }

    private final void logHeader(Headers headers, int i2) {
        String value = this.headersToRedact.contains(headers.name(i2)) ? "██" : headers.value(i2);
        Logger logger = this.logger;
        logger.log(headers.name(i2) + ": " + value);
    }

    /* renamed from: -deprecated_level  reason: not valid java name */
    public final Level m2356deprecated_level() {
        return this.level;
    }

    public final Level getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        char c2;
        String sb;
        boolean A;
        Charset UTF_8;
        Charset UTF_82;
        m.h(chain, "chain");
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z = level == Level.BODY;
        boolean z2 = z || level == Level.HEADERS;
        RequestBody body = request.body();
        Connection connection = chain.connection();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--> ");
        sb2.append(request.method());
        sb2.append(TokenParser.SP);
        sb2.append(request.url());
        sb2.append(connection != null ? " " + connection.protocol() : "");
        String sb3 = sb2.toString();
        if (!z2 && body != 0) {
            sb3 = sb3 + " (" + body.contentLength() + "-byte body)";
        }
        this.logger.log(sb3);
        if (z2) {
            Headers headers = request.headers();
            if (body != null) {
                MediaType contentType = body.contentType();
                if (contentType != null && headers.get("Content-Type") == null) {
                    this.logger.log("Content-Type: " + contentType);
                }
                if (body.contentLength() != -1 && headers.get("Content-Length") == null) {
                    this.logger.log("Content-Length: " + body.contentLength());
                }
            }
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                logHeader(headers, i2);
            }
            if (z && body != null) {
                if (bodyHasUnknownEncoding(request.headers())) {
                    this.logger.log("--> END " + request.method() + " (encoded body omitted)");
                } else if (body.isDuplex()) {
                    this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
                } else if (body.isOneShot()) {
                    this.logger.log("--> END " + request.method() + " (one-shot body omitted)");
                } else {
                    f fVar = new f();
                    body.writeTo(fVar);
                    MediaType contentType2 = body.contentType();
                    if (contentType2 == null || (UTF_82 = contentType2.charset(StandardCharsets.UTF_8)) == null) {
                        UTF_82 = StandardCharsets.UTF_8;
                        m.d(UTF_82, "UTF_8");
                    }
                    this.logger.log("");
                    if (Utf8Kt.isProbablyUtf8(fVar)) {
                        this.logger.log(fVar.l0(UTF_82));
                        this.logger.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                    } else {
                        this.logger.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                    }
                }
            } else {
                this.logger.log("--> END " + request.method());
            }
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            if (body2 == null) {
                m.q();
            }
            long contentLength = body2.contentLength();
            String str2 = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            Logger logger = this.logger;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("<-- ");
            sb4.append(proceed.code());
            if (proceed.message().length() == 0) {
                str = "-byte body omitted)";
                sb = "";
                c2 = TokenParser.SP;
            } else {
                String message = proceed.message();
                StringBuilder sb5 = new StringBuilder();
                str = "-byte body omitted)";
                c2 = TokenParser.SP;
                sb5.append(String.valueOf((char) TokenParser.SP));
                sb5.append(message);
                sb = sb5.toString();
            }
            sb4.append(sb);
            sb4.append(c2);
            sb4.append(proceed.request().url());
            sb4.append(" (");
            sb4.append(millis);
            sb4.append("ms");
            sb4.append(z2 ? "" : ", " + str2 + " body");
            sb4.append(')');
            logger.log(sb4.toString());
            if (z2) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    logHeader(headers2, i3);
                }
                if (z && HttpHeaders.promisesBody(proceed)) {
                    if (bodyHasUnknownEncoding(proceed.headers())) {
                        this.logger.log("<-- END HTTP (encoded body omitted)");
                    } else {
                        h source = body2.source();
                        source.request(Long.MAX_VALUE);
                        f buffer = source.getBuffer();
                        A = x.A("gzip", headers2.get("Content-Encoding"), true);
                        Long l2 = null;
                        if (A) {
                            Long valueOf = Long.valueOf(buffer.O0());
                            n nVar = new n(buffer.clone());
                            try {
                                buffer = new f();
                                buffer.t0(nVar);
                                a.a(nVar, null);
                                l2 = valueOf;
                            } finally {
                            }
                        }
                        MediaType contentType3 = body2.contentType();
                        if (contentType3 == null || (UTF_8 = contentType3.charset(StandardCharsets.UTF_8)) == null) {
                            UTF_8 = StandardCharsets.UTF_8;
                            m.d(UTF_8, "UTF_8");
                        }
                        if (!Utf8Kt.isProbablyUtf8(buffer)) {
                            this.logger.log("");
                            this.logger.log("<-- END HTTP (binary " + buffer.O0() + str);
                            return proceed;
                        }
                        if (contentLength != 0) {
                            this.logger.log("");
                            this.logger.log(buffer.clone().l0(UTF_8));
                        }
                        if (l2 != null) {
                            this.logger.log("<-- END HTTP (" + buffer.O0() + "-byte, " + l2 + "-gzipped-byte body)");
                        } else {
                            this.logger.log("<-- END HTTP (" + buffer.O0() + "-byte body)");
                        }
                    }
                } else {
                    this.logger.log("<-- END HTTP");
                }
            }
            return proceed;
        } catch (Exception e2) {
            this.logger.log("<-- HTTP FAILED: " + e2);
            throw e2;
        }
    }

    public final void level(Level level) {
        m.h(level, "<set-?>");
        this.level = level;
    }

    public final void redactHeader(String name) {
        Comparator<String> C;
        m.h(name, "name");
        C = x.C(h0.a);
        TreeSet treeSet = new TreeSet(C);
        w.y(treeSet, this.headersToRedact);
        treeSet.add(name);
        this.headersToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level) {
        m.h(level, "level");
        this.level = level;
        return this;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Logger.DEFAULT : logger);
    }
}