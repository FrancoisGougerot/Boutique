package fr.greta.entity;

public class Produit {
	private int idProduit;  // supprimer classe lot et mettre quantité ici ?
	private int quantite;
	private String nom;
	private String description;
	private String urlImage;
	private int idCategorie;
	private double prixActuel;
	
	public Produit(int idProduit, int quantite, String nom, String description, String urlImage, int idCategorie,
			double prixActuel) {
		this.idProduit = idProduit;
		this.quantite = quantite;
		this.nom = nom;
		this.description = description;
		this.urlImage = urlImage;
		this.idCategorie = idCategorie;
		this.prixActuel = prixActuel;
	}
	
	public void addOne() {
		quantite++;
	}
	
	public void removeOne() {
		quantite--;
	}
	
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public double getPrixActuel() {
		return prixActuel;
	}
	public void setPrixActuel(double prixActuel) {
		this.prixActuel = prixActuel;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}