package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.s;
import kotlin.e0.c.a;
import kotlin.j0.g;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: KClassImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003 \u0004*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/j0/g;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KClassImpl$Data$constructors$2<T> extends o implements a<List<? extends g<? extends T>>> {
    final /* synthetic */ KClassImpl.Data this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$constructors$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // kotlin.e0.c.a
    public final List<g<T>> invoke() {
        int r;
        Collection<ConstructorDescriptor> constructorDescriptors = KClassImpl.this.getConstructorDescriptors();
        r = s.r(constructorDescriptors, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ConstructorDescriptor constructorDescriptor : constructorDescriptors) {
            arrayList.add(new KFunctionImpl(KClassImpl.this, constructorDescriptor));
        }
        return arrayList;
    }
}