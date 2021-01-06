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
public class PanierBrowserBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Catalogue catalogue;
	private int index; // index de la page
	GestionPanierImpl gestionPanierImpl = new GestionPanierImpl();
	
	public Produit getCurrentProduit() { 
		return catalogue.getProduits().get( index );  // A revoir ce n'est pas index avec code de Felix
	}
	
	public void processRemoveProductAction( ActionEvent event ) {
		gestionPanierImpl.enleverPanier(getCurrentProduit()); // Pas de condition car aucune chance de se foirer sauf si problème avec hashmap
	}
	
	public void processQuantityAddAction( ActionEvent event ) {
		if (gestionPanierImpl.ajouterPanier(getCurrentProduit(),1)) {
			System.out.println("Le produit a bien été ajouté au panier");
		}
		System.out.println("Le produit n'a bien été ajouté au panier");
	}
	
	public void processQuantityRemoveAction( ActionEvent event ) {
		gestionPanierImpl.retirerPanier(getCurrentProduit());// Pas de condition car aucune chance de se foirer sauf si problème avec hashmapk
	}
	
	public void processPreviousAction( ActionEvent event ) {
		if( index > 0 )  index--;
		System.out.println("--");
	}
	
	public void processNextAction( ActionEvent event ) {
		if( index < ( catalogue.getProduits().size() - 1 ))  index++;
		System.out.println("++");
	}
	
//	public int getBasketSize() {
//		int quantity = 0;
//		for( Produit produit : panier )  quantity += produit.getQuantite();
//		return quantity;
//	}
		
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}	
}