public class Gefängnis extends Aktionsfelder
{
    public Gefängnis(int Feldnummer)
    {
    	super(Feldnummer, false, "Gefängnis", "Gefängnis");
    }
    
     public void feldBetreten(int aktiverSpieler)
    {
        //Wenn der Spieler nicht im Gefängnis ist, dann wird nur ein Text ausgegeben
    	System.out.println("\nDu hast das Gefängnis betreten.");
        System.out.println("\nDu bist nur zu Besuch!");
    }
	public String toString()
	{
		String ergebnis = "-- Das Gefängnis --";
		return ergebnis;
	}
}