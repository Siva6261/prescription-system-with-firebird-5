package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.C0242m;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0301e;
import android.support.v7.view.C0314d;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import java.util.WeakHashMap;

public class SearchView extends cq implements C0314d {
    static final fi f1797a = new fi();
    private static final boolean f1798b = (VERSION.SDK_INT >= 8);
    private boolean f1799A;
    private boolean f1800B;
    private int f1801C;
    private boolean f1802D;
    private CharSequence f1803E;
    private boolean f1804F;
    private int f1805G;
    private SearchableInfo f1806H;
    private Bundle f1807I;
    private Runnable f1808J;
    private final Runnable f1809K;
    private Runnable f1810L;
    private final WeakHashMap f1811M;
    private final SearchAutoComplete f1812c;
    private final View f1813d;
    private final View f1814e;
    private final ImageView f1815f;
    private final ImageView f1816g;
    private final ImageView f1817h;
    private final ImageView f1818i;
    private final ImageView f1819j;
    private final Drawable f1820k;
    private final int f1821l;
    private final int f1822m;
    private final Intent f1823n;
    private final Intent f1824o;
    private final CharSequence f1825p;
    private fk f1826q;
    private fj f1827r;
    private OnFocusChangeListener f1828s;
    private fl f1829t;
    private OnClickListener f1830u;
    private boolean f1831v;
    private boolean f1832w;
    private C0242m f1833x;
    private boolean f1834y;
    private CharSequence f1835z;

    public class SearchAutoComplete extends al {
        private int f1795a;
        private SearchView f1796b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0298b.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1795a = getThreshold();
        }

        public boolean enoughToFilter() {
            return this.f1795a <= 0 || super.enoughToFilter();
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1796b.m3867d();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1796b.clearFocus();
                        this.f1796b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1796b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.m3846a(getContext())) {
                    SearchView.f1797a.m4700a(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        protected void replaceText(CharSequence charSequence) {
        }

        void setSearchView(SearchView searchView) {
            this.f1796b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1795a = i;
        }
    }

    private Intent m3842a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1803E);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f1807I != null) {
            intent.putExtra("app_data", this.f1807I);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (f1798b) {
            intent.setComponent(this.f1806H.getSearchActivity());
        }
        return intent;
    }

    private void m3843a(int i, String str, String str2) {
        getContext().startActivity(m3842a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private void m3845a(boolean z) {
        boolean z2 = true;
        int i = 8;
        this.f1832w = z;
        int i2 = z ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.f1812c.getText());
        this.f1815f.setVisibility(i2);
        m3848b(z3);
        this.f1813d.setVisibility(z ? 8 : 0);
        if (!(this.f1819j.getDrawable() == null || this.f1831v)) {
            i = 0;
        }
        this.f1819j.setVisibility(i);
        m3853h();
        if (z3) {
            z2 = false;
        }
        m3849c(z2);
        m3852g();
    }

    static boolean m3846a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private CharSequence m3847b(CharSequence charSequence) {
        if (!this.f1831v || this.f1820k == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1812c.getTextSize()) * 1.25d);
        this.f1820k.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1820k), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void m3848b(boolean z) {
        int i = 8;
        if (this.f1834y && m3851f() && hasFocus() && (z || !this.f1802D)) {
            i = 0;
        }
        this.f1816g.setVisibility(i);
    }

    private void m3849c(boolean z) {
        int i;
        if (this.f1802D && !m3866c() && z) {
            i = 0;
            this.f1816g.setVisibility(8);
        } else {
            i = 8;
        }
        this.f1818i.setVisibility(i);
    }

    @TargetApi(8)
    private boolean m3850e() {
        if (this.f1806H == null || !this.f1806H.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1806H.getVoiceSearchLaunchWebSearch()) {
            intent = this.f1823n;
        } else if (this.f1806H.getVoiceSearchLaunchRecognizer()) {
            intent = this.f1824o;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean m3851f() {
        return (this.f1834y || this.f1802D) && !m3866c();
    }

    private void m3852g() {
        int i = 8;
        if (m3851f() && (this.f1816g.getVisibility() == 0 || this.f1818i.getVisibility() == 0)) {
            i = 0;
        }
        this.f1814e.setVisibility(i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0301e.abc_search_view_preferred_width);
    }

    private void m3853h() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.f1812c.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.f1831v || this.f1804F)) {
            i = 0;
        }
        ImageView imageView = this.f1817h;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.f1817h.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void m3854i() {
        post(this.f1809K);
    }

    private void m3855k() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1812c;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m3847b(queryHint));
    }

    @TargetApi(8)
    private void m3856l() {
        int i = 1;
        this.f1812c.setThreshold(this.f1806H.getSuggestThreshold());
        this.f1812c.setImeOptions(this.f1806H.getImeOptions());
        int inputType = this.f1806H.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1806H.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.f1812c.setInputType(inputType);
        if (this.f1833x != null) {
            this.f1833x.mo440a(null);
        }
        if (this.f1806H.getSuggestAuthority() != null) {
            this.f1833x = new fy(getContext(), this, this.f1806H, this.f1811M);
            this.f1812c.setAdapter(this.f1833x);
            fy fyVar = (fy) this.f1833x;
            if (this.f1799A) {
                i = 2;
            }
            fyVar.m4771a(i);
        }
    }

    private void m3857m() {
        CharSequence text = this.f1812c.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f1826q == null || !this.f1826q.m4703a(text.toString())) {
                if (this.f1806H != null) {
                    m3843a(0, null, text.toString());
                }
                setImeVisibility(false);
                m3858n();
            }
        }
    }

    private void m3858n() {
        this.f1812c.dismissDropDown();
    }

    private void m3859o() {
        if (!TextUtils.isEmpty(this.f1812c.getText())) {
            this.f1812c.setText("");
            this.f1812c.requestFocus();
            setImeVisibility(true);
        } else if (!this.f1831v) {
        } else {
            if (this.f1827r == null || !this.f1827r.m4702a()) {
                clearFocus();
                m3845a(true);
            }
        }
    }

    private void m3860p() {
        m3845a(false);
        this.f1812c.requestFocus();
        setImeVisibility(true);
        if (this.f1830u != null) {
            this.f1830u.onClick(this);
        }
    }

    private void m3861q() {
        f1797a.m4699a(this.f1812c);
        f1797a.m4701b(this.f1812c);
    }

    private void setImeVisibility(boolean z) {
        if (z) {
            post(this.f1808J);
            return;
        }
        removeCallbacks(this.f1808J);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f1812c.setText(charSequence);
        this.f1812c.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void mo620a() {
        if (!this.f1804F) {
            this.f1804F = true;
            this.f1805G = this.f1812c.getImeOptions();
            this.f1812c.setImeOptions(this.f1805G | 33554432);
            this.f1812c.setText("");
            setIconified(false);
        }
    }

    void m3863a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void m3864a(CharSequence charSequence, boolean z) {
        this.f1812c.setText(charSequence);
        if (charSequence != null) {
            this.f1812c.setSelection(this.f1812c.length());
            this.f1803E = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m3857m();
        }
    }

    public void mo621b() {
        m3864a((CharSequence) "", false);
        clearFocus();
        m3845a(true);
        this.f1812c.setImeOptions(this.f1805G);
        this.f1804F = false;
    }

    public boolean m3866c() {
        return this.f1832w;
    }

    public void clearFocus() {
        this.f1800B = true;
        setImeVisibility(false);
        super.clearFocus();
        this.f1812c.clearFocus();
        this.f1800B = false;
    }

    void m3867d() {
        m3845a(m3866c());
        m3854i();
        if (this.f1812c.hasFocus()) {
            m3861q();
        }
    }

    public int getImeOptions() {
        return this.f1812c.getImeOptions();
    }

    public int getInputType() {
        return this.f1812c.getInputType();
    }

    public int getMaxWidth() {
        return this.f1801C;
    }

    public CharSequence getQuery() {
        return this.f1812c.getText();
    }

    public CharSequence getQueryHint() {
        return this.f1835z != null ? this.f1835z : (!f1798b || this.f1806H == null || this.f1806H.getHintId() == 0) ? this.f1825p : getContext().getText(this.f1806H.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.f1822m;
    }

    int getSuggestionRowLayout() {
        return this.f1821l;
    }

    public C0242m getSuggestionsAdapter() {
        return this.f1833x;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.f1809K);
        post(this.f1810L);
        super.onDetachedFromWindow();
    }

    protected void onMeasure(int i, int i2) {
        if (m3866c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.f1801C <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.f1801C, size);
                    break;
                }
            case 0:
                if (this.f1801C <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f1801C;
                    break;
                }
            case 1073741824:
                if (this.f1801C > 0) {
                    size = Math.min(this.f1801C, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        fm fmVar = (fm) parcelable;
        super.onRestoreInstanceState(fmVar.getSuperState());
        m3845a(fmVar.f2308a);
        requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable fmVar = new fm(super.onSaveInstanceState());
        fmVar.f2308a = m3866c();
        return fmVar;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m3854i();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f1800B || !isFocusable()) {
            return false;
        }
        if (m3866c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f1812c.requestFocus(i, rect);
        if (requestFocus) {
            m3845a(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1807I = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            m3859o();
        } else {
            m3860p();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1831v != z) {
            this.f1831v = z;
            m3845a(z);
            m3855k();
        }
    }

    public void setImeOptions(int i) {
        this.f1812c.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f1812c.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f1801C = i;
        requestLayout();
    }

    public void setOnCloseListener(fj fjVar) {
        this.f1827r = fjVar;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f1828s = onFocusChangeListener;
    }

    public void setOnQueryTextListener(fk fkVar) {
        this.f1826q = fkVar;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.f1830u = onClickListener;
    }

    public void setOnSuggestionListener(fl flVar) {
        this.f1829t = flVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1835z = charSequence;
        m3855k();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f1799A = z;
        if (this.f1833x instanceof fy) {
            ((fy) this.f1833x).m4771a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1806H = searchableInfo;
        if (this.f1806H != null) {
            if (f1798b) {
                m3856l();
            }
            m3855k();
        }
        boolean z = f1798b && m3850e();
        this.f1802D = z;
        if (this.f1802D) {
            this.f1812c.setPrivateImeOptions("nm");
        }
        m3845a(m3866c());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1834y = z;
        m3845a(m3866c());
    }

    public void setSuggestionsAdapter(C0242m c0242m) {
        this.f1833x = c0242m;
        this.f1812c.setAdapter(this.f1833x);
    }
}
