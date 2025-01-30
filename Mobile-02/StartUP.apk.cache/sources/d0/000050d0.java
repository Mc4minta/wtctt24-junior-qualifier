package io.branch.referral;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.JSONObject;

/* compiled from: BranchViewHandler.java */
/* loaded from: classes2.dex */
public class j {
    private static j a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f16986b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f16987c;

    /* renamed from: d  reason: collision with root package name */
    private c f16988d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16989e = false;

    /* renamed from: f  reason: collision with root package name */
    private String f16990f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16991g;

    /* renamed from: h  reason: collision with root package name */
    private Dialog f16992h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BranchViewHandler.java */
    /* loaded from: classes2.dex */
    public class a extends WebViewClient {
        final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f16993b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WebView f16994c;

        a(c cVar, d dVar, WebView webView) {
            this.a = cVar;
            this.f16993b = dVar;
            this.f16994c = webView;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            j.this.p(this.a, this.f16993b, this.f16994c);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            j.this.f16991g = true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            boolean l2 = j.this.l(str);
            if (l2) {
                if (j.this.f16992h != null) {
                    j.this.f16992h.dismiss();
                }
            } else {
                webView.loadUrl(str);
            }
            return l2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BranchViewHandler.java */
    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnDismissListener {
        final /* synthetic */ d a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f16996b;

        b(d dVar, c cVar) {
            this.a = dVar;
            this.f16996b = cVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            j.this.f16986b = false;
            j.this.f16992h = null;
            if (this.a != null) {
                if (j.this.f16987c) {
                    this.a.e(this.f16996b.f16998b, this.f16996b.a);
                } else {
                    this.a.b(this.f16996b.f16998b, this.f16996b.a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BranchViewHandler.java */
    /* loaded from: classes2.dex */
    public class c {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private String f16998b;

        /* renamed from: c  reason: collision with root package name */
        private int f16999c;

        /* renamed from: d  reason: collision with root package name */
        private String f17000d;

        /* renamed from: e  reason: collision with root package name */
        private String f17001e;

        /* synthetic */ c(j jVar, JSONObject jSONObject, String str, a aVar) {
            this(jSONObject, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g(Context context) {
            int p = q.B(context).p(this.a);
            int i2 = this.f16999c;
            return i2 > p || i2 == -1;
        }

        public void h(Context context, String str) {
            q.B(context).C0(str);
        }

        private c(JSONObject jSONObject, String str) {
            this.a = "";
            this.f16998b = "";
            this.f16999c = 1;
            this.f17000d = "";
            this.f17001e = "";
            try {
                this.f16998b = str;
                l lVar = l.BranchViewID;
                if (jSONObject.has(lVar.h())) {
                    this.a = jSONObject.getString(lVar.h());
                }
                l lVar2 = l.BranchViewNumOfUse;
                if (jSONObject.has(lVar2.h())) {
                    this.f16999c = jSONObject.getInt(lVar2.h());
                }
                l lVar3 = l.BranchViewUrl;
                if (jSONObject.has(lVar3.h())) {
                    this.f17000d = jSONObject.getString(lVar3.h());
                }
                l lVar4 = l.BranchViewHtml;
                if (jSONObject.has(lVar4.h())) {
                    this.f17001e = jSONObject.getString(lVar4.h());
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: BranchViewHandler.java */
    /* loaded from: classes2.dex */
    public interface d {
        void b(String str, String str2);

        void d(int i2, String str, String str2);

        void e(String str, String str2);

        void f(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BranchViewHandler.java */
    /* loaded from: classes2.dex */
    public class e extends AsyncTask<Void, Void, Boolean> {
        private final c a;

        /* renamed from: b  reason: collision with root package name */
        private final Context f17003b;

        /* renamed from: c  reason: collision with root package name */
        private final d f17004c;

        public e(c cVar, Context context, d dVar) {
            this.a = cVar;
            this.f17003b = context;
            this.f17004c = dVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Boolean doInBackground(java.lang.Void... r8) {
            /*
                r7 = this;
                r8 = 0
                r0 = 200(0xc8, float:2.8E-43)
                r1 = -1
                java.net.URL r2 = new java.net.URL     // Catch: java.lang.Exception -> L53
                io.branch.referral.j$c r3 = r7.a     // Catch: java.lang.Exception -> L53
                java.lang.String r3 = io.branch.referral.j.c.b(r3)     // Catch: java.lang.Exception -> L53
                r2.<init>(r3)     // Catch: java.lang.Exception -> L53
                java.net.URLConnection r2 = r2.openConnection()     // Catch: java.lang.Exception -> L53
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch: java.lang.Exception -> L53
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch: java.lang.Exception -> L53
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch: java.lang.Exception -> L53
                java.lang.String r3 = "GET"
                r2.setRequestMethod(r3)     // Catch: java.lang.Exception -> L53
                r2.connect()     // Catch: java.lang.Exception -> L53
                int r3 = r2.getResponseCode()     // Catch: java.lang.Exception -> L53
                if (r3 != r0) goto L54
                java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Exception -> L52
                r4.<init>()     // Catch: java.lang.Exception -> L52
                java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Exception -> L52
                r5 = 1024(0x400, float:1.435E-42)
                byte[] r5 = new byte[r5]     // Catch: java.lang.Exception -> L52
            L36:
                int r6 = r2.read(r5)     // Catch: java.lang.Exception -> L52
                if (r6 == r1) goto L40
                r4.write(r5, r8, r6)     // Catch: java.lang.Exception -> L52
                goto L36
            L40:
                io.branch.referral.j$c r1 = r7.a     // Catch: java.lang.Exception -> L52
                java.lang.String r5 = "UTF-8"
                java.lang.String r5 = r4.toString(r5)     // Catch: java.lang.Exception -> L52
                io.branch.referral.j.c.e(r1, r5)     // Catch: java.lang.Exception -> L52
                r4.close()     // Catch: java.lang.Exception -> L52
                r2.close()     // Catch: java.lang.Exception -> L52
                goto L54
            L52:
                r1 = r3
            L53:
                r3 = r1
            L54:
                if (r3 != r0) goto L57
                r8 = 1
            L57:
                java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.j.e.doInBackground(java.lang.Void[]):java.lang.Boolean");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                j.this.j(this.a, this.f17003b, this.f17004c);
            } else {
                d dVar = this.f17004c;
                if (dVar != null) {
                    dVar.d(-202, "Unable to create a Branch view due to a temporary network error", this.a.f16998b);
                }
            }
            j.this.f16989e = false;
        }
    }

    private j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(c cVar, Context context, d dVar) {
        if (context == null || cVar == null) {
            return;
        }
        WebView webView = new WebView(context);
        webView.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            webView.setLayerType(2, null);
        }
        this.f16991g = false;
        if (TextUtils.isEmpty(cVar.f17001e)) {
            return;
        }
        webView.loadDataWithBaseURL(null, cVar.f17001e, "text/html", "utf-8", null);
        webView.setWebViewClient(new a(cVar, dVar, webView));
    }

    public static j k() {
        if (a == null) {
            a = new j();
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(String str) {
        try {
            URI uri = new URI(str);
            if (uri.getScheme().equalsIgnoreCase("branch-cta")) {
                if (uri.getHost().equalsIgnoreCase("accept")) {
                    this.f16987c = true;
                } else if (!uri.getHost().equalsIgnoreCase("cancel")) {
                    return false;
                } else {
                    this.f16987c = false;
                }
                return true;
            }
            return false;
        } catch (URISyntaxException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(c cVar, d dVar, WebView webView) {
        if (!this.f16991g && io.branch.referral.b.V() != null && io.branch.referral.b.V().F != null) {
            Activity activity = io.branch.referral.b.V().F.get();
            if (activity != null) {
                cVar.h(activity.getApplicationContext(), cVar.a);
                this.f16990f = activity.getClass().getName();
                RelativeLayout relativeLayout = new RelativeLayout(activity);
                relativeLayout.setVisibility(8);
                relativeLayout.addView(webView, new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout.setBackgroundColor(0);
                Dialog dialog = this.f16992h;
                if (dialog != null && dialog.isShowing()) {
                    if (dVar != null) {
                        dVar.d(-200, "Unable to create a Branch view. A Branch view is already showing", cVar.f16998b);
                        return;
                    }
                    return;
                }
                Dialog dialog2 = new Dialog(activity, 16973834);
                this.f16992h = dialog2;
                dialog2.setContentView(relativeLayout);
                relativeLayout.setVisibility(0);
                webView.setVisibility(0);
                this.f16992h.show();
                t(relativeLayout);
                t(webView);
                this.f16986b = true;
                if (dVar != null) {
                    dVar.f(cVar.f16998b, cVar.a);
                }
                this.f16992h.setOnDismissListener(new b(dVar, cVar));
                return;
            }
            return;
        }
        this.f16986b = false;
        if (dVar != null) {
            dVar.d(-202, "Unable to create a Branch view due to a temporary network error", cVar.f16998b);
        }
    }

    private boolean q(c cVar, Context context, d dVar) {
        if (this.f16986b || this.f16989e) {
            if (dVar != null) {
                dVar.d(-200, "Unable to create a Branch view. A Branch view is already showing", cVar.f16998b);
            }
            return false;
        }
        this.f16986b = false;
        this.f16987c = false;
        if (context != null && cVar != null) {
            if (cVar.g(context)) {
                if (!TextUtils.isEmpty(cVar.f17001e)) {
                    j(cVar, context, dVar);
                } else {
                    this.f16989e = true;
                    new e(cVar, context, dVar).execute(new Void[0]);
                }
                return true;
            } else if (dVar != null) {
                dVar.d(-203, "Unable to create this Branch view. Reached maximum usage limit ", cVar.f16998b);
            }
        }
        return false;
    }

    private void t(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setStartOffset(10L);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setFillAfter(true);
        view.setVisibility(0);
        view.startAnimation(alphaAnimation);
    }

    public boolean m(Context context) {
        c cVar = this.f16988d;
        return cVar != null && cVar.g(context);
    }

    public boolean n(JSONObject jSONObject, String str) {
        Activity activity;
        c cVar = new c(this, jSONObject, str, null);
        if (io.branch.referral.b.V().F == null || (activity = io.branch.referral.b.V().F.get()) == null || !cVar.g(activity)) {
            return false;
        }
        this.f16988d = new c(this, jSONObject, str, null);
        return true;
    }

    public void o(Activity activity) {
        String str = this.f16990f;
        if (str == null || !str.equalsIgnoreCase(activity.getClass().getName())) {
            return;
        }
        this.f16986b = false;
    }

    public boolean r(JSONObject jSONObject, String str, Context context, d dVar) {
        return q(new c(this, jSONObject, str, null), context, dVar);
    }

    public boolean s(Context context) {
        boolean q = q(this.f16988d, context, null);
        if (q) {
            this.f16988d = null;
        }
        return q;
    }
}