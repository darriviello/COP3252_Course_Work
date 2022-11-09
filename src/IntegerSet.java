public class IntegerSet
{
    private boolean[] intSet;

    IntegerSet()
    {
        intSet = new boolean[101];
    }

    public IntegerSet union(IntegerSet iSet)
    {
        IntegerSet unionSet = new IntegerSet();

        for (int i = 0; i < 101; i++)
        {
            if (this.intSet[i] || iSet.intSet[i])
            {
                unionSet.intSet[i] = true;
            }
        }
        return unionSet;
    }
    public IntegerSet intersection(IntegerSet iSet)
    {
        IntegerSet intersectSet = new IntegerSet();

        for (int i = 0; i < 101; i++)
        {
            if (this.intSet[i] && iSet.intSet[i])
            {
                intersectSet.intSet[i] = true;
            }
        }

        return intersectSet;
    }
    public IntegerSet insertElement(int data)
    {
        this.intSet[data] = true;
        return this;
    }
    public IntegerSet deleteElement(int data)
    {
        this.intSet[data] = false;
        return this;
    }
    public boolean isEqualTo(IntegerSet iSet)
    {
       boolean equal = false;

       for (int i = 0; i < 101; i++)
       {
           if (this.intSet[i] == iSet.intSet[i])
               equal = true;
           else
               equal = false;
       }
       return equal;
    }
    public String toString()
    {
        String stringSet = " ";

        if (this.intSet.length == 0)
            return "---";
        for (int i = 0; i < 101; i++)
        {
            if (this.intSet[i])
            {
                stringSet = stringSet.concat(String.valueOf(i));
                stringSet = stringSet.concat(" ");
            }
        }
        return stringSet;
    }

    public static void main(String[] args)
    {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.insertElement(0);
        set1.insertElement(2);
        set1.insertElement(8);
        System.out.println("After set1.insertElement(10), set1 = "
                + set1.insertElement(10));
        set1.insertElement(4);
        set1.insertElement(6);
        set1.insertElement(10);
        set1.insertElement(100);
        set1.insertElement(12);
        set1.insertElement(95);

        set2.insertElement(0);
        set2.insertElement(3);
        set2.insertElement(6);
        set2.insertElement(9);
        set2.insertElement(12);

        System.out.println("default IntegerSet is = " + (new IntegerSet()));
        System.out.println("set1 = " + set1);
        System.out.println("set2 = " + set2);
        System.out.println("set1.union(set2) = " + set1.union(set2));
        System.out.println("set1.intersection(set2) = " + set1.intersection(set2));
        System.out.println("set1.deleteElement(2) = " + set1.deleteElement(2));
        System.out.println("set1.isEqualTo(set1) = " + set1.isEqualTo(set1));
        System.out.println("set1.isEqualTo(set2) = " + set1.isEqualTo(set2));
    }
}
