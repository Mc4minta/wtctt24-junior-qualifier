package com.coinbase.wallet.store.storages;

import android.content.Context;
import android.content.SharedPreferences;
import com.coinbase.wallet.core.extensions.ByteArray_CoreKt;
import com.coinbase.wallet.core.util.JSON;
import com.coinbase.wallet.crypto.ciphers.AES256GCM;
import com.coinbase.wallet.crypto.ciphers.KeyStores;
import com.coinbase.wallet.store.extensions.String_StoreKt;
import com.coinbase.wallet.store.interfaces.Storage;
import com.coinbase.wallet.store.models.StoreKey;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Objects;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.d;
import kotlin.t;

/* compiled from: EncryptedSharedPreferencesStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/store/storages/EncryptedSharedPreferencesStorage;", "Lcom/coinbase/wallet/store/interfaces/Storage;", "", "value", "encrypt", "(Ljava/lang/String;)Ljava/lang/String;", "decrypt", "Ljavax/crypto/SecretKey;", "getSecretKey", "()Ljavax/crypto/SecretKey;", "T", "Lcom/coinbase/wallet/store/models/StoreKey;", "key", "Lkotlin/x;", "set", "(Lcom/coinbase/wallet/store/models/StoreKey;Ljava/lang/Object;)V", "get", "(Lcom/coinbase/wallet/store/models/StoreKey;)Ljava/lang/Object;", "destroy", "()V", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "preferences", "Landroid/content/SharedPreferences;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "store_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class EncryptedSharedPreferencesStorage implements Storage {
    private static final String ALIAS = "com.coinbase.wallet.CBStore";
    public static final Companion Companion = new Companion(null);
    private static final String KEYSTORE = "AndroidKeyStore";
    private final SharedPreferences preferences;

    /* compiled from: EncryptedSharedPreferencesStorage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/store/storages/EncryptedSharedPreferencesStorage$Companion;", "", "", "ALIAS", "Ljava/lang/String;", "KEYSTORE", "<init>", "()V", "store_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public EncryptedSharedPreferencesStorage(Context context) {
        m.g(context, "context");
        this.preferences = context.getSharedPreferences("CBStore.encrypted", 0);
    }

    private final String decrypt(String str) {
        t<byte[], byte[], byte[]> parseAES256GMPayload = String_StoreKt.parseAES256GMPayload(str);
        if (parseAES256GMPayload == null) {
            return null;
        }
        byte[] c2 = parseAES256GMPayload.c();
        SecretKey secretKey = getSecretKey();
        return new String(AES256GCM.Companion.decrypt(c2, secretKey, parseAES256GMPayload.a(), parseAES256GMPayload.b()), d.a);
    }

    private final String encrypt(String str) {
        byte[] n;
        byte[] n2;
        AES256GCM.Companion companion = AES256GCM.Companion;
        Charset charset = d.a;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str.getBytes(charset);
        m.f(bytes, "(this as java.lang.String).getBytes(charset)");
        t<byte[], byte[], byte[]> encrypt = companion.encrypt(bytes, getSecretKey());
        n = kotlin.a0.m.n(encrypt.d(), encrypt.e());
        n2 = kotlin.a0.m.n(n, encrypt.f());
        return ByteArray_CoreKt.base64EncodedString(n2);
    }

    private final SecretKey getSecretKey() {
        return KeyStores.INSTANCE.getOrCreateAESSecretKey(KEYSTORE, ALIAS, false, false);
    }

    @Override // com.coinbase.wallet.store.interfaces.Storage
    public void destroy() {
        this.preferences.edit().clear().commit();
    }

    @Override // com.coinbase.wallet.store.interfaces.Storage
    public <T> T get(StoreKey<T> key) {
        String decrypt;
        m.g(key, "key");
        String string = this.preferences.getString(key.getName(), null);
        if (string == null || (decrypt = decrypt(string)) == null) {
            return null;
        }
        return JSON.INSTANCE.parameterizedAdapter(key.getClazz(), new Type[0]).fromJson(decrypt);
    }

    @Override // com.coinbase.wallet.store.interfaces.Storage
    public <T> void set(StoreKey<T> key, T t) {
        SharedPreferences.Editor putString;
        m.g(key, "key");
        if (t == null) {
            putString = this.preferences.edit().remove(key.getName());
            m.f(putString, "{\n            preferences.edit().remove(key.name)\n        }");
        } else {
            String jsonString = JSON.INSTANCE.parameterizedAdapter(key.getClazz(), new Type[0]).toJson(t);
            m.f(jsonString, "jsonString");
            putString = this.preferences.edit().putString(key.getName(), encrypt(jsonString));
            m.f(putString, "{\n            val adapter = JSON.parameterizedAdapter<T>(key.clazz)\n            val jsonString = adapter.toJson(value)\n            val encrypted = encrypt(jsonString)\n            preferences.edit().putString(key.name, encrypted)\n        }");
        }
        if (key.getSyncNow()) {
            putString.commit();
        } else {
            putString.apply();
        }
    }
}