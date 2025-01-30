package com.coinbase.wallet.routing.repositories;

import android.app.Activity;
import android.net.Uri;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.common.extensions.JsonObject_CommonKt;
import com.coinbase.wallet.common.extensions.String_CommonKt;
import h.c.a0;
import h.c.b0;
import h.c.d0;
import h.c.f0;
import h.c.m0.f;
import h.c.s;
import h.c.u;
import h.c.v;
import io.branch.referral.b;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.json.JSONObject;

/* compiled from: DeepLinkRepository.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b%\u0010&J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00070\u00070\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0019\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/coinbase/wallet/routing/repositories/DeepLinkRepository;", "", "", "url", "Lkotlin/x;", "pushDappDeeplink", "(Ljava/lang/String;)V", "Landroid/net/Uri;", "uri", "pushNewIntentUrl", "(Landroid/net/Uri;)V", "Landroid/app/Activity;", "mainActivity", "Lh/c/s;", "setupSession", "(Landroid/app/Activity;)Lh/c/s;", "dappLink", "activity", "Lh/c/b0;", "createDappDeepLink", "(Ljava/lang/String;Landroid/app/Activity;)Lh/c/b0;", "Lh/c/v0/a;", "dappDeepLinksBehaviorSubject", "Lh/c/v0/a;", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "intentUriSubject", "Lh/c/v0/b;", "Lh/c/a0;", "concurrentScheduler", "Lh/c/a0;", "Lio/branch/referral/b;", "branch", "Lio/branch/referral/b;", "getDappDeepLinkObservable", "()Lh/c/s;", "dappDeepLinkObservable", "<init>", "(Lio/branch/referral/b;)V", "Companion", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DeepLinkRepository {
    private static final String ACTION_PARAM_KEY = "cb_action";
    public static final Companion Companion = new Companion(null);
    private static final String NON_BRANCH_LINK_KEY = "+non_branch_link";
    private static final String URL_PARAM_KEY = "cb_url";
    public static final String WALLET_SCHEME = "cbwallet://";
    private final io.branch.referral.b branch;
    private final a0 concurrentScheduler;
    private final h.c.v0.a<String> dappDeepLinksBehaviorSubject;
    private final h.c.v0.b<Uri> intentUriSubject;

    /* compiled from: DeepLinkRepository.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/routing/repositories/DeepLinkRepository$Companion;", "", "", "ACTION_PARAM_KEY", "Ljava/lang/String;", "NON_BRANCH_LINK_KEY", "URL_PARAM_KEY", "WALLET_SCHEME", "<init>", "()V", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DeepLinkRepository(io.branch.referral.b branch) {
        m.g(branch, "branch");
        this.branch = branch;
        a0 c2 = h.c.u0.a.c();
        m.f(c2, "io()");
        this.concurrentScheduler = c2;
        h.c.v0.a<String> d2 = h.c.v0.a.d();
        m.f(d2, "create()");
        this.dappDeepLinksBehaviorSubject = d2;
        h.c.v0.b<Uri> d3 = h.c.v0.b.d();
        m.f(d3, "create<Uri>()");
        this.intentUriSubject = d3;
    }

    public static /* synthetic */ void a(DeepLinkRepository deepLinkRepository, Activity activity, u uVar) {
        m1688setupSession$lambda8(deepLinkRepository, activity, uVar);
    }

    public static /* synthetic */ void b(Uri uri) {
        m1690setupSession$lambda9(uri);
    }

    public static /* synthetic */ void c(u uVar, JSONObject jSONObject, io.branch.referral.d dVar) {
        m1689setupSession$lambda8$lambda7(uVar, jSONObject, dVar);
    }

    /* renamed from: createDappDeepLink$lambda-10 */
    public static final void m1687createDappDeepLink$lambda10(String dappLink, Activity activity, d0 observer) {
        m.g(dappLink, "$dappLink");
        m.g(activity, "$activity");
        m.g(observer, "observer");
        observer.onSuccess(new h.b.a.a().f(m.o("dapp/", String_CommonKt.toHexEncodedString(dappLink))).d(activity, new io.branch.referral.j0.d().a(ACTION_PARAM_KEY, "dapp").a(URL_PARAM_KEY, dappLink)));
    }

    public static /* synthetic */ void d(String str, Activity activity, d0 d0Var) {
        m1687createDappDeepLink$lambda10(str, activity, d0Var);
    }

    /* renamed from: setupSession$lambda-8 */
    public static final void m1688setupSession$lambda8(DeepLinkRepository this$0, Activity mainActivity, final u observer) {
        m.g(this$0, "this$0");
        m.g(mainActivity, "$mainActivity");
        m.g(observer, "observer");
        this$0.branch.g0(new b.g() { // from class: com.coinbase.wallet.routing.repositories.c
            @Override // io.branch.referral.b.g
            public final void a(JSONObject jSONObject, io.branch.referral.d dVar) {
                DeepLinkRepository.c(u.this, jSONObject, dVar);
            }
        }, mainActivity.getIntent().getData(), mainActivity);
    }

    /* renamed from: setupSession$lambda-8$lambda-7 */
    public static final void m1689setupSession$lambda8$lambda7(u observer, JSONObject referringParams, io.branch.referral.d dVar) {
        Uri build;
        String decode;
        Uri parse;
        m.g(observer, "$observer");
        if (dVar != null) {
            l.a.a.d(dVar.toString(), new Object[0]);
            return;
        }
        m.f(referringParams, "referringParams");
        String safeString = JsonObject_CommonKt.getSafeString(referringParams, NON_BRANCH_LINK_KEY);
        if (safeString == null || (parse = Uri.parse(safeString)) == null) {
            String safeString2 = JsonObject_CommonKt.getSafeString(referringParams, ACTION_PARAM_KEY);
            if (safeString2 == null) {
                build = null;
            } else {
                Uri.Builder authority = new Uri.Builder().scheme(WALLET_SCHEME).authority(safeString2);
                String safeString3 = JsonObject_CommonKt.getSafeString(referringParams, URL_PARAM_KEY);
                if (safeString3 != null && (decode = URLDecoder.decode(safeString3, kotlin.l0.d.a.name())) != null) {
                    authority.appendQueryParameter("url", decode);
                }
                build = authority.build();
            }
            if (build != null) {
                observer.onNext(build);
                return;
            }
            return;
        }
        observer.onNext(parse);
        x xVar = x.a;
    }

    /* renamed from: setupSession$lambda-9 */
    public static final void m1690setupSession$lambda9(Uri uri) {
        l.a.a.g(m.o("Received intent: ", uri.getScheme()), new Object[0]);
    }

    public final b0<String> createDappDeepLink(final String dappLink, final Activity activity) {
        m.g(dappLink, "dappLink");
        m.g(activity, "activity");
        b0<String> subscribeOn = b0.create(new f0() { // from class: com.coinbase.wallet.routing.repositories.d
            @Override // h.c.f0
            public final void subscribe(d0 d0Var) {
                DeepLinkRepository.d(dappLink, activity, d0Var);
            }
        }).subscribeOn(this.concurrentScheduler);
        m.f(subscribeOn, "create<String> { observer ->\n            val canonicalIdentifier = \"dapp/${dappLink.toHexEncodedString()}\"\n            val universalObject = BranchUniversalObject().setCanonicalIdentifier(canonicalIdentifier)\n            val properties = LinkProperties()\n                .addControlParameter(ACTION_PARAM_KEY, \"dapp\")\n                .addControlParameter(URL_PARAM_KEY, dappLink)\n\n            val shortUri = universalObject.getShortUrl(activity, properties)\n\n            observer.onSuccess(shortUri)\n        }\n        .subscribeOn(concurrentScheduler)");
        return subscribeOn;
    }

    public final s<String> getDappDeepLinkObservable() {
        s<String> hide = this.dappDeepLinksBehaviorSubject.hide();
        m.f(hide, "dappDeepLinksBehaviorSubject.hide()");
        return hide;
    }

    public final void pushDappDeeplink(String url) {
        m.g(url, "url");
        this.dappDeepLinksBehaviorSubject.onNext(url);
    }

    public final void pushNewIntentUrl(Uri uri) {
        m.g(uri, "uri");
        this.intentUriSubject.onNext(uri);
    }

    public final s<Uri> setupSession(final Activity mainActivity) {
        m.g(mainActivity, "mainActivity");
        s<Uri> subscribeOn = s.create(new v() { // from class: com.coinbase.wallet.routing.repositories.a
            @Override // h.c.v
            public final void a(u uVar) {
                DeepLinkRepository.a(DeepLinkRepository.this, mainActivity, uVar);
            }
        }).mergeWith(this.intentUriSubject).doOnNext(new f() { // from class: com.coinbase.wallet.routing.repositories.b
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                DeepLinkRepository.b((Uri) obj);
            }
        }).subscribeOn(this.concurrentScheduler);
        m.f(subscribeOn, "create<Uri> { observer ->\n            branch.initSession(\n                { referringParams, error ->\n                    if (error != null) {\n                        Timber.e(error.toString())\n                        return@initSession\n                    }\n\n                    referringParams.getSafeString(NON_BRANCH_LINK_KEY)\n                        ?.let { Uri.parse(it) }\n                        ?.let { uri -> observer.onNext(uri) }\n                        ?.let { return@initSession }\n\n                    referringParams.getSafeString(ACTION_PARAM_KEY)\n                        ?.let { actionParam ->\n                            val uriBuilder = Uri.Builder()\n                                .scheme(WALLET_SCHEME)\n                                .authority(actionParam)\n\n                            referringParams.getSafeString(URL_PARAM_KEY)\n                                ?.let { encodedUrl -> URLDecoder.decode(encodedUrl, Charsets.UTF_8.name()) }\n                                ?.let { url -> uriBuilder.appendQueryParameter(\"url\", url) }\n\n                            uriBuilder.build()\n                        }\n                        .also { uri -> if (uri != null) observer.onNext(uri) }\n                },\n                mainActivity.intent.data,\n                mainActivity\n            )\n        }\n        .mergeWith(intentUriSubject)\n        .doOnNext { intent -> Timber.i(\"Received intent: ${intent.scheme}\") }\n        .subscribeOn(concurrentScheduler)");
        return subscribeOn;
    }
}