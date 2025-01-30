package androidx.lifecycle;

import androidx.lifecycle.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements m {
    private final f a;

    /* renamed from: b  reason: collision with root package name */
    private final m f1749b;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.a.values().length];
            a = iArr;
            try {
                iArr[i.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[i.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[i.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[i.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[i.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullLifecycleObserverAdapter(f fVar, m mVar) {
        this.a = fVar;
        this.f1749b = mVar;
    }

    @Override // androidx.lifecycle.m
    public void c(o oVar, i.a aVar) {
        switch (a.a[aVar.ordinal()]) {
            case 1:
                this.a.b(oVar);
                break;
            case 2:
                this.a.g(oVar);
                break;
            case 3:
                this.a.a(oVar);
                break;
            case 4:
                this.a.d(oVar);
                break;
            case 5:
                this.a.e(oVar);
                break;
            case 6:
                this.a.f(oVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        m mVar = this.f1749b;
        if (mVar != null) {
            mVar.c(oVar, aVar);
        }
    }
}