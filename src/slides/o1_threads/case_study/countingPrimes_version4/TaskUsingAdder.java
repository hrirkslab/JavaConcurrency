package slides.o1_threads.case_study.countingPrimes_version4;

import java.math.BigInteger;

import slides.o1_threads.case_study.countingPrimes_version4.util.Adder;
import slides.o1_threads.case_study.countingPrimes_version4.util.NumberBlock;

public class TaskUsingAdder implements Runnable
{
  private final NumberBlock numBlock;
  private final Adder adder;
  private int end;
  
  public TaskUsingAdder(int end, NumberBlock numBlock, Adder adder)
  {
    this.numBlock = numBlock;
    this.adder = adder;
    this.end = end;
  }

  @Override
  public void run()
  {
    int count = 0;
    
    long startTime = System.currentTimeMillis(); 
    long candiate = numBlock.getNext();
    while( candiate < this.end )
    {
      BigInteger bInt = BigInteger.valueOf(candiate);
      if( bInt.isProbablePrime(1000) )
      {
        count++;
      }
      candiate = numBlock.getNext();
    }
    
    this.adder.add(count);
    long endTime = System.currentTimeMillis(); 
    
    System.out.println(" Runtime " + (endTime - startTime) + "[ms]");
  }

}
