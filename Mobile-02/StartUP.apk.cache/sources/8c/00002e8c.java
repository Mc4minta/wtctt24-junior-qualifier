package com.facebook.react.modules.network;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.GuardedResultAsyncTask;
import com.facebook.react.bridge.ReactContext;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.http.cookie.SM;

/* compiled from: ForwardingCookieHandler.java */
/* loaded from: classes2.dex */
public class c extends CookieHandler {
    private static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final e f4968b = new e();

    /* renamed from: c  reason: collision with root package name */
    private final ReactContext f4969c;

    /* renamed from: d  reason: collision with root package name */
    private CookieManager f4970d;

    /* compiled from: ForwardingCookieHandler.java */
    /* loaded from: classes2.dex */
    class a extends GuardedResultAsyncTask<Boolean> {
        final /* synthetic */ Callback a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ReactContext reactContext, Callback callback) {
            super(reactContext);
            this.a = callback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedResultAsyncTask
        /* renamed from: a */
        public Boolean doInBackgroundGuarded() {
            CookieManager j2 = c.this.j();
            if (j2 != null) {
                j2.removeAllCookie();
            }
            c.this.f4968b.c();
            return Boolean.TRUE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedResultAsyncTask
        /* renamed from: b */
        public void onPostExecuteGuarded(Boolean bool) {
            this.a.invoke(bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ForwardingCookieHandler.java */
    /* loaded from: classes2.dex */
    public class b implements ValueCallback<Boolean> {
        final /* synthetic */ Callback a;

        b(Callback callback) {
            this.a = callback;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(Boolean bool) {
            c.this.f4968b.c();
            this.a.invoke(bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ForwardingCookieHandler.java */
    /* renamed from: com.facebook.react.modules.network.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0121c implements Runnable {
        final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CookieManager f4973b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f4974c;

        RunnableC0121c(List list, CookieManager cookieManager, String str) {
            this.a = list;
            this.f4973b = cookieManager;
            this.f4974c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.a) {
                this.f4973b.setCookie(this.f4974c, str);
            }
            c.this.f4968b.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ForwardingCookieHandler.java */
    /* loaded from: classes2.dex */
    public class d extends GuardedAsyncTask<Void, Void> {
        final /* synthetic */ Runnable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ReactContext reactContext, Runnable runnable) {
            super(reactContext);
            this.a = runnable;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            this.a.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ForwardingCookieHandler.java */
    /* loaded from: classes2.dex */
    public class e {
        private final Handler a;

        /* compiled from: ForwardingCookieHandler.java */
        /* loaded from: classes2.dex */
        class a implements Handler.Callback {
            final /* synthetic */ c a;

            a(c cVar) {
                this.a = cVar;
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 1) {
                    e.this.d();
                    return true;
                }
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ForwardingCookieHandler.java */
        /* loaded from: classes2.dex */
        public class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!c.a) {
                    e.this.b();
                } else {
                    CookieSyncManager.getInstance().sync();
                }
            }
        }

        public e() {
            this.a = new Handler(Looper.getMainLooper(), new a(c.this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(21)
        public void b() {
            CookieManager j2 = c.this.j();
            if (j2 != null) {
                j2.flush();
            }
        }

        public void c() {
            if (c.a) {
                this.a.sendEmptyMessageDelayed(1, 30000L);
            }
        }

        public void d() {
            this.a.removeMessages(1);
            c.this.m(new b());
        }
    }

    static {
        a = Build.VERSION.SDK_INT < 21;
    }

    public c(ReactContext reactContext) {
        this.f4969c = reactContext;
    }

    @TargetApi(21)
    private void e(String str, String str2) {
        CookieManager j2 = j();
        if (j2 != null) {
            j2.setCookie(str, str2, null);
        }
    }

    private void h(Callback callback) {
        CookieManager j2 = j();
        if (j2 != null) {
            j2.removeAllCookies(new b(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CookieManager j() {
        if (this.f4970d == null) {
            l(this.f4969c);
            try {
                CookieManager cookieManager = CookieManager.getInstance();
                this.f4970d = cookieManager;
                if (a) {
                    cookieManager.removeExpiredCookie();
                }
            } catch (IllegalArgumentException unused) {
                return null;
            } catch (Exception e2) {
                if (e2.getMessage() == null || !e2.getClass().getCanonicalName().equals("android.webkit.WebViewFactory.MissingWebViewPackageException")) {
                    throw e2;
                }
                return null;
            }
        }
        return this.f4970d;
    }

    private static boolean k(String str) {
        return str.equalsIgnoreCase("Set-cookie") || str.equalsIgnoreCase("Set-cookie2");
    }

    private static void l(Context context) {
        if (a) {
            CookieSyncManager.createInstance(context).sync();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Runnable runnable) {
        new d(this.f4969c, runnable).execute(new Void[0]);
    }

    public void f(String str, List<String> list) {
        CookieManager j2 = j();
        if (j2 == null) {
            return;
        }
        if (a) {
            m(new RunnableC0121c(list, j2, str));
            return;
        }
        for (String str2 : list) {
            e(str, str2);
        }
        j2.flush();
        this.f4968b.c();
    }

    public void g(Callback callback) {
        if (a) {
            new a(this.f4969c, callback).execute(new Void[0]);
        } else {
            h(callback);
        }
    }

    @Override // java.net.CookieHandler
    public Map<String, List<String>> get(URI uri, Map<String, List<String>> map) throws IOException {
        CookieManager j2 = j();
        if (j2 == null) {
            return Collections.emptyMap();
        }
        String cookie = j2.getCookie(uri.toString());
        if (TextUtils.isEmpty(cookie)) {
            return Collections.emptyMap();
        }
        return Collections.singletonMap(SM.COOKIE, Collections.singletonList(cookie));
    }

    public void i() {
        if (a) {
            CookieManager j2 = j();
            if (j2 != null) {
                j2.removeExpiredCookie();
            }
            this.f4968b.d();
        }
    }

    @Override // java.net.CookieHandler
    public void put(URI uri, Map<String, List<String>> map) throws IOException {
        String uri2 = uri.toString();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key != null && k(key)) {
                f(uri2, entry.getValue());
            }
        }
    }
}