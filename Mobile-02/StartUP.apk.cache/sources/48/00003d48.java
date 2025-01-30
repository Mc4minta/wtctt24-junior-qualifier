package com.google.zxing.t.r.g.e;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* compiled from: AbstractExpandedDecoder.java */
/* loaded from: classes2.dex */
public abstract class j {
    private final com.google.zxing.q.a a;

    /* renamed from: b  reason: collision with root package name */
    private final s f10052b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(com.google.zxing.q.a aVar) {
        this.a = aVar;
        this.f10052b = new s(aVar);
    }

    public static j a(com.google.zxing.q.a aVar) {
        if (aVar.i(1)) {
            return new g(aVar);
        }
        if (!aVar.i(2)) {
            return new k(aVar);
        }
        int g2 = s.g(aVar, 1, 4);
        if (g2 != 4) {
            if (g2 != 5) {
                int g3 = s.g(aVar, 1, 5);
                if (g3 != 12) {
                    if (g3 != 13) {
                        switch (s.g(aVar, 1, 7)) {
                            case 56:
                                return new e(aVar, "310", "11");
                            case 57:
                                return new e(aVar, "320", "11");
                            case 58:
                                return new e(aVar, "310", "13");
                            case 59:
                                return new e(aVar, "320", "13");
                            case 60:
                                return new e(aVar, "310", "15");
                            case 61:
                                return new e(aVar, "320", "15");
                            case 62:
                                return new e(aVar, "310", "17");
                            case 63:
                                return new e(aVar, "320", "17");
                            default:
                                throw new IllegalStateException("unknown decoder: " + aVar);
                        }
                    }
                    return new d(aVar);
                }
                return new c(aVar);
            }
            return new b(aVar);
        }
        return new a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final s b() {
        return this.f10052b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.google.zxing.q.a c() {
        return this.a;
    }

    public abstract String d() throws NotFoundException, FormatException;
}