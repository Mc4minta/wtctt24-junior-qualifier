package com.coinbase.wallet.features.lend.views;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.c;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.features.lend.models.LendProviderPickerState;
import com.coinbase.wallet.features.lend.views.adapters.LendProviderPickerAdapter;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.e0.c.p;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LendProviderPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendProviderPickerState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/lend/models/LendProviderPickerState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendProviderPickerFragment$setupObservers$1 extends o implements l<LendProviderPickerState, x> {
    final /* synthetic */ LendProviderPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LendProviderPickerFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;Z)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.lend.views.LendProviderPickerFragment$setupObservers$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends o implements p<View, Boolean, x> {
        final /* synthetic */ LendProviderPickerFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LendProviderPickerFragment lendProviderPickerFragment) {
            super(2);
            this.this$0 = lendProviderPickerFragment;
        }

        @Override // kotlin.e0.c.p
        public /* bridge */ /* synthetic */ x invoke(View view, Boolean bool) {
            invoke(view, bool.booleanValue());
            return x.a;
        }

        public final void invoke(View noName_0, boolean z) {
            m.g(noName_0, "$noName_0");
            View view = this.this$0.getView();
            ((Button) (view == null ? null : view.findViewById(e.j.a.continueButton))).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LendProviderPickerFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/appcompat/app/c$a;", "Lcom/toshi/extensions/DialogBuilder;", "Lkotlin/x;", "<anonymous>", "(Landroidx/appcompat/app/c$a;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.lend.views.LendProviderPickerFragment$setupObservers$1$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends o implements l<c.a, x> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(c.a aVar) {
            invoke2(aVar);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(c.a showDialog) {
            m.g(showDialog, "$this$showDialog");
            showDialog.n(R.string.lend_provider_disabled_title);
            showDialog.f(R.string.lend_provider_disabled_message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendProviderPickerFragment$setupObservers$1(LendProviderPickerFragment lendProviderPickerFragment) {
        super(1);
        this.this$0 = lendProviderPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(LendProviderPickerState lendProviderPickerState) {
        invoke2(lendProviderPickerState);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(LendProviderPickerState lendProviderPickerState) {
        LendProviderPickerAdapter lendProviderPickerAdapter;
        lendProviderPickerAdapter = this.this$0.providerPickerAdapter;
        if (lendProviderPickerAdapter != null) {
            lendProviderPickerAdapter.setItems(lendProviderPickerState.getProviders());
            boolean showContinueButton = lendProviderPickerState.getShowContinueButton();
            View view = this.this$0.getView();
            View continueButton = view == null ? null : view.findViewById(e.j.a.continueButton);
            m.f(continueButton, "continueButton");
            if (showContinueButton != (continueButton.getVisibility() == 0)) {
                if (lendProviderPickerState.getShowContinueButton()) {
                    View view2 = this.this$0.getView();
                    View continueButton2 = view2 != null ? view2.findViewById(e.j.a.continueButton) : null;
                    m.f(continueButton2, "continueButton");
                    View_CommonKt.fadeIn$default(continueButton2, 250L, null, 2, null);
                } else {
                    View view3 = this.this$0.getView();
                    View continueButton3 = view3 != null ? view3.findViewById(e.j.a.continueButton) : null;
                    m.f(continueButton3, "continueButton");
                    View_CommonKt.fadeOut(continueButton3, 250L, new AnonymousClass1(this.this$0));
                }
            }
            if (lendProviderPickerState.getShowProviderDisabledAlert()) {
                e.j.f.m.p(this.this$0, AnonymousClass2.INSTANCE);
                return;
            }
            return;
        }
        m.w("providerPickerAdapter");
        throw null;
    }
}