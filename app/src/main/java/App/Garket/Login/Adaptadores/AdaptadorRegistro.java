package App.Garket.Login.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import App.Garket.Login.Clases.almacen;
import App.Garket.Login.R;

public class AdaptadorRegistro extends RecyclerView.Adapter<AdaptadorRegistro.ViewHolder> {

        private List<almacen> almacenList;
        //Clases de Dialog
        public AdaptadorRegistro(){
            this.almacenList=new ArrayList<>();
        }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_registro, viewGroup, false);

        return new ViewHolder(itemView);
    }

    public void setAlmacenList(List<almacen> almacenList){
            this.almacenList=almacenList;
        }
        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView ubicacion,area,proceso,equipo,clave_equipo,conjunto,partes;

            public ImageView imagenplaca;
            public LinearLayout itemcontat;
            public ViewHolder(View itemView) {
                super(itemView);
                itemcontat=(LinearLayout)itemView.findViewById(R.id.registro_id);
                clave_equipo=itemView.findViewById(R.id.clave_equipo);
                ubicacion=itemView.findViewById(R.id.ubicacionid);
                area=itemView.findViewById(R.id.areaid);
                proceso=itemView.findViewById(R.id.procesoid);
                equipo=itemView.findViewById(R.id.equipoid);
                conjunto=itemView.findViewById(R.id.conjuntoid);
                partes=itemView.findViewById(R.id.parteid);
                imagenplaca=itemView.findViewById(R.id.imagenpalca);
            }

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

            almacen almacen= this.almacenList.get(position);
            viewHolder.clave_equipo.setText(almacen.getClave_equipo());
            viewHolder.ubicacion.setText(almacen.getUbicacion());
            viewHolder.area.setText(almacen.getArea());
            viewHolder.proceso.setText(almacen.getProceso());
            viewHolder.equipo.setText(almacen.getEquipo());
            viewHolder.conjunto.setText(almacen.getConjunto());
            viewHolder.partes.setText(almacen.getPartes());
//        String url = ApiServiceRutas.API_BASE_URL + "/viajes/buses/" + viajes();
//        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.imagenconductorImg);
        }
        @Override
        public int getItemCount() {
            return this.almacenList.size();
        }
    }

