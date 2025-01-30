package com.toshi.view.fragment.legal;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.b0;
import androidx.lifecycle.e0;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.RecyclerView;
import c.h.k.d0;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.toshi.model.local.Library;
import e.j.f.r;
import e.j.m.a.f;
import e.j.n.n2;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: LicenseListFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0006J-\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/toshi/view/fragment/legal/LicenseListFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "init", "()V", "initViewModel", "initViews", "initViewListeners", "initObservers", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "onBackPressed", "()Z", "Le/j/n/n2;", "a", "Le/j/n/n2;", "viewModel", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class LicenseListFragment extends BaseFragment implements StyledFragment, BackableFragment {
    private n2 a;

    /* compiled from: LicenseListFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends o implements l<View, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a() {
            super(1);
            LicenseListFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            m.g(it, "it");
            Fragment_CommonKt.navigateUp(LicenseListFragment.this);
        }
    }

    /* compiled from: LicenseListFragment.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b extends k implements l<Library, x> {
        b(n2 n2Var) {
            super(1, n2Var, n2.class, "handleLibraryClicked", "handleLibraryClicked(Lcom/toshi/model/local/Library;)V", 0);
        }

        public final void a(Library p0) {
            m.g(p0, "p0");
            ((n2) this.receiver).c(p0);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Library library) {
            a(library);
            return x.a;
        }
    }

    public static final void d(LicenseListFragment this$0, Library library) {
        m.g(this$0, "this$0");
        if (library == null) {
            return;
        }
        Fragment_CommonKt.navigate$default(this$0, R.id.action_licenseListFragment_to_licenseFragment, LicenseFragment.a.a(library), null, null, 12, null);
    }

    public static /* synthetic */ void e(LicenseListFragment licenseListFragment, Library library) {
        d(licenseListFragment, library);
    }

    private final void init() {
        initViewModel();
        initViews();
        initViewListeners();
        initObservers();
    }

    private final void initObservers() {
        n2 n2Var = this.a;
        if (n2Var == null) {
            m.w("viewModel");
            throw null;
        }
        e.j.l.k<Library> b2 = n2Var.b();
        androidx.lifecycle.o viewLifecycleOwner = getViewLifecycleOwner();
        m.f(viewLifecycleOwner, "viewLifecycleOwner");
        b2.g(viewLifecycleOwner, new v() { // from class: com.toshi.view.fragment.legal.a
            @Override // androidx.lifecycle.v
            public final void a(Object obj) {
                LicenseListFragment.e(LicenseListFragment.this, (Library) obj);
            }
        });
    }

    private final void initViewListeners() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(e.j.a.t0);
        m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new a(), 1, null);
    }

    private final void initViewModel() {
        b0 a2 = e0.a(this).a(n2.class);
        m.f(a2, "of(this).get(T::class.java)");
        this.a = (n2) a2;
    }

    private final void initViews() {
        View view = getView();
        RecyclerView recyclerView = (RecyclerView) (view == null ? null : view.findViewById(e.j.a.libraryList));
        m.f(recyclerView, "");
        r.b(recyclerView, 0, 0, 0, 0, 0, 0, 63, null);
        n2 n2Var = this.a;
        if (n2Var == null) {
            m.w("viewModel");
            throw null;
        }
        Resources resources = recyclerView.getResources();
        m.f(resources, "resources");
        List<Library> a2 = n2Var.a(resources);
        n2 n2Var2 = this.a;
        if (n2Var2 != null) {
            recyclerView.setAdapter(new f(a2, new b(n2Var2)));
        } else {
            m.w("viewModel");
            throw null;
        }
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), false, true, false, 5, null);
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_lib_licenses, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        init();
    }
}