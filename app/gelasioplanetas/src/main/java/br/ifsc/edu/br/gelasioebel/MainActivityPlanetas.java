package br.ifsc.edu.br.gelasioebel;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.ifsc.edu.br.gelasioebel.gelasioplanetas.R;

public class MainActivityPlanetas extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PlanetaAdapterRecyclerView planetaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_planetas);

        // Setup window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);

        // Set layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Add divider decoration
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                recyclerView.getContext(),
                layoutManager.getOrientation()
        );
        recyclerView.addItemDecoration(dividerItemDecoration);

        // Create and set adapter
        PlanetaDao planetaDao = new PlanetaDao();
        planetaAdapter = new PlanetaAdapterRecyclerView(
                this,
                R.layout.planeta_item,
                planetaDao.getAllPlanetas()
        );

        // Set click listener in the adapter
        planetaAdapter.setOnItemClickListener(position -> {
            Planeta planeta = planetaDao.getAllPlanetas().get(position);
            Toast.makeText(this,
                    "Planeta selecionado: " + planeta.nome,
                    Toast.LENGTH_SHORT).show();
        });

        recyclerView.setAdapter(planetaAdapter);
    }
}