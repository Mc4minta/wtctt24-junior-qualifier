package e.j.k.a;

import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: StellarMemoValidationResult.kt */
/* loaded from: classes2.dex */
public abstract class b {

    /* compiled from: StellarMemoValidationResult.kt */
    /* loaded from: classes2.dex */
    public static final class a extends b {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String message) {
            super(null);
            m.g(message, "message");
            this.a = message;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && m.c(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Error(message=" + this.a + ')';
        }
    }

    /* compiled from: StellarMemoValidationResult.kt */
    /* renamed from: e.j.k.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0324b extends b {
        private final TxMetadataKey a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f13699b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0324b(TxMetadataKey txMetaDatKey, Object value) {
            super(null);
            m.g(txMetaDatKey, "txMetaDatKey");
            m.g(value, "value");
            this.a = txMetaDatKey;
            this.f13699b = value;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C0324b) {
                C0324b c0324b = (C0324b) obj;
                return m.c(this.a, c0324b.a) && m.c(this.f13699b, c0324b.f13699b);
            }
            return false;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.f13699b.hashCode();
        }

        public String toString() {
            return "Success(txMetaDatKey=" + this.a + ", value=" + this.f13699b + ')';
        }
    }

    private b() {
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}