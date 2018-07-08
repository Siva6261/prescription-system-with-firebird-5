package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p008c.C0066a;
import android.support.v4.p012e.p013a.C0134b;
import android.support.v4.view.C0227n;
import android.support.v4.view.aw;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public class C0326a implements C0134b {
    private final int f1529a;
    private final int f1530b;
    private final int f1531c;
    private final int f1532d;
    private CharSequence f1533e;
    private CharSequence f1534f;
    private Intent f1535g;
    private char f1536h;
    private char f1537i;
    private Drawable f1538j;
    private int f1539k = 0;
    private Context f1540l;
    private OnMenuItemClickListener f1541m;
    private int f1542n = 16;

    public C0326a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f1540l = context;
        this.f1529a = i2;
        this.f1530b = i;
        this.f1531c = i3;
        this.f1532d = i4;
        this.f1533e = charSequence;
    }

    public C0134b m3318a(int i) {
        throw new UnsupportedOperationException();
    }

    public C0134b mo586a(aw awVar) {
        return this;
    }

    public C0134b mo587a(C0227n c0227n) {
        throw new UnsupportedOperationException();
    }

    public C0134b m3321a(View view) {
        throw new UnsupportedOperationException();
    }

    public C0227n mo588a() {
        return null;
    }

    public C0134b m3323b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public char getAlphabeticShortcut() {
        return this.f1537i;
    }

    public int getGroupId() {
        return this.f1530b;
    }

    public Drawable getIcon() {
        return this.f1538j;
    }

    public Intent getIntent() {
        return this.f1535g;
    }

    public int getItemId() {
        return this.f1529a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f1536h;
    }

    public int getOrder() {
        return this.f1532d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f1533e;
    }

    public CharSequence getTitleCondensed() {
        return this.f1534f != null ? this.f1534f : this.f1533e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f1542n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f1542n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f1542n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1542n & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m3318a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m3321a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f1537i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f1542n = (z ? 1 : 0) | (this.f1542n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f1542n = (z ? 2 : 0) | (this.f1542n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f1542n = (z ? 16 : 0) | (this.f1542n & -17);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1539k = i;
        this.f1538j = C0066a.m958a(this.f1540l, i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1538j = drawable;
        this.f1539k = 0;
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1535g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f1536h = c;
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1541m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1536h = c;
        this.f1537i = c2;
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m3323b(i);
    }

    public MenuItem setTitle(int i) {
        this.f1533e = this.f1540l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1533e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1534f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f1542n = (z ? 0 : 8) | (this.f1542n & 8);
        return this;
    }
}
