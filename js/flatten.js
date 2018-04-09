//
// Flatten an array
//
var nestedArray = [[1,2,[3]],4];
// Function:   flatten()
// Description:
//   Flatten an array of arbitrarily nested arrays of integers into
//   a flat array of integers.
// Input:
//   inArray     -- A nested array
// Output:
//   Returns flattened array
//
function flatten( inArray ) {
  var outArray = [];
  
  if( !inArray || !inArray.length ){   
    return null;
  }
  for( var i = 0; i < inArray.length; i++ ) {
    if( Array.isArray( inArray[i] ) ) {
	  //
	  // Element of input array is an array.
	  // Continue to flatten.
	  //
      var flatArray = flatten( inArray[i] );
      flatArray.forEach(
	    // Insert each element to flat array
        function( value ) {
          outArray.push( value );
		}
      )
    }
	else if( Number.isInteger( inArray[i] ) ) {
	  //
	  // Element of array is an integer.
	  // Add to flat array.
	  //
      outArray.push( inArray[i] );
    }
	else {
	  throw "Error: Input is not a nested array of integers.";
	}
  }
  return outArray;
}

flattenedArray = flatten( nestedArray );
// Note; only 2 dimensions are being logged
console.log( "Nested    array - ", nestedArray );
if( flattenedArray ) {
  console.log( "Flattened array - ", flattenedArray );
}
else {
  console.log( "Input array is empty or null." );	
}
alert( "Open console for result" );
