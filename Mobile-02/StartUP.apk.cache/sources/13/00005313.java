package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.l0.x;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KPackageImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/Class;", "invoke", "()Ljava/lang/Class;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KPackageImpl$Data$multifileFacade$2 extends o implements a<Class<?>> {
    final /* synthetic */ KPackageImpl.Data this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPackageImpl$Data$multifileFacade$2(KPackageImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final Class<?> invoke() {
        ReflectKotlinClass kotlinClass;
        String J;
        KotlinClassHeader classHeader;
        kotlinClass = this.this$0.getKotlinClass();
        String multifileClassName = (kotlinClass == null || (classHeader = kotlinClass.getClassHeader()) == null) ? null : classHeader.getMultifileClassName();
        if (multifileClassName != null) {
            if (multifileClassName.length() > 0) {
                ClassLoader classLoader = KPackageImpl.this.getJClass().getClassLoader();
                J = x.J(multifileClassName, '/', '.', false, 4, null);
                return classLoader.loadClass(J);
            }
            return null;
        }
        return null;
    }
}