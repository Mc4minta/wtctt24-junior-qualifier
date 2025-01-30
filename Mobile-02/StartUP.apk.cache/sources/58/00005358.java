package kotlin.reflect.jvm.internal.calls;

import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: AnnotationConstructorCaller.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "T", "", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
final class AnnotationConstructorCallerKt$createAnnotationInstance$toString$2 extends o implements a<String> {
    final /* synthetic */ Class $annotationClass;
    final /* synthetic */ Map $values;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(Class cls, Map map) {
        super(0);
        this.$annotationClass = cls;
        this.$values = map;
    }

    @Override // kotlin.e0.c.a
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        sb.append(this.$annotationClass.getCanonicalName());
        z.f0(this.$values.entrySet(), sb, ", ", "(", ")", 0, null, AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1.INSTANCE, 48, null);
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}