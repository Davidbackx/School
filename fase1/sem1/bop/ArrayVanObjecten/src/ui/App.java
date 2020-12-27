package ui;

import domain.Gerecht;
import domain.Menu;
import domain.Weekmenu;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Gerecht tomatensoepMetBalletjes = new Gerecht("tomatensoep met balletjes",false,150);
        Gerecht stoofVlees = new Gerecht("Stoofvlees",false,850);
        Gerecht portieFrietjes = new Gerecht("Frietjes",true,450);
        Gerecht dameBlanche = new Gerecht("Dame blanche",false, 275);

        Menu menuMaandag = new Menu();
        menuMaandag.addGerecht(tomatensoepMetBalletjes);
        menuMaandag.addGerecht(stoofVlees);
        menuMaandag.addGerecht(portieFrietjes);
        menuMaandag.addGerecht(dameBlanche);

        Gerecht spaghettiVegetarish = new Gerecht("Vegetarische spaghetti",true,425);
        Gerecht tiramisu = new Gerecht("Tiramisu",true,475);
        Menu menuDinsdag = new Menu();
        menuDinsdag.addGerecht(spaghettiVegetarish);
        menuDinsdag.addGerecht(tiramisu);

      /*  Gerecht krok = new Gerecht("Crocque monsieur",false,266);
        Gerecht yoghurt = new Gerecht("Yoghurt natuur",true,45);
        Menu menuWoensdag = new Menu(2);
        menuWoensdag.voegGerechtToe(krok);
        menuWoensdag.voegGerechtToe(yoghurt);*/

        Gerecht kippensoep = new Gerecht("Kippensoep",true,125);
        Gerecht steak = new Gerecht("Steak",false,345);
        Gerecht appel = new Gerecht("Appel",true,45);
        Menu menuDonderdag = new Menu();
        menuDonderdag.addGerecht(kippensoep);
        menuDonderdag.addGerecht(steak);
        menuDonderdag.addGerecht(portieFrietjes);
        menuDonderdag.addGerecht(appel);

        Gerecht vispannetje = new Gerecht("Vispannetje",false,425);
        Gerecht puree = new Gerecht("Puree",true,125);
        Gerecht pudding = new Gerecht("Pudding",true,125);
        Menu menuVrijdag = new Menu();
        menuVrijdag.addGerecht(vispannetje);
        menuVrijdag.addGerecht(puree);
        menuVrijdag.addGerecht(pudding);

        Gerecht pastaPesto = new Gerecht("Pasta pesto",true,385);
        Gerecht chocomousse = new Gerecht("Choco mousse", true, 175);
        Menu menuZaterdag = new Menu();
        menuZaterdag.addGerecht(pastaPesto);
        menuZaterdag.addGerecht(chocomousse);

        Gerecht kalkoen = new Gerecht("Kalkoen gebraad", false, 299);
        Gerecht veenbessen = new Gerecht("veenbessen",true,133);
        Gerecht cremeBrulee = new Gerecht ("crème brûlée", true,266);
        Menu menuZondag = new Menu();
        menuZondag.addGerecht(tomatensoepMetBalletjes);
        menuZondag.addGerecht(kalkoen);
        menuZondag.addGerecht(puree);
        menuZondag.addGerecht(veenbessen);
        menuZondag.addGerecht(cremeBrulee);

        Weekmenu weekMenu = new Weekmenu(LocalDate.now().getYear(),(LocalDate.now().getDayOfYear()/7)+1);
        weekMenu.addMenu(menuMaandag,1);
        weekMenu.addMenu(menuDinsdag,2);
        //weekMenu.voegMenuToe(menuWoensdag,3);
        weekMenu.addMenu(menuDonderdag,4);
        weekMenu.addMenu(menuVrijdag,5);
        weekMenu.addMenu(menuZaterdag,6);
        weekMenu.addMenu(menuZondag,7);

        System.out.println(weekMenu.toString());
        System.out.println("______________________________________________");
        portieFrietjes.setCalorieen(550);
        System.out.println(weekMenu.toString());
        System.out.println("______________________________________________");


    }
}
