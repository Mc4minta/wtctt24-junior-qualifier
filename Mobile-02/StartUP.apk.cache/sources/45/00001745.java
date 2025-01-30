package com.coinbase.wallet.consumer.viewmodels;

import android.net.Uri;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.AnalyticsEvent_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.viewmodels.ViewModelWithArgs;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.AddCardRedirectResult;
import com.coinbase.wallet.consumer.models.ConsumerAddCardEvent;
import com.coinbase.wallet.consumer.models.ConsumerAddCardState;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVArgs;
import com.coinbase.wallet.consumer.models.ConsumerPaymentMethod;
import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import com.coinbase.wallet.consumer.models.LoadUrlEvent;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ConsumerAddCardViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u0001:\u0001<B\u0019\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b:\u0010;J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\tR$\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00148\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010#0#0\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0017R\u001d\u0010\u000b\u001a\u00020\n8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140\u00188\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u001dR\u001d\u0010-\u001a\u00020\n8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(R\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020#0\u00188\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001dR\u001f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070\u00188\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u001b\u001a\u0004\b1\u0010\u001dR\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R$\u00108\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00070\u00070\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010\u0017R$\u00109\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00190\u00190\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010\u0017¨\u0006="}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAddCardViewModel;", "Lcom/coinbase/wallet/commonui/viewmodels/ViewModelWithArgs;", "Landroid/net/Uri;", "uri", "Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult;", "redirectResultFromURI", "(Landroid/net/Uri;)Lcom/coinbase/wallet/consumer/models/AddCardRedirectResult;", "Lkotlin/x;", "setup", "()V", "", "url", "", "shouldRedirectToApp", "(Ljava/lang/String;)Z", "Lh/c/b0;", "redirectToApp", "(Ljava/lang/String;)Lh/c/b0;", "onWebViewLoaded", "Lh/c/v0/b;", "Lcom/coinbase/wallet/consumer/models/ConsumerAddCardState;", "kotlin.jvm.PlatformType", "stateSubject", "Lh/c/v0/b;", "Lh/c/s;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationObservable", "Lh/c/s;", "getNavigationObservable", "()Lh/c/s;", "value", ApiConstants.STATE, "Lcom/coinbase/wallet/consumer/models/ConsumerAddCardState;", "setState", "(Lcom/coinbase/wallet/consumer/models/ConsumerAddCardState;)V", "Lcom/coinbase/wallet/consumer/models/ConsumerAddCardEvent;", "eventSubject", "url$delegate", "Lkotlin/h;", "getUrl", "()Ljava/lang/String;", "stateObservable", "getStateObservable", "cardType$delegate", "getCardType", "cardType", "eventObservable", "getEventObservable", "dismissObservable", "getDismissObservable", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "consumerWebViewConfig", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "consumerTransferRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "dismissSubject", "navigationSubject", "<init>", "(Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;)V", "Companion", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAddCardViewModel extends ViewModelWithArgs {
    public static final String APP_SCHEME = "com.coinbase.consumer";
    public static final Companion Companion = new Companion(null);
    private final kotlin.h cardType$delegate;
    private final ConsumerTransferRepository consumerTransferRepository;
    private final ConsumerWebViewConfig consumerWebViewConfig;
    private final h.c.s<kotlin.x> dismissObservable;
    private final h.c.v0.b<kotlin.x> dismissSubject;
    private final h.c.s<ConsumerAddCardEvent> eventObservable;
    private final h.c.v0.b<ConsumerAddCardEvent> eventSubject;
    private final h.c.s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private ConsumerAddCardState state;
    private final h.c.s<ConsumerAddCardState> stateObservable;
    private final h.c.v0.b<ConsumerAddCardState> stateSubject;
    private final kotlin.h url$delegate;

    /* compiled from: ConsumerAddCardViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAddCardViewModel$Companion;", "", "", "APP_SCHEME", "Ljava/lang/String;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ConsumerAddCardViewModel(ConsumerWebViewConfig consumerWebViewConfig, ConsumerTransferRepository consumerTransferRepository) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.jvm.internal.m.g(consumerWebViewConfig, "consumerWebViewConfig");
        kotlin.jvm.internal.m.g(consumerTransferRepository, "consumerTransferRepository");
        this.consumerWebViewConfig = consumerWebViewConfig;
        this.consumerTransferRepository = consumerTransferRepository;
        h.c.v0.b<ConsumerAddCardEvent> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<ConsumerAddCardEvent>()");
        this.eventSubject = d2;
        h.c.v0.b<ViewModelNavRoute> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<ViewModelNavRoute>()");
        this.navigationSubject = d3;
        h.c.v0.b<kotlin.x> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create<Unit>()");
        this.dismissSubject = d4;
        h.c.v0.b<ConsumerAddCardState> d5 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d5, "create<ConsumerAddCardState>()");
        this.stateSubject = d5;
        b2 = kotlin.k.b(new ConsumerAddCardViewModel$cardType$2(this));
        this.cardType$delegate = b2;
        this.state = new ConsumerAddCardState(false, false, 3, null);
        b3 = kotlin.k.b(new ConsumerAddCardViewModel$url$2(this));
        this.url$delegate = b3;
        h.c.s<ConsumerAddCardEvent> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "eventSubject.hide()");
        this.eventObservable = hide;
        h.c.s<ViewModelNavRoute> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "navigationSubject.hide()");
        this.navigationObservable = hide2;
        h.c.s<kotlin.x> hide3 = d4.hide();
        kotlin.jvm.internal.m.f(hide3, "dismissSubject.hide()");
        this.dismissObservable = hide3;
        h.c.s<ConsumerAddCardState> hide4 = d5.hide();
        kotlin.jvm.internal.m.f(hide4, "stateSubject.hide()");
        this.stateObservable = hide4;
    }

    public static /* synthetic */ Optional a(AddCardRedirectResult addCardRedirectResult, List list) {
        return m960redirectToApp$lambda3$lambda2(addCardRedirectResult, list);
    }

    public static /* synthetic */ void b(ConsumerAddCardViewModel consumerAddCardViewModel, Throwable th) {
        m962redirectToApp$lambda5(consumerAddCardViewModel, th);
    }

    public static /* synthetic */ kotlin.x c(ConsumerAddCardViewModel consumerAddCardViewModel, ConsumerPaymentMethod consumerPaymentMethod) {
        return m961redirectToApp$lambda4(consumerAddCardViewModel, consumerPaymentMethod);
    }

    public static /* synthetic */ h.c.h0 d(ConsumerAddCardViewModel consumerAddCardViewModel, AddCardRedirectResult addCardRedirectResult, kotlin.x xVar) {
        return m959redirectToApp$lambda3(consumerAddCardViewModel, addCardRedirectResult, xVar);
    }

    public final String getCardType() {
        return (String) this.cardType$delegate.getValue();
    }

    private final String getUrl() {
        return (String) this.url$delegate.getValue();
    }

    private final AddCardRedirectResult redirectResultFromURI(Uri uri) {
        String queryParameter = uri.getQueryParameter("result");
        if (queryParameter == null) {
            queryParameter = "";
        }
        int hashCode = queryParameter.hashCode();
        if (hashCode != -1867169789) {
            if (hashCode != -1367724422) {
                if (hashCode == -1086574198 && queryParameter.equals("failure")) {
                    return AddCardRedirectResult.Failure.INSTANCE;
                }
            } else if (queryParameter.equals("cancel")) {
                return AddCardRedirectResult.Cancel.INSTANCE;
            }
        } else if (queryParameter.equals("success")) {
            String queryParameter2 = uri.getQueryParameter("paymentMethodId");
            if (queryParameter2 == null) {
                queryParameter2 = "";
            }
            if (queryParameter2.length() == 0) {
                return AddCardRedirectResult.ParseError.INSTANCE;
            }
            String queryParameter3 = uri.getQueryParameter("verificationMethod");
            return queryParameter3 != null ? kotlin.jvm.internal.m.c(queryParameter3, "") : true ? new AddCardRedirectResult.Success(queryParameter2) : kotlin.jvm.internal.m.c(queryParameter3, "cdv") ? new AddCardRedirectResult.SuccessWithCdv(queryParameter2) : AddCardRedirectResult.UnsupportedVerification.INSTANCE;
        }
        return AddCardRedirectResult.ParseError.INSTANCE;
    }

    /* renamed from: redirectToApp$lambda-3 */
    public static final h.c.h0 m959redirectToApp$lambda3(ConsumerAddCardViewModel this$0, final AddCardRedirectResult result, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(result, "$result");
        kotlin.jvm.internal.m.g(it, "it");
        h.c.s<R> map = this$0.consumerTransferRepository.getPaymentMethodsObservable().map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAddCardViewModel.a(AddCardRedirectResult.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerTransferRepository.paymentMethodsObservable\n                            .map { paymentMethods ->\n                                paymentMethods.firstOrNull { it.id == result.paymentMethodId }.toOptional()\n                            }");
        h.c.s map2 = map.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.consumer.viewmodels.ConsumerAddCardViewModel$redirectToApp$lambda-3$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it2) {
                kotlin.jvm.internal.m.g(it2, "it");
                return it2.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.ConsumerAddCardViewModel$redirectToApp$lambda-3$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it2) {
                kotlin.jvm.internal.m.g(it2, "it");
                return it2.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map2, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        return Observable_CoreKt.takeSingle(map2);
    }

    /* renamed from: redirectToApp$lambda-3$lambda-2 */
    public static final Optional m960redirectToApp$lambda3$lambda2(AddCardRedirectResult result, List paymentMethods) {
        Object obj;
        kotlin.jvm.internal.m.g(result, "$result");
        kotlin.jvm.internal.m.g(paymentMethods, "paymentMethods");
        Iterator it = paymentMethods.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.jvm.internal.m.c(((ConsumerPaymentMethod) obj).getId(), ((AddCardRedirectResult.SuccessWithCdv) result).getPaymentMethodId())) {
                break;
            }
        }
        return OptionalKt.toOptional(obj);
    }

    /* renamed from: redirectToApp$lambda-4 */
    public static final kotlin.x m961redirectToApp$lambda4(ConsumerAddCardViewModel this$0, ConsumerPaymentMethod paymentMethod) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(paymentMethod, "paymentMethod");
        this$0.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_consumerAddCardFragment_to_consumerCardCDVFragment, ConsumerCardCDVArgs.INSTANCE.createArgs(paymentMethod), null, 4, null));
        return kotlin.x.a;
    }

    /* renamed from: redirectToApp$lambda-5 */
    public static final void m962redirectToApp$lambda5(ConsumerAddCardViewModel this$0, Throwable th) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.setState(new ConsumerAddCardState(true, false));
    }

    private final void setState(ConsumerAddCardState consumerAddCardState) {
        this.stateSubject.onNext(consumerAddCardState);
        this.state = consumerAddCardState;
    }

    public final h.c.s<kotlin.x> getDismissObservable() {
        return this.dismissObservable;
    }

    public final h.c.s<ConsumerAddCardEvent> getEventObservable() {
        return this.eventObservable;
    }

    public final h.c.s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }

    public final h.c.s<ConsumerAddCardState> getStateObservable() {
        return this.stateObservable;
    }

    public final void onWebViewLoaded() {
        setState(new ConsumerAddCardState(true, false));
    }

    public final h.c.b0<kotlin.x> redirectToApp(String url) {
        kotlin.jvm.internal.m.g(url, "url");
        Uri uri = Uri.parse(url);
        setState(new ConsumerAddCardState(false, true));
        kotlin.jvm.internal.m.f(uri, "uri");
        final AddCardRedirectResult redirectResultFromURI = redirectResultFromURI(uri);
        if (redirectResultFromURI instanceof AddCardRedirectResult.Cancel) {
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerAddCardCancel(AnalyticsEvent.Companion));
            h.c.v0.b<kotlin.x> bVar = this.dismissSubject;
            kotlin.x xVar = kotlin.x.a;
            bVar.onNext(xVar);
            h.c.b0<kotlin.x> just = h.c.b0.just(xVar);
            kotlin.jvm.internal.m.f(just, "{\n                Analytics.log(AnalyticsEvent.consumerAddCardCancel())\n                dismissSubject.onNext(Unit)\n                Single.just(Unit)\n            }");
            return just;
        } else if (redirectResultFromURI instanceof AddCardRedirectResult.Success) {
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerAddCardSuccess(AnalyticsEvent.Companion));
            h.c.v0.b<kotlin.x> bVar2 = this.dismissSubject;
            kotlin.x xVar2 = kotlin.x.a;
            bVar2.onNext(xVar2);
            h.c.b0<kotlin.x> just2 = h.c.b0.just(xVar2);
            kotlin.jvm.internal.m.f(just2, "{\n                Analytics.log(AnalyticsEvent.consumerAddCardSuccess())\n                dismissSubject.onNext(Unit)\n                Single.just(Unit)\n            }");
            return just2;
        } else if (redirectResultFromURI instanceof AddCardRedirectResult.SuccessWithCdv) {
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerAddCardSuccessCDVRequired(AnalyticsEvent.Companion));
            l.a.a.a(kotlin.jvm.internal.m.o("Got uri in redirect to app ", uri), new Object[0]);
            h.c.b0 doOnError = this.consumerTransferRepository.refreshPaymentMethods().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.l
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerAddCardViewModel.d(ConsumerAddCardViewModel.this, redirectResultFromURI, (kotlin.x) obj);
                }
            }).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.k
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerAddCardViewModel.c(ConsumerAddCardViewModel.this, (ConsumerPaymentMethod) obj);
                }
            }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.viewmodels.j
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    ConsumerAddCardViewModel.b(ConsumerAddCardViewModel.this, (Throwable) obj);
                }
            });
            kotlin.jvm.internal.m.f(doOnError, "consumerTransferRepository.refreshPaymentMethods()\n                    .flatMap {\n                        consumerTransferRepository.paymentMethodsObservable\n                            .map { paymentMethods ->\n                                paymentMethods.firstOrNull { it.id == result.paymentMethodId }.toOptional()\n                            }\n                            .unwrap()\n                            .takeSingle()\n                    }\n                    .observeOn(AndroidSchedulers.mainThread())\n                    .map { paymentMethod ->\n                        val args = ConsumerCardCDVArgs.createArgs(paymentMethod)\n                        navigationSubject.onNext(\n                            ViewModelNavRoute(R.id.action_consumerAddCardFragment_to_consumerCardCDVFragment, args)\n                        )\n                    }\n                    .doOnError { state = ConsumerAddCardState(showWebView = true, showLoading = false) }");
            return Single_CoreKt.asUnit(doOnError);
        } else {
            if (redirectResultFromURI instanceof AddCardRedirectResult.Failure ? true : redirectResultFromURI instanceof AddCardRedirectResult.UnsupportedVerification ? true : redirectResultFromURI instanceof AddCardRedirectResult.ParseError) {
                setState(new ConsumerAddCardState(true, false));
                Analytics.INSTANCE.log(AnalyticsEvent_AnalyticsKt.generalError$default(AnalyticsEvent.Companion, "invalid redirect url", null, 2, null));
                h.c.b0<kotlin.x> just3 = h.c.b0.just(kotlin.x.a);
                kotlin.jvm.internal.m.f(just3, "{\n                state = ConsumerAddCardState(showWebView = true, showLoading = false)\n                Analytics.log(AnalyticsEvent.generalError(\"invalid redirect url\"))\n                Single.just(Unit)\n            }");
                return just3;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void setup() {
        setState(this.state.copy(false, true));
        this.eventSubject.onNext(new LoadUrlEvent(getUrl()));
    }

    public final boolean shouldRedirectToApp(String str) {
        if (str == null) {
            return false;
        }
        return kotlin.jvm.internal.m.c(Uri.parse(str).getScheme(), APP_SCHEME);
    }
}