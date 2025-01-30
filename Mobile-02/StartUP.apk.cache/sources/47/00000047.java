package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.d0;
import androidx.core.widget.NestedScrollView;
import c.h.k.v;
import java.lang.ref.WeakReference;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    final androidx.appcompat.app.h f408b;

    /* renamed from: c  reason: collision with root package name */
    private final Window f409c;

    /* renamed from: d  reason: collision with root package name */
    private final int f410d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f411e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f412f;

    /* renamed from: g  reason: collision with root package name */
    ListView f413g;

    /* renamed from: h  reason: collision with root package name */
    private View f414h;

    /* renamed from: i  reason: collision with root package name */
    private int f415i;

    /* renamed from: j  reason: collision with root package name */
    private int f416j;

    /* renamed from: k  reason: collision with root package name */
    private int f417k;

    /* renamed from: l  reason: collision with root package name */
    private int f418l;
    private int m;
    Button o;
    private CharSequence p;
    Message q;
    private Drawable r;
    Button s;
    private CharSequence t;
    Message u;
    private Drawable v;
    Button w;
    private CharSequence x;
    Message y;
    private Drawable z;
    private boolean n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new a();

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final int f419b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.j.f2);
            this.f419b = obtainStyledAttributes.getDimensionPixelOffset(c.a.j.g2, -1);
            this.a = obtainStyledAttributes.getDimensionPixelOffset(c.a.j.h2, -1);
        }

        public void a(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.a, getPaddingRight(), z2 ? getPaddingBottom() : this.f419b);
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message obtain;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view == alertController.o && (message3 = alertController.q) != null) {
                obtain = Message.obtain(message3);
            } else if (view == alertController.s && (message2 = alertController.u) != null) {
                obtain = Message.obtain(message2);
            } else {
                obtain = (view != alertController.w || (message = alertController.y) == null) ? null : Message.obtain(message);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f408b).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements NestedScrollView.b {
        final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f420b;

        b(View view, View view2) {
            this.a = view;
            this.f420b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.b
        public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            AlertController.f(nestedScrollView, this.a, this.f420b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f422b;

        c(View view, View view2) {
            this.a = view;
            this.f422b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.A, this.a, this.f422b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements AbsListView.OnScrollListener {
        final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f424b;

        d(View view, View view2) {
            this.a = view;
            this.f424b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            AlertController.f(absListView, this.a, this.f424b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f426b;

        e(View view, View view2) {
            this.a = view;
            this.f426b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.f413g, this.a, this.f426b);
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public e O;
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f428b;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f430d;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f432f;

        /* renamed from: g  reason: collision with root package name */
        public View f433g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f434h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f435i;

        /* renamed from: j  reason: collision with root package name */
        public Drawable f436j;

        /* renamed from: k  reason: collision with root package name */
        public DialogInterface.OnClickListener f437k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f438l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;

        /* renamed from: c  reason: collision with root package name */
        public int f429c = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f431e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean P = true;
        public boolean r = true;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends ArrayAdapter<CharSequence> {
            final /* synthetic */ RecycleListView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i2, int i3, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i2, i3, charSequenceArr);
                this.a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i2, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i2, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i2]) {
                    this.a.setItemChecked(i2, true);
                }
                return view2;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b extends CursorAdapter {
            private final int a;

            /* renamed from: b  reason: collision with root package name */
            private final int f440b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ RecycleListView f441c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ AlertController f442d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Context context, Cursor cursor, boolean z, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z);
                this.f441c = recycleListView;
                this.f442d = alertController;
                Cursor cursor2 = getCursor();
                this.a = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f440b = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.a));
                this.f441c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f440b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f428b.inflate(this.f442d.M, viewGroup, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements AdapterView.OnItemClickListener {
            final /* synthetic */ AlertController a;

            c(AlertController alertController) {
                this.a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                f.this.x.onClick(this.a.f408b, i2);
                if (f.this.H) {
                    return;
                }
                this.a.f408b.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class d implements AdapterView.OnItemClickListener {
            final /* synthetic */ RecycleListView a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AlertController f445b;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.a = recycleListView;
                this.f445b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i2] = this.a.isItemChecked(i2);
                }
                f.this.J.onClick(this.f445b.f408b, i2, this.a.isItemChecked(i2));
            }
        }

        /* loaded from: classes.dex */
        public interface e {
            void a(ListView listView);
        }

        public f(Context context) {
            this.a = context;
            this.f428b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            int i2;
            ListAdapter listAdapter;
            RecycleListView recycleListView = (RecycleListView) this.f428b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                if (this.K == null) {
                    listAdapter = new a(this.a, alertController.M, 16908308, this.v, recycleListView);
                } else {
                    listAdapter = new b(this.a, this.K, false, recycleListView, alertController);
                }
            } else {
                if (this.H) {
                    i2 = alertController.N;
                } else {
                    i2 = alertController.O;
                }
                int i3 = i2;
                if (this.K != null) {
                    listAdapter = new SimpleCursorAdapter(this.a, i3, this.K, new String[]{this.L}, new int[]{16908308});
                } else {
                    listAdapter = this.w;
                    if (listAdapter == null) {
                        listAdapter = new h(this.a, i3, 16908308, this.v);
                    }
                }
            }
            e eVar = this.O;
            if (eVar != null) {
                eVar.a(recycleListView);
            }
            alertController.H = listAdapter;
            alertController.I = this.I;
            if (this.x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f413g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.f433g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f432f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f430d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i2 = this.f429c;
                if (i2 != 0) {
                    alertController.m(i2);
                }
                int i3 = this.f431e;
                if (i3 != 0) {
                    alertController.m(alertController.c(i3));
                }
            }
            CharSequence charSequence2 = this.f434h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f435i;
            if (charSequence3 != null || this.f436j != null) {
                alertController.k(-1, charSequence3, this.f437k, null, this.f436j);
            }
            CharSequence charSequence4 = this.f438l;
            if (charSequence4 != null || this.m != null) {
                alertController.k(-2, charSequence4, this.n, null, this.m);
            }
            CharSequence charSequence5 = this.o;
            if (charSequence5 != null || this.p != null) {
                alertController.k(-3, charSequence5, this.q, null, this.p);
            }
            if (this.v != null || this.K != null || this.w != null) {
                b(alertController);
            }
            View view2 = this.z;
            if (view2 != null) {
                if (this.E) {
                    alertController.t(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.s(view2);
                    return;
                }
            }
            int i4 = this.y;
            if (i4 != 0) {
                alertController.r(i4);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class g extends Handler {
        private WeakReference<DialogInterface> a;

        public g(DialogInterface dialogInterface) {
            this.a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.a.get(), message.what);
            } else if (i2 != 1) {
            } else {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h extends ArrayAdapter<CharSequence> {
        public h(Context context, int i2, int i3, CharSequence[] charSequenceArr) {
            super(context, i2, i3, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, androidx.appcompat.app.h hVar, Window window) {
        this.a = context;
        this.f408b = hVar;
        this.f409c = window;
        this.R = new g(hVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, c.a.j.F, c.a.a.n, 0);
        this.J = obtainStyledAttributes.getResourceId(c.a.j.G, 0);
        this.K = obtainStyledAttributes.getResourceId(c.a.j.I, 0);
        this.L = obtainStyledAttributes.getResourceId(c.a.j.K, 0);
        this.M = obtainStyledAttributes.getResourceId(c.a.j.L, 0);
        this.N = obtainStyledAttributes.getResourceId(c.a.j.N, 0);
        this.O = obtainStyledAttributes.getResourceId(c.a.j.J, 0);
        this.P = obtainStyledAttributes.getBoolean(c.a.j.M, true);
        this.f410d = obtainStyledAttributes.getDimensionPixelSize(c.a.j.H, 0);
        obtainStyledAttributes.recycle();
        hVar.supportRequestWindowFeature(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (childCount > 0) {
                childCount--;
                if (a(viewGroup.getChildAt(childCount))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void f(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i2 = this.K;
        if (i2 == 0) {
            return this.J;
        }
        return this.Q == 1 ? i2 : this.J;
    }

    private void p(ViewGroup viewGroup, View view, int i2, int i3) {
        View findViewById = this.f409c.findViewById(c.a.f.v);
        View findViewById2 = this.f409c.findViewById(c.a.f.u);
        if (Build.VERSION.SDK_INT >= 23) {
            v.z0(view, i2, i3);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i2 & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i2 & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById == null && findViewById2 == null) {
            return;
        }
        if (this.f412f != null) {
            this.A.setOnScrollChangeListener(new b(findViewById, findViewById2));
            this.A.post(new c(findViewById, findViewById2));
            return;
        }
        ListView listView = this.f413g;
        if (listView != null) {
            listView.setOnScrollListener(new d(findViewById, findViewById2));
            this.f413g.post(new e(findViewById, findViewById2));
            return;
        }
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 != null) {
            viewGroup.removeView(findViewById2);
        }
    }

    private void u(ViewGroup viewGroup) {
        boolean z;
        Button button = (Button) viewGroup.findViewById(16908313);
        this.o = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.p) && this.r == null) {
            this.o.setVisibility(8);
            z = false;
        } else {
            this.o.setText(this.p);
            Drawable drawable = this.r;
            if (drawable != null) {
                int i2 = this.f410d;
                drawable.setBounds(0, 0, i2, i2);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.o.setVisibility(0);
            z = true;
        }
        Button button2 = (Button) viewGroup.findViewById(16908314);
        this.s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.t) && this.v == null) {
            this.s.setVisibility(8);
        } else {
            this.s.setText(this.t);
            Drawable drawable2 = this.v;
            if (drawable2 != null) {
                int i3 = this.f410d;
                drawable2.setBounds(0, 0, i3, i3);
                this.s.setCompoundDrawables(this.v, null, null, null);
            }
            this.s.setVisibility(0);
            z |= true;
        }
        Button button3 = (Button) viewGroup.findViewById(16908315);
        this.w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.x) && this.z == null) {
            this.w.setVisibility(8);
        } else {
            this.w.setText(this.x);
            Drawable drawable3 = this.z;
            if (drawable3 != null) {
                int i4 = this.f410d;
                drawable3.setBounds(0, 0, i4, i4);
                this.w.setCompoundDrawables(this.z, null, null, null);
            }
            this.w.setVisibility(0);
            z |= true;
        }
        if (z(this.a)) {
            if (z) {
                b(this.o);
            } else if (z) {
                b(this.s);
            } else if (z) {
                b(this.w);
            }
        }
        if (z) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f409c.findViewById(c.a.f.w);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f412f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f413g != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
            int indexOfChild = viewGroup2.indexOfChild(this.A);
            viewGroup2.removeViewAt(indexOfChild);
            viewGroup2.addView(this.f413g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void w(ViewGroup viewGroup) {
        View view = this.f414h;
        if (view == null) {
            view = this.f415i != 0 ? LayoutInflater.from(this.a).inflate(this.f415i, viewGroup, false) : null;
        }
        boolean z = view != null;
        if (!z || !a(view)) {
            this.f409c.setFlags(PKIFailureInfo.unsupportedVersion, PKIFailureInfo.unsupportedVersion);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f409c.findViewById(c.a.f.n);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.n) {
                frameLayout.setPadding(this.f416j, this.f417k, this.f418l, this.m);
            }
            if (this.f413g != null) {
                ((d0.a) viewGroup.getLayoutParams()).a = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void x(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f409c.findViewById(c.a.f.O).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f409c.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.f411e)) && this.P) {
            TextView textView = (TextView) this.f409c.findViewById(c.a.f.f2468j);
            this.E = textView;
            textView.setText(this.f411e);
            int i2 = this.B;
            if (i2 != 0) {
                this.D.setImageResource(i2);
                return;
            }
            Drawable drawable = this.C;
            if (drawable != null) {
                this.D.setImageDrawable(drawable);
                return;
            }
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
            return;
        }
        this.f409c.findViewById(c.a.f.O).setVisibility(8);
        this.D.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.f409c.findViewById(c.a.f.t);
        int i2 = c.a.f.P;
        View findViewById4 = findViewById3.findViewById(i2);
        int i3 = c.a.f.m;
        View findViewById5 = findViewById3.findViewById(i3);
        int i4 = c.a.f.f2469k;
        View findViewById6 = findViewById3.findViewById(i4);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(c.a.f.o);
        w(viewGroup);
        View findViewById7 = viewGroup.findViewById(i2);
        View findViewById8 = viewGroup.findViewById(i3);
        View findViewById9 = viewGroup.findViewById(i4);
        ViewGroup i5 = i(findViewById7, findViewById4);
        ViewGroup i6 = i(findViewById8, findViewById5);
        ViewGroup i7 = i(findViewById9, findViewById6);
        v(i6);
        u(i7);
        x(i5);
        boolean z = viewGroup.getVisibility() != 8;
        boolean z2 = (i5 == null || i5.getVisibility() == 8) ? false : 1;
        boolean z3 = (i7 == null || i7.getVisibility() == 8) ? false : true;
        if (!z3 && i6 != null && (findViewById2 = i6.findViewById(c.a.f.K)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z2) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (this.f412f != null || this.f413g != null) {
                view = i5.findViewById(c.a.f.N);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (i6 != null && (findViewById = i6.findViewById(c.a.f.L)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f413g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z2, z3);
        }
        if (!z) {
            View view2 = this.f413g;
            if (view2 == null) {
                view2 = this.A;
            }
            if (view2 != null) {
                p(i6, view2, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f413g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i8 = this.I;
        if (i8 > -1) {
            listView2.setItemChecked(i8, true);
            listView2.setSelection(i8);
        }
    }

    private static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(c.a.a.m, typedValue, true);
        return typedValue.data != 0;
    }

    public int c(int i2) {
        TypedValue typedValue = new TypedValue();
        this.a.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f413g;
    }

    public void e() {
        this.f408b.setContentView(j());
        y();
    }

    public boolean g(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.k(keyEvent);
    }

    public boolean h(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.k(keyEvent);
    }

    public void k(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.x = charSequence;
            this.y = message;
            this.z = drawable;
        } else if (i2 == -2) {
            this.t = charSequence;
            this.u = message;
            this.v = drawable;
        } else if (i2 == -1) {
            this.p = charSequence;
            this.q = message;
            this.r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void l(View view) {
        this.G = view;
    }

    public void m(int i2) {
        this.C = null;
        this.B = i2;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i2 != 0) {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public void n(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public void o(CharSequence charSequence) {
        this.f412f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(CharSequence charSequence) {
        this.f411e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i2) {
        this.f414h = null;
        this.f415i = i2;
        this.n = false;
    }

    public void s(View view) {
        this.f414h = view;
        this.f415i = 0;
        this.n = false;
    }

    public void t(View view, int i2, int i3, int i4, int i5) {
        this.f414h = view;
        this.f415i = 0;
        this.n = true;
        this.f416j = i2;
        this.f417k = i3;
        this.f418l = i4;
        this.m = i5;
    }
}