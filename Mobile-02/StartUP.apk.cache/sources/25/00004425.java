package dagger.android.g;

import android.os.Bundle;
import dagger.android.DispatchingAndroidInjector;

/* compiled from: DaggerAppCompatActivity.java */
/* loaded from: classes2.dex */
public abstract class b extends androidx.appcompat.app.d implements dagger.android.f {
    DispatchingAndroidInjector<Object> androidInjector;

    public b() {
    }

    @Override // dagger.android.f
    public dagger.android.b<Object> androidInjector() {
        return this.androidInjector;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        dagger.android.a.a(this);
        super.onCreate(bundle);
    }

    public b(int i2) {
        super(i2);
    }
}