package service;

import fr.greta.entity.Produit;

public interface GestionPanier {
    public boolean ajouterPanier(Produit produit, int quantite);
    public void retirerPanier(Produit produit);
    public boolean setQuantite(Produit produit, int quantite);
    public void enleverPanier(Produit produit);
    public void viderPanier();
    public void afficherPanier();
    public int getPrixTotal();
}
