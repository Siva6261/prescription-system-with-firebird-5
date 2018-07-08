package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p018b.C0303g;
import android.support.v7.p018b.C0305i;
import android.support.v7.p018b.C0308l;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements aa {
    private C0337m f1515a;
    private ImageView f1516b;
    private RadioButton f1517c;
    private TextView f1518d;
    private CheckBox f1519e;
    private TextView f1520f;
    private Drawable f1521g;
    private int f1522h;
    private Context f1523i;
    private boolean f1524j;
    private int f1525k;
    private Context f1526l;
    private LayoutInflater f1527m;
    private boolean f1528n;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f1526l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0308l.MenuView, i, 0);
        this.f1521g = obtainStyledAttributes.getDrawable(C0308l.MenuView_android_itemBackground);
        this.f1522h = obtainStyledAttributes.getResourceId(C0308l.MenuView_android_itemTextAppearance, -1);
        this.f1524j = obtainStyledAttributes.getBoolean(C0308l.MenuView_preserveIconSpacing, false);
        this.f1523i = context;
        obtainStyledAttributes.recycle();
    }

    private void m3312b() {
        this.f1516b = (ImageView) getInflater().inflate(C0305i.abc_list_menu_item_icon, this, false);
        addView(this.f1516b, 0);
    }

    private void m3313c() {
        this.f1517c = (RadioButton) getInflater().inflate(C0305i.abc_list_menu_item_radio, this, false);
        addView(this.f1517c);
    }

    private void m3314d() {
        this.f1519e = (CheckBox) getInflater().inflate(C0305i.abc_list_menu_item_checkbox, this, false);
        addView(this.f1519e);
    }

    private LayoutInflater getInflater() {
        if (this.f1527m == null) {
            this.f1527m = LayoutInflater.from(this.f1526l);
        }
        return this.f1527m;
    }

    public void mo24a(C0337m c0337m, int i) {
        this.f1515a = c0337m;
        this.f1525k = i;
        setVisibility(c0337m.isVisible() ? 0 : 8);
        setTitle(c0337m.m3457a((aa) this));
        setCheckable(c0337m.isCheckable());
        m3316a(c0337m.m3470f(), c0337m.m3466d());
        setIcon(c0337m.getIcon());
        setEnabled(c0337m.isEnabled());
    }

    public void m3316a(boolean z, char c) {
        int i = (z && this.f1515a.m3470f()) ? 0 : 8;
        if (i == 0) {
            this.f1520f.setText(this.f1515a.m3468e());
        }
        if (this.f1520f.getVisibility() != i) {
            this.f1520f.setVisibility(i);
        }
    }

    public boolean mo25a() {
        return false;
    }

    public C0337m getItemData() {
        return this.f1515a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f1521g);
        this.f1518d = (TextView) findViewById(C0303g.title);
        if (this.f1522h != -1) {
            this.f1518d.setTextAppearance(this.f1523i, this.f1522h);
        }
        this.f1520f = (TextView) findViewById(C0303g.shortcut);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1516b != null && this.f1524j) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1516b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        if (z || this.f1517c != null || this.f1519e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f1515a.m3471g()) {
                if (this.f1517c == null) {
                    m3313c();
                }
                compoundButton = this.f1517c;
                compoundButton2 = this.f1519e;
            } else {
                if (this.f1519e == null) {
                    m3314d();
                }
                compoundButton = this.f1519e;
                compoundButton2 = this.f1517c;
            }
            if (z) {
                compoundButton.setChecked(this.f1515a.isChecked());
                int i = z ? 0 : 8;
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f1519e != null) {
                this.f1519e.setVisibility(8);
            }
            if (this.f1517c != null) {
                this.f1517c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1515a.m3471g()) {
            if (this.f1517c == null) {
                m3313c();
            }
            compoundButton = this.f1517c;
        } else {
            if (this.f1519e == null) {
                m3314d();
            }
            compoundButton = this.f1519e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f1528n = z;
        this.f1524j = z;
    }

    public void setIcon(Drawable drawable) {
        int i = (this.f1515a.m3473i() || this.f1528n) ? 1 : 0;
        if (i == 0 && !this.f1524j) {
            return;
        }
        if (this.f1516b != null || drawable != null || this.f1524j) {
            if (this.f1516b == null) {
                m3312b();
            }
            if (drawable != null || this.f1524j) {
                ImageView imageView = this.f1516b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f1516b.getVisibility() != 0) {
                    this.f1516b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f1516b.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1518d.setText(charSequence);
            if (this.f1518d.getVisibility() != 0) {
                this.f1518d.setVisibility(0);
            }
        } else if (this.f1518d.getVisibility() != 8) {
            this.f1518d.setVisibility(8);
        }
    }
}
