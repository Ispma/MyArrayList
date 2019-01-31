public class MyArrayList <Item>
//Это указатель на то, что тип данных будет подстановочный, то есть во время реализации мы не будем знать, что это за тип данных, но во время создания пользователь его укажет
// Механизм затирания не даёт создавать массив обобщённого типа такой как Item[], зато по принципу ООП - наследование, можно объявить массив класса object который может принять всё, что угодно
{
    private Object[] list= new Object[1];
    private int size= 0; //Переменная для хранения колличества элементов в нашем списке

    public int size()
    {
        return size; // метод возвращающий число элементов списка
    }
    // Вывод элемента по индексу
    public Item get ( int index )
    {
        if ( index < 0 || index > size - 1 )
        {
            throw new IndexOutOfBoundsException(); //Исключение
        }
        return (Item) list[index]; // Меняем переменные Object на Item
    }

    // Аналог команды присваивания
    public void set ( int index, Item item )
    {
        if ( index < 0 || index > size - 1 )
        {
            throw new IndexOutOfBoundsException(); //Исключение
        }
        list[index]= item; //Нужно обратить внимание, что в списке ничего кроме Item появиться не может
    }

    public void insert ( Item item )
    {
        if ( size == list.length )
        {
            resize( 2 * list.length ); // Увеличиваем размер массива
        }
        list[size]= item;
        size++;
    }

    private void resize ( int capacity )
    {
        Object[] temp= new Object[ capacity ]; //Создаём новый временный массив
        for ( int i= 0; i < size; i++ ) // С помощью цикла for записываем в него все элементы массива list
        {
            temp[i]= list[i];
        }
        list= temp; //Так как в джаве кроме примитивных все данные - ссылочного типа, мы присваиваем ссылку указывающую на новый массив temp массиву list
    }

    public boolean find ( Item item )
    {
        for ( int i= 0; i < size; i++ )
        {
            if ( list[i].equals(item) )
            {
                return true;
            }
        }
        return false;
    }

    public boolean delete ( Item item )
    {
        int i= 0;
        /*
        !(a || b)= !a && !b;
        !( i >= size || list[i].equals(item) )= i < size && !list[i].equals(item)
         */
        while ( i < size && !list[i].equals(item) )
        {
            i++;
        }
        if ( i == size )
        {
            return false;
        }
        // 1 2 3 4 5
        // 1 2 4 5 5
        for ( int s= 0; s < size; s++ )
        {
            list[s]= list[ s + 1 ];
        }
        list[ size - 1 ]= null;
        size--;

        if ( size == list.length / 4 && size > 0 )
        {
            resize( list.length / 2 );
        }
        return true;
    }

    @Override
    public String toString ()
    {
        String s= " ";
        for ( int i= 0; i < size; i++ )
        {
            s= s + list[i] + " ";
        }
        return s;
    }
}
