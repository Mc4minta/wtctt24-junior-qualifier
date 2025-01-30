package j;

import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Options.kt */
/* loaded from: classes3.dex */
public final class t extends kotlin.a0.d<i> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public static final a f17165b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private final i[] f17166c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f17167d;

    /* compiled from: Options.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        private final void a(long j2, f fVar, int i2, List<? extends i> list, int i3, int i4, List<Integer> list2) {
            int i5;
            int i6;
            int i7;
            int i8;
            f fVar2;
            int i9 = i2;
            if (i3 < i4) {
                for (int i10 = i3; i10 < i4; i10++) {
                    if (!(list.get(i10).Q() >= i9)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                i iVar = list.get(i3);
                i iVar2 = list.get(i4 - 1);
                int i11 = -1;
                if (i9 == iVar.Q()) {
                    int i12 = i3 + 1;
                    i5 = i12;
                    i6 = list2.get(i3).intValue();
                    iVar = list.get(i12);
                } else {
                    i5 = i3;
                    i6 = -1;
                }
                if (iVar.A(i9) != iVar2.A(i9)) {
                    int i13 = 1;
                    for (int i14 = i5 + 1; i14 < i4; i14++) {
                        if (list.get(i14 - 1).A(i9) != list.get(i14).A(i9)) {
                            i13++;
                        }
                    }
                    long c2 = j2 + c(fVar) + 2 + (i13 * 2);
                    fVar.D(i13);
                    fVar.D(i6);
                    for (int i15 = i5; i15 < i4; i15++) {
                        byte A = list.get(i15).A(i9);
                        if (i15 == i5 || A != list.get(i15 - 1).A(i9)) {
                            fVar.D(A & 255);
                        }
                    }
                    f fVar3 = new f();
                    while (i5 < i4) {
                        byte A2 = list.get(i5).A(i9);
                        int i16 = i5 + 1;
                        int i17 = i16;
                        while (true) {
                            if (i17 >= i4) {
                                i7 = i4;
                                break;
                            } else if (A2 != list.get(i17).A(i9)) {
                                i7 = i17;
                                break;
                            } else {
                                i17++;
                            }
                        }
                        if (i16 == i7 && i9 + 1 == list.get(i5).Q()) {
                            fVar.D(list2.get(i5).intValue());
                            i8 = i7;
                            fVar2 = fVar3;
                        } else {
                            fVar.D(((int) (c2 + c(fVar3))) * i11);
                            i8 = i7;
                            fVar2 = fVar3;
                            a(c2, fVar3, i9 + 1, list, i5, i7, list2);
                        }
                        fVar3 = fVar2;
                        i5 = i8;
                        i11 = -1;
                    }
                    fVar.t0(fVar3);
                    return;
                }
                int min = Math.min(iVar.Q(), iVar2.Q());
                int i18 = 0;
                for (int i19 = i9; i19 < min && iVar.A(i19) == iVar2.A(i19); i19++) {
                    i18++;
                }
                long c3 = j2 + c(fVar) + 2 + i18 + 1;
                fVar.D(-i18);
                fVar.D(i6);
                int i20 = i9 + i18;
                while (i9 < i20) {
                    fVar.D(iVar.A(i9) & 255);
                    i9++;
                }
                if (i5 + 1 == i4) {
                    if (i20 == list.get(i5).Q()) {
                        fVar.D(list2.get(i5).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                f fVar4 = new f();
                fVar.D(((int) (c(fVar4) + c3)) * (-1));
                a(c3, fVar4, i20, list, i5, i4, list2);
                fVar.t0(fVar4);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        static /* synthetic */ void b(a aVar, long j2, f fVar, int i2, List list, int i3, int i4, List list2, int i5, Object obj) {
            aVar.a((i5 & 1) != 0 ? 0L : j2, fVar, (i5 & 4) != 0 ? 0 : i2, list, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) != 0 ? list.size() : i4, list2);
        }

        private final long c(f fVar) {
            return fVar.O0() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:55:0x00f1, code lost:
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final j.t d(j.i... r17) {
            /*
                Method dump skipped, instructions count: 328
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: j.t.a.d(j.i[]):j.t");
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ t(i[] iVarArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(iVarArr, iArr);
    }

    public static final t r(i... iVarArr) {
        return f17165b.d(iVarArr);
    }

    @Override // kotlin.a0.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof i) {
            return k((i) obj);
        }
        return false;
    }

    @Override // kotlin.a0.a
    public int i() {
        return this.f17166c.length;
    }

    @Override // kotlin.a0.d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof i) {
            return p((i) obj);
        }
        return -1;
    }

    public /* bridge */ boolean k(i iVar) {
        return super.contains(iVar);
    }

    @Override // kotlin.a0.d, java.util.List
    /* renamed from: l */
    public i get(int i2) {
        return this.f17166c[i2];
    }

    @Override // kotlin.a0.d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof i) {
            return q((i) obj);
        }
        return -1;
    }

    public final i[] m() {
        return this.f17166c;
    }

    public final int[] o() {
        return this.f17167d;
    }

    public /* bridge */ int p(i iVar) {
        return super.indexOf(iVar);
    }

    public /* bridge */ int q(i iVar) {
        return super.lastIndexOf(iVar);
    }

    private t(i[] iVarArr, int[] iArr) {
        this.f17166c = iVarArr;
        this.f17167d = iArr;
    }
}