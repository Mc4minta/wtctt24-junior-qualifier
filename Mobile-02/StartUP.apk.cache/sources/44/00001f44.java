package com.coinbase.wallet.features.pushnotifications.repositories;

import com.coinbase.wallet.features.pushnotifications.extensions.StoreKeys_PushNotificationsKt;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import java.util.UUID;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushNotificationRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class PushNotificationRepository$deviceId$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<String> {
    final /* synthetic */ PushNotificationRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushNotificationRepository$deviceId$2(PushNotificationRepository pushNotificationRepository) {
        super(0);
        this.this$0 = pushNotificationRepository;
    }

    @Override // kotlin.e0.c.a
    public final String invoke() {
        StoreInterface storeInterface;
        StoreInterface storeInterface2;
        storeInterface = this.this$0.store;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        String str = (String) storeInterface.get(StoreKeys_PushNotificationsKt.getDeviceId(storeKeys));
        if (str == null) {
            String uuid = UUID.randomUUID().toString();
            storeInterface2 = this.this$0.store;
            storeInterface2.set(StoreKeys_PushNotificationsKt.getDeviceId(storeKeys), uuid);
            kotlin.jvm.internal.m.f(uuid, "randomUUID().toString().also {\n            store.set(StoreKeys.deviceId, it)\n        }");
            return uuid;
        }
        return str;
    }
}