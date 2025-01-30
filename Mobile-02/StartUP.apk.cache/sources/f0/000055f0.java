package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.e0.c.l;
import kotlin.jvm.internal.o;

/* compiled from: signatureEnhancement.kt */
/* loaded from: classes3.dex */
final class SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1 extends o implements l<Integer, JavaTypeQualifiers> {
    final /* synthetic */ TypeEnhancementInfo $predefined;
    final /* synthetic */ l<Integer, JavaTypeQualifiers> $qualifiers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1(TypeEnhancementInfo typeEnhancementInfo, l<? super Integer, JavaTypeQualifiers> lVar) {
        super(1);
        this.$predefined = typeEnhancementInfo;
        this.$qualifiers = lVar;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ JavaTypeQualifiers invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final JavaTypeQualifiers invoke(int i2) {
        JavaTypeQualifiers javaTypeQualifiers = this.$predefined.getMap().get(Integer.valueOf(i2));
        return javaTypeQualifiers == null ? this.$qualifiers.invoke(Integer.valueOf(i2)) : javaTypeQualifiers;
    }
}