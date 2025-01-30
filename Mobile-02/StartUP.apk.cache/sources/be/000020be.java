package com.coinbase.wallet.features.send.views;

import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.features.send.models.SendDestinationPickerRow;
import com.coinbase.wallet.features.send.viewmodels.SendDestinationPickerViewModel;
import kotlin.Metadata;

/* compiled from: SendDestinationPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendDestinationPickerRow$Destination;", "sendDestination", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/send/models/SendDestinationPickerRow$Destination;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationPickerFragment$setupViews$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SendDestinationPickerRow.Destination, kotlin.x> {
    final /* synthetic */ SendDestinationPickerFragment this$0;

    /* compiled from: SendDestinationPickerFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.send.views.SendDestinationPickerFragment$setupViews$1$2 */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
        final /* synthetic */ SendDestinationPickerRow.Destination $sendDestination;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SendDestinationPickerRow.Destination destination) {
            super(1);
            this.$sendDestination = destination;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
            invoke2(th);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            this.$sendDestination.getDestination().setLoading(false);
        }
    }

    /* compiled from: SendDestinationPickerFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.send.views.SendDestinationPickerFragment$setupViews$1$3 */
    /* loaded from: classes.dex */
    public static final class AnonymousClass3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.x, kotlin.x> {
        final /* synthetic */ SendDestinationPickerRow.Destination $sendDestination;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(SendDestinationPickerRow.Destination destination) {
            super(1);
            this.$sendDestination = destination;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.x xVar) {
            invoke2(xVar);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(kotlin.x xVar) {
            this.$sendDestination.getDestination().setLoading(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendDestinationPickerFragment$setupViews$1(SendDestinationPickerFragment sendDestinationPickerFragment) {
        super(1);
        this.this$0 = sendDestinationPickerFragment;
    }

    public static /* synthetic */ void a(SendDestinationPickerRow.Destination destination) {
        m1422invoke$lambda0(destination);
    }

    /* renamed from: invoke$lambda-0 */
    public static final void m1422invoke$lambda0(SendDestinationPickerRow.Destination sendDestination) {
        kotlin.jvm.internal.m.g(sendDestination, "$sendDestination");
        sendDestination.getDestination().setLoading(false);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(SendDestinationPickerRow.Destination destination) {
        invoke2(destination);
        return kotlin.x.a;
    }

    /* renamed from: invoke */
    public final void invoke2(final SendDestinationPickerRow.Destination sendDestination) {
        SendDestinationPickerViewModel sendDestinationPickerViewModel;
        SendDestinationPickerViewModel sendDestinationPickerViewModel2;
        FragmentLifecycleScopeProvider scopeProvider;
        kotlin.jvm.internal.m.g(sendDestination, "sendDestination");
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.sendDestinationAddressSelected(AnalyticsEvent.Companion));
        sendDestinationPickerViewModel = this.this$0.viewModel;
        if (sendDestinationPickerViewModel == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        } else if (sendDestinationPickerViewModel.isValidSendDestination(sendDestination.getDestination())) {
            sendDestination.getDestination().setLoading(true);
            sendDestinationPickerViewModel2 = this.this$0.viewModel;
            if (sendDestinationPickerViewModel2 != null) {
                h.c.b0<kotlin.x> doOnDispose = sendDestinationPickerViewModel2.confirmSend(sendDestination.getDestination()).observeOn(h.c.j0.c.a.b()).doOnDispose(new h.c.m0.a() { // from class: com.coinbase.wallet.features.send.views.m0
                    @Override // h.c.m0.a
                    public final void run() {
                        SendDestinationPickerFragment$setupViews$1.a(SendDestinationPickerRow.Destination.this);
                    }
                });
                scopeProvider = this.this$0.getScopeProvider();
                Object as = doOnDispose.as(com.uber.autodispose.d.a(scopeProvider));
                kotlin.jvm.internal.m.f(as, "viewModel.confirmSend(sendDestinationViewInfo = sendDestination.destination)\n                    .observeOn(AndroidSchedulers.mainThread())\n                    .doOnDispose { sendDestination.destination.isLoading = false }\n                    .`as`(autoDisposable(scopeProvider))");
                SingleSubscribeProxy_CommonKt.subscribeBy((com.uber.autodispose.a0) as, new AnonymousClass2(sendDestination), new AnonymousClass3(sendDestination));
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        } else {
            SendDestinationPickerFragment sendDestinationPickerFragment = this.this$0;
            View view = sendDestinationPickerFragment.getView();
            View searchField = view == null ? null : view.findViewById(e.j.a.searchField);
            kotlin.jvm.internal.m.f(searchField, "searchField");
            sendDestinationPickerFragment.setTextNoTrack((AppCompatEditText) searchField, sendDestination.getDestination().getTitle());
            View view2 = this.this$0.getView();
            ((AppCompatEditText) (view2 != null ? view2.findViewById(e.j.a.metadataField) : null)).requestFocus();
        }
    }
}