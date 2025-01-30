package kotlin.reflect.jvm.internal.impl.incremental.components;

/* compiled from: LookupTracker.kt */
/* loaded from: classes3.dex */
public enum ScopeKind {
    PACKAGE,
    CLASSIFIER;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static ScopeKind[] valuesCustom() {
        ScopeKind[] valuesCustom = values();
        ScopeKind[] scopeKindArr = new ScopeKind[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, scopeKindArr, 0, valuesCustom.length);
        return scopeKindArr;
    }
}