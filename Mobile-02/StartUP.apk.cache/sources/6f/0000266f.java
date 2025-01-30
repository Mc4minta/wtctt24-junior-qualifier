package com.coinbase.wallet.store.storages;

import android.content.Context;
import android.content.SharedPreferences;
import com.coinbase.wallet.core.util.JSON;
import com.coinbase.wallet.store.interfaces.Storage;
import com.coinbase.wallet.store.models.StoreKey;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SharedPreferencesStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/store/storages/SharedPreferencesStorage;", "Lcom/coinbase/wallet/store/interfaces/Storage;", "T", "Lcom/coinbase/wallet/store/models/StoreKey;", "key", "value", "Lkotlin/x;", "set", "(Lcom/coinbase/wallet/store/models/StoreKey;Ljava/lang/Object;)V", "get", "(Lcom/coinbase/wallet/store/models/StoreKey;)Ljava/lang/Object;", "destroy", "()V", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "preferences", "Landroid/content/SharedPreferences;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "store_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SharedPreferencesStorage implements Storage {
    private final SharedPreferences preferences;

    public SharedPreferencesStorage(Context context) {
        m.g(context, "context");
        this.preferences = context.getSharedPreferences("CBStore.plaintext", 0);
    }

    @Override // com.coinbase.wallet.store.interfaces.Storage
    public void destroy() {
        this.preferences.edit().clear().commit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coinbase.wallet.store.interfaces.Storage
    public <T> T get(StoreKey<T> key) {
        Object obj;
        m.g(key, "key");
        if (this.preferences.contains(key.getName())) {
            Class<?> cls = key.getClazz().getClass().getClass();
            if (m.c(cls, String.class)) {
                return (T) this.preferences.getString(key.getName(), null);
            }
            if (m.c(cls, Integer.TYPE)) {
                Object valueOf = Integer.valueOf(this.preferences.getInt(key.getName(), 0));
                boolean z = valueOf instanceof Object;
                obj = valueOf;
                if (!z) {
                    return null;
                }
            } else if (m.c(cls, Boolean.TYPE)) {
                Object valueOf2 = Boolean.valueOf(this.preferences.getBoolean(key.getName(), false));
                boolean z2 = valueOf2 instanceof Object;
                obj = valueOf2;
                if (!z2) {
                    return null;
                }
            } else if (m.c(cls, Float.TYPE)) {
                Object valueOf3 = Float.valueOf(this.preferences.getFloat(key.getName(), 0.0f));
                boolean z3 = valueOf3 instanceof Object;
                obj = valueOf3;
                if (!z3) {
                    return null;
                }
            } else if (!m.c(cls, Long.TYPE)) {
                String string = this.preferences.getString(key.getName(), null);
                if (string == null) {
                    return null;
                }
                return JSON.INSTANCE.parameterizedAdapter(key.getClazz(), new Type[0]).fromJson(string);
            } else {
                Object valueOf4 = Long.valueOf(this.preferences.getLong(key.getName(), 0L));
                boolean z4 = valueOf4 instanceof Object;
                obj = valueOf4;
                if (!z4) {
                    return null;
                }
            }
            return obj;
        }
        return null;
    }

    @Override // com.coinbase.wallet.store.interfaces.Storage
    public <T> void set(StoreKey<T> key, T t) {
        SharedPreferences.Editor putString;
        m.g(key, "key");
        if (t == null) {
            putString = this.preferences.edit().remove(key.getName());
            m.f(putString, "{\n            preferences.edit().remove(key.name)\n        }");
        } else {
            Class<?> cls = key.getClazz().getClass().getClass();
            if (m.c(cls, String.class)) {
                putString = this.preferences.edit().putString(key.getName(), (String) t);
            } else if (m.c(cls, Integer.TYPE)) {
                putString = this.preferences.edit().putInt(key.getName(), ((Integer) t).intValue());
            } else if (m.c(cls, Boolean.TYPE)) {
                putString = this.preferences.edit().putBoolean(key.getName(), ((Boolean) t).booleanValue());
            } else if (m.c(cls, Float.TYPE)) {
                putString = this.preferences.edit().putFloat(key.getName(), ((Float) t).floatValue());
            } else if (m.c(cls, Long.TYPE)) {
                putString = this.preferences.edit().putLong(key.getName(), ((Long) t).longValue());
            } else {
                putString = this.preferences.edit().putString(key.getName(), JSON.INSTANCE.parameterizedAdapter(key.getClazz(), new Type[0]).toJson(t));
            }
            m.f(putString, "{\n            when (key.clazz.javaClass::class.java) {\n                String::class.java -> preferences.edit().putString(key.name, value as String)\n                Int::class.java -> preferences.edit().putInt(key.name, value as Int)\n                Boolean::class.java -> preferences.edit().putBoolean(key.name, value as Boolean)\n                Float::class.java -> preferences.edit().putFloat(key.name, value as Float)\n                Long::class.java -> preferences.edit().putLong(key.name, value as Long)\n                else -> {\n                    val adapter = JSON.parameterizedAdapter<T>(key.clazz)\n                    val jsonString = adapter.toJson(value)\n                    preferences.edit().putString(key.name, jsonString)\n                }\n            }\n        }");
        }
        if (key.getSyncNow()) {
            putString.commit();
        } else {
            putString.apply();
        }
    }
}