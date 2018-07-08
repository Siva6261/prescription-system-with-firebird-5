package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bp;
import android.support.v7.p018b.C0298b;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

public class aw extends EditText implements bp {
    private aq f1962a;
    private am f1963b;
    private bo f1964c;

    public aw(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0298b.editTextStyle);
    }

    public aw(Context context, AttributeSet attributeSet, int i) {
        super(gc.m4782a(context), attributeSet, i);
        this.f1962a = aq.m4079a();
        this.f1963b = new am(this, this.f1962a);
        this.f1963b.m4062a(attributeSet, i);
        this.f1964c = bo.m4174a((TextView) this);
        this.f1964c.mo709a(attributeSet, i);
        this.f1964c.mo708a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1963b != null) {
            this.f1963b.m4065c();
        }
        if (this.f1964c != null) {
            this.f1964c.mo708a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1963b != null ? this.f1963b.m4057a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1963b != null ? this.f1963b.m4063b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1963b != null) {
            this.f1963b.m4061a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1963b != null) {
            this.f1963b.m4058a(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1963b != null) {
            this.f1963b.m4059a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1963b != null) {
            this.f1963b.m4060a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1964c != null) {
            this.f1964c.m4177a(context, i);
        }
    }
}
