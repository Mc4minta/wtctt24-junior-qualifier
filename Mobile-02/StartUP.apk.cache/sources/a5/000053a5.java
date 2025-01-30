package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.List;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: FunctionClassScope.kt */
/* loaded from: classes3.dex */
public final class FunctionClassScope extends GivenFunctionsMemberScope {

    /* compiled from: FunctionClassScope.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FunctionClassKind.values().length];
            iArr[FunctionClassKind.Function.ordinal()] = 1;
            iArr[FunctionClassKind.SuspendFunction.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionClassScope(StorageManager storageManager, FunctionClassDescriptor containingClass) {
        super(storageManager, containingClass);
        m.g(storageManager, "storageManager");
        m.g(containingClass, "containingClass");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
    public List<FunctionDescriptor> computeDeclaredFunctions() {
        List<FunctionDescriptor> b2;
        List<FunctionDescriptor> b3;
        List<FunctionDescriptor> g2;
        int i2 = WhenMappings.$EnumSwitchMapping$0[((FunctionClassDescriptor) getContainingClass()).getFunctionKind().ordinal()];
        if (i2 == 1) {
            b2 = q.b(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor) getContainingClass(), false));
            return b2;
        } else if (i2 != 2) {
            g2 = r.g();
            return g2;
        } else {
            b3 = q.b(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor) getContainingClass(), true));
            return b3;
        }
    }
}