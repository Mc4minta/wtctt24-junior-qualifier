package com.coinbase.wallet.commonui.extensions;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.z;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: Fragment+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/b0;", "T", "Landroidx/lifecycle/d0$b;", "<anonymous>", "()Landroidx/lifecycle/d0$b;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Fragment_CommonKt$viewModel$1 extends o implements kotlin.e0.c.a<d0.b> {
    final /* synthetic */ l<z, T> $provider;
    final /* synthetic */ Fragment $this_viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Fragment_CommonKt$viewModel$1(Fragment fragment, l<? super z, ? extends T> lVar) {
        super(0);
        this.$this_viewModel = fragment;
        this.$provider = lVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final d0.b invoke() {
        Bundle arguments = this.$this_viewModel.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        return new androidx.lifecycle.a(this.$provider, this.$this_viewModel, arguments) { // from class: com.coinbase.wallet.commonui.extensions.Fragment_CommonKt$viewModel$1.1
            final /* synthetic */ l<z, T> $provider;
            final /* synthetic */ Fragment $this_viewModel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(r2, arguments);
                this.$this_viewModel = r2;
            }

            @Override // androidx.lifecycle.a
            protected <T extends b0> T create(String key, Class<T> modelClass, z handle) {
                m.g(key, "key");
                m.g(modelClass, "modelClass");
                m.g(handle, "handle");
                return (T) this.$provider.invoke(handle);
            }
        };
    }
}