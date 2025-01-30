package e.j.f;

import android.text.Editable;
import kotlin.l0.a0;

/* compiled from: EditableExtensions.kt */
/* loaded from: classes2.dex */
public final class l {
    private static final boolean a(Editable editable, int i2) {
        Character n1;
        n1 = a0.n1(editable, i2);
        return n1 != null && n1.charValue() == ' ';
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0018, code lost:
        r6 = kotlin.l0.y.e0(r3, r5, r6 - r5.length(), true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(android.text.Editable r3, java.lang.String r4, java.lang.String r5, int r6, boolean r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.m.g(r3, r0)
            java.lang.String r0 = "word"
            kotlin.jvm.internal.m.g(r4, r0)
            java.lang.String r0 = "currentWord"
            kotlin.jvm.internal.m.g(r5, r0)
            r0 = 0
            r1 = 2
            r2 = 0
            boolean r0 = kotlin.l0.o.Q(r4, r5, r0, r1, r2)
            if (r0 == 0) goto L3c
            int r0 = r5.length()
            int r6 = r6 - r0
            r0 = 1
            int r6 = kotlin.l0.o.e0(r3, r5, r6, r0)
            int r5 = r5.length()
            int r5 = r5 + r6
            if (r5 >= 0) goto L2a
            return
        L2a:
            if (r7 == 0) goto L39
            boolean r7 = a(r3, r5)
            if (r7 == 0) goto L33
            goto L39
        L33:
            java.lang.String r7 = " "
            java.lang.String r4 = kotlin.jvm.internal.m.o(r4, r7)
        L39:
            r3.replace(r6, r5, r4)
        L3c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.f.l.b(android.text.Editable, java.lang.String, java.lang.String, int, boolean):void");
    }
}