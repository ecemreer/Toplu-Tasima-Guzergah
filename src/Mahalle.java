public class Mahalle {
   
    private String ad; 
    private double nufusYogunlugu;  
    private double mevcutUlasim;  
    private double maliyet;  
    private double cevreselEtki; 
    private double sosyalFayda; 

   
    private static final double MAX_NUFUS = 2000;  
    private static final double MAX_ULASIM = 5;   
    private static final double MAX_MALIYET = 200000;
    private static final double MAX_CEVRESEL = 10;  
    private static final double MAX_SOSYAL = 10;   

    
    public Mahalle(String ad, double nufusYogunlugu, double mevcutUlasim, double maliyet, double cevreselEtki, double sosyalFayda) {
        this.ad = ad; 
        
    // Değerleri belirlenen maksimum değerlere bölerek 0-1 arasına getiriyoruz
        this.nufusYogunlugu = nufusYogunlugu / MAX_NUFUS;
        this.mevcutUlasim = mevcutUlasim / MAX_ULASIM;

        // Maliyet Ters Çevrilerek Normalize Edildi
        // Maliyetin düşük olması daha iyi olduğu için 1 - (maliyet / max_maliyet) yaparak ters çeviriyoruz
        this.maliyet = 1 - (maliyet / MAX_MALIYET);

        this.cevreselEtki = cevreselEtki / MAX_CEVRESEL;
        this.sosyalFayda = sosyalFayda / MAX_SOSYAL;
    }

   
    public double[] getKriterler() {
        return new double[]{nufusYogunlugu, mevcutUlasim, maliyet, cevreselEtki, sosyalFayda};
    }

    
    public String getAd() {
        return ad;
    }
}
