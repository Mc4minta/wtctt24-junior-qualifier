package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KClassImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KClassImpl$Data$supertypes$2 extends o implements a<List<? extends KTypeImpl>> {
    final /* synthetic */ KClassImpl.Data this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KClassImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "T", "Ljava/lang/reflect/Type;", "invoke", "()Ljava/lang/reflect/Type;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    /* renamed from: kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends o implements a<Type> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final Type invoke() {
            return Object.class;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$supertypes$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends KTypeImpl> invoke() {
        boolean z;
        TypeConstructor typeConstructor = this.this$0.getDescriptor().getTypeConstructor();
        m.f(typeConstructor, "descriptor.typeConstructor");
        Collection<KotlinType> mo2215getSupertypes = typeConstructor.mo2215getSupertypes();
        m.f(mo2215getSupertypes, "descriptor.typeConstructor.supertypes");
        ArrayList<KTypeImpl> arrayList = new ArrayList(mo2215getSupertypes.size());
        for (KotlinType kotlinType : mo2215getSupertypes) {
            m.f(kotlinType, "kotlinType");
            arrayList.add(new KTypeImpl(kotlinType, new KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1(kotlinType, this)));
        }
        if (!KotlinBuiltIns.isSpecialClassWithNoSupertypes(this.this$0.getDescriptor())) {
            boolean z2 = false;
            if (!arrayList.isEmpty()) {
                for (KTypeImpl kTypeImpl : arrayList) {
                    ClassDescriptor classDescriptorForType = DescriptorUtils.getClassDescriptorForType(kTypeImpl.getType());
                    m.f(classDescriptorForType, "DescriptorUtils.getClassDescriptorForType(it.type)");
                    ClassKind kind = classDescriptorForType.getKind();
                    m.f(kind, "DescriptorUtils.getClass…ptorForType(it.type).kind");
                    if (kind == ClassKind.INTERFACE || kind == ClassKind.ANNOTATION_CLASS) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        break;
                    }
                }
            }
            z2 = true;
            if (z2) {
                SimpleType anyType = DescriptorUtilsKt.getBuiltIns(this.this$0.getDescriptor()).getAnyType();
                m.f(anyType, "descriptor.builtIns.anyType");
                arrayList.add(new KTypeImpl(anyType, AnonymousClass3.INSTANCE));
            }
        }
        return CollectionsKt.compact(arrayList);
    }
}