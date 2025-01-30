package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.calls.CallerImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KPropertyImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/reflect/Field;", "field", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "invoke", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "computeFieldCaller"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KPropertyImplKt$computeCallerForAccessor$3 extends o implements l<Field, CallerImpl<? extends Field>> {
    final /* synthetic */ boolean $isGetter;
    final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$1 $isJvmStaticProperty$1;
    final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$2 $isNotNullProperty$2;
    final /* synthetic */ KPropertyImpl.Accessor $this_computeCallerForAccessor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPropertyImplKt$computeCallerForAccessor$3(KPropertyImpl.Accessor accessor, boolean z, KPropertyImplKt$computeCallerForAccessor$2 kPropertyImplKt$computeCallerForAccessor$2, KPropertyImplKt$computeCallerForAccessor$1 kPropertyImplKt$computeCallerForAccessor$1) {
        super(1);
        this.$this_computeCallerForAccessor = accessor;
        this.$isGetter = z;
        this.$isNotNullProperty$2 = kPropertyImplKt$computeCallerForAccessor$2;
        this.$isJvmStaticProperty$1 = kPropertyImplKt$computeCallerForAccessor$1;
    }

    @Override // kotlin.e0.c.l
    public final CallerImpl<Field> invoke(Field field) {
        boolean isJvmFieldPropertyInCompanionObject;
        m.g(field, "field");
        isJvmFieldPropertyInCompanionObject = KPropertyImplKt.isJvmFieldPropertyInCompanionObject(this.$this_computeCallerForAccessor.getProperty().getDescriptor());
        return (isJvmFieldPropertyInCompanionObject || !Modifier.isStatic(field.getModifiers())) ? this.$isGetter ? this.$this_computeCallerForAccessor.isBound() ? new CallerImpl.FieldGetter.BoundInstance(field, KPropertyImplKt.getBoundReceiver(this.$this_computeCallerForAccessor)) : new CallerImpl.FieldGetter.Instance(field) : this.$this_computeCallerForAccessor.isBound() ? new CallerImpl.FieldSetter.BoundInstance(field, this.$isNotNullProperty$2.invoke2(), KPropertyImplKt.getBoundReceiver(this.$this_computeCallerForAccessor)) : new CallerImpl.FieldSetter.Instance(field, this.$isNotNullProperty$2.invoke2()) : this.$isJvmStaticProperty$1.invoke2() ? this.$isGetter ? this.$this_computeCallerForAccessor.isBound() ? new CallerImpl.FieldGetter.BoundJvmStaticInObject(field) : new CallerImpl.FieldGetter.JvmStaticInObject(field) : this.$this_computeCallerForAccessor.isBound() ? new CallerImpl.FieldSetter.BoundJvmStaticInObject(field, this.$isNotNullProperty$2.invoke2()) : new CallerImpl.FieldSetter.JvmStaticInObject(field, this.$isNotNullProperty$2.invoke2()) : this.$isGetter ? new CallerImpl.FieldGetter.Static(field) : new CallerImpl.FieldSetter.Static(field, this.$isNotNullProperty$2.invoke2());
    }
}