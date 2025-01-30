package com.toshi.view.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.i;
import androidx.viewpager.widget.ViewPager;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.share.Constants;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.view.custom.ViewPagerHeader;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Context_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.models.ForwardArgs;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.google.android.material.tabs.TabLayout;
import com.squareup.moshi.JsonClass;
import com.toshi.model.local.room.Prompt;
import com.toshi.view.custom.NoSwipeViewPager;
import com.toshi.view.fragment.r0.g;
import e.j.n.j2;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.http.protocol.HTTP;
import org.toshi.R;

/* compiled from: DisplayCoinAddressFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u000e\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001fB\u0007¢\u0006\u0004\be\u0010\tJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u00132\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b%\u0010&J!\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,R#\u00102\u001a\b\u0012\u0004\u0012\u00020\u00110-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001e\u00107\u001a\n 4*\u0004\u0018\u000103038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001f\u0010<\u001a\u0004\u0018\u0001088B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010/\u001a\u0004\b:\u0010;R\u001d\u0010?\u001a\u00020*8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010/\u001a\u0004\b>\u0010,R(\u0010H\u001a\b\u0012\u0004\u0012\u00020A0@8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001f\u0010L\u001a\u0004\u0018\u00010\n8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010/\u001a\u0004\bJ\u0010KR\"\u0010S\u001a\u00020M8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u0015\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u001d\u0010[\u001a\u00020\f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010/\u001a\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0016\u0010b\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\\8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bc\u0010^¨\u0006g"}, d2 = {"Lcom/toshi/view/fragment/DisplayCoinAddressFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lh/c/k0/b;", "t", "()Lh/c/k0/b;", "Lkotlin/x;", "u", "()V", "", "numPages", "", "username", "com/toshi/view/fragment/DisplayCoinAddressFragment$e", "p", "(ILjava/lang/String;)Lcom/toshi/view/fragment/DisplayCoinAddressFragment$e;", "Lcom/toshi/view/fragment/DisplayCoinAddressFragment$DisplayCoinAddress;", "qrCode", "Landroid/view/ViewGroup;", "viewGroup", "j", "(Lcom/toshi/view/fragment/DisplayCoinAddressFragment$DisplayCoinAddress;Landroid/view/ViewGroup;)V", "Landroid/graphics/Bitmap;", "Landroid/widget/ImageView;", "qrCodeView", "r", "(Landroid/graphics/Bitmap;Landroid/widget/ImageView;)V", "address", "s", "(Ljava/lang/String;)V", "Landroid/view/LayoutInflater;", "inflater", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "onBackPressed", "()Z", "", "e", "Lkotlin/h;", "k", "()Ljava/util/List;", ApiConstants.ADDRESSES, "Lh/c/a0;", "kotlin.jvm.PlatformType", "a", "Lh/c/a0;", "mainScheduler", "Lcom/toshi/model/local/room/Prompt;", "f", "n", "()Lcom/toshi/model/local/room/Prompt;", "prompt", "d", "q", "isPromptWarning", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Le/j/n/j2;", "h", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", Constants.URL_CAMPAIGN, "o", "()Ljava/lang/Integer;", "promptMessageResId", "Lcom/toshi/view/fragment/h0;", "Lcom/toshi/view/fragment/h0;", "m", "()Lcom/toshi/view/fragment/h0;", "setDisplayCoinAddressFragmentFactory$app_productionRelease", "(Lcom/toshi/view/fragment/h0;)V", "displayCoinAddressFragmentFactory", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "b", "l", "()Ljava/lang/String;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "g", "Le/j/n/j2;", "viewModel", "getOnDestroyScopeProvider", "onDestroyScopeProvider", "<init>", "DisplayCoinAddress", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DisplayCoinAddressFragment extends LockedFragment implements StyledFragment, BackableFragment {
    private final h.c.a0 a = h.c.j0.c.a.b();

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.h f11257b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.h f11258c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.h f11259d;

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.h f11260e;

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.h f11261f;

    /* renamed from: g  reason: collision with root package name */
    private j2 f11262g;

    /* renamed from: h  reason: collision with root package name */
    public GenericViewModelFactory<j2> f11263h;

    /* renamed from: j  reason: collision with root package name */
    public h0 f11264j;

    /* compiled from: DisplayCoinAddressFragment.kt */
    /* loaded from: classes2.dex */
    static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<List<? extends DisplayCoinAddress>> {
        a() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final List<? extends DisplayCoinAddress> invoke() {
            return DisplayCoinAddressFragment.this.m().a(e.j.f.e.d(DisplayCoinAddressFragment.this.getArguments(), "EXTRA_ADDRESS"));
        }
    }

    /* compiled from: DisplayCoinAddressFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.a<String> {
        b() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final String invoke() {
            return e.j.f.e.d(DisplayCoinAddressFragment.this.getArguments(), "EXTRA_CRYPTO");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DisplayCoinAddressFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DisplayCoinAddress f11268b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(DisplayCoinAddress displayCoinAddress) {
            super(1);
            this.f11268b = displayCoinAddress;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
            invoke2(view);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            View view = DisplayCoinAddressFragment.this.getView();
            kotlin.x xVar = null;
            Context context = view == null ? null : view.getContext();
            if (context == null) {
                return;
            }
            ClipData newPlainText = ClipData.newPlainText(DisplayCoinAddressFragment.this.getString(R.string.address), this.f11268b.a());
            ClipboardManager clipboardManager = Context_CommonKt.getClipboardManager(context);
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newPlainText);
                xVar = kotlin.x.a;
            }
            if (xVar == null) {
                return;
            }
            Toast.makeText(context, (int) R.string.address_copied, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DisplayCoinAddressFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Bitmap, kotlin.x> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ImageView f11269b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ImageView imageView) {
            super(1);
            this.f11269b = imageView;
        }

        public final void a(Bitmap it) {
            DisplayCoinAddressFragment displayCoinAddressFragment = DisplayCoinAddressFragment.this;
            kotlin.jvm.internal.m.f(it, "it");
            ImageView imageView = this.f11269b;
            kotlin.jvm.internal.m.f(imageView, "imageView");
            displayCoinAddressFragment.r(it, imageView);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Bitmap bitmap) {
            a(bitmap);
            return kotlin.x.a;
        }
    }

    /* compiled from: DisplayCoinAddressFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends androidx.viewpager.widget.a {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f11270b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DisplayCoinAddressFragment f11271c;

        /* compiled from: DisplayCoinAddressFragment.kt */
        /* loaded from: classes2.dex */
        public static final class a extends androidx.viewpager.widget.a {
            final /* synthetic */ DisplayCoinAddressFragment a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ LayoutInflater f11272b;

            a(DisplayCoinAddressFragment displayCoinAddressFragment, LayoutInflater layoutInflater) {
                this.a = displayCoinAddressFragment;
                this.f11272b = layoutInflater;
            }

            @Override // androidx.viewpager.widget.a
            public int getCount() {
                return this.a.k().size();
            }

            @Override // androidx.viewpager.widget.a
            public Object instantiateItem(ViewGroup container, int i2) {
                kotlin.jvm.internal.m.g(container, "container");
                View inflate = this.f11272b.inflate(R.layout.qr_code_and_address, container, false);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) inflate;
                viewGroup.setTag(kotlin.jvm.internal.m.o("qrCode", Integer.valueOf(i2)));
                DisplayCoinAddressFragment displayCoinAddressFragment = this.a;
                displayCoinAddressFragment.j((DisplayCoinAddress) displayCoinAddressFragment.k().get(i2), viewGroup);
                container.addView(viewGroup);
                return viewGroup;
            }

            @Override // androidx.viewpager.widget.a
            public boolean isViewFromObject(View view, Object object) {
                kotlin.jvm.internal.m.g(view, "view");
                kotlin.jvm.internal.m.g(object, "object");
                return kotlin.jvm.internal.m.c(view, object);
            }
        }

        /* compiled from: DisplayCoinAddressFragment.kt */
        /* loaded from: classes2.dex */
        public static final class b implements TabLayout.c {
            final /* synthetic */ DisplayCoinAddressFragment a;

            b(DisplayCoinAddressFragment displayCoinAddressFragment) {
                this.a = displayCoinAddressFragment;
            }

            @Override // com.google.android.material.tabs.TabLayout.c
            public void onTabReselected(TabLayout.f p) {
                kotlin.jvm.internal.m.g(p, "p");
            }

            @Override // com.google.android.material.tabs.TabLayout.c
            public void onTabSelected(TabLayout.f p) {
                kotlin.jvm.internal.m.g(p, "p");
                View view = this.a.getView();
                ((NoSwipeViewPager) (view == null ? null : view.findViewById(e.j.a.qrCodeViewPager))).setCurrentItem(p.e());
            }

            @Override // com.google.android.material.tabs.TabLayout.c
            public void onTabUnselected(TabLayout.f p) {
                kotlin.jvm.internal.m.g(p, "p");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DisplayCoinAddressFragment.kt */
        /* loaded from: classes2.dex */
        public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
            final /* synthetic */ DisplayCoinAddressFragment a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(DisplayCoinAddressFragment displayCoinAddressFragment) {
                super(1);
                this.a = displayCoinAddressFragment;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
                invoke2(view);
                return kotlin.x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                kotlin.jvm.internal.m.g(it, "it");
                DisplayCoinAddressFragment displayCoinAddressFragment = this.a;
                List k2 = displayCoinAddressFragment.k();
                View view = this.a.getView();
                displayCoinAddressFragment.s(((DisplayCoinAddress) k2.get(((NoSwipeViewPager) (view == null ? null : view.findViewById(e.j.a.qrCodeViewPager))).getCurrentItem())).a());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DisplayCoinAddressFragment.kt */
        /* loaded from: classes2.dex */
        public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
            final /* synthetic */ DisplayCoinAddressFragment a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f11273b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(DisplayCoinAddressFragment displayCoinAddressFragment, String str) {
                super(1);
                this.a = displayCoinAddressFragment;
                this.f11273b = str;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
                invoke2(view);
                return kotlin.x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                kotlin.jvm.internal.m.g(it, "it");
                DisplayCoinAddressFragment displayCoinAddressFragment = this.a;
                String string = displayCoinAddressFragment.getString(R.string.send_to_username_share_copy, this.f11273b);
                kotlin.jvm.internal.m.f(string, "getString(R.string.send_to_username_share_copy, username)");
                displayCoinAddressFragment.s(string);
            }
        }

        e(int i2, String str, DisplayCoinAddressFragment displayCoinAddressFragment) {
            this.a = i2;
            this.f11270b = str;
            this.f11271c = displayCoinAddressFragment;
        }

        private final Object a(ViewGroup viewGroup) {
            int r;
            LayoutInflater from = LayoutInflater.from(this.f11271c.getContext());
            if (from != null) {
                View inflate = from.inflate(R.layout.qr_code_and_address_parent, viewGroup, false);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup2 = (ViewGroup) inflate;
                viewGroup.addView(viewGroup2);
                View view = this.f11271c.getView();
                ((NoSwipeViewPager) (view == null ? null : view.findViewById(e.j.a.qrCodeViewPager))).setAdapter(new a(this.f11271c, from));
                View view2 = this.f11271c.getView();
                View addressSwitcher = view2 == null ? null : view2.findViewById(e.j.a.addressSwitcher);
                kotlin.jvm.internal.m.f(addressSwitcher, "addressSwitcher");
                addressSwitcher.setVisibility(this.f11271c.k().size() > 1 ? 0 : 8);
                if (this.f11271c.k().size() > 1) {
                    List<DisplayCoinAddress> k2 = this.f11271c.k();
                    DisplayCoinAddressFragment displayCoinAddressFragment = this.f11271c;
                    r = kotlin.a0.s.r(k2, 10);
                    ArrayList arrayList = new ArrayList(r);
                    for (DisplayCoinAddress displayCoinAddress : k2) {
                        Integer b2 = displayCoinAddress.b();
                        String string = displayCoinAddressFragment.getString(b2 == null ? R.string.blank : b2.intValue());
                        kotlin.jvm.internal.m.f(string, "getString(it.addressName ?: R.string.blank)");
                        View view3 = displayCoinAddressFragment.getView();
                        TabLayout tabLayout = (TabLayout) (view3 == null ? null : view3.findViewById(e.j.a.addressSwitcher));
                        View view4 = displayCoinAddressFragment.getView();
                        tabLayout.c(((TabLayout) (view4 == null ? null : view4.findViewById(e.j.a.addressSwitcher))).w().o(string));
                        arrayList.add(kotlin.x.a);
                    }
                    View view5 = this.f11271c.getView();
                    ((TabLayout) (view5 == null ? null : view5.findViewById(e.j.a.addressSwitcher))).b(new b(this.f11271c));
                }
                View view6 = this.f11271c.getView();
                View shareButton = view6 == null ? null : view6.findViewById(e.j.a.shareButton);
                kotlin.jvm.internal.m.f(shareButton, "shareButton");
                View_CommonKt.setOnSingleClickListener$default(shareButton, 0L, new c(this.f11271c), 1, null);
                View view7 = this.f11271c.getView();
                ((NoSwipeViewPager) (view7 != null ? view7.findViewById(e.j.a.qrCodeViewPager) : null)).setOffscreenPageLimit(this.f11271c.k().size());
                return viewGroup2;
            }
            throw new IllegalStateException("Couldn't get layout inflater");
        }

        private final Object b(ViewGroup viewGroup, String str) {
            char l1;
            LayoutInflater from = LayoutInflater.from(this.f11271c.getContext());
            if (from != null) {
                View inflate = from.inflate(R.layout.user_name_receive, viewGroup, false);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup2 = (ViewGroup) inflate;
                TextView share = (TextView) viewGroup2.findViewById(R.id.shareButton);
                ((TextView) viewGroup2.findViewById(R.id.username)).setText(this.f11271c.getString(R.string.prefixed_username, str));
                l1 = kotlin.l0.a0.l1(str);
                ((TextView) viewGroup2.findViewById(R.id.monogram)).setText(String.valueOf(Character.toUpperCase(l1)));
                kotlin.jvm.internal.m.f(share, "share");
                View_CommonKt.setOnSingleClickListener$default(share, 0L, new d(this.f11271c, str), 1, null);
                viewGroup.addView(viewGroup2);
                return viewGroup2;
            }
            throw new IllegalStateException("Couldn't get layout inflater");
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return this.a;
        }

        @Override // androidx.viewpager.widget.a
        public Object instantiateItem(ViewGroup container, int i2) {
            kotlin.jvm.internal.m.g(container, "container");
            if (i2 == 0) {
                return a(container);
            }
            return b(container, this.f11270b);
        }

        @Override // androidx.viewpager.widget.a
        public boolean isViewFromObject(View view, Object object) {
            kotlin.jvm.internal.m.g(view, "view");
            kotlin.jvm.internal.m.g(object, "object");
            return kotlin.jvm.internal.m.c(view, object);
        }
    }

    /* compiled from: DisplayCoinAddressFragment.kt */
    /* loaded from: classes2.dex */
    static final class f extends kotlin.jvm.internal.o implements kotlin.e0.c.a<Boolean> {
        f() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return e.j.f.e.a(DisplayCoinAddressFragment.this.getArguments(), "EXTRA_IS_PROMPT_WARNING");
        }
    }

    /* compiled from: DisplayCoinAddressFragment.kt */
    /* loaded from: classes2.dex */
    static final class g extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        g() {
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
            Fragment_CommonKt.navigateUp(DisplayCoinAddressFragment.this);
        }
    }

    /* compiled from: DisplayCoinAddressFragment.kt */
    /* loaded from: classes2.dex */
    static final class h extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        h() {
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
            DisplayCoinAddressFragment.this.u();
        }
    }

    /* compiled from: DisplayCoinAddressFragment.kt */
    /* loaded from: classes2.dex */
    static final class i extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
        i() {
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
            DisplayCoinAddressFragment.this.u();
        }
    }

    /* compiled from: DisplayCoinAddressFragment.kt */
    /* loaded from: classes2.dex */
    static final class j extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends Boolean, ? extends String>, kotlin.x> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DisplayCoinAddressFragment.kt */
        /* loaded from: classes2.dex */
        public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
            final /* synthetic */ ViewPagerHeader a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ViewPagerHeader viewPagerHeader) {
                super(1);
                this.a = viewPagerHeader;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
                invoke2(view);
                return kotlin.x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                kotlin.jvm.internal.m.g(it, "it");
                this.a.goToStart();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DisplayCoinAddressFragment.kt */
        /* loaded from: classes2.dex */
        public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
            final /* synthetic */ ViewPagerHeader a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(ViewPagerHeader viewPagerHeader) {
                super(1);
                this.a = viewPagerHeader;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
                invoke2(view);
                return kotlin.x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                kotlin.jvm.internal.m.g(it, "it");
                this.a.goToEnd();
            }
        }

        j() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends Boolean, ? extends String> oVar) {
            invoke2((kotlin.o<Boolean, String>) oVar);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(kotlin.o<Boolean, String> oVar) {
            Resources resources;
            boolean booleanValue = oVar.a().booleanValue();
            String b2 = oVar.b();
            View view = DisplayCoinAddressFragment.this.getView();
            View receiveTypeToggle = view == null ? null : view.findViewById(e.j.a.receiveTypeToggle);
            kotlin.jvm.internal.m.f(receiveTypeToggle, "receiveTypeToggle");
            receiveTypeToggle.setVisibility(booleanValue ? 0 : 8);
            View view2 = DisplayCoinAddressFragment.this.getView();
            View spacer1 = view2 == null ? null : view2.findViewById(e.j.a.spacer1);
            kotlin.jvm.internal.m.f(spacer1, "spacer1");
            spacer1.setVisibility(booleanValue ? 0 : 8);
            int i2 = booleanValue ? 2 : 1;
            if (booleanValue) {
                View view3 = DisplayCoinAddressFragment.this.getView();
                View findViewById = (view3 == null ? null : view3.findViewById(e.j.a.receiveTypeToggle)).findViewById(R.id.twoButtonSlider);
                Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.coinbase.wallet.application.view.custom.ViewPagerHeader");
                ViewPagerHeader viewPagerHeader = (ViewPagerHeader) findViewById;
                viewPagerHeader.setNumPages(i2);
                View view4 = DisplayCoinAddressFragment.this.getView();
                View receiveTypeViewPager = view4 == null ? null : view4.findViewById(e.j.a.receiveTypeViewPager);
                kotlin.jvm.internal.m.f(receiveTypeViewPager, "receiveTypeViewPager");
                viewPagerHeader.setViewPager((ViewPager) receiveTypeViewPager);
                View view5 = DisplayCoinAddressFragment.this.getView();
                View touchBlocker = view5 == null ? null : view5.findViewById(e.j.a.touchBlocker);
                kotlin.jvm.internal.m.f(touchBlocker, "touchBlocker");
                viewPagerHeader.setTransitionTouchBlocker(touchBlocker);
                View findViewById2 = viewPagerHeader.findViewById(e.j.a.backgroundLeft);
                kotlin.jvm.internal.m.f(findViewById2, "viewPagerHeader.backgroundLeft");
                View_CommonKt.setOnSingleClickListener$default(findViewById2, 0L, new a(viewPagerHeader), 1, null);
                View findViewById3 = viewPagerHeader.findViewById(e.j.a.backgroundRight);
                kotlin.jvm.internal.m.f(findViewById3, "viewPagerHeader.backgroundRight");
                View_CommonKt.setOnSingleClickListener$default(findViewById3, 0L, new b(viewPagerHeader), 1, null);
                View view6 = DisplayCoinAddressFragment.this.getView();
                ((ViewPager) (view6 == null ? null : view6.findViewById(e.j.a.receiveTypeViewPager))).addOnPageChangeListener(viewPagerHeader);
            }
            View view7 = DisplayCoinAddressFragment.this.getView();
            ((ViewPager) (view7 == null ? null : view7.findViewById(e.j.a.receiveTypeViewPager))).setAdapter(DisplayCoinAddressFragment.this.p(i2, b2));
            View view8 = DisplayCoinAddressFragment.this.getView();
            ((ViewPager) (view8 == null ? null : view8.findViewById(e.j.a.receiveTypeViewPager))).setOffscreenPageLimit(i2);
            Context context = DisplayCoinAddressFragment.this.getContext();
            if (context != null && (resources = context.getResources()) != null) {
                DisplayCoinAddressFragment displayCoinAddressFragment = DisplayCoinAddressFragment.this;
                int dimension = (int) resources.getDimension(R.dimen.view_size_12);
                int dimension2 = (int) resources.getDimension(R.dimen.view_size_32);
                int dimension3 = (int) resources.getDimension(R.dimen.view_size_48);
                View view9 = displayCoinAddressFragment.getView();
                ((ViewPager) (view9 == null ? null : view9.findViewById(e.j.a.receiveTypeViewPager))).setPageMargin(dimension);
                View view10 = displayCoinAddressFragment.getView();
                ((ViewPager) (view10 == null ? null : view10.findViewById(e.j.a.receiveTypeViewPager))).setPadding(dimension2, dimension, dimension2, dimension3);
            }
            View view11 = DisplayCoinAddressFragment.this.getView();
            ((ViewPager) (view11 != null ? view11.findViewById(e.j.a.receiveTypeViewPager) : null)).setClipToPadding(false);
        }
    }

    /* compiled from: DisplayCoinAddressFragment.kt */
    /* loaded from: classes2.dex */
    static final class k extends kotlin.jvm.internal.o implements kotlin.e0.c.a<Prompt> {
        k() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final Prompt invoke() {
            h0 m = DisplayCoinAddressFragment.this.m();
            Bundle arguments = DisplayCoinAddressFragment.this.getArguments();
            return m.m(arguments == null ? null : arguments.getString("EXTRA_PROMPT"));
        }
    }

    /* compiled from: DisplayCoinAddressFragment.kt */
    /* loaded from: classes2.dex */
    static final class l extends kotlin.jvm.internal.o implements kotlin.e0.c.a<Integer> {
        l() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.e0.c.a
        public final Integer invoke() {
            Bundle arguments = DisplayCoinAddressFragment.this.getArguments();
            if (arguments == null) {
                return null;
            }
            return Integer.valueOf(arguments.getInt("EXTRA_PROMPT_MESSAGE"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DisplayCoinAddressFragment.kt */
    /* loaded from: classes2.dex */
    public static final class m extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Boolean, kotlin.x> {
        public static final m a = new m();

        m() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Boolean bool) {
            invoke2(bool);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
        }
    }

    public DisplayCoinAddressFragment() {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        kotlin.h b5;
        kotlin.h b6;
        b2 = kotlin.k.b(new b());
        this.f11257b = b2;
        b3 = kotlin.k.b(new l());
        this.f11258c = b3;
        b4 = kotlin.k.b(new f());
        this.f11259d = b4;
        b5 = kotlin.k.b(new a());
        this.f11260e = b5;
        b6 = kotlin.k.b(new k());
        this.f11261f = b6;
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(DisplayCoinAddress displayCoinAddress, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.qrCodeView);
        TextView textView = (TextView) viewGroup.findViewById(R.id.coinAddress);
        textView.setText(displayCoinAddress.a());
        kotlin.jvm.internal.m.f(textView, "textView");
        View_CommonKt.setOnSingleClickListener$default(textView, 0L, new c(displayCoinAddress), 1, null);
        j2 j2Var = this.f11262g;
        if (j2Var != null) {
            h.c.b0<Bitmap> observeOn = j2Var.b(displayCoinAddress.d()).observeOn(this.a);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.generateQrCode(qrCode.url)\n            .observeOn(mainScheduler)");
            Object as = Single_AnalyticsKt.logError$default(observeOn, "Could not render QR Code", null, 2, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.generateQrCode(qrCode.url)\n            .observeOn(mainScheduler)\n            .logError(\"Could not render QR Code\")\n            .`as`(autoDisposable(onDestroyScopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new d(imageView), 1, null);
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DisplayCoinAddress> k() {
        return (List) this.f11260e.getValue();
    }

    private final String l() {
        return (String) this.f11257b.getValue();
    }

    private final Prompt n() {
        return (Prompt) this.f11261f.getValue();
    }

    private final Integer o() {
        return (Integer) this.f11258c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e p(int i2, String str) {
        return new e(i2, str, this);
    }

    private final boolean q() {
        return ((Boolean) this.f11259d.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(Bitmap bitmap, ImageView imageView) {
        imageView.setAlpha(0.0f);
        imageView.setImageBitmap(bitmap);
        imageView.animate().alpha(1.0f).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(String str) {
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.displayAddressShare(AnalyticsEvent.Companion));
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        startActivity(Intent.createChooser(intent, null));
    }

    private final h.c.k0.b t() {
        j2 j2Var = this.f11262g;
        if (j2Var != null) {
            Object as = j2Var.a(ForwardArgs.INSTANCE.create(R.id.displayCoinAddressFragment)).observeOn(h.c.j0.c.a.b()).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.backupIfNeeded(ForwardArgs.create(R.id.displayCoinAddressFragment))\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(scopeProvider))");
            return SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, m.a, 1, null);
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        Prompt n = n();
        if (n == null) {
            return;
        }
        com.toshi.view.fragment.r0.g gVar = new com.toshi.view.fragment.r0.g();
        gVar.setArguments(com.toshi.view.fragment.r0.g.a.a(n, g.b.Info));
        androidx.fragment.app.d activity = getActivity();
        if (activity != null) {
            gVar.show(activity.getSupportFragmentManager(), "PromptDialog");
        }
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.displayAddressInfoPromptSelected(AnalyticsEvent.Companion));
    }

    @Override // com.coinbase.wallet.commonui.views.LockedFragment, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public c.h.k.d0 applyWindowInsets(View view, c.h.k.d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 6, null);
    }

    public final GenericViewModelFactory<j2> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<j2> genericViewModelFactory = this.f11263h;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    public final h0 m() {
        h0 h0Var = this.f11264j;
        if (h0Var != null) {
            return h0Var;
        }
        kotlin.jvm.internal.m.w("displayCoinAddressFragmentFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_display_coin_address, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        int intValue;
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        androidx.lifecycle.b0 a2 = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(j2.class);
        kotlin.jvm.internal.m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.f11262g = (j2) a2;
        View view2 = getView();
        View backButton = view2 == null ? null : view2.findViewById(e.j.a.backButton);
        kotlin.jvm.internal.m.f(backButton, "backButton");
        View_CommonKt.setOnSingleClickListener$default(backButton, 0L, new g(), 1, null);
        View view3 = getView();
        View infoButton = view3 == null ? null : view3.findViewById(e.j.a.infoButton);
        kotlin.jvm.internal.m.f(infoButton, "infoButton");
        View_CommonKt.setOnSingleClickListener$default(infoButton, 0L, new h(), 1, null);
        View view4 = getView();
        View subtitle = view4 == null ? null : view4.findViewById(e.j.a.A6);
        kotlin.jvm.internal.m.f(subtitle, "subtitle");
        View_CommonKt.setOnSingleClickListener$default(subtitle, 0L, new i(), 1, null);
        View view5 = getView();
        ((TextView) (view5 == null ? null : view5.findViewById(e.j.a.K6))).setText(getString(R.string.template_receive_coin, l()));
        View view6 = getView();
        View infoButton2 = view6 == null ? null : view6.findViewById(e.j.a.infoButton);
        kotlin.jvm.internal.m.f(infoButton2, "infoButton");
        infoButton2.setVisibility(n() != null ? 0 : 8);
        if (q() && n() != null) {
            View view7 = getView();
            ((ImageView) (view7 == null ? null : view7.findViewById(e.j.a.infoButton))).setImageDrawable(e.j.f.m.n(this, R.drawable.ic_info_warning));
            View view8 = getView();
            ((TextView) (view8 == null ? null : view8.findViewById(e.j.a.A6))).setTextColor(e.j.f.m.m(this, R.color.primary_red));
            u();
        }
        Integer o = o();
        if (o != null && (intValue = o.intValue()) != 0) {
            View view9 = getView();
            ((TextView) (view9 == null ? null : view9.findViewById(e.j.a.A6))).setText(getString(intValue));
        }
        t();
        j2 j2Var = this.f11262g;
        if (j2Var != null) {
            h.c.b0<kotlin.o<Boolean, String>> observeOn = j2Var.d().observeOn(this.a);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.userName()\n            .observeOn(mainScheduler)");
            Object as = Single_AnalyticsKt.logError$default(observeOn, "Could not check whether we should display user name option", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.userName()\n            .observeOn(mainScheduler)\n            .logError(\"Could not check whether we should display user name option\")\n            .`as`(autoDisposable(scopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new j(), 1, null);
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* compiled from: DisplayCoinAddressFragment.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0017\u001a\u00020\u00058\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\f\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/toshi/view/fragment/DisplayCoinAddressFragment$DisplayCoinAddress;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Constants.URL_CAMPAIGN, "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "addressName", "Ljava/lang/String;", "d", "url", "a", "address", "I", "copyText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DisplayCoinAddress {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final String f11265b;

        /* renamed from: c  reason: collision with root package name */
        private final Integer f11266c;

        /* renamed from: d  reason: collision with root package name */
        private final int f11267d;

        public DisplayCoinAddress(String address, String url, Integer num, int i2) {
            kotlin.jvm.internal.m.g(address, "address");
            kotlin.jvm.internal.m.g(url, "url");
            this.a = address;
            this.f11265b = url;
            this.f11266c = num;
            this.f11267d = i2;
        }

        public final String a() {
            return this.a;
        }

        public final Integer b() {
            return this.f11266c;
        }

        public final int c() {
            return this.f11267d;
        }

        public final String d() {
            return this.f11265b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DisplayCoinAddress) {
                DisplayCoinAddress displayCoinAddress = (DisplayCoinAddress) obj;
                return kotlin.jvm.internal.m.c(this.a, displayCoinAddress.a) && kotlin.jvm.internal.m.c(this.f11265b, displayCoinAddress.f11265b) && kotlin.jvm.internal.m.c(this.f11266c, displayCoinAddress.f11266c) && this.f11267d == displayCoinAddress.f11267d;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.a.hashCode() * 31) + this.f11265b.hashCode()) * 31;
            Integer num = this.f11266c;
            return ((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.f11267d;
        }

        public String toString() {
            return "DisplayCoinAddress(address=" + this.a + ", url=" + this.f11265b + ", addressName=" + this.f11266c + ", copyText=" + this.f11267d + ')';
        }

        public /* synthetic */ DisplayCoinAddress(String str, String str2, Integer num, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i3 & 4) != 0 ? null : num, i2);
        }
    }
}