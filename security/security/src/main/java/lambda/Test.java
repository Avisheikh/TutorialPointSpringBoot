package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Test
{
    public static void main(String[] args) {
//        FuncInterface fobj = (int x) -> System.out.println(2*x);
//        FuncInterface fobj1 = (int y) -> System.out.println(2*y);
//
//        fobj.abstractFun(5);
//        fobj1.abstractFun(10);
//
//        ArrayList<Integer> arl = new ArrayList<>();
//        arl.add(1);
//        arl.add(2);
//        arl.add(3);
//        arl.add(4);
//
//        arl.forEach(n -> System.out.println(n));
//        arl.forEach(n -> {if (n%2 == 0) System.out.println("n: " + n);});

        int width = 10;

        Drawable d = new Drawable(){
            public void draw(){
                System.out.println("Drawing " + width);
            }
        };
        d.draw();

        Drawable d2 = () -> {
            System.out.println("Drawing part 2: " + width);
        };

        d2.draw();

        List<Product> list = new ArrayList<>();

        list.add(new Product(1, "Hp Laptop",2500));
        list.add(new Product(2, "Keyboard", 45000));
        list.add(new Product(3, "Dell mouser", 23322));

//        Collections.sort(list,(p1,p2) -> { return p1.name.compareTo(p2.name);});

//        for(Product p:list)
//        {
//            System.out.println(p.id+ " "+p.name+ " "+ p.price);
//        }

        Stream<Product> filtered_data = list.stream().filter(p -> p.price < 2600);

        filtered_data.forEach(product -> System.out.println(product.name+": "+ product.price));

    }
}
