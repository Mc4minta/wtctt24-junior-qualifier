package com.squareup.moshi;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.NonNullJsonAdapter;
import com.squareup.moshi.internal.NullSafeJsonAdapter;
import kotlin.Metadata;
import kotlin.j0.q;
import kotlin.j0.z;
import kotlin.jvm.internal.m;

/* compiled from: -MoshiKotlinExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a*\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0003\u0010\n¨\u0006\u000b"}, d2 = {"T", "Lcom/squareup/moshi/Moshi;", "Lcom/squareup/moshi/JsonAdapter;", "adapter", "(Lcom/squareup/moshi/Moshi;)Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/Moshi$Builder;", "addAdapter", "(Lcom/squareup/moshi/Moshi$Builder;Lcom/squareup/moshi/JsonAdapter;)Lcom/squareup/moshi/Moshi$Builder;", "Lkotlin/j0/q;", "ktype", "(Lcom/squareup/moshi/Moshi;Lkotlin/j0/q;)Lcom/squareup/moshi/JsonAdapter;", "moshi"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class _MoshiKotlinExtensionsKt {
    public static final /* synthetic */ <T> JsonAdapter<T> adapter(Moshi adapter) {
        m.g(adapter, "$this$adapter");
        m.l(6, "T");
        return adapter(adapter, null);
    }

    public static final /* synthetic */ <T> Moshi.Builder addAdapter(Moshi.Builder addAdapter, JsonAdapter<T> adapter) {
        m.g(addAdapter, "$this$addAdapter");
        m.g(adapter, "adapter");
        m.l(6, "T");
        Moshi.Builder add = addAdapter.add(z.f(null), adapter);
        m.f(add, "add(typeOf<T>().javaType, adapter)");
        return add;
    }

    public static final <T> JsonAdapter<T> adapter(Moshi adapter, q ktype) {
        m.g(adapter, "$this$adapter");
        m.g(ktype, "ktype");
        JsonAdapter<T> adapter2 = adapter.adapter(z.f(ktype));
        if (!(adapter2 instanceof NullSafeJsonAdapter) && !(adapter2 instanceof NonNullJsonAdapter)) {
            if (ktype.isMarkedNullable()) {
                adapter2 = adapter2.nullSafe();
            } else {
                adapter2 = adapter2.nonNull();
            }
            m.f(adapter2, "if (ktype.isMarkedNullab…    adapter.nonNull()\n  }");
        }
        return adapter2;
    }
}