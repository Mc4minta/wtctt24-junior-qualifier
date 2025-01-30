package com.toshi.view.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.navigation.fragment.b;
import com.appsflyer.share.Constants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.toshi.model.local.room.Erc721Token;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: CollectibleDetailFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001,B\u0007¢\u0006\u0004\b+\u0010\u0014J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR+\u0010$\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u001e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010#R\u001d\u0010'\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001cR\u001d\u0010(\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b\u0019\u0010\u001cR\u001d\u0010*\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001a\u001a\u0004\b)\u0010\u001c¨\u0006-"}, d2 = {"Lcom/toshi/view/fragment/CollectibleDetailFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/x;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "", "onBackPressed", "()Z", "", "e", "Lkotlin/h;", "d", "()Ljava/lang/String;", "collectibleImage", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "b", "g", "()Lcom/bumptech/glide/RequestBuilder;", "glideSvg", Constants.URL_CAMPAIGN, "f", "collectibleType", "collectibleName", "h", "transitionName", "<init>", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CollectibleDetailFragment extends BaseFragment implements StyledFragment, BackableFragment {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.h f11250b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.h f11251c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.h f11252d;

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.h f11253e;

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.h f11254f;

    /* compiled from: CollectibleDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(Erc721Token collectible, String collectibleType, String transition) {
            kotlin.jvm.internal.m.g(collectible, "collectible");
            kotlin.jvm.internal.m.g(collectibleType, "collectibleType");
            kotlin.jvm.internal.m.g(transition, "transition");
            Bundle bundle = new Bundle();
            bundle.putString("collectible_image", collectible.getImage());
            bundle.putString("collectible_name", collectible.getName());
            bundle.putString("collectible_type", collectibleType);
            bundle.putString("transition_name", transition);
            return bundle;
        }

        public final b.C0036b b(View view) {
            kotlin.jvm.internal.m.g(view, "view");
            return androidx.navigation.fragment.c.a(kotlin.u.a(view, view.getTransitionName()));
        }
    }

    /* compiled from: CollectibleDetailFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.a<String> {
        b() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final String invoke() {
            return e.j.f.e.d(CollectibleDetailFragment.this.getArguments(), "collectible_image");
        }
    }

    /* compiled from: CollectibleDetailFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.a<String> {
        c() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final String invoke() {
            return e.j.f.e.d(CollectibleDetailFragment.this.getArguments(), "collectible_name");
        }
    }

    /* compiled from: CollectibleDetailFragment.kt */
    /* loaded from: classes2.dex */
    static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.a<String> {
        d() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final String invoke() {
            return e.j.f.e.d(CollectibleDetailFragment.this.getArguments(), "collectible_type");
        }
    }

    /* compiled from: CollectibleDetailFragment.kt */
    /* loaded from: classes2.dex */
    static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.a<RequestBuilder<Drawable>> {

        /* compiled from: CollectibleDetailFragment.kt */
        /* loaded from: classes2.dex */
        public static final class a implements RequestListener<Drawable> {
            final /* synthetic */ CollectibleDetailFragment a;

            a(CollectibleDetailFragment collectibleDetailFragment) {
                this.a = collectibleDetailFragment;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* renamed from: a */
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                this.a.startPostponedEnterTransition();
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                this.a.startPostponedEnterTransition();
                return false;
            }
        }

        e() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final RequestBuilder<Drawable> invoke() {
            return Glide.with(CollectibleDetailFragment.this).asDrawable().apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.drawable.collectible_empty).fitCenter()).apply((BaseRequestOptions<?>) new RequestOptions().error(R.drawable.collectible_empty).fitCenter()).listener(new a(CollectibleDetailFragment.this));
        }
    }

    /* compiled from: CollectibleDetailFragment.kt */
    /* loaded from: classes2.dex */
    static final class f extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        f() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            Fragment_CommonKt.navigateUp(CollectibleDetailFragment.this);
        }
    }

    /* compiled from: CollectibleDetailFragment.kt */
    /* loaded from: classes2.dex */
    static final class g extends kotlin.jvm.internal.o implements kotlin.e0.c.a<String> {
        g() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final String invoke() {
            return e.j.f.e.d(CollectibleDetailFragment.this.getArguments(), "transition_name");
        }
    }

    public CollectibleDetailFragment() {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        kotlin.h b5;
        kotlin.h b6;
        b2 = kotlin.k.b(new e());
        this.f11250b = b2;
        b3 = kotlin.k.b(new d());
        this.f11251c = b3;
        b4 = kotlin.k.b(new c());
        this.f11252d = b4;
        b5 = kotlin.k.b(new b());
        this.f11253e = b5;
        b6 = kotlin.k.b(new g());
        this.f11254f = b6;
    }

    private final String d() {
        return (String) this.f11253e.getValue();
    }

    private final String e() {
        return (String) this.f11252d.getValue();
    }

    private final String f() {
        return (String) this.f11251c.getValue();
    }

    private final RequestBuilder<Drawable> g() {
        return (RequestBuilder) this.f11250b.getValue();
    }

    private final String h() {
        return (String) this.f11254f.getValue();
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

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSharedElementReturnTransition(TransitionInflater.from(getContext()).inflateTransition(R.transition.image_shared_element_transition));
        setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(R.transition.image_shared_element_transition));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_collectible_detail, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.collectibleDetailLanded(AnalyticsEvent.Companion));
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        postponeEnterTransition();
        View view2 = getView();
        View closeButton = view2 == null ? null : view2.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new f(), 1, null);
        View view3 = getView();
        ((TextView) (view3 == null ? null : view3.findViewById(e.j.a.C1))).setText(f());
        View view4 = getView();
        ((TextView) (view4 == null ? null : view4.findViewById(e.j.a.n4))).setText(e());
        View view5 = getView();
        ((ImageView) (view5 == null ? null : view5.findViewById(e.j.a.imageView))).setTransitionName(h());
        RequestBuilder<Drawable> load = g().load(d());
        View view6 = getView();
        load.into((ImageView) (view6 != null ? view6.findViewById(e.j.a.imageView) : null));
    }
}