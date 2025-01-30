package com.coinbase.wallet.store.models;

import com.coinbase.ApiConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: StoreKey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B;\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0019\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/coinbase/wallet/store/models/StoreKey;", "T", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/coinbase/wallet/store/models/StoreKind;", "kind", "Lcom/coinbase/wallet/store/models/StoreKind;", "getKind", "()Lcom/coinbase/wallet/store/models/StoreKind;", "Ljava/lang/Class;", "clazz", "Ljava/lang/Class;", "getClazz", "()Ljava/lang/Class;", "syncNow", "Z", "getSyncNow", "()Z", "", ApiConstants.NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "id", "uuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/coinbase/wallet/store/models/StoreKind;Ljava/lang/Class;)V", "store_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class StoreKey<T> {
    private final Class<T> clazz;
    private final StoreKind kind;
    private final String name;
    private final boolean syncNow;

    public StoreKey(String id, String str, boolean z, StoreKind kind, Class<T> clazz) {
        List l2;
        String h0;
        m.g(id, "id");
        m.g(kind, "kind");
        m.g(clazz, "clazz");
        this.syncNow = z;
        this.kind = kind;
        this.clazz = clazz;
        l2 = r.l(kind.name(), id, str, clazz.getSimpleName());
        h0 = z.h0(l2, "_", null, null, 0, null, null, 62, null);
        this.name = h0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StoreKey) {
            return m.c(this.name, ((StoreKey) obj).name);
        }
        return false;
    }

    public final Class<T> getClazz() {
        return this.clazz;
    }

    public final StoreKind getKind() {
        return this.kind;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getSyncNow() {
        return this.syncNow;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public /* synthetic */ StoreKey(String str, String str2, boolean z, StoreKind storeKind, Class cls, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? false : z, storeKind, cls);
    }
}