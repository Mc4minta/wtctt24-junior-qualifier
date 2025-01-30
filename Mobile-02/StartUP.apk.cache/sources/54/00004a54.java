package e.j.l.v;

import android.content.Context;
import e.j.f.h;
import e.j.n.p3.p;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: PinResource.kt */
/* loaded from: classes2.dex */
public final class a {

    /* compiled from: PinResource.kt */
    /* renamed from: e.j.l.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class C0331a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[p.values().length];
            iArr[p.CONFIRMED.ordinal()] = 1;
            iArr[p.CONFIRM_PIN.ordinal()] = 2;
            iArr[p.INCORRECT_PIN.ordinal()] = 3;
            iArr[p.NOT_MATCHING.ordinal()] = 4;
            iArr[p.INVALID_LENGTH.ordinal()] = 5;
            iArr[p.ERROR.ordinal()] = 6;
            a = iArr;
        }
    }

    public final String a(Context context, p pinStatus) {
        int i2;
        m.g(context, "context");
        m.g(pinStatus, "pinStatus");
        switch (C0331a.a[pinStatus.ordinal()]) {
            case 1:
                i2 = R.string.pin_success;
                break;
            case 2:
                i2 = R.string.confirm_pin;
                break;
            case 3:
                i2 = R.string.incorrect;
                break;
            case 4:
                i2 = R.string.pin_error;
                break;
            case 5:
                i2 = R.string.invalid_pin_length;
                break;
            case 6:
                i2 = R.string.error_creating_new_pin;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        String string = context.getString(i2);
        m.f(string, "context.getString(text)");
        return string;
    }

    public final int b(Context context, p pinStatus) {
        m.g(context, "context");
        m.g(pinStatus, "pinStatus");
        int i2 = C0331a.a[pinStatus.ordinal()];
        return h.f(context, (i2 == 1 || i2 == 2) ? R.color.colorPrimary : R.color.errorColor);
    }
}