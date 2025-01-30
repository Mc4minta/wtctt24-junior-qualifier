package dagger.android;

import android.app.Application;
import com.google.errorprone.annotations.ForOverride;

/* compiled from: DaggerApplication.java */
/* loaded from: classes2.dex */
public abstract class c extends Application implements f {
    volatile DispatchingAndroidInjector<Object> androidInjector;

    private void injectIfNecessary() {
        if (this.androidInjector == null) {
            synchronized (this) {
                if (this.androidInjector == null) {
                    applicationInjector().inject(this);
                    if (this.androidInjector == null) {
                        throw new IllegalStateException("The AndroidInjector returned from applicationInjector() did not inject the DaggerApplication");
                    }
                }
            }
        }
    }

    @Override // dagger.android.f
    public b<Object> androidInjector() {
        injectIfNecessary();
        return this.androidInjector;
    }

    @ForOverride
    protected abstract b<? extends c> applicationInjector();

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        injectIfNecessary();
    }
}