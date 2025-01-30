package com.coinbase.wallet.commonui.views;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: DaggerBottomSheetDialogFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/commonui/views/DaggerBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/b;", "Landroid/content/Context;", "context", "Lkotlin/x;", "onAttach", "(Landroid/content/Context;)V", "<init>", "()V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class DaggerBottomSheetDialogFragment extends com.google.android.material.bottomsheet.b {
    public void _$_clearFindViewByIdCache() {
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        m.g(context, "context");
        dagger.android.g.a.b(this);
        super.onAttach(context);
    }
}