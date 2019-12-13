 import java.util.ArrayList;
 
public class Spieler
{
    //Das Geld, dass der Spieler hat (in Mark)
    private int geld;
    //Die Positon des Spielers auf dem Grundstück
    private int position;
    //Die Grundstücke die der Spieler gekauft hat. Hier wird die Position des Grundstükes gespeichert. 
    private ArrayList<Integer> grundstücke;
    //Jeder Spieler braucht eine Spielernummer, damit man die Spieler unterscheiden kann
    private int spielernummer;
    //Ist dieser Spieler gerade im Gefängnis?
    private boolean imGefängnis = false;
    private int rundenImGefängnis = 0;
    //Die anzahl von "Komm aus dem Gefängnis Frei" Karten, die der Spieler besitzt
    private int kommAusDemGefängnisFreiKarten = 0;
    public Spieler()
    {
        grundstücke = new ArrayList<Integer>();
    }
    
    //Getter und Setter für alle Instanzvariablen
    public int getGeld()
    {
        return geld;
    }
    public void setGeld(int Geld)
    {
        geld = Geld;
    }
    public void addGeld(int Geld)
    {
        geld += Geld;
    }
    public void subtractGeld(int Geld)
    {
        geld -= Geld;
    }
    public int getPosition()
    {
        return position;
    }
    public void setPosition(int Position)
    {
        if(Position < 0)
        {
        	Position = 39 + Position;
        }
        if(Position > 39)
        {
            Position = Position - 39;
        }
    	position = Position;
<<<<<<< HEAD
=======
    }
    public boolean getImGefängnis()
    {
    	return imGefängnis;
    }
    public void setImGefängnis()
    {
    	imGefängnis = true;
    	position = 10;
    	rundenImGefängnis = 0;
    }
    public int getRundenImGefängnis()
    {
    	return rundenImGefängnis;
    }
    public void increaseRundenImGefängnis()
    {
    	rundenImGefängnis++;
>>>>>>> e3c151b5bfd8050101bc67e6683e68fb01bacf1f
    }
    public boolean getImGefängnis()
    {
<<<<<<< HEAD
    	return imGefängnis;
=======
        int[] ausgabe = new int[grundstücke.size()];
        for(int i = 0; i < ausgabe.length; i++)
        {
        	ausgabe[i] = grundstücke.get(i);
        }
        return ausgabe;
>>>>>>> e3c151b5bfd8050101bc67e6683e68fb01bacf1f
    }
    public void setImGefängnis()
    {
    	imGefängnis = true;
    	position = 10;
    	rundenImGefängnis = 0;
    }
    public int getRundenImGefängnis()
    {
    	return rundenImGefängnis;
    }
    public void increaseRundenImGefängnis()
    {
    	rundenImGefängnis++;
    }
    public Spielfeld[] getGrundstücke()
    {
<<<<<<< HEAD
        return Spielfeld.toArray();
    }
=======
        int[] ausgabe = new int[grundstücke.size()];
        for(int i = 0; i < ausgabe.length; i++)
        {
        	ausgabe[i] = grundstücke.get(i);
        }
        return ausgabe;
    }
>>>>>>> e3c151b5bfd8050101bc67e6683e68fb01bacf1f
    public void addGrundstück(int Position)
    {
        grundstücke.add(Position);
    }
    public void removeGrundstück(int Position)
    {
        grundstücke.remove(Position);
    }
    public int getSpielernummer()
    {
<<<<<<< HEAD
<<<<<<< HEAD
        
    }
}
=======
        return spielernummer;
    }
    public int getGefängnisKarte()
    {
    	return kommAusDemGefängnisFreiKarten;
    }
    public void addGefängnisKarte()
    {
    	kommAusDemGefängnisFreiKarten++;
    }
    public void subtractGefängnisKarte()
    {
    	kommAusDemGefängnisFreiKarten--;
    }
    
}
>>>>>>> e3c151b5bfd8050101bc67e6683e68fb01bacf1f
=======
        return spielernummer;
    }
    public int getGefängnisKarte()
    {
    	return kommAusDemGefängnisFreiKarten;
    }
    public void addGefängnisKarte()
    {
    	kommAusDemGefängnisFreiKarten++;
    }
    public void subtractGefängnisKarte()
    {
    	kommAusDemGefängnisFreiKarten--;
    }
    
}
>>>>>>> e3c151b5bfd8050101bc67e6683e68fb01bacf1f
