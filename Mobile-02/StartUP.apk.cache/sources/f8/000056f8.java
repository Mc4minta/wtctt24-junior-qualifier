package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: JvmMemberSignature.kt */
/* loaded from: classes3.dex */
public abstract class JvmMemberSignature {

    /* compiled from: JvmMemberSignature.kt */
    /* loaded from: classes3.dex */
    public static final class Field extends JvmMemberSignature {
        private final String desc;
        private final String name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Field(String name, String desc) {
            super(null);
            m.g(name, "name");
            m.g(desc, "desc");
            this.name = name;
            this.desc = desc;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return getName() + ':' + getDesc();
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.desc;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Field) {
                Field field = (Field) obj;
                return m.c(this.name, field.name) && m.c(this.desc, field.desc);
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getDesc() {
            return this.desc;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.desc.hashCode();
        }
    }

    /* compiled from: JvmMemberSignature.kt */
    /* loaded from: classes3.dex */
    public static final class Method extends JvmMemberSignature {
        private final String desc;
        private final String name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Method(String name, String desc) {
            super(null);
            m.g(name, "name");
            m.g(desc, "desc");
            this.name = name;
            this.desc = desc;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return m.o(getName(), getDesc());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Method) {
                Method method = (Method) obj;
                return m.c(this.name, method.name) && m.c(this.desc, method.desc);
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getDesc() {
            return this.desc;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.desc.hashCode();
        }
    }

    private JvmMemberSignature() {
    }

    public /* synthetic */ JvmMemberSignature(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String asString();

    public abstract String getDesc();

    public abstract String getName();

    public final String toString() {
        return asString();
    }
}