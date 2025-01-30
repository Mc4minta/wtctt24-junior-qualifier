package com.toshi.view.activity.webView;

import android.content.Context;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import com.coinbase.cipherwebview.CipherWebView;
import com.squareup.moshi.Moshi;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import kotlin.a0.r;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: CbWalletJavascriptInterface.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final a a = new a(null);

    /* renamed from: b */
    private static final List<String> f11148b;

    /* renamed from: c */
    private final Context f11149c;

    /* renamed from: d */
    private final Moshi f11150d;

    /* renamed from: e */
    private final CipherWebView f11151e;

    /* renamed from: f */
    private final l<String, x> f11152f;

    /* renamed from: g */
    private final kotlin.e0.c.a<x> f11153g;

    /* compiled from: CbWalletJavascriptInterface.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        List<String> j2;
        j2 = r.j("localhost", "wallet-dapps.firebaseapp.com", "toshi.org", "wallet.coinbase.com");
        f11148b = j2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Context context, Moshi moshi, CipherWebView cipherWebView, l<? super String, x> onRemoveBookmarkListener, kotlin.e0.c.a<x> onLoadBookmarksListener) {
        m.g(context, "context");
        m.g(moshi, "moshi");
        m.g(cipherWebView, "cipherWebView");
        m.g(onRemoveBookmarkListener, "onRemoveBookmarkListener");
        m.g(onLoadBookmarksListener, "onLoadBookmarksListener");
        this.f11149c = context;
        this.f11150d = moshi;
        this.f11151e = cipherWebView;
        this.f11152f = onRemoveBookmarkListener;
        this.f11153g = onLoadBookmarksListener;
    }

    private final String a(String str) {
        return "\n            (() => {\n                const e = new Event('cbWallet.loadBookmarks')\n                e.value = " + str + "\n                window.dispatchEvent(e)\n            })()\n        ";
    }

    private final Message b(String str) {
        try {
            return new MessageJsonAdapter(this.f11150d).fromJson(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x00d0, code lost:
        com.coinbase.wallet.analytics.Analytics.INSTANCE.log(com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt.dappDirectoryLanded(com.coinbase.wallet.analytics.models.AnalyticsEvent.Companion));
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x00db, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0042, code lost:
        if (r0.equals("dapps_screen_view") == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x004b, code lost:
        if (r0.equals("dapp_directory.landed") == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void c(com.toshi.view.activity.webView.Message r5) {
        /*
            r4 = this;
            java.util.List r0 = r5.a()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            com.toshi.view.activity.webView.DappInfoJsonAdapter r1 = new com.toshi.view.activity.webView.DappInfoJsonAdapter
            com.squareup.moshi.Moshi r2 = r4.f11150d
            r1.<init>(r2)
            int r2 = r0.hashCode()
            r3 = -63969491(0xfffffffffc2fe72d, float:-3.653363E36)
            if (r2 == r3) goto L45
            r3 = 417225903(0x18de5caf, float:5.747924E-24)
            if (r2 == r3) goto L3c
            r3 = 1366391878(0x51717c46, float:6.4823255E10)
            if (r2 == r3) goto L26
            goto L4d
        L26:
            java.lang.String r2 = "dapps_tab.what_are_dapps.landed"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L2f
            goto L4d
        L2f:
            com.coinbase.wallet.analytics.Analytics r5 = com.coinbase.wallet.analytics.Analytics.INSTANCE
            com.coinbase.wallet.analytics.models.AnalyticsEvent$Companion r0 = com.coinbase.wallet.analytics.models.AnalyticsEvent.Companion
            com.coinbase.wallet.analytics.models.AnalyticsEvent r0 = com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt.whatAreDappsLanded(r0)
            r5.log(r0)
            goto Ldb
        L3c:
            java.lang.String r2 = "dapps_screen_view"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto Ld0
            goto L4d
        L45:
            java.lang.String r2 = "dapp_directory.landed"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto Ld0
        L4d:
            java.util.List r5 = r5.a()
            r2 = 1
            java.lang.Object r5 = r5.get(r2)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r1.fromJson(r5)
            com.toshi.view.activity.webView.DappInfo r5 = (com.toshi.view.activity.webView.DappInfo) r5
            java.lang.String r1 = ""
            if (r5 != 0) goto L64
        L62:
            r2 = r1
            goto L72
        L64:
            java.util.List r2 = r5.a()
            if (r2 != 0) goto L6b
            goto L62
        L6b:
            java.lang.String r2 = e.j.f.g.b(r2)
            if (r2 != 0) goto L72
            goto L62
        L72:
            if (r5 != 0) goto L75
            goto L7d
        L75:
            java.lang.String r5 = r5.b()
            if (r5 != 0) goto L7c
            goto L7d
        L7c:
            r1 = r5
        L7d:
            int r5 = r0.hashCode()
            r3 = 305631696(0x123791d0, float:5.7924346E-28)
            if (r5 == r3) goto Lbb
            r3 = 1215652485(0x48756285, float:251274.08)
            if (r5 == r3) goto La6
            r3 = 2114075989(0x7e023d55, float:4.3279523E37)
            if (r5 == r3) goto L91
            goto Ldb
        L91:
            java.lang.String r5 = "dapps_tab.dapp_bookmarked"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L9a
            goto Ldb
        L9a:
            com.coinbase.wallet.analytics.Analytics r5 = com.coinbase.wallet.analytics.Analytics.INSTANCE
            com.coinbase.wallet.analytics.models.AnalyticsEvent$Companion r0 = com.coinbase.wallet.analytics.models.AnalyticsEvent.Companion
            com.coinbase.wallet.analytics.models.AnalyticsEvent r0 = com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt.dappsTabDappBookmarked(r0, r1, r2)
            r5.log(r0)
            goto Ldb
        La6:
            java.lang.String r5 = "dapp_detail.landed"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto Laf
            goto Ldb
        Laf:
            com.coinbase.wallet.analytics.Analytics r5 = com.coinbase.wallet.analytics.Analytics.INSTANCE
            com.coinbase.wallet.analytics.models.AnalyticsEvent$Companion r0 = com.coinbase.wallet.analytics.models.AnalyticsEvent.Companion
            com.coinbase.wallet.analytics.models.AnalyticsEvent r0 = com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt.dappDetailLanded(r0, r1, r2)
            r5.log(r0)
            goto Ldb
        Lbb:
            java.lang.String r5 = "dapp_detail.dapp_opened"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto Lc4
            goto Ldb
        Lc4:
            com.coinbase.wallet.analytics.Analytics r5 = com.coinbase.wallet.analytics.Analytics.INSTANCE
            com.coinbase.wallet.analytics.models.AnalyticsEvent$Companion r0 = com.coinbase.wallet.analytics.models.AnalyticsEvent.Companion
            com.coinbase.wallet.analytics.models.AnalyticsEvent r0 = com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt.dappDetailDappOpened(r0, r1, r2)
            r5.log(r0)
            goto Ldb
        Ld0:
            com.coinbase.wallet.analytics.Analytics r5 = com.coinbase.wallet.analytics.Analytics.INSTANCE
            com.coinbase.wallet.analytics.models.AnalyticsEvent$Companion r0 = com.coinbase.wallet.analytics.models.AnalyticsEvent.Companion
            com.coinbase.wallet.analytics.models.AnalyticsEvent r0 = com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt.dappDirectoryLanded(r0)
            r5.log(r0)
        Ldb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.toshi.view.activity.webView.b.c(com.toshi.view.activity.webView.Message):void");
    }

    private final void d(Message message) {
        String c2 = message.c();
        int hashCode = c2.hashCode();
        if (hashCode == -1115390025) {
            if (c2.equals("loadBookmarks") && f()) {
                h();
            }
        } else if (hashCode == 410926554) {
            if (c2.equals("removeBookmark")) {
                j(message);
            }
        } else if (hashCode == 1989757366 && c2.equals("logEvent")) {
            c(message);
        }
    }

    public static /* synthetic */ void g(b bVar, Message message) {
        i(bVar, message);
    }

    private final void h() {
        this.f11153g.invoke();
    }

    public static final void i(b this$0, Message message) {
        m.g(this$0, "this$0");
        m.g(message, "$message");
        this$0.d(message);
    }

    private final void j(Message message) {
        if (f() && (!message.a().isEmpty())) {
            this.f11152f.invoke(message.a().get(0));
        }
    }

    public final void e(List<JSBookmark> bookmarks) {
        m.g(bookmarks, "bookmarks");
        this.f11151e.evaluateJavaScript(a(JSBookmark.a.a(bookmarks)));
    }

    public final boolean f() {
        boolean O;
        try {
            URL url = new URL(this.f11151e.getWebView().getUrl());
            for (String str : f11148b) {
                String host = url.getHost();
                m.f(host, "url.host");
                O = kotlin.l0.x.O(host, str, true);
                if (O) {
                    return true;
                }
            }
        } catch (MalformedURLException unused) {
        }
        return false;
    }

    @JavascriptInterface
    public final void postMessage(String messageJson) {
        m.g(messageJson, "messageJson");
        final Message b2 = b(messageJson);
        if (b2 == null) {
            return;
        }
        new Handler(this.f11149c.getMainLooper()).post(new Runnable() { // from class: com.toshi.view.activity.webView.a
            @Override // java.lang.Runnable
            public final void run() {
                b.g(b.this, b2);
            }
        });
    }
}