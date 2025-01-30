package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KParameterImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KParameterImpl$annotations$2 extends o implements a<List<? extends Annotation>> {
    final /* synthetic */ KParameterImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KParameterImpl$annotations$2(KParameterImpl kParameterImpl) {
        super(0);
        this.this$0 = kParameterImpl;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends Annotation> invoke() {
        ParameterDescriptor descriptor;
        descriptor = this.this$0.getDescriptor();
        return UtilKt.computeAnnotations(descriptor);
    }
}