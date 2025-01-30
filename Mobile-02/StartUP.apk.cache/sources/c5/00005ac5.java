package okhttp3.internal;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import j.e0;
import j.g;
import j.h;
import j.i;
import j.t;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.a0.m0;
import kotlin.a0.n;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.i0.c;
import kotlin.i0.f;
import kotlin.jvm.internal.h0;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.l0.d;
import kotlin.l0.k;
import kotlin.l0.y;
import kotlin.x;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.cookie.ClientCookie;

/* compiled from: Util.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a%\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e*\b\u0012\u0004\u0012\u00020\u00070\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a7\u0010\u0014\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0018\u001a\u00020\u0007*\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\u001c\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u001a\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u001c\u0010\u001d\u001a%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010\"\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010#\u001a%\u0010$\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b$\u0010#\u001a%\u0010%\u001a\u00020\u0007*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b%\u0010&\u001a-\u0010(\u001a\u00020\u001b*\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b(\u0010)\u001a-\u0010(\u001a\u00020\u001b*\u00020\u00072\u0006\u0010+\u001a\u00020*2\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b(\u0010,\u001a\u0011\u0010-\u001a\u00020\u001b*\u00020\u0007¢\u0006\u0004\b-\u0010.\u001a\u0011\u0010/\u001a\u00020\t*\u00020\u0007¢\u0006\u0004\b/\u00100\u001a)\u00101\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u0002020\u000e\"\u000202¢\u0006\u0004\b1\u00104\u001a\u0019\u00108\u001a\u000206*\u0002052\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109\u001a'\u0010=\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b=\u0010>\u001a\u0011\u0010?\u001a\u00020\u001b*\u00020*¢\u0006\u0004\b?\u0010@\u001a\u0017\u0010D\u001a\u00020C*\b\u0012\u0004\u0012\u00020B0A¢\u0006\u0004\bD\u0010E\u001a\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020B0A*\u00020C¢\u0006\u0004\bF\u0010G\u001a\u0019\u0010H\u001a\u00020\t*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0016¢\u0006\u0004\bH\u0010I\u001a\u0011\u0010L\u001a\u00020K*\u00020J¢\u0006\u0004\bL\u0010M\u001a\u001c\u0010P\u001a\u00020\u001b*\u00020N2\u0006\u0010O\u001a\u00020\u001bH\u0086\u0004¢\u0006\u0004\bP\u0010Q\u001a\u001c\u0010P\u001a\u00020\u001b*\u00020R2\u0006\u0010O\u001a\u00020\u001bH\u0086\u0004¢\u0006\u0004\bP\u0010S\u001a\u001c\u0010P\u001a\u00020\u0000*\u00020\u001b2\u0006\u0010O\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\bP\u0010T\u001a\u0019\u0010W\u001a\u00020\u0004*\u00020U2\u0006\u0010V\u001a\u00020\u001b¢\u0006\u0004\bW\u0010X\u001a\u0011\u0010Y\u001a\u00020\u001b*\u000205¢\u0006\u0004\bY\u0010Z\u001a!\u0010]\u001a\u00020\t*\u00020[2\u0006\u0010:\u001a\u00020\u001b2\u0006\u0010\\\u001a\u00020;¢\u0006\u0004\b]\u0010^\u001a!\u0010`\u001a\u00020\t*\u00020[2\u0006\u0010_\u001a\u00020\u001b2\u0006\u0010\\\u001a\u00020;¢\u0006\u0004\b`\u0010^\u001a\u0011\u0010b\u001a\u00020\u0007*\u00020a¢\u0006\u0004\bb\u0010c\u001a\u0019\u0010e\u001a\u00020\t*\u00020a2\u0006\u0010d\u001a\u000205¢\u0006\u0004\be\u0010f\u001a\u001e\u0010i\u001a\u00020\u00042\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00040gH\u0086\b¢\u0006\u0004\bi\u0010j\u001a&\u0010k\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00040gH\u0086\b¢\u0006\u0004\bk\u0010l\u001a\u0019\u0010]\u001a\u00020\u001b*\u00020m2\u0006\u0010n\u001a\u00020N¢\u0006\u0004\b]\u0010o\u001a\u001b\u0010p\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b¢\u0006\u0004\bp\u0010q\u001a\u0011\u0010s\u001a\u00020\u0000*\u00020r¢\u0006\u0004\bs\u0010t\u001a\u0019\u0010v\u001a\u00020\u0000*\u00020\u00072\u0006\u0010u\u001a\u00020\u0000¢\u0006\u0004\bv\u0010w\u001a\u001b\u0010x\u001a\u00020\u001b*\u0004\u0018\u00010\u00072\u0006\u0010u\u001a\u00020\u001b¢\u0006\u0004\bx\u0010q\u001a#\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000A\"\u0004\b\u0000\u0010y*\b\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0004\bz\u0010{\u001a/\u0010}\u001a\b\u0012\u0004\u0012\u00028\u00000A\"\u0004\b\u0000\u0010y2\u0012\u0010|\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000e\"\u00028\u0000H\u0007¢\u0006\u0004\b}\u0010~\u001a;\u0010\u0082\u0001\u001a\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0081\u0001\"\u0004\b\u0000\u0010\u007f\"\u0005\b\u0001\u0010\u0080\u0001*\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0081\u0001¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0015\u0010\u0085\u0001\u001a\u00020\u0004*\u00030\u0084\u0001¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0014\u0010\u0085\u0001\u001a\u00020\u0004*\u00020a¢\u0006\u0006\b\u0085\u0001\u0010\u0087\u0001\u001a\u0015\u0010\u0085\u0001\u001a\u00020\u0004*\u00030\u0088\u0001¢\u0006\u0006\b\u0085\u0001\u0010\u0089\u0001\u001a\u0014\u0010\u008a\u0001\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0014\u0010\u008a\u0001\u001a\u00020\u0007*\u00020\u001b¢\u0006\u0006\b\u008a\u0001\u0010\u008c\u0001\u001a\u0017\u0010\u008d\u0001\u001a\u00020\u0004*\u000202H\u0086\b¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0017\u0010\u008f\u0001\u001a\u00020\u0004*\u000202H\u0086\b¢\u0006\u0006\b\u008f\u0001\u0010\u008e\u0001\u001a\u0017\u0010\u0090\u0001\u001a\u00020\u0004*\u000202H\u0086\b¢\u0006\u0006\b\u0090\u0001\u0010\u008e\u0001\u001a:\u0010\u0095\u0001\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010y2\u0007\u0010\u0091\u0001\u001a\u0002022\u000e\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0092\u00012\u0007\u0010\u0094\u0001\u001a\u00020\u0007¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a-\u0010\u009a\u0001\u001a\u00020\u0004\"\u0005\b\u0000\u0010\u0097\u0001*\t\u0012\u0004\u0012\u00028\u00000\u0098\u00012\u0007\u0010\u0099\u0001\u001a\u00028\u0000H\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0017\u0010\u009c\u0001\u001a\u00020\u0004*\u000202H\u0080\b¢\u0006\u0006\b\u009c\u0001\u0010\u008e\u0001\u001a\u0017\u0010\u009d\u0001\u001a\u00020\u0004*\u000202H\u0080\b¢\u0006\u0006\b\u009d\u0001\u0010\u008e\u0001\u001a0\u0010¢\u0001\u001a\u00030¡\u0001*\b0\u009e\u0001j\u0003`\u009f\u00012\u0013\u0010 \u0001\u001a\u000e\u0012\n\u0012\b0\u009e\u0001j\u0003`\u009f\u00010A¢\u0006\u0006\b¢\u0001\u0010£\u0001\"\u001a\u0010¥\u0001\u001a\u00030¤\u00018\u0006@\u0007X\u0087\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001\"\u001a\u0010¨\u0001\u001a\u00030§\u00018\u0006@\u0007X\u0087\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001\"\u001a\u0010«\u0001\u001a\u00030ª\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001\"\u001a\u0010®\u0001\u001a\u00030\u00ad\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001\"\u001a\u0010±\u0001\u001a\u00030°\u00018\u0006@\u0007X\u0087\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001\"\u001a\u0010´\u0001\u001a\u00030³\u00018\u0006@\u0007X\u0087\u0004¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001\"\u0019\u0010¶\u0001\u001a\u00020\u00078\u0000@\u0001X\u0081\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001\"\u0019\u0010¸\u0001\u001a\u00020C8\u0006@\u0007X\u0087\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001\"\u0019\u0010º\u0001\u001a\u00020\t8\u0000@\u0001X\u0081\u0004¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001¨\u0006¼\u0001"}, d2 = {"", "arrayLength", "offset", "count", "Lkotlin/x;", "checkOffsetAndCount", "(JJJ)V", "", ApiConstants.NAME, "", "daemon", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "(Ljava/lang/String;Z)Ljava/util/concurrent/ThreadFactory;", "", "other", "Ljava/util/Comparator;", "comparator", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "hasIntersection", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "Lokhttp3/HttpUrl;", "includeDefaultPort", "toHostHeader", "(Lokhttp3/HttpUrl;Z)Ljava/lang/String;", "value", "", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "concat", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "startIndex", "endIndex", "indexOfFirstNonAsciiWhitespace", "(Ljava/lang/String;II)I", "indexOfLastNonAsciiWhitespace", "trimSubstring", "(Ljava/lang/String;II)Ljava/lang/String;", "delimiters", "delimiterOffset", "(Ljava/lang/String;Ljava/lang/String;II)I", "", "delimiter", "(Ljava/lang/String;CII)I", "indexOfControlOrNonAscii", "(Ljava/lang/String;)I", "canParseAsIpAddress", "(Ljava/lang/String;)Z", "format", "", "args", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lj/h;", "Ljava/nio/charset/Charset;", CookieSpecs.DEFAULT, "readBomAsCharset", "(Lj/h;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", "duration", "Ljava/util/concurrent/TimeUnit;", "unit", "checkDuration", "(Ljava/lang/String;JLjava/util/concurrent/TimeUnit;)I", "parseHexDigit", "(C)I", "", "Lokhttp3/internal/http2/Header;", "Lokhttp3/Headers;", "toHeaders", "(Ljava/util/List;)Lokhttp3/Headers;", "toHeaderList", "(Lokhttp3/Headers;)Ljava/util/List;", "canReuseConnectionFor", "(Lokhttp3/HttpUrl;Lokhttp3/HttpUrl;)Z", "Lokhttp3/EventListener;", "Lokhttp3/EventListener$Factory;", "asFactory", "(Lokhttp3/EventListener;)Lokhttp3/EventListener$Factory;", "", "mask", "and", "(BI)I", "", "(SI)I", "(IJ)J", "Lj/g;", RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_MEDIUM, "writeMedium", "(Lj/g;I)V", "readMedium", "(Lj/h;)I", "Lj/e0;", "timeUnit", "skipAll", "(Lj/e0;ILjava/util/concurrent/TimeUnit;)Z", "timeout", ClientCookie.DISCARD_ATTR, "Ljava/net/Socket;", "peerName", "(Ljava/net/Socket;)Ljava/lang/String;", Payload.SOURCE, "isHealthy", "(Ljava/net/Socket;Lj/h;)Z", "Lkotlin/Function0;", "block", "ignoreIoExceptions", "(Lkotlin/e0/c/a;)V", "threadName", "(Ljava/lang/String;Lkotlin/e0/c/a;)V", "Lj/f;", "b", "(Lj/f;B)I", "indexOfNonWhitespace", "(Ljava/lang/String;I)I", "Lokhttp3/Response;", "headersContentLength", "(Lokhttp3/Response;)J", "defaultValue", "toLongOrDefault", "(Ljava/lang/String;J)J", "toNonNegativeInt", "T", "toImmutableList", "(Ljava/util/List;)Ljava/util/List;", "elements", "immutableListOf", "([Ljava/lang/Object;)Ljava/util/List;", "K", "V", "", "toImmutableMap", "(Ljava/util/Map;)Ljava/util/Map;", "Ljava/io/Closeable;", "closeQuietly", "(Ljava/io/Closeable;)V", "(Ljava/net/Socket;)V", "Ljava/net/ServerSocket;", "(Ljava/net/ServerSocket;)V", "toHexString", "(J)Ljava/lang/String;", "(I)Ljava/lang/String;", "wait", "(Ljava/lang/Object;)V", "notify", "notifyAll", "instance", "Ljava/lang/Class;", "fieldType", "fieldName", "readFieldOrNull", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "E", "", "element", "addIfAbsent", "(Ljava/util/List;Ljava/lang/Object;)V", "assertThreadHoldsLock", "assertThreadDoesntHoldLock", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "", "withSuppressed", "(Ljava/lang/Exception;Ljava/util/List;)Ljava/lang/Throwable;", "Lokhttp3/RequestBody;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "", "EMPTY_BYTE_ARRAY", "[B", "Lj/t;", "UNICODE_BOMS", "Lj/t;", "Lkotlin/l0/k;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/l0/k;", "Ljava/util/TimeZone;", "UTC", "Ljava/util/TimeZone;", "Lokhttp3/ResponseBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "okHttpName", "Ljava/lang/String;", "EMPTY_HEADERS", "Lokhttp3/Headers;", "assertionsEnabled", "Z", "okhttp"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    private static final t UNICODE_BOMS;
    public static final TimeZone UTC;
    private static final k VERIFY_AS_IP_ADDRESS;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;

    static {
        String A0;
        String B0;
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        t.a aVar = t.f17165b;
        i.a aVar2 = i.f17151b;
        UNICODE_BOMS = aVar.d(aVar2.b("efbbbf"), aVar2.b("feff"), aVar2.b("fffe"), aVar2.b("0000ffff"), aVar2.b("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        if (timeZone == null) {
            m.q();
        }
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new k("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        m.d(name, "OkHttpClient::class.java.name");
        A0 = y.A0(name, "okhttp3.");
        B0 = y.B0(A0, "Client");
        okHttpName = B0;
    }

    public static final <E> void addIfAbsent(List<E> addIfAbsent, E e2) {
        m.h(addIfAbsent, "$this$addIfAbsent");
        if (addIfAbsent.contains(e2)) {
            return;
        }
        addIfAbsent.add(e2);
    }

    public static final int and(byte b2, int i2) {
        return b2 & i2;
    }

    public static final int and(short s, int i2) {
        return s & i2;
    }

    public static final long and(int i2, long j2) {
        return i2 & j2;
    }

    public static final EventListener.Factory asFactory(final EventListener asFactory) {
        m.h(asFactory, "$this$asFactory");
        return new EventListener.Factory() { // from class: okhttp3.internal.Util$asFactory$1
            @Override // okhttp3.EventListener.Factory
            public EventListener create(Call call) {
                m.h(call, "call");
                return EventListener.this;
            }
        };
    }

    public static final void assertThreadDoesntHoldLock(Object assertThreadDoesntHoldLock) {
        m.h(assertThreadDoesntHoldLock, "$this$assertThreadDoesntHoldLock");
        if (assertionsEnabled && Thread.holdsLock(assertThreadDoesntHoldLock)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            m.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(assertThreadDoesntHoldLock);
            throw new AssertionError(sb.toString());
        }
    }

    public static final void assertThreadHoldsLock(Object assertThreadHoldsLock) {
        m.h(assertThreadHoldsLock, "$this$assertThreadHoldsLock");
        if (!assertionsEnabled || Thread.holdsLock(assertThreadHoldsLock)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        m.d(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(assertThreadHoldsLock);
        throw new AssertionError(sb.toString());
    }

    public static final boolean canParseAsIpAddress(String canParseAsIpAddress) {
        m.h(canParseAsIpAddress, "$this$canParseAsIpAddress");
        return VERIFY_AS_IP_ADDRESS.d(canParseAsIpAddress);
    }

    public static final boolean canReuseConnectionFor(HttpUrl canReuseConnectionFor, HttpUrl other) {
        m.h(canReuseConnectionFor, "$this$canReuseConnectionFor");
        m.h(other, "other");
        return m.c(canReuseConnectionFor.host(), other.host()) && canReuseConnectionFor.port() == other.port() && m.c(canReuseConnectionFor.scheme(), other.scheme());
    }

    public static final int checkDuration(String name, long j2, TimeUnit timeUnit) {
        m.h(name, "name");
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        boolean z = true;
        if (!(i2 >= 0)) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        if (timeUnit != null) {
            long millis = timeUnit.toMillis(j2);
            if (!(millis <= ((long) RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO))) {
                throw new IllegalArgumentException((name + " too large.").toString());
            }
            if (millis == 0 && i2 > 0) {
                z = false;
            }
            if (z) {
                return (int) millis;
            }
            throw new IllegalArgumentException((name + " too small.").toString());
        }
        throw new IllegalStateException("unit == null".toString());
    }

    public static final void checkOffsetAndCount(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(Closeable closeQuietly) {
        m.h(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] concat, String value) {
        int B;
        m.h(concat, "$this$concat");
        m.h(value, "value");
        Object[] copyOf = Arrays.copyOf(concat, concat.length + 1);
        m.d(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr = (String[]) copyOf;
        B = n.B(strArr);
        strArr[B] = value;
        return strArr;
    }

    public static final int delimiterOffset(String delimiterOffset, String delimiters, int i2, int i3) {
        boolean U;
        m.h(delimiterOffset, "$this$delimiterOffset");
        m.h(delimiters, "delimiters");
        while (i2 < i3) {
            U = y.U(delimiters, delimiterOffset.charAt(i2), false, 2, null);
            if (U) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return delimiterOffset(str, str2, i2, i3);
    }

    public static final boolean discard(e0 discard, int i2, TimeUnit timeUnit) {
        m.h(discard, "$this$discard");
        m.h(timeUnit, "timeUnit");
        try {
            return skipAll(discard, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String format(String format, Object... args) {
        m.h(format, "format");
        m.h(args, "args");
        h0 h0Var = h0.a;
        Locale locale = Locale.US;
        m.d(locale, "Locale.US");
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        m.d(format2, "java.lang.String.format(locale, format, *args)");
        return format2;
    }

    public static final boolean hasIntersection(String[] hasIntersection, String[] strArr, Comparator<? super String> comparator) {
        m.h(hasIntersection, "$this$hasIntersection");
        m.h(comparator, "comparator");
        if (!(hasIntersection.length == 0) && strArr != null) {
            if (!(strArr.length == 0)) {
                for (String str : hasIntersection) {
                    for (String str2 : strArr) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(Response headersContentLength) {
        m.h(headersContentLength, "$this$headersContentLength");
        String str = headersContentLength.headers().get("Content-Length");
        if (str != null) {
            return toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    public static final void ignoreIoExceptions(a<x> block) {
        m.h(block, "block");
        try {
            block.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... elements) {
        m.h(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(objArr, objArr.length)));
        m.d(unmodifiableList, "Collections.unmodifiable…sList(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int indexOf(String[] indexOf, String value, Comparator<String> comparator) {
        m.h(indexOf, "$this$indexOf");
        m.h(value, "value");
        m.h(comparator, "comparator");
        int length = indexOf.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(indexOf[i2], value) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String indexOfControlOrNonAscii) {
        m.h(indexOfControlOrNonAscii, "$this$indexOfControlOrNonAscii");
        int length = indexOfControlOrNonAscii.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = indexOfControlOrNonAscii.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String indexOfFirstNonAsciiWhitespace, int i2, int i3) {
        m.h(indexOfFirstNonAsciiWhitespace, "$this$indexOfFirstNonAsciiWhitespace");
        while (i2 < i3) {
            char charAt = indexOfFirstNonAsciiWhitespace.charAt(i2);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i2, i3);
    }

    public static final int indexOfLastNonAsciiWhitespace(String indexOfLastNonAsciiWhitespace, int i2, int i3) {
        m.h(indexOfLastNonAsciiWhitespace, "$this$indexOfLastNonAsciiWhitespace");
        int i4 = i3 - 1;
        if (i4 >= i2) {
            while (true) {
                char charAt = indexOfLastNonAsciiWhitespace.charAt(i4);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i4 + 1;
                }
                if (i4 == i2) {
                    break;
                }
                i4--;
            }
        }
        return i2;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i2, i3);
    }

    public static final int indexOfNonWhitespace(String indexOfNonWhitespace, int i2) {
        m.h(indexOfNonWhitespace, "$this$indexOfNonWhitespace");
        int length = indexOfNonWhitespace.length();
        while (i2 < length) {
            char charAt = indexOfNonWhitespace.charAt(i2);
            if (charAt != ' ' && charAt != '\t') {
                return i2;
            }
            i2++;
        }
        return indexOfNonWhitespace.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return indexOfNonWhitespace(str, i2);
    }

    public static final String[] intersect(String[] intersect, String[] other, Comparator<? super String> comparator) {
        m.h(intersect, "$this$intersect");
        m.h(other, "other");
        m.h(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : intersect) {
            int length = other.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (comparator.compare(str, other[i2]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i2++;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final boolean isHealthy(Socket isHealthy, h source) {
        m.h(isHealthy, "$this$isHealthy");
        m.h(source, "source");
        try {
            int soTimeout = isHealthy.getSoTimeout();
            try {
                isHealthy.setSoTimeout(1);
                return !source.Q();
            } finally {
                isHealthy.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final void notify(Object notify) {
        m.h(notify, "$this$notify");
        notify.notify();
    }

    public static final void notifyAll(Object notifyAll) {
        m.h(notifyAll, "$this$notifyAll");
        notifyAll.notifyAll();
    }

    public static final int parseHexDigit(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        char c3 = 'a';
        if ('a' > c2 || 'f' < c2) {
            c3 = 'A';
            if ('A' > c2 || 'F' < c2) {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static final String peerName(Socket peerName) {
        m.h(peerName, "$this$peerName");
        SocketAddress remoteSocketAddress = peerName.getRemoteSocketAddress();
        if (remoteSocketAddress instanceof InetSocketAddress) {
            String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
            m.d(hostName, "address.hostName");
            return hostName;
        }
        return remoteSocketAddress.toString();
    }

    public static final Charset readBomAsCharset(h readBomAsCharset, Charset charset) throws IOException {
        m.h(readBomAsCharset, "$this$readBomAsCharset");
        m.h(charset, "default");
        int h1 = readBomAsCharset.h1(UNICODE_BOMS);
        if (h1 != -1) {
            if (h1 == 0) {
                Charset UTF_8 = StandardCharsets.UTF_8;
                m.d(UTF_8, "UTF_8");
                return UTF_8;
            } else if (h1 == 1) {
                Charset UTF_16BE = StandardCharsets.UTF_16BE;
                m.d(UTF_16BE, "UTF_16BE");
                return UTF_16BE;
            } else if (h1 == 2) {
                Charset UTF_16LE = StandardCharsets.UTF_16LE;
                m.d(UTF_16LE, "UTF_16LE");
                return UTF_16LE;
            } else if (h1 != 3) {
                if (h1 == 4) {
                    return d.f17354i.b();
                }
                throw new AssertionError();
            } else {
                return d.f17354i.a();
            }
        }
        return charset;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0039, code lost:
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> T readFieldOrNull(java.lang.Object r6, java.lang.Class<T> r7, java.lang.String r8) {
        /*
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.lang.String r1 = "instance"
            kotlin.jvm.internal.m.h(r6, r1)
            java.lang.String r1 = "fieldType"
            kotlin.jvm.internal.m.h(r7, r1)
            java.lang.String r1 = "fieldName"
            kotlin.jvm.internal.m.h(r8, r1)
            java.lang.Class r1 = r6.getClass()
        L15:
            boolean r2 = kotlin.jvm.internal.m.c(r1, r0)
            r3 = 1
            r2 = r2 ^ r3
            r4 = 0
            if (r2 == 0) goto L44
            java.lang.reflect.Field r2 = r1.getDeclaredField(r8)     // Catch: java.lang.NoSuchFieldException -> L3a
            java.lang.String r5 = "field"
            kotlin.jvm.internal.m.d(r2, r5)     // Catch: java.lang.NoSuchFieldException -> L3a
            r2.setAccessible(r3)     // Catch: java.lang.NoSuchFieldException -> L3a
            java.lang.Object r2 = r2.get(r6)     // Catch: java.lang.NoSuchFieldException -> L3a
            boolean r3 = r7.isInstance(r2)     // Catch: java.lang.NoSuchFieldException -> L3a
            if (r3 != 0) goto L35
            goto L39
        L35:
            java.lang.Object r4 = r7.cast(r2)     // Catch: java.lang.NoSuchFieldException -> L3a
        L39:
            return r4
        L3a:
            java.lang.Class r1 = r1.getSuperclass()
            java.lang.String r2 = "c.superclass"
            kotlin.jvm.internal.m.d(r1, r2)
            goto L15
        L44:
            java.lang.String r1 = "delegate"
            boolean r2 = kotlin.jvm.internal.m.c(r8, r1)
            r2 = r2 ^ r3
            if (r2 == 0) goto L58
            java.lang.Object r6 = readFieldOrNull(r6, r0, r1)
            if (r6 == 0) goto L58
            java.lang.Object r6 = readFieldOrNull(r6, r7, r8)
            return r6
        L58:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.readFieldOrNull(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object");
    }

    public static final int readMedium(h readMedium) throws IOException {
        m.h(readMedium, "$this$readMedium");
        return and(readMedium.m0(), 255) | (and(readMedium.m0(), 255) << 16) | (and(readMedium.m0(), 255) << 8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0051, code lost:
        if (r5 == Long.MAX_VALUE) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0053, code lost:
        r11.timeout().clearDeadline();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x005b, code lost:
        r11.timeout().deadlineNanoTime(r0 + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x007d, code lost:
        if (r5 != Long.MAX_VALUE) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0080, code lost:
        return r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean skipAll(j.e0 r11, int r12, java.util.concurrent.TimeUnit r13) throws java.io.IOException {
        /*
            java.lang.String r0 = "$this$skipAll"
            kotlin.jvm.internal.m.h(r11, r0)
            java.lang.String r0 = "timeUnit"
            kotlin.jvm.internal.m.h(r13, r0)
            long r0 = java.lang.System.nanoTime()
            j.f0 r2 = r11.timeout()
            boolean r2 = r2.hasDeadline()
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 == 0) goto L27
            j.f0 r2 = r11.timeout()
            long r5 = r2.deadlineNanoTime()
            long r5 = r5 - r0
            goto L28
        L27:
            r5 = r3
        L28:
            j.f0 r2 = r11.timeout()
            long r7 = (long) r12
            long r12 = r13.toNanos(r7)
            long r12 = java.lang.Math.min(r5, r12)
            long r12 = r12 + r0
            r2.deadlineNanoTime(r12)
            j.f r12 = new j.f     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
            r12.<init>()     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
        L3e:
            r7 = 8192(0x2000, double:4.0474E-320)
            long r7 = r11.read(r12, r7)     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
            r9 = -1
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 == 0) goto L4e
            r12.b()     // Catch: java.lang.Throwable -> L64 java.io.InterruptedIOException -> L7a
            goto L3e
        L4e:
            r12 = 1
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L5b
        L53:
            j.f0 r11 = r11.timeout()
            r11.clearDeadline()
            goto L80
        L5b:
            j.f0 r11 = r11.timeout()
            long r0 = r0 + r5
            r11.deadlineNanoTime(r0)
            goto L80
        L64:
            r12 = move-exception
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L71
            j.f0 r11 = r11.timeout()
            r11.clearDeadline()
            goto L79
        L71:
            j.f0 r11 = r11.timeout()
            long r0 = r0 + r5
            r11.deadlineNanoTime(r0)
        L79:
            throw r12
        L7a:
            r12 = 0
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L5b
            goto L53
        L80:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.skipAll(j.e0, int, java.util.concurrent.TimeUnit):boolean");
    }

    public static final ThreadFactory threadFactory(final String name, final boolean z) {
        m.h(name, "name");
        return new ThreadFactory() { // from class: okhttp3.internal.Util$threadFactory$1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, name);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static final void threadName(String name, a<x> block) {
        m.h(name, "name");
        m.h(block, "block");
        Thread currentThread = Thread.currentThread();
        m.d(currentThread, "currentThread");
        String name2 = currentThread.getName();
        currentThread.setName(name);
        try {
            block.invoke();
        } finally {
            l.b(1);
            currentThread.setName(name2);
            l.a(1);
        }
    }

    public static final List<Header> toHeaderList(Headers toHeaderList) {
        c j2;
        int r;
        m.h(toHeaderList, "$this$toHeaderList");
        j2 = f.j(0, toHeaderList.size());
        r = s.r(j2, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator<Integer> it = j2.iterator();
        while (it.hasNext()) {
            int c2 = ((kotlin.a0.h0) it).c();
            arrayList.add(new Header(toHeaderList.name(c2), toHeaderList.value(c2)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> toHeaders) {
        m.h(toHeaders, "$this$toHeaders");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : toHeaders) {
            builder.addLenient$okhttp(header.component1().U(), header.component2().U());
        }
        return builder.build();
    }

    public static final String toHexString(long j2) {
        String hexString = Long.toHexString(j2);
        m.d(hexString, "java.lang.Long.toHexString(this)");
        return hexString;
    }

    public static final String toHostHeader(HttpUrl toHostHeader, boolean z) {
        boolean V;
        String host;
        m.h(toHostHeader, "$this$toHostHeader");
        V = y.V(toHostHeader.host(), ":", false, 2, null);
        if (V) {
            host = '[' + toHostHeader.host() + ']';
        } else {
            host = toHostHeader.host();
        }
        if (z || toHostHeader.port() != HttpUrl.Companion.defaultPort(toHostHeader.scheme())) {
            return host + ':' + toHostHeader.port();
        }
        return host;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return toHostHeader(httpUrl, z);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> toImmutableList) {
        List K0;
        m.h(toImmutableList, "$this$toImmutableList");
        K0 = z.K0(toImmutableList);
        List<T> unmodifiableList = Collections.unmodifiableList(K0);
        m.d(unmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> toImmutableMap) {
        Map<K, V> i2;
        m.h(toImmutableMap, "$this$toImmutableMap");
        if (toImmutableMap.isEmpty()) {
            i2 = m0.i();
            return i2;
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(toImmutableMap));
        m.d(unmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return unmodifiableMap;
    }

    public static final long toLongOrDefault(String toLongOrDefault, long j2) {
        m.h(toLongOrDefault, "$this$toLongOrDefault");
        try {
            return Long.parseLong(toLongOrDefault);
        } catch (NumberFormatException unused) {
            return j2;
        }
    }

    public static final int toNonNegativeInt(String str, int i2) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > ((long) RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO)) {
                    return RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i2;
    }

    public static final String trimSubstring(String trimSubstring, int i2, int i3) {
        m.h(trimSubstring, "$this$trimSubstring");
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(trimSubstring, i2, i3);
        String substring = trimSubstring.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(trimSubstring, indexOfFirstNonAsciiWhitespace, i3));
        m.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return trimSubstring(str, i2, i3);
    }

    public static final void wait(Object wait) {
        m.h(wait, "$this$wait");
        wait.wait();
    }

    public static final Throwable withSuppressed(Exception withSuppressed, List<? extends Exception> suppressed) {
        m.h(withSuppressed, "$this$withSuppressed");
        m.h(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        for (Exception exc : suppressed) {
            withSuppressed.addSuppressed(exc);
        }
        return withSuppressed;
    }

    public static final void writeMedium(g writeMedium, int i2) throws IOException {
        m.h(writeMedium, "$this$writeMedium");
        writeMedium.R((i2 >>> 16) & 255);
        writeMedium.R((i2 >>> 8) & 255);
        writeMedium.R(i2 & 255);
    }

    public static final int delimiterOffset(String delimiterOffset, char c2, int i2, int i3) {
        m.h(delimiterOffset, "$this$delimiterOffset");
        while (i2 < i3) {
            if (delimiterOffset.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return delimiterOffset(str, c2, i2, i3);
    }

    public static final String toHexString(int i2) {
        String hexString = Integer.toHexString(i2);
        m.d(hexString, "Integer.toHexString(this)");
        return hexString;
    }

    public static final void closeQuietly(Socket closeQuietly) {
        m.h(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(ServerSocket closeQuietly) {
        m.h(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(j.f skipAll, byte b2) {
        m.h(skipAll, "$this$skipAll");
        int i2 = 0;
        while (!skipAll.Q() && skipAll.A(0L) == b2) {
            i2++;
            skipAll.m0();
        }
        return i2;
    }
}