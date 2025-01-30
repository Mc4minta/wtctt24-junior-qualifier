package com.google.protobuf;

import com.google.protobuf.a;
import com.google.protobuf.a.AbstractC0201a;
import com.google.protobuf.n;

/* compiled from: AbstractMessageLite.java */
/* loaded from: classes2.dex */
public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0201a<MessageType, BuilderType>> implements n {
    protected int a = 0;

    /* compiled from: AbstractMessageLite.java */
    /* renamed from: com.google.protobuf.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0201a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0201a<MessageType, BuilderType>> implements n.a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static UninitializedMessageException d(n nVar) {
            return new UninitializedMessageException(nVar);
        }

        protected abstract BuilderType b(MessageType messagetype);

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.n.a
        /* renamed from: c */
        public BuilderType s0(n nVar) {
            if (getDefaultInstanceForType().getClass().isInstance(nVar)) {
                return (BuilderType) b((a) nVar);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UninitializedMessageException a() {
        return new UninitializedMessageException(this);
    }
}