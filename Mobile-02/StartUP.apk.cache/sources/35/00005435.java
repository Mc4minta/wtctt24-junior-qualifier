package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.m;

/* compiled from: Visibility.kt */
/* loaded from: classes3.dex */
public abstract class Visibility {
    private final boolean isPublicAPI;
    private final String name;

    /* JADX INFO: Access modifiers changed from: protected */
    public Visibility(String name, boolean z) {
        m.g(name, "name");
        this.name = name;
        this.isPublicAPI = z;
    }

    public Integer compareTo(Visibility visibility) {
        m.g(visibility, "visibility");
        return Visibilities.INSTANCE.compareLocal$compiler_common(this, visibility);
    }

    public String getInternalDisplayName() {
        return this.name;
    }

    public final boolean isPublicAPI() {
        return this.isPublicAPI;
    }

    public Visibility normalize() {
        return this;
    }

    public final String toString() {
        return getInternalDisplayName();
    }
}