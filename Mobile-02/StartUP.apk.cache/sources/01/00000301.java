package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.i;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SavedStateHandleController implements m {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1767b = false;

    /* renamed from: c  reason: collision with root package name */
    private final z f1768c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements SavedStateRegistry.a {
        a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.a
        public void a(androidx.savedstate.b bVar) {
            if (bVar instanceof g0) {
                f0 viewModelStore = ((g0) bVar).getViewModelStore();
                SavedStateRegistry savedStateRegistry = bVar.getSavedStateRegistry();
                for (String str : viewModelStore.c()) {
                    SavedStateHandleController.h(viewModelStore.b(str), savedStateRegistry, bVar.getLifecycle());
                }
                if (viewModelStore.c().isEmpty()) {
                    return;
                }
                savedStateRegistry.e(a.class);
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    SavedStateHandleController(String str, z zVar) {
        this.a = str;
        this.f1768c = zVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(b0 b0Var, SavedStateRegistry savedStateRegistry, i iVar) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) b0Var.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.l()) {
            return;
        }
        savedStateHandleController.i(savedStateRegistry, iVar);
        m(savedStateRegistry, iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SavedStateHandleController j(SavedStateRegistry savedStateRegistry, i iVar, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, z.a(savedStateRegistry.a(str), bundle));
        savedStateHandleController.i(savedStateRegistry, iVar);
        m(savedStateRegistry, iVar);
        return savedStateHandleController;
    }

    private static void m(final SavedStateRegistry savedStateRegistry, final i iVar) {
        i.b b2 = iVar.b();
        if (b2 != i.b.INITIALIZED && !b2.h(i.b.STARTED)) {
            iVar.a(new m() { // from class: androidx.lifecycle.SavedStateHandleController.1
                @Override // androidx.lifecycle.m
                public void c(o oVar, i.a aVar) {
                    if (aVar == i.a.ON_START) {
                        i.this.c(this);
                        savedStateRegistry.e(a.class);
                    }
                }
            });
        } else {
            savedStateRegistry.e(a.class);
        }
    }

    @Override // androidx.lifecycle.m
    public void c(o oVar, i.a aVar) {
        if (aVar == i.a.ON_DESTROY) {
            this.f1767b = false;
            oVar.getLifecycle().c(this);
        }
    }

    void i(SavedStateRegistry savedStateRegistry, i iVar) {
        if (!this.f1767b) {
            this.f1767b = true;
            iVar.a(this);
            savedStateRegistry.d(this.a, this.f1768c.f());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z k() {
        return this.f1768c;
    }

    boolean l() {
        return this.f1767b;
    }
}