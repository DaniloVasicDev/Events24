package com.dragonjic.cubes.events24.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.dragonjic.cubes.events24.R;
import com.dragonjic.cubes.events24.data.model.Authors;
import com.dragonjic.cubes.events24.data.model.Event;
import com.dragonjic.cubes.events24.data.model.Media;
import com.dragonjic.cubes.events24.data.model.Ticket;
import com.dragonjic.cubes.events24.databinding.RvItemAboutCreatorBinding;
import com.dragonjic.cubes.events24.databinding.RvItemConcertBinding;
import com.dragonjic.cubes.events24.databinding.RvItemHorizontalDetailMediaRvBinding;
import com.dragonjic.cubes.events24.databinding.RvItemTextViewRvBinding;
import com.dragonjic.cubes.events24.databinding.RvItemTicketDetalBinding;
import com.dragonjic.cubes.events24.ui.adapter.detail.RecyclerViewItemDetail;
import com.dragonjic.cubes.events24.ui.adapter.detail.RvItemDetailAboutCreator;
import com.dragonjic.cubes.events24.ui.adapter.detail.RvItemDetailHeader;
import com.dragonjic.cubes.events24.ui.adapter.detail.RvItemDetailTicket;
import com.dragonjic.cubes.events24.ui.adapter.detail.RvItemDetailTitle;
import com.dragonjic.cubes.events24.ui.adapter.detail.RvItemDetalMedia;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EventDetailAdapter extends RecyclerView.Adapter<EventDetailAdapter.EventViewHolder> {
    private Event event;
    private ArrayList<RecyclerViewItemDetail> items;


    public EventDetailAdapter(Event event) {
        this.event = event;
        this.items = new ArrayList<>();

        RvItemDetailHeader header = new RvItemDetailHeader(this.event);
        this.items.add(header);

        if(this.event.tickets.size() >0){

            RvItemDetailTitle title = new RvItemDetailTitle("Ulaznice");
            this.items.add(title);

            for(Ticket ticket:this.event.tickets){
                this.items.add(new RvItemDetailTicket(ticket));
            }
        }

        if(this.event.medias.size()>0){
            this.items.add(new RvItemDetailTitle("Slike i video"));
                this.items.add(new RvItemDetalMedia(this.event.medias));

        }

        if(this.event.author!=null){
            this.items.add(new RvItemDetailTitle("O izvodjacu"));
            this.items.add(new RvItemDetailAboutCreator(this.event.imageBig,this.event.author));
        }

    }

    @NonNull
    @Override
    public EventDetailAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      ViewBinding binding;

      LayoutInflater inflater = LayoutInflater.from(parent.getContext());

      switch (viewType){
          case 0:
              binding = RvItemConcertBinding.inflate(inflater,parent,false);
              break;
          case 2:
              binding = RvItemTicketDetalBinding.inflate(inflater,parent,false);
              break;
          case 3:
              binding = RvItemHorizontalDetailMediaRvBinding.inflate(inflater,parent,false);
              break;
          case 4:
              binding = RvItemAboutCreatorBinding.inflate(inflater,parent,false);
              break;
          default:
              binding = RvItemTextViewRvBinding.inflate(inflater,parent,false);
      }

      return new EventViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EventDetailAdapter.EventViewHolder holder, int position) {
        this.items.get(position).bind(holder);
    }

    @Override
    public int getItemCount() {
        return this.items.size();

    }

    @Override
    public int getItemViewType(int position) {
      return this.items.get(position).getType();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {

        public ViewBinding binding;

        public EventViewHolder(ViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
