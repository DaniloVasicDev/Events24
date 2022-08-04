package com.dragonjic.cubes.events24.ui.adapter.detail;

import com.dragonjic.cubes.events24.ui.adapter.EventDetailAdapter;

public interface RecyclerViewItemDetail {

    int getType();
    void bind(EventDetailAdapter.EventViewHolder holder);

}
