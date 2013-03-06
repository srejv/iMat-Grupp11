package se.grupp11.imat.models;

import java.util.ArrayList;
import java.util.List;

import org.omg.stub.java.rmi._Remote_Stub;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.grupp11.imat.models.CategoriesManual.CatEntry;

public class CategoriesManual {

	public enum CatEntry { BREAD, CHARK, DAIRY, CANDYANDFIKA, VEG, FRUITANDBERRIES, DRINK, BASEFOOD };
	
	private List<Product> bread;
	private List<Product> chark;
	private List<Product> dairy;
	private List<Product> candyandfika;
	private List<Product> veg;
	private List<Product> drink;
	private List<Product> basefood;
	private List<Product> fruitandberries;
	
	private static CategoriesManual _instance;
	
	public static CategoriesManual getInstance() {
		if(_instance == null) {
			_instance = new CategoriesManual();
		}
		return _instance;
	}
	
	private CategoriesManual() {
		IMatDataHandler imat = IMatDataHandler.getInstance();
		
		bread = new ArrayList<Product>();
		bread.add(imat.getProduct(8));
		bread.add(imat.getProduct(9));
		bread.add(imat.getProduct(10));
		bread.add(imat.getProduct(11));
		bread.add(imat.getProduct(12));
		bread.add(imat.getProduct(13));
		bread.add(imat.getProduct(14));
		
		
		veg = new ArrayList<Product>();
		veg.add(imat.getProduct(1));
		veg.add(imat.getProduct(2));
		veg.add(imat.getProduct(3));
		veg.add(imat.getProduct(4));
		veg.add(imat.getProduct(5));
		veg.add(imat.getProduct(6));
		veg.add(imat.getProduct(55));
		veg.add(imat.getProduct(56));
		veg.add(imat.getProduct(57));
		veg.add(imat.getProduct(58));
		veg.add(imat.getProduct(59));
		veg.add(imat.getProduct(60));
		veg.add(imat.getProduct(61));
		veg.add(imat.getProduct(62));
		veg.add(imat.getProduct(63));
		veg.add(imat.getProduct(64));
		veg.add(imat.getProduct(65));
		veg.add(imat.getProduct(66));
		veg.add(imat.getProduct(67));
		veg.add(imat.getProduct(68));
		veg.add(imat.getProduct(69));
		veg.add(imat.getProduct(70));
		veg.add(imat.getProduct(86));
		veg.add(imat.getProduct(87));
		veg.add(imat.getProduct(88));
		veg.add(imat.getProduct(89));
		veg.add(imat.getProduct(90));
		veg.add(imat.getProduct(121));
		veg.add(imat.getProduct(122));
		veg.add(imat.getProduct(123));
		veg.add(imat.getProduct(124));
		veg.add(imat.getProduct(125));
		veg.add(imat.getProduct(126));
		veg.add(imat.getProduct(127));
		veg.add(imat.getProduct(128));
		veg.add(imat.getProduct(142));
		veg.add(imat.getProduct(143));
		veg.add(imat.getProduct(144));
		veg.add(imat.getProduct(145));
		veg.add(imat.getProduct(146));
		veg.add(imat.getProduct(147));
		veg.add(imat.getProduct(148));
		
		fruitandberries = new ArrayList<Product>();
		fruitandberries.add(imat.getProduct(15));
		fruitandberries.add(imat.getProduct(16));
		fruitandberries.add(imat.getProduct(17));
		fruitandberries.add(imat.getProduct(18));
		fruitandberries.add(imat.getProduct(19));
		fruitandberries.add(imat.getProduct(20));
		fruitandberries.add(imat.getProduct(21));
		fruitandberries.add(imat.getProduct(22));
		fruitandberries.add(imat.getProduct(23));
		fruitandberries.add(imat.getProduct(24));
		fruitandberries.add(imat.getProduct(25));
		fruitandberries.add(imat.getProduct(26));
		fruitandberries.add(imat.getProduct(41));
		fruitandberries.add(imat.getProduct(42));
		fruitandberries.add(imat.getProduct(43));
		fruitandberries.add(imat.getProduct(44));
		fruitandberries.add(imat.getProduct(45));
		fruitandberries.add(imat.getProduct(46));
		fruitandberries.add(imat.getProduct(47));
		fruitandberries.add(imat.getProduct(129));
		fruitandberries.add(imat.getProduct(130));
		fruitandberries.add(imat.getProduct(131));
		fruitandberries.add(imat.getProduct(132));
		fruitandberries.add(imat.getProduct(133));

		
		
		
		drink = new ArrayList<Product>();
		drink.add(imat.getProduct(27));
		drink.add(imat.getProduct(28));
		drink.add(imat.getProduct(29));
		drink.add(imat.getProduct(30));
		drink.add(imat.getProduct(31));
		drink.add(imat.getProduct(32));
		drink.add(imat.getProduct(33));
		drink.add(imat.getProduct(34));
		drink.add(imat.getProduct(35));
		drink.add(imat.getProduct(36));
		drink.add(imat.getProduct(37));
		drink.add(imat.getProduct(38));
		drink.add(imat.getProduct(39));
		drink.add(imat.getProduct(40));
		
		
		chark = new ArrayList<Product>();
		chark.add(imat.getProduct(48));
		chark.add(imat.getProduct(49));
		chark.add(imat.getProduct(50));
		chark.add(imat.getProduct(51));
		chark.add(imat.getProduct(52));
		chark.add(imat.getProduct(53));
		chark.add(imat.getProduct(54));
		chark.add(imat.getProduct(71));
		chark.add(imat.getProduct(72));
		chark.add(imat.getProduct(73));
		chark.add(imat.getProduct(74));
		chark.add(imat.getProduct(75));
		chark.add(imat.getProduct(76));
		
		dairy = new ArrayList<Product>();
		dairy.add(imat.getProduct(77));
		dairy.add(imat.getProduct(78));
		dairy.add(imat.getProduct(79));
		dairy.add(imat.getProduct(80));
		dairy.add(imat.getProduct(81));
		dairy.add(imat.getProduct(82));
		dairy.add(imat.getProduct(83));
		dairy.add(imat.getProduct(84));
		dairy.add(imat.getProduct(85));
		
		basefood = new ArrayList<Product>();
		basefood.add(imat.getProduct(91));
		basefood.add(imat.getProduct(92));
		basefood.add(imat.getProduct(93));
		basefood.add(imat.getProduct(94));
		basefood.add(imat.getProduct(95));
		basefood.add(imat.getProduct(96));
		basefood.add(imat.getProduct(97));
		basefood.add(imat.getProduct(98));
		basefood.add(imat.getProduct(99));
		basefood.add(imat.getProduct(100));
		basefood.add(imat.getProduct(101));
		basefood.add(imat.getProduct(102));
		basefood.add(imat.getProduct(103));
		basefood.add(imat.getProduct(104));
		basefood.add(imat.getProduct(105));
		basefood.add(imat.getProduct(106));
		basefood.add(imat.getProduct(107));
		basefood.add(imat.getProduct(108));
		basefood.add(imat.getProduct(109));
		basefood.add(imat.getProduct(110));
		basefood.add(imat.getProduct(111));
		basefood.add(imat.getProduct(112));
		basefood.add(imat.getProduct(113));
		basefood.add(imat.getProduct(114));
		basefood.add(imat.getProduct(115));
		basefood.add(imat.getProduct(116));
		basefood.add(imat.getProduct(117));
		basefood.add(imat.getProduct(118));
		basefood.add(imat.getProduct(119));
		basefood.add(imat.getProduct(120));
		
		candyandfika = new ArrayList<Product>();
		candyandfika.add(imat.getProduct(134));
		candyandfika.add(imat.getProduct(135));
		candyandfika.add(imat.getProduct(136));
		candyandfika.add(imat.getProduct(137));
		candyandfika.add(imat.getProduct(138));
		candyandfika.add(imat.getProduct(139));
		candyandfika.add(imat.getProduct(140));
		
	}
	
	public List<Product> getCategory(CatEntry c) {
		switch(c) {
		case BASEFOOD:
			return basefood;
		case BREAD:
			return bread;
		case CANDYANDFIKA:
			return candyandfika;
		case CHARK:
			return chark;
		case DAIRY:
			return dairy;
		case DRINK:
			return drink;
		case VEG:
			return veg;
		case FRUITANDBERRIES:
			return fruitandberries;
		}
		
		return null;
	}

	public String getMenuName(CatEntry category) {
		switch(category) {
		case BASEFOOD:
			return "Basmat";
		case BREAD:
			return "Bröd";
		case CANDYANDFIKA:
			return "Godis och Fika";
		case CHARK:
			return "Chark";
		case DAIRY:
			return "Mejeri";
		case DRINK:
			return "Dricka";
		case VEG:
			return "Grönt";
		case FRUITANDBERRIES:
			return "Frukt och Bär";
		default:
				return "P TOSH";
		}
	}
}
/*
Bröd
- Hårt bröd
- Mjuktbröd
Chark:
- Kött
- Fågel
- Fisk
Mejeri:
- Mjölkvaror
- Ost
Godis och fika
- Godis
- Fikabröd och kakor
Frukt och grönt
- Frukt
- Bär
- Bönor och baljväxter
- Rotfrukter
- Grönsaker
Dryck
- Dricka
- Kaffe och te
- Juice
Basvaror
- Spannmål
- Skafferi
- Ris och pasta
- Nötter
Färdiglagat
*/
