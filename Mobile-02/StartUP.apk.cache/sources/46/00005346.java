package kotlin.reflect.jvm.internal;

import java.util.Collections;
import java.util.List;
import kotlin.j0.d;
import kotlin.j0.e;
import kotlin.j0.f;
import kotlin.j0.g;
import kotlin.j0.i;
import kotlin.j0.k;
import kotlin.j0.n;
import kotlin.j0.o;
import kotlin.j0.r;
import kotlin.j0.u;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.y;

/* loaded from: classes3.dex */
public class ReflectionFactoryImpl extends f0 {
    public static void clearCaches() {
        KClassCacheKt.clearKClassCache();
        ModuleByClassLoaderKt.clearModuleByClassLoaderCache();
    }

    private static KDeclarationContainerImpl getOwner(c cVar) {
        f owner = cVar.getOwner();
        return owner instanceof KDeclarationContainerImpl ? (KDeclarationContainerImpl) owner : EmptyContainerForLocal.INSTANCE;
    }

    @Override // kotlin.jvm.internal.f0
    public d createKotlinClass(Class cls) {
        return new KClassImpl(cls);
    }

    @Override // kotlin.jvm.internal.f0
    public g function(j jVar) {
        return new KFunctionImpl(getOwner(jVar), jVar.getName(), jVar.getSignature(), jVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.f0
    public d getOrCreateKotlinClass(Class cls) {
        return KClassCacheKt.getOrCreateKotlinClass(cls);
    }

    @Override // kotlin.jvm.internal.f0
    public f getOrCreateKotlinPackage(Class cls, String str) {
        return new KPackageImpl(cls, str);
    }

    @Override // kotlin.jvm.internal.f0
    public i mutableProperty0(p pVar) {
        return new KMutableProperty0Impl(getOwner(pVar), pVar.getName(), pVar.getSignature(), pVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.f0
    public kotlin.j0.j mutableProperty1(q qVar) {
        return new KMutableProperty1Impl(getOwner(qVar), qVar.getName(), qVar.getSignature(), qVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.f0
    public k mutableProperty2(s sVar) {
        getOwner(sVar);
        throw null;
    }

    @Override // kotlin.jvm.internal.f0
    public n property0(v vVar) {
        getOwner(vVar);
        throw null;
    }

    @Override // kotlin.jvm.internal.f0
    public o property1(w wVar) {
        return new KProperty1Impl(getOwner(wVar), wVar.getName(), wVar.getSignature(), wVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.f0
    public kotlin.j0.p property2(y yVar) {
        getOwner(yVar);
        throw null;
    }

    @Override // kotlin.jvm.internal.f0
    public String renderLambdaToString(kotlin.jvm.internal.o oVar) {
        return renderLambdaToString((kotlin.jvm.internal.i) oVar);
    }

    @Override // kotlin.jvm.internal.f0
    public void setUpperBounds(r rVar, List<kotlin.j0.q> list) {
    }

    @Override // kotlin.jvm.internal.f0
    public kotlin.j0.q typeOf(e eVar, List<kotlin.j0.s> list, boolean z) {
        return kotlin.reflect.full.c.b(eVar, list, z, Collections.emptyList());
    }

    @Override // kotlin.jvm.internal.f0
    public r typeParameter(Object obj, String str, u uVar, boolean z) {
        List<r> typeParameters;
        if (obj instanceof d) {
            typeParameters = ((d) obj).getTypeParameters();
        } else if (obj instanceof kotlin.j0.c) {
            typeParameters = ((kotlin.j0.c) obj).getTypeParameters();
        } else {
            throw new IllegalArgumentException("Type parameter container must be a class or a callable: " + obj);
        }
        for (r rVar : typeParameters) {
            if (rVar.getName().equals(str)) {
                return rVar;
            }
        }
        throw new IllegalArgumentException("Type parameter " + str + " is not found in container: " + obj);
    }

    @Override // kotlin.jvm.internal.f0
    public d createKotlinClass(Class cls, String str) {
        return new KClassImpl(cls);
    }

    @Override // kotlin.jvm.internal.f0
    public d getOrCreateKotlinClass(Class cls, String str) {
        return KClassCacheKt.getOrCreateKotlinClass(cls);
    }

    @Override // kotlin.jvm.internal.f0
    public String renderLambdaToString(kotlin.jvm.internal.i iVar) {
        KFunctionImpl asKFunctionImpl;
        g a = kotlin.j0.b0.d.a(iVar);
        if (a != null && (asKFunctionImpl = UtilKt.asKFunctionImpl(a)) != null) {
            return ReflectionObjectRenderer.INSTANCE.renderLambda(asKFunctionImpl.getDescriptor());
        }
        return super.renderLambdaToString(iVar);
    }
}