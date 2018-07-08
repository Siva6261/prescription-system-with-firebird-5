package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class bl implements OnItemClickListener {
    final /* synthetic */ bh f2045a;
    final /* synthetic */ bk f2046b;

    bl(bk bkVar, bh bhVar) {
        this.f2046b = bkVar;
        this.f2045a = bhVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f2046b.f2041a.setSelection(i);
        if (this.f2046b.f2041a.getOnItemClickListener() != null) {
            this.f2046b.f2041a.performItemClick(view, i, this.f2046b.f2043d.getItemId(i));
        }
        this.f2046b.m4160i();
    }
}
