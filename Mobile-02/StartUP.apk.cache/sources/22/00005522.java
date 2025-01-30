package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.a0.l0;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: classes3.dex */
public final class JavaDeprecatedAnnotationDescriptor$allValueArguments$2 extends o implements a<Map<Name, ? extends StringValue>> {
    public static final JavaDeprecatedAnnotationDescriptor$allValueArguments$2 INSTANCE = new JavaDeprecatedAnnotationDescriptor$allValueArguments$2();

    JavaDeprecatedAnnotationDescriptor$allValueArguments$2() {
        super(0);
    }

    @Override // kotlin.e0.c.a
    public final Map<Name, ? extends StringValue> invoke() {
        Map<Name, ? extends StringValue> e2;
        e2 = l0.e(u.a(JavaAnnotationMapper.INSTANCE.getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm(), new StringValue("Deprecated in Java")));
        return e2;
    }
}