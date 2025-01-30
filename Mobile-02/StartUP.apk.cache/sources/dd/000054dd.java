package kotlin.reflect.jvm.internal.impl.incremental.components;

import kotlin.jvm.internal.m;

/* compiled from: LookupTracker.kt */
/* loaded from: classes3.dex */
public interface LookupTracker {

    /* compiled from: LookupTracker.kt */
    /* loaded from: classes3.dex */
    public static final class DO_NOTHING implements LookupTracker {
        public static final DO_NOTHING INSTANCE = new DO_NOTHING();

        private DO_NOTHING() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public boolean getRequiresPosition() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public void record(String filePath, Position position, String scopeFqName, ScopeKind scopeKind, String name) {
            m.g(filePath, "filePath");
            m.g(position, "position");
            m.g(scopeFqName, "scopeFqName");
            m.g(scopeKind, "scopeKind");
            m.g(name, "name");
        }
    }

    boolean getRequiresPosition();

    void record(String str, Position position, String str2, ScopeKind scopeKind, String str3);
}