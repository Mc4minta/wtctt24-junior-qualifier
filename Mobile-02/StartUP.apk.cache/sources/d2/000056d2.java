package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* compiled from: TypeTable.kt */
/* loaded from: classes3.dex */
public final class TypeTable {
    private final List<ProtoBuf.Type> types;

    public TypeTable(ProtoBuf.TypeTable typeTable) {
        int r;
        m.g(typeTable, "typeTable");
        List<ProtoBuf.Type> typeList = typeTable.getTypeList();
        if (typeTable.hasFirstNullable()) {
            int firstNullable = typeTable.getFirstNullable();
            List<ProtoBuf.Type> typeList2 = typeTable.getTypeList();
            m.f(typeList2, "typeTable.typeList");
            r = s.r(typeList2, 10);
            ArrayList arrayList = new ArrayList(r);
            int i2 = 0;
            for (Object obj : typeList2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    r.q();
                }
                ProtoBuf.Type type = (ProtoBuf.Type) obj;
                if (i2 >= firstNullable) {
                    type = type.toBuilder().setNullable(true).build();
                }
                arrayList.add(type);
                i2 = i3;
            }
            typeList = arrayList;
        }
        m.f(typeList, "run {\n        val originalTypes = typeTable.typeList\n        if (typeTable.hasFirstNullable()) {\n            val firstNullable = typeTable.firstNullable\n            typeTable.typeList.mapIndexed { i, type ->\n                if (i >= firstNullable) {\n                    type.toBuilder().setNullable(true).build()\n                } else type\n            }\n        } else originalTypes\n    }");
        this.types = typeList;
    }

    public final ProtoBuf.Type get(int i2) {
        return this.types.get(i2);
    }
}