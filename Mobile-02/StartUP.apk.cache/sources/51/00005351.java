package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* compiled from: AnnotationConstructorCaller.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002$%BA\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010!\u001a\u00020 \u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e¢\u0006\u0004\b\"\u0010#J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00198V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006&"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/Class;", "jClass", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "erasedParameterTypes", "Ljava/util/List;", "defaultValues", "getMember", "()Ljava/lang/Void;", "member", "Ljava/lang/reflect/Method;", "methods", "", "parameterNames", "Ljava/lang/reflect/Type;", "parameterTypes", "getParameterTypes", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "origin", "<init>", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "CallMode", "Origin", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class AnnotationConstructorCaller implements Caller {
    private final CallMode callMode;
    private final List<Object> defaultValues;
    private final List<Class<?>> erasedParameterTypes;
    private final Class<?> jClass;
    private final List<Method> methods;
    private final List<String> parameterNames;
    private final List<Type> parameterTypes;

    /* compiled from: AnnotationConstructorCaller.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "<init>", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public enum CallMode {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    /* compiled from: AnnotationConstructorCaller.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "", "<init>", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public enum Origin {
        JAVA,
        KOTLIN
    }

    public AnnotationConstructorCaller(Class<?> jClass, List<String> parameterNames, CallMode callMode, Origin origin, List<Method> methods) {
        int r;
        int r2;
        int r3;
        List q0;
        m.g(jClass, "jClass");
        m.g(parameterNames, "parameterNames");
        m.g(callMode, "callMode");
        m.g(origin, "origin");
        m.g(methods, "methods");
        this.jClass = jClass;
        this.parameterNames = parameterNames;
        this.callMode = callMode;
        this.methods = methods;
        r = s.r(methods, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Method method : methods) {
            arrayList.add(method.getGenericReturnType());
        }
        this.parameterTypes = arrayList;
        List<Method> list = this.methods;
        r2 = s.r(list, 10);
        ArrayList arrayList2 = new ArrayList(r2);
        for (Method method2 : list) {
            Class<?> it = method2.getReturnType();
            m.f(it, "it");
            Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(it);
            if (wrapperByPrimitive != null) {
                it = wrapperByPrimitive;
            }
            arrayList2.add(it);
        }
        this.erasedParameterTypes = arrayList2;
        List<Method> list2 = this.methods;
        r3 = s.r(list2, 10);
        ArrayList arrayList3 = new ArrayList(r3);
        for (Method method3 : list2) {
            arrayList3.add(method3.getDefaultValue());
        }
        this.defaultValues = arrayList3;
        if (this.callMode == CallMode.POSITIONAL_CALL && origin == Origin.JAVA) {
            q0 = z.q0(this.parameterNames, "value");
            if (!q0.isEmpty()) {
                throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] args) {
        List Q0;
        Map r;
        m.g(args, "args");
        checkArguments(args);
        ArrayList arrayList = new ArrayList(args.length);
        int length = args.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Object obj = args[i2];
            int i4 = i3 + 1;
            Object transformKotlinToJvm = (obj == null && this.callMode == CallMode.CALL_BY_NAME) ? this.defaultValues.get(i3) : AnnotationConstructorCallerKt.transformKotlinToJvm(obj, this.erasedParameterTypes.get(i3));
            if (transformKotlinToJvm == null) {
                AnnotationConstructorCallerKt.throwIllegalArgumentType(i3, this.parameterNames.get(i3), this.erasedParameterTypes.get(i3));
                throw null;
            }
            arrayList.add(transformKotlinToJvm);
            i2++;
            i3 = i4;
        }
        Class<?> cls = this.jClass;
        Q0 = z.Q0(this.parameterNames, arrayList);
        r = m0.r(Q0);
        return AnnotationConstructorCallerKt.createAnnotationInstance(cls, r, this.methods);
    }

    public void checkArguments(Object[] args) {
        m.g(args, "args");
        Caller.DefaultImpls.checkArguments(this, args);
    }

    public Void getMember() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* renamed from: getMember  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Member mo2204getMember() {
        return (Member) getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List<Type> getParameterTypes() {
        return this.parameterTypes;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Type getReturnType() {
        return this.jClass;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AnnotationConstructorCaller(java.lang.Class r7, java.util.List r8, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode r9, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.Origin r10, java.util.List r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r12 = r12 & 16
            if (r12 == 0) goto L2a
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = 10
            int r12 = kotlin.a0.p.r(r8, r12)
            r11.<init>(r12)
            java.util.Iterator r12 = r8.iterator()
        L13:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L2a
            java.lang.Object r13 = r12.next()
            java.lang.String r13 = (java.lang.String) r13
            r0 = 0
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.reflect.Method r13 = r7.getDeclaredMethod(r13, r0)
            r11.add(r13)
            goto L13
        L2a:
            r5 = r11
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.<init>(java.lang.Class, java.util.List, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$CallMode, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$Origin, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}