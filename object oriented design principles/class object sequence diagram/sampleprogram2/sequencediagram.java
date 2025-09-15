Customer           BillGenerator
   |                     |
   | checkout()          |
   |-------------------->|   // Customer asks for total
   |                     |
   |   calculateTotal(customer)
   |<--------------------|   // Total amount returned
   | displayBill(total)   |
   |-------------------->|
   |                     |
