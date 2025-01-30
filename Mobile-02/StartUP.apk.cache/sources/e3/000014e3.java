package com.coinbase.wallet.commonui.views;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import dagger.android.g.h;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BaseFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\fJ)\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Ldagger/android/g/h;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/x;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "onPause", "onDestroyView", "onDestroy", "", "transit", "", "enter", "nextAnim", "Landroid/view/animation/Animation;", "onCreateAnimation", "(IZI)Landroid/view/animation/Animation;", "<init>", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class BaseFragment extends h {
    public void _$_clearFindViewByIdCache() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l.a.a.g(m.o(getClass().getSimpleName(), " onCreate"), new Object[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        return Fragment_CommonKt.fixOnCreateAnimation(this, i3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        l.a.a.g(m.o(getClass().getSimpleName(), " onDestroy"), new Object[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        l.a.a.g(m.o(getClass().getSimpleName(), " onDestroyView"), new Object[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        l.a.a.g(m.o(getClass().getSimpleName(), " onPause"), new Object[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        l.a.a.g(m.o(getClass().getSimpleName(), " onResume"), new Object[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        l.a.a.g(m.o(getClass().getSimpleName(), " onViewCreated"), new Object[0]);
    }
}