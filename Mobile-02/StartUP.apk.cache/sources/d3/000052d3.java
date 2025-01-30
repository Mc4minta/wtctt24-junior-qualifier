package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.j;
import kotlin.a0.p;
import kotlin.a0.s;
import kotlin.c0.d;
import kotlin.e0.a;
import kotlin.j0.b0.b;
import kotlin.j0.c;
import kotlin.j0.l;
import kotlin.j0.q;
import kotlin.j0.r;
import kotlin.j0.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* compiled from: KCallableImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u0007¢\u0006\u0004\bJ\u0010KJ%\u0010\b\u001a\u00028\u00002\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0012\u001a\u00028\u00002\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0011\"\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u00028\u00002\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\tJ3\u0010\u0019\u001a\u00028\u00002\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018R0\u0010\u001e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001c \u001d*\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b0\u001b0\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001c\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010$8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010,\u001a\u0006\u0012\u0002\b\u00030$8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010&R$\u0010.\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010-0-0\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010\u001fR0\u00100\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020/ \u001d*\n\u0012\u0004\u0012\u00020/\u0018\u00010\u001b0\u001b0\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010\u001fR\u001c\u00103\u001a\b\u0012\u0004\u0012\u0002010\u001b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010)R0\u00105\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005 \u001d*\n\u0012\u0004\u0012\u00020\u0005\u0018\u000104040\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010\u001fR\u0018\u00109\u001a\u0004\u0018\u0001068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020/0\u001b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010)R\u0016\u0010=\u001a\u00020<8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020<8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010>R\u0016\u0010@\u001a\u00020<8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010>R\u0016\u0010C\u001a\u00020\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020<8D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\bD\u0010>R\u0016\u0010E\u001a\u00020<8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010>R\u0016\u0010I\u001a\u00020F8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006L"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/j0/c;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "", "Lkotlin/j0/l;", "", "args", "callAnnotationConstructor", "(Ljava/util/Map;)Ljava/lang/Object;", "Lkotlin/j0/q;", "type", "defaultEmptyArray", "(Lkotlin/j0/q;)Ljava/lang/Object;", "Ljava/lang/reflect/Type;", "extractContinuationArgument", "()Ljava/lang/reflect/Type;", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "callBy", "Lkotlin/c0/d;", "continuationArgument", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/c0/d;)Ljava/lang/Object;", "callDefaultMethod", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "_typeParameters", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "defaultCaller", "getParameters", "()Ljava/util/List;", "parameters", "getCaller", "caller", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_returnType", "", "_annotations", "Lkotlin/j0/r;", "getTypeParameters", "typeParameters", "Ljava/util/ArrayList;", "_parameters", "Lkotlin/j0/v;", "getVisibility", "()Lkotlin/j0/v;", "visibility", "getAnnotations", "annotations", "", "isOpen", "()Z", "isAbstract", "isBound", "getReturnType", "()Lkotlin/j0/q;", "returnType", "isAnnotationConstructor", "isFinal", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "descriptor", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public abstract class KCallableImpl<R> implements c<R>, KTypeParameterOwnerImpl {
    private final ReflectProperties.LazySoftVal<List<Annotation>> _annotations;
    private final ReflectProperties.LazySoftVal<ArrayList<l>> _parameters;
    private final ReflectProperties.LazySoftVal<KTypeImpl> _returnType;
    private final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> _typeParameters;

    public KCallableImpl() {
        ReflectProperties.LazySoftVal<List<Annotation>> lazySoft = ReflectProperties.lazySoft(new KCallableImpl$_annotations$1(this));
        m.f(lazySoft, "ReflectProperties.lazySo…or.computeAnnotations() }");
        this._annotations = lazySoft;
        ReflectProperties.LazySoftVal<ArrayList<l>> lazySoft2 = ReflectProperties.lazySoft(new KCallableImpl$_parameters$1(this));
        m.f(lazySoft2, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this._parameters = lazySoft2;
        ReflectProperties.LazySoftVal<KTypeImpl> lazySoft3 = ReflectProperties.lazySoft(new KCallableImpl$_returnType$1(this));
        m.f(lazySoft3, "ReflectProperties.lazySo…eturnType\n        }\n    }");
        this._returnType = lazySoft3;
        ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> lazySoft4 = ReflectProperties.lazySoft(new KCallableImpl$_typeParameters$1(this));
        m.f(lazySoft4, "ReflectProperties.lazySo…this, descriptor) }\n    }");
        this._typeParameters = lazySoft4;
    }

    private final R callAnnotationConstructor(Map<l, ? extends Object> map) {
        int r;
        Object defaultEmptyArray;
        List<l> parameters = getParameters();
        r = s.r(parameters, 10);
        ArrayList arrayList = new ArrayList(r);
        for (l lVar : parameters) {
            if (map.containsKey(lVar)) {
                defaultEmptyArray = map.get(lVar);
                if (defaultEmptyArray == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + lVar + ')');
                }
            } else if (lVar.isOptional()) {
                defaultEmptyArray = null;
            } else if (!lVar.isVararg()) {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + lVar);
            } else {
                defaultEmptyArray = defaultEmptyArray(lVar.getType());
            }
            arrayList.add(defaultEmptyArray);
        }
        Caller<?> defaultCaller = getDefaultCaller();
        if (defaultCaller != null) {
            try {
                Object[] array = arrayList.toArray(new Object[0]);
                if (array != null) {
                    return (R) defaultCaller.call(array);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            } catch (IllegalAccessException e2) {
                throw new IllegalCallableAccessException(e2);
            }
        }
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
    }

    private final Object defaultEmptyArray(q qVar) {
        Class b2 = a.b(b.b(qVar));
        if (b2.isArray()) {
            Object newInstance = Array.newInstance(b2.getComponentType(), 0);
            m.f(newInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return newInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + b2.getSimpleName() + ", because it is not an array type");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Type extractContinuationArgument() {
        Type[] lowerBounds;
        CallableMemberDescriptor descriptor = getDescriptor();
        if (!(descriptor instanceof FunctionDescriptor)) {
            descriptor = null;
        }
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) descriptor;
        if (functionDescriptor == null || !functionDescriptor.isSuspend()) {
            return null;
        }
        Object l0 = p.l0(getCaller().getParameterTypes());
        if (!(l0 instanceof ParameterizedType)) {
            l0 = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) l0;
        if (m.c(parameterizedType != null ? parameterizedType.getRawType() : null, d.class)) {
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            m.f(actualTypeArguments, "continuationType.actualTypeArguments");
            Object R = j.R(actualTypeArguments);
            if (!(R instanceof WildcardType)) {
                R = null;
            }
            WildcardType wildcardType = (WildcardType) R;
            if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
                return null;
            }
            return (Type) j.y(lowerBounds);
        }
        return null;
    }

    @Override // kotlin.j0.c
    public R call(Object... args) {
        m.g(args, "args");
        try {
            return (R) getCaller().call(args);
        } catch (IllegalAccessException e2) {
            throw new IllegalCallableAccessException(e2);
        }
    }

    @Override // kotlin.j0.c
    public R callBy(Map<l, ? extends Object> args) {
        m.g(args, "args");
        return isAnnotationConstructor() ? callAnnotationConstructor(args) : callDefaultMethod$kotlin_reflection(args, null);
    }

    public final R callDefaultMethod$kotlin_reflection(Map<l, ? extends Object> args, d<?> dVar) {
        m.g(args, "args");
        List<l> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator<l> it = parameters.iterator();
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                if (dVar != null) {
                    arrayList.add(dVar);
                }
                if (!z) {
                    Object[] array = arrayList.toArray(new Object[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    return call(Arrays.copyOf(array, array.length));
                }
                arrayList2.add(Integer.valueOf(i3));
                Caller<?> defaultCaller = getDefaultCaller();
                if (defaultCaller != null) {
                    arrayList.addAll(arrayList2);
                    arrayList.add(null);
                    try {
                        Object[] array2 = arrayList.toArray(new Object[0]);
                        if (array2 != null) {
                            return (R) defaultCaller.call(array2);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    } catch (IllegalAccessException e2) {
                        throw new IllegalCallableAccessException(e2);
                    }
                }
                throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
            }
            l next = it.next();
            if (i2 != 0 && i2 % 32 == 0) {
                arrayList2.add(Integer.valueOf(i3));
                i3 = 0;
            }
            if (args.containsKey(next)) {
                arrayList.add(args.get(next));
            } else if (next.isOptional()) {
                arrayList.add(UtilKt.isInlineClassType(next.getType()) ? null : UtilKt.defaultPrimitiveValue(kotlin.j0.b0.c.f(next.getType())));
                i3 = (1 << (i2 % 32)) | i3;
                z = true;
            } else if (next.isVararg()) {
                arrayList.add(defaultEmptyArray(next.getType()));
            } else {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + next);
            }
            if (next.getKind() == l.a.VALUE) {
                i2++;
            }
        }
    }

    @Override // kotlin.j0.b
    public List<Annotation> getAnnotations() {
        List<Annotation> invoke = this._annotations.invoke();
        m.f(invoke, "_annotations()");
        return invoke;
    }

    public abstract Caller<?> getCaller();

    public abstract KDeclarationContainerImpl getContainer();

    public abstract Caller<?> getDefaultCaller();

    public abstract CallableMemberDescriptor getDescriptor();

    @Override // kotlin.j0.c
    public abstract /* synthetic */ String getName();

    @Override // kotlin.j0.c
    public List<l> getParameters() {
        ArrayList<l> invoke = this._parameters.invoke();
        m.f(invoke, "_parameters()");
        return invoke;
    }

    @Override // kotlin.j0.c
    public q getReturnType() {
        KTypeImpl invoke = this._returnType.invoke();
        m.f(invoke, "_returnType()");
        return invoke;
    }

    @Override // kotlin.j0.c
    public List<r> getTypeParameters() {
        List<KTypeParameterImpl> invoke = this._typeParameters.invoke();
        m.f(invoke, "_typeParameters()");
        return invoke;
    }

    @Override // kotlin.j0.c
    public v getVisibility() {
        DescriptorVisibility visibility = getDescriptor().getVisibility();
        m.f(visibility, "descriptor.visibility");
        return UtilKt.toKVisibility(visibility);
    }

    @Override // kotlin.j0.c
    public boolean isAbstract() {
        return getDescriptor().getModality() == Modality.ABSTRACT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isAnnotationConstructor() {
        return m.c(getName(), "<init>") && getContainer().getJClass().isAnnotation();
    }

    public abstract boolean isBound();

    @Override // kotlin.j0.c
    public boolean isFinal() {
        return getDescriptor().getModality() == Modality.FINAL;
    }

    @Override // kotlin.j0.c
    public boolean isOpen() {
        return getDescriptor().getModality() == Modality.OPEN;
    }

    @Override // kotlin.j0.c
    public abstract /* synthetic */ boolean isSuspend();
}