package com.google.protobuf;

/* compiled from: MessageLite.java */
/* loaded from: classes2.dex */
public interface n extends o {

    /* compiled from: MessageLite.java */
    /* loaded from: classes2.dex */
    public interface a extends o, Cloneable {
        n build();

        a s0(n nVar);
    }

    q<? extends n> getParserForType();

    a toBuilder();
}