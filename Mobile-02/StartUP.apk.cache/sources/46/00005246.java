package kotlin.jvm.internal;

/* compiled from: FunctionReference.java */
/* loaded from: classes3.dex */
public class j extends c implements i, kotlin.j0.g {
    private final int arity;
    private final int flags;

    public j(int i2) {
        this(i2, c.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.c
    protected kotlin.j0.c computeReflected() {
        return e0.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            return m.c(getOwner(), jVar.getOwner()) && getName().equals(jVar.getName()) && getSignature().equals(jVar.getSignature()) && this.flags == jVar.flags && this.arity == jVar.arity && m.c(getBoundReceiver(), jVar.getBoundReceiver());
        } else if (obj instanceof kotlin.j0.g) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    @Override // kotlin.jvm.internal.i
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // kotlin.j0.g
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // kotlin.j0.g
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // kotlin.j0.g
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // kotlin.j0.g
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.c, kotlin.j0.c
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        kotlin.j0.c compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public j(int i2, Object obj) {
        this(i2, obj, null, null, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c
    public kotlin.j0.g getReflected() {
        return (kotlin.j0.g) super.getReflected();
    }

    public j(int i2, Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.arity = i2;
        this.flags = i3 >> 1;
    }
}