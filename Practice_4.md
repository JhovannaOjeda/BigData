<div align="center">

**Instituto Tecnológico de Tijuana**

Departamento de Ciencias y Computación

Ingeniería en Sistemas Computacionales

 ![](https://www.tijuana.tecnm.mx/wp-content/themes/tecnm/images/logo_TECT.png)

**Title:**
Practice 4

**Subject:**
BDD-1704 S DATOS MASIVOS

**Unit:**
 I

**Professor:**
JOSE CHRISTIAN ROMERO HERNANDEZ

**Student:**

Jhovanna Andrea Ojeda Sanchez
15211334

Garcia Rincon Daniel Gerardo
16212002



**Date:**
Tijuana, Baja California, March 10, 2020. 
</div>



## Pratice 3 Analyze the Following Code

### First code block

This code creates a function that reads a list of ints and what the function will do is to be able to read the int and tell if the numbers are odd or even.

```scala
def listEvens(list:List[Int]): String ={
    for(n <- list){
        if(n%2==0){
            println(s"$n is even")
        }else{
            println(s"$n is odd")
        }
    }
    return "Done"
}
```

Here is declaration of two lists that contains random numbers.

```scala
val l = List(1,2,3,4,5,6,7,8)
val l2 = List(4,3,22,55,7,8)
```

Here is the function application to the lists named "l" and "l2".

```scala
listEvens(l)
listEvens(l2)
```


### Second code block

In this block at the beginning a function called lucky is declared and a list of int is used that will analyze the numbers if there is a 7 the value will be "res" and 14 points will be added.
If the number is not 7 then the value "res" will be added to the number found and this will be repeated until there is no number to analyze.
```scala
def afortunado(list:List[Int]): Int={
    var res=0
    for(n <- list){
        if(n==7){
            res = res + 14
        }else{
            res = res + n
        }
    }
    return res
}

```
Here is a declaration of a list of three numbers.

```scala
val af= List(1,7,7)
```

Here is the application of the function to the list named "af"

```scala
println(afortunado(af))
```
### Third code block

The following code block declares a function named "balance". This function will analyze a lists to see if the list is "balanced" between their values. First there is a declaration of two variables named "primera" and "segunda", these variables are for calculating if there is a balance between the values of the list. "Segunda" is equal to the sum of all the values in the list. The for cycle will start from 0 to the length of the list.

to confirm the balance, the "segunda" list is decremented equal to each of the values in the list and the "primera" variable increases according to each value in the list

"primera" is equal to the value of "primera" plus the value of the first variable in the list.

"segunda" is equal to the value of "segunda" minus the value of the first variable in the list.

If the value of "primera" is equal to "segunda" the function will return TRUE, otherwise the function will return FALSE

```scala
def balance(list:List[Int]): Boolean={
    var primera = 0
    var segunda = 0

    segunda = list.sum

    for(i <- Range(0,list.length)){
        primera = primera + list(i)
        segunda = segunda - list(i)

        if(primera == segunda){
            return true
        }
    }
    return false 
}
```

Here is the declaration of three different lists

```scala
val bl = List(3,2,1)
val bl2 = List(2,3,3,2)
val bl3 = List(10,30,90)
```

Here is the application of the function to the lists "bl", "bl2" and "bl3"

```scala
balance(bl)
balance(bl2)
balance(bl3)
```


### Fourth code block

This code defines a function that needs to be declared with a word charged to the method. The function return the same word but in reverse, this will allow us to see if its a palindrome.

```scala
def palindromo(palabra:String):Boolean ={
    return (palabra == palabra.reverse)
}
```

Here is the declaration of three variables that are palindromes

```scala
val palabra = "OSO"
val palabra2 = "ANNA"
val palabra3 = "JUAN"
```

Here is the print of the function applied to the variables "palabra", "palabra2" and "palabra3", it will return the three words but in reverse. We can see that the words are written in the same way, that is because they palindromes.

```scala
println(palindromo(palabra))
println(palindromo(palabra2))
println(palindromo(palabra3))
