package thewind.note;

interface Product{}
class ProductOne implements Product{}

class ProductTwo implements Product{}

public class SimpleFactory {
    public Product createProduct(int type){
        if(type==1){
            return new ProductOne();
        }else {
            return new ProductTwo();
        }
    }

    public static void main(){
        SimpleFactory factory=new SimpleFactory();
        Product product=factory.createProduct(1);
    }
}
