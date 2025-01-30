package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.j;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.spongycastle.i18n.MessageBundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationCompatJellybean.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: b  reason: collision with root package name */
    private static Field f1456b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f1457c;
    private static final Object a = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static final Object f1458d = new Object();

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle b(j.a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat e2 = aVar.e();
        bundle2.putInt("icon", e2 != null ? e2.e() : 0);
        bundle2.putCharSequence(MessageBundle.TITLE_ENTRY, aVar.i());
        bundle2.putParcelable("actionIntent", aVar.a());
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", e(aVar.f()));
        bundle2.putBoolean("showsUserInterface", aVar.h());
        bundle2.putInt("semanticAction", aVar.g());
        return bundle2;
    }

    public static Bundle c(Notification notification) {
        synchronized (a) {
            if (f1457c) {
                return null;
            }
            try {
                if (f1456b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f1457c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f1456b = declaredField;
                }
                Bundle bundle = (Bundle) f1456b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f1456b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f1457c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.e("NotificationCompat", "Unable to access notification extras", e3);
                f1457c = true;
                return null;
            }
        }
    }

    private static Bundle d(o oVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", oVar.i());
        bundle.putCharSequence("label", oVar.h());
        bundle.putCharSequenceArray("choices", oVar.e());
        bundle.putBoolean("allowFreeFormInput", oVar.c());
        bundle.putBundle("extras", oVar.g());
        Set<String> d2 = oVar.d();
        if (d2 != null && !d2.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(d2.size());
            for (String str : d2) {
                arrayList.add(str);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] e(o[] oVarArr) {
        if (oVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[oVarArr.length];
        for (int i2 = 0; i2 < oVarArr.length; i2++) {
            bundleArr[i2] = d(oVarArr[i2]);
        }
        return bundleArr;
    }

    public static Bundle f(Notification.Builder builder, j.a aVar) {
        IconCompat e2 = aVar.e();
        builder.addAction(e2 != null ? e2.e() : 0, aVar.i(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", e(aVar.f()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", e(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }
}