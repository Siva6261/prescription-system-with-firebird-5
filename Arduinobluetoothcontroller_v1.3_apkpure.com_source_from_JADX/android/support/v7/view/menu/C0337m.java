package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p012e.p013a.C0134b;
import android.support.v4.view.C0227n;
import android.support.v4.view.aw;
import android.support.v7.widget.aq;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class C0337m implements C0134b {
    private static String f1610w;
    private static String f1611x;
    private static String f1612y;
    private static String f1613z;
    private final int f1614a;
    private final int f1615b;
    private final int f1616c;
    private final int f1617d;
    private CharSequence f1618e;
    private CharSequence f1619f;
    private Intent f1620g;
    private char f1621h;
    private char f1622i;
    private Drawable f1623j;
    private int f1624k = 0;
    private C0329i f1625l;
    private ad f1626m;
    private Runnable f1627n;
    private OnMenuItemClickListener f1628o;
    private int f1629p = 16;
    private int f1630q = 0;
    private View f1631r;
    private C0227n f1632s;
    private aw f1633t;
    private boolean f1634u = false;
    private ContextMenuInfo f1635v;

    C0337m(C0329i c0329i, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1625l = c0329i;
        this.f1614a = i2;
        this.f1615b = i;
        this.f1616c = i3;
        this.f1617d = i4;
        this.f1618e = charSequence;
        this.f1630q = i5;
    }

    public C0134b m3452a(int i) {
        Context e = this.f1625l.m3371e();
        m3455a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public C0134b mo586a(aw awVar) {
        this.f1633t = awVar;
        return this;
    }

    public C0134b mo587a(C0227n c0227n) {
        if (this.f1632s != null) {
            this.f1632s.m2506f();
        }
        this.f1631r = null;
        this.f1632s = c0227n;
        this.f1625l.m3363b(true);
        if (this.f1632s != null) {
            this.f1632s.mo626a(new C0338n(this));
        }
        return this;
    }

    public C0134b m3455a(View view) {
        this.f1631r = view;
        this.f1632s = null;
        if (view != null && view.getId() == -1 && this.f1614a > 0) {
            view.setId(this.f1614a);
        }
        this.f1625l.m3361b(this);
        return this;
    }

    public C0227n mo588a() {
        return this.f1632s;
    }

    CharSequence m3457a(aa aaVar) {
        return (aaVar == null || !aaVar.mo25a()) ? getTitle() : getTitleCondensed();
    }

    public void m3458a(ad adVar) {
        this.f1626m = adVar;
        adVar.setHeaderTitle(getTitle());
    }

    void m3459a(ContextMenuInfo contextMenuInfo) {
        this.f1635v = contextMenuInfo;
    }

    public void m3460a(boolean z) {
        this.f1629p = (z ? 4 : 0) | (this.f1629p & -5);
    }

    public C0134b m3461b(int i) {
        setShowAsAction(i);
        return this;
    }

    void m3462b(boolean z) {
        int i = this.f1629p;
        this.f1629p = (z ? 2 : 0) | (this.f1629p & -3);
        if (i != this.f1629p) {
            this.f1625l.m3363b(false);
        }
    }

    public boolean m3463b() {
        if ((this.f1628o != null && this.f1628o.onMenuItemClick(this)) || this.f1625l.mo599a(this.f1625l.mo604p(), (MenuItem) this)) {
            return true;
        }
        if (this.f1627n != null) {
            this.f1627n.run();
            return true;
        }
        if (this.f1620g != null) {
            try {
                this.f1625l.m3371e().startActivity(this.f1620g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.f1632s != null && this.f1632s.mo618d();
    }

    public int m3464c() {
        return this.f1617d;
    }

    boolean m3465c(boolean z) {
        int i = this.f1629p;
        this.f1629p = (z ? 0 : 8) | (this.f1629p & -9);
        return i != this.f1629p;
    }

    public boolean collapseActionView() {
        return (this.f1630q & 8) == 0 ? false : this.f1631r == null ? true : (this.f1633t == null || this.f1633t.mo623b(this)) ? this.f1625l.mo603d(this) : false;
    }

    char m3466d() {
        return this.f1625l.mo600b() ? this.f1622i : this.f1621h;
    }

    public void m3467d(boolean z) {
        if (z) {
            this.f1629p |= 32;
        } else {
            this.f1629p &= -33;
        }
    }

    String m3468e() {
        char d = m3466d();
        if (d == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(f1610w);
        switch (d) {
            case '\b':
                stringBuilder.append(f1612y);
                break;
            case '\n':
                stringBuilder.append(f1611x);
                break;
            case ' ':
                stringBuilder.append(f1613z);
                break;
            default:
                stringBuilder.append(d);
                break;
        }
        return stringBuilder.toString();
    }

    public void m3469e(boolean z) {
        this.f1634u = z;
        this.f1625l.m3363b(false);
    }

    public boolean expandActionView() {
        return !m3478n() ? false : (this.f1633t == null || this.f1633t.mo622a(this)) ? this.f1625l.mo602c(this) : false;
    }

    boolean m3470f() {
        return this.f1625l.mo601c() && m3466d() != '\u0000';
    }

    public boolean m3471g() {
        return (this.f1629p & 4) != 0;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        if (this.f1631r != null) {
            return this.f1631r;
        }
        if (this.f1632s == null) {
            return null;
        }
        this.f1631r = this.f1632s.mo625a((MenuItem) this);
        return this.f1631r;
    }

    public char getAlphabeticShortcut() {
        return this.f1622i;
    }

    public int getGroupId() {
        return this.f1615b;
    }

    public Drawable getIcon() {
        if (this.f1623j != null) {
            return this.f1623j;
        }
        if (this.f1624k == 0) {
            return null;
        }
        Drawable a = aq.m4079a().m4100a(this.f1625l.m3371e(), this.f1624k);
        this.f1624k = 0;
        this.f1623j = a;
        return a;
    }

    public Intent getIntent() {
        return this.f1620g;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f1614a;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f1635v;
    }

    public char getNumericShortcut() {
        return this.f1621h;
    }

    public int getOrder() {
        return this.f1616c;
    }

    public SubMenu getSubMenu() {
        return this.f1626m;
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1618e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1619f != null ? this.f1619f : this.f1618e;
        return (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public void m3472h() {
        this.f1625l.m3361b(this);
    }

    public boolean hasSubMenu() {
        return this.f1626m != null;
    }

    public boolean m3473i() {
        return this.f1625l.m3383q();
    }

    public boolean isActionViewExpanded() {
        return this.f1634u;
    }

    public boolean isCheckable() {
        return (this.f1629p & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f1629p & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f1629p & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1632s == null || !this.f1632s.mo627b()) ? (this.f1629p & 8) == 0 : (this.f1629p & 8) == 0 && this.f1632s.mo628c();
    }

    public boolean m3474j() {
        return (this.f1629p & 32) == 32;
    }

    public boolean m3475k() {
        return (this.f1630q & 1) == 1;
    }

    public boolean m3476l() {
        return (this.f1630q & 2) == 2;
    }

    public boolean m3477m() {
        return (this.f1630q & 4) == 4;
    }

    public boolean m3478n() {
        if ((this.f1630q & 8) == 0) {
            return false;
        }
        if (this.f1631r == null && this.f1632s != null) {
            this.f1631r = this.f1632s.mo625a((MenuItem) this);
        }
        return this.f1631r != null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m3452a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m3455a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f1622i != c) {
            this.f1622i = Character.toLowerCase(c);
            this.f1625l.m3363b(false);
        }
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f1629p;
        this.f1629p = (z ? 1 : 0) | (this.f1629p & -2);
        if (i != this.f1629p) {
            this.f1625l.m3363b(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f1629p & 4) != 0) {
            this.f1625l.m3353a((MenuItem) this);
        } else {
            m3462b(z);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1629p |= 16;
        } else {
            this.f1629p &= -17;
        }
        this.f1625l.m3363b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1623j = null;
        this.f1624k = i;
        this.f1625l.m3363b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1624k = 0;
        this.f1623j = drawable;
        this.f1625l.m3363b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1620g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f1621h != c) {
            this.f1621h = c;
            this.f1625l.m3363b(false);
        }
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1628o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1621h = c;
        this.f1622i = Character.toLowerCase(c2);
        this.f1625l.m3363b(false);
        return this;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f1630q = i;
                this.f1625l.m3361b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m3461b(i);
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f1625l.m3371e().getString(i));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1618e = charSequence;
        this.f1625l.m3363b(false);
        if (this.f1626m != null) {
            this.f1626m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1619f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f1618e;
        }
        this.f1625l.m3363b(false);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        if (m3465c(z)) {
            this.f1625l.m3350a(this);
        }
        return this;
    }

    public String toString() {
        return this.f1618e != null ? this.f1618e.toString() : null;
    }
}
