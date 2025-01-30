package com.toshi.view.fragment.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.c;
import androidx.viewpager.widget.ViewPager;
import c.h.k.d0;
import c.h.k.q;
import c.h.k.v;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.toshi.view.fragment.o0;
import e.j.f.k;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.h;
import kotlin.j;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.u;
import kotlin.x;
import org.toshi.R;

/* compiled from: LandingFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0007¢\u0006\u0004\b&\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005J-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001e\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\u00020 8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/toshi/view/fragment/onboarding/LandingFragment;", "Lcom/toshi/view/fragment/o0;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "setup", "()V", "setupClickListeners", "k", "checkBannedLocation", "showBannedDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "b", "Lkotlin/h;", "g", "()F", "screenWidth", "", Constants.URL_CAMPAIGN, "isBannedLocation", "()Z", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "d", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class LandingFragment extends o0 implements StyledFragment {
    public static final a a = new a(null);

    /* renamed from: b */
    private final h f11344b = j.b(new c());

    /* renamed from: c */
    private final h f11345c = j.b(new b());

    /* renamed from: d */
    private final StyledFragment.Attributes f11346d = new StyledFragment.Attributes(true, false, false, 6, null);

    /* compiled from: LandingFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: LandingFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends o implements kotlin.e0.c.a<Boolean> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b() {
            super(0);
            LandingFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke */
        public final boolean invoke2() {
            Bundle arguments = LandingFragment.this.getArguments();
            if (arguments == null) {
                return false;
            }
            return arguments.getBoolean("banned_location", false);
        }
    }

    /* compiled from: LandingFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends o implements kotlin.e0.c.a<Float> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c() {
            super(0);
            LandingFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ Float invoke() {
            return Float.valueOf(invoke2());
        }

        /* renamed from: invoke */
        public final float invoke2() {
            return LandingFragment.this.getResources().getConfiguration().screenWidthDp * LandingFragment.this.getResources().getDisplayMetrics().density;
        }
    }

    /* compiled from: LandingFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends o implements l<View, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d() {
            super(1);
            LandingFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            m.g(it, "it");
            Fragment_CommonKt.navigate$default(LandingFragment.this, R.id.action_landingFragment_to_restoreWalletFragment, androidx.core.os.b.a(u.a("banned_location", Boolean.valueOf(LandingFragment.this.isBannedLocation()))), null, null, 12, null);
        }
    }

    /* compiled from: LandingFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends o implements l<View, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e() {
            super(1);
            LandingFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            m.g(it, "it");
            if (LandingFragment.this.isBannedLocation()) {
                LandingFragment.this.showBannedDialog();
                return;
            }
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.newWalletStart(AnalyticsEvent.Companion));
            Fragment_CommonKt.navigate$default(LandingFragment.this, R.id.action_landingFragment_to_legalAgreementFragment, null, null, null, 14, null);
        }
    }

    /* compiled from: LandingFragment.kt */
    /* loaded from: classes2.dex */
    public static final class f extends o implements l<c.a, x> {
        public static final f a = new f();

        f() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(c.a aVar) {
            invoke2(aVar);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(c.a showDialog) {
            m.g(showDialog, "$this$showDialog");
            showDialog.n(R.string.banned_location_dialog_title);
            showDialog.f(R.string.banned_location_dialog_restore_message);
            k.b(showDialog, R.string.ok);
        }
    }

    private final void checkBannedLocation() {
        if (isBannedLocation()) {
            View view = getView();
            ((Button) (view == null ? null : view.findViewById(e.j.a.createNewAccount))).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.fragment.onboarding.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LandingFragment.h(LandingFragment.this, view2);
                }
            });
            showBannedDialog();
        }
    }

    public static final void f(LandingFragment this$0, View view) {
        m.g(this$0, "this$0");
        this$0.showBannedDialog();
    }

    private final float g() {
        return ((Number) this.f11344b.getValue()).floatValue();
    }

    public static /* synthetic */ void h(LandingFragment landingFragment, View view) {
        f(landingFragment, view);
    }

    public final boolean isBannedLocation() {
        return ((Boolean) this.f11345c.getValue()).booleanValue();
    }

    public static final d0 j(View v, d0 d0Var) {
        m.f(v, "v");
        v.setPadding(v.getPaddingLeft(), v.getPaddingTop(), v.getPaddingRight(), d0Var.i());
        return d0Var;
    }

    private final void k() {
        View view = getView();
        ViewPager viewPager = (ViewPager) (view == null ? null : view.findViewById(e.j.a.landingViewPager));
        viewPager.setAdapter(new e.j.m.a.j(g()));
        viewPager.setOffscreenPageLimit(3);
    }

    private final void setup() {
        setupClickListeners();
        checkBannedLocation();
        k();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.landingPageLanded(AnalyticsEvent.Companion));
    }

    private final void setupClickListeners() {
        View view = getView();
        View signIn = view == null ? null : view.findViewById(e.j.a.signIn);
        m.f(signIn, "signIn");
        View_CommonKt.setOnSingleClickListener$default(signIn, 0L, new d(), 1, null);
        View view2 = getView();
        View createNewAccount = view2 != null ? view2.findViewById(e.j.a.createNewAccount) : null;
        m.f(createNewAccount, "createNewAccount");
        View_CommonKt.setOnSingleClickListener$default(createNewAccount, 0L, new e(), 1, null);
    }

    public final void showBannedDialog() {
        e.j.f.m.p(this, f.a);
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
        return this.f11346d;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_landing, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        v.w0(view, new q() { // from class: com.toshi.view.fragment.onboarding.b
            @Override // c.h.k.q
            public final d0 a(View view2, d0 d0Var) {
                d0 j2;
                j2 = LandingFragment.j(view2, d0Var);
                return j2;
            }
        });
        setup();
    }
}