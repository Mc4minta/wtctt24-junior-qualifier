package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.i0.c;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.UtilKt;

/* compiled from: InlineClassAwareCaller.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0002 \u0001*\u0004\u0018\u00010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001 B%\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00028\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00188V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "Ljava/lang/reflect/Member;", "M", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "getMember", "()Ljava/lang/reflect/Member;", "member", "", "isDefault", "Z", "", "getParameterTypes", "()Ljava/util/List;", "parameterTypes", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "descriptor", "<init>", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {
    private final Caller<M> caller;
    private final BoxUnboxData data;
    private final boolean isDefault;

    /* compiled from: InlineClassAwareCaller.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0086\u0002¢\u0006\u0004\b\t\u0010\nR!\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\bR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\n¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "Lkotlin/i0/c;", "component1", "()Lkotlin/i0/c;", "", "Ljava/lang/reflect/Method;", "component2", "()[Ljava/lang/reflect/Method;", "component3", "()Ljava/lang/reflect/Method;", "unbox", "[Ljava/lang/reflect/Method;", "getUnbox", "argumentRange", "Lkotlin/i0/c;", "getArgumentRange", "box", "Ljava/lang/reflect/Method;", "getBox", "<init>", "(Lkotlin/i0/c;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    private static final class BoxUnboxData {
        private final c argumentRange;
        private final Method box;
        private final Method[] unbox;

        public BoxUnboxData(c argumentRange, Method[] unbox, Method method) {
            m.g(argumentRange, "argumentRange");
            m.g(unbox, "unbox");
            this.argumentRange = argumentRange;
            this.unbox = unbox;
            this.box = method;
        }

        public final c component1() {
            return this.argumentRange;
        }

        public final Method[] component2() {
            return this.unbox;
        }

        public final Method component3() {
            return this.box;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
        if ((r9 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public InlineClassAwareCaller(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r8, kotlin.reflect.jvm.internal.calls.Caller<? extends M> r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.calls.Caller, boolean):void");
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] args) {
        Object invoke;
        m.g(args, "args");
        BoxUnboxData boxUnboxData = this.data;
        c component1 = boxUnboxData.component1();
        Method[] component2 = boxUnboxData.component2();
        Method component3 = boxUnboxData.component3();
        Object[] copyOf = Arrays.copyOf(args, args.length);
        m.f(copyOf, "java.util.Arrays.copyOf(this, size)");
        Objects.requireNonNull(copyOf, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int i2 = component1.i();
        int k2 = component1.k();
        if (i2 <= k2) {
            while (true) {
                Method method = component2[i2];
                Object obj = args[i2];
                if (method != null) {
                    if (obj != null) {
                        obj = method.invoke(obj, new Object[0]);
                    } else {
                        Class<?> returnType = method.getReturnType();
                        m.f(returnType, "method.returnType");
                        obj = UtilKt.defaultPrimitiveValue(returnType);
                    }
                }
                copyOf[i2] = obj;
                if (i2 == k2) {
                    break;
                }
                i2++;
            }
        }
        Object call = this.caller.call(copyOf);
        return (component3 == null || (invoke = component3.invoke(null, call)) == null) ? call : invoke;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* renamed from: getMember */
    public M mo2204getMember() {
        return this.caller.mo2204getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Type getReturnType() {
        return this.caller.getReturnType();
    }
}