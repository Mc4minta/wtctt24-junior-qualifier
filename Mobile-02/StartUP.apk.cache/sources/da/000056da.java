package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.jvm.internal.m;

/* compiled from: versionSpecificBehavior.kt */
/* loaded from: classes3.dex */
public final class VersionSpecificBehaviorKt {
    public static final boolean isKotlin1Dot4OrLater(BinaryVersion version) {
        m.g(version, "version");
        return version.getMajor() == 1 && version.getMinor() >= 4;
    }

    public static final boolean isVersionRequirementTableWrittenCorrectly(BinaryVersion version) {
        m.g(version, "version");
        return isKotlin1Dot4OrLater(version);
    }
}