package com.coinbase.wallet.core.extensions;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* compiled from: Map+Core.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\u001a1\u0010\u0004\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a<\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001*\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"K", "V", "", "key", "require", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "asMapOfType", "(Ljava/util/Map;)Ljava/util/Map;", "core_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Map_CoreKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0042 A[EDGE_INSN: B:22:0x0042->B:18:0x0042 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ <K, V> java.util.Map<K, V> asMapOfType(java.util.Map<?, ?> r8) {
        /*
            r0 = 0
            if (r8 != 0) goto L4
            return r0
        L4:
            boolean r1 = r8.isEmpty()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto Le
        Lc:
            r2 = r3
            goto L42
        Le:
            java.util.Set r1 = r8.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L16:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto Lc
            java.lang.Object r4 = r1.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            r6 = 3
            java.lang.String r7 = "K"
            kotlin.jvm.internal.m.l(r6, r7)
            boolean r5 = r5 instanceof java.lang.Object
            if (r5 == 0) goto L3f
            java.lang.String r5 = "V"
            kotlin.jvm.internal.m.l(r6, r5)
            boolean r4 = r4 instanceof java.lang.Object
            if (r4 == 0) goto L3f
            r4 = r3
            goto L40
        L3f:
            r4 = r2
        L40:
            if (r4 != 0) goto L16
        L42:
            if (r2 == 0) goto L45
            goto L46
        L45:
            r8 = r0
        L46:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.core.extensions.Map_CoreKt.asMapOfType(java.util.Map):java.util.Map");
    }

    public static final <K, V> V require(Map<K, ? extends V> map, K k2) {
        kotlin.jvm.internal.m.g(map, "<this>");
        V v = map.get(k2);
        if (v != null) {
            return v;
        }
        throw new NoSuchElementException(k2 + " in map is missing.");
    }
}