package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: IncompatibleVersionErrorData.kt */
/* loaded from: classes3.dex */
public final class IncompatibleVersionErrorData<T> {
    private final T actualVersion;
    private final ClassId classId;
    private final T expectedVersion;
    private final String filePath;

    public IncompatibleVersionErrorData(T t, T t2, String filePath, ClassId classId) {
        m.g(filePath, "filePath");
        m.g(classId, "classId");
        this.actualVersion = t;
        this.expectedVersion = t2;
        this.filePath = filePath;
        this.classId = classId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IncompatibleVersionErrorData) {
            IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
            return m.c(this.actualVersion, incompatibleVersionErrorData.actualVersion) && m.c(this.expectedVersion, incompatibleVersionErrorData.expectedVersion) && m.c(this.filePath, incompatibleVersionErrorData.filePath) && m.c(this.classId, incompatibleVersionErrorData.classId);
        }
        return false;
    }

    public int hashCode() {
        T t = this.actualVersion;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.expectedVersion;
        return ((((hashCode + (t2 != null ? t2.hashCode() : 0)) * 31) + this.filePath.hashCode()) * 31) + this.classId.hashCode();
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ", classId=" + this.classId + ')';
    }
}