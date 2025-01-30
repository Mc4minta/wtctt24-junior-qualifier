package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* compiled from: KotlinRetention.kt */
/* loaded from: classes3.dex */
public enum KotlinRetention {
    RUNTIME,
    BINARY,
    SOURCE;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static KotlinRetention[] valuesCustom() {
        KotlinRetention[] valuesCustom = values();
        KotlinRetention[] kotlinRetentionArr = new KotlinRetention[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, kotlinRetentionArr, 0, valuesCustom.length);
        return kotlinRetentionArr;
    }
}