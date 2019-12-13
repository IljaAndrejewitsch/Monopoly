import java.util.Scanner;
public abstract class Grundstück extends Feld
{
    public Scanner sc = new Scanner(System.in); 
    
    
    // Def KONS
    // KONSTRUKTOR
    
    
    
    // Nummer des Besitzters des Grundstücks
    private int besitzer;
    // preis des Grundstückes
    private int preis;
    
    public boolean getBesitzt()
    {
        return this.besitzt;
    }
    
    public void setBesitzt(boolean besitzt)
    {
        this.besitzt = besitzt;
    }
    
    public int getPreis()
    {
        return this.preis;
    }
    
    public void setPreis(int preis)
    {
        this.preis = preis;
    }
    
    // zählt, wie viele Spieler noch in der Auktion teilnehmen (will nicht teilnehmen oder Budget < Gebot)
    private static int zählMöglicheTeilnehmer(int [] teilnehmer, int teilnehmerSize, int Gebot)
    {
        int anzahl = 0;
        
        for (int i = 0; i < teilnehmerSize; i++) 
        {
            anzahl = ((teilnehmer[i] != -1) && (Spieler.alleSpieler.get(i).getGeld() > Gebot)) ? anzahl+1 : anzahl;
        }
        
        return anzahl;
    }
    
    // Auktion
    public void versteigGrundstück()
    {
        int[] teilnehmer = new int[Spieler.alleSpieler.size()]; // alle Teilnehmer der Auktion
        for (int i = 0; i < Spieler.alleSpieler.size(); i++)
            teilnehmer[i] = i;
        int gebot = 10; // aktuelles Gebot
        int dreckigesGebot; // ungeprüftes Gebot des Spielers (kann <= als das aktuelle Gebot oder > als das Budget des Spielers sein)
        int spitzenreiter = -1; // Nummer des aktuellen spitzenreiters der Auktion
        System.out.println("\nDas Anfangsgebot beträgt 10 Mark.");
        
        int i = 0;
        while (zählMöglicheTeilnehmer(teilnehmer, Spieler.alleSpieler.size()) > 1)
        {
            if (teilnehmer[i] != -1 && Spieler.alleSpieler.get(i).getGeld() >= gebot) // will noch immer teilnehmen und Budget >= Gebot
            {
                System.out.print("\nSpieler " + (i+1) + ", wie viel bieten Sie? (geben Sie eine Ganzzahl ein)"
                + "\nGeben Sie die Zahl \"-1\" (ohne Klammern), wenn Sie die Auktion verlassen möchten."
                + "\n-> ");
                dreckigesGebot = sc.nextInt();
                System.out.println();
                
                if (dreckigesGebot != -1) { // == -1? => will nicht mehr in der Auktion teilnehmen
                    while ((dreckigesGebot <= gebot) || (dreckigesGebot > Spieler.alleSpieler.get(i).getGeld()))
                    {
                        System.out.println("\nGeben Sie bitte ein Gebot, das größer als das Aktuelle ist, aber ihr Budget nicht überschreitet:"
                        + "\n-> ");
                        dreckigesGebot = sc.nextInt();
                        System.out.println();
                    }
                    
                    gebot = dreckigesGebot;
                    spitzenreiter = i;
                }
                else
                {
                    teilnehmer[i] = -1;
                }
            }
            else if (Spieler.alleSpieler.get(i).getGeld() < gebot) // vertreiben den Spieler, deren Budget < als Gebot der Auktion ist
            {
                System.out.println("\nSpieler " + (i+1) + ", leider haben Sie nicht genug Geld."
                + "Sie können in der Auktion nicht mehr teilnehmen.");
                teilnehmer[i] = -1;
            }
            i = ++i % Spieler.alleSpieler.size(); // läuft im Spielerkreis von 0 bis Spielerarraygröße-1
        }
            
        if (spitzenreiter != -1) // wenn irgendjemand ein Spitzenreiter war
            Spieler.alleSpieler.get(spitzenreiter).addGrundstück(position);
        else
        {
            System.out.println("\nDas Grundstück bleibt unbesitzt.");
        }
    }
    
    public void askKaufentscheidung()
    {
        int entscheidung;
        
        System.out.println("\nMöchten Sie dieses Grundstück kaufen? (ja - 1, nein - sonstiges)"
        + "\n-> ");
        entscheidung = sc.nextInt();
        
        if (entscheidung == 1)
        {
            this.besitzer = Spieler.alleSpieler.get(aktiverSpieler);
            Spieler.alleSpieler.get(aktiverSpieler).addGrundstück(position);
            Spieler.alleSpieler.get(aktiverSpieler).subtractGeld(this.getPreis());
        }
        else
        {
            Auktion.versteigGrundstück();
        }
    }
}
