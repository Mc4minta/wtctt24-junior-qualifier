package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: utils.kt */
/* loaded from: classes3.dex */
final class SubtypePathNode {
    private final SubtypePathNode previous;
    private final KotlinType type;

    public SubtypePathNode(KotlinType type, SubtypePathNode subtypePathNode) {
        m.g(type, "type");
        this.type = type;
        this.previous = subtypePathNode;
    }

    public final SubtypePathNode getPrevious() {
        return this.previous;
    }

    public final KotlinType getType() {
        return this.type;
    }
}