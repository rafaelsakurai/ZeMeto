package io.github.rafaelsakurai.zemeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Problema> problemas;
    private List<String> descricoes = new ArrayList();
    private ProblemaArrayAdapter adapter;
    private ProblemaDB db;
    private DateFormat df;
    private DateFormat hf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        df = android.text.format.DateFormat
                .getDateFormat(getApplicationContext());
        hf = android.text.format.DateFormat
                .getTimeFormat(getApplicationContext());

        db = new ProblemaDB(this);
        problemas = db.consultarTodos();

//        for(Problema p : problemas) {
//            descricoes.add("ID: " + p.getId() + "\nDescrição: " + p.getDescricao() + "\nData: " + df.format(p.getData()) + " " + hf.format(p.getData()));
//        }

        ListView lista = (ListView) findViewById(R.id.lista);
        adapter = new ProblemaArrayAdapter(this, 0, problemas);
//        adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, descricoes);
        lista.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void adicionar(View view) {
        EditText problema = ((EditText) findViewById(R.id.problema));
        String texto = problema.getText().toString();

        Problema p = new Problema(texto, new Date());
        p.setArrumado(true);
        db.salvar(p);
        descricoes.add("ID: " + p.getId() + "\nDescrição: " + p.getDescricao() + "\nData: " + df.format(p.getData()) + " " + hf.format(p.getData()));

        problema.setText("");
        adapter.notifyDataSetChanged();
    }
}
