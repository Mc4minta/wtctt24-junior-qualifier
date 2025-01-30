package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;

/* compiled from: MemberSignature.kt */
/* loaded from: classes3.dex */
public final class MemberSignature {
    public static final Companion Companion = new Companion(null);
    private final String signature;

    /* compiled from: MemberSignature.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemberSignature fromFieldNameAndDesc(String name, String desc) {
            m.g(name, "name");
            m.g(desc, "desc");
            return new MemberSignature(name + '#' + desc, null);
        }

        public final MemberSignature fromJvmMemberSignature(JvmMemberSignature signature) {
            m.g(signature, "signature");
            if (signature instanceof JvmMemberSignature.Method) {
                return fromMethodNameAndDesc(signature.getName(), signature.getDesc());
            }
            if (signature instanceof JvmMemberSignature.Field) {
                return fromFieldNameAndDesc(signature.getName(), signature.getDesc());
            }
            throw new NoWhenBranchMatchedException();
        }

        public final MemberSignature fromMethod(NameResolver nameResolver, JvmProtoBuf.JvmMethodSignature signature) {
            m.g(nameResolver, "nameResolver");
            m.g(signature, "signature");
            return fromMethodNameAndDesc(nameResolver.getString(signature.getName()), nameResolver.getString(signature.getDesc()));
        }

        public final MemberSignature fromMethodNameAndDesc(String name, String desc) {
            m.g(name, "name");
            m.g(desc, "desc");
            return new MemberSignature(m.o(name, desc), null);
        }

        public final MemberSignature fromMethodSignatureAndParameterIndex(MemberSignature signature, int i2) {
            m.g(signature, "signature");
            return new MemberSignature(signature.getSignature() + '@' + i2, null);
        }
    }

    private MemberSignature(String str) {
        this.signature = str;
    }

    public /* synthetic */ MemberSignature(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MemberSignature) && m.c(this.signature, ((MemberSignature) obj).signature);
    }

    public final String getSignature() {
        return this.signature;
    }

    public int hashCode() {
        return this.signature.hashCode();
    }

    public String toString() {
        return "MemberSignature(signature=" + this.signature + ')';
    }
}