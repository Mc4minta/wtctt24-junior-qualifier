package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* compiled from: CallableReference.java */
/* loaded from: classes3.dex */
public abstract class c implements kotlin.j0.c, Serializable {
    public static final Object NO_RECEIVER = a.a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient kotlin.j0.c reflected;
    private final String signature;

    /* compiled from: CallableReference.java */
    /* loaded from: classes3.dex */
    private static class a implements Serializable {
        private static final a a = new a();

        private a() {
        }
    }

    public c() {
        this(NO_RECEIVER);
    }

    @Override // kotlin.j0.c
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // kotlin.j0.c
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public kotlin.j0.c compute() {
        kotlin.j0.c cVar = this.reflected;
        if (cVar == null) {
            kotlin.j0.c computeReflected = computeReflected();
            this.reflected = computeReflected;
            return computeReflected;
        }
        return cVar;
    }

    protected abstract kotlin.j0.c computeReflected();

    @Override // kotlin.j0.b
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // kotlin.j0.c
    public String getName() {
        return this.name;
    }

    public kotlin.j0.f getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? e0.c(cls) : e0.b(cls);
    }

    @Override // kotlin.j0.c
    public List<kotlin.j0.l> getParameters() {
        return getReflected().getParameters();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public kotlin.j0.c getReflected() {
        kotlin.j0.c compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new kotlin.e0.b();
    }

    @Override // kotlin.j0.c
    public kotlin.j0.q getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // kotlin.j0.c
    public List<kotlin.j0.r> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // kotlin.j0.c
    public kotlin.j0.v getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // kotlin.j0.c
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // kotlin.j0.c
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // kotlin.j0.c
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // kotlin.j0.c
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Object obj) {
        this(obj, null, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }
}