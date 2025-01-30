package com.coinbase.wallet.commonui.di;

import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import f.a;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GenericViewModelFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0017\b\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0006\u001a\u00028\u0001\"\n\b\u0001\u0010\u0002*\u0004\u0018\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Landroidx/lifecycle/b0;", "T", "Landroidx/lifecycle/d0$d;", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/b0;", "Lf/a;", "viewModel", "Lf/a;", "<init>", "(Lf/a;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GenericViewModelFactory<T extends b0> extends d0.d {
    private final a<T> viewModel;

    public GenericViewModelFactory(a<T> viewModel) {
        m.g(viewModel, "viewModel");
        this.viewModel = viewModel;
    }

    @Override // androidx.lifecycle.d0.d, androidx.lifecycle.d0.b
    public <T extends b0> T create(Class<T> modelClass) {
        m.g(modelClass, "modelClass");
        return this.viewModel.get();
    }
}