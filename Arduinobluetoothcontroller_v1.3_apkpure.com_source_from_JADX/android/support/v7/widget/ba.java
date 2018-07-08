package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bp;
import android.support.v7.p018b.C0298b;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class ba extends MultiAutoCompleteTextView implements bp {
    private static final int[] f1974a = new int[]{16843126};
    private aq f1975b;
    private am f1976c;
    private bo f1977d;

    public ba(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0298b.autoCompleteTextViewStyle);
    }

    public ba(Context context, AttributeSet attributeSet, int i) {
        super(gc.m4782a(context), attributeSet, i);
        this.f1975b = aq.m4079a();
        gf a = gf.m4787a(getContext(), attributeSet, f1974a, i, 0);
        if (a.m4802f(0)) {
            setDropDownBackgroundDrawable(a.m4790a(0));
        }
        a.m4791a();
        this.f1976c = new am(this, this.f1975b);
        this.f1976c.m4062a(attributeSet, i);
        this.f1977d = bo.m4174a((TextView) this);
        this.f1977d.mo709a(attributeSet, i);
        this.f1977d.mo708a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1976c != null) {
            this.f1976c.m4065c();
        }
        if (this.f1977d != null) {
            this.f1977d.mo708a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1976c != null ? this.f1976c.m4057a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1976c != null ? this.f1976c.m4063b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1976c != null) {
            this.f1976c.m4061a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1976c != null) {
            this.f1976c.m4058a(i);
        }
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f1975b != null) {
            setDropDownBackgroundDrawable(this.f1975b.m4100a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1976c != null) {
            this.f1976c.m4059a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1976c != null) {
            this.f1976c.m4060a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1977d != null) {
            this.f1977d.m4177a(context, i);
        }
    }
}
