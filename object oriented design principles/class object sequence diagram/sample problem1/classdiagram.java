+-------------------+           +------------------+
|     Student       |<>---------|     Subject      |
+-------------------+           +------------------+
| - name : String   |           | - name : String  |
| - id   : String   |           | - marks : double |
| - subjects : List<Subject>    |
+-------------------+           +------------------+
| + addSubject(s:Subject)       |
| + getSubjects() : List<Subject>|
+--------------------------------+

          ▲
          |  uses
          |
+----------------------+
|   GradeCalculator    |
+----------------------+
| + calculateGrade(s:Student) : String |
| + calculateAverage(s:Student) : double|
+----------------------+
