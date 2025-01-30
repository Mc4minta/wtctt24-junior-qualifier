package dagger.android;

import dagger.android.b;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: DispatchingAndroidInjector_Factory.java */
/* loaded from: classes2.dex */
public final class e<T> implements f.c.d<DispatchingAndroidInjector<T>> {
    public static <T> DispatchingAndroidInjector<T> a(Map<Class<?>, Provider<b.a<?>>> map, Map<String, Provider<b.a<?>>> map2) {
        return new DispatchingAndroidInjector<>(map, map2);
    }
}