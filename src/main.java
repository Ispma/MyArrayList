public class main
{
    public static void main ( String args[] )
    {
        // Суть обобщённого программирования в том, что именно при создании списка мы указываем то, тип, который будет в нём храниться
        MyArrayList <Character> myList= new MyArrayList<>();

        myList.insert('i');
        myList.insert('d');
        myList.insert('p');
        System.out.println( myList.size() );
        System.out.println( myList );
        System.out.println( myList.get(1) );
        myList.set( 1, 's' );
        System.out.println( myList ); //Если мы указываем просто объект, то данный метод автоматически будет вызывать метод toString
        System.out.println( myList.get(1) );
        System.out.println( myList.find( 'p') );
        System.out.println( myList.find( 'd') );
        myList.insert('m');
        myList.insert('a');
        System.out.println( myList.size() );
        System.out.println( myList );
        System.out.println( myList.delete('m') );
        System.out.println( myList.size() );
        System.out.println( myList );

    }
}
