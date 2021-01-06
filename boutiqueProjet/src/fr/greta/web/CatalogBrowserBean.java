package fr.greta.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import fr.greta.entity.Produit;
import service.GestionPanierImpl;
import fr.greta.entity.Catalogue;
import fr.greta.entity.Lot;

@Named
@SessionScoped
public class CatalogBrowserBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Catalogue catalogue;
	private int index; // index de la page
	GestionPanierImpl gestionPanierImpl = new GestionPanierImpl();
	
	private List<Produit> panier = new ArrayList<>();
	
	public void processAddAction( ActionEvent event ) {
		if (gestionPanierImpl.ajouterPanier(getCurrentProduit(),1)) {
			System.out.println("Le produit a bien été ajouté au panier");
		}
		System.out.println("Le produit n'a bien été ajouté au panier");
	}
	
	public Produit getCurrentProduit() { //A Revoir avec Felix
		return catalogue.getProduits().get( index );
	}
	
	public void processPreviousAction( ActionEvent event ) {  // Aller à la page suivante
		if( index > 0 )  index--;
		System.out.println("--");
	}
	
	public void processNextAction( ActionEvent event ) {    // Aller à la page précédente
		if( index < ( catalogue.getProduits().size() - 1 ))  index++;
		System.out.println("++");
	}
		
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}	
}
