public class FreiParken extends Aktionsfelder
{
    public FreiParken(int Feldnummer)
    {
    	super(Feldnummer, false, "Frei Parken", "Frei Parken");
    }

    public void Ereignis(int aktiverSpieler)
    {
        System.out.println("\nEntspann dich!");
    }

    public void feldBetreten(int aktiverSpieler)
    {
        System.out.println("\nDu hast das „Frei Parken“ Feld betreten.");
        Ereignis(aktiverSpieler);
    }
    
    public String toString()
    {
    	String ergebnis = "-- Das „Frei Parken“ Feld --";
    	return ergebnis;
    }
}