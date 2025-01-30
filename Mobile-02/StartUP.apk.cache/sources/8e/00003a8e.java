package com.google.firebase.crashlytics.c.n.d;

import com.google.firebase.crashlytics.c.n.c.c;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class a implements b {
    private final c a;

    /* renamed from: b  reason: collision with root package name */
    private final d f9019b;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.c.n.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class C0187a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.a.values().length];
            a = iArr;
            try {
                iArr[c.a.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.a.NATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a(c cVar, d dVar) {
        this.a = cVar;
        this.f9019b = dVar;
    }

    @Override // com.google.firebase.crashlytics.c.n.d.b
    public boolean b(com.google.firebase.crashlytics.c.n.c.a aVar, boolean z) {
        int i2 = C0187a.a[aVar.f9014c.getType().ordinal()];
        if (i2 == 1) {
            this.a.b(aVar, z);
            return true;
        } else if (i2 != 2) {
            return false;
        } else {
            this.f9019b.b(aVar, z);
            return true;
        }
    }
}