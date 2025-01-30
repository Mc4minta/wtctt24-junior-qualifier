package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.a0.l0;
import kotlin.a0.s;
import kotlin.e0.c.a;
import kotlin.i0.f;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaClassMemberScope.kt */
/* loaded from: classes3.dex */
public final class LazyJavaClassMemberScope$enumEntryIndex$1 extends o implements a<Map<Name, ? extends JavaField>> {
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$enumEntryIndex$1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(0);
        this.this$0 = lazyJavaClassMemberScope;
    }

    @Override // kotlin.e0.c.a
    public final Map<Name, ? extends JavaField> invoke() {
        JavaClass javaClass;
        int r;
        int d2;
        int b2;
        javaClass = this.this$0.jClass;
        Collection<JavaField> fields = javaClass.getFields();
        ArrayList arrayList = new ArrayList();
        for (Object obj : fields) {
            if (((JavaField) obj).isEnumEntry()) {
                arrayList.add(obj);
            }
        }
        r = s.r(arrayList, 10);
        d2 = l0.d(r);
        b2 = f.b(d2, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
        for (Object obj2 : arrayList) {
            linkedHashMap.put(((JavaField) obj2).getName(), obj2);
        }
        return linkedHashMap;
    }
}