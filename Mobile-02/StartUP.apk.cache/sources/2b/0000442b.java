package dagger.android.g;

import android.content.Context;
import androidx.fragment.app.Fragment;
import dagger.android.DispatchingAndroidInjector;

/* compiled from: DaggerFragment.java */
/* loaded from: classes2.dex */
public abstract class h extends Fragment implements dagger.android.f {
    DispatchingAndroidInjector<Object> androidInjector;

    public h() {
    }

    @Override // dagger.android.f
    public dagger.android.b<Object> androidInjector() {
        return this.androidInjector;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        a.b(this);
        super.onAttach(context);
    }

    public h(int i2) {
        super(i2);
    }
}