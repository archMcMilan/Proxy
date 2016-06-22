package virtual;

/**
 * Created by Artem on 22.06.16.
 */
public class ProxyApp {
    public static void main(String[] args) {
        Image image=new ProxyImage("D:/images/my.jpg");
        image.display();
    }
}
interface Image{
    void display();
}

class RealImage implements Image{
    String file;

    public RealImage(String file) {
        this.file = file;
        load();
    }

    void load(){
        System.out.println("Load in file: "+file);
    }

    @Override
    public void display() {
        System.out.println("Watching "+file);
    }
}

class ProxyImage implements Image{
    String file;
    RealImage realImage;

    public ProxyImage(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if(realImage==null){
            realImage=new RealImage(file);
        }
        realImage.display();
    }
}