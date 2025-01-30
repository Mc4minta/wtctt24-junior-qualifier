package kotlin.jvm.internal;

/* compiled from: PropertyReference.java */
/* loaded from: classes3.dex */
public abstract class z extends c implements kotlin.j0.m {
    public z() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z) {
            z zVar = (z) obj;
            return getOwner().equals(zVar.getOwner()) && getName().equals(zVar.getName()) && getSignature().equals(zVar.getSignature()) && m.c(getBoundReceiver(), zVar.getBoundReceiver());
        } else if (obj instanceof kotlin.j0.m) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // kotlin.j0.m
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // kotlin.j0.m
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        kotlin.j0.c compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    public z(Object obj) {
        super(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c
    public kotlin.j0.m getReflected() {
        return (kotlin.j0.m) super.getReflected();
    }

    public z(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
    }
}