package complex

import (
    "fmt"
    "math"
)

type Complex interface {
    GetReal() float64
    GetImage() float64
    GetAbs() float64
    GetArg() float64
    ToString() string
}

func Add(a Complex, b Complex) Complex {
    return CreateRect(a.GetReal() + b.GetReal(), 
        a.GetImage() + b.GetImage())
}

type ComplexRect struct {
    real, image float64
}

func CreateRect(r float64, i float64) ComplexRect {
    return ComplexRect{r, i}
}

func (c ComplexRect) GetReal() float64 {
    return c.real
}

func (c ComplexRect) GetImage() float64 {
    return c.image
}

func (c ComplexRect) GetAbs() float64 {
    return math.Sqrt(c.real * c.real + c.image * c.image)
}

func (c ComplexRect) GetArg() float64 {
    return math.Atan(c.image / c.real)
}

func (c ComplexRect) ToString() string {
    var sgn = "+"
    if (c.image < 0) {
        sgn = ""
    }
    return fmt.Sprintf("%f%s%fi", c.real, sgn, c.image)
}

type ComplexPolar struct {
    abs, arg float64
}

func CreatePolar(r float64, a float64) ComplexPolar {
    return ComplexPolar{r, a}
}

func (c ComplexPolar) GetReal() float64 {
    return c.abs * math.Cos(c.arg)
}

func (c ComplexPolar) GetImage() float64 {
    return c.abs * math.Sin(c.arg)
}

func (c ComplexPolar) GetAbs() float64 {
    return c.abs
}

func (c ComplexPolar) GetArg() float64 {
    return c.arg
}

func (c ComplexPolar) ToString() string {
    return fmt.Sprintf("%f*exp(%fi)", c.abs, c.arg)
}