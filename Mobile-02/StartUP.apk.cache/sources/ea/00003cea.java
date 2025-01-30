package com.google.zxing.o;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.c;
import com.google.zxing.j;
import com.google.zxing.k;

/* compiled from: AztecReader.java */
/* loaded from: classes2.dex */
public final class b implements j {
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e A[LOOP:0: B:33:0x005c->B:34:0x005e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
    @Override // com.google.zxing.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.zxing.k a(com.google.zxing.c r11, java.util.Map<com.google.zxing.d, ?> r12) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        /*
            r10 = this;
            com.google.zxing.o.d.a r0 = new com.google.zxing.o.d.a
            com.google.zxing.q.b r11 = r11.a()
            r0.<init>(r11)
            r11 = 0
            r1 = 0
            com.google.zxing.o.a r2 = r0.a(r11)     // Catch: com.google.zxing.FormatException -> L25 com.google.zxing.NotFoundException -> L2b
            com.google.zxing.m[] r3 = r2.b()     // Catch: com.google.zxing.FormatException -> L25 com.google.zxing.NotFoundException -> L2b
            com.google.zxing.o.c.a r4 = new com.google.zxing.o.c.a     // Catch: com.google.zxing.FormatException -> L21 com.google.zxing.NotFoundException -> L23
            r4.<init>()     // Catch: com.google.zxing.FormatException -> L21 com.google.zxing.NotFoundException -> L23
            com.google.zxing.q.e r2 = r4.c(r2)     // Catch: com.google.zxing.FormatException -> L21 com.google.zxing.NotFoundException -> L23
            r4 = r3
            r3 = r1
            r1 = r2
            r2 = r3
            goto L2f
        L21:
            r2 = move-exception
            goto L27
        L23:
            r2 = move-exception
            goto L2d
        L25:
            r2 = move-exception
            r3 = r1
        L27:
            r4 = r3
            r3 = r2
            r2 = r1
            goto L2f
        L2b:
            r2 = move-exception
            r3 = r1
        L2d:
            r4 = r3
            r3 = r1
        L2f:
            if (r1 != 0) goto L4e
            r1 = 1
            com.google.zxing.o.a r0 = r0.a(r1)     // Catch: com.google.zxing.FormatException -> L44 com.google.zxing.NotFoundException -> L46
            com.google.zxing.m[] r4 = r0.b()     // Catch: com.google.zxing.FormatException -> L44 com.google.zxing.NotFoundException -> L46
            com.google.zxing.o.c.a r1 = new com.google.zxing.o.c.a     // Catch: com.google.zxing.FormatException -> L44 com.google.zxing.NotFoundException -> L46
            r1.<init>()     // Catch: com.google.zxing.FormatException -> L44 com.google.zxing.NotFoundException -> L46
            com.google.zxing.q.e r1 = r1.c(r0)     // Catch: com.google.zxing.FormatException -> L44 com.google.zxing.NotFoundException -> L46
            goto L4e
        L44:
            r11 = move-exception
            goto L47
        L46:
            r11 = move-exception
        L47:
            if (r2 != 0) goto L4d
            if (r3 == 0) goto L4c
            throw r3
        L4c:
            throw r11
        L4d:
            throw r2
        L4e:
            r6 = r4
            if (r12 == 0) goto L66
            com.google.zxing.d r0 = com.google.zxing.d.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r12 = r12.get(r0)
            com.google.zxing.n r12 = (com.google.zxing.n) r12
            if (r12 == 0) goto L66
            int r0 = r6.length
        L5c:
            if (r11 >= r0) goto L66
            r2 = r6[r11]
            r12.a(r2)
            int r11 = r11 + 1
            goto L5c
        L66:
            com.google.zxing.k r11 = new com.google.zxing.k
            java.lang.String r3 = r1.h()
            byte[] r4 = r1.e()
            int r5 = r1.c()
            com.google.zxing.a r7 = com.google.zxing.a.AZTEC
            long r8 = java.lang.System.currentTimeMillis()
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
            java.util.List r12 = r1.a()
            if (r12 == 0) goto L89
            com.google.zxing.l r0 = com.google.zxing.l.BYTE_SEGMENTS
            r11.h(r0, r12)
        L89:
            java.lang.String r12 = r1.b()
            if (r12 == 0) goto L94
            com.google.zxing.l r0 = com.google.zxing.l.ERROR_CORRECTION_LEVEL
            r11.h(r0, r12)
        L94:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.o.b.a(com.google.zxing.c, java.util.Map):com.google.zxing.k");
    }

    @Override // com.google.zxing.j
    public k b(c cVar) throws NotFoundException, FormatException {
        return a(cVar, null);
    }

    @Override // com.google.zxing.j
    public void reset() {
    }
}