package io.github.rafaelsakurai.zemeto;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by rafaelsakurai on 27/03/2018.
 */

public class ProblemaArrayAdapter extends ArrayAdapter<Problema>{
    private Context context;
    private List<Problema> problemas;

    private DateFormat df;

    public ProblemaArrayAdapter(Context context, int resource, List<Problema> problemas) {
        super(context, resource, problemas);
        this.context = context;
        this.problemas = problemas;
        df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View linha = inflater.inflate(R.layout.problema, parent, false);
        TextView idProblema = (TextView)linha.findViewById(R.id.idProblema);
        TextView descricao = (TextView) linha.findViewById(R.id.descricao);
        TextView data = (TextView) linha.findViewById(R.id.data);
        ImageView status = (ImageView) linha.findViewById(R.id.status);

        Problema p = problemas.get(position);

        Log.e("PROBLEMA", p.toString());

        idProblema.setText("ID: " + String.valueOf(p.getId()));
        descricao.setText(p.getDescricao());
        data.setText(df.format(p.getData()));
        if(p.isArrumado()) {
            status.setImageResource(R.drawable.arrumado);
        } else {
            status.setImageResource(R.drawable.naoarrumado);
        }

        return linha;
    }
}
