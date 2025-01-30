package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;

/* compiled from: ContractDeserializer.kt */
/* loaded from: classes3.dex */
public interface ContractDeserializer {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: ContractDeserializer.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ContractDeserializer DEFAULT = new ContractDeserializer() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer$Companion$DEFAULT$1
            @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer
            public o deserializeContractFromFunction(ProtoBuf.Function proto, FunctionDescriptor ownerFunction, TypeTable typeTable, TypeDeserializer typeDeserializer) {
                m.g(proto, "proto");
                m.g(ownerFunction, "ownerFunction");
                m.g(typeTable, "typeTable");
                m.g(typeDeserializer, "typeDeserializer");
                return null;
            }
        };

        private Companion() {
        }

        public final ContractDeserializer getDEFAULT() {
            return DEFAULT;
        }
    }

    o<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction(ProtoBuf.Function function, FunctionDescriptor functionDescriptor, TypeTable typeTable, TypeDeserializer typeDeserializer);
}