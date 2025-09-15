Student          GradeCalculator
   |                     |
   | requestGrade()      |
   |-------------------->|  // Student asks for grade
   |                     |
   |   calculateGrade(student) 
   |<--------------------|  // GradeCalculator computes
   |   return grade (e.g., "A")
   |                     |
   | displayGrade("A")   |
   |-------------------->|
   |                     |
