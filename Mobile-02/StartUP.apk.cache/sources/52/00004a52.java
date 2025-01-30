package e.j.l.u;

import com.coinbase.ApiConstants;
import com.google.firebase.crashlytics.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import l.a.a;

/* compiled from: CrashlyticsTree.kt */
/* loaded from: classes2.dex */
public final class a extends a.b {

    /* renamed from: b  reason: collision with root package name */
    public static final C0330a f13739b = new C0330a(null);

    /* renamed from: c  reason: collision with root package name */
    private final b f13740c;

    /* compiled from: CrashlyticsTree.kt */
    /* renamed from: e.j.l.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0330a {
        private C0330a() {
        }

        public /* synthetic */ C0330a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ a(com.google.firebase.crashlytics.b r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto Ld
            com.google.firebase.crashlytics.b r1 = com.google.firebase.crashlytics.b.a()
            java.lang.String r2 = "getInstance()"
            kotlin.jvm.internal.m.f(r1, r2)
        Ld:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.l.u.a.<init>(com.google.firebase.crashlytics.b, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // l.a.a.b
    protected void m(int i2, String str, String message, Throwable th) {
        m.g(message, "message");
        if (i2 == 4) {
            b bVar = this.f13740c;
            bVar.c(((Object) str) + ": " + message);
        } else if (i2 != 6) {
        } else {
            b bVar2 = this.f13740c;
            bVar2.e("priority", i2);
            if (str != null) {
                bVar2.f("tag", str);
            }
            bVar2.f(ApiConstants.MESSAGE, message);
            if (th == null) {
                bVar2.d(new Exception(message));
            } else {
                bVar2.d(new Exception(message, th));
            }
            bVar2.c(m.o("non-fatal exception: ", message));
        }
    }

    public a(b crashlytics) {
        m.g(crashlytics, "crashlytics");
        this.f13740c = crashlytics;
    }
}