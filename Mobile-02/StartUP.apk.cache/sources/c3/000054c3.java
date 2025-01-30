package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Field;
import kotlin.e0.c.l;
import kotlin.j0.f;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReflectJavaClass.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class ReflectJavaClass$fields$2 extends j implements l<Field, ReflectJavaField> {
    public static final ReflectJavaClass$fields$2 INSTANCE = new ReflectJavaClass$fields$2();

    ReflectJavaClass$fields$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.c, kotlin.j0.c
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.c
    public final f getOwner() {
        return e0.b(ReflectJavaField.class);
    }

    @Override // kotlin.jvm.internal.c
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Field;)V";
    }

    @Override // kotlin.e0.c.l
    public final ReflectJavaField invoke(Field p0) {
        m.g(p0, "p0");
        return new ReflectJavaField(p0);
    }
}