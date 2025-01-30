package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CapturedTypeApproximation.kt */
/* loaded from: classes3.dex */
public final class CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1 extends o implements l<UnwrappedType, Boolean> {
    public static final CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1 INSTANCE = new CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1();

    CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final Boolean invoke(UnwrappedType it) {
        m.f(it, "it");
        return Boolean.valueOf(CapturedTypeConstructorKt.isCaptured(it));
    }
}