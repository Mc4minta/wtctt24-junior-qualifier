package com.coinbase.wallet.common.extensions;

import androidx.lifecycle.z;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SavedStateHandle+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "Landroidx/lifecycle/z;", "", "key", "require", "(Landroidx/lifecycle/z;Ljava/lang/String;)Ljava/lang/Object;", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SavedStateHandle_CommonKt {
    public static final <T> T require(z zVar, String key) {
        m.g(zVar, "<this>");
        m.g(key, "key");
        T t = (T) zVar.b(key);
        if (t != null) {
            return t;
        }
        throw new Exception(m.o("No value found for key=", key));
    }
}