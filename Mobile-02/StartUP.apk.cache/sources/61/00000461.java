package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* compiled from: VersionedParcelParcel.java */
/* loaded from: classes.dex */
class a extends VersionedParcel {

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f2367d;

    /* renamed from: e  reason: collision with root package name */
    private final Parcel f2368e;

    /* renamed from: f  reason: collision with root package name */
    private final int f2369f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2370g;

    /* renamed from: h  reason: collision with root package name */
    private final String f2371h;

    /* renamed from: i  reason: collision with root package name */
    private int f2372i;

    /* renamed from: j  reason: collision with root package name */
    private int f2373j;

    /* renamed from: k  reason: collision with root package name */
    private int f2374k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new c.e.a(), new c.e.a(), new c.e.a());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void A(byte[] bArr) {
        if (bArr != null) {
            this.f2368e.writeInt(bArr.length);
            this.f2368e.writeByteArray(bArr);
            return;
        }
        this.f2368e.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f2368e, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void E(int i2) {
        this.f2368e.writeInt(i2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void G(Parcelable parcelable) {
        this.f2368e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void I(String str) {
        this.f2368e.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        int i2 = this.f2372i;
        if (i2 >= 0) {
            int i3 = this.f2367d.get(i2);
            int dataPosition = this.f2368e.dataPosition();
            this.f2368e.setDataPosition(i3);
            this.f2368e.writeInt(dataPosition - i3);
            this.f2368e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel b() {
        Parcel parcel = this.f2368e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f2373j;
        if (i2 == this.f2369f) {
            i2 = this.f2370g;
        }
        int i3 = i2;
        return new a(parcel, dataPosition, i3, this.f2371h + "  ", this.a, this.f2365b, this.f2366c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean g() {
        return this.f2368e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] i() {
        int readInt = this.f2368e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f2368e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f2368e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean m(int i2) {
        while (this.f2373j < this.f2370g) {
            int i3 = this.f2374k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f2368e.setDataPosition(this.f2373j);
            int readInt = this.f2368e.readInt();
            this.f2374k = this.f2368e.readInt();
            this.f2373j += readInt;
        }
        return this.f2374k == i2;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int o() {
        return this.f2368e.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T q() {
        return (T) this.f2368e.readParcelable(a.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String s() {
        return this.f2368e.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void w(int i2) {
        a();
        this.f2372i = i2;
        this.f2367d.put(i2, this.f2368e.dataPosition());
        E(0);
        E(i2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void y(boolean z) {
        this.f2368e.writeInt(z ? 1 : 0);
    }

    private a(Parcel parcel, int i2, int i3, String str, c.e.a<String, Method> aVar, c.e.a<String, Method> aVar2, c.e.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f2367d = new SparseIntArray();
        this.f2372i = -1;
        this.f2373j = 0;
        this.f2374k = -1;
        this.f2368e = parcel;
        this.f2369f = i2;
        this.f2370g = i3;
        this.f2373j = i2;
        this.f2371h = str;
    }
}