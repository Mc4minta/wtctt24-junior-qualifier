package com.coinbase.wallet.features.cloudbackup.view;

import com.coinbase.wallet.core.util.Optional;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RestoreWalletFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/coinbase/wallet/core/util/Optional;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "kotlin.jvm.PlatformType", "account", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/core/util/Optional;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RestoreWalletFragment$handleSignIn$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Optional<? extends GoogleSignInAccount>, kotlin.x> {
    final /* synthetic */ RestoreWalletFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestoreWalletFragment$handleSignIn$2(RestoreWalletFragment restoreWalletFragment) {
        super(1);
        this.this$0 = restoreWalletFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Optional<? extends GoogleSignInAccount> optional) {
        invoke2(optional);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Optional<? extends GoogleSignInAccount> optional) {
        GoogleSignInAccount nullable = optional.toNullable();
        if (nullable == null) {
            return;
        }
        this.this$0.initDriveClient(nullable);
    }
}