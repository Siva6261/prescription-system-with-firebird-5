package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bp;
import android.support.v7.p018b.C0298b;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

public class AppCompatButton extends Button implements bp {
    private final aq f1752a;
    private final am f1753b;
    private final bo f1754c;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0298b.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(gc.m4782a(context), attributeSet, i);
        this.f1752a = aq.m4079a();
        this.f1753b = new am(this, this.f1752a);
        this.f1753b.m4062a(attributeSet, i);
        this.f1754c = bo.m4174a((TextView) this);
        this.f1754c.mo709a(attributeSet, i);
        this.f1754c.mo708a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1753b != null) {
            this.f1753b.m4065c();
        }
        if (this.f1754c != null) {
            this.f1754c.mo708a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1753b != null ? this.f1753b.m4057a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1753b != null ? this.f1753b.m4063b() : null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1753b != null) {
            this.f1753b.m4061a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1753b != null) {
            this.f1753b.m4058a(i);
        }
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f1754c != null) {
            this.f1754c.m4180a(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1753b != null) {
            this.f1753b.m4059a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1753b != null) {
            this.f1753b.m4060a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1754c != null) {
            this.f1754c.m4177a(context, i);
        }
    }
}
