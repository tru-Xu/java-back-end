package collection.map;

import java.util.HashSet;

public class Book {
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (object instanceof Book) {
            Book that = (Book) object;
            if (that.getName().equals(this.name) && that.getAuthor().equals(this.author)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int hash = 1;
        hash = prime*hash + (this.name == null ? 0 : this.name.hashCode());
        hash = prime*hash + (this.author == null ? 0 : this.author.hashCode());
        return  hash;
    }
    public static void main(String[] args) {
/*        Book mathOne = new Book("math", "Dave");
        Book mathTwo = new Book("math", "Dave");
        Book engOne = new Book("English", "Dave");
        System.out.println(mathOne.equals(mathTwo));
        System.out.println(mathOne.equals(engOne));
        mathOne.setName("English");
        System.out.println(mathOne.equals(mathTwo));
        System.out.println(mathOne.equals(engOne));*/

        Book mathThree = new Book("math", "Dave");
        Book mathFour = new Book("math", "Dave");
        mathThree.hashCode();
        mathFour.hashCode();
        HashSet<Book> hashSet = new HashSet<>();
        hashSet.add(mathThree);
        hashSet.add(mathFour);
        hashSet.contains(mathFour);
        for (Book book : hashSet) {
            System.out.println(book.name);
        }
    }
}
