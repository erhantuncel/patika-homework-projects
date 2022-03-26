# Custom List Class

A Java class that save data by using generics. This class, contains generic array that accept data type dynamically.

## Properties

- Array that contains this class, has 10 elements by default. If it needs, can be increase array size by 2 times.

## Constructor

- This class should have two constructor.
    - `MyList()` : Starting size should be 10.
    - `MyList(in capacity)` : Starting size should be set with capacity parameter.

## Methods

- `size()` : Returns element count of array. 
- `getCapacity()` : Returns capacity of array.
- `add(T data)` : Adds element to Array belongs to class. If array is ful, size of array should be increase by two times. 
- `get(int index)` : Returns the value at the given index. 
Returns null if invalid index is entered.
- `remove(int index)` : Should delete the value at the given index and shift the data after the deleted index to the left. Returns null if invalid index is entered.
- `set(int index, T data)` : Replaces the value at the given index. Returns null if invalid index is entered.
- `String toString()` : Lists elements of array belongs to class.
- `int indexOf(T data)` : Returns index of the object that is given with parameter. Returns -1, If there is not object in the list.
- `int lastIndexOf(T data)` : Returns index of the last occurrence of the object that is given with parameter. Returns -1, If there is not object in the list.
- `boolean isEmpty()` : Checks if the array is empty. Returns true, if array is empty otherwise return false.
- `T[] toArray()` : Returns array that created with items in the list in the same order.
- `clear()` : Deletes all elements in the list.
- `MyList<T> subList(int start, int finish)` : Returns a list belongs to range that is given with parameter.
- `boolean contains(T data)` : Checks whether the value that is given with paramater is in the list. Returns true, if the value is in list otherwise return false.
