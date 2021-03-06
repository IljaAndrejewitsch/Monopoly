public abstract class Stadtwerk extends Grundstueck
{
	public Stadtwerk(int feldnummer, String feld, String feldname, int preis)
    {
    	super(feldnummer, feld, feldname, preis, null);
    }
	
	public void feldBetretenSW(int aktiverSpieler, int gewürfelteZahl) // Polymorphism spielt gegen Entwickler... (ohne SW am Ende werden die Overrides in der Subklassen im Programm aufgerufen)
	{
		System.out.println("\nDu hast den " + getFeldname() + " betreten.");

		if(getFeld().equals("Wasserwerk"))
		{
			((Wasserwerk)Main.spielfeld[28]).feldBetreten(aktiverSpieler, gewürfelteZahl);
		}
		else
		{
			((Stromwerk)Main.spielfeld[12]).feldBetreten(aktiverSpieler, gewürfelteZahl);
		}
	}

	public String toStringSW(Spieler welcherSpieler)
	{
		if(getFeld().equals("Wasserwerk"))
		{
			return ((Wasserwerk)Main.spielfeld[28]).toString(welcherSpieler);
		}
		else
		{
			return ((Stromwerk)Main.spielfeld[12]).toString(welcherSpieler);
		}
	}
}