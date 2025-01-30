package com.facebook.react.modules.websocket;

import com.coinbase.ApiConstants;
import com.facebook.fbreact.specs.NativeWebSocketModuleSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.network.c;
import j.i;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.apache.http.HttpHost;
import org.apache.http.cookie.SM;
import org.spongycastle.i18n.TextBundle;

@e.f.m.x.a.a(hasConstants = false, name = "WebSocketModule")
/* loaded from: classes2.dex */
public final class WebSocketModule extends NativeWebSocketModuleSpec {
    public static final String NAME = "WebSocketModule";
    public static final String TAG = "WebSocketModule";
    private final Map<Integer, b> mContentHandlers;
    private c mCookieHandler;
    private final Map<Integer, WebSocket> mWebSocketConnections;

    /* loaded from: classes2.dex */
    public interface b {
        void a(i iVar, WritableMap writableMap);

        void b(String str, WritableMap writableMap);
    }

    public WebSocketModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mWebSocketConnections = new ConcurrentHashMap();
        this.mContentHandlers = new ConcurrentHashMap();
        this.mCookieHandler = new c(reactApplicationContext);
    }

    private String getCookie(String str) {
        try {
            List<String> list = this.mCookieHandler.get(new URI(getDefaultOrigin(str)), new HashMap()).get(SM.COOKIE);
            if (list != null && !list.isEmpty()) {
                return list.get(0);
            }
            return null;
        } catch (IOException | URISyntaxException unused) {
            throw new IllegalArgumentException("Unable to get cookie from " + str);
        }
    }

    private static String getDefaultOrigin(String str) {
        boolean z;
        try {
            String str2 = "";
            URI uri = new URI(str);
            String scheme = uri.getScheme();
            int hashCode = scheme.hashCode();
            if (hashCode == 3804) {
                if (scheme.equals("ws")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 118039) {
                if (scheme.equals("wss")) {
                    z = false;
                }
                z = true;
            } else if (hashCode != 3213448) {
                if (hashCode == 99617003 && scheme.equals("https")) {
                    z = true;
                }
                z = true;
            } else {
                if (scheme.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
                    z = true;
                }
                z = true;
            }
            if (!z) {
                str2 = "https";
            } else if (z) {
                str2 = "" + HttpHost.DEFAULT_SCHEME_NAME;
            } else if (z || z) {
                str2 = "" + uri.getScheme();
            }
            return uri.getPort() != -1 ? String.format("%s://%s:%s", str2, uri.getHost(), Integer.valueOf(uri.getPort())) : String.format("%s://%s", str2, uri.getHost());
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("Unable to set " + str + " as default origin header");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyWebSocketFailed(int i2, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", i2);
        createMap.putString(ApiConstants.MESSAGE, str);
        sendEvent("websocketFailed", createMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(String str, WritableMap writableMap) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContextIfActiveOrWarn.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void addListener(String str) {
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void close(double d2, String str, double d3) {
        int i2 = (int) d3;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i2));
        if (webSocket == null) {
            return;
        }
        try {
            webSocket.close((int) d2, str);
            this.mWebSocketConnections.remove(Integer.valueOf(i2));
            this.mContentHandlers.remove(Integer.valueOf(i2));
        } catch (Exception e2) {
            e.f.d.d.a.j("ReactNative", "Could not close WebSocket connection for id " + i2, e2);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void connect(String str, ReadableArray readableArray, ReadableMap readableMap, double d2) {
        boolean z;
        int i2 = (int) d2;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = builder.connectTimeout(10L, timeUnit).writeTimeout(10L, timeUnit).readTimeout(0L, TimeUnit.MINUTES).build();
        Request.Builder url = new Request.Builder().tag(Integer.valueOf(i2)).url(str);
        String cookie = getCookie(str);
        if (cookie != null) {
            url.addHeader(SM.COOKIE, cookie);
        }
        if (readableMap != null && readableMap.hasKey("headers") && readableMap.getType("headers").equals(ReadableType.Map)) {
            ReadableMap map = readableMap.getMap("headers");
            ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
            z = false;
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                if (ReadableType.String.equals(map.getType(nextKey))) {
                    if (nextKey.equalsIgnoreCase("origin")) {
                        z = true;
                    }
                    url.addHeader(nextKey, map.getString(nextKey));
                } else {
                    e.f.d.d.a.A("ReactNative", "Ignoring: requested " + nextKey + ", value not a string");
                }
            }
        } else {
            z = false;
        }
        if (!z) {
            url.addHeader("origin", getDefaultOrigin(str));
        }
        if (readableArray != null && readableArray.size() > 0) {
            StringBuilder sb = new StringBuilder("");
            for (int i3 = 0; i3 < readableArray.size(); i3++) {
                String trim = readableArray.getString(i3).trim();
                if (!trim.isEmpty() && !trim.contains(",")) {
                    sb.append(trim);
                    sb.append(",");
                }
            }
            if (sb.length() > 0) {
                sb.replace(sb.length() - 1, sb.length(), "");
                url.addHeader("Sec-WebSocket-Protocol", sb.toString());
            }
        }
        build.newWebSocket(url.build(), new a(i2));
        build.dispatcher().executorService().shutdown();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "WebSocketModule";
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void ping(double d2) {
        int i2 = (int) d2;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i2));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i2);
            createMap.putString(ApiConstants.MESSAGE, "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i2);
            createMap2.putInt("code", 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i2));
            this.mContentHandlers.remove(Integer.valueOf(i2));
            return;
        }
        try {
            webSocket.send(i.a);
        } catch (Exception e2) {
            notifyWebSocketFailed(i2, e2.getMessage());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void removeListeners(double d2) {
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void send(String str, double d2) {
        int i2 = (int) d2;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i2));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i2);
            createMap.putString(ApiConstants.MESSAGE, "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i2);
            createMap2.putInt("code", 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i2));
            this.mContentHandlers.remove(Integer.valueOf(i2));
            return;
        }
        try {
            webSocket.send(str);
        } catch (Exception e2) {
            notifyWebSocketFailed(i2, e2.getMessage());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void sendBinary(String str, double d2) {
        int i2 = (int) d2;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i2));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i2);
            createMap.putString(ApiConstants.MESSAGE, "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i2);
            createMap2.putInt("code", 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i2));
            this.mContentHandlers.remove(Integer.valueOf(i2));
            return;
        }
        try {
            webSocket.send(i.q(str));
        } catch (Exception e2) {
            notifyWebSocketFailed(i2, e2.getMessage());
        }
    }

    public void setContentHandler(int i2, b bVar) {
        if (bVar != null) {
            this.mContentHandlers.put(Integer.valueOf(i2), bVar);
        } else {
            this.mContentHandlers.remove(Integer.valueOf(i2));
        }
    }

    /* loaded from: classes2.dex */
    class a extends WebSocketListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // okhttp3.WebSocketListener
        public void onClosed(WebSocket webSocket, int i2, String str) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", this.a);
            createMap.putInt("code", i2);
            createMap.putString("reason", str);
            WebSocketModule.this.sendEvent("websocketClosed", createMap);
        }

        @Override // okhttp3.WebSocketListener
        public void onClosing(WebSocket webSocket, int i2, String str) {
            webSocket.close(i2, str);
        }

        @Override // okhttp3.WebSocketListener
        public void onFailure(WebSocket webSocket, Throwable th, Response response) {
            WebSocketModule.this.notifyWebSocketFailed(this.a, th.getMessage());
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket webSocket, String str) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", this.a);
            createMap.putString("type", TextBundle.TEXT_ENTRY);
            b bVar = (b) WebSocketModule.this.mContentHandlers.get(Integer.valueOf(this.a));
            if (bVar != null) {
                bVar.b(str, createMap);
            } else {
                createMap.putString("data", str);
            }
            WebSocketModule.this.sendEvent("websocketMessage", createMap);
        }

        @Override // okhttp3.WebSocketListener
        public void onOpen(WebSocket webSocket, Response response) {
            WebSocketModule.this.mWebSocketConnections.put(Integer.valueOf(this.a), webSocket);
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", this.a);
            createMap.putString("protocol", response.header("Sec-WebSocket-Protocol", ""));
            WebSocketModule.this.sendEvent("websocketOpen", createMap);
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket webSocket, i iVar) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", this.a);
            createMap.putString("type", "binary");
            b bVar = (b) WebSocketModule.this.mContentHandlers.get(Integer.valueOf(this.a));
            if (bVar != null) {
                bVar.a(iVar, createMap);
            } else {
                createMap.putString("data", iVar.h());
            }
            WebSocketModule.this.sendEvent("websocketMessage", createMap);
        }
    }

    public void sendBinary(i iVar, int i2) {
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i2));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i2);
            createMap.putString(ApiConstants.MESSAGE, "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i2);
            createMap2.putInt("code", 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i2));
            this.mContentHandlers.remove(Integer.valueOf(i2));
            return;
        }
        try {
            webSocket.send(iVar);
        } catch (Exception e2) {
            notifyWebSocketFailed(i2, e2.getMessage());
        }
    }
}