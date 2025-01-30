package com.coinbase.wallet.features.pushnotifications.viewmodels;

import java.security.SecureRandom;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;
import org.spongycastle.i18n.TextBundle;

/* compiled from: PushNotificationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJF\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R'\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\tR\u0019\u0010\u001c\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0013R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/coinbase/wallet/features/pushnotifications/viewmodels/PushNotificationViewModel;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/util/Map;", "channelId", MessageBundle.TITLE_ENTRY, TextBundle.TEXT_ENTRY, "data", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/coinbase/wallet/features/pushnotifications/viewmodels/PushNotificationViewModel;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "Ljava/util/Map;", "getData", "id", "I", "getId", "getTitle", "getChannelId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class PushNotificationViewModel {
    private final String channelId;
    private final Map<String, String> data;
    private final int id;
    private final String text;
    private final String title;

    public PushNotificationViewModel(String channelId, String title, String text, Map<String, String> map) {
        m.g(channelId, "channelId");
        m.g(title, "title");
        m.g(text, "text");
        this.channelId = channelId;
        this.title = title;
        this.text = text;
        this.data = map;
        this.id = new SecureRandom().nextInt();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PushNotificationViewModel copy$default(PushNotificationViewModel pushNotificationViewModel, String str, String str2, String str3, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pushNotificationViewModel.channelId;
        }
        if ((i2 & 2) != 0) {
            str2 = pushNotificationViewModel.title;
        }
        if ((i2 & 4) != 0) {
            str3 = pushNotificationViewModel.text;
        }
        if ((i2 & 8) != 0) {
            map = pushNotificationViewModel.data;
        }
        return pushNotificationViewModel.copy(str, str2, str3, map);
    }

    public final String component1() {
        return this.channelId;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.text;
    }

    public final Map<String, String> component4() {
        return this.data;
    }

    public final PushNotificationViewModel copy(String channelId, String title, String text, Map<String, String> map) {
        m.g(channelId, "channelId");
        m.g(title, "title");
        m.g(text, "text");
        return new PushNotificationViewModel(channelId, title, text, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PushNotificationViewModel) {
            PushNotificationViewModel pushNotificationViewModel = (PushNotificationViewModel) obj;
            return m.c(this.channelId, pushNotificationViewModel.channelId) && m.c(this.title, pushNotificationViewModel.title) && m.c(this.text, pushNotificationViewModel.text) && m.c(this.data, pushNotificationViewModel.data);
        }
        return false;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Map<String, String> getData() {
        return this.data;
    }

    public final int getId() {
        return this.id;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((((this.channelId.hashCode() * 31) + this.title.hashCode()) * 31) + this.text.hashCode()) * 31;
        Map<String, String> map = this.data;
        return hashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "PushNotificationViewModel(channelId=" + this.channelId + ", title=" + this.title + ", text=" + this.text + ", data=" + this.data + ')';
    }
}