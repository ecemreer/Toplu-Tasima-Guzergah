import java.util.ArrayList;
import java.util.List;

public class Uygulama {
    public static void main(String[] args) {

        List<Mahalle> mahalleler = new ArrayList<>();
        mahalleler.add(new Mahalle("Karakaş", 900, 2, 150000, 6, 7));
        mahalleler.add(new Mahalle("İstasyon", 700, 4, 100000, 4, 9));
        mahalleler.add(new Mahalle("Pınar", 1200, 3, 120000, 5, 8)); 
      
        double[][] agirliklar = new double[mahalleler.size()][];

        System.out.println("Softmax Çıktıları:");
        for (int i = 0; i < mahalleler.size(); i++) {
           
            agirliklar[i] = SoftmaxHesaplayıcı.softmax(mahalleler.get(i).getKriterler());
            System.out.println(mahalleler.get(i).getAd() + ": " + java.util.Arrays.toString(agirliklar[i]));
        }

        double enYuksekFayda = Double.NEGATIVE_INFINITY; 
        Güzergah enIyiGüzergah = null; 
        
        for (int i = 0; i < mahalleler.size(); i++) {
          
            double toplamFayda = agirliklar[i][0] * 0.3  // Nüfus yoğunluğu (30%)
                    + agirliklar[i][1] * 0.2  // Mevcut ulaşım (20%)
                    + agirliklar[i][2] * 0.1  // Maliyet (10%)
                    + agirliklar[i][3] * 0.2  // Çevresel etki (20%)
                    + agirliklar[i][4] * 0.2; // Sosyal fayda (20%)

            System.out.println(mahalleler.get(i).getAd() + " için toplam fayda: " + toplamFayda);

        
            if (toplamFayda > enYuksekFayda) {
                enYuksekFayda = toplamFayda;
                enIyiGüzergah = new Güzergah(List.of(mahalleler.get(i)), toplamFayda);
            }
        }

        
        if (enIyiGüzergah != null) {
            enIyiGüzergah.yazdir();
        } else {
            System.out.println("Hata: En iyi güzergah belirlenemedi!");
        }
    }
}
