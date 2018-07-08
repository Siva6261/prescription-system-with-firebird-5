package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bv;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

class bk extends cx {
    final /* synthetic */ bh f2041a;
    private CharSequence f2042c;
    private ListAdapter f2043d;
    private final Rect f2044e = new Rect();

    public bk(bh bhVar, Context context, AttributeSet attributeSet, int i) {
        this.f2041a = bhVar;
        super(context, attributeSet, i);
        m4142a((View) bhVar);
        m4146a(true);
        m4140a(0);
        m4143a(new bl(this, bhVar));
    }

    private boolean m4168b(View view) {
        return bv.m1996C(view) && view.getGlobalVisibleRect(this.f2044e);
    }

    public CharSequence mo704a() {
        return this.f2042c;
    }

    public void mo705a(ListAdapter listAdapter) {
        super.mo705a(listAdapter);
        this.f2043d = listAdapter;
    }

    public void m4171a(CharSequence charSequence) {
        this.f2042c = charSequence;
    }

    void mo706b() {
        int i;
        Drawable d = m4150d();
        if (d != null) {
            d.getPadding(this.f2041a.f2004l);
            i = gv.m4891a(this.f2041a) ? this.f2041a.f2004l.right : -this.f2041a.f2004l.left;
        } else {
            Rect b = this.f2041a.f2004l;
            this.f2041a.f2004l.right = 0;
            b.left = 0;
            i = 0;
        }
        int paddingLeft = this.f2041a.getPaddingLeft();
        int paddingRight = this.f2041a.getPaddingRight();
        int width = this.f2041a.getWidth();
        if (this.f2041a.f2003k == -2) {
            int a = this.f2041a.m4125a((SpinnerAdapter) this.f2043d, m4150d());
            int i2 = (this.f2041a.getContext().getResources().getDisplayMetrics().widthPixels - this.f2041a.f2004l.left) - this.f2041a.f2004l.right;
            if (a <= i2) {
                i2 = a;
            }
            m4155f(Math.max(i2, (width - paddingLeft) - paddingRight));
        } else if (this.f2041a.f2003k == -1) {
            m4155f((width - paddingLeft) - paddingRight);
        } else {
            m4155f(this.f2041a.f2003k);
        }
        m4147b(gv.m4891a(this.f2041a) ? ((width - paddingRight) - m4158h()) + i : i + paddingLeft);
    }

    public void mo707c() {
        boolean k = m4162k();
        mo706b();
        m4157g(2);
        super.mo707c();
        m4164m().setChoiceMode(1);
        m4159h(this.f2041a.getSelectedItemPosition());
        if (!k) {
            ViewTreeObserver viewTreeObserver = this.f2041a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                OnGlobalLayoutListener bmVar = new bm(this);
                viewTreeObserver.addOnGlobalLayoutListener(bmVar);
                m4145a(new bn(this, bmVar));
            }
        }
    }
}
