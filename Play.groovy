def arr = [1, 2, 3, 4, 5, 6]
def str = "Hello World"

//closure
def pec = { e -> println e }

arr.each pec
str.each pec


//arr.size = 20

println arr.collect {it * 2}.findAll {it >= 10}.collect()
