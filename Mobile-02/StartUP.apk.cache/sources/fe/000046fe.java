package e.f.m;

import android.view.KeyEvent;
import android.view.View;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.Map;

/* compiled from: ReactAndroidHWInputDeviceHelper.java */
/* loaded from: classes2.dex */
public class j {
    private static final Map<Integer, String> a = com.facebook.react.common.c.a().b(23, "select").b(66, "select").b(62, "select").b(85, "playPause").b(89, "rewind").b(90, "fastForward").b(19, "up").b(22, "right").b(20, "down").b(21, "left").a();

    /* renamed from: b  reason: collision with root package name */
    private int f12844b = -1;

    /* renamed from: c  reason: collision with root package name */
    private final s f12845c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(s sVar) {
        this.f12845c = sVar;
    }

    private void b(String str, int i2) {
        c(str, i2, -1);
    }

    private void c(String str, int i2, int i3) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("eventType", str);
        writableNativeMap.putInt("eventKeyAction", i3);
        if (i2 != -1) {
            writableNativeMap.putInt("tag", i2);
        }
        this.f12845c.sendEvent("onHWKeyEvent", writableNativeMap);
    }

    public void a() {
        int i2 = this.f12844b;
        if (i2 != -1) {
            b("blur", i2);
        }
        this.f12844b = -1;
    }

    public void d(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        int action = keyEvent.getAction();
        if (action == 1 || action == 0) {
            Map<Integer, String> map = a;
            if (map.containsKey(Integer.valueOf(keyCode))) {
                c(map.get(Integer.valueOf(keyCode)), this.f12844b, action);
            }
        }
    }

    public void e(View view) {
        if (this.f12844b == view.getId()) {
            return;
        }
        int i2 = this.f12844b;
        if (i2 != -1) {
            b("blur", i2);
        }
        this.f12844b = view.getId();
        b("focus", view.getId());
    }
}