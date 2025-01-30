package e.j.j;

import android.content.Context;
import android.content.SharedPreferences;
import com.coinbase.wallet.application.model.BiometricsProtectionType;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import e.j.f.s;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MnemonicPrefs.kt */
@AppCoreScoped
/* loaded from: classes2.dex */
public final class g implements h {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final Context f13685b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.h f13686c;

    /* compiled from: MnemonicPrefs.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MnemonicPrefs.kt */
    /* loaded from: classes2.dex */
    static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.a<SharedPreferences> {
        b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.e0.c.a
        public final SharedPreferences invoke() {
            return g.this.f13685b.getSharedPreferences("wa", 0);
        }
    }

    public g(Context context) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(context, "context");
        this.f13685b = context;
        b2 = kotlin.k.b(new b());
        this.f13686c = b2;
    }

    private final SharedPreferences f() {
        return (SharedPreferences) this.f13686c.getValue();
    }

    @Override // e.j.j.h
    public String a() {
        SharedPreferences prefs = f();
        kotlin.jvm.internal.m.f(prefs, "prefs");
        return s.g(prefs, "ms");
    }

    @Override // e.j.j.h
    public void b(String str) {
        SharedPreferences prefs = f();
        kotlin.jvm.internal.m.f(prefs, "prefs");
        if (!s.f(prefs, "ms", str)) {
            throw new IOException("Couldn't save master seed");
        }
    }

    @Override // e.j.j.h
    public BiometricsProtectionType c() {
        return BiometricsProtectionType.values()[f().getInt("biometricsProtection", 2)];
    }

    @Override // e.j.j.h
    public void d(BiometricsProtectionType value) {
        kotlin.jvm.internal.m.g(value, "value");
        SharedPreferences prefs = f();
        kotlin.jvm.internal.m.f(prefs, "prefs");
        s.c(prefs, "biometricsProtection", value.ordinal());
    }
}