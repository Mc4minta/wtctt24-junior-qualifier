package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.coinbase.wallet.core.extensions.Strings;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: SuggestionsAdapter.java */
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
class m0 extends c.i.a.c implements View.OnClickListener {
    private int A;
    private int B;
    private int C;
    private final SearchView m;
    private final SearchableInfo n;
    private final Context p;
    private final WeakHashMap<String, Drawable.ConstantState> q;
    private final int t;
    private boolean u;
    private int v;
    private ColorStateList w;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuggestionsAdapter.java */
    /* loaded from: classes.dex */
    public static final class a {
        public final TextView a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f854b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f855c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f856d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f857e;

        public a(View view) {
            this.a = (TextView) view.findViewById(16908308);
            this.f854b = (TextView) view.findViewById(16908309);
            this.f855c = (ImageView) view.findViewById(16908295);
            this.f856d = (ImageView) view.findViewById(16908296);
            this.f857e = (ImageView) view.findViewById(c.a.f.q);
        }
    }

    public m0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.u = false;
        this.v = 1;
        this.x = -1;
        this.y = -1;
        this.z = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.m = searchView;
        this.n = searchableInfo;
        this.t = searchView.getSuggestionCommitIconResId();
        this.p = context;
        this.q = weakHashMap;
    }

    private void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.q.put(str, drawable.getConstantState());
        }
    }

    private void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    private Drawable k(String str) {
        Drawable.ConstantState constantState = this.q.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence l(CharSequence charSequence) {
        if (this.w == null) {
            TypedValue typedValue = new TypedValue();
            this.f3082d.getTheme().resolveAttribute(c.a.a.M, typedValue, true);
            this.w = this.f3082d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.w, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable m(ComponentName componentName) {
        PackageManager packageManager = this.f3082d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable == null) {
                Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
                return null;
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w("SuggestionsAdapter", e2.toString());
            return null;
        }
    }

    private Drawable n(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (this.q.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState = this.q.get(flattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.p.getResources());
        }
        Drawable m = m(componentName);
        this.q.put(flattenToShortString, m != null ? m.getConstantState() : null);
        return m;
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    private Drawable p() {
        Drawable n = n(this.n.getSearchActivity());
        return n != null ? n : this.f3082d.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable q(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.p.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                try {
                    openInputStream.close();
                } catch (IOException e2) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e2);
                }
                return createFromStream;
            }
            throw new FileNotFoundException("Failed to open " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
        return null;
    }

    private Drawable s(String str) {
        if (str == null || str.isEmpty() || Strings.zero.equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.p.getPackageName() + "/" + parseInt;
            Drawable k2 = k(str2);
            if (k2 != null) {
                return k2;
            }
            Drawable f2 = androidx.core.content.a.f(this.p, parseInt);
            A(str2, f2);
            return f2;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable k3 = k(str);
            if (k3 != null) {
                return k3;
            }
            Drawable q = q(Uri.parse(str));
            A(str, q);
            return q;
        }
    }

    private Drawable t(Cursor cursor) {
        int i2 = this.A;
        if (i2 == -1) {
            return null;
        }
        Drawable s = s(cursor.getString(i2));
        return s != null ? s : p();
    }

    private Drawable u(Cursor cursor) {
        int i2 = this.B;
        if (i2 == -1) {
            return null;
        }
        return s(cursor.getString(i2));
    }

    private static String w(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    private void y(ImageView imageView, Drawable drawable, int i2) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i2);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    @Override // c.i.a.a, c.i.a.b.a
    public void a(Cursor cursor) {
        if (this.u) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.x = cursor.getColumnIndex("suggest_text_1");
                this.y = cursor.getColumnIndex("suggest_text_2");
                this.z = cursor.getColumnIndex("suggest_text_2_url");
                this.A = cursor.getColumnIndex("suggest_icon_1");
                this.B = cursor.getColumnIndex("suggest_icon_2");
                this.C = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e2);
        }
    }

    @Override // c.i.a.a, c.i.a.b.a
    public CharSequence c(Cursor cursor) {
        String o;
        String o2;
        if (cursor == null) {
            return null;
        }
        String o3 = o(cursor, "suggest_intent_query");
        if (o3 != null) {
            return o3;
        }
        if (!this.n.shouldRewriteQueryFromData() || (o2 = o(cursor, "suggest_intent_data")) == null) {
            if (!this.n.shouldRewriteQueryFromText() || (o = o(cursor, "suggest_text_1")) == null) {
                return null;
            }
            return o;
        }
        return o2;
    }

    @Override // c.i.a.b.a
    public Cursor d(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.m.getVisibility() == 0 && this.m.getWindowVisibility() == 0) {
            try {
                Cursor v = v(this.n, charSequence2, 50);
                if (v != null) {
                    v.getCount();
                    return v;
                }
            } catch (RuntimeException e2) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
            }
        }
        return null;
    }

    @Override // c.i.a.a
    public void e(View view, Context context, Cursor cursor) {
        CharSequence w;
        a aVar = (a) view.getTag();
        int i2 = this.C;
        int i3 = i2 != -1 ? cursor.getInt(i2) : 0;
        if (aVar.a != null) {
            z(aVar.a, w(cursor, this.x));
        }
        if (aVar.f854b != null) {
            String w2 = w(cursor, this.z);
            if (w2 != null) {
                w = l(w2);
            } else {
                w = w(cursor, this.y);
            }
            if (TextUtils.isEmpty(w)) {
                TextView textView = aVar.a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.a.setMaxLines(1);
                }
            }
            z(aVar.f854b, w);
        }
        ImageView imageView = aVar.f855c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f856d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i4 = this.v;
        if (i4 != 2 && (i4 != 1 || (i3 & 1) == 0)) {
            aVar.f857e.setVisibility(8);
            return;
        }
        aVar.f857e.setVisibility(0);
        aVar.f857e.setTag(aVar.a.getText());
        aVar.f857e.setOnClickListener(this);
    }

    @Override // c.i.a.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View g2 = g(this.f3082d, this.f3081c, viewGroup);
            if (g2 != null) {
                ((a) g2.getTag()).a.setText(e2.toString());
            }
            return g2;
        }
    }

    @Override // c.i.a.a, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View h2 = h(this.f3082d, this.f3081c, viewGroup);
            if (h2 != null) {
                ((a) h2.getTag()).a.setText(e2.toString());
            }
            return h2;
        }
    }

    @Override // c.i.a.c, c.i.a.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View h2 = super.h(context, cursor, viewGroup);
        h2.setTag(new a(h2));
        ((ImageView) h2.findViewById(c.a.f.q)).setImageResource(this.t);
        return h2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(b());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.m.U((CharSequence) tag);
        }
    }

    Drawable r(Uri uri) throws FileNotFoundException {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f3082d.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        throw new FileNotFoundException("No authority: " + uri);
    }

    Cursor v(SearchableInfo searchableInfo, String str, int i2) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i2 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i2));
        }
        return this.f3082d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    public void x(int i2) {
        this.v = i2;
    }
}