package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.e0.c.a;
import kotlin.e0.c.l;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.spongycastle.asn1.eac.EACTags;
import org.spongycastle.crypto.tls.CipherSuite;

/* loaded from: classes3.dex */
public abstract class KotlinBuiltIns {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Name BUILTINS_MODULE_NAME = Name.special("<built-ins module>");
    private final MemoizedFunctionToNotNull<Name, ClassDescriptor> builtInClassesByName;
    private final NotNullLazyValue<Collection<PackageViewDescriptor>> builtInPackagesImportedByDefault;
    private ModuleDescriptorImpl builtInsModule;
    private final NotNullLazyValue<Primitives> primitives;
    private final StorageManager storageManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Primitives {
        public final Map<SimpleType, SimpleType> kotlinArrayTypeToPrimitiveKotlinType;
        public final Map<KotlinType, SimpleType> primitiveKotlinTypeToKotlinArrayType;
        public final Map<PrimitiveType, SimpleType> primitiveTypeToArrayKotlinType;

        private static /* synthetic */ void $$$reportNull$$$0(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1) {
                objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
            } else if (i2 != 2) {
                objArr[0] = "primitiveTypeToArrayKotlinType";
            } else {
                objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private Primitives(Map<PrimitiveType, SimpleType> map, Map<KotlinType, SimpleType> map2, Map<SimpleType, SimpleType> map3) {
            if (map == null) {
                $$$reportNull$$$0(0);
            }
            if (map2 == null) {
                $$$reportNull$$$0(1);
            }
            if (map3 == null) {
                $$$reportNull$$$0(2);
            }
            this.primitiveTypeToArrayKotlinType = map;
            this.primitiveKotlinTypeToKotlinArrayType = map2;
            this.kotlinArrayTypeToPrimitiveKotlinType = map3;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                i3 = 2;
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 71:
                objArr[0] = "module";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 8:
            case 9:
            case 75:
            case 76:
            case 88:
            case 95:
            case 102:
            case 106:
            case 107:
            case CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA /* 144 */:
            case CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA /* 145 */:
            case CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA /* 147 */:
            case CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA /* 155 */:
            case CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256 /* 156 */:
            case CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384 /* 157 */:
                objArr[0] = "descriptor";
                break;
            case 11:
            case 97:
            case 99:
            case 101:
            case 103:
            case 105:
            case CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA /* 134 */:
                objArr[0] = "fqName";
                break;
            case 13:
                objArr[0] = "simpleName";
                break;
            case 15:
            case 16:
            case 52:
            case 87:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 96:
            case 98:
            case 104:
            case 108:
            case 109:
            case 110:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case EACTags.SECURE_MESSAGING_TEMPLATE /* 125 */:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA /* 132 */:
            case CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA /* 133 */:
            case CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA /* 135 */:
            case CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA /* 136 */:
            case CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA /* 137 */:
            case CipherSuite.TLS_PSK_WITH_RC4_128_SHA /* 138 */:
            case CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA /* 139 */:
            case CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA /* 140 */:
            case CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA /* 141 */:
            case CipherSuite.TLS_DHE_PSK_WITH_RC4_128_SHA /* 142 */:
            case CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA /* 143 */:
            case CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA /* 146 */:
            case CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA /* 148 */:
            case CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA /* 149 */:
            case CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA /* 150 */:
            case CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA /* 151 */:
            case CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA /* 152 */:
            case CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA /* 153 */:
            case CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA /* 154 */:
            case CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 /* 159 */:
                objArr[0] = "type";
                break;
            case 45:
                objArr[0] = "classSimpleName";
                break;
            case 66:
                objArr[0] = "arrayType";
                break;
            case 70:
                objArr[0] = "notNullArrayType";
                break;
            case 72:
                objArr[0] = "primitiveType";
                break;
            case 74:
                objArr[0] = "kotlinType";
                break;
            case 77:
            case 81:
                objArr[0] = "projectionType";
                break;
            case 78:
            case 82:
            case 84:
                objArr[0] = "argument";
                break;
            case 79:
                objArr[0] = "annotations";
                break;
            case 100:
                objArr[0] = "typeConstructor";
                break;
            case 111:
                objArr[0] = "classDescriptor";
                break;
            case CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 /* 158 */:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i2) {
            case 2:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 3:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 4:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 5:
                objArr[1] = "getStorageManager";
                break;
            case 6:
                objArr[1] = "getBuiltInsModule";
                break;
            case 7:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 10:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 12:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 17:
                objArr[1] = "getSuspendFunction";
                break;
            case 18:
                objArr[1] = "getKFunction";
                break;
            case 19:
                objArr[1] = "getKSuspendFunction";
                break;
            case 20:
                objArr[1] = "getKClass";
                break;
            case 21:
                objArr[1] = "getKCallable";
                break;
            case 22:
                objArr[1] = "getKProperty";
                break;
            case 23:
                objArr[1] = "getKProperty0";
                break;
            case 24:
                objArr[1] = "getKProperty1";
                break;
            case 25:
                objArr[1] = "getKProperty2";
                break;
            case 26:
                objArr[1] = "getKMutableProperty0";
                break;
            case 27:
                objArr[1] = "getKMutableProperty1";
                break;
            case 28:
                objArr[1] = "getKMutableProperty2";
                break;
            case 29:
                objArr[1] = "getIterator";
                break;
            case 30:
                objArr[1] = "getIterable";
                break;
            case 31:
                objArr[1] = "getMutableIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterator";
                break;
            case 33:
                objArr[1] = "getCollection";
                break;
            case 34:
                objArr[1] = "getMutableCollection";
                break;
            case 35:
                objArr[1] = "getList";
                break;
            case 36:
                objArr[1] = "getMutableList";
                break;
            case 37:
                objArr[1] = "getSet";
                break;
            case 38:
                objArr[1] = "getMutableSet";
                break;
            case 39:
                objArr[1] = "getMap";
                break;
            case 40:
                objArr[1] = "getMutableMap";
                break;
            case 41:
                objArr[1] = "getMapEntry";
                break;
            case 42:
                objArr[1] = "getMutableMapEntry";
                break;
            case 43:
                objArr[1] = "getListIterator";
                break;
            case 44:
                objArr[1] = "getMutableListIterator";
                break;
            case 46:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 47:
                objArr[1] = "getNothingType";
                break;
            case 48:
                objArr[1] = "getNullableNothingType";
                break;
            case 49:
                objArr[1] = "getAnyType";
                break;
            case 50:
                objArr[1] = "getNullableAnyType";
                break;
            case 51:
                objArr[1] = "getDefaultBound";
                break;
            case 53:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 54:
                objArr[1] = "getNumberType";
                break;
            case 55:
                objArr[1] = "getByteType";
                break;
            case 56:
                objArr[1] = "getShortType";
                break;
            case 57:
                objArr[1] = "getIntType";
                break;
            case 58:
                objArr[1] = "getLongType";
                break;
            case 59:
                objArr[1] = "getFloatType";
                break;
            case 60:
                objArr[1] = "getDoubleType";
                break;
            case 61:
                objArr[1] = "getCharType";
                break;
            case 62:
                objArr[1] = "getBooleanType";
                break;
            case 63:
                objArr[1] = "getUnitType";
                break;
            case 64:
                objArr[1] = "getStringType";
                break;
            case 65:
                objArr[1] = "getIterableType";
                break;
            case 67:
            case 68:
            case 69:
                objArr[1] = "getArrayElementType";
                break;
            case 73:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 80:
            case 83:
                objArr[1] = "getArrayType";
                break;
            case 85:
                objArr[1] = "getEnumType";
                break;
            case 86:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                break;
            case 8:
                objArr[2] = "isBuiltIn";
                break;
            case 9:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 11:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 13:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 15:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 16:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 45:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 52:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 66:
                objArr[2] = "getArrayElementType";
                break;
            case 70:
            case 71:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 72:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 74:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 75:
            case 92:
                objArr[2] = "getPrimitiveType";
                break;
            case 76:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
                objArr[2] = "getArrayType";
                break;
            case 84:
                objArr[2] = "getEnumType";
                break;
            case 87:
                objArr[2] = "isArray";
                break;
            case 88:
            case 89:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 90:
                objArr[2] = "isPrimitiveArray";
                break;
            case 91:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 93:
                objArr[2] = "isPrimitiveType";
                break;
            case 94:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveClass";
                break;
            case 96:
            case 97:
            case 98:
            case 99:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 100:
            case 101:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 102:
            case 103:
                objArr[2] = "classFqNameEquals";
                break;
            case 104:
            case 105:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 106:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 107:
            case 108:
                objArr[2] = "isAny";
                break;
            case 109:
            case 111:
                objArr[2] = "isBoolean";
                break;
            case 110:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 112:
                objArr[2] = "isNumber";
                break;
            case 113:
                objArr[2] = "isChar";
                break;
            case 114:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 115:
                objArr[2] = "isInt";
                break;
            case 116:
                objArr[2] = "isByte";
                break;
            case 117:
                objArr[2] = "isLong";
                break;
            case 118:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 119:
                objArr[2] = "isShort";
                break;
            case 120:
                objArr[2] = "isFloat";
                break;
            case 121:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 122:
                objArr[2] = "isDouble";
                break;
            case 123:
                objArr[2] = "isUByte";
                break;
            case 124:
                objArr[2] = "isUShort";
                break;
            case EACTags.SECURE_MESSAGING_TEMPLATE /* 125 */:
                objArr[2] = "isUInt";
                break;
            case 126:
                objArr[2] = "isULong";
                break;
            case 127:
                objArr[2] = "isUByteArray";
                break;
            case 128:
                objArr[2] = "isUShortArray";
                break;
            case 129:
                objArr[2] = "isUIntArray";
                break;
            case 130:
                objArr[2] = "isULongArray";
                break;
            case 131:
                objArr[2] = "isUnsignedArrayType";
                break;
            case CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA /* 132 */:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA /* 133 */:
            case CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA /* 134 */:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA /* 135 */:
                objArr[2] = "isNothing";
                break;
            case CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA /* 136 */:
                objArr[2] = "isNullableNothing";
                break;
            case CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA /* 137 */:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case CipherSuite.TLS_PSK_WITH_RC4_128_SHA /* 138 */:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA /* 139 */:
                objArr[2] = "isNullableAny";
                break;
            case CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA /* 140 */:
                objArr[2] = "isDefaultBound";
                break;
            case CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA /* 141 */:
                objArr[2] = "isUnit";
                break;
            case CipherSuite.TLS_DHE_PSK_WITH_RC4_128_SHA /* 142 */:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA /* 143 */:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA /* 144 */:
                objArr[2] = "isMemberOfAny";
                break;
            case CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA /* 145 */:
            case CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA /* 146 */:
                objArr[2] = "isEnum";
                break;
            case CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA /* 147 */:
            case CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA /* 148 */:
                objArr[2] = "isComparable";
                break;
            case CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA /* 149 */:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA /* 150 */:
                objArr[2] = "isListOrNullableList";
                break;
            case CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA /* 151 */:
                objArr[2] = "isSetOrNullableSet";
                break;
            case CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA /* 152 */:
                objArr[2] = "isMapOrNullableMap";
                break;
            case CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA /* 153 */:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA /* 154 */:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA /* 155 */:
                objArr[2] = "isKClass";
                break;
            case CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256 /* 156 */:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384 /* 157 */:
                objArr[2] = "isCloneable";
                break;
            case CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 /* 158 */:
                objArr[2] = "isDeprecated";
                break;
            case CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 /* 159 */:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                throw new IllegalStateException(format);
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public KotlinBuiltIns(StorageManager storageManager) {
        if (storageManager == null) {
            $$$reportNull$$$0(0);
        }
        this.storageManager = storageManager;
        this.builtInPackagesImportedByDefault = storageManager.createLazyValue(new a<Collection<PackageViewDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.1
            @Override // kotlin.e0.c.a
            public Collection<PackageViewDescriptor> invoke() {
                return Arrays.asList(KotlinBuiltIns.this.builtInsModule.getPackage(StandardNames.BUILT_INS_PACKAGE_FQ_NAME), KotlinBuiltIns.this.builtInsModule.getPackage(StandardNames.COLLECTIONS_PACKAGE_FQ_NAME), KotlinBuiltIns.this.builtInsModule.getPackage(StandardNames.RANGES_PACKAGE_FQ_NAME), KotlinBuiltIns.this.builtInsModule.getPackage(StandardNames.ANNOTATION_PACKAGE_FQ_NAME));
            }
        });
        this.primitives = storageManager.createLazyValue(new a<Primitives>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.2
            @Override // kotlin.e0.c.a
            public Primitives invoke() {
                PrimitiveType[] valuesCustom;
                EnumMap enumMap = new EnumMap(PrimitiveType.class);
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                for (PrimitiveType primitiveType : PrimitiveType.valuesCustom()) {
                    SimpleType builtInTypeByClassName = KotlinBuiltIns.this.getBuiltInTypeByClassName(primitiveType.getTypeName().asString());
                    SimpleType builtInTypeByClassName2 = KotlinBuiltIns.this.getBuiltInTypeByClassName(primitiveType.getArrayTypeName().asString());
                    enumMap.put((EnumMap) primitiveType, (PrimitiveType) builtInTypeByClassName2);
                    hashMap.put(builtInTypeByClassName, builtInTypeByClassName2);
                    hashMap2.put(builtInTypeByClassName2, builtInTypeByClassName);
                }
                return new Primitives(enumMap, hashMap, hashMap2);
            }
        });
        this.builtInClassesByName = storageManager.createMemoizedFunction(new l<Name, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.3
            @Override // kotlin.e0.c.l
            public ClassDescriptor invoke(Name name) {
                ClassifierDescriptor mo2216getContributedClassifier = KotlinBuiltIns.this.getBuiltInsPackageScope().mo2216getContributedClassifier(name, NoLookupLocation.FROM_BUILTINS);
                if (mo2216getContributedClassifier != null) {
                    if (mo2216getContributedClassifier instanceof ClassDescriptor) {
                        return (ClassDescriptor) mo2216getContributedClassifier;
                    }
                    throw new AssertionError("Must be a class descriptor " + name + ", but was " + mo2216getContributedClassifier);
                }
                throw new AssertionError("Built-in class " + StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(name) + " is not found");
            }
        });
    }

    private static boolean classFqNameEquals(ClassifierDescriptor classifierDescriptor, FqNameUnsafe fqNameUnsafe) {
        if (classifierDescriptor == null) {
            $$$reportNull$$$0(102);
        }
        if (fqNameUnsafe == null) {
            $$$reportNull$$$0(103);
        }
        return classifierDescriptor.getName().equals(fqNameUnsafe.shortName()) && fqNameUnsafe.equals(DescriptorUtils.getFqName(classifierDescriptor));
    }

    private ClassDescriptor getBuiltInClassByName(String str) {
        if (str == null) {
            $$$reportNull$$$0(13);
        }
        ClassDescriptor invoke = this.builtInClassesByName.invoke(Name.identifier(str));
        if (invoke == null) {
            $$$reportNull$$$0(14);
        }
        return invoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SimpleType getBuiltInTypeByClassName(String str) {
        if (str == null) {
            $$$reportNull$$$0(45);
        }
        SimpleType defaultType = getBuiltInClassByName(str).getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(46);
        }
        return defaultType;
    }

    private static KotlinType getElementTypeForUnsignedArray(KotlinType kotlinType, ModuleDescriptor moduleDescriptor) {
        ClassId classId;
        ClassId unsignedClassIdByArrayClassId;
        ClassDescriptor findClassAcrossModuleDependencies;
        if (kotlinType == null) {
            $$$reportNull$$$0(70);
        }
        if (moduleDescriptor == null) {
            $$$reportNull$$$0(71);
        }
        ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
        if (mo2214getDeclarationDescriptor == null) {
            return null;
        }
        UnsignedTypes unsignedTypes = UnsignedTypes.INSTANCE;
        if (!unsignedTypes.isShortNameOfUnsignedArray(mo2214getDeclarationDescriptor.getName()) || (classId = DescriptorUtilsKt.getClassId(mo2214getDeclarationDescriptor)) == null || (unsignedClassIdByArrayClassId = unsignedTypes.getUnsignedClassIdByArrayClassId(classId)) == null || (findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, unsignedClassIdByArrayClassId)) == null) {
            return null;
        }
        return findClassAcrossModuleDependencies.getDefaultType();
    }

    public static PrimitiveType getPrimitiveArrayType(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(76);
        }
        if (StandardNames.FqNames.primitiveArrayTypeShortNames.contains(declarationDescriptor.getName())) {
            return StandardNames.FqNames.arrayClassFqNameToPrimitiveType.get(DescriptorUtils.getFqName(declarationDescriptor));
        }
        return null;
    }

    private ClassDescriptor getPrimitiveClassDescriptor(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            $$$reportNull$$$0(15);
        }
        return getBuiltInClassByName(primitiveType.getTypeName().asString());
    }

    public static PrimitiveType getPrimitiveType(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(75);
        }
        if (StandardNames.FqNames.primitiveTypeShortNames.contains(declarationDescriptor.getName())) {
            return StandardNames.FqNames.fqNameToPrimitiveType.get(DescriptorUtils.getFqName(declarationDescriptor));
        }
        return null;
    }

    public static boolean isAny(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(107);
        }
        return classFqNameEquals(classDescriptor, StandardNames.FqNames.any);
    }

    public static boolean isAnyOrNullableAny(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(CipherSuite.TLS_PSK_WITH_RC4_128_SHA);
        }
        return isConstructedFromGivenClass(kotlinType, StandardNames.FqNames.any);
    }

    public static boolean isArray(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(87);
        }
        return isConstructedFromGivenClass(kotlinType, StandardNames.FqNames.array);
    }

    public static boolean isArrayOrPrimitiveArray(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(88);
        }
        return classFqNameEquals(classDescriptor, StandardNames.FqNames.array) || getPrimitiveArrayType(classDescriptor) != null;
    }

    public static boolean isBoolean(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(109);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, StandardNames.FqNames._boolean);
    }

    public static boolean isBuiltIn(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(8);
        }
        return DescriptorUtils.getParentOfType(declarationDescriptor, BuiltInsPackageFragment.class, false) != null;
    }

    public static boolean isByte(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(116);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, StandardNames.FqNames._byte);
    }

    public static boolean isChar(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(113);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, StandardNames.FqNames._char);
    }

    private static boolean isConstructedFromGivenClass(KotlinType kotlinType, FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            $$$reportNull$$$0(96);
        }
        if (fqNameUnsafe == null) {
            $$$reportNull$$$0(97);
        }
        return isTypeConstructorForGivenClass(kotlinType.getConstructor(), fqNameUnsafe);
    }

    private static boolean isConstructedFromGivenClassAndNotNullable(KotlinType kotlinType, FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            $$$reportNull$$$0(CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA);
        }
        if (fqNameUnsafe == null) {
            $$$reportNull$$$0(CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA);
        }
        return isConstructedFromGivenClass(kotlinType, fqNameUnsafe) && !kotlinType.isMarkedNullable();
    }

    public static boolean isDefaultBound(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA);
        }
        return isNullableAny(kotlinType);
    }

    public static boolean isDeprecated(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256);
        }
        if (declarationDescriptor.getOriginal().getAnnotations().hasAnnotation(StandardNames.FqNames.deprecated)) {
            return true;
        }
        if (declarationDescriptor instanceof PropertyDescriptor) {
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) declarationDescriptor;
            boolean isVar = propertyDescriptor.isVar();
            PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
            PropertySetterDescriptor setter = propertyDescriptor.getSetter();
            if (getter != null && isDeprecated(getter)) {
                if (!isVar) {
                    return true;
                }
                if (setter != null && isDeprecated(setter)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean isDouble(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(122);
        }
        return isDoubleOrNullableDouble(kotlinType) && !kotlinType.isMarkedNullable();
    }

    public static boolean isDoubleOrNullableDouble(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA);
        }
        return isConstructedFromGivenClass(kotlinType, StandardNames.FqNames._double);
    }

    public static boolean isFloat(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(120);
        }
        return isFloatOrNullableFloat(kotlinType) && !kotlinType.isMarkedNullable();
    }

    public static boolean isFloatOrNullableFloat(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(121);
        }
        return isConstructedFromGivenClass(kotlinType, StandardNames.FqNames._float);
    }

    public static boolean isInt(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(115);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, StandardNames.FqNames._int);
    }

    public static boolean isKClass(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA);
        }
        return classFqNameEquals(classDescriptor, StandardNames.FqNames.kClass);
    }

    public static boolean isLong(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(117);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, StandardNames.FqNames._long);
    }

    private static boolean isNotNullConstructedFromGivenClass(KotlinType kotlinType, FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            $$$reportNull$$$0(104);
        }
        if (fqNameUnsafe == null) {
            $$$reportNull$$$0(105);
        }
        return !kotlinType.isMarkedNullable() && isConstructedFromGivenClass(kotlinType, fqNameUnsafe);
    }

    public static boolean isNothing(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA);
        }
        return isNothingOrNullableNothing(kotlinType) && !TypeUtils.isNullableType(kotlinType);
    }

    public static boolean isNothingOrNullableNothing(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA);
        }
        return isConstructedFromGivenClass(kotlinType, StandardNames.FqNames.nothing);
    }

    public static boolean isNullableAny(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA);
        }
        return isAnyOrNullableAny(kotlinType) && kotlinType.isMarkedNullable();
    }

    public static boolean isPrimitiveArray(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(90);
        }
        ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
        return (mo2214getDeclarationDescriptor == null || getPrimitiveArrayType(mo2214getDeclarationDescriptor) == null) ? false : true;
    }

    public static boolean isPrimitiveClass(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(95);
        }
        return getPrimitiveType(classDescriptor) != null;
    }

    public static boolean isPrimitiveType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(93);
        }
        return !kotlinType.isMarkedNullable() && isPrimitiveTypeOrNullablePrimitiveType(kotlinType);
    }

    public static boolean isPrimitiveTypeOrNullablePrimitiveType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(94);
        }
        ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
        return (mo2214getDeclarationDescriptor instanceof ClassDescriptor) && isPrimitiveClass((ClassDescriptor) mo2214getDeclarationDescriptor);
    }

    public static boolean isShort(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(119);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, StandardNames.FqNames._short);
    }

    public static boolean isSpecialClassWithNoSupertypes(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(106);
        }
        return classFqNameEquals(classDescriptor, StandardNames.FqNames.any) || classFqNameEquals(classDescriptor, StandardNames.FqNames.nothing);
    }

    public static boolean isString(KotlinType kotlinType) {
        return kotlinType != null && isNotNullConstructedFromGivenClass(kotlinType, StandardNames.FqNames.string);
    }

    public static boolean isTypeConstructorForGivenClass(TypeConstructor typeConstructor, FqNameUnsafe fqNameUnsafe) {
        if (typeConstructor == null) {
            $$$reportNull$$$0(100);
        }
        if (fqNameUnsafe == null) {
            $$$reportNull$$$0(101);
        }
        ClassifierDescriptor mo2214getDeclarationDescriptor = typeConstructor.mo2214getDeclarationDescriptor();
        return (mo2214getDeclarationDescriptor instanceof ClassDescriptor) && classFqNameEquals(mo2214getDeclarationDescriptor, fqNameUnsafe);
    }

    public static boolean isUByteArray(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(127);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, StandardNames.FqNames.uByteArrayFqName.toUnsafe());
    }

    public static boolean isUIntArray(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(129);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, StandardNames.FqNames.uIntArrayFqName.toUnsafe());
    }

    public static boolean isULongArray(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(130);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, StandardNames.FqNames.uLongArrayFqName.toUnsafe());
    }

    public static boolean isUShortArray(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(128);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, StandardNames.FqNames.uShortArrayFqName.toUnsafe());
    }

    public static boolean isUnderKotlinPackage(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(9);
        }
        while (declarationDescriptor != null) {
            if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                return ((PackageFragmentDescriptor) declarationDescriptor).getFqName().startsWith(StandardNames.BUILT_INS_PACKAGE_NAME);
            }
            declarationDescriptor = declarationDescriptor.getContainingDeclaration();
        }
        return false;
    }

    public static boolean isUnit(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA);
        }
        return isNotNullConstructedFromGivenClass(kotlinType, StandardNames.FqNames.unit);
    }

    public static boolean isUnsignedArrayType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(131);
        }
        return isUByteArray(kotlinType) || isUShortArray(kotlinType) || isUIntArray(kotlinType) || isULongArray(kotlinType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createBuiltInsModule(boolean z) {
        ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(BUILTINS_MODULE_NAME, this.storageManager, this, null);
        this.builtInsModule = moduleDescriptorImpl;
        moduleDescriptorImpl.initialize(BuiltInsLoader.Companion.getInstance().createPackageFragmentProvider(this.storageManager, this.builtInsModule, getClassDescriptorFactories(), getPlatformDependentDeclarationFilter(), getAdditionalClassPartsProvider(), z));
        ModuleDescriptorImpl moduleDescriptorImpl2 = this.builtInsModule;
        moduleDescriptorImpl2.setDependencies(moduleDescriptorImpl2);
    }

    protected AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        AdditionalClassPartsProvider.None none = AdditionalClassPartsProvider.None.INSTANCE;
        if (none == null) {
            $$$reportNull$$$0(2);
        }
        return none;
    }

    public ClassDescriptor getAny() {
        return getBuiltInClassByName("Any");
    }

    public SimpleType getAnyType() {
        SimpleType defaultType = getAny().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(49);
        }
        return defaultType;
    }

    public ClassDescriptor getArray() {
        return getBuiltInClassByName("Array");
    }

    public KotlinType getArrayElementType(KotlinType kotlinType) {
        KotlinType elementTypeForUnsignedArray;
        if (kotlinType == null) {
            $$$reportNull$$$0(66);
        }
        if (isArray(kotlinType)) {
            if (kotlinType.getArguments().size() == 1) {
                KotlinType type = kotlinType.getArguments().get(0).getType();
                if (type == null) {
                    $$$reportNull$$$0(67);
                }
                return type;
            }
            throw new IllegalStateException();
        }
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        SimpleType simpleType = ((Primitives) this.primitives.invoke()).kotlinArrayTypeToPrimitiveKotlinType.get(makeNotNullable);
        if (simpleType != null) {
            return simpleType;
        }
        ModuleDescriptor containingModuleOrNull = DescriptorUtils.getContainingModuleOrNull(makeNotNullable);
        if (containingModuleOrNull == null || (elementTypeForUnsignedArray = getElementTypeForUnsignedArray(makeNotNullable, containingModuleOrNull)) == null) {
            throw new IllegalStateException("not array: " + kotlinType);
        }
        return elementTypeForUnsignedArray;
    }

    public SimpleType getArrayType(Variance variance, KotlinType kotlinType, Annotations annotations) {
        if (variance == null) {
            $$$reportNull$$$0(77);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(78);
        }
        if (annotations == null) {
            $$$reportNull$$$0(79);
        }
        SimpleType simpleNotNullType = KotlinTypeFactory.simpleNotNullType(annotations, getArray(), Collections.singletonList(new TypeProjectionImpl(variance, kotlinType)));
        if (simpleNotNullType == null) {
            $$$reportNull$$$0(80);
        }
        return simpleNotNullType;
    }

    public SimpleType getBooleanType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.BOOLEAN);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(62);
        }
        return primitiveKotlinType;
    }

    public ClassDescriptor getBuiltInClassByFqName(FqName fqName) {
        if (fqName == null) {
            $$$reportNull$$$0(11);
        }
        ClassDescriptor resolveClassByFqName = DescriptorUtilKt.resolveClassByFqName(this.builtInsModule, fqName, NoLookupLocation.FROM_BUILTINS);
        if (resolveClassByFqName == null) {
            $$$reportNull$$$0(12);
        }
        return resolveClassByFqName;
    }

    public ModuleDescriptorImpl getBuiltInsModule() {
        ModuleDescriptorImpl moduleDescriptorImpl = this.builtInsModule;
        if (moduleDescriptorImpl == null) {
            $$$reportNull$$$0(6);
        }
        return moduleDescriptorImpl;
    }

    public MemberScope getBuiltInsPackageScope() {
        MemberScope memberScope = this.builtInsModule.getPackage(StandardNames.BUILT_INS_PACKAGE_FQ_NAME).getMemberScope();
        if (memberScope == null) {
            $$$reportNull$$$0(10);
        }
        return memberScope;
    }

    public SimpleType getByteType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.BYTE);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(55);
        }
        return primitiveKotlinType;
    }

    public SimpleType getCharType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.CHAR);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(61);
        }
        return primitiveKotlinType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Iterable<ClassDescriptorFactory> getClassDescriptorFactories() {
        List singletonList = Collections.singletonList(new BuiltInFictitiousFunctionClassFactory(this.storageManager, this.builtInsModule));
        if (singletonList == null) {
            $$$reportNull$$$0(4);
        }
        return singletonList;
    }

    public ClassDescriptor getCollection() {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.FqNames.collection);
        if (builtInClassByFqName == null) {
            $$$reportNull$$$0(33);
        }
        return builtInClassByFqName;
    }

    public ClassDescriptor getComparable() {
        return getBuiltInClassByName("Comparable");
    }

    public SimpleType getDefaultBound() {
        SimpleType nullableAnyType = getNullableAnyType();
        if (nullableAnyType == null) {
            $$$reportNull$$$0(51);
        }
        return nullableAnyType;
    }

    public SimpleType getDoubleType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.DOUBLE);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(60);
        }
        return primitiveKotlinType;
    }

    public SimpleType getFloatType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.FLOAT);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(59);
        }
        return primitiveKotlinType;
    }

    public ClassDescriptor getFunction(int i2) {
        return getBuiltInClassByName(StandardNames.getFunctionName(i2));
    }

    public SimpleType getIntType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.INT);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(57);
        }
        return primitiveKotlinType;
    }

    public ClassDescriptor getKClass() {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.FqNames.kClass.toSafe());
        if (builtInClassByFqName == null) {
            $$$reportNull$$$0(20);
        }
        return builtInClassByFqName;
    }

    public SimpleType getLongType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.LONG);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(58);
        }
        return primitiveKotlinType;
    }

    public ClassDescriptor getNothing() {
        return getBuiltInClassByName("Nothing");
    }

    public SimpleType getNothingType() {
        SimpleType defaultType = getNothing().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(47);
        }
        return defaultType;
    }

    public SimpleType getNullableAnyType() {
        SimpleType makeNullableAsSpecified = getAnyType().makeNullableAsSpecified(true);
        if (makeNullableAsSpecified == null) {
            $$$reportNull$$$0(50);
        }
        return makeNullableAsSpecified;
    }

    public SimpleType getNullableNothingType() {
        SimpleType makeNullableAsSpecified = getNothingType().makeNullableAsSpecified(true);
        if (makeNullableAsSpecified == null) {
            $$$reportNull$$$0(48);
        }
        return makeNullableAsSpecified;
    }

    public ClassDescriptor getNumber() {
        return getBuiltInClassByName("Number");
    }

    public SimpleType getNumberType() {
        SimpleType defaultType = getNumber().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(54);
        }
        return defaultType;
    }

    protected PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        PlatformDependentDeclarationFilter.NoPlatformDependent noPlatformDependent = PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
        if (noPlatformDependent == null) {
            $$$reportNull$$$0(3);
        }
        return noPlatformDependent;
    }

    public SimpleType getPrimitiveArrayKotlinType(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            $$$reportNull$$$0(72);
        }
        SimpleType simpleType = ((Primitives) this.primitives.invoke()).primitiveTypeToArrayKotlinType.get(primitiveType);
        if (simpleType == null) {
            $$$reportNull$$$0(73);
        }
        return simpleType;
    }

    public SimpleType getPrimitiveKotlinType(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            $$$reportNull$$$0(52);
        }
        SimpleType defaultType = getPrimitiveClassDescriptor(primitiveType).getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(53);
        }
        return defaultType;
    }

    public SimpleType getShortType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.SHORT);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(56);
        }
        return primitiveKotlinType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StorageManager getStorageManager() {
        StorageManager storageManager = this.storageManager;
        if (storageManager == null) {
            $$$reportNull$$$0(5);
        }
        return storageManager;
    }

    public ClassDescriptor getString() {
        return getBuiltInClassByName("String");
    }

    public SimpleType getStringType() {
        SimpleType defaultType = getString().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(64);
        }
        return defaultType;
    }

    public ClassDescriptor getSuspendFunction(int i2) {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier(StandardNames.getSuspendFunctionName(i2))));
        if (builtInClassByFqName == null) {
            $$$reportNull$$$0(17);
        }
        return builtInClassByFqName;
    }

    public ClassDescriptor getUnit() {
        return getBuiltInClassByName("Unit");
    }

    public SimpleType getUnitType() {
        SimpleType defaultType = getUnit().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(63);
        }
        return defaultType;
    }

    public void setBuiltInsModule(final ModuleDescriptorImpl moduleDescriptorImpl) {
        if (moduleDescriptorImpl == null) {
            $$$reportNull$$$0(1);
        }
        this.storageManager.compute(new a<Void>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.4
            @Override // kotlin.e0.c.a
            public Void invoke() {
                if (KotlinBuiltIns.this.builtInsModule != null) {
                    throw new AssertionError("Built-ins module is already set: " + KotlinBuiltIns.this.builtInsModule + " (attempting to reset to " + moduleDescriptorImpl + ")");
                }
                KotlinBuiltIns.this.builtInsModule = moduleDescriptorImpl;
                return null;
            }
        });
    }

    public SimpleType getArrayType(Variance variance, KotlinType kotlinType) {
        if (variance == null) {
            $$$reportNull$$$0(81);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(82);
        }
        SimpleType arrayType = getArrayType(variance, kotlinType, Annotations.Companion.getEMPTY());
        if (arrayType == null) {
            $$$reportNull$$$0(83);
        }
        return arrayType;
    }
}