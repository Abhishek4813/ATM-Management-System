# ATM-Management-System
Spring boot backend System for ATM Services

## Technologies
SpringBoot,   Spring Data JPA ,  JWT,   H2 Database

Application Port: 8081

## EndPoints With Dumps

### POST: /authenticate

### Request Data

{ "pin":1111 }
### Response 
JTW Token which you need to pass in order to access our services.


### POST: /withdraw

###Request Data

{
    "userId":1001,
    "accountNumber":100000001,
    "amount":100000
}

### GET: /transaction/{id}

Test With: /transaction/1001

### GET: /history/{id}

Test With: /transaction/1001

### For more dumps refer data.sql under resources folder.

