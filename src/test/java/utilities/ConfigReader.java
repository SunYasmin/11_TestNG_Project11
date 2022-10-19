package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;
    static { //(static blok)Her method'dan once calisir
        String dosyaYolu="configuration.properties";
        try {
            FileInputStream fis= new FileInputStream(dosyaYolu); //dosya yolundaki noktali virgul sonrasi nokta koydugumuzda try secenegini verir.
            properties =new Properties();
            properties.load(fis);//fis'in okudugu bilgileri properties'e yukledi
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //her seferinde exception firlatmasiyla ugrasmamak icin try catch icine aldik.
    //static bloklar herseyden once calistigi icin methodlarimizi static yaptik.
    //dosya yolu almak icin dosya uzerine gidip sag click ve copy path ve path from contant root secenegi ile aliriz.




    public static String getProperty(String key){
        /*
       Test methodundan yolladigimiz String key degerini alip properties classindan
       getProperty() methodunu kullanarak bu key'e ait value'yu bize getirir
        */
        return properties.getProperty(key);
    }



}
