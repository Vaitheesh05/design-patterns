package designpatterns.creationalpattern.factory;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class BookShop implements Cloneable{

    private String shopName;
    private List<Book> books = new ArrayList<>();

    public void loadData(){
        for(int i=0;i<10;i++){
            Book b= new Book();
            b.setId(i);
            b.setName("Book" + i);
            books.add(b);
        }
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public BookShop clone() {
        BookShop clone = new BookShop();
        for (Book b : getBooks()){
            clone.getBooks().add(b);
        }
        return clone;
    }
}
