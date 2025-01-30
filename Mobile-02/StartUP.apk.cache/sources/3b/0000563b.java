package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a0.l0;
import kotlin.a0.r;
import kotlin.i0.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmBytecodeBinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;

/* compiled from: KotlinClassHeader.kt */
/* loaded from: classes3.dex */
public final class KotlinClassHeader {
    private final JvmBytecodeBinaryVersion bytecodeVersion;
    private final String[] data;
    private final int extraInt;
    private final String extraString;
    private final String[] incompatibleData;
    private final Kind kind;
    private final JvmMetadataVersion metadataVersion;
    private final String packageName;
    private final String[] strings;

    /* compiled from: KotlinClassHeader.kt */
    /* loaded from: classes3.dex */
    public enum Kind {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        public static final Companion Companion = new Companion(null);
        private static final Map<Integer, Kind> entryById;
        private final int id;

        /* compiled from: KotlinClassHeader.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Kind getById(int i2) {
                Kind kind = (Kind) Kind.entryById.get(Integer.valueOf(i2));
                return kind == null ? Kind.UNKNOWN : kind;
            }
        }

        static {
            int d2;
            int b2;
            Kind[] valuesCustom = valuesCustom();
            d2 = l0.d(valuesCustom.length);
            b2 = f.b(d2, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
            for (Kind kind : valuesCustom) {
                linkedHashMap.put(Integer.valueOf(kind.getId()), kind);
            }
            entryById = linkedHashMap;
        }

        Kind(int i2) {
            this.id = i2;
        }

        public static final Kind getById(int i2) {
            return Companion.getById(i2);
        }

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Kind[] valuesCustom() {
            Kind[] valuesCustom = values();
            Kind[] kindArr = new Kind[valuesCustom.length];
            System.arraycopy(valuesCustom, 0, kindArr, 0, valuesCustom.length);
            return kindArr;
        }

        public final int getId() {
            return this.id;
        }
    }

    public KotlinClassHeader(Kind kind, JvmMetadataVersion metadataVersion, JvmBytecodeBinaryVersion bytecodeVersion, String[] strArr, String[] strArr2, String[] strArr3, String str, int i2, String str2) {
        m.g(kind, "kind");
        m.g(metadataVersion, "metadataVersion");
        m.g(bytecodeVersion, "bytecodeVersion");
        this.kind = kind;
        this.metadataVersion = metadataVersion;
        this.bytecodeVersion = bytecodeVersion;
        this.data = strArr;
        this.incompatibleData = strArr2;
        this.strings = strArr3;
        this.extraString = str;
        this.extraInt = i2;
        this.packageName = str2;
    }

    private final boolean has(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public final String[] getData() {
        return this.data;
    }

    public final String[] getIncompatibleData() {
        return this.incompatibleData;
    }

    public final Kind getKind() {
        return this.kind;
    }

    public final JvmMetadataVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    public final String getMultifileClassName() {
        String str = this.extraString;
        if (getKind() == Kind.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final List<String> getMultifilePartNames() {
        List<String> g2;
        String[] strArr = this.data;
        if (!(getKind() == Kind.MULTIFILE_CLASS)) {
            strArr = null;
        }
        List<String> c2 = strArr != null ? kotlin.a0.m.c(strArr) : null;
        if (c2 != null) {
            return c2;
        }
        g2 = r.g();
        return g2;
    }

    public final String[] getStrings() {
        return this.strings;
    }

    public final boolean isPreRelease() {
        return has(this.extraInt, 2);
    }

    public final boolean isUnstableFirBinary() {
        return has(this.extraInt, 64) && !has(this.extraInt, 32);
    }

    public final boolean isUnstableJvmIrBinary() {
        return has(this.extraInt, 16) && !has(this.extraInt, 32);
    }

    public String toString() {
        return this.kind + " version=" + this.metadataVersion;
    }
}