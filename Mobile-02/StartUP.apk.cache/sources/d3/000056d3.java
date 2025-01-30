package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.apache.http.message.TokenParser;

/* compiled from: VersionRequirement.kt */
/* loaded from: classes3.dex */
public final class VersionRequirement {
    public static final Companion Companion = new Companion(null);
    private final Integer errorCode;
    private final ProtoBuf.VersionRequirement.VersionKind kind;
    private final a level;
    private final String message;
    private final Version version;

    /* compiled from: VersionRequirement.kt */
    /* loaded from: classes3.dex */
    public static final class Version {
        public static final Companion Companion = new Companion(null);
        public static final Version INFINITY = new Version(256, 256, 256);
        private final int major;
        private final int minor;
        private final int patch;

        /* compiled from: VersionRequirement.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Version decode(Integer num, Integer num2) {
                if (num2 != null) {
                    return new Version(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255);
                }
                if (num != null) {
                    return new Version(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & 127);
                }
                return Version.INFINITY;
            }
        }

        public Version(int i2, int i3, int i4) {
            this.major = i2;
            this.minor = i3;
            this.patch = i4;
        }

        public final String asString() {
            StringBuilder sb;
            int i2;
            if (this.patch == 0) {
                sb = new StringBuilder();
                sb.append(this.major);
                sb.append('.');
                i2 = this.minor;
            } else {
                sb = new StringBuilder();
                sb.append(this.major);
                sb.append('.');
                sb.append(this.minor);
                sb.append('.');
                i2 = this.patch;
            }
            sb.append(i2);
            return sb.toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Version) {
                Version version = (Version) obj;
                return this.major == version.major && this.minor == version.minor && this.patch == version.patch;
            }
            return false;
        }

        public int hashCode() {
            return (((this.major * 31) + this.minor) * 31) + this.patch;
        }

        public String toString() {
            return asString();
        }

        public /* synthetic */ Version(int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(i2, i3, (i5 & 4) != 0 ? 0 : i4);
        }
    }

    public VersionRequirement(Version version, ProtoBuf.VersionRequirement.VersionKind kind, a level, Integer num, String str) {
        m.g(version, "version");
        m.g(kind, "kind");
        m.g(level, "level");
        this.version = version;
        this.kind = kind;
        this.level = level;
        this.errorCode = num;
        this.message = str;
    }

    public final ProtoBuf.VersionRequirement.VersionKind getKind() {
        return this.kind;
    }

    public final Version getVersion() {
        return this.version;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("since ");
        sb.append(this.version);
        sb.append(TokenParser.SP);
        sb.append(this.level);
        Integer num = this.errorCode;
        sb.append(num != null ? m.o(" error ", num) : "");
        String str = this.message;
        sb.append(str != null ? m.o(": ", str) : "");
        return sb.toString();
    }

    /* compiled from: VersionRequirement.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* compiled from: VersionRequirement.kt */
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ProtoBuf.VersionRequirement.Level.values().length];
                iArr[ProtoBuf.VersionRequirement.Level.WARNING.ordinal()] = 1;
                iArr[ProtoBuf.VersionRequirement.Level.ERROR.ordinal()] = 2;
                iArr[ProtoBuf.VersionRequirement.Level.HIDDEN.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<VersionRequirement> create(MessageLite proto, NameResolver nameResolver, VersionRequirementTable table) {
            List<Integer> ids;
            m.g(proto, "proto");
            m.g(nameResolver, "nameResolver");
            m.g(table, "table");
            if (proto instanceof ProtoBuf.Class) {
                ids = ((ProtoBuf.Class) proto).getVersionRequirementList();
            } else if (proto instanceof ProtoBuf.Constructor) {
                ids = ((ProtoBuf.Constructor) proto).getVersionRequirementList();
            } else if (proto instanceof ProtoBuf.Function) {
                ids = ((ProtoBuf.Function) proto).getVersionRequirementList();
            } else if (proto instanceof ProtoBuf.Property) {
                ids = ((ProtoBuf.Property) proto).getVersionRequirementList();
            } else if (!(proto instanceof ProtoBuf.TypeAlias)) {
                throw new IllegalStateException(m.o("Unexpected declaration: ", proto.getClass()));
            } else {
                ids = ((ProtoBuf.TypeAlias) proto).getVersionRequirementList();
            }
            m.f(ids, "ids");
            ArrayList arrayList = new ArrayList();
            for (Integer id : ids) {
                m.f(id, "id");
                VersionRequirement create = create(id.intValue(), nameResolver, table);
                if (create != null) {
                    arrayList.add(create);
                }
            }
            return arrayList;
        }

        public final VersionRequirement create(int i2, NameResolver nameResolver, VersionRequirementTable table) {
            a aVar;
            m.g(nameResolver, "nameResolver");
            m.g(table, "table");
            ProtoBuf.VersionRequirement versionRequirement = table.get(i2);
            if (versionRequirement == null) {
                return null;
            }
            Version decode = Version.Companion.decode(versionRequirement.hasVersion() ? Integer.valueOf(versionRequirement.getVersion()) : null, versionRequirement.hasVersionFull() ? Integer.valueOf(versionRequirement.getVersionFull()) : null);
            ProtoBuf.VersionRequirement.Level level = versionRequirement.getLevel();
            m.e(level);
            int i3 = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
            if (i3 == 1) {
                aVar = a.WARNING;
            } else if (i3 == 2) {
                aVar = a.ERROR;
            } else if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                aVar = a.HIDDEN;
            }
            a aVar2 = aVar;
            Integer valueOf = versionRequirement.hasErrorCode() ? Integer.valueOf(versionRequirement.getErrorCode()) : null;
            String string = versionRequirement.hasMessage() ? nameResolver.getString(versionRequirement.getMessage()) : null;
            ProtoBuf.VersionRequirement.VersionKind versionKind = versionRequirement.getVersionKind();
            m.f(versionKind, "info.versionKind");
            return new VersionRequirement(decode, versionKind, aVar2, valueOf, string);
        }
    }
}