package android.support.v7.p005a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p006b.C0067a;
import android.support.v4.p006b.ad;
import android.support.v4.p006b.bl;
import android.support.v4.p006b.bt;
import android.support.v4.p006b.bu;
import android.support.v4.view.C0235v;
import android.support.v7.view.C0274c;
import android.support.v7.view.C0277b;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ge;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class C0296u extends ad implements bu, C0047v {
    private C0267w f1432m;
    private int f1433n = 0;
    private boolean f1434o;
    private Resources f1435p;

    public Intent mo570a() {
        return bl.m1214a(this);
    }

    public C0277b mo139a(C0274c c0274c) {
        return null;
    }

    public void m3217a(bt btVar) {
        btVar.m1242a((Activity) this);
    }

    public void mo140a(C0277b c0277b) {
    }

    public void m3219a(Toolbar toolbar) {
        m3228j().mo486a(toolbar);
    }

    public boolean m3220a(Intent intent) {
        return bl.m1216a((Activity) this, intent);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m3228j().mo494b(view, layoutParams);
    }

    public void m3221b(Intent intent) {
        bl.m1219b((Activity) this, intent);
    }

    public void m3222b(bt btVar) {
    }

    public void mo141b(C0277b c0277b) {
    }

    public void mo571d() {
        m3228j().mo500e();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 19) {
            int action = keyEvent.getAction();
            if (action == 0) {
                if (C0235v.m2520a(keyEvent, 2)) {
                    C0266a g = m3225g();
                    if (g != null && g.mo533b() && g.mo540g()) {
                        this.f1434o = true;
                        return true;
                    }
                }
            } else if (action == 1 && this.f1434o) {
                this.f1434o = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public View findViewById(int i) {
        return m3228j().mo481a(i);
    }

    public C0266a m3225g() {
        return m3228j().mo474a();
    }

    public MenuInflater getMenuInflater() {
        return m3228j().mo476b();
    }

    public Resources getResources() {
        if (this.f1435p == null) {
            this.f1435p = new ge(this, super.getResources());
        }
        return this.f1435p;
    }

    public boolean m3226h() {
        Intent a = mo570a();
        if (a == null) {
            return false;
        }
        if (m3220a(a)) {
            bt a2 = bt.m1241a((Context) this);
            m3217a(a2);
            m3222b(a2);
            a2.m1245a();
            try {
                C0067a.m960a(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            m3221b(a);
        }
        return true;
    }

    @Deprecated
    public void m3227i() {
    }

    public void invalidateOptionsMenu() {
        m3228j().mo500e();
    }

    public C0267w m3228j() {
        if (this.f1432m == null) {
            this.f1432m = C0267w.m2852a((Activity) this, (C0047v) this);
        }
        return this.f1432m;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3228j().mo483a(configuration);
        if (this.f1435p != null) {
            this.f1435p.updateConfiguration(configuration, null);
        }
    }

    public void onContentChanged() {
        m3227i();
    }

    protected void onCreate(Bundle bundle) {
        C0267w j = m3228j();
        j.mo501g();
        j.mo484a(bundle);
        if (j.mo479h() && this.f1433n != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.f1433n, false);
            } else {
                setTheme(this.f1433n);
            }
        }
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        m3228j().mo478f();
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        C0266a g = m3225g();
        return (menuItem.getItemId() != 16908332 || g == null || (g.mo524a() & 4) == 0) ? false : m3226h();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m3228j().mo493b(bundle);
    }

    protected void onPostResume() {
        super.onPostResume();
        m3228j().mo499d();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m3228j().mo477c(bundle);
    }

    protected void onStop() {
        super.onStop();
        m3228j().mo497c();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m3228j().mo475a(charSequence);
    }

    public void setContentView(int i) {
        m3228j().mo492b(i);
    }

    public void setContentView(View view) {
        m3228j().mo487a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m3228j().mo488a(view, layoutParams);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.f1433n = i;
    }
}
