package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.u;
import androidx.lifecycle.i;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackStackState.java */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    final int[] a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<String> f1598b;

    /* renamed from: c  reason: collision with root package name */
    final int[] f1599c;

    /* renamed from: d  reason: collision with root package name */
    final int[] f1600d;

    /* renamed from: e  reason: collision with root package name */
    final int f1601e;

    /* renamed from: f  reason: collision with root package name */
    final String f1602f;

    /* renamed from: g  reason: collision with root package name */
    final int f1603g;

    /* renamed from: h  reason: collision with root package name */
    final int f1604h;

    /* renamed from: j  reason: collision with root package name */
    final CharSequence f1605j;

    /* renamed from: k  reason: collision with root package name */
    final int f1606k;

    /* renamed from: l  reason: collision with root package name */
    final CharSequence f1607l;
    final ArrayList<String> m;
    final ArrayList<String> n;
    final boolean p;

    /* compiled from: BackStackState.java */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public b[] newArray(int i2) {
            return new b[i2];
        }
    }

    public b(androidx.fragment.app.a aVar) {
        int size = aVar.f1678c.size();
        this.a = new int[size * 5];
        if (aVar.f1684i) {
            this.f1598b = new ArrayList<>(size);
            this.f1599c = new int[size];
            this.f1600d = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                u.a aVar2 = aVar.f1678c.get(i2);
                int i4 = i3 + 1;
                this.a[i3] = aVar2.a;
                ArrayList<String> arrayList = this.f1598b;
                Fragment fragment = aVar2.f1688b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.a;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.f1689c;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.f1690d;
                int i7 = i6 + 1;
                iArr[i6] = aVar2.f1691e;
                iArr[i7] = aVar2.f1692f;
                this.f1599c[i2] = aVar2.f1693g.ordinal();
                this.f1600d[i2] = aVar2.f1694h.ordinal();
                i2++;
                i3 = i7 + 1;
            }
            this.f1601e = aVar.f1683h;
            this.f1602f = aVar.f1686k;
            this.f1603g = aVar.v;
            this.f1604h = aVar.f1687l;
            this.f1605j = aVar.m;
            this.f1606k = aVar.n;
            this.f1607l = aVar.o;
            this.m = aVar.p;
            this.n = aVar.q;
            this.p = aVar.r;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public androidx.fragment.app.a a(m mVar) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(mVar);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.a.length) {
            u.a aVar2 = new u.a();
            int i4 = i2 + 1;
            aVar2.a = this.a[i2];
            if (m.r0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i3 + " base fragment #" + this.a[i4]);
            }
            String str = this.f1598b.get(i3);
            if (str != null) {
                aVar2.f1688b = mVar.X(str);
            } else {
                aVar2.f1688b = null;
            }
            aVar2.f1693g = i.b.values()[this.f1599c[i3]];
            aVar2.f1694h = i.b.values()[this.f1600d[i3]];
            int[] iArr = this.a;
            int i5 = i4 + 1;
            int i6 = iArr[i4];
            aVar2.f1689c = i6;
            int i7 = i5 + 1;
            int i8 = iArr[i5];
            aVar2.f1690d = i8;
            int i9 = i7 + 1;
            int i10 = iArr[i7];
            aVar2.f1691e = i10;
            int i11 = iArr[i9];
            aVar2.f1692f = i11;
            aVar.f1679d = i6;
            aVar.f1680e = i8;
            aVar.f1681f = i10;
            aVar.f1682g = i11;
            aVar.f(aVar2);
            i3++;
            i2 = i9 + 1;
        }
        aVar.f1683h = this.f1601e;
        aVar.f1686k = this.f1602f;
        aVar.v = this.f1603g;
        aVar.f1684i = true;
        aVar.f1687l = this.f1604h;
        aVar.m = this.f1605j;
        aVar.n = this.f1606k;
        aVar.o = this.f1607l;
        aVar.p = this.m;
        aVar.q = this.n;
        aVar.r = this.p;
        aVar.B(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.a);
        parcel.writeStringList(this.f1598b);
        parcel.writeIntArray(this.f1599c);
        parcel.writeIntArray(this.f1600d);
        parcel.writeInt(this.f1601e);
        parcel.writeString(this.f1602f);
        parcel.writeInt(this.f1603g);
        parcel.writeInt(this.f1604h);
        TextUtils.writeToParcel(this.f1605j, parcel, 0);
        parcel.writeInt(this.f1606k);
        TextUtils.writeToParcel(this.f1607l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.p ? 1 : 0);
    }

    public b(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.f1598b = parcel.createStringArrayList();
        this.f1599c = parcel.createIntArray();
        this.f1600d = parcel.createIntArray();
        this.f1601e = parcel.readInt();
        this.f1602f = parcel.readString();
        this.f1603g = parcel.readInt();
        this.f1604h = parcel.readInt();
        this.f1605j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1606k = parcel.readInt();
        this.f1607l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.p = parcel.readInt() != 0;
    }
}