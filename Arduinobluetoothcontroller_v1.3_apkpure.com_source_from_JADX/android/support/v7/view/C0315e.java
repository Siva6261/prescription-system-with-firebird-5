package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.p018b.C0307k;
import android.view.LayoutInflater;

public class C0315e extends ContextWrapper {
    private int f1438a;
    private Theme f1439b;
    private LayoutInflater f1440c;

    public C0315e(Context context, int i) {
        super(context);
        this.f1438a = i;
    }

    public C0315e(Context context, Theme theme) {
        super(context);
        this.f1439b = theme;
    }

    private void m3240b() {
        boolean z = this.f1439b == null;
        if (z) {
            this.f1439b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1439b.setTo(theme);
            }
        }
        m3242a(this.f1439b, this.f1438a, z);
    }

    public int m3241a() {
        return this.f1438a;
    }

    protected void m3242a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1440c == null) {
            this.f1440c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1440c;
    }

    public Theme getTheme() {
        if (this.f1439b != null) {
            return this.f1439b;
        }
        if (this.f1438a == 0) {
            this.f1438a = C0307k.Theme_AppCompat_Light;
        }
        m3240b();
        return this.f1439b;
    }

    public void setTheme(int i) {
        if (this.f1438a != i) {
            this.f1438a = i;
            m3240b();
        }
    }
}
