package com.coinbase.wallet.features.send.views;

import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.send.viewmodels.SendDestinationPickerViewModel;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendDestinationPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationPickerFragment$setupViews$10 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
    final /* synthetic */ SendDestinationPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SendDestinationPickerFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/coinbase/wallet/core/util/Optional;", "", "kotlin.jvm.PlatformType", "addressOptional", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/core/util/Optional;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.send.views.SendDestinationPickerFragment$setupViews$10$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Optional<? extends String>, kotlin.x> {
        final /* synthetic */ SendDestinationPickerFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SendDestinationPickerFragment sendDestinationPickerFragment) {
            super(1);
            this.this$0 = sendDestinationPickerFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Optional<? extends String> optional) {
            invoke2((Optional<String>) optional);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Optional<String> optional) {
            SendDestinationPickerViewModel sendDestinationPickerViewModel;
            SendDestinationPickerViewModel sendDestinationPickerViewModel2;
            FragmentLifecycleScopeProvider scopeProvider;
            String nullable = optional.toNullable();
            if (nullable == null) {
                return;
            }
            sendDestinationPickerViewModel = this.this$0.viewModel;
            if (sendDestinationPickerViewModel == null) {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            } else if (!sendDestinationPickerViewModel.isMetadataAvailable()) {
                sendDestinationPickerViewModel2 = this.this$0.viewModel;
                if (sendDestinationPickerViewModel2 != null) {
                    h.c.b0<kotlin.x> confirmSendToAddress = sendDestinationPickerViewModel2.confirmSendToAddress(nullable, null);
                    scopeProvider = this.this$0.getScopeProvider();
                    ((com.uber.autodispose.a0) confirmSendToAddress.as(com.uber.autodispose.d.a(scopeProvider))).subscribe();
                    return;
                }
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            } else {
                SendDestinationPickerFragment sendDestinationPickerFragment = this.this$0;
                View view = sendDestinationPickerFragment.getView();
                View searchField = view == null ? null : view.findViewById(e.j.a.searchField);
                kotlin.jvm.internal.m.f(searchField, "searchField");
                sendDestinationPickerFragment.setTextNoTrack((AppCompatEditText) searchField, nullable);
                View view2 = this.this$0.getView();
                ((AppCompatEditText) (view2 != null ? view2.findViewById(e.j.a.metadataField) : null)).requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendDestinationPickerFragment$setupViews$10(SendDestinationPickerFragment sendDestinationPickerFragment) {
        super(1);
        this.this$0 = sendDestinationPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
        invoke2(view);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        SendDestinationPickerViewModel sendDestinationPickerViewModel;
        FragmentLifecycleScopeProvider scopeProvider;
        kotlin.jvm.internal.m.g(it, "it");
        sendDestinationPickerViewModel = this.this$0.viewModel;
        if (sendDestinationPickerViewModel != null) {
            h.c.b0<Optional<String>> observeOn = sendDestinationPickerViewModel.pasteButtonTapped().observeOn(h.c.j0.c.a.b());
            scopeProvider = this.this$0.getScopeProvider();
            Object as = observeOn.as(com.uber.autodispose.d.a(scopeProvider));
            kotlin.jvm.internal.m.f(as, "viewModel.pasteButtonTapped()\n                .observeOn(AndroidSchedulers.mainThread())\n                .`as`(autoDisposable(scopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, new AnonymousClass1(this.this$0), 1, null);
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }
}