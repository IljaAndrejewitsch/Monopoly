public class Wasserwerk extends Stadtwerk
{
	public Wasserwerk(int feldnummer)
    {
    	super(feldnummer, "Stadtwerk", "Wasserwerk", 150);
    }
    
	//Bei Stadtwerken, wird die Miete anders berechnet als bei anderen Feldern. 
    //Wenn der Besitzer dieses Stadtwerkes das andere nicht besitzt, ist die Miete = (Die gewürfelte Zahl des Aktiven Spielers * 4)
    //Wenn der Besitzer das andere Stadtwerk auch besitzt, ist die Miete = (Die gewürfelte Zahl des Aktiven Spielers * 4)
    public void miete(int aktiverSpieler, int gewürfelteZahl)
    {
    	//Ist der Besitzer des Wasserwerks auch der Besitzer des Stromwerks?
    	if(getBesitzer() == ((Stadtwerk)(Main.spielfeld[12])).getBesitzer())
    	{
			System.out.println("\nJetzt zahlst du dem Eigentümer den zehnfachen Betrag deines Wurfergebnisses.");
    		Main.alleSpieler.get(aktiverSpieler).paySpieler(getBesitzer().getSpielernummer(), (gewürfelteZahl * 10));
    	}
    	else
    	{
			System.out.println("\nJetzt zahlst du dem Eigentümer den vierfachen Betrag deines Wurfergebnisses.");
    		Main.alleSpieler.get(aktiverSpieler).paySpieler(getBesitzer().getSpielernummer(), (gewürfelteZahl * 4));
    	}
    }
    
    public void feldBetreten(int aktiverSpieler, int gewürfelteZahl)
    {
    	//Gehört dieses Wasserwerk schon jemandem? Falls nein, kann es gekauft werden, falls ja, muss miete bezahlt werden
    	if(getBesitzer() == null)
    	{
    		askKaufentscheidung(aktiverSpieler);
    	}
    	else if(!getHypothek()) // mit Hypothek = keine Miete = Frei Parken
    	{
    		miete(aktiverSpieler,gewürfelteZahl);
    	}
    }
    
    public String toString(Spieler welcherSpieler)
    {
    	String ergebnis = "-- Der Wasserwerk --";
    	//Falls dieses Feld keinem Gehört, wird dies Ausgegeben
    	if(getBesitzer() == null)
    	{
    		ergebnis = ergebnis + "\nDieser gehört keinem.";
    	}
    	//Ausgeben vom Besitzer des Feldes
    	else
    	{
			if (welcherSpieler.equals(getBesitzer()))
				ergebnis = ergebnis + "\nDieser gehört dir.";
			else
    			ergebnis = ergebnis + "\nDieser gehört dem Spieler mit der Figur: " + getBesitzer().getFigur() + ".";
    	}
		
		if(getHypothek())
            ergebnis += " Auf den Wasserwerk wurde eine Hypothek aufgenommen.";

    	return ergebnis;
    }
}