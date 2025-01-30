package kotlin.j0;

/* compiled from: KParameter.kt */
/* loaded from: classes3.dex */
public interface l extends b {

    /* compiled from: KParameter.kt */
    /* loaded from: classes3.dex */
    public enum a {
        INSTANCE,
        EXTENSION_RECEIVER,
        VALUE
    }

    int getIndex();

    a getKind();

    String getName();

    q getType();

    boolean isOptional();

    boolean isVararg();
}