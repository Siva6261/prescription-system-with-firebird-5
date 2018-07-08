package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.p008c.C0066a;
import android.support.v4.widget.as;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0303g;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class fy extends as implements OnClickListener {
    private final SearchManager f2339j = ((SearchManager) this.d.getSystemService("search"));
    private final SearchView f2340k;
    private final SearchableInfo f2341l;
    private final Context f2342m;
    private final WeakHashMap f2343n;
    private final int f2344o;
    private boolean f2345p = false;
    private int f2346q = 1;
    private ColorStateList f2347r;
    private int f2348s = -1;
    private int f2349t = -1;
    private int f2350u = -1;
    private int f2351v = -1;
    private int f2352w = -1;
    private int f2353x = -1;

    public fy(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f2340k = searchView;
        this.f2341l = searchableInfo;
        this.f2344o = searchView.getSuggestionCommitIconResId();
        this.f2342m = context;
        this.f2343n = weakHashMap;
    }

    private Drawable m4752a(ComponentName componentName) {
        Object obj = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f2343n.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.f2343n.get(flattenToShortString);
            return constantState == null ? null : constantState.newDrawable(this.f2342m.getResources());
        } else {
            Drawable b = m4759b(componentName);
            if (b != null) {
                obj = b.getConstantState();
            }
            this.f2343n.put(flattenToShortString, obj);
            return b;
        }
    }

    private Drawable m4753a(String str) {
        Drawable b;
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f2342m.getPackageName() + "/" + parseInt;
            b = m4761b(str2);
            if (b != null) {
                return b;
            }
            b = C0066a.m958a(this.f2342m, parseInt);
            m4758a(str2, b);
            return b;
        } catch (NumberFormatException e) {
            b = m4761b(str);
            if (b != null) {
                return b;
            }
            b = m4760b(Uri.parse(str));
            m4758a(str, b);
            return b;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private static String m4754a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    public static String m4755a(Cursor cursor, String str) {
        return m4754a(cursor, cursor.getColumnIndex(str));
    }

    private void m4756a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void m4757a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void m4758a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f2343n.put(str, drawable.getConstantState());
        }
    }

    private Drawable m4759b(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    private Drawable m4760b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return m4769a(uri);
            }
            openInputStream = this.f2342m.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (Throwable e4) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
            }
        }
    }

    private Drawable m4761b(String str) {
        ConstantState constantState = (ConstantState) this.f2343n.get(str);
        return constantState == null ? null : constantState.newDrawable();
    }

    private CharSequence m4762b(CharSequence charSequence) {
        if (this.f2347r == null) {
            TypedValue typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(C0298b.textColorSearchUrl, typedValue, true);
            this.f2347r = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f2347r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void m4763d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    private Drawable m4764e(Cursor cursor) {
        if (this.f2351v == -1) {
            return null;
        }
        Drawable a = m4753a(cursor.getString(this.f2351v));
        return a == null ? m4766g(cursor) : a;
    }

    private Drawable m4765f(Cursor cursor) {
        return this.f2352w == -1 ? null : m4753a(cursor.getString(this.f2352w));
    }

    private Drawable m4766g(Cursor cursor) {
        Drawable a = m4752a(this.f2341l.getSearchActivity());
        return a != null ? a : this.d.getPackageManager().getDefaultActivityIcon();
    }

    Cursor m4767a(SearchableInfo searchableInfo, String str, int i) {
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        String[] strArr;
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
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
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    public Cursor mo439a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f2340k.getVisibility() != 0 || this.f2340k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = m4767a(this.f2341l, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    Drawable m4769a(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.d.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public View mo442a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.mo442a(context, cursor, viewGroup);
        a.setTag(new fz(a));
        ((ImageView) a.findViewById(C0303g.edit_query)).setImageResource(this.f2344o);
        return a;
    }

    public void m4771a(int i) {
        this.f2346q = i;
    }

    public void mo440a(Cursor cursor) {
        if (this.f2345p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo440a(cursor);
            if (cursor != null) {
                this.f2348s = cursor.getColumnIndex("suggest_text_1");
                this.f2349t = cursor.getColumnIndex("suggest_text_2");
                this.f2350u = cursor.getColumnIndex("suggest_text_2_url");
                this.f2351v = cursor.getColumnIndex("suggest_icon_1");
                this.f2352w = cursor.getColumnIndex("suggest_icon_2");
                this.f2353x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public void mo771a(View view, Context context, Cursor cursor) {
        fz fzVar = (fz) view.getTag();
        int i = this.f2353x != -1 ? cursor.getInt(this.f2353x) : 0;
        if (fzVar.f2354a != null) {
            m4757a(fzVar.f2354a, m4754a(cursor, this.f2348s));
        }
        if (fzVar.f2355b != null) {
            CharSequence a = m4754a(cursor, this.f2350u);
            a = a != null ? m4762b(a) : m4754a(cursor, this.f2349t);
            if (TextUtils.isEmpty(a)) {
                if (fzVar.f2354a != null) {
                    fzVar.f2354a.setSingleLine(false);
                    fzVar.f2354a.setMaxLines(2);
                }
            } else if (fzVar.f2354a != null) {
                fzVar.f2354a.setSingleLine(true);
                fzVar.f2354a.setMaxLines(1);
            }
            m4757a(fzVar.f2355b, a);
        }
        if (fzVar.f2356c != null) {
            m4756a(fzVar.f2356c, m4764e(cursor), 4);
        }
        if (fzVar.f2357d != null) {
            m4756a(fzVar.f2357d, m4765f(cursor), 8);
        }
        if (this.f2346q == 2 || (this.f2346q == 1 && (i & 1) != 0)) {
            fzVar.f2358e.setVisibility(0);
            fzVar.f2358e.setTag(fzVar.f2354a.getText());
            fzVar.f2358e.setOnClickListener(this);
            return;
        }
        fzVar.f2358e.setVisibility(8);
    }

    public CharSequence mo441c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = m4755a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f2341l.shouldRewriteQueryFromData()) {
            a = m4755a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.f2341l.shouldRewriteQueryFromText()) {
            return null;
        }
        a = m4755a(cursor, "suggest_text_1");
        return a != null ? a : null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = mo442a(this.d, this.c, viewGroup);
            if (a != null) {
                ((fz) a.getTag()).f2354a.setText(e.toString());
            }
            return a;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m4763d(mo438a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m4763d(mo438a());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f2340k.m3863a((CharSequence) tag);
        }
    }
}
