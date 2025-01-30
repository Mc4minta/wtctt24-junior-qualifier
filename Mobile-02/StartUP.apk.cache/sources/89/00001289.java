package com.coinbase.wallet.application.viewmodel;

import androidx.lifecycle.b0;
import com.coinbase.wallet.application.service.ApplicationService;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: SignOutViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/application/viewmodel/SignOutViewModel;", "Landroidx/lifecycle/b0;", "Lh/c/b0;", "Lkotlin/x;", "signOut", "()Lh/c/b0;", "Lcom/coinbase/wallet/application/service/ApplicationService;", "applicationService", "Lcom/coinbase/wallet/application/service/ApplicationService;", "<init>", "(Lcom/coinbase/wallet/application/service/ApplicationService;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SignOutViewModel extends b0 {
    private final ApplicationService applicationService;

    public SignOutViewModel(ApplicationService applicationService) {
        m.g(applicationService, "applicationService");
        this.applicationService = applicationService;
    }

    public final h.c.b0<x> signOut() {
        return this.applicationService.destroy();
    }
}