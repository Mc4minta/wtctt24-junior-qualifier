package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OpReorderer.java */
/* loaded from: classes.dex */
public class o {
    final a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OpReorderer.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(a.b bVar);

        a.b b(int i2, int i3, int i4, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.a = aVar;
    }

    private int a(List<a.b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<a.b> list, int i2, a.b bVar, int i3, a.b bVar2) {
        int i4 = bVar.f2091d;
        int i5 = bVar2.f2089b;
        int i6 = i4 < i5 ? -1 : 0;
        int i7 = bVar.f2089b;
        if (i7 < i5) {
            i6++;
        }
        if (i5 <= i7) {
            bVar.f2089b = i7 + bVar2.f2091d;
        }
        int i8 = bVar2.f2089b;
        if (i8 <= i4) {
            bVar.f2091d = i4 + bVar2.f2091d;
        }
        bVar2.f2089b = i8 + i6;
        list.set(i2, bVar2);
        list.set(i3, bVar);
    }

    private void d(List<a.b> list, int i2, int i3) {
        a.b bVar = list.get(i2);
        a.b bVar2 = list.get(i3);
        int i4 = bVar2.a;
        if (i4 == 1) {
            c(list, i2, bVar, i3, bVar2);
        } else if (i4 == 2) {
            e(list, i2, bVar, i3, bVar2);
        } else if (i4 != 4) {
        } else {
            f(list, i2, bVar, i3, bVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(List<a.b> list) {
        while (true) {
            int a2 = a(list);
            if (a2 == -1) {
                return;
            }
            d(list, a2, a2 + 1);
        }
    }

    void e(List<a.b> list, int i2, a.b bVar, int i3, a.b bVar2) {
        boolean z;
        int i4 = bVar.f2089b;
        int i5 = bVar.f2091d;
        boolean z2 = false;
        if (i4 < i5) {
            if (bVar2.f2089b == i4 && bVar2.f2091d == i5 - i4) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (bVar2.f2089b == i5 + 1 && bVar2.f2091d == i4 - i5) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i6 = bVar2.f2089b;
        if (i5 < i6) {
            bVar2.f2089b = i6 - 1;
        } else {
            int i7 = bVar2.f2091d;
            if (i5 < i6 + i7) {
                bVar2.f2091d = i7 - 1;
                bVar.a = 2;
                bVar.f2091d = 1;
                if (bVar2.f2091d == 0) {
                    list.remove(i3);
                    this.a.a(bVar2);
                    return;
                }
                return;
            }
        }
        int i8 = bVar.f2089b;
        int i9 = bVar2.f2089b;
        a.b bVar3 = null;
        if (i8 <= i9) {
            bVar2.f2089b = i9 + 1;
        } else {
            int i10 = bVar2.f2091d;
            if (i8 < i9 + i10) {
                bVar3 = this.a.b(2, i8 + 1, (i9 + i10) - i8, null);
                bVar2.f2091d = bVar.f2089b - bVar2.f2089b;
            }
        }
        if (z2) {
            list.set(i2, bVar2);
            list.remove(i3);
            this.a.a(bVar);
            return;
        }
        if (z) {
            if (bVar3 != null) {
                int i11 = bVar.f2089b;
                if (i11 > bVar3.f2089b) {
                    bVar.f2089b = i11 - bVar3.f2091d;
                }
                int i12 = bVar.f2091d;
                if (i12 > bVar3.f2089b) {
                    bVar.f2091d = i12 - bVar3.f2091d;
                }
            }
            int i13 = bVar.f2089b;
            if (i13 > bVar2.f2089b) {
                bVar.f2089b = i13 - bVar2.f2091d;
            }
            int i14 = bVar.f2091d;
            if (i14 > bVar2.f2089b) {
                bVar.f2091d = i14 - bVar2.f2091d;
            }
        } else {
            if (bVar3 != null) {
                int i15 = bVar.f2089b;
                if (i15 >= bVar3.f2089b) {
                    bVar.f2089b = i15 - bVar3.f2091d;
                }
                int i16 = bVar.f2091d;
                if (i16 >= bVar3.f2089b) {
                    bVar.f2091d = i16 - bVar3.f2091d;
                }
            }
            int i17 = bVar.f2089b;
            if (i17 >= bVar2.f2089b) {
                bVar.f2089b = i17 - bVar2.f2091d;
            }
            int i18 = bVar.f2091d;
            if (i18 >= bVar2.f2089b) {
                bVar.f2091d = i18 - bVar2.f2091d;
            }
        }
        list.set(i2, bVar2);
        if (bVar.f2089b != bVar.f2091d) {
            list.set(i3, bVar);
        } else {
            list.remove(i3);
        }
        if (bVar3 != null) {
            list.add(i2, bVar3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void f(java.util.List<androidx.recyclerview.widget.a.b> r9, int r10, androidx.recyclerview.widget.a.b r11, int r12, androidx.recyclerview.widget.a.b r13) {
        /*
            r8 = this;
            int r0 = r11.f2091d
            int r1 = r13.f2089b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Ld
            int r1 = r1 - r4
            r13.f2089b = r1
            goto L20
        Ld:
            int r5 = r13.f2091d
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r4
            r13.f2091d = r5
            androidx.recyclerview.widget.o$a r0 = r8.a
            int r1 = r11.f2089b
            java.lang.Object r5 = r13.f2090c
            androidx.recyclerview.widget.a$b r0 = r0.b(r2, r1, r4, r5)
            goto L21
        L20:
            r0 = r3
        L21:
            int r1 = r11.f2089b
            int r5 = r13.f2089b
            if (r1 > r5) goto L2b
            int r5 = r5 + r4
            r13.f2089b = r5
            goto L41
        L2b:
            int r6 = r13.f2091d
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.o$a r3 = r8.a
            int r1 = r1 + r4
            java.lang.Object r4 = r13.f2090c
            androidx.recyclerview.widget.a$b r3 = r3.b(r2, r1, r5, r4)
            int r1 = r13.f2091d
            int r1 = r1 - r5
            r13.f2091d = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f2091d
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.o$a r11 = r8.a
            r11.a(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r3 == 0) goto L5e
            r9.add(r10, r3)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.o.f(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }
}