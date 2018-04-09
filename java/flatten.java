import java.util.*;

public class flatten {
  public static class Flatten {
    // Public:      flattenArray()
    // Description:
    //   Flatten an array of arbitrarily nested arrays of integers into
    //   a flat array of integers.
    // Input:
    //   inArray     Object[] -- a nested array
    // Output:
    //   Returns flattened array
    //
    public static ArrayList<Integer> flattenArray( Object[] inArray ) {
      
      if( inArray == null ) {
        System.out.println( "WARNING: Nested array is null." );
        return null;
      }
   
      ArrayList<Integer> outArray = new ArrayList<Integer>();
      
      for( Object item : inArray ) {
        if( item instanceof Integer ) {
          //
          // Item is integer -- add to flat array
          //
          outArray.add( (Integer) item );
        }
        else if( item instanceof Object[] ) {
          //
          // Item is partially nested array -- continue to flatten
          //
          outArray.addAll( ( flattenArray( (Object[]) item ) ) );
        }
        else {
          throw new IllegalArgumentException(
                         "ERROR: Input is not a nested array of integers." );
        }
      }
      return outArray;
    }  
  }
  //
  // *** Program Entry ***
  //
  public static void main( String[] args ) {
    // Nexted array: [[1, 2, [3]], 4]
    Object[] nestedArray = new Object[] {
                             new Object[] {
                                1, 2 ,
                                new Object[] {3}
                             },
                             4
                           };
    //
    System.out.println( "Nested    Array: " + Arrays.deepToString(nestedArray) );
    ArrayList<Integer> flatArray = Flatten.flattenArray( nestedArray );
    if( flatArray != null ) {
      System.out.println( "Flattened Array: "+ flatArray );
    }
  }
}