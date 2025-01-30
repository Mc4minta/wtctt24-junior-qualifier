package com.toshi.view.fragment.toplevel;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.h0;
import androidx.lifecycle.i;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.share.Constants;
import com.coinbase.ApiConstants;
import com.coinbase.cipherwebview.CipherWebView;
import com.coinbase.cipherwebview.models.web3.call.Web3Call;
import com.coinbase.cipherwebview.models.web3.json.Web3CallResponse;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.wallets.extensions.legacy.Network_ApplicationKt;
import com.coinbase.wallet.routing.models.RouteAction;
import com.coinbase.wallet.routing.models.RouteScheme;
import com.coinbase.wallet.routing.repositories.DeepLinkRepository;
import com.squareup.moshi.Moshi;
import com.toshi.model.local.dapp.Dapp;
import com.toshi.model.local.room.Bookmark;
import com.toshi.view.activity.webView.JSBookmark;
import com.toshi.view.custom.AddressBarInputView;
import com.toshi.view.custom.ClickableRecyclerView;
import com.toshi.view.custom.ProgressBar;
import e.j.n.c2;
import e.j.n.h2;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.l0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.OkHttpClient;
import org.apache.http.HttpHost;
import org.apache.http.message.TokenParser;
import org.toshi.R;

/* compiled from: DappsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ´\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002´\u0001B\b¢\u0006\u0005\b³\u0001\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0006J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0006J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\rJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0006J\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u0006J\u001d\u0010 \u001a\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b#\u0010\u0011J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010\u0011J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\nH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\u0006J-\u00103\u001a\u0004\u0018\u0001022\u0006\u0010-\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b3\u00104J!\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u0002022\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0004H\u0016¢\u0006\u0004\b8\u0010\u0006J\u000f\u00109\u001a\u00020\nH\u0016¢\u0006\u0004\b9\u0010*J)\u0010?\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\b\u0010>\u001a\u0004\u0018\u00010=H\u0016¢\u0006\u0004\b?\u0010@J/\u0010E\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:2\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0A2\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bE\u0010FR\u001d\u0010K\u001a\u00020\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001d\u0010N\u001a\u00020\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010H\u001a\u0004\bM\u0010JR\u0016\u0010Q\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bS\u0010TR(\u0010^\u001a\b\u0012\u0004\u0012\u00020W0V8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010f\u001a\u00020_8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bh\u0010iR\"\u0010r\u001a\u00020k8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001e\u0010w\u001a\n t*\u0004\u0018\u00010s0s8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010z\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010|\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010yR'\u0010\u0084\u0001\u001a\u00020}8\u0000@\u0000X\u0081.¢\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001RE\u0010\u008f\u0001\u001a\u001f\u0012\u0005\u0012\u00030\u0086\u0001\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0005\u0012\u00030\u0089\u00010\u0087\u00010\u0085\u00018\u0000@\u0000X\u0081.¢\u0006\u0017\n\u0005\b\t\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R)\u0010\u0096\u0001\u001a\u00030\u0090\u00018\u0000@\u0000X\u0081.¢\u0006\u0017\n\u0005\bM\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u009a\u0001\u001a\u00030\u0097\u00018B@\u0002X\u0082\u0004¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001a\u0010\u009c\u0001\u001a\u00030\u0097\u00018B@\u0002X\u0082\u0004¢\u0006\b\u001a\u0006\b\u009b\u0001\u0010\u0099\u0001R\u001a\u0010 \u0001\u001a\u00030\u009d\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R*\u0010¨\u0001\u001a\u00030¡\u00018\u0000@\u0000X\u0081.¢\u0006\u0018\n\u0006\b¢\u0001\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R\u001b\u0010«\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u0019\u0010®\u0001\u001a\u00020W8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u001a\u0010²\u0001\u001a\u00030¯\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001¨\u0006µ\u0001"}, d2 = {"Lcom/toshi/view/fragment/toplevel/DappsFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "init", "()V", "initViewModel", "I", "w", "", "hasFocus", "s0", "(Z)V", "", "input", "G0", "(Ljava/lang/String;)V", "N", "setupObservers", "o0", "Le/j/n/c2;", "bookmarkBanner", "H0", "(Le/j/n/c2;)V", "F0", "existingBookmark", "I0", "J", "L", "Lh/c/b0;", "bookmarkUpdateSingle", "C", "(Lh/c/b0;)V", "it", "B", "u0", "Landroid/webkit/WebChromeClient$FileChooserParams;", "params", "t0", "(Landroid/webkit/WebChromeClient$FileChooserParams;)V", "H", "()Z", "v0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "onBackPressed", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "f", "Lkotlin/h;", "z", "()Ljava/lang/String;", "homeUrl", "g", "x", "appName", "m", "Z", "addressBarHasFocus", "Landroidx/appcompat/widget/h0;", "d", "Landroidx/appcompat/widget/h0;", "extraActionsPopUpMenu", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Le/j/n/h2;", "p", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "Lcom/squareup/moshi/Moshi;", "t", "Lcom/squareup/moshi/Moshi;", "A", "()Lcom/squareup/moshi/Moshi;", "setMoshi$app_productionRelease", "(Lcom/squareup/moshi/Moshi;)V", "moshi", "Lcom/toshi/view/activity/webView/b;", "e", "Lcom/toshi/view/activity/webView/b;", "cbWallet", "Lokhttp3/OkHttpClient;", "v", "Lokhttp3/OkHttpClient;", "getOkHttpClient$app_productionRelease", "()Lokhttp3/OkHttpClient;", "setOkHttpClient$app_productionRelease", "(Lokhttp3/OkHttpClient;)V", "okHttpClient", "Lh/c/a0;", "kotlin.jvm.PlatformType", "h", "Lh/c/a0;", "mainScheduler", "k", "Ljava/lang/String;", "currentUrl", "l", "currentTitle", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "q", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "getAuthenticationHelper$app_productionRelease", "()Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "setAuthenticationHelper$app_productionRelease", "(Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;)V", "authenticationHelper", "", "Lcom/coinbase/wallet/routing/models/RouteScheme;", "Lkotlin/Function1;", "Landroid/net/Uri;", "Lcom/coinbase/wallet/routing/models/RouteAction;", "Ljava/util/Map;", "getPaymentRoutes$app_productionRelease", "()Ljava/util/Map;", "setPaymentRoutes$app_productionRelease", "(Ljava/util/Map;)V", "paymentRoutes", "Lcom/coinbase/wallet/routing/repositories/DeepLinkRepository;", "Lcom/coinbase/wallet/routing/repositories/DeepLinkRepository;", "y", "()Lcom/coinbase/wallet/routing/repositories/DeepLinkRepository;", "setDeeplinkRepository$app_productionRelease", "(Lcom/coinbase/wallet/routing/repositories/DeepLinkRepository;)V", "deeplinkRepository", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "getOnDestroyScopeProvider", "onDestroyScopeProvider", "Lh/c/k0/a;", "j", "Lh/c/k0/a;", "activeWalletDisposeBag", "Le/j/l/o/a;", "u", "Le/j/l/o/a;", "getBase64Util$app_productionRelease", "()Le/j/l/o/a;", "setBase64Util$app_productionRelease", "(Le/j/l/o/a;)V", "base64Util", "n", "Landroid/webkit/WebChromeClient$FileChooserParams;", "fileChooserParams", "b", "Le/j/n/h2;", "viewModel", "Le/j/m/a/m;", Constants.URL_CAMPAIGN, "Le/j/m/a/m;", "searchDappAdapter", "<init>", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DappsFragment extends BaseFragment implements BackableFragment, StyledFragment {
    public static final a a = new a(null);

    /* renamed from: b */
    private h2 f11395b;

    /* renamed from: c */
    private e.j.m.a.m f11396c;

    /* renamed from: d */
    private h0 f11397d;

    /* renamed from: e */
    private com.toshi.view.activity.webView.b f11398e;

    /* renamed from: f */
    private final kotlin.h f11399f = kotlin.j.b(new e());

    /* renamed from: g */
    private final kotlin.h f11400g = kotlin.j.b(new c());

    /* renamed from: h */
    private final h.c.a0 f11401h = h.c.j0.c.a.b();

    /* renamed from: j */
    private final h.c.k0.a f11402j = new h.c.k0.a();

    /* renamed from: k */
    private String f11403k;

    /* renamed from: l */
    private String f11404l;
    private boolean m;
    private WebChromeClient.FileChooserParams n;
    public GenericViewModelFactory<h2> p;
    public AuthenticationHelper q;
    public Moshi t;
    public e.j.l.o.a u;
    public OkHttpClient v;
    public Map<RouteScheme, kotlin.e0.c.l<Uri, RouteAction>> w;
    public DeepLinkRepository x;

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a0 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Boolean, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a0() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Boolean bool) {
            invoke2(bool);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Boolean canGoForward) {
            View view = DappsFragment.this.getView();
            ImageButton imageButton = (ImageButton) (view == null ? null : view.findViewById(e.j.a.forwardButton));
            kotlin.jvm.internal.m.f(canGoForward, "canGoForward");
            imageButton.setAlpha(canGoForward.booleanValue() ? 1.0f : 0.4f);
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c2.c.values().length];
            iArr[c2.c.BOOKMARK_ADDED.ordinal()] = 1;
            iArr[c2.c.BOOKMARK_REMOVED.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b0 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Boolean, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b0() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Boolean bool) {
            invoke2(bool);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Boolean canGoBack) {
            View view = DappsFragment.this.getView();
            ImageButton imageButton = (ImageButton) (view == null ? null : view.findViewById(e.j.a.backButton));
            kotlin.jvm.internal.m.f(canGoBack, "canGoBack");
            imageButton.setAlpha(canGoBack.booleanValue() ? 1.0f : 0.4f);
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.a<String> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c() {
            super(0);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public final String invoke() {
            return DappsFragment.this.getString(R.string.app_name);
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c0 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Web3Call, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c0() {
            super(1);
            DappsFragment.this = r1;
        }

        public final void a(Web3Call call) {
            h2 h2Var = DappsFragment.this.f11395b;
            if (h2Var == null) {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            kotlin.jvm.internal.m.f(call, "call");
            h2Var.w(call, DappsFragment.this.f11403k);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Web3Call web3Call) {
            a(web3Call);
            return kotlin.x.a;
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<c2.a, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d() {
            super(1);
            DappsFragment.this = r1;
        }

        public final void a(c2.a it) {
            DappsFragment dappsFragment = DappsFragment.this;
            kotlin.jvm.internal.m.f(it, "it");
            dappsFragment.H0(it);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(c2.a aVar) {
            a(aVar);
            return kotlin.x.a;
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d0 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d0() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            e.j.f.m.u(DappsFragment.this, R.string.error__generating_share_link, 0, 2, null);
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.a<String> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e() {
            super(0);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public final String invoke() {
            return DappsFragment.this.getString(R.string.dapp_front_page);
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e0 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e0() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
            invoke2(str);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String str) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.setType("primaryText/plain");
            DappsFragment.this.startActivity(Intent.createChooser(intent, "Share via"));
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class f extends kotlin.jvm.internal.o implements kotlin.e0.c.a<kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f() {
            super(0);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ kotlin.x invoke() {
            invoke2();
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2() {
            View view = DappsFragment.this.getView();
            boolean canGoBack = ((CipherWebView) (view == null ? null : view.findViewById(e.j.a.cipherWebView))).getWebView().canGoBack();
            DappsFragment dappsFragment = DappsFragment.this;
            if (canGoBack) {
                View view2 = dappsFragment.getView();
                ((CipherWebView) (view2 != null ? view2.findViewById(e.j.a.cipherWebView) : null)).goBack();
            }
            kotlin.x xVar = kotlin.x.a;
            DappsFragment.this.w();
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class f0 extends kotlin.jvm.internal.o implements kotlin.e0.c.p<View, Boolean, kotlin.x> {
        public static final f0 a = new f0();

        f0() {
            super(2);
        }

        @Override // kotlin.e0.c.p
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view, Boolean bool) {
            invoke(view, bool.booleanValue());
            return kotlin.x.a;
        }

        public final void invoke(View view, boolean z) {
            kotlin.jvm.internal.m.g(view, "view");
            if (z) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class g extends kotlin.jvm.internal.o implements kotlin.e0.c.a<kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g() {
            super(0);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ kotlin.x invoke() {
            invoke2();
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2() {
            View view = DappsFragment.this.getView();
            boolean canGoForward = ((CipherWebView) (view == null ? null : view.findViewById(e.j.a.cipherWebView))).getWebView().canGoForward();
            DappsFragment dappsFragment = DappsFragment.this;
            if (canGoForward) {
                View view2 = dappsFragment.getView();
                ((CipherWebView) (view2 != null ? view2.findViewById(e.j.a.cipherWebView) : null)).goForward();
            }
            kotlin.x xVar = kotlin.x.a;
            DappsFragment.this.w();
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class h extends kotlin.jvm.internal.o implements kotlin.e0.c.a<kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h() {
            super(0);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ kotlin.x invoke() {
            invoke2();
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2() {
            DappsFragment dappsFragment = DappsFragment.this;
            String homeUrl = dappsFragment.z();
            kotlin.jvm.internal.m.f(homeUrl, "homeUrl");
            dappsFragment.B(homeUrl);
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class i extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
            invoke2(str);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            DappsFragment.this.B(it);
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class j extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Boolean, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return kotlin.x.a;
        }

        public final void invoke(boolean z) {
            DappsFragment.this.s0(z);
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class k extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
            invoke2(str);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            DappsFragment.this.G0(it);
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class l extends kotlin.jvm.internal.o implements kotlin.e0.c.a<kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l() {
            super(0);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ kotlin.x invoke() {
            invoke2();
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2() {
            h0 h0Var = DappsFragment.this.f11397d;
            if (h0Var != null) {
                h0Var.d();
            } else {
                kotlin.jvm.internal.m.w("extraActionsPopUpMenu");
                throw null;
            }
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class m extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
            invoke2(str);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            DappsFragment.this.u0(it);
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class n extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
            invoke2(str);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            DappsFragment.this.B(it);
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class o extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Dapp, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o() {
            super(1);
            DappsFragment.this = r1;
        }

        public final void a(Dapp it) {
            kotlin.jvm.internal.m.g(it, "it");
            DappsFragment dappsFragment = DappsFragment.this;
            String url = it.getUrl();
            if (url == null) {
                url = "";
            }
            dappsFragment.B(url);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Dapp dapp) {
            a(dapp);
            return kotlin.x.a;
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class p extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
            invoke2(str);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            DappsFragment dappsFragment = DappsFragment.this;
            h2 h2Var = dappsFragment.f11395b;
            if (h2Var != null) {
                dappsFragment.C(h2Var.S(it));
            } else {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class q extends kotlin.jvm.internal.o implements kotlin.e0.c.a<kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q() {
            super(0);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ kotlin.x invoke() {
            invoke2();
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2() {
            h2 h2Var = DappsFragment.this.f11395b;
            if (h2Var != null) {
                h2Var.q();
            } else {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class r extends kotlin.jvm.internal.o implements kotlin.e0.c.l<WebResourceRequest, Boolean> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(WebResourceRequest webResourceRequest) {
            return Boolean.valueOf(invoke2(webResourceRequest));
        }

        /* renamed from: invoke */
        public final boolean invoke2(WebResourceRequest webResourceRequest) {
            String scheme;
            Uri url = webResourceRequest == null ? null : webResourceRequest.getUrl();
            if (url == null || (scheme = url.getScheme()) == null || RouteScheme.Factory.create(scheme) == null) {
                return false;
            }
            DappsFragment.this.y().pushNewIntentUrl(url);
            return true;
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class s extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.x, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.x xVar) {
            invoke2(xVar);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(kotlin.x xVar) {
            DappsFragment.this.f11402j.d();
            DappsFragment.this.o0();
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class t extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
            invoke2(str);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String deeplinkUrl) {
            DappsFragment dappsFragment = DappsFragment.this;
            kotlin.jvm.internal.m.f(deeplinkUrl, "deeplinkUrl");
            dappsFragment.B(deeplinkUrl);
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class u extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Integer, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u() {
            super(1);
            DappsFragment.this = r1;
        }

        public final void a(Integer it) {
            View view = DappsFragment.this.getView();
            View findViewById = view == null ? null : view.findViewById(e.j.a.d5);
            kotlin.jvm.internal.m.f(it, "it");
            ((ProgressBar) findViewById).setProgress(it.intValue());
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Integer num) {
            a(num);
            return kotlin.x.a;
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class v extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
            invoke2(str);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String it) {
            DappsFragment dappsFragment = DappsFragment.this;
            kotlin.jvm.internal.m.f(it, "it");
            dappsFragment.f11404l = it;
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class w extends kotlin.jvm.internal.o implements kotlin.e0.c.l<WebChromeClient.FileChooserParams, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w() {
            super(1);
            DappsFragment.this = r1;
        }

        public final void a(WebChromeClient.FileChooserParams params) {
            DappsFragment.this.n = params;
            if (DappsFragment.this.H()) {
                DappsFragment dappsFragment = DappsFragment.this;
                kotlin.jvm.internal.m.f(params, "params");
                dappsFragment.t0(params);
                return;
            }
            DappsFragment.this.v0();
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(WebChromeClient.FileChooserParams fileChooserParams) {
            a(fileChooserParams);
            return kotlin.x.a;
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class x extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Optional<? extends Web3CallResponse>, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Optional<? extends Web3CallResponse> optional) {
            invoke2((Optional<Web3CallResponse>) optional);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Optional<Web3CallResponse> optional) {
            Web3CallResponse nullable = optional.toNullable();
            if (nullable == null) {
                return;
            }
            View view = DappsFragment.this.getView();
            ((CipherWebView) (view == null ? null : view.findViewById(e.j.a.cipherWebView))).respondToWeb3Call(nullable);
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class y extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends JSBookmark>, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        y() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(List<? extends JSBookmark> list) {
            invoke2((List<JSBookmark>) list);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(List<JSBookmark> it) {
            com.toshi.view.activity.webView.b bVar = DappsFragment.this.f11398e;
            if (bVar == null) {
                kotlin.jvm.internal.m.w("cbWallet");
                throw null;
            }
            kotlin.jvm.internal.m.f(it, "it");
            bVar.e(it);
        }
    }

    /* compiled from: DappsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class z extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends String, ? extends Boolean>, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z() {
            super(1);
            DappsFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends String, ? extends Boolean> oVar) {
            invoke2((kotlin.o<String, Boolean>) oVar);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(kotlin.o<String, Boolean> oVar) {
            String a = oVar.a();
            View view = DappsFragment.this.getView();
            AddressBarInputView addressBarInputView = (AddressBarInputView) (view == null ? null : view.findViewById(e.j.a.input));
            if (a == null) {
                a = "";
            }
            addressBarInputView.setUrl(a);
        }
    }

    public DappsFragment() {
        kotlin.h b2;
        kotlin.h b3;
        b2 = kotlin.k.b(new e());
        this.f11399f = b2;
        b3 = kotlin.k.b(new c());
        this.f11400g = b3;
        this.f11401h = h.c.j0.c.a.b();
        this.f11402j = new h.c.k0.a();
        Strings strings = Strings.INSTANCE;
        this.f11403k = Strings_CoreKt.getEmpty(strings);
        this.f11404l = Strings_CoreKt.getEmpty(strings);
    }

    public static final h.c.x A0(DappsFragment this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        h.c.s just = h.c.s.just(it);
        kotlin.jvm.internal.m.f(just, "just(it)");
        h2 h2Var = this$0.f11395b;
        if (h2Var != null) {
            return h.c.t0.d.a(just, h2Var.x(it));
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public final void B(String str) {
        boolean Q;
        CharSequence h1;
        if (!e.j.f.u.c(str)) {
            u0(str);
            return;
        }
        Q = kotlin.l0.x.Q(str, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null);
        if (!Q) {
            String o2 = kotlin.jvm.internal.m.o("http://", str);
            Objects.requireNonNull(o2, "null cannot be cast to non-null type kotlin.CharSequence");
            h1 = kotlin.l0.y.h1(o2);
            URL asURL = String_CoreKt.getAsURL(h1.toString());
            URI uri = asURL == null ? null : asURL.toURI();
            String aSCIIString = uri == null ? null : uri.toASCIIString();
            if (aSCIIString == null) {
                u0(str);
                return;
            }
            str = aSCIIString;
        }
        View view = getView();
        ((CipherWebView) (view == null ? null : view.findViewById(e.j.a.cipherWebView))).loadURL(str);
        View view2 = getView();
        ((AddressBarInputView) (view2 != null ? view2.findViewById(e.j.a.input) : null)).setUrl(str);
        w();
    }

    public static final void B0(DappsFragment this$0, kotlin.o oVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Boolean bookmarkExists = (Boolean) oVar.b();
        kotlin.jvm.internal.m.f(bookmarkExists, "bookmarkExists");
        this$0.I0(bookmarkExists.booleanValue());
    }

    public final void C(h.c.b0<c2> b0Var) {
        h.c.b0 map = b0Var.observeOn(this.f11401h).doOnSuccess(new h.c.m0.f() { // from class: com.toshi.view.fragment.toplevel.q
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                DappsFragment.D(DappsFragment.this, (c2) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.toshi.view.fragment.toplevel.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                h.c.h0 E;
                E = DappsFragment.E(DappsFragment.this, (c2) obj);
                return E;
            }
        }).observeOn(this.f11401h).doOnSuccess(new h.c.m0.f() { // from class: com.toshi.view.fragment.toplevel.s
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                DappsFragment.k0(DappsFragment.this, (Boolean) obj);
            }
        }).delay(2000L, TimeUnit.MILLISECONDS).observeOn(this.f11401h).map(new h.c.m0.n() { // from class: com.toshi.view.fragment.toplevel.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return DappsFragment.G((Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bookmarkUpdateSingle\n            .observeOn(mainScheduler)\n            .doOnSuccess { updateBookmarkBanner(it) }\n            .flatMap { viewModel.isCurrentUrlBookmarked(currentUrl).takeSingle() }\n            .observeOn(mainScheduler)\n            .doOnSuccess { updateBookmarksMenu(it) }\n            .delay(2000, TimeUnit.MILLISECONDS)\n            .observeOn(mainScheduler)\n            .map { BookmarkBanner.BookmarkBannerHidden }");
        Object as = Single_AnalyticsKt.logError$default(map, "Error while deleting current page from bookmark", null, 2, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
        kotlin.jvm.internal.m.f(as, "bookmarkUpdateSingle\n            .observeOn(mainScheduler)\n            .doOnSuccess { updateBookmarkBanner(it) }\n            .flatMap { viewModel.isCurrentUrlBookmarked(currentUrl).takeSingle() }\n            .observeOn(mainScheduler)\n            .doOnSuccess { updateBookmarksMenu(it) }\n            .delay(2000, TimeUnit.MILLISECONDS)\n            .observeOn(mainScheduler)\n            .map { BookmarkBanner.BookmarkBannerHidden }\n            .logError(\"Error while deleting current page from bookmark\")\n            .`as`(autoDisposable(onDestroyScopeProvider))");
        SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new d(), 1, null);
    }

    public static final void C0(DappsFragment this$0, kotlin.o oVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        String url = (String) oVar.a();
        kotlin.jvm.internal.m.f(url, "url");
        this$0.f11403k = url;
    }

    public static final void D(DappsFragment this$0, c2 it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.f(it, "it");
        this$0.H0(it);
    }

    public static final void D0(DappsFragment this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        h0 h0Var = this$0.f11397d;
        if (h0Var != null) {
            h0Var.a().findItem(R.id.stopLoading).setVisible(false);
        } else {
            kotlin.jvm.internal.m.w("extraActionsPopUpMenu");
            throw null;
        }
    }

    public static final h.c.h0 E(DappsFragment this$0, c2 it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        h2 h2Var = this$0.f11395b;
        if (h2Var != null) {
            return Observable_CoreKt.takeSingle(h2Var.x(this$0.f11403k));
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public static final void E0(DappsFragment this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        h0 h0Var = this$0.f11397d;
        if (h0Var != null) {
            h0Var.a().findItem(R.id.stopLoading).setVisible(true);
        } else {
            kotlin.jvm.internal.m.w("extraActionsPopUpMenu");
            throw null;
        }
    }

    public static final void F(DappsFragment this$0, Boolean it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.f(it, "it");
        this$0.I0(it.booleanValue());
    }

    private final void F0() {
        String str = this.f11403k;
        h2 h2Var = this.f11395b;
        if (h2Var != null) {
            androidx.fragment.app.d requireActivity = requireActivity();
            kotlin.jvm.internal.m.f(requireActivity, "requireActivity()");
            h.c.b0<String> observeOn = h2Var.m(str, requireActivity).observeOn(this.f11401h);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.createShareDappLink(url, requireActivity())\n            .observeOn(mainScheduler)");
            Object as = Single_AnalyticsKt.logError$default(observeOn, "Error while generating short link", null, 2, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.createShareDappLink(url, requireActivity())\n            .observeOn(mainScheduler)\n            .logError(\"Error while generating short link\")\n            .`as`(autoDisposable(onDestroyScopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy((com.uber.autodispose.a0) as, new d0(), new e0());
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public static final c2.a G(Boolean it) {
        kotlin.jvm.internal.m.g(it, "it");
        return c2.a.a;
    }

    public final void G0(String str) {
        if (this.m) {
            View view = getView();
            View searchDappsContainer = view == null ? null : view.findViewById(e.j.a.searchDappsContainer);
            kotlin.jvm.internal.m.f(searchDappsContainer, "searchDappsContainer");
            searchDappsContainer.setVisibility(0);
            e.j.m.a.m mVar = this.f11396c;
            if (mVar != null) {
                mVar.b(str);
                if (e.j.f.u.c(str)) {
                    e.j.m.a.m mVar2 = this.f11396c;
                    if (mVar2 != null) {
                        mVar2.d(str);
                        return;
                    } else {
                        kotlin.jvm.internal.m.w("searchDappAdapter");
                        throw null;
                    }
                }
                e.j.m.a.m mVar3 = this.f11396c;
                if (mVar3 != null) {
                    mVar3.n();
                    return;
                } else {
                    kotlin.jvm.internal.m.w("searchDappAdapter");
                    throw null;
                }
            }
            kotlin.jvm.internal.m.w("searchDappAdapter");
            throw null;
        }
    }

    public final boolean H() {
        return androidx.core.content.a.a(requireContext(), "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    public final void H0(c2 c2Var) {
        int i2;
        String title;
        if (c2Var instanceof c2.b) {
            c2.b bVar = (c2.b) c2Var;
            Bookmark a2 = bVar.a();
            String str = "";
            if (a2 != null && (title = a2.getTitle()) != null) {
                str = title;
            }
            c2.c b2 = bVar.b();
            String str2 = TokenParser.DQUOTE + e.j.f.u.a(str, 20) + TokenParser.DQUOTE;
            View view = getView();
            TextView textView = (TextView) (view == null ? null : view.findViewById(e.j.a.topBanner));
            int i3 = b.a[b2.ordinal()];
            if (i3 == 1) {
                i2 = R.string.added_to_bookmarks;
            } else if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                i2 = R.string.removed_from_bookmarks;
            }
            textView.setText(getString(i2, str2));
            View view2 = getView();
            ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.topBanner))).clearAnimation();
            View view3 = getView();
            View topBanner = view3 != null ? view3.findViewById(e.j.a.topBanner) : null;
            kotlin.jvm.internal.m.f(topBanner, "topBanner");
            e.j.f.d.b(topBanner, 50L, null, 2, null);
        } else if (c2Var instanceof c2.a) {
            View view4 = getView();
            View topBanner2 = view4 != null ? view4.findViewById(e.j.a.topBanner) : null;
            kotlin.jvm.internal.m.f(topBanner2, "topBanner");
            e.j.f.d.c(topBanner2, 300L, f0.a);
        }
    }

    private final void I() {
        View view = getView();
        ((AddressBarInputView) (view == null ? null : view.findViewById(e.j.a.input))).setOnBackClickedListener(new f());
        View view2 = getView();
        ((AddressBarInputView) (view2 == null ? null : view2.findViewById(e.j.a.input))).setOnForwardClickedListener(new g());
        View view3 = getView();
        ((AddressBarInputView) (view3 == null ? null : view3.findViewById(e.j.a.input))).setOnHomeClickedListener(new h());
        View view4 = getView();
        ((AddressBarInputView) (view4 == null ? null : view4.findViewById(e.j.a.input))).setOnGoClickedListener(new i());
        View view5 = getView();
        ((AddressBarInputView) (view5 == null ? null : view5.findViewById(e.j.a.input))).setOnFocusChangedListener(new j());
        View view6 = getView();
        ((AddressBarInputView) (view6 == null ? null : view6.findViewById(e.j.a.input))).setOnTextChangedListener(new k());
        View view7 = getView();
        ((AddressBarInputView) (view7 != null ? view7.findViewById(e.j.a.input) : null)).setOnExtraActionsClickedListener(new l());
    }

    private final void I0(boolean z2) {
        h0 h0Var = this.f11397d;
        if (h0Var != null) {
            h0Var.a().findItem(R.id.remove_bookmark).setVisible(z2);
            h0 h0Var2 = this.f11397d;
            if (h0Var2 != null) {
                h0Var2.a().findItem(R.id.add_bookmark).setVisible(!z2);
                return;
            } else {
                kotlin.jvm.internal.m.w("extraActionsPopUpMenu");
                throw null;
            }
        }
        kotlin.jvm.internal.m.w("extraActionsPopUpMenu");
        throw null;
    }

    private final void J() {
        e.j.m.a.m mVar = new e.j.m.a.m();
        mVar.q(new m());
        mVar.o(new n());
        mVar.p(new o());
        kotlin.x xVar = kotlin.x.a;
        this.f11396c = mVar;
        View view = getView();
        RecyclerView recyclerView = ((ClickableRecyclerView) (view == null ? null : view.findViewById(e.j.a.searchDappsContainer))).getRecyclerView();
        e.j.m.a.m mVar2 = this.f11396c;
        if (mVar2 != null) {
            recyclerView.setAdapter(mVar2);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setItemAnimator(null);
            View view2 = getView();
            ((ClickableRecyclerView) (view2 != null ? view2.findViewById(e.j.a.searchDappsContainer) : null)).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.fragment.toplevel.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    DappsFragment.n0(DappsFragment.this, view3);
                }
            });
            return;
        }
        kotlin.jvm.internal.m.w("searchDappAdapter");
        throw null;
    }

    public static final void K(DappsFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.w();
    }

    private final void L() {
        androidx.fragment.app.d activity = getActivity();
        if (activity == null) {
            return;
        }
        View view = getView();
        h0 h0Var = new h0(activity, view == null ? null : view.findViewById(e.j.a.extraActionsButton));
        this.f11397d = h0Var;
        if (h0Var == null) {
            kotlin.jvm.internal.m.w("extraActionsPopUpMenu");
            throw null;
        }
        MenuInflater b2 = h0Var.b();
        h0 h0Var2 = this.f11397d;
        if (h0Var2 != null) {
            b2.inflate(R.menu.web_menu, h0Var2.a());
            h0 h0Var3 = this.f11397d;
            if (h0Var3 != null) {
                h0Var3.c(new h0.d() { // from class: com.toshi.view.fragment.toplevel.n
                    @Override // androidx.appcompat.widget.h0.d
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        boolean M;
                        M = DappsFragment.M(DappsFragment.this, menuItem);
                        return M;
                    }
                });
                activity.setTitle(this.f11404l);
                return;
            }
            kotlin.jvm.internal.m.w("extraActionsPopUpMenu");
            throw null;
        }
        kotlin.jvm.internal.m.w("extraActionsPopUpMenu");
        throw null;
    }

    public static final boolean M(DappsFragment this$0, MenuItem menuItem) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        switch (menuItem.getItemId()) {
            case R.id.add_bookmark /* 2131362000 */:
                h2 h2Var = this$0.f11395b;
                if (h2Var != null) {
                    this$0.C(h2Var.j(this$0.f11404l, this$0.f11403k));
                    return true;
                }
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            case R.id.reload /* 2131362781 */:
                View view = this$0.getView();
                ((CipherWebView) (view != null ? view.findViewById(e.j.a.cipherWebView) : null)).reload();
                return true;
            case R.id.remove_bookmark /* 2131362782 */:
                h2 h2Var2 = this$0.f11395b;
                if (h2Var2 != null) {
                    this$0.C(h2Var2.S(this$0.f11403k));
                    return true;
                }
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            case R.id.share /* 2131362881 */:
                this$0.F0();
                return true;
            case R.id.stopLoading /* 2131362943 */:
                View view2 = this$0.getView();
                ((CipherWebView) (view2 != null ? view2.findViewById(e.j.a.cipherWebView) : null)).stopLoading();
                return true;
            default:
                return true;
        }
    }

    private final void N() {
        Context requireContext = requireContext();
        kotlin.jvm.internal.m.f(requireContext, "requireContext()");
        Moshi A = A();
        View view = getView();
        View cipherWebView = view == null ? null : view.findViewById(e.j.a.cipherWebView);
        kotlin.jvm.internal.m.f(cipherWebView, "cipherWebView");
        this.f11398e = new com.toshi.view.activity.webView.b(requireContext, A, (CipherWebView) cipherWebView, new p(), new q());
        View view2 = getView();
        CipherWebView cipherWebView2 = (CipherWebView) (view2 == null ? null : view2.findViewById(e.j.a.cipherWebView));
        com.toshi.view.activity.webView.b bVar = this.f11398e;
        if (bVar != null) {
            cipherWebView2.addJavascriptInterface(bVar, "__CBWalletJSI__");
            View view3 = getView();
            ((CipherWebView) (view3 == null ? null : view3.findViewById(e.j.a.cipherWebView))).setLayerType(2, null);
            h2 h2Var = this.f11395b;
            if (h2Var != null) {
                h.c.s doOnDispose = h2Var.p().distinctUntilChanged(new h.c.m0.d() { // from class: com.toshi.view.fragment.toplevel.u
                    @Override // h.c.m0.d
                    public final boolean a(Object obj, Object obj2) {
                        boolean O;
                        O = DappsFragment.O((Wallet) obj, (Wallet) obj2);
                        return O;
                    }
                }).map(new h.c.m0.n() { // from class: com.toshi.view.fragment.toplevel.c
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        kotlin.x P;
                        P = DappsFragment.P(DappsFragment.this, (Wallet) obj);
                        return P;
                    }
                }).observeOn(this.f11401h).map(new h.c.m0.n() { // from class: com.toshi.view.fragment.toplevel.l
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return DappsFragment.d0(DappsFragment.this, (kotlin.x) obj);
                    }
                }).doOnDispose(new h.c.m0.a() { // from class: com.toshi.view.fragment.toplevel.d
                    @Override // h.c.m0.a
                    public final void run() {
                        DappsFragment.V(DappsFragment.this);
                    }
                });
                kotlin.jvm.internal.m.f(doOnDispose, "viewModel.activeWalletObservable\n            .distinctUntilChanged { t1, t2 ->\n                t1.primaryAddress == t2.primaryAddress && t1.network == t2.network\n            }\n            .map {\n                val additionalHeaders = mapOf(\n                    Pair(\n                        \"X-App-Version\",\n                        \"${context?.packageName}/${BuildConfig.VERSION_NAME}/${BuildConfig.VERSION_CODE}\"\n                    )\n                )\n                cipherWebView.configure(\n                    appName = appName,\n                    appVersion = BuildConfig.VERSION_NAME,\n                    address = it.primaryAddress,\n                    chainId = it.network.asChainId(),\n                    additionalHeaders = additionalHeaders\n                )\n                cipherWebView.shouldOverrideUrlLoading = shouldOverrideUrl@{ request ->\n                    val uri = request?.url ?: return@shouldOverrideUrl false\n                    val scheme = uri.scheme ?: return@shouldOverrideUrl false\n\n                    if (RouteScheme.create(scheme) != null) {\n                        deeplinkRepository.pushNewIntentUrl(uri)\n                        return@shouldOverrideUrl true\n                    }\n                    return@shouldOverrideUrl false\n                }\n            }\n            .observeOn(mainScheduler)\n            .map { goToUrl(cipherWebView.currentUrl ?: homeUrl) }\n            .doOnDispose { activeWalletDisposeBag.clear() }");
                Object as = Observable_AnalyticsKt.logError$default(doOnDispose, "Error while observing wallet", null, 2, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                kotlin.jvm.internal.m.f(as, "viewModel.activeWalletObservable\n            .distinctUntilChanged { t1, t2 ->\n                t1.primaryAddress == t2.primaryAddress && t1.network == t2.network\n            }\n            .map {\n                val additionalHeaders = mapOf(\n                    Pair(\n                        \"X-App-Version\",\n                        \"${context?.packageName}/${BuildConfig.VERSION_NAME}/${BuildConfig.VERSION_CODE}\"\n                    )\n                )\n                cipherWebView.configure(\n                    appName = appName,\n                    appVersion = BuildConfig.VERSION_NAME,\n                    address = it.primaryAddress,\n                    chainId = it.network.asChainId(),\n                    additionalHeaders = additionalHeaders\n                )\n                cipherWebView.shouldOverrideUrlLoading = shouldOverrideUrl@{ request ->\n                    val uri = request?.url ?: return@shouldOverrideUrl false\n                    val scheme = uri.scheme ?: return@shouldOverrideUrl false\n\n                    if (RouteScheme.create(scheme) != null) {\n                        deeplinkRepository.pushNewIntentUrl(uri)\n                        return@shouldOverrideUrl true\n                    }\n                    return@shouldOverrideUrl false\n                }\n            }\n            .observeOn(mainScheduler)\n            .map { goToUrl(cipherWebView.currentUrl ?: homeUrl) }\n            .doOnDispose { activeWalletDisposeBag.clear() }\n            .logError(\"Error while observing wallet\")\n            .`as`(autoDisposable(onDestroyScopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new s(), 3, null);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("cbWallet");
        throw null;
    }

    public static final boolean O(Wallet t1, Wallet t2) {
        kotlin.jvm.internal.m.g(t1, "t1");
        kotlin.jvm.internal.m.g(t2, "t2");
        return kotlin.jvm.internal.m.c(t1.getPrimaryAddress(), t2.getPrimaryAddress()) && kotlin.jvm.internal.m.c(t1.getNetwork(), t2.getNetwork());
    }

    public static final kotlin.x P(DappsFragment this$0, Wallet it) {
        Map e2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        Context context = this$0.getContext();
        e2 = l0.e(new kotlin.o(ApiConstants.Headers.APP_VERSION, kotlin.jvm.internal.m.o(context == null ? null : context.getPackageName(), "/25.8.398/44000398")));
        View view = this$0.getView();
        View cipherWebView = view == null ? null : view.findViewById(e.j.a.cipherWebView);
        kotlin.jvm.internal.m.f(cipherWebView, "cipherWebView");
        String appName = this$0.x();
        kotlin.jvm.internal.m.f(appName, "appName");
        CipherWebView.configure$default((CipherWebView) cipherWebView, appName, "25.8.398", it.getPrimaryAddress(), Network_ApplicationKt.asChainId(it.getNetwork()), e2, null, null, 96, null);
        View view2 = this$0.getView();
        ((CipherWebView) (view2 != null ? view2.findViewById(e.j.a.cipherWebView) : null)).setShouldOverrideUrlLoading(new r());
        return kotlin.x.a;
    }

    public static final kotlin.x Q(DappsFragment this$0, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        View view = this$0.getView();
        String homeUrl = ((CipherWebView) (view == null ? null : view.findViewById(e.j.a.cipherWebView))).getCurrentUrl();
        if (homeUrl == null) {
            homeUrl = this$0.z();
            kotlin.jvm.internal.m.f(homeUrl, "homeUrl");
        }
        this$0.B(homeUrl);
        return kotlin.x.a;
    }

    public static final void R(DappsFragment this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.f11402j.d();
    }

    public static /* synthetic */ void T(DappsFragment dappsFragment, kotlin.o oVar) {
        B0(dappsFragment, oVar);
    }

    public static /* synthetic */ void V(DappsFragment dappsFragment) {
        R(dappsFragment);
    }

    public static /* synthetic */ void W(DappsFragment dappsFragment) {
        D0(dappsFragment);
    }

    public static /* synthetic */ void X(DappsFragment dappsFragment) {
        E0(dappsFragment);
    }

    public static /* synthetic */ h.c.h0 Y(DappsFragment dappsFragment, String str) {
        return p0(dappsFragment, str);
    }

    public static /* synthetic */ h.c.x Z(DappsFragment dappsFragment, String str) {
        return A0(dappsFragment, str);
    }

    public static /* synthetic */ Double a0(Double d2) {
        return w0(d2);
    }

    public static /* synthetic */ List c0(List list) {
        return z0(list);
    }

    public static /* synthetic */ kotlin.x d0(DappsFragment dappsFragment, kotlin.x xVar) {
        return Q(dappsFragment, xVar);
    }

    public static /* synthetic */ void e0(DappsFragment dappsFragment, kotlin.o oVar) {
        C0(dappsFragment, oVar);
    }

    public static /* synthetic */ boolean g0(Boolean bool) {
        return q0(bool);
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final void init() {
        e.j.f.m.o(this, getAuthenticationHelper$app_productionRelease());
        initViewModel();
        N();
        I();
        setupObservers();
        L();
        J();
    }

    private final void initViewModel() {
        androidx.lifecycle.b0 a2 = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(h2.class);
        kotlin.jvm.internal.m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.f11395b = (h2) a2;
    }

    public static /* synthetic */ String j0(String str, Boolean bool) {
        return r0(str, bool);
    }

    public static /* synthetic */ void k0(DappsFragment dappsFragment, Boolean bool) {
        F(dappsFragment, bool);
    }

    public static /* synthetic */ Integer l0(Double d2) {
        return x0(d2);
    }

    public static /* synthetic */ void n0(DappsFragment dappsFragment, View view) {
        K(dappsFragment, view);
    }

    public final void o0() {
        h2 h2Var = this.f11395b;
        if (h2Var != null) {
            h.c.s observeOn = h2Var.s().flatMapSingle(new h.c.m0.n() { // from class: com.toshi.view.fragment.toplevel.g
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return DappsFragment.Y(DappsFragment.this, (String) obj);
                }
            }).observeOn(this.f11401h);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.deepLinkUrlObservable\n            .flatMapSingle { url ->\n                // Make sure we wait for the home page to finish before loading the deep link\n                cipherWebView.onInitialPageLoadedChange.filter { it }.takeSingle().map { url }\n            }\n            .observeOn(mainScheduler)");
            h.c.t0.a.a(h.c.t0.g.h(Observable_AnalyticsKt.logError$default(observeOn, "Error observing deeplink url", null, 2, null), null, null, new t(), 3, null), this.f11402j);
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public static final h.c.h0 p0(DappsFragment this$0, final String url) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(url, "url");
        View view = this$0.getView();
        h.c.s<Boolean> filter = ((CipherWebView) (view == null ? null : view.findViewById(e.j.a.cipherWebView))).getOnInitialPageLoadedChange().filter(new h.c.m0.p() { // from class: com.toshi.view.fragment.toplevel.o
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return DappsFragment.g0((Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "cipherWebView.onInitialPageLoadedChange.filter { it }");
        return Observable_CoreKt.takeSingle(filter).map(new h.c.m0.n() { // from class: com.toshi.view.fragment.toplevel.r
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return DappsFragment.j0(url, (Boolean) obj);
            }
        });
    }

    public static final boolean q0(Boolean it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.booleanValue();
    }

    public static final String r0(String url, Boolean it) {
        kotlin.jvm.internal.m.g(url, "$url");
        kotlin.jvm.internal.m.g(it, "it");
        return url;
    }

    public final void s0(boolean z2) {
        View searchDappsContainer;
        this.m = z2;
        if (z2) {
            View view = getView();
            searchDappsContainer = view != null ? view.findViewById(e.j.a.input) : null;
            G0(((AddressBarInputView) searchDappsContainer).getUrl());
            return;
        }
        View view2 = getView();
        searchDappsContainer = view2 != null ? view2.findViewById(e.j.a.searchDappsContainer) : null;
        kotlin.jvm.internal.m.f(searchDappsContainer, "searchDappsContainer");
        searchDappsContainer.setVisibility(8);
    }

    private final void setupObservers() {
        View view = getView();
        h.c.s doOnNext = ((CipherWebView) (view == null ? null : view.findViewById(e.j.a.cipherWebView))).getOnUrlChange().flatMap(new h.c.m0.n() { // from class: com.toshi.view.fragment.toplevel.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return DappsFragment.Z(DappsFragment.this, (String) obj);
            }
        }).observeOn(this.f11401h).doOnNext(new h.c.m0.f() { // from class: com.toshi.view.fragment.toplevel.b
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                DappsFragment.T(DappsFragment.this, (kotlin.o) obj);
            }
        }).doOnNext(new h.c.m0.f() { // from class: com.toshi.view.fragment.toplevel.m
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                DappsFragment.e0(DappsFragment.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnNext, "cipherWebView.onUrlChange\n            .flatMap { Observable.just(it).zipWith(viewModel.isCurrentUrlBookmarked(it)) }\n            .observeOn(mainScheduler)\n            .doOnNext { (_, bookmarkExists) -> updateBookmarksMenu(bookmarkExists) }\n            .doOnNext { (url, _) -> currentUrl = url }");
        Object as = Observable_AnalyticsKt.logError$default(doOnNext, "Error while observing url changes", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as, "cipherWebView.onUrlChange\n            .flatMap { Observable.just(it).zipWith(viewModel.isCurrentUrlBookmarked(it)) }\n            .observeOn(mainScheduler)\n            .doOnNext { (_, bookmarkExists) -> updateBookmarksMenu(bookmarkExists) }\n            .doOnNext { (url, _) -> currentUrl = url }\n            .logError(\"Error while observing url changes\")\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new z(), 3, null);
        View view2 = getView();
        h.c.s<kotlin.x> doOnTerminate = ((CipherWebView) (view2 == null ? null : view2.findViewById(e.j.a.cipherWebView))).getOnNavigationCommit().observeOn(this.f11401h).doOnTerminate(new h.c.m0.a() { // from class: com.toshi.view.fragment.toplevel.e
            @Override // h.c.m0.a
            public final void run() {
                DappsFragment.W(DappsFragment.this);
            }
        });
        kotlin.jvm.internal.m.f(doOnTerminate, "cipherWebView.onNavigationCommit\n            .observeOn(mainScheduler)\n            .doOnTerminate { extraActionsPopUpMenu.menu.findItem(R.id.stopLoading).isVisible = false }");
        ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(doOnTerminate, "Error while observing navigation commit changes", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe();
        View view3 = getView();
        h.c.s<kotlin.x> doOnTerminate2 = ((CipherWebView) (view3 == null ? null : view3.findViewById(e.j.a.cipherWebView))).getOnNavigationStart().observeOn(this.f11401h).doOnTerminate(new h.c.m0.a() { // from class: com.toshi.view.fragment.toplevel.f
            @Override // h.c.m0.a
            public final void run() {
                DappsFragment.X(DappsFragment.this);
            }
        });
        kotlin.jvm.internal.m.f(doOnTerminate2, "cipherWebView.onNavigationStart\n            .observeOn(mainScheduler)\n            .doOnTerminate { extraActionsPopUpMenu.menu.findItem(R.id.stopLoading).isVisible = true }");
        ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(doOnTerminate2, "Error while observing navigation commit changes", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe();
        View view4 = getView();
        h.c.s<Boolean> observeOn = ((CipherWebView) (view4 == null ? null : view4.findViewById(e.j.a.cipherWebView))).getOnCanGoForwardChange().observeOn(this.f11401h);
        kotlin.jvm.internal.m.f(observeOn, "cipherWebView.onCanGoForwardChange\n            .observeOn(mainScheduler)");
        Object as2 = Observable_AnalyticsKt.logError$default(observeOn, "Error while observing navigation changes", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as2, "cipherWebView.onCanGoForwardChange\n            .observeOn(mainScheduler)\n            .logError(\"Error while observing navigation changes\")\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new a0(), 3, null);
        View view5 = getView();
        h.c.s<Boolean> observeOn2 = ((CipherWebView) (view5 == null ? null : view5.findViewById(e.j.a.cipherWebView))).getOnCanGoBackChange().observeOn(this.f11401h);
        kotlin.jvm.internal.m.f(observeOn2, "cipherWebView.onCanGoBackChange\n            .observeOn(mainScheduler)");
        Object as3 = Observable_AnalyticsKt.logError$default(observeOn2, "Error while observing navigation changes", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as3, "cipherWebView.onCanGoBackChange\n            .observeOn(mainScheduler)\n            .logError(\"Error while observing navigation changes\")\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new b0(), 3, null);
        View view6 = getView();
        h.c.s<Web3Call> observeOn3 = ((CipherWebView) (view6 == null ? null : view6.findViewById(e.j.a.cipherWebView))).getOnWeb3Call().observeOn(this.f11401h);
        kotlin.jvm.internal.m.f(observeOn3, "cipherWebView.onWeb3Call\n            .observeOn(mainScheduler)");
        Object as4 = Observable_AnalyticsKt.logError$default(observeOn3, "Error while observing web3 calls", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as4, "cipherWebView.onWeb3Call\n            .observeOn(mainScheduler)\n            .logError(\"Error while observing web3 calls\")\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as4, null, null, new c0(), 3, null);
        View view7 = getView();
        h.c.s map = ((CipherWebView) (view7 == null ? null : view7.findViewById(e.j.a.cipherWebView))).getOnProgressChange().observeOn(this.f11401h).map(new h.c.m0.n() { // from class: com.toshi.view.fragment.toplevel.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return DappsFragment.a0((Double) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.toshi.view.fragment.toplevel.t
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return DappsFragment.l0((Double) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "cipherWebView.onProgressChange\n            .observeOn(mainScheduler)\n            .map { it.times(100) }\n            .map { it.toInt() }");
        Object as5 = Observable_AnalyticsKt.logError$default(map, "Error while observing progress", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as5, "cipherWebView.onProgressChange\n            .observeOn(mainScheduler)\n            .map { it.times(100) }\n            .map { it.toInt() }\n            .logError(\"Error while observing progress\")\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as5, null, null, new u(), 3, null);
        View view8 = getView();
        h.c.s<String> observeOn4 = ((CipherWebView) (view8 == null ? null : view8.findViewById(e.j.a.cipherWebView))).getOnTitleChange().observeOn(this.f11401h);
        kotlin.jvm.internal.m.f(observeOn4, "cipherWebView.onTitleChange\n            .observeOn(mainScheduler)");
        Object as6 = Observable_AnalyticsKt.logError$default(observeOn4, "Error while observing title changes", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as6, "cipherWebView.onTitleChange\n            .observeOn(mainScheduler)\n            .logError(\"Error while observing title changes\")\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as6, null, null, new v(), 3, null);
        View view9 = getView();
        h.c.s<WebChromeClient.FileChooserParams> observeOn5 = ((CipherWebView) (view9 == null ? null : view9.findViewById(e.j.a.cipherWebView))).getOnFileUpload().observeOn(this.f11401h);
        kotlin.jvm.internal.m.f(observeOn5, "cipherWebView.onFileUpload\n            .observeOn(mainScheduler)");
        Object as7 = Observable_AnalyticsKt.logError$default(observeOn5, "Error while observing for file upload events", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as7, "cipherWebView.onFileUpload\n            .observeOn(mainScheduler)\n            .logError(\"Error while observing for file upload events\")\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as7, null, null, new w(), 3, null);
        h2 h2Var = this.f11395b;
        if (h2Var != null) {
            h.c.s observeOn6 = h2Var.t().map(new h.c.m0.n() { // from class: com.toshi.view.fragment.toplevel.a
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    Optional y0;
                    y0 = DappsFragment.y0((Web3CallResponse) obj);
                    return y0;
                }
            }).observeOn(this.f11401h);
            kotlin.jvm.internal.m.f(observeOn6, "viewModel.respondToWeb3CallObservable\n            .map { Optional(it) }\n            .observeOn(mainScheduler)");
            Object as8 = Observable_AnalyticsKt.logError$default(observeOn6, "Error while observing web3 call responses", null, 2, null).onErrorReturnItem(new Optional(null)).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as8, "viewModel.respondToWeb3CallObservable\n            .map { Optional(it) }\n            .observeOn(mainScheduler)\n            .logError(\"Error while observing web3 call responses\")\n            .onErrorReturnItem(Optional(null))\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as8, null, null, new x(), 3, null);
            h2 h2Var2 = this.f11395b;
            if (h2Var2 != null) {
                h.c.s<R> map2 = h2Var2.r().observeOn(this.f11401h).map(new h.c.m0.n() { // from class: com.toshi.view.fragment.toplevel.k
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return DappsFragment.c0((List) obj);
                    }
                });
                kotlin.jvm.internal.m.f(map2, "viewModel.bookmarksObservable\n            .observeOn(mainScheduler)\n            .map { bookmarks -> bookmarks.map { JSBookmark(it) } }");
                Object as9 = Observable_AnalyticsKt.logError$default(map2, "Error while fetching bookmarks", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as9, "viewModel.bookmarksObservable\n            .observeOn(mainScheduler)\n            .map { bookmarks -> bookmarks.map { JSBookmark(it) } }\n            .logError(\"Error while fetching bookmarks\")\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as9, null, null, new y(), 3, null);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public final void t0(WebChromeClient.FileChooserParams fileChooserParams) {
        Intent createIntent = fileChooserParams.createIntent();
        createIntent.setType("*/*");
        try {
            startActivityForResult(createIntent, 100);
        } catch (ActivityNotFoundException e2) {
            l.a.a.f(e2, "Cannot open file chooser", new Object[0]);
        }
    }

    public final void u0(String str) {
        String string = getString(R.string.google_search_url);
        kotlin.jvm.internal.m.f(string, "getString(R.string.google_search_url)");
        String e2 = e.j.f.u.e(str, string);
        View view = getView();
        ((CipherWebView) (view == null ? null : view.findViewById(e.j.a.cipherWebView))).loadURL(e2);
        w();
    }

    public final void v0() {
        requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
    }

    public final void w() {
        View view = getView();
        ((AddressBarInputView) (view == null ? null : view.findViewById(e.j.a.input))).clearFocus();
    }

    public static final Double w0(Double it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Double.valueOf(it.doubleValue() * 100);
    }

    private final String x() {
        return (String) this.f11400g.getValue();
    }

    public static final Integer x0(Double it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Integer.valueOf((int) it.doubleValue());
    }

    public static final Optional y0(Web3CallResponse it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new Optional(it);
    }

    public final String z() {
        return (String) this.f11399f.getValue();
    }

    public static final List z0(List bookmarks) {
        int r2;
        kotlin.jvm.internal.m.g(bookmarks, "bookmarks");
        r2 = kotlin.a0.s.r(bookmarks, 10);
        ArrayList arrayList = new ArrayList(r2);
        Iterator it = bookmarks.iterator();
        while (it.hasNext()) {
            arrayList.add(new JSBookmark((Bookmark) it.next()));
        }
        return arrayList;
    }

    public final Moshi A() {
        Moshi moshi = this.t;
        if (moshi != null) {
            return moshi;
        }
        kotlin.jvm.internal.m.w("moshi");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public c.h.k.d0 applyWindowInsets(View view, c.h.k.d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.DefaultImpls.getAttributes(this);
    }

    public final AuthenticationHelper getAuthenticationHelper$app_productionRelease() {
        AuthenticationHelper authenticationHelper = this.q;
        if (authenticationHelper != null) {
            return authenticationHelper;
        }
        kotlin.jvm.internal.m.w("authenticationHelper");
        throw null;
    }

    public final GenericViewModelFactory<h2> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<h2> genericViewModelFactory = this.p;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 100) {
            Uri[] parseResult = WebChromeClient.FileChooserParams.parseResult(i3, intent);
            if (parseResult != null) {
                View view = getView();
                ((CipherWebView) (view != null ? view.findViewById(e.j.a.cipherWebView) : null)).setFileUploadUri(parseResult);
                return;
            }
            View view2 = getView();
            ((CipherWebView) (view2 != null ? view2.findViewById(e.j.a.cipherWebView) : null)).cancelFileUpload();
        }
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        View view = getView();
        if (((AddressBarInputView) (view == null ? null : view.findViewById(e.j.a.input))).l()) {
            View view2 = getView();
            ((AddressBarInputView) (view2 != null ? view2.findViewById(e.j.a.input) : null)).clearFocus();
            return true;
        }
        View view3 = getView();
        if (((CipherWebView) (view3 == null ? null : view3.findViewById(e.j.a.cipherWebView))).getWebView().canGoBack()) {
            View view4 = getView();
            ((CipherWebView) (view4 != null ? view4.findViewById(e.j.a.cipherWebView) : null)).goBack();
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        super.onCreateView(inflater, viewGroup, bundle);
        return inflater.inflate(R.layout.fragment_dapp_view, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        View view = getView();
        ((CipherWebView) (view == null ? null : view.findViewById(e.j.a.cipherWebView))).getWebView().destroy();
        getAuthenticationHelper$app_productionRelease().clear();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] permissions, int[] grantResults) {
        WebChromeClient.FileChooserParams fileChooserParams;
        kotlin.jvm.internal.m.g(permissions, "permissions");
        kotlin.jvm.internal.m.g(grantResults, "grantResults");
        super.onRequestPermissionsResult(i2, permissions, grantResults);
        if (i2 != 1) {
            return;
        }
        if ((!(grantResults.length == 0)) && grantResults[0] == 0 && (fileChooserParams = this.n) != null) {
            t0(fileChooserParams);
        }
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        init();
    }

    public final DeepLinkRepository y() {
        DeepLinkRepository deepLinkRepository = this.x;
        if (deepLinkRepository != null) {
            return deepLinkRepository;
        }
        kotlin.jvm.internal.m.w("deeplinkRepository");
        throw null;
    }
}