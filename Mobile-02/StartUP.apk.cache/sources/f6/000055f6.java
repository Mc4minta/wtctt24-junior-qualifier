package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a0.e0;
import kotlin.a0.l0;
import kotlin.a0.n;
import kotlin.a0.s;
import kotlin.e0.c.l;
import kotlin.i0.f;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.u;
import kotlin.x;

/* compiled from: predefinedEnhancementInfo.kt */
/* loaded from: classes3.dex */
final class SignatureEnhancementBuilder {
    private final Map<String, PredefinedFunctionEnhancementInfo> signatures = new LinkedHashMap();

    public final Map<String, PredefinedFunctionEnhancementInfo> build() {
        return this.signatures;
    }

    /* compiled from: predefinedEnhancementInfo.kt */
    /* loaded from: classes3.dex */
    public final class ClassEnhancementBuilder {
        private final String className;
        final /* synthetic */ SignatureEnhancementBuilder this$0;

        public ClassEnhancementBuilder(SignatureEnhancementBuilder this$0, String className) {
            m.g(this$0, "this$0");
            m.g(className, "className");
            this.this$0 = this$0;
            this.className = className;
        }

        public final void function(String name, l<? super FunctionEnhancementBuilder, x> block) {
            m.g(name, "name");
            m.g(block, "block");
            Map map = this.this$0.signatures;
            FunctionEnhancementBuilder functionEnhancementBuilder = new FunctionEnhancementBuilder(this, name);
            block.invoke(functionEnhancementBuilder);
            o<String, PredefinedFunctionEnhancementInfo> build = functionEnhancementBuilder.build();
            map.put(build.c(), build.d());
        }

        public final String getClassName() {
            return this.className;
        }

        /* compiled from: predefinedEnhancementInfo.kt */
        /* loaded from: classes3.dex */
        public final class FunctionEnhancementBuilder {
            private final String functionName;
            private final List<o<String, TypeEnhancementInfo>> parameters;
            private o<String, TypeEnhancementInfo> returnType;
            final /* synthetic */ ClassEnhancementBuilder this$0;

            public FunctionEnhancementBuilder(ClassEnhancementBuilder this$0, String functionName) {
                m.g(this$0, "this$0");
                m.g(functionName, "functionName");
                this.this$0 = this$0;
                this.functionName = functionName;
                this.parameters = new ArrayList();
                this.returnType = u.a("V", null);
            }

            public final o<String, PredefinedFunctionEnhancementInfo> build() {
                int r;
                int r2;
                SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
                String className = this.this$0.getClassName();
                String functionName = getFunctionName();
                List<o<String, TypeEnhancementInfo>> list = this.parameters;
                r = s.r(list, 10);
                ArrayList arrayList = new ArrayList(r);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((o) it.next()).c());
                }
                String signature = signatureBuildingComponents.signature(className, signatureBuildingComponents.jvmDescriptor(functionName, arrayList, this.returnType.c()));
                TypeEnhancementInfo d2 = this.returnType.d();
                List<o<String, TypeEnhancementInfo>> list2 = this.parameters;
                r2 = s.r(list2, 10);
                ArrayList arrayList2 = new ArrayList(r2);
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((TypeEnhancementInfo) ((o) it2.next()).d());
                }
                return u.a(signature, new PredefinedFunctionEnhancementInfo(d2, arrayList2));
            }

            public final String getFunctionName() {
                return this.functionName;
            }

            public final void parameter(String type, JavaTypeQualifiers... qualifiers) {
                Iterable<e0> r0;
                int r;
                int d2;
                int b2;
                TypeEnhancementInfo typeEnhancementInfo;
                m.g(type, "type");
                m.g(qualifiers, "qualifiers");
                List<o<String, TypeEnhancementInfo>> list = this.parameters;
                if (qualifiers.length == 0) {
                    typeEnhancementInfo = null;
                } else {
                    r0 = n.r0(qualifiers);
                    r = s.r(r0, 10);
                    d2 = l0.d(r);
                    b2 = f.b(d2, 16);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
                    for (e0 e0Var : r0) {
                        linkedHashMap.put(Integer.valueOf(e0Var.c()), (JavaTypeQualifiers) e0Var.d());
                    }
                    typeEnhancementInfo = new TypeEnhancementInfo(linkedHashMap);
                }
                list.add(u.a(type, typeEnhancementInfo));
            }

            public final void returns(String type, JavaTypeQualifiers... qualifiers) {
                Iterable<e0> r0;
                int r;
                int d2;
                int b2;
                m.g(type, "type");
                m.g(qualifiers, "qualifiers");
                r0 = n.r0(qualifiers);
                r = s.r(r0, 10);
                d2 = l0.d(r);
                b2 = f.b(d2, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
                for (e0 e0Var : r0) {
                    linkedHashMap.put(Integer.valueOf(e0Var.c()), (JavaTypeQualifiers) e0Var.d());
                }
                this.returnType = u.a(type, new TypeEnhancementInfo(linkedHashMap));
            }

            public final void returns(JvmPrimitiveType type) {
                m.g(type, "type");
                String desc = type.getDesc();
                m.f(desc, "type.desc");
                this.returnType = u.a(desc, null);
            }
        }
    }
}