package com.dragonjic.cubes.events24.ui.adapter.detail;

import com.dragonjic.cubes.events24.data.model.Authors;
import com.dragonjic.cubes.events24.databinding.RvItemAboutCreatorBinding;
import com.dragonjic.cubes.events24.ui.adapter.EventDetailAdapter;
import com.squareup.picasso.Picasso;

public class RvItemDetailAboutCreator implements RecyclerViewItemDetail{

    public String image;
    public String text;


    public RvItemDetailAboutCreator(String image, String text) {
        this.image = image;
        this.text = text;
    }

    @Override
    public int getType() {
        return 4;
    }

    @Override
    public void bind(EventDetailAdapter.EventViewHolder holder) {
        RvItemAboutCreatorBinding binding = (RvItemAboutCreatorBinding) holder.binding;
        Picasso.get().load(image).into(binding.imageView);
        binding.textView.setText(text);
    }
}
