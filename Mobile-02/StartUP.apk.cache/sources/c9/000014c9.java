package com.coinbase.wallet.commonui.utilities;

import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ViewModelFactoryWithMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\b\u0007\u0012 \u0010\n\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R0\u0010\n\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/ViewModelFactoryWithMap;", "Landroidx/lifecycle/d0$d;", "Landroidx/lifecycle/b0;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/b0;", "", "Ljavax/inject/Provider;", "viewModels", "Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ViewModelFactoryWithMap extends d0.d {
    private final Map<Class<? extends b0>, Provider<b0>> viewModels;

    public ViewModelFactoryWithMap(Map<Class<? extends b0>, Provider<b0>> viewModels) {
        m.g(viewModels, "viewModels");
        this.viewModels = viewModels;
    }

    @Override // androidx.lifecycle.d0.d, androidx.lifecycle.d0.b
    public <T extends b0> T create(Class<T> modelClass) {
        m.g(modelClass, "modelClass");
        Provider<b0> provider = this.viewModels.get(modelClass);
        if (provider == null) {
            return null;
        }
        return (T) provider.get();
    }
}