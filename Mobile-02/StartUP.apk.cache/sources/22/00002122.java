package com.coinbase.wallet.features.settings.viewmodels;

import h.c.v0.a;
import h.c.v0.b;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserProfileViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UserProfileViewModel$setIsPublic$1 extends o implements l<Throwable, x> {
    final /* synthetic */ UserProfileViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileViewModel$setIsPublic$1(UserProfileViewModel userProfileViewModel) {
        super(1);
        this.this$0 = userProfileViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Throwable th) {
        invoke2(th);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable it) {
        b bVar;
        a aVar;
        m.g(it, "it");
        bVar = this.this$0.errorSubject;
        bVar.onNext(it.getLocalizedMessage());
        aVar = this.this$0.isLoading;
        aVar.onNext(Boolean.FALSE);
    }
}