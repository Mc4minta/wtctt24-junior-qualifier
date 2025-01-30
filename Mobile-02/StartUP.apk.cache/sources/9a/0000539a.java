package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum UBYTEARRAY uses external variables
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
public final class UnsignedArrayType {
    private static final /* synthetic */ UnsignedArrayType[] $VALUES;
    public static final UnsignedArrayType UBYTEARRAY;
    public static final UnsignedArrayType UINTARRAY;
    public static final UnsignedArrayType ULONGARRAY;
    public static final UnsignedArrayType USHORTARRAY;
    private final ClassId classId;
    private final Name typeName;

    static {
        ClassId fromString = ClassId.fromString("kotlin/UByteArray");
        m.f(fromString, "fromString(\"kotlin/UByteArray\")");
        UnsignedArrayType unsignedArrayType = new UnsignedArrayType("UBYTEARRAY", 0, fromString);
        UBYTEARRAY = unsignedArrayType;
        ClassId fromString2 = ClassId.fromString("kotlin/UShortArray");
        m.f(fromString2, "fromString(\"kotlin/UShortArray\")");
        UnsignedArrayType unsignedArrayType2 = new UnsignedArrayType("USHORTARRAY", 1, fromString2);
        USHORTARRAY = unsignedArrayType2;
        ClassId fromString3 = ClassId.fromString("kotlin/UIntArray");
        m.f(fromString3, "fromString(\"kotlin/UIntArray\")");
        UnsignedArrayType unsignedArrayType3 = new UnsignedArrayType("UINTARRAY", 2, fromString3);
        UINTARRAY = unsignedArrayType3;
        ClassId fromString4 = ClassId.fromString("kotlin/ULongArray");
        m.f(fromString4, "fromString(\"kotlin/ULongArray\")");
        UnsignedArrayType unsignedArrayType4 = new UnsignedArrayType("ULONGARRAY", 3, fromString4);
        ULONGARRAY = unsignedArrayType4;
        $VALUES = new UnsignedArrayType[]{unsignedArrayType, unsignedArrayType2, unsignedArrayType3, unsignedArrayType4};
    }

    private UnsignedArrayType(String str, int i2, ClassId classId) {
        this.classId = classId;
        Name shortClassName = classId.getShortClassName();
        m.f(shortClassName, "classId.shortClassName");
        this.typeName = shortClassName;
    }

    public static UnsignedArrayType valueOf(String value) {
        m.g(value, "value");
        return (UnsignedArrayType) Enum.valueOf(UnsignedArrayType.class, value);
    }

    public static UnsignedArrayType[] values() {
        UnsignedArrayType[] unsignedArrayTypeArr = $VALUES;
        UnsignedArrayType[] unsignedArrayTypeArr2 = new UnsignedArrayType[unsignedArrayTypeArr.length];
        System.arraycopy(unsignedArrayTypeArr, 0, unsignedArrayTypeArr2, 0, unsignedArrayTypeArr.length);
        return unsignedArrayTypeArr2;
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}