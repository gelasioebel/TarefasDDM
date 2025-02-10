package br.ifsc.edu.br.gelasioebel;

import android.content.Context;
import android.view.LayoutInflater;  // Added import
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlanetaAdapterRecyclerView extends RecyclerView.Adapter<PlanetaAdapterRecyclerView.PlanetaVH> {
    Context mContext;
    int mResource;
    List<Planeta> mListPlaneta;
    private OnItemClickListener mListener;

    public PlanetaAdapterRecyclerView(Context context, int resource, List<Planeta> objs) {
        mContext = context;
        mResource = resource;
        mListPlaneta = objs;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public PlanetaVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        // Fixed inflation
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(mResource, viewGroup, false);
        return new PlanetaVH(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetaVH planetaVH, int i) {
        Planeta p = mListPlaneta.get(i);
        planetaVH.imageView.setImageResource(p.foto);
        planetaVH.tvNome.setText(p.nome);
    }

    @Override
    public int getItemCount() {
        return mListPlaneta.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public class PlanetaVH extends RecyclerView.ViewHolder {
        TextView tvNome;
        ImageView imageView;

        public PlanetaVH(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            tvNome = itemView.findViewById(R.id.textViewNome);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }
}