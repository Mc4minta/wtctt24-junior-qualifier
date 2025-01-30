package okhttp3.internal.publicsuffix;

import kotlin.Metadata;
import kotlin.j0.f;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.p;

/* compiled from: PublicSuffixDatabase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
/* loaded from: classes3.dex */
final /* synthetic */ class PublicSuffixDatabase$findMatchingRule$1 extends p {
    PublicSuffixDatabase$findMatchingRule$1(PublicSuffixDatabase publicSuffixDatabase) {
        super(publicSuffixDatabase);
    }

    @Override // kotlin.j0.n
    public Object get() {
        return PublicSuffixDatabase.access$getPublicSuffixListBytes$p((PublicSuffixDatabase) this.receiver);
    }

    @Override // kotlin.jvm.internal.c, kotlin.j0.c
    public String getName() {
        return "publicSuffixListBytes";
    }

    @Override // kotlin.jvm.internal.c
    public f getOwner() {
        return e0.b(PublicSuffixDatabase.class);
    }

    @Override // kotlin.jvm.internal.c
    public String getSignature() {
        return "getPublicSuffixListBytes()[B";
    }

    public void set(Object obj) {
        ((PublicSuffixDatabase) this.receiver).publicSuffixListBytes = (byte[]) obj;
    }
}