package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;

/* compiled from: KPropertyImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0001*\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\b\"$\u0010\f\u001a\u0004\u0018\u00010\t*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00008@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "isGetter", "Lkotlin/reflect/jvm/internal/calls/Caller;", "computeCallerForAccessor", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;Z)Lkotlin/reflect/jvm/internal/calls/Caller;", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "isJvmFieldPropertyInCompanionObject", "(Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;)Z", "", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "boundReceiver", "kotlin-reflection"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KPropertyImplKt {
    public static final /* synthetic */ Caller access$computeCallerForAccessor(KPropertyImpl.Accessor accessor, boolean z) {
        return computeCallerForAccessor(accessor, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.reflect.jvm.internal.calls.Caller<?> computeCallerForAccessor(kotlin.reflect.jvm.internal.KPropertyImpl.Accessor<?, ?> r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KPropertyImplKt.computeCallerForAccessor(kotlin.reflect.jvm.internal.KPropertyImpl$Accessor, boolean):kotlin.reflect.jvm.internal.calls.Caller");
    }

    public static final Object getBoundReceiver(KPropertyImpl.Accessor<?, ?> boundReceiver) {
        m.g(boundReceiver, "$this$boundReceiver");
        return boundReceiver.getProperty().getBoundReceiver();
    }

    public static final boolean isJvmFieldPropertyInCompanionObject(PropertyDescriptor propertyDescriptor) {
        DeclarationDescriptor containingDeclaration = propertyDescriptor.getContainingDeclaration();
        m.f(containingDeclaration, "containingDeclaration");
        if (DescriptorUtils.isCompanionObject(containingDeclaration)) {
            DeclarationDescriptor containingDeclaration2 = containingDeclaration.getContainingDeclaration();
            return !(DescriptorUtils.isInterface(containingDeclaration2) || DescriptorUtils.isAnnotationClass(containingDeclaration2)) || ((propertyDescriptor instanceof DeserializedPropertyDescriptor) && JvmProtoBufUtil.isMovedFromInterfaceCompanion(((DeserializedPropertyDescriptor) propertyDescriptor).getProto()));
        }
        return false;
    }
}