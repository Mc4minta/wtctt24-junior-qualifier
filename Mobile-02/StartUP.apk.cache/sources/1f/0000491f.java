package e.j.d;

import javax.crypto.Cipher;
import kotlin.j0.m;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;

/* compiled from: Permit.kt */
/* loaded from: classes2.dex */
public final class a extends c {
    static final /* synthetic */ m<Object>[] a = {e0.h(new x(e0.b(a.class), "cipher", "getCipher()Ljavax/crypto/Cipher;"))};

    /* renamed from: b  reason: collision with root package name */
    private final b f13523b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Cipher cipher) {
        super(null);
        kotlin.jvm.internal.m.g(cipher, "cipher");
        this.f13523b = new b(cipher);
    }

    public final Cipher a() {
        return (Cipher) this.f13523b.a(this, a[0]);
    }
}