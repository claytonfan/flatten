#
# Flatten Nested Array
#
class flatten:
    # Public:      flattenArray()
    # Description:
    #   Flatten an array of arbitrarily nested arrays of integers into
    #   a flat array of integers.
    # Input:
    #   inArray     -- a nested array
    # Output:
    #   Returns flattened array
    #
    def flattenArray( inArray ):
        if inArray == None or len(inArray) == 0:
            print( "WARNING: Nested array is null or empty." )
            return None
        outArray = []
        for element in inArray:
           if isinstance( element, list ):
               #
               # Item is a list. Continue to flatten.
               #
               outArray.extend( flatten.flattenArray( element ) )
           elif isinstance( element, int ):
               #
               # Item is an integer. Append to flat array.
               #
               outArray.append( element )
           else:
               raise ValueError( "ERROR: Input is not a nested array of integers." )
        return outArray
#
# *** Program Entry ***
#
nestedArray = [[1,2,[3]],4]
print( "Nested    Array: ", nestedArray )
flatArray = flatten.flattenArray( nestedArray )
if( flatArray != None ):
    print( "Flattened array: ", flatArray )
