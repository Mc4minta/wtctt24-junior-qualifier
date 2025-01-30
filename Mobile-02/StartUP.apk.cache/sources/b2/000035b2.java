package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.w2;
import com.google.android.gms.internal.measurement.x2;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class w2<MessageType extends x2<MessageType, BuilderType>, BuilderType extends w2<MessageType, BuilderType>> implements x5 {
    @Override // com.google.android.gms.internal.measurement.x5
    public final /* synthetic */ x5 a0(byte[] bArr) throws zzfm {
        return l(bArr, 0, bArr.length);
    }

    public abstract /* synthetic */ Object clone() throws CloneNotSupportedException;

    protected abstract BuilderType k(MessageType messagetype);

    public abstract BuilderType l(byte[] bArr, int i2, int i3) throws zzfm;

    public abstract BuilderType n(byte[] bArr, int i2, int i3, z3 z3Var) throws zzfm;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.x5
    public final /* synthetic */ x5 o0(u5 u5Var) {
        if (b().getClass().isInstance(u5Var)) {
            return k((x2) u5Var);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // com.google.android.gms.internal.measurement.x5
    public final /* synthetic */ x5 z0(byte[] bArr, z3 z3Var) throws zzfm {
        return n(bArr, 0, bArr.length, z3Var);
    }
}