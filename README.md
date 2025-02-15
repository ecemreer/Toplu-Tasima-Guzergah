#  Toplu Taşıma Güzergah Optimizasyonu

Bu proje, **Softmax algoritması** kullanılarak Kırklareli'nin **üç mahallesi** için **en uygun toplu taşıma güzergahını** belirlemeyi amaçlamaktadır.

## Softmax Algoritmasının Projedeki Rolü

Projede, **nüfus yoğunluğu, mevcut ulaşım altyapısı, maliyet analizi, çevresel etki ve sosyal fayda** kriterleri kullanılarak en uygun güzergah belirlenmektedir. **Softmax algoritması**, bu kriterlerin **ağırlıklarını belirlemek** için kullanılmıştır.

##  Nasıl Çalışır?

1. **Kriter Önem Skorları Belirlenir**
   - Projede kullanılan kriterler **farklı önem derecelerine** sahiptir. Örnek olarak:
     ```
     [Nüfus Yoğunluğu: 9, Mevcut Ulaşım Altyapısı: 7, Maliyet Analizi: 8, Çevresel Etki: 6, Sosyal Fayda: 9]
     ```
2. **Softmax ile Ağırlık Hesaplama**
   - Her skorun üstel değeri alınır:
     ```math
     exp\_score = e^{skor}
     ```
   - Tüm üstel değerler toplanır:
     ```math
     sum\_exp = \sum exp\_score
     ```
   - Her kriterin ağırlığı hesaplanır:
     ```math
     ağırlık = \frac{exp\_score}{sum\_exp}
     ```
   - Örnek bir hesaplamada, ağırlıklar şu şekilde çıkmıştır:
     ```
     [0.39, 0.05, 0.14, 0.02, 0.39]
     ```

3. **Mahalle Skorlaması**
   - Her mahallenin kriter puanları, Softmax ağırlıklarıyla çarpılarak **toplam skor hesaplanır**:
     ```math
     toplam\_skor = \sum (kriter\_puanı \times ağırlık)
     ```
   - En yüksek toplam skora sahip mahalle **en uygun güzergah olarak belirlenir**.

##  Neden Softmax Kullanıldı?

 **Objektiflik:** Kriterlerin önemini **matematiksel olarak normalize eder**.
 **Esneklik:** Yeni kriterler eklenirse **ağırlıklar dinamik olarak güncellenebilir**.
**Optimizasyon:** **Maliyet-fayda analizi** ile **verimli güzergah seçimi** yapılmasını sağlar.

 **Detaylı dokümantasyon ve açıklamalar README.md içinde yer almaktadır.** 

