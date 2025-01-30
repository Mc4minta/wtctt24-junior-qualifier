package com.coinbase.wallet.libraries.databases.model;

import android.content.Context;
import com.coinbase.wallet.libraries.databases.interfaces.StorageOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: MemoryOptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\t\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/libraries/databases/model/MemoryOptions;", "T", "Lcom/coinbase/wallet/libraries/databases/interfaces/StorageOptions;", "Landroid/content/Context;", "component1", "()Landroid/content/Context;", "Ljava/lang/Class;", "component2", "()Ljava/lang/Class;", "context", "providerClazz", "copy", "(Landroid/content/Context;Ljava/lang/Class;)Lcom/coinbase/wallet/libraries/databases/model/MemoryOptions;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Class;", "getProviderClazz", "Landroid/content/Context;", "getContext", "<init>", "(Landroid/content/Context;Ljava/lang/Class;)V", "database_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MemoryOptions<T> implements StorageOptions {
    private final Context context;
    private final Class<T> providerClazz;

    public MemoryOptions(Context context, Class<T> providerClazz) {
        m.g(context, "context");
        m.g(providerClazz, "providerClazz");
        this.context = context;
        this.providerClazz = providerClazz;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MemoryOptions copy$default(MemoryOptions memoryOptions, Context context, Class cls, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = memoryOptions.context;
        }
        if ((i2 & 2) != 0) {
            cls = memoryOptions.providerClazz;
        }
        return memoryOptions.copy(context, cls);
    }

    public final Context component1() {
        return this.context;
    }

    public final Class<T> component2() {
        return this.providerClazz;
    }

    public final MemoryOptions<T> copy(Context context, Class<T> providerClazz) {
        m.g(context, "context");
        m.g(providerClazz, "providerClazz");
        return new MemoryOptions<>(context, providerClazz);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MemoryOptions) {
            MemoryOptions memoryOptions = (MemoryOptions) obj;
            return m.c(this.context, memoryOptions.context) && m.c(this.providerClazz, memoryOptions.providerClazz);
        }
        return false;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Class<T> getProviderClazz() {
        return this.providerClazz;
    }

    public int hashCode() {
        return (this.context.hashCode() * 31) + this.providerClazz.hashCode();
    }

    public String toString() {
        return "MemoryOptions(context=" + this.context + ", providerClazz=" + this.providerClazz + ')';
    }
}