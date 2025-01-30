package okhttp3;

import com.coinbase.ApiConstants;
import j.f;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.a0.r;
import kotlin.a0.s0;
import kotlin.i0.a;
import kotlin.i0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.k;
import kotlin.l0.x;
import kotlin.l0.y;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.http.HttpHost;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.message.TokenParser;
import org.spongycastle.math.Primes;

/* compiled from: HttpUrl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\"\n\u0002\b\u0013\u0018\u0000 W2\u00020\u0001:\u0002XWBc\b\u0000\u0012\u0006\u0010*\u001a\u00020\n\u0012\u0006\u0010.\u001a\u00020\n\u0012\u0006\u00102\u001a\u00020\n\u0012\u0006\u00104\u001a\u00020\n\u0012\u0006\u00106\u001a\u00020\u0011\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0\u000e\u0012\u0010\u0010T\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000e\u0012\b\u0010M\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\bU\u0010VJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000e2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0011H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\nH\u0016¢\u0006\u0004\b%\u0010\u0017J\u000f\u0010&\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b&\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b(\u0010\bJ\u000f\u0010*\u001a\u00020\nH\u0007¢\u0006\u0004\b)\u0010\u0017J\u000f\u0010,\u001a\u00020\nH\u0007¢\u0006\u0004\b+\u0010\u0017J\u000f\u0010.\u001a\u00020\nH\u0007¢\u0006\u0004\b-\u0010\u0017J\u000f\u00100\u001a\u00020\nH\u0007¢\u0006\u0004\b/\u0010\u0017J\u000f\u00102\u001a\u00020\nH\u0007¢\u0006\u0004\b1\u0010\u0017J\u000f\u00104\u001a\u00020\nH\u0007¢\u0006\u0004\b3\u0010\u0017J\u000f\u00106\u001a\u00020\u0011H\u0007¢\u0006\u0004\b5\u0010$J\u000f\u00108\u001a\u00020\u0011H\u0007¢\u0006\u0004\b7\u0010$J\u000f\u0010:\u001a\u00020\nH\u0007¢\u0006\u0004\b9\u0010\u0017J\u0015\u0010=\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0004\b;\u0010<J\u0015\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0004\b>\u0010<J\u0011\u0010A\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b@\u0010\u0017J\u0011\u0010C\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\bB\u0010\u0017J\u000f\u0010E\u001a\u00020\u0011H\u0007¢\u0006\u0004\bD\u0010$J\u0015\u0010I\u001a\b\u0012\u0004\u0012\u00020\n0FH\u0007¢\u0006\u0004\bG\u0010HJ\u0011\u0010K\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\bJ\u0010\u0017J\u0011\u0010M\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\bL\u0010\u0017R\u0013\u0010E\u001a\u00020\u00118G@\u0006¢\u0006\u0006\u001a\u0004\bE\u0010$R\u0013\u00100\u001a\u00020\n8G@\u0006¢\u0006\u0006\u001a\u0004\b0\u0010\u0017R\u0019\u0010.\u001a\u00020\n8\u0007@\u0006¢\u0006\f\n\u0004\b.\u0010N\u001a\u0004\b.\u0010\u0017R\u0019\u00106\u001a\u00020\u00118\u0007@\u0006¢\u0006\f\n\u0004\b6\u0010O\u001a\u0004\b6\u0010$R\u0019\u0010=\u001a\b\u0012\u0004\u0012\u00020\n0\u000e8G@\u0006¢\u0006\u0006\u001a\u0004\b=\u0010<R\u0015\u0010K\u001a\u0004\u0018\u00010\n8G@\u0006¢\u0006\u0006\u001a\u0004\bK\u0010\u0017R\u001f\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0\u000e8\u0007@\u0006¢\u0006\f\n\u0004\b?\u0010P\u001a\u0004\b?\u0010<R\u0019\u0010*\u001a\u00020\n8\u0007@\u0006¢\u0006\f\n\u0004\b*\u0010N\u001a\u0004\b*\u0010\u0017R\u0013\u0010:\u001a\u00020\n8G@\u0006¢\u0006\u0006\u001a\u0004\b:\u0010\u0017R\u0019\u0010Q\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bQ\u0010SR\u001b\u0010M\u001a\u0004\u0018\u00010\n8\u0007@\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bM\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010NR\u0015\u0010A\u001a\u0004\u0018\u00010\n8G@\u0006¢\u0006\u0006\u001a\u0004\bA\u0010\u0017R\u0019\u0010I\u001a\b\u0012\u0004\u0012\u00020\n0F8G@\u0006¢\u0006\u0006\u001a\u0004\bI\u0010HR\u0013\u00108\u001a\u00020\u00118G@\u0006¢\u0006\u0006\u001a\u0004\b8\u0010$R\u0013\u0010,\u001a\u00020\n8G@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010\u0017R\u0019\u00102\u001a\u00020\n8\u0007@\u0006¢\u0006\f\n\u0004\b2\u0010N\u001a\u0004\b2\u0010\u0017R \u0010T\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010PR\u0019\u00104\u001a\u00020\n8\u0007@\u0006¢\u0006\f\n\u0004\b4\u0010N\u001a\u0004\b4\u0010\u0017R\u0015\u0010C\u001a\u0004\u0018\u00010\n8G@\u0006¢\u0006\u0006\u001a\u0004\bC\u0010\u0017¨\u0006Y"}, d2 = {"Lokhttp3/HttpUrl;", "", "Ljava/net/URL;", "url", "()Ljava/net/URL;", "toUrl", "Ljava/net/URI;", "uri", "()Ljava/net/URI;", "toUri", "", ApiConstants.NAME, "queryParameter", "(Ljava/lang/String;)Ljava/lang/String;", "", "queryParameterValues", "(Ljava/lang/String;)Ljava/util/List;", "", "index", "queryParameterName", "(I)Ljava/lang/String;", "queryParameterValue", "redact", "()Ljava/lang/String;", "link", "resolve", "(Ljava/lang/String;)Lokhttp3/HttpUrl;", "Lokhttp3/HttpUrl$Builder;", "newBuilder", "()Lokhttp3/HttpUrl$Builder;", "(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "topPrivateDomain", "-deprecated_url", "-deprecated_uri", "-deprecated_scheme", "scheme", "-deprecated_encodedUsername", "encodedUsername", "-deprecated_username", "username", "-deprecated_encodedPassword", "encodedPassword", "-deprecated_password", "password", "-deprecated_host", "host", "-deprecated_port", ClientCookie.PORT_ATTR, "-deprecated_pathSize", "pathSize", "-deprecated_encodedPath", "encodedPath", "-deprecated_encodedPathSegments", "()Ljava/util/List;", "encodedPathSegments", "-deprecated_pathSegments", "pathSegments", "-deprecated_encodedQuery", "encodedQuery", "-deprecated_query", "query", "-deprecated_querySize", "querySize", "", "-deprecated_queryParameterNames", "()Ljava/util/Set;", "queryParameterNames", "-deprecated_encodedFragment", "encodedFragment", "-deprecated_fragment", "fragment", "Ljava/lang/String;", "I", "Ljava/util/List;", "isHttps", "Z", "()Z", "queryNamesAndValues", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class HttpUrl {
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;
    public static final Companion Companion = new Companion(null);
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* compiled from: HttpUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0016\u0018\u0000 e2\u00020\u0001:\u0001eB\u0007¢\u0006\u0004\bd\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0005¢\u0006\u0004\b \u0010\u001eJ\u0015\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\u001eJ\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010\u001eJ\u0015\u0010#\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0005¢\u0006\u0004\b#\u0010\u001eJ\u0015\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0005¢\u0006\u0004\b'\u0010\u001eJ\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u001eJ\u0015\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0005¢\u0006\u0004\b)\u0010\u001eJ\u0015\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0005¢\u0006\u0004\b+\u0010\u001eJ\u001d\u0010-\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0005¢\u0006\u0004\b-\u0010.J\u001d\u0010/\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0005¢\u0006\u0004\b/\u0010.J\u0015\u00100\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0002¢\u0006\u0004\b0\u0010%J\u0015\u00101\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0005¢\u0006\u0004\b1\u0010\u001eJ\u0017\u00102\u001a\u00020\u00002\b\u00102\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b2\u0010\u001eJ\u0017\u00103\u001a\u00020\u00002\b\u00103\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b3\u0010\u001eJ\u001f\u00106\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b6\u00107J\u001f\u0010:\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b:\u00107J\u001f\u0010;\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b;\u00107J\u001f\u0010<\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b<\u00107J\u0015\u0010=\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0005¢\u0006\u0004\b=\u0010\u001eJ\u0015\u0010>\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u0005¢\u0006\u0004\b>\u0010\u001eJ\u0017\u0010?\u001a\u00020\u00002\b\u0010?\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b?\u0010\u001eJ\u0017\u0010@\u001a\u00020\u00002\b\u0010@\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b@\u0010\u001eJ\u000f\u0010C\u001a\u00020\u0000H\u0000¢\u0006\u0004\bA\u0010BJ\r\u0010E\u001a\u00020D¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u0005H\u0016¢\u0006\u0004\bG\u0010HJ!\u0010L\u001a\u00020\u00002\b\u0010I\u001a\u0004\u0018\u00010D2\u0006\u0010\u000f\u001a\u00020\u0005H\u0000¢\u0006\u0004\bJ\u0010KR$\u0010#\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010M\u001a\u0004\bN\u0010H\"\u0004\bO\u0010\u000eR,\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010P8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010\"\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010M\u001a\u0004\bW\u0010H\"\u0004\bX\u0010\u000eR\"\u0010 \u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010M\u001a\u0004\bY\u0010H\"\u0004\bZ\u0010\u000eR\"\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050P8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b*\u0010R\u001a\u0004\b[\u0010TR$\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010M\u001a\u0004\b\\\u0010H\"\u0004\b]\u0010\u000eR\"\u0010$\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010^\u001a\u0004\b_\u0010\u0004\"\u0004\b`\u0010aR$\u0010@\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b@\u0010M\u001a\u0004\bb\u0010H\"\u0004\bc\u0010\u000e¨\u0006f"}, d2 = {"Lokhttp3/HttpUrl$Builder;", "", "", "effectivePort", "()I", "", "pathSegments", "", "alreadyEncoded", "addPathSegments", "(Ljava/lang/String;Z)Lokhttp3/HttpUrl$Builder;", "canonicalName", "Lkotlin/x;", "removeAllCanonicalQueryParameters", "(Ljava/lang/String;)V", "input", "startPos", "limit", "resolvePath", "(Ljava/lang/String;II)V", "pos", "addTrailingSlash", "push", "(Ljava/lang/String;IIZZ)V", "isDot", "(Ljava/lang/String;)Z", "isDotDot", "pop", "()V", "scheme", "(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "username", "encodedUsername", "password", "encodedPassword", "host", ClientCookie.PORT_ATTR, "(I)Lokhttp3/HttpUrl$Builder;", "pathSegment", "addPathSegment", "encodedPathSegment", "addEncodedPathSegment", "encodedPathSegments", "addEncodedPathSegments", "index", "setPathSegment", "(ILjava/lang/String;)Lokhttp3/HttpUrl$Builder;", "setEncodedPathSegment", "removePathSegment", "encodedPath", "query", "encodedQuery", ApiConstants.NAME, "value", "addQueryParameter", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "encodedName", "encodedValue", "addEncodedQueryParameter", "setQueryParameter", "setEncodedQueryParameter", "removeAllQueryParameters", "removeAllEncodedQueryParameters", "fragment", "encodedFragment", "reencodeForUri$okhttp", "()Lokhttp3/HttpUrl$Builder;", "reencodeForUri", "Lokhttp3/HttpUrl;", "build", "()Lokhttp3/HttpUrl;", "toString", "()Ljava/lang/String;", "base", "parse$okhttp", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "parse", "Ljava/lang/String;", "getHost$okhttp", "setHost$okhttp", "", "encodedQueryNamesAndValues", "Ljava/util/List;", "getEncodedQueryNamesAndValues$okhttp", "()Ljava/util/List;", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "getEncodedPathSegments$okhttp", "getScheme$okhttp", "setScheme$okhttp", "I", "getPort$okhttp", "setPort$okhttp", "(I)V", "getEncodedFragment$okhttp", "setEncodedFragment$okhttp", "<init>", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Builder {
        public static final Companion Companion = new Companion(null);
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String host;
        private String scheme;
        private String encodedUsername = "";
        private String encodedPassword = "";
        private int port = -1;

        /* compiled from: HttpUrl.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ'\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lokhttp3/HttpUrl$Builder$Companion;", "", "", "input", "", "pos", "limit", "schemeDelimiterOffset", "(Ljava/lang/String;II)I", "slashCount", "portColonOffset", "parsePort", "INVALID_HOST", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int parsePort(String str, int i2, int i3) {
                try {
                    int parseInt = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i2, i3, "", false, false, false, false, null, 248, null));
                    if (1 <= parseInt && 65535 >= parseInt) {
                        return parseInt;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int portColonOffset(String str, int i2, int i3) {
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt == ':') {
                        return i2;
                    }
                    if (charAt == '[') {
                        do {
                            i2++;
                            if (i2 < i3) {
                            }
                        } while (str.charAt(i2) != ']');
                    }
                    i2++;
                }
                return i3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int schemeDelimiterOffset(String str, int i2, int i3) {
                if (i3 - i2 < 2) {
                    return -1;
                }
                char charAt = str.charAt(i2);
                if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                    return -1;
                }
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        return -1;
                    }
                    char charAt2 = str.charAt(i2);
                    if ('a' > charAt2 || 'z' < charAt2) {
                        if ('A' > charAt2 || 'Z' < charAt2) {
                            if ('0' > charAt2 || '9' < charAt2) {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i2;
                                    }
                                    return -1;
                                }
                            }
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int slashCount(String str, int i2, int i3) {
                int i4 = 0;
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i4++;
                    i2++;
                }
                return i4;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final int effectivePort() {
            int i2 = this.port;
            if (i2 != -1) {
                return i2;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            if (str == null) {
                m.q();
            }
            return companion.defaultPort(str);
        }

        private final boolean isDot(String str) {
            boolean A;
            if (m.c(str, ".")) {
                return true;
            }
            A = x.A(str, "%2e", true);
            return A;
        }

        private final boolean isDotDot(String str) {
            boolean A;
            boolean A2;
            boolean A3;
            if (m.c(str, "..")) {
                return true;
            }
            A = x.A(str, "%2e.", true);
            if (A) {
                return true;
            }
            A2 = x.A(str, ".%2e", true);
            if (A2) {
                return true;
            }
            A3 = x.A(str, "%2e%2e", true);
            return A3;
        }

        private final void pop() {
            List<String> list = this.encodedPathSegments;
            if ((list.remove(list.size() - 1).length() == 0) && (!this.encodedPathSegments.isEmpty())) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.encodedPathSegments.add("");
        }

        private final void push(String str, int i2, int i3, boolean z, boolean z2) {
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i2, i3, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, false, null, 240, null);
            if (isDot(canonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(canonicalize$okhttp$default)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, canonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(canonicalize$okhttp$default);
            }
            if (z) {
                this.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            if (list == null) {
                m.q();
            }
            a i2 = d.i(d.h(list.size() - 2, 0), 2);
            int i3 = i2.i();
            int k2 = i2.k();
            int l2 = i2.l();
            if (l2 >= 0) {
                if (i3 > k2) {
                    return;
                }
            } else if (i3 < k2) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                if (list2 == null) {
                    m.q();
                }
                if (m.c(str, list2.get(i3))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    if (list3 == null) {
                        m.q();
                    }
                    list3.remove(i3 + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    if (list4 == null) {
                        m.q();
                    }
                    list4.remove(i3);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    if (list5 == null) {
                        m.q();
                    }
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (i3 == k2) {
                    return;
                }
                i3 += l2;
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:11:0x0029). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void resolvePath(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                return
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = okhttp3.internal.Util.delimiterOffset(r11, r12, r6, r13)
                if (r12 >= r13) goto L36
                r0 = r3
                goto L37
            L36:
                r0 = 0
            L37:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.push(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.resolvePath(java.lang.String, int, int):void");
        }

        public final Builder addEncodedPathSegment(String encodedPathSegment) {
            m.h(encodedPathSegment, "encodedPathSegment");
            push(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String encodedPathSegments) {
            m.h(encodedPathSegments, "encodedPathSegments");
            return addPathSegments(encodedPathSegments, true);
        }

        public final Builder addEncodedQueryParameter(String encodedName, String str) {
            m.h(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            if (list == null) {
                m.q();
            }
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, Primes.SMALL_FACTOR_LIMIT, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 == null) {
                m.q();
            }
            list2.add(str != null ? Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, Primes.SMALL_FACTOR_LIMIT, null) : null);
            return this;
        }

        public final Builder addPathSegment(String pathSegment) {
            m.h(pathSegment, "pathSegment");
            push(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String pathSegments) {
            m.h(pathSegments, "pathSegments");
            return addPathSegments(pathSegments, false);
        }

        public final Builder addQueryParameter(String name, String str) {
            m.h(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            if (list == null) {
                m.q();
            }
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 == null) {
                m.q();
            }
            list2.add(str != null ? Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null) : null);
            return this;
        }

        public final HttpUrl build() {
            String str = this.scheme;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, null);
                String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, null);
                String str2 = this.host;
                if (str2 != null) {
                    int effectivePort = effectivePort();
                    List percentDecode$default = Companion.percentDecode$default(companion, this.encodedPathSegments, false, 1, null);
                    if (percentDecode$default != null) {
                        List<String> list = this.encodedQueryNamesAndValues;
                        List percentDecode = list != null ? companion.percentDecode(list, true) : null;
                        String str3 = this.encodedFragment;
                        return new HttpUrl(str, percentDecode$okhttp$default, percentDecode$okhttp$default2, str2, effectivePort, percentDecode$default, percentDecode, str3 != null ? Companion.percentDecode$okhttp$default(companion, str3, 0, 0, false, 7, null) : null, toString());
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public final Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", true, false, false, true, null, org.spongycastle.crypto.tls.CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, null) : null;
            return this;
        }

        public final Builder encodedPassword(String encodedPassword) {
            m.h(encodedPassword, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        public final Builder encodedPath(String encodedPath) {
            boolean Q;
            m.h(encodedPath, "encodedPath");
            Q = x.Q(encodedPath, "/", false, 2, null);
            if (Q) {
                resolvePath(encodedPath, 0, encodedPath.length());
                return this;
            }
            throw new IllegalArgumentException(("unexpected encodedPath: " + encodedPath).toString());
        }

        public final Builder encodedQuery(String str) {
            List<String> list;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, Primes.SMALL_FACTOR_LIMIT, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        public final Builder encodedUsername(String encodedUsername) {
            m.h(encodedUsername, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        public final Builder fragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", false, false, false, true, null, org.spongycastle.crypto.tls.CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256, null) : null;
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String host) {
            m.h(host, "host");
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, host, 0, 0, false, 7, null));
            if (canonicalHost != null) {
                this.host = canonicalHost;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + host);
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String input) {
            int delimiterOffset;
            int i2;
            int i3;
            String str;
            boolean z;
            int i4;
            String str2;
            int i5;
            boolean z2;
            boolean z3;
            boolean N;
            boolean N2;
            m.h(input, "input");
            int indexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(input, 0, 0, 3, null);
            int indexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(input, indexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            Companion companion = Companion;
            int schemeDelimiterOffset = companion.schemeDelimiterOffset(input, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            String str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            char c2 = 65535;
            boolean z4 = true;
            if (schemeDelimiterOffset != -1) {
                N = x.N(input, "https:", indexOfFirstNonAsciiWhitespace$default, true);
                if (N) {
                    this.scheme = "https";
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else {
                    N2 = x.N(input, "http:", indexOfFirstNonAsciiWhitespace$default, true);
                    if (N2) {
                        this.scheme = HttpHost.DEFAULT_SCHEME_NAME;
                        indexOfFirstNonAsciiWhitespace$default += 5;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        String substring = input.substring(0, schemeDelimiterOffset);
                        m.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sb.append(substring);
                        sb.append("'");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            } else if (httpUrl != null) {
                this.scheme = httpUrl.scheme();
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int slashCount = companion.slashCount(input, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c3 = '?';
            char c4 = '#';
            if (slashCount < 2 && httpUrl != null && !(!m.c(httpUrl.scheme(), this.scheme))) {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || input.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i2 = indexOfLastNonAsciiWhitespace$default;
            } else {
                int i6 = indexOfFirstNonAsciiWhitespace$default + slashCount;
                boolean z5 = false;
                boolean z6 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(input, "@/\\?#", i6, indexOfLastNonAsciiWhitespace$default);
                    char charAt = delimiterOffset != indexOfLastNonAsciiWhitespace$default ? input.charAt(delimiterOffset) : c2;
                    if (charAt == c2 || charAt == c4 || charAt == '/' || charAt == '\\' || charAt == c3) {
                        break;
                    }
                    if (charAt != '@') {
                        z = z4;
                        str2 = str3;
                        i4 = indexOfLastNonAsciiWhitespace$default;
                    } else {
                        if (!z5) {
                            int delimiterOffset2 = Util.delimiterOffset(input, ':', i6, delimiterOffset);
                            Companion companion2 = HttpUrl.Companion;
                            z = z4;
                            i4 = indexOfLastNonAsciiWhitespace$default;
                            String str4 = str3;
                            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2, input, i6, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z6) {
                                canonicalize$okhttp$default = this.encodedUsername + "%40" + canonicalize$okhttp$default;
                            }
                            this.encodedUsername = canonicalize$okhttp$default;
                            if (delimiterOffset2 != delimiterOffset) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, input, delimiterOffset2 + 1, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z3 = z;
                            } else {
                                z3 = z5;
                            }
                            z5 = z3;
                            str2 = str4;
                            z2 = z;
                            i5 = delimiterOffset;
                        } else {
                            z = z4;
                            i4 = indexOfLastNonAsciiWhitespace$default;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            str2 = str3;
                            i5 = delimiterOffset;
                            sb2.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, i6, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.encodedPassword = sb2.toString();
                            z2 = z6;
                        }
                        i6 = i5 + 1;
                        z6 = z2;
                    }
                    str3 = str2;
                    z4 = z;
                    indexOfLastNonAsciiWhitespace$default = i4;
                    c4 = '#';
                    c3 = '?';
                    c2 = 65535;
                }
                boolean z7 = z4;
                String str5 = str3;
                i2 = indexOfLastNonAsciiWhitespace$default;
                Companion companion3 = Companion;
                int portColonOffset = companion3.portColonOffset(input, i6, delimiterOffset);
                int i7 = portColonOffset + 1;
                if (i7 < delimiterOffset) {
                    i3 = i6;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, input, i6, portColonOffset, false, 4, null));
                    int parsePort = companion3.parsePort(input, i7, delimiterOffset);
                    this.port = parsePort;
                    if (!(parsePort != -1 ? z7 : false)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Invalid URL port: \"");
                        String substring2 = input.substring(i7, delimiterOffset);
                        m.d(substring2, str5);
                        sb3.append(substring2);
                        sb3.append(TokenParser.DQUOTE);
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                    str = str5;
                } else {
                    i3 = i6;
                    str = str5;
                    Companion companion4 = HttpUrl.Companion;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, input, i3, portColonOffset, false, 4, null));
                    String str6 = this.scheme;
                    if (str6 == null) {
                        m.q();
                    }
                    this.port = companion4.defaultPort(str6);
                }
                if (!(this.host != null ? z7 : false)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid URL host: \"");
                    String substring3 = input.substring(i3, portColonOffset);
                    m.d(substring3, str);
                    sb4.append(substring3);
                    sb4.append(TokenParser.DQUOTE);
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                indexOfFirstNonAsciiWhitespace$default = delimiterOffset;
            }
            int i8 = i2;
            int delimiterOffset3 = Util.delimiterOffset(input, "?#", indexOfFirstNonAsciiWhitespace$default, i8);
            resolvePath(input, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 < i8 && input.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = Util.delimiterOffset(input, '#', delimiterOffset3, i8);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, input, delimiterOffset3 + 1, delimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < i8 && input.charAt(delimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, delimiterOffset3 + 1, i8, "", true, false, false, true, null, org.spongycastle.crypto.tls.CipherSuite.TLS_PSK_WITH_NULL_SHA256, null);
            }
            return this;
        }

        public final Builder password(String password) {
            m.h(password, "password");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final Builder port(int i2) {
            boolean z = true;
            if ((1 > i2 || 65535 < i2) ? false : false) {
                this.port = i2;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i2).toString());
        }

        public final Builder query(String str) {
            List<String> list;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String str = this.host;
            this.host = str != null ? new k("[\"<>^`{|}]").e(str, "") : null;
            int size = this.encodedPathSegments.size();
            for (int i2 = 0; i2 < size; i2++) {
                List<String> list = this.encodedPathSegments;
                list.set(i2, Companion.canonicalize$okhttp$default(HttpUrl.Companion, list.get(i2), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str2 = list2.get(i3);
                    list2.set(i3, str2 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, org.spongycastle.crypto.tls.CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str3, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, org.spongycastle.crypto.tls.CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384, null) : null;
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String encodedName) {
            m.h(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, Primes.SMALL_FACTOR_LIMIT, null));
            return this;
        }

        public final Builder removeAllQueryParameters(String name) {
            m.h(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        public final Builder removePathSegment(int i2) {
            this.encodedPathSegments.remove(i2);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public final Builder scheme(String scheme) {
            boolean A;
            boolean A2;
            m.h(scheme, "scheme");
            A = x.A(scheme, HttpHost.DEFAULT_SCHEME_NAME, true);
            if (A) {
                this.scheme = HttpHost.DEFAULT_SCHEME_NAME;
            } else {
                A2 = x.A(scheme, "https", true);
                if (!A2) {
                    throw new IllegalArgumentException("unexpected scheme: " + scheme);
                }
                this.scheme = "https";
            }
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            m.h(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final Builder setEncodedPathSegment(int i2, String encodedPathSegment) {
            m.h(encodedPathSegment, "encodedPathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            this.encodedPathSegments.set(i2, canonicalize$okhttp$default);
            if ((isDot(canonicalize$okhttp$default) || isDotDot(canonicalize$okhttp$default)) ? false : true) {
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + encodedPathSegment).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final Builder setEncodedQueryParameter(String encodedName, String str) {
            m.h(encodedName, "encodedName");
            removeAllEncodedQueryParameters(encodedName);
            addEncodedQueryParameter(encodedName, str);
            return this;
        }

        public final void setEncodedUsername$okhttp(String str) {
            m.h(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final Builder setPathSegment(int i2, String pathSegment) {
            m.h(pathSegment, "pathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, pathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if ((isDot(canonicalize$okhttp$default) || isDotDot(canonicalize$okhttp$default)) ? false : true) {
                this.encodedPathSegments.set(i2, canonicalize$okhttp$default);
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + pathSegment).toString());
        }

        public final void setPort$okhttp(int i2) {
            this.port = i2;
        }

        public final Builder setQueryParameter(String name, String str) {
            m.h(name, "name");
            removeAllQueryParameters(name);
            addQueryParameter(name, str);
            return this;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
            if ((r6.encodedPassword.length() > 0) != false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0095, code lost:
            if (r1 != r3.defaultPort(r2)) goto L44;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L12
                r0.append(r1)
                java.lang.String r1 = "://"
                r0.append(r1)
                goto L17
            L12:
                java.lang.String r1 = "//"
                r0.append(r1)
            L17:
                java.lang.String r1 = r6.encodedUsername
                int r1 = r1.length()
                r2 = 1
                r3 = 0
                if (r1 <= 0) goto L23
                r1 = r2
                goto L24
            L23:
                r1 = r3
            L24:
                r4 = 58
                if (r1 != 0) goto L35
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L32
                r1 = r2
                goto L33
            L32:
                r1 = r3
            L33:
                if (r1 == 0) goto L53
            L35:
                java.lang.String r1 = r6.encodedUsername
                r0.append(r1)
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L43
                goto L44
            L43:
                r2 = r3
            L44:
                if (r2 == 0) goto L4e
                r0.append(r4)
                java.lang.String r1 = r6.encodedPassword
                r0.append(r1)
            L4e:
                r1 = 64
                r0.append(r1)
            L53:
                java.lang.String r1 = r6.host
                if (r1 == 0) goto L79
                if (r1 != 0) goto L5c
                kotlin.jvm.internal.m.q()
            L5c:
                r2 = 2
                r5 = 0
                boolean r1 = kotlin.l0.o.U(r1, r4, r3, r2, r5)
                if (r1 == 0) goto L74
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.host
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L79
            L74:
                java.lang.String r1 = r6.host
                r0.append(r1)
            L79:
                int r1 = r6.port
                r2 = -1
                if (r1 != r2) goto L82
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L9d
            L82:
                int r1 = r6.effectivePort()
                java.lang.String r2 = r6.scheme
                if (r2 == 0) goto L97
                okhttp3.HttpUrl$Companion r3 = okhttp3.HttpUrl.Companion
                if (r2 != 0) goto L91
                kotlin.jvm.internal.m.q()
            L91:
                int r2 = r3.defaultPort(r2)
                if (r1 == r2) goto L9d
            L97:
                r0.append(r4)
                r0.append(r1)
            L9d:
                okhttp3.HttpUrl$Companion r1 = okhttp3.HttpUrl.Companion
                java.util.List<java.lang.String> r2 = r6.encodedPathSegments
                r1.toPathString$okhttp(r2, r0)
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                if (r2 == 0) goto Lb7
                r2 = 63
                r0.append(r2)
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                if (r2 != 0) goto Lb4
                kotlin.jvm.internal.m.q()
            Lb4:
                r1.toQueryString$okhttp(r2, r0)
            Lb7:
                java.lang.String r1 = r6.encodedFragment
                if (r1 == 0) goto Lc5
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.encodedFragment
                r0.append(r1)
            Lc5:
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
                kotlin.jvm.internal.m.d(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.toString():java.lang.String");
        }

        public final Builder username(String username) {
            m.h(username, "username");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        private final Builder addPathSegments(String str, boolean z) {
            int i2 = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(str, "/\\", i2, str.length());
                push(str, i2, delimiterOffset, delimiterOffset < str.length(), z);
                i2 = delimiterOffset + 1;
            } while (i2 <= str.length());
            return this;
        }
    }

    /* compiled from: HttpUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0019\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bL\u0010MJ3\u0010\u000b\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\r*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\r2\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0010\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J]\u0010\u0019\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010#\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00030\r2\n\u0010 \u001a\u00060\u001ej\u0002`\u001fH\u0000¢\u0006\u0004\b!\u0010\"J'\u0010%\u001a\u00020\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\r2\n\u0010 \u001a\u00060\u001ej\u0002`\u001fH\u0000¢\u0006\u0004\b$\u0010\"J\u001b\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030&*\u00020\u0003H\u0000¢\u0006\u0004\b'\u0010(J\u0013\u0010-\u001a\u00020**\u00020\u0003H\u0007¢\u0006\u0004\b+\u0010,J\u0015\u0010/\u001a\u0004\u0018\u00010**\u00020\u0003H\u0007¢\u0006\u0004\b.\u0010,J\u0015\u0010/\u001a\u0004\u0018\u00010**\u000200H\u0007¢\u0006\u0004\b+\u00101J\u0015\u0010/\u001a\u0004\u0018\u00010**\u000202H\u0007¢\u0006\u0004\b+\u00103J\u0017\u0010+\u001a\u00020*2\u0006\u00104\u001a\u00020\u0003H\u0007¢\u0006\u0004\b5\u0010,J\u0019\u0010.\u001a\u0004\u0018\u00010*2\u0006\u00104\u001a\u00020\u0003H\u0007¢\u0006\u0004\b6\u0010,J\u0019\u0010+\u001a\u0004\u0018\u00010*2\u0006\u00104\u001a\u000200H\u0007¢\u0006\u0004\b5\u00101J\u0019\u0010+\u001a\u0004\u0018\u00010*2\u0006\u00107\u001a\u000202H\u0007¢\u0006\u0004\b5\u00103J1\u0010\u000e\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b8\u00109Jc\u0010<\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0000¢\u0006\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b?\u0010>R\u0016\u0010@\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b@\u0010>R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bD\u0010>R\u0016\u0010E\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bE\u0010>R\u0016\u0010F\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bF\u0010>R\u0016\u0010G\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bG\u0010>R\u0016\u0010H\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bH\u0010>R\u0016\u0010I\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bI\u0010>R\u0016\u0010J\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bJ\u0010>R\u0016\u0010K\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bK\u0010>¨\u0006N"}, d2 = {"Lokhttp3/HttpUrl$Companion;", "", "Lj/f;", "", "encoded", "", "pos", "limit", "", "plusIsSpace", "Lkotlin/x;", "writePercentDecoded", "(Lj/f;Ljava/lang/String;IIZ)V", "", "percentDecode", "(Ljava/util/List;Z)Ljava/util/List;", "isPercentEncoded", "(Ljava/lang/String;II)Z", "input", "encodeSet", "alreadyEncoded", "strict", "unicodeAllowed", "Ljava/nio/charset/Charset;", "charset", "writeCanonicalized", "(Lj/f;Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)V", "scheme", "defaultPort", "(Ljava/lang/String;)I", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "toPathString$okhttp", "(Ljava/util/List;Ljava/lang/StringBuilder;)V", "toPathString", "toQueryString$okhttp", "toQueryString", "", "toQueryNamesAndValues$okhttp", "(Ljava/lang/String;)Ljava/util/List;", "toQueryNamesAndValues", "Lokhttp3/HttpUrl;", "get", "(Ljava/lang/String;)Lokhttp3/HttpUrl;", "toHttpUrl", "parse", "toHttpUrlOrNull", "Ljava/net/URL;", "(Ljava/net/URL;)Lokhttp3/HttpUrl;", "Ljava/net/URI;", "(Ljava/net/URI;)Lokhttp3/HttpUrl;", "url", "-deprecated_get", "-deprecated_parse", "uri", "percentDecode$okhttp", "(Ljava/lang/String;IIZ)Ljava/lang/String;", "canonicalize$okhttp", "(Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)Ljava/lang/String;", "canonicalize", "FORM_ENCODE_SET", "Ljava/lang/String;", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "", "HEX_DIGITS", "[C", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i4, Object obj) {
            return companion.canonicalize$okhttp(str, (i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? str.length() : i3, str2, (i4 & 8) != 0 ? false : z, (i4 & 16) != 0 ? false : z2, (i4 & 32) != 0 ? false : z3, (i4 & 64) != 0 ? false : z4, (i4 & 128) != 0 ? null : charset);
        }

        private final boolean isPercentEncoded(String str, int i2, int i3) {
            int i4 = i2 + 2;
            return i4 < i3 && str.charAt(i2) == '%' && Util.parseHexDigit(str.charAt(i2 + 1)) != -1 && Util.parseHexDigit(str.charAt(i4)) != -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<String> percentDecode(List<String> list, boolean z) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                arrayList.add(next != null ? percentDecode$okhttp$default(this, next, 0, 0, z, 3, null) : null);
            }
            List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
            m.d(unmodifiableList, "Collections.unmodifiableList(result)");
            return unmodifiableList;
        }

        static /* synthetic */ List percentDecode$default(Companion companion, List list, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            return companion.percentDecode(list, z);
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i2, int i3, boolean z, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = str.length();
            }
            if ((i4 & 4) != 0) {
                z = false;
            }
            return companion.percentDecode$okhttp(str, i2, i3, z);
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0062, code lost:
            if (isPercentEncoded(r16, r5, r18) == false) goto L40;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void writeCanonicalized(j.f r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                r14 = this;
                r0 = r15
                r1 = r16
                r2 = r18
                r3 = r24
                r4 = 0
                r5 = r17
                r6 = r4
            Lb:
                if (r5 >= r2) goto Lc5
                if (r1 == 0) goto Lbc
                int r7 = r1.codePointAt(r5)
                if (r20 == 0) goto L2b
                r8 = 9
                if (r7 == r8) goto L26
                r8 = 10
                if (r7 == r8) goto L26
                r8 = 12
                if (r7 == r8) goto L26
                r8 = 13
                if (r7 == r8) goto L26
                goto L2b
            L26:
                r8 = r14
                r12 = r19
                goto Lb5
            L2b:
                r8 = 43
                if (r7 != r8) goto L3c
                if (r22 == 0) goto L3c
                if (r20 == 0) goto L36
                java.lang.String r8 = "+"
                goto L38
            L36:
                java.lang.String r8 = "%2B"
            L38:
                r15.h0(r8)
                goto L26
            L3c:
                r8 = 32
                r9 = 37
                if (r7 < r8) goto L6c
                r8 = 127(0x7f, float:1.78E-43)
                if (r7 == r8) goto L6c
                r8 = 128(0x80, float:1.8E-43)
                if (r7 < r8) goto L4c
                if (r23 == 0) goto L6c
            L4c:
                char r8 = (char) r7
                r10 = 0
                r11 = 2
                r12 = r19
                boolean r8 = kotlin.l0.o.U(r12, r8, r10, r11, r4)
                if (r8 != 0) goto L6a
                if (r7 != r9) goto L65
                if (r20 == 0) goto L6a
                if (r21 == 0) goto L65
                r8 = r14
                boolean r10 = r14.isPercentEncoded(r1, r5, r2)
                if (r10 != 0) goto L66
                goto L6f
            L65:
                r8 = r14
            L66:
                r15.u1(r7)
                goto Lb5
            L6a:
                r8 = r14
                goto L6f
            L6c:
                r8 = r14
                r12 = r19
            L6f:
                if (r6 != 0) goto L76
                j.f r6 = new j.f
                r6.<init>()
            L76:
                if (r3 == 0) goto L8a
                java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
                boolean r10 = kotlin.jvm.internal.m.c(r3, r10)
                if (r10 == 0) goto L81
                goto L8a
            L81:
                int r10 = java.lang.Character.charCount(r7)
                int r10 = r10 + r5
                r6.q1(r1, r5, r10, r3)
                goto L8d
            L8a:
                r6.u1(r7)
            L8d:
                boolean r10 = r6.Q()
                if (r10 != 0) goto Lb5
                byte r10 = r6.m0()
                r10 = r10 & 255(0xff, float:3.57E-43)
                r15.R(r9)
                char[] r11 = okhttp3.HttpUrl.access$getHEX_DIGITS$cp()
                int r13 = r10 >> 4
                r13 = r13 & 15
                char r11 = r11[r13]
                r15.R(r11)
                char[] r11 = okhttp3.HttpUrl.access$getHEX_DIGITS$cp()
                r10 = r10 & 15
                char r10 = r11[r10]
                r15.R(r10)
                goto L8d
            Lb5:
                int r7 = java.lang.Character.charCount(r7)
                int r5 = r5 + r7
                goto Lb
            Lbc:
                r8 = r14
                kotlin.TypeCastException r0 = new kotlin.TypeCastException
                java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
                r0.<init>(r1)
                throw r0
            Lc5:
                r8 = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Companion.writeCanonicalized(j.f, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        private final void writePercentDecoded(f fVar, String str, int i2, int i3, boolean z) {
            int i4;
            while (i2 < i3) {
                if (str != null) {
                    int codePointAt = str.codePointAt(i2);
                    if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                        int parseHexDigit = Util.parseHexDigit(str.charAt(i2 + 1));
                        int parseHexDigit2 = Util.parseHexDigit(str.charAt(i4));
                        if (parseHexDigit != -1 && parseHexDigit2 != -1) {
                            fVar.R((parseHexDigit << 4) + parseHexDigit2);
                            i2 = Character.charCount(codePointAt) + i4;
                        }
                        fVar.u1(codePointAt);
                        i2 += Character.charCount(codePointAt);
                    } else {
                        if (codePointAt == 43 && z) {
                            fVar.R(32);
                            i2++;
                        }
                        fVar.u1(codePointAt);
                        i2 += Character.charCount(codePointAt);
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m2291deprecated_get(String url) {
            m.h(url, "url");
            return get(url);
        }

        /* renamed from: -deprecated_parse  reason: not valid java name */
        public final HttpUrl m2294deprecated_parse(String url) {
            m.h(url, "url");
            return parse(url);
        }

        public final String canonicalize$okhttp(String canonicalize, int i2, int i3, String encodeSet, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
            boolean U;
            m.h(canonicalize, "$this$canonicalize");
            m.h(encodeSet, "encodeSet");
            int i4 = i2;
            while (i4 < i3) {
                int codePointAt = canonicalize.codePointAt(i4);
                if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || z4)) {
                    U = y.U(encodeSet, (char) codePointAt, false, 2, null);
                    if (!U) {
                        if (codePointAt == 37) {
                            if (z) {
                                if (z2) {
                                    if (!isPercentEncoded(canonicalize, i4, i3)) {
                                        f fVar = new f();
                                        fVar.q0(canonicalize, i2, i4);
                                        writeCanonicalized(fVar, canonicalize, i4, i3, encodeSet, z, z2, z3, z4, charset);
                                        return fVar.G0();
                                    }
                                    if (codePointAt == 43 || !z3) {
                                        i4 += Character.charCount(codePointAt);
                                    } else {
                                        f fVar2 = new f();
                                        fVar2.q0(canonicalize, i2, i4);
                                        writeCanonicalized(fVar2, canonicalize, i4, i3, encodeSet, z, z2, z3, z4, charset);
                                        return fVar2.G0();
                                    }
                                }
                            }
                        }
                        if (codePointAt == 43) {
                        }
                        i4 += Character.charCount(codePointAt);
                    }
                }
                f fVar22 = new f();
                fVar22.q0(canonicalize, i2, i4);
                writeCanonicalized(fVar22, canonicalize, i4, i3, encodeSet, z, z2, z3, z4, charset);
                return fVar22.G0();
            }
            String substring = canonicalize.substring(i2, i3);
            m.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final int defaultPort(String scheme) {
            m.h(scheme, "scheme");
            int hashCode = scheme.hashCode();
            if (hashCode != 3213448) {
                if (hashCode == 99617003 && scheme.equals("https")) {
                    return 443;
                }
            } else if (scheme.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
                return 80;
            }
            return -1;
        }

        public final HttpUrl get(String toHttpUrl) {
            m.h(toHttpUrl, "$this$toHttpUrl");
            return new Builder().parse$okhttp(null, toHttpUrl).build();
        }

        public final HttpUrl parse(String toHttpUrlOrNull) {
            m.h(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            try {
                return get(toHttpUrlOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String percentDecode$okhttp(String percentDecode, int i2, int i3, boolean z) {
            m.h(percentDecode, "$this$percentDecode");
            for (int i4 = i2; i4 < i3; i4++) {
                char charAt = percentDecode.charAt(i4);
                if (charAt == '%' || (charAt == '+' && z)) {
                    f fVar = new f();
                    fVar.q0(percentDecode, i2, i4);
                    writePercentDecoded(fVar, percentDecode, i4, i3, z);
                    return fVar.G0();
                }
            }
            String substring = percentDecode.substring(i2, i3);
            m.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final void toPathString$okhttp(List<String> toPathString, StringBuilder out) {
            m.h(toPathString, "$this$toPathString");
            m.h(out, "out");
            int size = toPathString.size();
            for (int i2 = 0; i2 < size; i2++) {
                out.append('/');
                out.append(toPathString.get(i2));
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String toQueryNamesAndValues) {
            int h0;
            int h02;
            m.h(toQueryNamesAndValues, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 <= toQueryNamesAndValues.length()) {
                h0 = y.h0(toQueryNamesAndValues, '&', i2, false, 4, null);
                if (h0 == -1) {
                    h0 = toQueryNamesAndValues.length();
                }
                int i3 = h0;
                h02 = y.h0(toQueryNamesAndValues, '=', i2, false, 4, null);
                if (h02 != -1 && h02 <= i3) {
                    String substring = toQueryNamesAndValues.substring(i2, h02);
                    m.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    String substring2 = toQueryNamesAndValues.substring(h02 + 1, i3);
                    m.d(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                } else {
                    String substring3 = toQueryNamesAndValues.substring(i2, i3);
                    m.d(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring3);
                    arrayList.add(null);
                }
                i2 = i3 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(List<String> toQueryString, StringBuilder out) {
            m.h(toQueryString, "$this$toQueryString");
            m.h(out, "out");
            a i2 = d.i(d.j(0, toQueryString.size()), 2);
            int i3 = i2.i();
            int k2 = i2.k();
            int l2 = i2.l();
            if (l2 >= 0) {
                if (i3 > k2) {
                    return;
                }
            } else if (i3 < k2) {
                return;
            }
            while (true) {
                String str = toQueryString.get(i3);
                String str2 = toQueryString.get(i3 + 1);
                if (i3 > 0) {
                    out.append('&');
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (i3 == k2) {
                    return;
                }
                i3 += l2;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m2293deprecated_get(URL url) {
            m.h(url, "url");
            return get(url);
        }

        public final HttpUrl get(URL toHttpUrlOrNull) {
            m.h(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String url = toHttpUrlOrNull.toString();
            m.d(url, "toString()");
            return parse(url);
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m2292deprecated_get(URI uri) {
            m.h(uri, "uri");
            return get(uri);
        }

        public final HttpUrl get(URI toHttpUrlOrNull) {
            m.h(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String uri = toHttpUrlOrNull.toString();
            m.d(uri, "toString()");
            return parse(uri);
        }
    }

    public HttpUrl(String scheme, String username, String password, String host, int i2, List<String> pathSegments, List<String> list, String str, String url) {
        m.h(scheme, "scheme");
        m.h(username, "username");
        m.h(password, "password");
        m.h(host, "host");
        m.h(pathSegments, "pathSegments");
        m.h(url, "url");
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = i2;
        this.pathSegments = pathSegments;
        this.queryNamesAndValues = list;
        this.fragment = str;
        this.url = url;
        this.isHttps = m.c(scheme, "https");
    }

    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    public static final HttpUrl get(URL url) {
        return Companion.get(url);
    }

    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_encodedFragment  reason: not valid java name */
    public final String m2272deprecated_encodedFragment() {
        return encodedFragment();
    }

    /* renamed from: -deprecated_encodedPassword  reason: not valid java name */
    public final String m2273deprecated_encodedPassword() {
        return encodedPassword();
    }

    /* renamed from: -deprecated_encodedPath  reason: not valid java name */
    public final String m2274deprecated_encodedPath() {
        return encodedPath();
    }

    /* renamed from: -deprecated_encodedPathSegments  reason: not valid java name */
    public final List<String> m2275deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    /* renamed from: -deprecated_encodedQuery  reason: not valid java name */
    public final String m2276deprecated_encodedQuery() {
        return encodedQuery();
    }

    /* renamed from: -deprecated_encodedUsername  reason: not valid java name */
    public final String m2277deprecated_encodedUsername() {
        return encodedUsername();
    }

    /* renamed from: -deprecated_fragment  reason: not valid java name */
    public final String m2278deprecated_fragment() {
        return this.fragment;
    }

    /* renamed from: -deprecated_host  reason: not valid java name */
    public final String m2279deprecated_host() {
        return this.host;
    }

    /* renamed from: -deprecated_password  reason: not valid java name */
    public final String m2280deprecated_password() {
        return this.password;
    }

    /* renamed from: -deprecated_pathSegments  reason: not valid java name */
    public final List<String> m2281deprecated_pathSegments() {
        return this.pathSegments;
    }

    /* renamed from: -deprecated_pathSize  reason: not valid java name */
    public final int m2282deprecated_pathSize() {
        return pathSize();
    }

    /* renamed from: -deprecated_port  reason: not valid java name */
    public final int m2283deprecated_port() {
        return this.port;
    }

    /* renamed from: -deprecated_query  reason: not valid java name */
    public final String m2284deprecated_query() {
        return query();
    }

    /* renamed from: -deprecated_queryParameterNames  reason: not valid java name */
    public final Set<String> m2285deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    /* renamed from: -deprecated_querySize  reason: not valid java name */
    public final int m2286deprecated_querySize() {
        return querySize();
    }

    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m2287deprecated_scheme() {
        return this.scheme;
    }

    /* renamed from: -deprecated_uri  reason: not valid java name */
    public final URI m2288deprecated_uri() {
        return uri();
    }

    /* renamed from: -deprecated_url  reason: not valid java name */
    public final URL m2289deprecated_url() {
        return url();
    }

    /* renamed from: -deprecated_username  reason: not valid java name */
    public final String m2290deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        int h0;
        if (this.fragment == null) {
            return null;
        }
        h0 = y.h0(this.url, '#', 0, false, 6, null);
        int i2 = h0 + 1;
        String str = this.url;
        if (str != null) {
            String substring = str.substring(i2);
            m.d(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final String encodedPassword() {
        int h0;
        int h02;
        if (this.password.length() == 0) {
            return "";
        }
        h0 = y.h0(this.url, ':', this.scheme.length() + 3, false, 4, null);
        int i2 = h0 + 1;
        h02 = y.h0(this.url, '@', 0, false, 6, null);
        String str = this.url;
        if (str != null) {
            String substring = str.substring(i2, h02);
            m.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final String encodedPath() {
        int h0;
        h0 = y.h0(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", h0, str.length());
        String str2 = this.url;
        if (str2 != null) {
            String substring = str2.substring(h0, delimiterOffset);
            m.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final List<String> encodedPathSegments() {
        int h0;
        h0 = y.h0(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", h0, str.length());
        ArrayList arrayList = new ArrayList();
        while (h0 < delimiterOffset) {
            int i2 = h0 + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, '/', i2, delimiterOffset);
            String str2 = this.url;
            if (str2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = str2.substring(i2, delimiterOffset2);
            m.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(substring);
            h0 = delimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        int h0;
        if (this.queryNamesAndValues == null) {
            return null;
        }
        h0 = y.h0(this.url, '?', 0, false, 6, null);
        int i2 = h0 + 1;
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, '#', i2, str.length());
        String str2 = this.url;
        if (str2 != null) {
            String substring = str2.substring(i2, delimiterOffset);
            m.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, ":@", length, str.length());
        String str2 = this.url;
        if (str2 != null) {
            String substring = str2.substring(length, delimiterOffset);
            m.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && m.c(((HttpUrl) obj).url, this.url);
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    public final String queryParameter(String name) {
        m.h(name, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        a i2 = d.i(d.j(0, list.size()), 2);
        int i3 = i2.i();
        int k2 = i2.k();
        int l2 = i2.l();
        if (l2 < 0 ? i3 >= k2 : i3 <= k2) {
            while (!m.c(name, this.queryNamesAndValues.get(i3))) {
                if (i3 != k2) {
                    i3 += l2;
                }
            }
            return this.queryNamesAndValues.get(i3 + 1);
        }
        return null;
    }

    public final String queryParameterName(int i2) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            String str = list.get(i2 * 2);
            if (str == null) {
                m.q();
            }
            return str;
        }
        throw new IndexOutOfBoundsException();
    }

    public final Set<String> queryParameterNames() {
        Set<String> b2;
        if (this.queryNamesAndValues == null) {
            b2 = s0.b();
            return b2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a i2 = d.i(d.j(0, this.queryNamesAndValues.size()), 2);
        int i3 = i2.i();
        int k2 = i2.k();
        int l2 = i2.l();
        if (l2 < 0 ? i3 >= k2 : i3 <= k2) {
            while (true) {
                String str = this.queryNamesAndValues.get(i3);
                if (str == null) {
                    m.q();
                }
                linkedHashSet.add(str);
                if (i3 == k2) {
                    break;
                }
                i3 += l2;
            }
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        m.d(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final String queryParameterValue(int i2) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i2 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<String> queryParameterValues(String name) {
        List<String> g2;
        m.h(name, "name");
        if (this.queryNamesAndValues == null) {
            g2 = r.g();
            return g2;
        }
        ArrayList arrayList = new ArrayList();
        a i2 = d.i(d.j(0, this.queryNamesAndValues.size()), 2);
        int i3 = i2.i();
        int k2 = i2.k();
        int l2 = i2.l();
        if (l2 < 0 ? i3 >= k2 : i3 <= k2) {
            while (true) {
                if (m.c(name, this.queryNamesAndValues.get(i3))) {
                    arrayList.add(this.queryNamesAndValues.get(i3 + 1));
                }
                if (i3 == k2) {
                    break;
                }
                i3 += l2;
            }
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        m.d(unmodifiableList, "Collections.unmodifiableList(result)");
        return unmodifiableList;
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        if (newBuilder == null) {
            m.q();
        }
        return newBuilder.username("").password("").build().toString();
    }

    public final HttpUrl resolve(String link) {
        m.h(link, "link");
        Builder newBuilder = newBuilder(link);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e2) {
            try {
                URI create = URI.create(new k("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").e(builder, ""));
                m.d(create, "URI.create(stripped)");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final String username() {
        return this.username;
    }

    public final Builder newBuilder(String link) {
        m.h(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}