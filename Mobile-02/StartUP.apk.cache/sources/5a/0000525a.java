package kotlin.jvm.internal;

/* compiled from: MutablePropertyReference1Impl.java */
/* loaded from: classes3.dex */
public class r extends q {
    public r(kotlin.j0.f fVar, String str, String str2) {
        super(c.NO_RECEIVER, ((d) fVar).getJClass(), str, str2, !(fVar instanceof kotlin.j0.d) ? 1 : 0);
    }

    @Override // kotlin.j0.o
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    @Override // kotlin.j0.j
    public void set(Object obj, Object obj2) {
        getSetter().call(obj, obj2);
    }
}