package kotlin.j0;

/* compiled from: KProperty.kt */
/* loaded from: classes3.dex */
public interface m<V> extends c<V> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes3.dex */
    public interface a<V> {
        m<V> getProperty();
    }

    /* compiled from: KProperty.kt */
    /* loaded from: classes3.dex */
    public interface b<V> extends a<V>, g<V> {
    }

    b<V> getGetter();

    boolean isConst();

    boolean isLateinit();
}