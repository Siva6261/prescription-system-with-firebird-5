package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p012e.p013a.C0134b;
import android.support.v4.view.C0227n;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

@TargetApi(14)
public class C0339o extends C0328e implements MenuItem {
    private Method f1637c;

    C0339o(Context context, C0134b c0134b) {
        super(context, c0134b);
    }

    C0340p mo624a(ActionProvider actionProvider) {
        return new C0340p(this, this.a, actionProvider);
    }

    public void m3481a(boolean z) {
        try {
            if (this.f1637c == null) {
                this.f1637c = ((C0134b) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f1637c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    public boolean collapseActionView() {
        return ((C0134b) this.b).collapseActionView();
    }

    public boolean expandActionView() {
        return ((C0134b) this.b).expandActionView();
    }

    public ActionProvider getActionProvider() {
        C0227n a = ((C0134b) this.b).mo588a();
        return a instanceof C0340p ? ((C0340p) a).f1638a : null;
    }

    public View getActionView() {
        View actionView = ((C0134b) this.b).getActionView();
        return actionView instanceof C0341q ? ((C0341q) actionView).m3488c() : actionView;
    }

    public char getAlphabeticShortcut() {
        return ((C0134b) this.b).getAlphabeticShortcut();
    }

    public int getGroupId() {
        return ((C0134b) this.b).getGroupId();
    }

    public Drawable getIcon() {
        return ((C0134b) this.b).getIcon();
    }

    public Intent getIntent() {
        return ((C0134b) this.b).getIntent();
    }

    public int getItemId() {
        return ((C0134b) this.b).getItemId();
    }

    public ContextMenuInfo getMenuInfo() {
        return ((C0134b) this.b).getMenuInfo();
    }

    public char getNumericShortcut() {
        return ((C0134b) this.b).getNumericShortcut();
    }

    public int getOrder() {
        return ((C0134b) this.b).getOrder();
    }

    public SubMenu getSubMenu() {
        return m3328a(((C0134b) this.b).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((C0134b) this.b).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((C0134b) this.b).getTitleCondensed();
    }

    public boolean hasSubMenu() {
        return ((C0134b) this.b).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((C0134b) this.b).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((C0134b) this.b).isCheckable();
    }

    public boolean isChecked() {
        return ((C0134b) this.b).isChecked();
    }

    public boolean isEnabled() {
        return ((C0134b) this.b).isEnabled();
    }

    public boolean isVisible() {
        return ((C0134b) this.b).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((C0134b) this.b).mo587a(actionProvider != null ? mo624a(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((C0134b) this.b).setActionView(i);
        View actionView = ((C0134b) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((C0134b) this.b).setActionView(new C0341q(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0341q(view);
        }
        ((C0134b) this.b).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((C0134b) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((C0134b) this.b).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((C0134b) this.b).setChecked(z);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((C0134b) this.b).setEnabled(z);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((C0134b) this.b).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((C0134b) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((C0134b) this.b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((C0134b) this.b).setNumericShortcut(c);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((C0134b) this.b).mo586a(onActionExpandListener != null ? new C0342r(this, onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((C0134b) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0343s(this, onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        ((C0134b) this.b).setShortcut(c, c2);
        return this;
    }

    public void setShowAsAction(int i) {
        ((C0134b) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((C0134b) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((C0134b) this.b).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((C0134b) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((C0134b) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((C0134b) this.b).setVisible(z);
    }
}
