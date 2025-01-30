package androidx.lifecycle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.d0;

/* compiled from: ViewModelProviders.java */
@Deprecated
/* loaded from: classes.dex */
public class e0 {
    @Deprecated
    public static d0 a(Fragment fragment) {
        return new d0(fragment);
    }

    @Deprecated
    public static d0 b(androidx.fragment.app.d dVar, d0.b bVar) {
        if (bVar == null) {
            bVar = dVar.getDefaultViewModelProviderFactory();
        }
        return new d0(dVar.getViewModelStore(), bVar);
    }
}