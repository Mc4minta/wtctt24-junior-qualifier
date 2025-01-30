package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.m;

/* compiled from: ModuleCapability.kt */
/* loaded from: classes3.dex */
public final class ModuleCapability<T> {
    private final String name;

    public ModuleCapability(String name) {
        m.g(name, "name");
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}