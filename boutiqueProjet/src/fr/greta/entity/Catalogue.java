package fr.greta.entity;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped   // <---- ATTENTION ce n'est pas SessionScoped!!
public class Catalogue {
	private List<Produit> produits = new ArrayList<>();
		
	public Catalogue() {  // A changer une fois la BDD faite
		produits.add( new Produit(1, 2, "Samsung1", "description1", "chemin_image", 3, 200.00 ));
		produits.add( new Produit(2, 3, "Samsung2", "description2", "chemin_image", 3, 250.00 ));
		produits.add( new Produit(3, 10, "Samsung3", "description3", "chemin_image", 3, 270.00 ));
		produits.add( new Produit(4, 1, "Samsung4", "description4", "chemin_image", 3, 290.00 ));
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
}

