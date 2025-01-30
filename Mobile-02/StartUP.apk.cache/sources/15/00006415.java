package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.security.spec.ECGenParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;

/* loaded from: classes3.dex */
class ECUtils {
    ECUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static X9ECParameters getDomainParametersFromGenSpec(ECGenParameterSpec eCGenParameterSpec) {
        return getDomainParametersFromName(eCGenParameterSpec.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v6, types: [org.spongycastle.asn1.x9.X9ECParameters] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static X9ECParameters getDomainParametersFromName(String str) {
        try {
            if (str.charAt(0) >= '0' && str.charAt(0) <= '2') {
                str = ECUtil.getNamedCurveByOid(new ASN1ObjectIdentifier(str));
            } else if (str.indexOf(32) > 0) {
                str = ECUtil.getNamedCurveByName(str.substring(str.indexOf(32) + 1));
            } else {
                str = ECUtil.getNamedCurveByName(str);
            }
            return str;
        } catch (IllegalArgumentException unused) {
            return ECUtil.getNamedCurveByName(str);
        }
    }
}