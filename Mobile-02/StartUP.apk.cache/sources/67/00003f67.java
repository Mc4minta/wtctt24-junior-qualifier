package com.squareup.moshi;

import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.e0.a;
import kotlin.j0.d;
import kotlin.j0.q;
import kotlin.j0.z;
import kotlin.jvm.internal.m;

/* compiled from: -MoshiKotlinTypesExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a.\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0018\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0001\u0018\u0001H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0001\u0018\u0001H\u0087\b¢\u0006\u0004\b\b\u0010\u0007\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\u000b\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\r¢\u0006\u0004\b\u000b\u0010\u000e\u001a\u0011\u0010\u000b\u001a\u00020\n*\u00020\u000f¢\u0006\u0004\b\u000b\u0010\u0010\"\u001b\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0011*\u00020\u000f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"", "T", "", "nextAnnotations", "(Ljava/util/Set;)Ljava/util/Set;", "Ljava/lang/reflect/WildcardType;", "subtypeOf", "()Ljava/lang/reflect/WildcardType;", "supertypeOf", "Lkotlin/j0/q;", "Ljava/lang/reflect/GenericArrayType;", "asArrayType", "(Lkotlin/j0/q;)Ljava/lang/reflect/GenericArrayType;", "Lkotlin/j0/d;", "(Lkotlin/j0/d;)Ljava/lang/reflect/GenericArrayType;", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)Ljava/lang/reflect/GenericArrayType;", "Ljava/lang/Class;", "getRawType", "(Ljava/lang/reflect/Type;)Ljava/lang/Class;", "rawType", "moshi"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class _MoshiKotlinTypesExtensionsKt {
    public static final GenericArrayType asArrayType(q asArrayType) {
        m.g(asArrayType, "$this$asArrayType");
        return asArrayType(z.f(asArrayType));
    }

    public static final Class<?> getRawType(Type rawType) {
        m.g(rawType, "$this$rawType");
        Class<?> rawType2 = Types.getRawType(rawType);
        m.f(rawType2, "Types.getRawType(this)");
        return rawType2;
    }

    public static final /* synthetic */ <T extends Annotation> Set<Annotation> nextAnnotations(Set<? extends Annotation> nextAnnotations) {
        m.g(nextAnnotations, "$this$nextAnnotations");
        m.l(4, "T");
        return Types.nextAnnotations(nextAnnotations, Annotation.class);
    }

    public static final /* synthetic */ <T> WildcardType subtypeOf() {
        m.l(6, "T");
        Type f2 = z.f(null);
        if (f2 instanceof Class) {
            f2 = Util.boxIfPrimitive((Class) f2);
            m.f(f2, "Util.boxIfPrimitive(type)");
        }
        WildcardType subtypeOf = Types.subtypeOf(f2);
        m.f(subtypeOf, "Types.subtypeOf(type)");
        return subtypeOf;
    }

    public static final /* synthetic */ <T> WildcardType supertypeOf() {
        m.l(6, "T");
        Type f2 = z.f(null);
        if (f2 instanceof Class) {
            f2 = Util.boxIfPrimitive((Class) f2);
            m.f(f2, "Util.boxIfPrimitive(type)");
        }
        WildcardType supertypeOf = Types.supertypeOf(f2);
        m.f(supertypeOf, "Types.supertypeOf(type)");
        return supertypeOf;
    }

    public static final GenericArrayType asArrayType(d<?> asArrayType) {
        m.g(asArrayType, "$this$asArrayType");
        return asArrayType(a.b(asArrayType));
    }

    public static final GenericArrayType asArrayType(Type asArrayType) {
        m.g(asArrayType, "$this$asArrayType");
        GenericArrayType arrayOf = Types.arrayOf(asArrayType);
        m.f(arrayOf, "Types.arrayOf(this)");
        return arrayOf;
    }
}