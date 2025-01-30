package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.a0.n;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;

/* compiled from: signatureEnhancement.kt */
/* loaded from: classes3.dex */
final class SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1 extends o implements l<Integer, JavaTypeQualifiers> {
    final /* synthetic */ JavaTypeQualifiers[] $computedResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1(JavaTypeQualifiers[] javaTypeQualifiersArr) {
        super(1);
        this.$computedResult = javaTypeQualifiersArr;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ JavaTypeQualifiers invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final JavaTypeQualifiers invoke(int i2) {
        int B;
        JavaTypeQualifiers[] javaTypeQualifiersArr = this.$computedResult;
        if (i2 >= 0) {
            B = n.B(javaTypeQualifiersArr);
            if (i2 <= B) {
                return javaTypeQualifiersArr[i2];
            }
        }
        return JavaTypeQualifiers.Companion.getNONE();
    }
}