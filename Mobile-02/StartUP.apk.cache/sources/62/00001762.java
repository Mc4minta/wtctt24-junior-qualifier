package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.ConsumerAddCardArgs;
import com.coinbase.wallet.consumer.models.ConsumerAvailablePaymentMethod;
import com.coinbase.wallet.consumer.models.ConsumerAvailablePaymentMethodsState;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ConsumerAvailablePaymentMethodsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u000b0\u000b0\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00190\u00190\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0018¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAvailablePaymentMethodsViewModel;", "Landroidx/lifecycle/b0;", "Lh/c/b0;", "Lkotlin/x;", "setup", "()Lh/c/b0;", "Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethod;", "paymentMethod", "onPaymentMethodClick", "(Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethod;)V", "Lh/c/s;", "Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethodsState;", "stateObservable", "Lh/c/s;", "getStateObservable", "()Lh/c/s;", "value", ApiConstants.STATE, "Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethodsState;", "setState", "(Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethodsState;)V", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "stateSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationObservable", "getNavigationObservable", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "consumerTransferRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "navigationSubject", "<init>", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAvailablePaymentMethodsViewModel extends androidx.lifecycle.b0 {
    private final ConsumerTransferRepository consumerTransferRepository;
    private final h.c.s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private ConsumerAvailablePaymentMethodsState state;
    private final h.c.s<ConsumerAvailablePaymentMethodsState> stateObservable;
    private final h.c.v0.b<ConsumerAvailablePaymentMethodsState> stateSubject;

    public ConsumerAvailablePaymentMethodsViewModel(ConsumerTransferRepository consumerTransferRepository) {
        kotlin.jvm.internal.m.g(consumerTransferRepository, "consumerTransferRepository");
        this.consumerTransferRepository = consumerTransferRepository;
        h.c.v0.b<ViewModelNavRoute> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<ViewModelNavRoute>()");
        this.navigationSubject = d2;
        h.c.v0.b<ConsumerAvailablePaymentMethodsState> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<ConsumerAvailablePaymentMethodsState>()");
        this.stateSubject = d3;
        this.state = new ConsumerAvailablePaymentMethodsState(null, 1, null);
        h.c.s<ViewModelNavRoute> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "navigationSubject.hide()");
        this.navigationObservable = hide;
        h.c.s<ConsumerAvailablePaymentMethodsState> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "stateSubject.hide()");
        this.stateObservable = hide2;
    }

    public static /* synthetic */ boolean a(List list) {
        return m983setup$lambda0(list);
    }

    public static /* synthetic */ kotlin.x b(ConsumerAvailablePaymentMethodsViewModel consumerAvailablePaymentMethodsViewModel, List list) {
        return m984setup$lambda3(consumerAvailablePaymentMethodsViewModel, list);
    }

    private final void setState(ConsumerAvailablePaymentMethodsState consumerAvailablePaymentMethodsState) {
        this.state = consumerAvailablePaymentMethodsState;
        this.stateSubject.onNext(consumerAvailablePaymentMethodsState);
    }

    /* renamed from: setup$lambda-0 */
    public static final boolean m983setup$lambda0(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        return !it.isEmpty();
    }

    /* renamed from: setup$lambda-3 */
    public static final kotlin.x m984setup$lambda3(ConsumerAvailablePaymentMethodsViewModel this$0, List availablePaymentMethods) {
        List<ConsumerAvailablePaymentMethod> B0;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(availablePaymentMethods, "availablePaymentMethods");
        ArrayList arrayList = new ArrayList();
        for (Object obj : availablePaymentMethods) {
            if (((ConsumerAvailablePaymentMethod) obj).getSupportsBuy()) {
                arrayList.add(obj);
            }
        }
        B0 = kotlin.a0.z.B0(arrayList, new Comparator<T>() { // from class: com.coinbase.wallet.consumer.viewmodels.ConsumerAvailablePaymentMethodsViewModel$setup$lambda-3$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int c2;
                c2 = kotlin.b0.b.c(Integer.valueOf(!((ConsumerAvailablePaymentMethod) t).isEnabled()), Integer.valueOf(!((ConsumerAvailablePaymentMethod) t2).isEnabled()));
                return c2;
            }
        });
        this$0.setState(this$0.state.copy(B0));
        return kotlin.x.a;
    }

    public final h.c.s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final h.c.s<ConsumerAvailablePaymentMethodsState> getStateObservable() {
        return this.stateObservable;
    }

    public final void onPaymentMethodClick(ConsumerAvailablePaymentMethod paymentMethod) {
        kotlin.jvm.internal.m.g(paymentMethod, "paymentMethod");
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerPaymentMethodTapped(AnalyticsEvent.Companion, paymentMethod.getType().toString()));
        this.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_consumerAvailablePaymentMethodsFragment_to_consumerAddCardFragment, ConsumerAddCardArgs.INSTANCE.createArgs(paymentMethod.getType().name()), null, 4, null));
    }

    public final h.c.b0<kotlin.x> setup() {
        h.c.s<List<ConsumerAvailablePaymentMethod>> filter = this.consumerTransferRepository.getAvailablePaymentMethodsObservable().filter(new h.c.m0.p() { // from class: com.coinbase.wallet.consumer.viewmodels.g0
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return ConsumerAvailablePaymentMethodsViewModel.a((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "consumerTransferRepository.availablePaymentMethodsObservable\n            .filter { it.isNotEmpty() }");
        h.c.b0 map = Observable_CoreKt.takeSingle(filter).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.h0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAvailablePaymentMethodsViewModel.b(ConsumerAvailablePaymentMethodsViewModel.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerTransferRepository.availablePaymentMethodsObservable\n            .filter { it.isNotEmpty() }\n            .takeSingle()\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { availablePaymentMethods ->\n                val availablePaymentMethodsMap = availablePaymentMethods\n                    .filter { availablePaymentMethod -> availablePaymentMethod.supportsBuy }\n                    .sortedBy { if (it.isEnabled) 0 else 1 }\n\n                state = state.copy(availablePaymentMethods = availablePaymentMethodsMap)\n            }");
        return Single_CoreKt.asUnit(map);
    }
}