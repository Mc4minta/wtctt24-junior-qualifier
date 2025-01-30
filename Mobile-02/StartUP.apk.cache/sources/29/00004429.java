package dagger.android.g;

import android.content.Context;
import dagger.android.DispatchingAndroidInjector;

/* compiled from: DaggerDialogFragment.java */
/* loaded from: classes2.dex */
public abstract class f extends androidx.fragment.app.c implements dagger.android.f {
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