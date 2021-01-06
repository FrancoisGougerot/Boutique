package service;

import java.util.HashMap;
import fr.greta.entity.Produit;

public class GestionPanierImpl implements GestionPanier {
    private HashMap<Produit, Integer> panier;
    
    
    public GestionPanierImpl() {
        panier = new HashMap<Produit, Integer>();
    }
    
    public GestionPanierImpl(Produit produit, int quantite) {
        panier = new HashMap<Produit, Integer>();
        ajouterPanier(produit, quantite);
    }
    
    @Override
    public boolean ajouterPanier(Produit produit, int quantite) {
        if (panier.get(produit) != null) quantite += panier.get(produit);
        if (findById(produit.getIdProduit()).getQuantite() > quantite) return panier.put(produit, quantite) != null;
        return false;     
    }
    
    @Override
    public void retirerPanier(Produit produit) {
        panier.put(produit, panier.get(produit) - 1);
    }
    
    @Override
    public boolean setQuantite(Produit produit, int quantite) {
        if (findById(produit.getIdProduit()).getQuantite() > quantite) return panier.put(produit, quantite) != null;
        return false;
    }
    
    @Override
    public void enleverPanier(Produit produit) {
        panier.remove(produit);
    }
    
    @Override
    public void viderPanier() {
        panier.clear();
    }
    
    @Override
    public void afficherPanier() {
        panier.forEach((produit, quantite)
                -> System.out.println(produit.toString() + " : " + quantite));
    }
    
    @Override
    public double getPrixTotal() {
        double prixTotal;
        panier.forEach((produit, quantite) -> prixTotal += produit.getPrixActuel() * quantite);
        return prixTotal;
    }
}