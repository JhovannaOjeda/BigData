<div align="center">

**Instituto Tecnológico de Tijuana**

Departamento de Ciencias y Computación

Ingeniería en Sistemas Computacionales

 [![](https://upload.wikimedia.org/wikipedia/commons/2/2e/ITT.jpg)](https://upload.wikimedia.org/wikipedia/commons/2/2e/ITT.jpg)

**Title:**
Practice 1

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
Tijuana, Baja California, March 13, 2020. 
</div>


## Practice 3: Fibonacci Algorithms

**1.- Downstream Recursive Version**

Declaring the variable n (this will be used on the algorithms 1, 3 and 5; it can be changed to probe the Fibonacci):
```scala
var n: Int = 7
```

Fibonacci Version 1:
```scala
def fib1(n:Int): Int = {
  if(n<2){
    return n
    }else{
      return fib1(n-1) + fib1(n-2)
    }
  }
```

Because it's a function, we need to call it and pass it the variable (this will be happening on the odd algorithms; same for the return):
```scala
fib1(number)
```
Returns: **Int = 13**

**2.- Explicit Formula Version**

```scala
def Fibonacci2(n:Double): Double = 
	var p: Double = ((1 + scala.math.sqrt(5)) / 2)
	var j: Double = ((scala.math.pow(p, n) - scala.math.pow((1 - p), n)) / scala.math.sqrt(5))
	if(n < 2)
	{
		n
	}
	else
	{
		j
	}
}
```


**3.- Iterative Version**

Fibonacci Version 3:
```scala
def fib3(n:Int): Int = {
  var a = 0
  var b = 1
  for(k <- 0 to n-1){
    var c = b + a
    a = b
    b = c
  }
return a
}
```

**4.- Iterative Version: 2 variables**

```scala
def Fibonacci4(n:Int) : Int = {
	var a = 0
	var b = 1
	var k = 0

	while(k < n)
	{
		b = b + a
		a = b - a

		k = k + 1 
	}
	return a
}
```

**5.- Iterative Version: Vector**

Fibonacci Version 5:
```scala
def fib5(n:Int): Int = {
  if(n<2) {
    return n
    } else {
      var vec = new Array[Int](n+1)
      vec(1) = 1
      for(k <- 2 to n){
        var aux = vec(k-1) + vec(k-2)
        vec(k) = aux
      }
      return vec(n)
    }
  }
```

**6.- Divide and Overcome Version**
