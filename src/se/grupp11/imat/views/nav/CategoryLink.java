package se.grupp11.imat.views.nav;

import se.chalmers.ait.dat215.project.ProductCategory;
import se.grupp11.imat.views.CategoryView;
import se.grupp11.imat.views.nav.NavigationLink.NavType;

public class CategoryLink extends NavigationLink {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3670867534368040621L;
	private ProductCategory cat; 
	public CategoryLink(ProductCategory category) {
		super(category.toString().replace('_', ' ').toLowerCase(), "Category");
		cat = category;
		type = NavType.CategoryLink;
	}
	
	public ProductCategory getCategory() {
		return cat;
	}
}
