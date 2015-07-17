package main

import (
    "complex"
    "fmt"
    "math"
)

type HalfComp interface {
    GetReal() float64
}

func main() {
    var sqrtHalf = math.Sqrt(0.5)
    var a, b, c complex.Complex
    var ah HalfComp

    ah = complex.CreateRect(1, 1)
    fmt.Println(ah)

    a = complex.CreateRect(sqrtHalf, sqrtHalf)
    printIt(a)
    b = complex.CreatePolar(1, -math.Pi/4)
    printIt(b)
    c = complex.Add(a, b)
    printIt(c)
}

func printIt(c complex.Complex) {
    fmt.Println("----------");
    fmt.Println("complex:", c.ToString());
    fmt.Printf("real: %f, image: %f\n", c.GetReal(), c.GetImage());
    fmt.Printf("abs: %f, arg: %f\n", c.GetAbs(), c.GetArg());
}