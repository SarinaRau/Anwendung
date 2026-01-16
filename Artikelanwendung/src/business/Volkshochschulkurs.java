package business;

public class Volkshochschulkurs {
	
    private String kursname;
    private int kursbeitrag;
    private String wochentag;
    private float startuhrzeit;
    private String[] vorkenntnisse;
    
    public Volkshochschulkurs(String kursname, int kursbeitrag, String wochentag,
       	float startuhrzeit, String[] vorkenntnisse){
    	this.kursname = kursname;
      	this.kursbeitrag = kursbeitrag;
       	this.wochentag = wochentag;
       	this.startuhrzeit = startuhrzeit;
       	this.vorkenntnisse = vorkenntnisse;
    }

	public String getKursname() {
		return kursname;
	}

	public void setKursname(String kursname) {
		this.kursname = kursname;
	}

	public int getKursbeitrag() {
		return kursbeitrag;
	}

	public void setKursbeitrag(int kursbeitrag) {
		this.kursbeitrag = kursbeitrag;
	}

	public String getWochentag() {
		return wochentag;
	}

	public void setWochentag(String wochentag) {
		this.wochentag = wochentag;
	}

	public float getStartuhrzeit() {
		return startuhrzeit;
	}

	public void setStartuhrzeit(float startuhrzeit) {
		this.startuhrzeit = startuhrzeit;
	}

	public String[] getVorkenntnisse() {
		return vorkenntnisse;
	}

	public void setVorkenntnisse(String[] vorkenntnisse) {
		this.vorkenntnisse = vorkenntnisse;
	}
	
 	public String getVorkenntnisseAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getVorkenntnisse().length - 1; i++) {
			ergebnis = ergebnis + this.getVorkenntnisse()[i] + trenner; 
		}
		return ergebnis	+ this.getVorkenntnisse()[i];
	}
	
	public String gibVolkshochschuleZurueck(char trenner){
  		return this.getKursname() + trenner 
  			+ this.getKursbeitrag() + trenner
  			+ this.getWochentag() + trenner
  		    + this.getStartuhrzeit() + trenner + "\n"
  		    + this.getVorkenntnisseAlsString(trenner) + "\n";
  	}
}

