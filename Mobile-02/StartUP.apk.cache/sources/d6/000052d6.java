package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.v;
import kotlin.b0.b;
import kotlin.e0.c.a;
import kotlin.j0.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KCallableImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "Ljava/util/ArrayList;", "Lkotlin/j0/l;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/ArrayList;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KCallableImpl$_parameters$1 extends o implements a<ArrayList<l>> {
    final /* synthetic */ KCallableImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KCallableImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "invoke", "()Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    /* renamed from: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends o implements a<ParameterDescriptor> {
        final /* synthetic */ ReceiverParameterDescriptor $instanceReceiver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ReceiverParameterDescriptor receiverParameterDescriptor) {
            super(0);
            this.$instanceReceiver = receiverParameterDescriptor;
        }

        @Override // kotlin.e0.c.a
        public final ParameterDescriptor invoke() {
            return this.$instanceReceiver;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KCallableImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "invoke", "()Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    /* renamed from: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends o implements a<ParameterDescriptor> {
        final /* synthetic */ ReceiverParameterDescriptor $extensionReceiver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ReceiverParameterDescriptor receiverParameterDescriptor) {
            super(0);
            this.$extensionReceiver = receiverParameterDescriptor;
        }

        @Override // kotlin.e0.c.a
        public final ParameterDescriptor invoke() {
            return this.$extensionReceiver;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KCallableImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "invoke", "()Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    /* renamed from: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends o implements a<ParameterDescriptor> {
        final /* synthetic */ CallableMemberDescriptor $descriptor;
        final /* synthetic */ int $i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(CallableMemberDescriptor callableMemberDescriptor, int i2) {
            super(0);
            this.$descriptor = callableMemberDescriptor;
            this.$i = i2;
        }

        @Override // kotlin.e0.c.a
        public final ParameterDescriptor invoke() {
            ValueParameterDescriptor valueParameterDescriptor = this.$descriptor.getValueParameters().get(this.$i);
            m.f(valueParameterDescriptor, "descriptor.valueParameters[i]");
            return valueParameterDescriptor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KCallableImpl$_parameters$1(KCallableImpl kCallableImpl) {
        super(0);
        this.this$0 = kCallableImpl;
    }

    @Override // kotlin.e0.c.a
    public final ArrayList<l> invoke() {
        int i2;
        CallableMemberDescriptor descriptor = this.this$0.getDescriptor();
        ArrayList<l> arrayList = new ArrayList<>();
        int i3 = 0;
        if (this.this$0.isBound()) {
            i2 = 0;
        } else {
            ReceiverParameterDescriptor instanceReceiverParameter = UtilKt.getInstanceReceiverParameter(descriptor);
            if (instanceReceiverParameter != null) {
                arrayList.add(new KParameterImpl(this.this$0, 0, l.a.INSTANCE, new AnonymousClass1(instanceReceiverParameter)));
                i2 = 1;
            } else {
                i2 = 0;
            }
            ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
            if (extensionReceiverParameter != null) {
                arrayList.add(new KParameterImpl(this.this$0, i2, l.a.EXTENSION_RECEIVER, new AnonymousClass2(extensionReceiverParameter)));
                i2++;
            }
        }
        List<ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
        m.f(valueParameters, "descriptor.valueParameters");
        int size = valueParameters.size();
        while (i3 < size) {
            arrayList.add(new KParameterImpl(this.this$0, i2, l.a.VALUE, new AnonymousClass3(descriptor, i3)));
            i3++;
            i2++;
        }
        if (this.this$0.isAnnotationConstructor() && (descriptor instanceof JavaCallableMemberDescriptor) && arrayList.size() > 1) {
            v.x(arrayList, new Comparator<T>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1$$special$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int c2;
                    c2 = b.c(((l) t).getName(), ((l) t2).getName());
                    return c2;
                }
            });
        }
        arrayList.trimToSize();
        return arrayList;
    }
}