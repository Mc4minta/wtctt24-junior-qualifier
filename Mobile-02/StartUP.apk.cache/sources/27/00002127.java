package com.coinbase.wallet.features.settings.views;

import com.coinbase.wallet.features.settings.models.UserProfileViewState;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: UserProfileFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/settings/models/UserProfileViewState;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/settings/models/UserProfileViewState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class UserProfileFragment$onViewCreated$2 extends o implements l<UserProfileViewState, x> {
    final /* synthetic */ UserProfileFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileFragment$onViewCreated$2(UserProfileFragment userProfileFragment) {
        super(1);
        this.this$0 = userProfileFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(UserProfileViewState userProfileViewState) {
        invoke2(userProfileViewState);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(UserProfileViewState it) {
        this.this$0.updateUser(it.getUsername());
        UserProfileFragment userProfileFragment = this.this$0;
        m.f(it, "it");
        userProfileFragment.updatePrivacySetting(it);
    }
}