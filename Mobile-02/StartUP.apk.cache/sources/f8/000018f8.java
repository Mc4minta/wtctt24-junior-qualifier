package com.coinbase.wallet.core.extensions;

import kotlin.Metadata;

/* compiled from: Strings+Core.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"!\u0010\f\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\u0005\"!\u0010\u000f\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u0005\"!\u0010\u0012\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/core/extensions/Strings;", "", "at$delegate", "Lkotlin/h;", "getAt", "(Lcom/coinbase/wallet/core/extensions/Strings;)Ljava/lang/String;", "at", "ellipsis$delegate", "getEllipsis", "ellipsis", "period$delegate", "getPeriod", "period", "empty$delegate", "getEmpty", "empty", "space$delegate", "getSpace", "space", "core_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Strings_CoreKt {
    private static final kotlin.h empty$delegate = kotlin.j.b(Strings_CoreKt$empty$2.INSTANCE);
    private static final kotlin.h ellipsis$delegate = kotlin.j.b(Strings_CoreKt$ellipsis$2.INSTANCE);
    private static final kotlin.h space$delegate = kotlin.j.b(Strings_CoreKt$space$2.INSTANCE);
    private static final kotlin.h period$delegate = kotlin.j.b(Strings_CoreKt$period$2.INSTANCE);
    private static final kotlin.h at$delegate = kotlin.j.b(Strings_CoreKt$at$2.INSTANCE);

    public static final String getAt(Strings strings) {
        kotlin.jvm.internal.m.g(strings, "<this>");
        return (String) at$delegate.getValue();
    }

    public static final String getEllipsis(Strings strings) {
        kotlin.jvm.internal.m.g(strings, "<this>");
        return (String) ellipsis$delegate.getValue();
    }

    public static final String getEmpty(Strings strings) {
        kotlin.jvm.internal.m.g(strings, "<this>");
        return (String) empty$delegate.getValue();
    }

    public static final String getPeriod(Strings strings) {
        kotlin.jvm.internal.m.g(strings, "<this>");
        return (String) period$delegate.getValue();
    }

    public static final String getSpace(Strings strings) {
        kotlin.jvm.internal.m.g(strings, "<this>");
        return (String) space$delegate.getValue();
    }
}