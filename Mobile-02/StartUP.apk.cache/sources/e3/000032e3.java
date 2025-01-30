package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.q;
import com.google.android.gms.internal.clearcut.r;

/* loaded from: classes2.dex */
public abstract class r<MessageType extends q<MessageType, BuilderType>, BuilderType extends r<MessageType, BuilderType>> implements j2 {
    protected abstract BuilderType c(MessageType messagetype);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.clearcut.j2
    public final /* synthetic */ j2 k0(i2 i2Var) {
        if (b().getClass().isInstance(i2Var)) {
            return c((q) i2Var);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}