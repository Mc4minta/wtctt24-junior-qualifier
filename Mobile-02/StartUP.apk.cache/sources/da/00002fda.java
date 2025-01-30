package com.facebook.react.views.swiperefresh;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.BV.LinearGradient.LinearGradientManager;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.c;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.events.d;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.o0;
import com.facebook.react.uimanager.w0;
import e.f.m.a0.i;
import e.f.m.a0.j;
import java.util.Map;
import org.apache.http.client.config.CookieSpecs;

@e.f.m.x.a.a(name = SwipeRefreshLayoutManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class SwipeRefreshLayoutManager extends ViewGroupManager<com.facebook.react.views.swiperefresh.a> implements j<com.facebook.react.views.swiperefresh.a> {
    public static final String REACT_CLASS = "AndroidSwipeRefreshLayout";
    private final w0<com.facebook.react.views.swiperefresh.a> mDelegate = new i(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements SwipeRefreshLayout.j {
        final /* synthetic */ i0 a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.facebook.react.views.swiperefresh.a f5401b;

        a(i0 i0Var, com.facebook.react.views.swiperefresh.a aVar) {
            this.a = i0Var;
            this.f5401b = aVar;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
        public void a() {
            d b2 = o0.b(this.a, this.f5401b.getId());
            if (b2 != null) {
                b2.v(new b(this.f5401b.getId()));
            }
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected w0<com.facebook.react.views.swiperefresh.a> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return c.a().b("topRefresh", c.d("registrationName", "onRefresh")).a();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedViewConstants() {
        return c.d("SIZE", c.e("DEFAULT", 1, "LARGE", 0));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    public void setNativeRefreshing(com.facebook.react.views.swiperefresh.a aVar, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(i0 i0Var, com.facebook.react.views.swiperefresh.a aVar) {
        aVar.setOnRefreshListener(new a(i0Var, aVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public com.facebook.react.views.swiperefresh.a createViewInstance(i0 i0Var) {
        return new com.facebook.react.views.swiperefresh.a(i0Var);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(com.facebook.react.views.swiperefresh.a aVar, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativeRefreshing") && readableArray != null) {
            setRefreshing(aVar, readableArray.getBoolean(0));
        }
    }

    @Override // e.f.m.a0.j
    @com.facebook.react.uimanager.c1.a(customType = "ColorArray", name = LinearGradientManager.PROP_COLORS)
    public void setColors(com.facebook.react.views.swiperefresh.a aVar, ReadableArray readableArray) {
        if (readableArray != null) {
            int[] iArr = new int[readableArray.size()];
            for (int i2 = 0; i2 < readableArray.size(); i2++) {
                if (readableArray.getType(i2) == ReadableType.Map) {
                    iArr[i2] = ColorPropConverter.getColor(readableArray.getMap(i2), aVar.getContext()).intValue();
                } else {
                    iArr[i2] = readableArray.getInt(i2);
                }
            }
            aVar.setColorSchemeColors(iArr);
            return;
        }
        aVar.setColorSchemeColors(new int[0]);
    }

    @Override // e.f.m.a0.j
    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "enabled")
    public void setEnabled(com.facebook.react.views.swiperefresh.a aVar, boolean z) {
        aVar.setEnabled(z);
    }

    @Override // e.f.m.a0.j
    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "progressBackgroundColor")
    public void setProgressBackgroundColor(com.facebook.react.views.swiperefresh.a aVar, Integer num) {
        aVar.setProgressBackgroundColorSchemeColor(num == null ? 0 : num.intValue());
    }

    @Override // e.f.m.a0.j
    @com.facebook.react.uimanager.c1.a(defaultFloat = 0.0f, name = "progressViewOffset")
    public void setProgressViewOffset(com.facebook.react.views.swiperefresh.a aVar, float f2) {
        aVar.setProgressViewOffset(f2);
    }

    @Override // e.f.m.a0.j
    @com.facebook.react.uimanager.c1.a(name = "refreshing")
    public void setRefreshing(com.facebook.react.views.swiperefresh.a aVar, boolean z) {
        aVar.setRefreshing(z);
    }

    @Override // e.f.m.a0.j
    public void setSize(com.facebook.react.views.swiperefresh.a aVar, int i2) {
        aVar.setSize(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "size")
    public void setSize(com.facebook.react.views.swiperefresh.a aVar, Dynamic dynamic) {
        if (dynamic.isNull()) {
            aVar.setSize(1);
        } else if (dynamic.getType() == ReadableType.Number) {
            aVar.setSize(dynamic.asInt());
        } else if (dynamic.getType() == ReadableType.String) {
            String asString = dynamic.asString();
            if (asString.equals(CookieSpecs.DEFAULT)) {
                aVar.setSize(1);
            } else if (asString.equals("large")) {
                aVar.setSize(0);
            } else {
                throw new IllegalArgumentException("Size must be 'default' or 'large', received: " + asString);
            }
        } else {
            throw new IllegalArgumentException("Size must be 'default' or 'large'");
        }
    }
}