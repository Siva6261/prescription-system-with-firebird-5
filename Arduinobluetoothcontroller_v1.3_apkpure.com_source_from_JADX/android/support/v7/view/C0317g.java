package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.p012e.p013a.C0133a;
import android.support.v7.view.menu.ab;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

@TargetApi(11)
public class C0317g extends ActionMode {
    final Context f1448a;
    final C0277b f1449b;

    public C0317g(Context context, C0277b c0277b) {
        this.f1448a = context;
        this.f1449b = c0277b;
    }

    public void finish() {
        this.f1449b.mo562c();
    }

    public View getCustomView() {
        return this.f1449b.mo567i();
    }

    public Menu getMenu() {
        return ab.m3324a(this.f1448a, (C0133a) this.f1449b.mo559b());
    }

    public MenuInflater getMenuInflater() {
        return this.f1449b.mo554a();
    }

    public CharSequence getSubtitle() {
        return this.f1449b.mo565g();
    }

    public Object getTag() {
        return this.f1449b.m3136j();
    }

    public CharSequence getTitle() {
        return this.f1449b.mo564f();
    }

    public boolean getTitleOptionalHint() {
        return this.f1449b.m3137k();
    }

    public void invalidate() {
        this.f1449b.mo563d();
    }

    public boolean isTitleOptional() {
        return this.f1449b.mo566h();
    }

    public void setCustomView(View view) {
        this.f1449b.mo556a(view);
    }

    public void setSubtitle(int i) {
        this.f1449b.mo560b(i);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1449b.mo557a(charSequence);
    }

    public void setTag(Object obj) {
        this.f1449b.m3125a(obj);
    }

    public void setTitle(int i) {
        this.f1449b.mo555a(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1449b.mo561b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f1449b.mo558a(z);
    }
}
