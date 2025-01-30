package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder.java */
/* loaded from: classes.dex */
public final class q implements Iterable<Intent> {
    private final ArrayList<Intent> a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f1488b;

    /* compiled from: TaskStackBuilder.java */
    /* loaded from: classes.dex */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private q(Context context) {
        this.f1488b = context;
    }

    public static q m(Context context) {
        return new q(context);
    }

    public q h(Intent intent) {
        this.a.add(intent);
        return this;
    }

    public q i(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f1488b.getPackageManager());
        }
        if (component != null) {
            l(component);
        }
        h(intent);
        return this;
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.a.iterator();
    }

    public q k(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = h.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f1488b.getPackageManager());
            }
            l(component);
            h(supportParentActivityIntent);
        }
        return this;
    }

    public q l(ComponentName componentName) {
        int size = this.a.size();
        try {
            Intent b2 = h.b(this.f1488b, componentName);
            while (b2 != null) {
                this.a.add(size, b2);
                b2 = h.b(this.f1488b, b2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    public Intent o(int i2) {
        return this.a.get(i2);
    }

    public int p() {
        return this.a.size();
    }

    public void q() {
        r(null);
    }

    public void r(Bundle bundle) {
        if (!this.a.isEmpty()) {
            ArrayList<Intent> arrayList = this.a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (androidx.core.content.a.k(this.f1488b, intentArr, bundle)) {
                return;
            }
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f1488b.startActivity(intent);
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}