package io.branch.referral;

/* compiled from: BranchError.java */
/* loaded from: classes2.dex */
public class d {
    String a;

    /* renamed from: b  reason: collision with root package name */
    int f16934b = -113;

    public d(String str, int i2) {
        this.a = "";
        this.a = str + b(i2);
    }

    private String b(int i2) {
        if (i2 == -113) {
            this.f16934b = -113;
            return " Branch API Error: poor network connectivity. Please try again later.";
        } else if (i2 == -114) {
            this.f16934b = -114;
            return " Branch API Error: Please enter your branch_key in your project's manifest file first.";
        } else if (i2 == -104) {
            this.f16934b = -104;
            return " Did you forget to call init? Make sure you init the session before making Branch calls.";
        } else if (i2 == -101) {
            this.f16934b = -101;
            return " Unable to initialize Branch. Check network connectivity or that your branch key is valid.";
        } else if (i2 == -102) {
            this.f16934b = -102;
            return " Please add 'android.permission.INTERNET' in your applications manifest file.";
        } else if (i2 == -105) {
            this.f16934b = -105;
            return " Unable to create a URL with that alias. If you want to reuse the alias, make sure to submit the same properties for all arguments and that the user is the same owner.";
        } else if (i2 == -106) {
            this.f16934b = -106;
            return " That Branch referral code is already in use.";
        } else if (i2 == -107) {
            this.f16934b = -107;
            return " Unable to redeem rewards. Please make sure you have credits available to redeem.";
        } else if (i2 == -108) {
            this.f16934b = -108;
            return "BranchApp class can be used only with API level 14 or above. Please make sure your minimum API level supported is 14. If you wish to use API level below 14 consider calling getInstance(Context) instead.";
        } else if (i2 == -109) {
            this.f16934b = -109;
            return "Branch instance is not created. Make  sure your Application class is an instance of BranchLikedApp.";
        } else if (i2 == -110) {
            this.f16934b = -110;
            return " Unable create share options. Couldn't find applications on device to share the link.";
        } else if (i2 == -111) {
            this.f16934b = -111;
            return " Request to Branch server timed out. Please check your internet connectivity";
        } else if (i2 == -117) {
            this.f16934b = -117;
            return " Tracking is disabled. Requested operation cannot be completed when tracking is disabled";
        } else if (i2 >= 500 || i2 == -112) {
            this.f16934b = -112;
            return " Unable to reach the Branch servers, please try again shortly.";
        } else if (i2 == 409 || i2 == -115) {
            this.f16934b = -115;
            return " A resource with this identifier already exists.";
        } else if (i2 < 400 && i2 != -116) {
            this.f16934b = -113;
            return " Check network connectivity and that you properly initialized.";
        } else {
            this.f16934b = -116;
            return " The request was invalid.";
        }
    }

    public String a() {
        return this.a;
    }

    public String toString() {
        return a();
    }
}