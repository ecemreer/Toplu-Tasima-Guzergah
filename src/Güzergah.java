import java.util.List;

public class Güzergah {
    private List<Mahalle> mahalleler; // Seçilen mahallelerden oluşan güzergah
    private double toplamFayda; // Güzergahın toplam fayda değeri

    // **Kurucu Metot (Constructor)**
    public Güzergah(List<Mahalle> mahalleler, double toplamFayda) {
        this.mahalleler = mahalleler;
        this.toplamFayda = toplamFayda;
    }

    // **Güzergahı ekrana yazdıran metot**
    public void yazdir() {
        System.out.println("Seçilen en uygun güzergah:");
        for (Mahalle mahalle : mahalleler) {
            System.out.println("- " + mahalle.getAd());
        }
        System.out.println("Toplam Fayda: " + toplamFayda);
    }
}
