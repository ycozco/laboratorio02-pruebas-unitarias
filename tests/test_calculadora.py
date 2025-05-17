import sys
import os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../src')))
from calculadora import suma, resta, multiplicacion, division
import pytest

def test_suma():
    assert suma(2, 3) == 5
    assert suma(-1, 1) == 0

def test_resta():
    assert resta(5, 3) == 2
    assert resta(0, 4) == -4

def test_multiplicacion():
    assert multiplicacion(2, 3) == 6
    assert multiplicacion(-1, 5) == -5

def test_division():
    assert division(10, 2) == 5
    assert division(9, 3) == 3
    with pytest.raises(ValueError):
        division(5, 0)
