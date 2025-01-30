package kotlin.reflect.jvm.internal.impl.name;

/* compiled from: FqNamesUtil.kt */
/* loaded from: classes3.dex */
enum State {
    BEGINNING,
    MIDDLE,
    AFTER_DOT;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static State[] valuesCustom() {
        State[] valuesCustom = values();
        State[] stateArr = new State[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, stateArr, 0, valuesCustom.length);
        return stateArr;
    }
}