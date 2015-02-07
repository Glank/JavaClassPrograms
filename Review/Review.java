/*
This is a review of everything we've learned.
By the way, this is a block comment, nothing in
this little section get's executed because of the
slashes and stars
*/ 
public class Review{
    public static void main(String[] args){
        /*
        This is the main method. Everthing within the curlly
        braces get's run when the program starts.
        */
        System.out.println("Hello");
        /*
        That was a print statement - it' prints "Hello" on
        a line in the terminal.
        */

        //##### Variables #####//
        int a;
        /*
        That line This line creates a variable. A variable
        is a place where you can store information. This is
        an 'int' variable so it can hold integers (numbers
        without decimal points).
        */
        a = 10;
        System.out.println("a: "+a);
        /*
        We just stored 10 to the variable. Then we printed
        out the contents of the variable; 10.
        */
        a = a + 1;
        /*
        This line stores a new value to a; the old value plus 1.
        So after this line executes, a = 11.
        */
        System.out.println("a: "+a);
        /*
        This should print 11.
        Let's go over the different types of variables:
        */
        double b = 3.5;
        System.out.println("b: "+b);
        //'double' variables can store decimal numbers.
        char c = '?';
        System.out.println("c: "+c);
        //'char' variables can store single characters.
        boolean d = true;
        System.out.println("d: "+d);
        //'boolean' variables can only store 'true' or 'false'.
        String e = "Ernest";
        System.out.println("e: "+e);
        /*
        'String' variables are actually objects, but we'll get to
        that later. Strings can store text, like a name.
        */

        //##### LOOPS #####//
        /*
        Loops do something multiple times. There are several
        different types of loops.
        */
        int count = 1;
        while(count < 4){
            System.out.println("count: "+count);
            count++; //This is the same as "count = count+1;"
        }
        /*
        The above example prints out the numbers 1 through 3.
        Let's step through what happens:
            1)  The program sees that it needs to create a variable 'count'
                and store 1 in that variable.
            2)  The program sees the begining of the loop and asks "is count < 4".
                Since count is less than 4, it continues with the loop.
            3)  It prints out the current value of 'count' (1).
            4)  It 'increments' count (adds 1 to the value stored in the variable).
                Count becomes 2.
            5)  The program gets the the end of the loop, so it asks again:
                "is count < 4". Count is 2, 2 is less than 4, so the loop
                continues.
            6)  It prints out the current value of 'count' (2).
            7)  It increments count. Count becomes 3.
            8)  The program gets the the end of the loop, so it asks again:
                "is count < 4". Count is 3, 3 is less than 4, so the loop
                continues.
            9)  It prints out the current value of 'count' (3).
            10) It increments count. Count becomes 4.
            11) The program gets the the end of the loop, so it asks again:
                "is count < 4". Count is 4, 4 is not less than 4, so the loop
                ends. The program continues executing whatever is after the
                loop.
        Let's look at another type of loop:
        */
        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum = sum+i;
        }
        System.out.println("sum: "+sum);
        /*
        This is a 'for' loop. For loops are simply shorter ways of writing
        common loop structures. It is almost identical to writing:
        int i = 0;
        while(i < 10){
            sum = sum+i;
            i++;
        }
        Except that the variable 'i' gets deleted after you write a for loop.
        This particular loop sums the numbers 0 through 9:
            sum = 0+1+2+3+4+5+6+7+8+9
        */
    }
}
