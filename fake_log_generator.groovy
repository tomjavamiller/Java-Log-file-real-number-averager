// This groovy script creates fake log files
// with a real number that follows a patter but is somewhat random
// Example log file line:
//       08/10/2019 23:10 vital data for BET --> [49 145 0.156852]
//
def random = new Random()

int min = 0
int MIN_PER_DAY = 24 * 60;
def myLogNames = ["ALP":34, "BET":100, "GAM":2, "DEL":62, "EPS":33, "ZET":45]

use (groovy.time.TimeCategory) {
  def aDate = new Date()-22.days
  def toDate = aDate+8.days
  while(aDate<toDate) {
     println "today is ${aDate.format('MM/dd/yyyy')}"
     def aFile = new File("program_${aDate.format('MMddyyyy')}.log")
     aFile.withWriter { out ->

         out.write("asdf")
          mySinInday = 0;
          min=0
          while(min<MIN_PER_DAY) { 
            inDay = min/MIN_PER_DAY;
            if(inDay < 0.5)
               mySinInday = Math.sin(Math.PI*inDay)
            else
               mySinInday = 1 - (Math.cos(Math.PI*inDay))**2
          
            myLogNames.each{
                   aRandomNum = random.nextInt(99)
                   aRandomNum2 = random.nextInt(99) + it.value
                   aSimRandom = mySinInday + (aRandomNum2/1000) 
                   out.write(String.format("${aDate.format('MM/dd/yyyy')} %02d:%02d vital data for %s --> [%d %d %f]\n", 
                        (int)(min/60), min%60, it.key, aRandomNum, aRandomNum2, aSimRandom))
             }
             min += random.nextInt(20)
          }
      }

      aDate += 1.days
  }
}


