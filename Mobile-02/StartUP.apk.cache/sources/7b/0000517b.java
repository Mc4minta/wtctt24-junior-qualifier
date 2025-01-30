package kotlin.a0;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SetsJVM.kt */
/* loaded from: classes3.dex */
public class r0 {
    public static <T> Set<T> a(T t) {
        Set<T> singleton = Collections.singleton(t);
        kotlin.jvm.internal.m.f(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }
}