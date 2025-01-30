package e.j.k.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.stellar.extensions.TxMetadataKey_StellarKt;
import e.j.k.a.b;
import java.math.BigInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.b0;
import kotlin.l0.d;
import org.toshi.R;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum b uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:289)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: StellarMemoType.kt */
/* loaded from: classes2.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR;
    public static final C0323a a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f13693b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f13694c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f13695d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f13696e;

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ a[] f13697f;

    /* renamed from: g  reason: collision with root package name */
    private final TxMetadataKey f13698g;

    /* compiled from: StellarMemoType.kt */
    /* renamed from: e.j.k.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0323a {
        private C0323a() {
        }

        public /* synthetic */ C0323a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(TxMetadataKey txMetadataKey) {
            a[] values;
            m.g(txMetadataKey, "txMetadataKey");
            for (a aVar : a.values()) {
                if (m.c(aVar.q(), txMetadataKey)) {
                    return aVar;
                }
            }
            return null;
        }
    }

    /* compiled from: StellarMemoType.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.f13693b.ordinal()] = 1;
            iArr[a.f13694c.ordinal()] = 2;
            iArr[a.f13696e.ordinal()] = 3;
            iArr[a.f13695d.ordinal()] = 4;
            a = iArr;
        }
    }

    static {
        TxMetadataKey.Companion companion = TxMetadataKey.Companion;
        f13693b = new a("MEMO_TEXT", 0, TxMetadataKey_StellarKt.getMemoText(companion));
        f13694c = new a("MEMO_ID", 1, TxMetadataKey_StellarKt.getMemoId(companion));
        f13695d = new a("MEMO_RETURN", 2, TxMetadataKey_StellarKt.getMemoReturn(companion));
        f13696e = new a("MEMO_HASH", 3, TxMetadataKey_StellarKt.getMemoHash(companion));
        f13697f = h();
        a = new C0323a(null);
        CREATOR = new Parcelable.Creator<a>() { // from class: e.j.k.a.a.b
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final a createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return a.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final a[] newArray(int i2) {
                return new a[i2];
            }
        };
    }

    private a(String str, int i2, TxMetadataKey txMetadataKey) {
        this.f13698g = txMetadataKey;
    }

    private static final /* synthetic */ a[] h() {
        return new a[]{f13693b, f13694c, f13695d, f13696e};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f13697f.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String n() {
        int i2 = c.a[ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        return "Memo Return";
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return "Memo Hash";
            }
            return "Memo ID";
        }
        return "Memo Text";
    }

    public final TxMetadataKey q() {
        return this.f13698g;
    }

    public final e.j.k.a.b s(String value) {
        b.C0324b c0324b;
        m.g(value, "value");
        int i2 = c.a[ordinal()];
        if (i2 == 1) {
            byte[] bytes = value.getBytes(d.a);
            m.f(bytes, "(this as java.lang.String).getBytes(charset)");
            if (bytes.length <= 28) {
                c0324b = new b.C0324b(this.f13698g, value);
            } else {
                return new b.a(LocalizedStrings.INSTANCE.get(R.string.send_destination_stellar_metadata_too_long));
            }
        } else if (i2 == 2) {
            try {
                b0.d(value);
                c0324b = new b.C0324b(this.f13698g, new BigInteger(value));
            } catch (NumberFormatException unused) {
                return new b.a(LocalizedStrings.INSTANCE.get(R.string.send_destination_metadata_number_format));
            }
        } else if (i2 != 3 && i2 != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            if (!String_CoreKt.isHexString(value)) {
                return new b.a(LocalizedStrings.INSTANCE.get(R.string.send_destination_stellar_metadata_hex_format));
            }
            if (value.length() != 64) {
                return new b.a(LocalizedStrings.INSTANCE.get(R.string.send_destination_stellar_metadata_hex_length));
            }
            c0324b = new b.C0324b(this.f13698g, value);
        }
        return c0324b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(name());
    }
}