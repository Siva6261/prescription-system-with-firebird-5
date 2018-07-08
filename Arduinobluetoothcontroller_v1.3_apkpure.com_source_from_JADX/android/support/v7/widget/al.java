package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bp;
import android.support.v7.p018b.C0298b;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class al extends AutoCompleteTextView implements bp {
    private static final int[] f1791a = new int[]{16843126};
    private aq f1792b;
    private am f1793c;
    private bo f1794d;

    public al(Context context) {
        this(context, null);
    }

    public al(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0298b.autoCompleteTextViewStyle);
    }

    public al(Context context, AttributeSet attributeSet, int i) {
        super(gc.m4782a(context), attributeSet, i);
        this.f1792b = aq.m4079a();
        gf a = gf.m4787a(getContext(), attributeSet, f1791a, i, 0);
        if (a.m4802f(0)) {
            setDropDownBackgroundDrawable(a.m4790a(0));
        }
        a.m4791a();
        this.f1793c = new am(this, this.f1792b);
        this.f1793c.m4062a(attributeSet, i);
        this.f1794d = bo.m4174a((TextView) this);
        this.f1794d.mo709a(attributeSet, i);
        this.f1794d.mo708a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1793c != null) {
            this.f1793c.m4065c();
        }
        if (this.f1794d != null) {
            this.f1794d.mo708a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1793c != null ? this.f1793c.m4057a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1793c != null ? this.f1793c.m4063b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1793c != null) {
            this.f1793c.m4061a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1793c != null) {
            this.f1793c.m4058a(i);
        }
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f1792b != null) {
            setDropDownBackgroundDrawable(this.f1792b.m4100a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1793c != null) {
            this.f1793c.m4059a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1793c != null) {
            this.f1793c.m4060a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1794d != null) {
            this.f1794d.m4177a(context, i);
        }
    }
}
