package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p018b.C0298b;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar extends SeekBar {
    private bg f1755a;
    private aq f1756b;

    public AppCompatSeekBar(Context context) {
        this(context, null);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0298b.seekBarStyle);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1756b = aq.m4079a();
        this.f1755a = new bg(this, this.f1756b);
        this.f1755a.mo703a(attributeSet, i);
    }
}
