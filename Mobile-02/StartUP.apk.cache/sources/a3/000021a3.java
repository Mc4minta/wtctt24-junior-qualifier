package com.coinbase.wallet.features.signer.views;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import c.h.k.d0;
import c.h.k.v;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.Window_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.signer.interfaces.RequestSigning;
import com.coinbase.wallet.features.signer.interfaces.StackedRequestItem;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.uber.autodispose.x;
import h.c.s;
import java.net.URL;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: RequestSigningDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 G*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u00052\u00020\u00062\u00020\u0007:\u0001GB\u0007¢\u0006\u0004\bF\u0010\u000fJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u000fJ!\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u0019\u0010\u0016\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\u001f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001d\u0010(\u001a\u00020\u001f8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010#R@\u0010,\u001a&\u0012\f\u0012\n +*\u0004\u0018\u00010*0* +*\u0012\u0012\f\u0012\n +*\u0004\u0018\u00010*0*\u0018\u00010)0)8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001c\u00104\u001a\u00028\u00018$@$X¤\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00108\u001a\u0002058B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R$\u0010>\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010*0*0=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R$\u0010@\u001a\u0004\u0018\u00018\u00008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lcom/coinbase/wallet/features/signer/views/RequestSigningDialog;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "R", "Lcom/coinbase/wallet/features/signer/interfaces/StackedRequestItem;", "I", "Ldagger/android/g/d;", "Lcom/coinbase/wallet/features/signer/interfaces/RequestSigning;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Lkotlin/x;", "setUpViewModel", "()V", "setup", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onCreate", "(Landroid/os/Bundle;)V", "Ljava/net/URL;", "imageUrl", "Landroid/widget/ImageView;", "imageView", "loadImageInto$app_productionRelease", "(Ljava/net/URL;Landroid/widget/ImageView;)V", "loadImageInto", "", "shown", "Z", "getShown", "()Z", "setShown", "(Z)V", "isFullScreen$delegate", "Lkotlin/h;", "isFullScreen", "Lh/c/s;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "kotlin.jvm.PlatformType", "signingSessionEvents", "Lh/c/s;", "getSigningSessionEvents", "()Lh/c/s;", "getViewModel", "()Lcom/coinbase/wallet/features/signer/interfaces/StackedRequestItem;", "setViewModel", "(Lcom/coinbase/wallet/features/signer/interfaces/StackedRequestItem;)V", "viewModel", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lh/c/v0/b;", "signingSessionEventSubject", "Lh/c/v0/b;", "viewState", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "getViewState", "()Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "setViewState", "(Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;)V", "<init>", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class RequestSigningDialog<R extends SignatureRequestViewState, I extends StackedRequestItem<R>> extends dagger.android.g.d implements RequestSigning, StyledFragment {
    public static final Companion Companion = new Companion(null);
    public static final String IS_FULLSCREEN = "is_fullscreen";
    private final kotlin.h isFullScreen$delegate;
    private boolean shown;
    private final h.c.v0.b<SigningSessionEvent> signingSessionEventSubject;
    private final s<SigningSessionEvent> signingSessionEvents;
    private R viewState;

    /* compiled from: RequestSigningDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J]\u0010\r\u001a\u00028\u0004\"\b\b\u0002\u0010\u0003*\u00020\u0002\"\u000e\b\u0003\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00020\u0004\"\u0014\b\u0004\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00062\u0006\u0010\b\u001a\u00028\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00040\t2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/features/signer/views/RequestSigningDialog$Companion;", "", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "R", "Lcom/coinbase/wallet/features/signer/interfaces/StackedRequestItem;", "I", "Lcom/coinbase/wallet/features/signer/views/RequestSigningDialog;", "V", "viewState", "Ljava/lang/Class;", "clazz", "", "isFullScreen", "getInstance", "(Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;Ljava/lang/Class;Z)Lcom/coinbase/wallet/features/signer/views/RequestSigningDialog;", "", "IS_FULLSCREEN", "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ RequestSigningDialog getInstance$default(Companion companion, SignatureRequestViewState signatureRequestViewState, Class cls, boolean z, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                z = false;
            }
            return companion.getInstance(signatureRequestViewState, cls, z);
        }

        public final <R extends SignatureRequestViewState, I extends StackedRequestItem<R>, V extends RequestSigningDialog<R, I>> V getInstance(R viewState, Class<V> clazz, boolean z) {
            kotlin.jvm.internal.m.g(viewState, "viewState");
            kotlin.jvm.internal.m.g(clazz, "clazz");
            V newInstance = clazz.newInstance();
            V v = newInstance;
            v.setViewState(viewState);
            v.setArguments(new Bundle());
            Bundle arguments = v.getArguments();
            if (arguments != null) {
                arguments.putBoolean(RequestSigningDialog.IS_FULLSCREEN, z);
            }
            kotlin.jvm.internal.m.f(newInstance, "clazz.newInstance().apply {\n            this.viewState = viewState\n            arguments = Bundle()\n            arguments?.putBoolean(IS_FULLSCREEN, isFullScreen)\n        }");
            return v;
        }
    }

    public RequestSigningDialog() {
        kotlin.h b2;
        h.c.v0.b<SigningSessionEvent> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<SigningSessionEvent>()");
        this.signingSessionEventSubject = d2;
        b2 = kotlin.k.b(new RequestSigningDialog$isFullScreen$2(this));
        this.isFullScreen$delegate = b2;
        this.signingSessionEvents = d2.hide();
    }

    public static /* synthetic */ void d(RequestSigningDialog requestSigningDialog, DialogInterface dialogInterface) {
        m1451onCreateDialog$lambda4$lambda3(requestSigningDialog, dialogInterface);
    }

    public static /* synthetic */ void e(RequestSigningDialog requestSigningDialog, DialogInterface dialogInterface) {
        m1450onCreateDialog$lambda1$lambda0(requestSigningDialog, dialogInterface);
    }

    public static /* synthetic */ void f(RequestSigningDialog requestSigningDialog, Throwable th) {
        m1453onResume$lambda7(requestSigningDialog, th);
    }

    public static /* synthetic */ void g(RequestSigningDialog requestSigningDialog, SigningSessionEvent signingSessionEvent) {
        m1452onResume$lambda6(requestSigningDialog, signingSessionEvent);
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    /* renamed from: onCreateDialog$lambda-1$lambda-0 */
    public static final void m1450onCreateDialog$lambda1$lambda0(RequestSigningDialog this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.setShown(true);
    }

    /* renamed from: onCreateDialog$lambda-4$lambda-3 */
    public static final void m1451onCreateDialog$lambda4$lambda3(RequestSigningDialog this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Objects.requireNonNull(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final BottomSheetBehavior I = BottomSheetBehavior.I((FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet));
        I.S(3);
        I.N(new BottomSheetBehavior.c() { // from class: com.coinbase.wallet.features.signer.views.RequestSigningDialog$onCreateDialog$2$1$1$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
            public void onSlide(View p0, float f2) {
                kotlin.jvm.internal.m.g(p0, "p0");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
            public void onStateChanged(View view, int i2) {
                kotlin.jvm.internal.m.g(view, "view");
                if (i2 == 1) {
                    I.S(3);
                }
            }
        });
        this$0.setShown(true);
    }

    /* renamed from: onResume$lambda-6 */
    public static final void m1452onResume$lambda6(RequestSigningDialog this$0, SigningSessionEvent signingSessionEvent) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.signingSessionEventSubject.onNext(signingSessionEvent);
    }

    /* renamed from: onResume$lambda-7 */
    public static final void m1453onResume$lambda7(RequestSigningDialog this$0, Throwable it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        h.c.v0.b<SigningSessionEvent> bVar = this$0.signingSessionEventSubject;
        String uuid = this$0.getViewModel().getUuid();
        kotlin.jvm.internal.m.f(it, "it");
        bVar.onNext(new SigningSessionEvent.Failure(uuid, it));
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 4, null);
    }

    public final boolean getShown() {
        return this.shown;
    }

    @Override // com.coinbase.wallet.features.signer.interfaces.RequestSigning
    public s<SigningSessionEvent> getSigningSessionEvents() {
        return this.signingSessionEvents;
    }

    protected abstract I getViewModel();

    protected final R getViewState() {
        return this.viewState;
    }

    public final boolean isFullScreen() {
        return ((Boolean) this.isFullScreen$delegate.getValue()).booleanValue();
    }

    public final void loadImageInto$app_productionRelease(URL imageUrl, final ImageView imageView) {
        kotlin.jvm.internal.m.g(imageUrl, "imageUrl");
        kotlin.jvm.internal.m.g(imageView, "imageView");
        Glide.with(requireContext()).load(imageUrl.toString()).listener(new RequestListener<Drawable>() { // from class: com.coinbase.wallet.features.signer.views.RequestSigningDialog$loadImageInto$1
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                imageView.setVisibility(8);
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                return false;
            }
        }).into(imageView);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isFullScreen()) {
            setStyle(0, R.style.AppTheme);
        }
    }

    @Override // androidx.appcompat.app.i, androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        if (isFullScreen()) {
            Dialog dialog = new Dialog(requireContext(), getTheme());
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.coinbase.wallet.features.signer.views.f
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    RequestSigningDialog.e(RequestSigningDialog.this, dialogInterface);
                }
            });
            Window window = dialog.getWindow();
            if (window != null) {
                Window_CommonKt.enableFullscreenWindow(window);
            }
            return dialog;
        }
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(requireContext(), getTheme());
        aVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.coinbase.wallet.features.signer.views.e
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                RequestSigningDialog.d(RequestSigningDialog.this, dialogInterface);
            }
        });
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((x) getViewModel().getSignatureRequestEvents().as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.signer.views.h
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                RequestSigningDialog.g(RequestSigningDialog.this, (SigningSessionEvent) obj);
            }
        }, new h.c.m0.f() { // from class: com.coinbase.wallet.features.signer.views.g
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                RequestSigningDialog.f(RequestSigningDialog.this, (Throwable) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.x xVar;
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        if (isFullScreen()) {
            v.w0(view, new c.h.k.q() { // from class: com.coinbase.wallet.features.signer.views.a
                @Override // c.h.k.q
                public final d0 a(View view2, d0 d0Var) {
                    return RequestSigningDialog.this.applyWindowInsets(view2, d0Var);
                }
            });
        }
        R r = this.viewState;
        if (r == null) {
            xVar = null;
        } else {
            setUpViewModel();
            getViewModel().setViewState(r);
            setup();
            xVar = kotlin.x.a;
        }
        if (xVar == null) {
            dismiss();
        }
        setCancelable(false);
    }

    protected final void setShown(boolean z) {
        this.shown = z;
    }

    public abstract void setUpViewModel();

    protected abstract void setViewModel(I i2);

    protected final void setViewState(R r) {
        this.viewState = r;
    }

    public abstract void setup();
}