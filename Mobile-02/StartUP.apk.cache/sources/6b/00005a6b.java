package okhttp3;

import j.i;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.a0.n;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.m;
import kotlin.l0.x;
import kotlin.l0.y;
import okhttp3.internal.tls.CertificateChainCleaner;

/* compiled from: CertificatePinner.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0003*)+B!\b\u0000\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110$\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b'\u0010(J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\nH\u0000¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000f\"\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\u0010J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0019\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lokhttp3/CertificatePinner;", "", "", "hostname", "", "Ljava/security/cert/Certificate;", "peerCertificates", "Lkotlin/x;", "check", "(Ljava/lang/String;Ljava/util/List;)V", "Lkotlin/Function0;", "Ljava/security/cert/X509Certificate;", "cleanedPeerCertificatesFn", "check$okhttp", "(Ljava/lang/String;Lkotlin/e0/c/a;)V", "", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "Lokhttp3/CertificatePinner$Pin;", "findMatchingPins$okhttp", "(Ljava/lang/String;)Ljava/util/List;", "findMatchingPins", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "withCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)Lokhttp3/CertificatePinner;", "withCertificateChainCleaner", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lokhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "", "pins", "Ljava/util/Set;", "<init>", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "Companion", "Builder", "Pin", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    /* compiled from: CertificatePinner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\"\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\r¨\u0006\u0010"}, d2 = {"Lokhttp3/CertificatePinner$Builder;", "", "", "pattern", "", "pins", "add", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "Lokhttp3/CertificatePinner;", "build", "()Lokhttp3/CertificatePinner;", "", "Lokhttp3/CertificatePinner$Pin;", "Ljava/util/List;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public final Builder add(String pattern, String... pins) {
            m.h(pattern, "pattern");
            m.h(pins, "pins");
            for (String str : pins) {
                this.pins.add(CertificatePinner.Companion.newPin$okhttp(pattern, str));
            }
            return this;
        }

        public final CertificatePinner build() {
            Set M0;
            M0 = z.M0(this.pins);
            return new CertificatePinner(M0, null);
        }
    }

    /* compiled from: CertificatePinner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\b*\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\u00020\b*\u00020\u0007H\u0000¢\u0006\u0004\b\f\u0010\nJ\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00138\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lokhttp3/CertificatePinner$Companion;", "", "Ljava/security/cert/Certificate;", "certificate", "", "pin", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "Ljava/security/cert/X509Certificate;", "Lj/i;", "toSha1ByteString$okhttp", "(Ljava/security/cert/X509Certificate;)Lj/i;", "toSha1ByteString", "toSha256ByteString$okhttp", "toSha256ByteString", "pattern", "Lokhttp3/CertificatePinner$Pin;", "newPin$okhttp", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/CertificatePinner$Pin;", "newPin", "Lokhttp3/CertificatePinner;", "DEFAULT", "Lokhttp3/CertificatePinner;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0021, code lost:
            if (r0 != (-1)) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
            if (r0 != (-1)) goto L34;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00c2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okhttp3.CertificatePinner.Pin newPin$okhttp(java.lang.String r12, java.lang.String r13) {
            /*
                r11 = this;
                java.lang.String r0 = "pattern"
                kotlin.jvm.internal.m.h(r12, r0)
                java.lang.String r0 = "pin"
                kotlin.jvm.internal.m.h(r13, r0)
                java.lang.String r0 = "*."
                r1 = 0
                r2 = 2
                r3 = 0
                boolean r0 = kotlin.l0.o.Q(r12, r0, r1, r2, r3)
                r4 = -1
                if (r0 == 0) goto L23
                r7 = 1
                r8 = 0
                r9 = 4
                r10 = 0
                java.lang.String r6 = "*"
                r5 = r12
                int r0 = kotlin.l0.o.i0(r5, r6, r7, r8, r9, r10)
                if (r0 == r4) goto L45
            L23:
                java.lang.String r0 = "**."
                boolean r0 = kotlin.l0.o.Q(r12, r0, r1, r2, r3)
                if (r0 == 0) goto L38
                r7 = 2
                r8 = 0
                r9 = 4
                r10 = 0
                java.lang.String r6 = "*"
                r5 = r12
                int r0 = kotlin.l0.o.i0(r5, r6, r7, r8, r9, r10)
                if (r0 == r4) goto L45
            L38:
                r7 = 0
                r8 = 0
                r9 = 6
                r10 = 0
                java.lang.String r6 = "*"
                r5 = r12
                int r0 = kotlin.l0.o.i0(r5, r6, r7, r8, r9, r10)
                if (r0 != r4) goto L47
            L45:
                r0 = 1
                goto L48
            L47:
                r0 = r1
            L48:
                if (r0 == 0) goto Lc2
                java.lang.String r0 = okhttp3.internal.HostnamesKt.toCanonicalHost(r12)
                if (r0 == 0) goto Lab
                java.lang.String r12 = "sha1/"
                boolean r4 = kotlin.l0.o.Q(r13, r12, r1, r2, r3)
                java.lang.String r5 = "(this as java.lang.String).substring(startIndex)"
                if (r4 == 0) goto L73
                j.i$a r1 = j.i.f17151b
                r2 = 5
                java.lang.String r13 = r13.substring(r2)
                kotlin.jvm.internal.m.d(r13, r5)
                j.i r13 = r1.a(r13)
                if (r13 != 0) goto L6d
                kotlin.jvm.internal.m.q()
            L6d:
                okhttp3.CertificatePinner$Pin r1 = new okhttp3.CertificatePinner$Pin
                r1.<init>(r0, r12, r13)
                goto L93
            L73:
                java.lang.String r12 = "sha256/"
                boolean r1 = kotlin.l0.o.Q(r13, r12, r1, r2, r3)
                if (r1 == 0) goto L94
                j.i$a r1 = j.i.f17151b
                r2 = 7
                java.lang.String r13 = r13.substring(r2)
                kotlin.jvm.internal.m.d(r13, r5)
                j.i r13 = r1.a(r13)
                if (r13 != 0) goto L8e
                kotlin.jvm.internal.m.q()
            L8e:
                okhttp3.CertificatePinner$Pin r1 = new okhttp3.CertificatePinner$Pin
                r1.<init>(r0, r12, r13)
            L93:
                return r1
            L94:
                java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "pins must start with 'sha256/' or 'sha1/': "
                r0.append(r1)
                r0.append(r13)
                java.lang.String r13 = r0.toString()
                r12.<init>(r13)
                throw r12
            Lab:
                java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Invalid pattern: "
                r0.append(r1)
                r0.append(r12)
                java.lang.String r12 = r0.toString()
                r13.<init>(r12)
                throw r13
            Lc2:
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                java.lang.String r0 = "Unexpected pattern: "
                r13.append(r0)
                r13.append(r12)
                java.lang.String r12 = r13.toString()
                java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
                java.lang.String r12 = r12.toString()
                r13.<init>(r12)
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CertificatePinner.Companion.newPin$okhttp(java.lang.String, java.lang.String):okhttp3.CertificatePinner$Pin");
        }

        public final String pin(Certificate certificate) {
            m.h(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return "sha256/" + toSha256ByteString$okhttp((X509Certificate) certificate).h();
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        public final i toSha1ByteString$okhttp(X509Certificate toSha1ByteString) {
            m.h(toSha1ByteString, "$this$toSha1ByteString");
            i.a aVar = i.f17151b;
            PublicKey publicKey = toSha1ByteString.getPublicKey();
            m.d(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            m.d(encoded, "publicKey.encoded");
            return i.a.g(aVar, encoded, 0, 0, 3, null).O();
        }

        public final i toSha256ByteString$okhttp(X509Certificate toSha256ByteString) {
            m.h(toSha256ByteString, "$this$toSha256ByteString");
            i.a aVar = i.f17151b;
            PublicKey publicKey = toSha256ByteString.getPublicKey();
            m.d(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            m.d(encoded, "publicKey.encoded");
            return i.a.g(aVar, encoded, 0, 0, 3, null).P();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CertificatePinner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001a\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lokhttp3/CertificatePinner$Pin;", "", "", "component1", "()Ljava/lang/String;", "hostname", "", "matches", "(Ljava/lang/String;)Z", "toString", "component2", "Lj/i;", "component3", "()Lj/i;", "pattern", "hashAlgorithm", "hash", "copy", "(Ljava/lang/String;Ljava/lang/String;Lj/i;)Lokhttp3/CertificatePinner$Pin;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lj/i;", "getHash", "Ljava/lang/String;", "getHashAlgorithm", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Pin {
        private final i hash;
        private final String hashAlgorithm;
        private final String pattern;

        public Pin(String pattern, String hashAlgorithm, i hash) {
            m.h(pattern, "pattern");
            m.h(hashAlgorithm, "hashAlgorithm");
            m.h(hash, "hash");
            this.pattern = pattern;
            this.hashAlgorithm = hashAlgorithm;
            this.hash = hash;
        }

        private final String component1() {
            return this.pattern;
        }

        public static /* synthetic */ Pin copy$default(Pin pin, String str, String str2, i iVar, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = pin.pattern;
            }
            if ((i2 & 2) != 0) {
                str2 = pin.hashAlgorithm;
            }
            if ((i2 & 4) != 0) {
                iVar = pin.hash;
            }
            return pin.copy(str, str2, iVar);
        }

        public final String component2() {
            return this.hashAlgorithm;
        }

        public final i component3() {
            return this.hash;
        }

        public final Pin copy(String pattern, String hashAlgorithm, i hash) {
            m.h(pattern, "pattern");
            m.h(hashAlgorithm, "hashAlgorithm");
            m.h(hash, "hash");
            return new Pin(pattern, hashAlgorithm, hash);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Pin) {
                    Pin pin = (Pin) obj;
                    return m.c(this.pattern, pin.pattern) && m.c(this.hashAlgorithm, pin.hashAlgorithm) && m.c(this.hash, pin.hash);
                }
                return false;
            }
            return true;
        }

        public final i getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public int hashCode() {
            String str = this.pattern;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.hashAlgorithm;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            i iVar = this.hash;
            return hashCode2 + (iVar != null ? iVar.hashCode() : 0);
        }

        public final boolean matches(String hostname) {
            boolean Q;
            boolean Q2;
            boolean F;
            int m0;
            boolean F2;
            m.h(hostname, "hostname");
            Q = x.Q(this.pattern, "**.", false, 2, null);
            if (Q) {
                int length = this.pattern.length() - 3;
                int length2 = hostname.length() - length;
                F2 = x.F(hostname, hostname.length() - length, this.pattern, 3, length, false, 16, null);
                if (!F2) {
                    return false;
                }
                if (length2 != 0 && hostname.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else {
                Q2 = x.Q(this.pattern, "*.", false, 2, null);
                if (Q2) {
                    int length3 = this.pattern.length() - 1;
                    int length4 = hostname.length() - length3;
                    F = x.F(hostname, hostname.length() - length3, this.pattern, 1, length3, false, 16, null);
                    if (!F) {
                        return false;
                    }
                    m0 = y.m0(hostname, '.', length4 - 1, false, 4, null);
                    if (m0 != -1) {
                        return false;
                    }
                } else {
                    return m.c(hostname, this.pattern);
                }
            }
            return true;
        }

        public String toString() {
            return this.hashAlgorithm + this.hash.h();
        }
    }

    public CertificatePinner(Set<Pin> pins, CertificateChainCleaner certificateChainCleaner) {
        m.h(pins, "pins");
        this.pins = pins;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }

    public final void check(String hostname, List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        m.h(hostname, "hostname");
        m.h(peerCertificates, "peerCertificates");
        check$okhttp(hostname, new CertificatePinner$check$1(this, peerCertificates, hostname));
    }

    public final void check$okhttp(String hostname, a<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) {
        m.h(hostname, "hostname");
        m.h(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<Pin> findMatchingPins$okhttp = findMatchingPins$okhttp(hostname);
        if (findMatchingPins$okhttp.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> invoke = cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : invoke) {
            i iVar = null;
            i iVar2 = null;
            for (Pin pin : findMatchingPins$okhttp) {
                String hashAlgorithm = pin.getHashAlgorithm();
                int hashCode = hashAlgorithm.hashCode();
                if (hashCode != 109397962) {
                    if (hashCode == 2052263656 && hashAlgorithm.equals("sha256/")) {
                        if (iVar2 == null) {
                            iVar2 = Companion.toSha256ByteString$okhttp(x509Certificate);
                        }
                        if (m.c(pin.getHash(), iVar2)) {
                            return;
                        }
                    }
                    throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                } else if (hashAlgorithm.equals("sha1/")) {
                    if (iVar == null) {
                        iVar = Companion.toSha1ByteString$okhttp(x509Certificate);
                    }
                    if (m.c(pin.getHash(), iVar)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : invoke) {
            sb.append("\n    ");
            sb.append(Companion.pin(x509Certificate2));
            sb.append(": ");
            Principal subjectDN = x509Certificate2.getSubjectDN();
            m.d(subjectDN, "element.subjectDN");
            sb.append(subjectDN.getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(hostname);
        sb.append(":");
        for (Pin pin2 : findMatchingPins$okhttp) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        String sb2 = sb.toString();
        m.d(sb2, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(sb2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (m.c(certificatePinner.pins, this.pins) && m.c(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    public final List<Pin> findMatchingPins$okhttp(String hostname) {
        List<Pin> g2;
        m.h(hostname, "hostname");
        g2 = r.g();
        for (Pin pin : this.pins) {
            if (pin.matches(hostname)) {
                if (g2.isEmpty()) {
                    g2 = new ArrayList<>();
                }
                i0.c(g2).add(pin);
            }
        }
        return g2;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public int hashCode() {
        int hashCode = (1517 + this.pins.hashCode()) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return hashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        return m.c(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public final void check(String hostname, Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        List<? extends Certificate> e0;
        m.h(hostname, "hostname");
        m.h(peerCertificates, "peerCertificates");
        e0 = n.e0(peerCertificates);
        check(hostname, e0);
    }
}