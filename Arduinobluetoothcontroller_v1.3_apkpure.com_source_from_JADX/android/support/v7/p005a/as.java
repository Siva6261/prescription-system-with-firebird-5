package android.support.v7.p005a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.p018b.C0298b;
import android.support.v7.view.C0274c;
import android.support.v7.view.C0277b;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class as extends Dialog implements C0047v {
    private C0267w f468a;

    public as(Context context, int i) {
        super(context, as.m798a(context, i));
        m799a().mo484a(null);
        m799a().mo479h();
    }

    private static int m798a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0298b.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public C0267w m799a() {
        if (this.f468a == null) {
            this.f468a = C0267w.m2853a((Dialog) this, (C0047v) this);
        }
        return this.f468a;
    }

    public C0277b mo139a(C0274c c0274c) {
        return null;
    }

    public void mo140a(C0277b c0277b) {
    }

    public boolean m802a(int i) {
        return m799a().mo498c(i);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m799a().mo494b(view, layoutParams);
    }

    public void mo141b(C0277b c0277b) {
    }

    public View findViewById(int i) {
        return m799a().mo481a(i);
    }

    public void invalidateOptionsMenu() {
        m799a().mo500e();
    }

    protected void onCreate(Bundle bundle) {
        m799a().mo501g();
        super.onCreate(bundle);
        m799a().mo484a(bundle);
    }

    protected void onStop() {
        super.onStop();
        m799a().mo497c();
    }

    public void setContentView(int i) {
        m799a().mo492b(i);
    }

    public void setContentView(View view) {
        m799a().mo487a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m799a().mo488a(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        m799a().mo475a(getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m799a().mo475a(charSequence);
    }
}
