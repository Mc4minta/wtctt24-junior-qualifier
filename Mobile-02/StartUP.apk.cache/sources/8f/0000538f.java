package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.a0.s0;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: PrimitiveType.kt */
/* loaded from: classes3.dex */
public enum PrimitiveType {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");
    
    public static final Companion Companion;
    public static final Set<PrimitiveType> NUMBER_TYPES;
    private final h arrayTypeFqName$delegate;
    private final Name arrayTypeName;
    private final h typeFqName$delegate;
    private final Name typeName;

    /* compiled from: PrimitiveType.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Set<PrimitiveType> e2;
        PrimitiveType primitiveType = CHAR;
        PrimitiveType primitiveType2 = BYTE;
        PrimitiveType primitiveType3 = SHORT;
        PrimitiveType primitiveType4 = INT;
        PrimitiveType primitiveType5 = FLOAT;
        PrimitiveType primitiveType6 = LONG;
        PrimitiveType primitiveType7 = DOUBLE;
        Companion = new Companion(null);
        e2 = s0.e(primitiveType, primitiveType2, primitiveType3, primitiveType4, primitiveType5, primitiveType6, primitiveType7);
        NUMBER_TYPES = e2;
    }

    PrimitiveType(String str) {
        h a;
        h a2;
        Name identifier = Name.identifier(str);
        m.f(identifier, "identifier(typeName)");
        this.typeName = identifier;
        Name identifier2 = Name.identifier(m.o(str, "Array"));
        m.f(identifier2, "identifier(\"${typeName}Array\")");
        this.arrayTypeName = identifier2;
        kotlin.m mVar = kotlin.m.PUBLICATION;
        a = k.a(mVar, new PrimitiveType$typeFqName$2(this));
        this.typeFqName$delegate = a;
        a2 = k.a(mVar, new PrimitiveType$arrayTypeFqName$2(this));
        this.arrayTypeFqName$delegate = a2;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static PrimitiveType[] valuesCustom() {
        PrimitiveType[] valuesCustom = values();
        PrimitiveType[] primitiveTypeArr = new PrimitiveType[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, primitiveTypeArr, 0, valuesCustom.length);
        return primitiveTypeArr;
    }

    public final FqName getArrayTypeFqName() {
        return (FqName) this.arrayTypeFqName$delegate.getValue();
    }

    public final Name getArrayTypeName() {
        return this.arrayTypeName;
    }

    public final FqName getTypeFqName() {
        return (FqName) this.typeFqName$delegate.getValue();
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}