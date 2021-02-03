
package Assignment_6_ICS_4UI;


public class rectangle {

    private int left;
    private int bottom;
    private int width;
    private int height;

    public rectangle() {                                                //constructor
        this.left = 0;
        this.bottom = 0;
        this.width = 0;
        this.height = 0;
    }

    public rectangle(int left, int bottom, int height, int width) {     //constructor as well
        this.left = left;
        this.bottom = bottom;
        this.height = height;
        this.width = width;
    }

    public String toString(){                   // Returns the values of the rectangle
         return "base: "+" ("+this.left+","+this.bottom+") " + "w:"+this.width+ " h:"+this.height;      
         // I assume you will run the program with     System.out.println(<rectangle name>.toString());
    }

    public int area(){                          // Finds the area of rectangle
        return this.height*this.width;  
    }

    public int perimeter(){                     // Finds the perimeter of rectangle
        return 2*this.height + 2*this.width;
    }



    public boolean contains(rectangle b){       // Checks if two rectangles overlap
        
        if ((b.bottom >= this.bottom) && ((b.height+b.bottom) <= (this.bottom+this.height)) && (b.left >= this.left) && ((b.left+b.width) <= (this.left+this.width)) ){
            return true;
        }
        else{
            return false;
        }
    }

    public static rectangle intersection (rectangle a, rectangle b){        // Finds the rectangle made by two overlapping
        if (((a.bottom+a.height) < b.bottom) || (a.bottom > (b.bottom+b.height))){
            return new rectangle();
        }

        else if (((a.left+a.width) < b.left) || (a.left > (b.left+b.width))){
            return new rectangle();
        }


        else if ((a.width == b.width) & (a.height == b.width) & (a.left == b.left) & (a.bottom == b.bottom)){
            return a;
        }
        
        else {
            int NewLeft = Math.max(a.left, b.left);                 
            int NewBottom = Math.max(a.bottom, b.bottom);
            int NewTopRight = Math.min((a.left+a.width),(b.left+b.width));
            int NewTop = Math.min((a.bottom+a.height),(b.bottom+b.height));

            return new rectangle(NewLeft,NewBottom,(NewTopRight-NewLeft),(NewTop-NewBottom));
        }
    }
 


    public static int totalPerimeter(rectangle a, rectangle b){     // Finds the total perimeter of the rectangles overlapping or not

        if ((a.width == b.width) & (a.height == b.width) & (a.left == b.left) & (a.bottom == b.bottom)){
            return a.perimeter();
        }

        else if (a.contains(b) == true){
            return a.perimeter();
        }

        else if (b.contains(a)==true){
            return b.perimeter();
        }

        else{
            rectangle c;        // Finds the intersection rectangle and just subtracts it from the total to find the real total perimeter
            c = intersection(a, b);
            int all = a.perimeter() + b.perimeter();
            return all - c.perimeter();
        }
    }


    public static void main(String[] args){              //I just did this for testing purposes
        rectangle rec = new rectangle(3,3,4,5);
        rectangle b = new rectangle(3,-20,4,25);

        // System.out.println(rec.toString());

        // System.out.println(rec.area());

        // System.out.println(rec.perimeter());

        // System.out.println(rec.contains(b));

        // System.out.println(intersection(rec,b));

        System.out.println(totalPerimeter(rec,b));

    }

    

    

}
