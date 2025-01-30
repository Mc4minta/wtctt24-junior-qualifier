package com.toshi.view.fragment.r0;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.appsflyer.share.Constants;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.toshi.model.local.room.Prompt;
import e.j.f.u;
import e.j.f.z;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: PromptDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 52\u00020\u0001:\u00025\u001dB\u0007¢\u0006\u0004\b4\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R*\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001d\u0010,\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R*\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u001e\u001a\u0004\b(\u0010 \"\u0004\b.\u0010\"R\u001d\u00103\u001a\u0002008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010)\u001a\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/toshi/view/fragment/r0/g;", "Landroidx/fragment/app/c;", "Lkotlin/x;", "init", "()V", "j", "initView", "", "d", "()Ljava/lang/String;", "k", "onResume", "Landroid/os/Bundle;", ApiConstants.STATE, "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lkotlin/Function0;", "b", "Lkotlin/e0/c/a;", "e", "()Lkotlin/e0/c/a;", "setOnFirstClick", "(Lkotlin/e0/c/a;)V", "onFirstClick", "g", "setOnThirdClick", "onThirdClick", "Lcom/toshi/view/fragment/r0/g$b;", "f", "Lkotlin/h;", "i", "()Lcom/toshi/view/fragment/r0/g$b;", "type", Constants.URL_CAMPAIGN, "setOnSecondClick", "onSecondClick", "Lcom/toshi/model/local/room/Prompt;", "h", "()Lcom/toshi/model/local/room/Prompt;", "prompt", "<init>", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class g extends androidx.fragment.app.c {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private kotlin.e0.c.a<x> f11386b = new d();

    /* renamed from: c  reason: collision with root package name */
    private kotlin.e0.c.a<x> f11387c;

    /* renamed from: d  reason: collision with root package name */
    private kotlin.e0.c.a<x> f11388d;

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.h f11389e;

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.h f11390f;

    /* compiled from: PromptDialog.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(Prompt info, b type) {
            kotlin.jvm.internal.m.g(info, "info");
            kotlin.jvm.internal.m.g(type, "type");
            Bundle bundle = new Bundle();
            bundle.putParcelable("EXTRA_INFO", info);
            bundle.putParcelable("EXTRA_PROMPT_TYPE", type);
            return bundle;
        }
    }

    /* compiled from: PromptDialog.kt */
    /* loaded from: classes2.dex */
    public enum b implements Parcelable {
        Action(R.layout.fragment_action_prompt_dialog),
        Info(R.layout.fragment_info_prompt_dialog),
        Warning(R.layout.fragment_notification_dialog);
        
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        private final int f11394e;

        /* compiled from: PromptDialog.kt */
        /* loaded from: classes2.dex */
        public static final class a implements Parcelable.Creator<b> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final b createFromParcel(Parcel parcel) {
                kotlin.jvm.internal.m.g(parcel, "parcel");
                return b.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final b[] newArray(int i2) {
                return new b[i2];
            }
        }

        b(int i2) {
            this.f11394e = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final int n() {
            return this.f11394e;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            kotlin.jvm.internal.m.g(out, "out");
            out.writeString(name());
        }
    }

    /* compiled from: PromptDialog.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            iArr[b.Action.ordinal()] = 1;
            iArr[b.Info.ordinal()] = 2;
            iArr[b.Warning.ordinal()] = 3;
            a = iArr;
        }
    }

    /* compiled from: PromptDialog.kt */
    /* loaded from: classes2.dex */
    static final class d extends o implements kotlin.e0.c.a<x> {
        d() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ x invoke() {
            invoke2();
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            g.this.dismissAllowingStateLoss();
        }
    }

    /* compiled from: PromptDialog.kt */
    /* loaded from: classes2.dex */
    static final class e extends o implements kotlin.e0.c.a<Prompt> {
        e() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final Prompt invoke() {
            return (Prompt) e.j.f.e.b(g.this.getArguments(), "EXTRA_INFO");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PromptDialog.kt */
    /* loaded from: classes2.dex */
    public static final class f extends o implements kotlin.e0.c.l<View, x> {
        f() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            g.this.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PromptDialog.kt */
    /* renamed from: com.toshi.view.fragment.r0.g$g  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0246g extends o implements kotlin.e0.c.l<View, x> {
        C0246g() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            g.this.e().invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PromptDialog.kt */
    /* loaded from: classes2.dex */
    public static final class h extends o implements kotlin.e0.c.l<View, x> {
        h() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            g.this.e().invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PromptDialog.kt */
    /* loaded from: classes2.dex */
    public static final class i extends o implements kotlin.e0.c.l<View, x> {
        i() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            kotlin.e0.c.a<x> f2 = g.this.f();
            if (f2 == null) {
                return;
            }
            f2.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PromptDialog.kt */
    /* loaded from: classes2.dex */
    public static final class j extends o implements kotlin.e0.c.l<View, x> {
        j() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            kotlin.e0.c.a<x> g2 = g.this.g();
            if (g2 == null) {
                return;
            }
            g2.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PromptDialog.kt */
    /* loaded from: classes2.dex */
    public static final class k extends o implements kotlin.e0.c.l<View, x> {
        k() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            g.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PromptDialog.kt */
    /* loaded from: classes2.dex */
    public static final class l extends o implements kotlin.e0.c.l<View, x> {
        l() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            kotlin.e0.c.a<x> f2 = g.this.f();
            if (f2 == null) {
                return;
            }
            f2.invoke();
        }
    }

    /* compiled from: PromptDialog.kt */
    /* loaded from: classes2.dex */
    static final class m extends o implements kotlin.e0.c.a<b> {
        m() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final b invoke() {
            return (b) e.j.f.e.b(g.this.getArguments(), "EXTRA_PROMPT_TYPE");
        }
    }

    public g() {
        kotlin.h b2;
        kotlin.h b3;
        b2 = kotlin.k.b(new e());
        this.f11389e = b2;
        b3 = kotlin.k.b(new m());
        this.f11390f = b3;
    }

    private final String d() {
        if (h().getFormatArgs() != null) {
            String[] formatArgs = h().getFormatArgs();
            if (formatArgs == null) {
                return "";
            }
            String string = getString(h().getMessage(), Arrays.copyOf(formatArgs, formatArgs.length));
            kotlin.jvm.internal.m.f(string, "{\n            val formatArgs: Array<String> = prompt.formatArgs ?: return \"\"\n            getString(prompt.message, *formatArgs)\n        }");
            return string;
        }
        String string2 = getString(h().getMessage());
        kotlin.jvm.internal.m.f(string2, "getString(prompt.message)");
        return string2;
    }

    private final Prompt h() {
        return (Prompt) this.f11389e.getValue();
    }

    private final b i() {
        return (b) this.f11390f.getValue();
    }

    private final void init() {
        j();
        k();
        initView();
    }

    private final void initView() {
        View notificationIcon;
        int i2 = c.a[i().ordinal()];
        int i3 = R.string.got_it;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                View view = getView();
                ((TextView) (view == null ? null : view.findViewById(e.j.a.notificationTitle))).setText(getString(h().getTitle()));
                View view2 = getView();
                ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.notificationMessage))).setText(u.b(d()));
                View view3 = getView();
                notificationIcon = view3 != null ? view3.findViewById(e.j.a.notificationIcon) : null;
                kotlin.jvm.internal.m.f(notificationIcon, "notificationIcon");
                notificationIcon.setVisibility(8);
                return;
            }
            View view4 = getView();
            ((TextView) (view4 == null ? null : view4.findViewById(e.j.a.infoPromptTitle))).setText(getString(h().getTitle()));
            View view5 = getView();
            ((TextView) (view5 == null ? null : view5.findViewById(e.j.a.infoPromptMessage))).setText(u.b(d()));
            Integer imageResource = h().getImageResource();
            if (imageResource != null) {
                int intValue = imageResource.intValue();
                View view6 = getView();
                ((ImageView) (view6 == null ? null : view6.findViewById(e.j.a.infoPromptIcon))).setImageDrawable(androidx.core.content.a.f(requireContext(), intValue));
            }
            View view7 = getView();
            View infoPromptIcon = view7 == null ? null : view7.findViewById(e.j.a.infoPromptIcon);
            kotlin.jvm.internal.m.f(infoPromptIcon, "infoPromptIcon");
            infoPromptIcon.setVisibility(h().getImageResource() != null ? 0 : 8);
            View view8 = getView();
            View infoSpacing = view8 == null ? null : view8.findViewById(e.j.a.infoSpacing);
            kotlin.jvm.internal.m.f(infoSpacing, "infoSpacing");
            infoSpacing.setVisibility(h().getImageResource() == null ? 0 : 8);
            View view9 = getView();
            notificationIcon = view9 != null ? view9.findViewById(e.j.a.infoActionButton) : null;
            ((Button) notificationIcon).setText(getString(R.string.got_it));
            return;
        }
        View view10 = getView();
        ((TextView) (view10 == null ? null : view10.findViewById(e.j.a.actionPromptTitle))).setText(h().getTitle());
        View view11 = getView();
        ((TextView) (view11 == null ? null : view11.findViewById(e.j.a.actionPromptMessage))).setText(d());
        Integer imageResource2 = h().getImageResource();
        if (imageResource2 != null) {
            int intValue2 = imageResource2.intValue();
            View view12 = getView();
            ((ImageView) (view12 == null ? null : view12.findViewById(e.j.a.actionPromptIcon))).setImageDrawable(androidx.core.content.a.f(requireContext(), intValue2));
        }
        View view13 = getView();
        View actionPromptIcon = view13 == null ? null : view13.findViewById(e.j.a.actionPromptIcon);
        kotlin.jvm.internal.m.f(actionPromptIcon, "actionPromptIcon");
        actionPromptIcon.setVisibility(h().getImageResource() != null ? 0 : 8);
        View view14 = getView();
        Button button = (Button) (view14 == null ? null : view14.findViewById(e.j.a.f13508c));
        Integer firstButtonId = h().getFirstButtonId();
        button.setText(getString(firstButtonId == null ? R.string.got_it : firstButtonId.intValue()));
        View view15 = getView();
        Button button2 = (Button) (view15 == null ? null : view15.findViewById(e.j.a.firstButton));
        Integer firstButtonId2 = h().getFirstButtonId();
        if (firstButtonId2 != null) {
            i3 = firstButtonId2.intValue();
        }
        button2.setText(getString(i3));
        if (this.f11387c != null) {
            View view16 = getView();
            Button button3 = (Button) (view16 == null ? null : view16.findViewById(e.j.a.secondButton));
            Integer secondButtonId = h().getSecondButtonId();
            button3.setText(getString(secondButtonId == null ? R.string.remind_later : secondButtonId.intValue()));
        } else {
            View view17 = getView();
            ((Button) (view17 == null ? null : view17.findViewById(e.j.a.secondButton))).setVisibility(8);
        }
        if (this.f11388d != null) {
            View view18 = getView();
            ((Button) (view18 == null ? null : view18.findViewById(e.j.a.thirdButton))).setVisibility(0);
            View view19 = getView();
            notificationIcon = view19 != null ? view19.findViewById(e.j.a.thirdButton) : null;
            Button button4 = (Button) notificationIcon;
            Integer thirdButtonId = h().getThirdButtonId();
            button4.setText(getString(thirdButtonId == null ? R.string.dont_show_again : thirdButtonId.intValue()));
            return;
        }
        View view20 = getView();
        notificationIcon = view20 != null ? view20.findViewById(e.j.a.thirdButton) : null;
        ((Button) notificationIcon).setVisibility(8);
    }

    private final void j() {
        BaseApplication.Companion.getComponent().inject(this);
    }

    private final void k() {
        int i2 = c.a[i().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                View view = getView();
                View infoActionButton = view != null ? view.findViewById(e.j.a.infoActionButton) : null;
                kotlin.jvm.internal.m.f(infoActionButton, "infoActionButton");
                View_CommonKt.setOnSingleClickListener$default(infoActionButton, 0L, new f(), 1, null);
                return;
            } else if (i2 != 3) {
                return;
            } else {
                View view2 = getView();
                Button button = (Button) (view2 == null ? null : view2.findViewById(e.j.a.positiveActionButton));
                kotlin.jvm.internal.m.f(button, "");
                View_CommonKt.setOnSingleClickListener$default(button, 0L, new k(), 1, null);
                button.setAllCaps(true);
                View view3 = getView();
                Button button2 = (Button) (view3 != null ? view3.findViewById(e.j.a.dismissButton) : null);
                kotlin.jvm.internal.m.f(button2, "");
                button2.setVisibility(f() != null ? 0 : 8);
                View_CommonKt.setOnSingleClickListener$default(button2, 0L, new l(), 1, null);
                return;
            }
        }
        if (this.f11388d != null) {
            View view4 = getView();
            ((Button) (view4 == null ? null : view4.findViewById(e.j.a.firstButton))).setVisibility(0);
            View view5 = getView();
            ((Button) (view5 == null ? null : view5.findViewById(e.j.a.f13508c))).setVisibility(8);
        }
        View view6 = getView();
        View firstButton = view6 == null ? null : view6.findViewById(e.j.a.firstButton);
        kotlin.jvm.internal.m.f(firstButton, "firstButton");
        View_CommonKt.setOnSingleClickListener$default(firstButton, 0L, new C0246g(), 1, null);
        View view7 = getView();
        View actionButton = view7 == null ? null : view7.findViewById(e.j.a.f13508c);
        kotlin.jvm.internal.m.f(actionButton, "actionButton");
        View_CommonKt.setOnSingleClickListener$default(actionButton, 0L, new h(), 1, null);
        View view8 = getView();
        View secondButton = view8 == null ? null : view8.findViewById(e.j.a.secondButton);
        kotlin.jvm.internal.m.f(secondButton, "secondButton");
        View_CommonKt.setOnSingleClickListener$default(secondButton, 0L, new i(), 1, null);
        View view9 = getView();
        View thirdButton = view9 != null ? view9.findViewById(e.j.a.thirdButton) : null;
        kotlin.jvm.internal.m.f(thirdButton, "thirdButton");
        View_CommonKt.setOnSingleClickListener$default(thirdButton, 0L, new j(), 1, null);
    }

    public final kotlin.e0.c.a<x> e() {
        return this.f11386b;
    }

    public final kotlin.e0.c.a<x> f() {
        return this.f11387c;
    }

    public final kotlin.e0.c.a<x> g() {
        return this.f11388d;
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        kotlin.jvm.internal.m.f(onCreateDialog, "super.onCreateDialog(state)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        Window window2 = onCreateDialog.getWindow();
        if (window2 != null) {
            z.b(window2, 17170445);
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(i().n(), viewGroup);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        Window window2 = dialog.getWindow();
        WindowManager.LayoutParams attributes = window2 == null ? null : window2.getAttributes();
        if (attributes != null) {
            attributes.width = -1;
        }
        if (attributes != null) {
            attributes.height = -2;
        }
        if (attributes != null) {
            attributes.gravity = 80;
        }
        x xVar = x.a;
        window.setAttributes(attributes);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        init();
    }
}