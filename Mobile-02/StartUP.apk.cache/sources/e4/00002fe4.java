package com.facebook.react.views.text;

import android.text.TextUtils;
import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.views.text.h;
import com.lwansbrough.RCTCamera.RCTCameraModule;

/* loaded from: classes2.dex */
public abstract class ReactTextAnchorViewManager<T extends View, C extends h> extends BaseViewManager<T, C> {
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};

    @com.facebook.react.uimanager.c1.a(name = "adjustsFontSizeToFit")
    public void setAdjustFontSizeToFit(r rVar, boolean z) {
        rVar.setAdjustFontSizeToFit(z);
    }

    @com.facebook.react.uimanager.c1.b(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(r rVar, int i2, Integer num) {
        rVar.i(SPACING_TYPES[i2], num == null ? Float.NaN : num.intValue() & 16777215, num != null ? num.intValue() >>> 24 : Float.NaN);
    }

    @com.facebook.react.uimanager.c1.b(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(r rVar, int i2, float f2) {
        if (!com.facebook.yoga.g.a(f2)) {
            f2 = com.facebook.react.uimanager.o.c(f2);
        }
        if (i2 == 0) {
            rVar.setBorderRadius(f2);
        } else {
            rVar.j(f2, i2 - 1);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "borderStyle")
    public void setBorderStyle(r rVar, String str) {
        rVar.setBorderStyle(str);
    }

    @com.facebook.react.uimanager.c1.b(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(r rVar, int i2, float f2) {
        if (!com.facebook.yoga.g.a(f2)) {
            f2 = com.facebook.react.uimanager.o.c(f2);
        }
        rVar.k(SPACING_TYPES[i2], f2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @com.facebook.react.uimanager.c1.a(name = "dataDetectorType")
    public void setDataDetectorType(r rVar, String str) {
        char c2;
        switch (str.hashCode()) {
            case -1192969641:
                if (str.equals("phoneNumber")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 96673:
                if (str.equals("all")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3321850:
                if (str.equals("link")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3387192:
                if (str.equals("none")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 96619420:
                if (str.equals("email")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            rVar.setLinkifyMask(4);
        } else if (c2 == 1) {
            rVar.setLinkifyMask(1);
        } else if (c2 == 2) {
            rVar.setLinkifyMask(2);
        } else if (c2 != 3) {
            rVar.setLinkifyMask(0);
        } else {
            rVar.setLinkifyMask(15);
        }
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = false, name = "disabled")
    public void setDisabled(r rVar, boolean z) {
        rVar.setEnabled(!z);
    }

    @com.facebook.react.uimanager.c1.a(name = "ellipsizeMode")
    public void setEllipsizeMode(r rVar, String str) {
        if (str != null && !str.equals("tail")) {
            if (str.equals("head")) {
                rVar.setEllipsizeLocation(TextUtils.TruncateAt.START);
                return;
            } else if (str.equals("middle")) {
                rVar.setEllipsizeLocation(TextUtils.TruncateAt.MIDDLE);
                return;
            } else if (str.equals("clip")) {
                rVar.setEllipsizeLocation(null);
                return;
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid ellipsizeMode: " + str);
            }
        }
        rVar.setEllipsizeLocation(TextUtils.TruncateAt.END);
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "includeFontPadding")
    public void setIncludeFontPadding(r rVar, boolean z) {
        rVar.setIncludeFontPadding(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "onInlineViewLayout")
    public void setNotifyOnInlineViewLayout(r rVar, boolean z) {
        rVar.setNotifyOnInlineViewLayout(z);
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, name = "numberOfLines")
    public void setNumberOfLines(r rVar, int i2) {
        rVar.setNumberOfLines(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "selectable")
    public void setSelectable(r rVar, boolean z) {
        rVar.setTextIsSelectable(z);
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "selectionColor")
    public void setSelectionColor(r rVar, Integer num) {
        if (num == null) {
            rVar.setHighlightColor(d.c(rVar.getContext()));
        } else {
            rVar.setHighlightColor(num.intValue());
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "textAlignVertical")
    public void setTextAlignVertical(r rVar, String str) {
        if (str != null && !"auto".equals(str)) {
            if ("top".equals(str)) {
                rVar.setGravityVertical(48);
                return;
            } else if ("bottom".equals(str)) {
                rVar.setGravityVertical(80);
                return;
            } else if ("center".equals(str)) {
                rVar.setGravityVertical(16);
                return;
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid textAlignVertical: " + str);
            }
        }
        rVar.setGravityVertical(0);
    }
}