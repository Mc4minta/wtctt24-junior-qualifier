package com.coinbase.wallet.common.extensions;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Serializable+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u0004\u0018\u00010\u0001H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Ljava/io/Serializable;", "Ljava/lang/Class;", "asClassOfType", "(Ljava/io/Serializable;)Ljava/lang/Class;", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Serializable_CommonKt {
    public static final /* synthetic */ <T> Class<T> asClassOfType(Serializable serializable) {
        if (serializable != null) {
            if (serializable instanceof Class) {
                m.l(4, "T");
                Class<T> cls = (Class) serializable;
                if (Object.class.isAssignableFrom(cls)) {
                    return cls;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Class ");
            sb.append(serializable);
            sb.append(" is not assignable from ");
            m.l(4, "T");
            sb.append(Object.class);
            throw new IllegalStateException(sb.toString());
        }
        throw new IllegalStateException("Class this is null");
    }
}