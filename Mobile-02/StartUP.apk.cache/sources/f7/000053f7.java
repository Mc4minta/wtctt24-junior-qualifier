package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Modality.kt */
/* loaded from: classes3.dex */
public enum Modality {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;
    
    public static final Companion Companion = new Companion(null);

    /* compiled from: Modality.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Modality convertFromFlags(boolean z, boolean z2, boolean z3) {
            if (z) {
                return Modality.SEALED;
            }
            if (z2) {
                return Modality.ABSTRACT;
            }
            if (z3) {
                return Modality.OPEN;
            }
            return Modality.FINAL;
        }
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static Modality[] valuesCustom() {
        Modality[] valuesCustom = values();
        Modality[] modalityArr = new Modality[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, modalityArr, 0, valuesCustom.length);
        return modalityArr;
    }
}