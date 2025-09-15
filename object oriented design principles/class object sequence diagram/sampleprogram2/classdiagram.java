+------------------------+        +---------------------+
|       Customer         |◆-------|       Product       |
+------------------------+        +---------------------+
| - name : String        |        | - name  : String    |
| - id   : String        |        | - price : double    |
| - products : List<Product>      |
+------------------------+        +---------------------+
| + addProduct(p:Product)         |
| + getProducts() : List<Product> |
+---------------------------------+

          ▲
          |  uses
          |
+------------------------+
|     BillGenerator      |
+------------------------+
| + calculateTotal(c:Customer) : double |
| + printBill(c:Customer)              |
+------------------------+
