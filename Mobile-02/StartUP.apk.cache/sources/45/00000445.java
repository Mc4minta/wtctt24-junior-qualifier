package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.i;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.savedstate.Recreator;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: b  reason: collision with root package name */
    private Bundle f2324b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2325c;

    /* renamed from: d  reason: collision with root package name */
    private Recreator.a f2326d;
    private c.b.a.b.b<String, b> a = new c.b.a.b.b<>();

    /* renamed from: e  reason: collision with root package name */
    boolean f2327e = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(androidx.savedstate.b bVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        Bundle a();
    }

    public Bundle a(String str) {
        if (this.f2325c) {
            Bundle bundle = this.f2324b;
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle(str);
                this.f2324b.remove(str);
                if (this.f2324b.isEmpty()) {
                    this.f2324b = null;
                }
                return bundle2;
            }
            return null;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar, Bundle bundle) {
        if (!this.f2325c) {
            if (bundle != null) {
                this.f2324b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            iVar.a(new m() { // from class: androidx.savedstate.SavedStateRegistry.1
                @Override // androidx.lifecycle.m
                public void c(o oVar, i.a aVar) {
                    if (aVar == i.a.ON_START) {
                        SavedStateRegistry.this.f2327e = true;
                    } else if (aVar == i.a.ON_STOP) {
                        SavedStateRegistry.this.f2327e = false;
                    }
                }
            });
            this.f2325c = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f2324b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        c.b.a.b.b<String, b>.d k2 = this.a.k();
        while (k2.hasNext()) {
            Map.Entry next = k2.next();
            bundle2.putBundle((String) next.getKey(), ((b) next.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void d(String str, b bVar) {
        if (this.a.o(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void e(Class<? extends a> cls) {
        if (this.f2327e) {
            if (this.f2326d == null) {
                this.f2326d = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                this.f2326d.b(cls.getName());
                return;
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
}