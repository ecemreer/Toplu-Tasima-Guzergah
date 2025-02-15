import java.util.Arrays;

public class SoftmaxHesaplayıcı {
    public static double[] softmax(double[] kriterler) {
        // **1. En büyük değeri bul (overflow önlemek için)**
        double max = Arrays.stream(kriterler).max().orElse(0);

        // **2. Tüm değerlere en büyük değeri çıkararak ölçekle (shift technique)**
        double[] shiftedValues = Arrays.stream(kriterler).map(x -> x - max).toArray();

        // **3. Exponential işlemi (e^x) uygula**
        double[] expValues = Arrays.stream(shiftedValues).map(Math::exp).toArray();

        // **4. Toplamı hesapla**
        double toplam = Arrays.stream(expValues).sum();

        // **5. Eğer toplam 0 ise, bölme işlemi hatalı olur. Varsayılan değer döndür.**
        if (toplam == 0 || Double.isNaN(toplam)) {
            return new double[kriterler.length]; // Tüm değerler 0 olur
        }

        // **6. Softmax sonuçlarını hesapla ve iki ondalık basamağa yuvarla**
        return Arrays.stream(expValues)
                .map(x -> Math.round((x / toplam) * 100.0) / 100.0) // %2 hassasiyet
                .toArray();
    }
}
