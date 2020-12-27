package db;

import domain.Opdracht;
import java.util.*;

public class OpdrachtDatabank {
		
	private List<Opdracht> opdrachten;
	
	public OpdrachtDatabank() {
		Opdracht [] opdrachtjes ={
					new Opdracht("3+2=","5","optellen"),
					new Opdracht("3+12=","15","optellen"),
					new Opdracht("13+12=","25","optellen"),
					new Opdracht("13-2=","11","aftrekken"),
					new Opdracht("1-2=","-1","aftrekken"),					
					new Opdracht("13-13=","0","aftrekken"),
					new Opdracht("1*2=","2","vermenigvuldigen"),
					new Opdracht("11*2=","22","vermenigvuldigen"),
					new Opdracht("10*20=","200","vermenigvuldigen"),
					new Opdracht("20/10=","2","delen")
					};					
	
		opdrachten = new ArrayList<>(Arrays.asList(opdrachtjes));		
	}		
		
	public List<Opdracht> getOpdrachten() {
		return opdrachten;
	}
				
	public Opdracht getRandomOpdracht(){
		Random rn = new Random();
		int index = rn.nextInt(opdrachten.size());
		return opdrachten.get(index);
	}		
}
