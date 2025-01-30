package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* compiled from: VersionRequirement.kt */
/* loaded from: classes3.dex */
public final class VersionRequirementTable {
    public static final Companion Companion = new Companion(null);
    private static final VersionRequirementTable EMPTY;
    private final List<ProtoBuf.VersionRequirement> infos;

    /* compiled from: VersionRequirement.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VersionRequirementTable create(ProtoBuf.VersionRequirementTable table) {
            m.g(table, "table");
            if (table.getRequirementCount() == 0) {
                return getEMPTY();
            }
            List<ProtoBuf.VersionRequirement> requirementList = table.getRequirementList();
            m.f(requirementList, "table.requirementList");
            return new VersionRequirementTable(requirementList, null);
        }

        public final VersionRequirementTable getEMPTY() {
            return VersionRequirementTable.EMPTY;
        }
    }

    static {
        List g2;
        g2 = r.g();
        EMPTY = new VersionRequirementTable(g2);
    }

    private VersionRequirementTable(List<ProtoBuf.VersionRequirement> list) {
        this.infos = list;
    }

    public /* synthetic */ VersionRequirementTable(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    public final ProtoBuf.VersionRequirement get(int i2) {
        return (ProtoBuf.VersionRequirement) p.b0(this.infos, i2);
    }
}