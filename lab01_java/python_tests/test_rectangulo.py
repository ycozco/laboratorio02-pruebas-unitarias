import unittest

class Rectangulo:
    @staticmethod
    def area(base, altura):
        return base * altura

class TestRectangulo(unittest.TestCase):
    def test_area(self):
        self.assertEqual(Rectangulo.area(5, 3), 15)
        self.assertEqual(Rectangulo.area(0, 10), 0)
        self.assertEqual(Rectangulo.area(2.5, 4), 10)

if __name__ == '__main__':
    unittest.main()
