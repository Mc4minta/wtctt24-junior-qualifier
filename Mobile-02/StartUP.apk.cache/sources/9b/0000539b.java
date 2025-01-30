package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum UBYTE uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: UnsignedType.kt */
/* loaded from: classes3.dex */
public final class UnsignedType {
    private static final /* synthetic */ UnsignedType[] $VALUES;
    public static final UnsignedType UBYTE;
    public static final UnsignedType UINT;
    public static final UnsignedType ULONG;
    public static final UnsignedType USHORT;
    private final ClassId arrayClassId;
    private final ClassId classId;
    private final Name typeName;

    static {
        ClassId fromString = ClassId.fromString("kotlin/UByte");
        m.f(fromString, "fromString(\"kotlin/UByte\")");
        UnsignedType unsignedType = new UnsignedType("UBYTE", 0, fromString);
        UBYTE = unsignedType;
        ClassId fromString2 = ClassId.fromString("kotlin/UShort");
        m.f(fromString2, "fromString(\"kotlin/UShort\")");
        UnsignedType unsignedType2 = new UnsignedType("USHORT", 1, fromString2);
        USHORT = unsignedType2;
        ClassId fromString3 = ClassId.fromString("kotlin/UInt");
        m.f(fromString3, "fromString(\"kotlin/UInt\")");
        UnsignedType unsignedType3 = new UnsignedType("UINT", 2, fromString3);
        UINT = unsignedType3;
        ClassId fromString4 = ClassId.fromString("kotlin/ULong");
        m.f(fromString4, "fromString(\"kotlin/ULong\")");
        UnsignedType unsignedType4 = new UnsignedType("ULONG", 3, fromString4);
        ULONG = unsignedType4;
        $VALUES = new UnsignedType[]{unsignedType, unsignedType2, unsignedType3, unsignedType4};
    }

    private UnsignedType(String str, int i2, ClassId classId) {
        this.classId = classId;
        Name shortClassName = classId.getShortClassName();
        m.f(shortClassName, "classId.shortClassName");
        this.typeName = shortClassName;
        this.arrayClassId = new ClassId(classId.getPackageFqName(), Name.identifier(m.o(shortClassName.asString(), "Array")));
    }

    public static UnsignedType valueOf(String value) {
        m.g(value, "value");
        return (UnsignedType) Enum.valueOf(UnsignedType.class, value);
    }

    public static UnsignedType[] values() {
        UnsignedType[] unsignedTypeArr = $VALUES;
        UnsignedType[] unsignedTypeArr2 = new UnsignedType[unsignedTypeArr.length];
        System.arraycopy(unsignedTypeArr, 0, unsignedTypeArr2, 0, unsignedTypeArr.length);
        return unsignedTypeArr2;
    }

    public final ClassId getArrayClassId() {
        return this.arrayClassId;
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}