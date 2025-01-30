package e.j.f;

import android.os.Bundle;
import android.os.Parcelable;
import com.coinbase.wallet.commonui.extensions.Bundle_CommonKt;
import java.io.Serializable;
import java.util.Objects;
import org.apache.http.message.TokenParser;

/* compiled from: BundleExtensions.kt */
/* loaded from: classes2.dex */
public final class e {
    public static final boolean a(Bundle bundle, String name) {
        kotlin.jvm.internal.m.g(name, "name");
        Objects.requireNonNull(bundle, "Bundle is null");
        if (bundle.containsKey(name)) {
            return bundle.getBoolean(name);
        }
        throw new RuntimeException("Bundle does not have Boolean: \"" + name + TokenParser.DQUOTE);
    }

    public static final <T extends Parcelable> T b(Bundle bundle, String name) {
        kotlin.jvm.internal.m.g(name, "name");
        return (T) Bundle_CommonKt.requireParcelable(bundle, name);
    }

    public static final Serializable c(Bundle bundle, String name) {
        kotlin.jvm.internal.m.g(name, "name");
        Objects.requireNonNull(bundle, "Bundle is null");
        if (bundle.containsKey(name)) {
            Serializable serializable = bundle.getSerializable(name);
            if (serializable != null) {
                return serializable;
            }
            throw new NullPointerException("Bundle Serializable is null: \"" + name + TokenParser.DQUOTE);
        }
        throw new RuntimeException("Bundle does not have Serializable: \"" + name + TokenParser.DQUOTE);
    }

    public static final String d(Bundle bundle, String name) {
        kotlin.jvm.internal.m.g(name, "name");
        return Bundle_CommonKt.requireString(bundle, name);
    }
}