package com.coinbase.wallet.application.model;

import com.coinbase.ApiConstants;
import h.c.b0;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: Notification.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001:\u0001AB\u0083\u0001\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0007\u0012\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011\u0012\b\b\u0002\u0010#\u001a\u00020\u0014\u0012\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017¢\u0006\u0004\b?\u0010@J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0094\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00072\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\b\b\u0002\u0010#\u001a\u00020\u00142\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\u0004J\u0010\u0010)\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010,\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-R\u0019\u0010#\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010.\u001a\u0004\b/\u0010\u0016R!\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b$\u00100\u001a\u0004\b1\u0010\u001aR\u0019\u0010\u001f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00102\u001a\u0004\b3\u0010\tR\u001b\u0010 \u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b \u00104\u001a\u0004\b5\u0010\fR!\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b%\u00100\u001a\u0004\b6\u0010\u001aR\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\b8\u0010\u0004R\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00109\u001a\u0004\b:\u0010\u0010R\u0019\u0010\u001e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00107\u001a\u0004\b;\u0010\u0004R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00107\u001a\u0004\b<\u0010\u0004R\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010=\u001a\u0004\b>\u0010\u0013¨\u0006B"}, d2 = {"Lcom/coinbase/wallet/application/model/Notification;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Z", "", "component5", "()Ljava/lang/Integer;", "", "Lcom/coinbase/wallet/application/model/CallToAction;", "component6", "()Ljava/util/List;", "Lh/c/b0;", "component7", "()Lh/c/b0;", "Lcom/coinbase/wallet/application/model/NotificationDestination;", "component8", "()Lcom/coinbase/wallet/application/model/NotificationDestination;", "Lkotlin/Function0;", "Lkotlin/x;", "component9", "()Lkotlin/e0/c/a;", "component10", "id", MessageBundle.TITLE_ENTRY, ApiConstants.MESSAGE, "showCloseButton", "imageResId", "callToActions", "shouldShowNotification", "dismissDestination", "onCloseClickHook", "onDismissHook", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/util/List;Lh/c/b0;Lcom/coinbase/wallet/application/model/NotificationDestination;Lkotlin/e0/c/a;Lkotlin/e0/c/a;)Lcom/coinbase/wallet/application/model/Notification;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/application/model/NotificationDestination;", "getDismissDestination", "Lkotlin/e0/c/a;", "getOnCloseClickHook", "Z", "getShowCloseButton", "Ljava/lang/Integer;", "getImageResId", "getOnDismissHook", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getCallToActions", "getMessage", "getId", "Lh/c/b0;", "getShouldShowNotification", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/util/List;Lh/c/b0;Lcom/coinbase/wallet/application/model/NotificationDestination;Lkotlin/e0/c/a;Lkotlin/e0/c/a;)V", "Id", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Notification {
    private final List<CallToAction> callToActions;
    private final NotificationDestination dismissDestination;
    private final String id;
    private final Integer imageResId;
    private final String message;
    private final a<x> onCloseClickHook;
    private final a<x> onDismissHook;
    private final b0<Boolean> shouldShowNotification;
    private final boolean showCloseButton;
    private final String title;

    /* compiled from: Notification.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/application/model/Notification$Id;", "", "", "PROVIDER_SECURITY", "Ljava/lang/String;", "VERIFY_APPS_PROMPT", "KEY_BACKUP_PROMPT", "ANNOUNCEMENT_CONSUMER_CONNECT_ONRAMP", "SWAP_TOS", "ANNOUNCEMENT_CONSUMER_CONNECT", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Id {
        public static final String ANNOUNCEMENT_CONSUMER_CONNECT = "new_feature_consumer_connect";
        public static final String ANNOUNCEMENT_CONSUMER_CONNECT_ONRAMP = "new_feature_consumer_connect_onramp";
        public static final Id INSTANCE = new Id();
        public static final String KEY_BACKUP_PROMPT = "cloud_key_backup_action_prompt";
        public static final String PROVIDER_SECURITY = "provider_security";
        public static final String SWAP_TOS = "swap_tos";
        public static final String VERIFY_APPS_PROMPT = "verify_apps";

        private Id() {
        }
    }

    public Notification(String str, String title, String message, boolean z, Integer num, List<CallToAction> callToActions, b0<Boolean> shouldShowNotification, NotificationDestination dismissDestination, a<x> aVar, a<x> aVar2) {
        m.g(title, "title");
        m.g(message, "message");
        m.g(callToActions, "callToActions");
        m.g(shouldShowNotification, "shouldShowNotification");
        m.g(dismissDestination, "dismissDestination");
        this.id = str;
        this.title = title;
        this.message = message;
        this.showCloseButton = z;
        this.imageResId = num;
        this.callToActions = callToActions;
        this.shouldShowNotification = shouldShowNotification;
        this.dismissDestination = dismissDestination;
        this.onCloseClickHook = aVar;
        this.onDismissHook = aVar2;
    }

    public final String component1() {
        return this.id;
    }

    public final a<x> component10() {
        return this.onDismissHook;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.message;
    }

    public final boolean component4() {
        return this.showCloseButton;
    }

    public final Integer component5() {
        return this.imageResId;
    }

    public final List<CallToAction> component6() {
        return this.callToActions;
    }

    public final b0<Boolean> component7() {
        return this.shouldShowNotification;
    }

    public final NotificationDestination component8() {
        return this.dismissDestination;
    }

    public final a<x> component9() {
        return this.onCloseClickHook;
    }

    public final Notification copy(String str, String title, String message, boolean z, Integer num, List<CallToAction> callToActions, b0<Boolean> shouldShowNotification, NotificationDestination dismissDestination, a<x> aVar, a<x> aVar2) {
        m.g(title, "title");
        m.g(message, "message");
        m.g(callToActions, "callToActions");
        m.g(shouldShowNotification, "shouldShowNotification");
        m.g(dismissDestination, "dismissDestination");
        return new Notification(str, title, message, z, num, callToActions, shouldShowNotification, dismissDestination, aVar, aVar2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Notification) {
            Notification notification = (Notification) obj;
            return m.c(this.id, notification.id) && m.c(this.title, notification.title) && m.c(this.message, notification.message) && this.showCloseButton == notification.showCloseButton && m.c(this.imageResId, notification.imageResId) && m.c(this.callToActions, notification.callToActions) && m.c(this.shouldShowNotification, notification.shouldShowNotification) && m.c(this.dismissDestination, notification.dismissDestination) && m.c(this.onCloseClickHook, notification.onCloseClickHook) && m.c(this.onDismissHook, notification.onDismissHook);
        }
        return false;
    }

    public final List<CallToAction> getCallToActions() {
        return this.callToActions;
    }

    public final NotificationDestination getDismissDestination() {
        return this.dismissDestination;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getImageResId() {
        return this.imageResId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final a<x> getOnCloseClickHook() {
        return this.onCloseClickHook;
    }

    public final a<x> getOnDismissHook() {
        return this.onDismissHook;
    }

    public final b0<Boolean> getShouldShowNotification() {
        return this.shouldShowNotification;
    }

    public final boolean getShowCloseButton() {
        return this.showCloseButton;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.title.hashCode()) * 31) + this.message.hashCode()) * 31;
        boolean z = this.showCloseButton;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        Integer num = this.imageResId;
        int hashCode2 = (((((((i3 + (num == null ? 0 : num.hashCode())) * 31) + this.callToActions.hashCode()) * 31) + this.shouldShowNotification.hashCode()) * 31) + this.dismissDestination.hashCode()) * 31;
        a<x> aVar = this.onCloseClickHook;
        int hashCode3 = (hashCode2 + (aVar == null ? 0 : aVar.hashCode())) * 31;
        a<x> aVar2 = this.onDismissHook;
        return hashCode3 + (aVar2 != null ? aVar2.hashCode() : 0);
    }

    public String toString() {
        return "Notification(id=" + ((Object) this.id) + ", title=" + this.title + ", message=" + this.message + ", showCloseButton=" + this.showCloseButton + ", imageResId=" + this.imageResId + ", callToActions=" + this.callToActions + ", shouldShowNotification=" + this.shouldShowNotification + ", dismissDestination=" + this.dismissDestination + ", onCloseClickHook=" + this.onCloseClickHook + ", onDismissHook=" + this.onDismissHook + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ Notification(java.lang.String r15, java.lang.String r16, java.lang.String r17, boolean r18, java.lang.Integer r19, java.util.List r20, h.c.b0 r21, com.coinbase.wallet.application.model.NotificationDestination r22, kotlin.e0.c.a r23, kotlin.e0.c.a r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r4 = r2
            goto La
        L9:
            r4 = r15
        La:
            r1 = r0 & 16
            if (r1 == 0) goto L10
            r8 = r2
            goto L12
        L10:
            r8 = r19
        L12:
            r1 = r0 & 32
            if (r1 == 0) goto L1c
            java.util.List r1 = kotlin.a0.p.g()
            r9 = r1
            goto L1e
        L1c:
            r9 = r20
        L1e:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L2a
            com.coinbase.wallet.application.model.DismissDestination r1 = new com.coinbase.wallet.application.model.DismissDestination
            r3 = 1
            r1.<init>(r2, r3, r2)
            r11 = r1
            goto L2c
        L2a:
            r11 = r22
        L2c:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L32
            r12 = r2
            goto L34
        L32:
            r12 = r23
        L34:
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L3a
            r13 = r2
            goto L3c
        L3a:
            r13 = r24
        L3c:
            r3 = r14
            r5 = r16
            r6 = r17
            r7 = r18
            r10 = r21
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.application.model.Notification.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.Integer, java.util.List, h.c.b0, com.coinbase.wallet.application.model.NotificationDestination, kotlin.e0.c.a, kotlin.e0.c.a, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}