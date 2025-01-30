package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KCallableImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "invoke", "()Lkotlin/reflect/jvm/internal/KTypeImpl;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KCallableImpl$_returnType$1 extends o implements a<KTypeImpl> {
    final /* synthetic */ KCallableImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KCallableImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Ljava/lang/reflect/Type;", "invoke", "()Ljava/lang/reflect/Type;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    /* renamed from: kotlin.reflect.jvm.internal.KCallableImpl$_returnType$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends o implements a<Type> {
        AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final Type invoke() {
            Type extractContinuationArgument;
            extractContinuationArgument = KCallableImpl$_returnType$1.this.this$0.extractContinuationArgument();
            return extractContinuationArgument != null ? extractContinuationArgument : KCallableImpl$_returnType$1.this.this$0.getCaller().getReturnType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KCallableImpl$_returnType$1(KCallableImpl kCallableImpl) {
        super(0);
        this.this$0 = kCallableImpl;
    }

    @Override // kotlin.e0.c.a
    public final KTypeImpl invoke() {
        KotlinType returnType = this.this$0.getDescriptor().getReturnType();
        m.e(returnType);
        m.f(returnType, "descriptor.returnType!!");
        return new KTypeImpl(returnType, new AnonymousClass1());
    }
}