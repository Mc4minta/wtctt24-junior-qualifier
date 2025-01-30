package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.LinkedList;
import java.util.List;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.t;

/* compiled from: NameResolverImpl.kt */
/* loaded from: classes3.dex */
public final class NameResolverImpl implements NameResolver {
    private final ProtoBuf.QualifiedNameTable qualifiedNames;
    private final ProtoBuf.StringTable strings;

    /* compiled from: NameResolverImpl.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NameResolverImpl(ProtoBuf.StringTable strings, ProtoBuf.QualifiedNameTable qualifiedNames) {
        m.g(strings, "strings");
        m.g(qualifiedNames, "qualifiedNames");
        this.strings = strings;
        this.qualifiedNames = qualifiedNames;
    }

    private final t<List<String>, List<String>, Boolean> traverseIds(int i2) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i2 != -1) {
            ProtoBuf.QualifiedNameTable.QualifiedName qualifiedName = this.qualifiedNames.getQualifiedName(i2);
            String string = this.strings.getString(qualifiedName.getShortName());
            ProtoBuf.QualifiedNameTable.QualifiedName.Kind kind = qualifiedName.getKind();
            m.e(kind);
            int i3 = WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
            if (i3 == 1) {
                linkedList2.addFirst(string);
            } else if (i3 == 2) {
                linkedList.addFirst(string);
            } else if (i3 == 3) {
                linkedList2.addFirst(string);
                z = true;
            }
            i2 = qualifiedName.getParentQualifiedName();
        }
        return new t<>(linkedList, linkedList2, Boolean.valueOf(z));
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int i2) {
        String h0;
        String h02;
        t<List<String>, List<String>, Boolean> traverseIds = traverseIds(i2);
        List<String> a = traverseIds.a();
        h0 = z.h0(traverseIds.b(), ".", null, null, 0, null, null, 62, null);
        if (a.isEmpty()) {
            return h0;
        }
        StringBuilder sb = new StringBuilder();
        h02 = z.h0(a, "/", null, null, 0, null, null, 62, null);
        sb.append(h02);
        sb.append('/');
        sb.append(h0);
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int i2) {
        String string = this.strings.getString(i2);
        m.f(string, "strings.getString(index)");
        return string;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i2) {
        return traverseIds(i2).f().booleanValue();
    }
}