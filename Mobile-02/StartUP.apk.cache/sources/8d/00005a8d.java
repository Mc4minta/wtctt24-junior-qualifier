package okhttp3;

import java.security.cert.Certificate;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: Handshake.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/security/cert/Certificate;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes3.dex */
final class Handshake$Companion$get$1 extends o implements a<List<? extends Certificate>> {
    final /* synthetic */ List $peerCertificatesCopy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Handshake$Companion$get$1(List list) {
        super(0);
        this.$peerCertificatesCopy = list;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends Certificate> invoke() {
        return this.$peerCertificatesCopy;
    }
}