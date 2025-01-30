package com.coinbase.wallet.consumer.models;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerOnboardingViewEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewEvent;", "", "<init>", "()V", "HideKeyboard", "StartActivityForResult", "StartConnection", "Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewEvent$StartConnection;", "Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewEvent$HideKeyboard;", "Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewEvent$StartActivityForResult;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ConsumerOnboardingViewEvent {

    /* compiled from: ConsumerOnboardingViewEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewEvent$HideKeyboard;", "Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewEvent;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class HideKeyboard extends ConsumerOnboardingViewEvent {
        public static final HideKeyboard INSTANCE = new HideKeyboard();

        private HideKeyboard() {
            super(null);
        }
    }

    /* compiled from: ConsumerOnboardingViewEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\bJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R!\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewEvent$StartActivityForResult;", "Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewEvent;", "Ljava/lang/Class;", "Landroid/app/Activity;", "component1", "()Ljava/lang/Class;", "", "component2", "()I", "clazz", "requestCode", "copy", "(Ljava/lang/Class;I)Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewEvent$StartActivityForResult;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Class;", "getClazz", "I", "getRequestCode", "<init>", "(Ljava/lang/Class;I)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class StartActivityForResult extends ConsumerOnboardingViewEvent {
        private final Class<? extends Activity> clazz;
        private final int requestCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartActivityForResult(Class<? extends Activity> clazz, int i2) {
            super(null);
            m.g(clazz, "clazz");
            this.clazz = clazz;
            this.requestCode = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StartActivityForResult copy$default(StartActivityForResult startActivityForResult, Class cls, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                cls = startActivityForResult.clazz;
            }
            if ((i3 & 2) != 0) {
                i2 = startActivityForResult.requestCode;
            }
            return startActivityForResult.copy(cls, i2);
        }

        public final Class<? extends Activity> component1() {
            return this.clazz;
        }

        public final int component2() {
            return this.requestCode;
        }

        public final StartActivityForResult copy(Class<? extends Activity> clazz, int i2) {
            m.g(clazz, "clazz");
            return new StartActivityForResult(clazz, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StartActivityForResult) {
                StartActivityForResult startActivityForResult = (StartActivityForResult) obj;
                return m.c(this.clazz, startActivityForResult.clazz) && this.requestCode == startActivityForResult.requestCode;
            }
            return false;
        }

        public final Class<? extends Activity> getClazz() {
            return this.clazz;
        }

        public final int getRequestCode() {
            return this.requestCode;
        }

        public int hashCode() {
            return (this.clazz.hashCode() * 31) + this.requestCode;
        }

        public String toString() {
            return "StartActivityForResult(clazz=" + this.clazz + ", requestCode=" + this.requestCode + ')';
        }
    }

    /* compiled from: ConsumerOnboardingViewEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewEvent$StartConnection;", "Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewEvent;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class StartConnection extends ConsumerOnboardingViewEvent {
        public static final StartConnection INSTANCE = new StartConnection();

        private StartConnection() {
            super(null);
        }
    }

    private ConsumerOnboardingViewEvent() {
    }

    public /* synthetic */ ConsumerOnboardingViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}