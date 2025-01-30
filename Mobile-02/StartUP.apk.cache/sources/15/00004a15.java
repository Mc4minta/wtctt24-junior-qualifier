package e.j.j;

import android.content.Context;
import android.content.SharedPreferences;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import e.j.f.s;
import e.j.l.o.a;

/* compiled from: PinPrefs.kt */
@AppCoreScoped
/* loaded from: classes2.dex */
public final class m implements n {

    /* renamed from: b  reason: collision with root package name */
    private final e.j.l.o.a f13688b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f13689c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.h f13690d;

    /* compiled from: PinPrefs.kt */
    /* loaded from: classes2.dex */
    static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<SharedPreferences> {
        a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.e0.c.a
        public final SharedPreferences invoke() {
            return m.this.f13689c.getSharedPreferences("pin", 0);
        }
    }

    public m(e.j.l.o.a base64Util, Context context) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(base64Util, "base64Util");
        kotlin.jvm.internal.m.g(context, "context");
        this.f13688b = base64Util;
        this.f13689c = context;
        b2 = kotlin.k.b(new a());
        this.f13690d = b2;
    }

    private final SharedPreferences c() {
        return (SharedPreferences) this.f13690d.getValue();
    }

    @Override // e.j.j.n
    public void a(byte[] salt) {
        kotlin.jvm.internal.m.g(salt, "salt");
        SharedPreferences prefs = c();
        kotlin.jvm.internal.m.f(prefs, "prefs");
        s.d(prefs, "pin_salt", this.f13688b.b(salt, a.EnumC0327a.NO_WRAP));
    }

    @Override // e.j.j.n
    public byte[] getSalt() {
        e.j.l.o.a aVar = this.f13688b;
        SharedPreferences prefs = c();
        kotlin.jvm.internal.m.f(prefs, "prefs");
        return aVar.a(s.g(prefs, "pin_salt"), a.EnumC0327a.NO_WRAP);
    }
}