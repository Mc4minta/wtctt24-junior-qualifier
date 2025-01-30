package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.g;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();
    final int a;

    /* renamed from: b  reason: collision with root package name */
    final long f377b;

    /* renamed from: c  reason: collision with root package name */
    final long f378c;

    /* renamed from: d  reason: collision with root package name */
    final float f379d;

    /* renamed from: e  reason: collision with root package name */
    final long f380e;

    /* renamed from: f  reason: collision with root package name */
    final int f381f;

    /* renamed from: g  reason: collision with root package name */
    final CharSequence f382g;

    /* renamed from: h  reason: collision with root package name */
    final long f383h;

    /* renamed from: j  reason: collision with root package name */
    List<CustomAction> f384j;

    /* renamed from: k  reason: collision with root package name */
    final long f385k;

    /* renamed from: l  reason: collision with root package name */
    final Bundle f386l;
    private Object m;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<PlaybackStateCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PlaybackStateCompat[] newArray(int i2) {
            return new PlaybackStateCompat[i2];
        }
    }

    PlaybackStateCompat(int i2, long j2, long j3, float f2, long j4, int i3, CharSequence charSequence, long j5, List<CustomAction> list, long j6, Bundle bundle) {
        this.a = i2;
        this.f377b = j2;
        this.f378c = j3;
        this.f379d = f2;
        this.f380e = j4;
        this.f381f = i3;
        this.f382g = charSequence;
        this.f383h = j5;
        this.f384j = new ArrayList(list);
        this.f385k = j6;
        this.f386l = bundle;
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> d2 = g.d(obj);
        if (d2 != null) {
            ArrayList arrayList2 = new ArrayList(d2.size());
            for (Object obj2 : d2) {
                arrayList2.add(CustomAction.a(obj2));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(g.i(obj), g.h(obj), g.c(obj), g.g(obj), g.a(obj), 0, g.e(obj), g.f(obj), arrayList, g.b(obj), Build.VERSION.SDK_INT >= 22 ? h.a(obj) : null);
        playbackStateCompat.m = obj;
        return playbackStateCompat;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.a + ", position=" + this.f377b + ", buffered position=" + this.f378c + ", speed=" + this.f379d + ", updated=" + this.f383h + ", actions=" + this.f380e + ", error code=" + this.f381f + ", error message=" + this.f382g + ", custom actions=" + this.f384j + ", active item id=" + this.f385k + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeLong(this.f377b);
        parcel.writeFloat(this.f379d);
        parcel.writeLong(this.f383h);
        parcel.writeLong(this.f378c);
        parcel.writeLong(this.f380e);
        TextUtils.writeToParcel(this.f382g, parcel, i2);
        parcel.writeTypedList(this.f384j);
        parcel.writeLong(this.f385k);
        parcel.writeBundle(this.f386l);
        parcel.writeInt(this.f381f);
    }

    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f387b;

        /* renamed from: c  reason: collision with root package name */
        private final int f388c;

        /* renamed from: d  reason: collision with root package name */
        private final Bundle f389d;

        /* renamed from: e  reason: collision with root package name */
        private Object f390e;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<CustomAction> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public CustomAction[] newArray(int i2) {
                return new CustomAction[i2];
            }
        }

        CustomAction(String str, CharSequence charSequence, int i2, Bundle bundle) {
            this.a = str;
            this.f387b = charSequence;
            this.f388c = i2;
            this.f389d = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(g.a.a(obj), g.a.d(obj), g.a.c(obj), g.a.b(obj));
            customAction.f390e = obj;
            return customAction;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f387b) + ", mIcon=" + this.f388c + ", mExtras=" + this.f389d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.a);
            TextUtils.writeToParcel(this.f387b, parcel, i2);
            parcel.writeInt(this.f388c);
            parcel.writeBundle(this.f389d);
        }

        CustomAction(Parcel parcel) {
            this.a = parcel.readString();
            this.f387b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f388c = parcel.readInt();
            this.f389d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.a = parcel.readInt();
        this.f377b = parcel.readLong();
        this.f379d = parcel.readFloat();
        this.f383h = parcel.readLong();
        this.f378c = parcel.readLong();
        this.f380e = parcel.readLong();
        this.f382g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f384j = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f385k = parcel.readLong();
        this.f386l = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f381f = parcel.readInt();
    }
}