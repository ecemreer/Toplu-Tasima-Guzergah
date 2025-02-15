import java.util.List;

public class Güzergah {
    private List<Mahalle> mahalleler; 
    private double toplamFayda;
    
   
    public Güzergah(List<Mahalle> mahalleler, double toplamFayda) {
        this.mahalleler = mahalleler;
        this.toplamFayda = toplamFayda;
    }

  
    public void yazdir() {
        System.out.println("Seçilen en uygun güzergah:");
        for (Mahalle mahalle : mahalleler) {
            System.out.println("- " + mahalle.getAd());
        }
        System.out.println("Toplam Fayda: " + toplamFayda);
    }
}
