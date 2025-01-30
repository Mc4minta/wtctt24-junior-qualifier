package c.h.i;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import c.h.i.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.http.HttpStatus;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontProvider.java */
/* loaded from: classes.dex */
public class c {
    private static final Comparator<byte[]> a = new a();

    /* compiled from: FontProvider.java */
    /* loaded from: classes.dex */
    class a implements Comparator<byte[]> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            int i2;
            int i3;
            if (bArr.length != bArr2.length) {
                i2 = bArr.length;
                i3 = bArr2.length;
            } else {
                for (int i4 = 0; i4 < bArr.length; i4++) {
                    if (bArr[i4] != bArr2[i4]) {
                        i2 = bArr[i4];
                        i3 = bArr2[i4];
                    }
                }
                return 0;
            }
            return i2 - i3;
        }
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean b(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    private static List<List<byte[]>> c(d dVar, Resources resources) {
        if (dVar.b() != null) {
            return dVar.b();
        }
        return androidx.core.content.d.c.c(resources, dVar.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f.a d(Context context, d dVar, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo e2 = e(context.getPackageManager(), dVar, context.getResources());
        if (e2 == null) {
            return f.a.a(1, null);
        }
        return f.a.a(0, f(context, dVar, e2.authority, cancellationSignal));
    }

    static ProviderInfo e(PackageManager packageManager, d dVar, Resources resources) throws PackageManager.NameNotFoundException {
        String e2 = dVar.e();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(e2, 0);
        if (resolveContentProvider != null) {
            if (resolveContentProvider.packageName.equals(dVar.f())) {
                List<byte[]> a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(a2, a);
                List<List<byte[]>> c2 = c(dVar, resources);
                for (int i2 = 0; i2 < c2.size(); i2++) {
                    ArrayList arrayList = new ArrayList(c2.get(i2));
                    Collections.sort(arrayList, a);
                    if (b(a2, arrayList)) {
                        return resolveContentProvider;
                    }
                }
                return null;
            }
            throw new PackageManager.NameNotFoundException("Found content provider " + e2 + ", but package was not " + dVar.f());
        }
        throw new PackageManager.NameNotFoundException("No package found for authority: " + e2);
    }

    static f.b[] f(Context context, d dVar, String str, CancellationSignal cancellationSignal) {
        int i2;
        Uri withAppendedId;
        boolean z;
        int i3;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
            int i4 = 0;
            if (Build.VERSION.SDK_INT > 16) {
                cursor = context.getContentResolver().query(build, strArr, "query = ?", new String[]{dVar.g()}, null, cancellationSignal);
            } else {
                cursor = context.getContentResolver().query(build, strArr, "query = ?", new String[]{dVar.g()}, null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i5 = columnIndex != -1 ? cursor.getInt(columnIndex) : i4;
                    int i6 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : i4;
                    if (columnIndex3 == -1) {
                        i2 = i5;
                        withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        i2 = i5;
                        withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    int i7 = columnIndex5 != -1 ? cursor.getInt(columnIndex5) : HttpStatus.SC_BAD_REQUEST;
                    if (columnIndex6 == -1 || cursor.getInt(columnIndex6) != 1) {
                        z = false;
                        i3 = i2;
                    } else {
                        i3 = i2;
                        z = true;
                    }
                    arrayList2.add(f.b.a(withAppendedId, i6, i7, z, i3));
                    i4 = 0;
                }
                arrayList = arrayList2;
            }
            return (f.b[]) arrayList.toArray(new f.b[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}