package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.k;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Navigator.java */
/* loaded from: classes.dex */
public abstract class s<D extends k> {

    /* compiled from: Navigator.java */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: Navigator.java */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface b {
        String value();
    }

    public abstract D createDestination();

    public abstract k navigate(D d2, Bundle bundle, p pVar, a aVar);

    public void onRestoreState(Bundle bundle) {
    }

    public Bundle onSaveState() {
        return null;
    }

    public abstract boolean popBackStack();
}