package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.l0.k;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.CheckResult;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
public final class Checks {
    private final l<FunctionDescriptor, String> additionalCheck;
    private final Check[] checks;
    private final Name name;
    private final Collection<Name> nameList;
    private final k regex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: modifierChecks.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.util.Checks$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends o implements l {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public final Void invoke(FunctionDescriptor functionDescriptor) {
            m.g(functionDescriptor, "<this>");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: modifierChecks.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.util.Checks$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends o implements l {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public final Void invoke(FunctionDescriptor functionDescriptor) {
            m.g(functionDescriptor, "<this>");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: modifierChecks.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.util.Checks$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass4 extends o implements l {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public final Void invoke(FunctionDescriptor functionDescriptor) {
            m.g(functionDescriptor, "<this>");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Checks(Name name, k kVar, Collection<Name> collection, l<? super FunctionDescriptor, String> lVar, Check... checkArr) {
        this.name = name;
        this.regex = kVar;
        this.nameList = collection;
        this.additionalCheck = lVar;
        this.checks = checkArr;
    }

    public final CheckResult checkAll(FunctionDescriptor functionDescriptor) {
        m.g(functionDescriptor, "functionDescriptor");
        Check[] checkArr = this.checks;
        int length = checkArr.length;
        int i2 = 0;
        while (i2 < length) {
            Check check = checkArr[i2];
            i2++;
            String invoke = check.invoke(functionDescriptor);
            if (invoke != null) {
                return new CheckResult.IllegalSignature(invoke);
            }
        }
        String invoke2 = this.additionalCheck.invoke(functionDescriptor);
        if (invoke2 != null) {
            return new CheckResult.IllegalSignature(invoke2);
        }
        return CheckResult.SuccessCheck.INSTANCE;
    }

    public final boolean isApplicable(FunctionDescriptor functionDescriptor) {
        m.g(functionDescriptor, "functionDescriptor");
        if (this.name == null || m.c(functionDescriptor.getName(), this.name)) {
            if (this.regex != null) {
                String asString = functionDescriptor.getName().asString();
                m.f(asString, "functionDescriptor.name.asString()");
                if (!this.regex.d(asString)) {
                    return false;
                }
            }
            Collection<Name> collection = this.nameList;
            return collection == null || collection.contains(functionDescriptor.getName());
        }
        return false;
    }

    public /* synthetic */ Checks(Name name, Check[] checkArr, l lVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(name, checkArr, (i2 & 4) != 0 ? AnonymousClass2.INSTANCE : lVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Checks(kotlin.reflect.jvm.internal.impl.name.Name r8, kotlin.reflect.jvm.internal.impl.util.Check[] r9, kotlin.e0.c.l<? super kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.String> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.m.g(r8, r0)
            java.lang.String r0 = "checks"
            kotlin.jvm.internal.m.g(r9, r0)
            java.lang.String r0 = "additionalChecks"
            kotlin.jvm.internal.m.g(r10, r0)
            int r0 = r9.length
            kotlin.reflect.jvm.internal.impl.util.Check[] r6 = new kotlin.reflect.jvm.internal.impl.util.Check[r0]
            int r0 = r9.length
            r1 = 0
            java.lang.System.arraycopy(r9, r1, r6, r1, r0)
            r3 = 0
            r4 = 0
            r1 = r7
            r2 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.Checks.<init>(kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.util.Check[], kotlin.e0.c.l):void");
    }

    public /* synthetic */ Checks(k kVar, Check[] checkArr, l lVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kVar, checkArr, (i2 & 4) != 0 ? AnonymousClass3.INSTANCE : lVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Checks(kotlin.l0.k r8, kotlin.reflect.jvm.internal.impl.util.Check[] r9, kotlin.e0.c.l<? super kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.String> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "regex"
            kotlin.jvm.internal.m.g(r8, r0)
            java.lang.String r0 = "checks"
            kotlin.jvm.internal.m.g(r9, r0)
            java.lang.String r0 = "additionalChecks"
            kotlin.jvm.internal.m.g(r10, r0)
            int r0 = r9.length
            kotlin.reflect.jvm.internal.impl.util.Check[] r6 = new kotlin.reflect.jvm.internal.impl.util.Check[r0]
            int r0 = r9.length
            r1 = 0
            java.lang.System.arraycopy(r9, r1, r6, r1, r0)
            r2 = 0
            r4 = 0
            r1 = r7
            r3 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.Checks.<init>(kotlin.l0.k, kotlin.reflect.jvm.internal.impl.util.Check[], kotlin.e0.c.l):void");
    }

    public /* synthetic */ Checks(Collection collection, Check[] checkArr, l lVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(collection, checkArr, (i2 & 4) != 0 ? AnonymousClass4.INSTANCE : lVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Checks(java.util.Collection<kotlin.reflect.jvm.internal.impl.name.Name> r8, kotlin.reflect.jvm.internal.impl.util.Check[] r9, kotlin.e0.c.l<? super kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.String> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "nameList"
            kotlin.jvm.internal.m.g(r8, r0)
            java.lang.String r0 = "checks"
            kotlin.jvm.internal.m.g(r9, r0)
            java.lang.String r0 = "additionalChecks"
            kotlin.jvm.internal.m.g(r10, r0)
            int r0 = r9.length
            kotlin.reflect.jvm.internal.impl.util.Check[] r6 = new kotlin.reflect.jvm.internal.impl.util.Check[r0]
            int r0 = r9.length
            r1 = 0
            java.lang.System.arraycopy(r9, r1, r6, r1, r0)
            r2 = 0
            r3 = 0
            r1 = r7
            r4 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.Checks.<init>(java.util.Collection, kotlin.reflect.jvm.internal.impl.util.Check[], kotlin.e0.c.l):void");
    }
}