package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.t;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
@KeepName
/* loaded from: classes2.dex */
public final class DataHolder extends com.google.android.gms.common.internal.safeparcel.a implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new b();
    private static final a a = new com.google.android.gms.common.data.a(new String[0], null);

    /* renamed from: b  reason: collision with root package name */
    private final int f6160b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f6161c;

    /* renamed from: d  reason: collision with root package name */
    private Bundle f6162d;

    /* renamed from: e  reason: collision with root package name */
    private final CursorWindow[] f6163e;

    /* renamed from: f  reason: collision with root package name */
    private final int f6164f;

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f6165g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f6166h;

    /* renamed from: j  reason: collision with root package name */
    private int f6167j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6168k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f6169l = true;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public static class zaa extends RuntimeException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataHolder(int i2, String[] strArr, CursorWindow[] cursorWindowArr, int i3, Bundle bundle) {
        this.f6160b = i2;
        this.f6161c = strArr;
        this.f6163e = cursorWindowArr;
        this.f6164f = i3;
        this.f6165g = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (!this.f6168k) {
                this.f6168k = true;
                int i2 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.f6163e;
                    if (i2 >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i2].close();
                    i2++;
                }
            }
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.f6169l && this.f6163e.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA256);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle i1() {
        return this.f6165g;
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.f6168k;
        }
        return z;
    }

    public final int j1() {
        return this.f6164f;
    }

    public final void k1() {
        this.f6162d = new Bundle();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = this.f6161c;
            if (i3 >= strArr.length) {
                break;
            }
            this.f6162d.putInt(strArr[i3], i3);
            i3++;
        }
        this.f6166h = new int[this.f6163e.length];
        int i4 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.f6163e;
            if (i2 < cursorWindowArr.length) {
                this.f6166h[i2] = i4;
                i4 += this.f6163e[i2].getNumRows() - (i4 - cursorWindowArr[i2].getStartPosition());
                i2++;
            } else {
                this.f6167j = i4;
                return;
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.r(parcel, 1, this.f6161c, false);
        com.google.android.gms.common.internal.safeparcel.b.t(parcel, 2, this.f6163e, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 3, j1());
        com.google.android.gms.common.internal.safeparcel.b.e(parcel, 4, i1(), false);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, RNCWebViewManager.COMMAND_CLEAR_FORM_DATA, this.f6160b);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a2);
        if ((i2 & 1) != 0) {
            close();
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public static class a {
        private final String[] a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<HashMap<String, Object>> f6170b;

        /* renamed from: c  reason: collision with root package name */
        private final String f6171c;

        /* renamed from: d  reason: collision with root package name */
        private final HashMap<Object, Integer> f6172d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6173e;

        /* renamed from: f  reason: collision with root package name */
        private String f6174f;

        private a(String[] strArr, String str) {
            this.a = (String[]) t.k(strArr);
            this.f6170b = new ArrayList<>();
            this.f6171c = str;
            this.f6172d = new HashMap<>();
            this.f6173e = false;
            this.f6174f = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(String[] strArr, String str, com.google.android.gms.common.data.a aVar) {
            this(strArr, null);
        }
    }
}