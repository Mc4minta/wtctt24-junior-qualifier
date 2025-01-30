package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.jvm.internal.m;

/* compiled from: TypeSystemContext.kt */
/* loaded from: classes3.dex */
public interface TypeSystemOptimizationContext {

    /* compiled from: TypeSystemContext.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static boolean identicalArguments(TypeSystemOptimizationContext typeSystemOptimizationContext, SimpleTypeMarker a, SimpleTypeMarker b2) {
            m.g(typeSystemOptimizationContext, "this");
            m.g(a, "a");
            m.g(b2, "b");
            return false;
        }
    }

    boolean identicalArguments(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2);
}