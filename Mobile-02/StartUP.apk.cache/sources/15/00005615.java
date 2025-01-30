package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.m;
import kotlin.l0.x;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: typeSignatureMapping.kt */
/* loaded from: classes3.dex */
public class JvmDescriptorTypeWriter<T> {
    private T jvmCurrentType;
    private int jvmCurrentTypeArrayLevel;
    private final JvmTypeFactory<T> jvmTypeFactory;

    public void writeArrayEnd() {
    }

    public void writeArrayType() {
        if (this.jvmCurrentType == null) {
            this.jvmCurrentTypeArrayLevel++;
        }
    }

    public void writeClass(T objectType) {
        m.g(objectType, "objectType");
        writeJvmTypeAsIs(objectType);
    }

    protected final void writeJvmTypeAsIs(T type) {
        String G;
        m.g(type, "type");
        if (this.jvmCurrentType == null) {
            int i2 = this.jvmCurrentTypeArrayLevel;
            if (i2 > 0) {
                JvmTypeFactory<T> jvmTypeFactory = this.jvmTypeFactory;
                G = x.G("[", i2);
                type = jvmTypeFactory.createFromString(m.o(G, this.jvmTypeFactory.toString(type)));
            }
            this.jvmCurrentType = type;
        }
    }

    public void writeTypeVariable(Name name, T type) {
        m.g(name, "name");
        m.g(type, "type");
        writeJvmTypeAsIs(type);
    }
}