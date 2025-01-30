package com.coinbase.wallet.commonui.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.fragment.app.Fragment;
import com.coinbase.wallet.commonui.R;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.models.ActionStyle;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.spongycastle.i18n.MessageBundle;
import org.spongycastle.i18n.TextBundle;

/* compiled from: ActionSheetDialogHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u0011*\u00020\u000e8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper;", "", "Landroid/content/Context;", "context", "Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Properties;", "properties", "Landroidx/appcompat/app/c;", "create", "(Landroid/content/Context;Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Properties;)Landroidx/appcompat/app/c;", "Landroid/app/Activity;", "activity", "Lkotlin/x;", "show", "(Landroid/app/Activity;Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Properties;)V", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Properties;)V", "", "isAlive", "(Landroidx/fragment/app/Fragment;)Z", "<init>", "()V", "Action", "Properties", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ActionSheetDialogHelper {
    public static final ActionSheetDialogHelper INSTANCE = new ActionSheetDialogHelper();

    /* compiled from: ActionSheetDialogHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Action;", "", "", TextBundle.TEXT_ENTRY, "Ljava/lang/CharSequence;", "getText$commonui_productionRelease", "()Ljava/lang/CharSequence;", "Lcom/coinbase/wallet/commonui/models/ActionStyle;", "style", "Lcom/coinbase/wallet/commonui/models/ActionStyle;", "getStyle$commonui_productionRelease", "()Lcom/coinbase/wallet/commonui/models/ActionStyle;", "Lkotlin/Function1;", "Landroid/content/DialogInterface;", "Lkotlin/x;", "listener", "Lkotlin/e0/c/l;", "getListener$commonui_productionRelease", "()Lkotlin/e0/c/l;", "<init>", "(Ljava/lang/CharSequence;Lcom/coinbase/wallet/commonui/models/ActionStyle;Lkotlin/e0/c/l;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
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

    /* compiled from: ActionSheetDialogHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ActionStyle.values().length];
            iArr[ActionStyle.NEGATIVE.ordinal()] = 1;
            iArr[ActionStyle.NEUTRAL.ordinal()] = 2;
            iArr[ActionStyle.POSITIVE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ActionSheetDialogHelper() {
    }

    public static /* synthetic */ void a(l lVar, DialogInterface dialogInterface) {
        m802create$lambda2$lambda1(lVar, dialogInterface);
    }

    public static /* synthetic */ void b(l lVar, DialogInterface dialogInterface) {
        m803create$lambda4$lambda3(lVar, dialogInterface);
    }

    /* renamed from: create$lambda-2$lambda-1 */
    public static final void m802create$lambda2$lambda1(l tmp0, DialogInterface dialogInterface) {
        m.g(tmp0, "$tmp0");
        tmp0.invoke(dialogInterface);
    }

    /* renamed from: create$lambda-4$lambda-3 */
    public static final void m803create$lambda4$lambda3(l tmp0, DialogInterface dialogInterface) {
        m.g(tmp0, "$tmp0");
        tmp0.invoke(dialogInterface);
    }

    private final boolean isAlive(Fragment fragment) {
        return (fragment.getContext() == null || !fragment.isAdded() || fragment.isRemoving() || fragment.isDetached()) ? false : true;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [T, androidx.appcompat.app.c, java.lang.Object, android.app.Dialog] */
    public final androidx.appcompat.app.c create(Context context, Properties properties) {
        int i2;
        m.g(context, "context");
        m.g(properties, "properties");
        d0 d0Var = new d0();
        LayoutInflater from = LayoutInflater.from(context);
        View inflate = from.inflate(R.layout.dialog_bottom_sheet, (ViewGroup) null, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        ((TextView) viewGroup.findViewById(R.id.title)).setText(properties.getTitle$commonui_productionRelease());
        List<Action> actions$commonui_productionRelease = properties.getActions$commonui_productionRelease();
        if (actions$commonui_productionRelease != null) {
            for (Action action : actions$commonui_productionRelease) {
                int i3 = WhenMappings.$EnumSwitchMapping$0[action.getStyle$commonui_productionRelease().ordinal()];
                if (i3 == 1) {
                    i2 = R.color.primary_red;
                } else if (i3 == 2) {
                    i2 = R.color.primary_blue;
                } else if (i3 != 3) {
                    i2 = R.color.primary_blue;
                } else {
                    i2 = R.color.primary_blue;
                }
                View inflate2 = from.inflate(R.layout.dialog_bottom_sheet_button, viewGroup, false);
                int i4 = R.id.button;
                ((TextView) inflate2.findViewById(i4)).setText(action.getText$commonui_productionRelease());
                ((TextView) inflate2.findViewById(i4)).setTextColor(context.getColor(i2));
                TextView textView = (TextView) inflate2.findViewById(i4);
                m.f(textView, "buttonLayout.button");
                View_CommonKt.setOnSingleClickListener$default(textView, 0L, new ActionSheetDialogHelper$create$1$1(action, d0Var), 1, null);
                ((LinearLayout) viewGroup.findViewById(R.id.dialogContainer)).addView(inflate2);
            }
        }
        c.a p = new c.a(context).p(viewGroup);
        final l<DialogInterface, x> onCancelListener$commonui_productionRelease = properties.getOnCancelListener$commonui_productionRelease();
        if (onCancelListener$commonui_productionRelease != null) {
            p.i(new DialogInterface.OnCancelListener() { // from class: com.coinbase.wallet.commonui.utilities.a
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    ActionSheetDialogHelper.a(l.this, dialogInterface);
                }
            });
        }
        final l<DialogInterface, x> onDismissListener$commonui_productionRelease = properties.getOnDismissListener$commonui_productionRelease();
        if (onDismissListener$commonui_productionRelease != null) {
            p.j(new DialogInterface.OnDismissListener() { // from class: com.coinbase.wallet.commonui.utilities.b
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ActionSheetDialogHelper.b(l.this, dialogInterface);
                }
            });
        }
        ?? a = p.a();
        m.f(a, "builder.create()");
        a.setCanceledOnTouchOutside(properties.getCanceledOnTouchOutside$commonui_productionRelease());
        d0Var.a = a;
        ImageButton imageButton = (ImageButton) viewGroup.findViewById(R.id.closeButton);
        m.f(imageButton, "view.closeButton");
        View_CommonKt.setOnSingleClickListener$default(imageButton, 0L, new ActionSheetDialogHelper$create$4(a), 1, null);
        Window window = a.getWindow();
        if (window == null) {
            window = null;
        } else {
            window.getAttributes().windowAnimations = R.style.DialogVerticalSlideAnimation;
        }
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (window != null && attributes != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            attributes.gravity = 81;
            attributes.y = context.getResources().getDimensionPixelSize(R.dimen.view_size_16);
            window.setAttributes(attributes);
        }
        return a;
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

    /* compiled from: ActionSheetDialogHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\t\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R*\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u00020\u000f8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u00020\u00148\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R*\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Properties;", "", "", "Lcom/coinbase/wallet/commonui/utilities/ActionSheetDialogHelper$Action;", "actions", "Ljava/util/List;", "getActions$commonui_productionRelease", "()Ljava/util/List;", "Lkotlin/Function1;", "Landroid/content/DialogInterface;", "Lkotlin/x;", "onDismissListener", "Lkotlin/e0/c/l;", "getOnDismissListener$commonui_productionRelease", "()Lkotlin/e0/c/l;", "", "canceledOnTouchOutside", "Z", "getCanceledOnTouchOutside$commonui_productionRelease", "()Z", "", MessageBundle.TITLE_ENTRY, "Ljava/lang/CharSequence;", "getTitle$commonui_productionRelease", "()Ljava/lang/CharSequence;", "onCancelListener", "getOnCancelListener$commonui_productionRelease", "<init>", "(Ljava/lang/CharSequence;Ljava/util/List;ZLkotlin/e0/c/l;Lkotlin/e0/c/l;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Properties {
        private final List<Action> actions;
        private final boolean canceledOnTouchOutside;
        private final l<DialogInterface, x> onCancelListener;
        private final l<DialogInterface, x> onDismissListener;
        private final CharSequence title;

        /* JADX WARN: Multi-variable type inference failed */
        public Properties(CharSequence title, List<Action> list, boolean z, l<? super DialogInterface, x> lVar, l<? super DialogInterface, x> lVar2) {
            m.g(title, "title");
            this.title = title;
            this.actions = list;
            this.canceledOnTouchOutside = z;
            this.onCancelListener = lVar;
            this.onDismissListener = lVar2;
        }

        public final List<Action> getActions$commonui_productionRelease() {
            return this.actions;
        }

        public final boolean getCanceledOnTouchOutside$commonui_productionRelease() {
            return this.canceledOnTouchOutside;
        }

        public final l<DialogInterface, x> getOnCancelListener$commonui_productionRelease() {
            return this.onCancelListener;
        }

        public final l<DialogInterface, x> getOnDismissListener$commonui_productionRelease() {
            return this.onDismissListener;
        }

        public final CharSequence getTitle$commonui_productionRelease() {
            return this.title;
        }

        public /* synthetic */ Properties(CharSequence charSequence, List list, boolean z, l lVar, l lVar2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? null : lVar, (i2 & 16) != 0 ? null : lVar2);
        }
    }
}