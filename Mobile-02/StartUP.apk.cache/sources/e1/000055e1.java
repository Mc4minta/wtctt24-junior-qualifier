package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import kotlin.x;

/* compiled from: predefinedEnhancementInfo.kt */
/* loaded from: classes3.dex */
final class PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$9 extends o implements l<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, x> {
    final /* synthetic */ String $JFBiFunction;
    final /* synthetic */ String $JLObject;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$9(String str, String str2) {
        super(1);
        this.$JLObject = str;
        this.$JFBiFunction = str2;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        invoke2(functionEnhancementBuilder);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        JavaTypeQualifiers javaTypeQualifiers;
        JavaTypeQualifiers javaTypeQualifiers2;
        JavaTypeQualifiers javaTypeQualifiers3;
        JavaTypeQualifiers javaTypeQualifiers4;
        JavaTypeQualifiers javaTypeQualifiers5;
        JavaTypeQualifiers javaTypeQualifiers6;
        JavaTypeQualifiers javaTypeQualifiers7;
        m.g(functionEnhancementBuilder, "<this>");
        String str = this.$JLObject;
        javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
        functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
        String str2 = this.$JLObject;
        javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
        functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2);
        String str3 = this.$JFBiFunction;
        javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
        javaTypeQualifiers4 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
        javaTypeQualifiers5 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
        javaTypeQualifiers6 = PredefinedEnhancementInfoKt.NULLABLE;
        functionEnhancementBuilder.parameter(str3, javaTypeQualifiers3, javaTypeQualifiers4, javaTypeQualifiers5, javaTypeQualifiers6);
        String str4 = this.$JLObject;
        javaTypeQualifiers7 = PredefinedEnhancementInfoKt.NULLABLE;
        functionEnhancementBuilder.returns(str4, javaTypeQualifiers7);
    }
}