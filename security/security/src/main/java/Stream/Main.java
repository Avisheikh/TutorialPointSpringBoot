package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<Product>();

        productList.add(new Product(1,"Hp Laaptop",25000));
        productList.add(new Product(2, "dell laptop", 343434));
        productList.add(new Product(3, "lenovo laptop", 343443));
        productList.add(new Product(4, "sony laptopo", 3434));
        productList.add(new Product(5,"Apple laptop", 343434));

        List<Float> productPriceList = new ArrayList<Float>();
        List<String> productPriceList2 = productList.stream()
                .filter(p -> p.price < 30000)
                .map(p -> p.name)
                .collect(Collectors.toList());

        List<Float> productPriceList3 = productList.stream()
                .filter(p -> p.price <= 20000)
                .map(p -> p.price)
                .collect(Collectors.toList());


        for(Product product: productList)
        {
            if(product.price < 30000)
            {
                productPriceList.add(product.price);
            }
        }
        System.out.println(productPriceList);
        System.out.println("Product Price list:- " + productPriceList2);
        System.out.println("Product Price Llist");

        productList.stream()
                        .filter(product -> product.price > 30000)
                                .forEach(hero -> System.out.println(hero.name));

        System.out.println(productList.stream()
                .filter(p -> p.price > 30000)
                .map(p -> p.name)
                .collect(Collectors.toSet()));

        Stream.iterate(5, element -> element+1)
                .filter(element -> element%2==0)
                .limit(5)
                .forEach(System.out::println);
    }
}
