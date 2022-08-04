package com.dragonjic.cubes.events24.ui.adapter.detail;

import android.util.Log;
import android.view.View;

import com.dragonjic.cubes.events24.R;
import com.dragonjic.cubes.events24.data.database.AppDatabase;
import com.dragonjic.cubes.events24.data.model.Event;
import com.dragonjic.cubes.events24.databinding.RvItemConcertBinding;
import com.dragonjic.cubes.events24.ui.adapter.EventDetailAdapter;
import com.dragonjic.cubes.events24.ui.view.EventsMessage;
import com.squareup.picasso.Picasso;

public class RvItemDetailHeader implements RecyclerViewItemDetail{

    private Event event;

    public RvItemDetailHeader(Event event) {
        this.event = event;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public void bind(EventDetailAdapter.EventViewHolder holder) {

        RvItemConcertBinding binding = (RvItemConcertBinding) holder.binding;
        binding.textConcert.setText(event.type);
        binding.textViewDate.setText(event.date);
        binding.textViewTitle.setText(event.title);
        binding.textViewLocation.setText(event.location);
        Picasso.get().load(event.imageBig).into(binding.imageView);

        Event favEvent = AppDatabase.getInstance(binding.getRoot().getContext()).eventDao().getEvent(event.id);

        if(favEvent!=null){
            binding.buttonFavorite.setImageResource(R.drawable.ic_favorite_fil);
        }
        else{
            binding.buttonFavorite.setImageResource(R.drawable.ic_favorite);
        }
        binding.buttonFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(favEvent!=null){
                    AppDatabase.getInstance(view.getContext()).eventDao().delete(event);
                    binding.buttonFavorite.setImageResource(R.drawable.ic_favorite);
                    EventsMessage.showMessage(view.getContext(),"Removed event from favorite");
                }
                else {
                    AppDatabase.getInstance(view.getContext()).eventDao().insert(event);
                    binding.buttonFavorite.setImageResource(R.drawable.ic_favorite_fil);
                    EventsMessage.showMessage(view.getContext(),"Add event to favorite");
                }
            }
        });

    }
}
