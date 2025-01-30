package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: typeEnhancement.kt */
/* loaded from: classes3.dex */
public final class EnhancementResult<T> {
    private final Annotations enhancementAnnotations;
    private final T result;

    public EnhancementResult(T t, Annotations annotations) {
        this.result = t;
        this.enhancementAnnotations = annotations;
    }

    public final T component1() {
        return this.result;
    }

    public final Annotations component2() {
        return this.enhancementAnnotations;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EnhancementResult) {
            EnhancementResult enhancementResult = (EnhancementResult) obj;
            return m.c(this.result, enhancementResult.result) && m.c(this.enhancementAnnotations, enhancementResult.enhancementAnnotations);
        }
        return false;
    }

    public int hashCode() {
        T t = this.result;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        Annotations annotations = this.enhancementAnnotations;
        return hashCode + (annotations != null ? annotations.hashCode() : 0);
    }

    public String toString() {
        return "EnhancementResult(result=" + this.result + ", enhancementAnnotations=" + this.enhancementAnnotations + ')';
    }
}