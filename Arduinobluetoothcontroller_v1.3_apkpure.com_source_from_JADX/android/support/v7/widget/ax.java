package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bp;
import android.support.v7.p018b.C0298b;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class ax extends ImageButton implements bp {
    private am f1965a;
    private ay f1966b;

    public ax(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0298b.imageButtonStyle);
    }

    public ax(Context context, AttributeSet attributeSet, int i) {
        super(gc.m4782a(context), attributeSet, i);
        aq a = aq.m4079a();
        this.f1965a = new am(this, a);
        this.f1965a.m4062a(attributeSet, i);
        this.f1966b = new ay(this, a);
        this.f1966b.m4111a(attributeSet, i);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1965a != null) {
            this.f1965a.m4065c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1965a != null ? this.f1965a.m4057a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1965a != null ? this.f1965a.m4063b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1965a != null) {
            this.f1965a.m4061a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1965a != null) {
            this.f1965a.m4058a(i);
        }
    }

    public void setImageResource(int i) {
        this.f1966b.m4110a(i);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1965a != null) {
            this.f1965a.m4059a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1965a != null) {
            this.f1965a.m4060a(mode);
        }
    }
}
