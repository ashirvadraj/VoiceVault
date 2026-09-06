package com.voicevault.app.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.voicevault.app.R;
import com.voicevault.app.model.Speaker;
import com.voicevault.app.model.Speech;

import java.util.ArrayList;
import java.util.List;

public class SpeechListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_SPEAKER = 0;
    private static final int TYPE_SPEECH = 1;

    private List<Object> items;
    private Context context;
    private OnSpeechClickListener speechClickListener;
    private OnSpeakerClickListener speakerClickListener;

    public interface OnSpeechClickListener {
        void onSpeechClick(Speech speech);
    }

    public interface OnSpeakerClickListener {
        void onSpeakerClick(Speaker speaker, int position);
    }

    public SpeechListAdapter(Context context, List<Object> items) {
        this.context = context;
        this.items = items != null ? items : new ArrayList<>();
    }

    public void setOnSpeechClickListener(OnSpeechClickListener listener) {
        this.speechClickListener = listener;
    }

    public void setOnSpeakerClickListener(OnSpeakerClickListener listener) {
        this.speakerClickListener = listener;
    }

    public void updateItems(List<Object> newItems) {
        this.items = newItems != null ? newItems : new ArrayList<>();
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position) instanceof Speaker ? TYPE_SPEAKER : TYPE_SPEECH;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == TYPE_SPEAKER) {
            View view = inflater.inflate(R.layout.item_speaker_header, parent, false);
            return new SpeakerViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_speech, parent, false);
            return new SpeechViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SpeakerViewHolder) {
            Speaker speaker = (Speaker) items.get(position);
            SpeakerViewHolder vh = (SpeakerViewHolder) holder;
            vh.tvName.setText(speaker.getName());
            vh.tvCountry.setText(speaker.getCountry() + " · " + speaker.getSpeechCount() + " speeches");
            vh.tvInitials.setText(speaker.getInitials());

            // Set avatar color
            View avatarBg = vh.avatarBg;
            if (avatarBg.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) avatarBg.getBackground()).setColor(speaker.getAvatarColor());
            } else {
                GradientDrawable drawable = new GradientDrawable();
                drawable.setShape(GradientDrawable.OVAL);
                drawable.setColor(speaker.getAvatarColor());
                avatarBg.setBackground(drawable);
            }

            // Expand/collapse arrow
            vh.ivExpand.setRotation(speaker.isExpanded() ? 180f : 0f);

            vh.itemView.setOnClickListener(v -> {
                if (speakerClickListener != null) {
                    speakerClickListener.onSpeakerClick(speaker, holder.getAdapterPosition());
                }
            });
        } else if (holder instanceof SpeechViewHolder) {
            Speech speech = (Speech) items.get(position);
            SpeechViewHolder vh = (SpeechViewHolder) holder;
            vh.tvTitle.setText(speech.getTitle());
            String subtitle = speech.getYear() + " · " + speech.getSpeakerName();
            vh.tvYear.setText(subtitle);
            if (speech.getDescription() != null && !speech.getDescription().isEmpty()) {
                vh.tvDesc.setVisibility(View.VISIBLE);
                vh.tvDesc.setText(speech.getDescription());
            } else {
                vh.tvDesc.setVisibility(View.GONE);
            }

            vh.itemView.setOnClickListener(v -> {
                if (speechClickListener != null) {
                    speechClickListener.onSpeechClick(speech);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class SpeakerViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvCountry, tvInitials;
        View avatarBg;
        ImageView ivExpand;

        SpeakerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvSpeakerName);
            tvCountry = itemView.findViewById(R.id.tvSpeakerCountry);
            tvInitials = itemView.findViewById(R.id.tvInitials);
            avatarBg = itemView.findViewById(R.id.avatarBg);
            ivExpand = itemView.findViewById(R.id.ivExpand);
        }
    }

    static class SpeechViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvYear, tvDesc;

        SpeechViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvSpeechTitle);
            tvYear = itemView.findViewById(R.id.tvSpeechYear);
            tvDesc = itemView.findViewById(R.id.tvSpeechDesc);
        }
    }
}
