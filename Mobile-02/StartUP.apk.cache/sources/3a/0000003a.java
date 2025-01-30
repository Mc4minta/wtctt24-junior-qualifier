package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.app.f;
import androidx.lifecycle.a0;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.h;
import androidx.lifecycle.i;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.lifecycle.y;
import androidx.savedstate.SavedStateRegistry;

/* loaded from: classes.dex */
public class ComponentActivity extends f implements o, g0, h, androidx.savedstate.b, c {
    private int mContentLayoutId;
    private d0.b mDefaultFactory;
    private final p mLifecycleRegistry;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final androidx.savedstate.a mSavedStateRegistryController;
    private f0 mViewModelStore;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {
        Object a;

        /* renamed from: b  reason: collision with root package name */
        f0 f397b;

        b() {
        }
    }

    public ComponentActivity() {
        this.mLifecycleRegistry = new p(this);
        this.mSavedStateRegistryController = androidx.savedstate.a.a(this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
        if (getLifecycle() != null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 19) {
                getLifecycle().a(new m() { // from class: androidx.activity.ComponentActivity.2
                    @Override // androidx.lifecycle.m
                    public void c(o oVar, i.a aVar) {
                        if (aVar == i.a.ON_STOP) {
                            Window window = ComponentActivity.this.getWindow();
                            View peekDecorView = window != null ? window.peekDecorView() : null;
                            if (peekDecorView != null) {
                                peekDecorView.cancelPendingInputEvents();
                            }
                        }
                    }
                });
            }
            getLifecycle().a(new m() { // from class: androidx.activity.ComponentActivity.3
                @Override // androidx.lifecycle.m
                public void c(o oVar, i.a aVar) {
                    if (aVar != i.a.ON_DESTROY || ComponentActivity.this.isChangingConfigurations()) {
                        return;
                    }
                    ComponentActivity.this.getViewModelStore().a();
                }
            });
            if (19 > i2 || i2 > 23) {
                return;
            }
            getLifecycle().a(new ImmLeaksCleaner(this));
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    @Override // androidx.lifecycle.h
    public d0.b getDefaultViewModelProviderFactory() {
        if (getApplication() != null) {
            if (this.mDefaultFactory == null) {
                this.mDefaultFactory = new a0(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            return bVar.a;
        }
        return null;
    }

    @Override // androidx.core.app.f, androidx.lifecycle.o
    public i getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.c
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // androidx.lifecycle.g0
    public f0 getViewModelStore() {
        if (getApplication() != null) {
            if (this.mViewModelStore == null) {
                b bVar = (b) getLastNonConfigurationInstance();
                if (bVar != null) {
                    this.mViewModelStore = bVar.f397b;
                }
                if (this.mViewModelStore == null) {
                    this.mViewModelStore = new f0();
                }
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSavedStateRegistryController.c(bundle);
        y.g(this);
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        b bVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        f0 f0Var = this.mViewModelStore;
        if (f0Var == null && (bVar = (b) getLastNonConfigurationInstance()) != null) {
            f0Var = bVar.f397b;
        }
        if (f0Var == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        b bVar2 = new b();
        bVar2.a = onRetainCustomNonConfigurationInstance;
        bVar2.f397b = f0Var;
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        i lifecycle = getLifecycle();
        if (lifecycle instanceof p) {
            ((p) lifecycle).p(i.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.d(bundle);
    }

    public ComponentActivity(int i2) {
        this();
        this.mContentLayoutId = i2;
    }
}