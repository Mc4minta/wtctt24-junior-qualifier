package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.b3;
import com.google.android.gms.internal.p000firebaseperf.c3;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.b3  reason: invalid package */
/* loaded from: classes2.dex */
public abstract class b3<MessageType extends c3<MessageType, BuilderType>, BuilderType extends b3<MessageType, BuilderType>> implements u5 {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p000firebaseperf.u5
    public final /* synthetic */ u5 I0(v5 v5Var) {
        if (d().getClass().isInstance(v5Var)) {
            return f((c3) v5Var);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public abstract /* synthetic */ Object clone() throws CloneNotSupportedException;

    protected abstract BuilderType f(MessageType messagetype);
}