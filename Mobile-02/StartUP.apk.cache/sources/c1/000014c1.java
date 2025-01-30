package com.coinbase.wallet.commonui.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.commonui.models.ActionStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.spongycastle.i18n.MessageBundle;
import org.spongycastle.i18n.TextBundle;

/* compiled from: PromptDialogHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u0011*\u00020\u000e8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper;", "", "Landroid/content/Context;", "context", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "properties", "Landroidx/appcompat/app/c;", "create", "(Landroid/content/Context;Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;)Landroidx/appcompat/app/c;", "Landroid/app/Activity;", "activity", "Lkotlin/x;", "show", "(Landroid/app/Activity;Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;)V", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;)V", "", "isAlive", "(Landroidx/fragment/app/Fragment;)Z", "<init>", "()V", "Action", "Properties", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class PromptDialogHelper {
    public static final PromptDialogHelper INSTANCE = new PromptDialogHelper();

    /* compiled from: PromptDialogHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Action;", "", "Lcom/coinbase/wallet/commonui/models/ActionStyle;", "style", "Lcom/coinbase/wallet/commonui/models/ActionStyle;", "getStyle$commonui_productionRelease", "()Lcom/coinbase/wallet/commonui/models/ActionStyle;", "", TextBundle.TEXT_ENTRY, "Ljava/lang/CharSequence;", "getText$commonui_productionRelease", "()Ljava/lang/CharSequence;", "Lkotlin/Function1;", "Landroid/content/DialogInterface;", "Lkotlin/x;", "listener", "Lkotlin/e0/c/l;", "getListener$commonui_productionRelease", "()Lkotlin/e0/c/l;", "<init>", "(Ljava/lang/CharSequence;Lcom/coinbase/wallet/commonui/models/ActionStyle;Lkotlin/e0/c/l;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Action {
        private final l<DialogInterface, x> listener;
        private final ActionStyle style;
        private final CharSequence text;

        /* JADX WARN: Multi-variable type inference failed */
        public Action(CharSequence text, ActionStyle style, l<? super DialogInterface, x> listener) {
            m.g(text, "text");
            m.g(style, "style");
            m.g(listener, "listener");
            this.text = text;
            this.style = style;
            this.listener = listener;
        }

        public final l<DialogInterface, x> getListener$commonui_productionRelease() {
            return this.listener;
        }

        public final ActionStyle getStyle$commonui_productionRelease() {
            return this.style;
        }

        public final CharSequence getText$commonui_productionRelease() {
            return this.text;
        }
    }

    /* compiled from: PromptDialogHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ActionStyle.values().length];
            iArr[ActionStyle.NEGATIVE.ordinal()] = 1;
            iArr[ActionStyle.NEUTRAL.ordinal()] = 2;
            iArr[ActionStyle.NEUTRAL_RAISED.ordinal()] = 3;
            iArr[ActionStyle.POSITIVE.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PromptDialogHelper() {
    }

    public static /* synthetic */ void a(Properties properties, d0 d0Var, DialogInterface dialogInterface) {
        m806create$lambda3(properties, d0Var, dialogInterface);
    }

    public static /* synthetic */ void b(Properties properties, d0 d0Var, DialogInterface dialogInterface) {
        m807create$lambda4(properties, d0Var, dialogInterface);
    }

    /* renamed from: create$lambda-3 */
    public static final void m806create$lambda3(Properties properties, d0 dialogInterface, DialogInterface dialogInterface2) {
        m.g(properties, "$properties");
        m.g(dialogInterface, "$dialogInterface");
        l<DialogInterface, x> cancelListener$commonui_productionRelease = properties.getCancelListener$commonui_productionRelease();
        T t = dialogInterface.a;
        if (t != 0) {
            cancelListener$commonui_productionRelease.invoke((DialogInterface) t);
        } else {
            m.w("dialogInterface");
            throw null;
        }
    }

    /* renamed from: create$lambda-4 */
    public static final void m807create$lambda4(Properties properties, d0 dialogInterface, DialogInterface dialogInterface2) {
        m.g(properties, "$properties");
        m.g(dialogInterface, "$dialogInterface");
        l<DialogInterface, x> dismissListener$commonui_productionRelease = properties.getDismissListener$commonui_productionRelease();
        T t = dialogInterface.a;
        if (t != 0) {
            dismissListener$commonui_productionRelease.invoke((DialogInterface) t);
        } else {
            m.w("dialogInterface");
            throw null;
        }
    }

    private final boolean isAlive(Fragment fragment) {
        return (fragment.getContext() == null || !fragment.isAdded() || fragment.isRemoving() || fragment.isDetached()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0268 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0278  */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, androidx.appcompat.app.c, java.lang.Object, android.app.Dialog] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.appcompat.app.c create(android.content.Context r24, final com.coinbase.wallet.commonui.utilities.PromptDialogHelper.Properties r25) {
        /*
            Method dump skipped, instructions count: 658
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.commonui.utilities.PromptDialogHelper.create(android.content.Context, com.coinbase.wallet.commonui.utilities.PromptDialogHelper$Properties):androidx.appcompat.app.c");
    }

    public final void show(Activity activity, Properties properties) {
        m.g(activity, "activity");
        m.g(properties, "properties");
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        create(activity, properties).show();
    }

    public final void show(Fragment fragment, Properties properties) {
        m.g(fragment, "fragment");
        m.g(properties, "properties");
        Context context = fragment.getContext();
        if (context == null || !isAlive(fragment)) {
            return;
        }
        create(context, properties).show();
    }

    /* compiled from: PromptDialogHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u00002\u00020\u0001BÝ\u0001\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u001f¢\u0006\u0004\b0\u00101R*\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u00020\u00168\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001c\u0010 \u001a\u00020\u001f8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u00020\u001f8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b%\u0010#R*\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\bR*\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b(\u0010\u0006\u001a\u0004\b)\u0010\bR\u001e\u0010*\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\rR\u001e\u0010,\u001a\u0004\u0018\u00010\u00168\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010\u001aR*\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b.\u0010\u0006\u001a\u0004\b/\u0010\b¨\u00062"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "", "Lkotlin/Function1;", "Landroid/content/DialogInterface;", "Lkotlin/x;", "closeClickListener", "Lkotlin/e0/c/l;", "getCloseClickListener$commonui_productionRelease", "()Lkotlin/e0/c/l;", "", "windowAnimations", "Ljava/lang/Integer;", "getWindowAnimations$commonui_productionRelease", "()Ljava/lang/Integer;", "image", "getImage$commonui_productionRelease", "", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Action;", "actions", "Ljava/util/List;", "getActions$commonui_productionRelease", "()Ljava/util/List;", "", MessageBundle.TITLE_ENTRY, "Ljava/lang/CharSequence;", "getTitle$commonui_productionRelease", "()Ljava/lang/CharSequence;", "messageSecondary", "getMessageSecondary$commonui_productionRelease", "count", "getCount$commonui_productionRelease", "", "canceledOnTouchOutside", "Z", "getCanceledOnTouchOutside$commonui_productionRelease", "()Z", "showCloseButton", "getShowCloseButton$commonui_productionRelease", "dismissListener", "getDismissListener$commonui_productionRelease", "shareClickListener", "getShareClickListener$commonui_productionRelease", "gravity", "getGravity$commonui_productionRelease", ApiConstants.MESSAGE, "getMessage$commonui_productionRelease", "cancelListener", "getCancelListener$commonui_productionRelease", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;ZLjava/lang/Integer;Lkotlin/e0/c/l;Lkotlin/e0/c/l;Lkotlin/e0/c/l;Lkotlin/e0/c/l;Z)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Properties {
        private final List<Action> actions;
        private final l<DialogInterface, x> cancelListener;
        private final boolean canceledOnTouchOutside;
        private final l<DialogInterface, x> closeClickListener;
        private final CharSequence count;
        private final l<DialogInterface, x> dismissListener;
        private final Integer gravity;
        private final Integer image;
        private final CharSequence message;
        private final CharSequence messageSecondary;
        private final l<DialogInterface, x> shareClickListener;
        private final boolean showCloseButton;
        private final CharSequence title;
        private final Integer windowAnimations;

        /* JADX WARN: Multi-variable type inference failed */
        public Properties(CharSequence charSequence, CharSequence title, CharSequence charSequence2, CharSequence charSequence3, Integer num, List<Action> list, Integer num2, boolean z, Integer num3, l<? super DialogInterface, x> lVar, l<? super DialogInterface, x> lVar2, l<? super DialogInterface, x> lVar3, l<? super DialogInterface, x> lVar4, boolean z2) {
            m.g(title, "title");
            this.count = charSequence;
            this.title = title;
            this.message = charSequence2;
            this.messageSecondary = charSequence3;
            this.image = num;
            this.actions = list;
            this.windowAnimations = num2;
            this.canceledOnTouchOutside = z;
            this.gravity = num3;
            this.cancelListener = lVar;
            this.closeClickListener = lVar2;
            this.dismissListener = lVar3;
            this.shareClickListener = lVar4;
            this.showCloseButton = z2;
        }

        public final List<Action> getActions$commonui_productionRelease() {
            return this.actions;
        }

        public final l<DialogInterface, x> getCancelListener$commonui_productionRelease() {
            return this.cancelListener;
        }

        public final boolean getCanceledOnTouchOutside$commonui_productionRelease() {
            return this.canceledOnTouchOutside;
        }

        public final l<DialogInterface, x> getCloseClickListener$commonui_productionRelease() {
            return this.closeClickListener;
        }

        public final CharSequence getCount$commonui_productionRelease() {
            return this.count;
        }

        public final l<DialogInterface, x> getDismissListener$commonui_productionRelease() {
            return this.dismissListener;
        }

        public final Integer getGravity$commonui_productionRelease() {
            return this.gravity;
        }

        public final Integer getImage$commonui_productionRelease() {
            return this.image;
        }

        public final CharSequence getMessage$commonui_productionRelease() {
            return this.message;
        }

        public final CharSequence getMessageSecondary$commonui_productionRelease() {
            return this.messageSecondary;
        }

        public final l<DialogInterface, x> getShareClickListener$commonui_productionRelease() {
            return this.shareClickListener;
        }

        public final boolean getShowCloseButton$commonui_productionRelease() {
            return this.showCloseButton;
        }

        public final CharSequence getTitle$commonui_productionRelease() {
            return this.title;
        }

        public final Integer getWindowAnimations$commonui_productionRelease() {
            return this.windowAnimations;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ Properties(java.lang.CharSequence r19, java.lang.CharSequence r20, java.lang.CharSequence r21, java.lang.CharSequence r22, java.lang.Integer r23, java.util.List r24, java.lang.Integer r25, boolean r26, java.lang.Integer r27, kotlin.e0.c.l r28, kotlin.e0.c.l r29, kotlin.e0.c.l r30, kotlin.e0.c.l r31, boolean r32, int r33, kotlin.jvm.internal.DefaultConstructorMarker r34) {
            /*
                r18 = this;
                r0 = r33
                r1 = r0 & 1
                r2 = 0
                if (r1 == 0) goto L9
                r4 = r2
                goto Lb
            L9:
                r4 = r19
            Lb:
                r1 = r0 & 4
                if (r1 == 0) goto L11
                r6 = r2
                goto L13
            L11:
                r6 = r21
            L13:
                r1 = r0 & 8
                if (r1 == 0) goto L19
                r7 = r2
                goto L1b
            L19:
                r7 = r22
            L1b:
                r1 = r0 & 16
                if (r1 == 0) goto L21
                r8 = r2
                goto L23
            L21:
                r8 = r23
            L23:
                r1 = r0 & 32
                if (r1 == 0) goto L29
                r9 = r2
                goto L2b
            L29:
                r9 = r24
            L2b:
                r1 = r0 & 64
                if (r1 == 0) goto L31
                r10 = r2
                goto L33
            L31:
                r10 = r25
            L33:
                r1 = r0 & 128(0x80, float:1.8E-43)
                r3 = 0
                if (r1 == 0) goto L3a
                r11 = r3
                goto L3c
            L3a:
                r11 = r26
            L3c:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L48
                r1 = 81
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r12 = r1
                goto L4a
            L48:
                r12 = r27
            L4a:
                r1 = r0 & 512(0x200, float:7.17E-43)
                if (r1 == 0) goto L50
                r13 = r2
                goto L52
            L50:
                r13 = r28
            L52:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L58
                r14 = r2
                goto L5a
            L58:
                r14 = r29
            L5a:
                r1 = r0 & 2048(0x800, float:2.87E-42)
                if (r1 == 0) goto L60
                r15 = r2
                goto L62
            L60:
                r15 = r30
            L62:
                r1 = r0 & 4096(0x1000, float:5.74E-42)
                if (r1 == 0) goto L69
                r16 = r2
                goto L6b
            L69:
                r16 = r31
            L6b:
                r0 = r0 & 8192(0x2000, float:1.148E-41)
                if (r0 == 0) goto L77
                if (r14 == 0) goto L73
                r0 = 1
                goto L74
            L73:
                r0 = r3
            L74:
                r17 = r0
                goto L79
            L77:
                r17 = r32
            L79:
                r3 = r18
                r5 = r20
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.commonui.utilities.PromptDialogHelper.Properties.<init>(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, java.lang.Integer, java.util.List, java.lang.Integer, boolean, java.lang.Integer, kotlin.e0.c.l, kotlin.e0.c.l, kotlin.e0.c.l, kotlin.e0.c.l, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}