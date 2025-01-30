package kotlin.j0;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypesJVM.kt */
/* loaded from: classes3.dex */
public final class w implements ParameterizedType, Type {
    private final Type[] a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f17304b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f17305c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypesJVM.kt */
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class a extends kotlin.jvm.internal.k implements kotlin.e0.c.l<Type, String> {
        public static final a a = new a();

        a() {
            super(1, z.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final String invoke(Type p1) {
            String h2;
            kotlin.jvm.internal.m.g(p1, "p1");
            h2 = z.h(p1);
            return h2;
        }
    }

    public w(Class<?> rawType, Type type, List<? extends Type> typeArguments) {
        kotlin.jvm.internal.m.g(rawType, "rawType");
        kotlin.jvm.internal.m.g(typeArguments, "typeArguments");
        this.f17304b = rawType;
        this.f17305c = type;
        Object[] array = typeArguments.toArray(new Type[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.a = (Type[]) array;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (kotlin.jvm.internal.m.c(this.f17304b, parameterizedType.getRawType()) && kotlin.jvm.internal.m.c(this.f17305c, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f17305c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f17304b;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        String h2;
        String h3;
        StringBuilder sb = new StringBuilder();
        Type type = this.f17305c;
        if (type != null) {
            h3 = z.h(type);
            sb.append(h3);
            sb.append("$");
            sb.append(this.f17304b.getSimpleName());
        } else {
            h2 = z.h(this.f17304b);
            sb.append(h2);
        }
        Type[] typeArr = this.a;
        if (!(typeArr.length == 0)) {
            kotlin.a0.n.I(typeArr, sb, null, "<", ">", 0, null, a.a, 50, null);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.f(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public int hashCode() {
        int hashCode = this.f17304b.hashCode();
        Type type = this.f17305c;
        return (hashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public String toString() {
        return getTypeName();
    }
}