package com.coinbase.wallet.commonui.extensions;

import android.os.Bundle;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.apache.http.message.TokenParser;

/* compiled from: Bundle+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u001a%\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\n\u001a\u00020\u0003*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroid/os/Parcelable;", "T", "Landroid/os/Bundle;", "", ApiConstants.NAME, "requireParcelable", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "", "requireParcelableList", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/util/List;", "requireString", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;", "commonui_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Bundle_CommonKt {
    public static final <T extends Parcelable> T requireParcelable(Bundle bundle, String name) {
        m.g(name, "name");
        Objects.requireNonNull(bundle, "Bundle is null");
        if (bundle.containsKey(name)) {
            T t = (T) bundle.getParcelable(name);
            if (t != null) {
                return t;
            }
            throw new NullPointerException("Bundle Parcelable is null: \"" + name + TokenParser.DQUOTE);
        }
        throw new RuntimeException("Bundle does not have Parcelable: \"" + name + TokenParser.DQUOTE);
    }

    public static final <T extends Parcelable> List<T> requireParcelableList(Bundle bundle, String name) {
        m.g(name, "name");
        Objects.requireNonNull(bundle, "Bundle is null");
        if (bundle.containsKey(name)) {
            ArrayList<T> parcelableArrayList = bundle.getParcelableArrayList(name);
            if (parcelableArrayList != null) {
                return parcelableArrayList;
            }
            throw new NullPointerException("Bundle Parcelable is null: \"" + name + TokenParser.DQUOTE);
        }
        throw new RuntimeException("Bundle does not have Parcelable: \"" + name + TokenParser.DQUOTE);
    }

    public static final String requireString(Bundle bundle, String name) {
        m.g(name, "name");
        Objects.requireNonNull(bundle, "Bundle is null");
        if (bundle.containsKey(name)) {
            String string = bundle.getString(name);
            if (string != null) {
                return string;
            }
            throw new NullPointerException("Bundle String is null: \"" + name + TokenParser.DQUOTE);
        }
        throw new RuntimeException("Bundle does not have String: \"" + name + TokenParser.DQUOTE);
    }
}