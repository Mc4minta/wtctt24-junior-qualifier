package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.m;

/* compiled from: utils.kt */
/* loaded from: classes3.dex */
public final class Constant extends JavaDefaultValue {
    private final Object value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Constant(Object value) {
        super(null);
        m.g(value, "value");
        this.value = value;
    }
}