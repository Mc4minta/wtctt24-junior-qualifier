package com.google.protobuf;

import com.google.protobuf.n;

/* compiled from: AbstractParser.java */
/* loaded from: classes2.dex */
public abstract class b<MessageType extends n> implements q<MessageType> {
    private static final h a = h.a();

    private MessageType c(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw d(messagetype).a().h(messagetype);
    }

    private UninitializedMessageException d(MessageType messagetype) {
        if (messagetype instanceof a) {
            return ((a) messagetype).a();
        }
        return new UninitializedMessageException(messagetype);
    }

    @Override // com.google.protobuf.q
    /* renamed from: e */
    public MessageType a(e eVar, h hVar) throws InvalidProtocolBufferException {
        return c(f(eVar, hVar));
    }

    public MessageType f(e eVar, h hVar) throws InvalidProtocolBufferException {
        try {
            f p = eVar.p();
            MessageType messagetype = (MessageType) b(p, hVar);
            try {
                p.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.h(messagetype);
            }
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }
}