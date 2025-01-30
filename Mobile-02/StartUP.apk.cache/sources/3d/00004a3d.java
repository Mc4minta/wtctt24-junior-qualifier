package e.j.l.o;

import android.util.Base64;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.coinbase.wallet.common.extensions.Map_CommonKt;
import e.j.l.o.a;
import java.util.Map;
import kotlin.a0.m0;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: Base64Util.kt */
@AppCoreScoped
/* loaded from: classes2.dex */
public final class b implements a {
    private final Map<a.EnumC0327a, Integer> a;

    public b() {
        Map<a.EnumC0327a, Integer> l2;
        l2 = m0.l(u.a(a.EnumC0327a.DEFAULT, 0), u.a(a.EnumC0327a.NO_WRAP, 2));
        this.a = l2;
    }

    @Override // e.j.l.o.a
    public byte[] a(String str, a.EnumC0327a flag) {
        m.g(flag, "flag");
        if (str == null) {
            return null;
        }
        try {
            return Base64.decode(str, ((Number) Map_CommonKt.require(this.a, flag)).intValue());
        } catch (IllegalArgumentException e2) {
            l.a.a.f(e2, "Exception when decoding", new Object[0]);
            return null;
        }
    }

    @Override // e.j.l.o.a
    public String b(byte[] bArr, a.EnumC0327a flag) {
        m.g(flag, "flag");
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, ((Number) Map_CommonKt.require(this.a, flag)).intValue());
    }
}