package se.grupp11.imat.views.nav;

import se.chalmers.ait.dat215.project.ProductCategory;
import se.grupp11.imat.models.CategoriesManual;
import se.grupp11.imat.models.CategoriesManual.CatEntry;
import se.grupp11.imat.views.CategoryView;
import se.grupp11.imat.views.nav.NavigationLink.NavType;

public class CategoryLink extends NavigationLink {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3670867534368040621L;
	private CatEntry cat; 
	public CategoryLink(CatEntry category) {
		super(CategoriesManual.getInstance().getMenuName(category), "Category");
		cat = category;
		type = NavType.CategoryLink;
	}
	
	public CatEntry getCategory() {
		return cat;
	}
}
