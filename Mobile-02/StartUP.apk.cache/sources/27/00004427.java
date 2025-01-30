package dagger.android.g;

import android.content.Context;
import dagger.android.DispatchingAndroidInjector;

/* compiled from: DaggerAppCompatDialogFragment.java */
/* loaded from: classes2.dex */
public abstract class d extends androidx.appcompat.app.i implements dagger.android.f {
    DispatchingAndroidInjector<Object> androidInjector;

    @Override // dagger.android.f
    public dagger.android.b<Object> androidInjector() {
        return this.androidInjector;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        a.b(this);
        super.onAttach(context);
    }
}