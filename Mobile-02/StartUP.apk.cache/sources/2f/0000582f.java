package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.a0.s;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedPackageFragmentImpl.kt */
/* loaded from: classes3.dex */
final class DeserializedPackageFragmentImpl$initialize$1 extends o implements a<Collection<? extends Name>> {
    final /* synthetic */ DeserializedPackageFragmentImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl$initialize$1(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
        super(0);
        this.this$0 = deserializedPackageFragmentImpl;
    }

    @Override // kotlin.e0.c.a
    public final Collection<? extends Name> invoke() {
        int r;
        Collection<ClassId> allClassIds = this.this$0.getClassDataFinder().getAllClassIds();
        ArrayList<ClassId> arrayList = new ArrayList();
        for (Object obj : allClassIds) {
            ClassId classId = (ClassId) obj;
            if ((classId.isNestedClass() || ClassDeserializer.Companion.getBLACK_LIST().contains(classId)) ? false : true) {
                arrayList.add(obj);
            }
        }
        r = s.r(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(r);
        for (ClassId classId2 : arrayList) {
            arrayList2.add(classId2.getShortClassName());
        }
        return arrayList2;
    }
}