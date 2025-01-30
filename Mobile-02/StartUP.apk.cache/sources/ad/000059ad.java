package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: JavaTypeEnhancementState.kt */
/* loaded from: classes3.dex */
public enum ReportLevel {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");
    
    public static final Companion Companion = new Companion(null);
    private final String description;

    /* compiled from: JavaTypeEnhancementState.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    ReportLevel(String str) {
        this.description = str;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static ReportLevel[] valuesCustom() {
        ReportLevel[] valuesCustom = values();
        ReportLevel[] reportLevelArr = new ReportLevel[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, reportLevelArr, 0, valuesCustom.length);
        return reportLevelArr;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean isIgnore() {
        return this == IGNORE;
    }

    public final boolean isWarning() {
        return this == WARN;
    }
}