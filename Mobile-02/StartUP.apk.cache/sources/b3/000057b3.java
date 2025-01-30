package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: CapturedTypeConstructor.kt */
/* loaded from: classes3.dex */
final class CapturedTypeConstructorKt$createCapturedIfNeeded$1 extends o implements a<KotlinType> {
    final /* synthetic */ TypeProjection $this_createCapturedIfNeeded;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturedTypeConstructorKt$createCapturedIfNeeded$1(TypeProjection typeProjection) {
        super(0);
        this.$this_createCapturedIfNeeded = typeProjection;
    }

    @Override // kotlin.e0.c.a
    public final KotlinType invoke() {
        KotlinType type = this.$this_createCapturedIfNeeded.getType();
        m.f(type, "this@createCapturedIfNeeded.type");
        return type;
    }
}