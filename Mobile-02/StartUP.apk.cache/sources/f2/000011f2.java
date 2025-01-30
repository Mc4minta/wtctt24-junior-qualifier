package com.coinbase.wallet.application.model;

import com.coinbase.wallet.commonui.models.ActionStyle;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: Notification.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ@\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R!\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\u000eR\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\nR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"Lcom/coinbase/wallet/application/model/CallToAction;", "", "", "component1", "()I", "Lcom/coinbase/wallet/application/model/NotificationDestination;", "component2", "()Lcom/coinbase/wallet/application/model/NotificationDestination;", "Lcom/coinbase/wallet/commonui/models/ActionStyle;", "component3", "()Lcom/coinbase/wallet/commonui/models/ActionStyle;", "Lkotlin/Function0;", "Lkotlin/x;", "component4", "()Lkotlin/e0/c/a;", "actionButtonTextResId", "destination", "actionStyle", "onTapHook", "copy", "(ILcom/coinbase/wallet/application/model/NotificationDestination;Lcom/coinbase/wallet/commonui/models/ActionStyle;Lkotlin/e0/c/a;)Lcom/coinbase/wallet/application/model/CallToAction;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/application/model/NotificationDestination;", "getDestination", "Lkotlin/e0/c/a;", "getOnTapHook", "Lcom/coinbase/wallet/commonui/models/ActionStyle;", "getActionStyle", "I", "getActionButtonTextResId", "<init>", "(ILcom/coinbase/wallet/application/model/NotificationDestination;Lcom/coinbase/wallet/commonui/models/ActionStyle;Lkotlin/e0/c/a;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CallToAction {
    private final int actionButtonTextResId;
    private final ActionStyle actionStyle;
    private final NotificationDestination destination;
    private final a<x> onTapHook;

    public CallToAction(int i2, NotificationDestination destination, ActionStyle actionStyle, a<x> aVar) {
        m.g(destination, "destination");
        m.g(actionStyle, "actionStyle");
        this.actionButtonTextResId = i2;
        this.destination = destination;
        this.actionStyle = actionStyle;
        this.onTapHook = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallToAction copy$default(CallToAction callToAction, int i2, NotificationDestination notificationDestination, ActionStyle actionStyle, a aVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = callToAction.actionButtonTextResId;
        }
        if ((i3 & 2) != 0) {
            notificationDestination = callToAction.destination;
        }
        if ((i3 & 4) != 0) {
            actionStyle = callToAction.actionStyle;
        }
        if ((i3 & 8) != 0) {
            aVar = callToAction.onTapHook;
        }
        return callToAction.copy(i2, notificationDestination, actionStyle, aVar);
    }

    public final int component1() {
        return this.actionButtonTextResId;
    }

    public final NotificationDestination component2() {
        return this.destination;
    }

    public final ActionStyle component3() {
        return this.actionStyle;
    }

    public final a<x> component4() {
        return this.onTapHook;
    }

    public final CallToAction copy(int i2, NotificationDestination destination, ActionStyle actionStyle, a<x> aVar) {
        m.g(destination, "destination");
        m.g(actionStyle, "actionStyle");
        return new CallToAction(i2, destination, actionStyle, aVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CallToAction) {
            CallToAction callToAction = (CallToAction) obj;
            return this.actionButtonTextResId == callToAction.actionButtonTextResId && m.c(this.destination, callToAction.destination) && this.actionStyle == callToAction.actionStyle && m.c(this.onTapHook, callToAction.onTapHook);
        }
        return false;
    }

    public final int getActionButtonTextResId() {
        return this.actionButtonTextResId;
    }

    public final ActionStyle getActionStyle() {
        return this.actionStyle;
    }

    public final NotificationDestination getDestination() {
        return this.destination;
    }

    public final a<x> getOnTapHook() {
        return this.onTapHook;
    }

    public int hashCode() {
        int hashCode = ((((this.actionButtonTextResId * 31) + this.destination.hashCode()) * 31) + this.actionStyle.hashCode()) * 31;
        a<x> aVar = this.onTapHook;
        return hashCode + (aVar == null ? 0 : aVar.hashCode());
    }

    public String toString() {
        return "CallToAction(actionButtonTextResId=" + this.actionButtonTextResId + ", destination=" + this.destination + ", actionStyle=" + this.actionStyle + ", onTapHook=" + this.onTapHook + ')';
    }

    public /* synthetic */ CallToAction(int i2, NotificationDestination notificationDestination, ActionStyle actionStyle, a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, notificationDestination, actionStyle, (i3 & 8) != 0 ? null : aVar);
    }
}