package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.d0;
import androidx.savedstate.SavedStateRegistry;

/* compiled from: AbstractSavedStateViewModelFactory.java */
/* loaded from: classes.dex */
public abstract class a extends d0.c {
    static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    private final Bundle mDefaultArgs;
    private final i mLifecycle;
    private final SavedStateRegistry mSavedStateRegistry;

    public a(androidx.savedstate.b bVar, Bundle bundle) {
        this.mSavedStateRegistry = bVar.getSavedStateRegistry();
        this.mLifecycle = bVar.getLifecycle();
        this.mDefaultArgs = bundle;
    }

    @Override // androidx.lifecycle.d0.c
    public final <T extends b0> T create(String str, Class<T> cls) {
        SavedStateHandleController j2 = SavedStateHandleController.j(this.mSavedStateRegistry, this.mLifecycle, str, this.mDefaultArgs);
        T t = (T) create(str, cls, j2.k());
        t.setTagIfAbsent(TAG_SAVED_STATE_HANDLE_CONTROLLER, j2);
        return t;
    }

    protected abstract <T extends b0> T create(String str, Class<T> cls, z zVar);

    @Override // androidx.lifecycle.d0.e
    void onRequery(b0 b0Var) {
        SavedStateHandleController.h(b0Var, this.mSavedStateRegistry, this.mLifecycle);
    }

    @Override // androidx.lifecycle.d0.c, androidx.lifecycle.d0.b
    public final <T extends b0> T create(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}