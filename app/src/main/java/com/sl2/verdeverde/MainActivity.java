package com.sl2.verdeverde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sl2.verdeverde.entidades.Usuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);

        // Put this in a different thread or use AsyncSession in greenDAO.
        // For Demo purpose, this query is made on main thread but it should in a different thread.
        Usuario user = ((DemoApp)getApplication()).getDaoSession().getUsuarioDao().load(1L);

        //Usuario usuario2 = ((DemoApp)getApplication()).getDaoSession().getUsuarioDao().

        if(user != null){
            textView.setText(user.getNombre());
        }

    }
}
