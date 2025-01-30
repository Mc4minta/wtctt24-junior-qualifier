package com.facebook.react.modules.network;

import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import com.facebook.fbreact.specs.NativeNetworkingAndroidSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import j.q;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.client.methods.HttpHead;
import org.spongycastle.i18n.TextBundle;

@e.f.m.x.a.a(name = NetworkingModule.NAME)
/* loaded from: classes2.dex */
public final class NetworkingModule extends NativeNetworkingAndroidSpec {
    private static final int CHUNK_TIMEOUT_NS = 100000000;
    private static final String CONTENT_ENCODING_HEADER_NAME = "content-encoding";
    private static final String CONTENT_TYPE_HEADER_NAME = "content-type";
    private static final int MAX_CHUNK_SIZE_BETWEEN_FLUSHES = 8192;
    public static final String NAME = "Networking";
    private static final String REQUEST_BODY_KEY_BASE64 = "base64";
    private static final String REQUEST_BODY_KEY_FORMDATA = "formData";
    private static final String REQUEST_BODY_KEY_STRING = "string";
    private static final String REQUEST_BODY_KEY_URI = "uri";
    private static final String TAG = "NetworkingModule";
    private static final String USER_AGENT_HEADER_NAME = "user-agent";
    private static e customClientBuilder;
    private final OkHttpClient mClient;
    private final com.facebook.react.modules.network.c mCookieHandler;
    private final com.facebook.react.modules.network.a mCookieJarContainer;
    private final String mDefaultUserAgent;
    private final List<f> mRequestBodyHandlers;
    private final Set<Integer> mRequestIds;
    private final List<g> mResponseHandlers;
    private boolean mShuttingDown;
    private final List<h> mUriHandlers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Interceptor {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DeviceEventManagerModule.RCTDeviceEventEmitter f4956b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f4957c;

        /* renamed from: com.facebook.react.modules.network.NetworkingModule$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0120a implements com.facebook.react.modules.network.h {
            long a = System.nanoTime();

            C0120a() {
            }

            @Override // com.facebook.react.modules.network.h
            public void a(long j2, long j3, boolean z) {
                long nanoTime = System.nanoTime();
                if ((z || NetworkingModule.shouldDispatch(nanoTime, this.a)) && !a.this.a.equals(TextBundle.TEXT_ENTRY)) {
                    a aVar = a.this;
                    n.c(aVar.f4956b, aVar.f4957c, j2, j3);
                    this.a = nanoTime;
                }
            }
        }

        a(String str, DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i2) {
            this.a = str;
            this.f4956b = rCTDeviceEventEmitter;
            this.f4957c = i2;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Response proceed = chain.proceed(chain.request());
            return proceed.newBuilder().body(new j(proceed.body(), new C0120a())).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Callback {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DeviceEventManagerModule.RCTDeviceEventEmitter f4960b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f4961c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f4962d;

        b(int i2, DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, String str, boolean z) {
            this.a = i2;
            this.f4960b = rCTDeviceEventEmitter;
            this.f4961c = str;
            this.f4962d = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            String str;
            if (NetworkingModule.this.mShuttingDown) {
                return;
            }
            NetworkingModule.this.removeRequest(this.a);
            if (iOException.getMessage() != null) {
                str = iOException.getMessage();
            } else {
                str = "Error while executing request: " + iOException.getClass().getSimpleName();
            }
            n.f(this.f4960b, this.a, str, iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (NetworkingModule.this.mShuttingDown) {
                return;
            }
            NetworkingModule.this.removeRequest(this.a);
            n.h(this.f4960b, this.a, response.code(), NetworkingModule.translateHeaders(response.headers()), response.request().url().toString());
            try {
                ResponseBody body = response.body();
                if ("gzip".equalsIgnoreCase(response.header("Content-Encoding")) && body != null) {
                    j.n nVar = new j.n(body.source());
                    String header = response.header("Content-Type");
                    body = ResponseBody.create(header != null ? MediaType.parse(header) : null, -1L, q.d(nVar));
                }
                for (g gVar : NetworkingModule.this.mResponseHandlers) {
                    if (gVar.b(this.f4961c)) {
                        n.a(this.f4960b, this.a, gVar.a(body));
                        n.g(this.f4960b, this.a);
                        return;
                    }
                }
                if (this.f4962d && this.f4961c.equals(TextBundle.TEXT_ENTRY)) {
                    NetworkingModule.this.readWithProgress(this.f4960b, this.a, body);
                    n.g(this.f4960b, this.a);
                    return;
                }
                String str = "";
                if (this.f4961c.equals(TextBundle.TEXT_ENTRY)) {
                    try {
                        str = body.string();
                    } catch (IOException e2) {
                        if (!response.request().method().equalsIgnoreCase(HttpHead.METHOD_NAME)) {
                            n.f(this.f4960b, this.a, e2.getMessage(), e2);
                        }
                    }
                } else if (this.f4961c.equals(NetworkingModule.REQUEST_BODY_KEY_BASE64)) {
                    str = Base64.encodeToString(body.bytes(), 2);
                }
                n.b(this.f4960b, this.a, str);
                n.g(this.f4960b, this.a);
            } catch (IOException e3) {
                n.f(this.f4960b, this.a, e3.getMessage(), e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements com.facebook.react.modules.network.h {
        long a = System.nanoTime();

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DeviceEventManagerModule.RCTDeviceEventEmitter f4964b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f4965c;

        c(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i2) {
            this.f4964b = rCTDeviceEventEmitter;
            this.f4965c = i2;
        }

        @Override // com.facebook.react.modules.network.h
        public void a(long j2, long j3, boolean z) {
            long nanoTime = System.nanoTime();
            if (z || NetworkingModule.shouldDispatch(nanoTime, this.a)) {
                n.d(this.f4964b, this.f4965c, j2, j3);
                this.a = nanoTime;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends GuardedAsyncTask<Void, Void> {
        final /* synthetic */ int a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ReactContext reactContext, int i2) {
            super(reactContext);
            this.a = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            com.facebook.react.common.g.a.a(NetworkingModule.this.mClient, Integer.valueOf(this.a));
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(OkHttpClient.Builder builder);
    }

    /* loaded from: classes2.dex */
    public interface f {
        boolean a(ReadableMap readableMap);

        RequestBody b(ReadableMap readableMap, String str);
    }

    /* loaded from: classes2.dex */
    public interface g {
        WritableMap a(ResponseBody responseBody) throws IOException;

        boolean b(String str);
    }

    /* loaded from: classes2.dex */
    public interface h {
        WritableMap a(Uri uri) throws IOException;

        boolean b(Uri uri, String str);
    }

    NetworkingModule(ReactApplicationContext reactApplicationContext, String str, OkHttpClient okHttpClient, List<com.facebook.react.modules.network.e> list) {
        super(reactApplicationContext);
        this.mRequestBodyHandlers = new ArrayList();
        this.mUriHandlers = new ArrayList();
        this.mResponseHandlers = new ArrayList();
        if (list != null) {
            OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
            for (com.facebook.react.modules.network.e eVar : list) {
                newBuilder.addNetworkInterceptor(eVar.create());
            }
            okHttpClient = newBuilder.build();
        }
        this.mClient = okHttpClient;
        this.mCookieHandler = new com.facebook.react.modules.network.c(reactApplicationContext);
        this.mCookieJarContainer = (com.facebook.react.modules.network.a) okHttpClient.cookieJar();
        this.mShuttingDown = false;
        this.mDefaultUserAgent = str;
        this.mRequestIds = new HashSet();
    }

    private synchronized void addRequest(int i2) {
        this.mRequestIds.add(Integer.valueOf(i2));
    }

    private static void applyCustomBuilder(OkHttpClient.Builder builder) {
        e eVar = customClientBuilder;
        if (eVar != null) {
            eVar.a(builder);
        }
    }

    private synchronized void cancelAllRequests() {
        for (Integer num : this.mRequestIds) {
            cancelRequest(num.intValue());
        }
        this.mRequestIds.clear();
    }

    private void cancelRequest(int i2) {
        new d(getReactApplicationContext(), i2).execute(new Void[0]);
    }

    private MultipartBody.Builder constructMultipartBody(ReadableArray readableArray, String str, int i2) {
        MediaType mediaType;
        DeviceEventManagerModule.RCTDeviceEventEmitter eventEmitter = getEventEmitter("constructMultipartBody");
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MediaType.parse(str));
        int size = readableArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            ReadableMap map = readableArray.getMap(i3);
            Headers extractHeaders = extractHeaders(map.getArray("headers"), null);
            if (extractHeaders == null) {
                n.f(eventEmitter, i2, "Missing or invalid header format for FormData part.", null);
                return null;
            }
            String str2 = extractHeaders.get(CONTENT_TYPE_HEADER_NAME);
            if (str2 != null) {
                mediaType = MediaType.parse(str2);
                extractHeaders = extractHeaders.newBuilder().removeAll(CONTENT_TYPE_HEADER_NAME).build();
            } else {
                mediaType = null;
            }
            if (map.hasKey(REQUEST_BODY_KEY_STRING)) {
                builder.addPart(extractHeaders, RequestBody.create(mediaType, map.getString(REQUEST_BODY_KEY_STRING)));
            } else if (!map.hasKey(REQUEST_BODY_KEY_URI)) {
                n.f(eventEmitter, i2, "Unrecognized FormData part.", null);
            } else if (mediaType == null) {
                n.f(eventEmitter, i2, "Binary FormData part needs a content-type header.", null);
                return null;
            } else {
                String string = map.getString(REQUEST_BODY_KEY_URI);
                InputStream f2 = m.f(getReactApplicationContext(), string);
                if (f2 == null) {
                    n.f(eventEmitter, i2, "Could not retrieve file for uri " + string, null);
                    return null;
                }
                builder.addPart(extractHeaders, m.a(mediaType, f2));
            }
        }
        return builder;
    }

    private Headers extractHeaders(ReadableArray readableArray, ReadableMap readableMap) {
        String str;
        if (readableArray == null) {
            return null;
        }
        Headers.Builder builder = new Headers.Builder();
        int size = readableArray.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            ReadableArray array = readableArray.getArray(i2);
            if (array != null && array.size() == 2) {
                String a2 = com.facebook.react.modules.network.d.a(array.getString(0));
                String b2 = com.facebook.react.modules.network.d.b(array.getString(1));
                if (a2 != null && b2 != null) {
                    builder.add(a2, b2);
                }
            }
            return null;
        }
        if (builder.get(USER_AGENT_HEADER_NAME) == null && (str = this.mDefaultUserAgent) != null) {
            builder.add(USER_AGENT_HEADER_NAME, str);
        }
        if (readableMap != null && readableMap.hasKey(REQUEST_BODY_KEY_STRING)) {
            z = true;
        }
        if (!z) {
            builder.removeAll(CONTENT_ENCODING_HEADER_NAME);
        }
        return builder.build();
    }

    private DeviceEventManagerModule.RCTDeviceEventEmitter getEventEmitter(String str) {
        if (getReactApplicationContextIfActiveOrWarn() != null) {
            return (DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readWithProgress(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i2, ResponseBody responseBody) throws IOException {
        long j2;
        long j3 = -1;
        try {
            j jVar = (j) responseBody;
            j2 = jVar.f();
            try {
                j3 = jVar.contentLength();
            } catch (ClassCastException unused) {
            }
        } catch (ClassCastException unused2) {
            j2 = -1;
        }
        k kVar = new k(responseBody.contentType() == null ? com.facebook.react.common.e.a : responseBody.contentType().charset(com.facebook.react.common.e.a));
        InputStream byteStream = responseBody.byteStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = byteStream.read(bArr);
                if (read == -1) {
                    return;
                }
                n.e(rCTDeviceEventEmitter, i2, kVar.a(bArr, read), j2, j3);
            }
        } finally {
            byteStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeRequest(int i2) {
        this.mRequestIds.remove(Integer.valueOf(i2));
    }

    public static void setCustomClientBuilder(e eVar) {
        customClientBuilder = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldDispatch(long j2, long j3) {
        return j3 + 100000000 < j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WritableMap translateHeaders(Headers headers) {
        Bundle bundle = new Bundle();
        for (int i2 = 0; i2 < headers.size(); i2++) {
            String name = headers.name(i2);
            if (bundle.containsKey(name)) {
                bundle.putString(name, bundle.getString(name) + ", " + headers.value(i2));
            } else {
                bundle.putString(name, headers.value(i2));
            }
        }
        return Arguments.fromBundle(bundle);
    }

    private RequestBody wrapRequestBodyWithProgressEmitter(RequestBody requestBody, DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i2) {
        if (requestBody == null) {
            return null;
        }
        return m.c(requestBody, new c(rCTDeviceEventEmitter, i2));
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void abortRequest(double d2) {
        int i2 = (int) d2;
        cancelRequest(i2);
        removeRequest(i2);
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void addListener(String str) {
    }

    public void addRequestBodyHandler(f fVar) {
        this.mRequestBodyHandlers.add(fVar);
    }

    public void addResponseHandler(g gVar) {
        this.mResponseHandlers.add(gVar);
    }

    public void addUriHandler(h hVar) {
        this.mUriHandlers.add(hVar);
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    @ReactMethod
    public void clearCookies(com.facebook.react.bridge.Callback callback) {
        this.mCookieHandler.g(callback);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        this.mCookieJarContainer.b(new JavaNetCookieJar(this.mCookieHandler));
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
        cancelAllRequests();
        this.mCookieHandler.i();
        this.mCookieJarContainer.a();
        this.mRequestBodyHandlers.clear();
        this.mResponseHandlers.clear();
        this.mUriHandlers.clear();
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void removeListeners(double d2) {
    }

    public void removeRequestBodyHandler(f fVar) {
        this.mRequestBodyHandlers.remove(fVar);
    }

    public void removeResponseHandler(g gVar) {
        this.mResponseHandlers.remove(gVar);
    }

    public void removeUriHandler(h hVar) {
        this.mUriHandlers.remove(hVar);
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void sendRequest(String str, String str2, double d2, ReadableArray readableArray, ReadableMap readableMap, String str3, boolean z, double d3, boolean z2) {
        int i2 = (int) d2;
        try {
            sendRequestInternal(str, str2, i2, readableArray, readableMap, str3, z, (int) d3, z2);
        } catch (Throwable th) {
            e.f.d.d.a.j(TAG, "Failed to send url request: " + str2, th);
            DeviceEventManagerModule.RCTDeviceEventEmitter eventEmitter = getEventEmitter("sendRequest error");
            if (eventEmitter != null) {
                n.f(eventEmitter, i2, th.getMessage(), th);
            }
        }
    }

    public void sendRequestInternal(String str, String str2, int i2, ReadableArray readableArray, ReadableMap readableMap, String str3, boolean z, int i3, boolean z2) {
        f fVar;
        RequestBody e2;
        DeviceEventManagerModule.RCTDeviceEventEmitter eventEmitter = getEventEmitter("sendRequestInternal");
        try {
            Uri parse = Uri.parse(str2);
            for (h hVar : this.mUriHandlers) {
                if (hVar.b(parse, str3)) {
                    n.a(eventEmitter, i2, hVar.a(parse));
                    n.g(eventEmitter, i2);
                    return;
                }
            }
            try {
                Request.Builder url = new Request.Builder().url(str2);
                if (i2 != 0) {
                    url.tag(Integer.valueOf(i2));
                }
                OkHttpClient.Builder newBuilder = this.mClient.newBuilder();
                applyCustomBuilder(newBuilder);
                if (!z2) {
                    newBuilder.cookieJar(CookieJar.NO_COOKIES);
                }
                if (z) {
                    newBuilder.addNetworkInterceptor(new a(str3, eventEmitter, i2));
                }
                if (i3 != this.mClient.connectTimeoutMillis()) {
                    newBuilder.connectTimeout(i3, TimeUnit.MILLISECONDS);
                }
                OkHttpClient build = newBuilder.build();
                Headers extractHeaders = extractHeaders(readableArray, readableMap);
                if (extractHeaders == null) {
                    n.f(eventEmitter, i2, "Unrecognized headers format", null);
                    return;
                }
                String str4 = extractHeaders.get(CONTENT_TYPE_HEADER_NAME);
                String str5 = extractHeaders.get(CONTENT_ENCODING_HEADER_NAME);
                url.headers(extractHeaders);
                if (readableMap != null) {
                    Iterator<f> it = this.mRequestBodyHandlers.iterator();
                    while (it.hasNext()) {
                        fVar = it.next();
                        if (fVar.a(readableMap)) {
                            break;
                        }
                    }
                }
                fVar = null;
                if (readableMap == null || str.toLowerCase().equals("get") || str.toLowerCase().equals("head")) {
                    e2 = m.e(str);
                } else if (fVar != null) {
                    e2 = fVar.b(readableMap, str4);
                } else if (readableMap.hasKey(REQUEST_BODY_KEY_STRING)) {
                    if (str4 == null) {
                        n.f(eventEmitter, i2, "Payload is set but no content-type header specified", null);
                        return;
                    }
                    String string = readableMap.getString(REQUEST_BODY_KEY_STRING);
                    MediaType parse2 = MediaType.parse(str4);
                    if (m.g(str5)) {
                        e2 = m.b(parse2, string);
                        if (e2 == null) {
                            n.f(eventEmitter, i2, "Failed to gzip request body", null);
                            return;
                        }
                    } else {
                        Charset charset = com.facebook.react.common.e.a;
                        if (parse2 != null) {
                            charset = parse2.charset(charset);
                        }
                        e2 = RequestBody.create(parse2, string.getBytes(charset));
                    }
                } else if (readableMap.hasKey(REQUEST_BODY_KEY_BASE64)) {
                    if (str4 == null) {
                        n.f(eventEmitter, i2, "Payload is set but no content-type header specified", null);
                        return;
                    }
                    e2 = RequestBody.create(MediaType.parse(str4), j.i.q(readableMap.getString(REQUEST_BODY_KEY_BASE64)));
                } else if (readableMap.hasKey(REQUEST_BODY_KEY_URI)) {
                    if (str4 == null) {
                        n.f(eventEmitter, i2, "Payload is set but no content-type header specified", null);
                        return;
                    }
                    String string2 = readableMap.getString(REQUEST_BODY_KEY_URI);
                    InputStream f2 = m.f(getReactApplicationContext(), string2);
                    if (f2 == null) {
                        n.f(eventEmitter, i2, "Could not retrieve file for uri " + string2, null);
                        return;
                    }
                    e2 = m.a(MediaType.parse(str4), f2);
                } else if (readableMap.hasKey(REQUEST_BODY_KEY_FORMDATA)) {
                    if (str4 == null) {
                        str4 = "multipart/form-data";
                    }
                    MultipartBody.Builder constructMultipartBody = constructMultipartBody(readableMap.getArray(REQUEST_BODY_KEY_FORMDATA), str4, i2);
                    if (constructMultipartBody == null) {
                        return;
                    }
                    e2 = constructMultipartBody.build();
                } else {
                    e2 = m.e(str);
                }
                url.method(str, wrapRequestBodyWithProgressEmitter(e2, eventEmitter, i2));
                addRequest(i2);
                FirebasePerfOkHttpClient.enqueue(build.newCall(url.build()), new b(i2, eventEmitter, str3, z));
            } catch (Exception e3) {
                n.f(eventEmitter, i2, e3.getMessage(), null);
            }
        } catch (IOException e4) {
            n.f(eventEmitter, i2, e4.getMessage(), e4);
        }
    }

    NetworkingModule(ReactApplicationContext reactApplicationContext, String str, OkHttpClient okHttpClient) {
        this(reactApplicationContext, str, okHttpClient, null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, null, com.facebook.react.modules.network.g.b(reactApplicationContext), null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, List<com.facebook.react.modules.network.e> list) {
        this(reactApplicationContext, null, com.facebook.react.modules.network.g.b(reactApplicationContext), list);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, String str) {
        this(reactApplicationContext, str, com.facebook.react.modules.network.g.b(reactApplicationContext), null);
    }
}