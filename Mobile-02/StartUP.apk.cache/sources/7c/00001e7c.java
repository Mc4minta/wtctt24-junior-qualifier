package com.coinbase.wallet.features.lend.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ActionStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;
import org.toshi.R;

/* compiled from: ProviderInfoPrompt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\fR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b!\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/ProviderInfoPrompt;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Integer;", "component4", "Lcom/coinbase/wallet/commonui/models/ActionStyle;", "component5", "()Lcom/coinbase/wallet/commonui/models/ActionStyle;", MessageBundle.TITLE_ENTRY, ApiConstants.MESSAGE, "imageResId", "actionTitle", "actionStyle", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/coinbase/wallet/commonui/models/ActionStyle;)Lcom/coinbase/wallet/features/lend/models/ProviderInfoPrompt;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getImageResId", "Ljava/lang/String;", "getActionTitle", "Lcom/coinbase/wallet/commonui/models/ActionStyle;", "getActionStyle", "getTitle", "getMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/coinbase/wallet/commonui/models/ActionStyle;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ProviderInfoPrompt {
    private final ActionStyle actionStyle;
    private final String actionTitle;
    private final Integer imageResId;
    private final String message;
    private final String title;

    public ProviderInfoPrompt(String title, String message, Integer num, String actionTitle, ActionStyle actionStyle) {
        m.g(title, "title");
        m.g(message, "message");
        m.g(actionTitle, "actionTitle");
        m.g(actionStyle, "actionStyle");
        this.title = title;
        this.message = message;
        this.imageResId = num;
        this.actionTitle = actionTitle;
        this.actionStyle = actionStyle;
    }

    public static /* synthetic */ ProviderInfoPrompt copy$default(ProviderInfoPrompt providerInfoPrompt, String str, String str2, Integer num, String str3, ActionStyle actionStyle, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = providerInfoPrompt.title;
        }
        if ((i2 & 2) != 0) {
            str2 = providerInfoPrompt.message;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            num = providerInfoPrompt.imageResId;
        }
        Integer num2 = num;
        if ((i2 & 8) != 0) {
            str3 = providerInfoPrompt.actionTitle;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            actionStyle = providerInfoPrompt.actionStyle;
        }
        return providerInfoPrompt.copy(str, str4, num2, str5, actionStyle);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.message;
    }

    public final Integer component3() {
        return this.imageResId;
    }

    public final String component4() {
        return this.actionTitle;
    }

    public final ActionStyle component5() {
        return this.actionStyle;
    }

    public final ProviderInfoPrompt copy(String title, String message, Integer num, String actionTitle, ActionStyle actionStyle) {
        m.g(title, "title");
        m.g(message, "message");
        m.g(actionTitle, "actionTitle");
        m.g(actionStyle, "actionStyle");
        return new ProviderInfoPrompt(title, message, num, actionTitle, actionStyle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProviderInfoPrompt) {
            ProviderInfoPrompt providerInfoPrompt = (ProviderInfoPrompt) obj;
            return m.c(this.title, providerInfoPrompt.title) && m.c(this.message, providerInfoPrompt.message) && m.c(this.imageResId, providerInfoPrompt.imageResId) && m.c(this.actionTitle, providerInfoPrompt.actionTitle) && this.actionStyle == providerInfoPrompt.actionStyle;
        }
        return false;
    }

    public final ActionStyle getActionStyle() {
        return this.actionStyle;
    }

    public final String getActionTitle() {
        return this.actionTitle;
    }

    public final Integer getImageResId() {
        return this.imageResId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((this.title.hashCode() * 31) + this.message.hashCode()) * 31;
        Integer num = this.imageResId;
        return ((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.actionTitle.hashCode()) * 31) + this.actionStyle.hashCode();
    }

    public String toString() {
        return "ProviderInfoPrompt(title=" + this.title + ", message=" + this.message + ", imageResId=" + this.imageResId + ", actionTitle=" + this.actionTitle + ", actionStyle=" + this.actionStyle + ')';
    }

    public /* synthetic */ ProviderInfoPrompt(String str, String str2, Integer num, String str3, ActionStyle actionStyle, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? LocalizedStrings.INSTANCE.get(R.string.got_it) : str3, (i2 & 16) != 0 ? ActionStyle.POSITIVE : actionStyle);
    }
}