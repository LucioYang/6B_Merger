/**
  Represent a merge operation for sorted lists,
  as described in README.md
*/
import java.util.ArrayList;

public class Merger {

  ArrayList<String> usersData;

  /**
    Construct an instance from a list of data
    part of which is to be merged. See README
  */
  public Merger( ArrayList<String> list) {
    usersData = list;
  }

  /**
    Merge the sorted sub-lists.
  */
  public void merge(
  // indexes of sub-list boundaries; see README
    int start0  // index of first item in list0
  , int start1  // index of first item in list1
  , int nItems  // number of items in the merged list
                // = just past end of list1
  ) {
    ArrayList<String> sortedArray = new ArrayList<String>();
    for(int index = 0; index < usersData.size(); index++){
      sortedArray.add(usersData.get(index));
    }
    int endOfList0 = start1;
    int currentIndex = start0;
    while (start0 < endOfList0) {
      while (start1 < nItems){
        if (start0 < endOfList0){
          if (usersData.get(start0).compareTo(usersData.get(start1)) <= 0) {
            sortedArray.set(currentIndex,usersData.get(start0));
            currentIndex++;
            start0++;
          }
          else {
            sortedArray.set(currentIndex,usersData.get(start1));
            currentIndex++;
            start1++;
          }
        }
        sortedArray.set(currentIndex,usersData.get(start1));
        currentIndex++;
        start1++;
      }
    }
    usersData = sortedArray;
  }

  /**
    @return a string representation of the user's data
  */
  public String toString() {
    return "" + usersData;
  }

  /**
    @return the boolean value of the statement
    "the data in the range are in ascending order"
  */
  public boolean isSorted( int startAt, int endBefore) {
    for( int i = startAt
       ; i < endBefore -1
       ; i++
       )
    if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
    return true;
  }
}
