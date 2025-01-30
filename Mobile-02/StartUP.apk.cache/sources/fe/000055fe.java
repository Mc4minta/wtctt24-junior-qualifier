package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.jvm.internal.m;

/* compiled from: predefinedEnhancementInfo.kt */
/* loaded from: classes3.dex */
public final class TypeEnhancementInfo {
    private final Map<Integer, JavaTypeQualifiers> map;

    public TypeEnhancementInfo(Map<Integer, JavaTypeQualifiers> map) {
        m.g(map, "map");
        this.map = map;
    }

    public final Map<Integer, JavaTypeQualifiers> getMap() {
        return this.map;
    }
}