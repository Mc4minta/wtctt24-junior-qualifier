package com.coinbase.wallet.features.settings.viewmodels;

import androidx.lifecycle.b0;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.settings.models.UserProfileViewState;
import com.coinbase.wallet.user.models.User;
import com.coinbase.wallet.user.repositories.UserRepository;
import h.c.k0.a;
import h.c.m0.n;
import h.c.m0.p;
import h.c.s;
import h.c.t0.c;
import h.c.t0.g;
import h.c.v0.b;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: UserProfileViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b \u0010!J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR$\u0010\f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00020\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00110\u00110\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/features/settings/viewmodels/UserProfileViewModel;", "Landroidx/lifecycle/b0;", "", "isPublic", "Lkotlin/x;", "setIsPublic", "(Z)V", "onCleared", "()V", "Lh/c/v0/b;", "", "kotlin.jvm.PlatformType", "errorSubject", "Lh/c/v0/b;", "Lh/c/v0/a;", "isLoading", "Lh/c/v0/a;", "Lcom/coinbase/wallet/features/settings/models/UserProfileViewState;", "viewSubject", "Lcom/coinbase/wallet/user/repositories/UserRepository;", "userRepository", "Lcom/coinbase/wallet/user/repositories/UserRepository;", "Lh/c/s;", "errorStateObservable", "Lh/c/s;", "getErrorStateObservable", "()Lh/c/s;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "viewStateObservable", "getViewStateObservable", "<init>", "(Lcom/coinbase/wallet/user/repositories/UserRepository;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UserProfileViewModel extends b0 {
    private final a disposeBag;
    private final s<String> errorStateObservable;
    private final b<String> errorSubject;
    private final h.c.v0.a<Boolean> isLoading;
    private final UserRepository userRepository;
    private final s<UserProfileViewState> viewStateObservable;
    private final h.c.v0.a<UserProfileViewState> viewSubject;

    /* compiled from: UserProfileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u000526\u0010\u0004\u001a2\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0018\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/o;", "Lcom/coinbase/wallet/user/models/User;", "", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.settings.viewmodels.UserProfileViewModel$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static final class AnonymousClass1 extends o implements l<kotlin.o<? extends User, ? extends Boolean>, x> {
        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(kotlin.o<? extends User, ? extends Boolean> oVar) {
            invoke2((kotlin.o<User, Boolean>) oVar);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(kotlin.o<User, Boolean> oVar) {
            User a = oVar.a();
            Boolean isLoading = oVar.b();
            h.c.v0.a aVar = UserProfileViewModel.this.viewSubject;
            m.f(isLoading, "isLoading");
            aVar.onNext(new UserProfileViewState(a.getUsername(), !m.c(a.isPublic(), Boolean.FALSE), isLoading.booleanValue()));
        }
    }

    public UserProfileViewModel(UserRepository userRepository) {
        m.g(userRepository, "userRepository");
        this.userRepository = userRepository;
        a aVar = new a();
        this.disposeBag = aVar;
        h.c.v0.a<UserProfileViewState> d2 = h.c.v0.a.d();
        m.f(d2, "create<UserProfileViewState>()");
        this.viewSubject = d2;
        b<String> d3 = b.d();
        m.f(d3, "create<String>()");
        this.errorSubject = d3;
        h.c.v0.a<Boolean> e2 = h.c.v0.a.e(Boolean.FALSE);
        m.f(e2, "createDefault(false)");
        this.isLoading = e2;
        s<UserProfileViewState> hide = d2.hide();
        m.f(hide, "viewSubject.hide()");
        this.viewStateObservable = hide;
        s<String> hide2 = d3.hide();
        m.f(hide2, "errorSubject.hide()");
        this.errorStateObservable = hide2;
        c cVar = c.a;
        h.c.x map = userRepository.getActiveUserObservable().filter(new p() { // from class: com.coinbase.wallet.features.settings.viewmodels.UserProfileViewModel$special$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new n() { // from class: com.coinbase.wallet.features.settings.viewmodels.UserProfileViewModel$special$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        s a = cVar.a(map, e2);
        m.f(a, "Observables.combineLatest(userRepository.activeUserObservable.unwrap(), isLoading)");
        h.c.t0.a.a(g.h(a, null, null, new AnonymousClass1(), 3, null), aVar);
    }

    public final s<String> getErrorStateObservable() {
        return this.errorStateObservable;
    }

    public final s<UserProfileViewState> getViewStateObservable() {
        return this.viewStateObservable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.disposeBag.d();
    }

    public final void setIsPublic(boolean z) {
        this.isLoading.onNext(Boolean.TRUE);
        h.c.t0.a.a(g.f(this.userRepository.setUserIsPublic(z), new UserProfileViewModel$setIsPublic$1(this), new UserProfileViewModel$setIsPublic$2(this)), this.disposeBag);
    }
}