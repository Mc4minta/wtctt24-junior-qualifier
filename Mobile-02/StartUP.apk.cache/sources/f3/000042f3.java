package com.toshi.view.fragment.legal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import c.h.k.d0;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.toshi.view.fragment.o0;
import e.j.l.j;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k;
import org.toshi.R;

/* compiled from: LegalViewFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001'B\u0007¢\u0006\u0004\b&\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/toshi/view/fragment/legal/LegalViewFragment;", "Lcom/toshi/view/fragment/o0;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "init", "()V", "initClickListeners", "g", "f", "", "e", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "onBackPressed", "()Z", "Lcom/toshi/view/fragment/legal/b;", "b", "Lkotlin/h;", "d", "()Lcom/toshi/view/fragment/legal/b;", "legalType", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class LegalViewFragment extends o0 implements BackableFragment, StyledFragment {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final h f11339b;

    /* compiled from: LegalViewFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(com.toshi.view.fragment.legal.b legalType) {
            m.g(legalType, "legalType");
            Bundle bundle = new Bundle();
            bundle.putSerializable("legalType", legalType);
            return bundle;
        }
    }

    /* compiled from: LegalViewFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends j {
        b() {
            super(0L, 1, null);
        }

        @Override // e.j.l.j
        public void a(View v) {
            m.g(v, "v");
            Fragment_CommonKt.navigateUp(LegalViewFragment.this);
        }
    }

    /* compiled from: LegalViewFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends WebViewClient {
        c() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String str) {
            m.g(view, "view");
            if (str == null) {
                str = "";
            }
            view.loadUrl(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            m.g(view, "view");
            m.g(request, "request");
            Uri url = request.getUrl();
            String uri = url == null ? null : url.toString();
            if (uri == null) {
                uri = "";
            }
            view.loadUrl(uri);
            return true;
        }
    }

    /* compiled from: LegalViewFragment.kt */
    /* loaded from: classes2.dex */
    static final class d extends o implements kotlin.e0.c.a<com.toshi.view.fragment.legal.b> {
        d() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final com.toshi.view.fragment.legal.b invoke() {
            Bundle arguments = LegalViewFragment.this.getArguments();
            Serializable serializable = arguments == null ? null : arguments.getSerializable("legalType");
            com.toshi.view.fragment.legal.b bVar = serializable instanceof com.toshi.view.fragment.legal.b ? (com.toshi.view.fragment.legal.b) serializable : null;
            return bVar == null ? com.toshi.view.fragment.legal.b.PRIVACY_POLICY : bVar;
        }
    }

    public LegalViewFragment() {
        h b2;
        b2 = k.b(new d());
        this.f11339b = b2;
    }

    private final com.toshi.view.fragment.legal.b d() {
        return (com.toshi.view.fragment.legal.b) this.f11339b.getValue();
    }

    private final String e() {
        com.toshi.view.fragment.legal.b d2 = d();
        Context requireContext = requireContext();
        m.f(requireContext, "requireContext()");
        return d2.n(requireContext);
    }

    private final void f() {
        String e2 = e();
        View view = getView();
        ((WebView) (view == null ? null : view.findViewById(e.j.a.Q7))).loadUrl(e2);
    }

    private final void g() {
        View view = getView();
        ((WebView) (view == null ? null : view.findViewById(e.j.a.Q7))).setWebViewClient(new c());
        View view2 = getView();
        WebSettings settings = ((WebView) (view2 != null ? view2.findViewById(e.j.a.Q7) : null)).getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
    }

    private final void init() {
        initClickListeners();
        g();
        f();
    }

    private final void initClickListeners() {
        View view = getView();
        ((ImageView) (view == null ? null : view.findViewById(e.j.a.backButton))).setOnClickListener(new b());
    }

    @Override // com.toshi.view.fragment.o0, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 4, null);
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        View view = getView();
        if (((WebView) (view == null ? null : view.findViewById(e.j.a.Q7))).canGoBack()) {
            View view2 = getView();
            ((WebView) (view2 != null ? view2.findViewById(e.j.a.Q7) : null)).goBack();
            return true;
        }
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_legal_view, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        init();
    }
}