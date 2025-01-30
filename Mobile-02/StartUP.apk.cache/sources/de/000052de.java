package kotlin.reflect.jvm.internal;

import com.coinbase.ApiConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.z;
import kotlin.e0.a;
import kotlin.j0.c;
import kotlin.j0.d;
import kotlin.j0.g;
import kotlin.j0.m;
import kotlin.j0.q;
import kotlin.j0.r;
import kotlin.j0.v;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.x;
import kotlin.l0.y;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* compiled from: KClassImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u00052\u00020\u0006:\u0001jB\u0015\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000.¢\u0006\u0004\bh\u0010iJ\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u0019\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00178V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\u00178V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\"R\u0016\u0010(\u001a\u00020\u00178V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\"R\u0016\u0010)\u001a\u00020\u00178V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\"R$\u0010-\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00040*8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\"\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000.8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u00010\u001e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010 R\u0016\u00105\u001a\u00020\u00178V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\"R\u0018\u00108\u001a\u0004\u0018\u00018\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u0002090*8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010,R\u0018\u0010=\u001a\u0004\u0018\u00010\u001e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010 R\u0016\u0010>\u001a\u00020\u00178V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\"R;\u0010B\u001a$\u0012 \u0012\u001e A*\u000e\u0018\u00010@R\b\u0012\u0004\u0012\u00028\u00000\u00000@R\b\u0012\u0004\u0012\u00028\u00000\u00000?8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00178V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\"R \u0010J\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030G0\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR \u0010L\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010IR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020M0\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010IR\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020P0*8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010,R\"\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000S0\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010IR\u0016\u0010V\u001a\u00020\u00178V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\"R\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00020W0*8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010,R\u0016\u0010]\u001a\u00020Z8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0016\u0010g\u001a\u00020b8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\bf\u0010d¨\u0006k"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl;", "", "T", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/j0/d;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "", "reportUnresolvedClass", "()Ljava/lang/Void;", "Lkotlin/reflect/jvm/internal/impl/name/Name;", ApiConstants.NAME, "", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getProperties", "(Lkotlin/reflect/jvm/internal/impl/name/Name;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getFunctions", "", "index", "getLocalProperty", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "value", "", "isInstance", "(Ljava/lang/Object;)Z", "other", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "isOpen", "()Z", "Lkotlin/j0/v;", "getVisibility", "()Lkotlin/j0/v;", "visibility", "isAbstract", "isData", "isFun", "", "getSealedSubclasses", "()Ljava/util/List;", "sealedSubclasses", "Ljava/lang/Class;", "jClass", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "getQualifiedName", "qualifiedName", "isCompanion", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance", "Lkotlin/j0/r;", "getTypeParameters", "typeParameters", "getSimpleName", "simpleName", "isSealed", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "isInner", "Lkotlin/j0/c;", "getMembers", "()Ljava/util/Collection;", "members", "getNestedClasses", "nestedClasses", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "constructorDescriptors", "Lkotlin/j0/q;", "getSupertypes", "supertypes", "Lkotlin/j0/g;", "getConstructors", "constructors", "isFinal", "", "getAnnotations", "annotations", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "classId", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "memberScope", "getStaticScope$kotlin_reflection", "staticScope", "<init>", "(Ljava/lang/Class;)V", "Data", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KClassImpl<T> extends KDeclarationContainerImpl implements d<T>, KClassifierImpl, KTypeParameterOwnerImpl {
    private final ReflectProperties.LazyVal<KClassImpl<T>.Data> data;
    private final Class<T> jClass;

    /* compiled from: KClassImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\bQ\u0010RJ\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R/\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b8F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R'\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\rR\u001f\u0010\u001e\u001a\u0004\u0018\u00010\u00058F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\u001dR'\u0010!\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR\u001d\u0010&\u001a\u00020\"8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010%R#\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\u00118F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\u0015R'\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\rR\u001f\u00100\u001a\u0004\u0018\u00010\u00058F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010\u001dR#\u00104\u001a\b\u0012\u0004\u0012\u0002010\u00118F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\u0015R'\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\rR+\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u0000080\u00118F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u000b\u001a\u0004\b:\u0010\u0015R'\u0010>\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u000b\u001a\u0004\b=\u0010\rR%\u0010D\u001a\u0004\u0018\u00018\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b?\u0010@\u0012\u0004\bC\u0010\u000f\u001a\u0004\bA\u0010BR'\u0010G\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003080\b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u000b\u001a\u0004\bF\u0010\rR'\u0010J\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u000b\u001a\u0004\bI\u0010\rR'\u0010M\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\u000b\u001a\u0004\bL\u0010\rR'\u0010P\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u000b\u001a\u0004\bO\u0010\r¨\u0006S"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Ljava/lang/Class;", "jClass", "", "calculateLocalClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "", "Lkotlin/j0/g;", "constructors$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getConstructors", "()Ljava/util/Collection;", "getConstructors$annotations", "()V", "constructors", "", "Lkotlin/j0/r;", "typeParameters$delegate", "getTypeParameters", "()Ljava/util/List;", "typeParameters", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "declaredStaticMembers$delegate", "getDeclaredStaticMembers", "declaredStaticMembers", "qualifiedName$delegate", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName", "inheritedStaticMembers$delegate", "getInheritedStaticMembers", "inheritedStaticMembers", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "descriptor$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", "", "annotations$delegate", "getAnnotations", "annotations", "allNonStaticMembers$delegate", "getAllNonStaticMembers", "allNonStaticMembers", "simpleName$delegate", "getSimpleName", "simpleName", "Lkotlin/j0/q;", "supertypes$delegate", "getSupertypes", "supertypes", "allMembers$delegate", "getAllMembers", "allMembers", "Lkotlin/j0/d;", "sealedSubclasses$delegate", "getSealedSubclasses", "sealedSubclasses", "declaredMembers$delegate", "getDeclaredMembers", "declaredMembers", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getObjectInstance", "()Ljava/lang/Object;", "getObjectInstance$annotations", "objectInstance", "nestedClasses$delegate", "getNestedClasses", "nestedClasses", "declaredNonStaticMembers$delegate", "getDeclaredNonStaticMembers", "declaredNonStaticMembers", "allStaticMembers$delegate", "getAllStaticMembers", "allStaticMembers", "inheritedNonStaticMembers$delegate", "getInheritedNonStaticMembers", "inheritedNonStaticMembers", "<init>", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public final class Data extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ m[] $$delegatedProperties = {e0.h(new x(e0.b(Data.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), e0.h(new x(e0.b(Data.class), "annotations", "getAnnotations()Ljava/util/List;")), e0.h(new x(e0.b(Data.class), "simpleName", "getSimpleName()Ljava/lang/String;")), e0.h(new x(e0.b(Data.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), e0.h(new x(e0.b(Data.class), "constructors", "getConstructors()Ljava/util/Collection;")), e0.h(new x(e0.b(Data.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), e0.h(new x(e0.b(Data.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), e0.h(new x(e0.b(Data.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), e0.h(new x(e0.b(Data.class), "supertypes", "getSupertypes()Ljava/util/List;")), e0.h(new x(e0.b(Data.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), e0.h(new x(e0.b(Data.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), e0.h(new x(e0.b(Data.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), e0.h(new x(e0.b(Data.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), e0.h(new x(e0.b(Data.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), e0.h(new x(e0.b(Data.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), e0.h(new x(e0.b(Data.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), e0.h(new x(e0.b(Data.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), e0.h(new x(e0.b(Data.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        private final ReflectProperties.LazySoftVal allMembers$delegate;
        private final ReflectProperties.LazySoftVal allNonStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal allStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal annotations$delegate;
        private final ReflectProperties.LazySoftVal constructors$delegate;
        private final ReflectProperties.LazySoftVal declaredMembers$delegate;
        private final ReflectProperties.LazySoftVal declaredNonStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal declaredStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal descriptor$delegate;
        private final ReflectProperties.LazySoftVal inheritedNonStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal inheritedStaticMembers$delegate;
        private final ReflectProperties.LazySoftVal nestedClasses$delegate;
        private final ReflectProperties.LazyVal objectInstance$delegate;
        private final ReflectProperties.LazySoftVal qualifiedName$delegate;
        private final ReflectProperties.LazySoftVal sealedSubclasses$delegate;
        private final ReflectProperties.LazySoftVal simpleName$delegate;
        private final ReflectProperties.LazySoftVal supertypes$delegate;
        private final ReflectProperties.LazySoftVal typeParameters$delegate;

        public Data() {
            super();
            this.descriptor$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$descriptor$2(this));
            this.annotations$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$annotations$2(this));
            this.simpleName$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$simpleName$2(this));
            this.qualifiedName$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$qualifiedName$2(this));
            this.constructors$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$constructors$2(this));
            this.nestedClasses$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$nestedClasses$2(this));
            this.objectInstance$delegate = ReflectProperties.lazy(new KClassImpl$Data$objectInstance$2(this));
            this.typeParameters$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$typeParameters$2(this));
            this.supertypes$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$supertypes$2(this));
            this.sealedSubclasses$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$sealedSubclasses$2(this));
            this.declaredNonStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$declaredNonStaticMembers$2(this));
            this.declaredStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$declaredStaticMembers$2(this));
            this.inheritedNonStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$inheritedNonStaticMembers$2(this));
            this.inheritedStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$inheritedStaticMembers$2(this));
            this.allNonStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$allNonStaticMembers$2(this));
            this.allStaticMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$allStaticMembers$2(this));
            this.declaredMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$declaredMembers$2(this));
            this.allMembers$delegate = ReflectProperties.lazySoft(new KClassImpl$Data$allMembers$2(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String calculateLocalClassName(Class<?> cls) {
            String V0;
            String W0;
            String W02;
            String name = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                kotlin.jvm.internal.m.f(name, "name");
                W02 = y.W0(name, enclosingMethod.getName() + "$", null, 2, null);
                return W02;
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                kotlin.jvm.internal.m.f(name, "name");
                W0 = y.W0(name, enclosingConstructor.getName() + "$", null, 2, null);
                return W0;
            }
            kotlin.jvm.internal.m.f(name, "name");
            V0 = y.V0(name, '$', null, 2, null);
            return V0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> getDeclaredStaticMembers() {
            return (Collection) this.declaredStaticMembers$delegate.getValue(this, $$delegatedProperties[11]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> getInheritedNonStaticMembers() {
            return (Collection) this.inheritedNonStaticMembers$delegate.getValue(this, $$delegatedProperties[12]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> getInheritedStaticMembers() {
            return (Collection) this.inheritedStaticMembers$delegate.getValue(this, $$delegatedProperties[13]);
        }

        public final Collection<KCallableImpl<?>> getAllMembers() {
            return (Collection) this.allMembers$delegate.getValue(this, $$delegatedProperties[17]);
        }

        public final Collection<KCallableImpl<?>> getAllNonStaticMembers() {
            return (Collection) this.allNonStaticMembers$delegate.getValue(this, $$delegatedProperties[14]);
        }

        public final Collection<KCallableImpl<?>> getAllStaticMembers() {
            return (Collection) this.allStaticMembers$delegate.getValue(this, $$delegatedProperties[15]);
        }

        public final List<Annotation> getAnnotations() {
            return (List) this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
        }

        public final Collection<g<T>> getConstructors() {
            return (Collection) this.constructors$delegate.getValue(this, $$delegatedProperties[4]);
        }

        public final Collection<KCallableImpl<?>> getDeclaredMembers() {
            return (Collection) this.declaredMembers$delegate.getValue(this, $$delegatedProperties[16]);
        }

        public final Collection<KCallableImpl<?>> getDeclaredNonStaticMembers() {
            return (Collection) this.declaredNonStaticMembers$delegate.getValue(this, $$delegatedProperties[10]);
        }

        public final ClassDescriptor getDescriptor() {
            return (ClassDescriptor) this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        }

        public final Collection<d<?>> getNestedClasses() {
            return (Collection) this.nestedClasses$delegate.getValue(this, $$delegatedProperties[5]);
        }

        public final T getObjectInstance() {
            return this.objectInstance$delegate.getValue(this, $$delegatedProperties[6]);
        }

        public final String getQualifiedName() {
            return (String) this.qualifiedName$delegate.getValue(this, $$delegatedProperties[3]);
        }

        public final List<d<? extends T>> getSealedSubclasses() {
            return (List) this.sealedSubclasses$delegate.getValue(this, $$delegatedProperties[9]);
        }

        public final String getSimpleName() {
            return (String) this.simpleName$delegate.getValue(this, $$delegatedProperties[2]);
        }

        public final List<q> getSupertypes() {
            return (List) this.supertypes$delegate.getValue(this, $$delegatedProperties[8]);
        }

        public final List<r> getTypeParameters() {
            return (List) this.typeParameters$delegate.getValue(this, $$delegatedProperties[7]);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.valuesCustom().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            iArr[KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;
            iArr[KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;
            iArr[KotlinClassHeader.Kind.CLASS.ordinal()] = 6;
        }
    }

    public KClassImpl(Class<T> jClass) {
        kotlin.jvm.internal.m.g(jClass, "jClass");
        this.jClass = jClass;
        ReflectProperties.LazyVal<KClassImpl<T>.Data> lazy = ReflectProperties.lazy(new KClassImpl$data$1(this));
        kotlin.jvm.internal.m.f(lazy, "ReflectProperties.lazy { Data() }");
        this.data = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassId getClassId() {
        return RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(getJClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void reportUnresolvedClass() {
        KotlinClassHeader classHeader;
        ReflectKotlinClass create = ReflectKotlinClass.Factory.create(getJClass());
        KotlinClassHeader.Kind kind = (create == null || (classHeader = create.getClassHeader()) == null) ? null : classHeader.getKind();
        if (kind != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    throw new UnsupportedOperationException("Packages and file facades are not yet supported in Kotlin reflection. Meanwhile please use Java reflection to inspect this class: " + getJClass());
                case 4:
                    throw new UnsupportedOperationException("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection library has no idea what declarations does it have. Please use Java reflection to inspect this class: " + getJClass());
                case 5:
                    throw new KotlinReflectionInternalError("Unknown class: " + getJClass() + " (kind = " + kind + ')');
                case 6:
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        throw new KotlinReflectionInternalError("Unresolved class: " + getJClass());
    }

    public boolean equals(Object obj) {
        return (obj instanceof KClassImpl) && kotlin.jvm.internal.m.c(a.c(this), a.c((d) obj));
    }

    @Override // kotlin.j0.b
    public List<Annotation> getAnnotations() {
        return this.data.invoke().getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        List g2;
        ClassDescriptor descriptor = getDescriptor();
        if (descriptor.getKind() != ClassKind.INTERFACE && descriptor.getKind() != ClassKind.OBJECT) {
            Collection<ClassConstructorDescriptor> constructors = descriptor.getConstructors();
            kotlin.jvm.internal.m.f(constructors, "descriptor.constructors");
            return constructors;
        }
        g2 = kotlin.a0.r.g();
        return g2;
    }

    public Collection<g<T>> getConstructors() {
        return this.data.invoke().getConstructors();
    }

    public final ReflectProperties.LazyVal<KClassImpl<T>.Data> getData() {
        return this.data;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name name) {
        List t0;
        kotlin.jvm.internal.m.g(name, "name");
        MemberScope memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        t0 = z.t0(memberScope$kotlin_reflection.getContributedFunctions(name, noLookupLocation), getStaticScope$kotlin_reflection().getContributedFunctions(name, noLookupLocation));
        return t0;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl, kotlin.jvm.internal.d
    public Class<T> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int i2) {
        Class<?> declaringClass;
        if (kotlin.jvm.internal.m.c(getJClass().getSimpleName(), "DefaultImpls") && (declaringClass = getJClass().getDeclaringClass()) != null && declaringClass.isInterface()) {
            d e2 = a.e(declaringClass);
            Objects.requireNonNull(e2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((KClassImpl) e2).getLocalProperty(i2);
        }
        ClassDescriptor descriptor = getDescriptor();
        if (!(descriptor instanceof DeserializedClassDescriptor)) {
            descriptor = null;
        }
        DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) descriptor;
        if (deserializedClassDescriptor != null) {
            ProtoBuf.Class classProto = deserializedClassDescriptor.getClassProto();
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Property>> generatedExtension = JvmProtoBuf.classLocalVariable;
            kotlin.jvm.internal.m.f(generatedExtension, "JvmProtoBuf.classLocalVariable");
            ProtoBuf.Property property = (ProtoBuf.Property) ProtoBufUtilKt.getExtensionOrNull(classProto, generatedExtension, i2);
            if (property != null) {
                return (PropertyDescriptor) UtilKt.deserializeToDescriptor(getJClass(), property, deserializedClassDescriptor.getC().getNameResolver(), deserializedClassDescriptor.getC().getTypeTable(), deserializedClassDescriptor.getMetadataVersion(), KClassImpl$getLocalProperty$2$1$1.INSTANCE);
            }
            return null;
        }
        return null;
    }

    public final MemberScope getMemberScope$kotlin_reflection() {
        return getDescriptor().getDefaultType().getMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<c<?>> getMembers() {
        return this.data.invoke().getAllMembers();
    }

    public Collection<d<?>> getNestedClasses() {
        return this.data.invoke().getNestedClasses();
    }

    @Override // kotlin.j0.d
    public T getObjectInstance() {
        return this.data.invoke().getObjectInstance();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name name) {
        List t0;
        kotlin.jvm.internal.m.g(name, "name");
        MemberScope memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        t0 = z.t0(memberScope$kotlin_reflection.getContributedVariables(name, noLookupLocation), getStaticScope$kotlin_reflection().getContributedVariables(name, noLookupLocation));
        return t0;
    }

    @Override // kotlin.j0.d
    public String getQualifiedName() {
        return this.data.invoke().getQualifiedName();
    }

    public List<d<? extends T>> getSealedSubclasses() {
        return this.data.invoke().getSealedSubclasses();
    }

    @Override // kotlin.j0.d
    public String getSimpleName() {
        return this.data.invoke().getSimpleName();
    }

    public final MemberScope getStaticScope$kotlin_reflection() {
        MemberScope staticScope = getDescriptor().getStaticScope();
        kotlin.jvm.internal.m.f(staticScope, "descriptor.staticScope");
        return staticScope;
    }

    public List<q> getSupertypes() {
        return this.data.invoke().getSupertypes();
    }

    @Override // kotlin.j0.d
    public List<r> getTypeParameters() {
        return this.data.invoke().getTypeParameters();
    }

    public v getVisibility() {
        DescriptorVisibility visibility = getDescriptor().getVisibility();
        kotlin.jvm.internal.m.f(visibility, "descriptor.visibility");
        return UtilKt.toKVisibility(visibility);
    }

    public int hashCode() {
        return a.c(this).hashCode();
    }

    @Override // kotlin.j0.d
    public boolean isAbstract() {
        return getDescriptor().getModality() == Modality.ABSTRACT;
    }

    public boolean isCompanion() {
        return getDescriptor().isCompanionObject();
    }

    public boolean isData() {
        return getDescriptor().isData();
    }

    public boolean isFinal() {
        return getDescriptor().getModality() == Modality.FINAL;
    }

    public boolean isFun() {
        return getDescriptor().isFun();
    }

    @Override // kotlin.j0.d
    public boolean isInner() {
        return getDescriptor().isInner();
    }

    public boolean isInstance(Object obj) {
        Integer functionClassArity = ReflectClassUtilKt.getFunctionClassArity(getJClass());
        if (functionClassArity != null) {
            return i0.m(obj, functionClassArity.intValue());
        }
        Class wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (wrapperByPrimitive == null) {
            wrapperByPrimitive = getJClass();
        }
        return wrapperByPrimitive.isInstance(obj);
    }

    public boolean isOpen() {
        return getDescriptor().getModality() == Modality.OPEN;
    }

    @Override // kotlin.j0.d
    public boolean isSealed() {
        return getDescriptor().getModality() == Modality.SEALED;
    }

    public abstract /* synthetic */ boolean isValue();

    public String toString() {
        String str;
        String J;
        StringBuilder sb = new StringBuilder();
        sb.append("class ");
        ClassId classId = getClassId();
        FqName packageFqName = classId.getPackageFqName();
        kotlin.jvm.internal.m.f(packageFqName, "classId.packageFqName");
        if (packageFqName.isRoot()) {
            str = "";
        } else {
            str = packageFqName.asString() + ".";
        }
        String asString = classId.getRelativeClassName().asString();
        kotlin.jvm.internal.m.f(asString, "classId.relativeClassName.asString()");
        J = kotlin.l0.x.J(asString, '.', '$', false, 4, null);
        sb.append(str + J);
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public ClassDescriptor getDescriptor() {
        return this.data.invoke().getDescriptor();
    }
}