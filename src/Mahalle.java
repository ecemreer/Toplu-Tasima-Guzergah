public class Mahalle {
    // Mahalle bilgilerini saklamak için değişkenler
    private String ad;  // Mahallenin adı
    private double nufusYogunlugu;  // Nüfus yoğunluğu (normalize edilmiş)
    private double mevcutUlasim;  // Mevcut ulaşım olanakları (normalize edilmiş)
    private double maliyet;  // Toplu taşıma maliyeti (normalize edilmiş, ters çevrilmiş)
    private double cevreselEtki;  // Çevresel etki (normalize edilmiş)
    private double sosyalFayda;  // Sosyal fayda (normalize edilmiş)

    // Normalizasyon için kullanılacak maksimum değerler (örnek olarak belirlenmiş)
    private static final double MAX_NUFUS = 2000;   // En yüksek nüfus yoğunluğu
    private static final double MAX_ULASIM = 5;     // Mevcut ulaşım olanaklarının maksimum değeri
    private static final double MAX_MALIYET = 200000; // En yüksek maliyet
    private static final double MAX_CEVRESEL = 10;  // Çevresel etkinin maksimum değeri
    private static final double MAX_SOSYAL = 10;    // Sosyal faydanın maksimum değeri

    // **Constructor (Kurucu Metot)**
    // Mahalle nesnesi oluşturulurken girilen değerler normalize edilir
    public Mahalle(String ad, double nufusYogunlugu, double mevcutUlasim, double maliyet, double cevreselEtki, double sosyalFayda) {
        this.ad = ad;  // Mahalle adını sakla

        // **Veri Normalizasyonu:**
        // Değerleri belirlenen maksimum değerlere bölerek 0-1 arasına getiriyoruz
        this.nufusYogunlugu = nufusYogunlugu / MAX_NUFUS;
        this.mevcutUlasim = mevcutUlasim / MAX_ULASIM;

        // **Maliyet Ters Çevrilerek Normalize Edildi**
        // Maliyetin düşük olması daha iyi olduğu için 1 - (maliyet / max_maliyet) yaparak ters çeviriyoruz
        this.maliyet = 1 - (maliyet / MAX_MALIYET);

        this.cevreselEtki = cevreselEtki / MAX_CEVRESEL;
        this.sosyalFayda = sosyalFayda / MAX_SOSYAL;
    }

    // **Mahallenin kriterlerini döndüren metot**
    // Softmax algoritmasına girdi olarak verilecek kriterleri içeren bir dizi döndürür
    public double[] getKriterler() {
        return new double[]{nufusYogunlugu, mevcutUlasim, maliyet, cevreselEtki, sosyalFayda};
    }

    // **Mahallenin adını döndüren metot**
    public String getAd() {
        return ad;
    }
}
