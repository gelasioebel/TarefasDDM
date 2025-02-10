package br.ifsc.edu.br.gelasioebel;

import java.util.ArrayList;

import br.ifsc.edu.br.gelasioebel.gelasioplanetas.R;
public class PlanetaDao {
    ArrayList<Planeta> planetas;

    public PlanetaDao() {
        planetas = new ArrayList<>();
        planetas.add(new Planeta("Mercúrio", R.drawable.mercury));
        planetas.add(new Planeta("Vênus", R.drawable.venus));
        planetas.add(new Planeta("Terra", R.drawable.earth));
        planetas.add(new Planeta("Marte", R.drawable.mars));
        planetas.add(new Planeta("Júpiter", R.drawable.jupiter)); // Fixed spelling
        planetas.add(new Planeta("Saturno", R.drawable.saturn));
        planetas.add(new Planeta("Urano", R.drawable.uranus));
        planetas.add(new Planeta("Netuno", R.drawable.neptune)); // Changed from Pluto to Neptune
    }

    public ArrayList<Planeta> getAllPlanetas() {
        return this.planetas;
    }
}